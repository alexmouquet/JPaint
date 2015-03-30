package com.listener;

import com.drawing.Drawing;
import com.drawing.DrawingView;
import com.model.edition.ModelDEdition;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JColorChooser;

public class BorderColorListener implements ActionListener {

    private Drawing drawing;
    private DrawingView drawingView;

    public BorderColorListener(Drawing drawing, DrawingView drawingView) {
        this.drawing = drawing;
        this.drawingView = drawingView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ModelDEdition.currentBorderColor = JColorChooser.showDialog(null, "Choose a color", Color.WHITE);
    }
}
