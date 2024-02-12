package com.alianza.clientes.calificador;

import javax.persistence.Column;
import java.time.LocalDate;

public class SolicitudCrearClienteTest {

    private String sharedKey;

    private String name;

    private String lastName;

    private String phone;

    private String email;

    private LocalDate startDate;

    private LocalDate endDate;


    public SolicitudCrearClienteTest( String sharedKey, String name, String lastName,
                                     String phone, String email, LocalDate startDate,
                                     LocalDate endDate) {
        this.sharedKey = sharedKey;
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getSharedKey() {
        return sharedKey;
    }

    public void setSharedKey(String sharedKey) {
        this.sharedKey = sharedKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

}
