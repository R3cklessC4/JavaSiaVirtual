/**
 * ICSI404 - Assembly Computer Organization
 * 
 * @author Joshua Angulo
 * 
 *         Due: September 11, 2022
 */

public class rippleAdder {

    public static longword add(longword firstLongword, longword secondLongword) {
        longword newLongword = new longword();
        boolean carryValue = false; //
        for (int i = 31; i > -1; i--) {
            // Sets the newLongword at index by using XOR, gives carry the carry value
            newLongword.setBit(i, (firstLongword.getBit(i).xor(secondLongword.getBit(i))).xor(new Bit(carryValue)));
            // Determine the carry of the current iteration
            // C out = X AND Y OR ((X XOR Y) AND C in)
            carryValue = (firstLongword.getBit(i).and(secondLongword.getBit(i)))
                    .or((firstLongword.getBit(i).xor(secondLongword.getBit(i))).and(new Bit(carryValue)))
                    .getValue();
        }
        return newLongword;
    }

    // Negates the second longword, then uses the add method to add one to the
    // second longword to make it two's complement
    // Next its adds the first longword and the newly negated longword to give the
    // difference from the original two
    public static longword subtract(longword firstLongword, longword secondLongword) {
        return add(firstLongword, add(secondLongword.not(), new longword(1)));
    }
}
