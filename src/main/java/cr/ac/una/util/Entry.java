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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entry es una clase que contiene los datos de un nodo en un XML con los datos
 * de la matriz, al ser un tipo generico tiene un valor del tipo String
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Entry {

    /**
     * Crea una nueva entrada manual
     * 
     * @param row    fila de la entrada
     * @param column columna de la entrada
     * @param value  valor de la entrada
     */
    public Entry(int row, int column, String value) {
        this.row = row;
        this.column = column;
        this.value = value;
    }

    /**
     * Crea una nueva entrada, <br />
     * este método es necesario para cargar mediante XML
     * 
     */
    public Entry() {
    }

    /**
     * obtiene la fila de la entrada
     * 
     * @return la posicion en la fila
     */
    public int getRow() {
        return row;
    }

    /**
     * actualiza la fila de la entrada
     * 
     * @param row la nueva fila
     */
    public void setRow(int row) {
        this.row = row;
    }

    /**
     * recupera la columna de la entrada
     * 
     * @return la posicion en la columna
     */
    public int getColumn() {
        return column;
    }

    /**
     * actualiza la columna de la entrada
     * 
     * @param column la nueva columna
     */
    public void setColumn(int column) {
        this.column = column;
    }

    /**
     * recupera el valor de la entrada
     * 
     * @return el valor de la entrada como un String
     */
    public String getValue() {
        return value;
    }

    /**
     * actualiza el valor de la entrada
     * 
     * @param value el nuevo valor de la entrada
     */
    public void setValue(String value) {
        this.value = value;
    }

    private int row = -1;
    private int column = -1;
    private String value = "";
}
