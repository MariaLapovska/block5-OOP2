package com.epam.functions;

/**
 * Created by Maria on 20.05.2016.
 */
public class Point implements Cloneable, Comparable<Point> {

    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (this.getClass() != that.getClass()) {
            return false;
        }

        Point point = (Point) that;

        if (this.x != point.x) {
            return false;
        }
        if (this.y != point.y) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        final double prime = 31.;
        double result = 1.;

        result = prime * result + x;
        result = prime * result + y;

        return (int) result;
    }

    @Override
    public String toString() {
        return String.format("[ %.2f; %.2f ]", x, y);
    }

    @Override
    public Point clone() {
        try {
            return (Point) super.clone();
        } catch (CloneNotSupportedException ex) {
            return null;
        }
    }

    @Override
    public int compareTo(Point p) {
        return Double.compare(x, p.x);
    }
}
