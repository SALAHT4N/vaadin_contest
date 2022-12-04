package com.example.application.views.main;

import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.html.Nav;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;


public class HomePage extends VerticalLayout {
    Nav nav;
    Avatar avatar;
    MainView mainView;
    public HomePage()
    {
        nav =new Nav();

        nav.add(new Avatar());
        mainView=new MainView();
        add(nav,mainView);



    }
}
