package com.eimt.lab.EimtLab.control;

import com.eimt.lab.EimtLab.main.Categorization;
import com.eimt.lab.EimtLab.main.Library;
import com.eimt.lab.EimtLab.services.ServiceCategorization;
import com.eimt.lab.EimtLab.services.ServiceLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/")
public class ControlLibrary {

    public ServiceLibrary serviceLibrary;
    public ServiceCategorization serviceCategorization;
    Categorization categorization;

    @Autowired
    public ControlLibrary(ServiceLibrary serviceLibrary, ServiceCategorization serviceCategorization) {
        this.serviceLibrary = serviceLibrary;
        this.serviceCategorization = serviceCategorization;
    }

    @PostConstruct
    public void inLibrary() {
        categorization = new Categorization(1, "Travel", "Travel book is a book of information about a place designed " +
                "for the use of visitors or tourists.");
        Categorization categorization2 = new Categorization(2, "Action & Adventure", "Action and Adventure is a genre of fiction that usually involves an adventure" +
                "risk taking and often action and physical danger.");

        serviceCategorization.appendCat(categorization);
        serviceCategorization.appendCat(categorization2);

        Library library = new Library(0, "Destinations of a Lifetime", 5, categorization, 0, "slika1.jpg");
        Library library1 = new Library(1, "Treasure Island", 8, categorization2, 1, "slika2.jpg");
        Library library2 = new Library(2, "Harry Potter", 8, categorization2, 1, "slika4.jpg");

        serviceLibrary.appendLib(library);
        serviceLibrary.appendLib(library1);
        serviceLibrary.appendLib(library2);
    }

    @GetMapping("/structureLibs")
    public String libForm(Model model) {
        Library library = new Library();
        List<Categorization> categorizations = serviceCategorization.catList();
        model.addAttribute("library", library);
        model.addAttribute("categorizations", categorizations);
        return "add";
    }

    @GetMapping("/libs")
    public String book(Model model) {
        List<Library> libraries = serviceLibrary.libList();
        model.addAttribute("libraries", libraries);
        return "/libs";
    }

    @GetMapping("/libs/edit/{id}")
    public String libList(@PathVariable("id") int id, Model model) {
        List<Categorization> categorizations = serviceCategorization.catList();
        model.addAttribute("categorizations", categorizations);
        Library library = serviceLibrary.lib(id);
        model.addAttribute("library", library);
        model.addAttribute("categorizations", categorizations);
        return "edit";
    }

    @PostMapping("/libs/get")
    public String appendLib(@Valid @ModelAttribute("library") Library library, BindingResult bindingResult) throws IOException {
        if (bindingResult.hasErrors()) {
            return "add";
        } else {
            library.setId(serviceLibrary.libList().size());
            library.setCatBook(serviceCategorization.cat(library.getCatInt()));
            serviceLibrary.appendLib(library);
            return "redirect:/libs";
        }
    }

    @PostMapping("/libs/edit")
    public String newLib(@Valid @ModelAttribute("library") Library library, BindingResult bindingResult) throws IOException {
        if (bindingResult.hasErrors()) {
            return "edit";
        } else {
            Library library1 = serviceLibrary.lib((int) library.getId());
            library1.setCatBook(serviceCategorization.cat(library.getCatInt()));
            library1.setBook(library.getBook());
            library1.setNum(library.getNum());
            library1.setImgBook2(library.getImgBook());
        }
        return "redirect:/libs";
    }

    @GetMapping("/libs/delete/{id}")
    public String eraseLib(@PathVariable("id") int id) {
        serviceLibrary.eraseLib(id);
        if (id < serviceLibrary.libList().size())
            for (int i = id; i < serviceLibrary.libList().size(); i++) {
                serviceLibrary.lib(i).setId(serviceLibrary.lib(i).getId()-1);
            }
        return "redirect:/libs";
    }
}