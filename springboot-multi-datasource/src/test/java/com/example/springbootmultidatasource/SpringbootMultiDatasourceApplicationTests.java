package com.example.springbootmultidatasource;

import com.example.springbootmultidatasource.domain.User;
import com.example.springbootmultidatasource.mapper.datasource1.UserMapper;
import com.example.springbootmultidatasource.mapper.datasource2.CompanyMapper;
import com.google.common.base.Joiner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMultiDatasourceApplicationTests {

	@Test
	public void contextLoads() {
	}


	@Autowired
	private UserMapper userMapper;

	@Autowired
	private CompanyMapper companyMapper;

	@Test
	public void insert(){
		userMapper.insert("hello", ""+System.currentTimeMillis(), "1");
		userMapper.insert("hello", ""+System.currentTimeMillis(), "2");
	}


	@Test
	public void batchInsert(){

		User user1 = new User();
		user1.setName("hello");
		user1.setPassword(""+System.currentTimeMillis());
		user1.setPhone("3");

		User user2 = new User();
		user2.setName("hello");
		user2.setPassword(""+System.currentTimeMillis());
		user2.setPhone("3");

		List<User> users = new ArrayList<>();
		users.add(user1);
		users.add(user2);

		userMapper.insertBatch(users);
	}


	@Test
	public void find(){
		User user = userMapper.findUser("1");
		System.out.println(user);
	}

	@Test
	public void batchFind(){
		List<User> users = userMapper.findUsers("3");
		for (User user:users) {
			System.out.println(user);
		}
	}

	@Test
	public void findAll(){
		List<User> users = userMapper.findAll();
		for (User user:users) {
			System.out.println(user);
		}
	}

	@Test
	public void update(){
		long minid = Long.MAX_VALUE;
		List<User> users = userMapper.findAll();
		List<Long> idList = new ArrayList<>();
		for (User user:users) {
			if(minid > user.getId()){
				minid = user.getId();
			}
		}
		userMapper.update("world",minid);
	}


	@Test
	public void updateBatch(){
		List<User> users = userMapper.findAll();
		List<Long> idList = new ArrayList<>();
		for (User user:users) {
			idList.add((long)user.getId());
		}

		String ids = Joiner.on(",").join(idList);
		int updateCount = userMapper.updateBatch("t_user","name","good", ids);

		System.out.println("更新条数：" + updateCount);
	}


	@Test
	public void delete(){

		long minid = Long.MAX_VALUE;
		List<User> users = userMapper.findAll();
		List<Long> idList = new ArrayList<>();
		for (User user:users) {
			if(minid > user.getId()){
				minid = user.getId();
			}
		}

		int count = userMapper.delete(minid);
		System.out.println(count);
	}

	@Test
	public void deleteBatch(){

		List<User> users = userMapper.findAll();
		List<Long> idList = new ArrayList<>();
		for (User user:users) {
			idList.add((long)user.getId());
		}

		String ids = Joiner.on(",").join(idList);
		int count = userMapper.deleteBatch(ids);
		System.out.println(count);
	}
}
