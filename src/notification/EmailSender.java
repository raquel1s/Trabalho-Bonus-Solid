package notification;

import notification.Notifier;

public class EmailSender implements Notifier {

    @Override
    public void send(String email, String mensagem) {
        System.out.println("Email enviado para " + email + ": " + mensagem);
    }
}
