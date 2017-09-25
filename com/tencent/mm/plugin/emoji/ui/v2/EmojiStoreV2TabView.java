package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMTabView;

public class EmojiStoreV2TabView extends RelativeLayout {
    private int kZf;
    private int kZg = 0;
    private Bitmap kZh;
    private LinearLayout kZi;
    private ImageView kZj;
    private MMTabView kZk;
    private MMTabView kZl;
    a kZm;
    protected OnClickListener kZn = new OnClickListener(this) {
        final /* synthetic */ EmojiStoreV2TabView kZo;

        {
            this.kZo = r1;
        }

        public final void onClick(View view) {
            int intValue = ((Integer) view.getTag()).intValue();
            if (this.kZo.kZm != null) {
                this.kZo.kZm.lK(intValue);
            }
        }
    };
    private Matrix mMatrix = new Matrix();

    public interface a {
        void lK(int i);
    }

    public EmojiStoreV2TabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public EmojiStoreV2TabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.kZf = (i3 - i) / 2;
        int i5 = this.kZf;
        if (this.kZh == null || this.kZh.getWidth() != i5) {
            String str = "MicroMsg.emoji.EmojiStoreV2TabView";
            String str2 = "sharp width changed, from %d to %d";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(this.kZh == null ? -1 : this.kZh.getWidth());
            objArr[1] = Integer.valueOf(i5);
            w.w(str, str2, objArr);
            this.kZh = Bitmap.createBitmap(i5, com.tencent.mm.bg.a.fromDPToPix(getContext(), 3), Config.ARGB_8888);
            new Canvas(this.kZh).drawColor(getResources().getColor(R.e.aWu));
            i(this.kZg, 0.0f);
            this.kZj.setImageBitmap(this.kZh);
        }
        lJ(this.kZg);
    }

    private void init() {
        this.kZi = new LinearLayout(getContext());
        this.kZi.setBackgroundResource(R.e.white);
        this.kZi.setId(R.h.bLB);
        this.kZi.setOrientation(0);
        addView(this.kZi, new LayoutParams(-1, -2));
        this.kZj = new ImageView(getContext());
        this.kZj.setImageMatrix(this.mMatrix);
        this.kZj.setScaleType(ScaleType.MATRIX);
        this.kZj.setId(R.h.bLC);
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, com.tencent.mm.bg.a.fromDPToPix(getContext(), 3));
        layoutParams.addRule(8, R.h.bLB);
        addView(this.kZj, layoutParams);
        this.kZk = lI(0);
        this.kZk.setText(R.l.edp);
        layoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(R.f.bbj));
        layoutParams.weight = 1.0f;
        this.kZi.addView(this.kZk, layoutParams);
        this.kZl = lI(1);
        this.kZl.setText(R.l.edt);
        layoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(R.f.bbj));
        layoutParams.weight = 1.0f;
        this.kZi.addView(this.kZl, layoutParams);
    }

    private MMTabView lI(int i) {
        MMTabView mMTabView = new MMTabView(getContext(), i);
        mMTabView.setTag(Integer.valueOf(i));
        mMTabView.setOnClickListener(this.kZn);
        return mMTabView;
    }

    public final void i(int i, float f) {
        this.mMatrix.setTranslate(((float) this.kZf) * (((float) i) + f), 0.0f);
        this.kZj.setImageMatrix(this.mMatrix);
    }

    public final void lJ(int i) {
        this.kZg = i;
        this.kZk.setTextColor(this.kZg == 0 ? getResources().getColorStateList(R.e.aWu) : getResources().getColorStateList(R.e.aUw));
        this.kZl.setTextColor(this.kZg == 1 ? getResources().getColorStateList(R.e.aWu) : getResources().getColorStateList(R.e.aUw));
    }

    public final void dG(boolean z) {
        if (this.kZl != null) {
            this.kZl.kz(z);
        }
    }
}
