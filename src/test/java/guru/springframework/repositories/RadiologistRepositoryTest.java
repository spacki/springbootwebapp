package guru.springframework.repositories;

import guru.springframework.configuration.RepositoryConfiguration;
import guru.springframework.domain.Radiologist;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by karstenspakowski on 21/03/17.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {RepositoryConfiguration.class})
public class RadiologistRepositoryTest {

    RadiologistRepository radiologistRepository;

    @Autowired
    public void setRadiologistRepository(RadiologistRepository radiologistRepository) {
        this.radiologistRepository = radiologistRepository;
    }

    @Test
    public void testSaveRadiologist(){
        //setup product
        Radiologist radiologist = new Radiologist();
        radiologist.setUserName("snoopy");
        radiologist.setLastname("Bond");
        radiologist.setFirstName("James");
        radiologist.setDomain("NHU");
        radiologist.setDepartment("Radiology");
        radiologist.setEmail("snoopy@nhu.co.uk");
        radiologist.setPhoneNumber("+44 (0) 123456778");

        //save radiologist, verify has ID value after save
        assertNull(radiologist.getId()); //null before save
        radiologistRepository.save(radiologist);
        assertNotNull(radiologist.getId()); //not null after save

        //fetch from DB
        Radiologist fetchedRadiologist = radiologistRepository.findOne(radiologist.getId());

        //should not be null
        assertNotNull(fetchedRadiologist);

        //should equal
        assertEquals(radiologist.getId(), fetchedRadiologist.getId());
        assertEquals(radiologist.getUserName(), fetchedRadiologist.getUserName());

        //update description and save
        fetchedRadiologist.setUserName("woodstock");
        radiologistRepository.save(fetchedRadiologist);

        //get from DB, should be updated
        Radiologist fetchedUpdatedRadiologist = radiologistRepository.findOne(fetchedRadiologist.getId());
        assertEquals(fetchedRadiologist.getUserName(), fetchedUpdatedRadiologist.getUserName());

        //verify count of products in DB
        long productCount = radiologistRepository.count();
        assertEquals(productCount, 1);

        //get all products, list should only have one
        Iterable<Radiologist> radiologists = radiologistRepository.findAll();

        int count = 0;

        for(Radiologist r : radiologists){
            count++;
        }

        assertEquals(count, 1);
    }

}
