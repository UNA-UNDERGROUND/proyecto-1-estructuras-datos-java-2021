package cr.ac.una.xml;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

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
 *
 *
 */

/**
 * JAXBParser es una clase con utilitarios que permiten cargar un archivo XML
 * usando JAXB
 */
public class JAXBParser {
    /**
     * JAXBParser es una clase estatica
     */
    private JAXBParser() {

    }

    /**
     * Convierte un objeto a XML y lo guarda en un archivo indicado
     * 
     * @param <T>         el tipo del objeto
     * @param obj         el objeto a guardar
     * @param rutaArchivo la ruta del archivo a guardar
     */
    public static <T> void marshall(T obj, String rutaArchivo) {
        try {
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(obj, new FileOutputStream(rutaArchivo));
        } catch (Exception ex) {
            ex.printStackTrace();
            // System.err.println(ex.getLocalizedMessage());
        }
    }

    /**
     * Desserializa un objeto XML a su correspondiente
     * 
     * @param <T>         el tipo del objeto
     * @param ref         el objeto a cargar
     * @param rutaArchivo la ruta del archivo
     * @return el archivo cargado, en caso de error retorna el objeto original (ref)
     */
    public static <T> T unmarshall(T ref, String rutaArchivo) {
        return unmarshall(ref, new File(rutaArchivo));
    }

    /**
     * Desserializa un objeto XML a su correspondiente
     * 
     * @param <T>     el tipo del objeto
     * @param ref     el objeto a cargar
     * @param archivo el archivo de donde cargar el XML
     * 
     * @return el archivo cargado, en caso de error retorna el objeto original (ref)
     */
    public static <T> T unmarshall(T ref, File archivo) {
        try {
            return unmarshall(ref, new FileInputStream(archivo));
        } catch (FileNotFoundException e) {
            System.err.println("[WARN] Archivo no encontrado, omitiendo.");
        }
        return ref;
    }

    /**
     * Desserializa un objeto XML a su correspondiente
     * 
     * @param <T>     el tipo del objeto
     * @param ref     el objeto a cargar
     * @param archivo el stream de donde cargar el XML
     * 
     * @return el archivo cargado, en caso de error retorna el objeto original (ref)
     */
    @SuppressWarnings("unchecked")
    public static <T> T unmarshall(T ref, FileInputStream archivo) {
        try {
            JAXBContext context = JAXBContext.newInstance(ref.getClass());
            Unmarshaller unmarshallerObj = context.createUnmarshaller();
            return (T) unmarshallerObj.unmarshal(new BufferedInputStream(archivo));
        } catch (Exception ex) {
            System.err.println("[WARN] Archivo incorrecto, omitiendo.");
        }
        return ref;
    }

}
