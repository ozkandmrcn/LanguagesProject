package enoca.enoca.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import enoca.enoca.entities.concretes.Language;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Integer> {

}
