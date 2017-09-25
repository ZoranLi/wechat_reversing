package com.tencent.c.e;

import com.qq.taf.RequestPacket;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceUtil;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Set;

public final class i {
    static HashMap<String, byte[]> wSC = null;
    protected HashMap<String, byte[]> wSA = new HashMap();
    private HashMap<String, Object> wSB = new HashMap();
    protected String wSy = "UTF-8";
    protected RequestPacket wSz = new RequestPacket();

    public final void Vj(String str) {
        this.wSy = str;
    }

    public final void Vk(String str) {
        this.wSz.sServantName = str;
    }

    public final void Vl(String str) {
        this.wSz.sFuncName = str;
    }

    public final void cdN() {
        this.wSz.iRequestId = 3;
    }

    public final <T> void put(String str, T t) {
        if (str.startsWith(".") || t == null || (t instanceof Set)) {
            throw new IllegalArgumentException("wup put err");
        }
        JceOutputStream jceOutputStream = new JceOutputStream();
        jceOutputStream.setServerEncoding(this.wSy);
        jceOutputStream.write((Object) t, 0);
        this.wSA.put(str, JceUtil.getJceBufArray(jceOutputStream.getByteBuffer()));
    }

    public final byte[] nW() {
        if (this.wSz.sServantName == null) {
            this.wSz.sServantName = "";
        }
        if (this.wSz.sFuncName == null) {
            this.wSz.sFuncName = "";
        }
        JceOutputStream jceOutputStream = new JceOutputStream(0);
        jceOutputStream.setServerEncoding(this.wSy);
        jceOutputStream.write(this.wSA, 0);
        this.wSz.sBuffer = JceUtil.getJceBufArray(jceOutputStream.getByteBuffer());
        jceOutputStream = new JceOutputStream(0);
        jceOutputStream.setServerEncoding(this.wSy);
        this.wSz.writeTo(jceOutputStream);
        byte[] jceBufArray = JceUtil.getJceBufArray(jceOutputStream.getByteBuffer());
        int length = jceBufArray.length;
        ByteBuffer allocate = ByteBuffer.allocate(length + 4);
        allocate.putInt(length + 4).put(jceBufArray).flip();
        return allocate.array();
    }
}
