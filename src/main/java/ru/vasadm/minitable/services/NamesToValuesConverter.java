package ru.vasadm.minitable.services;

import java.util.*;

public class NamesToValuesConverter {
    public static String getValues(Wrapper wrapper, String formula) {
        String result = formula;
        List<String> subStings = Arrays.asList(formula.substring(1).split("[+\\-*/()]"));
        subStings = subStings.stream().filter(s -> !(Objects.equals(s, ""))).toList();
        Map<String, String> changeMap = new HashMap<>();
        subStings.forEach(s -> changeMap.put(s, wrapper.getCellValue(s)));
        changeMap.forEach((k,v) -> System.out.println(k + " - " + v));
        for (Map.Entry<String, String> entry : changeMap.entrySet()) {
            result = result.replaceAll(entry.getKey(), entry.getValue());
        }

        return result;
    }
}
