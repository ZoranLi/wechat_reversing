package com.tencent.mm.plugin.nfc_open.ui;

import android.annotation.TargetApi;
import android.content.Intent;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.plugin.nfc_open.a.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.b;
import com.tencent.mm.protocal.c.anv;
import com.tencent.mm.protocal.c.is;
import com.tencent.mm.protocal.c.lt;
import com.tencent.mm.protocal.c.mr;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Iterator;
import java.util.regex.Pattern;

public class NfcWebViewUI extends WebViewUI {
    private String nZr = null;
    private boolean nZs = false;
    private a nZt = new a();

    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] jPl = new int[b.values().length];

        static {
            try {
                jPl[b.sIe.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                jPl[b.sIf.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                jPl[b.sIg.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        if (M(intent)) {
            w.e("MicroMsg.NfcWebViewUI", "onCreate judgeIllegalCall finish");
            intent.putExtra("key_trust_url", false);
            super.onCreate(bundle);
            finish();
            return;
        }
        intent.putExtra("key_trust_url", false);
        super.onCreate(bundle);
        com.tencent.mm.sdk.b.a.urY.b(this.nZt);
        d.bGP();
        w.i("MicroMsg.NfcWebViewUI", "onCreate, intent action = " + intent.getAction());
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ NfcWebViewUI nZu;

            {
                this.nZu = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (this.nZu.nZs) {
                    this.nZu.aPf();
                } else {
                    this.nZu.finish();
                }
                return true;
            }
        });
        getIntent().putExtra("showShare", false);
        iS(false);
    }

    @TargetApi(11)
    protected void onDestroy() {
        super.onDestroy();
        com.tencent.mm.sdk.b.a.urY.c(this.nZt);
    }

    protected final void axz() {
        if (aPd()) {
            finish();
            w.w("MicroMsg.NfcWebViewUI", "not login, go to SimpleLogin");
            return;
        }
        super.axz();
        a(b.sIe, getIntent());
    }

    public void onNewIntent(Intent intent) {
        if (M(intent)) {
            w.e("MicroMsg.NfcWebViewUI", "onNewIntent judgeIllegalCall finish");
            return;
        }
        intent.putExtra("key_trust_url", false);
        super.onNewIntent(intent);
        setIntent(intent);
        int a = s.a(intent, "wizard_activity_result_code", Integer.MAX_VALUE);
        w.i("MicroMsg.NfcWebViewUI", "onNewIntent, resultCode = " + a);
        if (a != Integer.MAX_VALUE) {
            this.nZs = true;
        }
        switch (a) {
            case -1:
                a(b.sIe, intent);
                break;
            case 0:
                aPd();
                return;
            case 1:
                a(b.sIg, intent);
                break;
        }
        ga(true);
        w.i("Foreground dispatch", "Discovered tag with intent: " + intent);
    }

    private boolean aPd() {
        try {
            if (!this.iYF.bxy()) {
                return false;
            }
            w.w("MicroMsg.NfcWebViewUI", "not login");
            Intent intent = new Intent(this, getClass());
            intent.putExtras(getIntent());
            intent.addFlags(67108864);
            this.iYF.V(intent);
            return true;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.NfcWebViewUI", e, "", new Object[0]);
            return true;
        }
    }

    private void a(b bVar, Intent intent) {
        switch (AnonymousClass3.jPl[bVar.ordinal()]) {
            case 1:
                Tag tag;
                Parcelable parcelableExtra = intent.getParcelableExtra("android.nfc.extra.TAG");
                if (parcelableExtra == null || !(parcelableExtra instanceof Tag)) {
                    tag = null;
                } else {
                    tag = (Tag) parcelableExtra;
                }
                if (tag == null) {
                    w.e("MicroMsg.NfcWebViewUI", "[NFC]tag is null");
                    return;
                }
                try {
                    com.tencent.mm.plugin.nfc.b.a.a.aOZ().a(tag);
                    w.i("MicroMsg.NfcWebViewUI", "[NFC] connect status : " + com.tencent.mm.plugin.nfc.b.a.a.aOZ().cF(this.uSU.uTo));
                    return;
                } catch (Exception e) {
                    w.e("MicroMsg.NfcWebViewUI", "exp protect");
                    return;
                }
            default:
                finish();
                return;
        }
    }

    protected final void ga(boolean z) {
        if (this.iYF == null) {
            w.e("MicroMsg.NfcWebViewUI", "[NFC] invoker is null");
            return;
        }
        a(b.sIe, getIntent());
        String aPe = aPe();
        String str = this.fWY;
        if (!z || bg.mA(this.fWY) || this.fWY.startsWith("https://support.weixin.qq.com/security/readtemplate?t=bus_recharge/index_error")) {
            this.fWY = aPe;
            if (bg.mA(this.fWY)) {
                this.fWY = qw(0);
                w.e("MicroMsg.NfcWebViewUI", "[NFC] url not found! not support this card ?");
            }
            getIntent().putExtra("rawUrl", this.fWY);
            if (!this.fWY.equals(str)) {
                w.i("MicroMsg.NfcWebViewUI", "lo-nfc-dealwithNFC: onNewIntent load:" + this.fWY);
                this.oET.loadUrl(this.fWY);
                return;
            }
            return;
        }
        try {
            int i;
            if (!bg.mA(aPe)) {
                try {
                    Uri parse = Uri.parse(aPe);
                    Uri parse2 = Uri.parse(this.fWY);
                    aPe = parse.getHost();
                    str = parse2.getHost();
                    w.i("MicroMsg.NfcWebViewUI", "targetHost=" + aPe + ", curHost=" + str);
                    if (aPe.equals(str)) {
                        i = 1;
                        if (i != 0) {
                            this.rXh.m(4007, new Bundle());
                        }
                        w.i("MicroMsg.NfcWebViewUI", "[NFC]new intent not guide the page");
                    }
                } catch (Exception e) {
                }
            }
            i = 0;
            if (i != 0) {
                this.rXh.m(4007, new Bundle());
            }
        } catch (Throwable e2) {
            w.printErrStackTrace("MicroMsg.NfcWebViewUI", e2, "", new Object[0]);
        }
        w.i("MicroMsg.NfcWebViewUI", "[NFC]new intent not guide the page");
    }

    private static String qw(int i) {
        String str;
        StringBuilder stringBuilder = new StringBuilder("https://support.weixin.qq.com/security/readtemplate?t=bus_recharge/index_error");
        stringBuilder.append("&type=").append(i);
        if (!f.usw && v.bIN().equals("zh_CN")) {
            str = "zh_CN";
        } else if (v.bIL()) {
            str = "zh_TW";
        } else {
            str = "en";
        }
        stringBuilder.append("&lang=").append(str);
        return stringBuilder.toString();
    }

    private String aPe() {
        String str = null;
        w.i("MicroMsg.NfcWebViewUI", "nfc-getNfcCpuCardGuideUrl start");
        try {
            Bundle d = this.iYF.d(4006, null);
            if (d == null) {
                w.i("MicroMsg.NfcWebViewUI", "nfc-getNfcCpuCardGuideUrl data is null");
                return str;
            }
            d.setClassLoader(getClass().getClassLoader());
            String string = d.getString("debugConfig");
            String string2 = d.getString("config");
            if (string != null) {
                str = BM(string);
            } else {
                str = BN(string2);
            }
            w.i("MicroMsg.NfcWebViewUI", "nfc-getNfcCpuCardGuideUrl targetUrl=" + bg.mz(str));
            return str;
        } catch (Throwable e) {
            w.e("MicroMsg.NfcWebViewUI", e.toString());
            w.printErrStackTrace("MicroMsg.NfcWebViewUI", e, "", new Object[0]);
        }
    }

    private String BM(String str) {
        w.i("MicroMsg.NfcWebViewUI", "nfc-getDebugNfcCardGuideUrl start");
        this.nZr = "";
        try {
            String[] split = str.split(" ");
            if (split != null && split.length > 1) {
                boolean z = false;
                for (int i = 0; i < split.length - 1; i = (i + 1) + 1) {
                    String str2 = split[i];
                    String str3 = split[i + 1];
                    w.d("MicroMsg.NfcWebViewUI", "nfc-getDebugNfcCardGuideUrl cmd = " + str2 + " anwser = " + str3);
                    z = a(new com.tencent.mm.plugin.nfc.a.a(com.tencent.mm.plugin.nfc.c.a.BL(str2)), str3);
                    if (!z) {
                        break;
                    }
                }
                if (z) {
                    this.nZr = split[split.length - 1];
                    w.d("MicroMsg.NfcWebViewUI", "nfc-getDebugNfcCardGuideUrl tempurl = " + this.nZr);
                    return this.nZr;
                }
            }
            return this.nZr;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.NfcWebViewUI", e, "", new Object[0]);
            w.e("MicroMsg.NfcWebViewUI", "[NFC] Debug get nfc card type exception!" + e.toString());
            w.e("MicroMsg.NfcWebViewUI", "isConnect:" + com.tencent.mm.plugin.nfc.b.a.a.aOZ().cE(this.uSU.uTo));
            this.nZr = qw(1);
            return this.nZr;
        }
    }

    private String BN(String str) {
        w.i("MicroMsg.NfcWebViewUI", "nfc-getCommonNfcCardGuideUrl start");
        this.nZr = "";
        anv com_tencent_mm_protocal_c_anv = new anv();
        if (!bg.mA(str)) {
            try {
                com_tencent_mm_protocal_c_anv.aD(str.getBytes("ISO-8859-1"));
                if (com_tencent_mm_protocal_c_anv.tsY != null) {
                    int i = 0;
                    int i2 = 0;
                    while (i2 < com_tencent_mm_protocal_c_anv.tsY.size()) {
                        is isVar = (is) com_tencent_mm_protocal_c_anv.tsY.get(i2);
                        com.tencent.mm.plugin.nfc.b.a.a aOZ = com.tencent.mm.plugin.nfc.b.a.a.aOZ();
                        if (aOZ.nZk != null) {
                            aOZ.nZk.aPa();
                        }
                        if (!(isVar == null || bg.mA(isVar.tbt) || bg.bV(isVar.tnw))) {
                            String str2;
                            int i3 = 0;
                            int i4 = i;
                            while (i3 < isVar.tnw.size()) {
                                if (!bg.bV(((mr) isVar.tnw.get(i3)).ttb)) {
                                    int i5 = 0;
                                    while (i5 < ((mr) isVar.tnw.get(i3)).ttb.size()) {
                                        if (((mr) isVar.tnw.get(i3)).ttb.get(i5) != null && !bg.mA(((lt) ((mr) isVar.tnw.get(i3)).ttb.get(i5)).gaJ) && !bg.mA(((lt) ((mr) isVar.tnw.get(i3)).ttb.get(i5)).nmZ)) {
                                            String str3 = ((lt) ((mr) isVar.tnw.get(i3)).ttb.get(i5)).gaJ;
                                            str2 = ((lt) ((mr) isVar.tnw.get(i3)).ttb.get(i5)).nmZ;
                                            w.d("MicroMsg.NfcWebViewUI", "nfc-getCommonNfcCardGuideUrl cmd = " + str3 + " anwser = " + str2);
                                            if (!a(new com.tencent.mm.plugin.nfc.a.a(com.tencent.mm.plugin.nfc.c.a.BL(str3)), str2)) {
                                                i = 0;
                                                break;
                                            }
                                            i = 1;
                                        } else {
                                            i = i4;
                                        }
                                        i5++;
                                        i4 = i;
                                    }
                                    i = i4;
                                    if (i != 0) {
                                        break;
                                    }
                                } else {
                                    i = i4;
                                }
                                i3++;
                                i4 = i;
                            }
                            i = i4;
                            if (i != 0) {
                                str2 = isVar.tbt;
                                w.i("MicroMsg.NfcWebViewUI", "doCardTypeReport start");
                                e.post(new Runnable(this) {
                                    final /* synthetic */ NfcWebViewUI nZu;

                                    public final void run() {
                                        g.oUh.i(12794, new Object[]{str2, Integer.valueOf(0)});
                                        w.d("MicroMsg.NfcWebViewUI", "doCardTypeReport url = " + str2);
                                    }
                                }, getClass().getName());
                                return isVar.tbt;
                            }
                        }
                        i2++;
                        i = i;
                    }
                }
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.NfcWebViewUI", e, "", new Object[0]);
                w.e("MicroMsg.NfcWebViewUI", "[NFC] Common get nfc card type exception!" + e.toString());
                w.e("MicroMsg.NfcWebViewUI", "isConnect:" + com.tencent.mm.plugin.nfc.b.a.a.aOZ().cE(this.uSU.uTo));
                this.nZr = qw(1);
                return this.nZr;
            }
        }
        return this.nZr;
    }

    private static boolean a(com.tencent.mm.plugin.nfc.a.a aVar, String str) {
        boolean z;
        w.i("MicroMsg.NfcWebViewUI", "nfc-doCmd start");
        CharSequence cVar = com.tencent.mm.plugin.nfc.b.a.a.aOZ().a(aVar).toString();
        if (!bg.mA(cVar)) {
            w.d("MicroMsg.NfcWebViewUI", "nfc-judge mAnwser = " + bg.mz(str) + " resp = " + bg.mz(cVar));
            if (Pattern.compile(str, 2).matcher(cVar).find()) {
                z = true;
                if (z) {
                    return false;
                }
                return true;
            }
        }
        z = false;
        if (z) {
            return false;
        }
        return true;
    }

    public void onBackPressed() {
        if (this.nZs) {
            aPf();
        } else {
            super.onBackPressed();
        }
    }

    private void aPf() {
        Intent intent = new Intent();
        intent.addFlags(67108864);
        d.a(this, "com.tencent.mm.ui.LauncherUI", intent);
        finish();
        overridePendingTransition(R.a.aQL, R.a.aRn);
        w.i("MicroMsg.NfcWebViewUI", "lo-nfc-setBackBtn:back click after login");
    }

    private static boolean M(Intent intent) {
        if (intent == null) {
            w.e("MicroMsg.NfcWebViewUI", "intent is null");
            return true;
        }
        Tag tag;
        Iterator it = intent.getExtras().keySet().iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!(str == null || str.startsWith("android.nfc") || str == null)) {
                w.e("MicroMsg.NfcWebViewUI", "extra wrong key = " + str);
                it.remove();
            }
        }
        Parcelable parcelableExtra = intent.getParcelableExtra("android.nfc.extra.TAG");
        if (parcelableExtra == null || !(parcelableExtra instanceof Tag)) {
            tag = null;
        } else {
            tag = (Tag) parcelableExtra;
        }
        if (tag != null) {
            return false;
        }
        w.e("MicroMsg.NfcWebViewUI", "tag is null");
        return true;
    }
}
