package com.blog.by.kotor.model.postCategory;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class PostCategoryId implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Column(name = "post_id")
    private Integer postId;

    @Column(name = "category_id")
    private Integer categoryId;

}
