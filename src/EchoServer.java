/**
 * Created by admin on 29/10/15.
 */

public class EchoServer {

    private Console console;

    public EchoServer(Console console) {
        this.console = console;
    }

    public void run() {

        String message = "";

        while ( message != null )  {
            message = console.read();
            if ( message.equals("exit") ) {
                break;
            }
            console.write(message);
        }
    }
}



//            console.write("Please enter message to echo:");
