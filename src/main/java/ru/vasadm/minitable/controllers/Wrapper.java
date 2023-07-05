package ru.vasadm.minitable.controllers;

import lombok.Getter;
import lombok.Setter;
import ru.vasadm.minitable.Line;

import java.util.List;

@Getter
@Setter
public class Wrapper {
    private List<Line> lineList;
}
