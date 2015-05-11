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
     *
     * @param real Number to approximate to.
     * @param min  Minimum value of the product of the numerator and determinant of the division.
     * @param max  Maximum value of the product of the numerator and determinant of the division.
     * @return The denominator of an approximation of real as a fraction. The product of the numerator and determinant will be greater than min.
     */
    public static int diophantineApproximation(double real, int min, int max) {
        double number = real;
        Fraction fraction = new Fraction(1);
        List<Integer> succession = new LinkedList<Integer>();
        while (fraction.getNumerator() * fraction.getDenominator() < min && fraction.doubleValue() != real) {
            int current = (int) number;
            number = 1 / (number - current);
            succession.add(current);
            fraction = fractionResult(succession);
        }
        if (fraction.getNumerator() * fraction.getDenominator() < min) {
            int relation = min / (fraction.getNumerator() * fraction.getDenominator()) + 1;
            fraction = new Fraction(1, fraction.getDenominator() * relation);
        }
        int quantity=fraction.getDenominator();
        int i=1;
        while(quantity*fraction.getNumerator()/i > max){
            quantity = fraction.getDenominator()/i;
            i++;

        }
        return quantity;
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
            Integer num = iterator.previous();
            if (iterator.hasPrevious() && !(fraction.equals(Fraction.ZERO) && num == 0))
                fraction = fraction.add(num).reciprocal();
        }
        if (iterator.hasPrevious()) fraction = fraction.add(iterator.previous());
        return fraction;
    }

    public static int GCD(int a, int b) {
        return b == 0 ? a : GCD(b, a % b);
    }
}
