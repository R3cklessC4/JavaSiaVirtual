/**
 * ICSI404 - Assembly Computer Organization
 * 
 * @author Joshua Angulo
 * 
 *         Due: September 18, 2022
 */
public class ALU {
    public static longword doOP(Bit[] operation, longword firstLongword, longword secondLongword) throws Exception {
        if (operation.length != 4) {
            throw new Exception("Operation failure");
        }
        if (operation[0].getValue()) { // 1xxx
            if (operation[1].getValue()) { // 11xx
                if (operation[2].getValue()) { // 111x
                    if (operation[3].getValue()) {// 1111
                        return rippleAdder.subtract(firstLongword, secondLongword);
                    } else { // 1110
                        return rippleAdder.add(firstLongword, secondLongword);
                    }
                } else { // 110x
                    if (operation[3].getValue()) { // 1101 right shift
                        longword temp = new longword();
                        temp.copy(secondLongword);
                        for (int i = 26; i > -1; i--) {
                            temp.setBit(i, new Bit());
                        }
                        return firstLongword.rightShift(temp.getSigned());
                    } else {// 1100 left shift
                        longword temp = new longword();
                        temp.copy(secondLongword);
                        for (int i = 26; i > -1; i--) {
                            temp.setBit(i, new Bit());
                        }
                        return firstLongword.leftShift(temp.getSigned());
                    }
                }

            } else {
                if (operation[2].getValue()) {// 101x
                    if (operation[3].getValue()) { // 1011 not
                        return firstLongword.not();
                    } else { // xor 1010
                        return firstLongword.xor(secondLongword);
                    }
                } else { // 100x
                    if (operation[3].getValue()) { // or 1001
                        return firstLongword.or(secondLongword);
                    } else { // and 1000
                        return firstLongword.and(secondLongword);
                    }
                }
            }

        } else {// 0xxx
            if (operation[1].getValue()) {
                if (operation[2].getValue()) {
                    if (operation[3].getValue()) {
                        return multiplier.multiply(firstLongword, secondLongword); // Multiply is the only 0xxx
                    }
                }
            }
        }
        return new longword();
    }
}
