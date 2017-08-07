package site.zido.factory.abst_ract;

import site.zido.factory.common.Sender;

public class Main {
    public static void main(String[] args) {
        Provider provider = new SmsFactory();
        Sender sender = provider.produce();
        sender.sender();
    }
}
