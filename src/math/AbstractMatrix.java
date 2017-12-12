package math;

import math.Exception.DimensionsDoNotAgreeException;
import math.Iterator.MatrixIterator;

public abstract class AbstractMatrix implements Matrix {
    private Size size;

    @Override
    public Matrix add(double s) {
        Matrix matrix = new FullMatrix();
        int m = this.size().m;
        int n = this.size().n;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix.set(i, j, this.get(i, j) + s);
            }
        }

        return matrix;
    }

    @Override
    public abstract Matrix add(Matrix m) throws DimensionsDoNotAgreeException;

    @Override
    public Matrix sub(double s) {
        Matrix matrix = new FullMatrix();
        int m = this.size().m;
        int n = this.size().n;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                double val;
                val = this.get(i, j);
                val -= s;
                matrix.set(i, j, val);
            }
        }

        return matrix;
    }

    @Override
    public Matrix sub(Matrix m) throws DimensionsDoNotAgreeException {
        return null;
    }

    @Override
    public Matrix mul(double s) {
      Matrix matrix = new FullMatrix();
      int m = this.size().m;
      int n = this.size().n;

      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          double val;
          val = this.get(i, j);
          val *= s;
          matrix.set(i, j, val);
        }
      }

      return matrix;
    }

    @Override
    public abstract Matrix mul(Matrix m) throws DimensionsDoNotAgreeException;

    @Override
    public Vector mul(Vector v) throws DimensionsDoNotAgreeException {
        return null;
    }

    @Override
    public Size size() {
        return this.size;
    }

    @Override
    public abstract double get(int i, int j);

    @Override
    public Vector getRow(int i) {
        Vector vector = new Vector();

        return vector;
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
