package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ah.n;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.e.a.gk;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.y;
import java.util.HashMap;

@a(2)
public class WebViewDownloadWithX5UI extends MMActivity {
    private Context mContext;
    private Button sbJ;
    private final com.tencent.mm.plugin.webview.d.a sbX = new com.tencent.mm.plugin.webview.d.a();

    static /* synthetic */ void a(WebViewDownloadWithX5UI webViewDownloadWithX5UI, String str, String str2) {
        int i;
        b gkVar = new gk();
        gkVar.fLI.url = str;
        gkVar.fLI.fFW = "";
        gkVar.fLI.extInfo = "";
        gkVar.fLI.appId = "";
        com.tencent.mm.sdk.b.a.urY.m(gkVar);
        g.oUh.i(14217, new Object[]{"", Integer.valueOf(2), str2, str, Integer.valueOf(1)});
        int tbsVersion = QbSdk.getTbsVersion(webViewDownloadWithX5UI);
        if (ap.zb()) {
            ap.yY();
            String str3 = (String) c.vr().get(274528, "");
            if (TextUtils.isEmpty(str3) || !p.n(webViewDownloadWithX5UI.uSU.uTo, str3)) {
                i = 0;
            } else {
                w.i("MicroMsg.WebViewDownloadWithX5UI", "use always option PackageName is %s", new Object[]{str3});
                i = 1;
            }
        } else {
            i = 0;
        }
        if (i != 0 || tbsVersion <= 0) {
            com.tencent.mm.plugin.webview.d.a.d(webViewDownloadWithX5UI, str);
            return;
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put(QbSdk.LOGIN_TYPE_KEY_PARTNER_ID, "com.tencent.mm");
        hashMap.put(QbSdk.LOGIN_TYPE_KEY_PARTNER_CALL_POS, "9");
        w.i("MicroMsg.WebViewDownloadWithX5UI", "startQbOrMiniQBToLoadUrl ret = %b", new Object[]{Boolean.valueOf(QbSdk.startQbOrMiniQBToLoadUrl(webViewDownloadWithX5UI, str, hashMap, new y<String>(webViewDownloadWithX5UI) {
            final /* synthetic */ WebViewDownloadWithX5UI sbY;

            {
                this.sbY = r1;
            }

            public final /* synthetic */ void onReceiveValue(Object obj) {
                w.i("MicroMsg.WebViewDownloadWithX5UI", "onReceiveValue Value = %s", new Object[]{(String) obj});
                if ("closeMiniQb".equals((String) obj)) {
                    this.sbY.finish();
                }
            }
        }))});
        if (!QbSdk.startQbOrMiniQBToLoadUrl(webViewDownloadWithX5UI, str, hashMap, /* anonymous class already generated */)) {
            com.tencent.mm.plugin.webview.d.a.d(webViewDownloadWithX5UI, str);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mContext = this;
        qP(getString(R.l.fma));
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ WebViewDownloadWithX5UI sbY;

            {
                this.sbY = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.sbY.finish();
                return true;
            }
        });
        overridePendingTransition(MMFragmentActivity.a.uUP, MMFragmentActivity.a.uUQ);
        this.sbJ = (Button) findViewById(R.h.bKj);
        ImageView imageView = (ImageView) findViewById(R.h.bKs);
        TextView textView = (TextView) findViewById(R.h.bKu);
        final String stringExtra = getIntent().getStringExtra("task_url");
        CharSequence stringExtra2 = getIntent().getStringExtra("title");
        final long longExtra = getIntent().getLongExtra("task_size", 0);
        final String stringExtra3 = getIntent().getStringExtra("page_url");
        w.i("MicroMsg.WebViewDownloadWithX5UI", "onCreate: url=%s,taskSize=%d, thumbUrl=%s", new Object[]{stringExtra, Long.valueOf(longExtra), getIntent().getStringExtra("thumb_url")});
        if (longExtra > 0) {
            String ew = bg.ew(longExtra);
            this.sbJ.setText(getString(R.l.flS, new Object[]{ew}));
        }
        if (ap.zb()) {
            com.tencent.mm.ah.a.a GW = n.GW();
            com.tencent.mm.ah.a.a.c.a aVar = new com.tencent.mm.ah.a.a.c.a();
            aVar.hJa = R.k.dAG;
            aVar.hIL = true;
            GW.a(r7, imageView, aVar.Hg());
        } else {
            imageView.setImageResource(R.k.dAG);
        }
        textView.setVisibility(0);
        if (bg.mA(stringExtra2)) {
            textView.setText(getString(R.l.flZ));
        } else {
            textView.setText(stringExtra2);
        }
        g.oUh.i(14217, new Object[]{"", Integer.valueOf(1), stringExtra3, stringExtra, Integer.valueOf(1)});
        this.sbJ.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WebViewDownloadWithX5UI sbY;

            public final void onClick(View view) {
                if (am.isNetworkConnected(this.sbY.mContext)) {
                    ap.yY();
                    if (!c.isSDCardAvailable()) {
                        Toast.makeText(this.sbY.mContext, this.sbY.getString(R.l.eoI), 0).show();
                        w.i("MicroMsg.WebViewDownloadWithX5UI", "startDownload fail, sdcard not ready");
                        return;
                    } else if (longExtra > 0 && !f.G(longExtra)) {
                        Toast.makeText(this.sbY.mContext, this.sbY.getString(R.l.eoH), 0).show();
                        w.i("MicroMsg.WebViewDownloadWithX5UI", "startDownload fail, not enough space, require size = " + longExtra);
                        return;
                    } else if (am.isWifi(this.sbY.mContext)) {
                        WebViewDownloadWithX5UI.a(this.sbY, stringExtra, stringExtra3);
                        return;
                    } else {
                        com.tencent.mm.ui.base.g.a(this.sbY, this.sbY.getString(R.l.flW), this.sbY.getString(R.l.flX), this.sbY.getString(R.l.flR), this.sbY.getString(R.l.dGs), false, new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ AnonymousClass2 sca;

                            {
                                this.sca = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                WebViewDownloadWithX5UI.a(this.sca.sbY, stringExtra, stringExtra3);
                                dialogInterface.dismiss();
                            }
                        }, new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ AnonymousClass2 sca;

                            {
                                this.sca = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        }, R.e.aWu);
                        return;
                    }
                }
                Toast.makeText(this.sbY.mContext, this.sbY.getString(R.l.eoG), 0).show();
                w.i("MicroMsg.WebViewDownloadWithX5UI", "startDownload fail, network not ready");
            }
        });
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.drM;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (com.tencent.mm.plugin.webview.d.a.a(this, i, i2, intent) && -1 == i2) {
            finish();
        }
    }
}
