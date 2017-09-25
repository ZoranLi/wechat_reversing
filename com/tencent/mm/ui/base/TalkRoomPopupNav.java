package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;

public class TalkRoomPopupNav extends LinearLayout {
    public View lNL;
    public LinearLayout uVo;
    public a vpI;
    public LinearLayout vpJ;
    private LinearLayout vpK;
    private ImageView vpL;
    public ImageView vpM;
    public ScaleAnimation vpN;
    public Animation vpO;
    public int vpP = 0;
    public int vpQ = 0;
    private ScaleAnimation vpR;
    private Animation vpS;
    public AlphaAnimation vpT;
    public AlphaAnimation vpU;

    public interface a {
        void bST();

        void bSU();
    }

    static /* synthetic */ void b(TalkRoomPopupNav talkRoomPopupNav) {
        if (talkRoomPopupNav.vpR == null) {
            talkRoomPopupNav.vpR = new ScaleAnimation(1.0f, 1.0f, (((float) talkRoomPopupNav.vpQ) * 1.0f) / ((float) talkRoomPopupNav.vpP), 1.0f);
            talkRoomPopupNav.vpR.setDuration(300);
            talkRoomPopupNav.vpR.setAnimationListener(new AnimationListener(talkRoomPopupNav) {
                final /* synthetic */ TalkRoomPopupNav vpV;

                {
                    this.vpV = r1;
                }

                public final void onAnimationStart(Animation animation) {
                    this.vpV.vpK.setVisibility(4);
                }

                public final void onAnimationRepeat(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    this.vpV.vpJ.setVisibility(8);
                    this.vpV.uVo.setClickable(true);
                }
            });
        }
        if (talkRoomPopupNav.vpS == null) {
            talkRoomPopupNav.vpS = AnimationUtils.loadAnimation(talkRoomPopupNav.getContext(), R.a.aQY);
            talkRoomPopupNav.vpS.setFillAfter(true);
            talkRoomPopupNav.vpS.setAnimationListener(new AnimationListener(talkRoomPopupNav) {
                final /* synthetic */ TalkRoomPopupNav vpV;

                {
                    this.vpV = r1;
                }

                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationRepeat(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    this.vpV.vpK.setVisibility(4);
                    this.vpV.vpJ.setVisibility(4);
                }
            });
        }
        LayoutParams layoutParams = talkRoomPopupNav.lNL.getLayoutParams();
        layoutParams.height = talkRoomPopupNav.vpP;
        talkRoomPopupNav.lNL.setLayoutParams(layoutParams);
        talkRoomPopupNav.lNL.startAnimation(talkRoomPopupNav.vpR);
        talkRoomPopupNav.vpJ.startAnimation(talkRoomPopupNav.vpS);
        talkRoomPopupNav.uVo.startAnimation(AnimationUtils.loadAnimation(talkRoomPopupNav.getContext(), R.a.aQX));
        talkRoomPopupNav.uVo.setVisibility(0);
    }

    @TargetApi(11)
    public TalkRoomPopupNav(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        KC();
    }

    public TalkRoomPopupNav(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        KC();
    }

    public final void Tc(String str) {
        ((TextView) findViewById(R.h.cKl)).setText(str);
    }

    public final void Ap(int i) {
        if (this.lNL != null) {
            this.lNL.setBackgroundResource(i);
        }
    }

    public final void Aq(int i) {
        if (this.vpL != null) {
            this.vpL.setImageResource(i);
        }
    }

    public final void Ar(int i) {
        if (i < 0) {
            if (this.vpM != null) {
                this.vpM.setVisibility(8);
            }
        } else if (this.vpM != null) {
            this.vpM.setImageResource(i);
            this.vpM.setVisibility(0);
        }
    }

    private void KC() {
        inflate(getContext(), R.i.cHk, this);
        this.uVo = (LinearLayout) findViewById(R.h.cmu);
        this.vpJ = (LinearLayout) findViewById(R.h.bJt);
        this.vpK = (LinearLayout) findViewById(R.h.bJo);
        this.lNL = findViewById(R.h.cmq);
        this.vpL = (ImageView) findViewById(R.h.cHl);
        this.vpM = (ImageView) findViewById(R.h.cHm);
        this.vpM.setVisibility(8);
        this.uVo.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ TalkRoomPopupNav vpV;

            {
                this.vpV = r1;
            }

            public final void onClick(View view) {
                if (this.vpV.vpI != null) {
                    this.vpV.vpI.bST();
                }
            }
        });
        ((Button) findViewById(R.h.buY)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ TalkRoomPopupNav vpV;

            {
                this.vpV = r1;
            }

            public final void onClick(View view) {
                TalkRoomPopupNav.b(this.vpV);
            }
        });
        ((Button) findViewById(R.h.buZ)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ TalkRoomPopupNav vpV;

            {
                this.vpV = r1;
            }

            public final void onClick(View view) {
                TalkRoomPopupNav.b(this.vpV);
                if (this.vpV.vpI != null) {
                    this.vpV.vpI.bSU();
                }
            }
        });
        this.vpP = this.lNL.getLayoutParams().height;
        this.vpQ = this.vpJ.getLayoutParams().height;
    }

    public final void stop() {
        if (this.vpT != null && this.vpU != null) {
            com.tencent.mm.sdk.platformtools.BackwardSupportUtil.a.c(this.vpM, this.vpT);
            com.tencent.mm.sdk.platformtools.BackwardSupportUtil.a.c(this.vpM, this.vpU);
            this.vpM.clearAnimation();
            this.vpT = null;
            this.vpU = null;
        }
    }
}
