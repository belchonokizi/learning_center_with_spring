package com.ilzirabalobanova.epam.learning_center.bean;

import com.ilzirabalobanova.epam.learning_center.annotation.InjectRandomMark;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentBean {
    private int moduleCount;

    @InjectRandomMark
    private List<Integer> marksList;

    public StudentBean(List<Integer> marksList) {
        this.marksList = marksList;
    }

    public List<Integer> getMarksList() {
        return marksList;
    }

    public void setMarksList(List<Integer> marksList) {
        this.marksList = marksList;
    }

    public int getModuleCount() {
        return moduleCount;
    }

    public void setModuleCount(int moduleCount) {
        this.moduleCount = moduleCount;
    }
}
