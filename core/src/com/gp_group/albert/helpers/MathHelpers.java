package com.gp_group.albert.helpers;

import org.apache.commons.math3.fraction.Fraction;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * @author bluesialia
 *         Date: 18/02/15
 */
public class MathHelpers {

    /**
     * Calculates an approximation of the given number as a division of two integers with the Diophantine Approximation.
     * @param real Number to approximate to.
     * @param min Minimum value of the product of the numerator and determinant of the division.
     * @param max Maximum value of the product of the numerator and determinant of the division.
     * @return An approximation of real as a fraction. The product of the numerator and determinant will be greater than min.
     */
    public static Fraction diophantineApproximation(double real, int min, int max) {
        double number = real;
        Fraction fraction = new Fraction(1);
        List<Integer> succession = new LinkedList<Integer>();
        while (fraction.getNumerator() * fraction.getDenominator() < min) {
            int current = (int) number;
            number = 1 / (number - (int) number);
            succession.add(current);
            fraction = fractionResult(succession);
        }
        if (fraction.getNumerator() * fraction.getDenominator() > max) {
            succession.remove(succession.size());
            fraction = fractionResult(succession);
            fraction = fraction.add(new Fraction(1, fraction.getDenominator() * 2));
        }
        return fraction;
    }

    /**
     * Calculates the Diophantine Approximation obtained from the succession of integers.
     *
     * @param succession The first terms of a continuous fraction.
     * @return The fraction correspondent to the Diophantine Approximation
     */
    private static Fraction fractionResult(List<Integer> succession) {
        Fraction fraction = new Fraction(0);
        ListIterator<Integer> iterator = succession.listIterator(succession.size());
        while (iterator.hasPrevious()) {
            fraction = fraction.add(iterator.previous()).reciprocal();
        }
        return fraction;
    }
}
