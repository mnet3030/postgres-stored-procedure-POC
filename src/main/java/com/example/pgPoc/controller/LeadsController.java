package com.example.pgPoc.controller;


import com.example.pgPoc.entity.Lead;
import com.example.pgPoc.repository.LeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
public class LeadsController {

    @Autowired
    LeadRepository leadRepository;

    @PostMapping("/leads")
    void insertIntoLeads(@RequestBody Lead lead) {
        leadRepository.insertIntoLeads(lead.getName());
    }

    @GetMapping("/leads/{id}")
    ResponseEntity<Lead> getLeadById(@PathVariable("id") int id) {
        Optional<Lead> optionalLead = leadRepository.findById(id);
        if(optionalLead.isPresent())
            return new ResponseEntity<>(optionalLead.get(), HttpStatus.CREATED);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/leads/{id}")
    ResponseEntity<Lead> updateLeadById(@PathVariable("id") int id, @RequestBody  Lead lead) {
        leadRepository.updateLeadById(id, lead.getName());
        Lead updatedLead = leadRepository.findById(id).get();
        return new ResponseEntity<>(updatedLead, HttpStatus.CREATED);
    }

    @DeleteMapping("/leads/{id}")
    void deleteLeadById(@PathVariable("id") int id) {
        leadRepository.deleteLeadById(id);
    }
}
