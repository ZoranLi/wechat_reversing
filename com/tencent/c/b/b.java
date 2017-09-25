package com.tencent.c.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.Proxy;
import android.os.Build;
import com.tencent.c.c.a.a;
import com.tencent.c.c.a.c;
import com.tencent.c.e.d;
import com.tencent.c.e.i;
import com.tencent.mm.plugin.appbrand.jsapi.bh;

public final class b {
    private String mChannelId = null;
    private Context mContext = null;
    private String mVersionName = null;
    private int wQM = -1;
    private int wQN = -1;
    private String wQO = null;
    private c wQP = null;
    private a wQQ = null;

    public b(Context context) {
        this.mContext = context;
        com.tencent.c.a.a bu = com.tencent.c.e.a.bu(context, context.getPackageName());
        this.mVersionName = bu.versionName;
        this.wQN = bu.versionCode;
        this.wQM = 82;
        this.mChannelId = "105901";
        this.wQO = "C5FF2F9C793FB359";
    }

    public final byte[] a(com.tencent.c.c.b.a aVar) {
        byte[] bArr = null;
        try {
            i iVar = new i();
            iVar.cdN();
            iVar.Vk("viruscheck");
            iVar.Vl("RiskCheck");
            iVar.Vj("UTF-8");
            String str = "phonetype";
            if (this.wQQ == null) {
                this.wQQ = new a();
                this.wQQ.wQR = 2;
                this.wQQ.wQS = bh.CTRL_INDEX;
            }
            iVar.put(str, this.wQQ);
            iVar.put("userinfo", cdF());
            iVar.put("req", aVar);
            byte[] l = com.tencent.c.e.b.l(iVar.nW());
            if (l == null) {
                throw new RuntimeException("compress data fail");
            }
            bArr = com.tencent.c.e.c.j(l, com.tencent.c.e.c.cdL());
            return bArr;
        } catch (Exception e) {
        }
    }

    private c cdF() {
        int i;
        if (this.wQP == null) {
            this.wQP = new c();
            this.wQP.wRa = this.wQM;
            this.wQP.wRf = this.wQN;
            this.wQP.wQX = this.mChannelId;
            this.wQP.wQW = this.wQO;
            try {
                int i2;
                int i3;
                String[] split = this.mVersionName.trim().split("[\\.]");
                if (split == null || split.length < 3) {
                    i = 0;
                    i2 = 0;
                    i3 = 0;
                } else {
                    i3 = Integer.parseInt(split[0]);
                    i2 = Integer.parseInt(split[1]);
                    i = Integer.parseInt(split[2]);
                }
                this.wQP.wRb = new com.tencent.c.c.a.b();
                this.wQP.wRb.wQT = i3;
                this.wQP.wRb.wQU = i2;
                this.wQP.wRb.wQV = i;
            } catch (Exception e) {
            }
            this.wQP.wRc = 0;
            this.wQP.wRe = d.cdf();
            this.wQP.imei = Vb(d.fz(this.mContext));
            this.wQP.imsi = Vb(d.fA(this.mContext));
            this.wQP.wQY = Vb(Build.MODEL);
            this.wQP.qdX = Vb(d.fB(this.mContext));
            this.wQP.wRl = Vb(d.ma(true));
            this.wQP.wRm = Vb(d.ma(false));
            this.wQP.guid = null;
            this.wQP.wRd = 0;
        }
        c cVar = this.wQP;
        Context context = this.mContext;
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        i = (activeNetworkInfo == null || !(activeNetworkInfo.getState() == State.CONNECTING || activeNetworkInfo.getState() == State.CONNECTED)) ? d.a.wSu : activeNetworkInfo.getType() == 1 ? d.a.wSr : activeNetworkInfo.getType() == 0 ? (Proxy.getDefaultHost() == null && Proxy.getHost(context) == null) ? d.a.wSt : d.a.wSs : d.a.wSu;
        cVar.wQZ = i == d.a.wSr ? 2 : 1;
        return this.wQP;
    }

    private static String Vb(String str) {
        return str == null ? "" : str;
    }
}
