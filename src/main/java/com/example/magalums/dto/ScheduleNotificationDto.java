package com.example.magalums.dto;

import com.example.magalums.entity.Channel;
import com.example.magalums.entity.Notification;
import com.example.magalums.entity.Status;

import java.time.LocalDateTime;

public record ScheduleNotificationDto(LocalDateTime dateTime,
                                      String description,
                                      String message,
                                      Channel.Values channel) {

    public Notification toNotification() {
        return new Notification(
                dateTime,
                description,
                message,
                channel.toChannel(),
                Status.Values.PENDING.toStatus()
        );
    }
}
