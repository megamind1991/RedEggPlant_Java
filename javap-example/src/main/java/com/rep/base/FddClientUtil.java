package com.rep.base;

import com.fadada.sdk.client.FddClientBase;

/**
 * 法大大基础接口工具类 <Description> <br>
 * 
 * @author liuzx<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018年11月24日 <br>
 * @since V1.0<br>
 * @see com.hbasesoft.vcc.sgp.uum.org.client <br>
 */
public class FddClientUtil {

    /**
     *
     */
    private static final String APP_ID = "001105";

    /**
     *
     */
    private static final String APP_SECRET = "q2wNoxDKnc4CWDSLFC8UhyYH";

    /**
     *
     */
    private static final String VERSION = "2.0";

    /**
     *
     */
    private static final String URL = "https://extapi.fadada.com/api2/";

    /**
     *
     */
    private static final String COMPANY_URL = "https://partner.fadada.com/api/syncCompany.api";


    //    fdd:
//    app_id: "001105"
//    app_secret: q2wNoxDKnc4CWDSLFC8UhyYH
//    version: 2.0
//    app_url: https://extapi.fadada.com/api2/
//    app_company_ca_url: https://partner.fadada.com/api/syncCompany.api

    /** */
    private static FddClientBase client = null;

    /** */
    private static FddClientBase companyClient = null;

    /**
     * 法大大基础接口，用于企业上传合同模板 Description: <br>
     * 
     * @author liuzx<br>
     * @taskId <br>
     * @return FddClientBase <br>
     */
    public static FddClientBase getClient() {
        if (client == null) {
            client = new FddClientBase(APP_ID, APP_SECRET, VERSION, URL);
        }
        return client;
    }

    /**
     * 法大大基础接口，用于拼接企业认证URL Description: <br>
     * 
     * @author liuzx<br>
     * @taskId <br>
     * @return FddClientBase <br>
     */
    public static FddClientBase getCompanyClient() {
        if (companyClient == null) {
            companyClient = new FddClientBase(APP_ID, APP_SECRET, VERSION, COMPANY_URL);
        }
        return companyClient;
    }
}
