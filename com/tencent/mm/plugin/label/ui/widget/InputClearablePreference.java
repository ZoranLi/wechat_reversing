package com.tencent.mm.plugin.label.ui.widget;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.MMEditText;

public class InputClearablePreference extends Preference {
    public String iMT;
    public String jqT;
    public int naA;
    private int naB;
    public boolean naC;
    public MMEditText naD;
    private ImageView naE;
    public TextView naF;
    private int naG;
    public a naH;
    public String nay;
    public String naz;

    public interface a {
        void fi(boolean z);

        void zl(String str);
    }

    class b implements InputFilter {
        final /* synthetic */ InputClearablePreference naI;
        public final char[] naJ = new char[]{'\n', ',', ';', '、', '，', '；'};

        b(InputClearablePreference inputClearablePreference) {
            this.naI = inputClearablePreference;
        }

        public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            w.d("MicroMsg.Label.InputClearablePreference", "on create tag filter, %s [%d, %d) %s [%d, %d),", new Object[]{charSequence, Integer.valueOf(i), Integer.valueOf(i2), spanned, Integer.valueOf(i3), Integer.valueOf(i4)});
            int i5 = i;
            while (i5 < i2) {
                char[] cArr = new char[(i2 - i)];
                TextUtils.getChars(charSequence, i, i2, cArr, 0);
                for (char c : this.naJ) {
                    if (cArr[i5] == ' ' && i3 == 0 && i5 == 0) {
                        return "";
                    }
                    if (cArr[i5] == c) {
                        this.naI.fk(true);
                        return "";
                    }
                }
                i5++;
            }
            return null;
        }
    }

    public InputClearablePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public InputClearablePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void setText(String str) {
        this.jqT = str;
        if (this.naD != null && !bg.mA(str)) {
            this.naD.setText(h.c(this.mContext, this.jqT, this.naG));
            zn(this.jqT);
        }
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.naG = com.tencent.mm.bg.a.T(this.mContext, R.f.aXs);
        this.naD = (MMEditText) view.findViewById(R.h.bKP);
        this.naE = (ImageView) view.findViewById(R.h.bHU);
        this.naF = (TextView) view.findViewById(R.h.bMq);
        if (this.naD != null) {
            if (this.naB > 0) {
                this.naD.setFilters(new InputFilter[]{new LengthFilter(this.naB), new b(this)});
            } else {
                this.naD.setFilters(new InputFilter[]{new b(this)});
            }
        }
        this.naD.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ InputClearablePreference naI;

            {
                this.naI = r1;
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (charSequence != null) {
                    w.d("MicroMsg.Label.InputClearablePreference", "cpan[onTextChanged] :%s", new Object[]{charSequence.toString()});
                    if (this.naI.naH != null) {
                        this.naI.naH.zl(charSequence.toString());
                    }
                }
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                boolean z = false;
                if (editable != null) {
                    String obj = editable.toString();
                    this.naI.zn(obj);
                    InputClearablePreference inputClearablePreference = this.naI;
                    if (!bg.mA(obj)) {
                        z = true;
                    }
                    inputClearablePreference.fl(z);
                    this.naI.jqT = obj;
                    return;
                }
                this.naI.fl(false);
            }
        });
        w.d("MicroMsg.Label.InputClearablePreference", "mText %s", new Object[]{this.jqT});
        setText(this.jqT);
        if (!bg.mA(this.jqT)) {
            this.naD.setSelection(this.jqT.length());
        }
        if (this.naC) {
            new ae().postDelayed(new Runnable(this) {
                final /* synthetic */ InputClearablePreference naI;

                {
                    this.naI = r1;
                }

                public final void run() {
                    if (this.naI.naD != null) {
                        ((InputMethodManager) this.naI.naD.getContext().getSystemService("input_method")).toggleSoftInput(0, 2);
                        this.naI.naD.requestFocus();
                        this.naI.naD.setCursorVisible(false);
                        this.naI.naD.setCursorVisible(true);
                    }
                }
            }, 0);
        }
        this.naD.setHint(this.nay);
        this.naE.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ InputClearablePreference naI;

            {
                this.naI = r1;
            }

            public final void onClick(View view) {
                if (this.naI.naD != null) {
                    this.naI.naD.setText("");
                    this.naI.jqT = "";
                }
            }
        });
        if (this.naF != null) {
            this.naF.setOnTouchListener(new OnTouchListener(this) {
                final /* synthetic */ InputClearablePreference naI;

                {
                    this.naI = r1;
                }

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    if (this.naI.naD != null) {
                        this.naI.naD.clearFocus();
                    }
                    return false;
                }
            });
        }
    }

    public final void zn(String str) {
        boolean z = true;
        if (!bg.mA(str)) {
            int Un = com.tencent.mm.ui.tools.h.Un(str);
            boolean z2 = Un > this.naA;
            int aI = com.tencent.mm.ui.tools.h.aI(this.naA, "");
            int aJ = com.tencent.mm.ui.tools.h.aJ(this.naA, str);
            if (this.naF != null) {
                if (z2) {
                    this.naF.setText(String.format(this.iMT, new Object[]{Integer.valueOf(aI), Integer.valueOf(aJ)}));
                    this.naF.setVisibility(0);
                } else {
                    this.naF.setVisibility(8);
                }
            }
            if (this.naH != null) {
                a aVar = this.naH;
                if (Un > this.naA) {
                    z = false;
                }
                aVar.fi(z);
            }
        }
    }

    public final void fk(boolean z) {
        if (this.naF == null) {
            return;
        }
        if (z) {
            this.naF.setText(this.naz);
            this.naF.setVisibility(0);
            return;
        }
        this.naF.setVisibility(8);
    }

    public final void fl(boolean z) {
        if (this.naE == null) {
            return;
        }
        if (z) {
            this.naE.setVisibility(0);
        } else {
            this.naE.setVisibility(8);
        }
    }
}
