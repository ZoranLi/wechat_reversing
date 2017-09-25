package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.a.f;
import com.tencent.mm.plugin.game.d.e;
import com.tencent.mm.plugin.game.model.q;
import com.tencent.mm.plugin.game.model.q.h;
import com.tencent.mm.plugin.game.model.r;
import com.tencent.mm.plugin.game.model.r.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.bg;
import java.util.LinkedList;

public class GameMessageListUserIconView extends LinearLayout {
    r mCO;
    private f<String, Bitmap> mCP;
    Context mContext;

    public GameMessageListUserIconView(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    public GameMessageListUserIconView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init();
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        init();
    }

    private void init() {
        if (this.mCO == null) {
            this.mCO = new r(this.mContext);
        }
    }

    public final void a(q qVar, LinkedList<h> linkedList, f<String, Bitmap> fVar) {
        if (qVar == null || bg.bV(linkedList)) {
            setVisibility(8);
            return;
        }
        this.mCP = fVar;
        setVisibility(0);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.f.aXr);
        int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.f.aWA);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
        layoutParams.rightMargin = dimensionPixelSize2;
        while (getChildCount() < linkedList.size()) {
            View imageView = new ImageView(this.mContext);
            imageView.setLayoutParams(layoutParams);
            imageView.setScaleType(ScaleType.FIT_XY);
            imageView.setOnClickListener(this.mCO);
            addView(imageView);
        }
        for (int i = 0; i < getChildCount(); i++) {
            ImageView imageView2 = (ImageView) getChildAt(i);
            if (i < linkedList.size()) {
                imageView2.setVisibility(0);
                h hVar = (h) linkedList.get(i);
                String str;
                Bitmap bitmap;
                if (bg.mA(hVar.mqN)) {
                    str = hVar.userName;
                    if (bg.mA(str)) {
                        b.a(imageView2, str);
                    } else if (this.mCP.aV(str)) {
                        bitmap = (Bitmap) this.mCP.get(str);
                        if (bitmap == null || bitmap.isRecycled()) {
                            c(imageView2, str);
                        } else {
                            imageView2.setImageBitmap(bitmap);
                        }
                    } else {
                        c(imageView2, str);
                    }
                } else {
                    str = hVar.mqN;
                    if (this.mCP.aV(str)) {
                        bitmap = (Bitmap) this.mCP.get(str);
                        if (bitmap == null || bitmap.isRecycled()) {
                            e(imageView2, str);
                        } else {
                            imageView2.setImageBitmap(bitmap);
                        }
                    } else {
                        e(imageView2, str);
                    }
                }
                if (bg.mA(hVar.mqQ)) {
                    imageView2.setEnabled(false);
                } else {
                    imageView2.setTag(new a(qVar, hVar.mqQ, 6));
                    imageView2.setEnabled(true);
                }
            } else {
                imageView2.setVisibility(8);
            }
        }
    }

    private void e(ImageView imageView, final String str) {
        e.a.a aVar = new e.a.a();
        aVar.hIJ = false;
        e.aCi().a(imageView, str, aVar.aCj(), new e.b(this) {
            final /* synthetic */ GameMessageListUserIconView mDl;

            public final void s(Bitmap bitmap) {
                if (bitmap != null && !bitmap.isRecycled()) {
                    this.mDl.mCP.put(str, bitmap);
                }
            }
        });
    }

    private void c(ImageView imageView, String str) {
        Bitmap g = e.aCi().g(imageView, str);
        if (g != null) {
            this.mCP.put(str, g);
        }
    }
}
