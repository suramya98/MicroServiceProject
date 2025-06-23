package com.example.EmployeeModule.service;


import com.example.EmployeeModule.client.NotificationClient;
import com.example.EmployeeModule.dto.EmployeeRequest;
import com.example.EmployeeModule.dto.SuccessResponse;
import com.example.EmployeeModule.entity.Employee;
import com.example.EmployeeModule.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final RestTemplate restTemplate;
    private final NotificationClient notificationClient;
    
    public Integer registerEmployee(EmployeeRequest request) throws RuntimeException{
        Employee employee = Employee.builder()
                            .firstname(request.getFirstname())
                            .lastname(request.getLastname())
                            .email(request.getEmail())
                            .build();
        String senderEmail="hr@company.com";
        String receiverEmail=employee.getEmail();

        Integer id = employeeRepository.save(employee).getId();
//       SuccessResponse response=restTemplate.postForObject("http://NOTIFICATIONMODULE/api/v1/notification/send-email?sender_email={senderEmail}&receiver_email={receiverEmail}",
//               null, SuccessResponse.class,senderEmail,receiverEmail);
        SuccessResponse response=notificationClient.sendEmail(senderEmail,receiverEmail);
        System.out.println(response.getData());
        return id;
    }
}
