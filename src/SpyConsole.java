import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpyConsole implements Console {

    private boolean wasReadMethodCalled  = false;
    private boolean wasWriteMethodCalled = false;
    private List<String> inputMessages   = new ArrayList<>();
    private String printedMessage        = "";


    public String read() {
        wasReadMethodCalled = true;

        if (inputMessages.size() == 0) {
            return "";
        }

        return inputMessages.remove(0);
    }

    public void write(String message) {
        wasWriteMethodCalled = true;
        if (!message.equals(EchoServer.PROMPT)) {
            printedMessage += message;
        }
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
}
