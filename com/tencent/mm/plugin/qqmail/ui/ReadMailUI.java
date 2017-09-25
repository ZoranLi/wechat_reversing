package com.tencent.mm.plugin.qqmail.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.a.l;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.qqmail.b.p;
import com.tencent.mm.plugin.qqmail.stub.QQMailStubProxyUI;
import com.tencent.mm.plugin.qqmail.stub.ReadMailProxy;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebView.HitTestResult;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

public class ReadMailUI extends MMActivity implements OnCreateContextMenuListener {
    private static String oFH = "var mail_css = document.createElement(\"style\");";
    private static String oFI = "";
    private static String oFJ = "";
    private static float oFK;
    private static int oFL;
    private long fGM = -1;
    private ae handler;
    private SharedPreferences hgx;
    private TextView lle;
    private d lvq = new d(this);
    private long mwB = -1;
    private String oFA;
    private String oFB;
    private int oFC = 0;
    private String oFD;
    private aj oFE;
    private int oFF = 0;
    private int oFG = 0;
    private ReadMailProxy oFM;
    private String oFN;
    private int oFO;
    private String oFd;
    private MailMMWebView oFe;
    private ProgressBar oFf;
    private ImageView oFg;
    private TextView oFh;
    private MailAddrsViewControl oFi;
    private MailAddrsViewControl oFj;
    private MailAddrsViewControl oFk;
    private TextView oFl;
    private View oFm;
    private LinearLayout oFn;
    private TextView oFo;
    private TextView oFp;
    private LinearLayout oFq;
    private MailAttachListLinearLayout oFr;
    private View oFs;
    private TextView oFt;
    private TextView oFu;
    private View oFv;
    private long oFw = -1;
    private int oFx;
    private int oFy;
    private String oFz;
    private String ozl;
    private String ozq;

    public class b {
        public final /* synthetic */ ReadMailUI oFP;

        public b(ReadMailUI readMailUI) {
            this.oFP = readMailUI;
        }
    }

    public class c {
        final /* synthetic */ ReadMailUI oFP;

        public c(ReadMailUI readMailUI) {
            this.oFP = readMailUI;
        }
    }

    private class a extends com.tencent.mm.plugin.qqmail.b.p.a {
        final /* synthetic */ ReadMailUI oFP;
        public int oFX;

        public a(ReadMailUI readMailUI, int i) {
            this.oFP = readMailUI;
            this.oFX = i;
        }

        public final void onSuccess(String str, final Map<String, String> map) {
            w.d("MicroMsg.ReadMailUI", "onSuccess userData = %d", new Object[]{Integer.valueOf(this.oFX)});
            switch (this.oFX) {
                case 1:
                    ReadMailUI.a(this.oFP, new Runnable(this) {
                        final /* synthetic */ a oFZ;

                        public final void run() {
                            if (this.oFZ.oFP.oFd.equals(this.oFZ.oFP.ozl)) {
                                if (this.oFZ.oFP.oFk.oEd.size() == 0) {
                                    this.oFZ.oFP.oFk.a(ReadMailUI.a(map, ".Response.result.tolist", bg.getInt((String) map.get(".Response.result.tolistlen"), 0)), true);
                                }
                                if (this.oFZ.oFP.oFj.oEd.size() == 0) {
                                    String[] b = ReadMailUI.a(map, ".Response.result.cclist", bg.getInt((String) map.get(".Response.result.cclistlen"), 0));
                                    LinearLayout e = this.oFZ.oFP.oFn;
                                    int i = (b == null || b.length == 0) ? 8 : 0;
                                    e.setVisibility(i);
                                    this.oFZ.oFP.oFj.a(b, true);
                                }
                                String str = (String) map.get(".Response.result.content");
                                ReadMailUI.a(this.oFZ.oFP, map);
                                String str2 = (String) map.get(".Response.result.tips.wording");
                                if (!bg.mA(str2)) {
                                    if ("1".equals((String) map.get(".Response.result.tips.color"))) {
                                        this.oFZ.oFP.oFh.setBackgroundColor(-13627);
                                        this.oFZ.oFP.oFh.setTextColor(-7515315);
                                    }
                                    this.oFZ.oFP.oFh.setText(str2);
                                    ((View) this.oFZ.oFP.oFh.getParent()).setVisibility(0);
                                }
                                this.oFZ.oFP.oFe.loadDataWithBaseURL(p.aUt() + "?pageWidth=" + ReadMailUI.oFK, "<html style=\"margin-top:" + ReadMailUI.oFL + "px\">" + str + "</html>", "text/html", ProtocolPackage.ServerEncoding, null);
                            }
                        }
                    });
                    return;
                case 2:
                    this.oFP.handler.post(new Runnable(this) {
                        final /* synthetic */ a oFZ;

                        {
                            this.oFZ = r1;
                        }

                        public final void run() {
                            this.oFZ.oFP.oFp.setEnabled(false);
                            this.oFZ.oFP.oFp.setText(R.l.eIs);
                            this.oFZ.oFP.oFp.setTextColor(-7829368);
                            this.oFZ.oFP.oFp.setCompoundDrawablesWithIntrinsicBounds(com.tencent.mm.bg.a.a(this.oFZ.oFP, R.g.bjx), null, null, null);
                        }
                    });
                    break;
            }
            w.e("MicroMsg.ReadMailUI", "onSuccess, invalid userData = %d", new Object[]{Integer.valueOf(this.oFX)});
        }

        public final void onError(final int i, final String str) {
            w.d("MicroMsg.ReadMailUI", "onError errCode = %d, userData = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(this.oFX)});
            this.oFP.handler.post(new Runnable(this) {
                final /* synthetic */ a oFZ;

                public final void run() {
                    if (!this.oFZ.oFP.isFinishing()) {
                        Intent intent;
                        switch (this.oFZ.oFX) {
                            case 1:
                                this.oFZ.oFP.oFg.setVisibility(0);
                                if (i == -5) {
                                    intent = new Intent(this.oFZ.oFP, QQMailStubProxyUI.class);
                                    intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                                    this.oFZ.oFP.startActivityForResult(intent, 1);
                                    return;
                                }
                                if (i == -7) {
                                    this.oFZ.oFP.oFg.setVisibility(8);
                                    try {
                                        new ReadMailProxy(this.oFZ.oFP.lvq, null).REMOTE_CALL("replaceMsgContent", Long.valueOf(this.oFZ.oFP.fGM), str);
                                    } catch (Exception e) {
                                        w.w("MicroMsg.ReadMailUI", "replaceMsgContent fail, ex = %s", new Object[]{e.getMessage()});
                                    }
                                }
                                if (i == -10005 && !am.isConnected(this.oFZ.oFP)) {
                                    Toast.makeText(this.oFZ.oFP, this.oFZ.oFP.getString(R.l.elv, new Object[]{Integer.valueOf(2), Integer.valueOf(i)}), 1).show();
                                }
                                this.oFZ.oFP.oFe.loadDataWithBaseURL(p.aUt(), str + "(" + i + ")", "text/html", ProtocolPackage.ServerEncoding, null);
                                return;
                            case 2:
                                if (i == -5) {
                                    intent = new Intent(this.oFZ.oFP, QQMailStubProxyUI.class);
                                    intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                                    this.oFZ.oFP.startActivityForResult(intent, 2);
                                    return;
                                }
                                Toast.makeText(this.oFZ.oFP, str, 1).show();
                                return;
                            default:
                                w.e("MicroMsg.ReadMailUI", "onError invalid userData = %d", new Object[]{Integer.valueOf(this.oFZ.oFX)});
                                return;
                        }
                    }
                }
            });
        }

        public final boolean onReady() {
            this.oFP.handler.post(new Runnable(this) {
                final /* synthetic */ a oFZ;

                {
                    this.oFZ = r1;
                }

                public final void run() {
                    ReadMailUI.a(this.oFZ.oFP, new HashMap());
                }
            });
            return true;
        }

        public final void onComplete() {
            this.oFP.handler.post(new Runnable(this) {
                final /* synthetic */ a oFZ;

                {
                    this.oFZ = r1;
                }

                public final void run() {
                    this.oFZ.oFP.oFf.setVisibility(8);
                    this.oFZ.oFP.oFw = -2;
                }
            });
        }
    }

    static /* synthetic */ void E(ReadMailUI readMailUI) {
        readMailUI.hgx = ab.getContext().getSharedPreferences("QQMAIL", 4);
        if (readMailUI.hgx != null) {
            bg.i(readMailUI.hgx.getString("qqmail_downloadpath", ""), readMailUI);
        }
    }

    static /* synthetic */ void F(ReadMailUI readMailUI) {
        final Intent intent = new Intent();
        if (bg.mA(readMailUI.oFN)) {
            w.w("MicroMsg.ReadMailUI", "mQQMailSchemeForUnread is null");
            readMailUI.startActivity(readMailUI.getPackageManager().getLaunchIntentForPackage("com.tencent.androidqqmail"));
            return;
        }
        w.d("MicroMsg.ReadMailUI", "qq mail scheme:%s", new Object[]{readMailUI.oFN.replace("$uin$", (String) new ReadMailProxy(readMailUI.lvq, new a(readMailUI, 1)).REMOTE_CALL("getBindUin", new Object[0]))});
        intent.setData(Uri.parse(r0));
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        if (VERSION.SDK_INT >= 11) {
            intent.addFlags(WXMediaMessage.THUMB_LENGTH_LIMIT);
        }
        if (bg.j(readMailUI, intent)) {
            com.tencent.mm.bk.a.post(new Runnable(readMailUI) {
                final /* synthetic */ ReadMailUI oFP;

                public final void run() {
                    g.a(this.oFP, intent, this.oFP.getString(R.l.dSV), 1, null, null);
                }
            });
            return;
        }
        w.w("MicroMsg.ReadMailUI", "schema failed");
        com.tencent.mm.bk.a.post(new Runnable(readMailUI) {
            final /* synthetic */ ReadMailUI oFP;

            {
                this.oFP = r1;
            }

            public final void run() {
                g.a(this.oFP, this.oFP.getPackageManager().getLaunchIntentForPackage("com.tencent.androidqqmail"), this.oFP.getString(R.l.dSV), 1, null, null);
            }
        });
    }

    static /* synthetic */ void J(ReadMailUI readMailUI) {
        try {
            new ReadMailProxy(readMailUI.lvq, null).REMOTE_CALL("deleteMsgById", Long.valueOf(readMailUI.fGM));
        } catch (Exception e) {
            w.w("MicroMsg.ReadMailUI", "doDelete fail, ex = %s", new Object[]{e.getMessage()});
        }
        readMailUI.finish();
    }

    static /* synthetic */ void a(ReadMailUI readMailUI, final Runnable runnable) {
        CookieSyncManager.createInstance(readMailUI);
        final CookieManager instance = CookieManager.getInstance();
        instance.removeSessionCookie();
        readMailUI.handler.postDelayed(new Runnable(readMailUI) {
            final /* synthetic */ ReadMailUI oFP;

            public final void run() {
                Map map = null;
                if (!this.oFP.isFinishing()) {
                    try {
                        map = (Map) new ReadMailProxy(this.oFP.lvq, null).REMOTE_CALL("getCookie", new Object[0]);
                    } catch (Exception e) {
                        w.w("MicroMsg.ReadMailUI", "getCookie, ex = %s", new Object[]{e.getMessage()});
                    }
                    if (map != null) {
                        instance.setCookie(p.aUt(), "skey=" + ((String) map.get("skey")));
                        instance.setCookie(p.aUt(), "uin=" + ((String) map.get(OpenSDKTool4Assistant.EXTRA_UIN)));
                        instance.setCookie(p.aUt(), "svrid=" + ((String) map.get("svrid")));
                        CookieSyncManager.getInstance().sync();
                    }
                    if (!this.oFP.isFinishing() && this.oFP.oFe != null) {
                        runnable.run();
                    }
                }
            }
        }, 500);
    }

    static /* synthetic */ void a(ReadMailUI readMailUI, Map map) {
        if (bg.getInt(bg.ap((String) map.get(".Response.result.attachlen"), "0"), 0) == 0) {
            readMailUI.oFq.setVisibility(8);
            return;
        }
        readMailUI.oFq.setVisibility(0);
        ((TextView) readMailUI.findViewById(R.h.cvN)).setText(readMailUI.getString(R.l.eIk, new Object[]{Integer.valueOf(r3)}));
        readMailUI.oFr.removeAllViews();
        MailAttachListLinearLayout mailAttachListLinearLayout = readMailUI.oFr;
        int i = bg.getInt(bg.ap((String) map.get(".Response.result.attachlen"), "0"), 0);
        if (i == 0) {
            w.i("MicroMsg.MailAttachListLinearLayout", "inflate, attachLen = 0");
            return;
        }
        int i2 = 0;
        while (i2 < i) {
            StringBuffer stringBuffer = new StringBuffer(".Response.result.attachlist.item");
            if (i2 != 0) {
                stringBuffer.append(i2);
            }
            String stringBuffer2 = stringBuffer.toString();
            if (map.get(stringBuffer2) == null) {
                w.e("MicroMsg.MailAttachListLinearLayout", "item is null, itemKey = " + stringBuffer2);
                return;
            }
            View inflate = View.inflate(mailAttachListLinearLayout.context, R.i.dmb, null);
            if (i == 1 || i2 >= i - 1) {
                inflate.setBackgroundResource(R.g.bgT);
            } else {
                inflate.setBackgroundResource(R.g.bgS);
            }
            mailAttachListLinearLayout.addView(inflate);
            String str = (String) map.get(stringBuffer2 + ".name");
            long j = bg.getLong((String) map.get(stringBuffer2 + ".size"), 0);
            ((TextView) inflate.findViewById(R.h.cvP)).setText(str);
            ((TextView) inflate.findViewById(R.h.cvQ)).setText(bg.ay(j));
            String str2 = (String) map.get(stringBuffer2 + ".path");
            String dg = MailAttachListLinearLayout.dg(str2, "mailid");
            map.get(stringBuffer2 + ".type");
            String str3 = "";
            try {
                str3 = URLDecoder.decode(MailAttachListLinearLayout.dg(str2, "attachid"), ProtocolPackage.ServerEncoding);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.MailAttachListLinearLayout", e, "", new Object[0]);
            }
            mailAttachListLinearLayout.oEu.add(str);
            inflate.setOnClickListener(new com.tencent.mm.plugin.qqmail.ui.MailAttachListLinearLayout.AnonymousClass1(mailAttachListLinearLayout, str, dg, str3, j, bg.getInt(bg.ap((String) map.get(stringBuffer2 + ".preview"), "0"), 0), str2));
            ((ImageView) inflate.findViewById(R.h.cvO)).setImageResource(FileExplorerUI.Nl(str));
            i2++;
        }
    }

    static /* synthetic */ void q(ReadMailUI readMailUI) {
        readMailUI.oFp.setOnClickListener(new OnClickListener(readMailUI) {
            final /* synthetic */ ReadMailUI oFP;

            {
                this.oFP = r1;
            }

            public final void onClick(View view) {
                this.oFP.aVp();
            }
        });
        readMailUI.oFg.setOnClickListener(new OnClickListener(readMailUI) {
            final /* synthetic */ ReadMailUI oFP;

            {
                this.oFP = r1;
            }

            public final void onClick(View view) {
                this.oFP.oFg.setVisibility(8);
                this.oFP.a(new com.tencent.mm.plugin.qqmail.b.p.c());
            }
        });
        readMailUI.a(0, R.g.bhb, new OnMenuItemClickListener(readMailUI) {
            final /* synthetic */ ReadMailUI oFP;

            {
                this.oFP = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                com.tencent.mm.ui.base.g.a(this.oFP, null, this.oFP.getResources().getStringArray(R.c.aSe), this.oFP.getResources().getString(R.l.eIm), false, new com.tencent.mm.ui.base.g.c(this) {
                    final /* synthetic */ AnonymousClass13 oFV;

                    {
                        this.oFV = r1;
                    }

                    public final void hq(int i) {
                        int i2 = 0;
                        if (i == 3) {
                            ReadMailUI.J(this.oFV.oFP);
                            return;
                        }
                        Intent intent = new Intent();
                        intent.setClass(this.oFV.oFP, ComposeUI.class);
                        intent.putExtra("mailid", this.oFV.oFP.ozl);
                        intent.putExtra("subject", this.oFV.oFP.ozq);
                        String[] a = this.oFV.oFP.oFi.a(false, this.oFV.oFP.lvq);
                        String[] a2 = this.oFV.oFP.oFk.a(true, this.oFV.oFP.lvq);
                        String[] a3 = this.oFV.oFP.oFj.a(true, this.oFV.oFP.lvq);
                        switch (i) {
                            case 0:
                                intent.putExtra("composeType", 2);
                                intent.putExtra("toList", a);
                                break;
                            case 1:
                                int i3;
                                intent.putExtra("composeType", 2);
                                String[] strArr = new String[(a.length + a2.length)];
                                int length = a.length;
                                int i4 = 0;
                                int i5 = 0;
                                while (i4 < length) {
                                    i3 = i5 + 1;
                                    strArr[i5] = a[i4];
                                    i4++;
                                    i5 = i3;
                                }
                                i3 = a2.length;
                                while (i2 < i3) {
                                    i4 = i5 + 1;
                                    strArr[i5] = a2[i2];
                                    i2++;
                                    i5 = i4;
                                }
                                intent.putExtra("toList", strArr);
                                intent.putExtra("ccList", a3);
                                break;
                            case 2:
                                intent.putExtra("composeType", 3);
                                break;
                            default:
                                return;
                        }
                        this.oFV.oFP.startActivity(intent);
                    }
                });
                return false;
            }
        });
        if (readMailUI.oFw != -2) {
            String str;
            if (!(readMailUI.oFw == -1 || readMailUI.oFw == -2)) {
                try {
                    new ReadMailProxy(readMailUI.lvq, new a(readMailUI, 0)).REMOTE_CALL("cancel", Long.valueOf(readMailUI.oFw));
                } catch (Exception e) {
                    w.w("MicroMsg.ReadMailUI", "render cancel, ex = %s", new Object[]{e.getMessage()});
                }
            }
            try {
                str = (String) new ReadMailProxy(readMailUI.lvq, null).REMOTE_CALL("getMsgContent", Long.valueOf(readMailUI.fGM));
            } catch (Exception e2) {
                w.w("MicroMsg.ReadMailUI", "render, getMsgContent, ex = %s", new Object[]{e2.getMessage()});
                str = null;
            }
            Map q = bh.q(str, "msg");
            if (q == null) {
                w.e("MicroMsg.ReadMailUI", "render fail, maps is null");
                return;
            }
            readMailUI.qP("");
            readMailUI.ozl = (String) q.get(".msg.pushmail.mailid");
            readMailUI.ozq = (String) q.get(".msg.pushmail.content.subject");
            readMailUI.oFi.a(new String[]{((String) q.get(".msg.pushmail.content.fromlist.item.name")) + " " + ((String) q.get(".msg.pushmail.content.fromlist.item.addr"))}, true);
            readMailUI.oFk.a(a(q, ".msg.pushmail.content.tolist", bg.getInt((String) q.get(".msg.pushmail.content.tolist.$count"), 0)), true);
            String[] a = a(q, ".msg.pushmail.content.cclist", bg.getInt((String) q.get(".msg.pushmail.content.cclist.$count"), 0));
            LinearLayout linearLayout = readMailUI.oFn;
            int i = (a == null || a.length == 0) ? 8 : 0;
            linearLayout.setVisibility(i);
            readMailUI.oFj.a(a, true);
            readMailUI.oFo.setText(readMailUI.ozq);
            readMailUI.lle.setText((CharSequence) q.get(".msg.pushmail.content.date"));
            readMailUI.oFp.setEnabled(true);
            readMailUI.a(new com.tencent.mm.plugin.qqmail.b.p.c());
        }
    }

    static /* synthetic */ void s(ReadMailUI readMailUI) {
        readMailUI.hgx = ab.getContext().getSharedPreferences("QQMAIL", 4);
        if (readMailUI.hgx != null) {
            long j = readMailUI.hgx.getLong("qqmail_info_report_time", -1);
            long currentTimeMillis = System.currentTimeMillis();
            if (j < 0 || currentTimeMillis - j > 86400000) {
                if (com.tencent.mm.pluginsdk.model.app.p.n(readMailUI, "com.tencent.androidqqmail")) {
                    int i = com.tencent.mm.pluginsdk.model.app.p.az(readMailUI, "com.tencent.androidqqmail").versionCode;
                    w.d("MicroMsg.ReadMailUI", "is intalled:%d, version:%d", new Object[]{Integer.valueOf(1), Integer.valueOf(i)});
                    new ReadMailProxy(readMailUI.lvq, null).REMOTE_CALL("reportKvStates", Integer.valueOf(11389), Integer.valueOf(1), Integer.valueOf(i));
                } else {
                    w.d("MicroMsg.ReadMailUI", "is intalled:%d", new Object[]{Integer.valueOf(0)});
                    readMailUI.cK(11389, 0);
                }
                readMailUI.hgx.edit().putLong("qqmail_info_report_time", currentTimeMillis).commit();
            }
        }
    }

    static /* synthetic */ void z(ReadMailUI readMailUI) {
        readMailUI.mwB = ((Long) new ReadMailProxy(readMailUI.lvq, null).REMOTE_CALL("downloadQQMailApp", readMailUI.oFA, readMailUI.oFB)).longValue();
        if (readMailUI.mwB <= 0) {
            w.e("MicroMsg.ReadMailUI", "doAddDownloadTask fail, downloadId = %d ", new Object[]{Long.valueOf(readMailUI.mwB)});
            return;
        }
        readMailUI.hgx = ab.getContext().getSharedPreferences("QQMAIL", 4);
        if (readMailUI.hgx != null) {
            readMailUI.hgx.edit().putLong("qqmail_downloadid", readMailUI.mwB).commit();
        }
        readMailUI.oFG = 1;
        readMailUI.oFC = ((Integer) new ReadMailProxy(readMailUI.lvq, null).REMOTE_CALL("getMailAppDownloadStatus", Long.valueOf(readMailUI.mwB))).intValue();
        readMailUI.oFs.setVisibility(0);
        readMailUI.aVs();
        readMailUI.aVo();
    }

    private void aVo() {
        switch (this.oFG) {
            case 0:
                this.oFu.setText(R.l.eIp);
                return;
            case 1:
                this.oFu.setText(R.l.eIn);
                return;
            case 2:
                this.oFu.setText(R.l.eIo);
                return;
            case 3:
                String str = "";
                if (this.oFO > 99) {
                    str = "99+";
                } else if (this.oFO > 0) {
                    str = Integer.toString(this.oFO);
                }
                if (bg.mA(str)) {
                    this.oFu.setText(R.l.eIq);
                    return;
                }
                this.oFu.setText(String.format(com.tencent.mm.bg.a.V(this, R.l.eIr), new Object[]{str}));
                return;
            default:
                return;
        }
    }

    protected final int getLayoutId() {
        return R.i.dma;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.handler = new ae();
        this.fGM = getIntent().getLongExtra("msgid", -1);
        this.oFx = 0;
        this.oFy = 0;
        KC();
        this.lvq.G(new Runnable(this) {
            final /* synthetic */ ReadMailUI oFP;

            {
                this.oFP = r1;
            }

            public final void run() {
                ReadMailUI.q(this.oFP);
                if (this.oFP.oFy == 0) {
                    ReadMailUI.s(this.oFP);
                    if (!this.oFP.aVq()) {
                        this.oFP.aVr();
                    }
                    this.oFP.oFM = new ReadMailProxy(this.oFP.lvq, null, new b(this.oFP), new c(this.oFP));
                    this.oFP.oFM.REMOTE_CALL("addDownloadCallback", new Object[0]);
                }
            }
        });
    }

    protected void onPause() {
        super.onPause();
        if (this.oFw != -1 && this.oFw != -2) {
            try {
                new ReadMailProxy(this.lvq, new a(this, 0)).REMOTE_CALL("cancel", Long.valueOf(this.oFw));
            } catch (Exception e) {
                w.w("MicroMsg.ReadMailUI", "cancel, ex = %s", new Object[]{e.getMessage()});
            }
        }
    }

    protected void onStop() {
        super.onStop();
        this.oFe.stopLoading();
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.oFM != null) {
            this.oFM.REMOTE_CALL("removeDownloadCallback", new Object[0]);
        }
        this.lvq.release();
        this.oFe.setVisibility(8);
        this.oFe.destroy();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (i == 1) {
                w.d("MicroMsg.ReadMailUI", "USER_DATA_READMAIL onAfterVerify");
                a(new com.tencent.mm.plugin.qqmail.b.p.c());
            } else if (i == 2) {
                w.d("MicroMsg.ReadMailUI", "USER_DATA_SETUNREAD onAfterVerify");
                aVp();
            }
        }
    }

    protected final void KC() {
        this.oFi = (MailAddrsViewControl) findViewById(R.h.cum);
        this.oFk = (MailAddrsViewControl) findViewById(R.h.cun);
        this.oFj = (MailAddrsViewControl) findViewById(R.h.cul);
        this.oFl = (TextView) findViewById(R.h.cvU);
        this.oFm = findViewById(R.h.cvW);
        this.oFn = (LinearLayout) findViewById(R.h.cvT);
        this.oFo = (TextView) findViewById(R.h.cvZ);
        this.lle = (TextView) findViewById(R.h.cwa);
        this.oFp = (TextView) findViewById(R.h.cvY);
        this.oFq = (LinearLayout) findViewById(R.h.cvS);
        this.oFr = (MailAttachListLinearLayout) findViewById(R.h.cvR);
        this.oFf = (ProgressBar) findViewById(R.h.cvV);
        this.oFg = (ImageView) findViewById(R.h.cvX);
        this.oFh = (TextView) findViewById(R.h.cwb);
        int i = R.h.cwc;
        MMWebViewWithJsApi.fh(this);
        MMWebViewWithJsApi mMWebViewWithJsApi = (MMWebViewWithJsApi) findViewById(i);
        mMWebViewWithJsApi.gRU = true;
        mMWebViewWithJsApi.wwS = mMWebViewWithJsApi.getX5WebViewExtension() != null;
        this.oFe = (MailMMWebView) mMWebViewWithJsApi;
        this.oFv = findViewById(R.h.cgL);
        this.oFs = findViewById(R.h.cgG);
        this.oFu = (TextView) findViewById(R.h.cgI);
        this.oFt = (TextView) findViewById(R.h.cgH);
        this.oFs.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ReadMailUI oFP;

            {
                this.oFP = r1;
            }

            public final void onClick(View view) {
                switch (this.oFP.oFG) {
                    case 0:
                        this.oFP.cK(11288, 2);
                        if (bg.mA(this.oFP.oFA) || bg.mA(this.oFP.oFB)) {
                            e.post(new Runnable(this.oFP) {
                                final /* synthetic */ ReadMailUI oFP;

                                {
                                    this.oFP = r1;
                                }

                                public final void run() {
                                    Throwable th;
                                    Throwable th2;
                                    HttpURLConnection httpURLConnection = null;
                                    try {
                                        HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(this.oFP.oFz).openConnection();
                                        try {
                                            httpURLConnection2.setInstanceFollowRedirects(false);
                                            httpURLConnection2.connect();
                                            this.oFP.oFA = httpURLConnection2.getHeaderField("Location");
                                            InputStream inputStream = httpURLConnection2.getInputStream();
                                            int headerFieldInt = httpURLConnection2.getHeaderFieldInt("Content-Length", -1);
                                            if (headerFieldInt <= 0) {
                                                w.e("MicroMsg.ReadMailUI", "error content-length");
                                                inputStream.close();
                                                httpURLConnection2.disconnect();
                                                if (httpURLConnection2 != null) {
                                                    httpURLConnection2.disconnect();
                                                    return;
                                                }
                                                return;
                                            }
                                            byte[] bArr = new byte[headerFieldInt];
                                            inputStream.read(bArr);
                                            inputStream.close();
                                            w.i("MicroMsg.ReadMailUI", "dz[mQQMailDownloadUrl:%s]", new Object[]{this.oFP.oFA});
                                            this.oFP.oFB = new String(l.a(Base64.decode(bArr, 0), l.l(this.oFP.getApplicationContext(), "rsa_public_key_forwx.pem")));
                                            w.i("MicroMsg.ReadMailUI", "dz[mQQMailMD5:%s]", new Object[]{this.oFP.oFB});
                                            af.v(new Runnable(this) {
                                                final /* synthetic */ AnonymousClass3 oFR;

                                                {
                                                    this.oFR = r1;
                                                }

                                                public final void run() {
                                                    ReadMailUI.z(this.oFR.oFP);
                                                }
                                            });
                                            if (httpURLConnection2 != null) {
                                                httpURLConnection2.disconnect();
                                            }
                                        } catch (Throwable e) {
                                            th = e;
                                            httpURLConnection = httpURLConnection2;
                                            th2 = th;
                                            try {
                                                w.printErrStackTrace("MicroMsg.ReadMailUI", th2, "", new Object[0]);
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
                                        w.printErrStackTrace("MicroMsg.ReadMailUI", th2, "", new Object[0]);
                                        if (httpURLConnection != null) {
                                            httpURLConnection.disconnect();
                                        }
                                    }
                                }
                            }, "initQQMailDownloadUrlAndMD5");
                            return;
                        } else {
                            ReadMailUI.z(this.oFP);
                            return;
                        }
                    case 1:
                        this.oFP.cK(11288, 1);
                        int intValue = ((Integer) new ReadMailProxy(this.oFP.lvq, null).REMOTE_CALL("removeDownloadQQMailAppTask", Long.valueOf(this.oFP.mwB))).intValue();
                        if (intValue == -1) {
                            w.e("MicroMsg.ReadMailUI", "cancel_download_task:fail_apilevel_too_low downloadId = %d", new Object[]{Long.valueOf(this.oFP.mwB)});
                            return;
                        } else if (intValue <= 0) {
                            w.e("MicroMsg.ReadMailUI", "cancel_download_task:fail downloadId = %d", new Object[]{Long.valueOf(this.oFP.mwB)});
                            return;
                        } else {
                            w.i("MicroMsg.ReadMailUI", "cancel_download_task:ok downloadId = %d", new Object[]{Long.valueOf(this.oFP.mwB)});
                            this.oFP.oFE.KH();
                            this.oFP.rH(0);
                            this.oFP.oFG = 0;
                            this.oFP.aVo();
                            return;
                        }
                    case 2:
                        this.oFP.cK(11288, 3);
                        ReadMailUI.E(this.oFP);
                        return;
                    case 3:
                        this.oFP.cK(11288, 4);
                        ReadMailUI.F(this.oFP);
                        return;
                    default:
                        return;
                }
            }
        });
        this.oFl.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ReadMailUI oFP;

            {
                this.oFP = r1;
            }

            public final void onClick(View view) {
                if (this.oFP.oFm.getVisibility() == 8) {
                    this.oFP.oFl.setText(R.l.eIi);
                    this.oFP.oFm.setVisibility(0);
                    this.oFP.oFm.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass8 oFT;

                        {
                            this.oFT = r1;
                        }

                        public final void run() {
                            this.oFT.oFP.oFk.aVi();
                            this.oFT.oFP.oFj.aVi();
                        }
                    });
                    this.oFP.oFp.setVisibility(0);
                    return;
                }
                this.oFP.oFl.setText(R.l.eIj);
                this.oFP.oFm.setVisibility(8);
                this.oFP.oFp.setVisibility(8);
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ReadMailUI oFP;

            {
                this.oFP = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.oFP.finish();
                return true;
            }
        });
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        oFK = ((float) displayMetrics.widthPixels) / displayMetrics.scaledDensity;
        oFL = displayMetrics.heightPixels;
        this.oFe.getSettings().setDefaultTextEncodingName(ProtocolPackage.ServerEncoding);
        this.oFe.getSettings().setSupportZoom(false);
        this.oFe.getSettings().setBuiltInZoomControls(false);
        this.oFe.getSettings().setDisplayZoomControls(false);
        this.oFe.getSettings().setLoadsImagesAutomatically(false);
        this.oFe.getSettings().setUseWideViewPort(true);
        this.oFe.caH();
        MailMMWebView mailMMWebView = this.oFe;
        View view = this.oFv;
        if (view != null) {
            if (mailMMWebView.oEO != null) {
                mailMMWebView.removeView(mailMMWebView.oEO);
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            mailMMWebView.oEO = new a(mailMMWebView, mailMMWebView.getContext());
            ((a) mailMMWebView.oEO).addView(view, new FrameLayout.LayoutParams(-1, -2));
            mailMMWebView.oEO.setBackgroundColor(-1);
            mailMMWebView.addView(mailMMWebView.oEO, layoutParams);
        }
        mailMMWebView = this.oFe;
        view = this.oFs;
        if (view != null) {
            if (mailMMWebView.oEP != null) {
                mailMMWebView.removeView(mailMMWebView.oEP);
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            layoutParams = new FrameLayout.LayoutParams(-1, -2, 80);
            mailMMWebView.oEP = new a(mailMMWebView, mailMMWebView.getContext());
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) view.getLayoutParams();
            LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
            layoutParams3.setMargins(layoutParams2.leftMargin, layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
            ((a) mailMMWebView.oEP).addView(view, layoutParams3);
            mailMMWebView.addView(mailMMWebView.oEP, layoutParams);
            mailMMWebView.oEP.setVisibility(4);
        }
        Intent intent = this.uSU.uTo.getIntent();
        byte[] bArr = new byte[MMGIFException.D_GIF_ERR_IMAGE_DEFECT];
        bArr[25] = (byte) 1;
        bArr[16] = (byte) 1;
        bArr[57] = (byte) 1;
        bArr[63] = (byte) 1;
        bArr[61] = (byte) 1;
        bArr[70] = (byte) 1;
        bArr[68] = (byte) 1;
        bArr[82] = (byte) 1;
        bArr[111] = (byte) 1;
        intent.putExtra("hardcode_jspermission", new JsapiPermissionWrapper(bArr));
        this.uSU.uTo.setIntent(intent);
        this.oFe.setWebViewClient(new com.tencent.mm.plugin.webview.ui.tools.widget.c(this, this.oFe) {
            final /* synthetic */ ReadMailUI oFP;

            public final boolean Db(String str) {
                w.d("MicroMsg.ReadMailUI", "url:%s", new Object[]{str});
                if (str != null && str.startsWith(WebView.SCHEME_MAILTO)) {
                    String replace = str.trim().replace(WebView.SCHEME_MAILTO, "");
                    Intent intent = new Intent(this.oFP, ComposeUI.class);
                    intent.putExtra("composeType", 4);
                    intent.putExtra("toList", new String[]{replace + " " + replace});
                    this.oFP.startActivity(intent);
                    return true;
                } else if (str != null && str.startsWith(WebView.SCHEME_TEL)) {
                    r1 = new Intent("android.intent.action.DIAL", Uri.parse(str));
                    r1.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                    this.oFP.startActivity(r1);
                    return true;
                } else if (str == null || str.startsWith("data:")) {
                    return false;
                } else {
                    if (this.oFP.oFe.oEN) {
                        this.oFP.oFe.oEN = false;
                        return true;
                    } else if (!str.startsWith("http")) {
                        return false;
                    } else {
                        r1 = new Intent();
                        r1.putExtra("rawUrl", str);
                        com.tencent.mm.bb.d.b(this.oFP, "webview", ".ui.tools.WebViewUI", r1);
                        return true;
                    }
                }
            }

            public final void onLoadResource(WebView webView, String str) {
                w.d("MicroMsg.ReadMailUI", "load res:%s", new Object[]{str});
            }

            public final void a(WebView webView, String str) {
                webView.evaluateJavascript("javascript:var meta = document.createElement(\"meta\");meta.name=\"viewport\";meta.id=\"viewport\";meta.content=\"initial-scale=1,user-scalable=yes,maximum-scale=3.0\";document.head.appendChild(meta);", null);
                webView.evaluateJavascript("javascript:" + ReadMailUI.oFH, null);
                webView.evaluateJavascript("javascript:" + ReadMailUI.oFI, null);
                webView.evaluateJavascript("javascript:" + ReadMailUI.oFJ, null);
                if (this.oFP.lvq.isConnected()) {
                    if (!this.oFP.aVq()) {
                        this.oFP.aVr();
                    }
                    this.oFP.oFM = new ReadMailProxy(this.oFP.lvq, null, new b(this.oFP), new c(this.oFP));
                    this.oFP.oFM.REMOTE_CALL("addDownloadCallback", new Object[0]);
                }
                new ae(this.oFP.getMainLooper()).postDelayed(new Runnable(this) {
                    final /* synthetic */ AnonymousClass10 oFU;

                    {
                        this.oFU = r1;
                    }

                    public final void run() {
                        this.oFU.oFP.oFe.getSettings().setLoadsImagesAutomatically(true);
                        this.oFU.oFP.oFe.getSettings().setSupportZoom(true);
                        this.oFU.oFP.oFe.getSettings().setBuiltInZoomControls(true);
                        this.oFU.oFP.oFe.aVm();
                        this.oFU.oFP.oFe.aVn();
                    }
                }, 200);
                new ae(this.oFP.getMainLooper()).postDelayed(new Runnable(this) {
                    final /* synthetic */ AnonymousClass10 oFU;

                    {
                        this.oFU = r1;
                    }

                    public final void run() {
                        int contentHeight = (int) (((float) this.oFU.oFP.oFe.getContentHeight()) * this.oFU.oFP.oFe.getScale());
                        w.d("MicroMsg.ReadMailUI", this.oFU.oFP.oFe.getContentHeight() + "," + this.oFU.oFP.oFe.getHeight() + "," + this.oFU.oFP.oFe.getScale());
                        if (Math.abs(contentHeight - this.oFU.oFP.oFe.getHeight()) < 10) {
                            this.oFU.oFP.oFe.gt(true);
                        }
                    }
                }, 400);
            }
        });
        if (oFI.equals("")) {
            try {
                oFI += bg.convertStreamToString(getAssets().open("mail/lib.js"));
                oFJ += bg.convertStreamToString(getAssets().open("mail/readmail.js"));
                oFH += "mail_css.innerHTML='" + bg.convertStreamToString(getAssets().open("mail/qmail_webview.css")) + "'; document.head.appendChild(mail_css);";
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.ReadMailUI", e, "", new Object[0]);
                w.e("MicroMsg.ReadMailUI", "evaluateJavascript error " + e.getMessage());
            }
        }
        registerForContextMenu(this.oFe);
        new com.tencent.mm.ui.tools.l(this).a(this.oFe, this, null);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        if (view instanceof WebView) {
            final HitTestResult hitTestResult = ((WebView) view).getHitTestResult();
            if (hitTestResult.getType() == 5 || hitTestResult.getType() == 8) {
                boolean booleanValue;
                try {
                    booleanValue = ((Boolean) new ReadMailProxy(this.lvq, null).REMOTE_CALL("isSDCardAvailable", new Object[0])).booleanValue();
                } catch (Exception e) {
                    w.w("MicroMsg.ReadMailUI", "createContextMenu, isSDCardAvailable, ex = %s", new Object[]{e.getMessage()});
                    booleanValue = false;
                }
                if (booleanValue) {
                    contextMenu.setHeaderTitle(R.l.fnH);
                    contextMenu.add(0, 0, 0, getString(R.l.eOm)).setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                        final /* synthetic */ ReadMailUI oFP;

                        public final boolean onMenuItemClick(MenuItem menuItem) {
                            boolean booleanValue;
                            String extra = hitTestResult.getExtra();
                            if (extra.contains("qqmail.weixin.qq.com") && !extra.contains("qqmail.weixin.qq.com:443")) {
                                extra = extra.replace("qqmail.weixin.qq.com", "qqmail.weixin.qq.com:443");
                            }
                            String replaceFirst = extra.replaceFirst("%p2p0", "%25p2p0");
                            try {
                                booleanValue = ((Boolean) new ReadMailProxy(this.oFP.lvq, null).REMOTE_CALL("isSDCardAvailable", new Object[0])).booleanValue();
                            } catch (Exception e) {
                                w.w("MicroMsg.ReadMailUI", "createContextMenu, isSDCardAvailable, ex = %s", new Object[]{e.getMessage()});
                                booleanValue = false;
                            }
                            s.a(this.oFP, replaceFirst, CookieManager.getInstance().getCookie(p.aUt()), booleanValue);
                            return true;
                        }
                    });
                } else {
                    return;
                }
            }
        }
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    private static String[] a(Map<String, String> map, String str, int i) {
        if (map.get(str) == null) {
            return null;
        }
        String[] strArr = new String[i];
        int i2 = 0;
        while (i2 < i) {
            String str2 = str + ".item" + (i2 > 0 ? Integer.valueOf(i2) : "");
            strArr[i2] = ((String) map.get(str2 + ".name")) + " " + ((String) map.get(str2 + ".addr"));
            i2++;
        }
        return strArr;
    }

    private void a(com.tencent.mm.plugin.qqmail.b.p.c cVar) {
        if (this.ozl == null || this.ozl.length() == 0) {
            w.e("MicroMsg.ReadMailUI", "doReadMail invalid argument");
            return;
        }
        this.oFg.setVisibility(8);
        this.oFf.setVisibility(0);
        Map hashMap = new HashMap();
        hashMap.put("mailid", this.ozl);
        hashMap.put("texttype", "html");
        if (!(this.oFw == -1 || this.oFw == -2)) {
            try {
                new ReadMailProxy(this.lvq, new a(this, 0)).REMOTE_CALL("cancel", Long.valueOf(this.oFw));
            } catch (Exception e) {
                w.w("MicroMsg.ReadMailUI", "cancel, ex = %s", new Object[]{e.getMessage()});
            }
        }
        this.oFd = this.ozl;
        cVar.toBundle(new Bundle());
        try {
            this.oFw = ((Long) new ReadMailProxy(this.lvq, new a(this, 1)).REMOTE_CALL("get", "/cgi-bin/readmail", hashMap, new Bundle())).longValue();
        } catch (Exception e2) {
            w.w("MicroMsg.ReadMailUI", "doReadMail get fail, ex = %s", new Object[]{e2.getMessage()});
        }
    }

    private void aVp() {
        if (this.ozl == null || this.ozl.length() == 0) {
            w.e("MicroMsg.ReadMailUI", "doSetUnread invalid argument");
            return;
        }
        new HashMap().put("mailid", this.ozl);
        com.tencent.mm.plugin.qqmail.b.p.c cVar = new com.tencent.mm.plugin.qqmail.b.p.c();
        cVar.oAr = false;
        cVar.toBundle(new Bundle());
        try {
            new ReadMailProxy(this.lvq, new a(this, 2)).REMOTE_CALL("get", "/cgi-bin/setmailunread", new HashMap(), new Bundle());
        } catch (Exception e) {
            w.w("MicroMsg.ReadMailUI", "doSetUnread, ex = %s", new Object[]{e.getMessage()});
        }
    }

    private boolean aVq() {
        this.oFz = (String) new ReadMailProxy(this.lvq, null).REMOTE_CALL("getMailAppRedirectUrlAndroid", new Object[0]);
        this.oFN = (String) new ReadMailProxy(this.lvq, null).REMOTE_CALL("getMailAppEnterUlAndroid", new Object[0]);
        try {
            this.oFO = ((Integer) new ReadMailProxy(this.lvq, null).REMOTE_CALL("getUneradMailCountFromConfig", new Object[0])).intValue();
        } catch (Throwable e) {
            this.oFO = -1;
            w.printErrStackTrace("MicroMsg.ReadMailUI", e, "getUneradMailCountFromConfig got an NullPointerException", new Object[0]);
        }
        new ReadMailProxy(this.lvq, null).REMOTE_CALL("getUnreadMailCount", new Object[0]);
        Integer num = (Integer) new ReadMailProxy(this.lvq, null).REMOTE_CALL("showMailAppRecommend", new Object[0]);
        if (num == null) {
            w.e("MicroMsg.ReadMailUI", "Remote server Proxy not ready");
            return true;
        }
        this.oFy = 1;
        this.oFx = num.intValue();
        if (bg.mA(this.oFN)) {
            return true;
        }
        if (com.tencent.mm.pluginsdk.model.app.p.n(this, "com.tencent.androidqqmail")) {
            this.oFG = 3;
            aVo();
            return true;
        }
        this.hgx = ab.getContext().getSharedPreferences("QQMAIL", 4);
        if (this.hgx == null) {
            return true;
        }
        this.mwB = this.hgx.getLong("qqmail_downloadid", -1);
        this.oFC = ((Integer) new ReadMailProxy(this.lvq, null).REMOTE_CALL("getMailAppDownloadStatus", Long.valueOf(this.mwB))).intValue();
        this.oFD = this.hgx.getString("qqmail_downloadpath", "");
        if (this.oFC == 3 && com.tencent.mm.a.e.aO(this.oFD)) {
            this.oFG = 2;
            aVo();
            if (this.oFE != null) {
                this.oFE.KH();
            }
            return true;
        } else if (this.oFx == 1) {
            return false;
        } else {
            w.e("MicroMsg.ReadMailUI", "promote qq mail error:MailAppRecomend = %d", new Object[]{Integer.valueOf(this.oFx)});
            return true;
        }
    }

    private void aVr() {
        if (bg.mA(this.oFz)) {
            w.e("MicroMsg.ReadMailUI", "mQQMailRedirectUrl = null");
            return;
        }
        rH(0);
        w.i("MicroMsg.ReadMailUI", "status:%d", new Object[]{Integer.valueOf(this.oFC)});
        switch (this.oFC) {
            case 1:
            case 2:
                this.oFG = 1;
                aVs();
                aVo();
                return;
            case 3:
                if (!com.tencent.mm.a.e.aO(this.oFD)) {
                    break;
                }
                return;
        }
        this.oFG = 0;
        rH(0);
        aVo();
    }

    private void rH(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.oFt.getLayoutParams();
        layoutParams.width = i;
        this.oFt.setLayoutParams(layoutParams);
    }

    private void aVs() {
        this.oFE = new aj(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.aj.a(this) {
            final /* synthetic */ ReadMailUI oFP;

            {
                this.oFP = r1;
            }

            public final boolean oQ() {
                if (!this.oFP.lvq.isConnected()) {
                    return false;
                }
                double doubleValue = ((Double) new ReadMailProxy(this.oFP.lvq, null).REMOTE_CALL("getMailAppDownloadProgress", Long.valueOf(this.oFP.mwB))).doubleValue();
                if (doubleValue == 1.0d) {
                    this.oFP.aVq();
                    return false;
                }
                int i;
                if (this.oFP.oFF == 0) {
                    this.oFP.oFF = this.oFP.oFs.getWidth();
                    i = 0;
                } else {
                    i = (int) (((double) this.oFP.oFF) * doubleValue);
                }
                this.oFP.rH(i);
                return true;
            }
        }, true);
        this.oFE.v(500, 500);
    }

    private void cK(int i, int i2) {
        new ReadMailProxy(this.lvq, null).REMOTE_CALL("reportKvState", Integer.valueOf(i), Integer.valueOf(i2));
    }

    protected void onResume() {
        if (this.oFx == 1 && !aVq()) {
            aVr();
        }
        super.onResume();
    }
}
