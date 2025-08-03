package min.project.controller;

import lombok.RequiredArgsConstructor;
import min.project.dto.*;
import min.project.service.ScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping
    public ResponseEntity<ScheduleCreateResponseDto> createSchedule(@RequestBody ScheduleCreateRequestDto dto){

        ScheduleCreateResponseDto created = scheduleService.createSchedule(dto);

        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScheduleFindResponseDto> findSchedule(@PathVariable Long id){

        return new ResponseEntity<>(scheduleService.findSchedule(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ScheduleFindResponseDto>> findAllScheduleByName(@RequestParam(required = false) String name){

        List<ScheduleFindResponseDto> schedules = scheduleService.findAllScheduleByName(name);

        return new ResponseEntity<>(schedules, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ScheduleUpdateResponseDto> updateSchedule(@PathVariable Long id,
                                                               @RequestBody ScheduleUpdateRequestDto dto){

        return new ResponseEntity<>(scheduleService.updateSchedule(id, dto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteSchedule(@PathVariable Long id,
                                         @RequestBody ScheduleDeleteRequestDto dto){
        scheduleService.deleteSchedule(id, dto.getPassword());
    }
}
