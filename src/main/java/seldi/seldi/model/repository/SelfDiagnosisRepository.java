package seldi.seldi.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import seldi.seldi.model.entity.SelfDiagnosis;
import seldi.seldi.model.entity.User;

@Repository
public interface SelfDiagnosisRepository extends CrudRepository<SelfDiagnosis, Long> {

    SelfDiagnosis findByUserIdAndDiagnosisDateLike(User user, String time);

}
