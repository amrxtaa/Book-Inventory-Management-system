package com.bim.in.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bim.in.pojo.PermRolePojo;
import com.bim.in.service.PermRoleService;
@Controller
public class PermRoleController {
	@Autowired
	private PermRoleService permRoleService;
	@GetMapping("/permrole")
	public String getAllPermRole(Model model) {
		List<PermRolePojo> permRole = permRoleService.getAllPermRole();
		if (permRole == null) {
            permRole = new ArrayList<>();
        }
		model.addAttribute("permRole",permRole);
		return "permrole";
	}
//	@GetMapping("/addPermRole")
//	public String addpermroleform() {
//		return "addPermRole";
//	}
//	@PostMapping("/addPermRole")
//	public String addPermRole(@ModelAttribute PermRolePojo permRole) {
//		permRoleService.createPermRole(permRole);
//		return "redirect:/permrole";
//	}
	@GetMapping("/permrole/new")
    public String showPermRoleForm(Model model) {
        model.addAttribute("payment", new PermRolePojo());
        return "addPermRole"; 
    }
	   @PostMapping("/permrole")
	    public String savePermole(@Validated @ModelAttribute("permrole") PermRolePojo permrole) {
	        permRoleService.savePermRole(permrole);
	        return "redirect:/permrole";
	}
}
