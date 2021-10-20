package cr.ac.una;

import java.util.LinkedList;

public class SparseMatrix<T> {

    public SparseMatrix(int m, int n, T v) {
        this.m = n;
        this.n = n;
        this.v = v;
    }

    public SparseMatrix(int m, int n) {
        this.m = m;
        this.n = n;
        this.v = null;
    }

    public SparseMatrix<T> add(SparseMatrix<T> m) {
        // TODO
        throw new UnsupportedOperationException();
    }

    public SparseMatrix<T> transpose() {
        // TODO
        throw new UnsupportedOperationException();
    }

    public SparseMatrix<T> multiply(SparseMatrix<T> m) {
        // TODO
        throw new UnsupportedOperationException();
    }

    public int getRowCount() {
        return m;
    }

    public int getColumnCount() {
        return n;

    }

    public void set(int m, int n, T v) {
        // TODO
        throw new UnsupportedOperationException();
    }

    public T get(int m, int n) {
        // TODO
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return String.format("SparseMatrix[%d,%d]", m, n);
    }

    boolean equals(SparseMatrix<T> other) {
        // TODO
        throw new UnsupportedOperationException();

    }

    public SparseMatrix<T> splice(int m0, int m1, int n0, int n1) {
        // TODO
        throw new UnsupportedOperationException();
    }

    private int m;
    private int n;
    private T v;
    private LinkedList<LinkedList<T>> list;

};