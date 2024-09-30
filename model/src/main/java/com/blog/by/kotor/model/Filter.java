package com.blog.by.kotor.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "filters")
public class Filter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "criteria")
    private String criteria;

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
        Filter filter = (Filter) o;
        return Objects.equals(id, filter.id) && Objects.equals(name, filter.name) && Objects.equals(criteria, filter.criteria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, criteria);
    }

}

