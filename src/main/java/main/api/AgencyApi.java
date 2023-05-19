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
        return "agency";
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
    @GetMapping("/byId")
    public String getAgencyById(@PathVariable("id") Long id,Model model){
        model.addAttribute("info",service.getAgencyById(id));
        return "agencyInfo";
    }
}
