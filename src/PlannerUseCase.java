import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Use case demonstrating the effectiveness of TaskManager as a daily planner
 * for a user.
 */
public final class PlannerUseCase {

        /**
         * Private constructor.
         */
        private PlannerUseCase() {
                /*
                 * should not be instantiated
                 */
        }

        /**
         * Main method.
         *
         * @param args
         */
        public static void main(String[] args) {
                TaskManager dailyPlanner = new TaskManagerOnSequence();
                dailyPlanner.addTask(new Task("Software HW", "04/24/26",
                                "School", false));
                dailyPlanner.addTask(new Task("Foundations HW", "05/04/26",
                                "School", false));
                dailyPlanner.addTask(new Task("Moring Shift", "04/21/26",
                                "Work", true));
                dailyPlanner.addTask(new Task("Workout", "04/21/26", "Health",
                                true));
                dailyPlanner.addTask(
                                new Task("Run", "04/21/26", "Health", false));

                SimpleWriter out = new SimpleWriter1L();
                out.println("Number of Tasks: " + dailyPlanner.size() + "\n");
                Task t = dailyPlanner.removeTask("Software HW");
                out.println("Before updateStatus: " + t);
                dailyPlanner.addTask(t);
                dailyPlanner.updateStatus("Software HW");
                t = dailyPlanner.removeTask("Software HW");
                dailyPlanner.addTask(t);
                out.println("After updateStatus: " + t + "\n");
                out.println("Current TaskManager: " + dailyPlanner + "\n");
                out.println("Incomplete Tasks: "
                                + dailyPlanner.incompleteTasks());
                out.println("Updated TaskManager: " + dailyPlanner + "\n");
                out.println("Tasks by Date: " + dailyPlanner.tasksByDate());
                out.println("Updated TaskManager: " + dailyPlanner + "\n");
                out.println("Tasks in \"School\" Category: "
                                + dailyPlanner.tasksInCategory("School"));
                out.println("Updated TaskManager: " + dailyPlanner + "\n");

                out.close();
        }
}
