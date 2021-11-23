package seldi.seldi.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import seldi.seldi.model.entity.Location;
import java.util.*;

@Repository
public interface LocationRepository extends CrudRepository<Location, Long> {

    @Query("select u from Location u where u.collegeId = ?1 and u.time like ?2%")
    List<Location> findByLocationList(Long collegeId, String time);

}
