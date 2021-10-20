package cr.ac.una;

import java.util.LinkedList;

public class SparseMatrix<T extends Number> {

    public SparseMatrix(int m, int n, T v) {
        this.m = n;
        this.n = n;
        this.v = v;
        initMatrix();
    }

    public SparseMatrix(int m, int n) {
        this(m, n, null);
    }

    private void initMatrix() {
        list = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            LinkedList<T> elem = new LinkedList<>();
            for (int j = 0; j < n; j++) {
                elem.add(null);
            }
            list.add(elem);
        }
    }

    public SparseMatrix<T> add(SparseMatrix<T> m) {
        SparseMatrix<T> res = new SparseMatrix<>(this.m, this.n, this.v);
        for (int i = 0; i < this.m; i++) {
            for (int j = 0; j < this.n; j++) {
                T val = GenericNumber.add(this.get(i, j), m.get(i, j));
                res.set(i, j, val);
            }
        }
        return res;
    }

    public SparseMatrix<T> transpose() {
        // TODO
        throw new UnsupportedOperationException();
    }

    public SparseMatrix<T> multiply(SparseMatrix<T> m) {
        SparseMatrix<T> res = new SparseMatrix<>(this.m, this.n, this.v);
        for (int i = 0; i < this.m; i++) {
            for (int j = 0; j < this.n; j++) {
                T val = GenericNumber.multiply(this.get(i, j), m.get(i, j));
                res.set(i, j, val);
            }
        }
        return res;
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
        for (int i = 0; i < this.m; i++) {
            for (int j = 0; j < this.n; j++) {
                T val = get(i, j);
                if (val == null || !val.equals(other.get(i, j))) {
                    return false;
                }
            }
        }
        return true;
    }

    public SparseMatrix<T> splice(int m0, int m1, int n0, int n1) {
        // TODO
        throw new UnsupportedOperationException();
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object obj) {
        if (obj.getClass().isInstance(this)) {
            return equals((SparseMatrix<T>) obj);
        }
        return false;
    }

    private int m;
    private int n;
    private T v;
    private LinkedList<LinkedList<T>> list;

};