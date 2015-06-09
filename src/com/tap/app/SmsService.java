package com.tap.app;
/**
 * Created by dba on 6/9/15.
 */

import com.google.common.collect.Lists;

import hms.tap.api.TapException;
import hms.tap.api.sms.MoSmsListener;
import hms.tap.api.sms.SmsRequestSender;
import hms.tap.api.sms.messages.MoSmsReq;
import hms.tap.api.sms.messages.MtSmsReq;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

import static com.tap.app.ConfigUtil.*;
public class SmsService implements MoSmsListener{

    private static final String welcomMsg = getDisplayMessage("welcome.message").or("Welcome.");
    private static final String appId =  getApplicationConfig("app.id");    private static final String password =  getApplicationConfig("app.password");
    private static final Logger logger = Logger.getLogger("logger");

    @Override
    public void init() {
    }

    @Override
    public void onReceivedSms(MoSmsReq moSmsReq) {
        //
        try {
            String smsMoUrl = getApplicationConfig("tap.sms.endpoint");
            SmsRequestSender smsRequestSender = new SmsRequestSender(new URL(smsMoUrl));
            final MtSmsReq mtSmsReq = getMtSmsReq(moSmsReq);
            smsRequestSender.sendSmsRequest(mtSmsReq);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (TapException e) {
            e.printStackTrace();
        }
    }

    private MtSmsReq getMtSmsReq(MoSmsReq moSmsReq) {
        final MtSmsReq mtSmsReq = new MtSmsReq();
        mtSmsReq.setApplicationId(appId);
        mtSmsReq.setPassword(password);
        mtSmsReq.setDestinationAddresses(Lists.newArrayList(moSmsReq.getSourceAddress()));
        mtSmsReq.setVersion(moSmsReq.getVersion());
        mtSmsReq.setEncoding(moSmsReq.getEncoding());
        mtSmsReq.setMessage(welcomMsg);
        return mtSmsReq;
    }
}