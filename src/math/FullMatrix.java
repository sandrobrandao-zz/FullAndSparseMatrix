package math;

import math.Exception.DimensionsDoNotAgreeException;
import math.Iterator.MatrixIterator;

public class FullMatrix implements Matrix
{
  private Matrix fullMatrix;
  private Element fullMatrixElement;
  private Size size;
  private int m;
  private int n;
  private Vector<Element> vector;

  public FullMatrix()
  {

  }

  public FullMatrix(int m, int n)
  {
    size = new Size(m, n);    // matrix dimension
    Element element;
    vector = new Vector(m*n);
    for(int i = 0; i < m; i++){
      for(int j=0; j< n; j++){
        element = new Element(i,j,0);
        vector.add(element);
      }
    }
  }

  public FullMatrix(Matrix m)
  {
    size = new Size(m.size().m, m.size().n);
    Element element;
    vector = new Vector(size.m*size.n);
    for(int i = 0; i < size.m; i++){
      for(int j = 0; j < size.n; j++){
        element = new Element(i, j, m.get(i, j));
        vector.add(element);
      }
    }
  }

  @Override
  public Matrix add(double s)
  {
    Matrix matrix = new FullMatrix();
    int m = this.size.m;
    int n = this.size.n;
    for(int i = 0; i < m; i++)
      for (int j = 0; j < n; j++){
        double val;
        val = this.get(i, j);
        val += s;
        matrix.set(i, j, val);
      }
    return matrix;
  }

  @Override
  public Matrix add(Matrix m)
          throws DimensionsDoNotAgreeException
  {

    if(fullMatrix.size() != m.size())
      throw new IndexOutOfBoundsException("FullMatrixSizeIndex: "
              + fullMatrix.size() +"!=" +"Matrix M add "+ m.size());
    Matrix matrix = new FullMatrix();
    int m_i = this.size.m;
    int n_j = this.size.n;
    fullMatrix.size();
    for(int i = 0; i < m_i; i++)
      for(int j = 0; i < n_j; j++){
        matrix.set(i,j, fullMatrix.get(i, j) + m.get(i, j));
      }
    return matrix;
  }

  @Override
  public Matrix sub(double s)
  {
    Matrix matrix = new FullMatrix();
    int m = this.size.m;
    int n = this.size.n;
    for(int i = 0; i < m; i++)
      for (int j = 0; j < n; j++){
        matrix.set(i, j, this.get(i, j) - s);
      }
    return matrix;
  }

  @Override
  public Matrix sub(Matrix m)
          throws DimensionsDoNotAgreeException
  {
    if(fullMatrix.size() != m.size())
      throw new IndexOutOfBoundsException("FullMatrixSizeIndex: "
              + fullMatrix.size() +"!=" +"Matrix M subb "+ m.size());
    Matrix matrix = new FullMatrix();
    int m_i = this.size.m;
    int n_j = this.size.n;
    for(int i = 0; i < m_i; i++)
      for(int j = 0; i < n_j; j++){
        matrix.set(i,j, fullMatrix.get(i, j) - m.get(i, j));
      }
    return matrix;
  }

  @Override
  public Matrix mul(double s)
  {
    Matrix matrix = new FullMatrix();
    int m = this.size.m;
    int n = this.size.n;
    for(int i = 0; i < m; i++)
      for (int j = 0; j < n; j++){
        matrix.set(i, j, this.get(i, j) * s);
      }
    return matrix;
  }

  @Override
  public Matrix mul(Matrix m)
          throws DimensionsDoNotAgreeException
  {
    if(this.size().n != m.size().m)
      throw new IndexOutOfBoundsException("FullMatrixSize N: "
              + this.size().n +"!=" +"Matrix M mult M "+ m.size().m);
    Matrix matrix = new FullMatrix(this.size().m, m.size().n);
    int m_i = this.size.m;
    int n_j = m.size().n;
    for(int i = 0; i < m_i; i++){
      double valueAux = 0;
      boolean sentinel = true;
      int p_j = 0;
      for(int j = 0; i < n_j; j++){
        if(sentinel){
          sentinel = false;
          p_j = j;
        }
        valueAux += this.get(i, j) * m.get(j, i);
      }
      matrix.set(i, p_j, valueAux);
    }
    return matrix;
  }

  @Override
  public Vector mul(Vector v)
          throws DimensionsDoNotAgreeException
  {
    if(v.size() == this.vector.size())
      throw new IndexOutOfBoundsException(
              "IndexOutOfBoundsException: size Vector, verify element");
    Vector<Element> vecAux = v;
    Element element;
    for(int k = 0; k < this.vector.size(); k++){
      element = new Element(this.vector.get(k).i, this.vector.get(k).j,
              this.vector.get(k).value * vecAux.get(k).value);
      vecAux.set(k, element);

    }
    return vecAux;
  }

  @Override
  public Size size()
  {
    return new Size(m,n);
    //throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public double get(int i, int j)
  {
    if(i < 0 || j < 0 || i >= this.size.m || j >= this.size.n){
      throw new IndexOutOfBoundsException(
              "IndexOutOfBoundsException: i or j, verify elements");
    }
    for(int k = 0; k < this.vector.size(); k++){
      if(this.vector.get(k).i == i && this.vector.get(k).j == j){
        return this.vector.get(k).value;
      }
    }
    return -1;
  }

  @Override
  public Vector getRow(int i)
  {
    if(i < 0 || i > this.vector.size())
      throw new IndexOutOfBoundsException(
              "IndexOutOfBoundsException: i, verify element");
    Vector<Element> vecAux = new Vector(this.vector.size());
    for(int k = 0; k < this.vector.size(); k++){
      if(this.vector.get(k).i == i){
        vecAux.add(this.vector.get(k));
      }
    }
    return vecAux;
  }

  @Override
  public Vector getColumn(int j)
  {
    if(j < 0 || j > this.vector.size())
      throw new IndexOutOfBoundsException(
              "IndexOutOfBoundsException: j, verify element");
    Vector<Element> vecAux = new Vector(this.vector.size());
    for(int k = 0; k < this.vector.size(); k++){
      if(this.vector.get(k).j == j){
        vecAux.add(this.vector.get(k));
      }
    }
    return vecAux;
  }

  @Override
  public void set(int i, int j, double s)
  {
    if(i < 0 || j < 0 || i >= this.vector.size() || j >= this.vector.size()){
      throw new IndexOutOfBoundsException(
              "IndexOutOfBoundsException: i or j, verify elements");
    }
    Element element;
    for(int k = 0; k < this.vector.size(); k++){
      if(this.vector.get(k).i == i && this.vector.get(k).j == j){
        element = new Element(i, j, s);
        this.vector.set(k, element);
      }
    }
  }

  @Override
  public void setRow(int i, Vector v)
          throws DimensionsDoNotAgreeException
  {
    if(i < 0 || i > this.vector.size())
      throw new IndexOutOfBoundsException(
              "IndexOutOfBoundsException: i, verify element");
    for(int k = 0; k < this.vector.size(); k++){
      if(this.vector.get(k).i == i){
        this.vector.set(k, (Element)v.get(i));
      }
    }
  }

  @Override
  public void setColumn(int j, Vector v)
          throws DimensionsDoNotAgreeException
  {
    if(j < 0 || j > this.vector.size())
      throw new IndexOutOfBoundsException(
              "IndexOutOfBoundsException: j, verify element");
    for(int k = 0; k < this.vector.size(); k++){
      if(this.vector.get(k).j == j){
        this.vector.set(k, (Element)v.get(j));
      }
    }
  }

  @Override
  public MatrixIterator iterator()
  {
    // TODO
    throw new UnsupportedOperationException("Not supported yet.");
  }

} // FullMatrix