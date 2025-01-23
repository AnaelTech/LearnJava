import java.util.ArrayList;
import java.util.Scanner;

class Task {
    String  title;
    String  description;
    boolean done;
}

class TaskList {
    ArrayList<Task> tasks = new ArrayList<Task>();
}

public class Main {
    
    public static void main(String[] args) {

        TaskList taskList = new TaskList();

        Scanner scanner = new Scanner(System.in);
        // Scanner permet de lire les entrées de l'utilisateur

        while (true) {
            System.out.println("1. Ajouter une tâche");
            System.out.println("2. Lister les tâches");
            System.out.println("3. Marquer une tâche comme faite");
            System.out.println("4. Quitter");
            System.out.println("Choisissez une option : ");
            int option = scanner.nextInt();
            scanner.nextLine();

            if (option == 1) {
                Task task = new Task();
                System.out.println("Titre de la tâche : ");
                task.title = scanner.nextLine();
                System.out.println("Description de la tâche : ");
                task.description = scanner.nextLine();
                taskList.tasks.add(task);
            } else if (option == 2) {
                for (int i = 0; i < taskList.tasks.size(); i++) {
                    Task task = taskList.tasks.get(i);
                    System.out.println((i + 1) + ". " + task.title + " - " + task.description + " - " + (task.done ? "Fait" : "À faire"));
                }
            } else if (option == 3) {
                System.out.println("Quelle tâche voulez-vous marquer comme faite ?");
                int taskNumber = scanner.nextInt();
                Task task = taskList.tasks.get(taskNumber - 1);
                task.done = true;
            } else if (option == 4) {
                scanner.close();
                break;
            }
        }
    }   
}
