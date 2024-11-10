package use_case.login;

import data.AccountInfo;

/**
 * The Login Interactor.
 */
public class LoginInteractor implements LoginInputBoundary {
    private final LoginDataAccessInterface loginDataAccessInterface;
    private final LoginOutputBoundary loginPresenter;

    public LoginInteractor(LoginDataAccessInterface userDataAccessInterface,
                           LoginOutputBoundary loginOutputBoundary) {
        this.loginDataAccessInterface = userDataAccessInterface;
        this.loginPresenter = loginOutputBoundary;
    }

    @Override
    public void execute(LoginInputData loginInputData) {
        final String username = loginInputData.getUsername();
        final String password = loginInputData.getPassword();
        if (!loginDataAccessInterface.existsByName(username)) {
            loginPresenter.prepareFailView(username + ": Account does not exist.");
        }
        else {
            final String pwd = loginDataAccessInterface.get(username).getPassword();
            if (!password.equals(pwd)) {
                loginPresenter.prepareFailView("Incorrect password for \"" + username + "\".");
            }
            else {

                final AccountInfo account = loginDataAccessInterface.get(loginInputData.getUsername());

                loginDataAccessInterface.setCurrentUsername(account.getUsername());
                final LoginOutputData loginOutputData = new LoginOutputData(account.getUsername(),
                        account.getDays());
                loginPresenter.prepareSuccessView(loginOutputData);
            }
        }
    }
}
