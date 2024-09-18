package com.blog.by.kotor.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "options")
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;

    @Column(name = "option_text")
    private String optionText;

    @JsonIgnore
    @OneToMany(mappedBy = "option", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Vote> votes;

    @Override
    public String toString() {
        return "Option{" +
                "id=" + id +
                ", question=" + question +
                ", optionText='" + optionText + '\'' +
                ", votes=" + votes +
                '}';
    }

}
