package com.tencent.mm.plugin.freewifi.ui;

import android.net.NetworkInfo.State;
import com.tencent.mm.R;
import com.tencent.mm.plugin.freewifi.d.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.c.dy;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

@Deprecated
public class FreewifiWeChatNoAuthStateUI extends FreeWifiNoAuthStateUI {
    private int fIx;
    private String lXN;
    private String lXO;

    protected final String axi() {
        return getString(R.l.emO);
    }

    public final void a(State state) {
        w.i("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "now network state : %s", new Object[]{state.toString()});
        if (state == State.CONNECTED && d.wG(this.ssid) && this.lVy) {
            axl();
            this.lVy = false;
            this.lXN = d.awr();
            this.lXO = d.awt();
            this.fIx = d.aws();
            w.i("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "now has connect the ap, check from server rssi is :  %d, mac : %s, ssid is : %s", new Object[]{Integer.valueOf(this.fIx), this.lXN, this.lXO});
            new a(this.lUe, this.lXN, this.lXO, this.fIx, this.fuV, m.y(getIntent())).b(new e(this) {
                final /* synthetic */ FreewifiWeChatNoAuthStateUI lXQ;

                {
                    this.lXQ = r1;
                }

                public final void a(int i, int i2, String str, k kVar) {
                    ap.vd().b(640, this);
                    w.i("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "onSceneEnd, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                    if (i == 0 && i2 == 0) {
                        w.i("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "check ap ok");
                        dy awQ = ((a) kVar).awQ();
                        if (awQ != null) {
                            w.i("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s", new Object[]{awQ.teQ, awQ.jOp, awQ.jNj, Integer.valueOf(awQ.thK), awQ.thL, awQ.hAG});
                            this.lXQ.fTO = awQ.teQ;
                            this.lXQ.lUg = awQ.jOp;
                            this.lXQ.fKK = awQ.jNj;
                            this.lXQ.lXu = awQ.thK;
                            this.lXQ.lXv = awQ.thL;
                            this.lXQ.signature = awQ.hAG;
                            this.lXQ.lXw = awQ.thM;
                        }
                        d.a(this.lXQ.ssid, 2, this.lXQ.getIntent());
                        return;
                    }
                    w.e("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "check ap failed ： rssi is :  %d, mac : %s, ssid is : %s", new Object[]{Integer.valueOf(this.lXQ.fIx), this.lXQ.lXN, this.lXQ.lXO});
                    d.a(this.lXQ.ssid, -2014, this.lXQ.getIntent());
                    d.wI(this.lXQ.lXO);
                }
            });
        }
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected final int axh() {
        j.awB();
        int wF = d.wF(this.ssid);
        w.i("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "get connect state = %d", new Object[]{Integer.valueOf(wF)});
        if (wF == 0) {
            return -2014;
        }
        return wF;
    }
}
