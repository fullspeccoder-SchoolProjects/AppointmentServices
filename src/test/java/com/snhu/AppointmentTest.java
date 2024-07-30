package com.snhu;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class AppointmentTest {

    @Test
    void shouldCreateAppointment() {
        Appointment appointment1 = new Appointment("5511", new Date(), "Get haircut");
        assertEquals("Automotive Service Appointment", new Appointment("7821", new Date(), "Automotive Service Appointment").getDescription());
    }

    @Test
    void shouldCreateAppointmentWithAppointmentAndCustomID() {
        Appointment appointment1 = new Appointment("5511", new Date(), "Get haircut");
        Appointment appointment2 = new Appointment("2341", new Date(), "Automotive care");
        assertEquals("Get haircut", new Appointment("4187", appointment1).getDescription());
    }

    @Test
    void shouldNotCreateAppointmentWithNullId() {
        assertThrows(NullPointerException.class, () -> new Appointment(null, new Date(), "Get haircut"));
    }

    @Test
    void shouldNotCreateAppointmentWithNullDate() {
        assertThrows(NullPointerException.class, () -> new Appointment("5511", null, "Get haircut"));
    }

    @Test
    void shouldNotCreateAppointmentWithNullDescription() {
        assertThrows(NullPointerException.class, () -> new Appointment("5511", new Date(), null));
    }

    @Test
    void shouldNotCreateAppointmentWithLongId() {
        assertThrows(IllegalArgumentException.class, () -> new Appointment("7961235098577123589713458", new Date(), "Get haircut"));
    }

    @Test
    void shouldNotCreateAppointmentWithLongDescription() {
        assertThrows(IllegalArgumentException.class, () -> new Appointment("7961235098577123589713458", new Date(), "Get ha;kajsdgjhadgjafjkjagjldf;lkasdjflkjdfgjasdfhjalgj;klasfjkljsdjgfj;sdjgf;adjs;gaw;fghjadghjasbfjhsdbfvnkjfvhsdjvbhfjklsdjgkbasfvjkhasjkfbsdlhfjhanfkjshdjhlkjgvha;lsfh;jagircut"));
    }

    @Test
    void shouldNotCreateAppointmentWithPastDate() {
        assertThrows(IllegalArgumentException.class, () -> new Appointment("5511", new Date(122, Calendar.JANUARY, 3), "Get haircut"));
    }

    @Test
    void getId() {
        Appointment appointment1 = new Appointment("5511", new Date(), "Get haircut");
        assertEquals("5511", appointment1.getId());
    }

    @Test
    void getDate() {
        Appointment appointment1 = new Appointment("5511", new Date(), "Get haircut");
        assertEquals(new Date().toString(), appointment1.getDate().toString());
    }

    @Test
    void getDescription() {
        Appointment appointment1 = new Appointment("5511", new Date(), "Get haircut");
        assertEquals("Get haircut", appointment1.getDescription());
    }

    @Test
    void setDescription() {
        Appointment appointment1 = new Appointment("5511", new Date(), "Get haircut");
        appointment1.setDescription("Automotive Care");
        assertEquals("Automotive Care", appointment1.getDescription());
    }

    @Test
    void setDate() {
        Appointment appointment1 = new Appointment("5511", new Date(), "Get haircut");
        appointment1.setDate(new Date(125, Calendar.JANUARY, 3));

        assertEquals(new Date(125, Calendar.JANUARY, 3), appointment1.getDate());
    }

    @Test
    void shouldNotSetDate() {
        Appointment appointment1 = new Appointment("5511", new Date(), "Get haircut");
        assertThrows(IllegalArgumentException.class, () -> appointment1.setDate(new Date(122, Calendar.JANUARY, 3)));
    }
}