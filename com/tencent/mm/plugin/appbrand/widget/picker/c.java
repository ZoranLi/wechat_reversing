package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.a.a;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.widget.picker.YADatePicker;
import com.tencent.mm.ui.widget.picker.YADatePicker.d;
import com.tencent.mm.ui.widget.picker.b;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public final class c extends YADatePicker implements i<String> {
    public boolean jyh = true;
    public boolean jyi = true;
    public boolean jyj = true;
    public NumberPicker jyk;
    public NumberPicker jyl;
    public NumberPicker jym;
    private Date jyn;
    private Date jyo;
    private final Calendar jyp;
    private final String[] jyq = new String[12];

    public final /* synthetic */ Object ZF() {
        if (this.jyj) {
            return String.format(Locale.US, "%04d-%02d-%02d", new Object[]{Integer.valueOf(getYear()), Integer.valueOf(getMonth()), Integer.valueOf(getDayOfMonth())});
        } else if (this.jyi) {
            return String.format(Locale.US, "%04d-%02d", new Object[]{Integer.valueOf(getYear()), Integer.valueOf(getMonth())});
        } else {
            return String.format(Locale.US, "%04d", new Object[]{Integer.valueOf(getYear())});
        }
    }

    @a
    public c(Context context) {
        super(new ContextThemeWrapper(context, R.m.foJ));
        for (int i = 0; i < this.jyq.length; i++) {
            this.jyq[i] = (i + 1);
        }
        this.jyp = Calendar.getInstance(Locale.US);
        cbf();
        cbg();
        this.jyk = ((com.tencent.mm.ui.widget.picker.YADatePicker.c) getUIDelegate()).wzz;
        this.jyl = ((com.tencent.mm.ui.widget.picker.YADatePicker.c) getUIDelegate()).wzy;
        this.jym = ((com.tencent.mm.ui.widget.picker.YADatePicker.c) getUIDelegate()).wzx;
        Drawable drawable = getResources().getDrawable(R.g.blX);
        b.a(this.jyk, drawable);
        b.a(this.jyl, drawable);
        b.a(this.jym, drawable);
        b.b(this.jyk);
        b.b(this.jyl);
        b.b(this.jym);
        OnValueChangeListener anonymousClass1 = new OnValueChangeListener(this) {
            final /* synthetic */ c jyr;

            {
                this.jyr = r1;
            }

            public final void onValueChange(NumberPicker numberPicker, int i, int i2) {
                this.jyr.ZC();
            }
        };
        if (this.jyk != null) {
            this.jyk.setOnValueChangedListener(anonymousClass1);
            this.jyk.setMinValue(1900);
        }
        if (this.jyl != null) {
            this.jyl.setOnValueChangedListener(anonymousClass1);
        }
        if (this.jym != null) {
            this.jym.setOnValueChangedListener(anonymousClass1);
        }
        ZC();
        b.d(this.jyk);
        b.d(this.jyl);
        b.d(this.jym);
    }

    private void ZC() {
        int i = 0;
        if (this.jyk != null && this.jyl != null && this.jym != null) {
            boolean z;
            this.jyl.setDisplayedValues(null);
            if (this.jyk.getValue() != this.jyk.getMaxValue() || this.jyo == null) {
                this.jyl.setMaxValue(11);
                z = false;
            } else {
                this.jyl.setMaxValue(this.jyo.getMonth());
                if (this.jyl.getValue() == this.jyl.getMaxValue() && this.jyo != null) {
                    this.jym.setMaxValue(this.jyo.getDate());
                    z = true;
                }
                z = false;
            }
            if (!z) {
                this.jyp.set(this.jyk.getValue(), this.jyl.getValue(), 1);
                this.jym.setMaxValue(this.jyp.getActualMaximum(5));
            }
            if (this.jyk.getValue() != this.jyk.getMinValue() || this.jyn == null) {
                this.jyl.setMinValue(0);
            } else {
                this.jyl.setMinValue(this.jyn.getMonth());
                if (this.jyl.getValue() == this.jyl.getMinValue() && this.jyn != null) {
                    this.jym.setMinValue(this.jyn.getDate());
                    i = 1;
                }
            }
            if (i == 0) {
                this.jym.setMinValue(1);
            }
            this.jyl.setDisplayedValues((String[]) Arrays.copyOfRange(this.jyq, this.jyl.getMinValue(), this.jyl.getMaxValue() + 1));
            this.jyk.setWrapSelectorWheel(true);
            this.jyl.setWrapSelectorWheel(true);
            this.jym.setWrapSelectorWheel(true);
        }
    }

    public final void setMaxDate(long j) {
        super.setMaxDate(j);
        this.jyo = new Date(j);
        if (this.jyk != null) {
            this.jyk.setMaxValue(this.jyo.getYear() + 1900);
        }
    }

    public final void setMinDate(long j) {
        super.setMinDate(j);
        this.jyn = new Date(j);
        if (this.jyk != null) {
            this.jyk.setMinValue(this.jyn.getYear() + 1900);
        }
    }

    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        b.c(this.jyk);
        b.c(this.jyl);
        b.c(this.jym);
    }

    public final View getView() {
        return this;
    }

    public final void a(g gVar) {
        ZC();
    }

    public final void ZD() {
    }

    public final void b(g gVar) {
    }

    public final void ZE() {
    }

    public final void a(int i, int i2, int i3, d dVar) {
        super.a(i, Math.max(i2 - 1, 0), i3, dVar);
        ZC();
    }

    public final int getYear() {
        if (this.jyk != null) {
            return this.jyk.getValue();
        }
        return super.getYear();
    }

    public final int getMonth() {
        int value;
        if (this.jyl != null) {
            value = this.jyl.getValue() + 1;
        } else {
            value = super.getMonth() + 1;
        }
        return Math.max(Math.min(value, 12), 0);
    }

    public final int getDayOfMonth() {
        if (this.jym != null) {
            return this.jym.getValue();
        }
        return super.getDayOfMonth();
    }
}
