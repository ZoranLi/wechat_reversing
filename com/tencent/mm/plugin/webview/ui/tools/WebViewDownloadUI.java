package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
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
import com.tencent.mm.e.a.gk;
import com.tencent.mm.e.a.i;
import com.tencent.mm.plugin.downloader.model.e;
import com.tencent.mm.plugin.downloader.model.m;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;

public class WebViewDownloadUI extends MMActivity {
    private TextView kCp;
    private int kGV;
    private Context mContext;
    private long mwB;
    private boolean sbD;
    private Button sbJ;
    private TextView sbK;
    private a sbL;
    private String sbM;
    private TextView sbN;
    private m sbO = new m(this) {
        final /* synthetic */ WebViewDownloadUI sbP;

        {
            this.sbP = r1;
        }

        public final void onTaskStarted(long j, String str) {
            w.i("MicroMsg.WebViewDownloadUI", "onTaskStarted id=%d, savedFilePath=%s", new Object[]{Long.valueOf(j), str});
        }

        public final void c(long j, String str, boolean z) {
            w.i("MicroMsg.WebViewDownloadUI", "onTaskFinished id=%d, savedFilePath=%s, hasChangeUrl=%b", new Object[]{Long.valueOf(j), str, Boolean.valueOf(z)});
            Toast.makeText(this.sbP.uSU.uTo, this.sbP.getString(R.l.flY), 1).show();
            this.sbP.finish();
        }

        public final void d(long j, int i, boolean z) {
            w.i("MicroMsg.WebViewDownloadUI", "onTaskFailed id=%d, errCode=%d, hasChangeUrl=%b", new Object[]{Long.valueOf(j), Integer.valueOf(i), Boolean.valueOf(z)});
            Toast.makeText(this.sbP.uSU.uTo, this.sbP.getString(R.l.flV), 1).show();
            this.sbP.finish();
        }

        public final void onTaskRemoved(long j) {
            w.i("MicroMsg.WebViewDownloadUI", "onTaskRemoved id=%d", new Object[]{Long.valueOf(j)});
            this.sbP.finish();
        }

        public final void onTaskPaused(long j) {
            w.i("MicroMsg.WebViewDownloadUI", "onTaskPaused id=%d", new Object[]{Long.valueOf(j)});
        }

        public final void bg(long j) {
        }

        public final void j(long j, String str) {
            w.i("MicroMsg.WebViewDownloadUI", "onTaskResumed id=%d, savedFilePath=%s", new Object[]{Long.valueOf(j), str});
        }
    };

    private enum a {
        TO_DOWNLOAD,
        DOWNLOADING
    }

    static /* synthetic */ void a(WebViewDownloadUI webViewDownloadUI, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        b gkVar = new gk();
        gkVar.fLI.url = str;
        gkVar.fLI.fFW = str2;
        gkVar.fLI.extInfo = str3;
        gkVar.fLI.appId = str4;
        com.tencent.mm.sdk.b.a.urY.m(gkVar);
        g.oUh.i(14217, new Object[]{str4, Integer.valueOf(2), str6, str, Integer.valueOf(0)});
        com.tencent.mm.plugin.downloader.model.f.a aVar = new com.tencent.mm.plugin.downloader.model.f.a();
        aVar.tL(str);
        aVar.tM(str5);
        aVar.tN(str7);
        aVar.tO(str2);
        aVar.setAppId(str4);
        aVar.bl(str8);
        aVar.dn(true);
        aVar.la(webViewDownloadUI.kGV);
        long a = e.akM().a(aVar.kHa);
        w.i("MicroMsg.WebViewDownloadUI", "downloadOpBtn.onClick, lastDownloadId = %d, downloadId=%d", new Object[]{Long.valueOf(webViewDownloadUI.mwB), Long.valueOf(a)});
        webViewDownloadUI.mwB = a;
        b iVar = new i();
        iVar.fCu.fCw = a;
        iVar.fCu.fCv = false;
        com.tencent.mm.sdk.b.a.urY.m(iVar);
        webViewDownloadUI.sbD = true;
        if (a <= 0) {
            Toast.makeText(webViewDownloadUI.uSU.uTo, webViewDownloadUI.getString(R.l.flV), 1).show();
            webViewDownloadUI.finish();
            return;
        }
        Toast.makeText(webViewDownloadUI.uSU.uTo, webViewDownloadUI.getString(R.l.flQ), 1).show();
        webViewDownloadUI.a(a.DOWNLOADING);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mContext = this;
        qP(getString(R.l.fma));
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ WebViewDownloadUI sbP;

            {
                this.sbP = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.sbP.finish();
                return true;
            }
        });
        overridePendingTransition(com.tencent.mm.ui.MMFragmentActivity.a.uUP, com.tencent.mm.ui.MMFragmentActivity.a.uUQ);
        this.sbJ = (Button) findViewById(R.h.bKj);
        this.sbK = (TextView) findViewById(R.h.bJZ);
        TextView textView = (TextView) findViewById(R.h.bKu);
        this.sbN = (TextView) findViewById(R.h.bKp);
        ImageView imageView = (ImageView) findViewById(R.h.bKs);
        this.kCp = (TextView) findViewById(R.h.bKt);
        a(a.TO_DOWNLOAD);
        final String stringExtra = getIntent().getStringExtra("task_name");
        final String stringExtra2 = getIntent().getStringExtra("task_url");
        final String stringExtra3 = getIntent().getStringExtra("alternative_url");
        long longExtra = getIntent().getLongExtra("task_size", 0);
        final String stringExtra4 = getIntent().getStringExtra("file_md5");
        final String stringExtra5 = getIntent().getStringExtra("extInfo");
        String stringExtra6 = getIntent().getStringExtra("fileType");
        final String stringExtra7 = getIntent().getStringExtra("appid");
        final String stringExtra8 = getIntent().getStringExtra("package_name");
        String stringExtra9 = getIntent().getStringExtra("thumb_url");
        CharSequence stringExtra10 = getIntent().getStringExtra("title");
        final String stringExtra11 = getIntent().getStringExtra("page_url");
        w.i("MicroMsg.WebViewDownloadUI", "onCreate: md5=%s, url=%s, extInfo=%s, fileType=%s, appId=%s, packageName=%s, taskSize=%d, thumbUrl=%s", new Object[]{stringExtra4, stringExtra2, stringExtra5, stringExtra6, stringExtra7, stringExtra8, Long.valueOf(longExtra), stringExtra9});
        g.oUh.i(14217, new Object[]{stringExtra7, Integer.valueOf(1), stringExtra11, stringExtra2, Integer.valueOf(0)});
        this.kGV = bg.getInt(stringExtra6, 1);
        if (bg.mA(stringExtra10)) {
            stringExtra10 = bg.mz(stringExtra);
        }
        if (!bg.mA(stringExtra10)) {
            textView.setText(stringExtra10);
            textView.setVisibility(0);
        }
        if (longExtra > 0) {
            this.sbM = bg.ew(longExtra);
            this.sbN.setText(this.sbM);
            this.sbJ.setText(getString(R.l.flS, new Object[]{this.sbM}));
        }
        com.tencent.mm.ah.a.a GW = n.GW();
        com.tencent.mm.ah.a.a.c.a aVar = new com.tencent.mm.ah.a.a.c.a();
        aVar.hJa = R.k.dAG;
        aVar.hIL = true;
        GW.a(stringExtra9, imageView, aVar.Hg());
        this.sbJ.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WebViewDownloadUI sbP;

            public final void onClick(View view) {
                w.i("MicroMsg.WebViewDownloadUI", "downloadOpBtn.onClick state=%s", new Object[]{this.sbP.sbL});
                switch (this.sbP.sbL) {
                    case TO_DOWNLOAD:
                        if (!am.isNetworkConnected(this.sbP.mContext)) {
                            Toast.makeText(this.sbP.mContext, this.sbP.getString(R.l.eoG), 0).show();
                            w.i("MicroMsg.WebViewDownloadUI", "startDownload fail, network not ready");
                            return;
                        } else if (am.isWifi(this.sbP.mContext)) {
                            WebViewDownloadUI.a(this.sbP, stringExtra2, stringExtra4, stringExtra5, stringExtra7, stringExtra3, stringExtra11, stringExtra, stringExtra8);
                            return;
                        } else {
                            com.tencent.mm.ui.base.g.a(this.sbP, this.sbP.getString(R.l.flW), this.sbP.getString(R.l.flX), this.sbP.getString(R.l.flR), this.sbP.getString(R.l.dGs), false, new DialogInterface.OnClickListener(this) {
                                final /* synthetic */ AnonymousClass2 sbS;

                                {
                                    this.sbS = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    WebViewDownloadUI.a(this.sbS.sbP, stringExtra2, stringExtra4, stringExtra5, stringExtra7, stringExtra3, stringExtra11, stringExtra, stringExtra8);
                                    dialogInterface.dismiss();
                                }
                            }, new DialogInterface.OnClickListener(this) {
                                final /* synthetic */ AnonymousClass2 sbS;

                                {
                                    this.sbS = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.dismiss();
                                }
                            }, R.e.aWu);
                            return;
                        }
                    default:
                        w.e("MicroMsg.WebViewDownloadUI", "downloadOpBtn.onClick unexpected download state");
                        return;
                }
            }
        });
        this.sbK.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WebViewDownloadUI sbP;

            public final void onClick(View view) {
                w.i("MicroMsg.WebViewDownloadUI", "doCancelDownloadTask, downloadId = %d, state=%s", new Object[]{Long.valueOf(this.sbP.mwB), this.sbP.sbL});
                g.oUh.i(14217, new Object[]{stringExtra7, Integer.valueOf(3), stringExtra11, stringExtra2, Integer.valueOf(0)});
                if (this.sbP.mwB <= 0) {
                    w.e("MicroMsg.WebViewDownloadUI", "doCancelDownloadTask fail, unexpected branch! ");
                } else {
                    w.i("MicroMsg.WebViewDownloadUI", "doCancelDownloadTask, ret = %d", new Object[]{Integer.valueOf(e.akM().aT(this.sbP.mwB))});
                    if (e.akM().aT(this.sbP.mwB) > 0) {
                        Toast.makeText(this.sbP.uSU.uTo, this.sbP.getString(R.l.flU), 1).show();
                        this.sbP.finish();
                        return;
                    }
                }
                Toast.makeText(this.sbP.uSU.uTo, this.sbP.getString(R.l.flT), 1).show();
            }
        });
        e.akM();
        com.tencent.mm.plugin.downloader.model.b.a(this.sbO);
    }

    protected void onDestroy() {
        super.onDestroy();
        w.i("MicroMsg.WebViewDownloadUI", "onDestroy hasCallback=%b", new Object[]{Boolean.valueOf(this.sbD)});
        if (!this.sbD) {
            b iVar = new i();
            iVar.fCu.fCv = true;
            com.tencent.mm.sdk.b.a.urY.m(iVar);
            this.sbD = true;
        }
        e.akM();
        com.tencent.mm.plugin.downloader.model.b.b(this.sbO);
    }

    protected final int getLayoutId() {
        return R.i.drM;
    }

    private void a(a aVar) {
        w.i("MicroMsg.WebViewDownloadUI", "setDownloadState old=%s new=%s", new Object[]{this.sbL, aVar});
        this.sbL = aVar;
        switch (this.sbL) {
            case TO_DOWNLOAD:
                this.sbJ.setVisibility(0);
                this.kCp.setVisibility(8);
                this.sbK.setVisibility(8);
                break;
            case DOWNLOADING:
                this.sbJ.setVisibility(8);
                this.sbK.setVisibility(0);
                this.kCp.setVisibility(0);
                if (!bg.mA(this.sbM)) {
                    this.sbN.setVisibility(0);
                    return;
                }
                break;
            default:
                return;
        }
        this.sbN.setVisibility(8);
    }
}
