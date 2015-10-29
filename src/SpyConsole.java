/**
 * Created by admin on 29/10/15.
 */

public class SpyConsole implements Console {

    private boolean wasReadMethodCalled = false;
    private boolean wasWriteMethodCalled = false;
    private String inputMessage = "";
    private String printedMessage;

    public String read() {
        wasReadMethodCalled = true;
        return inputMessage;
    }

    public boolean readMethodWasCalled() {
        return wasReadMethodCalled;
    }

    public void write(String message) {
        wasWriteMethodCalled = true;
        printedMessage = message;
    }

    public boolean writeMethodWasCalled() {
        return wasWriteMethodCalled;
    }

    public void userInput(String message) {
        inputMessage = message;
    }

    public String printedMessage() {
        return printedMessage;
    }
}
