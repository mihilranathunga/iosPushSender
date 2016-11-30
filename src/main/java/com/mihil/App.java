package com.mihil;

import com.notnoop.apns.APNS;
import com.notnoop.apns.ApnsDelegate;
import com.notnoop.apns.ApnsService;
import com.notnoop.apns.EnhancedApnsNotification;

import java.util.Date;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        ApnsDelegate delegate = new NotificationDelegate();

        ApnsService service =
                APNS.newService()
                        //.withCert("egypt_apns_prod.p12", "123456")
                        .withCert("dbfs_apns_prod.p12", "123456")
                        //.withCert("global_push_no_prod.p12", "123456")
                        .withDelegate(delegate)
                        .withSandboxDestination()
                        //.withProductionDestination()
                        .build();

        String payload = APNS.newPayload().alertBody("First one!").badge(1).sound("push").customField("mt", "rm").build();
        String token = "8020ac842a8e693b382b34521688eda25273b4ce027e5ad6400a162e5d39ec90";

        int now = (int) (new Date().getTime() / 1000);

        EnhancedApnsNotification notification = new EnhancedApnsNotification(EnhancedApnsNotification.INCREMENT_ID() /* Next ID */,
                now + 60 * 1 /* Expire in one minute */,
                token /* Device Token */,
                payload);

        try {
            service.push(notification);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
