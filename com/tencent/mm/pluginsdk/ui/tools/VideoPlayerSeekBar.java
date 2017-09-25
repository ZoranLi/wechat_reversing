package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar;
import com.tencent.mm.plugin.y.a.a;
import com.tencent.mm.plugin.y.a.b;
import com.tencent.mm.pluginsdk.ui.g;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.w;

public class VideoPlayerSeekBar extends AdVideoPlayerLoadingBar implements g {
    public boolean fKD = false;
    private PInt sWE = new PInt();
    private int sWF = -1;
    private int sWG = -1;
    private int sWH = -1;

    static /* synthetic */ int a(VideoPlayerSeekBar videoPlayerSeekBar, int i, PInt pInt) {
        int bGE = ((LayoutParams) videoPlayerSeekBar.puO.getLayoutParams()).leftMargin - videoPlayerSeekBar.bGE();
        pInt.value = (int) (((((double) (i - bGE)) * 1.0d) / ((double) videoPlayerSeekBar.bco())) * ((double) videoPlayerSeekBar.puT));
        if (pInt.value <= 0) {
            pInt.value = 0;
            return i - bGE > bGE ? i - bGE : bGE;
        } else if (pInt.value < videoPlayerSeekBar.puT) {
            return i - bGE;
        } else {
            pInt.value = videoPlayerSeekBar.puT;
            return videoPlayerSeekBar.bco() - (((videoPlayerSeekBar.bcq() - videoPlayerSeekBar.bGE()) - videoPlayerSeekBar.bGF()) / 2);
        }
    }

    public VideoPlayerSeekBar(Context context) {
        super(context);
    }

    public VideoPlayerSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public VideoPlayerSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void init() {
        this.ipu = View.inflate(getContext(), getLayoutId(), this);
        this.puN = (ImageView) this.ipu.findViewById(a.ooL);
        this.puO = (ImageView) this.ipu.findViewById(a.ooK);
        this.puP = (ImageView) this.ipu.findViewById(a.ooM);
        this.puQ = (ImageView) this.ipu.findViewById(a.crK);
        this.puR = (TextView) this.ipu.findViewById(a.ooI);
        this.puS = (TextView) this.ipu.findViewById(a.ooJ);
        this.puP.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ VideoPlayerSeekBar sWI;

            {
                this.sWI = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    w.i("MicroMsg.VideoPlayerSeekBar", "ontouch down");
                    this.sWI.jGP = false;
                    this.sWI.puW = motionEvent.getX();
                    if (this.sWI.puM != null) {
                        this.sWI.puM.Uh();
                    }
                } else if (motionEvent.getAction() == 2) {
                    float x = motionEvent.getX();
                    LayoutParams layoutParams = (LayoutParams) this.sWI.puP.getLayoutParams();
                    int a = VideoPlayerSeekBar.a(this.sWI, ((int) (x - this.sWI.puW)) + layoutParams.leftMargin, this.sWI.sWE);
                    layoutParams.leftMargin = a;
                    this.sWI.puP.setLayoutParams(layoutParams);
                    int i = this.sWI.sWE.value;
                    if (this.sWI.puT > 0) {
                        layoutParams = (LayoutParams) this.sWI.puN.getLayoutParams();
                        layoutParams.width = a;
                        this.sWI.puN.setLayoutParams(layoutParams);
                    }
                    this.sWI.puR.setText(AdVideoPlayerLoadingBar.hQ(i / 60) + ":" + AdVideoPlayerLoadingBar.hQ(i % 60));
                    this.sWI.jGP = true;
                } else {
                    int m = this.sWI.kC;
                    if (this.sWI.jGP) {
                        m = this.sWI.kC = this.sWI.sWE.value;
                    }
                    if (this.sWI.puM != null) {
                        w.i("MicroMsg.VideoPlayerSeekBar", "current time : " + m);
                        this.sWI.puM.hR(m);
                    }
                    this.sWI.jGP = false;
                }
                return true;
            }
        });
    }

    protected final int bcq() {
        if (this.sWF == -1) {
            this.sWF = this.puP.getWidth();
        }
        return this.sWF;
    }

    private int bGE() {
        if (this.sWG == -1) {
            this.sWG = this.puP.getPaddingLeft();
        }
        return this.sWG;
    }

    private int bGF() {
        if (this.sWH == -1) {
            this.sWH = this.puP.getPaddingRight();
        }
        return this.sWH;
    }

    public int getLayoutId() {
        return b.cLX;
    }

    public final void seek(int i) {
        w.d("MicroMsg.VideoPlayerSeekBar", "seek position : " + i);
        if (i < 0) {
            i = 0;
        }
        if (i >= this.puT) {
            i = this.puT;
        }
        if (this.kC != i) {
            this.kC = i;
            bcr();
        }
    }

    public final void sH(int i) {
        this.puT = i;
        this.kC = 0;
        this.puS.setText(AdVideoPlayerLoadingBar.hQ(this.puT / 60) + ":" + AdVideoPlayerLoadingBar.hQ(this.puT % 60));
        bcr();
    }

    public final void bcr() {
        if (this.puT != 0 && !this.jGP && this.puP != null && bco() != 0) {
            this.puR.setText(AdVideoPlayerLoadingBar.hQ(this.kC / 60) + ":" + AdVideoPlayerLoadingBar.hQ(this.kC % 60));
            LayoutParams layoutParams = (LayoutParams) this.puP.getLayoutParams();
            int bco = bco();
            int i = this.kC;
            if (i <= 0) {
                this.puO.getLayoutParams();
                i = 0;
            } else {
                i = i >= this.puT ? bco - (((bcq() - bGE()) - bGF()) / 2) : (int) (((((double) i) * 1.0d) / ((double) this.puT)) * ((double) bco));
            }
            layoutParams.leftMargin = i;
            this.puP.setLayoutParams(layoutParams);
            layoutParams = (LayoutParams) this.puN.getLayoutParams();
            layoutParams.width = (int) (((double) bco) * ((((double) this.kC) * 1.0d) / ((double) this.puT)));
            this.puN.setLayoutParams(layoutParams);
            requestLayout();
        }
    }

    public final void f(OnClickListener onClickListener) {
        if (this.puQ != null) {
            this.puQ.setOnClickListener(onClickListener);
        }
    }

    public void bX(boolean z) {
        this.fKD = z;
        super.bX(z);
    }

    public final void tt(int i) {
        seek(i);
    }

    public final void jk(boolean z) {
        bX(z);
    }
}
