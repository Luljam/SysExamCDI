package hspm.web.filter;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.*;
import org.hibernate.SessionFactory;
import hspm.util.HibernateUtil;

public class ConexaoHibernateFilter implements Filter {
private SessionFactory sf;
	
	public void init(FilterConfig config) throws ServletException{
		this.sf = HibernateUtil.getSessionFactory();
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		try{
			this.sf.getCurrentSession().beginTransaction();
			chain.doFilter(servletRequest, servletResponse);
			this.sf.getCurrentSession().beginTransaction().commit();
			this.sf.getCurrentSession().close();
		}catch(Throwable ex){
			try{
				if(this.sf.getCurrentSession().getTransaction().isActive()){
					this.sf.getCurrentSession().getTransaction().rollback();
				}
			}catch (Throwable t){
				t.printStackTrace();
			}
			throw new ServerException(ex.toString());
		}
		
	}
	public void destroy(){}
}