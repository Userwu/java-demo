package site.zido.factory.manyFactory;

import site.zido.factory.common.MailSender;
import site.zido.factory.common.Sender;
import site.zido.factory.common.SmsSender;

public class ManySendFactory {
    Sender produceMail(){
        return new MailSender();
    }
    public Sender produceSms(){
        return new SmsSender();
    }

    public static void main(String[] args) {
        ManySendFactory factory = new ManySendFactory();
        Sender sender = factory.produceMail();
        sender.sender();
    }
}
