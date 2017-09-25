package com.tencent.pb.common.b;

import android.os.Handler;
import android.os.Looper;
import com.google.a.a.e;
import com.tencent.pb.common.c.h;

public abstract class d implements c {
    private final long hts = 60000;
    Runnable htx = new Runnable(this) {
        final /* synthetic */ d wLb;

        {
            this.wLb = r1;
        }

        public final void run() {
            this.wLb.jUy = true;
            com.tencent.pb.common.c.d.d("MicroMsg.Voip", "NETTASK_RECV TimeOut cmd= ", this.wLb.ccP());
            h.w(20006, 3, "-1104");
            if (this.wLb.wKW != null) {
                this.wLb.wKW.a(2, -1, "time exceed, force to callback", this.wLb);
            }
        }
    };
    private int jUO = -999;
    public boolean jUy = false;
    Handler mHandler = new Handler(Looper.getMainLooper());
    public int mlJ = 2;
    public boolean wKU = false;
    public final String wKV = getClass().getSimpleName();
    public b wKW = null;
    public byte[] wKX = null;
    public Object wKY = null;
    public int wKZ;
    public int wLa = 0;

    public abstract Object bs(byte[] bArr);

    public abstract String ccP();

    public abstract int getType();

    public final void n(final int i, byte[] bArr) {
        int i2 = 2;
        com.tencent.pb.common.c.d.d("MicroMsg.Voip", this.wKV, "onResp errcode", Integer.valueOf(i));
        this.mHandler.removeCallbacks(this.htx);
        com.tencent.pb.common.c.d.d("MicroMsg.Voip", "NETTASK_RECV onResp:cmd= ", ccP(), Integer.valueOf(i), Boolean.valueOf(this.jUy));
        if (i != 0) {
            com.tencent.pb.common.c.d.k("MicroMsg.Voip", this.wKV, "getNetworkErrType errcode:" + i);
            if (i != -1) {
                i2 = i == 6801 ? 10 : 4;
            } else if (h.isNetworkConnected()) {
                i2 = 1;
            }
        } else {
            i2 = 0;
        }
        if (this.jUy) {
            com.tencent.pb.common.c.d.d("MicroMsg.Voip", "onResp netscene already canceled, cmd:" + this.wKZ);
            return;
        }
        if (this.wKU) {
            "".length();
        }
        this.jUO = i;
        this.wKY = bs(bArr);
        this.mHandler.post(new Runnable(this) {
            final /* synthetic */ d wLb;

            public final void run() {
                if (this.wLb.jUy) {
                    com.tencent.pb.common.c.d.d("MicroMsg.Voip", this.wLb.wKV, "onResp netscene already canceled, cmd:" + this.wLb.wKZ);
                } else if (this.wLb.wKW != null) {
                    this.wLb.wKW.a(i2, i, "", this.wLb);
                }
            }
        });
    }

    public final void c(int i, e eVar) {
        this.wKZ = i;
        byte[] bArr = null;
        try {
            bArr = e.b(eVar);
        } catch (Exception e) {
        }
        this.wKX = bArr;
    }
}
