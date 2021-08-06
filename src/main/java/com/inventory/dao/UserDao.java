package com.inventory.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.inventory.config.DataSourceConfig;
import com.inventory.dto.ProductDto;
import com.inventory.dto.UserDto;
import com.inventory.mapper.ProductRowMapper;
import com.inventory.mapper.UserRowMapper;

@Repository
public class UserDao implements AppDao<UserDto> {

	@Autowired
	private DataSourceConfig dataSource;

	@Override
	public Integer create(UserDto t) throws Exception {
		String sql = "insert into app_user(firstname,lastname,username,phone,password,isAdmin,userRole) values(?,?,?,?,?,?,?)";
		int row = dataSource.getJdbcTemplate().update(sql, new Object[] { t.getFirstName(), t.getLasttName(),
				t.getUsername(), t.getPhone(), t.getPassword(), t.getIsAdmin(), t.getUserRoleId() });
		return row;
	}

	@Override
	public Integer update(UserDto t, int id) throws Exception {
		String sql = "update app_user set firstname=?,lastname=?,username=?,phone=?,password=?,isAdmin=?,userRole=?  where userId=?";
		return dataSource.getJdbcTemplate().update(sql, new Object[] { t.getFirstName(), t.getLasttName(),
				t.getUsername(), t.getPhone(), t.getPassword(), t.getIsAdmin(), t.getUserRoleId(), id });
	}

	@Override
	public UserDto getById(int id) throws Exception {
		String sql = "Select firstname,lastname,username,phone,isAdmin,userRole from app_user where userId=?";
		return (UserDto) dataSource.getJdbcTemplate().queryForObject(sql, new Object[] { id }, new UserRowMapper());
	}

	@Override
	public List<UserDto> getAll() throws Exception {
		String sql = "Select firstname,lastname,username,phone,isAdmin,userRole from app_user";
		return dataSource.getJdbcTemplate().query(sql, new UserRowMapper());
	}

	@Override
	public void addAll(List<UserDto> t) throws Exception {
		// TODO Auto-generated method stub

	}

	/**
	 * support method for spring security use by authentication manager
	 * 
	 * @param username
	 * @return
	 * @throws Exception
	 */
	public UserDto findByUsername(String username) throws Exception {
		String sql = "select * from app_user where username=?";
		return (UserDto) dataSource.getJdbcTemplate().queryForObject(sql, new Object[] { username },
				new RowMapper<UserDto>() {
					@Override
					public UserDto mapRow(ResultSet rs, int rowNum) throws SQLException {
						UserDto uDto = new UserDto();
						uDto.setUsername(rs.getString("username"));
						uDto.setPassword(rs.getString("password"));
						return uDto;
					}
				});
	}

}
