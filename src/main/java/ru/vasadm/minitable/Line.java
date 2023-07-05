package ru.vasadm.minitable;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Line {
    private int id;
    List<String> values;
}
