package com.tap.app;

/**
 * Created by dba on 6/9/15.
 */
import hms.tap.api.ussd.messages.MoUssdReq;
import hms.tap.ussd.manager.Session;
import hms.tap.ussd.manager.annotations.Config;
import hms.tap.ussd.manager.menu.Menu;


@Config(id="Finish")
public class SubscriptionMenu implements Menu{

    @Override
    public String getMessage(Session session, MoUssdReq moUssdReq) {

        return "Thank you for your subscription";
    }

    @Override
    public String getNextMenu(Session session, MoUssdReq moUssdReq) {

        return null;
    }
}
