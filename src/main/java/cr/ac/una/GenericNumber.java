package cr.ac.una;

public class GenericNumber {
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
