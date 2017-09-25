package com.tencent.mm.plugin.game.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;
import java.util.ArrayList;

public class AutoResizeTextView extends TextView {
    private a mGD;

    public AutoResizeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        d(attributeSet);
    }

    public AutoResizeTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        d(attributeSet);
    }

    private void d(AttributeSet attributeSet) {
        a aVar = new a(this);
        if (attributeSet != null) {
            int i = (int) aVar.mGJ;
            float f = aVar.mGL;
            float f2 = (float) i;
            Context context = aVar.kH.getContext();
            Resources system = Resources.getSystem();
            if (context != null) {
                system = context.getResources();
            }
            float applyDimension = TypedValue.applyDimension(0, f2, system.getDisplayMetrics());
            if (applyDimension != aVar.mGJ) {
                aVar.mGJ = applyDimension;
                aVar.aCk();
            }
            if (aVar.mGL != f) {
                aVar.mGL = f;
                aVar.aCk();
            }
        }
        if (!aVar.AK) {
            aVar.AK = true;
            aVar.kH.addTextChangedListener(aVar.acO);
            aVar.aCk();
        }
        if (aVar.mListeners == null) {
            aVar.mListeners = new ArrayList();
        }
        aVar.mListeners.add(this);
        this.mGD = aVar;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.mGD != null) {
            this.mGD.aCk();
        }
    }

    public void setTextSize(int i, float f) {
        super.setTextSize(i, f);
        if (this.mGD != null) {
            a aVar = this.mGD;
            if (!aVar.mGM) {
                Context context = aVar.kH.getContext();
                Resources system = Resources.getSystem();
                if (context != null) {
                    system = context.getResources();
                }
                aVar.V(TypedValue.applyDimension(i, f, system.getDisplayMetrics()));
            }
        }
    }

    public void setLines(int i) {
        super.setLines(i);
        if (this.mGD != null) {
            this.mGD.nO(i);
        }
    }

    public void setMaxLines(int i) {
        super.setMaxLines(i);
        if (this.mGD != null) {
            this.mGD.nO(i);
        }
    }
}
