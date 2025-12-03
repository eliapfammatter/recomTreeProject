package commands;

public class Help implements Command {
    @Override
    public String execute() {
        return "";
    }

    @Override
    public String getDescription() {
        return "";
    }

    @Override
    public String getName() {
        return "Help";
    }
}
