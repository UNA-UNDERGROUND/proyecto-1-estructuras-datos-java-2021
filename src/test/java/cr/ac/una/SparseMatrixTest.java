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
}

