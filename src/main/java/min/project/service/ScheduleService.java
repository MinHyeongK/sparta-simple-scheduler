package min.project.service;

import lombok.RequiredArgsConstructor;
import min.project.dto.ScheduleRequestDto;
import min.project.dto.ScheduleResponseDto;
import min.project.dto.SchedulesResponseDto;
import min.project.entity.Schedule;
import min.project.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public Schedule createSchedule(ScheduleRequestDto scheduleRequestDto){

        return scheduleRepository.save(new Schedule(
                scheduleRequestDto.getTitle(),
                scheduleRequestDto.getContents(),
                scheduleRequestDto.getName(),
                scheduleRequestDto.getPassword()
        ));
    }

    public Schedule findSchedule(Long id){
        return scheduleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 id값"));
    }

    public List<ScheduleResponseDto> findAllScheduleByName(String name){
        return scheduleRepository.findAllByName(name);
    }
}
