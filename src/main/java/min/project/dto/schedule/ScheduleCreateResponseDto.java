package min.project.dto.schedule;


import lombok.AllArgsConstructor;
import lombok.Getter;
import min.project.entity.Schedule;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ScheduleCreateResponseDto {
    private final String title;
    private final String contents;
    private final String name;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    public ScheduleCreateResponseDto(Schedule schedule) {
        this.title = schedule.getTitle();
        this.contents = schedule.getContents();
        this.name = schedule.getName();
        this.createdAt = schedule.getCreatedAt();
        this.updatedAt = schedule.getUpdatedAt();
    }
}
