/**
 * ICSI404 - Assembly Computer Organization
 * 
 * @author Joshua Angulo
 * 
 *         Due: September 11, 2022
 */

public class rippleAdder_test {

    public static void runTests() throws Exception {
        System.out.println("--------------------------------------------------");
        System.out.println("--------------------------------------------------");
        System.out.println("NOW TESTING ASSIGNMENT 3\nRippleAdder.runTests()");
        System.out.println("--------------------------------------------------");
        System.out.println("--------------------------------------------------" + "\n");

        testAdd();
        testSubtract();

        System.out.println("--------------------------------------------------");
        System.out.println("--------------------------------------------------");
        System.out.println("Test Ending assignment 3");
        System.out.println("--------------------------------------------------");
        System.out.println("--------------------------------------------------\n");

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
}
