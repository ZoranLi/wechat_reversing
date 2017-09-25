package com.tencent.mm.plugin.backup.bakoldlogic.bakoldmoveui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.a.b;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldmovemodel.a;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldmovemodel.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.lang.reflect.Method;

public class BakMoveOldUI extends BakMoveBaseUI implements b, d, e {
    private boolean hoD = false;
    private boolean jLc = false;
    private int progress = -2;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KC();
        a.abR().abS().jKh = this;
        a.abR().abS().jKi = this;
        try {
            Method method = WifiManager.class.getMethod("isWifiApEnabled", new Class[0]);
            WifiManager wifiManager = (WifiManager) getSystemService("wifi");
            a.abR().abS().jDR = ((Boolean) method.invoke(wifiManager, new Object[0])).booleanValue();
            w.d("MicroMsg.BakMoveOldUI", "old isWifiAp:%s", new Object[]{Boolean.valueOf(a.abR().abS().jDR)});
        } catch (Exception e) {
            w.e("MicroMsg.BakMoveOldUI", "no such method WifiManager.isWifiApEnabled:%s", new Object[]{new ah()});
        }
    }

    public final void KC() {
        zi(R.l.dMz);
        this.jKK.setVisibility(4);
        zi(R.l.dMD);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ BakMoveOldUI jLf;

            {
                this.jLf = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.jLf.acf();
                return true;
            }
        });
    }

    public void onDestroy() {
        w.d("MicroMsg.BakMoveOldUI", " BakMoveOldUI onDestroy.");
        a.abR().abS().jKh = null;
        a.abR().abS().jKi = null;
        com.tencent.mm.plugin.backup.f.b.clear();
        super.onDestroy();
    }

    public final void onError(int i, String str) {
        w.d("MicroMsg.BakMoveOldUI", "onError errorType : " + i + " info : " + str);
        if (!this.hoD) {
            this.progress = -1;
            w.i("MicroMsg.BakMoveOldUI", "begin goto BakMoveErrUI");
            Intent intent = new Intent(ab.getContext(), BakMoveErrUI.class);
            intent.putExtra("err_type", i);
            intent.putExtra("err_info", str);
            intent.addFlags(335544320);
            ab.getContext().startActivity(intent);
            finish();
        }
    }

    public final void b(long j, long j2, int i) {
        CharSequence string;
        w.d("MicroMsg.BakMoveOldUI", "onNetProgress sucSize : " + j + " convDataSize : " + j2 + " timeLeft : " + i);
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
        if (this.progress != i2) {
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
    }

    public final void abW() {
        w.d("MicroMsg.BakMoveOldUI", "begin to onNetFinish. ");
        this.hoD = true;
        this.jLc = false;
        this.progress = -1;
        this.jKK.setVisibility(0);
        this.jKK.setText(R.l.dMP);
        this.jKM.setVisibility(4);
        this.jKL.setVisibility(4);
        this.jKN.setText(R.l.dMQ);
    }

    public final void aac() {
    }

    public final void n(int i, long j) {
        this.jLc = true;
        if (this.progress < i) {
            if (this.progress < 0) {
                this.jKL.setVisibility(0);
            }
            this.progress = i;
            this.jKL.setText(getString(R.l.dMG, new Object[]{Integer.valueOf(this.progress), com.tencent.mm.plugin.backup.bakoldlogic.a.d.aI(j)}));
            this.jKM.setProgress(i);
        }
    }

    public final void abO() {
        this.progress = -1;
        this.jKL.setText(getString(R.l.dMF));
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
        g.a(this, R.l.dLN, 0, R.l.dGs, R.l.dMM, null, new OnClickListener(this) {
            final /* synthetic */ BakMoveOldUI jLf;

            {
                this.jLf = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                w.i("MicroMsg.BakMoveOldUI", "try cancel");
                a.abR().abS().bx(false);
                this.jLf.finish();
            }
        });
    }

    public final void a(int i, int i2, String str, k kVar) {
    }
}
