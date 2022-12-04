package com.example.application.views.main.components;

import com.vaadin.flow.component.PropertyDescriptor;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.login.AbstractLogin;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.login.LoginI18n;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Locale;

public class SignUpForm extends FormLayout {

    private H2 title = new H2("Sign up");
    private EmailField email = new EmailField("Email");
    private DatePicker birthDate = new DatePicker("Birth date");
    private PasswordField passwordField = new PasswordField("Password");
    private Button signUpButton = new Button("Sign up");
    public SignUpForm()
    {
        signUpButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        email.addClassName("input-field");
        birthDate.addClassName("last-input");
        signUpButton.addClassName("submit-button");
        passwordField.addClassName("input-field");
        title.setClassName("title");
//        LoginI18n.Form f = new LoginI18n.Form();
//        f.setTitle("Sign up");
//        LoginI18n l = new LoginI18n();

            addClassName("sign-up");

        setWidth("298px");
        add(title,email,passwordField,birthDate, signUpButton);

    }


}
