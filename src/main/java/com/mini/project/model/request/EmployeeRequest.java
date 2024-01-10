package com.mini.project.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class EmployeeRequest {

    @NotBlank(message = "Nama can not be empty!")
    private String nama;

    @NotNull(message = "DOB can not be empty!")
    private Date dob;

    @NotBlank(message = "Nama can not be empty!")
    private String posisi;

}
