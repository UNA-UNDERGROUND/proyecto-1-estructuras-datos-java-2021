package cr.ac.una;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class SparseMatrixTest {
    @BeforeEach
    public void init() {
    }

    /** 
    * Verifica si una matriz retorna las dimensiones correctas
    */
    @Test
    public void pruebaDimension() {
        SparseMatrix<Integer> matrix= new SparseMatrix<>(5, 4); 
        assertEquals(5, matrix.getRowCount());
        assertEquals(4, matrix.getColumnCount());
    }

    @Test
    public void pruebaMatrizNula(){
        SparseMatrix<Integer> matrix = new SparseMatrix<>(1, 1);
        assertEquals(matrix.get(0, 0), 0);
    }

    @Test
    public void pruebaTraspuesta(){
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
    public void pruebaSuma(){
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
}

