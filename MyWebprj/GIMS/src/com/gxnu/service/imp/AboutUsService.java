package com.gxnu.service.imp;

import com.gxnu.dao.AboutUsDAO;
import com.gxnu.entity.AboutUs;
import com.gxnu.service.IAboutUsService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author ymp0519
 *
 */
	public class AboutUsService implements IAboutUsService{

		@Override
		public void add(AboutUs aboutUs) {

			AboutUsDAO aboutUsDAO = new AboutUsDAO();
			try {
				aboutUsDAO.add(aboutUs);
			} catch (ClassNotFoundException | SQLException e) {
		
				e.printStackTrace();
			}
			
			
		}

		@Override
		public void remove(int id) {

			AboutUsDAO aboutUsDAO = new AboutUsDAO();
			AboutUs aboutUs = new AboutUs();
			aboutUs.setId(id);
			try {
				aboutUsDAO.delete(aboutUs);
			} catch (ClassNotFoundException | SQLException e) {
			
				e.printStackTrace();
			}
			
		}

		@Override
		public void update(AboutUs aboutUs) {

			AboutUsDAO aboutUsDAO = new AboutUsDAO();

			try {
				aboutUsDAO.merge(aboutUs);
			} catch (ClassNotFoundException | SQLException e) {
		
				e.printStackTrace();
			}
		}

		@Override
		public AboutUs find(int id) {

			AboutUsDAO aboutUsDAO = new AboutUsDAO();
			AboutUs aboutUs = new AboutUs();
			aboutUs.setId(id);
			try {
				aboutUs = aboutUsDAO.read(id);
			} catch (ClassNotFoundException | SQLException e) {
		
				e.printStackTrace();
				System.out.println("chdkd");
			}
			return aboutUs;
		}

		@Override
		public List<AboutUs> find_all_list() {

			AboutUsDAO aboutUsDAO = new AboutUsDAO();
			

			
			List<AboutUs> emailService = new ArrayList<AboutUs>();
			
			try {
//				aboutUss = aboutUsDAO.read_all();
				emailService = aboutUsDAO.read_all_1();
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			return emailService;
		}
/**
 * 
 * @param receivernumber
 * @param emailaddress
 * @return
 */
		@Override
		public AboutUs find(String name, String address) {
			
			AboutUs aboutUs_result = new AboutUs();
			AboutUsDAO aboutUsDAO = new AboutUsDAO();
			AboutUs[] aboutUss;
			try {
				aboutUss = new AboutUs[aboutUsDAO.count()];
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
			
			
			try {
				aboutUss = aboutUsDAO.read_all(); 
				
				for(int i=0;i< aboutUss.length;i++){
					if(aboutUss[i].getName().equalsIgnoreCase(name) && aboutUss[i].getAddress().equalsIgnoreCase(address)){
					
					aboutUs_result = aboutUss[i];
					break;
					}
					
					
				}
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
			
			return aboutUs_result;
		}

@Override
public List<AboutUs> find(int currentPage, int pageSize) {

	AboutUsDAO aboutUsDAO = new AboutUsDAO();
	
	
	List<AboutUs> emailService = new ArrayList<AboutUs>();
	
	try {
		emailService = aboutUsDAO.read_all(currentPage,pageSize);
	} catch (ClassNotFoundException | SQLException e) {
	
		e.printStackTrace();
	}
	return emailService;
}

}
