package com.snhu;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class AppointmentServices {
    final List<Appointment> appointments = new ArrayList<>();
    int currentId = 3000;

    public int getCurrentId() {
        return currentId;
    }

    AppointmentServices() {

    }

    public Appointment getAppointment(String id) {
        if(id == null || id.isEmpty()) {
            throw new NullPointerException("Appointment id cannot be null or empty");
        }
        for(Appointment a : appointments) {
            if(a.getId().equals(id)) {
                return a;
            }
        }
        throw new IllegalArgumentException("Appointment with id " + id + " not found");
    }

    void addAppointment(Appointment appointment) {
        String formattedId = String.format("%s", currentId >= Integer.parseInt(appointment.getId()) ? currentId++ : appointment.getId());
        appointments.add(new Appointment(formattedId, appointment));
        if(currentId < Integer.parseInt(appointment.getId())) {
            currentId = Integer.parseInt(appointment.getId()) + 1;
        }
    }

    void addAppointment(String id, Appointment appointment) {
        if (id == null || id.isEmpty()) {
            throw new NullPointerException("Appointment id cannot be null or empty");
        }
        String formattedId = String.format("%s", currentId >= Integer.parseInt(id) ? currentId++ : id);
        appointments.add(new Appointment(formattedId, appointment));
        if(currentId < Integer.parseInt(id)) {
            currentId = Integer.parseInt(id) + 1;
        }
    }

    void addAppointment(String id, Date date, String description) {
        if (id == null || id.isEmpty()) {
            throw new NullPointerException("Appointment id cannot be null or empty");
        }
        String formattedId = String.format("%s", currentId >= Integer.parseInt(id) ? currentId++ : id);
        appointments.add(new Appointment(formattedId, date, description));
        if(currentId < Integer.parseInt(id)) {
            currentId = Integer.parseInt(id) + 1;
        }
    }

    void deleteAppointment(String id) {
        if(id == null || id.isEmpty()) {
            throw new NullPointerException("Appointment id cannot be null or empty");
        }
        if(!appointments.removeIf((appointment) -> Objects.equals(appointment.getId(), id))) {
            throw new IllegalArgumentException("Id not found in appointments");
        }
    }
}
