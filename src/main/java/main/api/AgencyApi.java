package main.api;

import lombok.RequiredArgsConstructor;
import main.service.AgencyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/agencies")
@RequiredArgsConstructor
public class AgencyApi {
    private final AgencyService service;
    @GetMapping
    public String getAllAgencies(Model model){
        model.addAttribute("agencies",service.getAllAgencies());
        return "agency";
    }
}
