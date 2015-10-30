import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 29/10/15.
 */

public class SpyConsole implements Console {

    private boolean wasReadMethodCalled = false;
    private boolean wasWriteMethodCalled = false;
    private String printedMessage;

    private List<String> inputMessages = new ArrayList<>();

    public String read() {
        wasReadMethodCalled = true;
        if (inputMessages.size() == 0) {
            return "";
        }
        return inputMessages.remove(0);
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
        inputMessages.add(message);
    }

    public String printedMessage() {
        return printedMessage;
    }

    public void userInput(String[] messages) {
        //inputMessages = messages;
    }
}
