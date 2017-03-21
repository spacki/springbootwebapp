package guru.springframework.controllers;

import guru.springframework.domain.Product;
import guru.springframework.domain.Radiologist;
import guru.springframework.services.RadiologistService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by karstenspakowski on 21/03/17.
 */

@Controller
public class RadiologistController {

    private Logger log = Logger.getLogger(RadiologistController.class);

    private RadiologistService radiologistService;

    @Autowired
    public void setRadiologistService(RadiologistService radiologistService) {
        this.radiologistService = radiologistService;
    }

    @RequestMapping(value = "/radiologists", method = RequestMethod.GET)
    public String list(Model model){
        log.debug("get radiologists called ....");
        model.addAttribute("radiologists", radiologistService.listAllRadiologist());
        return "radiologists";
    }


    @RequestMapping("radiologist/{id}")
    public String showRadiologist(@PathVariable Integer id, Model model) {
        log.debug("get radiolgist called .. " + id);
        model.addAttribute("radiologist", radiologistService.getRadiologistById(id));
        return "radiologistshow";
    }


    @RequestMapping("radiologist/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        log.debug("edit radiologist called ... " + id);
        model.addAttribute("radiologist", radiologistService.getRadiologistById(id));
        return "radiologistform";
    }

    @RequestMapping("radiologist/new")
    public String newRadiologist(Model model) {
        log.debug("create radiologist called ... ");
        model.addAttribute("radiologist", new Radiologist());
        return "radiologistform";
    }

    @RequestMapping(value = "radiologist", method = RequestMethod.POST)
    public String saveProduct(Radiologist radiologist) {
        log.debug("post radiologist called ... " + radiologist);
        radiologistService.saveRadiologist(radiologist);
        return "redirect:/radiologist/" + radiologist.getId();
    }

    @RequestMapping("radiologist/delete/{id}")
    public String delete(@PathVariable Integer id) {
        log.debug(" delete radiologist called ... " + id);
        radiologistService.deleteRadiologist(id);
        return "redirect:/radiologists";
    }





}
