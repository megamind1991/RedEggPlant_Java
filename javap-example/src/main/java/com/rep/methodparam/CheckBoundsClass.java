package com.rep.methodparam;

import java.util.Comparator;

public class CheckBoundsClass {
    /**
     * Checks that the item is between the two bounds, inclusive.
     *
     * @param bound1 The first bound, could be the high or low bound.
     * @param bound2 The second bound, could be the high or low bound.
     * @param item The item to check is between the bounds.
     * @param <T> The type of objects being compared, must implement Comparable.
     * @return True if item is between the bounds, false otherwise.
     */
    public static <T extends Comparable> boolean between(final T bound1,
            final T bound2, final T item) {
        return between(bound1, bound2, item, false);
    }

    /**
     * Checks that the item is between the two bounds, inclusive.  Uses a custom comparator.
     *
     * @param bound1 The first bound, could be the high or low bound.
     * @param bound2 The second bound, could be the high or low bound.
     * @param item The item to check is between the bounds.
     * @param comparator The comparator used to compare the objects in the test.
     * @param <T> The type of objects being compared.
     * @return True if item is between the bounds, false otherwise.
     * @throws NullPointerException If the comparator is null.
     */
    public static <T> boolean between(final T bound1, final T bound2,
            final T item, final Comparator<T> comparator) {
        return between(bound1, bound2, item, false, comparator);
    }

    /**
     * Checks that the item is between the two bounds.  If marked as strict it
     * is not an inclusive test, bound1 and bound2 will not return true if passed in as the item.
     *
     * @param bound1 The first bound, could be the high or low bound.
     * @param bound2 The second bound, could be the high or low bound.
     * @param item The item to check is between the bounds.
     * @param strict If true, the check will not be inclusive of the bounds.
     * @param <T> The type of objects being compared, must implement Comparable.
     * @return True if item is between the bounds, false otherwise.
     */
    public static <T extends Comparable> boolean between(final T bound1,
            final T bound2, final T item, final boolean strict) {
        Comparator<Comparable> order = Comparator.naturalOrder();
        return between(bound1, bound2, item, strict, order);
    }

    /**
     * Checks that the item is between the two bounds.  Uses a custom comparator.
     * If marked as strict it is not an inclusive test,
     * bound1 and bound2 will not return true if passed in as the item.
     *
     * @param bound1 The first bound, could be the high or low bound.
     * @param bound2 The second bound, could be the high or low bound.
     * @param item The item to check is between the bounds.
     * @param strict If true, the check will not be inclusive of the bounds.
     * @param comparator The comparator used to compare the objects in the test.
     * @param <T> The type of objects being compared.
     * @return True if item is between the bounds, false otherwise.
     * @throws NullPointerException If the comparator is null.
     */
    public static <T> boolean between(final T bound1, final T bound2,
            final T item, final boolean strict,
            final Comparator<T> comparator) {

        T low = comparator.compare(bound1, bound2) < 0 ? bound1 : bound2;
        T high = low == bound1 ? bound2 : bound1;

        return (!strict && (comparator.compare(bound1, item) == 0 || comparator
                .compare(bound2, item) == 0))
                || comparator.compare(low, item) < 0
                && comparator.compare(item, high) < 0;
    }
}
