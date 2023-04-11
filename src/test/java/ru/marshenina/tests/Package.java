package ru.marshenina.tests;

import java.util.List;
import java.util.Map;

public class Package {
    private String packageName;
    private String activeDate;
    private Integer period;
    private Integer packageId;
    private boolean haveActivePackage;
    private List<Integer> options;
    private Map<String, Object> user;

    public String getPackageName() {
        return packageName;
    }

    public String getActiveDate() {
        return activeDate;
    }

    public Integer getPeriod() {
        return period;
    }

    public Integer getPackageId() {
        return packageId;
    }

    public boolean isHaveActivePackage() {
        return haveActivePackage;
    }

    public List<Integer> getOptions() {
        return options;
    }

    public Map<String, Object> getUser() {
        return user;
    }

}
