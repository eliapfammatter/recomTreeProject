package commands;

import java.util.Map;

public class Help implements Command {
    private final Map<String, Command> commands;

    // Constructor injection: The Help command receives the map of all commands
    public Help(Map<String, Command> commands) {
        this.commands = commands;
    }

    @Override
    public String execute(String args) {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Available Commands ===\n");

        for (Command cmd : commands.values()) {
            sb.append(String.format("%-15s : %s\n", cmd.getName(), cmd.getDescription()));
        }

        return sb.toString();
    }

    @Override
    public String getDescription() {
        return "Lists all available commands and their descriptions.";
    }

    @Override
    public String getName() {
        return "HELP";
    }
}