package model;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BuyerAPI
 */
@WebServlet("/researcherAPI")
public class researcherAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Researcher itemObj = new Researcher();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public researcherAPI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String output = itemObj.insertreseacher(request.getParameter("fname"),request.getParameter("lname"),request.getParameter("phone"),request.getParameter("bdate"),request.getParameter("email"),request.getParameter("inoctgry"),request.getParameter("country"),request.getParameter("edustate"),request.getParameter("password"),request.getParameter("cpasswored"));
		response.getWriter().write(output);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Map paras = getParasMap(request);
		 String output = itemObj.updateResercher(paras.get("hidridSave").toString(),paras.get("fname").toString(),paras.get("lname").toString(),paras.get("phone").toString(),paras.get("bdate").toString(),paras.get("email").toString(),paras.get("inoctgry").toString(),paras.get("country").toString(),paras.get("edustate").toString(),paras.get("password").toString(),paras.get("cpasswored").toString());
		response.getWriter().write(output);
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Map paras = getParasMap(request);
		 String output = itemObj.deleteResercher(paras.get("rid").toString());
		response.getWriter().write(output);
	}
	private static Map getParasMap(HttpServletRequest request)
	{
	 Map<String, String> map = new HashMap<String, String>();
	try
	 {
	 Scanner scanner = new Scanner(request.getInputStream(), "UTF-8");
	 String queryString = scanner.hasNext() ?
	 scanner.useDelimiter("\\A").next() : "";
	 scanner.close();
	 String[] params = queryString.split("&");
	 for (String param : params)
	 { 
	
	String[] p = param.split("=");
	 map.put(p[0], p[1]);
	 }
	 }
	catch (Exception e)
	 {
	 }
	return map;
	}

}
