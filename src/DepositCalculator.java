import java.util.Scanner;

public class DepositCalculator {
    private final double YEAR_RATE = 0.06;
    private final int DEFAULT_PLACES = 2;

    double calculateComplexPercent(double amount, int period) {
        final int monthCount = 12;
        double pay = amount * Math.pow((1 + YEAR_RATE / monthCount), monthCount * period);
        return round(pay, DEFAULT_PLACES);
    }

    double calculateSimplePercent(double amount, int period) {
        return round(amount + amount * YEAR_RATE * period, DEFAULT_PLACES);
    }

    double round(double value, int places) {
        double scaLe = Math.pow(10, places);
        return Math.round(value * scaLe) / scaLe;
    }

    void run() {
        int period;
        int action;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();

        double depositPercent = 0;
        if (action == 1) {
            depositPercent = calculateSimplePercent(amount, period);
        } else if (action == 2) {
            depositPercent = calculateComplexPercent(amount, period);
        }

        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + depositPercent);
    }

    public static void main(String[] args) {
        new DepositCalculator().run();
    }

}