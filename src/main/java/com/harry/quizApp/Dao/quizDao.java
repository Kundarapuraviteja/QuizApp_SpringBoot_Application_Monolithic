package com.harry.quizApp.Dao;

import com.harry.quizApp.model.Quiz;
import com.harry.quizApp.model.quizapp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface quizDao extends JpaRepository<Quiz,Integer> {

}
