package com.snhu;

import org.junit.After;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class AppointmentServicesTest {

    final private AppointmentServices services = new AppointmentServices();

    @AfterEach
    public void tearDown() {
        System.out.println(AppointmentServices.getCurrentId());
    }

    @Test
    void shouldAddAppointment() {
        services.addAppointment("5511", new Date(), "Get haircut");
        assertEquals("Get haircut", services.getAppointment("5511").getDescription());
    }

    @Test
    void shouldAddAppointmentWithAppointment() {
        services.addAppointment(new Appointment("5513", new Date(), "Doctor's Appointment"));
        assertEquals("Doctor's Appointment", services.getAppointment("5513").getDescription());
    }

    @Test
    void shouldAddAppointmentWithAppointmentAndCustomId() {
        services.addAppointment("5515", new Appointment("5513", new Date(), "Doctor's Appointment"));
        assertEquals("Doctor's Appointment", services.getAppointment("5515").getDescription());
    }

    @Test
    void shouldDeleteAppointmentWithId() {
        services.addAppointment(new Appointment("5513", new Date(), "Doctor's Appointment"));
        services.deleteAppointment("5516");
        assertThrows(IllegalArgumentException.class, () -> services.getAppointment("5516"));
    }

    @Test
    void shouldNotDeleteAppointmentWithId() {
        services.addAppointment(new Appointment("5513", new Date(), "Doctor's Appointment"));
        assertThrows(IllegalArgumentException.class, () -> services.deleteAppointment("5517"));
    }
}