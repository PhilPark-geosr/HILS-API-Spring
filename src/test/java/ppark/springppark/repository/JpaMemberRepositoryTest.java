package ppark.springppark.repository;

import static org.junit.jupiter.api.Assertions.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import ppark.springppark.domain.Member;

@SpringBootTest
class JpaMemberRepositoryTest {
    @Autowired //먼저 injection 받고 시작하자!!
    JpaMemberRepository memberRepository;

    @Test
    @Transactional // Entitiy Manager를 통한 모든 data변경은 transaction 안에서 이루어져야 한다!
    @Rollback(false) //원래 테스트 코드에서는 transactional 안에 있으면 롤백해서 데이터를 다시 다 지워주는데, false로 옵션 주면 안지운다!
    public void testMember() throws Exception {
        //given
        Member member = new Member();
        member.setUserId("memberA");
        member.setPassword("memberA");

        //when
        Long saveId = memberRepository.save(member); //저장해서 받은 아이디를
        Member findMember = memberRepository.find(saveId); // 찾아본다
        //then
        // 내가 저장한 아이디가 찾은 아이디랑 일치하는지
        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
        Assertions.assertThat(findMember.getUserId()).isEqualTo(member.getUserId());

        // 기본편에 상세 이유 있음!
        Assertions.assertThat(findMember).isEqualTo(member); //저장이랑 조회가 같니?
//        System.out.println("findMember == member" + (findMember == member));
        // 같은 이유 : 같은 transaction 안에서 같은 영속성 컨텍스트 안에서는 id값이 같으면 같은 Entity로 인식한다!

    }

}