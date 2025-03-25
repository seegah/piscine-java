public class DoOp {
    public static String operate(String[] args) {
        if (args.length != 3 || args[1].length() != 1) {
            return "Error";
        }

        if (!isNumeric(args[0]) || !isNumeric(args[2])) {
            return "Error";
        }

        int num1 = Integer.parseInt(args[0]);
        int num2 = Integer.parseInt(args[2]);
        char operator = args[1].charAt(0); // Extraire l'opérateur sous forme de char

        switch (operator) {
            case '+':
                return String.valueOf(num1 + num2);
            case '-':
                return String.valueOf(num1 - num2);
            case '*':
                return String.valueOf(num1 * num2);
            case '/':
                return (num2 == 0) ? "Error" : String.valueOf(num1 / num2);
            case '%':
                return (num2 == 0) ? "Error" : String.valueOf(num1 % num2);
            default:
                return "Error";
        }
        
    }

    public static boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c) && (c != '-' || str.length() == 1)) {
                return false;
            }
        }
        return true;
    }
}
