package com.alfarosoft.itemstockbatch.model;

import java.util.Objects;

public class MerchandiseHierarchy {
    private String division;
    private String group;
    private String department;
    private String merchandiseClass;
    private String category;

    public MerchandiseHierarchy(String division, String group, String department, String merchandiseClass, String category) {
        this.division = division;
        this.group = group;
        this.department = department;
        this.merchandiseClass = merchandiseClass;
        this.category = category;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getMerchandiseClass() {
        return merchandiseClass;
    }

    public void setMerchandiseClass(String merchandiseClass) {
        this.merchandiseClass = merchandiseClass;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MerchandiseHierarchy that = (MerchandiseHierarchy) o;
        return Objects.equals(division, that.division) &&
                Objects.equals(group, that.group) &&
                Objects.equals(department, that.department) &&
                Objects.equals(merchandiseClass, that.merchandiseClass) &&
                Objects.equals(category, that.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(division, group, department, merchandiseClass, category);
    }

    @Override
    public String toString() {
        return "MerchandiseHierarchy{" +
                "division='" + division + '\'' +
                ", group='" + group + '\'' +
                ", department='" + department + '\'' +
                ", merchandiseClass='" + merchandiseClass + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
