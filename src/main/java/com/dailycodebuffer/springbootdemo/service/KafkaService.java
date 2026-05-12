package com.dailycodebuffer.springbootdemo.service;

import com.dailycodebuffer.springbootdemo.model.LeadModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

    @Autowired
    private  KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private LeadService leadService;

    @Autowired
    private ObjectMapper objectMapper; // Spring Boot provides this automatically

    @KafkaListener(topics = "salesforce_leads_topic", groupId = "sales_force_leads_group")
    public void readFromKafkaTopic(ConsumerRecord<String, String> consumerRecord,
                                   Acknowledgment acknowledgment) {

        try {

            // Accessing Metadata
            String key = consumerRecord.key();
            long offset = consumerRecord.offset();
            int partition = consumerRecord.partition();
            // Manually convert the String value to your LeadModel
            LeadModel leadModel = objectMapper.readValue(consumerRecord.value(), LeadModel.class);


            System.out.println("Processing Record at Offset " + offset + " in Partition " + partition);

            if (leadModel != null) {
                // Pass to your Service
                leadService.createLead(leadModel);
            }


            // Committing the offset
            acknowledgment.acknowledge();

        }   catch (JsonProcessingException e) {
        System.err.println("Failed to parse JSON: " + e.getMessage());
    }

    }

}
