package com.shape;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.PathIterator;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;

public class Ellipse extends OurShape implements Serializable {

    protected Ellipse2D.Float e;

    public Ellipse(float x, float y, float w, float h, Color borderColor, Color fillingColor, float strokeSize) {
        this.e = new Ellipse2D.Float(x, y, w, h);
        
        super.borderColor = borderColor;
        super.fillingColor = fillingColor;
        
        if (strokeSize <= 0) {
            throw new IllegalStateException("invalid Stroke : " + strokeSize);
        } else {
            super.strokeSize = strokeSize;
        }
    }

    public Ellipse() {
    }

    public Color getFillingColor() {
        return fillingColor;
    }

    public void setFillingColor(Color fillingColor) {
        this.fillingColor = fillingColor;
    }

    public Color getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }

    public float getStrokeSize() {
        return strokeSize;
    }

    public void setStrokeSize(int strokeSize) {
        this.strokeSize = strokeSize;
    }

    @Override
    public double getX() {
        return this.e.getX();
    }

    @Override
    public double getY() {
        return this.e.getY();
    }

    @Override
    public double getWidth() {
        return this.e.getWidth();
    }

    @Override
    public double getHeight() {
        return this.e.getHeight();
    }

    @Override
    public boolean isEmpty() {
        return this.e.isEmpty();
    }

    @Override
    public void setFrame(double x, double y, double w, double h) {
        this.e.setFrame(x, y, w, h);
    }

    public Rectangle2D getBounds2D() {
        return this.e.getBounds2D();
    }

    public boolean contains(double x, double y) {
        return this.e.contains(x, y);
    }

    public boolean intersects(double x, double y, double w, double h) {
        return this.e.intersects(x, y, w, h);
    }

    @Override
    public boolean contains(double x, double y, double w, double h) {
        return this.e.contains(x, y, w, h);
    }

    public PathIterator getPathIterator(AffineTransform at) {
        return this.e.getPathIterator(at);
    }

    @Override
    public void draw(Graphics2D g2D) {
        g2D.setPaint(super.fillingColor);
        g2D.fill(this.e);
        
        g2D.setStroke(new BasicStroke(super.strokeSize));
        g2D.setPaint(borderColor);
        g2D.draw(this.e);
    }

}
