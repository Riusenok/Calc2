import java.util.Scanner;

public class Calc2 {
    public static void main(String[] args) {
        System.out.println("Введи, что нужно посчитать, например: 2 + 7");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        try {
            String result = Main.calc(input);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    class Main{
        public static String calc(String input) throws Exception {
            String[] m = (input.trim()).split("\\s+");
            int a, b;
            String result;

            if (m.length < 3) {
                throw new Exception("Строка не является математической операцией");
            }

            if (m.length > 3) {
                throw new Exception("Не выполнено условие: два операнда и один оператор");
            }

            a = Integer.parseInt(m[0]);
            b = Integer.parseInt(m[2]);

            if (a > 10 || b > 10 || a < 1 || b < 1) {
                throw new Exception("Данный калькулятор принимает числа от 1 до 10");
            }

            switch (m[1]) {
                case "+":
                    result = String.format("%d", a + b);
                    break;
                case "-":
                    result = String.format("%d", a - b);
                    break;
                case "*":
                    result = String.format("%d", a * b);
                    break;
                case "/":
                    result = String.format("%d", a / b);
                    break;
                default:
                    throw new Exception("Данный калькулятор не умеет вычислять эту операцию");
            }

            return result;
        }
    }

}
