package guru.springframework.repositories;

import guru.springframework.domain.Radiologist;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by karstenspakowski on 21/03/17.
 */
public interface RadiologistRepository extends CrudRepository<Radiologist, Integer> {



}
