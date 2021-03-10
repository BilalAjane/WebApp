/*package com.example.demo.Controller;

import com.example.demo.Model.Product;
import com.example.demo.Repository.ProductRepository;
import com.example.demo.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/")
    public String index(Model model){
        //add all products to view model from productService
        model.addAttribute("prod",productService.getAll());
        return ("index");
    }

    @GetMapping("/create")
    public String create(){
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Product prod){
        System.out.println(prod);
        productService.create(prod);
        return "redirect:/";
    }

    @GetMapping("/update/{idproduct}")
    public String update(@PathVariable("idproduct") long id, Model model){
        //tilføj produkt med id til model view
        model.addAttribute("prod", productService.findProductById(id));
        return "update";
    }

    //update product
    @PostMapping("/update")
    public String update(@ModelAttribute Product prod){
        //update by using update service
        productService.updateProduct(prod);
        return "redirect:/";
    }

    //delete product
    @GetMapping("/delete/{idproduct}")
    public String delete(@PathVariable("idproduct") long id, Model model){
        productService.deleteProduct(id);
        return "redirect:/";
    }

}
 */
