package com.example.EmployeeModule.client;


import com.example.EmployeeModule.dto.SuccessResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("NOTIFICATIONMODULE")
public interface NotificationClient {
    @PostMapping("/api/v1/notification/send-email")
    public SuccessResponse sendEmail(
            @RequestParam(name = "sender_email") String senderEmail,
            @RequestParam(name = "receiver_email") String receiverEmail);
}
