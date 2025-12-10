package commands;

public class Quit implements Command {

    @Override
    public String execute(String args) {
        return "Goodbye! Closing connection...";
    }

    @Override
    public String getName() {
        return "QUIT";
    }

    @Override
    public String getDescription() {
        return "Disconnects from the server.";
    }
}