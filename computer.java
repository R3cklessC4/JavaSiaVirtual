/**
 * ICSI404 - Assembly Computer Organization
 * 
 * @author Joshua Angulo
 * 
 *         Due: September 25, 2022
 * 
 *         Assignment 6th due: October 2, 2022
 * 
 *         Last Edited: September 27, 2022 11:20pm
 */

public class computer {

    Bit halted = new Bit(false); // Add bit to indicate if the computer is halted or not- have it default to not
    memory member = new memory(); // add a memory member

    // part 1
    longword pc = new longword();
    longword currentInstruction = new longword();

    // Part 2
    longword[] register = new longword[16];

    // Part 4
    longword op1 = new longword();
    longword op2 = new longword();
    longword result = new longword();

    public void run() throws Exception {
        for (int i = 0; i < 16; i++) {
            register[i] = new longword();
        }

        while (halted.getValue()) {
            fetch();
            decode();
            execute();
            store();
        }
    }

    void fetch() {
        currentInstruction.copy(member.read(pc));
        rippleAdder.add(pc, new longword(2)); // Increments by 2 just like in word doc
    }

    void decode() {
        // Subtracts by 1 because index of registers, 1 less than it is.
        // Left Shifts by 4 then right shifts by 28 to isolate OP 1
        op1.copy(rippleAdder.subtract(
                currentInstruction.leftShift(new longword(4).getSigned()).rightShift(new longword(28).getSigned()),
                new longword(1)));

        // Subtracts by 1 because index of registers, 1 less than it is.
        // Left Shifts by 8 then right shifts by 28 to isolate OP 2
        op2.copy(rippleAdder.subtract(
                currentInstruction.leftShift(new longword(8).getSigned()).rightShift(new longword(28).getSigned()),
                new longword(1)));
    }

    void execute() throws Exception {
        Bit[] temp = new Bit[4];
        for (int i = 0; i < 4; i++) {
            temp[i] = new Bit(currentInstruction.getBit(i).getValue());
        }
        result.copy(ALU.doOP(temp, register[op1.getSigned()], register[op2.getSigned()]));
    }

    void store() {
        // Subtracts by 1 because index of registers, 1 less than it is.
        // Left Shifts by 12 then right shifts by 28 to isolate OP 3
        register[rippleAdder.subtract(
                currentInstruction.leftShift(new longword(12).getSigned()).rightShift(new longword(28).getSigned()),
                new longword(1)).getSigned()].copy(result);
    }
}
