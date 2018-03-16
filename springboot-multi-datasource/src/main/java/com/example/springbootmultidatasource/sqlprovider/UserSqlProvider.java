package com.example.springbootmultidatasource.sqlprovider;

import com.example.springbootmultidatasource.domain.User;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

import static org.apache.ibatis.jdbc.SqlBuilder.*;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;

/**
 * Title:
 * Description: 辅助生成操作User的mapper的SQL
 * Date:  2018/3/17
 *
 * @author <a href=mailto:zhouzhichao1024@gmail.com>chaochao</a>
 */

public class UserSqlProvider {


    public String insertBatch(Map<String, List<User>> map) {
        List<User> list = map.get("list");
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO t_user(name, password, phone)");
        sb.append(" values ");
        MessageFormat mf = new MessageFormat(
                " (#'{'list[{0}].name},#'{'list[{0}].password},#'{'list[{0}].phone} )");
        for (int i = 0; i < list.size(); i++) {
            sb.append(mf.format(new Object[] { i }));
            if (i < list.size() - 1) {
                sb.append(",");
            }
        }

        return sb.toString();
    }


    /**
     * @param paramsMap
     * @return
     */
    public String deleteBatch(Map<String, String> paramsMap) {
        String ids = paramsMap.get("ids");
        BEGIN();
        DELETE_FROM("t_user");
        WHERE("id in (" + ids + ")");
        String sql = SQL().replaceAll("\n|\r", " ").toString();
        return sql;
    }

}
