package eCommerce.business.concretes;

import java.util.List;

import eCommerce.business.abstracts.UserService;
import eCommerce.core.utils.EmailService;
import eCommerce.dataAccess.abstracts.UserDao;
import eCommerce.entities.concretes.User;

public class UserManager implements UserService {
	private UserDao _userDao;
	private EmailService _emailService;

	public UserManager(UserDao _userDao, EmailService _emailService) {
		super();
		this._userDao = _userDao;
		this._emailService=_emailService;
	}

	@Override
	public void add(User user) {
		
		//if(userValidate(user)) {
		_userDao.add(user);
		System.out.println("log: "+user.getEmail());
		_emailService.send(user.getEmail(),"kayýt oldunuz.");
		//}
	}
	
	@Override
	public void add(String email) {
		//if(!email.isEmpty()) {
			User user =new User();
			user.setEmail(email);
			_userDao.add(user);
			System.out.println("Log2: " + user.getEmail());
			_emailService.send(email,"Kayýt oldunuz.");
		//}	
	}	

	@Override
	public void update(User user) {
		_userDao.update(user);
		
	}

	@Override
	public void delete(int userId) {
		_userDao.delete(userId);
		
	}

	@Override
	public User get(String email) {
		
		return _userDao.get(email);
	}

	@Override
	public List<User> getAll() {
		
		for (User user : _userDao.getAll()) {
			System.out.println(user.getUserId() +" "+ user.getEmail() +" "+ user.getFullName());
		}
		return _userDao.getAll();
	}
	public boolean userValidate(User user) {
		if(user.getFirstName().length()>=2 && user.getLastName().length()>=2) {
			return true;				
		}
		System.out.println("Adýnýz ve soyadýnýz minimum 2 karakter olmalý.");
		return false;
	}

	
}
