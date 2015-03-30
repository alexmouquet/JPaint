package com.drawing;

import com.shape.Ellipse;
import java.awt.Shape;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DrawingSerializer {

    Drawing drawing;

    public DrawingSerializer(Drawing drawing) {
        //this.drawing = drawing;
    }

    public static void save(Drawing drawing) {
        // Point point = new Point(8.3,-2.1);
        // Circle circle = new Circle(12.5,point);
        Iterator it;

        it = drawing.iterator();

        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("objet.ser"));
            while (it.hasNext()) {
                Object o = it.next();
                Shape shape = (Shape) o;

                objectOutputStream.writeObject(shape);

            }
            //   objectOutputStream.flush();
            //   objectOutputStream.reset();
        } catch (IOException ioException) {
        }
        
        List<Shape> LoadedObjects = new LinkedList<Shape>();
        
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("objet.ser"));
            while (it.hasNext()) {
                LoadedObjects.add((Ellipse) objectInputStream.readObject());
            }
        } catch (IOException ioException) {
        } catch (ClassNotFoundException classNotFoundException) {
        }
    }
}
