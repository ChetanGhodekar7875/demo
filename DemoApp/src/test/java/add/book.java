package add;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

@WebServlet("/add")
public class book extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String	bookName=req.getParameter("bName");
	double bPrice=Double.parseDouble(req.getParameter("price"));
	
		Configuration cfg=new Configuration().configure("/hibernate.cfg.xml").addAnnotatedClass(BookDto.class);
		Session session=cfg.buildSessionFactory().openSession();

		BookDto b=new BookDto();
		b.setBookName(bookName);
		b.setBookPrice(bPrice);
		
		session.save(b);
		Transaction tx=session.beginTransaction();
		tx.commit();
	}
	
}
