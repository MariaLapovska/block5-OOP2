package com.epam.functions;

import java.util.LinkedHashSet;

/**
 * Created by Asus on 19.05.2016.
 */
public class Parabola extends Function {

    private double coefficientA;
    private double coefficientB;
    private double coefficientC;

    public Parabola() {}

    public Parabola(double coefficientA, double coefficientB, double coefficientC) {
        checkCoefficient(coefficientA);

        this.coefficientA = coefficientA;
        this.coefficientB = coefficientB;
        this.coefficientC = coefficientC;
    }

    public double getCoefficientA() {
        return coefficientA;
    }

    public void setCoefficientA(double coefficientA) {
        checkCoefficient(coefficientA);

        this.coefficientA = coefficientA;
    }

    public double getCoefficientB() {
        return coefficientB;
    }

    public void setCoefficientB(double coefficientB) {
        this.coefficientB = coefficientB;
    }

    public double getCoefficientC() {
        return coefficientC;
    }

    public void setCoefficientC(double coefficientC) {
        this.coefficientC = coefficientC;
    }

    @Override
    public double[] solve() {
        double d = coefficientB * coefficientB -
                4 * coefficientA * coefficientC;

        if (d < 0) {
            return new double[0];
        } else if (d == 0) {
            return new double[] {-coefficientB / (2 * coefficientA)};
        } else { // d > 0
            double x1 = (-coefficientB - Math.sqrt(d)) /
                    (2 * coefficientA);
            double x2 = (-coefficientB + Math.sqrt(d)) /
                    (2 * coefficientA);

            return new double[] {x1, x2};
        }
    }

    @Override
    public double findYbyX(double x) {
        return coefficientA * x * x + coefficientB * x + coefficientC;
    }

    @Override
    public double[] findXbyY(double y) {
        return new Parabola(coefficientA, coefficientB, coefficientC - y).solve();
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

        Parabola parabola = (Parabola) that;

        if (this.coefficientA != parabola.coefficientA) {
            return false;
        }
        if (this.coefficientB != parabola.coefficientB) {
            return false;
        }
        if (this.coefficientC != parabola.coefficientC) {
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
        result = prime * result + coefficientC;

        return (int) result;
    }

    @Override
    public String toString() {
        return "com.epam.functions.Parabola{" +
                "coefficient A=" + coefficientA +
                ", coefficient B=" + coefficientB +
                ", coefficient C=" + coefficientC +
                ", points=" + points.toString() +
                "}";
    }

    @Override
    public Parabola clone() {
        try {
            Parabola temp = (Parabola) super.clone();

            temp.points = new LinkedHashSet<>();

            for (Point p : points) {
                temp.points.add(p.clone());
            }

            return temp;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    private void checkCoefficient(double coefficient) {
        if (coefficient == 0.) {
            throw new IllegalArgumentException("a == 0!");
        }
    }
}
