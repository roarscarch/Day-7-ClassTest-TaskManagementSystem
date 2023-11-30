import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Task {

    private String name;
    private boolean completed;

    public Task(String name) {
        this.name = name;
        this.completed = false;
    }

    public String getName() {
        return name;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void markCompleted() {
        completed = true;
    }
}

class User {

    private String username;

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}

class Project {

    private String projectName;
    private List<Task> tasks;
    private Map<User, List<Task>> taskAssignments;

    public Project(String projectName) {
        this.projectName = projectName;
        this.tasks = new ArrayList<>();
        this.taskAssignments = new HashMap<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void assignTask(User user, Task task) {
        if (!taskAssignments.containsKey(user)) {
            taskAssignments.put(user, new ArrayList<>());
        }
        taskAssignments.get(user).add(task);
    }

    public void markTaskCompleted(Task task) {
        task.markCompleted();
    }

    public void generateReports() {
        System.out.println("Project--->" + projectName);

        for (User user : taskAssignments.keySet()) {
            System.out.println("User--->" + user.getUsername());

            List<Task> assignedTasks = taskAssignments.get(user);

            for (Task task : assignedTasks) {
                System.out.println("Task : " + task.getName() + "--Completed : " + task.isCompleted());
            }
        }
    }
}

public class TMS {

    public static void main(String[] args) {

        User user1 = new User("Anurag");
        Task task1 = new Task("Task1");
        Task task2 = new Task("Task2");

        Project project = new Project("Project1");
        project.assignTask(user1, task1);
        project.assignTask(user1, task2);

        project.markTaskCompleted(task1);
        project.markTaskCompleted(task2);
        project.generateReports();
    }
}
