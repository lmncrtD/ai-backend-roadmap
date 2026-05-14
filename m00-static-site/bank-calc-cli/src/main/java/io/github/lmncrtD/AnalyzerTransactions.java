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
        double[] values = new double[countAll];
        for (int i = 0; i < countAll; i++) {
            values[i] = parseAmount(args[i]);
        }

        printResult(
                countAll,
                calculateIncome(values),
                calculateOutcome(values),
                countIncome(values),
                countOutcome(values),
                countTech(values),
                definitionClass(calculateIncome(values), calculateOutcome(values))
        );

    }

    // Перевод из Strin в Double для расчетов
    public static double parseAmount(String amount)
    {
        return Double.parseDouble(amount);
    }

    // Подсчет количества записей о доходах
    public static int countIncome(double[] value)
    {
        int resultCount = 0;
        for (double item: value) {
            if (item > 0) {
                resultCount++;
            }
        }
        return resultCount;
    }

    // Метод расчета доходов
    public static double calculateIncome(double[] value)
    {
        double result = 0;
        for (double item: value) {
            if (item > 0){
                result += item;
            }
        }
        return result;
    }

    // Подсчет количество записей о расходах
    public static int countOutcome(double[] value)
    {
        int resultCount = 0;
        for (double item: value) {
            if (item < 0) {
                resultCount++;
            }
        }
        return resultCount;
    }

    // Подсчет количества нулевых значений
    public static int countTech(double[] value)
    {
        int resultCount = 0;
        for (double item: value) {
            if (item == 0) {
                resultCount++;
            }
        }
        return resultCount;
    }

    // Метод рассчета расходов
    public static double calculateOutcome(double[] value)
    {
        double result = 0;
        for (double item: value) {
            if (item < 0){
                result += item * -1;
            }
        }
        return result;
    }

    // Метод определения класса
    public static String definitionClass(double income, double outcome)
    {
        double sum = income - outcome;
        String resultStatus = "";
        if (sum == 0){
            resultStatus = "Нулевой";
        }
        else if (sum < 0) {
            resultStatus = "Дефицит";
        }
        else if (sum > 0) {
            resultStatus = "Профицит";
        }
        return resultStatus;
    }

    // Вывод отчета
    public static void printResult(int countAll, double income, double outcome,
                                   int countIncome, int countOutcome,
                                   int countTech, String status)
    {
        System.out.printf("%nОбработано записей: %d " +
                "%nДоходов: %d на сумму %.2f " +
                "%nРасходов: %d на сумму %.2f " +
                "%nПропущено: %d%n" +
                "%nБаланс: %.2f %nСтатус: %s%n",
                countAll,
                countIncome,
                income,
                countOutcome,
                outcome,
                countTech,
                income - outcome,
                status);
    }
}
