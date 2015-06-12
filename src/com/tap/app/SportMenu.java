package com.tap.app;

/**
 * Created by dba on 6/9/15.
 */
import hms.tap.api.ussd.messages.MoUssdReq;
import hms.tap.ussd.manager.Session;
import hms.tap.ussd.manager.ValueHolder;
import hms.tap.ussd.manager.annotations.Config;
import hms.tap.ussd.manager.menu.Menu;


@Config(id="Sport")
public class SportMenu implements Menu{
    @Override
    public String getMessage(Session session, MoUssdReq moUssdReq) {
        return "Choose your preference\n 1. Local \n 2. International";
    }

    @Override
    public String getNextMenu(Session session, MoUssdReq moUssdReq) {
        String sport = moUssdReq.getMessage();
        if (sport.equals("1")){
            session.getValueHolders().add(new ValueHolder("sport", "local"));
        } else if(sport.equals("2")){
            session.getValueHolders().add(new ValueHolder("sport", "international"));
        }
        return "Subsciption";
    }
}
