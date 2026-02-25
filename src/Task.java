public class Task {

    /**
     * The name of this Task,
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
    private String status;

    /**
     * No-argument constructor.
     */
    public Task() {
        this.name = "Task";
        this.date = "01/01/26";
        this.category = "category";
        this.status = "incomplete";
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
        this.status = "incomplete";
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
        this.status = "incomplete";
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
        this.status = "incomplete";
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
    public Task(String n, String d, String c, String s) {
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

    public void setStatus(String s) {
        if (s.equals("complete") || s.equals("in progress")
                || s.equals("incomplete")) {
            this.status = s;
        }
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

    @Override
    public String toString() {
        return this.name + ", " + this.date + ", " + this.category + ", "
                + this.status;
    }
}
