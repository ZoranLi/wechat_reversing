package com.tencent.wecall.talkroom.model;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.pb.common.c.d;
import com.tencent.pb.common.c.e;
import com.tencent.pb.common.c.i;
import java.util.ArrayList;

public class h {
    static final String TAG = h.class.getCanonicalName();
    public static h xlq = new h();
    String deviceModel;
    public String groupId = "";
    public int mNL = 0;
    public long mNM = 0;
    public int mOs = -1;
    long mPi = 0;
    int mPj = 0;
    public int netType = -1;
    public int rjW = 1;
    public int rkd = 0;
    public int rkk = -1;
    int rrM = 0;
    int rrP = 0;
    int rrT = 0;
    long rrU = 0;
    int rrZ = 0;
    public int rsa = 0;
    String rsf = "";
    public String wLG = "";
    int xlA = -1;
    String xlB;
    int xlC;
    StringBuffer xlD = new StringBuffer();
    long xlE = 0;
    long xlF = 0;
    long xlG = 0;
    public int xlr = 0;
    int xls = 0;
    long xlt = 0;
    long xlu = 0;
    int xlv = 0;
    public int xlw = 0;
    int xlx = 0;
    long xly = 0;
    int xlz;

    public final String chL() {
        int i;
        d.d(TAG, "collectInfo");
        this.xlB = Build.MANUFACTURER;
        this.deviceModel = Build.MODEL;
        this.xlC = VERSION.SDK_INT;
        this.rsf = VERSION.RELEASE;
        this.netType = k.hL(e.rof);
        this.rrZ = 0;
        this.rsa = 0;
        this.xlz = -1;
        this.xlA = -1;
        Iterable arrayList = new ArrayList();
        arrayList.add(this.groupId);
        arrayList.add(this.wLG);
        arrayList.add(Integer.valueOf(this.rjW));
        arrayList.add(Integer.valueOf(this.mNL));
        arrayList.add(Long.valueOf(this.mNM));
        arrayList.add(Integer.valueOf(this.mOs));
        arrayList.add(Integer.valueOf(this.rrM));
        arrayList.add(Integer.valueOf(this.rrT));
        arrayList.add(Integer.valueOf(this.rrP));
        arrayList.add(Integer.valueOf(this.mPj));
        arrayList.add(Integer.valueOf(this.xlr));
        arrayList.add(Integer.valueOf(this.xls));
        arrayList.add(Long.valueOf(this.xlt));
        arrayList.add(Long.valueOf(this.xlu));
        arrayList.add(Integer.valueOf(this.xlv));
        arrayList.add(Integer.valueOf(this.xlw));
        arrayList.add(Integer.valueOf(this.xlx));
        arrayList.add(Long.valueOf(this.xly));
        arrayList.add(Long.valueOf(this.rrU));
        arrayList.add(Long.valueOf(this.mPi));
        arrayList.add(Integer.valueOf(this.rrZ));
        arrayList.add(Integer.valueOf(this.rsa));
        arrayList.add(Integer.valueOf(this.netType));
        arrayList.add(Integer.valueOf(this.xlz));
        arrayList.add(Integer.valueOf(this.xlA));
        arrayList.add(this.xlB);
        arrayList.add(this.deviceModel);
        arrayList.add(Integer.valueOf(this.xlC));
        arrayList.add(this.rsf);
        TalkRoom Wc = c.chs().Wc(this.groupId);
        if (Wc == null) {
            i = 0;
        } else {
            i = Wc.xjB.size();
            d.d("TalkRoomManager", "getGroupMemberSize groupid: ", r3, " size: ", Integer.valueOf(i));
        }
        arrayList.add(Integer.valueOf(i));
        arrayList.add(this.xlD.toString());
        arrayList.add(Integer.valueOf(this.rkk));
        arrayList.add(Integer.valueOf(this.rkd));
        String a = i.a(arrayList, ",", "_");
        d.d(TAG, "logBuf: ", this.xlD.toString());
        d.d(TAG, "statresult", a);
        return a;
    }

    public static void a(String str, int i, long j, String... strArr) {
        if (TextUtils.isEmpty(str)) {
            d.k(TAG, "uploadTempReport groupId is null");
            return;
        }
        d.k(TAG, "uploadTempReport: ", str, Integer.valueOf(i), Long.valueOf(j));
        h hVar = new h();
        if (str == null) {
            str = "";
        }
        hVar.groupId = str;
        hVar.mNL = i;
        hVar.mNM = j;
        hVar.N(strArr);
        Wk(hVar.chL());
    }

    public static void a(String str, String str2, int i, long j, String... strArr) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            d.k(TAG, "uploadTempReport groupId and clientGroupId is null");
            return;
        }
        d.k(TAG, "uploadTempReport: ", str, " clientGroupId: ", str2, " roomid: ", Integer.valueOf(i), Long.valueOf(j));
        h hVar = new h();
        if (str == null) {
            str = "";
        }
        hVar.groupId = str;
        hVar.mNL = i;
        hVar.mNM = j;
        if (str2 == null) {
            str2 = "";
        }
        hVar.wLG = str2;
        hVar.N(strArr);
        Wk(hVar.chL());
        com.tencent.pb.common.c.h.cdl();
    }

    public static void a(int i, long j, String... strArr) {
        h hVar = new h();
        hVar.groupId = "";
        hVar.mNL = i;
        hVar.mNM = j;
        hVar.wLG = "";
        hVar.N(strArr);
        Wk(hVar.chL());
        com.tencent.pb.common.c.h.cdl();
    }

    public final void N(String... strArr) {
        int i = 0;
        if (strArr != null && strArr.length != 0) {
            if (this.xlD.length() > 900) {
                this.xlD.setLength(0);
                this.xlD.append("overmaxsize");
            }
            if (this.xlD.length() != 0) {
                this.xlD.append("-");
            }
            int length = strArr.length;
            while (i < length) {
                this.xlD.append(strArr[i]);
                this.xlD.append("|");
                i++;
            }
        }
    }

    public final void chM() {
        this.xlE = System.currentTimeMillis();
        d.d(TAG, "beginCreateOrEnter", Long.valueOf(this.xlE));
    }

    public final void chN() {
        d.k(TAG, "beginCreateOrNotify");
        this.xlF = System.currentTimeMillis();
    }

    public static void Eg(int i) {
        d.d(TAG, "sendNetSceneStat", Integer.valueOf(i));
        com.tencent.pb.common.c.h.w(527, 3, String.valueOf(i));
    }

    public static void Eh(int i) {
        d.d(TAG, "sendDeviceStat", Integer.valueOf(i));
        com.tencent.pb.common.c.h.w(528, 3, String.valueOf(i));
    }

    public static void Ei(int i) {
        d.d(TAG, "sendtalkRoomDialStat", Integer.valueOf(i));
        com.tencent.pb.common.c.h.w(530, 3, String.valueOf(i));
    }

    public static void chO() {
        d.d(TAG, "sendTalkRoomOnDialStat", Integer.valueOf(-5001));
        com.tencent.pb.common.c.h.w(531, 3, "-5001");
    }

    public static void Ej(int i) {
        d.d(TAG, "sendEngineStat", Integer.valueOf(i));
        com.tencent.pb.common.c.h.w(529, 3, String.valueOf(i));
    }

    public static void Wk(String str) {
        d.d(TAG, "sendSummaryNetScene", str);
        com.tencent.pb.common.c.h.w(532, 3, str);
    }

    public static void Wl(String str) {
        d.d(TAG, "sendEngineRecv", str);
        com.tencent.pb.common.c.h.w(533, 3, str);
    }

    public static void Wm(String str) {
        d.d(TAG, "sendEngineSend", str);
        com.tencent.pb.common.c.h.w(534, 3, str);
    }

    public static void Wn(String str) {
        d.d(TAG, "sendChannelStat", str);
        com.tencent.pb.common.c.h.w(535, 3, str);
    }

    public final void Ek(int i) {
        d.d(TAG, "stopStatus", Integer.valueOf(i));
        this.rrM = i;
    }
}
