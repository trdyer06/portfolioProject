public class Task {
    private String name;

    private String date;

    private String category;

    public Task() {
        this.name = "";
        this.date = "";
        this.category = "";
    }

    public Task(String n) {
        this.name = n;
        this.date = "";
        this.category = "";
    }

    public Task(String n, String d) {
        this.name = n;
        this.date = d;
        this.category = "";
    }

    public Task(String n, String d, String c) {
        this.name = n;
        this.date = d;
        this.category = c;
    }

    public void setName(String n) {
        this.name = n;
    }

    public void setDate(String d) {
        this.date = d;
    }

    public void setCategory(String c) {
        this.category = c;
    }

    public String getName() {
        return this.name;
    }

    public String getDate() {
        return this.date;
    }

    public String getCategory() {
        return this.category;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.date + ", " + this.category;
    }
}
