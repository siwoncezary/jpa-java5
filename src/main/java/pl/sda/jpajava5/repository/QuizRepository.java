package pl.sda.jpajava5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.jpajava5.entity.Quiz;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {
}
