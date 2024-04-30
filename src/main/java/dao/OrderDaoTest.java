package dao;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Order;

class OrderDaoTest {
	
	OrderDao ord = new OrderDao();

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
	void testInsertOrder() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateStatus() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteOrder() {
		fail("Not yet implemented");
	}

	

}
