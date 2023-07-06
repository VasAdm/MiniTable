package ru.vasadm.minitable.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.vasadm.minitable.Line;
import ru.vasadm.minitable.services.Calculator;
import ru.vasadm.minitable.services.NamesToValuesConverter;
import ru.vasadm.minitable.services.Wrapper;

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
        operations(wrapper);
        MainPageController.wrapper = wrapper;
        return "index";
    }

    private void operations(Wrapper wrapper) {
        wrapper.getLineList().forEach(line -> {
            for (int i = 0; i < line.getValues().size(); i++) {
                String tmp = line.getValues().get(i);
                if (tmp.startsWith("=")) {
                    tmp = NamesToValuesConverter.getValues(wrapper, tmp);
                    line.getValues().set(i, String.valueOf(Calculator.evaluate(tmp)));
                }
            }
        });
    }
}
