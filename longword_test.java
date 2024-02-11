/**
 * ICSI404 - Assembly Computer Organization
 * 
 * @author Joshua Angulo
 * 
 *         Due: September 4, 2022
 */

public class longword_test {

    public static void runTests() throws Exception {
        System.out.println("--------------------------------------------------");
        System.out.println("--------------------------------------------------");
        System.out.println("NOW TESTING longword_test.runTests()");
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

        System.out.println("--------------------------------------------------");
        System.out.println("--------------------------------------------------");
        System.out.println("TEST END FOR ASSIGNMENT 2: longword_test.java");
        System.out.println("--------------------------------------------------");
        System.out.println("--------------------------------------------------" + "\n");
    }

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
}
