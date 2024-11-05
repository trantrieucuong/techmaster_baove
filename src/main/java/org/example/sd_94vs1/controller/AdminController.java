package org.example.sd_94vs1.controller;

import lombok.RequiredArgsConstructor;
import org.example.sd_94vs1.entity.User;
import org.example.sd_94vs1.entity.product.Manufacturer;
import org.example.sd_94vs1.model.enums.UserRole;
import org.example.sd_94vs1.repository.Product.ManufacturerRepository;
import org.example.sd_94vs1.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final UserRepository userRepository;
    private final ManufacturerRepository manufacturerRepository;
    @GetMapping
    public String getAdminPage(Model model) {
        return "redirect:/admin/dashboard";
    }
    @GetMapping("/dashboard")
    public String getDashboardPage(Model model) {
        return "admin/dashboard/index";
    }
//lấy tất cả các user
    @GetMapping("/users")
    public String getUserPage(Model model) {
        List<User> users = userRepository.findByRole(UserRole.ADMIN);
        model.addAttribute("users", users);
        return "admin/user/index";
    }
//    Lấy tất cả các khách hàng
    @GetMapping("/custumer")
    public String getCustomerPage(Model model) {
        List<User> users = userRepository.findByRole(UserRole.USER);
        model.addAttribute("users", users);
        return "admin/user/custumer";
    }
//    Lấy nhà dung cấp
    @GetMapping("/manufacturer")
    public String getManufacturerPage(Model model) {
        List<Manufacturer>manufacturers=manufacturerRepository.findAll();
        model.addAttribute("manufacturers", manufacturers);
        return "admin/manufacturer/index";
    }



}
