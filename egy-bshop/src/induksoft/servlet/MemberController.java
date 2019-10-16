package induksoft.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import induksoft.model.Member;

/**
 * Servlet implementation class MemberController
 */
@WebServlet({"/member-login.do", "/member-register.do", "/member-list.do"})
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// records or rows
	ArrayList<Member> arrayListofMember = new ArrayList<Member>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		HttpSession session = request.getSession();
		
		String uri = request.getRequestURI();
		String action = uri.substring(uri.lastIndexOf("/") + 1);

		if(action.equals("member-login.do")) {

			session.setAttribute("login", null);
			for(Member m : arrayListofMember) {
				if(id.equals(m.getId()) && pw.equals(m.getPw())) {
					session.setAttribute("login", m.getName());
				}
			}			
			request.getRequestDispatcher("member-login-view.jsp").forward(request, response);
		}
		else if(action.equals("member-register.do")) {
			String name = request.getParameter("name");
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");
			String country = request.getParameter("country");
			
			Member member = new Member();
			// 1 record , 1 row
			member.setId(id);
			member.setPw(pw);
			member.setName(name);
			member.setPhone(phone);
			member.setEmail(email);
			member.setCountry(country);
			
			arrayListofMember.add(member);
			request.setAttribute("member", name);
			session.setAttribute("memberlist", arrayListofMember);
			request.getRequestDispatcher("member-register-view.jsp").forward(request, response);
		}
		else if(action.equals("member-list.do")) {
			request.getRequestDispatcher("member-list-view.jsp").forward(request, response);
		}
		else
			System.out.println("요청을 확인하시오");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		/*
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		session.setAttribute("name", request.getParameter("name"));
		response.sendRedirect("post.jsp");
		*/
		
		
	}

}
