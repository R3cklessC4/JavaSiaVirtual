/**
 * ICSI404 - Assembly Computer Organization
 * 
 * @author Joshua Angulo
 * 
 *         Due: September 11, 2022
 */

public class rippleAdder_test {

    public static void main(String[] args) throws Exception {
        runTests();
    }

    public static void runTests() throws Exception {
        // THIS FIRST PARTS TEST bit_runTests();!!!
        System.out.println("--------------------------------------------------");
        System.out.println("--------------------------------------------------");
        System.out.println("THIS IS TESTING PROJECT 1 bit.runTests()");
        System.out.println("TO SEE PROJECT 2, PLEASE SCROLL DOWN UNTIL YOU SEE A SIMILAR COMMENT LIKE THIS");
        System.out.println("--------------------------------------------------");
        System.out.println("--------------------------------------------------" + "\n");

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
        bitTestOthers(bit, bit2, bit3, bit4);

        System.out.println("-------------------------");
        System.out.println("All bits are restored to original");
        System.out.println("-------------------------" + "\n");

        bitTestAnd(bit, bit2, bit3, bit4);
        bitTestOr(bit, bit2, bit3, bit4);
        bitTestXor(bit, bit2, bit3, bit4);
        bitTestNot(bit, bit2, bit3, bit4);

        /**
         * ENDING ASSIGNMENT 1 TESTS
         */

        /**
         * NOW TESTING ASSIGNMENT 2
         * LONGWORD.JAVA!!!!!
         */

        System.out.println("--------------------------------------------------");
        System.out.println("--------------------------------------------------");
        System.out.println("THIS IS TESTING PROJECT 2 longword_test.runTests()");
        System.out.println("TO SEE PROJECT 3, PLEASE SCROLL DOWN UNTIL YOU SEE A SIMILAR COMMENT LIKE THIS");
        System.out.println("--------------------------------------------------");
        System.out.println("--------------------------------------------------" + "\n");

        // First Longword and Second Longword test setBit() for testing purposes
        System.out.println("Testing setBit() and printing first two longwords:\n");
        longword firstLongword = new longword();
        int count = 0;

        /**
         * This algorithm will be used for most of every longword 3.
         * It's intent is to have the bits inserted one by one in a certain pattern
         */
        for (int i = 0; i < 32; i++) { // Algorithm to insert bits in a pattern
            if ((count % 5) == 0) {
                firstLongword.setBit(i, new Bit(true)); // Inserts a true bit after every 5 counts
            } else {
                firstLongword.setBit(i, (i % 2 == 0 ? new Bit(true) : new Bit(false)));
            }
            count++;
        }
        System.out.println(firstLongword + "\n");

        longword secondLongword = new longword();
        count = 0;
        for (int i = 0; i < 32; i++) { // Algorithm to insert bits in a pattern
            if ((count % 3) == 0) {
                secondLongword.setBit(i, new Bit(true)); // Inserts a true bit after every 3 counts
            } else {
                secondLongword.setBit(i, (i % 2 == 0 ? new Bit(true) : new Bit(false)));
            }
            count++;
        }
        System.out.println(secondLongword + "\n");

        System.out.println("Testing getBit():\n" + firstLongword.getBit(17) + "\n");

        testAnd();
        testOr();
        testXor();
        testNot();
        testShift();
        testGetSigned();
        testGetUnsigned();
        testCopyAndSet();
        /**
         * ENDING ASSIGNMENT 2 TESTS
         */

        /**
         * TESTING ASSIGNMENT 3
         * RIPPLEADDER.JAVA
         */

        System.out.println("--------------------------------------------------");
        System.out.println("--------------------------------------------------");
        System.out.println("NOW TESTING ASSIGNMENT 3\nRippleAdder.runTests()");
        System.out.println("--------------------------------------------------");
        System.out.println("--------------------------------------------------" + "\n");
        testAdd();
        testSubtract();
    }

    public static void testAdd() throws Exception {
        System.out.println("Testing Add:");
        longword longword1 = new longword();
        longword longword2 = new longword();

        longword1.set(1);
        longword2.set(1);
        if (rippleAdder.add(longword1, longword2).getSigned() != 2) {
            throw new Exception("Failed");
        } else {
            System.out.println("longword 1 = " + longword1.getSigned());
            System.out.println("longword 2 = " + longword2.getSigned());
            System.out.println("1 + 1 = " + rippleAdder.add(longword1, longword2).getSigned());
        }

        System.out.println();
        longword1.set(-1);
        if (rippleAdder.add(longword1, longword2).getSigned() != 0) {
            throw new Exception("Failed");
        } else {
            System.out.println("longword 1 = " + longword1.getSigned());
            System.out.println("longword 2 = " + longword2.getSigned());
            System.out.println("-1 + 1 = " + rippleAdder.add(longword1, longword2).getSigned());
        }

        System.out.println();
        if (rippleAdder.add(new longword(27), new longword(38)).getSigned() != 65) {
            throw new Exception("Failed");
        } else {
            System.out.println("longword 1 = " + (new longword(27)).getSigned());
            System.out.println("longword 2 = " + (new longword(38)).getSigned());
            System.out.println("27 + 38 = " + rippleAdder.add(new longword(27), new longword(38)).getSigned());
        }

        System.out.println();
        if (rippleAdder.add(new longword(), new longword(9285523)).getSigned() != 9285523) {
            throw new Exception("Failed");
        } else {
            System.out.println("longword 1 = " + (new longword()).getSigned());
            System.out.println("longword 2 = " + (new longword(9285523)).getSigned());
            System.out.println("0 + 9285523 = " + rippleAdder.add(new longword(), new longword(9285523)).getSigned());
        }

        System.out.println();
        if (rippleAdder.add(new longword(-8593535), new longword(9859325)).getSigned() != 1265790) {
            throw new Exception("Failed");
        } else {
            System.out.println("longword 1 = " + (new longword(-8593535)).getSigned());
            System.out.println("longword 2 = " + (new longword(9859325)).getSigned());
            System.out.println(
                    "-8593535 + 9859325 = "
                            + rippleAdder.add(new longword(-8593535), new longword(9859325)).getSigned());
        }

        System.out.println();
        if (rippleAdder.add(new longword(-15000), new longword(-15000)).getSigned() != -30000) {
            throw new Exception("Failed");
        } else {
            System.out.println("longword 1 = " + (new longword(-15000)).getSigned());
            System.out.println("longword 2 = " + (new longword(-15000)).getSigned());
            System.out.println(
                    "-15000 + -15000 = "
                            + rippleAdder.add(new longword(-15000), new longword(-15000)).getSigned());
        }

        System.out.println();
        if (rippleAdder.add(new longword(14000), new longword(-15000)).getSigned() != -1000) {
            throw new Exception("Failed");
        } else {
            System.out.println("longword 1 = " + (new longword(14000)).getSigned());
            System.out.println("longword 2 = " + (new longword(-15000)).getSigned());
            System.out.println(
                    "14000 + -15000 = "
                            + rippleAdder.add(new longword(14000), new longword(-15000)).getSigned());
        }
    }

    public static void testSubtract() throws Exception {
        System.out.println("\nTesting Subtract:");

        longword longword1 = new longword();
        longword longword2 = new longword();

        longword1.set(5);
        longword2.set(3);

        if (rippleAdder.subtract(longword1, longword2).getSigned() != 2) {
            throw new Exception("Failed");
        } else {
            System.out.println("longword 1 = " + longword1.getSigned());
            System.out.println("longword 2 = " + longword2.getSigned());
            System.out.println("5 - 3 = " + rippleAdder.subtract(longword1, longword2).getSigned());
        }

        System.out.println();// leave a space
        if (rippleAdder.subtract(new longword(14), new longword(10)).getSigned() != 4) {
            throw new Exception("Failed");
        } else {
            System.out.println("longword 1 = " + (new longword(14)).getSigned());
            System.out.println("longword 2 = " + (new longword(10)).getSigned());
            System.out.println("14 - 10 = " + rippleAdder.add(new longword(24), new longword(10)).getSigned());
        }

        System.out.println();
        if (rippleAdder.subtract(new longword(517), new longword(235)).getSigned() != 282) {
            throw new Exception("Failed");
        } else {
            System.out.println("longword 1 = " + (new longword(517)).getSigned());
            System.out.println("longword 2 = " + (new longword(235)).getSigned());
            System.out.println("517 - 235 = " + rippleAdder.add(new longword(517), new longword(235)).getSigned());
        }

        System.out.println();
        if (rippleAdder.subtract(new longword(14), new longword(10)).getSigned() != 4) {
            throw new Exception("Failed");
        } else {
            System.out.println("longword 1 = " + (new longword(14)).getSigned());
            System.out.println("longword 2 = " + (new longword(10)).getSigned());
            System.out.println("14 - 10 = " + rippleAdder.subtract(new longword(14), new longword(10)).getSigned());
        }

        System.out.println();
        if (rippleAdder.subtract(new longword(82729452), new longword(1002945)).getSigned() != 81726507) {
            throw new Exception("Failed");
        } else {
            System.out.println("longword 1 = " + (new longword(82729452)).getSigned());
            System.out.println("longword 2 = " + (new longword(1002945)).getSigned());
            System.out.println(
                    "82729452 - 1002945 = "
                            + rippleAdder.subtract(new longword(82729452), new longword(1002945)).getSigned());
        }

        System.out.println();
        if (rippleAdder.subtract(new longword(-10000), new longword(-10000)).getSigned() != 0) {
            throw new Exception("Failed");
        } else {
            System.out.println("longword 1 = " + (new longword(-10000)).getSigned());
            System.out.println("longword 2 = " + (new longword(-10000)).getSigned());
            System.out.println(
                    "-10000 - -10000 = "
                            + rippleAdder.subtract(new longword(-10000), new longword(-10000)).getSigned());
        }
    }

    /**
     * TESTS FOR longword.runTests();
     * BELOW THIS POINT IS FROM PROJECT 2
     * EVERY THING FROM PROJECT 3 IS ABOVE THIS COMMENT BLOCK
     */

    public static void testAnd() {

        System.out.println("This will be testing AND:");

        // Creates 3 seperate longwords to test and
        longword longword = new longword(607);
        longword longword2 = new longword(125);
        longword longword3 = new longword();
        int count = 0;
        for (int i = 0; i < 32; i++) { // Inserts bits in a pattern
            if ((count % 5) == 0) {
                longword3.setBit(i, new Bit(true));
            } else {
                longword3.setBit(i, (i % 2 == 0 ? new Bit(true) : new Bit(false)));
            }
            count++;
        }

        System.out.println("Initial longwords for AND:");
        System.out.println(longword);
        System.out.println(longword2);
        System.out.println(longword3);

        System.out.println("Testing AND:");
        // I really don't feel like checking the binary for all numbers

        System.out.println("Longword AND longword 2:\n" + longword.and(longword2));
        System.out.println("Longword AND longword 3:\n" + longword.and(longword3));
        System.out.println("Longword 2 AND longword 3:\n" + longword2.and(longword3) + "\n");

    }

    public static void testOr() {
        System.out.println("This will be testing OR:");

        // Creates 3 seperate longwords to test or
        longword longword = new longword(777);
        longword longword2 = new longword(12952);
        longword longword3 = new longword();
        int count = 0;
        for (int i = 0; i < 32; i++) { // Inserts bits in a pattern
            if ((count % 5) == 0) {
                longword3.setBit(i, new Bit(true));
            } else {
                longword3.setBit(i, (i % 2 == 0 ? new Bit(true) : new Bit(false)));
            }
            count++;
        }
        System.out.println("Initial longwords for OR:");
        System.out.println(longword);
        System.out.println(longword2);
        System.out.println(longword3);

        System.out.println("Testing OR:");
        System.out.println("Longword OR longword 2:\n" + longword.or(longword2));
        System.out.println("Longword OR longword 3:\n" + longword.or(longword3));
        System.out.println("Longword 2 OR longword 3:\n" + longword2.or(longword3) + "\n");
    }

    public static void testXor() {
        System.out.println("This will be testing XOR:");

        // Creates 3 seperate longwords to test xor
        longword longword = new longword(-19275);
        longword longword2 = new longword(9184851);
        longword longword3 = new longword();
        int count = 0;
        for (int i = 0; i < 32; i++) { // Inserts bits in a pattern
            if ((count % 5) == 0) {
                longword3.setBit(i, new Bit(true));
            } else {
                longword3.setBit(i, (i % 2 == 0 ? new Bit(true) : new Bit(false)));
            }
            count++;
        }
        System.out.println("Initial longwords for XOR:");
        System.out.println(longword);
        System.out.println(longword2);
        System.out.println(longword3);

        System.out.println("Testing XOR:");
        System.out.println("Longword XOR longword 2:\n" + longword.xor(longword2));
        System.out.println("Longword XOR longword 3:\n" + longword.xor(longword3));
        System.out.println("Longword 2 XOR longword 3:\n" + longword2.xor(longword3) + "\n");
    }

    public static void testNot() {
        System.out.println("This will be testing NOT:");

        // Creates 3 seperate longwords to test not
        longword longword = new longword(919525);
        longword longword2 = new longword(-12416136);
        longword longword3 = new longword();
        int count = 0;
        for (int i = 0; i < 32; i++) { // Inserts bits in a pattern
            if ((count % 5) == 0) {
                longword3.setBit(i, new Bit(true));
            } else {
                longword3.setBit(i, (i % 2 == 0 ? new Bit(true) : new Bit(false)));
            }
            count++;
        }
        System.out.println("Initial longwords for NOT:");
        System.out.println(longword);
        System.out.println(longword2);
        System.out.println(longword3);

        System.out.println("Testing NOT:");
        System.out.println("NOT longword:\n" + longword.not());
        System.out.println("NOT longword 2:\n" + longword2.not());
        System.out.println("NOT longword 3:\n" + longword3.not() + "\n");
    }

    public static void testShift() {
        System.out.println("This will be testing left shift and right shift:");

        // Creates 3 seperate longwords to test shift
        longword longword = new longword(-1984);
        longword longword2 = new longword(2022);
        longword longword3 = new longword();
        int count = 0;
        for (int i = 0; i < 32; i++) { // Inserts bits in a pattern
            if ((count % 5) == 0) {
                longword3.setBit(i, new Bit(true));
            } else {
                longword3.setBit(i, (i % 2 == 0 ? new Bit(true) : new Bit(false)));
            }
            count++;
        }
        System.out.println("Initial longwords for the shifts:");
        System.out.println(longword);
        System.out.println(longword2);
        System.out.println(longword3);

        System.out.println("Testing Shifts:");
        System.out.println("LeftShift:");
        System.out.println("longword:\n" + longword.leftShift(5));
        System.out.println("longword 2:\n" + longword2.leftShift(17));
        System.out.println("longword 3:\n" + longword3.leftShift(4));

        System.out.println("RightShift:");
        System.out.println("longword:\n" + longword.rightShift(3));
        System.out.println("longword 2:\n" + longword2.rightShift(13));
        System.out.println("longword 3:\n" + longword3.rightShift(1) + "\n");
    }

    public static void testGetSigned() {
        System.out.println("This will be testing :");
        // Creates 3 seperate longwords to test getSigned
        longword longword = new longword(-192);
        longword longword2 = new longword(200);
        longword longword3 = new longword();
        int count = 0;
        for (int i = 0; i < 32; i++) { // Inserts bits in a pattern
            if ((count % 5) == 0) {
                longword3.setBit(i, new Bit(true));
            } else {
                longword3.setBit(i, (i % 2 == 0 ? new Bit(true) : new Bit(false)));
            }
            count++;
        }
        System.out.println("Initial longwords for the getSigned:");
        System.out.println(longword);
        System.out.println(longword2);
        System.out.println(longword3);

        System.out.println("Testing getSigned:");
        System.out.println("longword:\n" + longword.getSigned());
        System.out.println("longword 2:\n" + longword2.getSigned());
        System.out.println("longword 3:\n" + longword3.getSigned() + "\n");
    }

    public static void testGetUnsigned() {
        // Creates 3 seperate longwords to test getUnsigned
        longword longword = new longword(-19);
        longword longword2 = new longword(627);
        longword longword3 = new longword();
        int count = 0;
        for (int i = 0; i < 32; i++) { // Inserts bits in a pattern
            if ((count % 5) == 0) {
                longword3.setBit(i, new Bit(true));
            } else {
                longword3.setBit(i, (i % 2 == 0 ? new Bit(true) : new Bit(false)));
            }
            count++;
        }
        System.out.println("Initial longwords for the getUnsigned:");
        System.out.println(longword);
        System.out.println(longword2);
        System.out.println(longword3);

        System.out.println("Testing getUnsigned:");
        System.out.println("longword:\n" + longword.getUnsigned());
        System.out.println("longword 2:\n" + longword2.getUnsigned());
        System.out.println("longword 3:\n" + longword3.getUnsigned() + "\n");
    }

    public static void testCopyAndSet() {
        System.out.println("This will be testing left shift and right shift:");

        // Creates 3 seperate longwords to test copy and set
        longword longword = new longword(-187);
        longword longword2 = new longword(85737);
        longword longword3 = new longword(); // Longword 3 is empty for testing purposes

        System.out.println("Initial longwords for the Copy and Set:");
        System.out.println(longword);
        System.out.println(longword2);
        System.out.println(longword3);

        System.out.println("Testing Shifts:");
        System.out.println("Copy");

        System.out.println("Longword 3 before copy:\n" + longword3);
        longword3.copy(longword);
        System.out.println("Longword 3 after copying longword: \n" + longword3);

        System.out.println("Longword 1 before copy:\n" + longword);
        longword.copy(longword2);
        System.out.println("Longword after copying longword 2: \n" + longword);

        System.out.println("Set:");
        System.out.println("Before setting 145\n" + longword);
        longword.set(145);
        System.out.println("After setting 145\n" + longword);

        System.out.println("Before setting -571\n" + longword2);
        longword2.set(-571);
        System.out.println("After setting -571\n" + longword2);

    }

    /**
     * TESTS FOR bit_tests.runTests();
     * PASSED THIS POINT IS FROM PROJECT 1
     * EVERY THING FROM PROJECT 2 IS ABOVE THIS COMMENT BLOCK
     */

    public static void bitTestOthers(Bit bit, Bit bit2, Bit bit3, Bit bit4) {
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

    public static void bitTestAnd(Bit bit, Bit bit2, Bit bit3, Bit bit4) throws Exception {
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

    public static void bitTestOr(Bit bit, Bit bit2, Bit bit3, Bit bit4) throws Exception {
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

    public static void bitTestXor(Bit bit, Bit bit2, Bit bit3, Bit bit4) throws Exception {
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

    public static void bitTestNot(Bit bit, Bit bit2, Bit bit3, Bit bit4) throws Exception {
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
