import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * JUnit test fixture for TaskManagerOnSequence.
 */
public class TaskManagerOnSequenceTest extends TaskManagerTest {

    @Override
    protected final TaskManager constructorTest() {
        TaskManager tm = new TaskManagerOnSequence();
        return tm;
    }

    /**
     * Test the constructor with no arguments.
     */
    @Test
    public void constuctorTest() {
        /*
         * create TaskManagers to compare
         */
        TaskManager tm = this.constructorTest();
        TaskManager expectedTm = this.constructorTest();
        /*
         * assert the constructor creates an empty TaskManager
         */
        assertEquals(tm.size(), 0);
        assertEquals(tm, expectedTm);
    }

    /*
     * Kernel method tests -----------------------------------------------------
     */

    /**
     * Test addTask with an empty TaskManager adding 1 Task.
     */
    @Test
    public void addTaskTest1() {
        /*
         * create TaskManagers to compare
         */
        TaskManager tm = this.constructorTest();
        TaskManager expectedTm = this.constructorTest();
        /*
         * create Task to add
         */
        Task t1 = new Task("task 1", "01/01/2026", "school", false);
        /*
         * add the Task
         */
        tm.addTask(t1);
        expectedTm.addTask(t1);
        /*
         * assert the Task was added to the TaskManager
         */
        assertEquals(tm.size(), 1);
        assertEquals(tm, expectedTm);
    }

    /**
     * Test addTask with an empty TaskManager adding 2 Tasks.
     */
    @Test
    public void addTaskTest2() {
        /*
         * create TaskManagers to compare
         */
        TaskManager tm = this.constructorTest();
        TaskManager expectedTm = this.constructorTest();
        /*
         * create Tasks to add
         */
        Task t1 = new Task("task 1", "01/01/2026", "school", false);
        Task t2 = new Task("task 2", "01/31/2026", "school", true);
        /*
         * add the Tasks
         */
        tm.addTask(t1);
        tm.addTask(t2);
        expectedTm.addTask(t1);
        expectedTm.addTask(t2);
        /*
         * assert the Tasks were added to the TaskManager
         */
        assertEquals(tm.size(), 2);
        assertEquals(tm, expectedTm);
    }

    /**
     * Test removeTask with a TaskManager with 1 Task removing 1 Task.
     */
    @Test
    public void removeTaskTest1() {
        /*
         * create TaskManagers to compare
         */
        TaskManager tm = this.constructorTest();
        TaskManager expectedTm = this.constructorTest();
        /*
         * create Task to add
         */
        Task t1 = new Task("task 1", "01/01/2026", "school", false);
        Task expectedRemoved = new Task("task 1", "01/01/2026", "school",
                false);
        /*
         * add the Task
         */
        tm.addTask(t1);
        /*
         * remove the Task
         */
        Task removed = tm.removeTask("task 1");
        /*
         * assert the Task was removed
         */
        assertEquals(tm.size(), 0);
        assertEquals(tm, expectedTm);
        assertEquals(removed, expectedRemoved);
    }

    /**
     * Test removeTask with a TaskManager with 2 Tasks removing 1 Task.
     */
    @Test
    public void removeTaskTest2() {
        /*
         * create TaskManagers to compare
         */
        TaskManager tm = this.constructorTest();
        TaskManager expectedTm = this.constructorTest();
        /*
         * create Tasks to add and compare
         */
        Task t1 = new Task("task 1", "01/01/2026", "school", false);
        Task t2 = new Task("task 2", "01/31/2026", "school", true);
        Task expectedRemoved = new Task("task 1", "01/01/2026", "school",
                false);
        /*
         * add the Tasks
         */
        tm.addTask(t1);
        tm.addTask(t2);
        expectedTm.addTask(t2);
        /*
         * remove a Task
         */
        Task removed = tm.removeTask("task 1");
        /*
         * assert the Task was removed
         */
        assertEquals(tm.size(), 1);
        assertEquals(tm, expectedTm);
        assertEquals(removed, expectedRemoved);
    }

    /**
     * Test removeAny with a TaskManager with 1 Task.
     */
    @Test
    public void removeAnyTest1() {
        /*
         * create TaskManagers to compare
         */
        TaskManager tm = this.constructorTest();
        TaskManager expectedTm = this.constructorTest();
        /*
         * create Tasks to add and compare
         */
        Task t1 = new Task("task 1", "01/01/2026", "school", false);
        Task expectedRemoved = new Task("task 1", "01/01/2026", "school",
                false);
        /*
         * add the Task
         */
        tm.addTask(t1);
        /*
         * remove a Task
         */
        Task removed = tm.removeAny();
        /*
         * assert a Task was removed
         */
        assertEquals(tm.size(), 0);
        assertEquals(tm, expectedTm);
        assertEquals(removed, expectedRemoved);
    }

    /**
     * Test removeAny with a TaskManager with 2 Tasks.
     */
    @Test
    public void removeAnyTest2() {
        /*
         * create TaskManagers to compare
         */
        TaskManager tm = this.constructorTest();
        TaskManager expectedTm = this.constructorTest();
        /*
         * create Tasks to add
         */
        Task t1 = new Task("task 1", "01/01/2026", "school", false);
        Task t2 = new Task("task 2", "01/31/2026", "school", true);
        /*
         * add the Tasks
         */
        tm.addTask(t1);
        tm.addTask(t2);
        expectedTm.addTask(t1);
        expectedTm.addTask(t2);
        /*
         * remove a Task
         */
        Task removed = tm.removeAny();
        /*
         * assert the removed Task was in the TaskManager
         */
        assertEquals(expectedTm.contains(removed.getName()), true);
        /*
         * remove the Task from expected TaskManager
         */
        expectedTm.removeTask(removed.getName());
        /*
         * assert a Task was removed
         */
        assertEquals(tm.size(), 1);
        assertEquals(tm, expectedTm);
    }

    /**
     * Test updateStatus with a TaskManager with 1 Task.
     */
    @Test
    public void updateStatusTest1() {
        /*
         * create TaskManagers to compare
         */
        TaskManager tm = this.constructorTest();
        TaskManager expectedTm = this.constructorTest();
        /*
         * create Tasks to add and compare
         */
        Task t1 = new Task("task 1", "01/01/2026", "school", false);
        Task expectedTask = new Task("task 1", "01/01/2026", "school", true);
        /*
         * add the Tasks
         */
        tm.addTask(t1);
        expectedTm.addTask(expectedTask);
        /*
         * update the Task
         */
        tm.updateStatus("task 1");
        /*
         * assert the Task was updated
         */
        assertEquals(tm.size(), 1);
        assertEquals(tm, expectedTm);
    }

    /**
     * Test updateStatus with a TaskManager with 2 Tasks.
     */
    @Test
    public void updateStatusTest2() {
        /*
         * create TaskManagers to compare
         */
        TaskManager tm = this.constructorTest();
        TaskManager expectedTm = this.constructorTest();
        /*
         * create Tasks to add and compare
         */
        Task t1 = new Task("task 1", "01/01/2026", "school", false);
        Task t2 = new Task("task 2", "01/31/2026", "school", true);
        Task expectedTask = new Task("task 1", "01/01/2026", "school", true);
        /*
         * add the Tasks
         */
        tm.addTask(t1);
        tm.addTask(t2);
        expectedTm.addTask(expectedTask);
        expectedTm.addTask(t2);
        /*
         * update the Task
         */
        tm.updateStatus("task 1");
        /*
         * assert the Task was updated
         */
        assertEquals(tm.size(), 2);
        assertEquals(tm, expectedTm);
    }

    /**
     * Test contains on an empty TaskManager.
     */
    @Test
    public void containsTest1() {
        /*
         * create TaskManagers to compare
         */
        TaskManager tm = this.constructorTest();
        TaskManager expectedTm = this.constructorTest();
        /*
         * call contains
         */
        boolean contains = tm.contains("task 1");
        /*
         * assert contains returned whether the Task is in the TaskManager
         */
        assertEquals(tm.size(), 0);
        assertEquals(tm, expectedTm);
        assertEquals(contains, false);
    }

    /**
     * Test contains on a TaskManager with 1 Task expecting false.
     */
    @Test
    public void containsTest2() {
        /*
         * create TaskManagers to compare
         */
        TaskManager tm = this.constructorTest();
        TaskManager expectedTm = this.constructorTest();
        /*
         * create Task to add
         */
        Task t1 = new Task("task 1", "01/01/2026", "school", false);
        /*
         * add the Task
         */
        tm.addTask(t1);
        expectedTm.addTask(t1);
        /*
         * call contains
         */
        boolean contains = tm.contains("task 2");
        /*
         * assert contains returned whether the Task is in the TaskManager
         */
        assertEquals(tm.size(), 1);
        assertEquals(tm, expectedTm);
        assertEquals(contains, false);
    }

    /**
     * Test contains on a TaskManager with 1 Task expecting true.
     */
    @Test
    public void containsTest3() {
        /*
         * create TaskManagers to compare
         */
        TaskManager tm = this.constructorTest();
        TaskManager expectedTm = this.constructorTest();
        /*
         * create Task to add
         */
        Task t1 = new Task("task 1", "01/01/2026", "school", false);
        /*
         * add the Task
         */
        tm.addTask(t1);
        expectedTm.addTask(t1);
        /*
         * call contains
         */
        boolean contains = tm.contains("task 1");
        /*
         * assert contains returned whether the Task is in the TaskManager
         */
        assertEquals(tm.size(), 1);
        assertEquals(tm, expectedTm);
        assertEquals(contains, true);
    }

    /**
     * Test size with an empty TaskManager.
     */
    @Test
    public void sizeTest1() {
        /*
         * create TaskManagers to compare
         */
        TaskManager tm = this.constructorTest();
        TaskManager expectedTm = this.constructorTest();
        /*
         * call size
         */
        int size = tm.size();
        /*
         * assert size returned the number of Tasks in the TaskManager
         */
        assertEquals(size, 0);
        assertEquals(tm, expectedTm);
    }

    /**
     * Test size with a TaskManager with 1 Task.
     */
    @Test
    public void sizeTest2() {
        /*
         * create TaskManagers to compare
         */
        TaskManager tm = this.constructorTest();
        TaskManager expectedTm = this.constructorTest();
        /*
         * create Task to add
         */
        Task t1 = new Task("task 1", "01/01/2026", "school", false);
        /*
         * add the Task
         */
        tm.addTask(t1);
        expectedTm.addTask(t1);
        /*
         * call size
         */
        int size = tm.size();
        /*
         * assert size returned the number of Tasks in the TaskManager
         */
        assertEquals(size, 1);
        assertEquals(tm, expectedTm);
    }

    /**
     * Test size with a TaskManager with 2 Task.
     */
    @Test
    public void sizeTest3() {
        /*
         * create TaskManagers to compare
         */
        TaskManager tm = this.constructorTest();
        TaskManager expectedTm = this.constructorTest();
        /*
         * create Tasks to add
         */
        Task t1 = new Task("task 1", "01/01/2026", "school", false);
        Task t2 = new Task("task 2", "01/31/2026", "school", true);
        /*
         * add the Tasks
         */
        tm.addTask(t1);
        tm.addTask(t2);
        expectedTm.addTask(t1);
        expectedTm.addTask(t2);
        /*
         * call size
         */
        int size = tm.size();
        /*
         * assert size returned the number of Tasks in the TaskManager
         */
        assertEquals(size, 2);
        assertEquals(tm, expectedTm);
    }

    /*
     * Secondary method tests --------------------------------------------------
     */

    /**
     * Tests incompleteTasks with an empty TaskManager.
     */
    @Test
    public void incompleteTasksTest1() {
        /*
         * create TaskManagers to compare
         */
        TaskManager tm = this.constructorTest();
        TaskManager expectedResult = this.constructorTest();
        /*
         * call incompleteTasks
         */
        TaskManager result = tm.incompleteTasks();
        /*
         * assert the result mathces the expected result
         */
        assertEquals(result, expectedResult);
    }

    /**
     * Tests incompleteTasks with a TaskManager with 1 incomplete Task.
     */
    @Test
    public void incompleteTasksTest2() {
        /*
         * create TaskManagers to compare
         */
        TaskManager tm = this.constructorTest();
        TaskManager expectedResult = this.constructorTest();
        /*
         * create Task to add
         */
        Task t1 = new Task("task 1", "01/01/2026", "school", false);
        /*
         * add the Task
         */
        tm.addTask(t1);
        expectedResult.addTask(t1);
        /*
         * call incompleteTasks
         */
        TaskManager result = tm.incompleteTasks();
        /*
         * assert the result mathces the expected result
         */
        assertEquals(result, expectedResult);
    }

    /**
     * Tests incompleteTasks with a TaskManager with 1 complete Task.
     */
    @Test
    public void incompleteTasksTest3() {
        /*
         * create TaskManagers to compare
         */
        TaskManager tm = this.constructorTest();
        TaskManager expectedResult = this.constructorTest();
        /*
         * create Task to add
         */
        Task t1 = new Task("task 1", "01/01/2026", "school", true);
        /*
         * add the Task
         */
        tm.addTask(t1);
        /*
         * call incompleteTasks
         */
        TaskManager result = tm.incompleteTasks();
        /*
         * assert the result mathces the expected result
         */
        assertEquals(result, expectedResult);
    }

    /**
     * Tests incompleteTasks with a TaskManager with 1 incomplete Task and 1
     * complete Task.
     */
    @Test
    public void incompleteTasksTest4() {
        /*
         * create TaskManagers to compare
         */
        TaskManager tm = this.constructorTest();
        TaskManager expectedResult = this.constructorTest();
        /*
         * create Tasks to add
         */
        Task t1 = new Task("task 1", "01/01/2026", "school", false);
        Task t2 = new Task("task 2", "01/31/2026", "school", true);
        /*
         * add the Tasks
         */
        tm.addTask(t1);
        tm.addTask(t2);
        expectedResult.addTask(t1);
        /*
         * call incompleteTasks
         */
        TaskManager result = tm.incompleteTasks();
        /*
         * assert the result mathces the expected result
         */
        assertEquals(result, expectedResult);
    }

    /**
     * Test tasksInCategory with an empty TaskManager.
     */
    @Test
    public void tasksInCategoryTest1() {
        /*
         * create TaskManagers to compare
         */
        TaskManager tm = this.constructorTest();
        TaskManager expectedResult = this.constructorTest();
        /*
         * call tasksInCategory
         */
        TaskManager result = tm.tasksInCategory("work");
        /*
         * assert the result mathces the expected result
         */
        assertEquals(result, expectedResult);
    }

    /**
     * Test tasksInCategory with a non-empty TaskManager with no Tasks in the
     * category.
     */
    @Test
    public void tasksInCategoryTest2() {
        /*
         * create TaskManagers to compare
         */
        TaskManager tm = this.constructorTest();
        TaskManager expectedResult = this.constructorTest();
        /*
         * create Task to add
         */
        Task t1 = new Task("task 1", "01/01/2026", "school", false);
        /*
         * add the Task
         */
        tm.addTask(t1);
        /*
         * call tasksInCategory
         */
        TaskManager result = tm.tasksInCategory("work");
        /*
         * assert the result mathces the expected result
         */
        assertEquals(result, expectedResult);
    }

    /**
     * Test tasksInCategory with a TaskManager with 1 Task in the category.
     */
    @Test
    public void tasksInCategoryTest3() {
        /*
         * create TaskManagers to compare
         */
        TaskManager tm = this.constructorTest();
        TaskManager expectedResult = this.constructorTest();
        /*
         * create Task to add
         */
        Task t1 = new Task("task 1", "01/01/2026", "school", false);
        /*
         * add the Task
         */
        tm.addTask(t1);
        expectedResult.addTask(t1);
        /*
         * call tasksInCategory
         */
        TaskManager result = tm.tasksInCategory("school");
        /*
         * assert the result mathces the expected result
         */
        assertEquals(result, expectedResult);
    }

    /**
     * Test tasksInCategory with a TaskManager with 1 Task in the category and 1
     * Task not in the category.
     */
    @Test
    public void tasksInCategoryTest4() {
        /*
         * create TaskManagers to compare
         */
        TaskManager tm = this.constructorTest();
        TaskManager expectedResult = this.constructorTest();
        /*
         * create Tasks to add
         */
        Task t1 = new Task("task 1", "01/01/2026", "school", false);
        Task t2 = new Task("task 2", "01/31/2026", "work", true);
        /*
         * add the Task
         */
        tm.addTask(t1);
        tm.addTask(t2);
        expectedResult.addTask(t1);
        /*
         * call tasksInCategory
         */
        TaskManager result = tm.tasksInCategory("school");
        /*
         * assert the result mathces the expected result
         */
        assertEquals(result, expectedResult);
    }

    /**
     * Test tasksByDate with an empty TaskManager.
     */
    @Test
    public void tasksByDateTest1() {
        /*
         * create TaskManagers to compare
         */
        TaskManager tm = this.constructorTest();
        TaskManager expectedResult = this.constructorTest();
        /*
         * call tasksByDate
         */
        TaskManager result = tm.tasksByDate();
        /*
         * assert the result mathces the expected result
         */
        assertEquals(result, expectedResult);
    }

    /**
     * Test tasksByDate with a TaskManager with 1 Task.
     */
    @Test
    public void tasksByDateTest2() {
        /*
         * create TaskManagers to compare
         */
        TaskManager tm = this.constructorTest();
        TaskManager expectedResult = this.constructorTest();
        /*
         * create Task to add
         */
        Task t1 = new Task("task 1", "01/01/2026", "school", false);
        /*
         * add the Task
         */
        tm.addTask(t1);
        expectedResult.addTask(t1);
        /*
         * call tasksByDate
         */
        TaskManager result = tm.tasksByDate();
        /*
         * assert the result mathces the expected result
         */
        assertEquals(result, expectedResult);
    }

    /**
     * Test tasksByDate with a TaskManager with 2 Tasks.
     */
    @Test
    public void tasksByDateTest3() {
        /*
         * create TaskManagers to compare
         */
        TaskManager tm = this.constructorTest();
        TaskManager expectedResult = this.constructorTest();
        /*
         * create Tasks to add
         */
        Task t1 = new Task("task 1", "01/01/2026", "school", false);
        Task t2 = new Task("task 2", "01/31/2026", "work", true);
        /*
         * add the Task
         */
        tm.addTask(t1);
        tm.addTask(t2);
        expectedResult.addTask(t1);
        expectedResult.addTask(t2);
        /*
         * call tasksByDate
         */
        TaskManager result = tm.tasksByDate();
        /*
         * assert the result mathces the expected result
         */
        assertEquals(result, expectedResult);
    }

}
