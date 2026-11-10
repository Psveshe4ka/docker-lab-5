// Автор: Рєпін Володимир Сергійович, Варіант 1
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("  Калькулятор складних відсотків (Docker) ");
        System.out.println("  Студент: Рєпін Володимир, Група З-41   ");
        System.out.println("==========================================");

        String envPrincipal = System.getenv("PRINCIPAL");
        String envRate = System.getenv("RATE");
        String envYears = System.getenv("YEARS");

        double principal = (envPrincipal != null) ? Double.parseDouble(envPrincipal) : 10000.0;
        double rate = (envRate != null) ? Double.parseDouble(envRate) : 10.0;
        int years = (envYears != null) ? Integer.parseInt(envYears) : 5;

        System.out.printf("Початкова сума: %.2f грн\n", principal);
        System.out.printf("Річна ставка: %.2f%%\n", rate);
        System.out.printf("Термін: %d років\n", years);
        System.out.println("------------------------------------------");
        System.out.printf("%-6s | %-15s | %-15s\n", "Рік", "Нараховано", "Підсумок");
        System.out.println("------------------------------------------");

        DecimalFormat df = new DecimalFormat("#,##0.00 грн");
        double currentAmount = principal;

        for (int i = 1; i <= years; i++) {
            double interest = currentAmount * (rate / 100.0);
            currentAmount += interest;
            System.out.printf("%-6d | %-15s | %-15s\n", i, df.format(interest), df.format(currentAmount));
        }

        System.out.println("------------------------------------------");
        System.out.printf("Кінцева сума вкладу: %s\n", df.format(currentAmount));
        System.out.printf("Загальний прибуток:  %s\n", df.format(currentAmount - principal));
        System.out.println("==========================================");
    }
}