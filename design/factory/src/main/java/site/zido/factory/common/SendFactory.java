package site.zido.factory.common;

public class SendFactory {
    private Sender produce(SenderType type){
        switch (type){
            case SMS:
                return new SmsSender();
            case MAIL:
                return new MailSender();
            default:
                System.out.println("类型错误");
                return null;
        }
    }
    public static void main(String[] args){
        SendFactory factory = new SendFactory();
        Sender produce = factory.produce(SenderType.MAIL);
        produce.sender();
    }
}
