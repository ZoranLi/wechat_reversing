package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.ipcall.a.b.d;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.ipcall.c;
import com.tencent.mm.plugin.ipcall.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.x.b;

public final class j implements com.tencent.mm.plugin.ipcall.a.b.b.a, e {
    ImageView ioV;
    TextView ipa;
    DialPad mRs;
    String mTP;
    String mTQ;
    String mTR;
    String mTS;
    int mTT;
    int mTU;
    Bitmap mXT;
    public EditText mYc;
    TextView mYd;
    ImageView mYe;
    IPCallFuncButton mYf;
    IPCallFuncButton mYg;
    IPCallFuncButton mYh;
    ImageButton mYi;
    public TextView mYj;
    public View mYk;
    ImageButton mYl;
    int mYm = -1;
    String mYn;
    public IPCallTalkUI mYo;
    public c mYp;
    a mYq;
    private long mYr;
    public long mYs = -1;
    public boolean mYt = false;
    public boolean mYu = false;
    private AudioManager mYv = null;
    boolean mYw = false;
    private boolean mYx = true;
    boolean mYy = false;
    String mwO;

    public interface a {
        void fh(boolean z);
    }

    public j(IPCallTalkUI iPCallTalkUI) {
        this.mYo = iPCallTalkUI;
        this.mYp = i.aEm();
        this.mYp.mMm = this;
    }

    private void b(String str, String str2, int i, String str3) {
        String str4;
        aFs();
        if (!bg.mA(str)) {
            str4 = str;
        } else if (bg.mA(str3)) {
            str4 = this.mYo.getString(R.l.etB);
        } else {
            str4 = str3;
        }
        if (2 == i && str2 != null) {
            this.ipa.setText(str2);
        } else if (1 == i && str2 != null) {
            g.a(this.mYo, str2, str4, this.mYo.getString(R.l.etC), false, new OnClickListener(this) {
                final /* synthetic */ j mYz;

                {
                    this.mYz = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.mYz.mYo.finish();
                }
            });
        }
    }

    final void aFp() {
        i.aEk().fCi = this.mYo;
        Object aEk = i.aEk();
        aEk.mOB.mOS = aEk;
        d dVar = aEk.mOB;
        if (!dVar.jXn.uvF) {
            dVar.jXn.a(dVar);
            if (dVar.jXr.M(new Runnable(dVar) {
                final /* synthetic */ d mOT;

                {
                    this.mOT = r1;
                }

                public final void run() {
                    this.mOT.jXs = bg.NA();
                }
            })) {
                dVar.jXs = 0;
            } else {
                dVar.jXs = -1;
            }
        }
        i.aEk().mOF = this;
        i.aEk().a(this);
    }

    final void aFq() {
        this.mYc.setKeyListener(null);
        this.mYc.setHorizontallyScrolling(true);
        this.mRs.setVisibility(4);
        DialPad dialPad = this.mRs;
        dialPad.mRk = true;
        for (DialNumberButton fc : dialPad.mRn.values()) {
            fc.fc(true);
        }
        for (View view : dialPad.mRp.values()) {
            if (dialPad.mRk) {
                view.setBackgroundDrawable(dialPad.getResources().getDrawable(R.e.aVZ));
            } else {
                view.setBackgroundDrawable(dialPad.getResources().getDrawable(R.e.aTy));
            }
        }
        if (!bg.mA(this.mYn)) {
            yO(this.mYn);
        }
        if (com.tencent.mm.compatible.util.d.eo(16)) {
            this.mYc.setTypeface(Typeface.create("sans-serif-light", 0));
            this.mYd.setTypeface(Typeface.create("sans-serif-light", 0));
        }
        if (!bg.mA(this.mTQ)) {
            this.mXT = com.tencent.mm.plugin.ipcall.b.a.f(this.mYo, this.mTQ, true);
        }
        if (this.mXT == null && !bg.mA(this.mTP) && com.tencent.mm.plugin.ipcall.b.a.Fo()) {
            this.mXT = com.tencent.mm.plugin.ipcall.b.a.am(this.mYo, this.mTP);
        }
        if (this.mXT == null && !bg.mA(this.mTS)) {
            this.mXT = b.b(this.mTS, 480, 480, 4);
        }
        if (this.mXT == null) {
            this.mYe.setVisibility(0);
            this.ioV.setVisibility(8);
        }
        if (this.mXT != null) {
            this.mYe.setVisibility(8);
            this.ioV.setVisibility(0);
            this.ioV.setImageBitmap(this.mXT);
        }
        this.mYl.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ j mYz;

            {
                this.mYz = r1;
            }

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void onClick(android.view.View r6) {
                /*
                r5 = this;
                r0 = com.tencent.mm.plugin.ipcall.a.i.aEm();
                r1 = r0.lEf;
                monitor-enter(r1);
                r2 = com.tencent.mm.plugin.ipcall.a.i.aEl();	 Catch:{ all -> 0x005c }
                r2 = r2.aEb();	 Catch:{ all -> 0x005c }
                if (r2 == 0) goto L_0x005a;
            L_0x0011:
                r2 = r0.mMu;	 Catch:{ all -> 0x005c }
                if (r2 == 0) goto L_0x001a;
            L_0x0015:
                r0.aDH();	 Catch:{ all -> 0x005c }
                monitor-exit(r1);	 Catch:{ all -> 0x005c }
            L_0x0019:
                return;
            L_0x001a:
                r2 = 1;
                r0.mMu = r2;	 Catch:{ all -> 0x005c }
                r2 = com.tencent.mm.sdk.platformtools.ab.getContext();	 Catch:{ all -> 0x005c }
                r3 = com.tencent.mm.R.l.eCg;	 Catch:{ all -> 0x005c }
                r4 = 0;
                r2 = android.widget.Toast.makeText(r2, r3, r4);	 Catch:{ all -> 0x005c }
                r2.show();	 Catch:{ all -> 0x005c }
                r2 = new android.content.Intent;	 Catch:{ all -> 0x005c }
                r2.<init>();	 Catch:{ all -> 0x005c }
                r3 = 268435456; // 0x10000000 float:2.5243549E-29 double:1.32624737E-315;
                r2.setFlags(r3);	 Catch:{ all -> 0x005c }
                r3 = com.tencent.mm.sdk.platformtools.ab.getContext();	 Catch:{ all -> 0x005c }
                r4 = com.tencent.mm.plugin.ipcall.ui.IPCallTalkUI.class;
                r2.setClass(r3, r4);	 Catch:{ all -> 0x005c }
                r3 = "IPCallTalkUI_isFromMiniNotification";
                r4 = 1;
                r2.putExtra(r3, r4);	 Catch:{ all -> 0x005c }
                r3 = com.tencent.mm.plugin.voip.model.d.bpe();	 Catch:{ all -> 0x005c }
                r4 = r0.mMv;	 Catch:{ all -> 0x005c }
                r3.a(r2, r4);	 Catch:{ all -> 0x005c }
                r0.aDH();	 Catch:{ all -> 0x005c }
                r2 = r0.mMm;	 Catch:{ all -> 0x005c }
                if (r2 == 0) goto L_0x005a;
            L_0x0055:
                r0 = r0.mMm;	 Catch:{ all -> 0x005c }
                r0.aDP();	 Catch:{ all -> 0x005c }
            L_0x005a:
                monitor-exit(r1);	 Catch:{ all -> 0x005c }
                goto L_0x0019;
            L_0x005c:
                r0 = move-exception;
                monitor-exit(r1);	 Catch:{ all -> 0x005c }
                throw r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.ipcall.ui.j.9.onClick(android.view.View):void");
            }
        });
        this.mYh.mUU = new com.tencent.mm.plugin.ipcall.ui.IPCallFuncButton.a(this) {
            final /* synthetic */ j mYz;

            {
                this.mYz = r1;
            }

            public final void ff(boolean z) {
                w.d("MicroMsg.TalkUIController", "switch speaker, isChecked: %b", new Object[]{Boolean.valueOf(z)});
                if (i.aEl().aEc()) {
                    this.mYz.mYt = z;
                    this.mYz.mYu = z;
                    i.aEk().eW(z);
                    com.tencent.mm.plugin.report.service.g.oUh.i(12057, new Object[]{Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0)});
                } else if (!i.aEr().brA() && !i.aEl().aEe()) {
                    i.aEr().io(z);
                }
            }
        };
        this.mYf.mUU = new com.tencent.mm.plugin.ipcall.ui.IPCallFuncButton.a(this) {
            final /* synthetic */ j mYz;

            {
                this.mYz = r1;
            }

            public final void ff(boolean z) {
                if (i.aEl().aEd()) {
                    w.d("MicroMsg.TalkUIController", "switch mute, isChecked: %b", new Object[]{Boolean.valueOf(z)});
                    com.tencent.mm.plugin.ipcall.a.c.a aEi = i.aEi();
                    int pQ = z ? aEi.mOV.pQ(412) : aEi.mOV.pQ(413);
                    if (pQ < 0) {
                        w.e("MicroMsg.IPCallEngineManager", "tryMuteMicrophone ret:" + pQ);
                    }
                    i.aEk().mOA.bQ(z);
                    com.tencent.mm.plugin.report.service.g.oUh.i(12057, new Object[]{Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
                }
            }
        };
        this.mYg.mUU = new com.tencent.mm.plugin.ipcall.ui.IPCallFuncButton.a(this) {
            final /* synthetic */ j mYz;

            {
                this.mYz = r1;
            }

            public final void ff(boolean z) {
                j jVar;
                if (z) {
                    jVar = this.mYz;
                    if (jVar.mXT == null) {
                        jVar.ioV.setVisibility(8);
                    } else {
                        jVar.ioV.setVisibility(4);
                    }
                    jVar.ioV.setVisibility(8);
                    jVar.mYe.setVisibility(8);
                    jVar.mYc.setText("");
                    jVar.mYd.setText("");
                    jVar.mRs.setVisibility(0);
                } else {
                    jVar = this.mYz;
                    if (jVar.mXT != null) {
                        jVar.ioV.setVisibility(0);
                        jVar.mYe.setVisibility(8);
                    } else {
                        jVar.mYe.setVisibility(0);
                        jVar.ioV.setVisibility(8);
                    }
                    jVar.yO(jVar.mYn);
                    jVar.mRs.setVisibility(4);
                }
                com.tencent.mm.plugin.report.service.g.oUh.i(12057, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0)});
            }
        };
        this.mYi.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ j mYz;

            {
                this.mYz = r1;
            }

            public final void onClick(View view) {
                this.mYz.aFr();
            }
        });
        this.mRs.mRq = new com.tencent.mm.plugin.ipcall.ui.DialPad.a(this) {
            final /* synthetic */ j mYz;

            {
                this.mYz = r1;
            }

            public final void yy(String str) {
                String obj = this.mYz.mYc.getText().toString();
                if (bg.mA(obj)) {
                    this.mYz.mYs = System.currentTimeMillis();
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.mYz.mYs >= 3000) {
                    obj = obj + " ";
                }
                obj = obj + str;
                this.mYz.mYs = currentTimeMillis;
                this.mYz.cB(obj, "");
                c.yp(str);
                com.tencent.mm.plugin.report.service.g.oUh.i(12057, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1)});
            }

            public final void yz(String str) {
            }
        };
    }

    final void yO(String str) {
        if (bg.mA(this.mwO)) {
            cB(com.tencent.mm.plugin.ipcall.b.a.yY(str), "");
        } else {
            cB(this.mwO, com.tencent.mm.plugin.ipcall.b.a.yY(str));
        }
    }

    public final void cB(String str, String str2) {
        this.mYc.setText(str);
        if (!bg.mA(str)) {
            this.mYc.setSelection(this.mYc.getText().length() - 1);
        }
        this.mYd.setText(str2);
    }

    public final void ox(int i) {
        switch (i) {
            case 3:
                int i2 = i.aEh().mNd.mOc;
                Context context = ab.getContext();
                r0 = ((i2 & 1) <= 0 || (i2 & 2) > 0) ? (i2 & 8) > 0 ? context.getString(R.l.evo) + " " : "" : context.getString(R.l.evn) + " ";
                if (this.mYm != -1) {
                    String oy = com.tencent.mm.plugin.ipcall.b.a.oy(this.mYm);
                    this.ipa.setText(r0 + this.mYo.getString(R.l.euv, new Object[]{oy}));
                    return;
                }
                this.ipa.setText(r0 + this.mYo.getString(R.l.euu));
                return;
            case 5:
                this.ipa.setText(String.format("%02d:%02d", new Object[]{Long.valueOf(this.mYr / 60), Long.valueOf(this.mYr % 60)}));
                return;
            case 10:
                this.ipa.setText(R.l.eux);
                return;
            default:
                return;
        }
    }

    public final void aDy() {
        int i = 0;
        w.i("MicroMsg.TalkUIController", "onInviteSuccess");
        String str = i.aEh().mNd.mOo;
        String str2 = i.aEh().mNd.mOp;
        if (!(bg.mA(str) || bg.mA(str2) || str.equals(str2))) {
            w.i("MicroMsg.TalkUIController", "toPhoneNumber:%s,serverRetPhoneNumber:%s", new Object[]{str, str2});
            yO(str2);
        }
        w.i("MicroMsg.TalkUIController", "callFlag:" + i.aEh().mNd.mOc);
        int i2 = i.aEh().mNd.mOc;
        if ((i2 & 1) > 0 && (i2 & 2) > 0 && (i2 & 8) <= 0) {
            i = 1;
        }
        if (i != 0) {
            w.i("MicroMsg.TalkUIController", "isNotFree");
            g.a(this.mYo, R.l.euD, R.l.euE, R.l.euC, R.l.euB, true, null, new OnClickListener(this) {
                final /* synthetic */ j mYz;

                {
                    this.mYz = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    w.i("MicroMsg.TalkUIController", "user choose end this call because isNotFree");
                    this.mYz.aFr();
                }
            });
        }
        ox(3);
    }

    public final void aDz() {
        w.d("MicroMsg.TalkUIController", "onStartRing");
        if (i.aEl().aEc()) {
            this.mYt = this.mYh.isChecked();
            this.mYu = this.mYh.isChecked();
            i.aEk().eW(this.mYh.isChecked());
        }
    }

    public final void aDN() {
        w.d("MicroMsg.TalkUIController", "onUserAccept");
        if (i.aEl().aEc()) {
            this.mYt = this.mYh.isChecked();
            this.mYu = this.mYh.isChecked();
            i.aEk().eW(this.mYh.isChecked());
        }
        if (i.aEl().aEd()) {
            i.aEk().mOA.bQ(this.mYf.isChecked());
        }
    }

    public final void aDO() {
        w.d("MicroMsg.TalkUIController", "onOthersideShutdown");
        aFs();
        ox(10);
        ap.getNotification().cancel(42);
        if (this.mYq != null) {
            this.mYq.fh(true);
        }
    }

    public final void c(int i, String str, String str2, int i2) {
        w.d("MicroMsg.TalkUIController", "onError, error: %d", new Object[]{Integer.valueOf(i)});
        if (i2 == 1) {
            this.mYx = false;
        }
        if (i == 8) {
            if (i2 == 1) {
                String string;
                if (bg.mA(str)) {
                    string = this.mYo.getString(R.l.etB);
                } else {
                    string = str;
                }
                g.a(this.mYo, false, str2, string, this.mYo.getString(R.l.euc), this.mYo.getString(R.l.dGs), new OnClickListener(this) {
                    final /* synthetic */ j mYz;

                    {
                        this.mYz = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent();
                        intent.setClass(this.mYz.mYo, IPCallShareCouponUI.class);
                        this.mYz.mYo.startActivity(intent);
                        intent = new Intent();
                        intent.setClass(this.mYz.mYo, IPCallRechargeUI.class);
                        this.mYz.mYo.startActivity(intent);
                        this.mYz.mYo.finish();
                    }
                }, new OnClickListener(this) {
                    final /* synthetic */ j mYz;

                    {
                        this.mYz = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.mYz.mYo.finish();
                    }
                });
            } else {
                b(str, str2, i2, this.mYo.getString(R.l.etA));
            }
        } else if (i != 10) {
            b(str, str2, i2, null);
        } else {
            b(str, str2, i2, null);
        }
        ap.getNotification().cancel(42);
        if (this.mYq != null && !this.mYy) {
            this.mYq.fh(this.mYx);
        }
    }

    public final void aFr() {
        this.mYp.ck(0, 0);
        ap.getNotification().cancel(42);
        this.mYo.finish();
    }

    public final void eZ(boolean z) {
        w.d("MicroMsg.TalkUIController", "onHeadsetPlugStateChange, isPlugged: %b", new Object[]{Boolean.valueOf(z)});
        if (!i.aEl().aEc()) {
            return;
        }
        if (z) {
            i.aEk();
            this.mYt = com.tencent.mm.plugin.ipcall.a.b.a.qN();
            i.aEk().eW(false);
            this.mYh.fe(false);
            return;
        }
        i.aEk().eW(this.mYt);
        this.mYh.fe(true);
        this.mYh.setChecked(this.mYt);
    }

    public final void fa(boolean z) {
        w.d("MicroMsg.TalkUIController", "onBluetoothPlugStateChange, isPlugged: %b", new Object[]{Boolean.valueOf(z)});
        if (!i.aEl().aEc()) {
            return;
        }
        if (z) {
            i.aEk();
            this.mYu = com.tencent.mm.plugin.ipcall.a.b.a.qN();
            i.aEk().eW(false);
            this.mYh.fe(false);
            return;
        }
        i.aEk().eW(this.mYu);
        this.mYh.fe(true);
        this.mYh.setChecked(this.mYu);
    }

    public final void aDQ() {
        this.mYr = (long) i.aEm().aDJ();
        ox(5);
    }

    public final void aDP() {
        this.mYo.finish();
    }

    public final void aFs() {
        if (this.mYj != null) {
            this.mYj.setVisibility(4);
        }
        if (this.mYk != null) {
            this.mYk.setVisibility(4);
        }
    }
}
