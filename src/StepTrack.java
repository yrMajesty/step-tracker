import java.util.Scanner;
public class StepTrack {

    Scanner scanner = new Scanner(System.in);
    int stepsByDay = 10000;
    int monthData[][] = new int[12][30];

    String[] monthName = {"Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"};
//или последний метод заменить на это с выводом массива - понял.


    ////////////////////////////////
    int inputAndCheckMonth() { //ввод месяца
        while (true) {
            System.out.println("Введите данные:");
            System.out.println("За какой месяц Вы хотите внести данные: 0 - Январь, 1 - Февраль, 2 - Март, 3 - Апрель, 4 - Май, 5 - Июнь, 6 - Июль, 7 - Август, 8 - Сентябрь, 9 - Октябрь, 10 - Ноябрь, 11 - Декабрь?");
            int userMonth = scanner.nextInt();
            if (userMonth >= 0 && userMonth <= 11) {
                return userMonth;
            } else {
                System.out.println("Неверный ввод. Введите число от 1 - 11");
            }
        }
    }

    // количесво шагов по дням
    public void printMonthSteps(int month) {
        for (int i = 0; i < monthData[month].length; i++) {
            System.out.println((i + 1) + "-ый день: " + monthData[month][i] + ","); // добавил +1 для вывода 1-30 дней
        }
    }
    // Сумма шагов
    public int getStepsCount(int userMonth) { // не заметил большой регистр в название месяца, случайно написал =(
        int sumOfSteps = 0;
        for (int i =0; i < monthData[userMonth].length; i++) {
            sumOfSteps = sumOfSteps + monthData[userMonth][i];

        }
        return sumOfSteps;
    }
    // максмальные шаги
    public int saveMaxStep(int userMonth) { // максимум пройденно шагов
        int maxSteps = 0;
        for (int i = 0; i < monthData[userMonth].length; i++) {
            if (monthData[userMonth][i] > maxSteps) {
                maxSteps = monthData[userMonth][i];
            }
        }
        return maxSteps;
    }

    // среднее количесво шагов

    public double averageOfSteps(int userMonth)  {
        int saveSteps = getStepsCount(userMonth);
        double avengerSumSteps = saveSteps / monthData[userMonth].length; //
        return avengerSumSteps;
    }

    // максимальная серия
    //Сейчас подсчитывается сколько всего дней было шагов больше чем цель,
    // а надо чтобы было сколько дней подряд шагов больше чем цель
    public int bestSeriesSteps(int userMonth)  {
        int seriesSteps = 0;
        int maxSeriesSteps = 0;
        for (int i = 0; i < monthData[userMonth].length; i++){
            if (monthData[userMonth][i] >= stepsByDay) {
                seriesSteps++;
                if (seriesSteps > maxSeriesSteps) {
                    maxSeriesSteps = seriesSteps;
                }
            } else {
                seriesSteps = 0;
            }
        }

        return maxSeriesSteps;
    }


    // Изменене целевых шагов
    void newPurposeSteps() {
        while (true) {
            System.out.println("Введите новое целевое количество шагов в день:");
            int newSteps = scanner.nextInt();
            if (newSteps > 0) {
                stepsByDay = newSteps;
                System.out.println("Целевое количество шагов в день изменено на: " + stepsByDay);
                return;
            } else {
                System.out.println("Введите положительное, целое число");
            }
        }
    }

    ////////// ввод количества дней
    public  int inputAndCheckDay() {
        while (true) {
            System.out.println("За какой день Вы хотите внести данные: 1-30? ");
            int userDay = scanner.nextInt();
            userDay = userDay - 1;
            if (userDay >= 0 && userDay < 30) {
                return userDay ;
            } else {
                System.out.println("Неверный ввод. Введите число от 1 - 30");
            }
        }
    }
    // данные по шагам
    public int inputAndCheckSteps(int month, int day) {
        while (true) {
            System.out.println("Количество пройденных шагов:");
            int userSteps = scanner.nextInt();
            if (userSteps > 0) {
                System.out.println("Данные внесены!");

                return userSteps;
            } else {
                System.out.println("Введите положительное, целое число");
            }
        }
    }
    // привязка шагов
    public void monthDaySteps(int userMonth, int userDay, int userSteps, String normMonth) {

        monthData[userMonth][userDay] = userSteps;
        System.out.println(userSteps + " шагов - было записано в " + userDay + "-ый день за " + monthName[userMonth] + "!");
    }






    public String getMonthName(int month) {   //имена месяцев для вывода для красоты

        if (month == 0) {
            return "Январь";
        } else if (month == 1) {
            return "Февраль";
        } else if (month == 2) {
            return "Март";
        } else if (month == 3) {
            return "Апрель";
        } else if (month == 4) {
            return "Май";
        } else if (month == 5) {
            return "Июнь";
        } else if (month == 6) {
            return "Июль";
        } else if (month == 7) {
            return "Август";
        } else if (month== 8) {
            return "Сентябрь";
        } else if (month == 9) {
            return "Окябрь";
        } else if (month == 10) {
            return "Ноябрь";
        } else if (month == 11) {
            return "Декабрь";
        }
        return null;
    }


}