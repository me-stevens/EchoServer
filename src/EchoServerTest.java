/**
 * Created by admin on 29/10/15.
 */

import org.junit.Before;
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
        assertEquals(promptmsg, spyConsole.printedMessage());
    }

    @Test
    public void printsMessageUntilExit() {
        String[] messages = new String[] {"hello", "exit"};
        spyConsole.userInput(messages);
        echoServer.run();
        assertEquals(printed(messages), spyConsole.printedMessage());
        assertEquals(2, spyConsole.timesReadWasCalled());
    }

    @Test
    public void printsMessagesUntilExit() {
        String[] messages = new String[] {"hello", "goodbye", "exit"};
        spyConsole.userInput(messages);
        echoServer.run();
        assertEquals(printed(messages), spyConsole.printedMessage());
        assertEquals(3, spyConsole.timesReadWasCalled());
    }

    private String printed(String[] messages) {
        String output = promptmsg;
        for (int i=0; i<messages.length-1; i++) {
            output += messages[i] + promptmsg;
        }
        return output;
    }
}