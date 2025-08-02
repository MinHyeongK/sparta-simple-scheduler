package min.project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import min.project.entity.Schedule;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleResponseDto {
    private String title;
    private String contents;
    private String name;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ScheduleResponseDto(Schedule schedule) {
        this.title = schedule.getTitle();
        this.contents = schedule.getContents();
        this.name = schedule.getName();
        this.createdAt = schedule.getCreatedAt();
        this.updatedAt = schedule.getUpdatedAt();
    }

    public ScheduleResponseDto(String title, String name, LocalDateTime updatedAt){
        this.title = title;
        this.name = name;
        this.updatedAt = updatedAt;
    }

    public ScheduleResponseDto(String title, String name, LocalDateTime createdAt, LocalDateTime updatedAt){
        this.title = title;
        this.name = name;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static ScheduleResponseDto from(Schedule schedule){
        return new ScheduleResponseDto(schedule.getTitle(), schedule.getContents(), schedule.getName(), schedule.getCreatedAt(), schedule.getUpdatedAt());
    }
}
