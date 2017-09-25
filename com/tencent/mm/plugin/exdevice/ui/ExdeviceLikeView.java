package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.w;

public class ExdeviceLikeView extends RelativeLayout {
    int llg;
    a llh;
    private int lli;
    TextView llj;
    private ImageView llk;
    private ProgressBar lll;
    private Context mContext;

    public interface a {
        boolean aqj();

        void hq(int i);
    }

    static /* synthetic */ void c(ExdeviceLikeView exdeviceLikeView) {
        Animation loadAnimation = AnimationUtils.loadAnimation(exdeviceLikeView.mContext, R.a.aRg);
        loadAnimation.setFillAfter(false);
        exdeviceLikeView.llk.startAnimation(loadAnimation);
    }

    static /* synthetic */ int lZ(int i) {
        switch (i) {
            case 0:
                return 1;
            case 1:
                return 0;
            case 2:
                return 2;
            default:
                w.w("MicroMsg.ExdeviceLikeView", "hy: state error");
                return 2;
        }
    }

    public ExdeviceLikeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.lli = 2;
        this.mContext = context;
        View inflate = LayoutInflater.from(this.mContext).inflate(R.i.dbD, this, true);
        this.llj = (TextView) inflate.findViewById(R.h.bMK);
        this.llk = (ImageView) inflate.findViewById(R.h.bMJ);
        this.lll = (ProgressBar) inflate.findViewById(R.h.bMN);
        setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ExdeviceLikeView llm;

            {
                this.llm = r1;
            }

            public final void onClick(View view) {
                if (this.llm.llh == null || this.llm.llh.aqj() || this.llm.lli != 0) {
                    w.d("MicroMsg.ExdeviceLikeView", "hy: loading or has liked or consumed. abort event");
                    return;
                }
                w.d("MicroMsg.ExdeviceLikeView", "click listener is not null");
                this.llm.lY(ExdeviceLikeView.lZ(this.llm.lli));
                if (this.llm.lli == 1) {
                    ExdeviceLikeView.c(this.llm);
                }
                if (this.llm.llh != null) {
                    this.llm.llh.hq(this.llm.lli);
                }
            }
        });
    }

    public ExdeviceLikeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public final void lY(int i) {
        this.lli = i;
        if (this.lli == 1) {
            this.lll.setVisibility(8);
            this.llj.setVisibility(0);
            this.llk.setVisibility(0);
            this.llk.setImageResource(R.k.dwx);
        } else if (this.lli == 0) {
            this.lll.setVisibility(8);
            this.llj.setVisibility(0);
            this.llk.setVisibility(0);
            this.llk.setImageResource(R.k.dwy);
        } else if (this.lli == 2) {
            this.llj.setVisibility(8);
            this.lll.setVisibility(0);
            this.llk.setVisibility(8);
        } else {
            w.w("MicroMsg.ExdeviceLikeView", "hy: error state");
        }
    }
}
