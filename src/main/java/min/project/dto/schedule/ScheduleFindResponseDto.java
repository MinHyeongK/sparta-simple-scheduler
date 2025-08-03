package min.project.dto.schedule;

import lombok.AllArgsConstructor;
import lombok.Getter;
import min.project.entity.Comment;
import min.project.entity.Schedule;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
public class ScheduleFindResponseDto {
    private final Long id;
    private final String title;
    private final String contents;
    private final String name;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;
    private final List<Comment> comments;

    public ScheduleFindResponseDto(Schedule schedule, List<Comment> comments) {
        this.id = schedule.getId();
        this.title = schedule.getTitle();
        this.contents = schedule.getContents();
        this.name = schedule.getName();
        this.createdAt = schedule.getCreatedAt();
        this.updatedAt = schedule.getUpdatedAt();
        this.comments = comments;
    }
}
