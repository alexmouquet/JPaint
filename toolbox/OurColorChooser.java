package com.toolbox;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.ChangeListener;

public class OurColorChooser extends JFrame implements ActionListener {

    private static final int FRAME_WIDTH = 700;
    private static final int FRAME_HEIGHT = 400;
    private static final int COLOR_CHOOSER_HEIGHT = 300;

    private JColorChooser chooser;
    private JPanel bottom;
    private JButton confirm;
    private JButton cancel;
    private Color previousColor;

    public OurColorChooser(Color defaultColor, ChangeListener changeListener) {
        super("Select color");

        setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        setLayout(new BorderLayout());
        pack();

        chooser = new JColorChooser(defaultColor);
        chooser.setPreferredSize(new Dimension(FRAME_WIDTH, COLOR_CHOOSER_HEIGHT));
        chooser.getSelectionModel().addChangeListener(changeListener);

        confirm = new JButton("OK");
        confirm.addActionListener(this);

        cancel = new JButton("Cancel");
        cancel.addActionListener(this);

        bottom = new JPanel();
        bottom.add(confirm);
        bottom.add(cancel);

        add(chooser, BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);
    }

    public void setColor(Color rgb) {
        chooser.setColor(rgb);
    }

    public Color getColor() {
        return chooser.getColor();
    }

    public void display() {
        setVisible(true);
        previousColor = getColor();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == confirm) {
            setVisible(false);
        } else if (source == cancel) {
            setColor(previousColor);
            setVisible(false);
        }
    }
}
