package eCommerce;

import eCommerce.business.concretes.AuthManager;
import eCommerce.business.concretes.UserManager;
import eCommerce.core.utils.AmazonMailManagerAdapter;
import eCommerce.core.utils.GoogleMailManagerAdapter;
import eCommerce.dataAccess.concretes.InMemoryUserDao;
import eCommerce.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
				
				//UserManager userManager=new UserManager(new InMemoryUserDao(), new AmazonMailManagerAdapter());
				User sevim=new User(1, "sevim", "ta�", "sevim1@gmail.com", "123654", true);
				//userManager.add(sevim);
				
				//User sevg�l = new User(2, "sevg�l", "ta�", "sevg�l@gmail.com", "147258", false);
				//userManager.update(sevg�l);
				
				InMemoryUserDao inMemoryUserDao = new InMemoryUserDao();
				GoogleMailManagerAdapter googleMailManagerAdapter = new GoogleMailManagerAdapter();
				AmazonMailManagerAdapter amazonMailManagerAdapter = new  AmazonMailManagerAdapter();

				
				AuthManager authManager =new AuthManager(new UserManager(inMemoryUserDao, googleMailManagerAdapter));
				//authManager.register(sevim);
				authManager.register(sevim);
				UserManager userManager = new UserManager(inMemoryUserDao, amazonMailManagerAdapter);
				
				//userManager.getAll();
				
	}

}
