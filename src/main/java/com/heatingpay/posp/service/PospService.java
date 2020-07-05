package com.heatingpay.posp.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PospService {

    @Value("${unionpay.msgserver.ip}")
    private String msgHost;
    @Value("${unionpay.msgserver.port}")
    private int msgPort;
    @Value("${unionpay.tpdu}")
    private String tpdu;


    /**
     * 下载商户的终端主密钥（TMK)
     *
     * @param licenseCode 授权码
     * @param serialNo 终端序列号
     * @return
     */
    public String downloadTmk(String licenseCode, String serialNo) {
        return null;
    }
}
