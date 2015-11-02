import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class EchoConsole implements Console {

    private InputStream in;
    private PrintStream out;

    public EchoConsole(InputStream in, PrintStream out) {
        this.in  = in;
        this.out = out;
    }

    @Override
    public String read() {
        return new Scanner(in).nextLine();
    }

    @Override
    public void write(String message) {
        out.println(message);
    }
}
