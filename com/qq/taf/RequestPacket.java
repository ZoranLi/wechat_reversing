package com.qq.taf;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.util.HashMap;
import java.util.Map;

public final class RequestPacket extends JceStruct {
    static final /* synthetic */ boolean $assertionsDisabled;
    static Map<String, String> cache_context = null;
    static byte[] cache_sBuffer = null;
    public byte cPacketType = (byte) 0;
    public Map<String, String> context;
    public int iMessageType = 0;
    public int iRequestId = 0;
    public int iTimeout = 0;
    public short iVersion = (short) 0;
    public byte[] sBuffer;
    public String sFuncName = null;
    public String sServantName = null;
    public Map<String, String> status;

    static {
        boolean z;
        if (RequestPacket.class.desiredAssertionStatus()) {
            z = false;
        } else {
            z = true;
        }
        $assertionsDisabled = z;
    }

    public RequestPacket(short s, byte b, int i, int i2, String str, String str2, byte[] bArr, int i3, Map<String, String> map, Map<String, String> map2) {
        this.iVersion = s;
        this.cPacketType = b;
        this.iMessageType = i;
        this.iRequestId = i2;
        this.sServantName = str;
        this.sFuncName = str2;
        this.sBuffer = bArr;
        this.iTimeout = i3;
        this.context = map;
        this.status = map2;
    }

    public final boolean equals(Object obj) {
        RequestPacket requestPacket = (RequestPacket) obj;
        if (JceUtil.equals(1, requestPacket.iVersion) && JceUtil.equals(1, requestPacket.cPacketType) && JceUtil.equals(1, requestPacket.iMessageType) && JceUtil.equals(1, requestPacket.iRequestId) && JceUtil.equals(Integer.valueOf(1), requestPacket.sServantName) && JceUtil.equals(Integer.valueOf(1), requestPacket.sFuncName) && JceUtil.equals(Integer.valueOf(1), requestPacket.sBuffer) && JceUtil.equals(1, requestPacket.iTimeout) && JceUtil.equals(Integer.valueOf(1), requestPacket.context) && JceUtil.equals(Integer.valueOf(1), requestPacket.status)) {
            return true;
        }
        return false;
    }

    public final Object clone() {
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {
            if (!$assertionsDisabled) {
                throw new AssertionError();
            }
        }
        return obj;
    }

    public final void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iVersion, 1);
        jceOutputStream.write(this.cPacketType, 2);
        jceOutputStream.write(this.iMessageType, 3);
        jceOutputStream.write(this.iRequestId, 4);
        jceOutputStream.write(this.sServantName, 5);
        jceOutputStream.write(this.sFuncName, 6);
        jceOutputStream.write(this.sBuffer, 7);
        jceOutputStream.write(this.iTimeout, 8);
        jceOutputStream.write(this.context, 9);
        jceOutputStream.write(this.status, 10);
    }

    public final void readFrom(JceInputStream jceInputStream) {
        try {
            Map hashMap;
            this.iVersion = jceInputStream.read(this.iVersion, 1, true);
            this.cPacketType = jceInputStream.read(this.cPacketType, 2, true);
            this.iMessageType = jceInputStream.read(this.iMessageType, 3, true);
            this.iRequestId = jceInputStream.read(this.iRequestId, 4, true);
            this.sServantName = jceInputStream.readString(5, true);
            this.sFuncName = jceInputStream.readString(6, true);
            if (cache_sBuffer == null) {
                cache_sBuffer = new byte[1];
            }
            this.sBuffer = jceInputStream.read(cache_sBuffer, 7, true);
            this.iTimeout = jceInputStream.read(this.iTimeout, 8, true);
            if (cache_context == null) {
                hashMap = new HashMap();
                cache_context = hashMap;
                hashMap.put("", "");
            }
            this.context = (Map) jceInputStream.read(cache_context, 9, true);
            if (cache_context == null) {
                hashMap = new HashMap();
                cache_context = hashMap;
                hashMap.put("", "");
            }
            this.status = (Map) jceInputStream.read(cache_context, 10, true);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public final void display(StringBuilder stringBuilder, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(stringBuilder, i);
        jceDisplayer.display(this.iVersion, "iVersion");
        jceDisplayer.display(this.cPacketType, "cPacketType");
        jceDisplayer.display(this.iMessageType, "iMessageType");
        jceDisplayer.display(this.iRequestId, "iRequestId");
        jceDisplayer.display(this.sServantName, "sServantName");
        jceDisplayer.display(this.sFuncName, "sFuncName");
        jceDisplayer.display(this.sBuffer, "sBuffer");
        jceDisplayer.display(this.iTimeout, "iTimeout");
        jceDisplayer.display(this.context, "context");
        jceDisplayer.display(this.status, DownloadInfo.STATUS);
    }
}
