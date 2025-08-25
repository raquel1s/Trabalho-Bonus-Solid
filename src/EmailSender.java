public class EmailSender {

    private Notifier notifier;

    public EmailSender(Notifier notifier) {
        this.notifier = notifier;
    }

    public void sendEmail(String email, String s){
        notifier.send(email, s);
    }
}
