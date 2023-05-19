package main.api;

import jakarta.persistence.Id;
import lombok.RequiredArgsConstructor;
import main.entity.Agency;
import main.service.AgencyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/agencies")
@RequiredArgsConstructor
public class AgencyApi {
    private final AgencyService service;

    @GetMapping
    public String getAllAgencies(Model model) {
        model.addAttribute("agencies", service.getAllAgencies());
        return "index";
    }

    @GetMapping("/new")
    public String createAgency(Model model) {
        model.addAttribute("newAgency", new Agency());
        return "newAgency";
    }

    @PostMapping("/save")
    public String saveAgency(@ModelAttribute("newAgency") Agency agency) {
        service.saveAgency(agency);
        return "redirect:/agencies";
    }
    @DeleteMapping("/{id}/delete")
    public String deleteAgency(@PathVariable("id") Long id){
        service.deleteAgencyById(id);
        return "redirect:/agencies";
    }
    @GetMapping("/{id}")
    public String getAgencyById(@PathVariable("id") Long id,Model model){
       try{
           Agency agency = service.getAgencyById(id);
           if (agency == null){
               return "errorPage";
           }
           model.addAttribute("info",agency);
           return "agencyInfo";
       } catch (Exception e) {
           System.out.println(e.getMessage());
       }
       return "errorPage";
    }
    @GetMapping("/{id}/edit")
    public String update(@PathVariable("id")Long id, Model model){
       try{
           Agency agency = service.getAgencyById(id);
           if (agency  == null){
               return "errorPage";
           }
           model.addAttribute("editAgency",agency);
           return "updateAgency";
       } catch (Exception e) {
           System.out.println(e.getMessage());
       }
        return "updateAgency";
    }
    @PostMapping("/updateAgency/{id}")
    public String saveUpdate(@ModelAttribute("editAgency") Agency agency, @PathVariable("id") Long id){
        service.updateAgency(id,agency);
        return "redirect:agencies";
    }
}
