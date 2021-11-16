package seldi.seldi.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import seldi.seldi.model.entity.Location;

@Repository
public interface LocationRepository extends CrudRepository<Location, Long> {
}
