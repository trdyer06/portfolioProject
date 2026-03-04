public interface TaskManager extends TaskManagerKernel {

    TaskManager incompleteTasks();

    TaskManager tasksInCategory(String c);

    TaskManager tasksByDate();
}
