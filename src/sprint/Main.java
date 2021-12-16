package sprint;

import java.util.Scanner;

public class Main {


    static String[] months = {"Январь","Февраль","Март","Апрель","Май","Июнь","Июль","Август","Сентябрь",
            "Октябрь","Ноябрь","Декабрь"};
    public static void main(String[] args) {

        int targetNumberOfSteps = 10000;
        System.out.println("Вас приветствует трекер шагов!");
        System.out.println();

        StepTracker stepTracker = new StepTracker(months);
        Converter converter = new Converter();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ваша суточная норма - " + targetNumberOfSteps + " шагов, ");
        System.out.println("или - " + converter.convertStep(targetNumberOfSteps) + " метров,");
        System.out.println("и " + converter.convertCall(targetNumberOfSteps) + " сожженных калорий!");
        System.out.println();

        while (true) {
            printMenu();
            int command = scanner.nextInt();
            if (command == 1) {
                System.out.println("Выберите, за какой месяц вы хотите ввести данные: ");
                for (int month = 0; month < months.length; month++) {
                    System.out.println((month + 1) + " - " + months[month]);
                }

                int monthNumber = scanner.nextInt();
                String month = months[monthNumber - 1];

                System.out.println("Укажите день месяца "
                        + month + " за который вы хотите ввести шаги.") ;
                System.out.println("Введите от 1 до 30: ");
                int day = scanner.nextInt();

                System.out.println("Введите количество пройденных шагов за "
                        + day + " день месяца "
                        + month + ":");
                int step = scanner.nextInt();

                System.out.println("Вы прошли - " + step + " шагов, или "
                        + converter.convertStep(step) + " метров, сожгли при этом - "
                        + converter.convertCall(step) + " килокаллорий!");
                stepTracker.addSteps(month, day, step);

            } else if (command == 2) {
                System.out.println("За какой месяц вы хотите узнать статистику?");
                for (int month = 0; month < months.length; month++) {
                    System.out.println((month + 1) + " - " + months[month]);
                }
                int monthNumber = scanner.nextInt();
                String month = months[monthNumber - 1];
                scanner.close();
                stepTracker.printAllSteps(month);
                stepTracker.numberOfStepsPerMonth(month);
                stepTracker.maximumNumberOfStepsPerMonth(month);
                stepTracker.averageNumberOfStepsPerMonth(month);
                stepTracker.distanceCovered(month);
                stepTracker.caloriesBurned(month);
                stepTracker.bestStreakOfTheMonth(month,targetNumberOfSteps);

            } else if (command == 3) {
                System.out.println("Вы можете изменить цель по количеству шагов в день.");
                targetNumberOfSteps = stepTracker.newTargetNumberOfSteps();
                System.out.println("Целевое количество шагов за день изменено.");
                System.out.println("Ваше новое количество шагов за день - " + targetNumberOfSteps + ".");
            } else if (command == 4) {
                System.out.println("До свидания!");
                break;
            } else {
                System.out.println("Нет такой команды!");
            }
        }
    }
    public static void printMenu() {
        System.out.println("Пожалуйста, выберете действие...");
        System.out.println();
        System.out.println("1 - Ввести количество шагов за определенный день.");
        System.out.println("2 - Напечатать статистику за определенный месяц.");
        System.out.println("3 - Изменить цель по количеству шагов в день.");
        System.out.println("4 - Выйти из приложения");
    }
}
