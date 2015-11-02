import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpyConsole implements Console {

    private boolean wasReadMethodCalled  = false;
    private boolean wasWriteMethodCalled = false;
    private List<String> inputMessages   = new ArrayList<>();
    private String printedMessage        = "";
    private int timesReadWasCalled       = 0;


    public String read() {
        wasReadMethodCalled = true;
        timesReadWasCalled++;

        if (inputMessages.size() == 0) {
            return "";
        }
        return inputMessages.remove(0);
    }

    public void write(String message) {
        wasWriteMethodCalled = true;
        printedMessage += message;
    }

    public boolean readMethodWasCalled() {
        return wasReadMethodCalled;
    }

    public boolean writeMethodWasCalled() {
        return wasWriteMethodCalled;
    }

    public void userInput(String[] messages) {
        inputMessages.addAll(Arrays.asList(messages));
    }

    public String printedMessage() {
        return printedMessage;
    }

    public int timesReadWasCalled() {
        return timesReadWasCalled;
    }
}
