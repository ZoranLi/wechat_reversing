package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.af;

public class ExdeviceRankListHeaderView extends RelativeLayout {
    private TextView lnI;
    OnClickListener lnJ;
    private Animation lnK;
    private Animation lnL;
    private Runnable lnM;
    boolean lnN;
    private Context mContext;

    static /* synthetic */ void b(ExdeviceRankListHeaderView exdeviceRankListHeaderView) {
        af.I(exdeviceRankListHeaderView.lnM);
        if (exdeviceRankListHeaderView.lnI.getVisibility() == 4) {
            exdeviceRankListHeaderView.lnK.reset();
            exdeviceRankListHeaderView.lnI.startAnimation(exdeviceRankListHeaderView.lnK);
            return;
        }
        exdeviceRankListHeaderView.lnL.reset();
        exdeviceRankListHeaderView.lnI.startAnimation(exdeviceRankListHeaderView.lnL);
    }

    public ExdeviceRankListHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.lnN = true;
        bV(context);
    }

    public ExdeviceRankListHeaderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public ExdeviceRankListHeaderView(Context context) {
        super(context);
        this.lnN = true;
        bV(context);
    }

    private void bV(Context context) {
        this.mContext = context;
        this.lnI = (TextView) LayoutInflater.from(this.mContext).inflate(R.i.dbT, this, true).findViewById(R.h.byX);
        this.lnI.setVisibility(4);
        this.lnK = AnimationUtils.loadAnimation(this.mContext, R.a.aQH);
        this.lnL = AnimationUtils.loadAnimation(this.mContext, R.a.aQI);
        this.lnM = new Runnable(this) {
            final /* synthetic */ ExdeviceRankListHeaderView lnO;

            {
                this.lnO = r1;
            }

            public final void run() {
                this.lnO.lnI.startAnimation(this.lnO.lnL);
            }
        };
        this.lnK.setAnimationListener(new AnimationListener(this) {
            final /* synthetic */ ExdeviceRankListHeaderView lnO;

            {
                this.lnO = r1;
            }

            public final void onAnimationStart(Animation animation) {
                this.lnO.lnI.setVisibility(0);
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                this.lnO.lnL.reset();
                af.f(this.lnO.lnM, 4000);
            }
        });
        this.lnL.setAnimationListener(new AnimationListener(this) {
            final /* synthetic */ ExdeviceRankListHeaderView lnO;

            {
                this.lnO = r1;
            }

            public final void onAnimationStart(Animation animation) {
                this.lnO.lnI.setVisibility(0);
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                this.lnO.lnI.setVisibility(4);
            }
        });
        this.lnK.setFillAfter(true);
        this.lnK.setFillEnabled(true);
        this.lnL.setFillAfter(true);
        this.lnL.setFillAfter(true);
        setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ExdeviceRankListHeaderView lnO;

            {
                this.lnO = r1;
            }

            public final void onClick(View view) {
                if (this.lnO.lnN) {
                    ExdeviceRankListHeaderView.b(this.lnO);
                }
                if (this.lnO.lnJ != null) {
                    this.lnO.lnJ.onClick(this.lnO);
                }
            }
        });
    }
}
