package com.tap.app;

/**
 * Created by dba on 6/9/15.
 */
import hms.tap.api.ussd.messages.MoUssdReq;
import hms.tap.ussd.manager.Session;
import hms.tap.ussd.manager.ValueHolder;
import hms.tap.ussd.manager.annotations.Config;
import hms.tap.ussd.manager.menu.Menu;

@Config(id="Cinema")
public class CinemaMenu implements Menu{
    @Override
    public String getMessage(Session session, MoUssdReq moUssdReq) {
        return "Choose your preference \n 1. Hollywood \n 2. Bollywood \n 3. Kollywood ";
    }

    @Override
    public String getNextMenu(Session session, MoUssdReq moUssdReq) {
        String cinema = moUssdReq.getMessage();
        if (cinema.equals("1")){
            session.getValueHolders().add(new ValueHolder("cinema", "hollywood"));
        } else if(cinema.equals("2")){
            session.getValueHolders().add(new ValueHolder("cinema", "bollywood"));
        } else if(cinema.equals("3")){
            session.getValueHolders().add(new ValueHolder("cinema", "kollywood"));
        }
        return "Subsciption";
    }
}
