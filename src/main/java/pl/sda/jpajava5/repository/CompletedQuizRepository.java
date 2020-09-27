package pl.sda.jpajava5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.jpajava5.entity.CompletedQuiz;

@Repository
public interface CompletedQuizRepository extends JpaRepository<CompletedQuiz, Long> {
}
