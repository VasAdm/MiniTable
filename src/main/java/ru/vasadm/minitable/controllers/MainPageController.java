package ru.vasadm.minitable.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.vasadm.minitable.Line;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainPageController {
    private static Wrapper wrapper = new Wrapper();

    static {
        List<Line> lineList = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            Line line = new Line();
            line.setId(i);
            List<String> list = new ArrayList<>();
            list.add("");
            list.add("");
            list.add("");
            list.add("");
            line.setValues(list);
//            line.setA("");
//            line.setB("");
//            line.setC("");
//            line.setD("");
            lineList.add(line);
        }
        wrapper.setLineList(lineList);
    }

    @GetMapping("/")
    public String mainPage(Model model) {
        model.addAttribute("wrapper", wrapper);
        return "index";
    }

    @PostMapping(value = "/")
    public String responsePage(@ModelAttribute Wrapper wrapper) {
        System.out.println(wrapper);
        MainPageController.wrapper = wrapper;
        return "index";
    }

    private Wrapper operations(Wrapper wrapper) {
        List<Line> tmpList = wrapper.getLineList();
        String regex = "=[a-d][1-4][+\\-*/][a-d][1-4]";
        for (Line line : tmpList) {
            for (String cell : line.getValues()) {
                if (!isNumeric(cell)) {

                }
            }
        }
        return null;
    }

    private static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return true;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

}
