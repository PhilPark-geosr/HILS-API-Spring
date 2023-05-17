package ppark.springppark.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ppark.springppark.domain.Member;

public interface JpaMemberRepository extends JpaRepository<Member, Integer> {
}
