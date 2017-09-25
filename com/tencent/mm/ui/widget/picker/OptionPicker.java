package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.NumberPicker;
import com.tencent.mm.bg.a;
import com.tencent.mm.bm.a.d;
import com.tencent.mm.sdk.platformtools.w;
import java.lang.reflect.Field;

public class OptionPicker extends NumberPicker {
    private int PN;
    private int iO;
    private int jyA;
    String[] jyz;
    private Context mContext;

    public OptionPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init();
    }

    public OptionPicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        init();
    }

    private void init() {
        this.PN = a.fromDPToPix(this.mContext, 120);
        this.jyA = a.fromDPToPix(this.mContext, 20);
        b(this, getResources().getDrawable(d.wzZ));
        setDescendantFocusability(393216);
    }

    private static boolean b(NumberPicker numberPicker, Drawable drawable) {
        Field[] declaredFields = NumberPicker.class.getDeclaredFields();
        int length = declaredFields.length;
        int i = 0;
        while (i < length) {
            Field field = declaredFields[i];
            if (field.getName().equals("mSelectionDivider")) {
                field.setAccessible(true);
                try {
                    field.set(numberPicker, drawable);
                    return true;
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.MMoptionPicker", e, "", new Object[0]);
                }
            } else {
                i++;
            }
        }
        return false;
    }

    public final void h(String[] strArr) {
        if (strArr != null) {
            this.jyz = strArr;
            setDisplayedValues(null);
            setMinValue(0);
            setMaxValue(Math.max(strArr.length - 1, 0));
            setWrapSelectorWheel(false);
            if (strArr.length <= 0) {
                strArr = null;
            }
            super.setDisplayedValues(strArr);
        }
    }

    @Deprecated
    public void setDisplayedValues(String[] strArr) {
        super.setDisplayedValues(strArr);
    }

    protected void onMeasure(int i, int i2) {
        if (MeasureSpec.getMode(i) == Integer.MIN_VALUE || MeasureSpec.getMode(i) == 1073741824) {
            this.iO = MeasureSpec.getSize(i);
        }
        super.onMeasure(MeasureSpec.makeMeasureSpec(0, 0), i2);
        if (getMeasuredWidth() > this.PN || (this.iO > 0 && this.PN > this.iO)) {
            int measuredWidth = getMeasuredWidth() + (this.jyA * 2);
            if (this.iO > 0 && this.iO <= measuredWidth) {
                measuredWidth = this.iO;
            }
            setMeasuredDimension(measuredWidth, getMeasuredHeight());
            return;
        }
        setMeasuredDimension(this.PN, getMeasuredHeight());
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }
}
