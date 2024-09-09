package com.blog.by.kotor.PostCategory;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@Scope("prototype")
@Entity
@Table(name = "posts_categories")
public class PostCategory {

    @EmbeddedId
    private PostCategoryId id;

    public PostCategoryId getId() {
        return id;
    }

    public void setId(PostCategoryId id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostCategory that = (PostCategory) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "PostCategory{" +
                "id=" + id +
                '}';
    }

}
