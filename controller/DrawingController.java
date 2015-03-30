package com.controller;

import com.drawing.Drawing;
import com.drawing.DrawingView;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public abstract class DrawingController implements MouseListener {

    protected Drawing drawing;
    protected DrawingController controleur = null;

    public DrawingController(Drawing drawing, DrawingView drawingView) {
        // On renseigne le modèle au contrôleur
        this.drawing = drawing;
        // La vue s'enregistre auprès du contrôleur pour recevoir ses événements
        drawingView.addMouseListener(this);
    }

    public static void setInstance(Drawing drawing, DrawingView drawingView) {
    }

    public static DrawingController getInstance() {
        return null;
    }

    public void setRun(boolean run) {
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }
}
