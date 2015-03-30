package com.controller;

import com.drawing.Drawing;
import com.drawing.DrawingView;
import com.model.edition.ModelDEdition;
import com.shape.OurShape;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.awt.geom.RectangularShape;
import java.util.Iterator;

public class MoveController extends DrawingController {

    private Point2D previousClick = null;
    private Point2D currentClick = null;
    private boolean run = false;
    private boolean onShape;
    private static MoveController instance = null;

    private MoveController(Drawing drawing, DrawingView drawingView) {
        super(drawing, drawingView);
    }

    public static void setInstance(Drawing drawing, DrawingView drawingView) {
        if (instance == null) {
            instance = new MoveController(drawing, drawingView);
            instance.run = true;
            ModelDEdition.controleur.add(instance);
        }
    }

    public static MoveController getInstance() {
        return instance;
    }

    @Override
    public void setRun(boolean run) {
        this.run = run;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        previousClick = (Point2D) e.getPoint();
        if (this.run == true) {
            Iterator it = drawing.iterator();
            boolean stop = false;
            while (it.hasNext() && stop == false) {
                Object o = it.next();
                if (o instanceof java.awt.Shape) {
                    RectangularShape shape = (RectangularShape) o;

                    if (shape.contains(previousClick)) {
                        stop = true;
                        this.onShape = true;
                    } else {
                        this.onShape = false;
                    }
                }
            }
            if (stop == false) {
                drawing.groupe.clearListOfShape();
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

        currentClick = e.getPoint();
        double xDelta = currentClick.getX() - previousClick.getX();
        double yDelta = currentClick.getY() - previousClick.getY();
        if (this.run == true) {

            Iterator it = drawing.iterator();
            boolean stop = false;
            boolean isGrouped = false;
            while (it.hasNext() && stop == false) {
                Object o = it.next();

                if (o instanceof java.awt.Shape) {
                    OurShape shape = (OurShape) o;

                    if (this.onShape == true) {
                        if (shape.contains(previousClick)) {

                            if (drawing.groupe.isListOfGroupedShapeEmpty()) {
                                moveShape(shape, xDelta, yDelta);
                                stop = true;
                            } else {
                                Iterator groupIt = drawing.groupe.getListOfShape().iterator();
                                while (groupIt.hasNext() && stop == false) {
                                    Object groupO = groupIt.next();

                                    if (shape.equals((RectangularShape) groupO)) {
                                        isGrouped = true;
                                        stop = true;
                                    }
                                }
                                Iterator groupIt2 = drawing.groupe.getListOfShape().iterator();

                                if (isGrouped == true) {
                                    while (groupIt2.hasNext()) {
                                        Object groupO = groupIt2.next();
                                        RectangularShape groupedShape = (RectangularShape) groupO;
                                        moveShape(groupedShape, xDelta, yDelta);
                                    }
                                } else {
                                    moveShape(shape, xDelta, yDelta);
                                    stop = true;
                                    drawing.groupe.clearListOfShape();
                                }
                            }
                        }
                    } else {
                        if (shape.getMinX() >= previousClick.getX() && shape.getMaxX() <= currentClick.getX() && shape.getMinY() >= previousClick.getY() && shape.getMaxY() <= currentClick.getY()) {
                            drawing.groupe.addShape(shape);
                        }
                    }
                }
            }
        }
    }

    public void moveShape(RectangularShape shape, double xDelta, double yDelta) {
        shape.setFrame(shape.getX() + xDelta, shape.getY() + yDelta, shape.getWidth(), shape.getHeight());
        drawing.reDraw();
    }
}
