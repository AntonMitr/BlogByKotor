package com.blog.by.kotor.repository;

import com.blog.by.kotor.model.Poll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PollRepository extends JpaRepository<Poll, Integer> {

    List<Poll> findByTitle(String title);

    List<Poll> findByUserId(Integer userId);

}
