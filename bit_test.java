/**
 * ICSI404 - Assembly Computer Organization
 * 
 * @author Joshua Angulo
 * 
 *         Due: August 28, 2022
 */

public class bit_test {
    public static void main(String[] args) throws Exception {
            runTests();
    }

    public static void runTests() throws Exception {
            Bit bit = new Bit(true);
            Bit bit2 = new Bit(false);
            Bit bit3 = new Bit(true);
            Bit bit4 = new Bit(false);

            // Run initial
            System.out.println("Initial Bits:");
            System.out.println("Bit 1 is: " + bit.getValue());
            System.out.println("Bit 2 is: " + bit2.getValue());
            System.out.println("Bit 3 is: " + bit3.getValue());
            System.out.println("Bit 4 is: " + bit4.getValue() + "\n");

            // Tests everything excepts operators to keep it cleaner
            testOthers(bit, bit2, bit3, bit4);

            System.out.println("-------------------------");
            // For when the rightmost is already true. Finds the next possible zero
            // System.out.println("All bits are restored to original");
            System.out.println("-------------------------" + "\n");

            testAnd(bit, bit2, bit3, bit4);
            testOr(bit, bit2, bit3, bit4);
            testXor(bit, bit2, bit3, bit4);
            testNot(bit, bit2, bit3, bit4);
    }

    public static void testOthers(Bit bit, Bit bit2, Bit bit3, Bit bit4) {
            bit.set(false);
            System.out.println("Tests set(value) \nChanged bit to false: " + bit + "");
            bit.set(true);
            System.out.println("Changed back to true: " + bit + "\n");

            System.out.println("Testing toggle(). it should reverse the inital settings.");
            bit.toggle();
            bit2.toggle();
            System.out.println("Toggled bit 1: " + bit);
            System.out.println("Toggled bit 2: " + bit2);
            bit.toggle();
            bit2.toggle();
            System.out.println("Toggled bit 1 back: " + bit);
            System.out.println("Toggled bit 2 back: " + bit2 + "\n");

            System.out.println("Testing set() and clear(). Sets should be true, clears should be false.");
            bit2.set();
            bit4.set();
            System.out.println("Set bit 2: " + bit2);
            System.out.println("Set bit 4: " + bit4);
            bit2.clear();
            bit4.clear();
            System.out.println("Clear bit 2: " + bit2 + "");
            System.out.println("Clear bit 4: " + bit4 + "\n");

            System.out.println("Testing getValue()");
            System.out.println("Bit 1 should be true\nBit: " + bit.getValue());
            System.out.println("Bit 2 should be false\nBit2: " + bit2.getValue());
            System.out.println("Bit 3 should be true\nBit3: " + bit3.getValue());
            System.out.println("Bit 4 should be false\nBit4: " + bit4.getValue() + "\n");
    }

    public static void testAnd(Bit bit, Bit bit2, Bit bit3, Bit bit4) throws Exception {
            // Run and
            System.out.println("Test operator AND:");

            System.out.print("True and false: ");
            if ((bit.and(bit2)).getValue() != false) {
                    throw new Exception("Fail");
            } else {
                    System.out.println(bit.and(bit2) + "\nPass");
            }

            System.out.print("True and True: ");
            if ((bit.and(bit3)).getValue() != true) {
                    throw new Exception("Fail");
            } else {
                    System.out.println(bit.and(bit3) + "\nPass");
            }

            System.out.print("False and True: ");
            if ((bit4.and(bit)).getValue() != false) {
                    throw new Exception("Fail");
            } else {
                    System.out.println(bit4.and(bit) + "\nPass");
            }

            System.out.print("False and False: ");
            if ((bit2.and(bit4)).getValue() != false) {
                    throw new Exception("Fail");
            } else {
                    System.out.println(bit2.and(bit4) + "\nPass" + "\n");
            }
    }

    public static void testOr(Bit bit, Bit bit2, Bit bit3, Bit bit4) throws Exception {
            // Run or
            System.out.println("Test operator Or:");

            System.out.print("True or false: ");
            if ((bit.or(bit2)).getValue() != true) {
                    throw new Exception("Fail");
            } else {
                    System.out.println(bit.or(bit2) + "\nPass");
            }

            System.out.print("True or True: ");
            if ((bit.or(bit3)).getValue() != true) {
                    throw new Exception("Fail");
            } else {
                    System.out.println(bit.or(bit3) + "\nPass");
            }

            System.out.print("False or True: ");
            if ((bit4.or(bit)).getValue() != true) {
                    throw new Exception("Fail");
            } else {
                    System.out.println(bit4.or(bit) + "\nPass");
            }

            System.out.print("False or False: ");
            if ((bit2.or(bit4)).getValue() != false) {
                    throw new Exception("Fail");
            } else {
                    System.out.println(bit2.or(bit4) + "\nPass");
            }
    }

    public static void testXor(Bit bit, Bit bit2, Bit bit3, Bit bit4) throws Exception {
            // Run xor
            System.out.println("Test operator Xor:");

            System.out.print("True xor false: ");
            if ((bit.xor(bit2)).getValue() != true) {
                    throw new Exception("Fail");
            } else {
                    System.out.println(bit.xor(bit2) + "\nPass");
            }

            System.out.print("True xor True: ");
            if ((bit.xor(bit3)).getValue() != false) {
                    throw new Exception("Fail");
            } else {
                    System.out.println(bit.xor(bit3) + "\nPass");
            }

            System.out.print("False xor True: ");
            if ((bit4.xor(bit)).getValue() != true) {
                    throw new Exception("Fail");
            } else {
                    System.out.println(bit4.xor(bit) + "\nPass");
            }

            System.out.print("False xor False: ");
            if ((bit2.xor(bit4)).getValue() != false) {
                    throw new Exception("Fail");
            } else {
                    System.out.println(bit2.xor(bit4) + "\nPass" + "\n");
            }
    }

    public static void testNot(Bit bit, Bit bit2, Bit bit3, Bit bit4) throws Exception {
            // Run not
            System.out.println("Test operator Not:");

            System.out.print("not True: ");
            if ((bit.not()).getValue() != false) {
                    throw new Exception("Fail");
            } else {
                    System.out.println(bit.not() + "\nPass");
            }

            System.out.print("not false: ");
            if ((bit2.not()).getValue() != true) {
                    throw new Exception("Fail");
            } else {
                    System.out.println(bit2.not() + "\nPass");
            }

            System.out.print("not true: ");
            if ((bit3.not()).getValue() != false) {
                    throw new Exception("Fail");
            } else {
                    System.out.println(bit3.not() + "\nPass");
            }

            System.out.print("not false: ");
            if ((bit4.not()).getValue() != true) {
                    throw new Exception("Fail");
            } else {
                    System.out.println(bit4.not() + "\nPass");
            }
    }
}