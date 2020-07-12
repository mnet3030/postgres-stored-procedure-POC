package com.example.pgPoc.repository;

import com.example.pgPoc.entity.Lead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface LeadRepository extends JpaRepository<Lead, Integer> {

    //@Procedure(name = "insertIntoLeads")

    @Transactional
    @Modifying
    @Query(value = "CALL insert_into_leads(:name);", nativeQuery = true)
    void insertIntoLeads(@Param("name") String name);

    @Transactional
    @Modifying
    @Query(value = "CALL update_lead_by_id(:id, cast(:name as varchar));", nativeQuery = true)
    void updateLeadById(@Param("id") Integer id, @Param("name") String name);

    @Transactional
    @Modifying
    @Query(value = "CALL delete_lead_by_id(:id);", nativeQuery = true)
    void deleteLeadById(@Param("id") Integer id);
}
