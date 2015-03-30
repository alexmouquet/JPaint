package com.toolbox;

import com.listener.BorderColorListener;
import com.listener.CircleListener;
import com.listener.MoveListener;
import com.listener.RectangleListener;
import com.listener.ShapeFillingListener;
import com.drawing.Drawing;
import com.drawing.DrawingView;
import java.awt.Color;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class ToolBox extends JPanel {

    public JPanel boutons;

    public ToolBox(Drawing drawing, DrawingView drawingView) {
        boutons = new JPanel();
        ButtonGroup buttonGroup = new ButtonGroup();

        // Outils de dessin
        JToggleButton circleButton = new JToggleButton("Tracer un cercle");
        JToggleButton rectangleButton = new JToggleButton("Tracer un rectangle");

        // Outils de manipulation de formes
        JToggleButton shapeSelectionButton = new JToggleButton("Sélection");    // todo: renommer MoveControleur et MoveListener
        JToggleButton shapeFillingButton = new JToggleButton("Remplissage");

        // Outils de choix de couleurs
        JButton borderColorButton = new JButton("Couleur de bordure");
        FillingColorButton fillingColorButton = new FillingColorButton();

        // On ajoute les listeners aux boutons
        circleButton.addActionListener(new CircleListener(drawing, drawingView));
        rectangleButton.addActionListener(new RectangleListener(drawing, drawingView));
        shapeSelectionButton.addActionListener(new MoveListener(drawing, drawingView));
        shapeFillingButton.addActionListener(new ShapeFillingListener(drawing, drawingView));
        borderColorButton.addActionListener(new BorderColorListener(drawing, drawingView));

        // On ajoute les formes à notre toolbox
        boutons.add(circleButton);
        boutons.add(rectangleButton);
        boutons.add(shapeSelectionButton);
        boutons.add(shapeFillingButton);
        boutons.add(fillingColorButton.colorPreview);
        boutons.add(borderColorButton);

        // On regroupe les boutons qui doivent rester "enfoncés" lorsqu'on les sélectionne
        buttonGroup.add(circleButton);
        buttonGroup.add(rectangleButton);
        buttonGroup.add(shapeFillingButton);
        buttonGroup.add(shapeSelectionButton);

        // On ajoute une couleur de fond
        boutons.setBackground(Color.GRAY);
    }
}
