package com.snhu;

import java.util.Date;

public class Appointment {
    final String appointmentId;
    Date appointmentDate;
    String appointmentDescription;

    public Appointment(String id, Date date, String description) {
        checkIfPhraseIsNull(id);
        checkIfPhraseIsNull(description);
        checkLengthOfPhrase(id, 10);
        checkLengthOfPhrase(id, 50);
        checkIfDateInPast(date);
        this.appointmentId = id;
        this.appointmentDate = date;
        this.appointmentDescription = description;
    }

    public Appointment(String id, Appointment appointment) {
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

    public void setDescription(String description) {
        this.appointmentDescription = description;
    }

    public void setDate(Date date) {
        this.appointmentDate = date;
    }

    private void checkLengthOfPhrase(String phrase, int length) {
        if(phrase.length() > length) {
            throw new IllegalArgumentException(String.format("%s is too long", phrase));
        }
    }

    private void checkIfPhraseIsNull(String phrase) {
        if(phrase == null) {
            throw new NullPointerException("String is null");
        }
    }

    private void checkIfDateInPast(Date date) {
        if(date.before(new Date())) {
            throw new IllegalArgumentException("Date is in the past");
        }
    }
}
