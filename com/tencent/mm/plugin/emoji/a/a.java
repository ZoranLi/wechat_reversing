package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.emoji.a.a.e;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public abstract class a {
    private final String TAG;
    private LayoutInflater dZ;
    protected TextView jhl;
    public int kC;
    protected View kHA;
    protected ImageView kHB;
    protected ImageView kHC;
    protected TextView kHD;
    protected TextView kHE;
    protected ProgressBar kHF;
    protected ViewGroup kHG;
    protected View kHH;
    protected TextView kHI;
    protected ImageView kHJ;
    protected View kHK;
    protected ProgressBar kHL;
    protected TextView kHM;
    protected TextView kHN;
    protected FrameLayout kHO;
    protected View kHP;
    private View kHt;
    private final int kHu;
    private final int kHv;
    private final int kHw;
    private int[] kHx;
    private int kHy;
    public f kHz;
    Context mContext;

    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] kHS = new int[a.alj().length];

        static {
            try {
                kHS[a.kHT - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                kHS[a.kHU - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                kHS[a.kHV - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public enum a {
        ;

        public static int[] alj() {
            return (int[]) kHW.clone();
        }

        static {
            kHT = 1;
            kHU = 2;
            kHV = 3;
            kHW = new int[]{kHT, kHU, kHV};
        }
    }

    protected abstract void akV();

    protected abstract int[] akW();

    protected abstract int akX();

    protected abstract boolean ale();

    public a(Context context, View view) {
        this(context, view, a.kHT);
    }

    private a(Context context, View view, int i) {
        this.TAG = "MicroMsg.emoji.BaseEmojiItemHolder";
        this.kHu = R.i.dat;
        this.kHv = R.i.daE;
        this.kHw = R.i.daF;
        this.kHx = new int[]{-1, -1};
        this.kHy = -1;
        this.mContext = context;
        this.dZ = LayoutInflater.from(this.mContext);
        if (view == null) {
            switch (AnonymousClass2.kHS[i - 1]) {
                case 1:
                    view = lb(this.kHu);
                    break;
                case 2:
                    view = lb(this.kHw);
                    break;
                case 3:
                    view = lb(this.kHv);
                    break;
                default:
                    view = lb(this.kHu);
                    break;
            }
        }
        this.kHP = view;
        if (view != null) {
            this.kHt = view;
            this.kHA = this.kHt.findViewById(R.h.bZe);
            this.kHC = (ImageView) this.kHt.findViewById(R.h.bZM);
            this.kHB = (ImageView) this.kHt.findViewById(R.h.bZl);
            this.jhl = (TextView) this.kHt.findViewById(R.h.bZv);
            this.kHD = (TextView) this.kHt.findViewById(R.h.bZg);
            this.kHE = (TextView) this.kHt.findViewById(R.h.bZn);
            this.kHF = (ProgressBar) this.kHt.findViewById(R.h.css);
            this.kHH = this.kHt.findViewById(R.h.bZx);
            this.kHG = (ViewGroup) this.kHt.findViewById(R.h.bZG);
            this.kHI = (TextView) this.kHt.findViewById(R.h.bZI);
            this.kHJ = (ImageView) this.kHt.findViewById(R.h.bZJ);
            this.kHK = this.kHt.findViewById(R.h.bZF);
            this.kHL = (ProgressBar) this.kHt.findViewById(R.h.bZi);
            this.kHM = (TextView) this.kHt.findViewById(R.h.bZd);
            this.kHN = (TextView) this.kHt.findViewById(R.h.bZw);
            this.kHO = (FrameLayout) this.kHt.findViewById(R.h.bZt);
        }
        akV();
        if (i == a.kHT) {
            int[] akW = akW();
            if (this.kHB != null && akW[0] >= 0 && akW[1] >= 0 && !(akW[0] == this.kHx[0] && akW[1] == this.kHx[1])) {
                LayoutParams layoutParams = this.kHB.getLayoutParams();
                layoutParams.width = akW[0];
                layoutParams.height = akW[1];
                this.kHB.setLayoutParams(layoutParams);
                this.kHx = akW;
            }
            int akX = akX();
            if (!(this.kHt == null || akX < 0 || this.kHy == akX)) {
                this.kHt.setMinimumHeight(akX);
                if (this.kHA != null) {
                    this.kHA.setMinimumHeight(akX);
                }
            }
        }
        view.setTag(this);
    }

    private View lb(int i) {
        if (this.dZ == null || i <= 0) {
            return null;
        }
        return this.dZ.inflate(i, null);
    }

    public final void setTitle(String str) {
        this.jhl.setText(str);
    }

    public final void setTitle(int i) {
        this.jhl.setText(i);
    }

    public final ImageView akY() {
        return this.kHB;
    }

    public final void lc(int i) {
        this.kHB.setImageResource(i);
    }

    public final ImageView akZ() {
        return this.kHC;
    }

    public final void ld(int i) {
        this.kHC.setVisibility(i);
    }

    public final void le(int i) {
        this.kHC.setImageResource(i);
    }

    public final void lf(int i) {
        this.kHH.setVisibility(i);
    }

    public final void ala() {
        this.kHD.setVisibility(8);
        this.kHE.setVisibility(8);
    }

    public final void tR(String str) {
        this.kHD.setText(str);
    }

    public final void tS(String str) {
        if (bg.mA(str)) {
            this.kHE.setVisibility(8);
            return;
        }
        this.kHE.setVisibility(0);
        this.kHE.setText(str);
    }

    public final void a(final com.tencent.mm.plugin.emoji.model.g.a aVar) {
        if (this.kHH != null) {
            this.kHH.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ a kHR;

                public final void onClick(View view) {
                    if (this.kHR.a(aVar, view)) {
                        this.kHR.b(aVar, view);
                    }
                }
            });
        }
    }

    protected boolean a(com.tencent.mm.plugin.emoji.model.g.a aVar, View view) {
        return true;
    }

    protected void b(com.tencent.mm.plugin.emoji.model.g.a aVar, View view) {
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public final String alb() {
        return (this.kHz == null || this.kHz.kJb == null) ? null : this.kHz.kJb.tgW;
    }

    public final int alc() {
        return (this.kHz == null ? null : Integer.valueOf(this.kHz.mStatus)).intValue();
    }

    public final String ald() {
        return (this.kHz == null || this.kHz.kJb == null) ? null : this.kHz.kJb.tuY;
    }

    public final int getProgress() {
        return this.kHz == null ? 0 : this.kHz.sd;
    }

    protected final void alf() {
        this.kHF.setVisibility(8);
        this.kHG.setVisibility(8);
        this.kHH.setEnabled(false);
        this.kHJ.setVisibility(8);
        this.kHL.setVisibility(0);
        this.kHL.setProgress(getProgress());
        if (this.kHK == null) {
            this.kHL.setVisibility(0);
        } else {
            this.kHK.setVisibility(0);
        }
    }

    private void alg() {
        this.kHF.setVisibility(8);
        this.kHG.setBackgroundResource(R.g.bda);
        this.kHG.setVisibility(0);
        this.kHH.setEnabled(true);
        this.kHI.setText("");
        if (this.kHK == null) {
            this.kHL.setVisibility(4);
        } else {
            this.kHK.setVisibility(4);
        }
        this.kHI.setVisibility(0);
        this.kHI.setText(R.l.edi);
        this.kHI.setTextColor(this.mContext.getResources().getColorStateList(R.e.aWx));
        this.kHJ.setVisibility(8);
    }

    public void alh() {
        if (this.kHz != null && ale()) {
            this.kHI.setVisibility(8);
            this.kHI.setTextColor(this.mContext.getResources().getColorStateList(R.e.aSW));
            switch (alc()) {
                case 0:
                    alg();
                    return;
                case 3:
                    alg();
                    return;
                case 4:
                case 12:
                    this.kHF.setVisibility(8);
                    this.kHG.setBackgroundResource(R.g.bdd);
                    this.kHG.setVisibility(0);
                    if (this.kHK == null) {
                        this.kHL.setVisibility(4);
                    } else {
                        this.kHK.setVisibility(4);
                    }
                    this.kHH.setEnabled(true);
                    this.kHJ.setVisibility(4);
                    this.kHI.setVisibility(0);
                    if (this.kHz.kJb != null) {
                        this.kHI.setText(this.kHz.kJb.tuY);
                        return;
                    }
                    return;
                case 6:
                    alf();
                    return;
                case 7:
                    if (this.kHz.kJf) {
                        w.d("MicroMsg.emoji.BaseEmojiItemHolder", "jacks use emoji");
                        this.kHF.setVisibility(8);
                        this.kHG.setBackgroundResource(R.g.bda);
                        this.kHG.setVisibility(0);
                        this.kHG.setTag(alb());
                        this.kHH.setEnabled(true);
                        this.kHI.setVisibility(0);
                        this.kHI.setText(R.l.edW);
                        this.kHI.setTextColor(this.mContext.getResources().getColorStateList(R.e.aWx));
                        this.kHJ.setVisibility(4);
                        if (this.kHK == null) {
                            this.kHL.setVisibility(4);
                            return;
                        } else {
                            this.kHK.setVisibility(4);
                            return;
                        }
                    } else if (this.kHz.kJh && e.bO(this.kHz.kJb.tva, 64)) {
                        this.kHG.setVisibility(0);
                        this.kHG.setBackgroundResource(R.g.bdc);
                        this.kHI.setVisibility(0);
                        this.kHI.setText(R.l.edz);
                        this.kHI.setTextColor(this.mContext.getResources().getColorStateList(R.e.aWx));
                        this.kHJ.setVisibility(4);
                        this.kHH.setEnabled(true);
                        if (this.kHK == null) {
                            this.kHL.setVisibility(4);
                            return;
                        } else {
                            this.kHK.setVisibility(4);
                            return;
                        }
                    } else {
                        this.kHF.setVisibility(8);
                        this.kHG.setVisibility(0);
                        this.kHG.setBackgroundResource(R.g.bdd);
                        this.kHI.setVisibility(0);
                        this.kHI.setText(R.l.edk);
                        this.kHI.setTextColor(this.mContext.getResources().getColorStateList(R.e.aSV));
                        this.kHJ.setVisibility(4);
                        this.kHH.setEnabled(false);
                        if (this.kHK == null) {
                            this.kHL.setVisibility(4);
                            return;
                        } else {
                            this.kHK.setVisibility(4);
                            return;
                        }
                    }
                case 8:
                    this.kHF.setVisibility(8);
                    this.kHG.setBackgroundDrawable(null);
                    this.kHG.setVisibility(0);
                    this.kHH.setEnabled(false);
                    this.kHI.setVisibility(0);
                    this.kHI.setText(R.l.edl);
                    this.kHJ.setVisibility(4);
                    if (this.kHK == null) {
                        this.kHL.setVisibility(4);
                        return;
                    } else {
                        this.kHK.setVisibility(4);
                        return;
                    }
                case 10:
                    this.kHF.setVisibility(8);
                    this.kHG.setBackgroundResource(R.g.bdd);
                    this.kHG.setVisibility(0);
                    this.kHI.setVisibility(0);
                    this.kHI.setText(R.l.edu);
                    this.kHJ.setVisibility(4);
                    this.kHH.setEnabled(true);
                    if (this.kHK == null) {
                        this.kHL.setVisibility(4);
                        return;
                    } else {
                        this.kHK.setVisibility(4);
                        return;
                    }
                case 11:
                    this.kHF.setVisibility(0);
                    this.kHG.setBackgroundResource(R.g.bdd);
                    this.kHG.setVisibility(0);
                    this.kHI.setVisibility(0);
                    this.kHI.setText("");
                    this.kHH.setEnabled(false);
                    this.kHJ.setVisibility(4);
                    if (this.kHK == null) {
                        this.kHL.setVisibility(4);
                        return;
                    } else {
                        this.kHK.setVisibility(4);
                        return;
                    }
                default:
                    w.w("MicroMsg.emoji.BaseEmojiItemHolder", "unknow product status:%d", new Object[]{Integer.valueOf(alc())});
                    return;
            }
        }
    }

    public final View ali() {
        return this.kHP;
    }
}
