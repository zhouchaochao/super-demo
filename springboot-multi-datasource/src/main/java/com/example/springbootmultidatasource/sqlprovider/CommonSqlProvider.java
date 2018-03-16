package com.example.springbootmultidatasource.sqlprovider;

import java.util.Map;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

/**
 * Title:
 * Description:
 * Date:  2018/3/17
 *
 * @author <a href=mailto:zhouzhichao1024@gmail.com>chaochao</a>
 */

public class CommonSqlProvider {

    /**
     * 需要参数： @Param("table") String table,
     *          @Param("column") String column,
     *          @Param("value") String value,
     *          @Param("ids") String ids  数值以逗号相连
     * 生成sql： update table set column_name = value WHERE id in ();
     * @param paramsMap
     * @return
     */
    public String setValueSql(Map<String, String> paramsMap) {
        String table = paramsMap.get("table");
        String column = paramsMap.get("column");
        String value = paramsMap.get("value");
        String ids = paramsMap.get("ids");

        BEGIN();
        UPDATE(table);
        SET(column + " = \"" + value + "\"");
        WHERE("id in (" + ids + ")");
        String sql = SQL().replaceAll("\n|\r", " ").toString();
        return sql;
    }
}
