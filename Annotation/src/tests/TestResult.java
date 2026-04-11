package tests;

import java.io.Serializable;

public class TestResult implements Serializable {
    String method;
    String args;
    boolean passed;
    String errorMsg;
    long timeMs;

    public TestResult(String method, String args, boolean passed, String errorMsg, long timeMs) {
        this.method = method;
        this.args = args;
        this.passed = passed;
        this.errorMsg = errorMsg;
        this.timeMs = timeMs;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s(%s) -> %s", passed ? "OK" : "FAIL", method, args, errorMsg);
    }
}
