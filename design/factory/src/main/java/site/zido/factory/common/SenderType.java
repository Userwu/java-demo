package site.zido.factory.common;

public enum SenderType {
    MAIL("mail"),SMS("sms");
    String type;
    SenderType(String type){
        this.type = type;
    }
}
