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

    @Before
    public void setUp() throws Exception {
        spyConsole = new SpyConsole();
        echoServer = new EchoServer(spyConsole);
    }

    @Test
    public void readMethodWasNotCalled() {
        assertThat(spyConsole.readMethodWasCalled(), is(false));
    }

    @Test
    public void readMethodWasCalled() {
        echoServer.run();
        assertThat(spyConsole.readMethodWasCalled(), is(true));
    }

    @Test
    public void writeMethodWasNotCalled() {
        assertThat(spyConsole.writeMethodWasCalled(), is(false));
    }

    @Test
    public void writeMessageWasCalled() {
        echoServer.run();
        assertThat(spyConsole.writeMethodWasCalled(), is(true));
    }

    @Test
    public void theUserInputWasPrinted() {
        spyConsole.userInput("Hello");
        echoServer.run();
        assertEquals("Hello", spyConsole.printedMessage());
    }

    @Test
    public void messageIsNotPrintedIfUserTypesExit() {
        spyConsole.userInput("exit");
        echoServer.run();
        assertEquals(null, spyConsole.printedMessage());
    }
}