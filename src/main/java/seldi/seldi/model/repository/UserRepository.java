package seldi.seldi.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import seldi.seldi.model.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
