package com.tap.app;

/**
 * Created by dba on 6/9/15.
 */
import hms.tap.api.ussd.messages.MoUssdReq;
import hms.tap.ussd.manager.Session;
import hms.tap.ussd.manager.ValueHolder;
import hms.tap.ussd.manager.annotations.Config;
import hms.tap.ussd.manager.menu.Menu;


@Config(id="category")
public class CategoryMenu implements Menu{
    @Override
    public String getMessage(Session session, MoUssdReq moUssdReq) {
        return "Goss-App\nChoose Category\n 1. Cinema \n 2. Politics \n 3. Sports \n 4. My Profile";
    }

    @Override
    public String getNextMenu(Session session, MoUssdReq moUssdReq) {
        String category = moUssdReq.getMessage();
        if(category.equals("1")){
            session.getValueHolders().add(new ValueHolder("category", "cinema"));
            return "Cinema";
        } else if(category.equals("2")){
            session.getValueHolders().add(new ValueHolder("category", "politics"));
            return "Politics";
        } else if (category.equals("3")){
            session.getValueHolders().add(new ValueHolder("category", "sport"));
            return "Sport";
        } else if (category.equals("4")){
            return "Myprofile";
        } else return "category";
    }
}
