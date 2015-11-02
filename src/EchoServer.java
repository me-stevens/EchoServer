public class EchoServer {

    private Console console;

    public EchoServer(Console console) {
        this.console = console;
    }

    public static void main(String[] args) {

        EchoServer echoServer = new EchoServer(new EchoConsole(System.in, System.out));
        echoServer.run();

    }

    public void run() {

        console.write("Print something to echo (exit quits): ");
        String message = console.read();

        if ( !message.equals("exit") ) {
            console.write(message);
            run();
        }
    }
}
