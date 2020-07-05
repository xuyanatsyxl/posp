package com.heatingpay.posp.service;

import lombok.extern.slf4j.Slf4j;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISOPackager;
import org.jpos.iso.ISOUtil;
import org.jpos.iso.channel.NACChannel;
import org.jpos.iso.packager.GenericPackager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
public class PospService {

    @Value("${unionpay.msgserver.ip}")
    private String msgHost;
    @Value("${unionpay.msgserver.port}")
    private int msgPort;
    @Value("${unionpay.tpdu}")
    private String tpdu;

    public String downloadTmk() throws IOException, ISOException {
        String licenseCode = "12142934264873";
        String serialNo = "12345678";
        ISOPackager p = new GenericPackager("classpath:message/tmkdown.xml");
        ISOMsg msg = new ISOMsg();
        msg.setMTI("0800");
        msg.set(20, licenseCode); // 授权码
        msg.set(25, "01");
        msg.set(41, "00000000");
        msg.set(42, "000000000000000");
//        msg.set(60, "99000000630");
//        msg.set(63, serialNo);

        NACChannel channel = new NACChannel(msgHost, msgPort, p, ISOUtil.hex2byte(tpdu));
        channel.connect();
        channel.send(msg);
        ISOMsg retMsg = channel.receive();

        return null;
    }
}
