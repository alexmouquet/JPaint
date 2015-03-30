package com.toolbox;

import com.drawing.Drawing;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import com.drawing.DrawingSerializer;

public class Menu extends JMenuBar {

    Drawing drawing;
    
    // Les composants du menu
    private JMenu test1 = new JMenu("Fichier");
    private JMenu test2 = new JMenu("Edition");
    private JMenuItem item1 = new JMenuItem("Sauvegarder");
    private JMenuItem item2 = new JMenuItem("Charger");
    private JMenuItem item3 = new JMenuItem("Fermer");

    public Menu(final Drawing drawing) {
        this.drawing = drawing;
        this.test1.add(item1);
        this.test1.add(item2);
        this.test1.add(item3);

        item1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DrawingSerializer.save(drawing);
            }
        });

        item3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        this.add(test1);
        this.add(test2);
        this.setVisible(true);
    }
}
