public class StepTracker {
    int[] steps;
    int goalSteps;

    StepTracker() {
        steps = new int[360];
        goalSteps = 10000;
    }

    void saveSteps(int month, int day, int stepsQuantity) {
        if (stepsQuantity >= 0) {
            steps[month * 30 + day - 1] = stepsQuantity;
            System.out.println("Готово! В " + day + "-й день " + month
                    + "-го месяца вы " + "сделали " + stepsQuantity + " шагов");
        } else {
            System.out.println("Шагов не может быть меньше нуля! Попробуйте снова");
        }
    }

    void getStatistics(int month, Converter converter) {
        for (int i = 0; i < 29; i++) {
            System.out.print((i + 1) + " день: " + steps[month * 30 + i] + ", ");
        }
        System.out.println("30 день: " + steps[month * 30 + 29]);
        System.out.println("Всего вы сделали " + findSum(month) + " шагов за "
                + month + "-й месяц. Так держать!");
        System.out.println("Наибольшее количество шагов за месяц - "
                + findMax(month));
        System.out.println("В среднем вы проходили " + (int) (findSum(month) / 30)
                + " шагов в день");
        System.out.println("Пройденная дистанция за месяц - "
                + converter.convert(findSum(month), 1) + " км");
        System.out.println("Было сожжено " + converter.convert(findSum(month), 2)
                + " килокалорий");
        System.out.println("Лучшая серия - " + bestSeries(month) + " дней.");
    }

    int bestSeries(int month) {
        int best = 0, localBest = 0;
        for (int i = 0; i < 30; i++) {
            if (steps[month * 30 + i] >= goalSteps) {
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
        for (int i = 0; i < 30; i++) {
            if (max < steps[month * 30 + i]) {
                max = steps[month * 30 + i];
            }
        }
        return max;
    }

    int findSum(int month) {
        int sum = 0;
        for (int i = 0; i < 30; i++) {
            sum += steps[month * 30 + i];
        }
        return sum;
    }

    void setGoalSteps(int steps) {
        goalSteps = steps;
        System.out.println("Готово! Теперь ваша цель - " + goalSteps
                + " шагов в день");
    }

}
