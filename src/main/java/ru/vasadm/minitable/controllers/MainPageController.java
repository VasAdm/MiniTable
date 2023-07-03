package ru.vasadm.minitable.controllers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.vasadm.minitable.MyTest;

import java.util.ArrayList;
import java.util.Arrays;

@Controller
public class MainPageController {
    @GetMapping("/")
    public String mainPage(Model model) {
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("");
        stringList.add("");
        stringList.add("");
        stringList.add("");
        model.addAttribute("stringList", stringList);
        return "index";
    }
    @PostMapping(value = "/query", produces = MediaType.TEXT_HTML_VALUE)
    public ResponseEntity<String> responsePage(@ModelAttribute ArrayList<String> stringList) {
        System.out.println(stringList.toString());
        return ResponseEntity.ok(stringList.toString());
    }
}
