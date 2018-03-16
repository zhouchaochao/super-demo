package com.example.springbootmultidatasource.mapper.datasource1;

import com.example.springbootmultidatasource.domain.User;
import com.example.springbootmultidatasource.sqlprovider.CommonSqlProvider;
import com.example.springbootmultidatasource.sqlprovider.UserSqlProvider;
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
public interface UserMapper {

    @Insert("INSERT INTO t_user(NAME, PASSWORD, PHONE) VALUES(#{name}, #{password}, #{phone})")
    int insert(@Param("name") String name, @Param("password") String password, @Param("phone") String phone);

    @InsertProvider(type = UserSqlProvider.class, method = "insertBatch")
    void insertBatch(List<User> list);



    @Select("SELECT * FROM t_user WHERE PHONE = #{phone}")
    User findUser(@Param("phone") String phone);

    @Select("SELECT * FROM t_user WHERE PHONE = #{phone}")
    List<User> findUsers(@Param("phone") String phone);

    @Select("SELECT * FROM t_user")
    List<User> findAll();

    @Update("update t_user set name=#{name} where id=#{id}")
    void update(@Param("name") String name, @Param("id") long id);

    @UpdateProvider(type = CommonSqlProvider.class, method = "setValueSql")
    int updateBatch(@Param("table") String table, @Param("column") String column, @Param("value") String value, @Param("ids") String ids);



    @Delete("delete from t_user where id=#{id}")
    int delete(@Param("id") long id);

    @DeleteProvider(type = UserSqlProvider.class, method = "deleteBatch")
    int deleteBatch(@Param("ids") String ids);

    @Delete("delete from t_user")
    int deleteAll();
}
