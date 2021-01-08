package at.fhv.cqrs.domain;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;
@Schema
public class Person {

    private String _surName;
    private String _lastName;
    private LocalDate _birthday;

    public Person(String surName, String lastName, LocalDate birthday){
        _surName = surName;
        _lastName = lastName;
        _birthday = birthday;
    }

    public Person(){
    }

    @Override
    public String toString(){
        return _surName + " " + _lastName + " ";
    }

    @Schema
    public String getSurName() {
        return _surName;
    }

    @Schema
    public String getLastName() {
        return _lastName;
    }

    @Schema
    public LocalDate getBirthday() {
        return _birthday;
    }

    @Schema
    public void setSurName(String surName) {
        _surName = surName;
    }

    @Schema
    public void setLastName(String lastName) {
        _lastName = lastName;
    }

    @Schema
    public void setBirthday(LocalDate birthday) {
        _birthday = birthday;
    }
}
