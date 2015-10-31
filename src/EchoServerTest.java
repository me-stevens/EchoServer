/**
 * Created by admin on 29/10/15.
 */

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class EchoServerTest {

    private SpyConsole spyConsole;
    private EchoServer echoServer;
    private String promptmsg;

    @Before
    public void setUp() throws Exception {
        spyConsole = new SpyConsole();
        echoServer = new EchoServer(spyConsole);
        promptmsg  = "Print something to echo (exit quits): ";
    }

    @Test
    public void readMethodWasNotCalled() {
        assertThat(spyConsole.readMethodWasCalled(), is(false));
    }

    @Test
    public void writeMethodWasNotCalled() {
        assertThat(spyConsole.writeMethodWasCalled(), is(false));
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
        String messages = promptmsg + "hello" + promptmsg;
        assertEquals(messages, spyConsole.printedMessage());
        assertEquals(2, spyConsole.timesReadWasCalled());
    }

    @Test
    public void printsMessagesUntilExit() {
        spyConsole.userInput(new String[] {"hello", "goodbye", "exit"});
        echoServer.run();
        String messages = promptmsg + "hello" + promptmsg + "goodbye" + promptmsg;
        assertEquals("hellogoodbye", spyConsole.printedMessage());
        assertEquals(3, spyConsole.timesReadWasCalled());
    }
}