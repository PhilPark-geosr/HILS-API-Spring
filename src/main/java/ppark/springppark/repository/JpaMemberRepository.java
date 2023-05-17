package ppark.springppark.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ppark.springppark.domain.Member;

@Repository
public class JpaMemberRepository {
    @PersistenceContext // 자동으로 스프링에서 EntitiyManager를 주입해준다
    private EntityManager em;

    public Long save(Member member) {
        em.persist(member);
        return member.getId();
    }
    public Member find(Long id) {
        return em.find(Member.class, id);

    }
}
