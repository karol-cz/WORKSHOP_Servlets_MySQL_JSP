package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MySqlSolutionDao;
import model.dao.SolutionDao;
import model.entity.Solution;
import model.utils.Utils;

/**
 * Servlet implementation class solutionDetails
 */
@WebServlet("/solutionDetails")
public class solutionDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SolutionDao solutionDao = new MySqlSolutionDao(Utils.DB_URL, Utils.USER, Utils.PASSWORD);

		Solution solution = solutionDao.loadById(Integer.parseInt(request.getParameter("id")));
		
		request.setAttribute("solution", solution);

		getServletContext().getRequestDispatcher("/solutionDetails.jsp").forward(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
