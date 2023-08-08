# QuizApp_SpringBoot_Application_Monolithic
This is just a simple project of spring boot (monolithic) to create quiz according to certain requirements and also to calculate score accordingly

Dependencies used: spring Data jpa (to be free from boiler plate JDBC code)
                   spring Web ( provides a set of tools and libraries that make it easy to develop, test, and deploy web applications)
                   postgresql ( postgresql as database for maintaing the quiz and questions realated data)
                   lombok (to skip all the required boiler plate code of pojo or model)

Modules :  1 - Quiz : (this is for users or clinets side )  in this we -> create a quiz
                                                                       -> get quiz by id  
                                                                       -> submit the responses to get score.
           
           2 - Questions : (admin maintains this module for any updations) here we  -> add the questions
                                                                                    -> delete the questions
                                                                                    -> get questions by category
                                                                                    -> view all the questions  
Models or pojos used: -> QuestionWrapper for creation of quiz
                      -> Quiz for creating the quiz
                      -> quizapp as primary model for question creation
                      -> Response - user submit the responses to get the score
  
