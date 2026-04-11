import tests.MathTester;
import tests.TestReport;

public class Main {
    public static void main(String[] args) throws Exception {
        MathTester.run(MyMathTest.class);

        TestReport report = TestReport.loadFromFile("../lesson_11_105/Annotation/src/reports/test_report.ser");
        if (report == null) {
            System.err.println("Не удалось загрузить отчёт. Запустите тесты сначала.");
            return;
        }

        // 2️⃣ Выводим красивый отчёт
        report.printDetailedReport();

        // 3️⃣ Смотрим только ошибки
        report.printFailedOnly();

        // 4️⃣ Ищем медленные тесты (> 10 мс)
        report.printSlowTests(10);

        // 5️⃣ Экспортируем для менеджеров/CI
        report.exportToCSV("../lesson_11_105/Annotation/src/reports/test_report.csv");
        report.exportToJSON("../lesson_11_105/Annotation/src/reports/test_report.json");
    }
}