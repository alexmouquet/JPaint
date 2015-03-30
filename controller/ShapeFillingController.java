package com.controller;

import com.drawing.Drawing;
import com.drawing.DrawingView;
import com.model.edition.ModelDEdition;
import com.shape.OurShape;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.util.Iterator;

public class ShapeFillingController extends DrawingController {

    private Point2D previousClick = null;
    private Point2D currentClick = null;
    private boolean run = false;
    private static ShapeFillingController instance = null;

    private ShapeFillingController(Drawing drawing, DrawingView drawingView) {
        super(drawing, drawingView);
    }

    public static void setInstance(Drawing drawing, DrawingView drawingView) {
        if (instance == null) {
            instance = new ShapeFillingController(drawing, drawingView);
            instance.run = true;
            ModelDEdition.controleur.add(instance);
        }
    }

    public static ShapeFillingController getInstance() {
        return instance;
    }

    @Override
    public void setRun(boolean run) {
        this.run = run;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        currentClick = (Point2D) e.getPoint();
        boolean isInside = false;

        if (run == true) {
            Iterator it = drawing.iterator();
            boolean stop = false;

            while (it.hasNext() && stop == false) {
                Object o = it.next();

                if (o instanceof java.awt.Shape) {
                    OurShape shape = (OurShape) o;

                    if (shape.contains(currentClick)) {
                        isInside = true;

                        shape.fillingColor = ModelDEdition.currentFillingColor;
                        shape.borderColor = ModelDEdition.currentBorderColor;
                        drawing.reDraw();
                    }
                }
            }
        }
    }
}
