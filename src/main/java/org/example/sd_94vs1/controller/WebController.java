package org.example.sd_94vs1.controller;

import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.sd_94vs1.entity.Blog;
import org.example.sd_94vs1.entity.User;
import org.example.sd_94vs1.entity.product.Category;
import org.example.sd_94vs1.entity.product.Manufacturer;
import org.example.sd_94vs1.entity.product.Product;
import org.example.sd_94vs1.entity.product.ProductType;
import org.example.sd_94vs1.service.BlogService;
import org.example.sd_94vs1.service.product.CategoryService;
import org.example.sd_94vs1.service.product.ManufacturerService;
import org.example.sd_94vs1.service.product.ProductService;
import org.example.sd_94vs1.service.product.ProductTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class WebController {

    private final ProductService productService;
    private final ProductTypeService productTypeService;
    private final CategoryService categoryService;
    private final ManufacturerService manufacturerService;
    private final HttpSession session;
    private final BlogService blogService;


    @GetMapping("/")
    public String getHomePage(Model model) {
//        Phân danh mục cớ bản không theo enum
        List<Product> productsmini = productService.findProductsByCodeAndType("mn","bn001");
        List<Product> productsmavic = productService.findProductsByCodeAndType("mv","bn001");

        List<ProductType> productTypes = productTypeService.findAll();
        List<Category> categories = categoryService.findAll();
        List<Manufacturer>manufacturers=manufacturerService.getAll();
        // Lấy 4 bài viết mới nhất
        List<Blog> latestBlogs = blogService.getLatestBlogs(4);

        model.addAttribute("productsmini", productsmini);
        model.addAttribute("productsmavic", productsmavic);
        model.addAttribute("productTypes", productTypes);
        model.addAttribute("categories", categories);
        model.addAttribute("manufacturers", manufacturers);
        model.addAttribute("latestBlogs", latestBlogs);
        return "web/index";
    }
    @GetMapping("/dang-ky")
    public String getDangKyPage() {
        User user = (User) session.getAttribute("currentUser"); // Lấy thông tin người dùng trong session
        if (user != null) { // Nếu đăng nhập thì chuyển hướng về trang chủ
            return "redirect:/";
        }
        return "web/dang-ky"; // Nếu chưa đăng nhập thì hiển thị trang đăng ký
    }

    @GetMapping("/dang-nhap")
    public String getDangNhapPage() {
        User user = (User) session.getAttribute("currentUser"); // Lấy thông tin người dùng trong session
        if (user != null) { // Nếu đăng nhập thì chuyển hướng về trang chủ
            return "redirect:/";
        }
        return "web/dang-nhap"; // Nếu chưa đăng nhập thì hiển thị trang đăng nhập
    }

}
