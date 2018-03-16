package com.example.springbootmultidatasource;

import com.example.springbootmultidatasource.domain.Company;
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
public class CompanyTests {

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

		companyMapper.insert("hello", "1");
		companyMapper.insert("hello", "2");
		companyMapper.insert("hello", "3");
		companyMapper.insert("hello", "3");
	}


	@Test
	public void batchFind(){
		List<Company> companies = companyMapper.findCompanies("3");
		for (Company company:companies) {
			System.out.println(company);
		}
	}

	@Test
	public void findAll(){

		List<User> users = userMapper.findAll();
		for (User user:users) {
			System.out.println(user);
		}

		List<Company> companies = companyMapper.findAll();
		for (Company company:companies) {
			System.out.println(company);
		}
	}


	@Test
	public void deleteAll(){

		int userDeleteCount = userMapper.deleteAll();
		System.out.println("userDeleteCount:" + userDeleteCount);


		int companyDeleteCount = companyMapper.deleteAll();
		System.out.println("companyDeleteCount:" + companyDeleteCount);

	}
}
