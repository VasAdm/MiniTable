package ru.vasadm.minitable.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.vasadm.minitable.Line;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class MainPageController {
    private static List<Line> lines = new ArrayList<>();
    private static Wrapper wrapper = new Wrapper();

    static {
        for (int i = 1; i < 5; i++) {
            Line line = new Line();
            List<String> strings = new ArrayList<>(Arrays.asList("", "", "", ""));
            line.setId(i);
            line.setCellsValues(strings);
            lines.add(line);
        }
    }

    @GetMapping("/")
    public String mainPage(Model model) {
        wrapper.setLineList(lines);
        model.addAttribute("wrapper", wrapper);
        return "index";
    }

    @PostMapping(value = "/")
    public String responsePage(@ModelAttribute Wrapper wrapper, Model model) {
        System.out.println(wrapper);
        MainPageController.wrapper = wrapper;
        model.addAttribute("wrapper", wrapper);
        return "index";
    }
}
