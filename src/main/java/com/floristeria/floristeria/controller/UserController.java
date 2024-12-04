package com.floristeria.floristeria.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

// import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;

// import com.floristeria.floristeria.domain.entities.FloresEntity;
import com.floristeria.floristeria.domain.entities.UserEntity;
// import com.floristeria.floristeria.services.FloresService;
import com.floristeria.floristeria.services.UserService;

@Controller
@RequestMapping("/")
public class UserController {
    @Autowired
    private UserService objUserService;

    // @Autowired
    // private FloresService objFloresService;

    @GetMapping
    public String showViewGetAll(Model objModel, @RequestParam( defaultValue = "0") int page, @RequestParam( defaultValue = "3") int size) {
        Page<UserEntity> list = this.objUserService.findPaginated(page - 1, size);

        objModel.addAttribute("userList", list); // Llave- valor
        objModel.addAttribute("currentPage", page); // Llave- valor
        objModel.addAttribute("totalPages", list.getTotalPages()); // Llave- valor

        return "viewUser";
    }    

    @GetMapping("/form")
    public String showViewFormUser(Model objModel) {

        objModel.addAttribute("user", new UserEntity());
        objModel.addAttribute("action", "/user/create");
        return "viewForm";
    }

    @GetMapping("/update/{id}")
    public String showFormUpdate(@PathVariable Long id, Model objModel) {
        UserEntity objUserFind = this.objUserService.findById(id);
        objModel.addAttribute("user", objUserFind);
        objModel.addAttribute("action", "/edit/" + id);
        return "viewForm";
    }

    @PostMapping("/edit/{id}")
    public String updateUser(@PathVariable Long id, @ModelAttribute UserEntity objUser) {
        this.objUserService.update(id, objUser);

        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id){
        this.objUserService.delete(id);
        return "redirect:/";
    }

    @PostMapping("/user/create")
    public String createUser(@ModelAttribute UserEntity objUser) {
        this.objUserService.insert(objUser);
        return "redirect:/";
    }

    // // inventario

    // @GetMapping("/inventario/{id}")
    // public String showInventario(Model objModel, @PathVariable Long id) {
    //     UserEntity objUser = this.objUserService.findById(id);
    //     objModel.addAttribute("user", objUser);
    //     return "viewInventario";
    // }

}
