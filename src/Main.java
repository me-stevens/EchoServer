/**
 * Created by admin on 29/10/15.
 */
public class Main {

    public static void main(String[] args) {

        EchoServer echoServer = new EchoServer(new EchoConsole(System.in, System.out));
        echoServer.run();

    }
}
