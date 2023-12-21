package framework.utilities;

public class Email {
    private final String sender;
    private final String receiver;
    private final String message;
    private final String subject;

    /**
     *
     * @param subject
     * @param sender
     * @param receiver
     * @param message
     */
    public Email(String subject, String sender, String receiver, String message){
        this.message = message;
        this.receiver = receiver;
        this.sender = sender;
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Subject: " + this.subject + "\n " + "Sender: " + this.sender + "\n" + "Receiver: " + this.receiver + "\n" + "Message: " + this.message + "\n";
    }
}
