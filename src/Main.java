import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int daysIntoMonth = 30;
        Scanner scanner = new Scanner(System.in);
        Converter converter = new Converter(0.00075,0.05);
        StepTracker tracker = new StepTracker(daysIntoMonth);

        while (true) {
            printMenu();
            int command = scanner.nextInt();

            if (command == 1) {
                System.out.println("За какой месяц вы хотите внести правку? " +
                        "(нумерация месяцев идёт с нуля)");
                int month = scanner.nextInt();
                if (month < 0 || month > 11) {
                    System.out.println("Месяц введён некорректно");
                    continue;
                }
                System.out.println("За какой день? (нумерация стандартная)");
                int day = scanner.nextInt();
                if (day < 1 || day > daysIntoMonth) {
                    System.out.println("День введён некорректно");
                    continue;
                }
                System.out.println("Количество шагов:");
                int steps = scanner.nextInt();
                if (steps < 0) {
                    System.out.println("Количество шагов введено некорректно");
                    continue;
                }
                tracker.saveSteps(month, day, steps);
            } else if (command == 2) {
                System.out.println("За какой месяц хотите получить статистику? " +
                        "(нумерация месяцев идёт с нуля)");
                int month = scanner.nextInt();
                if (month < 0 || month > 11) {
                    System.out.println("Месяц введён некорректно");
                    continue;
                }
                tracker.getStatistics(month, converter);
            } else if (command == 3) {
                System.out.println("Какая теперь цель по шагам?");
                int steps = scanner.nextInt();
                if (steps < 0) {
                    System.out.println("Количество шагов введено некорректно");
                    continue;
                }
                tracker.setGoalSteps(steps);
            } else if (command == 0) {
                System.out.println("Выход");
                break;
            } else {
                System.out.println("Извините, такой команды пока нет.");
            }
        }
    }

    public static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Ввести количество шагов");
        System.out.println("2 - Посмотреть статистику");
        System.out.println("3 - Поставить новую цель!");
        System.out.println("0 - Выход");
    }
}