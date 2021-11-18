package pj.webt5.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pj.webt5.connection.DBConnection;
import pj.webt5.dao.ContentDao;
import pj.webt5.dao.UserDao;
import pj.webt5.model.ContentModel;
import pj.webt5.model.UserModel;

public class ContentDaoImpl extends DBConnection implements ContentDao{
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	UserDao userdao = new UserDaoImpl();
	@Override
	public void insert(ContentModel content) {
		String sql ="INSERT INTO `cmsnhom5`.`content` (`title`, `brief`, `content`, `createdate`, `updatetime`, `authorid`) VALUES ( ?, ?, ?, ?, ?, ?);";
		try {
			conn = DBConnection.getConnect();
			ps = conn.prepareStatement(sql);

			
			ps.setString(1, content.getTitle());
			ps.setString(2, content.getBrief());
			ps.setString(3, content.getContent());
			ps.setDate(4, new Date(content.getCreatedate().getTime()));
			ps.setDate(5, new Date(content.getUpdatetime().getTime()));
			ps.setInt(6, content.getUser().getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void delete(int id) {
		String sql = "delete from content where id = ?";
		try {
			conn = DBConnection.getConnect();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public List<ContentModel> getall() {
		List<ContentModel> listcontent = new ArrayList<ContentModel>();
		String sql ="SELECT content.id, content.title, content.brief, content.content FROM cmsnhom5.content;";
		try {
			Connection con = super.getConnect();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				UserModel us = userdao.getbyid(rs.getInt("authorid"));
				ContentModel content = new ContentModel();
				content.setId(rs.getInt("id"));
				content.setTitle(rs.getString("title"));
				content.setBrief(rs.getString("brief"));
				content.setContent(rs.getString("content"));
				content.setCreatedate(rs.getDate("createdate"));
				content.setUpdatetime(rs.getDate("updatedate"));
				content.setUser(us);
				listcontent.add(content);
				
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listcontent;
	}
}
