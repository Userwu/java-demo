package site.zido.factory.sta_tic;

import site.zido.factory.common.MailSender;
import site.zido.factory.common.Sender;
import site.zido.factory.common.SmsSender;

public class StaticFactory {
    static Sender produceMailSender(){
        return new MailSender();
    }
    public static Sender ProduceSmsSender(){
        return new SmsSender();
    }

    public static void main(String[] args) {
        Sender sender = StaticFactory.produceMailSender();
        sender.sender();
    }
}
