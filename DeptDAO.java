package src.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import src.utill.DBUtill;

public class DeptDAO {
	
	public List<DeptVO> selectAll() throws SQLException {

		String sql = "select * from Departments";

		List<DeptVO> deptlist = new ArrayList<>();
		Connection conn = DBUtill.getConnection();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while (rs.next()) {
			DeptVO dept= new DeptVO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
			deptlist.add(dept);
		}
		DBUtill.dbClose(rs, st, conn);

		return deptlist;
	}
	
	public DeptVO selectById(int deptid) {
		String sql = "select * from Departments where department_id = ?";
		List<DeptVO> deptlist = new ArrayList<>();
		Connection conn;
		ResultSet rs =null;
		PreparedStatement ps = null;
		DeptVO dept= new DeptVO();
		
		conn = DBUtill.getConnection();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, deptid);
			rs = ps.executeQuery();
			while(rs.next()) {
				rs.getInt(deptid);
				deptlist.add(dept);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dept;
		
	}
	
	public int insertDept(DeptVO dept) {
		String sql = "insert into departments values(?,?,?,?)";
		Connection conn;
		PreparedStatement ps = null;
		int res = 0;

		conn = DBUtill.getConnection();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, dept.getDepartment_id());
			ps.setString(2, dept.getDepartment_name());
			ps.setInt(3, dept.getManager_id());
			ps.setInt(5, dept.getManager_id());
			res = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
}
