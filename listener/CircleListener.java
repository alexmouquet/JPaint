package com.listener;

import com.controller.CircleController;
import com.controller.DrawingController;
import com.drawing.Drawing;
import com.drawing.DrawingView;
import com.model.edition.ModelDEdition;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

public class CircleListener implements ActionListener {

    private Drawing drawing;
    private DrawingView drawingView;

    public CircleListener(Drawing drawing, DrawingView drawingView) {
        this.drawing = drawing;
        this.drawingView = drawingView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // si il y a une instance de CirecleController alors on lance le contrôleur avec "run"
        // sinon on l'instancie
        // et on ferme les autres contrôleurs
        Iterator it = ModelDEdition.controleur.iterator();
        while (it != null && it.hasNext()) {
            Object o = it.next();

            DrawingController drawingController = (DrawingController) o;
            if (o != null) {
                drawingController.setRun(false);
            }
        }

        if (CircleController.getInstance() != null) {
            CircleController.getInstance().setRun(true);
        } else {
            CircleController.setInstance(drawing, drawingView);
        }
    }
}
