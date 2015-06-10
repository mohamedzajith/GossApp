package com.tap.app;

/**
 * Created by dba on 6/9/15.
 */
import hms.tap.api.ussd.messages.MoUssdReq;
import hms.tap.ussd.manager.Session;
import hms.tap.ussd.manager.ValueHolder;
import hms.tap.ussd.manager.annotations.Config;
import hms.tap.ussd.manager.annotations.Index;
import hms.tap.ussd.manager.menu.Menu;

@Index
@Config(id="welcome")
public class WelcomeMenu implements Menu{

    @Override
    public String getMessage(Session session, MoUssdReq moUssdReq) {
        return "Welcome to Goss-App\nChoose language\n 1. Sinhala \n 2. Tamil \n 3. English \n";
    }

    @Override
    public String getNextMenu(Session session, MoUssdReq moUssdReq) {
        String language = moUssdReq.getMessage();
        if(language.equals("1")){
            session.getValueHolders().add(new ValueHolder("language", "Sinhala"));
            return "category";
        } else if(language.equals("2")){
            session.getValueHolders().add(new ValueHolder("language", "Tamil"));
            return "category";
        } else if(language.equals("3")){
            session.getValueHolders().add(new ValueHolder("language", "English"));
            return "category";
        }else return "welcome";
    }
}
