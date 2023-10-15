package br.com.erudio.converters;

public class NumberConverter {
    public static Double convertToDouble(String number) {
        if (number == null) return 0D;
        String tempNumber = number.replaceAll(",", ".");
        if (isNumeric(tempNumber)) return Double.parseDouble(tempNumber);
        return 0D;
    }

    public static boolean isNumeric(String number) {
        if (number == null) return false;
        String tempNumber = number.replaceAll(",", ".");
        return tempNumber.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
