package site.zido.factory.abst_ract;

import site.zido.factory.common.Sender;
import site.zido.factory.common.SmsSender;

public class SmsFactory implements Provider{
    public Sender produce() {
        return new SmsSender();
    }
}
