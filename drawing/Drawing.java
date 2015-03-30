package com.drawing;

import com.listener.DrawingListener;
import com.shape.GroupModel;
import com.shape.OurShape;
import java.awt.Shape;
import java.util.LinkedList;
import java.util.List;

public class Drawing extends LinkedList<Shape> {

    private List<DrawingListener> listeners = new LinkedList<DrawingListener>();
    public GroupModel groupe = new GroupModel(new LinkedList<OurShape>());

    @Override
    public boolean add(Shape shape) {
        boolean r = super.add(shape);

        // Le modèle est modifié : on notifie les vues
        fireDrawingEvent();

        return r;
    }

    public void reDraw() {
        fireDrawingEvent();
    }

    public void addListener(DrawingListener listener) {
        listeners.add(listener);
    }

    public void removeListener(DrawingListener listener) {
        listeners.remove(listener);
    }

    private void fireDrawingEvent() {
        for (DrawingListener listener : listeners) {
            System.out.println(listener.getClass().getName());
            DrawingEvent event = new DrawingEvent(this);
            listener.drawingChanged(event);
        }
    }
}
