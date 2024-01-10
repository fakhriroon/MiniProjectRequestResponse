package com.mini.project.model.response;


import lombok.Data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class EmployeeResponse {

    private Integer id;

    private String nama;

    private String dob;

    private String posisi;

    private String createdDate;

    public EmployeeResponse(Integer id, String nama, Date dob, String posisi, Date createdDate) {
        this.id = id;
        this.nama = nama;
        this.dob = convertDateToString(dob);
        this.posisi = posisi;
        this.createdDate = convertDateToString(createdDate);
    }

    protected String convertDateToString(Date date) {
        if (date==null) {
            return null;
        }
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        return dateFormat.format(date);
    }
}
