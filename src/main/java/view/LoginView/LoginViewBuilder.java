package view.LoginView;

import data_access.TempDAOInMemory;
import interface_adapter.login.LoginController;
import interface_adapter.login.LoginPresenter;
import org.jetbrains.annotations.NotNull;
import use_case.login.LoginDataAccessInterface;
import use_case.login.LoginInputBoundary;
import use_case.login.LoginInteractor;
import use_case.login.LoginOutputBoundary;
import view.mainView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginViewBuilder {

    private final JFrame loginFrame;
    private final JPanel loginPanel;
    private JLabel welcomeLabel;
    private JPanel usernamePanel;
    private JPanel passwordPanel;
    private JPanel buttonPanel;

    public LoginViewBuilder(JPanel loginPanel, JFrame loginFrame) {
        this.loginFrame = loginFrame;
        this.loginPanel = loginPanel;
        this.loginPanel.setLayout(new BoxLayout(this.loginPanel, BoxLayout.Y_AXIS));
    }

    public void setWelcomeLabel() {
        this.welcomeLabel = new JLabel("Welcome to AlgoHealth's Nutrition Tracker!");
    }

    public LoginViewBuilder addWelcomeLabel() {
        this.setWelcomeLabel();
        this.loginPanel.add(welcomeLabel);
        return this;
    }

    public void setUsernamePanel() {
        JPanel usernamePanel = new JPanel();
        JLabel usernameText = new JLabel("Username:");
        JTextField usernameField = new JTextField(15);

        usernamePanel.add(usernameText);
        usernamePanel.add(usernameField);

        this.usernamePanel = usernamePanel;
    }

    public LoginViewBuilder addUsernamePanel() {
        this.setUsernamePanel();
        this.loginPanel.add(usernamePanel);
        return this;
    }

    public void setPasswordPanel() {
        JPanel passwordPanel = new JPanel();
        JLabel passwordText = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField(15);

        passwordPanel.add(passwordText);
        passwordPanel.add(passwordField);

        this.passwordPanel = passwordPanel;
    }

    public LoginViewBuilder addPasswordPanel() {
        this.setPasswordPanel();
        this.loginPanel.add(passwordPanel);
        return this;
    }

    public JButton getLoginButton(JTextField usernameField, JPasswordField passwordField) {

        LoginOutputBoundary loginPresenter = new LoginPresenter(new mainView()); // does this work????
        LoginDataAccessInterface loginDataAccessObject = new TempDAOInMemory();
        LoginInputBoundary loginUseCaseInteractor = new LoginInteractor(loginDataAccessObject, loginPresenter);
        LoginController loginController = new LoginController(loginUseCaseInteractor);

        return createLoginButton(usernameField, passwordField, loginController, this.loginFrame);
    }

    @NotNull
    private static JButton createLoginButton(JTextField usernameField,
                                             JPasswordField passwordField,
                                             LoginController loginController,
                                             JFrame loginFrame) {

        JButton loginButton = new JButton("Log In");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                char[] passwordChars = passwordField.getPassword();
                StringBuilder password = new StringBuilder();

                for (char passwordChar : passwordChars) {
                    password.append(passwordChar);
                }
                System.out.println("clicked log in");
                loginController.execute(username, password.toString(), loginFrame);
                System.out.println(username);
                System.out.println(password);
            }
        });
        return loginButton;
    }

    public JButton getSignupButton() {
        JButton signupButton = new JButton("Sign Up");
        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // get the signup view, close this one
            }
        });
        return signupButton;
    }

    public void setButtonPanel() {
        JTextField usernameField = (JTextField) this.usernamePanel.getComponent(1); // maybe bad practice
        JPasswordField passwordField = (JPasswordField) this.passwordPanel.getComponent(1);

        JPanel buttonPanel = new JPanel();
        JButton loginButton = getLoginButton(usernameField, passwordField);
        JButton signupButton = getSignupButton();

        buttonPanel.add(loginButton);
        buttonPanel.add(signupButton);

        this.buttonPanel = buttonPanel;
    }

    public LoginViewBuilder addButtonPanel() {
        this.setButtonPanel();
        this.loginPanel.add(buttonPanel);
        return this;
    }

    public JFrame build() {
        this.loginFrame.setContentPane(this.loginPanel);
        this.loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        return loginFrame;
    }
}
