package com.dailycodebuffer.springbootdemo.mapper;

import com.dailycodebuffer.springbootdemo.entities.AppointmentEntity;
import com.dailycodebuffer.springbootdemo.model.AppointmentModel;
import org.gld.model.appointments.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AppointmentsMapper {
    AppointmentEntity modelToEntity(AppointmentModel appointmentModel);


}
