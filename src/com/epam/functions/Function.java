package com.epam.functions;

import java.util.TreeSet;

/**
 * Created by Asus on 19.05.2016.
 */
public abstract class Function implements Cloneable {

    protected TreeSet<Point> points = new TreeSet<>();

    public abstract double[] solve();
    public abstract double findYbyX(double x);
    public abstract double[] findXbyY(double y);

    public void drawGraph(double from, double to, double step) {
        if (from >= to) {
            throw new IllegalArgumentException("Lower index should be less than upper!");
        }
        if (step == 0.) {
            throw new IllegalArgumentException("Step should be bigger than 0!");
        }

        for (double i = from; i < to; i += step) {
            points.add(new Point(i, findYbyX(i)));
        }
    }

    public TreeSet<Point> getPoints() {
        return points;
    }
}