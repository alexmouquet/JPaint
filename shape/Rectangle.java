package com.shape;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;

public class Rectangle extends OurShape implements Serializable {

    protected Rectangle2D.Float r;

    public Rectangle(float x, float y, float w, float h, Color borderColor, Color fillingColor, float strokeSize) {
        this.r = new Rectangle2D.Float(x, y, w, h);
        
        super.borderColor = borderColor;
        super.fillingColor = fillingColor;
        
        if (strokeSize <= 0) {
            throw new IllegalStateException("invalid Stroke : " + strokeSize);
        } else {
            super.strokeSize = strokeSize;
        }
    }

    public Rectangle() {
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
        return this.r.getX();
    }

    @Override
    public double getY() {
        return this.r.getY();
    }

    @Override
    public double getWidth() {
        return this.r.getWidth();
    }

    @Override
    public double getHeight() {
        return this.r.getHeight();
    }

    @Override
    public boolean isEmpty() {
        return this.r.isEmpty();
    }

    @Override
    public void setFrame(double x, double y, double w, double h) {
        this.r.setFrame(x, y, w, h);
    }

    public Rectangle2D getBounds2D() {
        return this.r.getBounds2D();
    }

    public boolean contains(double x, double y) {
        return this.r.contains(x, y);
    }

    public boolean intersects(double x, double y, double w, double h) {
        return this.r.intersects(x, y, w, h);
    }

    @Override
    public boolean contains(double x, double y, double w, double h) {
        return this.r.contains(x, y, w, h);
    }

    public PathIterator getPathIterator(AffineTransform at) {
        return this.r.getPathIterator(at);
    }

    @Override
    public void draw(Graphics2D g2D) {
        g2D.setPaint(fillingColor);
        g2D.fill(this.r);
        
        g2D.setStroke(new BasicStroke(strokeSize));
        g2D.setPaint(borderColor);
        g2D.draw(this.r);
    }
}
