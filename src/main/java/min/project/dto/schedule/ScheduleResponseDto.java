package min.project.dto.schedule;


import lombok.AllArgsConstructor;
import lombok.Getter;
import min.project.entity.Schedule;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ScheduleResponseDto {
    private final Long id;
    private final String title;
    private final String contents;
    private final String name;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    public ScheduleResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.title = schedule.getTitle();
        this.contents = schedule.getContents();
        this.name = schedule.getName();
        this.createdAt = schedule.getCreatedAt();
        this.updatedAt = schedule.getUpdatedAt();
    }
}
