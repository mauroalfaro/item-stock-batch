package com.alfarosoft.itemstockbatch.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "MerchandiseHierarchy")
public class MerchandiseHierarchy {

    @JsonProperty("division")
    @Column(name = "division")
    private String division;

    @JsonProperty("group")
    @Column(name = "group")
    private String group;

    @JsonProperty("department")
    @Column(name = "department")
    private String department;

    @JsonProperty("class")
    @Column(name = "class")
    private String merchandiseClass;

    @JsonProperty("category")
    @Column(name = "category")
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
