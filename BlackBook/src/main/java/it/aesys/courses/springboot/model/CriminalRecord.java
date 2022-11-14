package it.aesys.courses.springboot.model;

<<<<<<< HEAD
import it.aesys.courses.springboot.model.Report;

import java.util.HashMap;
import java.util.Map;


public class CriminalRecord {

    private Map<String, Report> mapCriminal = new HashMap<>();

    public CriminalRecord(Map<String, Report> mapCriminal) {
        this.mapCriminal = mapCriminal;
    }

    public Map<String, Report> getMapCriminal() {
        return mapCriminal;
    }

    public void setMapCriminal(Map<String, Report> mapCriminal) {
        this.mapCriminal = mapCriminal;
    }

=======
import org.springframework.stereotype.Component;

@Component
public class CriminalRecord {
>>>>>>> fbff48ef1d56a868ae94db0348d981554a580b75
}
