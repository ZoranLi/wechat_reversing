package com.tencent.mm.plugin.voip.ui;

import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.voip.model.d;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.n;
import com.tencent.mm.ui.base.s;
import java.util.Timer;
import java.util.TimerTask;

public final class f extends d {
    public boolean fAp = false;
    private TextView mYj;
    private Timer okA;
    public int rhK = 1;
    private boolean rmP = false;
    private boolean rmR = false;
    private Button rmo;
    public MMCheckBox rnA;
    private TextView rnB;
    public TextView rnC;
    private TextView rnD;
    public VoipBigIconButton rnE;
    public VoipBigIconButton rnF;
    public VoipBigIconButton rnG;
    public VoipBigIconButton rnH;
    private VoipSmallIconButton rnI;
    private OnClickListener rnJ = new OnClickListener(this) {
        final /* synthetic */ f rnP;

        {
            this.rnP = r1;
        }

        public final void onClick(View view) {
            boolean isChecked = this.rnP.rnx.isChecked();
            w.i("MicroMsg.VoipVoiceFragment", "onSpeakerClick, status: %b", new Object[]{Boolean.valueOf(isChecked)});
            this.rnP.rnx.setEnabled(false);
            if (!(this.rnP.rlu == null || this.rnP.rlu.get() == null)) {
                ((c) this.rnP.rlu.get()).ie(isChecked);
            }
            this.rnP.rhK = isChecked ? 1 : 2;
            this.rnP.rnx.setEnabled(true);
        }
    };
    private OnClickListener rnK = new OnClickListener(this) {
        final /* synthetic */ f rnP;

        {
            this.rnP = r1;
        }

        public final void onClick(View view) {
            boolean isChecked = this.rnP.rnA.isChecked();
            w.i("MicroMsg.VoipVoiceFragment", "onMicClick, status: %b", new Object[]{Boolean.valueOf(isChecked)});
            this.rnP.rnA.setEnabled(false);
            if (!(this.rnP.rlu == null || this.rnP.rlu.get() == null)) {
                ((c) this.rnP.rlu.get()).fN(isChecked);
            }
            this.rnP.fAp = isChecked;
            this.rnP.rnA.setEnabled(true);
        }
    };
    private OnClickListener rnL = new OnClickListener(this) {
        final /* synthetic */ f rnP;

        {
            this.rnP = r1;
        }

        public final void onClick(View view) {
            w.i("MicroMsg.VoipVoiceFragment", "click accept voice invite button");
            g.oUh.a(11526, true, true, new Object[]{Integer.valueOf(d.bpd().bqh()), Long.valueOf(d.bpd().bqi()), Long.valueOf(d.bpd().bqj()), Integer.valueOf(2)});
            if (this.rnP.rlu != null && this.rnP.rlu.get() != null && ((c) this.rnP.rlu.get()).bpG()) {
                this.rnP.rnE.setEnabled(false);
                this.rnP.rnt.setText(R.l.fcS);
                this.rnP.rlL.a(this.rnP.rnu, d.rlG);
                this.rnP.rnv.setVisibility(0);
                this.rnP.rns.setVisibility(8);
                this.rnP.rnE.setVisibility(8);
                this.rnP.rnF.setVisibility(8);
                this.rnP.rnG.setVisibility(0);
            }
        }
    };
    private OnClickListener rnM = new OnClickListener(this) {
        final /* synthetic */ f rnP;

        {
            this.rnP = r1;
        }

        public final void onClick(View view) {
            w.i("MicroMsg.VoipVoiceFragment", "click reject voice invite button");
            g.oUh.a(11526, true, true, new Object[]{Integer.valueOf(d.bpd().bqh()), Long.valueOf(d.bpd().bqi()), Long.valueOf(d.bpd().bqj()), Integer.valueOf(5)});
            if (this.rnP.rlu != null && this.rnP.rlu.get() != null && ((c) this.rnP.rlu.get()).bpF()) {
                this.rnP.rnF.setEnabled(false);
                this.rnP.rnE.setEnabled(false);
                this.rnP.bU(this.rnP.getString(R.l.fcw), -1);
                if (this.rnP.rlK != null) {
                    this.rnP.rlK.w(true, false);
                }
            }
        }
    };
    private OnClickListener rnN = new OnClickListener(this) {
        final /* synthetic */ f rnP;

        {
            this.rnP = r1;
        }

        public final void onClick(View view) {
            w.i("MicroMsg.VoipVoiceFragment", "click hangup voice talking button");
            if (this.rnP.rlu != null && this.rnP.rlu.get() != null && ((c) this.rnP.rlu.get()).bpB()) {
                this.rnP.bU(this.rnP.getString(R.l.fbX), -1);
            }
        }
    };
    private OnClickListener rnO = new OnClickListener(this) {
        final /* synthetic */ f rnP;

        {
            this.rnP = r1;
        }

        public final void onClick(View view) {
            w.i("MicroMsg.VoipVoiceFragment", "click cancel voice invite button");
            if (this.rnP.rlu != null && this.rnP.rlu.get() != null && ((c) this.rnP.rlu.get()).bpI()) {
                this.rnP.bU(this.rnP.getString(R.l.fbv), -1);
                this.rnP.rnH.setEnabled(false);
            }
        }
    };
    private OnClickListener rnc = new OnClickListener(this) {
        final /* synthetic */ f rnP;

        {
            this.rnP = r1;
        }

        public final void onClick(View view) {
            g.oUh.i(11618, new Object[]{Integer.valueOf(3), Integer.valueOf(1)});
            if (!(this.rnP.rlu == null || this.rnP.rlu.get() == null)) {
                ((c) this.rnP.rlu.get()).if(true);
            }
            if (this.rnP.rlK != null) {
                this.rnP.rlK.w(false, true);
            }
        }
    };
    private OnClickListener rnd = new OnClickListener(this) {
        final /* synthetic */ f rnP;

        {
            this.rnP = r1;
        }

        public final void onClick(View view) {
            g.oUh.i(11619, new Object[]{Integer.valueOf(3)});
            if (this.rnP.rlu != null && this.rnP.rlu.get() != null) {
                ((c) this.rnP.rlu.get()).bpW();
            }
        }
    };
    private Runnable rni = new Runnable(this) {
        final /* synthetic */ f rnP;

        {
            this.rnP = r1;
        }

        public final void run() {
            if (this.rnP.aG() != null && !this.rnP.aG().isFinishing()) {
                this.rnP.rnC.setVisibility(8);
            }
        }
    };
    private View rnp;
    private ImageView rnq;
    private TextView rnr;
    public TextView rns;
    public TextView rnt;
    public TextView rnu;
    public View rnv;
    private RelativeLayout rnw;
    public MMCheckBox rnx;
    private TextView rny;
    private RelativeLayout rnz;

    public final void onDestroy() {
        this.rmP = false;
        super.onDestroy();
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) layoutInflater.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        w.i("MicroMsg.VoipVoiceFragment", "dpi: " + (((float) displayMetrics.heightPixels) / displayMetrics.density));
        if (((float) displayMetrics.heightPixels) / displayMetrics.density <= 540.0f) {
            this.rlH = (RelativeLayout) layoutInflater.inflate(R.i.dpP, viewGroup, false);
        } else {
            this.rlH = (RelativeLayout) layoutInflater.inflate(R.i.dpO, viewGroup, false);
            if (Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
                ((RelativeLayout) this.rlH.findViewById(R.h.czc)).setPadding(0, 0, 0, b.a(aG(), 40.0f));
            }
        }
        this.rlI = (ImageView) this.rlH.findViewById(R.h.cNP);
        this.rnp = this.rlH.findViewById(R.h.cOE);
        this.rnq = (ImageView) this.rlH.findViewById(R.h.cOQ);
        a.b.a(this.rnq, this.gLD, 0.0375f, true);
        this.rnr = (TextView) this.rlH.findViewById(R.h.cOR);
        this.rnr.setText(h.b(aG(), n.eK(this.gLD), this.rnr.getTextSize()));
        this.rns = (TextView) this.rlH.findViewById(R.h.cOW);
        this.rnt = (TextView) this.rlH.findViewById(R.h.cOI);
        this.rnu = (TextView) this.rlH.findViewById(R.h.cOK);
        this.rnv = this.rlH.findViewById(R.h.cOJ);
        this.rnC = (TextView) this.rlH.findViewById(R.h.cOF);
        this.rnD = (TextView) this.rlH.findViewById(R.h.cOS);
        this.mYj = (TextView) this.rlH.findViewById(R.h.cOj);
        b(this.rnu, getResources().getString(R.l.fcC));
        this.rnz = (RelativeLayout) this.rlH.findViewById(R.h.cOM);
        this.rnA = (MMCheckBox) this.rlH.findViewById(R.h.cOL);
        this.rnA.setChecked(this.fAp);
        this.rnB = (TextView) this.rlH.findViewById(R.h.cON);
        this.rnB.setText(R.l.fcm);
        this.rnw = (RelativeLayout) this.rlH.findViewById(R.h.cOU);
        this.rnx = (MMCheckBox) this.rlH.findViewById(R.h.cOT);
        this.rny = (TextView) this.rlH.findViewById(R.h.cOV);
        this.rny.setText(R.l.fcA);
        brb();
        this.rnE = (VoipBigIconButton) this.rlH.findViewById(R.h.cOD);
        this.rnE.setOnClickListener(this.rnL);
        this.rnF = (VoipBigIconButton) this.rlH.findViewById(R.h.cOP);
        this.rnF.setOnClickListener(this.rnM);
        this.rnG = (VoipBigIconButton) this.rlH.findViewById(R.h.cOH);
        this.rnG.setOnClickListener(this.rnN);
        this.rnH = (VoipBigIconButton) this.rlH.findViewById(R.h.cOG);
        this.rnH.setOnClickListener(this.rnO);
        this.rmR = com.tencent.mm.plugin.voip.b.d.mo("VOIPBlockIgnoreButton") == 0;
        this.rnI = (VoipSmallIconButton) this.rlH.findViewById(R.h.cOh);
        this.rnI.setOnClickListener(this.rnd);
        if (!this.rmR) {
            this.rnI.setVisibility(8);
        }
        this.rnx.setOnClickListener(this.rnJ);
        this.rnA.setOnClickListener(this.rnK);
        this.rmo = (Button) this.rlH.findViewById(R.h.bvb);
        this.rmo.setOnClickListener(this.rnc);
        int eR = s.eR(aG());
        w.d("MicroMsg.VoipVoiceFragment", "statusHeight: " + eR);
        d.E(this.rmo, eR);
        if (this.rhF && 2 == this.rhK) {
            bU(getString(R.l.fbc), 10000);
        }
        this.okA = new Timer();
        dm(this.rlJ, this.mStatus);
        return this.rlH;
    }

    public final void dm(int i, int i2) {
        super.dm(i, i2);
        w.i("MicroMsg.VoipVoiceFragment", "newState: " + com.tencent.mm.plugin.voip.b.b.vf(i2));
        if (this.rlH == null) {
            w.i("MicroMsg.VoipVoiceFragment", "fragment no create, return first, onCreateView will call it again");
            return;
        }
        switch (i2) {
            case 1:
                this.rnp.setVisibility(0);
                this.rns.setVisibility(8);
                this.rnt.setText(R.l.fcu);
                this.rlL.a(this.rnu, rlG);
                this.rnv.setVisibility(0);
                this.rnE.setVisibility(8);
                this.rnF.setVisibility(8);
                this.rnG.setVisibility(8);
                this.rnH.setVisibility(0);
                this.rnI.setVisibility(8);
                this.rnz.setVisibility(0);
                this.rnA.setEnabled(false);
                this.rnA.setBackgroundResource(R.g.blF);
                this.rnB.setTextColor(1728053247);
                this.rnD.setVisibility(8);
                if (d.bpd().ric != null) {
                    this.rnD.setVisibility(0);
                    this.rnD.setText(d.bpd().ric);
                }
                brb();
                this.rnA.setChecked(this.fAp);
                this.rnw.setVisibility(0);
                if (2 == this.rhK) {
                    bU(getString(R.l.fbc), 10000);
                }
                bqV();
                return;
            case 3:
                this.rnp.setVisibility(0);
                this.rns.setVisibility(8);
                this.rnt.setText(R.l.fcj);
                this.rlL.a(this.rnu, rlG);
                this.rnv.setVisibility(0);
                this.rnE.setVisibility(8);
                this.rnF.setVisibility(8);
                this.rnG.setVisibility(8);
                this.rnH.setVisibility(0);
                this.rnI.setVisibility(8);
                this.rnz.setVisibility(0);
                this.rnA.setEnabled(false);
                this.rnA.setBackgroundResource(R.g.blF);
                this.rnB.setTextColor(1728053247);
                brb();
                this.rnA.setChecked(this.fAp);
                this.rnw.setVisibility(0);
                if (i != 4097 && 2 == this.rhK) {
                    bU(getString(R.l.fbc), 10000);
                }
                bqV();
                this.rnD.setVisibility(8);
                if (d.bpd().ric != null) {
                    this.rnD.setVisibility(0);
                    this.rnD.setText(d.bpd().ric);
                    return;
                }
                return;
            case 5:
                this.rnt.setText(R.l.fcS);
                this.rlL.a(this.rnu, rlG);
                this.rnE.setVisibility(8);
                this.rnF.setVisibility(8);
                this.rnG.setVisibility(0);
                this.rnH.setVisibility(8);
                this.rnI.setVisibility(8);
                return;
            case 7:
            case 261:
                this.rnH.setVisibility(8);
                this.rnE.setVisibility(8);
                this.rnF.setVisibility(8);
                this.rnI.setVisibility(8);
                this.rnv.setVisibility(8);
                this.rlL.bqW();
                this.rnG.setVisibility(0);
                this.rns.setVisibility(0);
                this.rnz.setVisibility(0);
                this.rnw.setVisibility(0);
                this.rnp.setVisibility(0);
                this.rmo.setVisibility(0);
                this.rnA.setEnabled(true);
                this.rnA.setBackgroundResource(R.g.blB);
                this.rnB.setTextColor(-1);
                brb();
                this.rnA.setChecked(this.fAp);
                if (2 == this.rhK) {
                    bU(getString(R.l.fbc), 10000);
                }
                bqV();
                if (!(this.okA == null || this.rmP)) {
                    if (-1 == this.rlw) {
                        this.rlw = bg.Ny();
                    }
                    this.rmP = true;
                    this.okA.schedule(new TimerTask(this) {
                        final /* synthetic */ f rnP;

                        {
                            this.rnP = r1;
                        }

                        public final void run() {
                            this.rnP.jiB.post(new Runnable(this) {
                                final /* synthetic */ AnonymousClass2 rnQ;

                                {
                                    this.rnQ = r1;
                                }

                                public final void run() {
                                    this.rnQ.rnP.rns.setText(d.aq(bg.az(this.rnQ.rnP.rlw)));
                                }
                            });
                        }
                    }, 50, 1000);
                }
                this.rnD.setVisibility(8);
                if (d.bpd().ric != null) {
                    this.rnD.setVisibility(0);
                    this.rnD.setText(d.bpd().ric);
                    return;
                }
                return;
            case 8:
            case 262:
                this.rlL.bqW();
                this.rnG.setEnabled(false);
                this.rnH.setEnabled(false);
                this.rnE.setEnabled(false);
                this.rnF.setEnabled(false);
                this.rnI.setEnabled(false);
                return;
            case 257:
                this.rnp.setVisibility(0);
                this.rnv.setVisibility(0);
                this.rnt.setText(R.l.fck);
                this.rlL.a(this.rnu, rlG);
                brb();
                this.rnE.setVisibility(0);
                this.rnF.setVisibility(0);
                this.rnG.setVisibility(8);
                this.rnH.setVisibility(8);
                if (this.rmR) {
                    this.rnI.setVisibility(0);
                }
                bU(getString(R.l.fbd), 10000);
                bqV();
                this.rnD.setVisibility(8);
                if (d.bpd().ric != null) {
                    this.rnD.setVisibility(0);
                    this.rnD.setText(d.bpd().ric);
                    return;
                }
                return;
            case 259:
                this.rnp.setVisibility(0);
                this.rnv.setVisibility(0);
                this.rnt.setText(R.l.fcS);
                this.rlL.a(this.rnu, rlG);
                this.rnE.setVisibility(8);
                this.rnF.setVisibility(8);
                this.rnG.setVisibility(0);
                this.rnH.setVisibility(8);
                this.rnI.setVisibility(8);
                bU(getString(R.l.fbd), 10000);
                bqV();
                return;
            default:
                return;
        }
    }

    public final void b(CaptureView captureView) {
    }

    public final void uninit() {
        if (this.okA != null) {
            this.okA.cancel();
            this.okA = null;
        }
        super.uninit();
    }

    protected final void HD(String str) {
        if (this.rnD != null) {
            this.rnD.setVisibility(0);
            this.rnD.setText(str);
        }
    }

    protected final void bU(String str, int i) {
        if (this.rnC != null) {
            this.rnC.setText(bg.mz(str));
            this.rnC.setVisibility(0);
            this.rnC.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            this.rnC.setBackgroundResource(R.g.blD);
            this.rnC.setCompoundDrawables(null, null, null, null);
            this.rnC.setCompoundDrawablePadding(0);
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

    public final void bQ(boolean z) {
        this.fAp = z;
        if (this.rnA != null && this.rnB != null) {
            this.rnA.setChecked(z);
        }
    }

    public final void a(byte[] bArr, long j, int i, int i2, int i3, int i4, int i5, int i6) {
    }

    public final void a(int i, int i2, int[] iArr) {
    }

    public final void bpR() {
    }

    public final void vb(int i) {
        this.rhK = i;
        brb();
    }

    private void brb() {
        boolean z = false;
        if (this.rnx == null || this.rny == null) {
            w.e("MicroMsg.VoipVoiceFragment", "speaker is null");
        } else if (4 == this.rhK || 3 == this.rhK) {
            this.rnx.setEnabled(false);
            this.rny.setTextColor(1728053247);
            this.rnx.setBackgroundResource(R.g.blA);
        } else {
            if (this.rhK == 1) {
                z = true;
            }
            this.rnx.setBackgroundResource(R.g.blC);
            this.rnx.setEnabled(true);
            this.rny.setTextColor(-1);
            this.rnx.setChecked(z);
        }
    }
}
