package com.tencent.mm.ui.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.Context;
import android.os.Build.VERSION;
import android.provider.Settings.System;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.NumberPicker;
import com.tencent.mm.s.a.k;
import com.tencent.mm.sdk.platformtools.w;

public final class f extends DatePickerDialog {
    private boolean wvg;
    private long wvh;
    private int wvi;

    class a {
        final /* synthetic */ f wvj;

        a(f fVar) {
            this.wvj = fVar;
        }

        @TargetApi(11)
        public final NumberPicker n(ViewGroup viewGroup) {
            if (viewGroup != null) {
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    NumberPicker numberPicker;
                    View childAt = viewGroup.getChildAt(i);
                    if (childAt instanceof NumberPicker) {
                        numberPicker = (NumberPicker) childAt;
                        if (numberPicker.getMaxValue() >= 28 && numberPicker.getMaxValue() <= 31) {
                            return numberPicker;
                        }
                    }
                    if (childAt instanceof ViewGroup) {
                        numberPicker = n((ViewGroup) childAt);
                        if (numberPicker != null) {
                            return numberPicker;
                        }
                    }
                }
            }
            return null;
        }
    }

    class b {
        final /* synthetic */ f wvj;

        b(f fVar) {
            this.wvj = fVar;
        }

        public final View d(ViewGroup viewGroup, int i) {
            if (viewGroup != null) {
                int childCount = viewGroup.getChildCount();
                int i2 = 0;
                while (i2 < childCount) {
                    View childAt = viewGroup.getChildAt(i2);
                    Class cls = childAt.getClass();
                    w.d("MicroMsg.MMDatePickerDialog", "NAME = " + cls.getName());
                    w.d("MicroMsg.MMDatePickerDialog", "SimpleName = " + cls.getSimpleName());
                    if ("NumberPicker".equals(cls.getSimpleName()) && i2 == i) {
                        return childAt;
                    }
                    if (childAt instanceof ViewGroup) {
                        childAt = d((ViewGroup) childAt, i);
                        if (childAt != null) {
                            return childAt;
                        }
                    }
                    i2++;
                }
            }
            return null;
        }
    }

    public f(Context context, OnDateSetListener onDateSetListener, int i, int i2, int i3, long j) {
        super(context, 3, onDateSetListener, i, i2, i3);
        this.wvg = true;
        this.wvg = true;
        this.wvh = j;
        this.wvi = 1;
    }

    public f(Context context, OnDateSetListener onDateSetListener, int i, int i2, int i3, long j, int i4) {
        super(context, 3, onDateSetListener, i, i2, i3);
        this.wvg = true;
        this.wvg = true;
        this.wvh = j;
        this.wvi = i4;
    }

    public f(Context context, OnDateSetListener onDateSetListener, int i, int i2, int i3, long j, String str) {
        super(context, 3, onDateSetListener, i, i2, i3);
        this.wvg = true;
        this.wvg = true;
        this.wvh = j;
        if (str != null) {
            if (str.equals("month")) {
                this.wvi = 2;
                return;
            }
        }
        this.wvi = 1;
    }

    @SuppressLint({"DefaultLocale"})
    public final void show() {
        int i = 1;
        super.show();
        if (this.wvg) {
            View n;
            if (VERSION.SDK_INT >= 11) {
                n = new a(this).n((ViewGroup) getWindow().getDecorView());
                if (n != null && this.wvi > 1) {
                    n.setVisibility(8);
                }
            } else {
                Object string = System.getString(getContext().getContentResolver(), "date_format");
                if (string != null) {
                    string = string.toLowerCase();
                }
                if ("dd/mm/yyyy".equals(string) || "dd-mm-yyyy".equals(string)) {
                    i = 0;
                } else if (!("mm/dd/yyyy".equals(string) || "mm-dd-yyyy".equals(string))) {
                    i = ("yyyy/mm/dd".equals(string) || "yyyy-mm-dd".equals(string)) ? 2 : -1;
                }
                if (i != -1) {
                    n = new b(this).d((ViewGroup) getWindow().getDecorView(), i);
                    if (n != null) {
                        n.setVisibility(8);
                    }
                }
            }
            int year = getDatePicker().getYear();
            i = getDatePicker().getMonth();
            getDatePicker().getDayOfMonth();
            ep(year, i);
        }
        this.wvg = false;
    }

    public final void onDateChanged(DatePicker datePicker, int i, int i2, int i3) {
        super.onDateChanged(datePicker, i, i2, i3);
        ep(i, i2);
    }

    private void ep(int i, int i2) {
        if (this.wvi > 1) {
            setTitle(getContext().getString(k.hfh, new Object[]{Integer.valueOf(i), Integer.valueOf(i2 + 1)}));
        }
    }
}
