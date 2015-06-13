package com.tap.app;
/**
 * Created by dba on 6/9/15.
 */

import hms.tap.api.ussd.MoUssdListener;
import hms.tap.api.ussd.messages.MoUssdReq;
import hms.tap.ussd.manager.UssdMessageProcessor;
import hms.tap.ussd.manager.conf.AppConfig;
import hms.tap.ussd.manager.exceptions.DuplicateMenuIdException;
import hms.tap.ussd.manager.exceptions.IndexMenuNotDefinedException;
import hms.tap.ussd.manager.exceptions.MultipleIndexMenuException;
import hms.tap.ussd.manager.exceptions.UssdInitializationException;
import hms.tap.ussd.manager.menu.Menu;

import java.util.Arrays;

public class UssdService implements MoUssdListener {

    UssdMessageProcessor ussdMessageProcessor;

    public UssdService() {
        try {
            ussdMessageProcessor = new UssdMessageProcessor.Builder().appConfig(new AppConfig.Builder().appId("APP_013175").password("10cb14450cebb747926d11d90fe23633").build()).
                    menus(Arrays.<Menu>asList(new WelcomeMenu(), new CategoryMenu(), new SportMenu(), new CinemaMenu()
                            , new PoliticsMenu(), new ConformationMenu(), new SubscriptionMenu(),new MyProfile(),new Addmore(),new Remove())).build();
        } catch (UssdInitializationException e) {
            e.printStackTrace();
        } catch (MultipleIndexMenuException e) {
            e.printStackTrace();
        } catch (DuplicateMenuIdException e) {
            e.printStackTrace();
        } catch (IndexMenuNotDefinedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void init() {

    }

    @Override
    public void onReceivedUssd(MoUssdReq moUssdReq) {
        ussdMessageProcessor.processMessage(moUssdReq);
    }
}