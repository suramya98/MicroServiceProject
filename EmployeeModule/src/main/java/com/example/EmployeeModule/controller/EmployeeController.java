package com.example.EmployeeModule.controller;

import com.example.EmployeeModule.dto.EmployeeRequest;
import com.example.EmployeeModule.dto.SuccessResponse;
import com.example.EmployeeModule.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee/v1")
public class EmployeeController {
    private final EmployeeService employeeService;
    @PostMapping(path = "")
    public SuccessResponse registerEmployee(@RequestBody EmployeeRequest request) {

        Integer id = employeeService.registerEmployee(request);
        return SuccessResponse.builder()
                .message("Employee registered")
                .status(HttpStatus.CREATED)
                .data(id)
                .timestamp(LocalDateTime.now())
                .build();

    }

}
