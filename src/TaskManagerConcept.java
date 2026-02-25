import java.util.Iterator;

import components.sequence.Sequence;
import components.sequence.Sequence1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

public class TaskManagerConcept implements Iterable<Task> {
    private Sequence<Task> tasks;

    /**
     * Creator of initial representation.
     */
    private void createNewRep() {
        this.tasks = new Sequence1L<Task>();
    }

    /**
     * No-argument constructor.
     */
    public TaskManagerConcept() {
        this.createNewRep();
    }

    /**
     * adds Task t to the end of this.
     *
     * @param t
     *            the Task to be added
     */
    public void addTask(Task t) {
        this.tasks.add(this.tasks.length(), t);
    }

    /**
     * Removes Task t from this.
     *
     * @param t
     *            the Task to be removed
     * @return the removed Task
     */
    public Task removeTask(String t) {
        Task removed = new Task();
        int i = 0;
        /*
         * find the index of the Task to be removed
         */
        while (i < this.tasks.length()) {
            String name = this.tasks.entry(i).getName();
            if (name.equals(t)) {
                removed = this.tasks.remove(i);
            }
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
        int index = -1;
        int i = 0;
        /*
         * find the index of the Task to be updated
         */
        while (i < this.tasks.length()) {
            if (this.tasks.entry(i).equals(t)) {
                index = i;
            }
            i++;
        }
        /*
         * replace the Task with the r
         */
        if (index >= 0) {
            Task task = this.tasks.remove(index);
            task.setName(r);
            this.tasks.add(index, task);
        }
    }

    /**
     * Reports the number of elements in this.
     *
     * @return the length of this
     */
    public int length() {
        return this.tasks.length();
    }

    @Override
    public Iterator<Task> iterator() {
        return this.tasks.iterator();
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
        while (input.equals("a") || input.equals("r") || input.equals("u")) {
            String name = "";
            String date = "";
            String category = "";
            if (input.equals("a")) {
                out.print("Enter task name: ");
                name = in.nextLine();
                out.print("Enter task date: ");
                date = in.nextLine();
                out.print("Enter task category: ");
                category = in.nextLine();
                manager.addTask(new Task(name, date, category));
            } else if (input.equals("r")) {
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
            for (Task t : manager) {
                out.print(t + "; ");
            }
            out.println("Length: " + manager.length());
            out.println();
            out.println("Add Task (a)\nRemove Task (r)\nUpdate Task (u)");
            input = in.nextLine();
        }
        out.println("Final Task Manager");
        for (Task t : manager) {
            out.print(t + "; ");
        }
        out.println("Length: " + manager.length());
        out.close();
        in.close();
    }
}
