/**
 * ICSI404 - Assembly Computer Organization
 * 
 * @author Joshua Angulo
 * 
 *         Due: September 18, 2022
 */
public class ALU_test {
    public static void runTests() throws Exception {
        System.out.println("--------------------------------------------------");
        System.out.println("--------------------------------------------------");
        System.out.println("NOW TESTING ASSIGNMENT 4\nALU_test.runTests()");
        System.out.println("--------------------------------------------------");
        System.out.println("--------------------------------------------------" + "\n");

        testALU();
    }

    public static void testALU() throws Exception {
        // Operation bits
        Bit[] op = new Bit[4];
        for (int i = 0; i < op.length; i++) {
            op[i] = new Bit(false);
        }

        // This is to check if the operation does not exist
        if (ALU.doOP(op, new longword(17), new longword(7)).getSigned() == 0) {
            System.out.println("Operation failed: Test passed");
        }

        op[0].toggle();
        op[1].toggle();
        op[2].toggle();
        System.out.println("\nTesting addition:");
        if (ALU.doOP(op, new longword(17), new longword(7)).getSigned() != 24) {
            System.out.println("Addition failed");
        } else {
            System.out.println("17 + 7 = 24: Addition Pass");
        }

        System.out.println();
        if (ALU.doOP(op, new longword(-65), new longword(7)).getSigned() != -58) {
            System.out.println("Addition failed");
        } else {
            System.out.println("-65 + 5 = -58: Addition Pass");
        }

        System.out.println();
        if (ALU.doOP(op, new longword(-25), new longword(-25)).getSigned() != -50) {
            System.out.println("Addition failed");
        } else {
            System.out.println("-25 + -25 = -50: Addition Pass");
        }

        op[3].toggle();
        System.out.println("\nTesting Subtraction:");
        if (ALU.doOP(op, new longword(17), new longword(7)).getSigned() != 10) {
            System.out.println("Subtraction failed");
        } else {
            System.out.println("17 - 7 = 10: Subtration Pass");
        }

        System.out.println();
        if (ALU.doOP(op, new longword(-20), new longword(-10)).getSigned() != -10) {
            System.out.println("Subtraction failed");
        } else {
            System.out.println("-20 - -10 = -10: Subtration Pass");
        }

        System.out.println();
        if (ALU.doOP(op, new longword(-2), new longword(-10)).getSigned() != 8) {
            System.out.println("Subtraction failed");
        } else {
            System.out.println("-2 - -10 = 8: Subtration Pass");
        }

        op[0].toggle();
        System.out.println("\nTesting Multiplication:");
        if (ALU.doOP(op, new longword(5), new longword(7)).getSigned() != 35) {
            System.out.println("Multiplication failed");
        } else {
            System.out.println("5 * 7 = 10: Multiplication Pass");
        }

        System.out.println();
        if (ALU.doOP(op, new longword(12), new longword(12)).getSigned() != 144) {
            System.out.println("Multiplication failed");
        } else {
            System.out.println("12 * 12 = 144: Multiplication Pass");
        }

        System.out.println();
        if (ALU.doOP(op, new longword(15), new longword(-15)).getSigned() != -225) {
            System.out.println("Multiplication failed");
        } else {
            System.out.println("15 * -15 = -225: Multiplication Pass");
        }

        op[0].toggle();
        op[1].toggle();
        op[2].toggle();
        op[3].toggle();
        System.out.println("\nTesting AND:");
        if (ALU.doOP(op, new longword(5), new longword(5)).getSigned() != 5) {
            System.out.println("AND failed");
        } else {
            System.out.println("5 AND 5 = 5: AND Pass");
        }

        System.out.println();
        if (ALU.doOP(op, new longword(7), new longword(5)).getSigned() != 5) {
            System.out.println("AND failed");
        } else {
            System.out.println("7 AND 5 = 5: AND Pass");
        }

        System.out.println();
        if (ALU.doOP(op, new longword(11), new longword(27)).getSigned() != 11) {
            System.out.println("AND failed");
        } else {
            System.out.println("11 AND 27 = 11: AND Pass");
        }

        op[3].toggle();
        System.out.println("\nTesing OR:");
        if (ALU.doOP(op, new longword(7), new longword(5)).getSigned() != 7) {
            System.out.println("OR failed");
        } else {
            System.out.println("7 OR 5 = 7: OR Pass");
        }

        System.out.println();
        if (ALU.doOP(op, new longword(19), new longword(12)).getSigned() != 31) {
            System.out.println("OR failed");
        } else {
            System.out.println("19 OR 12 = 31: OR Pass");
        }

        System.out.println();
        if (ALU.doOP(op, new longword(27), new longword(12)).getSigned() != 31) {
            System.out.println("OR failed");
        } else {
            System.out.println("27 OR 12 = 31: OR Pass");
        }

        op[2].toggle();
        op[3].toggle();
        System.out.println("\nTesting XOR:");
        if (ALU.doOP(op, new longword(7), new longword(5)).getSigned() != 2) {
            System.out.println("XOR failed");
        } else {
            System.out.println("7 XOR 5 = 2: XOR Pass");
        }

        System.out.println();
        if (ALU.doOP(op, new longword(40000), new longword(15000)).getSigned() != 42712) {
            System.out.println("XOR failed");
        } else {
            System.out.println("40000 XOR 15000 = 42712: XOR Pass");
        }

        System.out.println();
        if (ALU.doOP(op, new longword(-12000000), new longword(15)).getSigned() != -11999985) {
            System.out.println("XOR failed");
        } else {
            System.out.println("-12000000 XOR 15 = -11999985: XOR Pass");
        }

        op[3].toggle();
        System.out.println("\nTesting NOT:");
        if (ALU.doOP(op, new longword(), new longword()).getSigned() != -1) {
            System.out.println("NOT failed");
        } else {
            System.out.println("0 NOT = -1: NOT Pass");
        }

        System.out.println();
        if (ALU.doOP(op, new longword(17), new longword()).getSigned() != -18) {
            System.out.println("NOT failed");
        } else {
            System.out.println("17 NOT = -18: NOT Pass");
        }

        System.out.println();
        if (ALU.doOP(op, new longword(-13), new longword()).getSigned() != 12) {
            System.out.println("NOT failed");
        } else {
            System.out.println("-13 NOT = 12: NOT Pass");
        }

        op[1].toggle();
        op[2].toggle();
        op[3].toggle();
        System.out.println("\nTesting left shift:");
        if (ALU.doOP(op, new longword(21), new longword(2)).getSigned() != 84) {
            System.out.println("left shift failed");
        } else {
            System.out.println("21 left shift 2 = 84: left shift Pass");
        }

        System.out.println();
        if (ALU.doOP(op, new longword(5), new longword(2)).getSigned() != 20) {
            System.out.println("left shift failed");
        } else {
            System.out.println("5 left shift 2 = 20: left shift Pass");
        }

        System.out.println();
        if (ALU.doOP(op, new longword(1041249), new longword(2)).getSigned() != 4164996) {
            System.out.println("left shift failed");
        } else {
            System.out.println("1041249 left shift 2 = 4164996: left shift Pass");
        }

        System.out.println();
        if (ALU.doOP(op, new longword(1041249), new longword(34)).getSigned() != 4164996) {
            System.out.println("left shift failed");
        } else {
            System.out.println("1041249 left shift 34 (2) = 4164996: left shift Pass");
        }

        op[3].toggle();
        System.out.println("\nTesting right shift:");
        if (ALU.doOP(op, new longword(21), new longword(2)).getSigned() != 5) {
            System.out.println("right shift failed");
        } else {
            System.out.println("21 right shift 2 = 5: right shift Pass");
        }

        System.out.println();
        if (ALU.doOP(op, new longword(85), new longword(2)).getSigned() != 21) {
            System.out.println("right shift failed");
        } else {
            System.out.println("85 right shift 2 = 21: right shift Pass");
        }

        System.out.println();
        if (ALU.doOP(op, new longword(-12754), new longword(2)).getSigned() != 1073738635) {
            System.out.println("right shift failed");
        } else {
            System.out.println("-12754 right shift 2 = 1073738635: right shift Pass");
        }

        System.out.println();
        // testing for longword value above 32
        if (ALU.doOP(op, new longword(21), new longword(34)).getSigned() != 5) {
            System.out.println("right shift failed");
        } else {
            System.out.println("21 right shift 34(2) = 5: right shift Pass");
        }
    }
}
