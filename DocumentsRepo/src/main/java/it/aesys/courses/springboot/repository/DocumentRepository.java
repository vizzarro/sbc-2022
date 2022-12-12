package it.aesys.courses.springboot.repository;

import it.aesys.courses.springboot.models.Document;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocumentRepository extends JpaRepository {

    List<Document> findByFiscalCode (String fiscalCode);
}
