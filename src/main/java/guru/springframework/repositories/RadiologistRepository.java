package guru.springframework.repositories;

import guru.springframework.domain.Radiologist;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by karstenspakowski on 20/03/17.
 */
@Repository
public interface RadiologistRepository extends CrudRepository<Radiologist, Integer> {


}
