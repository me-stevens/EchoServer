import com.sun.javafx.image.impl.BaseByteToIntConverter;
import org.junit.Test;

import java.io.*;

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
        ByteArrayOutputStream storeBytesHere = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(storeBytesHere);

        EchoConsole echoConsole = new EchoConsole(null, out);
        echoConsole.write("Hello");

        assertEquals("Hello\n", storeBytesHere.toString());
    }
}
