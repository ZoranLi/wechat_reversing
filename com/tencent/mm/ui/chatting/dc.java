package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.Base64;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.a.l;
import com.tencent.mm.bb.d;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.ui.tools.i;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public final class dc {
    SharedPreferences hgx;
    LinearLayout kZi = null;
    long lgm = -1;
    public Context mContext;
    public String oFA;
    public String oFB;
    public String oFz;
    ChatFooterCustom vGn;
    FrameLayout vGo;
    FrameLayout vGp;
    public TextView vGq;
    ImageView vGr;
    public a vGs = a.DEFAULT;
    public int vGt = -1;
    public boolean vGu;
    String vGv = null;
    String vGw;
    OnClickListener vGx = new OnClickListener(this) {
        final /* synthetic */ dc vGA;

        {
            this.vGA = r1;
        }

        public final void onClick(View view) {
            new Intent().putExtra("composeType", 1);
            d.w(this.vGA.mContext, "qqmail", ".ui.ComposeUI");
        }
    };
    OnClickListener vGy = new OnClickListener(this) {
        final /* synthetic */ dc vGA;

        {
            this.vGA = r1;
        }

        public final void onClick(View view) {
            dc dcVar;
            switch (this.vGA.vGs) {
                case NEED_INSTALL:
                    g.oUh.i(11288, Integer.valueOf(7));
                    dcVar = this.vGA;
                    w.i("MicroMsg.ChattingQQMailFooterHandler", "dz[installQQMail]");
                    bg.i(dcVar.vGv, dcVar.mContext);
                    return;
                case DOWNLOADING:
                    dcVar = this.vGA;
                    w.i("MicroMsg.ChattingQQMailFooterHandler", "dz[cancelDownload]");
                    e.akM().aT(dcVar.lgm);
                    dcVar.bUH();
                    return;
                case NEED_DOWNLOAD:
                    g.oUh.i(11288, Integer.valueOf(6));
                    dc dcVar2 = this.vGA;
                    if (!am.isConnected(dcVar2.mContext)) {
                        com.tencent.mm.ui.base.g.a(dcVar2.mContext, com.tencent.mm.bg.a.V(dcVar2.mContext, R.l.dSS), "", com.tencent.mm.bg.a.V(dcVar2.mContext, R.l.dSN), null);
                        return;
                    } else if (am.isWifi(dcVar2.mContext)) {
                        com.tencent.mm.ui.base.g.a(dcVar2.mContext, R.l.dSQ, 0, R.l.dSL, R.l.dSK, new DialogInterface.OnClickListener(dcVar2) {
                            final /* synthetic */ dc vGA;

                            {
                                this.vGA = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                this.vGA.bUJ();
                            }
                        }, null);
                        return;
                    } else {
                        com.tencent.mm.ui.base.g.a(dcVar2.mContext, R.l.dSP, 0, R.l.dSL, R.l.dSK, new DialogInterface.OnClickListener(dcVar2) {
                            final /* synthetic */ dc vGA;

                            {
                                this.vGA = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                this.vGA.bUJ();
                            }
                        }, null);
                        return;
                    }
                case INSTALLED:
                    Intent launchIntentForPackage;
                    g.oUh.i(11288, Integer.valueOf(5));
                    dc dcVar3 = this.vGA;
                    w.i("MicroMsg.ChattingQQMailFooterHandler", "dz[openQQMail]");
                    w.i("MicroMsg.ChattingQQMailFooterHandler", "mQQMailScheme = %s", dcVar3.vGw);
                    if (bg.mA(dcVar3.vGw)) {
                        launchIntentForPackage = dcVar3.mContext.getPackageManager().getLaunchIntentForPackage("com.tencent.androidqqmail");
                    } else {
                        launchIntentForPackage = new Intent();
                        launchIntentForPackage.setData(Uri.parse(dcVar3.vGw));
                        launchIntentForPackage.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                        if (VERSION.SDK_INT >= 11) {
                            launchIntentForPackage.addFlags(WXMediaMessage.THUMB_LENGTH_LIMIT);
                        }
                        if (!bg.j(dcVar3.mContext, launchIntentForPackage)) {
                            launchIntentForPackage = dcVar3.mContext.getPackageManager().getLaunchIntentForPackage("com.tencent.androidqqmail");
                        }
                    }
                    w.i("MicroMsg.ChattingQQMailFooterHandler", "intent = %s", launchIntentForPackage);
                    com.tencent.mm.bk.a.post(new AnonymousClass5(dcVar3, launchIntentForPackage));
                    return;
                case NO_URL:
                    if (this.vGA.vGu) {
                        this.vGA.bUI();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private com.tencent.mm.pluginsdk.ui.tools.i.a vGz = new com.tencent.mm.pluginsdk.ui.tools.i.a(this) {
        final /* synthetic */ dc vGA;

        {
            this.vGA = r1;
        }

        public final void rD(int i) {
            this.vGA.vGt = i;
            this.vGA.bUK();
        }

        public final void aUE() {
            this.vGA.vGq.setText(R.l.dSV);
        }
    };

    class AnonymousClass5 implements Runnable {
        final /* synthetic */ Intent oFS;
        final /* synthetic */ dc vGA;

        AnonymousClass5(dc dcVar, Intent intent) {
            this.vGA = dcVar;
            this.oFS = intent;
        }

        public final void run() {
            com.tencent.mm.pluginsdk.model.app.g.a(this.vGA.mContext, this.oFS, this.vGA.mContext.getString(R.l.dSV), 1, null, null);
        }
    }

    private enum a {
        DEFAULT,
        NEED_DOWNLOAD,
        DOWNLOADING,
        NEED_INSTALL,
        INSTALLED,
        NO_URL
    }

    public dc(ChatFooterCustom chatFooterCustom) {
        this.mContext = chatFooterCustom.getContext();
        this.vGn = chatFooterCustom;
    }

    final void bUG() {
        if (this.vGs == a.INSTALLED) {
            this.vGr.setImageResource(R.k.dyS);
        } else {
            this.vGr.setImageResource(R.k.dyT);
        }
    }

    public final void bUH() {
        a aVar;
        if (!p.n(this.mContext, "com.tencent.androidqqmail")) {
            this.hgx = this.mContext.getSharedPreferences("QQMAIL", 4);
            this.lgm = this.hgx.getLong("qqmail_downloadid", -1);
            if (this.lgm >= 0) {
                FileDownloadTaskInfo aU = e.akM().aU(this.lgm);
                int i = aU.status;
                this.vGv = aU.path;
                switch (i) {
                    case 1:
                        aVar = a.DOWNLOADING;
                        break;
                    case 3:
                        if (!com.tencent.mm.a.e.aO(this.vGv)) {
                            if (!bg.mA(this.oFz)) {
                                aVar = a.NEED_DOWNLOAD;
                                break;
                            } else {
                                aVar = a.NO_URL;
                                break;
                            }
                        }
                        aVar = a.NEED_INSTALL;
                        break;
                    default:
                        if (!bg.mA(this.oFz)) {
                            aVar = a.NEED_DOWNLOAD;
                            break;
                        } else {
                            aVar = a.NO_URL;
                            break;
                        }
                }
            }
            aVar = bg.mA(this.oFz) ? a.NO_URL : a.NEED_DOWNLOAD;
        } else {
            aVar = a.INSTALLED;
        }
        this.vGs = aVar;
        bUG();
        w.i("MicroMsg.ChattingQQMailFooterHandler", "dz[initRightBtnTv: status:%s]", this.vGs.toString());
        switch (this.vGs) {
            case NEED_INSTALL:
                this.vGq.setText(R.l.dSO);
                return;
            case DOWNLOADING:
                this.vGq.setText(R.l.dSM);
                return;
            case NEED_DOWNLOAD:
            case INSTALLED:
            case NO_URL:
                i.a(this.vGz);
                return;
            default:
                i.a(this.vGz);
                return;
        }
    }

    public final void bUI() {
        w.i("MicroMsg.ChattingQQMailFooterHandler", "dz[handleNoUrl]");
        com.tencent.mm.ui.base.g.a(this.mContext, com.tencent.mm.bg.a.V(this.mContext, R.l.dSR), "", com.tencent.mm.bg.a.V(this.mContext, R.l.dSN), null);
    }

    public final void bUJ() {
        w.i("MicroMsg.ChattingQQMailFooterHandler", "dz[initQQMailDownloadUrlAndMD5]");
        com.tencent.mm.sdk.f.e.post(new Runnable(this) {
            final /* synthetic */ dc vGA;

            {
                this.vGA = r1;
            }

            public final void run() {
                Throwable th;
                Throwable th2;
                HttpURLConnection httpURLConnection = null;
                try {
                    HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(this.vGA.oFz).openConnection();
                    try {
                        httpURLConnection2.setInstanceFollowRedirects(false);
                        httpURLConnection2.connect();
                        this.vGA.oFA = httpURLConnection2.getHeaderField("Location");
                        InputStream inputStream = httpURLConnection2.getInputStream();
                        int headerFieldInt = httpURLConnection2.getHeaderFieldInt("Content-Length", -1);
                        if (headerFieldInt <= 0) {
                            w.e("MicroMsg.ChattingQQMailFooterHandler", "error content-length");
                            inputStream.close();
                        } else {
                            byte[] bArr = new byte[headerFieldInt];
                            inputStream.read(bArr);
                            inputStream.close();
                            byte[] a = l.a(Base64.decode(bArr, 0), l.l(this.vGA.mContext, "rsa_public_key_forwx.pem"));
                            this.vGA.oFB = new String(a);
                            af.v(new Runnable(this) {
                                final /* synthetic */ AnonymousClass6 vGB;

                                {
                                    this.vGB = r1;
                                }

                                public final void run() {
                                    if (bg.mA(this.vGB.vGA.oFA) || bg.mA(this.vGB.vGA.oFB)) {
                                        this.vGB.vGA.bUI();
                                        return;
                                    }
                                    dc dcVar = this.vGB.vGA;
                                    w.i("MicroMsg.ChattingQQMailFooterHandler", "dz[downloadQQMail]");
                                    com.tencent.mm.plugin.downloader.model.f.a aVar = new com.tencent.mm.plugin.downloader.model.f.a();
                                    aVar.tL(dcVar.oFA);
                                    aVar.tN(dcVar.mContext.getResources().getString(R.l.ebT));
                                    aVar.tO(dcVar.oFB);
                                    aVar.dn(true);
                                    aVar.la(1);
                                    dcVar.lgm = e.akM().a(aVar.kHa);
                                    if (dcVar.lgm > 0) {
                                        dcVar.hgx = dcVar.mContext.getSharedPreferences("QQMAIL", 4);
                                        dcVar.hgx.edit().putLong("qqmail_downloadid", dcVar.lgm).apply();
                                        dcVar.bUH();
                                    }
                                }
                            });
                        }
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                    } catch (Throwable e) {
                        th = e;
                        httpURLConnection = httpURLConnection2;
                        th2 = th;
                        try {
                            w.printErrStackTrace("MicroMsg.ChattingQQMailFooterHandler", th2, "", new Object[0]);
                            this.vGA.bUI();
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            throw th2;
                        }
                    } catch (Throwable e2) {
                        th = e2;
                        httpURLConnection = httpURLConnection2;
                        th2 = th;
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        throw th2;
                    }
                } catch (Exception e3) {
                    th2 = e3;
                    w.printErrStackTrace("MicroMsg.ChattingQQMailFooterHandler", th2, "", new Object[0]);
                    this.vGA.bUI();
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                }
            }
        }, "QQMailDownloadUrlAndMD5");
    }

    public final void bUK() {
        if (this.vGt == 0) {
            this.vGq.setText(R.l.dSV);
        } else if (this.vGt > 99) {
            this.vGq.setText(R.l.dSU);
        } else {
            this.vGq.setText(String.format(com.tencent.mm.bg.a.V(this.mContext, R.l.dST), new Object[]{Integer.valueOf(this.vGt)}));
        }
    }
}
