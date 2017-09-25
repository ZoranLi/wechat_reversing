package com.tencent.mm.plugin.clean.ui;

import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.Signature;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.R;
import com.tencent.mm.plugin.clean.b.a;
import com.tencent.mm.plugin.clean.b.b;
import com.tencent.mm.plugin.clean.b.c;
import com.tencent.mm.plugin.clean.b.d;
import com.tencent.mm.plugin.clean.b.e;
import com.tencent.mm.plugin.clean.b.f;
import com.tencent.mm.plugin.clean.b.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class CleanUI extends MMActivity implements f, g {
    private ProgressDialog isv;
    private View kzA;
    private PieView kzB;
    private TextView kzC;
    private Button kzD;
    private Button kzE;
    private TextView kzF;
    private TextView kzG;
    private TextView kzH;
    private TextView kzI;
    private TextView kzJ;
    private JSONObject kzK;
    private long kzL;
    private String kzM = "com.tencent.qqpimsecure";
    private String kzN = "00B1208638DE0FCD3E920886D658DAF6";
    private String kzO = "11206657";
    private e kzr;
    private c kzz;

    static /* synthetic */ long ajW() {
        Calendar instance = Calendar.getInstance();
        if (instance.get(2) <= 3) {
            instance.set(instance.get(1) - 1, instance.get(2) + 9, instance.get(5));
        } else {
            instance.set(instance.get(1), instance.get(2) - 3, instance.get(5));
        }
        long timeInMillis = instance.getTimeInMillis();
        if (d.abX() == null) {
            return 0;
        }
        Iterator it = d.abX().iterator();
        long j = 0;
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar.kyt != null) {
                Iterator it2 = bVar.kyt.iterator();
                while (it2.hasNext()) {
                    a aVar = (a) it2.next();
                    if (aVar.ian < timeInMillis) {
                        j += aVar.size;
                    }
                }
            }
            j = j;
        }
        return j;
    }

    static /* synthetic */ ArrayList ajX() {
        Calendar instance = Calendar.getInstance();
        if (instance.get(2) <= 3) {
            instance.set(instance.get(1) - 1, instance.get(2) + 9, instance.get(5));
        } else {
            instance.set(instance.get(1), instance.get(2) - 3, instance.get(5));
        }
        long timeInMillis = instance.getTimeInMillis();
        ArrayList arrayList = new ArrayList();
        for (int size = d.abX().size() - 1; size >= 0; size--) {
            b bVar = (b) d.abX().get(size);
            for (int size2 = bVar.kyt.size() - 1; size2 >= 0; size2--) {
                if (((a) bVar.kyt.get(size2)).ian < timeInMillis) {
                    arrayList.add(bVar.kyt.get(size2));
                    bVar.kyt.remove(size2);
                }
            }
            if (!bVar.ajF()) {
                d.abX().remove(size);
            }
        }
        return arrayList;
    }

    static /* synthetic */ void e(CleanUI cleanUI) {
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        arrayList.add(cleanUI.getString(R.l.eHy));
        arrayList2.add(Integer.valueOf(0));
        com.tencent.mm.ui.base.g.a(cleanUI, null, arrayList, arrayList2, null, false, new com.tencent.mm.ui.base.g.d(cleanUI) {
            final /* synthetic */ CleanUI kzP;

            {
                this.kzP = r1;
            }

            public final void bN(int i, int i2) {
                switch (i2) {
                    case 0:
                        if (CleanUI.ajW() > 0) {
                            com.tencent.mm.ui.base.g.a(this.kzP, this.kzP.getString(R.l.dWj, new Object[]{bg.ay(r2)}), "", this.kzP.getString(R.l.bHU), this.kzP.getString(R.l.cancel), new OnClickListener(this) {
                                final /* synthetic */ AnonymousClass7 kzR;

                                {
                                    this.kzR = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    this.kzR.kzP.kzr = new e(d.ajK(), this.kzR.kzP, CleanUI.ajX());
                                    this.kzR.kzP.kzr.start();
                                    this.kzR.kzP.isv.show();
                                }
                            }, null);
                            return;
                        }
                        Toast.makeText(this.kzP, R.l.eDM, 0).show();
                        return;
                    default:
                        return;
                }
            }
        });
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.mm.plugin.report.service.g.oUh.a(282, 3, 1, false);
        if (getIntent().getBooleanExtra("had_detected_no_sdcard_space", false) && ajV()) {
            finish();
            return;
        }
        d.ajP();
        this.kzC = (TextView) findViewById(R.h.csx);
        this.kzB = (PieView) findViewById(R.h.crI);
        this.kzD = (Button) findViewById(R.h.bCo);
        this.kzE = (Button) findViewById(R.h.ctN);
        this.kzA = findViewById(R.h.boF);
        this.kzF = (TextView) findViewById(R.h.cSN);
        this.kzF.setTextSize(1, 20.0f);
        this.kzG = (TextView) findViewById(R.h.cqr);
        this.kzG.setTextSize(1, 20.0f);
        this.kzH = (TextView) findViewById(R.h.bRg);
        this.kzH.setTextSize(1, 20.0f);
        this.kzI = (TextView) findViewById(R.h.bCr);
        this.kzJ = (TextView) findViewById(R.h.bCs);
        zi(R.l.dWk);
        d.a(new com.tencent.mm.plugin.clean.b.a.b());
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ CleanUI kzP;

            {
                this.kzP = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.kzP.finish();
                return false;
            }
        });
        this.kzD.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ CleanUI kzP;

            {
                this.kzP = r1;
            }

            public final void onClick(View view) {
                this.kzP.startActivityForResult(new Intent(this.kzP, CleanChattingUI.class), 0);
                com.tencent.mm.plugin.report.service.g.oUh.a(282, 4, 1, false);
            }
        });
        this.kzE.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ CleanUI kzP;

            {
                this.kzP = r1;
            }

            public final void onClick(View view) {
                com.tencent.mm.plugin.report.service.g.oUh.a(282, 5, 1, false);
                if (!this.kzP.ajV()) {
                    if (this.kzP.ajU()) {
                        com.tencent.mm.ui.base.g.a(this.kzP, this.kzP.getString(R.l.dWf, new Object[]{bg.ew(this.kzP.kzL)}), "", this.kzP.getString(R.l.dGE), this.kzP.getString(R.l.dGs), new OnClickListener(this) {
                            final /* synthetic */ AnonymousClass3 kzQ;

                            {
                                this.kzQ = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                try {
                                    w.i("MicroMsg.CleanUI", "download url:%s, md5:%s", new Object[]{new URL(this.kzQ.kzP.kzK.getString(SlookSmartClipMetaTag.TAG_TYPE_URL)), this.kzQ.kzP.kzK.getString("md5")});
                                    com.tencent.mm.plugin.downloader.model.f.a aVar = new com.tencent.mm.plugin.downloader.model.f.a();
                                    aVar.tN("wesecure.apk");
                                    aVar.tL(r0.toString());
                                    aVar.dn(true);
                                    aVar.tO(r1);
                                    aVar.la(1);
                                    com.tencent.mm.plugin.downloader.model.e.akM().a(aVar.kHa);
                                } catch (Throwable e) {
                                    w.printErrStackTrace("MicroMsg.CleanUI", e, "", new Object[0]);
                                }
                                com.tencent.mm.plugin.report.service.g.oUh.a(282, 7, 1, false);
                            }
                        }, null);
                        return;
                    }
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", "http://weixin.qq.com/cgi-bin/readtemplate?t=w_safe&qqpimenter=shoushen");
                    intent.putExtra("show_bottom", false);
                    intent.putExtra("showShare", false);
                    com.tencent.mm.bb.d.b(this.kzP.uSU.uTo, "webview", ".ui.tools.WebViewUI", intent);
                }
            }
        });
        a(0, R.k.dsS, new OnMenuItemClickListener(this) {
            final /* synthetic */ CleanUI kzP;

            {
                this.kzP = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                CleanUI.e(this.kzP);
                return false;
            }
        });
        ae(0, false);
        getString(R.l.dIO);
        this.isv = com.tencent.mm.ui.base.g.a(this, getString(R.l.dWc), false, new OnCancelListener(this) {
            final /* synthetic */ CleanUI kzP;

            {
                this.kzP = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        this.isv.dismiss();
        if (d.abX() != null) {
            this.kzC.setVisibility(8);
            this.kzD.setEnabled(true);
            this.kzE.setEnabled(true);
            ae(0, true);
            d.ajM();
            aS(d.ajL());
        } else {
            com.tencent.mm.plugin.clean.b.a.b ajK = d.ajK();
            if (ajK != null) {
                this.kzz = new c(ajK, this);
                com.tencent.mm.sdk.f.e.post(this.kzz, "CleanUI_clean");
                this.kzC.setText(getString(R.l.dDg, new Object[]{"0%"}));
            }
        }
        if (bg.bJX() || com.tencent.mm.sdk.platformtools.f.fuV == 1) {
            this.kzE.setVisibility(8);
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(com.tencent.mm.ui.d.g.uOD, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
        intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE");
        sendBroadcast(intent);
        try {
            com.tencent.mm.sdk.c.b.b bVar = new com.tencent.mm.sdk.c.b.b();
            bVar.usm = "https://";
            bVar.host = "jtool.qq.com";
            bVar.uri = "/channel?productId=31&channelId=102133";
            com.tencent.mm.sdk.c.b aVar = new com.tencent.mm.sdk.c.a((HttpURLConnection) new URL(bVar.getUrl()).openConnection());
            com.tencent.mm.sdk.f.e.post(new com.tencent.mm.sdk.c.b.AnonymousClass1(aVar, bVar, new com.tencent.mm.sdk.c.b.c(this, "") {
                final /* synthetic */ CleanUI kzP;

                public final void onComplete() {
                    w.d("MicroMsg.CleanUI", "request onComplete:%s", new Object[]{this.content});
                    try {
                        JSONObject jSONObject = new JSONObject(this.content);
                        ap.yY();
                        com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uCT, this.content);
                    } catch (Throwable e) {
                        w.printErrStackTrace("MicroMsg.CleanUI", e, "", new Object[0]);
                        com.tencent.mm.plugin.report.service.g.oUh.a(282, 8, 1, false);
                    }
                }
            }, new ae()), aVar.getClass().getName());
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.CleanUI", e, e.getMessage(), new Object[0]);
        }
    }

    private boolean ajU() {
        ap.yY();
        String str = (String) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uCT, "");
        if (bg.mA(str)) {
            return false;
        }
        try {
            this.kzK = new JSONObject(str);
            this.kzM = this.kzK.getString(DownloadInfoColumns.PACKAGENAME);
            this.kzK.get("md5");
            this.kzO = this.kzK.getString("launcherID");
            this.kzN = this.kzK.getString("signature");
            this.kzK.get(SlookSmartClipMetaTag.TAG_TYPE_URL);
            this.kzL = this.kzK.getLong("size");
            return true;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.CleanUI", e, "", new Object[0]);
            return false;
        }
    }

    private boolean ajV() {
        ajU();
        if (!p.n(this.uSU.uTo, this.kzM)) {
            return false;
        }
        Signature[] aR = p.aR(this, this.kzM);
        if (aR == null || aR[0] == null) {
            return false;
        }
        String n = com.tencent.mm.a.g.n(aR[0].toByteArray());
        if (n == null || !n.equalsIgnoreCase(this.kzN)) {
            return false;
        }
        try {
            Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(this.kzM);
            if (launchIntentForPackage != null) {
                Bundle bundle = new Bundle();
                p.g(bundle, this.kzO);
                launchIntentForPackage.putExtras(bundle);
                launchIntentForPackage.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                startActivity(launchIntentForPackage);
                com.tencent.mm.plugin.report.service.g.oUh.a(282, 6, 1, false);
                return true;
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.CleanUI", e, "", new Object[0]);
        }
        return true;
    }

    protected final int getLayoutId() {
        return R.i.cYV;
    }

    private void aS(long j) {
        int i = 5;
        long ajH = (c.ajH() - c.ajI()) - j;
        int ajH2 = (int) ((360 * j) / c.ajH());
        if (ajH2 >= 5) {
            i = ajH2;
        }
        this.kzB.kAc = i;
        this.kzB.kAd = (int) ((360 * ajH) / c.ajH());
        this.kzB.ivi = 1;
        this.kzA.setVisibility(0);
        this.kzF.setText(bg.ay(j));
        this.kzG.setText(bg.ay(ajH));
        this.kzH.setText(bg.ay(c.ajI()));
        i = (int) ((100 * j) / c.ajH());
        ajH2 = (int) ((c.ajI() * 100) / c.ajH());
        if (i < 10 && ajH2 >= 30) {
            this.kzJ.setText(getString(R.l.eXi));
        } else if (i < 10 && ajH2 < 30) {
            this.kzJ.setText(getString(R.l.eXg));
        } else if (ajH2 < 30) {
            this.kzJ.setText(getString(R.l.eXh, new Object[]{i + "%"}));
        } else {
            this.kzJ.setText(getString(R.l.eXj, new Object[]{i + "%"}));
        }
        if (i <= 10 || ajH2 >= 30) {
            this.kzD.setBackgroundResource(R.g.bdd);
            this.kzD.setTextColor(getResources().getColorStateList(R.e.aSW));
            this.kzE.setBackgroundResource(R.g.bda);
            this.kzE.setTextColor(getResources().getColorStateList(R.e.aWx));
            return;
        }
        this.kzD.setBackgroundResource(R.g.bda);
        this.kzD.setTextColor(getResources().getColorStateList(R.e.aWx));
        this.kzE.setBackgroundResource(R.g.bdd);
        this.kzE.setTextColor(getResources().getColorStateList(R.e.aSW));
    }

    protected void onDestroy() {
        if (this.kzz != null) {
            Runnable runnable = this.kzz;
            w.i("MicroMsg.CleanController", "stop CleanController [%d]", new Object[]{Integer.valueOf(runnable.hashCode())});
            runnable.isStop = true;
            com.tencent.mm.sdk.f.e.O(runnable);
        }
        if (this.kzr != null) {
            this.kzr.ajR();
        }
        if (d.ajK() != null) {
            com.tencent.mm.plugin.clean.b.a.b ajK = d.ajK();
            for (ae removeCallbacksAndMessages : ajK.kyS.values()) {
                removeCallbacksAndMessages.removeCallbacksAndMessages(null);
            }
            for (ae removeCallbacksAndMessages2 : ajK.kyS.values()) {
                removeCallbacksAndMessages2.getLooper().getThread().interrupt();
                removeCallbacksAndMessages2.getLooper().quit();
            }
            w.i("MicroMsg.ThreadController", "finish thread controller [%d]", new Object[]{Integer.valueOf(ajK.hashCode())});
        }
        d.ajQ();
        d.ajO();
        super.onDestroy();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        d.ajM();
        aS(d.ajL());
    }

    public final void bL(int i, int i2) {
        this.kzC.setText(getString(R.l.dDg, new Object[]{((i * 100) / i2) + "%"}));
    }

    public final void a(long j, long j2, ArrayList<b> arrayList) {
        w.i("MicroMsg.CleanUI", "onCleanResult: wechatSize:%d", new Object[]{Long.valueOf(j2)});
        this.kzC.setVisibility(8);
        this.kzD.setEnabled(true);
        this.kzE.setEnabled(true);
        ae(0, true);
        aS(j2);
        if (j > 0) {
            this.kzI.setVisibility(0);
            this.kzI.setText(getString(R.l.dWe, new Object[]{bg.ay(j)}));
        } else {
            this.kzI.setVisibility(8);
            this.kzI.setText("");
        }
        d.aQ(j);
        d.aP(j2);
        d.p(arrayList);
    }

    public final void bM(int i, int i2) {
        this.isv.setMessage(getString(R.l.dWi, new Object[]{((i * 100) / i2) + "%"}));
    }

    public final void aR(long j) {
        this.isv.dismiss();
        d.aP(d.ajL() - j);
        d.aQ(d.ajM() + j);
        d.ajM();
        aS(d.ajL());
    }
}
