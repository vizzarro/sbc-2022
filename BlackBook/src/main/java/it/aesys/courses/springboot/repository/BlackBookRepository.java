package it.aesys.courses.springboot.repository;

import it.aesys.courses.springboot.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlackBookRepository extends JpaRepository<Report, Integer> {

    List<Report> findAllByFiscalCodeNumber(String fiscalCodeNumber);
}
