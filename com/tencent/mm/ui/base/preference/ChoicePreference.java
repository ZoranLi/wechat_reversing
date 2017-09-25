package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.tencent.mm.s.a.g;
import com.tencent.mm.s.a.h;
import com.tencent.mm.s.a.m;
import com.tencent.mm.ui.base.preference.Preference.a;
import java.util.HashMap;
import junit.framework.Assert;

public final class ChoicePreference extends Preference {
    public int oqL;
    public String value;
    private final HashMap<CharSequence, b> values;
    private RadioGroup vqq;
    private CharSequence[] vqr;
    public CharSequence[] vqs;
    public a vqt;

    public ChoicePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChoicePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.values = new HashMap();
        this.oqL = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.fpl, i, 0);
        this.vqr = obtainStyledAttributes.getTextArray(m.hfC);
        this.vqs = obtainStyledAttributes.getTextArray(m.hfD);
        obtainStyledAttributes.recycle();
        bSV();
    }

    public final void a(a aVar) {
        this.vqt = aVar;
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(g.content);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(h.hen, viewGroup2);
        this.vqq = (RadioGroup) onCreateView.findViewById(g.bVE);
        for (int i = 0; i < this.vqs.length; i++) {
            b bVar = (b) this.values.get(this.vqs[i]);
            if (bVar != null) {
                RadioButton radioButton;
                if (i == 0) {
                    radioButton = (RadioButton) layoutInflater.inflate(h.heb, null);
                    bVar.a(radioButton);
                    this.vqq.addView(radioButton);
                } else if (i == this.vqs.length - 1) {
                    radioButton = (RadioButton) layoutInflater.inflate(h.hed, null);
                    bVar.a(radioButton);
                    this.vqq.addView(radioButton);
                } else {
                    radioButton = (RadioButton) layoutInflater.inflate(h.hec, null);
                    bVar.a(radioButton);
                    this.vqq.addView(radioButton);
                }
            }
        }
        this.vqq.setOnCheckedChangeListener(new OnCheckedChangeListener(this) {
            final /* synthetic */ ChoicePreference vqu;

            {
                this.vqu = r1;
            }

            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (this.vqu.vqt != null) {
                    if (i != -1) {
                        this.vqu.value = this.vqu.vqs[i - 1048576];
                    } else {
                        this.vqu.value = null;
                    }
                    this.vqu.oqL = i;
                    this.vqu.vqt.a(this.vqu, this.vqu.value);
                }
            }
        });
        return onCreateView;
    }

    private void bSV() {
        boolean z;
        int i = 0;
        if (this.vqr == null) {
            this.vqr = new CharSequence[0];
        }
        if (this.vqs == null) {
            this.vqs = new CharSequence[0];
        }
        String str = "entries count different";
        if (this.vqr.length == this.vqs.length) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(str, z);
        this.values.clear();
        while (i < this.vqs.length) {
            this.values.put(this.vqs[i], new b(this.vqr[i], 1048576 + i));
            i++;
        }
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        if (this.vqq != null) {
            this.vqq.check(this.oqL);
        }
    }

    public final void setValue(String str) {
        this.value = str;
        b bVar = (b) this.values.get(str);
        if (bVar == null) {
            this.oqL = -1;
        } else {
            this.oqL = bVar.id;
        }
    }
}
