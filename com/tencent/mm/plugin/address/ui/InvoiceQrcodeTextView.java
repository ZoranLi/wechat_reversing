package com.tencent.mm.plugin.address.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bg.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public class InvoiceQrcodeTextView extends RelativeLayout implements OnFocusChangeListener {
    private int background;
    private int gravity;
    private int imeOptions;
    private int inputType;
    private OnFocusChangeListener itW;
    private TextView itX;
    private ImageView itZ;
    TextView iuH;
    private String iua;
    private String iub;
    private int iuc;
    private int iud;
    public boolean iue;
    private int iuf;
    public boolean iug;
    private int iuh;
    private int iui;
    private boolean iuj;
    private OnClickListener iuk;
    private String iul;
    public boolean iun;
    private int iup;
    public boolean iuq;

    public InvoiceQrcodeTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.iun = false;
        this.iua = "";
        this.iub = "";
        this.inputType = 1;
        this.iup = 0;
        this.gravity = 19;
        this.iuc = -1;
        this.background = -1;
        this.iud = -1;
        this.iue = true;
        this.iuq = true;
        this.iug = false;
        this.iuh = 0;
        this.iui = 100;
        this.iuj = true;
        this.iuk = new OnClickListener(this) {
            final /* synthetic */ InvoiceQrcodeTextView iuI;

            {
                this.iuI = r1;
            }

            public final void onClick(View view) {
                if (this.iuI.itZ.getVisibility() == 0 && this.iuI.iue && this.iuI.iuc != 2 && !bg.mA(this.iuI.getText())) {
                    this.iuI.iuH.setText("");
                    this.iuI.bD(this.iuI.iuH.isFocused());
                }
            }
        };
        this.iul = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.n.fqq, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(R.n.fqx, 0);
        if (resourceId != 0) {
            this.iua = context.getString(resourceId);
        }
        resourceId = obtainStyledAttributes.getResourceId(R.n.fqB, 0);
        if (resourceId != 0) {
            this.iub = context.getString(resourceId);
        }
        this.inputType = obtainStyledAttributes.getInteger(R.n.fqu, 1);
        this.iuc = obtainStyledAttributes.getInteger(R.n.fqv, 0);
        this.iue = obtainStyledAttributes.getBoolean(R.n.fqw, true);
        this.gravity = obtainStyledAttributes.getInt(R.n.fqs, 19);
        this.imeOptions = obtainStyledAttributes.getInteger(R.n.fqt, 5);
        this.background = obtainStyledAttributes.getResourceId(R.n.fqr, R.g.bkS);
        this.iuf = obtainStyledAttributes.getResourceId(R.n.fqz, -1);
        this.iud = obtainStyledAttributes.getResourceId(R.n.fqy, R.g.bkS);
        this.iuj = obtainStyledAttributes.getBoolean(R.n.fqA, true);
        obtainStyledAttributes.recycle();
        View inflate = LayoutInflater.from(context).inflate(R.i.dfV, this, true);
        this.iuH = (TextView) inflate.findViewById(R.h.bWk);
        this.iuH.setTextSize(0, (float) a.T(context, R.f.aXI));
        this.itX = (TextView) inflate.findViewById(R.h.cIJ);
        this.itZ = (ImageView) inflate.findViewById(R.h.bXC);
        this.itZ.setOnClickListener(this.iuk);
        this.iuH.setImeOptions(this.imeOptions);
        if (!bg.mA(this.iua)) {
            this.iuH.setHint(this.iua);
        }
        if (!bg.mA(this.iub)) {
            this.itX.setText(this.iub);
        }
        Rect rect = new Rect();
        b(this.iuH, rect);
        c(this.iuH, rect);
        setPadding(a.fromDPToPix(getContext(), 8), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        if (this.iuf != -1) {
            this.itZ.setImageResource(this.iuf);
        }
        if (!this.iuj) {
            this.iuH.setSingleLine(false);
        }
    }

    public InvoiceQrcodeTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void Pe() {
        setBackgroundResource(0);
        this.itX.setTextColor(getResources().getColor(R.e.aVK));
        this.iuH.setTextColor(getResources().getColor(R.e.black));
        this.iuH.setInputType(0);
        this.iuH.clearFocus();
        this.iuH.setSingleLine(false);
        ((InputMethodManager) getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.iuH.getWindowToken(), 0);
    }

    public final String getText() {
        return this.iuH.getText().toString();
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.iue = z;
        this.itZ.setEnabled(true);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.iue) {
            boolean z;
            if (this.itZ.getVisibility() == 0) {
                Rect rect = new Rect();
                this.itZ.getHitRect(rect);
                rect.left -= 50;
                rect.right += 50;
                rect.top -= 25;
                rect.bottom += 25;
                z = rect.contains((int) motionEvent.getX(), (int) motionEvent.getY());
            } else {
                z = false;
            }
            if (!z) {
                return true;
            }
        }
        return false;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
    }

    private void bD(boolean z) {
        if (!this.iue || bg.mA(getText())) {
            switch (this.iuc) {
                case 0:
                case 1:
                case 4:
                    this.itZ.setVisibility(8);
                    return;
                case 2:
                    this.itZ.setVisibility(0);
                    this.itZ.setContentDescription(getContext().getString(R.l.dCt));
                    return;
                case 3:
                    this.itZ.setVisibility(0);
                    this.itZ.setContentDescription(getContext().getString(R.l.dCD));
                    return;
                default:
                    this.itZ.setVisibility(8);
                    return;
            }
        }
        this.itZ.setImageResource(R.g.bgg);
        this.itZ.setContentDescription(getContext().getString(R.l.bCu));
        switch (this.iuc) {
            case 0:
            case 1:
            case 4:
            case 5:
                if (z) {
                    this.itZ.setVisibility(0);
                    return;
                } else {
                    this.itZ.setVisibility(8);
                    return;
                }
            case 2:
                this.itZ.setVisibility(0);
                this.itZ.setContentDescription(getContext().getString(R.l.dCt));
                return;
            case 3:
                this.itZ.setVisibility(0);
                this.itZ.setContentDescription(getContext().getString(R.l.dCD));
                return;
            default:
                this.itZ.setVisibility(8);
                return;
        }
    }

    public void setOnFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        super.setOnFocusChangeListener(onFocusChangeListener);
        this.itW = onFocusChangeListener;
    }

    public void onFocusChange(View view, boolean z) {
        if (this.itW != null) {
            this.itW.onFocusChange(this, z);
        }
        w.d("MicroMsg.InvoiceEditView", "View:" + this.iub + ", editType:" + this.iuc + " onFocusChange to " + z);
        if (this.iug) {
            this.itX.setEnabled(true);
        } else {
            this.itX.setEnabled(false);
        }
        if (view == this.iuH) {
            Rect rect = new Rect();
            b(this, rect);
            if (z) {
                setBackgroundResource(R.g.bfV);
            } else {
                setBackgroundResource(R.g.bfW);
            }
            c(this, rect);
        }
        bD(z);
    }

    public final void mU(String str) {
        this.iuH.setText(str);
        this.iul = str;
    }

    private static void b(View view, Rect rect) {
        rect.left = view.getPaddingLeft();
        rect.right = view.getPaddingRight();
        rect.top = view.getPaddingTop();
        rect.bottom = view.getPaddingBottom();
    }

    private static void c(View view, Rect rect) {
        view.setPadding(rect.left, rect.top, rect.right, rect.bottom);
    }
}
