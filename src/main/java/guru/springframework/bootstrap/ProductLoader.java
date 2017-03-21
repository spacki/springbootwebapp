package guru.springframework.bootstrap;

import guru.springframework.domain.Product;
import guru.springframework.domain.Radiologist;
import guru.springframework.repositories.ProductRepository;
import guru.springframework.repositories.RadiologistRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ProductLoader implements ApplicationListener<ContextRefreshedEvent> {

    private ProductRepository productRepository;

    private RadiologistRepository radiologistRepository;

    private Logger log = Logger.getLogger(ProductLoader.class);

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Autowired
    public void setRadiologistRepository(RadiologistRepository radiologistRepository) {
        this.radiologistRepository = radiologistRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        Product shirt = new Product();
        shirt.setDescription("Spring Framework Guru Shirt");
        shirt.setPrice(new BigDecimal("18.95"));
        shirt.setImageUrl("https://springframework.guru/wp-content/uploads/2015/04/spring_framework_guru_shirt-rf412049699c14ba5b68bb1c09182bfa2_8nax2_512.jpg");
        shirt.setProductId("235268845711068308");
        productRepository.save(shirt);

        log.info("Saved Shirt - id: " + shirt.getId());

        Product mug = new Product();
        mug.setDescription("Spring Framework Guru Mug");
        mug.setImageUrl("https://springframework.guru/wp-content/uploads/2015/04/spring_framework_guru_coffee_mug-r11e7694903c348e1a667dfd2f1474d95_x7j54_8byvr_512.jpg");
        mug.setProductId("168639393495335947");
        mug.setPrice(new BigDecimal("11.95"));
        productRepository.save(mug);

        log.info("Saved Mug - id:" + mug.getId());

         /* some Radiologists */

        Radiologist radiologist1 = new Radiologist();
        radiologist1.setUserName("NhuRadio1");
        radiologist1.setDomain("NHU");
        radiologist1.setEmail("radio1@nhu.uk.co");
        radiologist1.setDepartment("radiology");
        radiologist1.setLastName("Mouse");
        radiologist1.setFirstName("Micky");
        radiologist1.setPhoneNumber("+44 (0) 12345");

        radiologistRepository.save(radiologist1);

        log.info("saved  Radiologist 1: " + radiologist1.getId());


        Radiologist radiologist2 = new Radiologist();
        radiologist2.setUserName("NhuRadio2");
        radiologist2.setDomain("NHU");
        radiologist2.setEmail("radio2@nhu.uk.co");
        radiologist2.setDepartment("radiology");
        radiologist2.setLastName("Mouse");
        radiologist2.setFirstName("Minny");
        radiologist2.setPhoneNumber("+44 (0) 12345");

        radiologistRepository.save(radiologist2);

        log.info("saved  Radiologist 2: " + radiologist2.getId());


    }
}
