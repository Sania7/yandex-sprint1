package sprint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class StepTracker {

    Scanner scanner = new Scanner(System.in);
    Converter converter = new Converter();
    HashMap<String, ArrayList<Integer>> numberOfSteps;
    ArrayList<Integer> daysInAMonth;
    int[] days = new int[30];

    StepTracker(String[] months) {
        numberOfSteps = new HashMap<>();
        for (String month : months) {
            numberOfSteps.put(month, daysInAMonth);
        }
        daysInAMonth = new ArrayList<>();
        for (int count : days) {
            daysInAMonth.add(count);
        }
    }

    void addSteps(String month, int day, int step) {
        if ((step >= 0) && (day >= 0) && (day <= 30)) {
            daysInAMonth.add((day - 1), step);
            numberOfSteps.put(month, daysInAMonth);
            System.out.println("Ваши данные сохранены!");
        } else {
            System.out.println("Вы ввели неверные данные!");
        }
        System.out.println();
    }

    void printAllSteps(String month) {
            ArrayList<Integer> totalSteps = numberOfSteps.get(month);
            if (totalSteps != null) {
            for (int i = 0; i < totalSteps.size(); i++) {
                System.out.println((i + 1) + " день: " + totalSteps.get(i));
            }
            } else {
                System.out.println("Введите данные!");
            }
    }

    void numberOfStepsPerMonth(String month) {
        ArrayList<Integer> stepsPerMonth = numberOfSteps.get(month);
        int sumStep = 0;
        for (Integer integer : stepsPerMonth) {
            sumStep += integer;
        }
        System.out.println("Общее количество пройденых шагов за месяц " + sumStep + ".");
    }

    void maximumNumberOfStepsPerMonth(String month) {
        ArrayList<Integer> maxStep = numberOfSteps.get(month);
        int maxStepMonth = 0;
        for (Integer max : maxStep) {
            if (max > maxStepMonth) {
                maxStepMonth = max;
            }
        }
        System.out.println("Максимальное количество шагов за "
                + month + " - " + maxStepMonth);
    }
    void averageNumberOfStepsPerMonth(String month) {
        ArrayList<Integer> average = numberOfSteps.get(month);
        int sumStep = 0;
        for (Integer aver : average) {
            sumStep += aver;
        }
        int averageStep = sumStep / average.size();
        System.out.println("Среднее количество шагов за "
                + month + " месяц " + averageStep);
    }

    void distanceCovered(String month) {
        ArrayList<Integer> distance = numberOfSteps.get(month);
        int distanceStep = 0;
        for (Integer integer : distance) {
            distanceStep += integer;
        }
        System.out.println("Пройденная дистанция за "
                + month + " - " + converter.convertStep(distanceStep) + " километров.");
    }
    void caloriesBurned(String month) {
        ArrayList<Integer> calories = numberOfSteps.get(month);
        int cCal = 0;
        for (Integer calory : calories) {
            cCal += calory;
        }
        System.out.println("Сожжено за "
                + month + " - "
                + converter.convertCall(cCal) + " калорий.");
    }

    void bestStreakOfTheMonth(String month, int betterDays) {
        ArrayList<Integer> best = numberOfSteps.get(month);
        ArrayList<Integer> bestList = new ArrayList<>();
        int daySeries = 0;
        for (int i = 0; i < best.size(); i++) {
            if (best.get(i) > betterDays) {
                if (i - (i - 1) == 1) {
                    daySeries++;
                    System.out.println("серия - " + daySeries + " дней.");
                }
            }
            bestList.add(daySeries);
        }
        int bestSeries = 0;
        for (Integer integer : bestList) {
            if (bestSeries < integer) {
                bestSeries = integer;
            }
        }
        System.out.println("Лучшая серия - " + bestSeries + " дней.");
    }

    int newTargetNumberOfSteps() {
        System.out.println("Введите новые данные!");
        return scanner.nextInt();
    }

}