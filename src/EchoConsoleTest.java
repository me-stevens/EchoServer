import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class EchoConsoleTest {

    @Test
    public void readMethodReadsAString() {
        InputStream in = new ByteArrayInputStream("Hello".getBytes());
        EchoConsole echoConsole = new EchoConsole(in, null);

        assertEquals("Hello", echoConsole.read());
    }

    @Test
    public void writeMethodWritesAString() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outputStream);

        EchoConsole echoConsole = new EchoConsole(null, out);
        echoConsole.write("Hello");

        assertEquals("Hello\n", outputStream.toString());
    }
}
