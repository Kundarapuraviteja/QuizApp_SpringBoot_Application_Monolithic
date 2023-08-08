package com.harry.quizApp.controller;

import com.harry.quizApp.model.quizapp;
import com.harry.quizApp.service.questionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    questionService qs;

    @GetMapping("/allquestions")
    public ResponseEntity<List<quizapp>> getAllQuestions(){
        return qs.getAllQuestions();

    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<quizapp>> getQuestionByCat(@PathVariable String category){
        return qs.getQuestionByCat(category);
    }

    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody quizapp quiz){
       return qs.addQuestion(quiz);

    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable int id){
        qs.deleteQuestion(id);
        return ResponseEntity.noContent().build();
    }
}
