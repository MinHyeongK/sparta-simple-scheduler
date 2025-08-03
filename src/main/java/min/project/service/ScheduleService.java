package min.project.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import min.project.dto.schedule.*;
import min.project.entity.Comment;
import min.project.entity.Schedule;
import min.project.repository.CommentRepository;
import min.project.repository.ScheduleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final CommentRepository commentRepository;

    @Transactional
    public ScheduleResponseDto createSchedule(ScheduleCreateRequestDto dto){

        Schedule schedule = scheduleRepository.save(dto.toCreateEntity());

        return new ScheduleResponseDto(schedule);
    }

    //TODO: refact: ErrorCode: 500 => 400
    @Transactional(readOnly = true)
    public ScheduleFindResponseDto findSchedule(Long id){

        List<Comment> comments = commentRepository.findAllByScheduleId(id);

        Schedule schedule = scheduleRepository.findById(id).orElseThrow(() -> new NoSuchElementException("존재하지 않는 id값"));

        return new ScheduleFindResponseDto(schedule, comments);
    }

    @Transactional(readOnly = true)
    public List<ScheduleResponseDto> findAllScheduleByName(String name){

        List<Schedule> original = scheduleRepository.findAllByName(name);

        original.sort(Comparator.comparing(Schedule::getCreatedAt).reversed());

        List<ScheduleResponseDto> found = new ArrayList<>();
        for (Schedule schedule : original) {
            found.add(new ScheduleResponseDto(schedule));
        }

        return found;
    }

    // question: Optional 사용 X 방법 (뭐가 더 좋은 방법일까요?)
    @Transactional
    public ScheduleResponseDto updateSchedule(Long id, ScheduleUpdateRequestDto dto){

        Schedule schedule = scheduleRepository.findById(id).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "id 없다고"));

        ValidationService.validate(schedule.getPassword(), dto.getPassword());

        schedule.updateSchedule(dto.getName(), dto.getTitle());

        return new ScheduleResponseDto(scheduleRepository.saveAndFlush(schedule));
    }

    // question : Optional 사용 O 방법 (뭐가 더 좋은 방법일까요?)
    @Transactional
    public void deleteSchedule(Long id, String password){
        Optional<Schedule> foundSchedule = scheduleRepository.findById(id);

        if(foundSchedule.isPresent()){
            ValidationService.validate(foundSchedule.get().getPassword(), password);
            scheduleRepository.deleteById(id);
        }else{
            throw new NoSuchElementException("해당 id를 찾을 수 없습니다.");
        }
    }
}
