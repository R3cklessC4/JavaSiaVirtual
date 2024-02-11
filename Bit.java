/**
 * ICSI404 - Assembly Computer Organization
 * 
 * @author Joshua Angulo
 * 
 *         Due: August 28, 2022
 */
public class Bit {
    private boolean value;

    public Bit() {
        this.set(false); // Defaults empty perameter to false on creation of new bit
    }

    public Bit(boolean value) {
        this.set(value);
    }

    public void set(boolean value) {
        this.value = value;
    }

    public void toggle() {
        if (getValue()) { // getValue() is already a boolean
            this.value = false;
            return;
        }
        this.value = true;
    }

    public void set() {
        this.value = true;
    }

    public void clear() {
        this.value = false;
    }

    public boolean getValue() {
        return this.value;
    }

    public Bit and(Bit other) {
        Bit newBit = new Bit();
        if (this.getValue()) { // getValue() is already a boolean
            if (other.getValue()) { // getValue() is already a boolean
                newBit.set(true);
                return newBit;
            }
        }
        newBit.set(false);
        return newBit;
    }

    public Bit or(Bit other) {
        Bit newBit = new Bit();
        if (this.getValue()) { // getValue() is already a boolean
            newBit = this;
            return newBit;
        }
        if (other.getValue()) { // getValue() is already a boolean
            newBit = other;
            return newBit;
        }
        newBit.set(false);
        return newBit;
    }

    public Bit xor(Bit other) {
        Bit newBit = new Bit();
        if (this.getValue() == other.getValue()) { // No need for nest if statements when we could test if the values
                                                   // match
            newBit.set(false);
            return newBit;
        }
        newBit.set(true);
        return newBit;
    }

    public Bit not() {
        Bit newBit = new Bit(this.getValue()); // putting in the existing value rather than equalling the instance makes
                                               // it easier to toggle than mess with the original bit
        newBit.toggle();
        return newBit;
    }

    @Override
    public String toString() {
        if (value) {
            return "t";
        }
        return "f"; // Default to false since all true cases will yield true
    }
}