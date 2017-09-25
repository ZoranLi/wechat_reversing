package com.tencent.mm.plugin.ipcall.a.a;

import com.tencent.mm.bd.b;
import com.tencent.mm.protocal.c.ark;
import java.util.Iterator;
import java.util.LinkedList;

public final class c {
    public String fFa;
    public String fVb;
    public String fWT;
    public LinkedList<ark> jEB = new LinkedList();
    public int leR;
    public String leS;
    public int mNL;
    public long mNM;
    public long mNN;
    public int mNO;
    public int mNP;
    public int mNQ;
    public int mNR;
    public String mNS;
    public int mNT;
    public int mNU;
    public int mNV;
    public int mNW;
    public int mNX;
    public boolean mNY = false;
    public boolean mNZ = false;
    public boolean mOa = false;
    public boolean mOb = true;
    public int mOc = 0;
    public int mOd;
    public int mOe;
    public int mOf;
    public b mOg;
    public int mOh;
    public int mOi;
    public b mOj;
    public LinkedList<ark> mOk = new LinkedList();
    public int mOl = 999;
    public LinkedList<d> mOm = new LinkedList();
    public String mOn;
    public String mOo;
    public String mOp;
    public int mOq;
    public boolean mOr = false;

    public final int aEx() {
        if (this.mOm == null || this.mOm.size() <= 0) {
            return this.mNU;
        }
        return ((d) this.mOm.get(0)).mNU;
    }

    public final int aEy() {
        if (this.mOm == null || this.mOm.size() <= 0) {
            return this.mNV;
        }
        return ((d) this.mOm.get(0)).gXk;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append("IPCallInfo: ");
        stringBuilder.append(String.format("[roomId: %d, roomKey: %d, callSeq: %d, inviteId: %d, roomMemberId: %d, syncKey: %d, syncInterval: %d, currentStatus: %d, ErrMsg: %s, ErrCode：%d, ErrLevel：%d]\n", new Object[]{Integer.valueOf(this.mNL), Long.valueOf(this.mNM), Long.valueOf(this.mNN), Integer.valueOf(this.mNO), Integer.valueOf(this.mNT), Integer.valueOf(this.mNU), Integer.valueOf(this.mNW), Integer.valueOf(this.mNV), this.leS, Integer.valueOf(this.leR), Integer.valueOf(this.mNR)}));
        stringBuilder.append(String.format("[toUsername: %s, toPhoneNumber: %s]\n", new Object[]{this.fVb, this.mOo}));
        stringBuilder.append("[addrList: ");
        Iterator it = this.jEB.iterator();
        while (it.hasNext()) {
            ark com_tencent_mm_protocal_c_ark = (ark) it.next();
            stringBuilder.append(String.format("{IP: %s, port: %d}", new Object[]{com_tencent_mm_protocal_c_ark.tNy, Integer.valueOf(com_tencent_mm_protocal_c_ark.tVV)}));
        }
        stringBuilder.append("]");
        stringBuilder.append("\n");
        if (this.mOm == null || this.mOm.size() <= 0) {
            stringBuilder.append("userInfoList is empty");
        } else {
            stringBuilder.append("[userInfoList: ");
            it = this.mOm.iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                stringBuilder.append("{");
                stringBuilder.append(dVar.toString());
                stringBuilder.append("}");
            }
            stringBuilder.append("]");
        }
        return stringBuilder.toString();
    }
}
