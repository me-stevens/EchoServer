import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by admin on 29/10/15.
 */

public class EchoConsole implements Console {

    private InputStream in;
    private PrintStream out;

    public EchoConsole(InputStream in, PrintStream out) {
        this.in  = in;
        this.out = out;
    }

    @Override
    public String read() {
        Scanner scanner = new Scanner(in);
        return scanner.nextLine();
    }

    @Override
    public void write(String message) {
        out.println(message);
    }
}
