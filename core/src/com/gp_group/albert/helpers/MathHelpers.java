package com.gp_group.albert.helpers;

/**
 * @author bluesialia
 *         Date: 18/02/15
 */
public class MathHelpers {

    /**
     * Calculates the great common divisor for a and b.
     *
     * @param a
     * @param b
     * @return
     */
    public static int GCD(int a, int b) {
        return b == 0 ? a : GCD(b, a % b);
    }
}
