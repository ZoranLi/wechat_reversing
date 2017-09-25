package com.tencent.mm.plugin.webview.stub;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.e.a.aj;
import com.tencent.mm.e.a.bx;
import com.tencent.mm.e.a.jp;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.a;

@a(7)
public class WebviewScanImageActivity extends Activity {
    private int fFo;
    private int fFp;
    private String hPd;
    private String qtn = null;
    private c qtq = new c<jp>(this) {
        final /* synthetic */ WebviewScanImageActivity sav;

        {
            this.sav = r2;
            this.usg = jp.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            jp jpVar = (jp) bVar;
            if (jpVar != null && (jpVar instanceof jp)) {
                com.tencent.mm.sdk.b.a.urY.c(this.sav.qtq);
                w.i("MicroMsg.WebviewScanImageActivity", "notify Event: %d", new Object[]{Integer.valueOf(jpVar.fQb.fPZ)});
                w.d("MicroMsg.WebviewScanImageActivity", "%s, %s", new Object[]{jpVar.fQb.activity, this.sav});
                if (jpVar.fQb.activity == this.sav && jpVar.fQb.fDK.equals(this.sav.qtn)) {
                    Bundle bundle = jpVar.fQb.fQc;
                    int i;
                    switch (jpVar.fQb.fPZ) {
                        case 0:
                        case 1:
                        case 2:
                            this.sav.finish();
                            break;
                        case 3:
                            if (bundle != null) {
                                i = bundle.getInt("geta8key_action_code", 0);
                                g.oUh.i(13329, new Object[]{this.sav.url, this.sav.qtn, Integer.valueOf(i)});
                            }
                            this.sav.finish();
                            break;
                        case 4:
                            if (bundle != null) {
                                i = bundle.getInt("geta8key_action_code", 0);
                                g.oUh.i(13329, new Object[]{this.sav.url, this.sav.qtn, Integer.valueOf(i)});
                                break;
                            }
                            break;
                        default:
                            break;
                    }
                }
                w.e("MicroMsg.WebviewScanImageActivity", "not the same, eventStr: %s, origin: %s", new Object[]{jpVar.fQb.fDK, this.sav.qtn});
            } else {
                w.e("MicroMsg.WebviewScanImageActivity", "event is null or not a instant of NotifyDealQBarStrResultEvent");
            }
            return false;
        }
    };
    private boolean sau = false;
    private String url;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        w.i("MicroMsg.WebviewScanImageActivity", "hy: on create");
        if (d.eo(21)) {
            getWindow().addFlags(Integer.MIN_VALUE);
            getWindow().setStatusBarColor(0);
        }
        setContentView(R.i.dgG);
    }

    protected void onStart() {
        super.onStart();
        w.i("MicroMsg.WebviewScanImageActivity", "hy: on start");
        if (!(this.sau || getIntent() == null)) {
            this.qtn = getIntent().getStringExtra("key_string_for_scan");
            this.fFo = getIntent().getIntExtra("key_codetype_for_scan", 0);
            this.fFp = getIntent().getIntExtra("key_codeversion_for_scan", 0);
            this.url = getIntent().getStringExtra("key_string_for_url");
            this.hPd = getIntent().getStringExtra("key_string_for_image_url");
            if (this.qtn != null) {
                b bxVar = new bx();
                bxVar.fFn.activity = this;
                bxVar.fFn.fDK = this.qtn;
                bxVar.fFn.fFp = this.fFp;
                bxVar.fFn.fFo = this.fFo;
                bxVar.fFn.fFq = 6;
                bxVar.fFn.imagePath = this.hPd;
                bxVar.fFn.scene = 40;
                Bundle bundle = new Bundle();
                bundle.putString("stat_url", this.url);
                bundle.putInt("stat_scene", 4);
                bxVar.fFn.fFu = bundle;
                com.tencent.mm.sdk.b.a.urY.m(bxVar);
                com.tencent.mm.sdk.b.a.urY.b(this.qtq);
            }
        }
        this.sau = true;
    }

    protected void onPause() {
        super.onPause();
        w.i("MicroMsg.WebviewScanImageActivity", "hy: on pause");
        b ajVar = new aj();
        ajVar.fDJ.activity = this;
        ajVar.fDJ.fDK = this.qtn;
        com.tencent.mm.sdk.b.a.urY.m(ajVar);
        com.tencent.mm.sdk.b.a.urY.c(this.qtq);
        finish();
    }
}
