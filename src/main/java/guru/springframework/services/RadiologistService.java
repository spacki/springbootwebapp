package guru.springframework.services;

import guru.springframework.domain.Radiologist;

/**
 * Created by karstenspakowski on 21/03/17.
 */
public interface RadiologistService {

    Iterable<Radiologist> listAllRadiologist();

    Radiologist getRadiologistById(Integer id);

    Radiologist saveRadiologist(Radiologist radiologist);

    void deleteRadiologist(Integer id);

}
