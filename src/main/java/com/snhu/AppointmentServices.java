package com.snhu;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AppointmentServices {
    final List<Appointment> appointments = new ArrayList<Appointment>();
    static int currentId = 3000;

    AppointmentServices() {

    }

    void addAppointment(Appointment appointment) {
        currentId++;
    }

    void addAppointment(String description, Date date) {
        currentId++;
    }

    void addAppointment(String id, String description, Date date) {
        currentId++;
    }

    void deleteAppointment(String id) {

    }
}
