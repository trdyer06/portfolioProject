import components.standard.Standard;

/**
 * Task manager kernel component with primary methods.
 */
public interface TaskManagerKernel extends Standard<TaskManager> {

    /**
     * Adds {@code t} to {@code this}.
     *
     * @param t
     *            the Task to be added
     * @updates this
     * @requires t is not in this
     * @ensures this = #this * <t>
     */
    void addTask(Task t);

    /**
     * Removes the {@code Task} named {@code n} from {@code this} and reports
     * the {@code Task}.
     *
     * @param n
     *            the name of the {@code Task} to be removed
     * @return the {@code Task} that was removed
     * @updates this
     * @requires a Task with name n is in this
     * @ensures removeTask = the Task with name n and this = #this \ task named
     *          n
     */
    Task removeTask(String n);

    /**
     * Removes an arbitrary {@code Task} from {@code this}.
     *
     * @return the {@code Task} that was removed
     * @updates this
     * @requires |this| > 0
     * @ensures removeAny = a Task in #this and this = #this \ removeAny
     */
    Task removeAny();

    /**
     * Updates the completion status of the {@code Task} named {@code n}.
     *
     * @param n
     *
     *            the name of the {@code Task} to be updated
     * @updates this
     * @requires a Task with name n is in this
     * @ensures if the Task named n was incomplete it will be complete and if
     *          the Task named n was complete it will be incomplete
     */
    void updateStatus(String n);

    /**
     * Reports whether a {@code Task} named {@code n} is in {@code this}.
     *
     * @param n
     *            the name of the {@code Task} to be searched for
     * @return true if a {@code Task} named {@code n} is in {@code this}
     * @ensures contains = whether a Task named n is in this
     */
    boolean contains(String n);

    /**
     * Reports the number of {@code Task}s in {@code this}.
     *
     * @return the number of {@code Task}s in {@code this}
     * @ensures size = |this|
     */
    int size();
}
