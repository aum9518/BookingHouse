package main.api;

import lombok.RequiredArgsConstructor;
import main.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerApi {
    private final CustomerService service;
    @GetMapping
    public String getAllAgencies(Model model) {
        model.addAttribute("customers", service.getAllCustomers());
        return "customer";
    }

}
