package com.shape;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.RectangularShape;

public abstract class OurShape extends RectangularShape {

    public Color fillingColor = null;
    public Color borderColor = null;
    protected float strokeSize = 2;

    public abstract void draw(Graphics2D g2D);

    public abstract boolean contains(double x, double y, double w, double h);
}
