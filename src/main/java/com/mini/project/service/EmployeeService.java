package com.mini.project.service;

import com.mini.project.model.db.Employee;
import com.mini.project.model.request.EmployeeRequest;
import com.mini.project.model.response.EmployeeResponse;
import com.mini.project.repository.EmployeeRepository;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;


@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeService {

    private final EmployeeRepository employeeRepo;

    private final Validator validator;

    public EmployeeResponse insertEmployee(EmployeeRequest employeeRequest) {
        var result = validator.validate(employeeRequest);

        if (!result.isEmpty()) {
            throw new ConstraintViolationException(result);
        }

        Employee employee = new Employee(
                employeeRequest.getNama(),
                employeeRequest.getDob(),
                employeeRequest.getPosisi(),
                new Date()
        );

        Employee response = employeeRepo.save(employee);
        log.info("Employee saved successfully!");
        return convertToResponse(response);
    }

    public EmployeeResponse getEmployeeById(Integer id) {
        Employee employee = employeeRepo.findById(id).orElseThrow(() -> {
            log.error("Employee {} not found!", id);
            throw new NoSuchElementException("Data Employee not found");
        });

        log.info("Successfully get Employee with id {}", id);
        return convertToResponse(employee);
    }

    public List<EmployeeResponse> getAllEmployee() {
        List<EmployeeResponse> employeeList = employeeRepo.findAll().stream().map(this::convertToResponse).toList();
        return new ArrayList<>(employeeList);
    }

    private EmployeeResponse convertToResponse(Employee employee) {
        return new EmployeeResponse(
                employee.getId(),
                employee.getNama(),
                employee.getDob(),
                employee.getPosisi(),
                employee.getCreatedDate()
        );
    }

}
