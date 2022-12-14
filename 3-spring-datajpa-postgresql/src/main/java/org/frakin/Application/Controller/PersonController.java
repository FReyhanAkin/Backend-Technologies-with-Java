package org.frakin.Application.Controller;

import lombok.RequiredArgsConstructor;
import org.frakin.Application.DataTransferObject.PersonDto;
import org.frakin.Application.Service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @PostMapping
    public ResponseEntity<PersonDto> save(@Valid @RequestBody PersonDto personDto) {
        return ResponseEntity.ok(personService.save(personDto));
    }

    @GetMapping
    public ResponseEntity<List<PersonDto>> listAll() {
        return ResponseEntity.ok(personService.getAll());
    }
}
