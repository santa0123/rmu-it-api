package com.it.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.it.dto.AuthenDTO;

@Repository
public class AuthenticationDao {

	public final JdbcTemplate defaultJdbcTemplate;

	protected AuthenticationDao(JdbcTemplate defaultJdbcTemplate) {
		this.defaultJdbcTemplate = defaultJdbcTemplate;
	}

	public AuthenDTO authen(String userName, String password) {

		StringBuilder sql = new StringBuilder();

		List<Object> param = new ArrayList<>();

		sql.append("select user.id , user.username, user.record_status , r.id as role_id ,r.role_name from tb_user user ");
		sql.append("inner join tb_role r on r.id = user.role_id ");
		sql.append("where user.username = ? ");
		sql.append("and user.password = ? ");

		param.add(userName);
		param.add(password);

		Object[] paramArr = param.toArray();

		List<AuthenDTO> result = defaultJdbcTemplate.query(sql.toString(), paramArr, rowMapperUserDTO);

		if (!result.isEmpty()) {
			return result.get(0);
		}

		return null;
	}

	private final RowMapper<AuthenDTO> rowMapperUserDTO = new RowMapper<AuthenDTO>() {

		@Override
		public AuthenDTO mapRow(ResultSet rs, int row) throws SQLException {
			AuthenDTO dto = new AuthenDTO();
			dto.setUserId(rs.getInt("user_id"));
			dto.setUsername(rs.getString("username"));
			dto.setRoleId(rs.getString("role_id"));
			dto.setRoleName(rs.getString("role_name"));
			dto.setRecordStatus(rs.getString("record_status"));
			return dto;
		}
	};
}
