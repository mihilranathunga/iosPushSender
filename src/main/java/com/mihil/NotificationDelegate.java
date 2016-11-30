package com.mihil;

import com.notnoop.apns.ApnsDelegate;
import com.notnoop.apns.ApnsNotification;
import com.notnoop.apns.DeliveryError;

/**
 * Created by mihilranathunga on 9/6/16.
 */
public class NotificationDelegate implements ApnsDelegate {
    @Override
    public void messageSent(ApnsNotification apnsNotification, boolean b) {
        System.out.println("MESSAGE SENT");
    }

    @Override
    public void messageSendFailed(ApnsNotification apnsNotification, Throwable throwable) {
        System.out.println("MESSAGE FAILED");
    }

    @Override
    public void connectionClosed(DeliveryError deliveryError, int i) {
        System.out.println("delevery Error :" +deliveryError);
    }

    @Override
    public void cacheLengthExceeded(int i) {

    }

    @Override
    public void notificationsResent(int i) {
        System.out.println("MESSAGE RESENT");
    }
}
