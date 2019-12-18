package com.rest.application.controller;

import com.rest.application.entity.Conference;
import com.rest.application.repository.ConferenceRepository;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conferences")
public class ConferenceController {

  @Resource
  private ConferenceRepository conferenceRepository;

  @GetMapping
  public List<Conference> getAllConferences() {
    return conferenceRepository.getAllConferences();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Conference> getConferenceById(@PathVariable Long id){
    return ResponseEntity.of(conferenceRepository.findConferenceById(id));
  }

  @PostMapping
  public void createConference(@RequestBody Conference conference){
    conferenceRepository.addConference(conference);
  }

  @PutMapping
  public void updateConference(@RequestBody Conference updatedConference){
    conferenceRepository.updateConference(updatedConference);
  }

  @DeleteMapping
  public void deleteConference(@RequestBody Conference conference){
    conferenceRepository.deleteConference(conference);
  }

}
