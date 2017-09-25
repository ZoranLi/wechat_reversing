package com.tencent.mm.plugin.backup.bakoldlogic.bakoldmoveui;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.backup.a.h;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldmovemodel.a;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldmovemodel.d;
import com.tencent.mm.plugin.backup.f.b;
import com.tencent.mm.plugin.backup.h.v;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.io.File;
import java.lang.reflect.Method;

public class BakMoveNewUI extends BakMoveBaseUI implements d, e {
    private boolean hoD = false;
    private boolean jLc = false;
    private boolean jLd = false;
    private int progress = -1;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent().getBooleanExtra("testMode", false)) {
            String str = r.ijy;
            int i = r.ijz;
            b.a(a.abR().abU());
            b.a(a.abR().aaE());
            b.jg(2);
            a.abR().aaE().connect(str, i);
        }
        a.abR().abU().jKh = this;
        com.tencent.mm.a.e.d(new File(h.aan()));
        KC();
        try {
            Method method = WifiManager.class.getMethod("isWifiApEnabled", new Class[0]);
            WifiManager wifiManager = (WifiManager) getSystemService("wifi");
            a.abR().abU().jDR = ((Boolean) method.invoke(wifiManager, new Object[0])).booleanValue();
            w.d("MicroMsg.BakMoveNewUI", "new isWifiAp:%s", new Object[]{Boolean.valueOf(a.abR().abU().jDR)});
        } catch (Exception e) {
            w.e("MicroMsg.BakMoveNewUI", "no such method WifiManager.isWifiApEnabled:%s", new Object[]{new ah()});
        }
    }

    public final void KC() {
        boolean z = true;
        g.oUh.a(103, 8, 1, false);
        String stringExtra = getIntent().getStringExtra("WifiName");
        String stringExtra2 = getIntent().getStringExtra("ip");
        w.i("MicroMsg.BakMoveNewUI", "initView thisWifi:%s, oldWifi:%s, oldIp:%s", new Object[]{com.tencent.mm.plugin.backup.bakoldlogic.a.d.bH(this), stringExtra, stringExtra2});
        if (stringExtra == null || !stringExtra.equals(r2)) {
            Intent intent = new Intent(ab.getContext(), BakMoveErrUI.class);
            intent.putExtra("wifiNameDifferentErr", true);
            intent.putExtra("WifiName", stringExtra);
            intent.addFlags(335544320);
            ab.getContext().startActivity(intent);
            finish();
        } else if (h.rA(stringExtra2)) {
            zi(R.l.dML);
            b(new OnMenuItemClickListener(this) {
                final /* synthetic */ BakMoveNewUI jLe;

                {
                    this.jLe = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    this.jLe.acf();
                    return true;
                }
            });
            if (h.aao() < 30) {
                r1 = new Intent(ab.getContext(), BakMoveErrUI.class);
                r1.putExtra("battery_not_enough", true);
                r1.addFlags(335544320);
                ab.getContext().startActivity(r1);
                finish();
            } else if (getIntent().getBooleanExtra("need_auth", true)) {
                e abU = a.abR().abU();
                w.i("MicroMsg.MoveRecoverServer", "makeAuth");
                abU.jKg = false;
                abU.fLh = 0;
                abU.recvSize = 0;
                abU.jKr = 0;
                abU.jKs = 0;
                abU.htv = false;
                abU.jDO = true;
                abU.jDK = 0;
                abU.jDP.clear();
                b.a(1, abU);
                try {
                    if (bg.getInt(com.tencent.mm.i.g.sV().getValue("ChattingRecordsKvstatDisable"), 0) != 0) {
                        z = false;
                    }
                    abU.jDT = z;
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.MoveRecoverServer", e, "getInt", new Object[0]);
                }
                com.tencent.mm.plugin.backup.bakoldlogic.b.a aVar = new com.tencent.mm.plugin.backup.bakoldlogic.b.a(a.abR().jBn, a.abR().jBo, com.tencent.mm.plugin.backup.a.e.aai(), a.abR().jBm, com.tencent.mm.plugin.backup.bakoldlogic.a.b.jIY, -22);
                if (abU.jDT) {
                    v vVar = aVar.jHh;
                    vVar.jOd |= com.tencent.mm.plugin.backup.bakoldlogic.a.b.jIX;
                }
                aVar.abt();
                a.abR().abU().jKt = stringExtra2;
            }
        } else {
            r1 = new Intent(ab.getContext(), BakMoveErrUI.class);
            r1.putExtra("complexWIFIErr", true);
            r1.addFlags(335544320);
            ab.getContext().startActivity(r1);
            finish();
        }
    }

    public void onDestroy() {
        a.abR().abU().jKh = null;
        a.abR().aaE().stop();
        b.clear();
        super.onDestroy();
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.BakMoveNewUI", "onSceneEnd type:%d, errType:%d, errCode:%d, errMsg:%s", new Object[]{Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2), str});
    }

    public final void onError(int i, String str) {
        if (this.hoD || this.jLd) {
            w.i("MicroMsg.BakMoveNewUI", "onError isMergeing drop");
            return;
        }
        this.progress = -1;
        Intent intent = new Intent(ab.getContext(), BakMoveErrUI.class);
        intent.putExtra("err_type", i);
        intent.putExtra("err_info", str);
        intent.addFlags(335544320);
        ab.getContext().startActivity(intent);
        finish();
    }

    public final void b(long j, long j2, int i) {
        CharSequence string;
        this.jLc = true;
        if (this.progress < 0) {
            this.jKN.setText(R.l.dME);
            this.jKL.setVisibility(0);
            this.jKM.setVisibility(0);
        }
        if (i < 60) {
            string = getString(R.l.dMO);
        } else {
            string = getString(R.l.dMN, new Object[]{Integer.valueOf((i / 60) + 1)});
        }
        this.jKK.setText(string);
        if (j < 512000) {
            this.jKK.setVisibility(4);
        } else {
            this.jKK.setVisibility(0);
        }
        int i2 = (int) (j2 == 0 ? 0 : (100 * j) / j2);
        if (this.progress < i2) {
            if (this.progress > 0) {
                this.jKK.setVisibility(0);
            }
            this.progress = i2;
            if (i <= 0) {
                this.jKL.setText(com.tencent.mm.plugin.backup.bakoldlogic.a.d.aI(j) + "/" + com.tencent.mm.plugin.backup.bakoldlogic.a.d.aI(j2));
            } else {
                this.jKL.setText(com.tencent.mm.plugin.backup.bakoldlogic.a.d.aI(j) + "/" + com.tencent.mm.plugin.backup.bakoldlogic.a.d.aI(j2) + "(" + com.tencent.mm.plugin.backup.bakoldlogic.a.d.aI((j2 - j) / ((long) i)) + "/s)");
            }
            this.jKM.setProgress(i2);
        }
    }

    public final void bE(int i, int i2) {
        this.jKK.setText(R.l.dMJ);
        int i3 = (int) (i == 0 ? 0 : (((long) i) * 100) / ((long) i2));
        this.jKL.setText(getString(R.l.dMI, new Object[]{Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(i2)}));
        if (this.progress < i3) {
            this.progress = i3;
            this.jKM.setProgress(i3);
        }
    }

    public final void abW() {
        this.progress = -1;
        this.jKN.setText(R.l.dMK);
        this.jLd = true;
    }

    public final void aac() {
        this.jLc = false;
        this.jLd = false;
        this.hoD = true;
        this.progress = -1;
        this.jKK.setVisibility(0);
        this.jKK.setText(getString(R.l.dMH));
        this.jKL.setVisibility(4);
        this.jKM.setVisibility(4);
        this.jKN.setVisibility(4);
        this.jKO.setVisibility(0);
        this.jKO.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ BakMoveNewUI jLe;

            {
                this.jLe = r1;
            }

            public final void onClick(View view) {
                this.jLe.finish();
            }
        });
    }

    public synchronized boolean onKeyDown(int i, KeyEvent keyEvent) {
        boolean z;
        if (i == 4) {
            acf();
            z = true;
        } else {
            z = super.onKeyDown(i, keyEvent);
        }
        return z;
    }

    private void acf() {
        if (!this.jLc) {
            finish();
        }
        com.tencent.mm.ui.base.g.a(this, R.l.dLN, 0, R.l.dGs, R.l.dMM, null, new DialogInterface.OnClickListener(this) {
            final /* synthetic */ BakMoveNewUI jLe;

            {
                this.jLe = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                w.i("MicroMsg.BakMoveNewUI", "try cancel");
                a.abR().abU().jr(30050107);
                a.abR().abU().acd();
                this.jLe.finish();
            }
        });
    }
}
