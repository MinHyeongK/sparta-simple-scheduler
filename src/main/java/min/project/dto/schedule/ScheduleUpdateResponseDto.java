package min.project.dto.schedule;

import lombok.AllArgsConstructor;
import lombok.Getter;
import min.project.entity.Schedule;

@Getter
@AllArgsConstructor
public class ScheduleUpdateResponseDto {
    private final String title;
    private final String contents;
    private final String name;

    // TODO: createAt, updatedAt
    public ScheduleUpdateResponseDto(Schedule schedule) {
        this.title = schedule.getTitle();
        this.contents = schedule.getContents();
        this.name = schedule.getName();
    }
}