import java.util.Scanner;

public class CalculateDeposit {
    private final double YEAR_RATE = 0.06;
    private final int MONTH_COUNT = 12;
    private final int DEFAULT_PLACES = 2;

    double calculateComplexPercent(double amount, int period) {
        double pay = amount * Math.pow((1 + YEAR_RATE / MONTH_COUNT), MONTH_COUNT * period);
        return round(pay, DEFAULT_PLACES);
    }

    double calculateSimplePercent(double amount, int period) {
         return round(amount + amount * YEAR_RATE * period, DEFAULT_PLACES);
    }

    double round(double value, int places) {
       double scaLe= Math.pow(10, places);
       return Math.round(value * scaLe) / scaLe;
    }

    void doImportantJob( )
    {
        int period;
        int action;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt( );

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();

        double value = 0;
        if (action == 1) {
            value = calculateSimplePercent(amount, period);
        }
        else if (action == 2) {
            value = calculateComplexPercent(amount, period);
        }

        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + value);
    }

    public static void main(String[] args) {
        new CalculateDeposit().doImportantJob();
    }

}