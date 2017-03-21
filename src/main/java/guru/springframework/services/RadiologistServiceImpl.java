package guru.springframework.services;

import guru.springframework.domain.Radiologist;
import guru.springframework.repositories.RadiologistRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by karstenspakowski on 21/03/17.
 */
public class RadiologistServiceImpl implements RadiologistService {

    private Logger log = Logger.getLogger(RadiologistServiceImpl.class);

    private RadiologistRepository radiologistRepository;


    @Autowired
    public void setRadiologistRepository(RadiologistRepository radiologistRepository) {
        this.radiologistRepository = radiologistRepository;
    }


    @Override
    public Iterable<Radiologist> listAllRadiologist() {
        log.debug("find all radiologists ...");
        return radiologistRepository.findAll();
    }

    @Override
    public Radiologist getRadiologistById(Integer id) {
        log.debug("find Radiologist with id " + id);
        return radiologistRepository.findOne(id);
    }

    @Override
    public Radiologist saveRadiologist(Radiologist radiologist) {
        log.debug("save radiologist " + radiologist);
        return null;
    }

    @Override
    public void deleteRadiologist(Integer id) {
        log.debug("delete radiologist with id: " + id);
        radiologistRepository.delete(id);

    }
}
