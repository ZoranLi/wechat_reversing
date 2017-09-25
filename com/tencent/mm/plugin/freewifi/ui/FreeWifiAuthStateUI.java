package com.tencent.mm.plugin.freewifi.ui;

import android.net.NetworkInfo.State;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.plugin.freewifi.d.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.g.b;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.c.dy;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

@Deprecated
public class FreeWifiAuthStateUI extends FreeWifiStateUI {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        d.a(this.ssid, 4, getIntent());
        w.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "now it is from qrcode, try to auth");
    }

    protected final void KC() {
        super.KC();
        zi(R.l.emO);
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public final void a(State state) {
        w.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "now network state : %s", new Object[]{state.toString()});
        if (state == State.CONNECTED && d.wG(this.ssid)) {
            axl();
            axn();
        }
    }

    protected final void Tq() {
        j.awH().a(this.ssid, new b(this) {
            final /* synthetic */ FreeWifiAuthStateUI lVF;

            {
                this.lVF = r1;
            }

            public final void aV(String str, int i) {
                w.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "get ap auth data : %s, url : %s, mac : %s", new Object[]{str, this.lVF.lUe, d.awr()});
                if (!bg.mA(str)) {
                    String str2 = str;
                    new a(this.lVF.lUe, this.lVF.ssid, r3, this.lVF.lVw, str2, "", i, m.y(this.lVF.getIntent())).b(new e(this) {
                        final /* synthetic */ AnonymousClass1 lVG;

                        {
                            this.lVG = r1;
                        }

                        public final void a(int i, int i2, String str, k kVar) {
                            w.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "errType : %d, errCode : %d, errMsg : %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                            this.lVG.lVF.lVy = false;
                            if (i == 0 && i2 == 0) {
                                a aVar = (a) kVar;
                                w.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "authUrl : %s", new Object[]{aVar.awK()});
                                dy awQ = aVar.awQ();
                                if (awQ != null) {
                                    w.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s", new Object[]{awQ.teQ, awQ.jOp, awQ.jNj, Integer.valueOf(awQ.thK), awQ.thL, awQ.hAG});
                                    this.lVG.lVF.fTO = awQ.teQ;
                                    this.lVG.lVF.lUg = awQ.jOp;
                                    this.lVG.lVF.fKK = awQ.jNj;
                                    this.lVG.lVF.lXu = awQ.thK;
                                    this.lVG.lVF.lXv = awQ.thL;
                                    this.lVG.lVF.signature = awQ.hAG;
                                    this.lVG.lVF.lXw = awQ.thM;
                                }
                                j.awH().a(this.lVG.lVF.ssid, r0, this.lVG.lVF.getIntent());
                            } else if (i2 == -2014) {
                                d.a(this.lVG.lVF.ssid, -2014, this.lVG.lVF.getIntent());
                            } else {
                                d.a(this.lVG.lVF.ssid, 3, this.lVG.lVF.getIntent());
                            }
                        }
                    });
                }
            }
        }, this.fuV, getIntent());
    }

    protected final void axg() {
        axk();
        d.wH(this.ssid);
    }

    protected final int axh() {
        j.awB();
        return d.wF(this.ssid);
    }
}
