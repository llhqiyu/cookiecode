package dao;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import junit.framework.Assert;
import model.User;

class UserDaoTest {
	
	UserDao udt = new UserDao();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testAddUser() throws SQLException {
		User ud = new User(0,"qiqi","qiqi@vilicode.com","123","管理员","123456","中华人民共和国",false,false);
		try {
			udt.addUser(ud);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("qiqi", ud.getUsername());
	}
	

	@Test
	void testDelete() {
		User ud = new User(0,"wuwu","wuwu@vilicode.com","3321","管理员","123789","中华人民共和国",false,false);
		try {
			udt.addUser(ud);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int id = ud.getId();
		try {
			udt.delete(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			assertNull(udt.selectById(id));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
}
