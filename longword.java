/**
 * ICSI404 - Assembly Computer Organization
 * 
 * @author Joshua Angulo
 * 
 *         Due: September 4, 2022
 */

public class longword implements Ilongword {
    private Bit[] bits;

    public longword() {
        this.bits = new Bit[32];
        // To make sure there is no null bit
        for (int i = 0; i < 32; i++) {
            this.bits[i] = new Bit(false);
        }
    }

    public longword(int value) {
        this.bits = new Bit[32];
        // To make sure there is no null bit
        for (int i = 0; i < 32; i++) {
            this.bits[i] = new Bit(false);
        }
        this.set(value);
    }

    public Bit getBit(int i) {
        return this.bits[i];
    }

    public void setBit(int i, Bit bit) {
        this.bits[i] = bit;
    }

    public longword and(longword other) {
        longword newLongword = new longword();
        for (int i = 0; i < 32; i++) {
            newLongword.setBit(i, this.getBit(i).and(other.getBit(i)));
        }
        return newLongword;
    }

    public longword or(longword other) {
        longword newLongword = new longword();
        for (int i = 0; i < 32; i++) {
            newLongword.setBit(i, this.getBit(i).or(other.getBit(i)));
        }
        return newLongword;
    }

    public longword xor(longword other) {
        longword newLongword = new longword();
        for (int i = 0; i < 32; i++) {
            newLongword.setBit(i, this.getBit(i).xor(other.getBit(i)));
        }
        return newLongword;
    }

    public longword not() {
        longword newLongword = new longword();
        for (int i = 0; i < 32; i++) {
            newLongword.setBit(i, this.getBit(i).not());
        }
        return newLongword;
    }

    public longword rightShift(int amount) {
        if (amount < 0 || amount > 31) {
            throw new IndexOutOfBoundsException();
        }
        longword newLongword = new longword();
        int j = 0;

        for (int i = 0; i < amount; i++) {
            newLongword.setBit(i, new Bit());
        }
        for (int i = amount; i < 31; i++) {
            newLongword.setBit(i, this.getBit(j));
            j++;
        }
        return newLongword;
    }

    public longword leftShift(int amount) {
        if (amount < 0 || amount > 31) {
            throw new IndexOutOfBoundsException();
        }
        longword newLongword = new longword();
        int j = 31;

        for (int i = 31; (31 - amount) < i; i--) {
            newLongword.setBit(i, new Bit());
        }
        for (int i = (31 - amount); i > -1; i--) {
            newLongword.setBit(i, this.getBit(j));
            j--;
        }
        return newLongword;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            result.append((this.bits[i].getValue() ? "t" : "f"));
            if (i != 31)
                result.append(", "); // So it doesnt add to final bit
        }
        result.append("\n");
        return result.toString();
    }

    public long getUnsigned() {
        long result = 0;
        int j = 0;
        for (int i = 31; i > -1; i--) {
            if (this.bits[i].getValue()) {
                result += ((int) Math.pow(2, j));
            }
            j++;
        }
        return result;
    }

    public int getSigned() {
        int result = 0, j = 0;

        // if leftmost is zero, give to getUnsigned.
        if (!this.bits[0].getValue())
            return (int) getUnsigned();

        // if leftmost is one, not() it, add it up, then subtract one.
        longword newLongword = this.not();
        for (int i = 31; i > 1; i--) {
            if (newLongword.getBit(i).getValue()) {
                result += (int) Math.pow(2, j);
            }
            j++;
        }
        return (result * -1) - 1;
    }

    public void copy(longword other) {
        for (int i = 0; i < 32; i++) {
            this.setBit(i, other.getBit(i));
        }
    }

    public void set(int value) {
        // number into binary
        int i = 0;
        longword temp = new longword();
        int num = value;// value will change, num will not

        if (value < 0) {
            value *= -1;
        }

        // Turns a num (a decimal value) into binary and creates a new bit,
        // Uses a temporary longword because it is backwards.
        while (value != 0) {
            if (value % 2 == 1) {
                temp.setBit(i, new Bit(true));
            } else {
                temp.setBit(i, new Bit(false));
            }
            value /= 2;
            i++;
        }

        // Reverses the temporary to make it correct when it is printed
        i = 31;
        for (int j = 0; j < 32; j++) {
            this.setBit(j, temp.getBit(i));
            i--;
        }

        // Checks if original value is negtive to make it a signed bit.
        if (num < 0) {
            temp = this;
            temp = temp.not(); // One's complement

            // Adds one to the binary representation of the negative value.
            Bit tempBit;
            if (!temp.getBit(31).getValue()) { // if the rightmost bit is zero, changes the bit to true.
                tempBit = new Bit(temp.getBit(31).getValue());
                tempBit.toggle();
                temp.setBit(31, tempBit);

            } else {
                // When the rightmost bit is already true, it will traverse
                // backwards to find the next possible zero to add one to make it
                // Two's complement
                i = 31;
                while (temp.getBit(i).getValue()) {
                    tempBit = new Bit(temp.getBit(i).getValue());
                    tempBit.toggle();
                    temp.setBit(i, tempBit);
                    i--;
                }
                // Sets the next possible zero to true
                // Completing Two's complement
                tempBit = new Bit(temp.getBit(i).getValue());
                tempBit.toggle();
                temp.setBit(i, tempBit);
            }
            for (i = 0; i < 32; i++) { // Sets the current longword to the one we just worked one
                this.setBit(i, temp.getBit(i));
            }
        }
    }
}
