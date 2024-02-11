/**
 * ICSI404 - Assembly Computer Organization
 * 
 * @author Joshua Angulo
 * 
 *         Due: September 25, 2022
 */

public class computer {
    Bit halted = new Bit(false); // Add bit to indicate if the computer is halted or not- have it default to not
    private memory member = new memory(); // add a memory member

    public void run() {
        while (halted.getValue()) {
            fetch();
            decode();
            execute();
            store();
        }
    }

    void fetch() {
    }

    void decode() {
    }

    void execute() {
    }

    void store() {
    }
}
