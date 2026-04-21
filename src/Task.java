/**
 * Represents a Task with a name, deadline date, category, and completion
 * status.
 */
public class Task {
    /**
     * The name of this Task.
     */
    private String name;

    /**
     * The deadline for this Task.
     */
    private String date;

    /**
     * The category of this Task.
     */
    private String category;

    /**
     * This completion status of this Task.
     */
    private boolean status;

    /**
     * No-argument constructor.
     */
    public Task() {
        this.name = "Task";
        this.date = "01/01/26";
        this.category = "category";
        this.status = false;
    }

    /**
     * 1-argument constructor.
     *
     * @param n
     *            String assigned to name
     */
    public Task(String n) {
        this.name = n;
        this.date = "01/01/26";
        this.category = "category";
        this.status = false;
    }

    /**
     * 2-argument constructor.
     *
     * @param n
     *            String assigned to name
     * @param d
     *            String assigned to date
     */
    public Task(String n, String d) {
        this.name = n;
        this.setDate(d);
        this.category = "category";
        this.status = false;
    }

    /**
     * 3-argument constructor.
     *
     * @param n
     *            String assigned to name
     * @param d
     *            String assigned to date
     * @param c
     *            String assigned to category
     */
    public Task(String n, String d, String c) {
        this.name = n;
        this.setDate(d);
        this.category = c;
        this.status = false;
    }

    /**
     * 4-argument constructor.
     *
     * @param n
     *            String assigned to name
     * @param d
     *            String assigned to date
     * @param c
     *            String assigned to category
     * @param s
     *            String assigned to status
     */
    public Task(String n, String d, String c, boolean s) {
        this.name = n;
        this.setDate(d);
        this.category = c;
        this.setStatus(s);
    }

    /**
     * Sets the name of this Task to n.
     *
     * @param n
     *            String assigned to name
     */
    public void setName(String n) {
        this.name = n;
    }

    /**
     * Sets the date of this Task to d.
     *
     * @param d
     *            String assigned to date
     */
    public void setDate(String d) {
        if (d.indexOf("/") == 2
                && d.substring(3, d.length()).indexOf("/") == 2) {
            this.date = d;
        }
    }

    /**
     * Sets the category of this Task to c.
     *
     * @param c
     *            String assigned to category
     */
    public void setCategory(String c) {
        this.category = c;
    }

    /**
     * Sets the status of this to s.
     *
     * @param s
     *            the boolean assigned to status
     */
    public void setStatus(boolean s) {
        this.status = s;
    }

    /**
     * Reports the name of this Task.
     *
     * @return the name of this
     */
    public String getName() {
        return this.name;
    }

    /**
     * Reports the date of this Task.
     *
     * @return the date of this
     */
    public String getDate() {
        return this.date;
    }

    /**
     * Reports the category of this Task.
     *
     * @return the category of this
     */
    public String getCategory() {
        return this.category;
    }

    /**
     * Reports whether this is complete or incomplete.
     *
     * @return the status of this
     */
    public boolean getStatus() {
        return this.status;
    }

    /*
     * Common methods ----------------------------------------------------------
     */

    @Override
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Task)) {
            return false;
        }
        Task t = (Task) obj;
        if (!(this.name.equals(t.name))) {
            return false;
        }
        if (!(this.date.equals(t.date))) {
            return false;
        }
        if (!(this.category.equals(t.category))) {
            return false;
        }
        if (!(this.status == t.status)) {
            return false;
        }
        return true;
    }

    @Override
    public final int hashCode() {
        final int prime = 17;
        int result = 1;
        result = prime * result + this.name.hashCode();
        result = prime * result + this.date.hashCode();
        result = prime * result + this.category.hashCode();
        return result;
    }

    @Override
    public final String toString() {
        String toString = "";
        if (this.status) {
            toString = this.name + ", " + this.date + ", " + this.category
                    + ", complete";
        } else {
            toString = this.name + ", " + this.date + ", " + this.category
                    + ", incomplete";
        }
        return toString;
    }
}
