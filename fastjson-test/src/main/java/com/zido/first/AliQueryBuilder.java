package com.zido.first;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Drawlottery.
 * Date: 2017/2/23 0023
 * Time: 15:03
 *
 * @author <a href="http://userwu.github.io">wuhongxu</a>.
 * @version 1.0.0
 */
public class AliQueryBuilder {
    /**********************公共参数****************************/

    /**
     * 支付宝分配给开发者的应用ID
     */
    private String app_id;
    /**
     * 接口名称
     */
    private String method;
    /**
     * 仅支持JSON
     */
    private String format;
    /**
     * 请求使用的编码格式，如utf-8,gbk,gb2312等
     */
    private String charset;
    /**
     * 商户生成签名字符串所使用的签名算法类型，目前支持RSA2和RSA，推荐使用RSA2
     */
    private String sign_type;
    /**
     * 商户请求参数的签名串，详见签名
     */
    private String sign;
    /**
     * 发送请求的时间，格式"yyyy-MM-dd HH:mm:ss"
     */
    private String timestamp;
    /**
     * 调用的接口版本，固定为：1.0
     */
    private String version;
    /**
     * 支付宝服务器主动通知商户服务器里指定的页面http/https路径。建议商户使用https
     */
    private String notify_url;
    /**
     * 业务请求参数的集合，最大长度不限，除公共参数外所有请求参数都必须放在这个参数中传递，具体参照各产品快速接入文档
     */
    private String biz_content;

    public Map<String, String> encode() {
        Map<String, String> map = new HashMap<>();
        try {
            map.put("app_id", URLEncoder.encode(app_id, "UTF-8"));
            map.put("method", URLEncoder.encode(method, "UTF-8"));
            map.put("format", URLEncoder.encode(format, "UTF-8"));
            map.put("charset", URLEncoder.encode(charset, "UTF-8"));
            map.put("sign_type", URLEncoder.encode(sign_type, "UTF-8"));
            if (sign != null)
                map.put("sign", URLEncoder.encode(sign, "UTF-8"));
            map.put("timestamp", URLEncoder.encode(timestamp, "UTF-8"));
            map.put("version", URLEncoder.encode(version, "UTF-8"));
            map.put("notify_url", URLEncoder.encode(notify_url, "UTF-8"));
            map.put("biz_content", URLEncoder.encode(biz_content, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return map;
    }

    public Map<String, String> getMap() {
        Map<String, String> map = new HashMap<>();
        map.put("app_id", app_id);
        map.put("method", method);
        map.put("format", format);
        map.put("charset", charset);
        map.put("sign_type", sign_type);
        if (sign != null)
            map.put("sign", sign);
        map.put("timestamp", timestamp);
        map.put("notify_url", notify_url);
        map.put("version", version);
        if (biz_content != null)
            map.put("biz_content", biz_content);
        return map;
    }

    /**
     * 不进行序列化
     */
    private transient Content content;


    /**********************业务参数****************************/

    public static class Content {
        /**
         * 对一笔交易的具体描述信息。如果是多种商品，请将商品描述字符串累加传给body。
         */
        public static String body = "body";
        /**
         * 商品的标题/交易标题/订单标题/订单关键字等。
         */
        public static String subject = "subject";
        /**
         * 商户网站唯一订单号
         */
        public static String out_trade_no = "out_trade_no";
        /**
         * 设置未付款支付宝交易的超时时间，一旦超时，该笔交易就会自动被关闭。当用户进入支付宝收银台页面（不包括登录页面），会触发即刻创建支付宝交易，此时开始计时。取值范围：1m～15d。m-分钟，h-小时，d-天，1c-当天（1c-当天的情况下，无论交易何时创建，都在0点关闭）。 该参数数值不接受小数点， 如 1.5h，可转换为 90m。
         */
        public static String timeout_express = "timeout_express";
        /**
         * 订单总金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000]
         */
        public static String total_amount = "total_amount";
        /**
         * 收款支付宝用户ID。 如果该值为空，则默认为商户签约账号对应的支付宝用户ID
         */
        public static String seller_id = "seller_id";
        /**
         * 销售产品码，商家和支付宝签约的产品码，为固定值QUICK_MSECURITY_PAY
         */
        public static String product_code = "product_code";
        /**
         * 商品主类型：0—虚拟类商品，1—实物类商品
         * 注：虚拟类商品不支持使用花呗渠道
         */
        public static String goods_type = "goods_type";
        /**
         * 公用回传参数，如果请求时传递了该参数，则返回给商户时会回传该参数。支付宝会在异步通知时将该参数原样返回。本参数必须进行UrlEncode之后才可以发送给支付宝
         */
        public static String passback_param = "passback_param";
        /**
         * 优惠参数
         * 注：仅与支付宝协商后可用
         */
        public static String promo_params = "promo_params";
        /**
         * 业务扩展参数，详见下面的“业务扩展参数说明”
         */
        public static String extend_params = "extend_params";
        /**
         * 可用渠道，用户只能在指定渠道范围内支付
         * 当有多个渠道时用“,”分隔
         * 注：与disable_pay_channels互斥
         */
        public static String enable_pay_channels = "enable_pay_channels";
        /**
         * 禁用渠道，用户不可用指定渠道支付
         * 当有多个渠道时用“,”分隔
         * 注：与enable_pay_channels互斥
         */
        public static String disable_pay_cha = "disable_pay_cha";
        /**
         * 商户门店编号
         */
        public static String store_id = "store_id";

        /**
         * 是否发起实名校验
         */
        public static String needBuyerRealnamed = "needBuyerRealnamed";

        /**
         * 账务备注
         * 注：该字段显示在离线账单的账务备注中
         */
        public static String TRANS_MEMO = "TRANS_MEMO";
    }


    public String getApp_id() {
        return app_id;
    }

    public AliQueryBuilder setApp_id(String app_id) {
        this.app_id = app_id;
        return this;
    }

    public String getMethod() {
        return method;
    }

    public AliQueryBuilder setMethod(String method) {
        this.method = method;
        return this;
    }

    public String getFormat() {
        return format;
    }

    public AliQueryBuilder setFormat(String format) {
        this.format = format;
        return this;
    }

    public String getCharset() {
        return charset;
    }

    public AliQueryBuilder setCharset(String charset) {
        this.charset = charset;
        return this;
    }

    public String getSign_type() {
        return sign_type;
    }

    public AliQueryBuilder setSign_type(String sign_type) {
        this.sign_type = sign_type;
        return this;
    }

    public String getSign() {
        return sign;
    }

    public AliQueryBuilder setSign(String sign) {
        this.sign = sign;
        return this;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public AliQueryBuilder setTimestamp(String timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public String getVersion() {
        return version;
    }

    public AliQueryBuilder setVersion(String version) {
        this.version = version;
        return this;
    }

    public String getNotify_url() {
        return notify_url;
    }

    public AliQueryBuilder setNotify_url(String notify_url) {
        this.notify_url = notify_url;
        return this;
    }

    public AliQueryBuilder setBiz_content(String biz_content) {
        this.biz_content = biz_content;
        return this;
    }

    public String getBiz_content() {
        return biz_content;
    }

    public Content startContent() {
        if (null == content)
            content = new Content();
        return content;
    }

    public Content getContent() {
        return content;
    }

    public AliQueryBuilder setContent(Content content) {
        this.content = content;
        return this;
    }

    @Override
    public String toString() {
        return "app_id=" + app_id +
                "&method=" + method +
                "&format=" + format +
                "&charset=" + charset +
                "&sign_type=" + sign_type +
                "&sign=" + sign +
                "&timestamp=" + timestamp +
                "&version=" + version +
                "&notify_url=" + notify_url +
                "&biz_content=" + biz_content;
    }
}
