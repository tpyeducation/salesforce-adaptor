package com.dailycodebuffer.springbootdemo.mapper;

import com.dailycodebuffer.springbootdemo.entities.EntityLead;
import com.dailycodebuffer.springbootdemo.model.LeadModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LeadsMapper {

    LeadModel toLeadModel(EntityLead entityLead);

    EntityLead toEntityLead(LeadModel leadModel);

}
