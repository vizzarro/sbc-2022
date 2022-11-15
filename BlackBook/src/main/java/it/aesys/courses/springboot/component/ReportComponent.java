package it.aesys.courses.springboot.component;

import it.aesys.courses.springboot.model.Report;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class ReportComponent {

    private final List <Report> reportmockedDb;
    private Report report;

    public ReportComponent(){
        super();
        this.reportmockedDb = new ArrayList<>();
    }
}

