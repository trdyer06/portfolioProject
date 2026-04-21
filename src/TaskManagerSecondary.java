import java.util.Iterator;

/**
 * Layered implementations of secondary methods for {@code TaskManager}.
 */
public abstract class TaskManagerSecondary implements TaskManager {

    /*
     * Secondary methods -------------------------------------------------------
     */

    /**
     * Creates a {@code TaskManager} of {@code Task}s from {@code this} which
     * have a status of incomplete and reports the {@code TaskManager}.
     *
     * @return the {@code TaskManager} containing {@code Task}s with a status of
     *         incomplete
     * @updates this
     * @ensures incompleteTasks = all Tasks with a status of incomplete in #this
     *          and this = #this \ incompleteTasks
     */
    @Override
    public TaskManager incompleteTasks() {
        TaskManager result = this.newInstance();
        TaskManager temp = this.newInstance();
        while (this.size() > 0) {
            Task t = this.removeAny();
            if (!t.getStatus()) {
                result.addTask(t);
            } else {
                temp.addTask(t);
            }
        }
        while (temp.size() > 0) {
            this.addTask(temp.removeAny());
        }
        return result;
    }

    /**
     * Creates a {@code TaskManager} of {@code Task}s from {@code this} which
     * have a category named {@code c} and reports the {@code TaskManager}.
     *
     * @param c
     *            the name of the category to be searched for
     * @return the {@code TaskManager} containing {@code Task}s with a category
     *         named {@code c}
     * @updates this
     * @ensures tasksInCategory = all Tasks with a category of c in #this and
     *          this = #this \ tasksInCategory
     */
    @Override
    public TaskManager tasksInCategory(String c) {
        TaskManager result = this.newInstance();
        TaskManager temp = this.newInstance();
        while (this.size() > 0) {
            Task t = this.removeAny();
            if (t.getCategory().equals(c)) {
                result.addTask(t);
            } else {
                temp.addTask(t);
            }
        }
        while (temp.size() > 0) {
            this.addTask(temp.removeAny());
        }
        return result;
    }

    /**
     * Creates a {@code TaskManager} of the {@code Task}s in {@code this} sorted
     * by their dates and reports the {@code TaskManager}.
     *
     * @return the {@code TaskManager} containing {@code Task}s sorted by date
     * @clears this
     * @ensures tasksByDate = all Tasks in #this sorted by date in ascending
     *          order
     */
    @Override
    public TaskManager tasksByDate() {
        TaskManager result = this.newInstance();
        TaskManager temp = this.newInstance();
        while (this.size() > 0) {
            Task earliest = this.removeAny();
            while (this.size() > 0) {
                Task t = this.removeAny();
                if (t.getDate().compareTo(earliest.getDate()) < 0) {
                    temp.addTask(earliest);
                    earliest = t;
                } else {
                    temp.addTask(t);
                }
            }
            while (temp.size() > 0) {
                this.addTask(temp.removeAny());
            }
            result.addTask(earliest);
        }
        return result;
    }

    /*
     * Common methods ----------------------------------------------------------
     */

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof TaskManager)) {
            return false;
        }
        TaskManager t = (TaskManager) obj;
        if (this.size() != t.size()) {
            return false;
        }
        Iterator<Task> it1 = this.iterator();
        Iterator<Task> it2 = t.iterator();
        while (it1.hasNext()) {
            Task x1 = it1.next();
            Object x2 = it2.next();
            if (!x1.equals(x2)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 17;
        int result = 1;
        for (Task t : this) {
            result = prime * result + t.hashCode();
        }
        return result;
    }

    @Override
    public String toString() {
        String result = "<";
        boolean first = true;
        for (Task t : this) {
            if (!first) {
                result += ", ";
            }
            result += t.toString();
            first = false;
        }
        result += ">";
        return result;
    }
}
