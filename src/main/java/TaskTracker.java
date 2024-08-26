import java.io.*;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class TaskTracker {
    private static final String JSON_FILE = "tasks.json";
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        if (args.length < 1) {
           System.out.println("Usage: java TaskTracker <command> [arguments]");
           return;
        }

        String command = args[0];
        switch(command) {
            case "add":
                if (args.length < 2) {
                    System.out.println("Usage: java TaskTracker add <description");
                    return;
                }
                addTask(args[1]);
                break;
            case "update":
                if (args.length < 3) {
                    System.out.println("Usage: java TaskTracker update <taskID> <description>");
                    return;
                }
                updateTask(Integer.parseInt(args[1]), args[2]);
        }
    }

    private static void addTask(String description) {

    }

    private static void updateTask(int id, String newDescription) {

    }

    private static void deleteTask(int id) {

    }

    private static void markTaskStatus(int id, String status) {

    }

    private static void listTasks(String status) {
        JSONArray tasks = readTasksFromFile();
        for (Object obj : tasks) {
            JSONObject task = (JSONObject) obj;
            if (status == null || status.equals(task.get("status"))) {
                System.out.println("ID: " + task.get("id") + ", Description: " + task.get("description") +
                        ", Status: " + task.get("status") + ", Created: " + task.get("createdAt") +
                        ", Updated: " + task.get("updatedAt"));
            }
        }
    }

    private static JSONArray readTasksFromFile() {
        try {
            InputStream inputStream = TaskTracker.class.getClassLoader().getResourceAsStream(JSON_FILE);
            if (inputStream != null) {
                JSONParser parser = new JSONParser();
                try (InputStreamReader reader = new InputStreamReader(inputStream)) {
                    return (JSONArray) parser.parse(reader);
                }
            } else {
                System.out.println("File not found: " + JSON_FILE);
                return new JSONArray();
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            return new JSONArray();
        }
    }

    private static void updateTask(JSONArray tasks) {

    }

}
