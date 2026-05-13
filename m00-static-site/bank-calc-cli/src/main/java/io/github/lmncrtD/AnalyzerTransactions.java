package io.github.lmncrtD;

public class AnalyzerTransactions {
    static void main(String[] args) {
     /*
     1. Сколько всего записей обработано.
     2. Сколько среди них доходов, на какую общую сумму.
     3. Сколько расходов, на какую общую сумму (положительным числом)
     4. Сколько технических (нулевых) записей.
     5. Итоговый баланс.
     6. Статус баланса (Профицит/Дефицит/Нелевой)
     */
        int countAll = args.length;
        double income = 0.0;
        double outcome = 0.0;
        int countIncome = 0;
        int countOutcome = 0;
        int countTech = 0;
        String status = "";

        for (String item: args) {
            if (Double.parseDouble(item) > 0) {
                countIncome++;
                income += Double.parseDouble(item);
            }
            else if (Double.parseDouble(item) < 0) {
                countOutcome++;
                outcome += Double.parseDouble(item) * -1;
            }
            else if (Double.parseDouble(item) == 0) {
                countTech++;
            }
        }

        if (income - outcome == 0) {
            status = "Нулевой";
        } else if (income - outcome > 0) {
            status = "Профицит";
        } else if (income - outcome < 0) {
            status = "Дефицит";
        }

        System.out.printf(
                "%nОбработано записей: %d %nДоходов: %d на сумму %.2f %nРасходов: %d на сумму %.2f %nПропущено: %d%n%nБаланс: %.2f %nСтатус: %s%n",
                countAll,
                countIncome,
                income,
                countOutcome,
                outcome,
                countTech,
                income - outcome,
                status
                );
    }
}
