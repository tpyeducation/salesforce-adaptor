package com.dailycodebuffer.springbootdemo.model;

import jakarta.persistence.*;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AppointmentModel {

    private Integer id;

    private String name;

    private String doctor;

    private String concern;

    private String conclusion;

    private String prescription;

    private String sicknote;


}