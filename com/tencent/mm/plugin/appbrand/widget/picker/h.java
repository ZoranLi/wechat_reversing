package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.a.a;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import android.widget.TimePicker;
import com.tencent.mm.R;
import com.tencent.mm.compatible.loader.c;
import com.tencent.mm.ui.widget.picker.b;
import java.util.Locale;

public final class h extends TimePicker implements i<String> {
    public int iUB = -1;
    public int iUC = -1;
    public int iUD = -1;
    public int iUE = -1;
    public NumberPicker jyL;
    private NumberPicker jyM;

    public final /* synthetic */ Object ZF() {
        return String.format(Locale.US, "%02d:%02d", new Object[]{getCurrentHour(), getCurrentMinute()});
    }

    @a
    public h(Context context) {
        super(new ContextThemeWrapper(context, R.m.foJ));
        setIs24HourView(Boolean.valueOf(true));
        this.jyL = rt("mHourSpinner");
        this.jyM = rt("mMinuteSpinner");
        b.b(this.jyL);
        b.b(this.jyM);
        Drawable drawable = getResources().getDrawable(R.g.blX);
        b.a(this.jyL, drawable);
        b.a(this.jyM, drawable);
        if (this.jyL != null) {
            this.jyL.setOnValueChangedListener(new OnValueChangeListener(this) {
                final /* synthetic */ h jyN;

                {
                    this.jyN = r1;
                }

                public final void onValueChange(NumberPicker numberPicker, int i, int i2) {
                    this.jyN.ZJ();
                }
            });
        }
        if (this.jyM != null && VERSION.SDK_INT >= 21) {
            this.jyM.setOnValueChangedListener(new OnValueChangeListener(this) {
                final /* synthetic */ h jyN;

                {
                    this.jyN = r1;
                }

                public final void onValueChange(NumberPicker numberPicker, int i, int i2) {
                }
            });
        }
        b.d(this.jyL);
        b.d(this.jyM);
    }

    public final void ZJ() {
        if (j.jc(this.iUB) && j.jb(this.iUC) && this.jyL != null && this.jyM != null) {
            if (this.jyL.getValue() == this.iUB) {
                this.jyM.setMinValue(this.iUC);
            } else {
                this.jyM.setMinValue(0);
            }
        }
        if (j.jc(this.iUD) && this.jyL != null && this.jyM != null) {
            if (this.jyL.getValue() == this.iUD) {
                this.jyM.setMaxValue(this.iUE);
            } else {
                this.jyM.setMaxValue(59);
            }
        }
    }

    public final void setCurrentMinute(Integer num) {
        super.setCurrentMinute(Integer.valueOf(num == null ? 0 : num.intValue()));
        ZJ();
    }

    public final void setCurrentHour(Integer num) {
        super.setCurrentHour(Integer.valueOf(num == null ? 0 : num.intValue()));
        ZJ();
    }

    private NumberPicker rt(String str) {
        if (VERSION.SDK_INT >= 21) {
            return rv(str);
        }
        return ru(str);
    }

    private NumberPicker ru(String str) {
        try {
            return (NumberPicker) new c(this, str, null).get();
        } catch (Exception e) {
            return null;
        }
    }

    private NumberPicker rv(String str) {
        try {
            Object obj = new c(this, "mDelegate", null).get();
            if (obj != null) {
                return (NumberPicker) new c(obj, str, null).get();
            }
        } catch (Exception e) {
        }
        return null;
    }

    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        b.c(this.jyL);
        b.c(this.jyM);
    }

    public final View getView() {
        return this;
    }

    public final void a(g gVar) {
    }

    public final void ZD() {
    }

    public final void b(g gVar) {
    }

    public final void ZE() {
    }
}
