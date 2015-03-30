package com.shape;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;

public class GroupModel extends OurShape {

    private List<OurShape> listOfGroupedShape;

    public GroupModel(List<OurShape> listOfShape) {
        this.listOfGroupedShape = listOfShape;
    }

    public List<OurShape> getListOfShape() {
        return listOfGroupedShape;
    }

    public void clearListOfShape() {
        if (listOfGroupedShape != null) {
            listOfGroupedShape.clear();
        }
    }

    public boolean isListOfGroupedShapeEmpty() {
        if (listOfGroupedShape == null) {
            return true;
        }
        return false;
    }

    public void addShape(OurShape shape) {
        listOfGroupedShape.add(shape);
    }

    public void setListOfShape(List<OurShape> listOfShape) {
        this.listOfGroupedShape = listOfShape;
    }

    @Override
    public void draw(Graphics2D g2D) {
        Iterator it = this.listOfGroupedShape.iterator();
        while (it.hasNext()) {
            Object o = it.next();
            OurShape shape = (OurShape) o;
            shape.draw(g2D);
        }
    }

    @Override
    public boolean contains(double x, double y, double w, double h) {
        Iterator it = this.listOfGroupedShape.iterator();
        while (it.hasNext()) {
            Object o = it.next();
            OurShape shape = (OurShape) o;

            if (shape.contains(x, y, w, h) == false) {
                return false;
            }
        }
        return true;
    }

    @Override
    public double getX() {
        SortedSet<Double> xTab = (SortedSet<Double>) new ArrayList<Double>();
        Iterator it = this.listOfGroupedShape.iterator();
        while (it.hasNext()) {
            Object o = it.next();
            OurShape shape = (OurShape) o;
            xTab.add(shape.getX());
        }
        return xTab.first();
    }

    @Override
    public double getY() {
        SortedSet<Double> yTab = (SortedSet<Double>) new ArrayList<Double>();
        Iterator it = this.listOfGroupedShape.iterator();
        while (it.hasNext()) {
            Object o = it.next();
            OurShape shape = (OurShape) o;
            yTab.add(shape.getY());
        }
        return yTab.first();
    }

    @Override
    public double getWidth() {
        SortedSet<Double> xTab = (SortedSet<Double>) new ArrayList<Double>();
        Iterator it = this.listOfGroupedShape.iterator();
        while (it.hasNext()) {
            Object o = it.next();
            OurShape shape = (OurShape) o;
            xTab.add(shape.getX());
        }
        return (xTab.last() - xTab.first());
    }

    @Override
    public double getHeight() {
        SortedSet<Double> yTab = (SortedSet<Double>) new ArrayList<Double>();
        Iterator it = this.listOfGroupedShape.iterator();
        while (it.hasNext()) {
            Object o = it.next();
            OurShape shape = (OurShape) o;
            yTab.add(shape.getY());
        }
        return (yTab.last() - yTab.first());
    }

    @Override
    public boolean isEmpty() {
        Iterator it = this.listOfGroupedShape.iterator();
        while (it.hasNext()) {
            Object o = it.next();
            OurShape shape = (OurShape) o;
            if (!shape.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void setFrame(double x, double y, double w, double h) {

        Iterator it = this.listOfGroupedShape.iterator();
        while (it.hasNext()) {
            Object o = it.next();
            OurShape shape = (OurShape) o;
            shape.setFrame(shape.getX() + w, shape.getY() + h, w, h);
        }
    }

    public Rectangle2D getBounds2D() {
        return null;
    }

    public boolean contains(double x, double y) {
        Iterator it = this.listOfGroupedShape.iterator();
        while (it.hasNext()) {
            Object o = it.next();
            OurShape shape = (OurShape) o;
            if (shape.contains(x, y)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean intersects(double x, double y, double w, double h) {
        Iterator it = this.listOfGroupedShape.iterator();
        while (it.hasNext()) {
            Object o = it.next();
            OurShape shape = (OurShape) o;

            if (!shape.intersects(x, y, w, h)) {
                return false;
            }
        }
        return true;
    }

    public PathIterator getPathIterator(AffineTransform at) {
        return this.getPathIterator(at);
    }
}
