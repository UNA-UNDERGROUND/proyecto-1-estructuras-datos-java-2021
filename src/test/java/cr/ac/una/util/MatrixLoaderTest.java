package cr.ac.una.util;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;

import org.junit.jupiter.api.Test;

import cr.ac.una.SparseMatrix;
import cr.ac.una.xml.JAXBParser;

public class MatrixLoaderTest {
    private static final String RUTA_XML = "A.xml";

    @Test
    void testFileExist() {
        ClassLoader classLoader = this.getClass().getClassLoader();
        File file = new File(classLoader.getResource(RUTA_XML).getFile());
        assertTrue(file.exists());
    }

    @Test
    void testLoad() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(RUTA_XML).getFile());

        MatrixLoader loader = JAXBParser.unmarshall(new MatrixLoader(), file);
        SparseMatrix<Integer> matrix = loader.load();
        assertTrue(matrix.getRowCount() == 200);
        assertTrue(matrix.getColumnCount() == 241);
        assertTrue(matrix.get(0, 210).equals(277));
    }
}
