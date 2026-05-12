package com.dailycodebuffer.springbootdemo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class LeadModel {
    private String name;
    private String company;
    private String email;
    private String status;
}