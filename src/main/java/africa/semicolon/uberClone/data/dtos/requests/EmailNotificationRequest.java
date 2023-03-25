package africa.semicolon.uberClone.data.dtos.requests;


import java.util.List;

public class EmailNotificationRequest {
    private final Sender sender = new Sender("Uber Clone", "uber_clone@uber.net");
    private List<Recipient> to;
    private final String subject = "welcome to Uber Clone";
    private final String htmlContent = "<p>Hello, welcome to Uber Clone</p>";
}
