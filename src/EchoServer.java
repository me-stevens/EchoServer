/**
 * Created by admin on 29/10/15.
 */

public class EchoServer {

    private Console console;

    public EchoServer(Console console) {
        this.console = console;
    }

    public void run() {

        console.write(console.read());

    }


}
