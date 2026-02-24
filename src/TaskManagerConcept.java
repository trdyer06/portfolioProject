import java.util.Iterator;

import components.sequence.Sequence;
import components.sequence.Sequence1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

public class TaskManagerConcept implements Iterable<String> {
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

    /**
     * Reports the number of elements in this.
     *
     * @return the length of this
     */
    public int length() {
        return this.tasks.length();
    }

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        TaskManagerConcept manager = new TaskManagerConcept();
        SimpleWriter out = new SimpleWriter1L();
        SimpleReader in = new SimpleReader1L();
        out.println("Add Task (a)\nRemove Task (r)\nUpdate Task (u)");
        String input = in.nextLine();
        while (!(input.equals("a") && input.equals("b") && input.equals("c"))) {
            String name = "";
            if (input.equals("a")) {
                out.print("Enter task name: ");
                name = in.nextLine();
                manager.addTask(name);
            } else if (input.equals("b")) {
                out.print("Name of task being removed: ");
                name = in.nextLine();
                manager.removeTask(name);
            } else {
                out.print("Name of task being updated: ");
                name = in.nextLine();
                out.print("Enter new task name: ");
                String replace = in.nextLine();
                manager.updateTask(name, replace);
            }
            for (String s : manager) {
                out.print(s + ", ");
            }
            out.println("Length: " + manager.length());
            out.println();
            out.println("Add Task (a)\nRemove Task (r)\nUpdate Task (u)");
            input = in.nextLine();
        }
    }

    @Override
    public Iterator<String> iterator() {
        Sequence<String> copy = this.tasks.newInstance();
        copy.transferFrom(this.tasks);
        return copy.iterator();
    }
}
