package com.blog.by.kotor.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonIgnore
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "poll_id")
    private Poll poll;

    @Column(name = "question_text")
    private String questionText;

    @JsonIgnore
    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Option> options;


    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", poll=" + poll +
                ", questionText='" + questionText + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return Objects.equals(id, question.id) && Objects.equals(poll, question.poll) && Objects.equals(questionText, question.questionText) && Objects.equals(options, question.options);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, poll, questionText, options);
    }

}
