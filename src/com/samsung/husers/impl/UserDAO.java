package com.samsung.husers.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.samsung.assignment.utils.JDBCUtils;
import com.samsung.husers.vo.UserVO;

public class UserDAO {
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	// 새로운 회원 가입
	public boolean insertUser(UserVO vo){
		try {
			conn = JDBCUtils.getConnection();

			String sql = "insert into husers values((select nvl(max(seq), 0)+1 from husers), ?, ?, ?, ?, ?)";
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, vo.getName());
			stmt.setString(2, vo.getPassword());
			stmt.setString(3, vo.getEmail());
			stmt.setInt(4, vo.getAge());
			stmt.setInt(5, vo.getGender());
			
			int result = stmt.executeUpdate();
			if(result==0){
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(conn, stmt);
		}
		return true;
	}
	
	// 전체 회원 리스트 출력
	public ArrayList<UserVO> selectUserList(){
		ArrayList<UserVO> list = new ArrayList<UserVO>();
		try{
			conn = JDBCUtils.getConnection();
			String sql = "select * from husers order by seq desc";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				UserVO vo = new UserVO();
				vo.setSeq(rs.getInt("seq"));
				vo.setName(rs.getString("name"));
				vo.setPassword(rs.getString("password"));
				vo.setEmail(rs.getString("email"));
				vo.setAge(rs.getInt("age"));
				System.out.println(rs.getInt("age"));
				vo.setGender(rs.getInt("gender"));
				System.out.println(rs.getInt("gender"));
				list.add(vo);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JDBCUtils.close(conn, stmt, rs);
		}
		return list;
	}
}
