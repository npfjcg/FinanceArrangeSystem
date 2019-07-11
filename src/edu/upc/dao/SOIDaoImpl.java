package edu.upc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.upc.utils.DbUtils;

public class SOIDaoImpl implements SharedOwnedInfoDao {

	@Override
	public void  insertSOI(ShareOwnedInfo  shareownedinfo) {
		// TODO Auto-generated method stub
		Connection  conn=null;
		PreparedStatement  pstmt=null;
				try {
			conn=DbUtils.getConnection();	
				String  sql="insert  into  shareownedinfo(shareowned_id" //�˺�	
						+ ",shareowned_no"//����	
						+ ",shareowned_name"//��Ʊ����
						+ ",shareowned_begin"//�ɱ���
						+ ",shareowned_end"//���̼�
						+ ",shareowned_amount)  "//�ֲ���
						+ "values(?,?,?,?,?,?)";
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, shareownedinfo.getShareowned_id());
				pstmt.setInt(2, shareownedinfo.getShareowned_no());
				pstmt.setString(3, shareownedinfo.getShareowned_name());
				pstmt.setDouble(4, shareownedinfo.getShareowned_begin());
				pstmt.setDouble(5, shareownedinfo.getShareowned_end());
				pstmt.setInt(6, shareownedinfo.getShareowned_amount());
				pstmt.executeUpdate();//���뵽���ݿ�
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally
				{
					DbUtils.closeStatement(pstmt);
					DbUtils.closeConnection(conn);
				}
	}

	@Override
	public void updateSOI(ShareOwnedInfo  shareownedinfo) {
		// TODO Auto-generated method stub
		Connection  conn=null;
		PreparedStatement  pstmt=null;
				try {
			conn=DbUtils.getConnection();	
				String  sql="update  shareownedinfo  set shareowned_name=?,shareowned_begin=?,shareowned_end=?,shareowned_amount=? where shareowned_id  = ? and shareowned_no = ?";
				pstmt=conn.prepareStatement(sql);
				
				pstmt.setInt(5, shareownedinfo.getShareowned_id());
				pstmt.setInt(6, shareownedinfo.getShareowned_no());
				pstmt.setString(1, shareownedinfo.getShareowned_name());
				pstmt.setDouble(2, shareownedinfo.getShareowned_begin());
				pstmt.setDouble(3, shareownedinfo.getShareowned_end());
				pstmt.setInt(4, shareownedinfo.getShareowned_amount());
				pstmt.executeUpdate();//
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally
				{
					DbUtils.closeStatement(pstmt);
					DbUtils.closeConnection(conn);
				}
	}

	@Override
	public void deleteSOI(int shareowned_id,int shareowned_no) {
		// TODO Auto-generated method stub
		Connection  conn=null;
		PreparedStatement  pstmt=null;
				try {
			conn=DbUtils.getConnection();	
				String  sql="delete  from  shareownedinfo where  shareowned_id=? and shareowned_no=?;";
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, shareowned_id);
				pstmt.setInt(2, shareowned_no);
				pstmt.executeUpdate();//���뵽���ݿ�
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally
				{
					DbUtils.closeStatement(pstmt);
					DbUtils.closeConnection(conn);
				}
	}

	@Override
	public List<ShareOwnedInfo> getAllSOI() {
		Connection  conn=null;
		PreparedStatement  pstmt=null;
		ResultSet  rs=null;
		List<ShareOwnedInfo>   shareownedinfos=new ArrayList<>();
		try {

			//2.�������ݿ�		
			conn=DbUtils.getConnection();
			// System.out.println("ok");
	//3.	�������ݿ�
			String  sql="select  *   from  shareownedinfo ";
		  pstmt=conn.prepareStatement(sql);
		

		rs=pstmt.executeQuery();
		while(rs.next())
		{
ShareOwnedInfo  shareownedinfo=new ShareOwnedInfo();
shareownedinfo.setShareowned_id(rs.getInt("shareowned_id"));
shareownedinfo.setShareowned_no(rs.getInt("shareowned_no"));
shareownedinfo.setShareowned_name(rs.getString("shareowned_name"));
shareownedinfo.setShareowned_begin(rs.getDouble("shareowned_begin"));
shareownedinfo.setShareowned_end(rs.getDouble("shareowned_end"));
shareownedinfo.setShareowned_amount(rs.getInt("shareowned_amount"));
shareownedinfos.add(shareownedinfo);
		}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{

	//4.�ر����ݿ�
	DbUtils.closeResultSet(rs);
	DbUtils.closeStatement(pstmt);
	DbUtils.closeConnection(conn);
	}
		
	
		return shareownedinfos;
	}

	@Override
	public List<ShareOwnedInfo>  getSOIBySOI_id(int  shareowned_id){
		// TODO Auto-generated method stub
		Connection  conn=null;
		PreparedStatement  pstmt=null;
		ResultSet  rs=null;
		List<ShareOwnedInfo>  shareownedinfos=new ArrayList<>();
		try {

			//2.�������ݿ�		
			conn=DbUtils.getConnection();
			// System.out.println("ok");
	//3.	�������ݿ�
			String  sql="select  *   from  shareownedinfo  where  shareowned_id=?";
		  pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, shareowned_id);

		rs=pstmt.executeQuery();
		while(rs.next())
		{
			ShareOwnedInfo  shareownedinfo=new ShareOwnedInfo();
			shareownedinfo.setShareowned_id(rs.getInt("shareowned_id"));
			shareownedinfo.setShareowned_no(rs.getInt("shareowned_no"));
			shareownedinfo.setShareowned_name(rs.getString("shareowned_name"));
			shareownedinfo.setShareowned_begin(rs.getDouble("shareowned_begin"));
			shareownedinfo.setShareowned_end(rs.getDouble("shareowned_end"));
			shareownedinfo.setShareowned_amount(rs.getInt("shareowned_amount"));
			shareownedinfos.add(shareownedinfo);
		}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{

	//4.�ر����ݿ�
	DbUtils.closeResultSet(rs);
	DbUtils.closeStatement(pstmt);
	DbUtils.closeConnection(conn);
	}
		
		
		return shareownedinfos;
	}
	public ShareOwnedInfo  getSOIByidno(int  shareowned_id,int shareowned_no) {
		// TODO Auto-generated method stub
				Connection  conn=null;
				PreparedStatement  pstmt=null;
				ResultSet  rs=null;
				ShareOwnedInfo  shareownedinfo=new ShareOwnedInfo();
				try {

					//2.�������ݿ�		
					conn=DbUtils.getConnection();
					// System.out.println("ok");
			//3.	�������ݿ�
					String  sql="select  *   from  shareownedinfo  where  shareowned_id=? and shareowned_no=?";
				  pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, shareowned_id);
				pstmt.setInt(2, shareowned_no);

				rs=pstmt.executeQuery();
				while(rs.next())
				{
					shareownedinfo.setShareowned_id(rs.getInt("shareowned_id"));
					shareownedinfo.setShareowned_no(rs.getInt("shareowned_no"));
					shareownedinfo.setShareowned_name(rs.getString("shareowned_name"));
					shareownedinfo.setShareowned_begin(rs.getDouble("shareowned_begin"));
					shareownedinfo.setShareowned_end(rs.getDouble("shareowned_end"));
					shareownedinfo.setShareowned_amount(rs.getInt("shareowned_amount"));

				}
				
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{

			//4.�ر����ݿ�
			DbUtils.closeResultSet(rs);
			DbUtils.closeStatement(pstmt);
			DbUtils.closeConnection(conn);
			}
				
				
				return shareownedinfo;
			}
	
}
