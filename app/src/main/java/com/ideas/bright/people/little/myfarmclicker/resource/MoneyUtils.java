package com.ideas.bright.people.little.myfarmclicker.resource;

import org.apache.commons.lang3.StringUtils;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;

public class MoneyUtils {

    static private NumberFormat formatter = new DecimalFormat("#,###.00");
    static private NumberFormat integerFormatter = new DecimalFormat("0");

    static final private String[] LARGE_NUMBERS = new String[]{"", "", "M", "B", "T", "q", "Q", "s", "S", "O", "N", "D", "UD", "DD", "TD", "qD", "QD", "sD", "SD", "OD", "ND", "V"};

    static public String toString(double value)
    {
        return toString(value, formatter);
    }

    static public String toString(double value, NumberFormat formatter)
    {
        String valueAsString = integerFormatter.format(value);
        int numberOfNumbers = valueAsString.length();

        if(numberOfNumbers > 6)
        {
            int multiplier = (numberOfNumbers - 1) / 3;
            int numberOfNumbersToRemove = 3 * (multiplier - 1);
            int midIndex = numberOfNumbers - 3 * multiplier;
            String firstThree = StringUtils.substring(valueAsString, 0, midIndex);
            String lastThree = StringUtils.substring(valueAsString, midIndex, midIndex + 3);

            return firstThree + "." + lastThree + LARGE_NUMBERS[multiplier];
        } else {
            return formatter.format(value);
        }
    }

    static public double toDouble(String value)
    {
        String lastChar = value.substring(value.length() - 1);
        List<String> largeNumbers = Arrays.asList(LARGE_NUMBERS);
        if(largeNumbers.contains(lastChar))
        {
            String number = value.substring(0, value.length() - 1);

            return Double.parseDouble(number) * Math.pow(1000, largeNumbers.indexOf(lastChar));
        } else {
            lastChar = value.substring(value.length() - 2);
            if(largeNumbers.contains(lastChar))
            {
                String number = value.substring(0, value.length() - 2);
                return Double.parseDouble(number) * Math.pow(1000, largeNumbers.indexOf(lastChar));
            }
        }
        return 0;
    }
}
