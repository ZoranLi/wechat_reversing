package com.tencent.mm.plugin.setting.ui.qrcode;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelsimple.aa;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.protocal.c.awr;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bb;
import com.tencent.mm.u.bb.a;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public class GetQRCodeInfoUI extends MMBaseActivity implements e {
    private ProgressDialog isv = null;
    private aa pik;

    static /* synthetic */ void a(GetQRCodeInfoUI getQRCodeInfoUI, String str) {
        if (!bg.mA(str)) {
            String str2 = "";
            if (str.startsWith("weixin://qr/")) {
                str2 = str.substring(12) + "@qr";
            } else if (str.startsWith("http://weixin.qq.com/r/")) {
                str2 = str.substring(23) + "@qr";
            }
            ap.vd().a(MMGIFException.D_GIF_ERR_NO_COLOR_MAP, getQRCodeInfoUI);
            getQRCodeInfoUI.pik = new aa(str2, 5);
            ap.vd().a(getQRCodeInfoUI.pik, 0);
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.i.empty);
        Uri data = getIntent().getData();
        if (data == null) {
            finish();
            return;
        }
        String mz = bg.mz(data.getHost());
        String mz2 = bg.mz(data.getScheme());
        if (("http".equals(mz2) && "weixin.qq.com".equals(mz)) || ("weixin".equals(mz2) && "qr".equals(mz))) {
            ap.vd().a(new bb(new a(this) {
                final /* synthetic */ GetQRCodeInfoUI pil;

                {
                    this.pil = r1;
                }

                public final void a(com.tencent.mm.network.e eVar) {
                    if (eVar == null) {
                        this.pil.finish();
                    } else if (!ap.zb() || ap.uP()) {
                        com.tencent.mm.plugin.setting.a.imv.t(new Intent(), this.pil);
                        this.pil.finish();
                    } else {
                        GetQRCodeInfoUI.a(this.pil, this.pil.getIntent().getDataString());
                    }
                }
            }), 0);
        } else {
            finish();
        }
    }

    public void onResume() {
        super.onResume();
        getString(R.l.dIO);
        this.isv = g.a(this, getString(R.l.dCL), true, new OnCancelListener(this) {
            final /* synthetic */ GetQRCodeInfoUI pil;

            {
                this.pil = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                this.pil.finish();
            }
        });
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.pik != null) {
            ap.vd().c(this.pik);
        }
        ap.vd().b(MMGIFException.D_GIF_ERR_NO_COLOR_MAP, this);
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.GetQRCodeInfoUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.isv != null) {
            this.isv.dismiss();
            this.isv = null;
        }
        if (i == 4 && i2 == -2004) {
            g.a(this, R.l.eHl, R.l.dIO, new OnClickListener(this) {
                final /* synthetic */ GetQRCodeInfoUI pil;

                {
                    this.pil = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.pil.finish();
                }
            });
        } else if (i == 0 && i2 == 0) {
            awr Jx = ((aa) kVar).Jx();
            String a = n.a(Jx.ttp);
            com.tencent.mm.x.n.Bl().g(a, n.a(Jx.tfh));
            ((com.tencent.mm.pluginsdk.g) h.h(com.tencent.mm.pluginsdk.g.class)).a(new Intent(), Jx, 30);
            if (bg.mz(a).length() > 0) {
                if ((Jx.tMP & 8) > 0) {
                    com.tencent.mm.plugin.report.service.g.oUh.A(10298, a + ",30");
                }
                d.b(this, "profile", ".ui.ContactInfoUI", 1);
            }
        } else {
            g.a(this, getString(R.l.elQ, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), getString(R.l.dIO), new OnClickListener(this) {
                final /* synthetic */ GetQRCodeInfoUI pil;

                {
                    this.pil = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.pil.finish();
                }
            });
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        com.tencent.mm.plugin.setting.a.imv.t(new Intent(), this);
        finish();
    }
}
