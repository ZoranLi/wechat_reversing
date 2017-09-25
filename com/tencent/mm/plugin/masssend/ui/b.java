package com.tencent.mm.plugin.masssend.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.media.ToneGenerator;
import android.os.Vibrator;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.c.b.h;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.plugin.masssend.a.f;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.y.k;
import java.util.List;

public final class b implements com.tencent.mm.pluginsdk.ui.chat.b {
    public p irJ = null;
    public ToneGenerator jYA;
    public long jYB = -1;
    public Toast jYC;
    private Vibrator jYD;
    public final aj jYU = new aj(new com.tencent.mm.sdk.platformtools.aj.a(this) {
        final /* synthetic */ b nxn;

        {
            this.nxn = r1;
        }

        public final boolean oQ() {
            this.nxn.nxh.xD(this.nxn.nxi.getMaxAmplitude());
            return true;
        }
    }, true);
    public final aj jYV = new aj(new com.tencent.mm.sdk.platformtools.aj.a(this) {
        final /* synthetic */ b nxn;

        {
            this.nxn = r1;
        }

        public final boolean oQ() {
            if (this.nxn.jYB == -1) {
                this.nxn.jYB = bg.NA();
            }
            long aB = bg.aB(this.nxn.jYB);
            if (aB >= 50000 && aB <= 60000) {
                int i;
                if (this.nxn.jYC == null) {
                    i = (int) ((60000 - aB) / 1000);
                    this.nxn.jYC = Toast.makeText(this.nxn.nxg, this.nxn.nxg.getResources().getQuantityString(R.j.dsh, i, new Object[]{Integer.valueOf(i)}), 0);
                } else {
                    i = (int) ((60000 - aB) / 1000);
                    this.nxn.jYC.setText(this.nxn.nxg.getResources().getQuantityString(R.j.dsh, i, new Object[]{Integer.valueOf(i)}));
                }
                this.nxn.jYC.show();
            }
            if (aB < 60000) {
                return true;
            }
            w.v("MicroMsg.MassSendFooterEventImpl", "record stop on countdown");
            if (this.nxn.nxi.pd()) {
                this.nxn.aJw();
            }
            this.nxn.nxh.auL();
            aq.B(this.nxn.nxg, R.l.eYh);
            return false;
        }
    }, true);
    private final com.tencent.mm.y.h.a jYY = new com.tencent.mm.y.h.a(this) {
        final /* synthetic */ b nxn;

        {
            this.nxn = r1;
        }

        public final void onError() {
            this.nxn.nxi.reset();
            this.nxn.jYU.KH();
            this.nxn.jYV.KH();
            ad.Pu("keep_app_silent");
            this.nxn.nxh.auL();
            w.v("MicroMsg.MassSendFooterEventImpl", "record stop on error");
            Toast.makeText(this.nxn.nxg, this.nxn.nxg.getString(R.l.dVh), 0).show();
        }
    };
    public MassSendMsgUI nxg;
    public ChatFooter nxh;
    public a nxi;
    private String nxj;
    private List<String> nxk;
    private boolean nxl;
    private final com.tencent.mm.y.h.b nxm = new com.tencent.mm.y.h.b(this) {
        final /* synthetic */ b nxn;

        {
            this.nxn = r1;
        }

        public final void BF() {
            this.nxn.nxh.bFv();
        }
    };

    class a extends h {
        String fyF;
        final /* synthetic */ b nxn;

        public a(b bVar, Context context) {
            this.nxn = bVar;
            super(context, false);
        }

        public final String getFileName() {
            return this.fyF;
        }

        public final boolean pd() {
            this.fyF = super.getFileName();
            boolean pd = super.pd();
            super.reset();
            return pd;
        }
    }

    public b(MassSendMsgUI massSendMsgUI, ChatFooter chatFooter, String str, List<String> list, boolean z) {
        this.nxg = massSendMsgUI;
        this.nxh = chatFooter;
        this.nxj = str;
        this.nxk = list;
        this.nxl = z;
        this.nxi = new a(this, massSendMsgUI);
        this.nxi.a(this.jYY);
        this.nxi.a(this.nxm);
        this.jYA = new ToneGenerator(1, 60);
        this.jYD = (Vibrator) massSendMsgUI.getSystemService("vibrator");
    }

    public final boolean aJv() {
        this.jYU.KH();
        this.jYV.KH();
        this.jYB = -1;
        if (this.nxi.pd()) {
            aJw();
            this.nxh.auL();
        } else {
            this.nxh.bFt();
        }
        ap.oH().pR();
        return false;
    }

    public final void aJw() {
        com.tencent.mm.plugin.masssend.a.a aVar = new com.tencent.mm.plugin.masssend.a.a();
        aVar.nwQ = this.nxj;
        aVar.nwR = this.nxk.size();
        aVar.filename = this.nxi.fyF;
        aVar.msgType = 34;
        aVar.nwS = this.nxi.fAW;
        final k fVar = new f(aVar, this.nxl);
        ap.vd().a(fVar, 0);
        Context context = this.nxg;
        this.nxg.getString(R.l.dIO);
        this.irJ = g.a(context, this.nxg.getString(R.l.eRm), true, new OnCancelListener(this) {
            final /* synthetic */ b nxn;

            public final void onCancel(DialogInterface dialogInterface) {
                ap.vd().c(fVar);
                if (this.nxn.irJ != null) {
                    this.nxn.irJ.dismiss();
                    this.nxn.irJ = null;
                }
            }
        });
    }

    public final boolean aJx() {
        this.jYU.KH();
        this.jYV.KH();
        this.jYB = -1;
        this.nxh.auL();
        a aVar = this.nxi;
        aVar.pd();
        q.mb(aVar.fyF);
        ap.oH().pR();
        return false;
    }

    public final boolean aJy() {
        ap.yY();
        if (c.isSDCardAvailable()) {
            this.jYA.startTone(24);
            new ae().postDelayed(new Runnable(this) {
                final /* synthetic */ b nxn;

                {
                    this.nxn = r1;
                }

                public final void run() {
                    this.nxn.jYA.stopTone();
                }
            }, 200);
            this.jYD.vibrate(50);
            this.jYU.v(100, 100);
            this.jYV.v(200, 200);
            this.nxh.xC(this.nxg.getResources().getDisplayMetrics().heightPixels - this.nxh.getHeight());
            this.nxi.bx("_USER_FOR_THROWBOTTLE_");
            this.nxi.a(this.nxm);
            this.nxi.a(this.jYY);
            ap.oH().pS();
        } else {
            s.eP(this.nxg);
        }
        return false;
    }

    public final boolean zV(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        MassSendMsgUI.zZ(str);
        com.tencent.mm.plugin.masssend.a.a aVar = new com.tencent.mm.plugin.masssend.a.a();
        aVar.nwQ = this.nxj;
        aVar.nwR = this.nxk.size();
        aVar.filename = str;
        aVar.msgType = 1;
        final k fVar = new f(aVar, this.nxl);
        ap.vd().a(fVar, 0);
        Context context = this.nxg;
        this.nxg.getString(R.l.dIO);
        this.irJ = g.a(context, this.nxg.getString(R.l.eRm), true, new OnCancelListener(this) {
            final /* synthetic */ b nxn;

            public final void onCancel(DialogInterface dialogInterface) {
                ap.vd().c(fVar);
                if (this.nxn.irJ != null) {
                    this.nxn.irJ.dismiss();
                    this.nxn.irJ = null;
                }
            }
        });
        return true;
    }

    public final void aJz() {
    }

    public final void aJA() {
    }

    public final void aJB() {
    }

    public final void release() {
        this.jYA.release();
    }

    public final void onPause() {
        this.jYU.KH();
        this.jYV.KH();
        this.jYB = -1;
        this.nxi.pd();
        ap.oH().pR();
    }

    public final void fA(boolean z) {
    }
}
