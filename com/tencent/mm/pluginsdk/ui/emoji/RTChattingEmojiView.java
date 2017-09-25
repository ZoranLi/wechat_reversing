package com.tencent.mm.pluginsdk.ui.emoji;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.a.e;
import com.tencent.mm.e.a.ci;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.gif.MMGIFImageView;
import com.tencent.mm.plugin.m.a;
import com.tencent.mm.plugin.m.a.b;
import com.tencent.mm.plugin.m.a.d;
import com.tencent.mm.plugin.m.a.g;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.a.c;
import com.tencent.mm.storage.aj;
import java.lang.ref.WeakReference;

public class RTChattingEmojiView extends FrameLayout {
    private c kPz;
    private int mStatus = -1;
    private TextView rdo;
    private int sRD;
    private int sRE;
    private int sRF;
    private int sRG;
    private int sRH;
    public ChattingEmojiView sRI;
    private ProgressBar sRJ;
    private LayoutParams sRK;
    LayoutParams sRL;

    public RTChattingEmojiView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RTChattingEmojiView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void KC() {
        this.sRD = getContext().getResources().getDimensionPixelSize(a.c.kDz);
        this.sRE = getContext().getResources().getDimensionPixelSize(a.c.laa);
        this.sRG = getContext().getResources().getDimensionPixelSize(a.c.lad);
        this.sRH = getContext().getResources().getDimensionPixelSize(a.c.lac);
        this.sRI = new ChattingEmojiView(getContext());
        this.sRJ = new ProgressBar(getContext());
        this.sRJ.setIndeterminateDrawable(getResources().getDrawable(d.lah));
        this.rdo = new TextView(getContext());
        this.rdo.setText(g.lan);
        this.rdo.setTextColor(getResources().getColor(b.kZY));
        this.sRK = new LayoutParams(-2, -2);
        this.sRL = new LayoutParams(-2, -2);
        this.sRK.gravity = 17;
        addView(this.sRJ, this.sRK);
        addView(this.rdo, this.sRK);
    }

    public final void a(c cVar, long j) {
        a(cVar, j, new aj(""));
    }

    public final void a(c cVar, long j, aj ajVar) {
        w.d("MicroMsg.emoji.RTChattingEmojiView", "setEmojiInfo");
        this.kPz = cVar;
        if (this.kPz.bCU()) {
            xN(2);
            MMGIFImageView mMGIFImageView = this.sRI;
            boolean z = !ajVar.iai;
            int e = ((PluginEmoji) h.j(PluginEmoji.class)).getEmojiMgr().e(cVar);
            int[] f = ((PluginEmoji) h.j(PluginEmoji.class)).getEmojiMgr().f(cVar);
            String name = cVar.getName();
            String valueOf = String.valueOf(j + cVar.getName());
            Drawable cVar2;
            if (bg.mA(valueOf)) {
                cVar2 = new com.tencent.mm.plugin.gif.c(mMGIFImageView.getContext(), false, z, e, f, name);
                cVar2.start();
                mMGIFImageView.setImageDrawable(cVar2);
                return;
            }
            mMGIFImageView.kHX = valueOf;
            com.tencent.mm.plugin.gif.b aCV = com.tencent.mm.plugin.gif.b.aCV();
            Context context = mMGIFImageView.getContext();
            if (TextUtils.isEmpty(name)) {
                cVar2 = null;
            } else {
                if (aCV.mJO.get(valueOf) == null || ((WeakReference) aCV.mJO.get(valueOf)).get() == null) {
                    cVar2 = null;
                } else {
                    cVar2 = (com.tencent.mm.plugin.gif.c) ((WeakReference) aCV.mJO.get(valueOf)).get();
                }
                if (cVar2 == null) {
                    cVar2 = new com.tencent.mm.plugin.gif.c(context, false, z, e, f, name);
                    aCV.mJO.put(valueOf, new WeakReference(cVar2));
                }
            }
            if (z == cVar2.mJX) {
                cVar2.start();
            } else {
                cVar2.kZt = 0;
                cVar2.mJZ = 0;
                cVar2.mJX = true;
                cVar2.start();
            }
            mMGIFImageView.setImageDrawable(cVar2);
        } else if (this.kPz.bNt()) {
            xN(2);
            this.sRI.a(c.bc(getContext(), cVar.getName()), String.valueOf(j));
        } else {
            String eN = this.kPz.eN(this.kPz.field_groupId, this.kPz.EP());
            if (e.aN(eN) > 0) {
                xN(2);
                byte[] c = e.c(eN, 0, 10);
                if (c == null || o.bg(c)) {
                    this.sRI.cs(eN, String.valueOf(j));
                    return;
                } else {
                    this.sRI.a(this.kPz, ((PluginEmoji) h.j(PluginEmoji.class)).getEmojiMgr().g(this.kPz), String.valueOf(j));
                    return;
                }
            }
            if (cVar.field_state == c.uLi) {
                xN(0);
                bGk();
            } else {
                xN(3);
                bGk();
            }
            this.sRI.setImageBitmap(null);
        }
    }

    public final void setImageBitmap(Bitmap bitmap) {
        xN(2);
        if (this.sRI != null && bitmap != null && !bitmap.isRecycled()) {
            bitmap.setDensity(320);
            this.sRI.setImageBitmap(bitmap);
        }
    }

    public boolean performClick() {
        if (this.mStatus == 3) {
            xN(1);
            bGk();
            return true;
        } else if (this.mStatus == 2) {
            return super.performClick();
        } else {
            w.d("MicroMsg.emoji.RTChattingEmojiView", "do nothing when loading");
            return true;
        }
    }

    private void bGk() {
        com.tencent.mm.sdk.b.b ciVar = new ci();
        ciVar.fFN.fFO = this.kPz;
        ciVar.fFN.scene = 0;
        com.tencent.mm.sdk.b.a.urY.m(ciVar);
    }

    private void xN(int i) {
        this.mStatus = i;
        switch (i) {
            case 0:
                this.sRJ.setVisibility(0);
                this.rdo.setVisibility(4);
                this.sRI.setVisibility(4);
                setBackgroundResource(d.bkS);
                return;
            case 1:
                this.sRJ.setVisibility(0);
                this.rdo.setVisibility(4);
                this.sRI.setVisibility(4);
                setBackgroundResource(d.lae);
                return;
            case 2:
                this.sRI.setVisibility(0);
                this.sRJ.setVisibility(4);
                this.rdo.setVisibility(4);
                setBackgroundResource(d.bkS);
                return;
            case 3:
                Drawable drawable = getResources().getDrawable(d.lag);
                drawable.setBounds(0, 0, this.sRF, this.sRF);
                w.d("MicroMsg.emoji.RTChattingEmojiView", "iconSize:%d hashcode:%d", Integer.valueOf(this.sRF), Integer.valueOf(hashCode()));
                this.rdo.setCompoundDrawables(null, drawable, null, null);
                this.rdo.setText(g.lan);
                this.rdo.setVisibility(0);
                this.sRJ.setVisibility(4);
                this.sRI.setVisibility(4);
                setBackgroundResource(d.lae);
                return;
            default:
                return;
        }
    }

    protected void onMeasure(int i, int i2) {
        if (this.mStatus == 0 || this.mStatus == 1 || this.mStatus == 3) {
            int i3;
            if (this.kPz == null || this.kPz.field_height == 0) {
                i3 = this.sRE;
            } else {
                i3 = (int) (((float) this.kPz.field_height) * this.sRI.aCU());
                if (i3 < this.sRE) {
                    i3 = this.sRE;
                }
            }
            if (i3 > this.sRD) {
                i3 = this.sRD;
            }
            this.sRF = this.sRG;
            if (i3 >= this.sRE && i3 < this.sRE + (this.sRG - this.sRH)) {
                this.sRF = this.sRH + (i3 - this.sRE);
            }
            int i4 = this.sRD;
            setMeasuredDimension(i4, i3);
            super.onMeasure(MeasureSpec.makeMeasureSpec(i4, 1073741824), MeasureSpec.makeMeasureSpec(i3, 1073741824));
            xN(this.mStatus);
            return;
        }
        super.onMeasure(i, i2);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }
}
