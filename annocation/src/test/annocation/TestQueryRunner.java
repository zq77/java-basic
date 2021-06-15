package annocation;

import java.util.UUID;

import org.junit.Test;

import com.z.model.User;
import com.z.utils.C3p0Utils;
import com.z.utils.QueryRunner;

/**
 * 除了需要c3p0的包和QueryRunner包外，还要com.springsource.javax.persistence-1.0.0.jar
 * 调用我们自己封装的QueryRunner
 * @author z
 *
 */
public class TestQueryRunner {

	@Test
	public void testSave() throws Exception {
		User u = new User();
		u.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		u.setName("qid");
		u.setPassword("sdw22");
		
		QueryRunner run = new QueryRunner(C3p0Utils.getDataSource());
		run.save(u);
	}

}
