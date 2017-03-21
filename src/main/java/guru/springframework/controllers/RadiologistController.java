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

    @RequestMapping(value = "/radiolgist", method = RequestMethod.GET)
    public String list(Model model){
        log.debug("get radiologist called ....");
        model.addAttribute("radiolgist", radiologistService.listAllRadiologist());
        return "radiolgists";
    }

    @RequestMapping("radiolgist/{id}")
    public String showRadiologist(@PathVariable Integer id, Model model) {
        log.debug("get radiolgist called .. " + id);
        model.addAttribute("radiolgist", radiologistService.getRadiologistById(id));
        return "radiolgistshow";
    }

    @RequestMapping("radiolgist/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        log.debug("edit radilogist called ... " + id);
        model.addAttribute("product", radiologistService.getRadiologistById(id));
        return "radiologistform";
    }

    @RequestMapping("radiolgist/new")
    public String newRadiologist(Model model){
        model.addAttribute("radiolgist", new Radiologist());
        return "radiolgistform";
    }

    @RequestMapping(value = "radiologist", method = RequestMethod.POST)
    public String saveProduct(Radiologist radiologist) {
        log.debug("post radiologist called ... " + radiologist);
        radiologistService.saveRadiologist(radiologist);
        return "redirect:/radiolgists/" + radiologist.getId();
    }

    @RequestMapping("product/delete/{id}")
    public String delete(@PathVariable Integer id) {
        log.debug(" delete radiologist called ... " + id);
        radiologistService.deleteRadiologist(id);
        return "redirect:/radiolgists";
    }





}
