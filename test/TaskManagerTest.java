/**
 * JUnit test fixture for TaskManager's constructors and kernel methods.
 */
public abstract class TaskManagerTest {

    /**
     * Invokes the appropriate TaskManager constructor for the implementation
     * under test and returns the result.
     *
     * @return the new TaskManager
     * @ensures constructorTest = (empty TaskManager)
     */
    protected abstract TaskManager constructorTest();
}
