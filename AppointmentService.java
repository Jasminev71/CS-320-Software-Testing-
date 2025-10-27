package org.snhu.cs320.appointment;

import java.util.HashMap;
import java.util.Map;

public class AppointmentService {

    private final Map<String, Appointment> store = new HashMap<>();

    public void addAppointment(Appointment appt) {
        if (appt == null) throw new IllegalArgumentException("Appointment cannot be null.");
        String id = appt.getAppointmentId();
        if (store.containsKey(id)) {
            throw new IllegalArgumentException("Duplicate appointment ID: " + id);
        }
        store.put(id, appt);
    }

    public void deleteAppointment(String appointmentId) {
        if (appointmentId == null || !store.containsKey(appointmentId)) {
            throw new IllegalArgumentException("No appointment with ID: " + appointmentId);
        }
        store.remove(appointmentId);
    }

    public Appointment getAppointment(String appointmentId) {
        return store.get(appointmentId);
    }

	public Integer size() {
		  return store.size(); 
	}


}