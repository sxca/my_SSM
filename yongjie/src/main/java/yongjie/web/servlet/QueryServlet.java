package yongjie.web.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/query/*")
public class QueryServlet extends BaseServlet {
    public void pageQuery(HttpServletRequest request, HttpServletResponse response) {
        String start_time = request.getParameter("start_time");
        System.out.println(start_time);
    }
}
