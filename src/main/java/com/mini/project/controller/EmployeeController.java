package com.mini.project.controller;

import com.mini.project.model.request.EmployeeRequest;
import com.mini.project.model.response.EmployeeResponse;
import com.mini.project.model.response.GeneralResponse;
import com.mini.project.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("api/mini-project/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping(path = "/create", consumes = {"application/json"}, produces = {"application/json"})
    public GeneralResponse<EmployeeResponse> insertEmployee(@RequestBody @Valid EmployeeRequest employeeRequest) {
        EmployeeResponse employeeResponse = employeeService.insertEmployee(employeeRequest);

        return new GeneralResponse<>(
                200,
                employeeResponse,
                "Success"
        );
    }

    @GetMapping("/find/{id}")
    public GeneralResponse<EmployeeResponse> getEmployeeById(@PathVariable Integer id) {
        EmployeeResponse employeeResponse = employeeService.getEmployeeById(id);

        return new GeneralResponse<>(
                200,
                employeeResponse,
                "Success"
        );
    }

    @GetMapping("/find")
    public GeneralResponse<List<EmployeeResponse>> getAllEmployee() {
        List<EmployeeResponse> employeeList = employeeService.getAllEmployee();

        return new GeneralResponse<>(
                200,
                employeeList,
                "Success"
        );
    }
}
