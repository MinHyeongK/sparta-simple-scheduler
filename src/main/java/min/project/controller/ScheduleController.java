package min.project.controller;

import lombok.RequiredArgsConstructor;
import min.project.dto.ScheduleRequestDto;
import min.project.dto.ScheduleResponseDto;
import min.project.dto.SchedulesResponseDto;
import min.project.entity.Schedule;
import min.project.service.ScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping
    public ResponseEntity<ScheduleResponseDto> createSchedule(@RequestBody ScheduleRequestDto scheduleRequestDto){

        Schedule createdSchedule = scheduleService.createSchedule(scheduleRequestDto);

        return new ResponseEntity<>(new ScheduleResponseDto(createdSchedule), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> findSchedule(@PathVariable Long id){

        try{
            return new ResponseEntity<>(new ScheduleResponseDto(scheduleService.findSchedule(id)), HttpStatus.OK) ;
        } catch (IllegalArgumentException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<SchedulesResponseDto> findAllScheduleByName(@RequestParam(required = false) String name){

        List<ScheduleResponseDto> scheduleList =  scheduleService.findAllScheduleByName(name);
        scheduleList.sort(Comparator.comparing(ScheduleResponseDto::getUpdatedAt).reversed());

        return new ResponseEntity<>(new SchedulesResponseDto(scheduleList), HttpStatus.OK);
    }
}
