/** 
 *
 * (c) 2021
 * @author Paula Arias Mora
 * @version 1.0.0 2021-10-24
 *
 * -----------------------------------------------
 * EIF207 Estructuras de Datos
 * 2do ciclo 2021, grupo 01
 * Proyecto 1
 *
 * 117160835 Arias Mora Maria Paula 
 * -----------------------------------------------
 */

package cr.ac.una;

import java.util.LinkedList;
import java.util.List;

/**
 * Implementacion LIL (Lista enlazada) de una matriz de tamaño constante
 */
public class SparseMatrix<T extends Number> {

    /**
     * Crea una matriz usando una dimension especificada y tomando un valor nulo
     * indicado
     * 
     * @param m cantidad de filas
     * @param n cantidad de columnas
     * @param v el valor nulo de la matriz
     */
    public SparseMatrix(int m, int n, T v) {
        this.m = m;
        this.n = n;
        this.v = v;
        initMatrix();
    }

    /**
     * Crea una matriz usando una dimension especificada y tomando un valor por
     * defecto disponible para los valores nulos
     * 
     * @param m cantidad de filas
     * @param n cantidad de columnas
     */
    public SparseMatrix(int m, int n) {
        this(m, n, GenericNumber.getDefault());
    }

    /**
     * inicializa la matriz interna usando los parametros de dimension
     * preestablecidos por la instancia de la matríz
     *
     */
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

    /**
     * suma la matriz actual con otra matriz <br />
     * siendo el resultado AxB=C <br />
     * siendo A esta matriz y C la nueva matriz
     *
     * @param m la matriz con la que se sumará (B)
     * @return la matriz resultado de la suma (C)
     */
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

    /**
     * multiplica la matriz actual con otra matriz <br />
     * siendo el resultado AxB=C <br />
     * siendo A esta matriz y C la nueva matriz
     *
     * @return la matriz resultado de la multiplicacion (B)
     */
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

    /**
     * multiplica la matriz actual con otra matriz <br />
     * siendo el resultado AxB=C <br />
     * siendo A esta matriz y C la nueva matriz
     *
     * @param m la matriz con la que se multiplicará (B)
     * @return la matriz resultado de la multiplicacion (C)
     */
    public SparseMatrix<T> multiply(SparseMatrix<T> m) {
        int M = this.m > m.m ? this.m : m.m;
        int N = this.n > m.n ? this.n : m.n;
        SparseMatrix<T> res = new SparseMatrix<>(M, N, this.v);
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                List<T> row = getRow(i);
                List<T> col = m.getColumn(j);
                T val = multiplyRowCol(row, col);
                res.set(i, j, val);
            }
        }
        return res;
    }

    /**
     * obtiene una submatriz usando las dimensiones de inicio y fin especificadas en
     * el método
     *
     * @param m0 la fila inicial (inclusiva)
     * @param m1 la fila final (exclusiva)
     * @param n0 la columna inicial (inclusiva)
     * @param n1 la columna final (exclusiva)
     * @return la matriz resultado del seccionamiento
     */
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

    /**
     * recupera el numero de filas de la matriz
     * 
     * @return la cantidad de filas
     */
    public int getRowCount() {
        return m;
    }

    /**
     * recupera el numero de filas de la matriz
     * 
     * @return el numero de columnas
     */
    public int getColumnCount() {
        return n;
    }

    /**
     * cambia el valor del elemento especificado
     * 
     * @param m la filaa destino
     * @param n la columna destino
     * @param v el nuevo valor
     */
    public void set(int m, int n, T v) {
        list.get(m).set(n, v);
    }

    /**
     * recupera el elemento de la matriz
     * 
     * @param m la fila de la matriz
     * @param n la columna de la matriz
     * @return
     */
    public T get(int m, int n) {
        try {
            return list.get(m).get(n);
        } catch (Exception e) {
            return v;
        }
    }

    /**
     * recupera una fila de la matriz
     *
     * @param row el indice de la fila (0 inclusivo)
     * @return la fila ordenada en una lista
     */
    private List<T> getRow(int row) {
        List<T> vals = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            vals.add(get(row, i));
        }
        return vals;
    }

    /**
     * recupera una columna de la matriz
     *
     * @param col el indice de la columna (0 inclusivo)
     * @return la columna ordenada en una lista
     */
    private List<T> getColumn(int col) {
        List<T> vals = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            vals.add(get(i, col));
        }
        return vals;
    }

    /**
     * multiplica una fila y una columna de la matriz
     *
     * @param row el indice de la fila (0 inclusivo)
     * @param col el indice de la columna (0 inclusivo)
     * @return el escalar resultado de la multiplicacion
     */
    private T multiplyRowCol(List<T> row, List<T> col) {
        T val = GenericNumber.getDefault();
        for (int i = 0; i < row.size(); i++) {
            T res = (GenericNumber.multiply(row.get(i), col.get(i)));
            val = GenericNumber.add(val, res);
        }
        return val;
    }

    /**
     * retorna una representacion de la matriz especificada
     */
    @Override
    public String toString() {
        return String.format("SparseMatrix[%d,%d]", m, n);
    }

    /**
     * compara la matriz con otra matriz
     * 
     * @param other la otra matriz a comparar
     * @return el resultado de la comparacion
     */
    boolean equals(SparseMatrix<T> other) {
        for (int i = 0; i < this.m; i++) {
            for (int j = 0; j < this.n; j++) {
                T val = get(i, j);
                T o = other.get(i, j);
                if (val == null || !val.equals(o)) {
                    return false;
                }
            }
        }
        return true;
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