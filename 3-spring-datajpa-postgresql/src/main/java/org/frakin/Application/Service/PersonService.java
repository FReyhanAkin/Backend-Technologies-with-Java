package org.frakin.Application.Service;

import org.frakin.Application.DataTransferObject.PersonDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PersonService {

    PersonDto save(PersonDto personDto);

    void delete(int id);

    List<PersonDto> getAll();

    Page<PersonDto> getAll(Pageable pageable);
}
