/**
 * ICSI404 - Assembly Computer Organization
 * 
 * @author Joshua Angulo
 * 
 *         Due: September 18, 2022
 */
public class multiplier_test {
    public static void runTests() throws Exception {
        System.out.println("--------------------------------------------------");
        System.out.println("--------------------------------------------------");
        System.out.println("NOW TESTING ASSIGNMENT 4\nmultiply_test.runTests()");
        System.out.println("--------------------------------------------------");
        System.out.println("--------------------------------------------------" + "\n");

        testMultiply();
    }

    public static void testMultiply() throws Exception {
        System.out.println();
        if (multiplier.multiply(new longword(2), new longword(3)).getSigned() != 6) {
            throw new Exception("Failed");
        } else {
            System.out.println("longword 1 = " + (new longword(2)).getSigned());
            System.out.println("longword 2 = " + (new longword(3)).getSigned());
            System.out.println("2 * 3 = " + multiplier.multiply(new longword(2), new longword(3)).getSigned());
        }

        System.out.println();
        if (multiplier.multiply(new longword(5), new longword(5)).getSigned() != 25) {
            throw new Exception("Failed");
        } else {
            System.out.println("longword 1 = " + (new longword(5)).getSigned());
            System.out.println("longword 2 = " + (new longword(5)).getSigned());
            System.out.println("5 * 5 = " + multiplier.multiply(new longword(5), new longword(5)).getSigned());
        }

        System.out.println();
        if (multiplier.multiply(new longword(-5), new longword(5)).getSigned() != -25) {
            throw new Exception("Failed");
        } else {
            System.out.println("longword 1 = " + (new longword(-5)).getSigned());
            System.out.println("longword 2 = " + (new longword(-5)).getSigned());
            System.out.println("-5 * 5 = " + multiplier.multiply(new longword(-5), new longword(5)).getSigned());
        }

        System.out.println();
        if (multiplier.multiply(new longword(17), new longword(-56)).getSigned() != -952) {
            throw new Exception("Failed");
        } else {
            System.out.println("longword 1 = " + (new longword(17)).getSigned());
            System.out.println("longword 2 = " + (new longword(-56)).getSigned());
            System.out.println("17 * -56 = " + multiplier.multiply(new longword(17), new longword(-56)).getSigned());
        }
    }

}
