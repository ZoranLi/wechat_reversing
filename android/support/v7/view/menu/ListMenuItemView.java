package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.a.a.f;
import android.support.v7.a.a.h;
import android.support.v7.a.a.k;
import android.support.v7.view.menu.m.a;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

public class ListMenuItemView extends LinearLayout implements a {
    private LayoutInflater Du;
    private TextView Fy;
    private RadioButton Qa;
    private CheckBox Qb;
    private TextView Qc;
    private Drawable Qd;
    private Context Qe;
    boolean Qf;
    private int Qg;
    boolean Qh;
    private h dR;
    private int ea;
    private ImageView kI;
    private Context mContext;

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.mContext = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.cn, i, 0);
        this.Qd = obtainStyledAttributes.getDrawable(k.MH);
        this.ea = obtainStyledAttributes.getResourceId(k.MI, -1);
        this.Qf = obtainStyledAttributes.getBoolean(k.MJ, false);
        this.Qe = context;
        obtainStyledAttributes.recycle();
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        setBackgroundDrawable(this.Qd);
        this.Fy = (TextView) findViewById(f.title);
        if (this.ea != -1) {
            this.Fy.setTextAppearance(this.Qe, this.ea);
        }
        this.Qc = (TextView) findViewById(f.Kr);
    }

    public final void a(h hVar) {
        int i;
        boolean z;
        this.dR = hVar;
        this.Qg = 0;
        setVisibility(hVar.isVisible() ? 0 : 8);
        CharSequence a = hVar.a((a) this);
        if (a != null) {
            this.Fy.setText(a);
            if (this.Fy.getVisibility() != 0) {
                this.Fy.setVisibility(0);
            }
        } else if (this.Fy.getVisibility() != 8) {
            this.Fy.setVisibility(8);
        }
        boolean isCheckable = hVar.isCheckable();
        if (!(!isCheckable && this.Qa == null && this.Qb == null)) {
            CompoundButton compoundButton;
            CompoundButton compoundButton2;
            if (this.dR.dG()) {
                if (this.Qa == null) {
                    this.Qa = (RadioButton) dq().inflate(h.KK, this, false);
                    addView(this.Qa);
                }
                compoundButton = this.Qa;
                compoundButton2 = this.Qb;
            } else {
                if (this.Qb == null) {
                    this.Qb = (CheckBox) dq().inflate(h.KH, this, false);
                    addView(this.Qb);
                }
                compoundButton = this.Qb;
                compoundButton2 = this.Qa;
            }
            if (isCheckable) {
                compoundButton.setChecked(this.dR.isChecked());
                int i2 = isCheckable ? 0 : 8;
                if (compoundButton.getVisibility() != i2) {
                    compoundButton.setVisibility(i2);
                }
                if (!(compoundButton2 == null || compoundButton2.getVisibility() == 8)) {
                    compoundButton2.setVisibility(8);
                }
            } else {
                if (this.Qb != null) {
                    this.Qb.setVisibility(8);
                }
                if (this.Qa != null) {
                    this.Qa.setVisibility(8);
                }
            }
        }
        boolean dF = hVar.dF();
        hVar.dE();
        if (dF && this.dR.dF()) {
            i = 0;
        } else {
            i = 8;
        }
        if (i == 0) {
            TextView textView = this.Qc;
            char dE = this.dR.dE();
            if (dE == '\u0000') {
                a = "";
            } else {
                StringBuilder stringBuilder = new StringBuilder(h.QV);
                switch (dE) {
                    case '\b':
                        stringBuilder.append(h.QX);
                        break;
                    case '\n':
                        stringBuilder.append(h.QW);
                        break;
                    case ' ':
                        stringBuilder.append(h.QY);
                        break;
                    default:
                        stringBuilder.append(dE);
                        break;
                }
                a = stringBuilder.toString();
            }
            textView.setText(a);
        }
        if (this.Qc.getVisibility() != i) {
            this.Qc.setVisibility(i);
        }
        Drawable icon = hVar.getIcon();
        if (this.dR.dW.QE || this.Qh) {
            z = true;
        } else {
            z = false;
        }
        if ((z || this.Qf) && !(this.kI == null && icon == null && !this.Qf)) {
            if (this.kI == null) {
                this.kI = (ImageView) dq().inflate(h.KI, this, false);
                addView(this.kI, 0);
            }
            if (icon != null || this.Qf) {
                this.kI.setImageDrawable(z ? icon : null);
                if (this.kI.getVisibility() != 0) {
                    this.kI.setVisibility(0);
                }
            } else {
                this.kI.setVisibility(8);
            }
        }
        setEnabled(hVar.isEnabled());
    }

    public final h z() {
        return this.dR;
    }

    protected void onMeasure(int i, int i2) {
        if (this.kI != null && this.Qf) {
            LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.kI.getLayoutParams();
            if (layoutParams.height > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = layoutParams.height;
            }
        }
        super.onMeasure(i, i2);
    }

    public final boolean A() {
        return false;
    }

    private LayoutInflater dq() {
        if (this.Du == null) {
            this.Du = LayoutInflater.from(this.mContext);
        }
        return this.Du;
    }
}
