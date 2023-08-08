package com.harry.quizApp.Dao;


import com.harry.quizApp.model.quizapp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface questionDao extends JpaRepository<quizapp,Integer> {
    List<quizapp> findByCategory(String cat);

    @Query(value = "select * from quizapp q where q.category=:category order by random() LIMIT :noQ",nativeQuery = true)
    List<quizapp> findRandomQuestionsByCategory(String category, int noQ);
}
