package com.blog.by.kotor.model.postTag;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class PostTagId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "post_id")
    private Integer postId;

    @Column(name = "tag_id")
    private Integer tagId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostTagId postTagId = (PostTagId) o;
        return Objects.equals(postId, postTagId.postId) && Objects.equals(tagId, postTagId.tagId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postId, tagId);
    }

}
