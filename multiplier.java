/**
 * ICSI404 - Assembly Computer Organization
 * 
 * @author Joshua Angulo
 * 
 *         Due: September 18, 2022
 */
public class multiplier {
    public static longword multiply(longword firstLongword, longword secondLongword) {
        longword newLongword = new longword();
        for (int i = 31; i > -1; i--) {
            if (secondLongword.getBit(i).getValue()) // only add the left shift if second longword bit is true
                // adds each left shift to the new longword result to make code cleaner
                newLongword.copy(rippleAdder.add(newLongword, ((new longword(firstLongword.leftShift(31 - i))))));
        }
        return newLongword;
    }
}
