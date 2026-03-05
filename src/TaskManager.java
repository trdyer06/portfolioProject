public interface TaskManager extends TaskManagerKernel {

    /**
     * Creates a {@code TaskManager} of {@code Task}s from {@code this} which
     * have a status of incomplete and reports the {@code TaskManager}.
     *
     * @return the {@code TaskManager} containing {@code Task}s with a status of
     *         incomplete
     */
    TaskManager incompleteTasks();

    /**
     * Creates a {@code TaskManager} of {@code Task}s from {@code this} which
     * have a cateogory named {@code c} and reports the {@code TaskManager}.
     *
     * @param c
     *            the name of the category to be searched for
     * @return the {@code TaskManager} containing {@code Task}s with a category
     *         named {@code c}
     */
    TaskManager tasksInCategory(String c);

    /**
     * Creates a {@code TaskManager} of the {@code Task}s in {@code this} sorted
     * by their dates and reports the {@code TaskManager}.
     *
     * @return the {@code TaskManager} containing {@code Task}s sorted by date
     */
    TaskManager tasksByDate();
}
