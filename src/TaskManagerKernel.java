import components.standard.Standard;

public interface TaskManagerKernel extends Standard<TaskManager> {

    /**
     * Adds {@code T} to {@code this}.
     *
     * @param t
     *            the name of the {@code Task} to be added
     */
    void addTask(Task t);

    /**
     * Removes the {@code Task} named {@code n} from {@code this} and reports
     * the {@code Task}.
     *
     * @param n
     *            the name of the {@code Task} to be removed
     * @return the {@code Task} that was removed
     */
    Task removeTask(String n);

    /**
     * Updates the completion status of the {@code Task} named {@code n}.
     *
     * @param n
     *
     *            the name of the {@code Task} to be updated
     */
    void updateStatus(String n);

    /**
     * Reports whether a {@code Task} named {@code n} is in {@code this}.
     *
     * @param n
     *            the name of the {@code Task} to be searched for
     * @return true if a {@code Task} named {@code n} is in {@code this}
     */
    boolean contains(String n);

    /**
     * Reports the number of {@code Task}s in {@code this}.
     *
     * @return the number of {@code Task}s in {@code this}
     */
    int size();
}
