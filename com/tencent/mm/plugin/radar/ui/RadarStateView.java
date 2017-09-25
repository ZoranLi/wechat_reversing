package com.tencent.mm.plugin.radar.ui;

import android.content.Context;
import android.os.Message;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mm.R;
import com.tencent.mm.bg.a;
import com.tencent.mm.plugin.radar.a.c.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;

public class RadarStateView extends RelativeLayout {
    public d oHp = d.Stranger;
    boolean oIl = false;
    private Animation oIm = null;
    private Animation oIn = null;
    boolean oIs = true;
    ae oIt = new ae(this) {
        final /* synthetic */ RadarStateView oIv;

        {
            this.oIv = r1;
        }

        public final void handleMessage(Message message) {
            this.oIv.aVO();
            this.oIv.aVP();
        }
    };
    private ImageView oIu = null;

    public RadarStateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RadarStateView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    final void aVO() {
        w.d("MicroMsg.RadarStateView", " state : " + this.oHp);
        if (this.oIs) {
            switch (this.oHp) {
                case Stranger:
                    setVisibility(8);
                    return;
                case Verifying:
                    setBackgroundResource(R.k.dyX);
                    this.oIu.setImageResource(R.k.dzb);
                    setVisibility(0);
                    return;
                case Added:
                    setBackgroundResource(R.k.dyY);
                    this.oIu.setImageResource(R.k.dza);
                    setVisibility(0);
                    return;
                case NeedVerify:
                    setBackgroundResource(R.k.dyY);
                    this.oIu.setImageResource(R.k.dyZ);
                    setVisibility(0);
                    return;
                default:
                    return;
            }
        }
        setVisibility(8);
    }

    final void init() {
        if (this.oIu == null) {
            this.oIu = new ImageView(getContext());
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(15);
            layoutParams.setMargins(0, 0, a.fromDPToPix(getContext(), 5), a.fromDPToPix(getContext(), 2));
            this.oIu.setLayoutParams(layoutParams);
            addView(this.oIu);
        }
        if (this.oIm == null) {
            this.oIm = AnimationUtils.loadAnimation(getContext(), R.a.aRw);
            this.oIm.setAnimationListener(new AnimationListener(this) {
                final /* synthetic */ RadarStateView oIv;

                {
                    this.oIv = r1;
                }

                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            });
        }
        if (this.oIn == null) {
            this.oIn = AnimationUtils.loadAnimation(getContext(), R.a.aRv);
            this.oIn.setAnimationListener(new AnimationListener(this) {
                final /* synthetic */ RadarStateView oIv;

                {
                    this.oIv = r1;
                }

                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    this.oIv.oIl = false;
                    this.oIv.setVisibility(8);
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            });
        }
    }

    public final void aVP() {
        if (this.oIs) {
            init();
            aVO();
            this.oIl = true;
            startAnimation(this.oIm);
        }
    }

    public final void aVQ() {
        if (this.oIs) {
            init();
            aVO();
            startAnimation(this.oIn);
        }
    }
}
