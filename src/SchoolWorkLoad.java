/**
 * Proof-of-concept that manages school assignments using TaskManager as the
 * underlying representation.
 */
public class SchoolWorkLoad {

    /**
     * Representation of this.
     */
    private TaskManager assignments;

    /**
     * No argument constructor.
     */
    public SchoolWorkLoad() {
        this.assignments = new TaskManagerOnSequence();
    }

    /**
     * Adds an assignment to this.
     *
     * @param t
     *            Task to add
     */
    public void addAssignment(Task t) {
        this.assignments.addTask(t);
    }

    /**
     * Reports the assignments to do for a specific course.
     *
     * @param c
     *            name of course
     * @return TaskManager containing assignments for course c
     */
    public TaskManager getWorkForCourse(String c) {
        return this.assignments.tasksInCategory(c);
    }

    /**
     * Reports the assignments that have not been completed.
     *
     * @return TaskManager containing all incomplete assignments
     */
    public TaskManager getIncompleteAssignments() {
        return this.assignments.incompleteTasks();
    }
}
