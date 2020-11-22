package com.rep.methodparam;

public class CastAs {

    @SuppressWarnings("unchecked")
    /**
     * Attempt casting passed in object as the type of class C. Will return null if the cast is incompatible rather then
     * throw an exception.
     * 
     * @param object
     * @param c
     * @return
     */
    public static <T> T castAs(Object object, Class<T> c) {
        try {
            return (T) object;
        }
        catch (Exception e) {
            return null;
        }
    }

    /**
     * Convenience method of choosing the first non-null value starting from the left
     * 
     * @param a
     * @param b
     * @return
     */
    @SafeVarargs
    public static <T> T Coalice(T... values) {
        for (T item : values) {
            if (item != null) {
                return item;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(CastAs.Coalice(null, 1));
        System.out.println(CastAs.Coalice(null, null).toString());
//        CastAs.castAs();
    }
}