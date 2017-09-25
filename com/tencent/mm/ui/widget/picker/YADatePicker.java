package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View.BaseSavedState;
import android.view.accessibility.AccessibilityEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.CalendarView;
import android.widget.CalendarView.OnDateChangeListener;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import android.widget.TextView;
import com.tencent.mm.bm.a.e;
import com.tencent.mm.bm.a.f;
import com.tencent.mm.bm.a.j;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.am;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;

public class YADatePicker extends FrameLayout {
    private static final String DU = YADatePicker.class.getSimpleName();
    public final b wzs;

    private static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }
        };
        private final int jTi;
        private final int jTj;
        private final int jTk;

        private SavedState(Parcelable parcelable, int i, int i2, int i3) {
            super(parcelable);
            this.jTi = i;
            this.jTj = i2;
            this.jTk = i3;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.jTi = parcel.readInt();
            this.jTj = parcel.readInt();
            this.jTk = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.jTi);
            parcel.writeInt(this.jTj);
            parcel.writeInt(this.jTk);
        }
    }

    public interface b {
        void a(int i, int i2, int i3, d dVar);

        Parcelable b(Parcelable parcelable);

        boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent);

        int getDayOfMonth();

        int getMonth();

        int getYear();

        boolean isEnabled();

        void onConfigurationChanged(Configuration configuration);

        void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent);

        void onRestoreInstanceState(Parcelable parcelable);

        void setCalendarViewShown(boolean z);

        void setEnabled(boolean z);

        void setFirstDayOfWeek(int i);

        void setMaxDate(long j);

        void setMinDate(long j);

        void setSpinnersShown(boolean z);
    }

    public interface d {
    }

    static abstract class a implements b {
        protected Context mContext;
        protected YADatePicker wzt;
        protected Locale wzu;
        protected d wzv;

        public a(YADatePicker yADatePicker, Context context) {
            this.wzt = yADatePicker;
            this.mContext = context;
            e(Locale.getDefault());
        }

        protected void e(Locale locale) {
            if (!locale.equals(this.wzu)) {
                this.wzu = locale;
            }
        }
    }

    public static class c extends a {
        public Calendar jyp;
        private String[] jyq;
        private final EditText wzA;
        private final EditText wzB;
        private final EditText wzC;
        private final CalendarView wzD;
        private final DateFormat wzE = new SimpleDateFormat("MM/dd/yyyy");
        private int wzF;
        private Calendar wzG;
        private Calendar wzH;
        public Calendar wzI;
        private boolean wzJ = true;
        private final LinearLayout wzw;
        public final NumberPicker wzx;
        public final NumberPicker wzy;
        public final NumberPicker wzz;

        c(YADatePicker yADatePicker, Context context, AttributeSet attributeSet, int i, int i2) {
            super(yADatePicker, context);
            this.wzt = yADatePicker;
            this.mContext = context;
            e(Locale.getDefault());
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.fpq, i, 0);
            boolean z = obtainStyledAttributes.getBoolean(j.wAS, true);
            boolean z2 = obtainStyledAttributes.getBoolean(j.wAM, true);
            int i3 = obtainStyledAttributes.getInt(j.wAT, 1900);
            int i4 = obtainStyledAttributes.getInt(j.wAN, 2100);
            String string = obtainStyledAttributes.getString(j.wAR);
            String string2 = obtainStyledAttributes.getString(j.wAQ);
            int resourceId = obtainStyledAttributes.getResourceId(j.wAP, f.wAi);
            obtainStyledAttributes.recycle();
            ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(resourceId, this.wzt, true);
            OnValueChangeListener anonymousClass1 = new OnValueChangeListener(this) {
                final /* synthetic */ c wzK;

                {
                    this.wzK = r1;
                }

                public final void onValueChange(NumberPicker numberPicker, int i, int i2) {
                    this.wzK.cbn();
                    this.wzK.jyp.setTimeInMillis(this.wzK.wzI.getTimeInMillis());
                    if (numberPicker == this.wzK.wzx) {
                        int actualMaximum = this.wzK.jyp.getActualMaximum(5);
                        if (i == actualMaximum && i2 == 1) {
                            this.wzK.jyp.add(5, 1);
                        } else if (i == 1 && i2 == actualMaximum) {
                            this.wzK.jyp.add(5, -1);
                        } else {
                            this.wzK.jyp.add(5, i2 - i);
                        }
                    } else if (numberPicker == this.wzK.wzy) {
                        if (i == 11 && i2 == 0) {
                            this.wzK.jyp.add(2, 1);
                        } else if (i == 0 && i2 == 11) {
                            this.wzK.jyp.add(2, -1);
                        } else {
                            this.wzK.jyp.add(2, i2 - i);
                        }
                    } else if (numberPicker == this.wzK.wzz) {
                        this.wzK.jyp.set(1, i2);
                    } else {
                        throw new IllegalArgumentException();
                    }
                    this.wzK.aa(this.wzK.jyp.get(1), this.wzK.jyp.get(2), this.wzK.jyp.get(5));
                    this.wzK.cbk();
                    this.wzK.cbl();
                    this.wzK.cbm();
                }
            };
            this.wzw = (LinearLayout) this.wzt.findViewById(e.wAh);
            this.wzD = (CalendarView) this.wzt.findViewById(e.wAe);
            this.wzD.setOnDateChangeListener(new OnDateChangeListener(this) {
                final /* synthetic */ c wzK;

                {
                    this.wzK = r1;
                }

                public final void onSelectedDayChange(CalendarView calendarView, int i, int i2, int i3) {
                    this.wzK.aa(i, i2, i3);
                    this.wzK.cbk();
                    this.wzK.cbm();
                }
            });
            this.wzx = (NumberPicker) this.wzt.findViewById(e.jXa);
            this.wzx.setFormatter(new c());
            this.wzx.setOnLongPressUpdateInterval(100);
            this.wzx.setOnValueChangedListener(anonymousClass1);
            this.wzA = b.a(this.wzx);
            this.wzy = (NumberPicker) this.wzt.findViewById(e.month);
            this.wzy.setMinValue(0);
            this.wzy.setMaxValue(this.wzF - 1);
            this.wzy.setDisplayedValues(this.jyq);
            this.wzy.setOnLongPressUpdateInterval(200);
            this.wzy.setOnValueChangedListener(anonymousClass1);
            this.wzB = b.a(this.wzy);
            this.wzz = (NumberPicker) this.wzt.findViewById(e.year);
            this.wzz.setOnLongPressUpdateInterval(100);
            this.wzz.setOnValueChangedListener(anonymousClass1);
            this.wzC = b.a(this.wzz);
            if (z || z2) {
                setSpinnersShown(z);
                setCalendarViewShown(z2);
            } else {
                setSpinnersShown(true);
            }
            this.jyp.clear();
            if (TextUtils.isEmpty(string) || !a(string, this.jyp)) {
                this.jyp.set(i3, 0, 1);
            }
            setMinDate(this.jyp.getTimeInMillis());
            this.jyp.clear();
            if (TextUtils.isEmpty(string2) || !a(string2, this.jyp)) {
                this.jyp.set(i4, 11, 31);
            }
            setMaxDate(this.jyp.getTimeInMillis());
            this.wzI.setTimeInMillis(System.currentTimeMillis());
            a(this.wzI.get(1), this.wzI.get(2), this.wzI.get(5), null);
            cbj();
            if (this.wzt.getImportantForAccessibility() == 0) {
                this.wzt.setImportantForAccessibility(1);
            }
        }

        public final void a(int i, int i2, int i3, d dVar) {
            aa(i, i2, i3);
            cbk();
            cbl();
            this.wzv = dVar;
        }

        public final int getYear() {
            return this.wzI.get(1);
        }

        public final int getMonth() {
            return this.wzI.get(2);
        }

        public final int getDayOfMonth() {
            return this.wzI.get(5);
        }

        public final void setFirstDayOfWeek(int i) {
            this.wzD.setFirstDayOfWeek(i);
        }

        public final void setMinDate(long j) {
            this.jyp.setTimeInMillis(j);
            if (this.jyp.get(1) != this.wzG.get(1) || this.jyp.get(6) == this.wzG.get(6)) {
                this.wzG.setTimeInMillis(j);
                this.wzD.setMinDate(j);
                if (this.wzI.before(this.wzG)) {
                    this.wzI.setTimeInMillis(this.wzG.getTimeInMillis());
                    cbl();
                }
                cbk();
            }
        }

        public final void setMaxDate(long j) {
            this.jyp.setTimeInMillis(j);
            if (this.jyp.get(1) != this.wzH.get(1) || this.jyp.get(6) == this.wzH.get(6)) {
                this.wzH.setTimeInMillis(j);
                this.wzD.setMaxDate(j);
                if (this.wzI.after(this.wzH)) {
                    this.wzI.setTimeInMillis(this.wzH.getTimeInMillis());
                    cbl();
                }
                cbk();
            }
        }

        public final void setEnabled(boolean z) {
            this.wzx.setEnabled(z);
            this.wzy.setEnabled(z);
            this.wzz.setEnabled(z);
            this.wzD.setEnabled(z);
            this.wzJ = z;
        }

        public final boolean isEnabled() {
            return this.wzJ;
        }

        public final void setCalendarViewShown(boolean z) {
            this.wzD.setVisibility(z ? 0 : 8);
        }

        public final void setSpinnersShown(boolean z) {
            this.wzw.setVisibility(z ? 0 : 8);
        }

        public final void onConfigurationChanged(Configuration configuration) {
            e(configuration.locale);
        }

        public final Parcelable b(Parcelable parcelable) {
            return new SavedState(parcelable, getYear(), getMonth(), getDayOfMonth());
        }

        public final void onRestoreInstanceState(Parcelable parcelable) {
            SavedState savedState = (SavedState) parcelable;
            aa(savedState.jTi, savedState.jTj, savedState.jTk);
            cbk();
            cbl();
        }

        public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            onPopulateAccessibilityEvent(accessibilityEvent);
            return true;
        }

        public final void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            accessibilityEvent.getText().add(DateUtils.formatDateTime(this.mContext, this.wzI.getTimeInMillis(), 20));
        }

        protected final void e(Locale locale) {
            super.e(locale);
            this.jyp = a(this.jyp, locale);
            this.wzG = a(this.wzG, locale);
            this.wzH = a(this.wzH, locale);
            this.wzI = a(this.wzI, locale);
            this.wzF = this.jyp.getActualMaximum(2) + 1;
            this.jyq = new DateFormatSymbols().getShortMonths();
            if (cbi()) {
                this.jyq = new String[this.wzF];
                for (int i = 0; i < this.wzF; i++) {
                    this.jyq[i] = String.format("%d", new Object[]{Integer.valueOf(i + 1)});
                }
            }
        }

        private boolean cbi() {
            return Character.isDigit(this.jyq[0].charAt(0));
        }

        private static Calendar a(Calendar calendar, Locale locale) {
            if (calendar == null) {
                return Calendar.getInstance(locale);
            }
            long timeInMillis = calendar.getTimeInMillis();
            Calendar instance = Calendar.getInstance(locale);
            instance.setTimeInMillis(timeInMillis);
            return instance;
        }

        private void cbj() {
            char[] cArr;
            this.wzw.removeAllViews();
            if (VERSION.SDK_INT < 17 || this.wzt.getLayoutDirection() == 0) {
                cArr = new char[]{'y', 'M', 'd'};
            } else {
                cArr = android.text.format.DateFormat.getDateFormatOrder(this.wzt.getContext());
            }
            int length = cArr.length;
            for (int i = 0; i < length; i++) {
                switch (cArr[i]) {
                    case am.CTRL_BYTE /*77*/:
                        this.wzw.addView(this.wzy);
                        a(this.wzy, length, i);
                        break;
                    case 'd':
                        this.wzw.addView(this.wzx);
                        a(this.wzx, length, i);
                        break;
                    case 'y':
                        this.wzw.addView(this.wzz);
                        a(this.wzz, length, i);
                        break;
                    default:
                        throw new IllegalArgumentException(Arrays.toString(cArr));
                }
            }
        }

        private boolean a(String str, Calendar calendar) {
            try {
                calendar.setTime(this.wzE.parse(str));
                return true;
            } catch (ParseException e) {
                YADatePicker.DU;
                new StringBuilder("Date: ").append(str).append(" not in format: MM/dd/yyyy");
                return false;
            }
        }

        public final void aa(int i, int i2, int i3) {
            this.wzI.set(i, i2, i3);
            if (this.wzI.before(this.wzG)) {
                this.wzI.setTimeInMillis(this.wzG.getTimeInMillis());
            } else if (this.wzI.after(this.wzH)) {
                this.wzI.setTimeInMillis(this.wzH.getTimeInMillis());
            }
        }

        public final void cbk() {
            if (this.wzI.equals(this.wzG)) {
                this.wzx.setMinValue(this.wzI.get(5));
                this.wzx.setMaxValue(this.wzI.getActualMaximum(5));
                this.wzx.setWrapSelectorWheel(false);
                this.wzy.setDisplayedValues(null);
                this.wzy.setMinValue(this.wzI.get(2));
                this.wzy.setMaxValue(this.wzI.getActualMaximum(2));
                this.wzy.setWrapSelectorWheel(false);
            } else if (this.wzI.equals(this.wzH)) {
                this.wzx.setMinValue(this.wzI.getActualMinimum(5));
                this.wzx.setMaxValue(this.wzI.get(5));
                this.wzx.setWrapSelectorWheel(false);
                this.wzy.setDisplayedValues(null);
                this.wzy.setMinValue(this.wzI.getActualMinimum(2));
                this.wzy.setMaxValue(this.wzI.get(2));
                this.wzy.setWrapSelectorWheel(false);
            } else {
                this.wzx.setMinValue(1);
                this.wzx.setMaxValue(this.wzI.getActualMaximum(5));
                this.wzx.setWrapSelectorWheel(true);
                this.wzy.setDisplayedValues(null);
                this.wzy.setMinValue(0);
                this.wzy.setMaxValue(11);
                this.wzy.setWrapSelectorWheel(true);
            }
            this.wzy.setDisplayedValues((String[]) Arrays.copyOfRange(this.jyq, this.wzy.getMinValue(), this.wzy.getMaxValue() + 1));
            this.wzz.setMinValue(this.wzG.get(1));
            this.wzz.setMaxValue(this.wzH.get(1));
            this.wzz.setWrapSelectorWheel(false);
            this.wzz.setValue(this.wzI.get(1));
            this.wzy.setValue(this.wzI.get(2));
            this.wzx.setValue(this.wzI.get(5));
            if (cbi()) {
                this.wzB.setRawInputType(2);
            }
        }

        public final void cbl() {
            this.wzD.setDate(this.wzI.getTimeInMillis(), false, false);
        }

        public final void cbm() {
            this.wzt.sendAccessibilityEvent(4);
            if (this.wzv != null) {
                getYear();
                getMonth();
                getDayOfMonth();
            }
        }

        private static void a(NumberPicker numberPicker, int i, int i2) {
            int i3;
            if (i2 < i - 1) {
                i3 = 5;
            } else {
                i3 = 6;
            }
            TextView a = b.a(numberPicker);
            if (a != null) {
                a.setImeOptions(i3);
            }
        }

        public final void cbn() {
            InputMethodManager inputMethodManager = (InputMethodManager) this.wzt.getContext().getSystemService("input_method");
            if (inputMethodManager == null) {
                return;
            }
            if (inputMethodManager.isActive(this.wzC)) {
                this.wzC.clearFocus();
                inputMethodManager.hideSoftInputFromWindow(this.wzt.getWindowToken(), 0);
            } else if (inputMethodManager.isActive(this.wzB)) {
                this.wzB.clearFocus();
                inputMethodManager.hideSoftInputFromWindow(this.wzt.getWindowToken(), 0);
            } else if (inputMethodManager.isActive(this.wzA)) {
                this.wzA.clearFocus();
                inputMethodManager.hideSoftInputFromWindow(this.wzt.getWindowToken(), 0);
            }
        }
    }

    public YADatePicker(Context context) {
        this(context, null);
    }

    public YADatePicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, com.tencent.mm.bm.a.a.datePickerStyle);
    }

    public YADatePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.wzs = new c(this, context, attributeSet, i, 0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.fpq, i, 0);
        int i2 = obtainStyledAttributes.getInt(j.wAO, 0);
        obtainStyledAttributes.recycle();
        if (i2 == 0) {
            return;
        }
        if (i2 <= 0 || i2 > 7) {
            throw new IllegalArgumentException("firstDayOfWeek must be between 1 and 7");
        }
        this.wzs.setFirstDayOfWeek(i2);
    }

    @android.support.a.a
    public b getUIDelegate() {
        return this.wzs;
    }

    public void a(int i, int i2, int i3, d dVar) {
        this.wzs.a(i, i2, i3, dVar);
    }

    public int getYear() {
        return this.wzs.getYear();
    }

    public int getMonth() {
        return this.wzs.getMonth();
    }

    public int getDayOfMonth() {
        return this.wzs.getDayOfMonth();
    }

    public void setMinDate(long j) {
        this.wzs.setMinDate(j);
    }

    public void setMaxDate(long j) {
        this.wzs.setMaxDate(j);
    }

    public void setEnabled(boolean z) {
        if (this.wzs.isEnabled() != z) {
            super.setEnabled(z);
            this.wzs.setEnabled(z);
        }
    }

    public boolean isEnabled() {
        return this.wzs.isEnabled();
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.wzs.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        this.wzs.onPopulateAccessibilityEvent(accessibilityEvent);
    }

    public CharSequence getAccessibilityClassName() {
        return YADatePicker.class.getName();
    }

    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.wzs.onConfigurationChanged(configuration);
    }

    public final void cbf() {
        this.wzs.setCalendarViewShown(false);
    }

    public final void cbg() {
        this.wzs.setSpinnersShown(true);
    }

    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    protected Parcelable onSaveInstanceState() {
        return this.wzs.b(super.onSaveInstanceState());
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        BaseSavedState baseSavedState = (BaseSavedState) parcelable;
        super.onRestoreInstanceState(baseSavedState.getSuperState());
        this.wzs.onRestoreInstanceState(baseSavedState);
    }
}
