package com.rest.application.repository;

import com.rest.application.entity.Conference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class ConferenceRepository {

  private static List<Conference> conferences = new ArrayList<>(Arrays.asList(
      new Conference(1L, "It Conference", "Adam Smith"),
      new Conference(2L, "Science today", "Adam Smith"),
      new Conference(3L, "Ecology", "Adam Smith"),
      new Conference(4L, "Your wonderful morning", "Adam Smith"),
      new Conference(5L, "Rest&SOAP", "Valeria Fatova"),
      new Conference(6L, "Spring", "Oleksii Retiznyk")));

  public Optional<Conference> findConferenceById(Long id) {
    return conferences.stream()
        .filter(conference -> conference.getId() == id)
        .findFirst();
  }

  public List<Conference> getAllConferences() {
    return conferences;
  }

  public void addConference(Conference conference) {
    conferences.add(conference);
  }

  public void updateConference(Conference updatedConference) {
    Conference conferenceFromDB = conferences.get((int) updatedConference.getId()-1);
    conferenceFromDB.setSubject(updatedConference.getSubject());
    conferenceFromDB.setReaderName(updatedConference.getReaderName());
  }

  public void deleteConference(Conference conference) {
    conferences.remove(conference);
  }
}
