    package com.company;

    import java.util.regex.Matcher;
    import java.util.regex.Pattern;

    /**
     * Class contains method and constants to check the expression for errors.
     */
    public class ValidatorImpl implements Validator {
        /** dot or mathematical symbols(+ ,- ,/ ,*) are at the beginning of the expression */
        public static final String ERROR_AT_THE_BEGINNING = "^[+\\-/*.]";
        /** two or more consecutive characters (dot,+ ,- ,/ ,*) are in the expression */
        public static final String ERROR_DOUBLED_SYMBOLS = "[.+\\-*/]{2,10}";
        /** two or more dots are in a number in the expression */
        public static final String ERROR_EXTRA_POINTS = "\\.?\\d+\\.+\\d+\\.";
        /** expression contains letters and another not allowed symbol like parenthesis, square braces, @, !, %, and ect. */
        public static final String ERROR_EXTRA_CHAR = "[^\\d./+\\-*]";
        /** dot or mathematical symbols(dot,+ ,- ,/ ,*) in the end of the expression */
        public static final String ERROR_IN_THE_END = "[+\\-/*.]$";

        /**
         * Method check given string for errors
         * which will not allow you to convert the string to the reverse Polish notation.
         * In fact, it checks the user's errors in the mathematical expression.
         * @param line that will check on the errors.
         * @return true if expression doesn't contain errors:
         */
        public boolean validate(String line){
            StringBuilder sb = new StringBuilder();
            Pattern errors = Pattern.compile(ERROR_AT_THE_BEGINNING + "|" + ERROR_DOUBLED_SYMBOLS
                    + "|" + ERROR_EXTRA_POINTS + "|" + ERROR_EXTRA_CHAR + "|" + ERROR_IN_THE_END);
            Matcher e = errors.matcher(line);
            while (e.find()){
                sb.append("[").append(line, e.start(), e.end()).append("]").append(" ");
            }
            if( !sb.toString().isEmpty()){
                throw new IllegalArgumentException("Invalid symbols " +  sb + " " +
                        "\nAllowed only +, -, ., *, / (not twice dots, for example) and digits from 0 to 9. " +
                        "\nYou made a mistake in the expression!");
            }
            return true;
        }

    }

