package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.pluginsdk.model.m;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.storage.ba;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public class SendFeedBackUI extends MMActivity implements e {
    private ProgressDialog isv = null;
    private EditText oBT;
    private TextView pji = null;

    protected final int getLayoutId() {
        return R.i.dao;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KC();
    }

    public void onDestroy() {
        ap.vd().b(153, this);
        super.onDestroy();
    }

    protected final void KC() {
        zi(R.l.eSB);
        this.oBT = (EditText) findViewById(R.h.content);
        String stringExtra = getIntent().getStringExtra("intentKeyFrom");
        if (stringExtra != null && stringExtra.equals("fromEnjoyAppDialog")) {
            this.pji = (TextView) findViewById(R.h.cMy);
            this.pji.setVisibility(0);
            this.pji.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ SendFeedBackUI pjj;

                {
                    this.pjj = r1;
                }

                public final void onClick(View view) {
                    Intent intent = new Intent();
                    intent.putExtra("showShare", false);
                    intent.putExtra("rawUrl", this.pjj.getString(R.l.fmX));
                    d.b(this.pjj.uSU.uTo, "webview", ".ui.tools.WebViewUI", intent);
                }
            });
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SendFeedBackUI pjj;

            {
                this.pjj = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.pjj.aHf();
                this.pjj.finish();
                return true;
            }
        });
        a(0, getString(R.l.dIA), new OnMenuItemClickListener(this) {
            final /* synthetic */ SendFeedBackUI pjj;

            {
                this.pjj = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                String trim = this.pjj.oBT.getText().toString().trim();
                if (trim.length() > 0) {
                    if (trim.startsWith("//traceroute")) {
                        this.pjj.oBT.setText("");
                        d.w(this.pjj.uSU.uTo, "traceroute", ".ui.NetworkDiagnoseIntroUI");
                    } else {
                        final k mVar = new m(p.rP(), trim + " key " + ba.bMW() + " local key " + ba.bMV() + "NetType:" + am.getNetTypeString(this.pjj.getApplicationContext()) + " hasNeon: " + com.tencent.mm.compatible.d.m.rr() + " isArmv6: " + com.tencent.mm.compatible.d.m.rt() + " isArmv7: " + com.tencent.mm.compatible.d.m.rs());
                        ap.vd().a(153, this.pjj);
                        ap.vd().a(mVar, 0);
                        this.pjj.aHf();
                        SendFeedBackUI sendFeedBackUI = this.pjj;
                        Context context = this.pjj;
                        this.pjj.getString(R.l.dIO);
                        sendFeedBackUI.isv = g.a(context, this.pjj.getString(R.l.dIB), true, new OnCancelListener(this) {
                            final /* synthetic */ AnonymousClass3 pjl;

                            public final void onCancel(DialogInterface dialogInterface) {
                                ap.vd().c(mVar);
                            }
                        });
                    }
                }
                return false;
            }
        });
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (this.isv != null) {
            this.isv.dismiss();
            this.isv = null;
        }
        if (i == 0 && i2 == 0) {
            g.a(this, getString(R.l.eSA), getString(R.l.dIO), new DialogInterface.OnClickListener(this) {
                final /* synthetic */ SendFeedBackUI pjj;

                {
                    this.pjj = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.pjj.finish();
                }
            });
        } else {
            g.a(this, getString(R.l.eSz), getString(R.l.dIO), new DialogInterface.OnClickListener(this) {
                final /* synthetic */ SendFeedBackUI pjj;

                {
                    this.pjj = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
        }
    }
}
