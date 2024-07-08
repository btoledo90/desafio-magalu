package com.example.magalums.controller;

import com.example.magalums.dto.ScheduleNotificationDto;
import com.example.magalums.entity.Notification;
import com.example.magalums.service.NotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping
    public ResponseEntity<?> scheduleNotification(@RequestBody ScheduleNotificationDto dto) {
        notificationService.scheduleNotification(dto);

        return ResponseEntity.accepted().build();

    }

    @GetMapping("/{notificationId}")
    public ResponseEntity<Notification> getNotification(@PathVariable("notificationId") Long notificationId) {

        var notification = notificationService.findById(notificationId);

        if (notification.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(notification.get());

    }

    @DeleteMapping("/{notificationId}")
    public ResponseEntity<Void> calcelNotification(@PathVariable("notificationId") Long notificationId) {
        notificationService.cancelNotification(notificationId);
        return ResponseEntity.noContent().build();

    }

}
