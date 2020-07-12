package com.example.pgPoc.entity;

import javax.persistence.*;


//@NamedStoredProcedureQuery(name = "insertIntoLeads", procedureName = "insert_into_leads", parameters = {
//        @StoredProcedureParameter(mode = ParameterMode.IN, name = "name", type = String.class) })
//
//@NamedStoredProcedureQuery(name = "updateLeadById", procedureName = "update_lead_by_id", parameters = {
//        @StoredProcedureParameter(mode = ParameterMode.IN, name = "id", type = Integer.class),
//        @StoredProcedureParameter(mode = ParameterMode.IN, name = "name", type = String.class)})
//
//@NamedStoredProcedureQuery(name = "deleteLeadById", procedureName = "delete_lead_by_id", parameters = {
//        @StoredProcedureParameter(mode = ParameterMode.IN, name = "id", type = Integer.class) })

@Entity
public class Lead {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
