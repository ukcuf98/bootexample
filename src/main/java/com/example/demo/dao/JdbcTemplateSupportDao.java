package com.example.demo.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

/**
 * <p>Title: </p>
 * <p>
 * <p>Description:com.example.demo.dao</p>
 * <p>
 * <p>
 * @author lucifer
 * @version 1.0
 * @date 2018/7/20 16:11
 */
public class JdbcTemplateSupportDao extends JdbcDaoSupport {
//public class JdbcTemplateSupportDao {

	/** 写操作jdbc模板 */
	private JdbcTemplate write_jdbcTemplate;
	/** 读操作jdbc模板 */
	private JdbcTemplate read_jdbcTemplate;

	public JdbcTemplateSupportDao(JdbcTemplate writeJdbcTemplate){
		this.write_jdbcTemplate = writeJdbcTemplate;
		this.read_jdbcTemplate = writeJdbcTemplate;
	}
	public JdbcTemplateSupportDao(JdbcTemplate writeJdbcTemplate, JdbcTemplate readJdbcTemplate){
		this.write_jdbcTemplate = writeJdbcTemplate;
		this.read_jdbcTemplate = readJdbcTemplate;
	}

	/**
	 * spring提供JdbcDaoSupport工具
	 * Object... args：args是个数组，此参数可传也可不传
	 */
	public int update(String sql){
		return this.write_jdbcTemplate.update(sql);
	}

	/**
	 * eg: update t_sys_user set name = ?, age = ? where id = ?
	 * new Object[]{param1,param2}
	 * @param sql
	 * @param args
	 */
	public int update(String sql, Object... args){
		return this.write_jdbcTemplate.update(sql, args);
	}

	/**
	 * @param sql
	 * @param args
	 * @param argTypes 指定args参数的类型，例如： Types.DATE, Types.VARCHAR
	 */
	public int update(String sql, Object[] args, int[] argTypes){
		return this.write_jdbcTemplate.update(sql, args, argTypes);
	}

	/**
	 * 批量处理
	 * @param sql
	 */
	public int[] batchUpdate(String sql){
		return this.write_jdbcTemplate.batchUpdate(sql);
	}

	/**
	 * 批量更新
	 * @param sql
	 * @param batchArgs
	 */
	public int[] batchUpdate(String sql, List<Object[]> batchArgs){
		return this.write_jdbcTemplate.batchUpdate(sql, batchArgs);
	}

	/**
	 * 批量更新
	 * @param sql
	 * @param batchArgs	更新字段参数
	 * @param argTypes	指定batchArgs参数的类型，例如： Types.DATE, Types.VARCHAR
	 */
	public int[] batchUpdate(String sql, List<Object[]> batchArgs, int[] argTypes){
		return this.write_jdbcTemplate.batchUpdate(sql, batchArgs, argTypes);
	}

	/**
	 * 返回list集合,list内为vo对象
	 * @param sql
	 * @param elementType
	 * @param <T>
	 * @return
	 */
	public <T> List<T> queryForVoList(String sql, Class<T> elementType){
		return this.read_jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(elementType));
	}

	public <T> List<T> queryForVoList(String sql, Object[] args, Class<T> elementType){
		return (List<T>) this.read_jdbcTemplate.query(sql,args,new BeanPropertyRowMapper<>(elementType));
	}

	public <T> List<T> queryForVoList(String sql, Class<T> elementType, Object... args){
		return this.read_jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(elementType), args);
	}

	public <T> List<T> queryForVoList(String sql, Object[] args, int[] argTypes, Class<T> elementType){
		return this.read_jdbcTemplate.query(sql, args, argTypes, new BeanPropertyRowMapper<>(elementType));
	}

	/**
	 * 返回list集合,ist里存放的是map集合
	 * @param sql
	 * @return
	 */
	public List<Map<String, Object>> queryForList(String sql){
		return this.read_jdbcTemplate.queryForList(sql);
	}

	public List<Map<String, Object>> queryForList(String sql, Object... args){
		return this.read_jdbcTemplate.queryForList(sql, args);
	}

	public List<Map<String, Object>> queryForList(String sql, Object[] args, int[] argTypes){
		return this.read_jdbcTemplate.queryForList(sql, args, argTypes);
	}

	/**
	 * 返回单个map
	 * @param sql
	 * @return
	 */
	public Map<String, Object> queryforMap(String sql){
		return this.read_jdbcTemplate.queryForMap(sql);
	}

	public Map<String, Object> queryForMap(String sql, Object... args){
		return this.read_jdbcTemplate.queryForMap(sql, args);
	}

	public Map<String, Object> queryMap(String sql, Object[] args, int[] argTypes){
		return this.read_jdbcTemplate.queryForMap(sql, args, argTypes);
	}

	/**
	 * 返回基本数据类型，如：String、Integer、Long
	 * @param sql
	 * @param requiredType
	 * @param <T>
	 * @return
	 */
	public <T> T queryForObject(String sql, Class<T> requiredType){
		return this.read_jdbcTemplate.queryForObject(sql, requiredType);
	}

	public <T> T queryForObject(String sql, Class<T> requiredType, Object... args){
		return this.read_jdbcTemplate.queryForObject(sql, requiredType, args);
	}

	public <T> T queryForObject(String sql, Object[] args, Class<T> requiredType){
		return this.read_jdbcTemplate.queryForObject(sql, args, requiredType);
	}

	public <T> T queryForObject(String sql, Object[] args, int[] argTypes, Class<T> requiredType){
		return this.read_jdbcTemplate.queryForObject(sql, args, argTypes, requiredType);
	}

	/**
	 * 返回vo
	 * @param sql
	 * @param requiredType
	 * @param args
	 * @param <T>
	 * @return
	 */
	public <T> T queryForVo(String sql, Class<T> requiredType, Object[] args){
		return this.read_jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(requiredType), args);
	}

//	//返回实体对象,不是map集合
//	//select * from t_sys_user where loginname = ''
//	//RowMapper的实现类是：new BeanPropertyRowMapper<User>(User.class)
//	public <T> T queryForObject(String sql, RowMapper<T> rowMapper){
//		return this.read_jdbcTemplate.queryForObject(sql, rowMapper);
//	}
//
//	public <T> T queryForObject(String sql, Object[] args, RowMapper<T> rowMapper){
//		return this.read_jdbcTemplate.queryForObject(sql, args, rowMapper);
//	}
//
//	public <T> T queryForObject(String sql, RowMapper<T> rowMapper, Object... args){
//		return this.read_jdbcTemplate.queryForObject(sql, rowMapper, args);
//	}
//
//	//select * from t_sys_user where loginname = ?
//	//argTypes：指定args参数的类型，例如： Types.DATE, Types.VARCHAR
//	public <T> T queryForObject(String sql, Object[] args, int[] argTypes, RowMapper<T> rowMapper){
//		return this.read_jdbcTemplate.queryForObject(sql, args, argTypes, rowMapper);
//	}

	//创建一个Statement对象来将SQL语句发送到数据库
	//创建一个PreparedStatement对象来将参数化的 SQL 语句发送到数据库
	public Connection openConnection(){
		Connection connection = super.getConnection();
		return connection;
	}
}
