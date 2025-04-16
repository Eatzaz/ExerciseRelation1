package com.example.exerciserelation.DTO;

import com.example.exerciserelation.Model.Teacher;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {
    @NotEmpty(message = "The Area cannot be Empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String area;
    @NotEmpty(message = "The Street cannot be Empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String street;
    @NotNull(message = "The building number cannot be Null")
    @Column(columnDefinition = "int not null")
    private Integer building_number;
    private Integer teacher_id;

}
