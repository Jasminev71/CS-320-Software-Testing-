package org.snhu.cs320.appointment;

import java.util.Date;


public class Appointment {

    private final String appointmentId;
    private Date appointmentDate;
    private String description;

    public Appointment(String appointmentId, Date appointmentDate, String description) {
        validateId(appointmentId);
        setAppointmentDate(appointmentDate); 
        setDescription(description);        
        this.appointmentId = appointmentId;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public Date getAppointmentDate() {
        // KEEP: Defensive copy is best practice to meet "not in the past" requirement
        return new Date(appointmentDate.getTime());
    }

    public String getDescription() {
        return description;
    }

  
    public void setAppointmentDate(Date appointmentDate) {
        validateDate(appointmentDate);
        // KEEP: Defensive copy is best practice to meet "not in the past" requirement
        this.appointmentDate = new Date(appointmentDate.getTime());
    }

    public void setDescription(String description) {
        validateDescription(description);
        this.description = description;
    }

 
    private static void validateId(String id) {
        if (id == null || id.length() > 10) {
            throw new IllegalArgumentException("Appointment ID must be non-null and <= 10 characters.");
        }
    }

    private static void validateDate(Date d) {
        if (d == null || d.before(new Date())) {
            throw new IllegalArgumentException("Appointment date must be non-null and not in the past.");
        }
    }

    private static void validateDescription(String desc) {
        if (desc == null || desc.length() > 50) {
            throw new IllegalArgumentException("Description must be non-null and <= 50 characters.");
        }
    }

    // }
}