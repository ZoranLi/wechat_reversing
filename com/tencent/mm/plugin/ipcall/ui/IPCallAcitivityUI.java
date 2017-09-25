package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.storage.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;

@a(3)
public class IPCallAcitivityUI extends MMActivity {
    private FrameLayout mRQ;
    private TextView mRR;
    private TextView mRS;
    private Button mRT;
    private CdnImageView mRU;
    private boolean mRV = false;
    private com.tencent.mm.plugin.ipcall.a.g.a mRW;

    protected final int Ol() {
        return 1;
    }

    protected final int getLayoutId() {
        return R.i.dgi;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
        getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        this.uSU.bQg();
        KC();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    protected final void KC() {
        this.mRQ = (FrameLayout) findViewById(R.h.bYO);
        this.mRR = (TextView) findViewById(R.h.bYS);
        this.mRS = (TextView) findViewById(R.h.bYP);
        this.mRT = (Button) findViewById(R.h.bYQ);
        this.mRU = (CdnImageView) findViewById(R.h.bYR);
        ap.yY();
        String str = (String) c.vr().get(w.a.uCe, "");
        if (bg.mA(str)) {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.IPCallAcitivityUI", "xml is empty");
            finish();
        } else {
            this.mRW = com.tencent.mm.plugin.ipcall.a.g.a.yr(str);
            if (this.mRW == null) {
                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.IPCallAcitivityUI", "mMsgInfo is null");
                finish();
            } else {
                this.mRR.setText(this.mRW.fDC);
                this.mRS.setText(this.mRW.msk);
                this.mRT.setText(this.mRW.mQU);
                this.mRU.L(this.mRW.mQT, 0, 0);
            }
        }
        this.mRQ.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ IPCallAcitivityUI mRX;

            {
                this.mRX = r1;
            }

            public final void onClick(View view) {
                this.mRX.finish();
            }
        });
        this.mRT.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ IPCallAcitivityUI mRX;

            {
                this.mRX = r1;
            }

            public final void onClick(View view) {
                if (this.mRX.mRW.jOc == 1) {
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.IPCallAcitivityUI", "click activity, go to IPCallPackageUI");
                    Intent intent = new Intent();
                    intent.setClass(this.mRX.uSU.uTo, IPCallShareCouponUI.class);
                    this.mRX.startActivity(intent);
                    intent = new Intent();
                    intent.setClass(this.mRX.uSU.uTo, IPCallPackageUI.class);
                    this.mRX.startActivity(intent);
                }
                this.mRX.mRV = true;
                this.mRX.finish();
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ IPCallAcitivityUI mRX;

            {
                this.mRX = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.mRX.finish();
                return true;
            }
        });
    }

    public void finish() {
        super.finish();
        overridePendingTransition(R.a.aQL, R.a.aRn);
        if (this.mRV) {
            com.tencent.mm.plugin.ipcall.a.e.c.om(1);
        } else {
            com.tencent.mm.plugin.ipcall.a.e.c.om(0);
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
    }
}
