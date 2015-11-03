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
        spyConsole.setInput("hi");
        assertEquals("hi", echoServer.getInput());
        assertTrue(spyConsole.readMethodWasCalled());
    }

    @Test
    public void anyMessageIsPrinted() {
        echoServer.printMessage("hi");
        assertEquals("hi", spyConsole.printedMessage());
        assertTrue(spyConsole.writeMethodWasCalled());
    }

    @Test
    public void userInputIsPrinted() {
        spyConsole.setInput("hi");
        echoServer.printUserInput();
        assertEquals("hi", spyConsole.printedMessage());
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