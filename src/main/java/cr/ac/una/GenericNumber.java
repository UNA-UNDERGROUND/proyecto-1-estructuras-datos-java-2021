
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

package cr.ac.una;

/**
 * GenericNumber es una clase que permite manipulacion de Numeros de manera
 * Generica <br />
 * por ejemplo realizar lo siguiente
 * <ul>
 * <li>Obtener el tipo del numero</li>
 * <li>crear un numero por defecto</li>
 * <li>sumar 2 numeros</li>
 * <li>multiplicar 2 numeros</li>
 * </ul>
 * el soporte de los Tipos soportados son todos los que heredan de Number
 */
public final class GenericNumber<T extends Number> {

    /**
     * Generic Number es una clase de metodos para el manejo de genericos, como tal
     * no es instanciable y todos sus metodos son estaticos
     */
    private GenericNumber() {

    }

    /**
     * recupera el valor por defecto para un tipo especificado
     * 
     * @param <T> el tipo del Generico
     * @return el valor por defecto del Tipo
     */
    @SuppressWarnings("unchecked")
    public static <T extends Number> T getDefault() {
        return ((T) (Integer) (int) 0);
    }

    /**
     * agrega 2 numeros Genericos
     * 
     * @param <T> el tipo del numero
     * @param x   el primer numero
     * @param y   el segundo numero
     * @return la suma de los dos numeros (x + b)
     */
    @SuppressWarnings("unchecked")
    public static <T extends Number> T add(T x, T y) {
        if (x instanceof Integer) {
            Integer sum;
            sum = (x.intValue() + y.intValue());
            return (T) (sum);
        }
        if (x instanceof Long) {
            Long sum;
            sum = (x.longValue() + y.longValue());
            return (T) (sum);
        }
        if (x instanceof Float) {
            Float sum;
            sum = (x.floatValue() + y.floatValue());
            return (T) (sum);
        }
        if (x instanceof Double) {
            Double sum;
            sum = (x.doubleValue() + y.doubleValue());
            return (T) (sum);
        }
        if (x instanceof Byte) {
            Byte sum;
            sum = (byte) (x.intValue() + y.intValue());
            return (T) (sum);
        }
        if (x instanceof Short) {
            Short sum;
            sum = (short) (x.intValue() + y.intValue());
            return (T) (sum);
        }
        throw new ClassCastException("NaN");
    }

    /**
     * multiplica 2 numeros Genericos
     * 
     * @param <T> el tipo del numero
     * @param x   el primer numero
     * @param y   el segundo numero
     * @return la suma de los dos numeros (x + b)
     */
    @SuppressWarnings("unchecked")
    public static <T extends Number> T multiply(T x, T y) {
        if (x instanceof Integer) {
            Integer sum;
            sum = (x.intValue() * y.intValue());
            return (T) (sum);
        }
        if (x instanceof Long) {
            Long sum;
            sum = (x.longValue() * y.longValue());
            return (T) (sum);
        }
        if (x instanceof Float) {
            Float sum;
            sum = (x.floatValue() * y.floatValue());
            return (T) (sum);
        }
        if (x instanceof Double) {
            Double sum;
            sum = (x.doubleValue() * y.doubleValue());
            return (T) (sum);
        }
        if (x instanceof Byte) {
            Byte sum;
            sum = (byte) (x.intValue() * y.intValue());
            return (T) (sum);
        }
        if (x instanceof Short) {
            Short sum;
            sum = (short) (x.intValue() * y.intValue());
            return (T) (sum);
        }
        throw new ClassCastException("NaN");
    }
}
