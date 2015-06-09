package com.tap.app;

/**
 * Created by dba on 6/9/15.
 */
import hms.tap.api.ussd.messages.MoUssdReq;
import hms.tap.ussd.manager.Session;
import hms.tap.ussd.manager.ValueHolder;
import hms.tap.ussd.manager.annotations.Config;
import hms.tap.ussd.manager.menu.Menu;

@Config(id="Politics")
public class PoliticsMenu implements Menu{
    @Override
    public String getMessage(Session session, MoUssdReq moUssdReq) {
        return "Goss-App\nChoose Category\n 1. Local \n 2. Central ";
    }

    @Override
    public String getNextMenu(Session session, MoUssdReq moUssdReq) {
        String politics = moUssdReq.getMessage();
        if (politics.equals("1")){
            session.getValueHolders().add(new ValueHolder("politics", "local"));
        } else if(politics.equals("2")){
            session.getValueHolders().add(new ValueHolder("politics", "central"));
        }
        return "Subsciption";
    }
}
