import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task {

    private int id;
    private String description;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Task(String description, String status, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.description = description;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Task() {}

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public String getCreatedAt() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return this.createdAt.format(formatter);
    }

    public String getUpdatedAt() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return this.updatedAt.format(formatter);
    }

    public void setId(int id) { this.id = id; }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(String status) { this.status = status; }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

}
