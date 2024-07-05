package com.breez.help;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/help-service/v1/support")
public class ServletManager extends HttpServlet {

	private final MemRepository memRepository = MemRepository.getInstance();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try (PrintWriter writer = response.getWriter()) {
			writer.println(memRepository.getPhrase());
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try (PrintWriter writer = response.getWriter()) {
			String newPhrase = request.getParameter("phrase");
			if (newPhrase != null) {
				if (memRepository.addPhrase(newPhrase)) {
					writer.println("This phrase is already exist");
				} else {
					writer.println("New phrase: <" + newPhrase + "> added successfully");
				}
			}
		}
	}

}
