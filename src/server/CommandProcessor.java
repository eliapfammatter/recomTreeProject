package server;

import commands.*;
import recommendation.GenreBasedStrategy;
import recommendation.TopRatedStrategy; // Assuming you created this from the previous step
import java.util.HashMap;
import java.util.Map;

public class CommandProcessor {
    private final Map<String, Command> commandMap;
    private String genre;

    public CommandProcessor() {
        commandMap = new HashMap<>();
        registerCommands();
    }

    private void registerCommands() {
        // Pass the commandMap to Help so it can list all registered commands
        commandMap.put("HELP", new Help(commandMap));

        // Register other commands
        commandMap.put("QUIT", new Quit());
        commandMap.put("ADD_MOVIE", new AddMovie());
        commandMap.put("RATE_MOVIE", new RateMovie());
        commandMap.put("SEARCH_MOVIE", new SearchMovie());
        commandMap.put("LIST_SUBTREE", new ListSubtree());
        commandMap.put("RECOMMEND_TOP", new Recommend(new TopRatedStrategy()));
        commandMap.put("RECOMMEND_GENRE", new Recommend(new GenreBasedStrategy(genre)));
    }

    public String process(String input) {
        if (input == null || input.trim().isEmpty()) {
            return "Error: Empty command.";
        }

        // Split the input into two parts: COMMAND and ARGUMENTS
        // Example: "ADD_MOVIE Inception SciFi" -> ["ADD_MOVIE", "Inception SciFi"]
        String[] parts = input.trim().split("\\s+", 2);
        String commandName = parts[0].toUpperCase();
        String arguments = parts.length > 1 ? parts[1] : "";

        Command command = commandMap.get(commandName);

        if (command != null) {
            return command.execute(arguments);
        } else {
            return "Error: Unknown command '" + commandName + "'. Type HELP for a list.";
        }
    }
}