package dude.task;

import dude.exception.InvalidTaskDataException;

/**
 * ToDo task.
 */
public class ToDoTask extends Task {
    /**
     * Constructs new ToDo task.
     *
     * @param description Description of task.
     */
    public ToDoTask(String description) {
        super(description);
    }

    /**
     * Constructs new ToDo task, specifying completion status.
     *
     * @param description Description of task.
     * @param isDone      Boolean representing task completion status.
     */
    public ToDoTask(String description, boolean isDone) {
        super(description, isDone);
    }

    /**
     * Parses save file data into a To Do task instance.
     *
     * @param data Line from save file.
     * @return Task instance.
     * @throws InvalidTaskDataException If data is not in the expected format.
     */
    public static ToDoTask fromData(String data) throws InvalidTaskDataException {
        /*
           expected format:
           completed: 1, incomplete: 0
           todo: T || 1/0 || description
        */
        // read sections from text
        String[] splitData = data.split(DELIMITER_REGEX, 3);
        if (splitData.length < 3) {
            throw new InvalidTaskDataException();
        }
        String taskType = splitData[0];
        String taskCompleted = splitData[1];
        String taskDescription = splitData[2];

        // convert text to properties
        if (!taskCompleted.equals("1") && !taskCompleted.equals("0")) {
            throw new InvalidTaskDataException();
        }
        boolean isCompleted = taskCompleted.equals("1");
        return new ToDoTask(taskDescription, isCompleted);
    }

    /**
     * Gets Todo task formatted with type and status icon.
     *
     * @return Task formatted as a string.
     */
    @Override
    public String toString() {
        return "<T>" + super.toString();
    }

    /**
     * Parses To Do task instance into save file string data.
     *
     * @return {@inheritDoc}
     */
    @Override
    public String toData() {
        /*
           expected format:
           completed: 1, incomplete: 0
           todo: T || 1/0 || description
        */
        String taskCompleted = this.isDone ? "1" : "0";
        return String.join(DELIMITER, "T", taskCompleted, this.description) + "\n";
    }
}
