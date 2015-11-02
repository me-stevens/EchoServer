public class EchoServer {

    public static final String PROMPT = "Please print something to echo (exit quits): ";
    private Console console;

    public EchoServer(Console console) {
        this.console = console;
    }

    public static void main(String[] args) {

        EchoServer echoServer = new EchoServer(new EchoConsole(System.in, System.out));
        echoServer.run();

    }

    public void run() {

        String message = getInput();

        if ( !message.equals("exit") ) {
            console.write(message);
            run();
        }
    }

    private String getInput() {
        console.write(PROMPT);
        return console.read();
    }
}
