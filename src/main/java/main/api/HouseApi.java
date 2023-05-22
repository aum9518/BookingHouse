package main.api;

import lombok.RequiredArgsConstructor;
import main.entity.Customer;
import main.entity.House;
import main.service.AgencyService;
import main.service.HouseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/houses")
@RequiredArgsConstructor
public class HouseApi {
    private final HouseService service;
    private final AgencyService agencyService;
    @GetMapping
    public String getAllCustomer(Model model) {
        model.addAttribute("houses", service.getAllHouses());
        return "house";
    }
    @GetMapping("/newHouse")
    public String createHouse(Model model) {
        model.addAttribute("newHouse", new House());
        model.addAttribute("agencies", agencyService.getAllAgencies());
        return "newHouse";
    }

    @PostMapping("/saveHouse")
    public String saveHouse(@ModelAttribute("newHouse") House House) {
        service.saveHouse(House);
        return "redirect:/Houses";
    }
    @DeleteMapping("/{id}/delete")
    public String deleteHouse(@PathVariable("id") Long id){
        service.deleteHouseById(id);
        return "redirect:/houses";
    }
}
