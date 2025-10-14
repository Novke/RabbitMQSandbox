package com.sandbox.rabbit.producer.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Employee implements Serializable {

    @JsonProperty("employee_id")
    private String employeeId;

    private String name;

    @JsonFormat(pattern = "dd.MM.yyyy")
    @JsonProperty("birth_date")
    private LocalDate birthDate;

}
