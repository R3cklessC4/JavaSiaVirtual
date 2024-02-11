/**
 * ICSI404 - Assembly Computer Organization
 * 
 * @author Joshua Angulo
 * 
 *         Due: September 25, 2022
 */

public class memory {
    Bit[] memoryBits;

    // has to fill a whole lot of new bits for memory
    public memory() {
        this.memoryBits = new Bit[8192];
        for (int i = 0; i < 8192; i++) {
            memoryBits[i] = new Bit();
        }
    }

    public longword read(longword address) {
        if (address.getUnsigned() < 0 || address.getUnsigned() > 1020) {
            throw new IndexOutOfBoundsException(); // Only 1024 bytes, it has to read up until
        }
        longword result = new longword();
        for (int i = 0; i < 32; i++) {
            // it multiplys by 8 because a byte is 8 bits and we are reading by bytes.
            result.setBit(i, memoryBits[(int) ((address.getUnsigned() * 8) + i)]);
        }
        return result;
    }

    public void write(longword address, longword value) {
        if (address.getUnsigned() < 0 || address.getUnsigned() > 1020) {
            // Only 1024 bytes, it has to write up until 1024
            throw new IndexOutOfBoundsException();
        }
        for (int i = 0; i < 32; i++) {
            // it multiplys by 8 because a byte is 8 bits and we are reading by bytes.
            memoryBits[(int) ((address.getUnsigned() * 8) + i)] = value.getBit(i);
        }
    }

    // For testing purposes
    @Override
    public String toString() {
        StringBuilder printMemory = new StringBuilder();
        int count = 0;

        printMemory.append("Dumping Memory:\n");
        for (int i = 0; i < 8192; i++) {
            // if (i % 8 == 0) {} -- counts bytes instead of longwords
            if (i % 32 == 0) {
                printMemory.append("\n" + count + " - ");
                count++;
            }
            printMemory.append((this.memoryBits[i].getValue() ? "1" : "0"));
        }
        return printMemory.toString();
    }
}