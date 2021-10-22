package cr.ac.una;

/**
 * GenericNumber es una clase que permite manipulacion de Numeros de manera Generica
 * <br />
 * por ejemplo realizar lo siguiente
 * <ul>
 *     <li>Obtener el tipo del numero</li>
 *     <li>crear un numero por defecto</li>
 *     <li>sumar 2 numeros</li>
 *     <li>multiplicar 2 numeros</li>
 * </ul>
 * el soporte de los Tipos soportados son todos los que heredan de Number
 */
public class GenericNumber<T> {

    @SuppressWarnings("unchecked")
    public static <T extends Number> T getDefault() {
        return ((T) (Integer) (int) 0);
    }

    /**
     * agrega 2 numeros Genericos
     * @param <T> el tipo del numero
     * @param x el primer numero
     * @param y el segundo numero
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
