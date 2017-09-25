package com.tencent.mm.plugin.masssend.ui;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.plugin.masssend.a.h;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.SensorController.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.k;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.y.g;
import com.tencent.mm.y.g.b;
import junit.framework.Assert;

public class MassSendHistoryUI extends MMActivity implements a, g.a, b {
    private static SensorController jXn;
    private com.tencent.mm.c.a.a fyE;
    private boolean jXq = true;
    private View mUZ;
    private ListView nxG;
    private c nxH;
    private Button nxI;
    private Button nxJ;
    private MMPullDownView nxK;
    private boolean nxL = false;
    private LinearLayout nxM;
    private d nxN = new d(this) {
        final /* synthetic */ MassSendHistoryUI nxO;

        {
            this.nxO = r1;
        }

        public final void c(MenuItem menuItem, int i) {
            if (menuItem.getItemId() == 1) {
                com.tencent.mm.plugin.masssend.a.a aVar = (com.tencent.mm.plugin.masssend.a.a) this.nxO.nxH.getItem(menuItem.getGroupId());
                if (aVar != null) {
                    if (aVar.aJl().equals(this.nxO.nxH.nxv)) {
                        this.nxO.adL();
                    }
                    com.tencent.mm.plugin.masssend.a.b aJt = h.aJt();
                    String aJl = aVar.aJl();
                    Cursor a = aJt.hnH.a("select * from massendinfo ORDER BY createtime DESC  limit 2", null, 0);
                    if (a != null) {
                        if (a.getCount() == 0) {
                            a.close();
                        } else if (a.getCount() == 1) {
                            a.moveToFirst();
                            r3 = new com.tencent.mm.plugin.masssend.a.a();
                            r3.b(a);
                            a.close();
                            r2 = new ae();
                            r2.setUsername("masssendapp");
                            r2.setContent(ab.getContext().getResources().getString(R.l.dYJ));
                            r2.s(r3.iam);
                            r2.dw(0);
                            r2.dt(0);
                            ap.yY();
                            c.wW().a(r2, "masssendapp");
                        } else {
                            a.moveToPosition(1);
                            r3 = new com.tencent.mm.plugin.masssend.a.a();
                            r3.b(a);
                            a.close();
                            r2 = new ae();
                            r2.setUsername("masssendapp");
                            r2.setContent(com.tencent.mm.plugin.masssend.a.b.a(r3));
                            r2.s(r3.iam);
                            r2.dw(0);
                            r2.dt(0);
                            ap.yY();
                            c.wW().a(r2, "masssendapp");
                        }
                    }
                    if (aJt.hnH.delete("massendinfo", "clientid= ?", new String[]{aJl}) > 0) {
                        aJt.doNotify();
                    }
                }
            }
        }
    };

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zi(R.l.eAA);
        if (jXn == null) {
            jXn = new SensorController(getApplicationContext());
        }
        KC();
        this.fyE = new com.tencent.mm.c.a.a(this);
        this.fyE.fzb = this;
        this.fyE.fza = this;
        this.nxH.nxw = new e(this) {
            final /* synthetic */ MassSendHistoryUI nxO;

            {
                this.nxO = r1;
            }

            public final String zX(String str) {
                ap.yY();
                if (c.isSDCardAvailable()) {
                    String mz = bg.mz(str);
                    if (!this.nxO.fyE.isPlaying() || !mz.equals(this.nxO.nxH.nxv)) {
                        return !this.nxO.zY(mz) ? "" : mz;
                    } else {
                        MassSendHistoryUI.jXn.bJG();
                        this.nxO.releaseWakeLock();
                        this.nxO.fyE.ap(false);
                        return "";
                    }
                }
                s.eP(this.nxO);
                return "";
            }
        };
        if (this.uSU != null) {
            this.uSU.ag(3, false);
        }
    }

    protected void onResume() {
        super.onResume();
        h.aJt().c(this.nxH);
        this.nxH.a(null, null);
        this.nxG.setSelection(this.nxH.getCount() - 1);
    }

    protected void onPause() {
        super.onPause();
        ap.yZ().qS();
        h.aJt().f(this.nxH);
        jXn.bJG();
    }

    protected void onDestroy() {
        this.nxH.aEW();
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.dih;
    }

    protected final void KC() {
        this.nxL = getIntent().getBooleanExtra("finish_direct", false);
        w.d("MicroMsg.MassSendHistoryUI", "isFromSearch  " + this.nxL);
        this.nxM = (LinearLayout) findViewById(R.h.cjk);
        this.nxG = (ListView) findViewById(R.h.ciU);
        this.nxG.setTranscriptMode(0);
        this.nxK = (MMPullDownView) findViewById(R.h.ciV);
        this.nxK.vln = new MMPullDownView.g(this) {
            final /* synthetic */ MassSendHistoryUI nxO;

            {
                this.nxO = r1;
            }

            public final boolean akp() {
                int i = 0;
                if (this.nxO.nxH.ahI()) {
                    this.nxO.nxG.setSelectionFromTop(0, this.nxO.nxK.vlp);
                } else {
                    c b = this.nxO.nxH;
                    if (!b.ahI()) {
                        b.kor += 10;
                        if (b.kor <= b.hOI) {
                            i = 10;
                        } else {
                            b.kor = b.hOI;
                            i = b.hOI % 10;
                        }
                    }
                    w.v("MicroMsg.MassSendHistoryUI", "onLoadData add count:" + i);
                    this.nxO.nxH.a(null, null);
                    this.nxO.nxG.setSelectionFromTop(i, this.nxO.nxK.vlp);
                }
                return true;
            }
        };
        this.nxK.kR(true);
        this.nxK.vlz = new MMPullDownView.c(this) {
            final /* synthetic */ MassSendHistoryUI nxO;

            {
                this.nxO = r1;
            }

            public final boolean ako() {
                if (this.nxO.nxG.getChildAt(this.nxO.nxG.getChildCount() - 1).getBottom() > this.nxO.nxG.getHeight() || this.nxO.nxG.getLastVisiblePosition() != this.nxO.nxG.getAdapter().getCount() - 1) {
                    return false;
                }
                return true;
            }
        };
        this.nxK.vlA = new MMPullDownView.d(this) {
            final /* synthetic */ MassSendHistoryUI nxO;

            {
                this.nxO = r1;
            }

            public final boolean akn() {
                View childAt = this.nxO.nxG.getChildAt(this.nxO.nxG.getFirstVisiblePosition());
                if (childAt == null || childAt.getTop() != 0) {
                    return false;
                }
                return true;
            }
        };
        this.nxK.kP(true);
        this.nxH = new c(this);
        this.nxH.uSN = new k.a(this) {
            final /* synthetic */ MassSendHistoryUI nxO;

            {
                this.nxO = r1;
            }

            public final void OH() {
                this.nxO.nxK.kO(this.nxO.nxH.ahI());
                if (this.nxO.nxH.getCount() == 0) {
                    this.nxO.nxK.setVisibility(8);
                    this.nxO.mUZ.setVisibility(0);
                    this.nxO.nxM.setVisibility(8);
                    return;
                }
                this.nxO.nxK.setVisibility(0);
                this.nxO.mUZ.setVisibility(8);
                this.nxO.nxM.setVisibility(0);
            }

            public final void OI() {
            }
        };
        this.mUZ = findViewById(R.h.ciT);
        this.nxG.setAdapter(this.nxH);
        this.nxG.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ MassSendHistoryUI nxO;

            {
                this.nxO = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                w.v("MicroMsg.MassSendHistoryUI", "onItemClick");
            }
        });
        this.nxG.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ MassSendHistoryUI nxO;

            {
                this.nxO = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                w.v("MicroMsg.MassSendHistoryUI", "onTouch");
                return false;
            }
        });
        this.nxI = (Button) findViewById(R.h.cjj);
        this.nxI.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MassSendHistoryUI nxO;

            {
                this.nxO = r1;
            }

            public final void onClick(View view) {
                this.nxO.startActivity(new Intent(this.nxO, MassSendSelectContactUI.class));
            }
        });
        this.nxJ = (Button) findViewById(R.h.cjl);
        this.nxJ.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MassSendHistoryUI nxO;

            {
                this.nxO = r1;
            }

            public final void onClick(View view) {
                this.nxO.startActivity(new Intent(this.nxO, MassSendSelectContactUI.class));
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ MassSendHistoryUI nxO;

            {
                this.nxO = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (this.nxO.nxL) {
                    this.nxO.finish();
                } else {
                    Intent intent = new Intent();
                    intent.addFlags(67108864);
                    com.tencent.mm.plugin.masssend.a.imv.t(intent, this.nxO);
                    this.nxO.finish();
                }
                return true;
            }
        });
        a(0, R.l.dID, R.k.dsW, new OnMenuItemClickListener(this) {
            final /* synthetic */ MassSendHistoryUI nxO;

            {
                this.nxO = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent();
                intent.putExtra("Contact_User", "masssendapp");
                com.tencent.mm.plugin.masssend.a.imv.d(intent, this.nxO);
                return true;
            }
        });
        new l(this).a(this.nxG, this, this.nxN);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.nxL) {
            finish();
        } else {
            Intent intent = new Intent();
            intent.addFlags(67108864);
            com.tencent.mm.plugin.masssend.a.imv.t(intent, this);
            finish();
        }
        return true;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        w.v("MicroMsg.MassSendHistoryUI", "onCreateContextMenu");
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        String[] split = ((com.tencent.mm.plugin.masssend.a.a) this.nxH.getItem(adapterContextMenuInfo.position)).aJo().split(";");
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : split) {
            ap.yY();
            x Rc = c.wR().Rc(str);
            if (Rc != null) {
                stringBuilder.append(Rc.tL() + ";");
            }
        }
        contextMenu.setHeaderTitle(stringBuilder.toString());
        contextMenu.add(adapterContextMenuInfo.position, 1, 0, getString(R.l.dUp));
    }

    protected final void releaseWakeLock() {
        this.nxG.setKeepScreenOn(false);
    }

    public final void cU(boolean z) {
        if (this.fyE != null) {
            if (this.fyE.isPlaying()) {
                this.fyE.aq(z);
                ap.yZ().c(z, false);
                this.jXq = z;
                if (!z) {
                    if (zY(this.nxH.nxv)) {
                        this.nxH.zW(this.nxH.nxv);
                        return;
                    } else {
                        this.nxH.zW("");
                        return;
                    }
                }
                return;
            }
            this.fyE.aq(true);
            ap.yZ().c(true, false);
            this.jXq = true;
        }
    }

    private boolean zY(String str) {
        Assert.assertTrue(str != null);
        jXn.a(this);
        com.tencent.mm.plugin.masssend.a.a zT = h.aJt().zT(str);
        ap.yY();
        if (c.isSDCardAvailable() || bg.mA(zT.aJm())) {
            if (this.fyE == null) {
                this.fyE = new com.tencent.mm.c.a.a(this);
            }
            this.fyE.ap(false);
            if (this.fyE.h(zT.aJm(), this.jXq)) {
                ap.yZ().c(this.jXq, false);
                this.fyE.fzb = this;
                this.fyE.fza = this;
                return true;
            }
            Toast.makeText(this, getString(R.l.dVf), 0).show();
            return false;
        }
        s.eP(this);
        return false;
    }

    private void adL() {
        jXn.bJG();
        this.fyE.ap(false);
        this.nxH.zW("");
        releaseWakeLock();
    }

    public final void oW() {
        adL();
    }

    public final void onError() {
        adL();
    }
}
