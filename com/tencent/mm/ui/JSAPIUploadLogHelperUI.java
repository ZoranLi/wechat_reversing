package com.tencent.mm.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.network.e;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ad;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bb;
import com.tencent.mm.u.bb.a;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.h;

public class JSAPIUploadLogHelperUI extends MMBaseActivity {
    private static volatile boolean lp = false;
    private byte[] gWC = new byte[0];

    protected void onCreate(Bundle bundle) {
        boolean z;
        w.i("MicroMsg.JSAPIUploadLogHelperUI", "onCreate called, isRunning:%b", Boolean.valueOf(lp));
        super.onCreate(bundle);
        setContentView(R.i.cVc);
        synchronized (this.gWC) {
            if (lp) {
                w.w("MicroMsg.JSAPIUploadLogHelperUI", "reentered while last one is running, finish myself.");
                finish();
            }
        }
        final String stringExtra = getIntent().getStringExtra("key_user");
        final int intExtra = getIntent().getIntExtra("key_time", 0);
        String str = "MicroMsg.JSAPIUploadLogHelperUI";
        String str2 = "upload log from jsapi, in upload activity, username-recv-well:%b, time:%d";
        Object[] objArr = new Object[2];
        if (stringExtra == null || !stringExtra.equals(m.xL())) {
            z = false;
        } else {
            z = true;
        }
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Integer.valueOf(intExtra);
        w.i(str, str2, objArr);
        if (stringExtra == null) {
            w.e("MicroMsg.JSAPIUploadLogHelperUI", "doUpload: userName is null.");
            finish();
        } else if (intExtra < 0) {
            w.e("MicroMsg.JSAPIUploadLogHelperUI", "doUpload: illegal time value: %d", Integer.valueOf(intExtra));
            finish();
        } else {
            getString(R.l.dIO);
            final ProgressDialog a = g.a((Context) this, getString(R.l.fnX), false, null);
            ap.vd().a(new bb(new a(this) {
                final /* synthetic */ JSAPIUploadLogHelperUI uRF;

                public final void a(e eVar) {
                    synchronized (this.uRF.gWC) {
                        JSAPIUploadLogHelperUI.lp = true;
                    }
                    ap.vd().a(1, "", 0, false);
                    w.bIP();
                    ap.vd().a(2, stringExtra, intExtra, ap.zb());
                }
            }), 0);
            final OnDismissListener anonymousClass2 = new OnDismissListener(this) {
                final /* synthetic */ JSAPIUploadLogHelperUI uRF;

                {
                    this.uRF = r1;
                }

                public final void onDismiss(DialogInterface dialogInterface) {
                    if (!this.uRF.isFinishing()) {
                        this.uRF.finish();
                    }
                }
            };
            ap.a(new ad(this) {
                final /* synthetic */ JSAPIUploadLogHelperUI uRF;

                public final void ey(int i) {
                    h h;
                    if (i < 0) {
                        w.e("MicroMsg.JSAPIUploadLogHelperUI", "uploadLog call by jsapi, error happened, percent:%d", Integer.valueOf(i));
                        ap.a(null);
                        if (a != null) {
                            a.dismiss();
                        }
                        h = g.h(this.uRF, R.l.eZf, R.l.dIO);
                        if (h != null) {
                            h.setOnDismissListener(anonymousClass2);
                        }
                        synchronized (this.uRF.gWC) {
                            JSAPIUploadLogHelperUI.lp = false;
                        }
                    } else if (i >= 100) {
                        w.i("MicroMsg.JSAPIUploadLogHelperUI", "uploadLog call by jsapi done.");
                        ap.a(null);
                        if (a != null) {
                            a.dismiss();
                        }
                        h = g.h(this.uRF, R.l.eZj, R.l.dIO);
                        if (h != null) {
                            h.setOnDismissListener(anonymousClass2);
                        }
                        long currentTimeMillis = System.currentTimeMillis() / 1000;
                        com.tencent.mm.plugin.report.service.g.oUh.i(12975, Long.valueOf(currentTimeMillis));
                        synchronized (this.uRF.gWC) {
                            JSAPIUploadLogHelperUI.lp = false;
                        }
                    } else {
                        w.i("MicroMsg.JSAPIUploadLogHelperUI", "uploadLog call by jsapi, ipxx progress:%d", Integer.valueOf(i));
                        if (a != null) {
                            a.setMessage(this.uRF.getString(R.l.eZg) + i + "%");
                        }
                    }
                }
            });
        }
    }

    protected void onDestroy() {
        w.i("MicroMsg.JSAPIUploadLogHelperUI", "onDestroy called, isRunning:%b", Boolean.valueOf(lp));
        super.onDestroy();
    }
}
