/**
 * Created by admin on 29/10/15.
 */

public class SpyConsole implements Console {

    private boolean writeMessageWasCalled = false;
    private boolean readMessageWasCalled  = false;
    private String inputMessage;
    private String printedMessage;

    public String read() {
        readMessageWasCalled = true;
        return inputMessage;
    }

    public boolean readMessageWasCalled() {
        return readMessageWasCalled;
    }

    public void write(String message) {
        writeMessageWasCalled = true;
        printedMessage = message;
    }

    public boolean writeMessageWasCalled() {
        return writeMessageWasCalled;
    }

    public void userInput(String message) {
        inputMessage = message;
    }

    public String printedMessage() {
        return printedMessage;
    }
}
