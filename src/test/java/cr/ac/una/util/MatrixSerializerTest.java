package cr.ac.una.util;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;

import org.junit.jupiter.api.Test;

import cr.ac.una.SparseMatrix;
import cr.ac.una.xml.JAXBParser;

public class MatrixSerializerTest {
    private static final String RUTA_XML = "A.xml";
    private static final String RESULTADO_XML = "save-test.xml";

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

        MatrixSerializer loader = JAXBParser.unmarshall(new MatrixSerializer(), file);
        SparseMatrix<Integer> matrix = loader.load();
        assertTrue(matrix.getRowCount() == 200);
        assertTrue(matrix.getColumnCount() == 241);
        assertTrue(matrix.get(0, 210).equals(277));
    }

    @Test
    void testSave() {
        SparseMatrix<Integer> matrix = new SparseMatrix<>(2, 2, -1);
        matrix.set(0, 0, 1);
        matrix.set(0, 1, 2);
        matrix.set(1, 0, 3);
        matrix.set(1, 1, 4);
        MatrixSerializer serializer = new MatrixSerializer(matrix);
        JAXBParser.marshall(serializer, RESULTADO_XML);
        serializer = JAXBParser.unmarshall(new MatrixSerializer(), RESULTADO_XML);
        matrix = serializer.load();
        assertTrue(matrix.get(0, 0) == 1);
        assertTrue(matrix.get(0, 1) == 2);
        assertTrue(matrix.get(1, 0) == 3);
        assertTrue(matrix.get(1, 1) == 4);
    }
}
