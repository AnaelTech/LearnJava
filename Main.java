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

        String delete = "O";

        Scanner scanner = new Scanner(System.in);
        // Scanner permet de lire les entrées de l'utilisateur

        while (true) {
            System.out.println("1. Ajouter une tâche");
            System.out.println("2. Lister les tâches");
            System.out.println("3. Marquer une tâche comme faite");
            System.out.println("4. Afficher les tâches faites");
            System.out.println("5. Quitter");
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
                    if (task.done == false) {
                        System.out.println((i + 1) + ". " + task.title + " - " + task.description + " - " + ("À faire")); 
                     } else {
                        System.out.println("Vous avez terminé toutes vos tâches");
                     }

                }
            } else if (option == 3) {
                System.out.println("Quelle tâche voulez-vous marquer comme faite ?");
                int taskNumber = scanner.nextInt();
                Task task = taskList.tasks.get(taskNumber - 1);
                task.done = true;
                if (task.done) {
                    System.out.println("La tâche " + task.title + " est marquée comme faite.");
                }
            } 
            else if (option == 4){
                for (int i = 0; i < taskList.tasks.size(); i++) {
                    Task task = taskList.tasks.get(i);
                    if (task.done) {
                        for( i = 0; i < taskList.tasks.size(); i++) {
                            task = taskList.tasks.get(i);
                            System.out.println((i + 1) + ". " + task.title + " - " + task.description + " - " + ("Fait"));
                        }
                        System.out.println("Voulez-vous supprimer une tâche ? (O/N)");
                        delete = scanner.nextLine();
                        if (delete.equalsIgnoreCase("O")) {
                            System.out.println("Quelle tâche voulez-vous supprimer ?");
                            int taskToDelete = scanner.nextInt();
                            scanner.nextLine(); 
                            if (taskToDelete > 0 && taskToDelete <= taskList.tasks.size()) {
                                taskList.tasks.remove(taskToDelete - 1);
                                System.out.println("La tâche a été supprimée");
                            } else {
                                System.out.println("Numéro de tâche invalide");
                            }
                        } else {
                            // rien ne se passe si l'utilisateur ne veut pas supprimer la tâche
                        }
                    } else {
                        System.out.println("Aucune tâche de faites");
                    }
                }
            }
            else if (option == 5) {
                System.out.println("Au revoir !");
                scanner.close();
                break;
            }
        }
    }   
}
