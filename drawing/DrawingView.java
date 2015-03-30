package com.drawing;

import com.listener.DrawingListener;
import com.shape.OurShape;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Iterator;
import javax.swing.JPanel;

public class DrawingView extends JPanel implements DrawingListener {

    private Drawing drawing;

    public DrawingView(Drawing drawing) {
        super();

        this.drawing = drawing;

        // On s'enregistre auprès du modèle pour recevoir ses événements
        drawing.addListener(this);
    }

    @Override
    public void drawingChanged(DrawingEvent e) {
        // Le modèle nous a notifié qu'il a a été modifié
        // On redessine la vue
        repaint(); // Cela va automatiquement appeler la méthode paintComponent
    }

    @Override
    public void paintComponent(Graphics g) {
        // Dessin du fond
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g; // should be checked

        Iterator it = drawing.iterator();

        // Dessin des formes
        while (it.hasNext()) {
            Object o = it.next();
//            try {
//                Method isFill = o.getClass().getDeclaredMethod("isFill");
//                Method getBorderColor = o.getClass().getDeclaredMethod("getBorderColor");
//                Method getFillingColor = o.getClass().getDeclaredMethod("getFillingColor");
//                Method getStrokeSize = o.getClass().getDeclaredMethod("getStrokeSize");
//                Shape shape = (Shape) o;
//
//                if ("true".equals(isFill.invoke(o).toString())) {
//                    g2d.setPaint((Color) getFillingColor.invoke(o));
//                    g2d.fill(shape);
//                }
//                g2d.setStroke(new BasicStroke((Integer) getStrokeSize.invoke(o)));
//                g2d.setPaint((Color) getBorderColor.invoke(o));
//                g2d.draw(shape);
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }

            OurShape shape = (OurShape) o;
            shape.draw(g2d);

//            g2d.setPaint(Color.RED);
//            g2d.fill(shape);
//            g2d.setPaint(Color.BLACK);
//            g2d.draw(shape);
        }
    }
}
