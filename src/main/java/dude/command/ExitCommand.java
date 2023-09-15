package dude.command;

import dude.Storage;
import dude.Ui;
import dude.task.TaskList;

/**
 * Command to exit Dude.
 */
public class ExitCommand extends DudeCommand {
    private static final String GOODBYE_MSG =
            "Bye. Hope to see you again soon!";

    /**
     * Prints goodbye message and exits.
     */
    @Override
    public String execute(TaskList taskList, Storage storage) {
        return GOODBYE_MSG;
    }

    /**
     * {@inheritDoc}
     *
     * @return True.
     */
    @Override
    public boolean isExit() {
        return true;
    }
}
