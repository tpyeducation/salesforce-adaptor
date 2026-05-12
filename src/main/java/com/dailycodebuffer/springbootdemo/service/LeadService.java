package com.dailycodebuffer.springbootdemo.service;

import com.dailycodebuffer.springbootdemo.entities.EntityLead;
import com.dailycodebuffer.springbootdemo.mapper.LeadsMapper;
import com.dailycodebuffer.springbootdemo.model.LeadModel;
import com.dailycodebuffer.springbootdemo.repository.LeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class LeadService {

    @Autowired
    private LeadRepository leadRepository;

    @Autowired
    private LeadsMapper leadsMapper;

    @Transactional
    public LeadModel createLead(LeadModel leadModel) {

        EntityLead entityLead = leadsMapper.toEntityLead(leadModel);
        // Basic validation or data cleaning
        if (entityLead.getName() == null || entityLead.getName().isEmpty()) {
            throw new IllegalArgumentException("Lead name cannot be empty");
        }

        EntityLead save = leadRepository.save(entityLead);
        LeadModel updatedLeadModel = leadsMapper.toLeadModel(save);

        return updatedLeadModel;
    }
}