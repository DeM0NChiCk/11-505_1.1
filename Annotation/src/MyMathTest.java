import annotation.BeforeAll;
import annotation.GenerateEdgeCases;
import annotation.MathTest;

public class MyMathTest {

    @BeforeAll
    public void setup() {
        System.out.println("Подготовка тестовой среды...");
    }

    @MathTest
    public void testDevide(@GenerateEdgeCases int a, @GenerateEdgeCases int b) {
        int result = MathUtils.divide(a, b);
    }

    @MathTest
    public void testIsPrime(@GenerateEdgeCases int num) {
        boolean result = MathUtils.isPrime(num);

        if (num <= 1) {
            if (result) throw new AssertionError("Числа <= 1 не являются простыми");
        }
        if (num == 73) {
            if (!result) throw new AssertionError("73 — простое число");
        }
    }
}
