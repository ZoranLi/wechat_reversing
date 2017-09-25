package com.tencent.mm.plugin.freewifi.ui;

import android.net.NetworkInfo.State;
import com.tencent.mm.R;
import com.tencent.mm.plugin.freewifi.d.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

@Deprecated
public class FreewifiActivateWeChatNoAuthStateUI extends FreeWifiActivateNoAuthStateUI {
    private int fIx;
    private String lXN;
    private String lXO;

    protected final String axi() {
        return getString(R.l.emO);
    }

    public final void a(State state) {
        w.i("MicroMsg.FreeWifi.FreewifiActivateWeChatNoAuthStateUI", "now network state : %s", new Object[]{state.toString()});
        if (state == State.CONNECTED && d.wG(this.ssid) && this.lVy) {
            axl();
            this.lVy = false;
            this.lXN = d.awr();
            this.lXO = d.awt();
            this.fIx = d.aws();
            w.i("MicroMsg.FreeWifi.FreewifiActivateWeChatNoAuthStateUI", "now has connect the ap, check from server rssi is :  %d, mac : %s, ssid is : %s", new Object[]{Integer.valueOf(this.fIx), this.lXN, this.lXO});
            new a(this.lUe, this.lXN, this.lXO, this.fIx, this.fuV, m.y(getIntent())).b(new e(this) {
                final /* synthetic */ FreewifiActivateWeChatNoAuthStateUI lXP;

                {
                    this.lXP = r1;
                }

                public final void a(int i, int i2, String str, k kVar) {
                    ap.vd().b(640, this);
                    w.i("MicroMsg.FreeWifi.FreewifiActivateWeChatNoAuthStateUI", "onSceneEnd, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                    if (i == 0 && i2 == 0) {
                        w.i("MicroMsg.FreeWifi.FreewifiActivateWeChatNoAuthStateUI", "check ap ok");
                        d.a(this.lXP.ssid, 2, this.lXP.getIntent());
                        return;
                    }
                    w.e("MicroMsg.FreeWifi.FreewifiActivateWeChatNoAuthStateUI", "check ap failed ： rssi is :  %d, mac : %s, ssid is : %s", new Object[]{Integer.valueOf(this.lXP.fIx), this.lXP.lXN, this.lXP.lXO});
                    this.lXP.lW(-2014);
                    d.wI(this.lXP.lXO);
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
        w.i("MicroMsg.FreeWifi.FreewifiActivateWeChatNoAuthStateUI", "get connect state = %d", new Object[]{Integer.valueOf(wF)});
        if (wF == 0) {
            return -2014;
        }
        return wF;
    }
}
