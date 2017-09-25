package com.tencent.mm.plugin.facedetect.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.bb.d;
import com.tencent.mm.plugin.facedetect.a.g;
import com.tencent.mm.plugin.facedetect.a.h;
import com.tencent.mm.plugin.facedetect.b.l;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.protocal.c.ail;
import com.tencent.mm.protocal.c.arj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.List;

@a(3)
public class FaceDetectConfirmUI extends MMActivity implements e {
    private String appId;
    private int hPq;
    private String iTT;
    private p irJ;
    private String luZ = null;
    private TextView lyr;
    private TextView lys;
    private TextView lyt;
    private Button lyu;
    private List<ail> lyv = new ArrayList();
    private arj lyw = null;
    private String lyx;

    protected final int getLayoutId() {
        return g.lts;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.appId = getIntent().getStringExtra("k_app_id");
        this.iTT = getIntent().getStringExtra("request_verify_pre_info");
        this.lyx = getIntent().getStringExtra("key_function_name");
        this.hPq = getIntent().getIntExtra("key_business_type", -1);
        qP(getString(h.ltG));
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ FaceDetectConfirmUI lyy;

            {
                this.lyy = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                w.i("MicroMsg.FaceDetectConfirmUI", "alvinluo cancel with back button");
                this.lyy.asl();
                return false;
            }
        });
        this.lyr = (TextView) findViewById(com.tencent.mm.plugin.facedetect.a.e.lsL);
        this.lys = (TextView) findViewById(com.tencent.mm.plugin.facedetect.a.e.lsV);
        this.lyt = (TextView) findViewById(com.tencent.mm.plugin.facedetect.a.e.lsU);
        this.lyu = (Button) findViewById(com.tencent.mm.plugin.facedetect.a.e.ltn);
        this.lyu.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FaceDetectConfirmUI lyy;

            {
                this.lyy = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent(this.lyy, FaceDetectPrepareUI.class);
                intent.putExtras(this.lyy.getIntent().getExtras());
                this.lyy.startActivityForResult(intent, 1);
            }
        });
        w.i("MicroMsg.FaceDetectConfirmUI", "alvinluo start get confirm info");
        Context context = this.uSU.uTo;
        getString(h.dIO);
        this.irJ = com.tencent.mm.ui.base.g.a(context, getString(h.dJd), false, new OnCancelListener(this) {
            final /* synthetic */ FaceDetectConfirmUI lyy;

            {
                this.lyy = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        k lVar = new l(this.appId, this.iTT);
        com.tencent.mm.kernel.h.vd().a(1147, this);
        com.tencent.mm.kernel.h.vd().a(lVar, 0);
    }

    private void asl() {
        Intent intent = new Intent();
        intent.putExtra("err_code", com.tencent.mm.plugin.facedetect.model.k.mk(90024));
        intent.putExtra("err_msg", "user cancel in confirm ui");
        FaceDetectReporter.arN().a(this.hPq, false, 3, 1, 90024);
        FaceDetectReporter.arN().lwH = System.currentTimeMillis();
        FaceDetectReporter.arN().aP(this.lyx, this.hPq);
        setResult(0, intent);
        finish();
    }

    public void finish() {
        asm();
        super.finish();
    }

    private void asm() {
        if (this.irJ != null && this.irJ.isShowing()) {
            this.irJ.dismiss();
        }
    }

    public void onBackPressed() {
        asl();
        super.onBackPressed();
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.FaceDetectConfirmUI", "alvinluo scene: %d, errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i == 0 && i2 == 0) {
            this.lyv = ((l) kVar).luX;
            this.lyw = ((l) kVar).luY;
            this.luZ = ((l) kVar).luZ;
            if (bg.mA(this.luZ)) {
                this.luZ = getString(h.ltF);
            }
            asm();
            this.lyu.setEnabled(true);
            this.lyr.setText(this.luZ);
            w.i("MicroMsg.FaceDetectConfirmUI", "alvinluo refreshView");
            if (this.lyw != null) {
                if (!bg.mA(this.lyw.fNG)) {
                    w.v("MicroMsg.FaceDetectConfirmUI", "alvinluo provider wording: %s", new Object[]{this.lyw.fNG});
                    this.lys.setVisibility(0);
                    this.lys.setText(this.lyw.fNG);
                }
                if (!bg.mA(this.lyw.tVU)) {
                    w.v("MicroMsg.FaceDetectConfirmUI", "alvinluo protocal url wording: %s", new Object[]{this.lyw.tVU});
                    this.lyt.setVisibility(0);
                    this.lyt.setText(this.lyw.tVU);
                    if (!bg.mA(this.lyw.url)) {
                        w.v("MicroMsg.FaceDetectConfirmUI", "alvinluo protocal url: %s", new Object[]{this.lyw.url});
                        final String str2 = this.lyw.url;
                        this.lyt.setOnClickListener(new OnClickListener(this) {
                            final /* synthetic */ FaceDetectConfirmUI lyy;

                            public final void onClick(View view) {
                                Intent intent = new Intent();
                                intent.putExtra("rawUrl", str2);
                                intent.putExtra("showShare", false);
                                intent.putExtra("geta8key_username", m.xL());
                                d.b(this.lyy, "webview", ".ui.tools.WebViewUI", intent);
                            }
                        });
                    }
                }
            }
        } else {
            if (bg.mA(str)) {
                str = getString(h.ltQ);
            }
            asm();
            com.tencent.mm.ui.base.g.a(this, str, getString(h.dIO), false, new DialogInterface.OnClickListener(this) {
                final /* synthetic */ FaceDetectConfirmUI lyy;

                {
                    this.lyy = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent = new Intent();
                    intent.putExtra("err_code", com.tencent.mm.plugin.facedetect.model.k.mk(90022));
                    intent.putExtra("err_msg", "get confirm info error");
                    FaceDetectReporter.arN().a(this.lyy.hPq, false, 3, 2, 90022);
                    FaceDetectReporter.arN().lwH = System.currentTimeMillis();
                    FaceDetectReporter.arN().aP(this.lyy.lyx, this.lyy.hPq);
                    this.lyy.setResult(-1, intent);
                    this.lyy.finish();
                }
            });
        }
        com.tencent.mm.kernel.h.vd().b(1147, this);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        w.i("MicroMsg.FaceDetectConfirmUI", "onActiviyResult reqeustCode: %d, resultCode: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        FaceDetectReporter.arN().lwH = System.currentTimeMillis();
        FaceDetectReporter.arN().aP(this.lyx, this.hPq);
        setResult(i2, intent);
        finish();
    }
}
