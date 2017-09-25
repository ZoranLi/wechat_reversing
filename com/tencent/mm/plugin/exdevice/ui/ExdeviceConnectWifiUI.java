package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiManager.MulticastLock;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.util.Base64;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.bb.d;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.base.model.c;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.plugin.exdevice.model.j;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;

public class ExdeviceConnectWifiUI extends MMActivity {
    private TextWatcher acO;
    private String kMI = "";
    private View ljI;
    private TextView ljJ;
    private View ljK;
    private EditText ljL;
    private View ljM;
    private p ljN;
    private WifiInfo ljO;
    private com.tencent.mm.plugin.exdevice.d.a ljP;
    private String ljQ;
    private boolean ljR;
    private boolean ljS;
    private boolean ljT;
    private int ljU;
    private byte[] ljV;
    private int ljW;
    private int ljX;
    private int ljY;
    private String ljZ = "";
    private int lka;
    private long lkb;
    boolean lkc = false;
    private com.tencent.mm.plugin.exdevice.d.b lkd;
    private int lke;
    private m lkf;
    private com.tencent.mm.plugin.exdevice.model.j.a lkg;
    private MulticastLock lkh;
    private Runnable lki = new Runnable(this) {
        final /* synthetic */ ExdeviceConnectWifiUI lkj;

        {
            this.lkj = r1;
        }

        public final void run() {
            if (bg.mA(this.lkj.getPassword())) {
                this.lkj.ljL.setText(this.lkj.ljP.leF);
                Spannable text = this.lkj.ljL.getText();
                if (text != null) {
                    Selection.setSelection(text, text.length());
                    return;
                }
                return;
            }
            w.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "User has input password.");
        }
    };

    static /* synthetic */ class AnonymousClass7 {
        static final /* synthetic */ int[] lkp = new int[b.aqe().length];

        static {
            try {
                lkp[b.lkt - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                lkp[b.lkv - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                lkp[b.lku - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                lkp[b.lkx - 1] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                lkp[b.lkw - 1] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    private static class a {
        public static String M(int i, String str) {
            if (bg.mA(str)) {
                return null;
            }
            return i + "@" + str.hashCode();
        }
    }

    public enum b {
        ;

        public static int[] aqe() {
            return (int[]) lky.clone();
        }

        static {
            lkt = 1;
            lku = 2;
            lkv = 3;
            lkw = 4;
            lkx = 5;
            lky = new int[]{lkt, lku, lkv, lkw, lkx};
        }
    }

    static /* synthetic */ void a(ExdeviceConnectWifiUI exdeviceConnectWifiUI, final WifiInfo wifiInfo) {
        if (wifiInfo == null) {
            w.e("MicroMsg.exdevice.ExdeviceConnectWifiUI", "WifiInfo is null.");
            return;
        }
        exdeviceConnectWifiUI.lkc = true;
        exdeviceConnectWifiUI.lkb = System.currentTimeMillis();
        exdeviceConnectWifiUI.lU(3);
        final String password = exdeviceConnectWifiUI.getPassword();
        String ssid = wifiInfo.getSSID();
        w.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "SSID = %s", new Object[]{ssid});
        if (bg.mA(ssid)) {
            w.e("MicroMsg.exdevice.ExdeviceConnectWifiUI", "Error parameter: aSSID is null or nil");
            ssid = "";
        } else {
            ssid = ssid.replaceAll("\"", "");
        }
        w.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "do start AirKiss, ssid(%s).", new Object[]{ssid});
        if (bg.mA(ssid)) {
            w.e("MicroMsg.exdevice.ExdeviceConnectWifiUI", "ssid is invalid");
            Toast.makeText(exdeviceConnectWifiUI.uSU.uTo, "SSID is invalid", 0).show();
            return;
        }
        exdeviceConnectWifiUI.lV(b.lkv);
        ap.vL().D(new Runnable(exdeviceConnectWifiUI) {
            final /* synthetic */ ExdeviceConnectWifiUI lkj;

            public final void run() {
                this.lkj.lkh.acquire();
                int startAirKissWithInter = Java2CExDevice.startAirKissWithInter(password, ssid, this.lkj.ljV, 60000, this.lkj.ljW, this.lkj.ljX);
                w.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "Start AirKiss result (%d). input ssid = %s, ssid by system = %s, bssid by system = %s", new Object[]{Integer.valueOf(startAirKissWithInter), ssid, wifiInfo.getSSID(), wifiInfo.getBSSID()});
            }
        });
    }

    static /* synthetic */ void q(ExdeviceConnectWifiUI exdeviceConnectWifiUI) {
        if (exdeviceConnectWifiUI.ljO == null) {
            w.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "wifiInfo is null.");
            return;
        }
        String ssid = exdeviceConnectWifiUI.ljO.getSSID();
        String mz = bg.mz(exdeviceConnectWifiUI.getPassword());
        if (bg.mA(ssid)) {
            w.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "ssid is null or nil.");
            return;
        }
        if (bg.mA(exdeviceConnectWifiUI.ljP.leE) || (ssid.equals(exdeviceConnectWifiUI.ljP.leE) && !mz.equals(exdeviceConnectWifiUI.ljP.leF))) {
            com.tencent.mm.plugin.exdevice.d.a L = exdeviceConnectWifiUI.L(exdeviceConnectWifiUI.ljU, ssid);
            if (L == null) {
                L = new com.tencent.mm.plugin.exdevice.d.a();
                L.leE = ssid;
                L.leD = exdeviceConnectWifiUI.ljU;
                exdeviceConnectWifiUI.lkd.leG.add(L);
            }
            L.leF = c.bp(mz, a.M(exdeviceConnectWifiUI.ljU, ssid));
        } else if (!exdeviceConnectWifiUI.ljR) {
            w.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "password hasn't changed, so do not need to save.");
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        ap.yY();
        ssid = stringBuilder.append(com.tencent.mm.u.c.xv()).append("exdevice_wifi_infos").toString();
        try {
            byte[] toByteArray = exdeviceConnectWifiUI.lkd.toByteArray();
            e.b(ssid, toByteArray, toByteArray.length);
        } catch (Throwable e) {
            w.d("MicroMsg.exdevice.ExdeviceConnectWifiUI", e.getMessage());
            w.printErrStackTrace("MicroMsg.exdevice.ExdeviceConnectWifiUI", e, "", new Object[0]);
        }
        w.v("MicroMsg.exdevice.ExdeviceConnectWifiUI", "Current wifiInfo was save to file(%s).", new Object[]{ssid});
    }

    static /* synthetic */ void r(ExdeviceConnectWifiUI exdeviceConnectWifiUI) {
        Java2CExDevice.stopAirKiss();
        exdeviceConnectWifiUI.dK(true);
        if (exdeviceConnectWifiUI.lkh.isHeld()) {
            exdeviceConnectWifiUI.lkh.release();
        }
    }

    protected final int getLayoutId() {
        return R.i.dbx;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lkf = new com.tencent.mm.network.m.a(this) {
            final /* synthetic */ ExdeviceConnectWifiUI lkj;

            {
                this.lkj = r1;
            }

            public final void cU(int i) {
                af.v(new Runnable(this) {
                    final /* synthetic */ AnonymousClass8 lkq;

                    {
                        this.lkq = r1;
                    }

                    public final void run() {
                        if (this.lkq.lkj.lke != b.lkw) {
                            this.lkq.lkj.dK(true);
                        }
                    }
                });
            }
        };
        this.lke = b.lkt;
        if (ap.zb()) {
            this.lkd = new com.tencent.mm.plugin.exdevice.d.b();
            this.ljP = new com.tencent.mm.plugin.exdevice.d.a();
            ap.yY();
            this.ljU = com.tencent.mm.u.c.uH();
            String stringExtra = getIntent().getStringExtra("encryptKey");
            this.ljW = getIntent().getIntExtra("procInterval", 0);
            this.ljX = getIntent().getIntExtra("dataInterval", 0);
            w.d("MicroMsg.exdevice.ExdeviceConnectWifiUI", "Process interval:" + this.ljW + " Data interval:" + this.ljX);
            if (!bg.mA(stringExtra)) {
                this.ljV = Base64.decode(stringExtra, 0);
                this.lka = 1;
            }
            this.lkc = false;
            this.ljY = getIntent().getExtras().getInt("exdevice_airkiss_open_type");
            if (this.ljY == 2) {
                this.ljZ = getIntent().getStringExtra("device_brand_name");
                this.kMI = getIntent().getStringExtra("device_category_id");
            }
            this.lkg = new com.tencent.mm.plugin.exdevice.model.j.a(this) {
                final /* synthetic */ ExdeviceConnectWifiUI lkj;

                {
                    this.lkj = r1;
                }

                public final void f(int i, Object... objArr) {
                    if (i == 0 && objArr != null && objArr.length >= 2 && (objArr[0] instanceof Integer) && (objArr[1] instanceof Integer)) {
                        int intValue = ((Integer) objArr[0]).intValue();
                        int intValue2 = ((Integer) objArr[1]).intValue();
                        if (this.lkj.lkh.isHeld()) {
                            this.lkj.lkh.release();
                        }
                        w.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "AirKiss jni callback (%d, %d)", new Object[]{Integer.valueOf(intValue), Integer.valueOf(intValue2)});
                        if (intValue == 0 && intValue2 == 0) {
                            af.v(new Runnable(this) {
                                final /* synthetic */ AnonymousClass9 lkr;

                                {
                                    this.lkr = r1;
                                }

                                public final void run() {
                                    this.lkr.lkj.lV(b.lkw);
                                }
                            });
                        } else {
                            this.lkj.runOnUiThread(new Runnable(this) {
                                final /* synthetic */ AnonymousClass9 lkr;

                                {
                                    this.lkr = r1;
                                }

                                public final void run() {
                                    this.lkr.lkj.ljN.dismiss();
                                    g.a(this.lkr.lkj.uSU.uTo, this.lkr.lkj.uSU.uTo.getString(R.l.efg), "", this.lkr.lkj.uSU.uTo.getString(R.l.efF), "", false, new OnClickListener(this) {
                                        final /* synthetic */ AnonymousClass2 lks;

                                        {
                                            this.lks = r1;
                                        }

                                        public final void onClick(DialogInterface dialogInterface, int i) {
                                            this.lks.lkr.lkj.lV(b.lkx);
                                        }
                                    }, null).show();
                                }
                            });
                        }
                    }
                }
            };
            j.apk().a(0, this.lkg);
            KC();
            ap.vL().D(new Runnable(this) {
                final /* synthetic */ ExdeviceConnectWifiUI lkj;

                {
                    this.lkj = r1;
                }

                public final void run() {
                    try {
                        StringBuilder stringBuilder = new StringBuilder();
                        ap.yY();
                        byte[] d = e.d(stringBuilder.append(com.tencent.mm.u.c.xv()).append("exdevice_wifi_infos").toString(), 0, Integer.MAX_VALUE);
                        if (d != null) {
                            this.lkj.lkd.aD(d);
                            this.lkj.aqd();
                        }
                    } catch (Throwable e) {
                        w.d("MicroMsg.exdevice.ExdeviceConnectWifiUI", e.getMessage());
                        w.printErrStackTrace("MicroMsg.exdevice.ExdeviceConnectWifiUI", e, "", new Object[0]);
                    }
                    af.f(new Runnable(this) {
                        final /* synthetic */ AnonymousClass3 lkn;

                        {
                            this.lkn = r1;
                        }

                        public final void run() {
                            this.lkn.lkj.aHj();
                        }
                    }, 500);
                }
            });
            lU(1);
            this.lkh = ((WifiManager) getSystemService("wifi")).createMulticastLock("localWifi");
            return;
        }
        finish();
    }

    protected void onResume() {
        super.onResume();
        dK(false);
        ap.a(this.lkf);
        if (this.ljS) {
            aqd();
            this.ljS = false;
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (!this.lkc) {
            lU(2);
        }
        j.apk().b(0, this.lkg);
    }

    protected void onStop() {
        super.onStop();
        ap.b(this.lkf);
    }

    protected final void KC() {
        zi(R.l.dbx);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ExdeviceConnectWifiUI lkj;

            {
                this.lkj = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (!this.lkj.ljT) {
                    boolean z;
                    Intent intent = new Intent();
                    String str = "is_wifi_connected";
                    if (this.lkj.lke != b.lku) {
                        z = true;
                    } else {
                        z = false;
                    }
                    intent.putExtra(str, z);
                    this.lkj.setResult(0, intent);
                    this.lkj.finish();
                }
                return false;
            }
        });
        this.ljI = findViewById(R.h.cCF);
        this.ljJ = (TextView) findViewById(R.h.cml);
        this.ljK = findViewById(R.h.bop);
        this.ljL = (EditText) findViewById(R.h.cqF);
        this.ljM = findViewById(R.h.bEK);
        this.acO = new TextWatcher(this) {
            final /* synthetic */ ExdeviceConnectWifiUI lkj;

            {
                this.lkj = r1;
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                if (editable.length() > 31) {
                    this.lkj.ljK.setVisibility(0);
                    this.lkj.ljM.setEnabled(false);
                    return;
                }
                this.lkj.ljK.setVisibility(8);
                this.lkj.ljM.setEnabled(true);
            }
        };
        this.ljI.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ ExdeviceConnectWifiUI lkj;

            {
                this.lkj = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                this.lkj.ljL.clearFocus();
                this.lkj.aHf();
                return false;
            }
        });
        this.ljM.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ ExdeviceConnectWifiUI lkj;

            {
                this.lkj = r1;
            }

            public final void onClick(View view) {
                w.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "onClick connectBtn.");
                ExdeviceConnectWifiUI.a(this.lkj, this.lkj.ljO);
            }
        });
        this.ljL.setTransformationMethod(new PasswordTransformationMethod());
        this.ljL.addTextChangedListener(this.acO);
        this.ljL.setOnEditorActionListener(new OnEditorActionListener(this) {
            final /* synthetic */ ExdeviceConnectWifiUI lkj;

            {
                this.lkj = r1;
            }

            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i != 6 && i != 5) {
                    return false;
                }
                w.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "on next Key down.");
                ExdeviceConnectWifiUI.a(this.lkj, this.lkj.ljO);
                return true;
            }
        });
        this.ljL.setOnKeyListener(new OnKeyListener(this) {
            final /* synthetic */ ExdeviceConnectWifiUI lkj;

            {
                this.lkj = r1;
            }

            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (66 != i || keyEvent.getAction() != 0) {
                    return false;
                }
                ExdeviceConnectWifiUI.a(this.lkj, this.lkj.ljO);
                return true;
            }
        });
        this.ljL.requestFocus();
    }

    private void lU(int i) {
        long j = 0;
        if (i == 4) {
            j = System.currentTimeMillis() - this.lkb;
        }
        com.tencent.mm.plugin.report.service.g.oUh.i(13503, new Object[]{Integer.valueOf(i), Integer.valueOf(this.ljY), Long.valueOf(j), this.ljZ, this.kMI, Integer.valueOf(this.lka)});
    }

    private com.tencent.mm.plugin.exdevice.d.a L(int i, String str) {
        if (bg.mA(str) || this.lkd == null) {
            w.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "ssid or wifiInfoList is null or nil.");
            return null;
        }
        int i2 = 0;
        while (i2 < this.lkd.leG.size()) {
            com.tencent.mm.plugin.exdevice.d.a aVar = (com.tencent.mm.plugin.exdevice.d.a) this.lkd.leG.get(i2);
            if (aVar == null) {
                int i3 = i2 - 1;
                this.lkd.leG.remove(i2);
                this.ljR = true;
                i2 = i3;
            } else if (aVar.leD == i && str.equals(aVar.leE)) {
                return aVar;
            }
            i2++;
        }
        return null;
    }

    private void aqd() {
        if (this.ljO == null) {
            w.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "wifiInfo is null, delay to fill.");
            this.ljS = true;
            return;
        }
        this.ljP.leF = "";
        this.ljP.leE = "";
        com.tencent.mm.plugin.exdevice.d.a L = L(this.ljU, this.ljO.getSSID());
        if (L == null) {
            return;
        }
        if (bg.mA(L.leF)) {
            w.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "Do not have a local password to fill for the current wifi.");
            this.lkd.leG.remove(L);
            this.ljR = true;
            return;
        }
        this.ljP.leF = c.bp(L.leF, a.M(this.ljU, L.leE));
        this.ljP.leE = L.leE;
        af.v(this.lki);
    }

    private String getPassword() {
        return this.ljL.getText() != null ? this.ljL.getText().toString() : null;
    }

    private void dK(boolean z) {
        this.ljO = am.getWifiInfo(this);
        int i = z ? b.lkt : this.lke;
        if (this.ljO == null) {
            i = b.lku;
        } else {
            String ssid = this.ljO.getSSID();
            w.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "Get SSID(%s)", new Object[]{ssid});
            if (bg.mA(ssid)) {
                this.ljJ.setText("");
            } else {
                this.ljJ.setText(ssid.replaceAll("\"", ""));
            }
            if (!(bg.mA(ssid) || ssid.equals(this.ljQ))) {
                this.ljQ = ssid;
            }
        }
        lV(i);
    }

    public final synchronized void lV(int i) {
        if (i == 0) {
            w.e("MicroMsg.exdevice.ExdeviceConnectWifiUI", "Status is null.");
        } else {
            this.lke = i;
            switch (AnonymousClass7.lkp[i - 1]) {
                case 1:
                    b(true, false, false);
                    break;
                case 2:
                    b(true, true, false);
                    break;
                case 3:
                    b(false, false, false);
                    break;
                case 4:
                    lU(5);
                    this.ljT = true;
                    setResult(1);
                    break;
                case 5:
                    lU(4);
                    b(true, false, true);
                    this.ljT = true;
                    setResult(-1);
                    ap.vL().D(new Runnable(this) {
                        final /* synthetic */ ExdeviceConnectWifiUI lkj;

                        {
                            this.lkj = r1;
                        }

                        public final void run() {
                            ExdeviceConnectWifiUI.q(this.lkj);
                        }
                    });
                    if (getIntent().getBooleanExtra("jumpToBindDevice", false)) {
                        Intent intent = new Intent();
                        intent.putExtra("device_scan_mode", getIntent().getStringExtra("device_scan_mode"));
                        intent.putExtra("device_scan_conn_proto", getIntent().getStringExtra("device_scan_conn_proto"));
                        intent.putExtra("device_id", getIntent().getStringExtra("device_id"));
                        intent.putExtra("device_type", getIntent().getStringExtra("device_type"));
                        intent.putExtra("device_title", getIntent().getStringExtra("device_title"));
                        intent.putExtra("device_desc", getIntent().getStringExtra("device_desc"));
                        intent.putExtra("device_icon_url", getIntent().getStringExtra("device_icon_url"));
                        intent.putExtra("device_category_id", getIntent().getStringExtra("device_category_id"));
                        intent.putExtra("device_brand_name", getIntent().getStringExtra("device_brand_name"));
                        intent.putExtra("bind_ticket", getIntent().getStringExtra("bind_ticket"));
                        d.b(this.uSU.uTo, "exdevice", ".ui.ExdeviceBindDeviceUI", intent);
                        break;
                    }
                    break;
            }
            finish();
            if (i != b.lkt) {
                this.ljL.clearFocus();
                aHf();
            }
        }
    }

    private void b(boolean z, boolean z2, boolean z3) {
        this.ljI.setVisibility(z ? 0 : 8);
        if (z2) {
            runOnUiThread(new Runnable(this) {
                final /* synthetic */ ExdeviceConnectWifiUI lkj;

                {
                    this.lkj = r1;
                }

                public final void run() {
                    ExdeviceConnectWifiUI exdeviceConnectWifiUI = this.lkj;
                    Context context = this.lkj.uSU.uTo;
                    this.lkj.getString(R.l.dIO);
                    exdeviceConnectWifiUI.ljN = g.a(context, this.lkj.getString(R.l.egE), true, new OnCancelListener(this) {
                        final /* synthetic */ AnonymousClass5 lko;

                        {
                            this.lko = r1;
                        }

                        public final void onCancel(DialogInterface dialogInterface) {
                            w.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "On progress cancel, stop airkiss");
                            if (this.lko.lkj.lke != b.lkw) {
                                ExdeviceConnectWifiUI.r(this.lko.lkj);
                            }
                        }
                    });
                }
            });
        } else {
            runOnUiThread(new Runnable(this) {
                final /* synthetic */ ExdeviceConnectWifiUI lkj;

                {
                    this.lkj = r1;
                }

                public final void run() {
                    if (this.lkj.ljN != null && this.lkj.ljN.isShowing()) {
                        this.lkj.ljN.dismiss();
                    }
                }
            });
            if (this.lkh.isHeld()) {
                this.lkh.release();
            }
        }
        if (z3) {
            Toast.makeText(this.uSU.uTo, R.l.efJ, 0).show();
        }
    }
}
