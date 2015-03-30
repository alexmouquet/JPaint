package com.controller;

import com.drawing.Drawing;
import com.drawing.DrawingView;
import com.model.edition.ModelDEdition;
import com.shape.Ellipse;
import java.awt.Point;
import java.awt.event.MouseEvent;

public class CircleController extends DrawingController {

    private Point previousClick = null;
    private Point currentClick = null;
    private boolean run = false;
    private static CircleController instance = null;

    private CircleController(Drawing drawing, DrawingView drawingView) {
        super(drawing, drawingView);
    }

    public static void setInstance(Drawing drawing, DrawingView drawingView) {
        if (instance == null) {
            instance = new CircleController(drawing, drawingView);
            instance.run = true;
            ModelDEdition.controleur.add(instance);
        }
    }

    public static CircleController getInstance() {
        return instance;
    }

    @Override
    public void setRun(boolean run) {
        this.run = run;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        previousClick = e.getPoint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        currentClick = e.getPoint();

        if (previousClick.x > currentClick.x) {
            int i;
            i = previousClick.x;
            previousClick.x = currentClick.x;
            currentClick.x = i;
        }
        if (previousClick.y > currentClick.y) {
            int i;
            i = previousClick.y;
            previousClick.y = currentClick.y;
            currentClick.y = i;
        }

        if (run == true) {
            // On a eu une interaction utilisateur, on modifie le modèle
            // Le modèle va ensuite notifier les vues pour qu'elles se rafraichissent
            if (super.drawing.add(new Ellipse(previousClick.x, previousClick.y,
                    currentClick.x - previousClick.x, currentClick.y - previousClick.y, ModelDEdition.currentBorderColor, ModelDEdition.currentFillingColor, 1))) {
                System.out.println("nouveau cercle");
            } else {
                System.out.println("le cercle ne marche pas :/");
            }
        }
    }
}
