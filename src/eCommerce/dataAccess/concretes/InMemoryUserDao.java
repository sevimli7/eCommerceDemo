package eCommerce.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import eCommerce.dataAccess.abstracts.UserDao;
import eCommerce.entities.concretes.User;

public class InMemoryUserDao implements UserDao{
	
	private List<User> users=new ArrayList<User>();
	
	public InMemoryUserDao() {
		super();
		User user1=new User(1,"sevim","taþ","sevim@gmail.com","123425",true);
		User user2=new User(2,"sevgi","taþ","sevgi@gmail.com","982345",true);
		User user3=new User(3,"asya","taþ","asya@gmail.com","823456",true);
		
		users.add(user1);
		users.add(user2);
		users.add(user3);
	}
	

	@Override
	public void add(User user) {
		System.out.println("log inmemory: "+user.getEmail());
		users.add(user);
		
	}

	@Override
	public void update(User user) {
		User userToUpdate=users.stream()
				.filter(u->u.getUserId()==user.getUserId())
				.findFirst()
				.orElse(null);
		userToUpdate.setEmail(user.getEmail());
		userToUpdate.setFirstName(user.getFirstName());
		userToUpdate.setLastName(user.getLastName());
		userToUpdate.setPassword(user.getPassword());
		userToUpdate.setIsVerify(user.getIsVerify());
	}

	@Override
	public void delete(int userId) {
		User userToDelete=users.stream()
				.filter(u->u.getUserId()==userId)
				.findFirst()
				.orElse(null);
		users.remove(userToDelete);
	}

	@Override
	public User get(String email) {
		
		User user = users.stream()
				.filter(u -> u.getEmail() == email)
				.findFirst()
				.orElse(null);
		return user;
	}

	@Override
	public List<User> getAll() {
		
		return users;
	}

}
