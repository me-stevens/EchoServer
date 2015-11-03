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
        String message = promptForInput();
        setOutput(message);
        return message;
    }

    private void promptUser() {
        console.write(PROMPT);
    }

    private String getInput() {
        return console.read();
    }

    public String promptForInput() {
        promptUser();
        return getInput();
    }

    public void setOutput(String message) {
        if (!userTypedExit(message)) {
            console.write(message);
        }
    }

    private boolean userTypedExit(String message) {
        return message.equals("exit");
    }
}
