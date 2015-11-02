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
        String message = "";

        do {
            message = singleLoop(message);
        } while (!userTypedExit(message));
    }

    public String singleLoop(String lastMessage) {
        setOutput(lastMessage);
        return getInput();
    }

    private void setOutput(String message) {
        console.write(message);
    }

    private String getInput() {
        setOutput(PROMPT);
        return console.read();
    }

    boolean userTypedExit(String message) {
        return message.equals("exit");
    }
}
