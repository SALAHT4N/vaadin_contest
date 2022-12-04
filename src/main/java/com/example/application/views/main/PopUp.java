package com.example.application.views.main;

import com.example.application.views.main.components.MyLoginForm;
import com.example.application.views.main.components.SignUpForm;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;

public class PopUp extends VerticalLayout {

    private VerticalLayout form;
    public PopUp()
    {
        Tab signIn = new Tab("Sign in");
        Tab signUp = new Tab("Sign up");

            addClassName("black");
            setPadding( false);

        MyLoginForm loginForm = new MyLoginForm();
        loginForm.getElement().getThemeList().add("dark");
        loginForm.addClassName("sign-in");

        SignUpForm signUpForm = new SignUpForm();
        signUpForm.getElement().getThemeList().add("dark");

        form = new VerticalLayout();

        Tabs tabs = new Tabs(signIn, signUp);
        tabs.addSelectedChangeListener(e -> {
            if (e.getSelectedTab() == signIn)
            {
                form.removeAll();
                form.add(loginForm);
                loginForm.addClassName("animate-login");

            } else {
                form.removeAll();
                form.add(signUpForm);
                loginForm.removeClassName("animate-login");
            }
        });

        tabs.setAutoselect(true);
        tabs.addClassName("tabs");

        add(tabs,form);
    }



}
