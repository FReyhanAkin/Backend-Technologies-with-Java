package org.frakin.Application.Controller;


import lombok.RequiredArgsConstructor;
import org.frakin.Application.Entity.Person;
import org.frakin.Application.Repository.PersonRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonRepository personRepository;

    @PostConstruct
    public void init(){
        Person person =new Person();
        person.setId("001");
        person.setName("Name");
        person.setSurname("Surname");
        person.setBirthDate(Calendar.getInstance().getTime());
        personRepository.save(person);
    }

    @GetMapping("/{search}")
    public ResponseEntity<List<Person>> getPerson(@PathVariable String search) {
        List<Person> personList = personRepository.findByNameLikeOrSurnameLike(search,search);
        return ResponseEntity.ok(personList);
    }
}
