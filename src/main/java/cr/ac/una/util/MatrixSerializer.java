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
package cr.ac.una.util;

import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import cr.ac.una.GenericNumber;
import cr.ac.una.SparseMatrix;

/**
 * Un encapsulador para cargar la lista de elementos del XML sin orden
 */
@XmlRootElement(name = "sparse_matrix")
@XmlAccessorType(XmlAccessType.FIELD)
public class MatrixSerializer {
    public MatrixSerializer() {
        init();
    }

    public <T extends Number> MatrixSerializer(SparseMatrix<T> matrix) {
        init();
        for (int i = 0; i < matrix.getRowCount(); i++) {
            for (int j = 0; j < matrix.getColumnCount(); j++) {
                entryList.add(new Entry(i, j, matrix.get(i, j).toString()));
            }
        }
    }

    private void init() {
        if (entryList == null) {
            entryList = new LinkedList<>();
        }
    }

    public <T extends Number> SparseMatrix<T> load() {
        init();
        try {
            LinkedList<LinkedList<T>> values = new LinkedList<>();
            values.add(new LinkedList<>());
            values.get(0).add(GenericNumber.getDefault());

            for (Entry entry : entryList) {
                resize(values, entry.getRow(), entry.getColumn());
                values.get(entry.getRow()).set(entry.getColumn(), GenericNumber.parseNumber(entry.getValue()));
            }
            return new SparseMatrix<>(values);
        } catch (Exception e) {
            throw new RuntimeException("Non parsable file");
        }
    }

    private <T extends Number> void resize(LinkedList<LinkedList<T>> entries, int row, int col) {
        while (entries.size() < (row + 1)) {
            entries.add(new LinkedList<T>());
        }
        for (LinkedList<T> list : entries) {
            while (list.size() < col + 1) {
                list.add(GenericNumber.getDefault());
            }
        }
    }

    @XmlElementWrapper(name = "entry_list")
    @XmlElement(name = "entry")
    List<Entry> entryList;
}
