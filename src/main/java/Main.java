import static java.lang.System.*;

public class Main {
    int result = 0;

    public static void main(String[] args) {
        out.println("Передайте в метод checkYear год в формате: 'yyyy' и количество дней в формате: 'n'");

        Main main = new Main();
        out.println(main.checkYear(2022, 365));
        out.println(main.checkYear(2022, 366));
        out.println(main.checkYear(2022, 367));

    }

    boolean checkYear(int year, int days) {
        int checkDaysOfYear = daysOfYear(year);
        return checkDaysOfYear == days;
    }

    public static int daysOfYear(int year) {
        int daysOfYear = (year % 4 == 0 && !(year % 100 == 0)) ? 366 : 365;
        return daysOfYear;
    }
}
