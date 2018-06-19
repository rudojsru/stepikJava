package frontend;

import base.AccountService;
import base.UserProfile;

import java.util.HashMap;
import java.util.Map;

public class AccountServiceImp implements AccountService {


    Map<String, UserProfile> signUpUser= new HashMap<>();
    @Override
    public void signUp(String login, String password) {
        signUpUser.put(login, new UserProfile(login,password));

    }

    @Override
    public boolean signIn(String login, String password) {
        UserProfile signInUser= signUpUser.get(login);

        return signInUser != null && signInUser.getPassword().equals(password);
    }
}
