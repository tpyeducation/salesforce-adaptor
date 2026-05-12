package com.dailycodebuffer.springbootdemo.service;

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


    //Read from Bulletin board (named: test-priority-appointment):  patients/doctors/politicians/receptionist
    @KafkaListener(topics = "read_appointment_topic", groupId = "doctors-group")
    public void readFromKafkaTopic(ConsumerRecord<String, String> consumerRecord, Acknowledgment acknowledgment) {
        System.out.println("===========================Reading from kafka topic: " + consumerRecord.key() + ">>>" + consumerRecord.value());
    }

}
