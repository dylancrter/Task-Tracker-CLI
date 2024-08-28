import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class TaskTracker {

    public static void main(String[] args) {

        if (args.length < 1) {
           System.out.println("Usage: java TaskTracker <command> [arguments]");
           return;
        }

        String command = args[0];
        switch(command) {
            case "add":
                if (args.length != 2) {
                    System.out.println("Usage: java TaskTracker add <description>");
                    return;
                }
                addTask(args[1]);
                break;
            case "update":
                if (args.length < 3) {
                    System.out.println("Usage: java TaskTracker update <taskID> <description>");
                    return;
                }
                String input = String.join(" ", args);
                Pattern pattern = Pattern.compile("\"([^\"]*)\"");
                Matcher matcher = pattern.matcher(input);
                String taskDescription = "";
                if (matcher.find()) {
                    taskDescription = matcher.group(1);
                }
                updateTask(Integer.parseInt(args[1]), taskDescription);
                break;
            case "delete":
                if (args.length != 2) {
                    System.out.println("Usage: java TaskTracker delete <taskID>");
                    return;
                }
                deleteTask(Integer.parseInt(args[1]));
                break;
            case "mark-in-progress":
                if (args.length != 2) {
                    System.out.println("Usage: java TaskTracker mark-in-progress <taskID>");
                    return;
                }
                markTaskStatus(Integer.parseInt(args[1]), "in-progress");
                break;
            case "mark-done":
                if (args.length != 2) {
                    System.out.println("Usage: java TaskTracker mark-done <taskID>");
                    return;
                }
                markTaskStatus(Integer.parseInt(args[1]), "done");
                break;
            case "list":
                if (args.length != 1) {
                    System.out.println("Usage: java TaskTracker list");
                    return;
                }
                listTasks(null, true);
                break;
            default:
                System.out.println("Command not recognized. Please try again.");
        }
    }

    private static void addTask(String description) {
        Task task = new Task();
        task.setDescription(description);
        task.setCreatedAt(LocalDateTime.now());
        task.setUpdatedAt(LocalDateTime.now());
        task.setStatus("in-progress");
        int id = 0;

        List<Task> tasks;
        tasks = readTasksFromFile();
        id = tasks.size();
        task.setId(id);
        tasks.add(task);

        writeTasksToFile(tasks);
        System.out.println("Task added successfully (ID: " + task.getId() + ")");
    }

    private static void updateTask(int id, String newDescription) {

    }

    private static void deleteTask(int id) {

    }

    private static void markTaskStatus(int id, String status) {

    }

    private static void listTasks(String status, boolean all) {

    }

    private static List<Task> readTasksFromFile() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        try {
            return mapper.readValue(getTasksFile(), new TypeReference<>() {
            });
        } catch (IOException e) {
            return new ArrayList<Task>();
        }
    }

    private static void updateTask() {

    }

    private static void writeTasksToFile(List<Task> tasks) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            mapper.writeValue(getTasksFile(), tasks);
        } catch (IOException e) {
            System.err.println("Error writing tasks to file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static File getTasksFile() {
        String filepath = "src/main/resources/tasks.json";
        return new File(filepath);
    }

}
