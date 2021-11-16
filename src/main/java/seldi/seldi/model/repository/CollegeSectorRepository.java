package seldi.seldi.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import seldi.seldi.model.entity.CollegeSector;

@Repository
public interface CollegeSectorRepository extends CrudRepository<CollegeSector, Long> {
}
