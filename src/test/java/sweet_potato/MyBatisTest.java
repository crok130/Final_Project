package sweet_potato;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sweetpotato.member.vo.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/root-context.xml"})
public class MyBatisTest {

	@Autowired
	SqlSession sqlSession;
	
	@Before
	public void sessionTest() {
		System.out.println("session : " + sqlSession);
	}
	
	@Test
	public void insertMember() {
		MemberVO member = new MemberVO();
		member.setMemberid("id002");
		member.setMemberpass("pw002");
		member.setMembername("홍길순");
		member.setMemberbirth("1997.11.01");
		member.setMemberphone("01011111111");
		member.setMemberemail("fatherimim@naver.com");
		member.setMemberaddr("부산광역시 수영구 광남로 70");
		
		int result = sqlSession.insert("memberMapper.create", member);
		System.out.println("insert result : " + result);
	}
}
