import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
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
    public void writeMethodWasCalled() {
        echoServer.singleLoop("hi");
        assertThat(spyConsole.writeMethodWasCalled(), is(true));
    }

    @Test
    public void readMethodWasCalled() {
        String message = "hi";
        spyConsole.userInput(new String[] {message});
        echoServer.singleLoop(message);
        assertThat(spyConsole.readMethodWasCalled(), is(true));
    }

    @Test
    public void userExits() {
        assertTrue(echoServer.userTypedExit("exit"));
    }

    @Test
    public void userKeepsTyping() {
        assertFalse(echoServer.userTypedExit("hi"));
    }

    @Test
    public void userInputIsPrinted() {
        String message = "hi";
        spyConsole.userInput(new String[] {message});
        echoServer.singleLoop(message);
        assertEquals(message, spyConsole.printedMessage());
    }
}