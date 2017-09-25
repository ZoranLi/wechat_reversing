package com.tencent.mm.plugin.voip_cs.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mm.compatible.d.l;
import com.tencent.mm.protocal.c.bkm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class c {
    public static int rrr = 0;
    public static int rrs = 1;
    public static int rrt = 2;
    public int aMw;
    public int channelStrategy;
    public String deviceModel;
    public long mNM;
    public long mPk;
    public String mPt;
    public String mPu;
    public int networkType;
    public int qXE;
    public int rjJ;
    public int rjW;
    public int rkb;
    public int rkc;
    public int rkd;
    public int rln;
    public int rrA;
    public int rrB;
    public int rrC;
    public int rrD;
    public int rrE;
    public int rrF;
    public int rrG;
    public long rrH;
    public String rrI;
    public int rrJ;
    public int rrK;
    public int rrL;
    public int rrM;
    public int rrN;
    public int rrO;
    public int rrP;
    public int rrQ;
    public int rrR;
    public int rrS;
    public int rrT;
    public long rrU;
    public int rrV;
    public long rrW;
    public long rrX;
    public long rrY;
    public int rrZ;
    public int rru;
    public int rrv;
    public int rrw;
    public int rrx;
    public int rry;
    public int rrz;
    public int rsa;
    public int rsb;
    public int rsc;
    public String rsd;
    public String rse;
    public String rsf;
    public int rsg;
    public int rsh;
    public int rsi;
    public int rsj;
    public int rsk;
    public int rsl;

    public c() {
        this.aMw = 0;
        this.rru = 0;
        this.rrv = 0;
        this.rrw = 0;
        this.rrx = 0;
        this.rry = 0;
        this.rrz = 0;
        this.rrA = 0;
        this.rrB = 0;
        this.rrC = 0;
        this.rrD = 0;
        this.networkType = 0;
        this.rrE = 0;
        this.rrG = 0;
        this.rjW = 0;
        this.rrH = 0;
        this.mNM = 0;
        this.rrI = "";
        this.rjJ = 0;
        this.rrK = 0;
        this.rrL = 0;
        this.rrM = 0;
        this.rrN = 0;
        this.rkc = 0;
        this.rkb = 0;
        this.rrO = 0;
        this.rrP = 1;
        this.rrQ = 0;
        this.rrR = 0;
        this.rrS = 0;
        this.rrT = 0;
        this.rrU = 0;
        this.rrW = 0;
        this.rrX = 0;
        this.rrY = 0;
        this.mPk = 0;
        this.channelStrategy = 1;
        this.rln = 0;
        this.rkd = 0;
        this.rsb = -1;
        this.rsc = 0;
        this.rsd = "";
        this.deviceModel = "";
        this.rse = "";
        this.rsf = "";
        this.rsg = 0;
        this.rsh = 0;
        this.rsi = 0;
        this.rsj = 0;
        this.rsk = 0;
        this.rsl = 0;
        this.qXE = l.rl();
        this.mPu = "";
        this.mPt = "";
        this.rsd = Build.MANUFACTURER;
        if (this.rsd.contains(",")) {
            this.rsd = this.rsd.replace(',', ' ');
        }
        this.deviceModel = Build.MODEL;
        if (this.deviceModel.contains(",")) {
            this.deviceModel = this.deviceModel.replace(',', ' ');
        }
        this.rse = VERSION.SDK;
        if (this.rse.contains(",")) {
            this.rse = this.rse.replace(',', ' ');
        }
        this.rsf = VERSION.RELEASE;
        if (this.rsf.contains(",")) {
            this.rsf = this.rsf.replace(',', ' ');
        }
    }

    public final void vo(int i) {
        this.rkb = Math.abs(i);
    }

    public final void brQ() {
        w.d("MicroMsg.VoipCSReportHelper", "markEndTalk");
        if (this.rsk == 0 && this.rsj != 0) {
            this.rsk = (int) (System.currentTimeMillis() / 1000);
            this.mPk = (long) (this.rsk - this.rsj);
        }
    }

    public final bkm brR() {
        bkm com_tencent_mm_protocal_c_bkm = new bkm();
        com_tencent_mm_protocal_c_bkm.jOc = 2;
        com_tencent_mm_protocal_c_bkm.ukg = this.mPt;
        w.i("MicroMsg.VoipCSReportHelper", "getVoipCSEngineReportData, result: %s", new Object[]{com_tencent_mm_protocal_c_bkm.ukg});
        String[] split = this.mPt.split(",");
        if (split != null && split.length > 0) {
            try {
                this.rrx = bg.getInt(split[8], 0);
                this.rry = bg.getInt(split[10], 0);
            } catch (Exception e) {
                w.e("MicroMsg.VoipCSReportHelper", "get videoFps and rate fail!!");
            }
        }
        return com_tencent_mm_protocal_c_bkm;
    }

    public static int brS() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) ab.getContext().getSystemService("connectivity");
            if (connectivityManager != null) {
                NetworkInfo networkInfo = connectivityManager.getNetworkInfo(0);
                if (networkInfo == null) {
                    return rrr;
                }
                if (networkInfo.getState() == State.CONNECTED) {
                    return rrs;
                }
                return rrt;
            }
        } catch (Exception e) {
            w.e("MicroMsg.VoipCSReportHelper", "isMobileNetworkAvailable fail!");
        }
        return rrr;
    }

    public static int getNetType(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return 0;
            }
            if (activeNetworkInfo.getType() == 1) {
                return 1;
            }
            if (activeNetworkInfo.getType() != 0) {
                return 0;
            }
            if (activeNetworkInfo.getSubtype() == 1) {
                return 2;
            }
            if (activeNetworkInfo.getSubtype() == 2) {
                return 2;
            }
            if (activeNetworkInfo.getSubtype() == 13) {
                return 4;
            }
            if ((activeNetworkInfo.getSubtype() < 3 || activeNetworkInfo.getSubtype() >= 13) && activeNetworkInfo.getSubtype() <= 13) {
                return 2;
            }
            return 3;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.VoipCSReportHelper", e, "", new Object[0]);
            return 0;
        }
    }
}
