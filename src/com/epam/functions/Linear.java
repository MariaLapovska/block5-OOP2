package com.epam.functions;

import java.util.TreeSet;

/**
 * Created by Maria on 20.05.2016.
 */
public class Linear extends Function {

    private double coefficientA;
    private double coefficientB;

    public Linear(double coefficientA, double coefficientB) {
        this.coefficientA = coefficientA;
        this.coefficientB = coefficientB;
    }

    public double getCoefficientA() {
        return coefficientA;
    }

    public void setCoefficientA(double coefficientA) {
        this.coefficientA = coefficientA;
    }

    public double getCoefficientB() {
        return coefficientB;
    }

    public void setCoefficientB(double coefficientB) {
        this.coefficientB = coefficientB;
    }

    @Override
    public double[] solve() {
        if (coefficientA == 0.) {
            return null;
        }

        return new double[] {coefficientB / coefficientA};
    }

    @Override
    public double findYbyX(double x) {
        return coefficientA * x + coefficientB;
    }

    @Override
    public double[] findXbyY(double y) {
        return new Linear(coefficientA, coefficientB - y).solve();
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

        Linear line = (Linear) that;

        if (this.coefficientA != line.coefficientA) {
            return false;
        }
        if (this.coefficientB != line.coefficientB) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        final double prime = 31.;
        double result = 1.;

        result = prime * result + coefficientA;
        result = prime * result + coefficientB;

        return (int) result;
    }

    @Override
    public String toString() {
        return "Line{" +
                "coefficient A=" + coefficientA +
                ", coefficient B=" + coefficientB +
                ", points=" + points.toString() +
                "}";
    }

    @Override
    public Linear clone() {
        try {
            Linear temp = (Linear) super.clone();

            temp.points = new TreeSet<>();

            for (Point p : points) {
                temp.points.add(p.clone());
            }

            return temp;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}