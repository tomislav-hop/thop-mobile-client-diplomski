package diplomski.thop.thopmobileclient.controller.implementation;


import android.text.Editable;

import diplomski.thop.thopmobileclient.controller.requests.LoginRequest;

public class LoginImpl {
	
	public int login(String username, String password){
		LoginRequest loginRequest = new LoginRequest();
		return loginRequest.sendLoginRequest(username, password);
	}

}
