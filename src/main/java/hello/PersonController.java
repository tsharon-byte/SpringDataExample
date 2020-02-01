package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;

@Controller
public class PersonController {
    PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String form(@ModelAttribute Person person, BindingResult bindingResult, Model model) {
        List<Person> personsList;
        personService.save(person);
        personsList = personService.findAll();
        model.addAttribute("personsList", personsList);
        return "persons";
    }
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String home(@ModelAttribute Person person, BindingResult bindingResult, Model model) {
        System.out.println(person);
        return "index";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String form(Model model) {
        String[] currentRoles= {"Student", "Full time job"};
        String[] recommendTypes= {"Yes", "No", "Maybe"};
        String[] languageTypes={"Java","Java script", "C++"};
        model.addAttribute("currentRoles",currentRoles);
        model.addAttribute("person",new Person());
        model.addAttribute("recommendTypes", recommendTypes);
        model.addAttribute("languageTypes", languageTypes);
        return "form";
    }
}