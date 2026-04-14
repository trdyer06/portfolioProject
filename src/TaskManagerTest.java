public final class TaskManagerTest {

    private TaskManagerTest() {
        // no instantiation
    }

    public static void main(String[] args) {

        // CHANGE THIS to your actual implementation class
        TaskManager tm = new TaskManagerOnSequence();

        System.out.println("=== ADD TASKS ===");

        Task t1 = new Task("HW1", "04/15/26", "school", false);
        Task t2 = new Task("Gym", "04/14/26", "fitness", false);
        Task t3 = new Task("Groceries", "04/14/26", "errands", false);

        tm.addTask(t1);
        tm.addTask(t2);
        tm.addTask(t3);

        System.out.println("Size (expected 3): " + tm.size());

        System.out.println("\n=== CONTAINS TEST ===");
        System.out.println("Contains Gym (true): " + tm.contains("Gym"));
        System.out.println("Contains Sleep (false): " + tm.contains("Sleep"));

        System.out.println("\n=== UPDATE STATUS TEST ===");
        tm.updateStatus("Gym");
        System.out.println("After updating Gym:");
        for (Task t : tm) {
            System.out.println(t);
        }

        System.out.println("\n=== REMOVE ANY TEST ===");
        Task any = tm.removeAny();
        System.out.println("Removed any: " + any);
        System.out.println("Size now: " + tm.size());

        System.out.println("\n=== FINAL CONTENTS ===");
        for (Task t : tm) {
            System.out.println(t);
        }

        System.out.println("\n=== TO STRING ===");
        System.out.println(tm);

        System.out.println("\n=== EQUALS / HASHCODE TEST ===");

        TaskManager tm2 = new TaskManagerOnSequence();

        tm2.addTask(new Task("Groceries", "04/14/26", "errands", false));

        System.out.println("tm equals tm2: " + tm.equals(tm2));
        System.out.println("tm hashCode: " + tm.hashCode());
        System.out.println("tm2 hashCode: " + tm2.hashCode());
    }
}