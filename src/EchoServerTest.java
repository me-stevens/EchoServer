import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class EchoServerTest {

    private SpyConsole spyConsole;
    private EchoServer echoServer;

    @Before
    public void setUp() {
        spyConsole = new SpyConsole();
        echoServer = new EchoServer(spyConsole);
    }

    @Test
    public void userInputIsRead() {
        String message = "hi";
        spyConsole.setInput(message);
        assertEquals(message, echoServer.getInput());
        assertTrue(spyConsole.readMethodWasCalled());
    }

    @Test
    public void anyMessageIsPrinted() {
        String message = "hi";
        echoServer.printMessage(message);
        assertEquals(message, spyConsole.printedMessage());
        assertTrue(spyConsole.writeMethodWasCalled());
    }

    @Test
    public void userInputIsPrinted() {
        String message = "hi";
        spyConsole.setInput(message);
        echoServer.printUserInput();
        assertEquals(message, spyConsole.printedMessage());
    }

    @Test
    public void ifUserTypesExitNothingIsPrinted() {
        spyConsole.setInput("exit");
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