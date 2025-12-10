package commands;

public interface Command {
    String execute(String args);
    String getName();
    String getDescription();
}
