package min.project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import min.project.entity.Schedule;

import java.util.List;

@Getter
public class SchedulesResponseDto {
    private final List<ScheduleResponseDto> scheduleResponses ;

    public SchedulesResponseDto(List<ScheduleResponseDto> schedules) {
        this.scheduleResponses = schedules;
    }
}
