package it.aesys.courses.springboot.model.request;

import it.aesys.courses.springboot.model.Person;
import it.aesys.courses.springboot.model.Report;

public class PersonRequest {

    private Person person;
    private Report report;

    public PersonRequest() {
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }
}
