package com.harry.quizApp.controller;

import com.harry.quizApp.model.QuestionWrapper;
import com.harry.quizApp.model.Reponse;
import com.harry.quizApp.model.quizapp;
import com.harry.quizApp.service.quizService;
import jakarta.persistence.criteria.CriteriaBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class quizCOntroller {

    @Autowired
    quizService qs;
    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category,@RequestParam int noQ,@RequestParam String title){
        return qs.createQuiz(category,noQ,title);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id){
        return  qs.getQuizQuestions(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Reponse> responses){
        return  qs.calculateResult(id,responses);

    }

}
