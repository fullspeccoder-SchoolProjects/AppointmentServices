package com.snhu;

import java.util.Calendar;
import java.util.Date;

public class Appointment {
    final Date curDate = new Date(124, Calendar.JULY, 30);
    final String appointmentId;
    Date appointmentDate;
    String appointmentDescription;

    public Appointment(String id, Date date, String description) {
        checkIfPhraseIsNullOrEmpty(id);
        checkIfPhraseIsNullOrEmpty(description);
        checkIfDateIsNull(date);
        checkLengthOfPhrase(id, 10);
        checkLengthOfPhrase(description, 50);
        checkIfDateInPast(date);
        this.appointmentId = id;
        this.appointmentDate = date;
        this.appointmentDescription = description;
    }

    public Appointment(String id, Appointment appointment) {
        checkIfPhraseIsNullOrEmpty(id);
        checkLengthOfPhrase(id, 10);
        this.appointmentId = id;
        this.appointmentDate = appointment.getDate();
        this.appointmentDescription = appointment.getDescription();
    }

    public String getId() {
        return appointmentId;
    }

    public Date getDate() {
        return appointmentDate;
    }

    public String getDescription() {
        return appointmentDescription;
    }

    private void checkLengthOfPhrase(String phrase, int length) {
        if(phrase.length() > length) {
            throw new IllegalArgumentException(String.format("%s is too long", phrase));
        }
    }

    private void checkIfPhraseIsNullOrEmpty(String phrase) {
        if(phrase == null || phrase.isEmpty()) {
            throw new NullPointerException("String is null or empty");
        }
    }

    private void checkIfDateIsNull(Date date) {
        if(date == null) {
            throw new NullPointerException("Date is null");
        }
    }

    private void checkIfDateInPast(Date date) {
        if(date.before(curDate)) {
            throw new IllegalArgumentException("Date is in the past");
        }
    }
}
