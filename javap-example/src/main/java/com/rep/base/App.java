package com.rep.base;

import java.util.Date;

import com.fadada.sdk.client.FddClientBase;
import com.fadada.sdk.util.crypt.FddEncryptTool;
import com.fadada.sdk.util.http.HttpsUtil;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        String timeStamp = String.valueOf(new Date().getTime());
        FddClientBase fddClient = FddClientUtil.getCompanyClient();
        StringBuilder sb = new StringBuilder(fddClient.getUrl());
        try {
            String appSecret = fddClient.getSecret();
            String ctripUserId = FddEncryptTool.encrypt("91440608748008424R", appSecret); // 填写企业信用社会编码
            String identNo = FddEncryptTool.encrypt("91440608748008424R", appSecret); // 填写企业信用社会编码
            String name = FddEncryptTool.encrypt("佛山市高明燃气有限公司", appSecret);
            String sha1 = FddEncryptTool
                    .sha1(fddClient.getAppId() + FddEncryptTool.md5Digest(ctripUserId + timeStamp)
                            + FddEncryptTool.sha1(fddClient.getSecret() + identNo + name));

            String e = new String(FddEncryptTool.Base64Encode(sha1.getBytes()));
            sb.append("?app_id=").append(fddClient.getAppId());
            sb.append("&timestamp=").append(timeStamp);
            sb.append("&v=").append(fddClient.getVersion());
            sb.append("&ctrip_user_id=").append(ctripUserId);
            sb.append("&name=").append(name);
            sb.append("&ident_no=").append(identNo);
            sb.append("&msg_digest=").append(e);

            System.out.println(sb);
        }
        catch (Exception arg11) {
            arg11.printStackTrace();
            throw new RuntimeException(arg11);
        }
    }

}
