package com.apps.pets.model;


import lombok.Data;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


 
import com.apps.pets.model.Visit;
import com.apps.pets.model.Pet;
import com.apps.pets.model.PetOwner;
import com.apps.pets.model.VisitScheduler;
import com.apps.pets.model.Veterian;
import com.apps.pets.model.Appointment;
import com.apps.pets.model.VaccineScheduler;
import com.apps.pets.model.Image;
import com.apps.pets.converter.DurationConverter;
import com.apps.pets.converter.UUIDToByteConverter;
import com.apps.pets.converter.UUIDToStringConverter;

import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmFunction;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.time.Duration;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Lob;
import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmMediaStream;

@Entity(name = "Appointment")
@Table(name = "\"Appointment\"", schema =  "\"petcare\"")
@Data
                        
public class Appointment {
	public Appointment () {   
  }
	  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "\"Appointment_Id\"", nullable = true )
  private Integer appointment_Id;
	  
  @Column(name = "\"DateOfappointment\"", nullable = true )
  @Temporal(value = TemporalType.TIMESTAMP)
  private Date dateOfappointment;  
  
	  
  @Column(name = "\"Reasonproblem\"", nullable = true )
  private String reasonproblem;
  
  
  
  
   
	
@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
@JoinTable(
            name="\"AppointmentPetappointment\"",
            joinColumns = @JoinColumn( name="\"Appointment_Id\""),
            inverseJoinColumns = @JoinColumn( name="\"Pet_id\""), schema = "\"petcare\"")
private List<Pet> petappointment = new ArrayList<>();


@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
@JoinTable(
            name="\"AppointmentAppointmentDetails\"",
            joinColumns = @JoinColumn( name="\"Appointment_Id\""),
            inverseJoinColumns = @JoinColumn( name="\"Visit_id\""), schema = "\"petcare\"")
private List<Visit> appointmentDetails = new ArrayList<>();


@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
@JoinTable(
            name="\"AppointmentVetPetVaccineSchedular\"",
            joinColumns = @JoinColumn( name="\"Appointment_Id\""),
            inverseJoinColumns = @JoinColumn( name="\"Vet_id\""), schema = "\"petcare\"")
private List<Veterian> vetPetVaccineSchedular = new ArrayList<>();


@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
@JoinTable(
            name="\"AppointmentVetpetappointment\"",
            joinColumns = @JoinColumn( name="\"Appointment_Id\""),
            inverseJoinColumns = @JoinColumn( name="\"Pet_ownerId\""), schema = "\"petcare\"")
private List<PetOwner> vetpetappointment = new ArrayList<>();
  
  
  
  
  
  
  
  
  
  @Override
  public String toString() {
	return "Appointment [" 
  + "Appointment_Id= " + appointment_Id  + ", " 
  + "DateOfappointment= " + dateOfappointment  + ", " 
  + "Reasonproblem= " + reasonproblem 
 + "]";
	}
	
}