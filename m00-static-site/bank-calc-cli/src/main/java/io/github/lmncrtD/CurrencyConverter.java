package io.github.lmncrtD;

import java.math.BigDecimal;

public class CurrencyConverter {
    public static void main(String[] args) {
        double rub = Double.parseDouble(args[0]);
        double usd = Double.parseDouble(args[1]);
        double eur = Double.parseDouble(args[2]);
        double gbp = Double.parseDouble(args[3]);

        System.out.printf("Конвертация %.2f RUB %n%s%nUSD: %.2f %nEUR: %.2f %nGBP: %.2f",
                rub,
                "=".repeat(20),
                rub / usd,
                rub / eur,
                rub / gbp);
    }
}
