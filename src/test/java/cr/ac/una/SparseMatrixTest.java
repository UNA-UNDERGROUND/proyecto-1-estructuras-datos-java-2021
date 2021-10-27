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

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SparseMatrixTest {
    @BeforeEach
    public void init() {
    }


    @Test
    public void testDimension() {
        SparseMatrix<Integer> matrix = new SparseMatrix<>(5, 4);
        assertEquals(5, matrix.getRowCount());
        assertEquals(4, matrix.getColumnCount());
    }

    @Test
    public void testMatrizNula() {
        SparseMatrix<Integer> matrix = new SparseMatrix<>(1, 1);
        assertEquals(matrix.get(0, 0), 0);
    }

    @Test
    public void testAdd() {
        SparseMatrix<Integer> matrixA = new SparseMatrix<>(3, 3);
        SparseMatrix<Integer> matrixB = new SparseMatrix<>(3, 3);
        int v = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrixA.set(i, j, v++);
                matrixB.set(i, j, 10);
            }
        }
        SparseMatrix<Integer> expected = new SparseMatrix<>(3, 3);
        v = 10;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                expected.set(i, j, v++);
            }
        }
        assertEquals(expected, matrixA.add(matrixB));
    }

    @Test
    public void testTranspose() {
        SparseMatrix<Integer> matrix = new SparseMatrix<>(3, 3);
        int v = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix.set(i, j, v++);
            }
        }
        SparseMatrix<Integer> expected = new SparseMatrix<>(3, 3);
        v = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                expected.set(j, i, v++);
            }
        }
        assertEquals(expected, matrix.transpose());
    }

    @Test
    public void testMultiply() {
        SparseMatrix<Integer> matrixA = new SparseMatrix<>(3, 3);
        SparseMatrix<Integer> matrixB = new SparseMatrix<>(3, 3);
        SparseMatrix<Integer> expected = new SparseMatrix<>(3, 3);

        matrixA.set(0, 0, 2);
        matrixA.set(0, 1, 0);
        matrixA.set(0, 2, 1);
        matrixA.set(1, 0, 3);
        matrixA.set(1, 1, 0);
        matrixA.set(1, 2, 0);
        matrixA.set(2, 0, 5);
        matrixA.set(2, 1, 1);
        matrixA.set(2, 2, 1);

        matrixB.set(0, 0, 1);
        matrixB.set(0, 1, 0);
        matrixB.set(0, 2, 1);
        matrixB.set(1, 0, 1);
        matrixB.set(1, 1, 2);
        matrixB.set(1, 2, 1);
        matrixB.set(2, 0, 1);
        matrixB.set(2, 1, 1);
        matrixB.set(2, 2, 0);

        expected.set(0, 0, 3);
        expected.set(0, 1, 1);
        expected.set(0, 2, 2);
        expected.set(1, 0, 3);
        expected.set(1, 1, 0);
        expected.set(1, 2, 3);
        expected.set(2, 0, 7);
        expected.set(2, 1, 3);
        expected.set(2, 2, 6);

        assertEquals(expected, matrixA.multiply(matrixB));
    }

    @Test
    public void testSplice() {
        SparseMatrix<Integer> matrix = new SparseMatrix<>(4, 4);
        SparseMatrix<Integer> expected = new SparseMatrix<>(2, 2);
        int v = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matrix.set(i, j, v++);
            }
        }
        expected.set(0, 0, 0);
        expected.set(0, 1, 1);
        expected.set(1, 0, 4);
        expected.set(1, 1, 5);

        assertEquals(expected, matrix.splice(0, 2, 0, 2));
    }
}
