package edu.upc.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.upc.dao.ShareStreamInfo;
import edu.upc.service.SSIServiceImpl;

/**
 * Servlet implementation class InsertDeptServlet
 */
@WebServlet("/InsertSSIServlet")
public class InsertSSIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertSSIServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//�������󲢴���
		response.setContentType("text/html;charset = utf-8");
		request.setCharacterEncoding("UTF-8");
		int  sharestream_id=Integer.parseInt(request.getParameter("sharestream_id"));
		int  sharestream_no=Integer.parseInt(request.getParameter("sharestream_no"));
		String  sharestream_name=request.getParameter("sharestream_name");
		int  sharestream_in=Integer.parseInt(request.getParameter("sharestream_in"));
		int  sharestream_out=Integer.parseInt(request.getParameter("sharestream_out"));
		//String date = request.getParameter("sharestream_date");
		//DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		//df.setLenient(false);
		//Timestamp sharestream_date;
		//try {
			//sharestream_date = new Timestamp(df.parse(date).getTime());
			Timestamp sharestream_date=Timestamp.valueOf((request.getParameter("sharestream_date")));
			//Date  sharestream_date=request.getParameter("sharestream_date");
			ShareStreamInfo  sharestreaminfo=new ShareStreamInfo(sharestream_id,sharestream_no,sharestream_name,sharestream_in,sharestream_out,sharestream_date);
			//�ҵ�ĳ��ҵ���߼�����
			SSIServiceImpl  SSIService=SSIServiceImpl.getInstance();
			SSIService.insertSSI(sharestreaminfo);
		
		//3.�ҵ�ĳ����ͼ��Ӧ
		//} catch (ParseException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		//}finally {
		
	request.getRequestDispatcher("GetAllSSIsServlet").forward(request, response);
		}
	
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	this.doGet(request, response);
	}

}
