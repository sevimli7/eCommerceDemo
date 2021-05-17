package eCommerce.business.concretes;

import java.util.List;

import eCommerce.core.utils.util.utils;
import eCommerce.business.abstracts.AuthService;
import eCommerce.business.abstracts.UserService;
import eCommerce.entities.concretes.LoginDto;
import eCommerce.entities.concretes.User;

public class AuthManager implements AuthService{
	
	private UserService _userService;
	
	public AuthManager(UserService userService) {
		super();
		this._userService = userService;
	}

	@Override
	public void register(User user) {
		if(userValidate(user) 
				&& passwordValidate(user.getPassword()) 
				&& userExists(user.getEmail()) == false 
				&& utils.emailValidate(user.getEmail())) 
		{
			_userService.add(user);	
		}
		else {
			System.out.println("Kayıt başarısız!");
		}	
		
	}

	@Override
	public void verify(User user,String token) {
		
		if(user != null && token.length() > 15) {			
			User existUser= _userService.get(user.getEmail());
			existUser.setIsVerify(true);
			
			_userService.update(existUser);	
			
			System.out.println("Email doğrulandı.");
		}
		else {
			System.out.println("Email doğrulanamadı.");
		}	
		
	}

	@Override
	public boolean userExists(String email) {
		User user=_userService.get(email);

		if(user == null) {
			return false;
		}
		
		else {
			System.out.println("Email zaten mevcut.!" + email);		
			return true;
		}	
	}

	@Override
	public void login(LoginDto dto) {
		// TODO Auto-generated method stub
		
	}
	
	public boolean userValidate(User user) {	
		
		if(user != null && !user.getFirstName().isEmpty() && !user.getLastName().isEmpty()
				&& !user.getEmail().isEmpty()	&& !user.getPassword().isEmpty()) {
			return true;			
		}
		
		System.out.println("Boş alan bırakmayınız.");
		
		return false;		
	}
	
	public boolean passwordValidate(String password) {
		
		if(password.length() >= 6 ) {
			return true;
		}
		
		System.out.println("Şifreniz 6 karakterden dhaa uzun olmalıdır.");
		
		return false;
	}
	

}
