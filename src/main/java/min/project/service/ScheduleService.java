package min.project.service;

import lombok.RequiredArgsConstructor;
import min.project.dto.ScheduleRequestDto;
import min.project.dto.ScheduleResponseDto;
import min.project.dto.SchedulesResponseDto;
import min.project.entity.Schedule;
import min.project.repository.ScheduleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    @Transactional
    public Schedule createSchedule(ScheduleRequestDto dto){

        return scheduleRepository.save(dto.toEntity(dto));
    }

    //TODO: refact: ErrorCode: 500 => 400
    public Schedule findSchedule(Long id){
        return scheduleRepository.findById(id).orElseThrow(() -> new NoSuchElementException("존재하지 않는 id값"));
    }

    //TODO: refact: class separation
    public SchedulesResponseDto findAllScheduleByName(String name){

        List<Schedule> schedules = scheduleRepository.findAllByName(name);
        List<ScheduleResponseDto> schedulesResponseDto = new ArrayList<>();

        for (Schedule schedule : schedules) {
            schedulesResponseDto.add(new ScheduleResponseDto(schedule));
        }

        schedulesResponseDto.sort(Comparator.comparing(ScheduleResponseDto::getUpdatedAt).reversed());

        return new SchedulesResponseDto(schedulesResponseDto);
    }
}
