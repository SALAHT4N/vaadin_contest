package com.example.application.views.main;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Main")
@Route(value = "")
public class MainView extends VerticalLayout {

    private TextField name;
    private Button sayHello;
    HorizontalLayout nav;
    Avatar avatar;
    TextField textField;

    public MainView() {
        addClassName("main-pagge");
        setWidthFull();
        setHeightFull();
        Dialog dialog = new Dialog();
        dialog.setClassName("pop-up");
        dialog.getElement().setAttribute("theme","background-color");

        dialog.add(new PopUp());
        nav =new HorizontalLayout(  );
        avatar=new Avatar();
        sayHello = new Button("Sign in",avatar);
        sayHello.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        textField=new TextField("");
        textField.setPlaceholder("Search..");
        textField.addClassName("search");
        nav.add(textField,sayHello);
        nav.addClassName("nav");
        add(nav, new Mathces());
        sayHello.addClickListener(e -> {
            dialog.open();
        });
        dialog.getElement().getThemeList().add("dark");

    }

}
