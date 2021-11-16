package seldi.seldi.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import seldi.seldi.model.entity.SelfDiagnosis;

@Repository
public interface SelfDiagnosisRepository extends CrudRepository<SelfDiagnosis, Long> {
}
