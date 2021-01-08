package at.fhv.cqrs.domain;

import java.time.LocalDate;

public class Person {

    private String _surName;
    private String _lastName;
    private LocalDate _birthday;

    public Person(String surName, String lastName, LocalDate birthday){
        _surName = surName;
        _lastName = lastName;
        _birthday = birthday;
    }

    @Override
    public String toString(){
        return _surName + " " + _lastName + " ";
    }
}
