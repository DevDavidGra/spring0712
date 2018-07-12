package part01test;

import java.sql.SQLException;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainMethod {

	public static void main(String[] args) {
		ApplicationContext con = new ClassPathXmlApplicationContext("part01test/test.xml");
		ConnDAO dao = (ConnDAO)con.getBean("conn");
		
		try {
			for(Map<String, String> i : dao.select()) {
				System.out.println(i.get("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

	}

}
