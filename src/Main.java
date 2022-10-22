import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StepTrack stepTrack = new StepTrack();
        Converter converter = new Converter();

        while (true) {
            printMenu();
            // запуск меню
            int command = scanner.nextInt();  // выбор пользователя
            if (command == 1) { // Внесенние данных
                int month = stepTrack.inputAndCheckMonth(); // подсчет месяцев
                int day = stepTrack.inputAndCheckDay(); // подсчет дней
                String normMonth = stepTrack.getMonthName(month); // назване месяцев
                int steps = stepTrack.inputAndCheckSteps(month, day); // подсчет шагов
                stepTrack.monthDaySteps(month, day, steps, normMonth); // привязка месяца-дня-шагов
            } else if (command == 2) {
                System.out.println("За какой месяц Вы хотите внести данные: 0 - Январь, 1 - Февраль, 2 - Март, 3 - Апрель, 4 - Май, 5 - Июнь, 6 - Июль, 7 - Август, 8 - Сентябрь, 9 - Октябрь, 10 - Ноябрь, 11 - Декабрь?");
                int userMonth = scanner.nextInt();
                if (userMonth < 0 | userMonth > 11) {
                    System.out.println("Введен некорректный номер месяца");
                } else {
                    String normMonth = stepTrack.getMonthName(userMonth);
                    System.out.println("Количество пройденных шагов по дням за " + normMonth + ": ");
                    stepTrack.printMonthSteps(userMonth);
                    System.out.println("Общее количество пройденных шагов за " + normMonth + " = " + stepTrack.getStepsCount(userMonth) + " шагов.");
                    System.out.println("Максимальное пройденное кол-во шагов за " + normMonth + " = " + stepTrack.saveMaxStep(userMonth) + " шагов.");
                    System.out.println("Среднее количесвово шагов пройденных за " + normMonth + " = " + stepTrack.averageOfSteps(userMonth) + " шагов.");
                    System.out.println("Пройденная дистанция за " + normMonth + " = " + converter.distance(stepTrack. getStepsCount(userMonth)) + " км.");
                    System.out.println("Количество сожжённых калорий за " + normMonth + " = " + converter.burnCals(stepTrack. getStepsCount(userMonth)) + " ккал.");
                    System.out.println("Лучшая серия: максимальное количество идущих подряд дней с количеством шагов выше целевого = "+ stepTrack.bestSeriesSteps(userMonth));
                }
            } else if (command == 3) {    // Изменение количетсва шагов в день
                stepTrack.newPurposeSteps();
            } else if (command == 0) {    // Выход
                System.out.println("Выход");
                break;
            } else {
                System.out.println("Извините, такой команды пока нет.");
            }

        }
    }

    public static void printMenu () {    // Вызов меню
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Выйти из приложения");
    }

}
