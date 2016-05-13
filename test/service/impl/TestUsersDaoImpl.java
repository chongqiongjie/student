package service.impl;

import junit.framework.Assert;

import org.junit.Test;

import service.UsersDao;
import entity.Users;

public class TestUsersDaoImpl {
	@Test
	public void testUsersLogin(){
		Users u = new Users(1,"zhangsan","123456");
		UsersDao udao = new UsersDaoImpl();
		Assert.assertEquals(true, udao.usersLogin(u));
	}
}
