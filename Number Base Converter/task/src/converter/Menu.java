package converter;

import java.util.Scanner;

class Menu {
    public static void start() {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
        boolean isConvert = true;
        int source = 0;
        int target = 0;

        while (isRunning) {
            System.out.print("Enter two numbers in format: {source base} {target base} (To quit type /exit) ");
            isConvert = true;
            String command = scanner.nextLine();
            if (command.equals("/exit")) {
                isRunning = false;
                break;
            } else {
                String[] input = command.split(" ");
                source = Integer.valueOf(input[0]);
                target = Integer.valueOf(input[1]);
            }
            while (isConvert) {
                System.out.print("Enter number in base " + source + " to convert to base " + target + " (To go back type /back) ");
                String digit = scanner.nextLine();
                if (digit.equals("/back")) {
                    isConvert = false;
                } else {
                    System.out.println("Conversion result: " + BaseConverter.converter(digit, source, target));
                }
            }
        }
    }
}
