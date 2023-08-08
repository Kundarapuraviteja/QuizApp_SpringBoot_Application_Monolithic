package com.harry.quizApp.service;

import com.harry.quizApp.Dao.questionDao;
import com.harry.quizApp.model.quizapp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class questionService {
    @Autowired
    questionDao qd;

    public ResponseEntity<List<quizapp>> getAllQuestions() {
        try {
            return new ResponseEntity<>(qd.findAll(), HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<List<quizapp>> getQuestionByCat(String cat) {
        try {
            return new ResponseEntity<>(qd.findByCategory(cat),HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addQuestion(quizapp quiz) {
        qd.save(quiz);
        return new ResponseEntity<>("success",HttpStatus.CREATED);
    }

    public void deleteQuestion(int id) {
        qd.deleteById(id);
    }
}
