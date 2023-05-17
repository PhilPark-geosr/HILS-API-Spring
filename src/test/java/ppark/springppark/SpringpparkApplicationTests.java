package ppark.springppark;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ppark.springppark.domain.Member;
import ppark.springppark.repository.JpaMemberRepository;

@SpringBootTest
class SpringpparkApplicationTests {
	@Autowired
	private JpaMemberRepository memberRepository;

	@Test
	void save() {
		memberRepository.save(Member.builder()
				.userId("ppark")
				.password("ppark")
				.build());
	}

	@Test
	void select() {
		Member member = memberRepository.findById(1).get();
		System.out.println("Member 테이블 조회결과" + member);
	}

	@Test
	void contextLoads() {
	}

}
