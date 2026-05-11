package io.github.lmncrtD;

import java.math.BigDecimal;

public class CurrencyConverter {
    public static void main(String[] args) {
        Double rub = new Double(args[0]);
        Double usd = new Double(args[1]);
        Double eur = new Double(args[2]);
        Double gbp = new Double(args[3]);

        System.out.printf("Конвертация %.2f RUB %n%s%nUSD: %.2f %nEUR: %.2f %nGBP: %.2f",
                rub,
                "=".repeat(20),
                rub / usd,
                rub / eur,
                rub / gbp);
    }
}
