package com.harry.quizApp.service;

import com.harry.quizApp.Dao.questionDao;
import com.harry.quizApp.Dao.quizDao;
import com.harry.quizApp.model.QuestionWrapper;
import com.harry.quizApp.model.Quiz;
import com.harry.quizApp.model.Reponse;
import com.harry.quizApp.model.quizapp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class quizService {
    @Autowired
    quizDao dao;

    @Autowired
    questionDao qdao;

    public ResponseEntity<String> createQuiz(String category, int noQ, String title) {
        List<quizapp> ques=qdao.findRandomQuestionsByCategory(category,noQ);
        Quiz q=new Quiz();
        q.setTitle(title);
        q.setQuizapp(ques);
        dao.save(q);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }


    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
   Optional<Quiz> quiz= dao.findById(id);
   List<quizapp> question=quiz.get().getQuizapp();
   List<QuestionWrapper> questforuser=new ArrayList<>();
   for(quizapp q:question){
       QuestionWrapper qr=new QuestionWrapper(q.getId(),q.getQuestion(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
       questforuser.add(qr);
   }

   return  new ResponseEntity<>(questforuser,HttpStatus.OK);

    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Reponse> responses) {
        Quiz q=dao.findById(id).get();
        List<quizapp> questions=q.getQuizapp();
        int i=0,right=0;
        for(Reponse r:responses){
            if(r.getResponse().equals(questions.get(i).getRightans()))
                right++;
        i++;
        }
        return new ResponseEntity<>(right,HttpStatus.OK);

    }
}
