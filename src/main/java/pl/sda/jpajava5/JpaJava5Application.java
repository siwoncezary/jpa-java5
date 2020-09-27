package pl.sda.jpajava5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.sda.jpajava5.entity.*;
import pl.sda.jpajava5.repository.AnswerRepository;
import pl.sda.jpajava5.repository.CompletedQuizRepository;
import pl.sda.jpajava5.repository.QuestionRepository;
import pl.sda.jpajava5.repository.QuizRepository;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class JpaJava5Application implements CommandLineRunner {
    final QuestionRepository questionRepository;
    final QuizRepository quizRepository;
    final AnswerRepository answerRepository;
    final CompletedQuizRepository completedQuizRepository;
    @Autowired
    public JpaJava5Application(QuestionRepository questionRepository, QuizRepository quizRepository, AnswerRepository answerRepository, CompletedQuizRepository completedQuizRepository) {
        this.questionRepository = questionRepository;
        this.quizRepository = quizRepository;
        this.answerRepository = answerRepository;
        this.completedQuizRepository = completedQuizRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(JpaJava5Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Question question = Question.builder()
                .body("Pytanie testowe")
                .points(10)
                .options(
                        Option.builder()
                                .option1("Red")
                                .option2("White")
                                .option3("Blue")
                                .option4("Yellow")
                                .build()
                )
                .validOption(1).build();
        question = questionRepository.save(question);
        Set<Question> questions = new HashSet<>();
        questions.add(question);
        Quiz quiz = Quiz.builder().title("Kolor").questions(questions).build();
        quiz = quizRepository.save(quiz);
        Answer answer = Answer.builder().optionNumber(2).question(question).build();
        answer = answerRepository.save(answer);
        Set<Answer> answers = new HashSet<>();
        answers.add(answer);
        CompletedQuiz completedQuiz = CompletedQuiz.builder()
                .quiz(quiz)
                .answers(answers)
                .build();
        completedQuizRepository.save(completedQuiz);
    }
}
