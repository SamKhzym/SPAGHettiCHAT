package com.example.spaghettichat.accountmanager.data;


import com.example.spaghettichat.accountmanager.AccountManagerModel;
import com.example.spaghettichat.accountmanager.data.model.LoggedInUser;
import com.example.spaghettichat.accountmanager.data.Result;

import java.io.IOException;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {

    private AccountManagerModel accountManager = new AccountManagerModel();

    public Result<LoggedInUser> login(String username, String password) {

        try {
            // TODO: handle loggedInUser authentication

            //LoggedInUser fakeUser =
            //        new LoggedInUser(
            //                java.util.UUID.randomUUID().toString(),
            //                "Jane Doe");

            if (accountManager.getAccountByUserId(username) != null) {
                LoggedInUser fakeUser = new LoggedInUser(java.util.UUID.randomUUID().toString(),
                        accountManager.getAccountByUserId(username).getFullName());
                AccountManagerModel.setCurrentUser(accountManager.getAccountByUserId(username));
                return new Result.Success<>(fakeUser);
            }
            else {
                return null;
            }

        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }

    public void logout() {
        // TODO: revoke authentication
    }
}