import java.util.Scanner;

public class StepTracker {
    Scanner scanner = new Scanner(System.in);
    Converter converter = new Converter();
    int[][] monthToData;
    int goalSteps = 10000;

    public StepTracker(Scanner scanner) {
        monthToData = new int[12][30];
    }

    public int goalSteps() { // третий пункт из main
        System.out.println("Введите новую цель шагов на день.");
        int newSteps = scanner.nextInt();
        if (newSteps < 0) {
            System.out.println("Введите верное положительное значение.");
        } else {
            goalSteps = newSteps;
            System.out.println("Ваша новая цель: " + goalSteps + " шагов в день"); // измененная цель шагов
        }
        return goalSteps; //возвращаем значение
    }

    public void meaning() { // первый пункт из main
        System.out.println("За какой месяц хотите ввести шаги: 0- январь, 1- февраль ... 11-декабрь?");
        int month = scanner.nextInt(); //ввод месяца
        if (month > 11 || month < 0) { //неверный ввод
            System.out.println("Неверный ввод. Выбранный месяц должен быть от 0 до 11.");
        } else {
            System.out.println("За какой день хотите ввести шаги: 0- первый день месяца, 1- второй ..." +
                    "29- тридцатый?");
            int day = scanner.nextInt();// ввод дня
            if (day > 29 || day < 0) { //неверный ввод
                System.out.println("Неверный ввод. Выбранный день должен быть от 0 до 29.");
            } else {
                System.out.println("Введите количество шагов в этот день.");
                int steps = scanner.nextInt(); //ввод шагов за определенный день
                if (steps < 0) { //неверный ввод
                    System.out.println("Неверный ввод. Количество шагов должно быть больше 0");
                } else {
                    monthToData[month][day] = steps;
                }
            }
        }
    }


    public void statistics() { // второй пункт из main
        System.out.println("За какой месяц хотите узнать статистику: 0- январь, 1- февраль ... 11-декабрь?");
        int totalSteps = 0; //общее количество шагов
        int maxSteps = 0; // максимум шагов за мес
        int middleSteps = 0; //среднее количество шагов в месяц
        int bestResult = 0; // лучшая серия за месяц
        int series = 0;
        int month = scanner.nextInt(); // ввод месяца
        if (month > 11 || month < 0) { //неверный ввод
            System.out.println("Неверный ввод. Повторите попытку, выбрав нужный месяц от 0 до 11.");
            month = scanner.nextInt();
        } else {
            for (int i = 0; i < monthToData[month].length; i++) {
                System.out.println((i + 1) + " День: " + monthToData[month][i] + ". ");
                totalSteps = totalSteps + monthToData[month][i]; //общее количество шагов
                if (monthToData[month][i] > maxSteps) {
                    maxSteps = monthToData[month][i]; // максимум шагов за месяц
                }
                middleSteps = totalSteps / monthToData[month].length; //среднее количество шагов за месяц
                if (monthToData[month][i] >= goalSteps) {
                    series++;
                    if (series > bestResult) {
                        bestResult = series;
                    }
                } else {
                    series = 0;
                }
            }

            System.out.println("Общее количество пройденных шагов в месяц: " + totalSteps);
            System.out.println("Максимальное количество пройденных шагов в месяц: " + maxSteps);
            System.out.println("Среднее количество пройденных шагов за месяц: " + middleSteps);
            System.out.println("Пройденная дистанция в километрах: " + converter.getDistance(totalSteps));
            System.out.println("Количество израсходованных килокаллорий: " + converter.getCalories(totalSteps));
            System.out.println("Лучшая серия дней в месяце: " + bestResult);
        }
    }
}


