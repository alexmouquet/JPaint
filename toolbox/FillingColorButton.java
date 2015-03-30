package com.toolbox;

import com.model.edition.ModelDEdition;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/* On peut modifier cette classe pour ajouter d'autre boutons "colorés", comme la couleur de bordure par exemple (nous avons néanmoins choisi
 * de garder le style de bouton classique pour le choix de couleur de bordure)
 */
public class FillingColorButton extends JButton implements ActionListener, ChangeListener {

    private static final Color DEFAULT_COLOR = Color.WHITE;
    private static final int COLOR_PREVIEW_WIDTH = 125;
    private static final int COLOR_PREVIEW_HEIGHT = 30;

    private Color currentColor;
    public JButton colorPreview;
    private OurColorChooser colorChooser;

    public FillingColorButton() {
        super();

        currentColor = DEFAULT_COLOR;
        colorChooser = new OurColorChooser(currentColor, this);
        colorPreview = new JButton("Fond");

        colorPreview.setPreferredSize(new Dimension(COLOR_PREVIEW_WIDTH, COLOR_PREVIEW_HEIGHT));
        colorPreview.addActionListener(this);
        colorPreview.setToolTipText("Select a filling color");
        colorPreview.setBackground(currentColor);
    }

    public Color getColor() {
        return currentColor;
    }

    public void setColor(Color color) {
        currentColor = color;
        colorPreview.setBackground(color);
        colorPreview.setOpaque(true);
    }

    public void actionPerformed(ActionEvent e) {
        colorChooser.display();
    }

    public void stateChanged(ChangeEvent e) {
        //Object source = e.getSource();

        //if (source.getClass() == DefaultColorSelectionModel.class) {
        setColor(colorChooser.getColor());
        ModelDEdition.currentFillingColor = colorChooser.getColor();
        //}
    }
}
