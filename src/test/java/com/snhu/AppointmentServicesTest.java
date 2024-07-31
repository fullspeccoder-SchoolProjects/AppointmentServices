package com.snhu;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;
import static org.junit.Assert.*;

public class AppointmentServicesTest {

    private AppointmentServices services;

    @BeforeEach
    public void initEach() {
        services = new AppointmentServices();
    }

    @Test
    void shouldAddAppointment() {
        services.addAppointment("5511", new Date(), "Get haircut");
        assertEquals("Get haircut", services.getAppointment("5511").getDescription());
    }

    @Test
    void shouldAddAppointmentWithLowerId() {
        services.addAppointment("1000", new Date(), "Get haircut");
        assertEquals("Get haircut", services.getAppointment("3000").getDescription());
    }

    @Test
    void appointmentServicesCurrentIdChanges() {
        services.addAppointment("5564", new Date(), "Get haircut");
        assertEquals(5565, services.getCurrentId());
    }

    @Test
    void shouldAddAppointmentWithAppointment() {
        services.addAppointment(new Appointment("5513", new Date(), "Doctor's Appointment"));
        assertEquals("Doctor's Appointment", services.getAppointment("5513").getDescription());
    }

    @Test
    void shouldAddAppointmentWithAppointmentThatHasLowerId() {
        services.addAppointment(new Appointment("1000", new Date(), "Doctor's Appointment"));
        assertEquals("Doctor's Appointment", services.getAppointment("3000").getDescription());
    }

    @Test
    void shouldAddAppointmentWithAppointmentAndCustomId() {
        services.addAppointment("5515", new Appointment("5513", new Date(), "Doctor's Appointment"));
        assertEquals("Doctor's Appointment", services.getAppointment("5515").getDescription());
    }

    @Test
    void shouldAddAppointmentWithAppointmentAndLowerId() {
        services.addAppointment("1000", new Appointment("5513", new Date(), "Doctor's Appointment"));
        assertEquals("Doctor's Appointment", services.getAppointment("3000").getDescription());
    }

    @Test
    void shouldNotAddAppointmentWithAppoinmentAndNullId() {
        assertThrows(NullPointerException.class, () -> services.addAppointment(null, new Appointment("7000", new Date(), "Get haircut")));
    }

    @Test
    void shouldNotAddAppointmentWithAppointmentAndEmptyId() {
        assertThrows(NullPointerException.class, () -> services.addAppointment("", new Appointment("7000", new Date(), "Get haircut")));
    }

    @Test
    void shouldNotAddAppointmentWithNullId() {
        assertThrows(NullPointerException.class, () -> services.addAppointment(null, new Date(), "Get haircut"));
    }

    @Test
    void shouldNotAddAppointmentWithNullDate() {
        assertThrows(NullPointerException.class, () -> services.addAppointment("7000", null, "Get haircut"));
    }

    @Test
    void shouldNotAddAppointmentWithNullDescription() {
        assertThrows(NullPointerException.class, () -> services.addAppointment("7000", new Date(), null));
    }

    @Test
    void shouldNotAddAppointmentWithEmptyId() {
        assertThrows(NullPointerException.class, () -> services.addAppointment("", new Date(), "Get haircut"));
    }

    @Test
    void shouldNotAddAppointmentWithLongId() {
        assertThrows(IllegalArgumentException.class, () -> services.addAppointment("5846544784465", new Date(), "Get haircut"));
    }

    @Test
    void shouldNotAddAppointmentWithPastDate() {
        assertThrows(IllegalArgumentException.class, () -> services.addAppointment("7000", new Date(120, Calendar.JANUARY, 2), "Get haircut"));
    }

    @Test
    void shouldNotAddAppointmentWithLongDescription() {
        assertThrows(IllegalArgumentException.class, () -> services.addAppointment("7000", new Date(), "jhasdfkjhasdfhkjasdhflkjhaslkjdfhlkjashdflkjhalskdfhlkjashdflkjhaslkjdflkjasdflkjhasdlkjfhlkjasdhflkjhashdlfhalsjkdgfhlkjasdhflkjasdhflkjhasdlfhklasjdhflkjasdhflkjahsdf"));
    }

    @Test
    void shouldDeleteAppointmentWithId() {
        services.addAppointment(new Appointment("5513", new Date(), "Doctor's Appointment"));
        services.deleteAppointment("5513");
        assertThrows(IllegalArgumentException.class, () -> services.getAppointment("5513"));
    }

    @Test
    void shouldNotDeleteAppointmentWithId() {
        assertThrows(IllegalArgumentException.class, () -> services.deleteAppointment("5513"));
    }

    @Test
    void shouldNotDeleteAppointmentWithNullId() {
        assertThrows(NullPointerException.class, () -> services.deleteAppointment(null));
    }

    @Test
    void shouldNotDeleteAppointmentWithEmptyId() {
        assertThrows(NullPointerException.class, () -> services.deleteAppointment(""));
    }

    @Test
    void shouldGetAppointmentWithId() {
        services.addAppointment("5518", new Date(), "Doctor's Appointment");
        assertEquals("Doctor's Appointment", services.getAppointment("5518").getDescription());
    }

    @Test
    void shouldNotGetAppointmentWithId() {
        assertThrows(IllegalArgumentException.class, () -> services.getAppointment("7000"));
    }

    @Test
    void shouldNotGetAppointmentWithNullId() {
        assertThrows(NullPointerException.class, () -> services.getAppointment(null));
    }

    @Test
    void shouldNotGetAppointmentWithEmptyId() {
        assertThrows(NullPointerException.class, () -> services.getAppointment(""));
    }
}