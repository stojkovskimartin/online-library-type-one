package com.eimt.lab.EimtLab.control;

import com.eimt.lab.EimtLab.data.CategorizationData;
import com.eimt.lab.EimtLab.main.Categorization;
import com.eimt.lab.EimtLab.services.ServiceCategorization;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/request")
public class ControlCategorization {

    private ServiceCategorization serviceCategorization;
    Random r;

    public ControlCategorization(ServiceCategorization  serviceCategorization){
        this.serviceCategorization = serviceCategorization;
        r = new Random();
    }

    @PostConstruct
    public void appendCategorization(){
        Categorization categorization = new Categorization(0, "Comics", "Comic books are magazines that use a series of pictures" +
                "usually accompanied by words, to tell stories.");
        serviceCategorization.appendCat(categorization);

        }

        @GetMapping("/categorizations")
        public List<Categorization> catList(){
        return serviceCategorization.catList();

    }

        @GetMapping("/categorizations/{id}")
        public Categorization cat(@PathVariable("id") int id){
        return serviceCategorization.cat(id);
        }


    @DeleteMapping("/categorizations/{id}")
    public void eraseCat(@PathVariable("id") int id){
        serviceCategorization.eraseCat(id);
    }

    @PostMapping("/categorizations")
        public void appendLib(@RequestBody Categorization categorization){
        categorization.setId(serviceCategorization.catList().size()+1);
        serviceCategorization.appendCat(categorization);
        }
    }

