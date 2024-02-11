/**
 * ICSI404 - Assembly Computer Organization
 * 
 * @author Joshua Angulo
 * 
 *         Due: September 25, 2022
 */

public class memory_test {
    public static void runTests() {
        System.out.println("--------------------------------------------------");
        System.out.println("--------------------------------------------------");
        System.out.println("NOW TESTING ASSIGNMENT 5\nmemory.runTests()");
        System.out.println("--------------------------------------------------");
        System.out.println("--------------------------------------------------" + "\n");

        testMemory();
    }

    public static void testMemory() {
        memory mem = new memory();

        // Uncomment line below to check memory dump
        // System.out.println(mem);

        System.out.println("Write Test:");
        mem.write(new longword(1020), new longword(172));

        System.out.println(mem);
        System.out.println("\nValue: " + new longword(172).getSigned());
        System.out.println("Write Test passes if longword 255 ends with: 10101100");

        if (mem.read(new longword(1020)).getSigned() != 172) {
            System.out.println("Read Failed");
        } else {
            System.out.println("Read passed: " + mem.read(new longword(1020)).getSigned());
        }

        /**
         * I am writing over the byte before 1020 so I can test if it wrote over my
         * current byte
         */
        System.out.println("\nRead/Write test:");
        mem.write(new longword(1019), new longword(172));

        if (mem.read(new longword(1020)).getSigned() != 44204) {
            System.out.println("Read/Write Failed");
        } else {
            System.out.println("Read/Write Passed:" + mem.read(new longword(1020)).getSigned());
        }

        // Negative test
        System.out.println("\nRead/Write test 2:");
        mem.write(new longword(1020), new longword(-1));
        if (mem.read(new longword(1020)).getSigned() != -1) {
            System.out.println("Read/Write Test failed");
        } else {
            // System.out.println(mem.read(new longword(1020)));
            System.out.println("Read/Write test passed: " + mem.read(new longword(1020)).getSigned());
        }

        System.out.println("\nRead/Write test 3:");
        mem.write(new longword(225), new longword(-1));
        if (mem.read(new longword(225)).getSigned() != -1) {
            System.out.println("Read/Write Test failed");
        } else {
            // System.out.println(mem.read(new longword(225)));
            System.out.println("Read/Write test passed: " + mem.read(new longword(225)).getSigned());
        }

        System.out.println("\nWriting over already written memory:");
        mem.write(new longword(1019), new longword(-1));
        if (mem.read(new longword(1019)).getSigned() != -1) {
            System.out.println("Read/Rewrite Test failed");
        } else {
            System.out.println("Read/Rewrite test passed: " + mem.read(new longword(1019)).getSigned());
        }
        System.out.println("\n" + mem);
        System.out.println("Dumped memory to see all changes^");
    }
}
