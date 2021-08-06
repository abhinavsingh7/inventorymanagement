package com.inventory.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.inventory.dto.UserDto;

public class UserRowMapper implements RowMapper<UserDto> {

	@Override
	public UserDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserDto udto = new UserDto();
		udto.setUserId(rs.getInt("userId"));
		udto.setFirstName(rs.getString("firstname"));
		udto.setLasttName(rs.getString("lastname"));
		udto.setUsername(rs.getString("username"));
		udto.setPhone(rs.getString("phone"));
		udto.setIsAdmin(rs.getString("isAdmin"));
		udto.setUserRoleId(rs.getInt("userRole"));
		return udto;
	}

}
