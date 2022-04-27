package ru.gb.thymeleafprepare.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gb.thymeleafprepare.service.CartService;
import ru.gb.thymeleafprepare.service.ProductService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;
    private final ProductService productService;

    @GetMapping("/cart")
    public String cart(Model model) {
        model.addAttribute("productCart", cartService.allProductInCart());
        return "cart";
    }

    @GetMapping("/addProductInCart/{id}")
    public String addProduct(@PathVariable(name = "id") Long id) {
        cartService.addProductInCart(id);
        return "redirect:/product/all";
    }

    @GetMapping("/deleteProduct/{id}")
    public String deleteFromCart(@PathVariable(name = "id") Long id) {
        cartService.deleteFromCartById(id);
        return "redirect:/product/cart";
    }
}
