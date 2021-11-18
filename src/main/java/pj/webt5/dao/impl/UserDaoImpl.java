package pj.webt5.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import pj.webt5.connection.DBConnection;
import pj.webt5.dao.UserDao;
import pj.webt5.model.UserModel;

public class UserDaoImpl extends DBConnection implements UserDao{
	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;
	@Override
	public void insert(UserModel user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserModel getbyid(int id) {
		String sql = "SELECT * FROM cmsnhom5.member;";

		try {
			new DBConnection();
			conn = DBConnection.getConnect();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				UserModel user = new UserModel();
				user.setId(rs.getInt("id"));
				user.setFirstname(rs.getString("firstname"));
				user.setLastname(rs.getString("lastname"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setPhone(rs.getString("phone"));
				user.setEmail(rs.getString("email"));
				user.setDescription(rs.getString("description"));
				user.setCreatedate(rs.getDate("createddate"));
				user.setUpdatetime(rs.getDate("updatetime"));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public UserModel getusername(String name) {
		String sql = "SELECT * FROM cmsnhom5.member where username = ?;";
		long time = System.currentTimeMillis();
		try {
			new DBConnection();
			conn = DBConnection.getConnect();
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();

			while (rs.next()) {
				UserModel user = new UserModel();
				user.setId(rs.getInt("id"));
				user.setFirstname(rs.getString("firstname"));
				user.setLastname(rs.getString("lastname"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setPhone(rs.getString("phone"));
				user.setEmail(rs.getString("email"));
				user.setDescription(rs.getString("description"));
				user.setCreatedate(new java.sql.Date(time));
				user.setUpdatetime(new java.sql.Date(time));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	
	}
	
}
