package com.blog.by.kotor;

import java.util.Objects;

public class Filter {

    private int id;
    private String name;
    private String criteria;

    public Filter(int id, String name, String criteria) {
        this.id = id;
        this.name = name;
        this.criteria = criteria;
    }

    public Filter() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCriteria() {
        return criteria;
    }

    public void setCriteria(String criteria) {
        this.criteria = criteria;
    }

    @Override
    public String toString() {
        return "Filter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", criteria='" + criteria + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Filter filters = (Filter) o;
        return id == filters.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

