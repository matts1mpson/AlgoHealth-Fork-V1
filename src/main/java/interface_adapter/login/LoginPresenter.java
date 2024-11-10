package interface_adapter.login;

import data.DayInfo;
import use_case.login.LoginOutputBoundary;
import use_case.login.LoginOutputData;
import view.mainView;

import java.time.LocalDate;
import java.util.List;

/**
 * The Presenter for the Login Use Case.
 */
public class LoginPresenter implements LoginOutputBoundary {

    private final mainView homePage;

    public LoginPresenter(mainView homePage) {
        this.homePage = homePage;
    }

    @Override
    public void prepareSuccessView(LoginOutputData loginOutputData) {
        List<DayInfo> days = loginOutputData.getDays();
        int latestDayIndex = days.size() - 1;
        homePage.genMvGUI(days.get(latestDayIndex));
    }

    @Override
    public void prepareFailView(String error) {

    }
}
