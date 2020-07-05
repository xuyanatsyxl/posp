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

    public String downloadTmk() {
        String licenseCode = ;
        String serialNoString;

        return null;
    }
}
