package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public class LuckyMoneyAutoScrollView extends RelativeLayout implements b {
    private View ipu;
    private Context mContext;
    private RelativeLayout nqJ;
    private RelativeLayout nqK;
    private RelativeLayout nqL;
    LuckyMoneyAutoScrollItem nqM;
    LuckyMoneyAutoScrollItem nqN;
    LuckyMoneyAutoScrollItem nqO;
    ImageView nqP;
    ImageView nqQ;
    ImageView nqR;
    private String nqS;
    private String nqT;
    private String nqU;
    boolean nqV;
    private a nqW;

    public interface a {
        void aIq();
    }

    public LuckyMoneyAutoScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.nqS = "0";
        this.nqT = "0";
        this.nqU = "0";
        this.nqV = false;
        this.mContext = context;
        View inflate = LayoutInflater.from(this.mContext).inflate(R.i.dgY, this);
        this.ipu = inflate;
        this.nqM = (LuckyMoneyAutoScrollItem) inflate.findViewById(R.h.boz);
        this.nqN = (LuckyMoneyAutoScrollItem) inflate.findViewById(R.h.boA);
        this.nqO = (LuckyMoneyAutoScrollItem) inflate.findViewById(R.h.boB);
        this.nqP = (ImageView) inflate.findViewById(R.h.cHG);
        this.nqQ = (ImageView) inflate.findViewById(R.h.cHH);
        this.nqR = (ImageView) inflate.findViewById(R.h.cHI);
        this.nqJ = (RelativeLayout) inflate.findViewById(R.h.bZo);
        this.nqK = (RelativeLayout) inflate.findViewById(R.h.bZp);
        this.nqL = (RelativeLayout) inflate.findViewById(R.h.bZq);
    }

    public LuckyMoneyAutoScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public final void zN(String str) {
        w.i("MicroMsg.LuckyMoneyAutoScrollView", "hy: setting text: %s", new Object[]{str});
        this.nqS = str.substring(0, 1);
        this.nqT = str.substring(2, 3);
        this.nqU = str.substring(3, 4);
        this.nqM.nqz = bg.getInt(this.nqS, 0);
        this.nqN.nqz = bg.getInt(this.nqT, 0);
        this.nqO.nqz = bg.getInt(this.nqU, 0);
        this.nqP.setImageResource(((Integer) LuckyMoneyAutoScrollItem.nqD.get(bg.getInt(this.nqS, 0))).intValue());
        this.nqQ.setImageResource(((Integer) LuckyMoneyAutoScrollItem.nqD.get(bg.getInt(this.nqT, 0))).intValue());
        this.nqR.setImageResource(((Integer) LuckyMoneyAutoScrollItem.nqD.get(bg.getInt(this.nqU, 0))).intValue());
        this.nqP.setVisibility(4);
        this.nqQ.setVisibility(4);
        this.nqR.setVisibility(4);
        this.nqM.nqC = this;
        this.nqN.nqC = this;
        this.nqO.nqC = this;
        w.i("MicroMsg.LuckyMoneyAutoScrollView", "hy: first: %s, second :%s, third: %s", new Object[]{this.nqS, this.nqT, this.nqU});
    }

    public final void a(a aVar) {
        this.nqW = aVar;
        af.v(new Runnable(this) {
            final /* synthetic */ LuckyMoneyAutoScrollView nqX;

            {
                this.nqX = r1;
            }

            public final void run() {
                this.nqX.nqM.aIo();
                this.nqX.nqN.aIo();
                this.nqX.nqO.aIo();
            }
        });
    }

    public final void aIp() {
        if (!this.nqV) {
            this.nqV = true;
            af.v(new Runnable(this) {
                final /* synthetic */ LuckyMoneyAutoScrollView nqX;

                {
                    this.nqX = r1;
                }

                public final void run() {
                    this.nqX.nqM.setVisibility(8);
                    this.nqX.nqN.setVisibility(8);
                    this.nqX.nqO.setVisibility(8);
                    this.nqX.nqP.setVisibility(0);
                    this.nqX.nqQ.setVisibility(0);
                    this.nqX.nqR.setVisibility(0);
                    if (this.nqX.nqW != null) {
                        this.nqX.nqW.aIq();
                    }
                }
            });
        }
    }

    public final void cn(int i, int i2) {
        if (i > 0 && i2 > 0) {
            LayoutParams layoutParams = (LayoutParams) this.ipu.getLayoutParams();
            layoutParams.height = i2;
            this.ipu.setLayoutParams(layoutParams);
            this.ipu.invalidate();
            layoutParams = (LayoutParams) this.nqJ.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            this.nqJ.setLayoutParams(layoutParams);
            this.nqJ.invalidate();
            layoutParams = (LayoutParams) this.nqK.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            this.nqK.setLayoutParams(layoutParams);
            this.nqK.invalidate();
            layoutParams = (LayoutParams) this.nqL.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            layoutParams.leftMargin = 0;
            this.nqL.setLayoutParams(layoutParams);
            this.nqL.invalidate();
        }
    }
}
