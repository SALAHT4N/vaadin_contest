package com.example.application.views.main.components;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;

public class MyLoginForm extends FormLayout {

    private H2 title = new H2("Sign in");
    private TextField username = new TextField("Username");
    private PasswordField passwordField = new PasswordField("Password");
    private Button logInButton = new Button("Sign in");

    public MyLoginForm()
    {
        addClassName("login");
        logInButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        username.addClassName("input-field");

        logInButton.addClassName("submit-button");
        passwordField.addClassName("last-input");
        title.setClassName("title");
//        LoginI18n.Form f = new LoginI18n.Form();
//        f.setTitle("Sign up");
//        LoginI18n l = new LoginI18n();

        addClassName("sign-up");
        setWidth("298px");
        add(title,username ,passwordField, logInButton);
    }
}
