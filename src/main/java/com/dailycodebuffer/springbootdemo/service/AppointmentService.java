package com.dailycodebuffer.springbootdemo.service;


import com.dailycodebuffer.springbootdemo.entities.AppointmentEntity;
import com.dailycodebuffer.springbootdemo.mapper.AppointmentsMapper;
import com.dailycodebuffer.springbootdemo.model.AppointmentModel;
import com.dailycodebuffer.springbootdemo.practice.Person;
import com.dailycodebuffer.springbootdemo.repository.AppointmentRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class AppointmentService implements IAppointmentService { //car toyota

//steering 1
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private AppointmentsMapper appointmentsMapper;
  

    @Override
    public AppointmentModel saveAppointment(AppointmentModel appointmentModel) {
        AppointmentEntity appointmentEntity = appointmentsMapper.modelToEntity(appointmentModel);
        log.info("=======================About to write to Save Data - Step 5");;
        AppointmentEntity save = appointmentRepository.save(appointmentEntity);
        appointmentModel.setId(save.getId().intValue());
        return appointmentModel;
    }
}
