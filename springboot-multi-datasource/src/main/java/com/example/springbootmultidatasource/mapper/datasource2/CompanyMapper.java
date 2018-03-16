package com.example.springbootmultidatasource.mapper.datasource2;


import com.example.springbootmultidatasource.domain.Company;
import com.example.springbootmultidatasource.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Title:
 * Description:
 * Date:  2018/3/17
 *
 * @author <a href=mailto:zhouzhichao1024@gmail.com>chaochao</a>
 */

@Mapper
public interface CompanyMapper {

    @Insert("INSERT INTO t_company(NAME, PHONE) VALUES(#{name}, #{phone})")
    int insert(@Param("name") String name, @Param("phone") String phone);

    @Select("SELECT * FROM t_company WHERE PHONE = #{phone}")
    Company findByPhone(@Param("phone") String phone);

    @Select("SELECT * FROM t_company WHERE PHONE = #{phone}")
    List<Company> findCompanies(@Param("phone") String phone);

    @Select("SELECT * FROM t_company")
    List<Company> findAll();

    @Delete("delete from t_company")
    int deleteAll();
}
