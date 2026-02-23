import components.sequence.Sequence;
import components.sequence.Sequence1L;

public class TaskManagerConcept {
    private Sequence<String> tasks;

    public TaskManagerConcept() {
        this.tasks = new Sequence1L<String>();
    }

    /**
     * adds Task t to the end of this.
     *
     * @param t
     *            the Task to be added
     */
    public void addTask(String t) {
        this.tasks.add(this.tasks.length(), t);
    }

    /**
     * Removes Task t from this.
     *
     * @param t
     *            the Task to be removed
     * @return the removed Task
     */
    public String removeTask(String t) {
        Sequence<String> temp = this.tasks.newInstance();
        int index = 0;
        int i = 0;
        /*
         * find the index of the Task to be removed
         */
        while (i < this.tasks.length()) {
            if (this.tasks.entry(i).equals(t)) {
                index = i;
            }
            temp.add(temp.length(), this.tasks.remove(i));
            i++;
        }
        /*
         * remove the Task
         */
        String removed = temp.remove(index);
        i = 0;
        /*
         * restore this
         */
        while (i < temp.length()) {
            this.tasks.add(this.tasks.length(), temp.remove(i));
            i++;
        }
        return removed;
    }

    /**
     * Replaces the title of Task t with r.
     *
     * @param t
     *            the Task whose title will be changed
     * @param r
     *            the new title of t
     */
    public void updateTask(String t, String r) {
        int index = 0;
        int i = 0;
        /*
         * find the index of the Task to be updated
         */
        while (i < this.tasks.length()) {
            if (this.tasks.entry(i).equals(t)) {
                index = i;
            }
        }
        /*
         * replace the Task with the r
         */
        this.tasks.replaceEntry(index, r);
    }
}
