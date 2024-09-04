package com.hexaexplorers.Daily_updates.Controller;

import com.hexaexplorers.Daily_updates.Entity.Info;
import com.hexaexplorers.Daily_updates.Services.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MainController {

    @Autowired
    private InfoService infoService;


    @GetMapping({"/", "viewInfo"})
    public String viewAllInfo(Model model, @ModelAttribute("message") String message)
    {
        model.addAttribute("list",infoService.getAllInfo());
        model.addAttribute("message",message);
        return "ViewInfo";

    }

    @GetMapping("/info/create")
    public String createInfoForm(Model model)
    {
        Info info=new Info();
        model.addAttribute("info",info);
        return "addInfo";
    }

    @PostMapping("/info")
    public String saveInfo(@ModelAttribute("info")Info info)
    {
        infoService.saveOrUpdateInfo(info);
        return "redirect:/viewInfo";
    }

    @GetMapping("/updateinfo/edit/{id}")
    public String updateStatus(@PathVariable Long id,Model model)
    {
        model.addAttribute("info",infoService.getItemById(id));
        return "editInfo";
    }

    @PostMapping("/info/{id}")
    public String updateInfo(@PathVariable Long id,@ModelAttribute("info") Info info)
    {
        Info existingInfo=infoService.getItemById(id);
        existingInfo.setId(id);
        existingInfo.setInfo_name(info.getInfo_name());
        existingInfo.setData(info.getData());
        existingInfo.setStatus(info.getStatus());
        infoService.saveOrUpdateInfo(existingInfo);

        return "redirect:/viewInfo";
    }









}
