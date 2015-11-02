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
        spyConsole.userInput(new String[] {"hi"});
        echoServer.singleLoop("hi");
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

    }

    @Test
    public void messageIsNotPrintedIfUserTypesExit() {
        spyConsole.userInput(new String[] {"exit"});
        echoServer.run();
        assertEquals("", spyConsole.printedMessage());
    }

    @Test
    public void printsMessageUntilExit() {
        spyConsole.userInput(new String[] {"hello", "exit"});
        echoServer.run();
        assertEquals("hello", spyConsole.printedMessage());
        assertEquals(2, spyConsole.timesReadWasCalled());
    }

    @Test
    public void printsMessagesUntilExit() {
        spyConsole.userInput(new String[] {"hello", "goodbye", "exit"});
        echoServer.run();
        assertEquals("hellogoodbye", spyConsole.printedMessage());
        assertEquals(3, spyConsole.timesReadWasCalled());
    }
}