package seldi.seldi.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import seldi.seldi.model.entity.College;

@Repository
public interface CollegeRepository extends CrudRepository<College, Long> {
}
