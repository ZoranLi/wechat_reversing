package com.tencent.mm.plugin.backup.bakoldlogic.bakoldmoveui;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.backup.a.h;
import com.tencent.mm.plugin.backup.bakoldlogic.a.d;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldmovemodel.f.a;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldmovemodel.i;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldmovemodel.j;
import com.tencent.mm.plugin.backup.f.b;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.ef;
import com.tencent.mm.protocal.c.eg;
import com.tencent.mm.protocal.c.me;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;

public class BakMoveWaitUI extends MMActivity implements a, e {
    private m hyk = new m.a(this) {
        final /* synthetic */ BakMoveWaitUI jLk;

        {
            this.jLk = r1;
        }

        public final void cU(int i) {
            w.d("MicroMsg.BakMoveWaitUI", "cdntra onNetworkChange st:%d ", new Object[]{Integer.valueOf(i)});
            this.jLk.jED = null;
        }
    };
    private LinkedList<me> jEB;
    private String jEC;
    private String jED = "";
    private PLong jKl = new PLong();
    private PInt jKm = new PInt();
    private TextView jLg;
    private ImageView jLh;
    private ArrayList<String> jLi = null;
    private aj jLj;
    private WakeLock wakeLock;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (ap.zb()) {
            this.jLi = getIntent().getStringArrayListExtra("selected_records_username");
            this.jKl.value = getIntent().getLongExtra("selected_records_addupsize", -1);
            this.jKm.value = getIntent().getIntExtra("selected_records_count", -1);
            if (this.jLi == null || this.jLi.size() < 0 || this.jKl.value < 0 || this.jKm.value <= 0) {
                finish();
                return;
            } else if (com.tencent.mm.plugin.backup.bakoldlogic.bakoldmovemodel.e.abX() == null) {
                finish();
                return;
            } else {
                KC();
                w.d("MicroMsg.BakMoveWaitUI", "resetMoveServerAndBakScene begin");
                com.tencent.mm.plugin.backup.bakoldlogic.bakoldmovemodel.a.abR().abS().bx(true);
                com.tencent.mm.plugin.backup.bakoldlogic.bakoldmovemodel.a.abR().abS().a(this.jLi, this.jKl, this.jKm);
                com.tencent.mm.plugin.backup.bakoldlogic.bakoldmovemodel.a.abR().abS().a(this);
                b.clear();
                b.a(com.tencent.mm.plugin.backup.bakoldlogic.bakoldmovemodel.a.abR().abS());
                b.a(com.tencent.mm.plugin.backup.bakoldlogic.bakoldmovemodel.a.abR().aaE());
                b.jg(2);
                ap.vd().a(704, this);
                ap.vd().a(1000, this);
                ap.a(this.hyk);
                com.tencent.mm.plugin.backup.a.e.aak();
                this.jLj = new aj(new aj.a(this) {
                    final /* synthetic */ BakMoveWaitUI jLk;

                    {
                        this.jLk = r1;
                    }

                    public final boolean oQ() {
                        this.jLk.aaR();
                        return true;
                    }
                }, true);
                this.jLj.v(5000, 5000);
                this.wakeLock = ((PowerManager) getSystemService("power")).newWakeLock(26, "My Lock");
                return;
            }
        }
        finish();
    }

    private void aaR() {
        String bH = d.bH(this);
        w.i("MicroMsg.BakMoveWaitUI", "newWifiName: " + bH + " preWifiName : " + this.jED);
        if (!bH.equals(this.jED) && ap.zb()) {
            this.jED = bH;
            if (!aaS()) {
                return;
            }
            if (ap.uP()) {
                w.d("MicroMsg.BakMoveWaitUI", "begin to netscene create QRCode offline");
                ap.vd().a(new j(this.jEB, this.jEC), 0);
                return;
            }
            w.d("MicroMsg.BakMoveWaitUI", "begin to netscene create QRCode online");
            ap.vd().a(new i(this.jEB, this.jEC), 0);
        }
    }

    public final void KC() {
        zi(R.l.eSf);
        this.jLg = (TextView) findViewById(R.h.cJG);
        this.jLh = (ImageView) findViewById(R.h.cup);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ BakMoveWaitUI jLk;

            {
                this.jLk = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.jLk.finish();
                return true;
            }
        });
        com.tencent.mm.a.e.d(new File(h.aan()));
        if (aaS()) {
            this.jED = null;
            aaR();
        }
    }

    private boolean aaS() {
        this.jEB = new LinkedList();
        PString pString = new PString();
        PInt pInt = new PInt();
        if (com.tencent.mm.plugin.backup.bakoldlogic.bakoldmovemodel.a.abR().aaE().a(pString, pInt)) {
            w.i("MicroMsg.BakMoveWaitUI", "server listen result: %s, %d", new Object[]{pString.value, Integer.valueOf(pInt.value)});
            this.jEC = d.bH(this);
            w.i("MicroMsg.BakMoveWaitUI", "wifiName :%s", new Object[]{this.jEC});
            if (bg.mA(this.jEC)) {
                ju(R.l.dMA);
                this.jED = "";
                return false;
            }
            me meVar = new me();
            meVar.tsr = pString.value;
            meVar.tss = new LinkedList();
            meVar.tss.add(Integer.valueOf(pInt.value));
            this.jEB.add(meVar);
            return true;
        }
        ju(R.l.dMA);
        this.jED = "";
        return false;
    }

    public synchronized boolean onKeyDown(int i, KeyEvent keyEvent) {
        boolean z;
        if (i == 4) {
            finish();
            z = true;
        } else {
            z = super.onKeyDown(i, keyEvent);
        }
        return z;
    }

    public void onDestroy() {
        w.i("MicroMsg.BakMoveWaitUI", "BakMoveWaitUI onDestroy.");
        if (this.jLj != null) {
            this.jLj.KH();
        }
        com.tencent.mm.plugin.backup.bakoldlogic.bakoldmovemodel.a.abR().abS().a(null);
        ap.vd().b(704, this);
        ap.vd().b(1000, this);
        ap.b(this.hyk);
        super.onDestroy();
    }

    public final void a(int i, int i2, String str, k kVar) {
        byte[] bArr = null;
        if (kVar.getType() == 704) {
            if (i == 0 && i2 == 0) {
                eg egVar = (eg) ((i) kVar).gUA.hsk.hsr;
                if (!(egVar == null || egVar.thY == null)) {
                    bArr = egVar.thY.tZp.sYA;
                }
                if (bArr != null) {
                    this.jLh.setImageBitmap(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
                    this.jLg.setText(R.l.dMC);
                    this.jLg.setTextColor(this.uSU.uTo.getResources().getColor(R.e.black));
                    return;
                }
                return;
            }
            w.i("MicroMsg.BakMoveWaitUI", "err: %d, %d, %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            if (i2 == -100) {
                ap.vd().a(new j(this.jEB, this.jEC), 0);
            } else {
                ju(R.l.dMB);
            }
        } else if (kVar.getType() != 1000) {
        } else {
            if (i == 0 && i2 == 0) {
                ef efVar = ((com.tencent.mm.protocal.j.b) ((j) kVar).htt.zg()).sZr;
                String str2 = "MicroMsg.NetSceneBakChatCreateQRCodeOffline";
                String str3 = "onGYNetEnd QRCodeUrl:%s";
                Object[] objArr = new Object[1];
                objArr[0] = efVar == null ? "" : efVar.thZ;
                w.i(str2, str3, objArr);
                byte[] bArr2 = efVar == null ? null : efVar.thY == null ? null : efVar.thY.tZp.sYA;
                if (bArr2 != null) {
                    this.jLh.setImageBitmap(BitmapFactory.decodeByteArray(bArr2, 0, bArr2.length));
                    this.jLg.setText(R.l.dMC);
                    this.jLg.setTextColor(this.uSU.uTo.getResources().getColor(R.e.black));
                    return;
                }
                return;
            }
            w.i("MicroMsg.BakMoveWaitUI", "err: %d, %d, %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            ju(R.l.dMB);
        }
    }

    private void ju(int i) {
        this.jLg.setText(i);
        this.jLg.setTextColor(this.uSU.uTo.getResources().getColor(R.e.aVD));
        this.jLh.setImageResource(R.g.bhZ);
    }

    public void onResume() {
        super.onResume();
        this.wakeLock.acquire();
    }

    public void onPause() {
        super.onPause();
        this.wakeLock.release();
    }

    protected final int getLayoutId() {
        return R.i.cVn;
    }

    public final void acc() {
        w.d("MicroMsg.BakMoveWaitUI", "onAuthOK. go to bakMoveOldUI.");
        startActivity(new Intent(this, BakMoveOldUI.class));
        finish();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
    }
}
