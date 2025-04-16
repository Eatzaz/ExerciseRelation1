package com.example.exerciserelation.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {
    @Id
    private  Integer id;
    @NotEmpty(message = "The Area cannot be Empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String area;
    @NotEmpty(message = "The Street cannot be Empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String street;
    @NotNull(message = "The building number cannot be Null")
    @Column(columnDefinition = "int not null")
    private Integer building_number;
    @OneToOne
    @JsonIgnore
    @MapsId
    private Teacher teacher;
}
