import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scanner);
        System.out.println("Добро пожаловать в наше приложение!");
        printMenu(); //печать меню
        int userInput = scanner.nextInt(); //ввод нужной команды пользователем

        while (userInput != 0) { // обработка разных случаев
            if (userInput == 1) { //количество шагов за определенный день
                stepTracker.meaning();
            } else if (userInput == 2) { // статистика шагов
                stepTracker.statistics();
            } else if (userInput == 3) { // изменение цели по количеству шагов
                stepTracker.goalSteps();
            } else {
                System.out.println("Неверный ввод, повторите попытку.");
            }
            printMenu(); // печатаем меню ещё раз перед завершением предыдущего действия
            userInput = scanner.nextInt(); // повторное считывание данных от пользователя
        }
        System.out.println("Программа завершена");
    }

    private static void printMenu() {
        System.out.println("Выберите необходимое действие:");
        System.out.println("1- Ввод количества шагов за определенный день");
        System.out.println("2- Статистика за определенный месяц");
        System.out.println("3- Изменение цели по количеству шагов в день");
        System.out.println("0- Выход из приложения");
    }
}


