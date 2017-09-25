package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.net.NetworkInfo.State;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mm.R;
import com.tencent.mm.plugin.freewifi.d.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.g.b;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

@Deprecated
public class FreeWifiActivateAuthStateUI extends FreeWifiActivateStateUI {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.cGa != 2) {
            d.a(this.ssid, 1, getIntent());
        }
        w.i("MicroMsg.FreeWifi.FreeWifiActivateAuthStateUI", "now it is from qrcode, try to auth");
    }

    protected final void KC() {
        super.KC();
        this.lVv = (Button) findViewById(R.h.bWi);
        this.lVv.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FreeWifiActivateAuthStateUI lVn;

            {
                this.lVn = r1;
            }

            public final void onClick(View view) {
                String string = this.lVn.getString(R.l.emy);
                Intent intent = new Intent();
                intent.putExtra("rawUrl", string);
                intent.putExtra("showShare", false);
                intent.putExtra("show_bottom", false);
                com.tencent.mm.bb.d.b(this.lVn, "webview", ".ui.tools.WebViewUI", intent);
            }
        });
        zi(R.l.emO);
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public final void a(State state) {
        w.i("MicroMsg.FreeWifi.FreeWifiActivateAuthStateUI", "now network state : %s", new Object[]{state.toString()});
        if (state == State.CONNECTED && d.wG(this.ssid)) {
            axl();
            axn();
        }
    }

    protected final void Tq() {
        j.awH().a(this.ssid, new b(this) {
            final /* synthetic */ FreeWifiActivateAuthStateUI lVn;

            {
                this.lVn = r1;
            }

            public final void aV(String str, int i) {
                w.i("MicroMsg.FreeWifi.FreeWifiActivateAuthStateUI", "get ap auth data : %s, url : %s, mac : %s", new Object[]{str, this.lVn.lUe, d.awr()});
                if (!bg.mA(str)) {
                    String str2 = str;
                    new a(this.lVn.lUe, this.lVn.ssid, r3, this.lVn.lVw, str2, "", i, m.y(this.lVn.getIntent())).b(new e(this) {
                        final /* synthetic */ AnonymousClass2 lVo;

                        {
                            this.lVo = r1;
                        }

                        public final void a(int i, int i2, String str, k kVar) {
                            w.i("MicroMsg.FreeWifi.FreeWifiActivateAuthStateUI", "errType : %d, errCode : %d, errMsg : %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                            this.lVo.lVn.lVy = false;
                            if (i == 0 && i2 == 0) {
                                w.i("MicroMsg.FreeWifi.FreeWifiActivateAuthStateUI", "authUrl : %s", new Object[]{((a) kVar).awK()});
                                j.awH().a(this.lVo.lVn.ssid, r0, this.lVo.lVn.getIntent());
                            } else if (i2 == -2014) {
                                d.a(this.lVo.lVn.ssid, -2014, this.lVo.lVn.getIntent());
                            } else {
                                d.a(this.lVo.lVn.ssid, 3, this.lVo.lVn.getIntent());
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
