package eCommerce.core.utils;

import amazonEmail.AmazonMailManager;

public class AmazonMailManagerAdapter implements EmailService{

	private AmazonMailManager amazonMailManager;
	public AmazonMailManagerAdapter(AmazonMailManager amazonMailManager) {
		super();
		this.amazonMailManager = amazonMailManager;
	}
	public AmazonMailManagerAdapter() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void send(String email, String message) {
		amazonMailManager.send(email,message);
		
	}

}
