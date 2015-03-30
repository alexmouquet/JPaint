package com.mycompany.vectoriel1_controleur;

import com.drawing.Drawing;
import com.drawing.DrawingView;
import com.toolbox.Menu;
import com.toolbox.ToolBox;
import java.awt.BorderLayout;
import javax.swing.JFrame;

public class Window extends JFrame {

    private static final int FRAME_WIDTH = 1200;
    private static final int FRAME_HEIGHT = 1000;
    private static final String TITLE = "Vectoriel 1 ";

    public Window() {
        super(TITLE);

        // Le modèle
        Drawing drawing = new Drawing();

        // La vue
        DrawingView drawingView = new DrawingView(drawing);

        // Le menu
        Menu menu = new Menu(drawing);
        this.setJMenuBar(menu);

        // La barre de boutons
        ToolBox actionButton = new ToolBox(drawing, drawingView);
        this.add(actionButton.boutons, BorderLayout.NORTH);

        // La fenêtre
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.add(drawingView);
        this.setVisible(true);
    }
}
