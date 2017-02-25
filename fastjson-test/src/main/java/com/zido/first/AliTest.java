package com.zido.first;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static com.alipay.api.AlipayConstants.APP_ID;

/**
 * test.
 * Date: 2017/2/24 0024
 * Time: 9:33
 *
 * @author <a href="http://userwu.github.io">wuhongxu</a>.
 * @version 1.0.0
 */
public class AliTest {
    /**
     * 创建阿里订单信息
     *
     * @param orderInfo 订单详细信息,附加数据
     * @param orderId   订单id号码,可能重复
     * @param subject   订单支付提示信息
     * @param body      订单附加信息
     * @param price     订单价格
     * @return
     * @throws Exception
     */
    public final static String createAlipayInfo(String orderInfo, String orderId, String subject, String body, String price) throws Exception {
        //StringBuilder builder = new StringBuilder("service=\"mobile.securitypay.createOrder\"&payment_type=\"1\"&_input_charset=\"utf-8\"&it_b_pay=\"10m\"");

        final AliQueryBuilder ali = new AliQueryBuilder();
        ali.setApp_id(AlipayConfig.appId)
                .setMethod(AlipayConfig.Method.PAY)
                .setFormat("JSON")
                .setCharset("utf-8")
                .setSign_type("RSA2")
                .setTimestamp(DateUtil.formatDateTime(new Date()))
                .setVersion("1.0")
                .setNotify_url(AlipayConfig.NOTIFY_URL);
        /*
        * TODO 此参数尚未加上
        * builder.append("&order_attach=\"");
        * builder.append(orderInfo);//拼接商户个人订单信息
        * builder.append("\"");
        * */
        Map<String, String> bizContentMap = new HashMap<String, String>();
        bizContentMap.put(AliQueryBuilder.Content.body, body);
        bizContentMap.put(AliQueryBuilder.Content.subject, subject);
        bizContentMap.put(AliQueryBuilder.Content.out_trade_no, orderId);
        bizContentMap.put(AliQueryBuilder.Content.timeout_express, "90m");
        bizContentMap.put(AliQueryBuilder.Content.total_amount, price);
        bizContentMap.put(AliQueryBuilder.Content.seller_id, AlipayConfig.partner);
        bizContentMap.put(AliQueryBuilder.Content.product_code, "QUICK_MSECURITY_PAY");
        ali.setBiz_content(JSON.toJSON(bizContentMap).toString());
        //.setGoods_type("0") 商品类型
        //.setPassback_param("") 回传参数，可用于校验
        //签名
        String signStr = AlipaySignature.rsaSign(ali.getMap(), AlipayConfig.private_key, "utf-8");
//        RSA.sign(JSONObject.toJSON(ali).toString(), AlipayConfig.private_key, "utf-8");
        Map<String, String> queryMap = ali.encode();

        final Map<String, String> parMap = AlipayCore.paraFilter(queryMap);
        final Set<String> sets = parMap.keySet();
        for (String set : sets) {
            System.out.println(set);
        }
        String str = AlipayCore.createLinkString(parMap);
        str += "&sign="+ URLEncoder.encode(signStr,"UTF-8");

        System.out.println("------------------------------------------\n" +
                "------------" + str + "----------------\n" +
                "----------------------------------------\n");

        System.out.println(URLDecoder.decode("f63hirtW4G0NNF99AsQ%2BZ2ZPL3nRmgiz2ygwV6FPgy8TifDwyut9tpzS1nLmRYYWsKnK32bloH5%2BFGW%2Bw7k%2FlzcckDjcFSBVIm7%2BH1CVQVIgHVM48hwmWp4zt%2FjnVOBPT%2BUsFvp17rtS8d4GqiU8iK5xcZGlzI0xMq46uy4vZGRawBWakVTxQxBwsc906xX%2BuhtxwnZtimdfpYX5bYGizxki2CJYhlBcz54B%2Fm6Op%2B6b5%2FoZDHtnhuiLNhlxCamJ2fKM%2BxxFrN1E0%2BCTY2WUmMnJmTX2OG2zK32hTWiPGlunJPLpM94TRfijvaG4z%2FSenSDkTLPzNegZ0rshShrc%2Fw%3D%3D","UTF-8"));
        return str;


    }

    public static void main(String[] args) {
        try {
            AliTest.alipay("i-n-f-o",
                    "o-r-d-e-r-i-d",
                    "s-u-b-j-e-c-t",
                    "b-o-d-y",
                    "20");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String alipay(String orderInfo, String orderId, String subject, String body, String price) throws Exception {

        //实例化客户端
        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do", APP_ID, AlipayConfig.private_key, "json", "UTF-8", AlipayConfig.private_key, "RSA2");
        //实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
        AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
        //SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
        AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
        model.setBody(body);
        model.setSubject(subject);
        model.setOutTradeNo(orderId);
        model.setTimeoutExpress("30m");
        model.setTotalAmount(price);
        model.setProductCode("QUICK_MSECURITY_PAY");
        request.setBizModel(model);
        request.setNotifyUrl(AlipayConfig.NOTIFY_URL);
        request.setApiVersion("1.0");
        try {
            //这里和普通的接口调用不同，使用的是sdkExecute
            AlipayTradeAppPayResponse response = alipayClient.sdkExecute(request);
            System.out.println("---------------------");
            System.out.println(response.getBody()+"\n\n\n");//就是orderString 可以直接给客户端请求，无需再做处理。
            System.out.println(response.toString());
            return response.getBody();
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return null;
    }
}
