package math;

import math.Exception.DimensionsDoNotAgreeException;

public abstract class AbstractMatrix implements Matrix {
    @Override
    public Matrix add(double s) {
        return null;
    }

    @Override
    public abstract Matrix add(Matrix m) throws DimensionsDoNotAgreeException;

    @Override
    public Matrix sub(double s) {
        return null;
    }

    @Override
    public Matrix sub(Matrix m) throws DimensionsDoNotAgreeException {
        return null;
    }

    @Override
    public Matrix mul(double s) {
        return null;
    }

    @Override
    public abstract Matrix mul(Matrix m) throws DimensionsDoNotAgreeException;

    @Override
    public Vector mul(Vector v) throws DimensionsDoNotAgreeException {
        return null;
    }

    @Override
    public Size size() {
        return null;
    }

    @Override
    public double get(int i, int j) {
        return 0;
    }

    @Override
    public Vector getRow(int i) {
        return null;
    }

    @Override
    public Vector getColumn(int j) {
        return null;
    }

    @Override
    public void set(int i, int j, double s) {

    }

    @Override
    public void setRow(int i, Vector v) throws DimensionsDoNotAgreeException {

    }

    @Override
    public void setColumn(int j, Vector v) throws DimensionsDoNotAgreeException {

    }

    @Override
    public MatrixIterator iterator() {
        return null;
    }
}
