public class EchoServer {

    public static final String PROMPT = "Type something ('exit' to quit)";
    private Console console;

    public EchoServer(Console console) {
        this.console = console;
    }

    public static void main(String[] args) {
        EchoServer echoServer = new EchoServer(new EchoConsole(System.in, System.out));
        echoServer.run();
    }

    public void run() {
        String message = "";

        do {
            message = printUserInput();
        } while (!userTypedExit(message));
    }

    public String printUserInput() {
        String message = getInput();
        printMessage(message);
        return message;
    }

    private void promptUser() {
        console.write(PROMPT);
    }

    public String getInput() {
        promptUser();
        return console.read();
    }

        if (!userTypedExit(message)) {
    public void printMessage(String message) {
            console.write(message);
        }
    }

    private boolean userTypedExit(String message) {
        return message.equals("exit");
    }
}
