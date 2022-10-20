import java.util.Scanner;
public class StepTrack {

    Scanner scanner = new Scanner(System.in);
    int stepsByDay = 10000;
    int monthData[][] = new int[12][31];
    int sumOfSteps = 0;




   ////////////////////////////////
    int userMonth() { //ввод месяца
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
    public void stepsNumber(int month) {
        for (int i = 1; i < monthData[month].length; i++) {
            System.out.println((i) + "-ый день: " + monthData[month][i] + ",");
        }
    }
// Сумма шагов
    public int SumOfSteps(int userMonth) {
        sumOfSteps = 0;
        for (int i = 0; i < monthData[userMonth].length; i++) {
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
        double avengerSumSteps = sumOfSteps / (monthData[userMonth].length - 1);
        return avengerSumSteps;
    }

// максимальная серия
    public int bestSeriesSteps(int userMonth)  {
        int seriesSteps = 0;
        int maxSeriesSteps = 0;
        for (int i = 1; i < monthData[userMonth].length; i++){
            if (monthData[userMonth][i] >= stepsByDay){
                seriesSteps ++;
            }
        }
        if (seriesSteps > maxSeriesSteps) {
            maxSeriesSteps = seriesSteps;
            seriesSteps = 0;
        }
        return maxSeriesSteps;
    }


////////// ввод количества дней
   public  int userDay() {
        while (true) {
            System.out.println("За какой день Вы хотите внести данные: 1-30? ");
            int userDay = scanner.nextInt();
            if (userDay >= 1 && userDay <= 30) {
                return userDay;
            } else {
                System.out.println("Неверный ввод. Введите число от 1 - 30");
            }
        }
    }
// данные по шагам
   public int userSteps(int month, int day, String normMonth) {
        while (true) {
            System.out.println("Количество пройденных шагов:");
            int userSteps = scanner.nextInt();
            if (userSteps > 0) {
                System.out.println("Данные внесены!");
                System.out.println(userSteps + " шагов - было записано в " + day + "-ый день за " + normMonth + "!");
                return userSteps;
            } else {
                System.out.println("Введите положительное, целое число");
            }
        }
    }
// привязка шагов
    public void monthDaySteps(int userMonth, int userDay, int userSteps) {

            monthData[userMonth][userDay] = userSteps;
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



    public String normMonth(int userMonth) {   //имена месяцев для вывода для красоты

        if (userMonth == 0) {
            String normMonth = "Январь";
            return normMonth;
        } else if (userMonth == 1) {
            String normMonth = "Февраль";
            return normMonth;
        } else if (userMonth == 2) {
            String normMonth = "Март";
            return normMonth;
        } else if (userMonth == 3) {
            String normMonth = "Апрель";
            return normMonth;
        } else if (userMonth == 4) {
            String normMonth = "Май";
            return normMonth;
        } else if (userMonth == 5) {
            String normMonth = "Июнь";
            return normMonth;
        } else if (userMonth == 6) {
            String normMonth = "Июль";
            return normMonth;
        } else if (userMonth == 7) {
            String normMonth = "Август";
            return normMonth;
        } else if (userMonth == 8) {
            String normMonth = "Сентябрь";
            return normMonth;
        } else if (userMonth == 9) {
            String normMonth = "Окябрь";
            return normMonth;
        } else if (userMonth == 10) {
            String normMonth = "Ноябрь";
            return normMonth;
        } else if (userMonth == 11) {
            String normMonth = "Декабрь";
            return normMonth;
        }
        return null;
    }


}

