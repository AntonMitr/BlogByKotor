package com.blog.by.kotor.repository;

import com.blog.by.kotor.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface VoteRepository extends JpaRepository<Vote, Integer> {

    List<Vote> findVotesByOptionId(Integer optionId);

    List<Vote> findVotesByUserId(Integer userId);

}
