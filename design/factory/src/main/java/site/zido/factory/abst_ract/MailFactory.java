package site.zido.factory.abst_ract;

import site.zido.factory.common.MailSender;
import site.zido.factory.common.Sender;

public class MailFactory implements Provider {

    public Sender produce() {
        return new MailSender();
    }
}
