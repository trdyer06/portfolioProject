import java.util.Iterator;

import components.sequence.Sequence1L;

/**
 * TaskManager represented as a Sequence<Task> with implementations of primary
 * methods.
 *
 * @convention [each Task in $this.rep has a unique name]
 * @correspondence this = [value of $this.rep]
 */
public class TaskManagerOnSequence extends TaskManagerSecondary {

    /*
     * Private members ---------------------------------------------------------
     */

    /**
     * Representation of this.
     */
    private Sequence1L<Task> rep;

    /**
     * Creator of initial representation.
     */
    private void createNewRep() {
        this.rep = new Sequence1L<Task>();
    }

    /*
     * Constructors ------------------------------------------------------------
     */

    /**
     * No argument constructor.
     */
    public TaskManagerOnSequence() {
        this.createNewRep();
    }

    /*
     * Standard methods --------------------------------------------------------
     */

    @Override
    public final TaskManagerOnSequence newInstance() {
        try {
            return this.getClass().getConstructor().newInstance();
        } catch (ReflectiveOperationException e) {
            throw new AssertionError(
                    "Cannot construct object of type " + this.getClass());
        }
    }

    @Override
    public final void clear() {
        this.createNewRep();
    }

    @Override
    public final void transferFrom(TaskManager t) {
        TaskManagerOnSequence source = (TaskManagerOnSequence) t;
        this.rep = source.rep;
        source.createNewRep();
    }

    /*
     * Kernel methods ----------------------------------------------------------
     */

    @Override
    public final void addTask(Task t) {
        this.rep.add(this.rep.length(), t);
    }

    @Override
    public final Task removeTask(String n) {
        int index = 0;
        for (int i = 0; i < this.rep.length(); i++) {
            if (this.rep.entry(i).getName().equals(n)) {
                index = i;
            }
        }
        return this.rep.remove(index);
    }

    @Override
    public final Task removeAny() {
        return this.rep.remove(0);
    }

    @Override
    public final void updateStatus(String n) {
        int index = 0;
        for (int i = 0; i < this.rep.length(); i++) {
            if (this.rep.entry(i).getName().equals(n)) {
                index = i;
            }
        }
        Task t = this.rep.remove(index);
        t.setStatus(!t.getStatus());
        this.rep.add(index, t);
    }

    @Override
    public final boolean contains(String n) {
        boolean contains = false;
        for (Task t : this.rep) {
            if (t.getName().equals(n)) {
                contains = true;
            }
        }
        return contains;
    }

    @Override
    public final int size() {
        return this.rep.length();
    }

    /*
     * Iterator ----------------------------------------------------------------
     */

    /**
     * Implementation of Iterator interface for TaskManagerOnSequence
     */
    private final class TaskManagerOnSequenceIterator
            implements Iterator<Task> {

    }
}
