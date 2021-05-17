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
				User sevim=new User(1, "sevim", "taþ", "sevim1@gmail.com", "123654", true);
				//userManager.add(sevim);
				
				//User sevgül = new User(2, "sevgül", "taþ", "sevgül@gmail.com", "147258", false);
				//userManager.update(sevgül);
				
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
