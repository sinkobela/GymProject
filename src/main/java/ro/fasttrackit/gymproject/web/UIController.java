package ro.fasttrackit.gymproject.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ro.fasttrackit.gymproject.domain.Person;
import ro.fasttrackit.gymproject.services.PersonService;

@Controller
@RequestMapping("persons")
public class UIController {
    private final PersonService personService;

    public UIController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    String getPersonsPage(Model pageModel) {
        pageModel.addAttribute("persons", personService.getAll());
        return "persons";
    }

    @GetMapping("{personId}")
    String getPersonPage(Model pageModel, @PathVariable Integer personId) {
        pageModel.addAttribute("showDetails", true);
        Person one = personService.getById(personId);
        pageModel.addAttribute("selectedPerson", one);
        pageModel.addAttribute("persons", personService.getAll());
        if (one != null) {
            return "persons";
        } else {
            return "redirect:/persons";
        }
    }
}
