package com.alfarosoft.itemstockbatch.model.composites;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class MerchandiseHierarchyComposite {
    private String division;
    private String group;
    private String department;
    private String merchandiseClass;
    private String category;
    private LocalDate dateImported;

    public MerchandiseHierarchyComposite(String division, String group, String department, String merchandiseClass, String category, LocalDate dateImported) {
        this.division = division;
        this.group = group;
        this.department = department;
        this.merchandiseClass = merchandiseClass;
        this.category = category;
        this.dateImported = dateImported;
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

    public LocalDate getDateImported() {
        return dateImported;
    }

    public void setDateImported(LocalDate dateImported) {
        this.dateImported = dateImported;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MerchandiseHierarchyComposite that = (MerchandiseHierarchyComposite) o;
        return Objects.equals(division, that.division) &&
                Objects.equals(group, that.group) &&
                Objects.equals(department, that.department) &&
                Objects.equals(merchandiseClass, that.merchandiseClass) &&
                Objects.equals(category, that.category) &&
                Objects.equals(dateImported, that.dateImported);
    }

    @Override
    public int hashCode() {
        return Objects.hash(division, group, department, merchandiseClass, category, dateImported);
    }

    @Override
    public String toString() {
        return "MerchandiseHierarchyComposite{" +
                "division='" + division + '\'' +
                ", group='" + group + '\'' +
                ", department='" + department + '\'' +
                ", merchandiseClass='" + merchandiseClass + '\'' +
                ", category='" + category + '\'' +
                ", dateImported=" + dateImported +
                '}';
    }
}
