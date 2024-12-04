package com.floristeria.floristeria.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import com.floristeria.floristeria.domain.entities.FloresEntity;
import com.floristeria.floristeria.services.FloresService;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/")
public class FloresController {
    
    @Autowired
    private FloresService objFloresService;

    // @Autowired
    // private UserService objUserService;
    // @GetMapping
    // public String showViewGetAll(Model objModel, @RequestParam( defaultValue = "0") int page, @RequestParam( defaultValue = "3") int size) {
    //     Page<FloresEntity> list = this.objFloresService.findPaginated(page - 1, size);

    //     objModel.addAttribute("floresList", list); // Llave- valor
    //     objModel.addAttribute("currentPage", page); // Llave- valor
    //     objModel.addAttribute("totalPages", list.getTotalPages()); // Llave- valor

    //     return "viewInventario";
    // }

    @GetMapping("/inventario/{user_id}")
    public String showInventario(Model objModel, @PathVariable int user_id) {
        List<FloresEntity> flores = this.objFloresService.getAllByUserId(user_id);
        objModel.addAttribute("flores", flores);
        return "viewInventario";
    }

    @GetMapping("/inventario/form")
    public String showViewFormFlores(Model objModel) {
        objModel.addAttribute("flores", new FloresEntity());
        return "viewFormFlores";
    }


    @PostMapping("/inventario/create")
    public String createStock(@ModelAttribute FloresEntity objFlores) {
        this.objFloresService.insert(objFlores);
        return "redirect:/";
    }
}
