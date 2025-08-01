package min.project.dto;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class SchedulesResponseDto {
    private List<ScheduleResponseDto> schedulesResponse ;

    public SchedulesResponseDto(List<ScheduleResponseDto> schedulesResponse) {
        this.schedulesResponse = schedulesResponse;
    }
}
