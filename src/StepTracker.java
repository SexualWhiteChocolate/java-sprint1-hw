import java.text.DecimalFormat;

public class StepTracker {
    int[] steps;
    int goalSteps;
    int daysIntoMonth;

    StepTracker(int days) {
        steps = new int[360];
        goalSteps = 10000;
        daysIntoMonth = days;
    }

    void saveSteps(int month, int day, int stepsQuantity) {
        steps[month * daysIntoMonth + day - 1] = stepsQuantity;
        System.out.println("Готово! В " + day + "-й день " + month
                + "-го месяца вы " + "сделали " + stepsQuantity + " шагов");
    }

    void getStatistics(int month, Converter converter) {
        for (int i = 0; i < daysIntoMonth - 1; i++) {
            System.out.print((i + 1) + " день: " + steps[month * daysIntoMonth + i] + ", ");
        }
        System.out.println(daysIntoMonth + " день: " + steps[month * (daysIntoMonth + 1) - 1]);
        System.out.println("Всего вы сделали " + findSum(month) + " шагов за "
                + month + "-й месяц. Так держать!");
        System.out.println("Наибольшее количество шагов за месяц - "
                + findMax(month));
        System.out.println("В среднем вы проходили " + (int) (findSum(month) / daysIntoMonth)
                + " шагов в день");
        System.out.println("Пройденная дистанция за месяц - "
                + new DecimalFormat( "#.0" ).format(converter.convertKm(findSum(month)))
                + " км");
        System.out.println("Было сожжено " +
                new DecimalFormat( "#.0" ).format(converter.convertCalories(findSum(month)))
                + " килокалорий");
        System.out.println("Лучшая серия - " + bestSeries(month) + " дней.");
    }

    int bestSeries(int month) {
        int best = 0, localBest = 0;
        for (int i = 0; i < daysIntoMonth; i++) {
            if (steps[month * daysIntoMonth + i] >= goalSteps) {
                localBest++;
                if (best < localBest) {
                    best = localBest;
                }
            } else {
                localBest = 0;
            }
        }
        return best;
    }

    int findMax(int month) {
        int max = 0;
        for (int i = 0; i < daysIntoMonth; i++) {
            if (max < steps[month * daysIntoMonth + i]) {
                max = steps[month * daysIntoMonth + i];
            }
        }
        return max;
    }

    int findSum(int month) {
        int sum = 0;
        for (int i = 0; i < daysIntoMonth; i++) {
            sum += steps[month * daysIntoMonth + i];
        }
        return sum;
    }

    void setGoalSteps(int steps) {
        goalSteps = steps;
        System.out.println("Готово! Теперь ваша цель - " + goalSteps
                + " шагов в день");
    }

}
