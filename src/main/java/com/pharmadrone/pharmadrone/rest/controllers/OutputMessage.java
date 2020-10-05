package com.pharmadrone.pharmadrone.rest.controllers;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OutputMessage {
    private String from;
    private String message;
    private String time;
}
