package com.mini.project.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GeneralResponse<T> {

    private int code;

    private T data;

    private String status;

}
