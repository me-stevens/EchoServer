import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpyConsole implements Console {

    private boolean wasReadMethodCalled  = false;
    private boolean wasWriteMethodCalled = false;
    private String inputMessage          = "";
    private String printedMessage        = "";


    public String read() {
        wasReadMethodCalled = true;
        return inputMessage;
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

    public void userInput(String message) {
        inputMessage = message;
    }

    public String printedMessage() {
        return printedMessage;
    }
}
