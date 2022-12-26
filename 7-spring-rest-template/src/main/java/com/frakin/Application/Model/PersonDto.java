package com.frakin.Application.Model;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = {"id"})
public class PersonDto {

    private int id;

    @NotNull
    private String name;

    private String surname;

    private List<String> addresses;
}
