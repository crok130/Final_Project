package sweet_potato;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/resources/spring/root-context.xml"})
public class mybatisTest {

    @Inject
    private SqlSessionFactory sqlFactory;

    @Test
    public void testFactory() throws Exception {
        System.out.println("Mybatis 연결 ----- " + sqlFactory);
        if (sqlFactory != null) {
            System.out.println("SqlSessionFactory가 성공적으로 초기화되었습니다.");
        } else {
            System.out.println("SqlSessionFactory 초기화에 실패했습니다.");
        }
    }

    @Test
    public void testSession() throws Exception {
        try (SqlSession sqlSession = sqlFactory.openSession()) {
            System.out.println("MyBatis 세션이 성공적으로 열렸습니다: " + sqlSession);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
