package math;

import math.Exception.DimensionsDoNotAgreeException;

public class SparseMatrix
  implements Matrix
{
  public SparseMatrix(int m, int n)
  {
    // TODO
    throw new UnsupportedOperationException("Not supported yet.");
  }

  public SparseMatrix(Matrix m)
  {
    // TODO
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public Matrix add(double s)
  {
    // TODO
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public Matrix add(Matrix m)
    throws DimensionsDoNotAgreeException
  {
    // TODO
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public Matrix sub(double s)
  {
    // TODO
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public Matrix sub(Matrix m)
    throws DimensionsDoNotAgreeException
  {
    // TODO
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public Matrix mul(double s)
  {
    // TODO
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public Matrix mul(Matrix m)
    throws DimensionsDoNotAgreeException
  {
    // TODO
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public Vector mul(Vector v)
    throws DimensionsDoNotAgreeException
  {
    // TODO
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public Size size()
  {
    // TODO
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public double get(int i, int j)
  {
    // TODO
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public Vector getRow(int i)
  {
    // TODO
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public Vector getColumn(int j)
  {
    // TODO
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public void set(int i, int j, double s)
  {
    // TODO
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public void setRow(int i, Vector v)
    throws DimensionsDoNotAgreeException
  {
    // TODO
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public void setColumn(int j, Vector v)
    throws DimensionsDoNotAgreeException
  {
    // TODO
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public MatrixIterator iterator()
  {
    // TODO
    throw new UnsupportedOperationException("Not supported yet.");
  }

} // SparseMatrix
