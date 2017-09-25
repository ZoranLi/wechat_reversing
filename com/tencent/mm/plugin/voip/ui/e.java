package com.tencent.mm.plugin.voip.ui;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiLaunchApplication;
import com.tencent.mm.plugin.voip.model.d;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.m;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.plugin.voip.video.MovableVideoView;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.OpenGlView;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.n;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.s;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public final class e extends d {
    private TextView mYj;
    int[] nQb = null;
    private Timer okA;
    private CaptureView rhA;
    public TextView rmA;
    public TextView rmB;
    public TextView rmC;
    public TextView rmD;
    public com.tencent.mm.plugin.voip.video.e rmE = null;
    private Button rmF = null;
    private Button rmG = null;
    public boolean rmH = false;
    int rmI;
    int rmJ;
    int rmK;
    int rmL;
    int rmM;
    public int rmN = 0;
    public boolean rmO = false;
    private boolean rmP = false;
    private boolean rmQ = false;
    private boolean rmR;
    public long rmS = 0;
    public Bitmap rmT = null;
    public a rmU;
    private OnClickListener rmV = new OnClickListener(this) {
        final /* synthetic */ e rnk;

        {
            this.rnk = r1;
        }

        public final void onClick(View view) {
            w.i("MicroMsg.Voip.VoipVideoFragment", "hangup video talking");
            if (this.rnk.rlu != null && this.rnk.rlu.get() != null && ((c) this.rnk.rlu.get()).bpB()) {
                this.rnk.rmw.setEnabled(false);
                this.rnk.rmv.setEnabled(false);
                this.rnk.bU(this.rnk.getString(R.l.fbX), -1);
            }
        }
    };
    private OnClickListener rmW = new OnClickListener(this) {
        final /* synthetic */ e rnk;

        {
            this.rnk = r1;
        }

        public final void onClick(View view) {
            if (this.rnk.rlu != null && this.rnk.rlu.get() != null) {
                ((c) this.rnk.rlu.get()).bpK();
            }
        }
    };
    private OnClickListener rmX = new OnClickListener(this) {
        final /* synthetic */ e rnk;

        {
            this.rnk = r1;
        }

        public final void onClick(View view) {
            if (this.rnk.rlu != null && this.rnk.rlu.get() != null) {
                ((c) this.rnk.rlu.get()).bpK();
            }
        }
    };
    private OnClickListener rmY = new OnClickListener(this) {
        final /* synthetic */ e rnk;

        {
            this.rnk = r1;
        }

        public final void onClick(View view) {
            w.i("MicroMsg.Voip.VoipVideoFragment", "click accept video invite use voice button");
            if (am.isWifi(this.rnk.aG()) || l.bqd()) {
                this.rnk.bqX();
            } else {
                g.a(this.rnk.aG(), R.l.fcr, R.l.fcs, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ AnonymousClass13 rnm;

                    {
                        this.rnm = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        l.bqc();
                        this.rnm.rnk.bqX();
                    }
                }, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ AnonymousClass13 rnm;

                    {
                        this.rnm = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.rnm.rnk.bqY();
                    }
                });
            }
        }
    };
    private OnClickListener rmZ = new OnClickListener(this) {
        final /* synthetic */ e rnk;

        {
            this.rnk = r1;
        }

        public final void onClick(View view) {
            w.i("MicroMsg.Voip.VoipVideoFragment", "click accept video invite button");
            if (am.isWifi(this.rnk.aG()) || (l.bqd() && !am.is2G(this.rnk.aG()))) {
                this.rnk.bqZ();
            } else {
                g.a(this.rnk.aG(), R.l.fcr, R.l.fcs, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ AnonymousClass14 rnn;

                    {
                        this.rnn = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        if (!am.is2G(this.rnn.rnk.aG())) {
                            l.bqc();
                        }
                        this.rnn.rnk.bqZ();
                    }
                }, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ AnonymousClass14 rnn;

                    {
                        this.rnn = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.rnn.rnk.bqY();
                    }
                });
            }
        }
    };
    private OpenGlView rma;
    public OpenGlView rmb;
    private OpenGlRender rmc;
    private OpenGlRender rmd;
    private View rme;
    private ImageView rmf;
    private TextView rmg;
    public TextView rmh;
    public TextView rmi;
    private View rmj;
    public TextView rmk;
    public TextView rml;
    private TextView rmm;
    private RelativeLayout rmn;
    public Button rmo;
    private VoipSmallIconButton rmp;
    private VoipSmallIconButton rmq;
    private VoipSmallIconButton rmr;
    public VoipBigIconButton rms;
    private VoipBigIconButton rmt;
    private VoipBigIconButton rmu;
    public VoipBigIconButton rmv;
    public VoipBigIconButton rmw;
    public VoipBigIconButton rmx;
    public TextView rmy;
    public TextView rmz;
    private OnClickListener rna = new OnClickListener(this) {
        final /* synthetic */ e rnk;

        {
            this.rnk = r1;
        }

        public final void onClick(View view) {
            w.i("MicroMsg.Voip.VoipVideoFragment", "click reject video invite button");
            this.rnk.bqY();
        }
    };
    private OnClickListener rnb = new OnClickListener(this) {
        final /* synthetic */ e rnk;

        {
            this.rnk = r1;
        }

        public final void onClick(View view) {
            w.i("MicroMsg.Voip.VoipVideoFragment", "click cancel video invite button");
            if (this.rnk.rlu != null && this.rnk.rlu.get() != null && ((c) this.rnk.rlu.get()).bpH()) {
                this.rnk.rmw.setEnabled(false);
                this.rnk.rms.setEnabled(false);
                this.rnk.rml.setVisibility(0);
                this.rnk.rml.setText(R.l.fbv);
            }
        }
    };
    private OnClickListener rnc = new OnClickListener(this) {
        final /* synthetic */ e rnk;

        {
            this.rnk = r1;
        }

        public final void onClick(View view) {
            com.tencent.mm.plugin.report.service.g.oUh.i(11618, new Object[]{Integer.valueOf(2), Integer.valueOf(1)});
            if (!(this.rnk.rlu == null || this.rnk.rlu.get() == null)) {
                ((c) this.rnk.rlu.get()).if(true);
            }
            if (this.rnk.rlK != null) {
                this.rnk.rlK.w(false, true);
            }
        }
    };
    private OnClickListener rnd = new OnClickListener(this) {
        final /* synthetic */ e rnk;

        {
            this.rnk = r1;
        }

        public final void onClick(View view) {
            com.tencent.mm.plugin.report.service.g.oUh.i(11619, new Object[]{Integer.valueOf(2)});
            if (this.rnk.rlu != null && this.rnk.rlu.get() != null) {
                ((c) this.rnk.rlu.get()).bpW();
            }
        }
    };
    private OnClickListener rne = new OnClickListener(this) {
        final /* synthetic */ e rnk;

        {
            this.rnk = r1;
        }

        public final void onClick(View view) {
            this.rnk.rmH = !this.rnk.rmH;
            if (!this.rnk.rmH) {
                this.rnk.rmE.setVisibility(8);
            }
            Toast.makeText(this.rnk.aG(), String.format("mIsShowFaceRect:%b", new Object[]{Boolean.valueOf(this.rnk.rmH)}), 0).show();
        }
    };
    private OnClickListener rnf = new OnClickListener(this) {
        final /* synthetic */ e rnk;

        {
            this.rnk = r1;
        }

        public final void onClick(View view) {
            boolean b = bg.b((Boolean) view.getTag(), false);
            view.setTag(Boolean.valueOf(!b));
            if (b) {
                this.rnk.rmE.setVisibility(8);
                Toast.makeText(this.rnk.aG(), "stop face detect", 0).show();
            } else {
                Toast.makeText(this.rnk.aG(), "start face detect", 0).show();
            }
            if (this.rnk.rlu != null && this.rnk.rlu.get() != null) {
                ((c) this.rnk.rlu.get()).bpX();
            }
        }
    };
    private OnClickListener rng = new OnClickListener(this) {
        final /* synthetic */ e rnk;

        {
            this.rnk = r1;
        }

        public final void onClick(View view) {
            w.i("MicroMsg.Voip.VoipVideoFragment", "switch camera");
            this.rnk.rmx.setEnabled(false);
            this.rnk.bra();
            this.rnk.rmx.setEnabled(true);
            if (this.rnk.rlu != null && this.rnk.rlu.get() != null) {
                ((c) this.rnk.rlu.get()).bpJ();
            }
        }
    };
    private Runnable rnh = new Runnable(this) {
        final /* synthetic */ e rnk;

        {
            this.rnk = r1;
        }

        public final void run() {
            w.i("MicroMsg.Voip.VoipVideoFragment", "dismiss bar");
            e eVar = this.rnk;
            eVar.rmN--;
            if (this.rnk.aG() != null && !this.rnk.aG().isFinishing() && this.rnk.rmN <= 0) {
                this.rnk.rmx.setVisibility(8);
                this.rnk.rmo.setVisibility(8);
                this.rnk.rmk.setVisibility(8);
                this.rnk.rmw.setVisibility(8);
                this.rnk.rmv.setVisibility(8);
                this.rnk.ik(false);
            }
        }
    };
    private Runnable rni = new Runnable(this) {
        final /* synthetic */ e rnk;

        {
            this.rnk = r1;
        }

        public final void run() {
            if (this.rnk.aG() != null && !this.rnk.aG().isFinishing()) {
                this.rnk.rml.setVisibility(8);
            }
        }
    };
    int rnj = 0;

    public class a implements Runnable {
        final /* synthetic */ e rnk;

        public final void run() {
            w.i("MicroMsg.Voip.VoipVideoFragment", "try load blur bitmap");
            final Bitmap bitmap = this.rnk.rmT;
            this.rnk.jiB.post(new Runnable(this) {
                final /* synthetic */ a rno;

                public final void run() {
                    if (this.rno.rnk.rlI != null) {
                        this.rno.rnk.rlI.setBackgroundDrawable(new BitmapDrawable(bitmap));
                    }
                    this.rno.rnk.rmU = null;
                }
            });
        }
    }

    public final void bqX() {
        w.i("MicroMsg.Voip.VoipVideoFragment", "accept video invite use voice");
        com.tencent.mm.plugin.report.service.g.oUh.a(11526, true, true, new Object[]{Integer.valueOf(d.bpd().bqh()), Long.valueOf(d.bpd().bqi()), Long.valueOf(d.bpd().bqj()), Integer.valueOf(3)});
        if (this.rlu != null && this.rlu.get() != null && ((c) this.rlu.get()).bpC()) {
            this.rmr.setEnabled(false);
            this.rmu.setEnabled(false);
            this.rmt.setEnabled(false);
            this.rmh.setText(R.l.fcS);
            this.rlL.a(this.rmi, rlG);
        }
    }

    public final void bqY() {
        w.i("MicroMsg.Voip.VoipVideoFragment", "reject video invite");
        com.tencent.mm.plugin.report.service.g.oUh.a(11526, true, true, new Object[]{Integer.valueOf(d.bpd().bqh()), Long.valueOf(d.bpd().bqi()), Long.valueOf(d.bpd().bqj()), Integer.valueOf(4)});
        if (this.rlu != null && this.rlu.get() != null && ((c) this.rlu.get()).bpD()) {
            bU(getString(R.l.fcw), -1);
            this.rmt.setEnabled(false);
            this.rmu.setEnabled(false);
            this.rmr.setEnabled(false);
        }
    }

    public final void bqZ() {
        w.i("MicroMsg.Voip.VoipVideoFragment", "accept video invite");
        com.tencent.mm.plugin.report.service.g.oUh.a(11526, true, true, new Object[]{Integer.valueOf(d.bpd().bqh()), Long.valueOf(d.bpd().bqi()), Long.valueOf(d.bpd().bqj()), Integer.valueOf(1)});
        if (this.rlu != null && this.rlu.get() != null && ((c) this.rlu.get()).bpE()) {
            this.rmu.setEnabled(false);
            this.rmt.setEnabled(false);
            this.rmr.setEnabled(false);
            this.rms.setVisibility(8);
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.rlH = (RelativeLayout) layoutInflater.inflate(R.i.dpN, viewGroup, false);
        if (Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
            ((RelativeLayout) this.rlH.findViewById(R.h.cza)).setPadding(0, 0, 0, b.a(aG(), 40.0f));
        }
        this.rlI = (ImageView) this.rlH.findViewById(R.h.cNP);
        this.rmn = (RelativeLayout) this.rlH.findViewById(R.h.cbC);
        this.rma = (OpenGlView) this.rlH.findViewById(R.h.bsJ);
        this.rma.do(mScreenWidth, mScreenHeight);
        this.rmx = (VoipBigIconButton) this.rlH.findViewById(R.h.cOq);
        this.rmx.setOnClickListener(this.rng);
        this.rmw = (VoipBigIconButton) this.rlH.findViewById(R.h.cOB);
        this.rmw.setOnClickListener(this.rmW);
        this.rms = (VoipBigIconButton) this.rlH.findViewById(R.h.cNQ);
        this.rms.setOnClickListener(this.rnb);
        this.rmv = (VoipBigIconButton) this.rlH.findViewById(R.h.cOf);
        this.rmv.setOnClickListener(this.rmV);
        this.rmu = (VoipBigIconButton) this.rlH.findViewById(R.h.cNN);
        this.rmu.setOnClickListener(this.rmZ);
        this.rmr = (VoipSmallIconButton) this.rlH.findViewById(R.h.cNO);
        this.rmr.setOnClickListener(this.rmY);
        this.rmt = (VoipBigIconButton) this.rlH.findViewById(R.h.cOn);
        this.rmt.setOnClickListener(this.rna);
        this.rmq = (VoipSmallIconButton) this.rlH.findViewById(R.h.cOr);
        this.rmq.setOnClickListener(this.rmX);
        this.rmR = com.tencent.mm.plugin.voip.b.d.mo("VOIPBlockIgnoreButton") == 0;
        this.rmp = (VoipSmallIconButton) this.rlH.findViewById(R.h.cOg);
        this.rmp.setOnClickListener(this.rnd);
        if (!this.rmR) {
            this.rmp.setVisibility(8);
        }
        this.rmk = (TextView) this.rlH.findViewById(R.h.cOC);
        this.rme = this.rlH.findViewById(R.h.cOy);
        this.rmf = (ImageView) this.rlH.findViewById(R.h.cOx);
        com.tencent.mm.pluginsdk.ui.a.b.a(this.rmf, this.gLD, 0.05882353f, true);
        this.rmg = (TextView) this.rlH.findViewById(R.h.cOz);
        this.rmh = (TextView) this.rlH.findViewById(R.h.cOu);
        this.rmi = (TextView) this.rlH.findViewById(R.h.cOw);
        this.rmj = this.rlH.findViewById(R.h.cOv);
        b(this.rmi, getResources().getString(R.l.fcC));
        this.rml = (TextView) this.rlH.findViewById(R.h.cOt);
        this.rmm = (TextView) this.rlH.findViewById(R.h.cOA);
        this.rmo = (Button) this.rlH.findViewById(R.h.bvb);
        this.mYj = (TextView) this.rlH.findViewById(R.h.cOj);
        if (r.ijJ) {
            this.rmy = (TextView) this.rlH.findViewById(R.h.cNR);
            this.rmz = (TextView) this.rlH.findViewById(R.h.cOo);
            this.rmA = (TextView) this.rlH.findViewById(R.h.cOl);
            this.rmB = (TextView) this.rlH.findViewById(R.h.cOp);
            this.rmC = (TextView) this.rlH.findViewById(R.h.cOm);
            this.rmD = (TextView) this.rlH.findViewById(R.h.bMh);
        }
        this.rmF = (Button) this.rlH.findViewById(R.h.cOd);
        this.rmG = (Button) this.rlH.findViewById(R.h.cOe);
        this.rmF.setVisibility(8);
        this.rmG.setVisibility(8);
        this.rmF.setOnClickListener(this.rne);
        this.rmG.setOnClickListener(this.rnf);
        this.rmE = new com.tencent.mm.plugin.voip.video.e(aG());
        this.rlH.addView(this.rmE);
        this.rmE.setVisibility(8);
        this.rmo.setOnClickListener(this.rnc);
        c(this.rhA);
        int eR = s.eR(aG());
        w.d("MicroMsg.Voip.VoipVideoFragment", "statusHeight: " + eR);
        d.E(this.rmo, eR);
        d.E(this.rlH.findViewById(R.h.cOs), eR);
        d.E(this.rme, eR);
        this.rmJ = 0;
        this.rmI = 0;
        this.rmK = 0;
        this.rmL = 0;
        this.rmM = 0;
        WindowManager windowManager = (WindowManager) aG().getSystemService("window");
        int height = windowManager.getDefaultDisplay().getHeight() / 5;
        int width = (windowManager.getDefaultDisplay().getWidth() * height) / windowManager.getDefaultDisplay().getHeight();
        this.rmb = new MovableVideoView(aG().getApplicationContext());
        ((MovableVideoView) this.rmb).dn(width, height);
        this.rmb.setVisibility(8);
        this.rmc = new OpenGlRender(this.rmb, OpenGlRender.rpM);
        this.rmb.a(this.rmc);
        this.rmb.setRenderMode(0);
        this.rmd = new OpenGlRender(this.rma, OpenGlRender.rpL);
        this.rma.a(this.rmd);
        this.rma.setRenderMode(0);
        if (Build.MODEL.equals("Nexus 6")) {
            this.rmb.setZOrderOnTop(true);
        } else {
            this.rmb.setZOrderMediaOverlay(true);
        }
        this.rlH.addView(this.rmb);
        this.rmb.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ e rnk;

            {
                this.rnk = r1;
            }

            public final void onClick(View view) {
                boolean z;
                e eVar = this.rnk;
                if (this.rnk.rmO) {
                    z = false;
                } else {
                    z = true;
                }
                eVar.rmO = z;
                eVar = this.rnk;
                if (this.rnk.rmO) {
                    z = false;
                } else {
                    z = true;
                }
                Point il = eVar.il(z);
                this.rnk.rmb.dp(il.x, il.y);
                com.tencent.mm.plugin.report.service.g.oUh.i(11079, new Object[]{Integer.valueOf(3)});
            }
        });
        this.rmg.setText(h.b(aG(), n.eK(this.gLD), this.rmg.getTextSize()));
        if (!this.rhF) {
            this.rmO = !this.rmO;
        }
        if (this.rhF) {
            this.jiB.postDelayed(new Runnable(this) {
                final /* synthetic */ e rnk;

                {
                    this.rnk = r1;
                }

                public final void run() {
                    this.rnk.rmh.setText(R.l.fcj);
                    this.rnk.rlL.a(this.rnk.rmi, d.rlG);
                }
            }, 2000);
        }
        this.okA = new Timer("VoIP_video_talking_count");
        this.rmQ = true;
        dm(0, this.mStatus);
        return this.rlH;
    }

    public final void onDestroy() {
        this.rmP = false;
        super.onDestroy();
    }

    public final void bra() {
        w.i("MicroMsg.Voip.VoipVideoFragment", "trigger dismiss bar");
        this.rmN++;
        this.jiB.postDelayed(this.rnh, 10000);
    }

    public final void dm(int i, int i2) {
        super.dm(i, i2);
        w.i("MicroMsg.Voip.VoipVideoFragment", "newState: " + com.tencent.mm.plugin.voip.b.b.vf(i2));
        if (this.rlH == null) {
            w.i("MicroMsg.Voip.VoipVideoFragment", "fragment no create, return first, onCreateView will call it again");
            return;
        }
        switch (i2) {
            case 0:
            case 2:
                this.rmj.setVisibility(0);
                this.rmn.setVisibility(0);
                this.rma.setVisibility(0);
                this.rmh.setText(R.l.fcj);
                this.rlI.setVisibility(8);
                this.rml.setVisibility(8);
                this.rmm.setVisibility(8);
                if (d.bpd().ric != null) {
                    this.rmm.setVisibility(0);
                    this.rmm.setText(d.bpd().ric);
                }
                this.rlL.a(this.rmi, rlG);
                this.rmx.setVisibility(8);
                this.rmw.setVisibility(8);
                this.rms.setVisibility(0);
                this.rmv.setVisibility(8);
                this.rmu.setVisibility(8);
                this.rmr.setVisibility(8);
                this.rmt.setVisibility(8);
                this.rmq.setVisibility(0);
                this.rmp.setVisibility(8);
                return;
            case 4:
            case 258:
                this.rmh.setText(R.l.fcS);
                this.rlL.a(this.rmi, rlG);
                return;
            case 6:
            case GameJsApiLaunchApplication.CTRL_BYTE /*260*/:
                this.rlH.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ e rnk;

                    {
                        this.rnk = r1;
                    }

                    public final void onClick(View view) {
                        int i;
                        boolean z = false;
                        com.tencent.mm.plugin.report.service.g.oUh.i(11079, new Object[]{Integer.valueOf(4)});
                        if (!(this.rnk.rmO || this.rnk.rlu.get() == null)) {
                            this.rnk.rmx.getVisibility();
                        }
                        if (this.rnk.rmx.getVisibility() == 0) {
                            i = 4;
                        } else {
                            boolean z2 = false;
                        }
                        int i2 = i == 0 ? 0 : 8;
                        this.rnk.rmx.setVisibility(i2);
                        this.rnk.rmo.setVisibility(i2);
                        this.rnk.rmk.setVisibility(i2);
                        this.rnk.rmv.setVisibility(i2);
                        this.rnk.rmw.setVisibility(i2);
                        e eVar = this.rnk;
                        if (i2 == 0) {
                            z = true;
                        }
                        eVar.ik(z);
                        if (r.ijJ) {
                            this.rnk.rmy.setVisibility(i2);
                            this.rnk.rmz.setVisibility(i2);
                            this.rnk.rmA.setVisibility(i2);
                            this.rnk.rmB.setVisibility(i2);
                            this.rnk.rmC.setVisibility(i2);
                            this.rnk.rmD.setVisibility(i2);
                        }
                        if (i == 0) {
                            this.rnk.bra();
                        }
                    }
                });
                if (this.rmb.getVisibility() != 0) {
                    if (this.rhF) {
                        this.rmO = !this.rmO;
                        Point il = il(!this.rmO);
                        this.rmb.dp(il.x, il.y);
                    }
                    if (r.ijJ) {
                        this.rmy.setVisibility(0);
                        this.rmz.setVisibility(0);
                        this.rmA.setVisibility(0);
                        this.rmB.setVisibility(0);
                        this.rmC.setVisibility(0);
                        this.rmD.setVisibility(0);
                    }
                    this.rme.setVisibility(8);
                    this.rma.setVisibility(0);
                    this.rmb.setVisibility(0);
                    this.rmk.setVisibility(0);
                    this.rmo.setVisibility(0);
                    this.rmn.setVisibility(0);
                    this.rmx.setVisibility(0);
                    this.rmw.setVisibility(0);
                    this.rms.setVisibility(8);
                    this.rmv.setVisibility(0);
                    this.rmu.setVisibility(8);
                    this.rmr.setVisibility(8);
                    this.rmt.setVisibility(8);
                    this.rmq.setVisibility(8);
                    this.rmp.setVisibility(8);
                    Point il2 = il(!this.rmO);
                    ((MovableVideoView) this.rmb).dn(il2.x, il2.y);
                    if (!(this.okA == null || this.rmP)) {
                        if (-1 == this.rlw) {
                            this.rlw = bg.Ny();
                        }
                        this.rmS = this.rlw;
                        this.rmP = true;
                        this.okA.schedule(new TimerTask(this) {
                            final /* synthetic */ e rnk;

                            {
                                this.rnk = r1;
                            }

                            public final void run() {
                                this.rnk.jiB.post(new Runnable(this) {
                                    final /* synthetic */ AnonymousClass9 rnl;

                                    {
                                        this.rnl = r1;
                                    }

                                    public final void run() {
                                        this.rnl.rnk.rmk.setText(d.aq(bg.az(this.rnl.rnk.rlw)));
                                        e eVar = this.rnl.rnk;
                                        m bpd = d.bpd();
                                        int i = eVar.rmJ;
                                        com.tencent.mm.plugin.voip.model.g gVar = bpd.riE.rew.rfS;
                                        gVar.rew.rfQ.rkL = i;
                                        gVar.rew.rfQ.rkM = 0;
                                        if (r.ijJ) {
                                            long Ny = bg.Ny();
                                            int i2 = (int) (Ny - eVar.rmS);
                                            if (i2 <= 1) {
                                                i2 = 1;
                                            }
                                            CharSequence format = String.format(Locale.US, "Cap Fps: %d", new Object[]{Integer.valueOf(eVar.rmJ)});
                                            CharSequence format2 = String.format(Locale.US, "Send Fps: %d", new Object[]{Integer.valueOf(eVar.rmI)});
                                            CharSequence format3 = String.format(Locale.US, "Recv Fps: %d", new Object[]{Integer.valueOf(eVar.rmK)});
                                            int i3 = d.bpd().riE.rew.rfS.rew.rfQ.field_sendVideoLen;
                                            int i4 = d.bpd().riE.rew.rfS.rew.rfQ.field_recvVideoLen;
                                            eVar.rmL = (int) ((((double) (i3 - eVar.rmL)) * 8.0d) / ((double) (i2 * 1000)));
                                            eVar.rmM = (int) ((((double) (i4 - eVar.rmM)) * 8.0d) / ((double) (i2 * 1000)));
                                            CharSequence format4 = String.format(Locale.US, "Send Br: %d", new Object[]{Integer.valueOf(eVar.rmL)});
                                            CharSequence format5 = String.format(Locale.US, "Recv Br: %d", new Object[]{Integer.valueOf(eVar.rmM)});
                                            byte[] bArr = d.bpd().riE.rew.rfQ.rkN;
                                            if (bArr != null) {
                                                try {
                                                    eVar.rmD.setText(new String(bArr, "UTF-8"));
                                                } catch (Throwable e) {
                                                    w.printErrStackTrace("MicroMsg.Voip.VoipVideoFragment", e, "", new Object[0]);
                                                }
                                            }
                                            eVar.rmy.setText(format);
                                            eVar.rmz.setText(format2);
                                            eVar.rmA.setText(format3);
                                            eVar.rmC.setText(format5);
                                            eVar.rmB.setText(format4);
                                            eVar.rmL = i3;
                                            eVar.rmM = i4;
                                            eVar.rmS = Ny;
                                        }
                                        eVar.rmJ = 0;
                                        eVar.rmI = 0;
                                        eVar.rmK = 0;
                                    }
                                });
                            }
                        }, 1000, 1000);
                    }
                    if (ab.bIY().getBoolean("voipfaceDebug", false)) {
                        this.rmF.setVisibility(0);
                        this.rmG.setVisibility(0);
                    }
                    bra();
                    return;
                }
                return;
            case 8:
            case 262:
                this.rlL.bqW();
                this.rms.setEnabled(false);
                this.rmw.setEnabled(false);
                this.rmv.setEnabled(false);
                this.rmu.setEnabled(false);
                this.rmt.setEnabled(false);
                this.rmr.setEnabled(false);
                this.rmx.setEnabled(false);
                this.rmq.setEnabled(false);
                this.rmp.setEnabled(false);
                switch (i) {
                    case 4105:
                        this.rml.setVisibility(0);
                        this.rml.setText(R.l.fcq);
                        break;
                }
                if (this.rlK != null) {
                    this.rlK.w(true, false);
                    return;
                }
                return;
            case 256:
                this.rma.setVisibility(8);
                this.rme.setVisibility(0);
                this.rmg.setVisibility(0);
                this.rmh.setText(R.l.fcl);
                this.rmj.setVisibility(0);
                this.rmf.setVisibility(0);
                this.rlL.a(this.rmi, rlG);
                this.rmx.setVisibility(8);
                this.rmw.setVisibility(8);
                this.rms.setVisibility(8);
                this.rmv.setVisibility(8);
                this.rmu.setVisibility(0);
                this.rmr.setVisibility(0);
                this.rmt.setVisibility(0);
                this.rmq.setVisibility(8);
                if (this.rmR) {
                    this.rmp.setVisibility(0);
                }
                bqV();
                this.rmm.setVisibility(8);
                if (d.bpd().ric != null) {
                    this.rmm.setVisibility(0);
                    this.rmm.setText(d.bpd().ric);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void b(CaptureView captureView) {
        this.rhA = captureView;
        c(this.rhA);
    }

    public final void uninit() {
        this.rmb.setVisibility(4);
        if (this.rhA != null) {
            this.rlH.removeView(this.rhA);
            this.rhA = null;
            w.d("MicroMsg.Voip.VoipVideoFragment", "CaptureView removed");
        }
        if (this.rmU != null) {
            com.tencent.mm.sdk.f.e.remove(this.rmU);
            this.rmU = null;
        }
        super.uninit();
    }

    public final void bQ(boolean z) {
    }

    public final void onStop() {
        this.rmd.bry();
        this.rmc.bry();
        super.onStop();
    }

    public final void onStart() {
        this.rmd.rps = true;
        this.rmc.rps = true;
        super.onStart();
    }

    public final void ik(boolean z) {
        if (z) {
            aG().getWindow().clearFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        } else {
            aG().getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        }
    }

    protected final void HD(String str) {
        if (this.rmm != null) {
            this.rmm.setVisibility(0);
            this.rmm.setText(str);
        }
    }

    protected final void bU(String str, int i) {
        if (this.rml != null) {
            this.rml.setText(bg.mz(str));
            this.rml.setVisibility(0);
            this.rml.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            this.rml.setBackgroundResource(R.g.blD);
            this.rml.setCompoundDrawables(null, null, null, null);
            this.rml.setCompoundDrawablePadding(0);
            this.jiB.removeCallbacks(this.rni);
            if (-1 != i) {
                this.jiB.postDelayed(this.rni, (long) i);
            }
        }
    }

    protected final void bqT() {
        if (this.mYj != null) {
            this.mYj.clearAnimation();
            this.mYj.setVisibility(0);
        }
    }

    protected final void bqU() {
        if (this.mYj != null) {
            this.mYj.clearAnimation();
            this.mYj.setVisibility(8);
        }
    }

    public final void a(byte[] bArr, long j, int i, int i2, int i3, int i4, int i5, int i6) {
        if (this.rmQ) {
            if (OpenGlRender.rpX == 1) {
                if (this.rnj < i * i2) {
                    this.nQb = null;
                }
                if (this.nQb == null) {
                    this.rnj = i * i2;
                    this.nQb = new int[this.rnj];
                }
                if (d.bpd().a(bArr, (int) j, i3 & 31, i, i2, this.nQb) >= 0 && this.nQb != null) {
                    if (this.rmO) {
                        this.rmc.a(this.nQb, i, i2, (OpenGlRender.rpD + i4) + i5);
                    } else {
                        this.rmd.a(this.nQb, i, i2, (OpenGlRender.rpD + i4) + i5);
                    }
                } else {
                    return;
                }
            } else if (OpenGlRender.rpX == 2) {
                if (this.rmO) {
                    this.rmc.b(bArr, i, i2, (OpenGlRender.rpH + i4) + i5);
                } else {
                    this.rmd.b(bArr, i, i2, (OpenGlRender.rpH + i4) + i5);
                }
            }
            this.rmJ++;
            if (i6 > 0) {
                this.rmI++;
            }
            com.tencent.mm.plugin.voip.video.e eVar = this.rmE;
            eVar.roU = i;
            eVar.roV = i2;
            eVar = this.rmE;
            int width = this.rlH.getWidth();
            int height = this.rlH.getHeight();
            eVar.roT = width;
            eVar.fg = height;
        }
    }

    public final void a(int i, int i2, int[] iArr) {
        if (this.rmQ) {
            this.rmK++;
            if (OpenGlRender.rpX == 1) {
                if (this.rmO) {
                    this.rmd.a(iArr, i, i2, OpenGlRender.rpC + OpenGlRender.rpI);
                } else {
                    this.rmc.a(iArr, i, i2, OpenGlRender.rpC + OpenGlRender.rpI);
                }
            } else if (this.rmO) {
                this.rmd.a(iArr, i, i2, OpenGlRender.rpF + OpenGlRender.rpI);
            } else {
                this.rmc.a(iArr, i, i2, OpenGlRender.rpF + OpenGlRender.rpI);
            }
        }
    }

    public final void bpR() {
        if (this.rmQ) {
            this.rmd.brz();
            this.rmc.brz();
        }
    }

    private void c(CaptureView captureView) {
        if (this.rlH != null && captureView != null) {
            this.rlH.removeView(this.rhA);
            this.rhA = null;
            this.rhA = captureView;
            this.rlH.addView(captureView, new LayoutParams(1, 1));
            this.rhA.setVisibility(0);
            w.d("MicroMsg.Voip.VoipVideoFragment", "CaptureView added");
        }
    }

    public final void onDetach() {
        w.i("MicroMsg.Voip.VoipVideoFragment", "onDetach");
        if (this.okA != null) {
            this.okA.cancel();
            this.okA = null;
        }
        super.onDetach();
    }

    public final void vb(int i) {
    }

    public final Point il(boolean z) {
        int height = (int) (((double) aG().getWindowManager().getDefaultDisplay().getHeight()) / 5.0d);
        float f = (float) height;
        d.bpd();
        return new Point((int) (f * m.ii(z)), height);
    }
}
