package org.snhu.cs320.appointment;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

class AppointmentTest {

    private Date future(long minutesAhead) {
        return new Date(System.currentTimeMillis() + minutesAhead * 60_000L);
    }

    @Test
    void testSuccessfulCreation() {
        Appointment a = new Appointment("A123", future(10), "Checkup");
        assertEquals("A123", a.getAppointmentId());
        assertEquals("Checkup", a.getDescription());
        assertTrue(a.getAppointmentDate().after(new Date()));
    }

    @Test
    void testIdNotUpdatable() {
        Appointment a = new Appointment("LOCKED", future(5), "Init");
        // Confirm the ID remains constant after modifying other fields
        a.setDescription("Updated");
        a.setAppointmentDate(future(15));
        assertEquals("LOCKED", a.getAppointmentId());
        assertEquals("Updated", a.getDescription());
    }
    
    @Test
    void testInvalidIdThrowsException() {
        Date futureDate = new Date(System.currentTimeMillis() + 60_000);
        // ID longer than 10 characters should fail
        assertThrows(IllegalArgumentException.class, () ->
            new Appointment("12345678901", futureDate, "Dentist appointment"));
    }

}