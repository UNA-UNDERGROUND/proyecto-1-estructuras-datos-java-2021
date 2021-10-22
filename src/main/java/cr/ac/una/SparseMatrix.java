package cr.ac.una;

import java.util.LinkedList;
import java.util.List;

public class SparseMatrix<T extends Number> {

    public SparseMatrix(int m, int n, T v) {
        this.m = m;
        this.n = n;
        this.v = v;
        initMatrix();
    }

    public SparseMatrix(int m, int n) {
        this(m, n, GenericNumber.getDefault());
    }

    private void initMatrix() {
        list = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            LinkedList<T> elem = new LinkedList<>();
            for (int j = 0; j < n; j++) {
                elem.add(v);
            }
            list.add(elem);
        }
    }

    public SparseMatrix<T> add(SparseMatrix<T> m) {
        int M = this.m > m.m ? this.m : m.m;
        int N = this.n > m.n ? this.n : m.n;
        SparseMatrix<T> res = new SparseMatrix<>(M, N, this.v);
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                T val = GenericNumber.add(this.get(i, j), m.get(i, j));
                res.set(i, j, val);
            }
        }
        return res;
    }

    public SparseMatrix<T> transpose() {
        SparseMatrix<T> res = new SparseMatrix<>(this.n, this.m, this.v);
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.m; j++) {
                T val = this.get(j, i);
                res.set(i, j, val);
            }
        }
        return res;
    }


    private List<T> getRow(int row){
        List<T> vals = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            vals.add(get(row, i));
        }
        return vals;
    }
    private List<T> getColumn(int col){
        List<T> vals = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            vals.add(get(i, col));
        }
        return vals;
    }
    private T multiplyRowCol(List<T> row, List<T> col){
        T val = GenericNumber.getDefault();
        for (int i = 0; i < row.size(); i++) {
            T res = (GenericNumber.multiply(row.get(i) , col.get(i)));
            val = GenericNumber.add(val, res);
        }
        return val;
    }

    public SparseMatrix<T> multiply(SparseMatrix<T> m) {
        int M = this.m > m.m ? this.m : m.m;
        int N = this.n > m.n ? this.n : m.n;
        SparseMatrix<T> res = new SparseMatrix<>(M, N, this.v);
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                List<T> row = getRow(i);
                List<T> col = getColumn(j);
                T val = multiplyRowCol(row, col);
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
        list.get(m).set(m, v);
    }

    public T get(int m, int n) {
        try {
            return list.get(m).get(n);
        } catch (Exception e) {
            return v;
        }
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

        if (m0 < 0 || m0 > m1 || m1 < m0 && m1 > m || n0 < 0 && n0 > n1 || n1 < n0 && n1 > n) {

            throw new IndexOutOfBoundsException();
        }
        int M = m1 - m0;
        int N = n1 - n0;
        SparseMatrix<T> res = new SparseMatrix<>(M, N);
        LinkedList<LinkedList<T>> list = new LinkedList<>();

        for (int i = m0; i < m1; i++) {
            LinkedList<T> l = new LinkedList<>();
            for (int j = n0; j < n1; j++) {
                l.add(this.get(i, j));
            }
            list.add(l);
        }
        res.list = list;
        return res;

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