/**
 * ICSI404 - Assembly Computer Organization
 * 
 * @author Joshua Angulo
 */

public class main {
    public static void main(String[] args) throws Exception {
        runTests();
    }

    public static void runTests() throws Exception {
        bit_test.runTests();
        longword_test.runTests();
        rippleAdder_test.runTests();
        multiplier_test.runTests();
        ALU_test.runTests();
        memory_test.runTests();
        computer_test.runTest();
    }
}
