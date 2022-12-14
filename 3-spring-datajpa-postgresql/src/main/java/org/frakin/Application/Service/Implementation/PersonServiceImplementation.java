package org.frakin.Application.Service.Implementation;


import lombok.RequiredArgsConstructor;
import org.frakin.Application.DataTransferObject.PersonDto;
import org.frakin.Application.Entity.Address;
import org.frakin.Application.Entity.Person;
import org.frakin.Application.Repository.AddressRepository;
import org.frakin.Application.Repository.PersonRepository;
import org.frakin.Application.Service.PersonService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonServiceImplementation implements PersonService {

    private final PersonRepository personRepository;
    private final AddressRepository addressRepository;

    @Override
    public PersonDto save(PersonDto personDto) {
        Assert.notNull(personDto.getName(), "Obligatory!");

        Person person = new Person();
        person.setName(personDto.getName());
        person.setSurname(personDto.getSurname());
        final Person person1=personRepository.save(person);

        List<Address> list = new ArrayList<>();
        personDto.getAddresses().forEach(item->{
            Address address = new Address();
            address.setAddress(item);
            address.setAddressType(Address.AddressType.OTHER);
            address.setActive(true);
            address.setPerson(person1);
            list.add(address);
        });
        addressRepository.saveAll(list);

        personDto.setId(person1.getId());

        return personDto;
    }

    @Override
    public void delete(int id) {}

    @Override
    public List<PersonDto> getAll() {
        List<Person> personList =personRepository.findAll();
        List<PersonDto> personDtoList = new ArrayList<>();

        personList.forEach(item-> {
            PersonDto personDto = new PersonDto();
            personDto.setId(item.getId());
            personDto.setName(item.getName());
            personDto.setName(item.getSurname());
            personDto.setAddresses(
                    item.getAddresses() != null ?
                        item.getAddresses().stream().map(Address::getAddress).collect(Collectors.toList())
                            : null);
            personDtoList.add(personDto);
        });
        return personDtoList;


    }

    @Override
    public Page<PersonDto> getAll(Pageable pageable) {
        return null;
    }
}
