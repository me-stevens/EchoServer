import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class EchoServerTest {

    private SpyConsole spyConsole;
    private EchoServer echoServer;

    @Before
    public void setUp() throws Exception {
        spyConsole = new SpyConsole();
        echoServer = new EchoServer(spyConsole);
    }

    @Test
    public void userInputIsRead() {
        String message = "hi";
        spyConsole.userInput(message);
        assertEquals(message, echoServer.promptForInput());
        assertTrue(spyConsole.readMethodWasCalled());
    }

    @Test
    public void anyMessageIsPrinted() {
        String message = "hi";
        echoServer.setOutput(message);
        assertEquals(message, spyConsole.printedMessage());
        assertTrue(spyConsole.writeMethodWasCalled());
    }

    @Test
    public void userInputIsPrinted() {
        String message = "hi";
        spyConsole.userInput(message);
        echoServer.printUserInput();
        assertEquals(message, spyConsole.printedMessage());
    }

    @Test
    public void ifUserTypesExitNothingIsPrinted() {
        spyConsole.userInput("exit");
        echoServer.printUserInput();
        assertEquals("", spyConsole.printedMessage());
    }

    @Test
    public void readsSeveralInputs() {
        spyConsole.userInputs(new String[] {"hi", "bye", "exit"});
        echoServer.run();
        assertEquals("hibye", spyConsole.printedMessage());
    }
}