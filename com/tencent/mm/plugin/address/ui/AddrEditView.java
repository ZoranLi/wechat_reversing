package com.tencent.mm.plugin.address.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.telephony.PhoneNumberUtils;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public class AddrEditView extends RelativeLayout implements OnFocusChangeListener {
    private int background;
    private int gravity;
    private int imeOptions;
    private int inputType;
    a itU;
    b itV;
    private OnFocusChangeListener itW;
    private TextView itX;
    EditText itY;
    private ImageView itZ;
    private String iua;
    private String iub;
    private int iuc;
    private int iud;
    public boolean iue;
    private int iuf;
    private boolean iug;
    private int iuh;
    private int iui;
    private boolean iuj;
    private OnClickListener iuk;
    private String iul;

    public interface a {
        void onClick();
    }

    public interface b {
        void OY();
    }

    public AddrEditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.iua = "";
        this.iub = "";
        this.inputType = 1;
        this.gravity = 19;
        this.iuc = -1;
        this.background = -1;
        this.iud = -1;
        this.iue = true;
        this.iug = false;
        this.iuh = 1;
        this.iui = 30;
        this.iuj = true;
        this.iuk = new OnClickListener(this) {
            final /* synthetic */ AddrEditView ium;

            {
                this.ium = r1;
            }

            public final void onClick(View view) {
                if (this.ium.itZ.getVisibility() != 0) {
                    return;
                }
                if (this.ium.iue && this.ium.iuc != 2 && !bg.mA(this.ium.getText())) {
                    this.ium.itY.setText("");
                    this.ium.bD(this.ium.itY.isFocused());
                } else if (this.ium.itU != null) {
                    this.ium.itU.onClick();
                }
            }
        };
        this.iul = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.n.foR, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(R.n.foU, 0);
        if (resourceId != 0) {
            this.iua = context.getString(resourceId);
        }
        resourceId = obtainStyledAttributes.getResourceId(R.n.foY, 0);
        if (resourceId != 0) {
            this.iub = context.getString(resourceId);
        }
        this.inputType = obtainStyledAttributes.getInteger(R.n.fpc, 1);
        this.iuc = obtainStyledAttributes.getInteger(R.n.foS, 0);
        this.iue = obtainStyledAttributes.getBoolean(R.n.foT, true);
        this.gravity = obtainStyledAttributes.getInt(R.n.fpa, 19);
        this.imeOptions = obtainStyledAttributes.getInteger(R.n.fpb, 5);
        this.background = obtainStyledAttributes.getResourceId(R.n.foZ, R.g.bkS);
        this.iuf = obtainStyledAttributes.getResourceId(R.n.foW, -1);
        this.iud = obtainStyledAttributes.getResourceId(R.n.foV, R.g.bkS);
        this.iuj = obtainStyledAttributes.getBoolean(R.n.foX, true);
        obtainStyledAttributes.recycle();
        View inflate = LayoutInflater.from(context).inflate(R.i.cTE, this, true);
        this.itY = (EditText) inflate.findViewById(R.h.bWk);
        this.itY.setTextSize(0, (float) com.tencent.mm.bg.a.T(context, R.f.aXI));
        this.itX = (TextView) inflate.findViewById(R.h.cIJ);
        this.itZ = (ImageView) inflate.findViewById(R.h.bXC);
        this.itZ.setOnClickListener(this.iuk);
        this.itY.setImeOptions(this.imeOptions);
        this.itY.setInputType(this.inputType);
        if (this.inputType == 2) {
            this.itY.setKeyListener(new NumberKeyListener(this) {
                final /* synthetic */ AddrEditView ium;

                {
                    this.ium = r1;
                }

                public final int getInputType() {
                    return 3;
                }

                protected final char[] getAcceptedChars() {
                    return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
                }
            });
        } else if (this.inputType == 3) {
            this.itY.setKeyListener(new NumberKeyListener(this) {
                final /* synthetic */ AddrEditView ium;

                {
                    this.ium = r1;
                }

                public final int getInputType() {
                    return 3;
                }

                protected final char[] getAcceptedChars() {
                    return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
                }
            });
        } else {
            this.itY.setInputType(this.inputType);
        }
        bD(this.itY.isFocused());
        this.itY.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ AddrEditView ium;

            {
                this.ium = r1;
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                boolean Pb = this.ium.Pb();
                if (!(Pb == this.ium.iug || this.ium.itV == null)) {
                    w.d("MicroMsg.AddrEditView", "View:" + this.ium.iub + ", editType:" + this.ium.iuc + " inputValid change to " + Pb);
                    this.ium.iug = Pb;
                    this.ium.itV.OY();
                }
                this.ium.bD(this.ium.itY.isFocused());
            }
        });
        this.itY.setOnFocusChangeListener(this);
        if (!bg.mA(this.iua)) {
            this.itY.setHint(this.iua);
        }
        if (!bg.mA(this.iub)) {
            this.itX.setText(this.iub);
        }
        Rect rect = new Rect();
        b(this.itY, rect);
        if (this.iue) {
            this.iug = false;
            this.itY.setBackgroundResource(this.iud);
            setBackgroundResource(this.background);
        } else {
            this.itY.setEnabled(false);
            this.itY.setTextColor(getResources().getColor(R.e.aSH));
            this.itY.setFocusable(false);
            this.itY.setClickable(false);
            this.itY.setBackgroundResource(R.g.bkS);
            setBackgroundResource(R.g.beo);
            setPadding(com.tencent.mm.bg.a.fromDPToPix(getContext(), 8), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        c(this.itY, rect);
        this.itY.setGravity(this.gravity);
        if (this.iuf != -1) {
            this.itZ.setImageResource(this.iuf);
        }
        if (!this.iuj) {
            this.itY.setSingleLine(false);
        }
    }

    public AddrEditView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final String getText() {
        return this.itY.getText().toString();
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

    public final boolean Pb() {
        String obj = this.itY.getText().toString();
        switch (this.iuc) {
            case 1:
                if (obj.length() >= this.iuh && obj.length() <= this.iui) {
                    if (obj == null) {
                        obj = null;
                    } else {
                        obj = obj.replaceAll("\\D", "");
                        if (obj.startsWith("86")) {
                            obj = obj.substring(2);
                        }
                    }
                    if (PhoneNumberUtils.isGlobalPhoneNumber(obj)) {
                        return true;
                    }
                }
                return false;
            default:
                if (obj.length() >= this.iuh) {
                    return true;
                }
                return false;
        }
    }

    private void bD(boolean z) {
        if (!this.iue || bg.mA(getText())) {
            switch (this.iuc) {
                case 0:
                case 1:
                    this.itZ.setVisibility(8);
                    return;
                case 2:
                    this.itZ.setVisibility(0);
                    this.itZ.setImageResource(R.k.dAA);
                    this.itZ.setContentDescription(getContext().getString(R.l.dCt));
                    return;
                case 3:
                    this.itZ.setVisibility(0);
                    this.itZ.setImageResource(R.k.dAB);
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
                if (z) {
                    this.itZ.setVisibility(0);
                    return;
                } else {
                    this.itZ.setVisibility(8);
                    return;
                }
            case 2:
                this.itZ.setVisibility(0);
                this.itZ.setImageResource(R.k.dAA);
                this.itZ.setContentDescription(getContext().getString(R.l.dCt));
                return;
            case 3:
                this.itZ.setVisibility(0);
                this.itZ.setImageResource(R.k.dAB);
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
        w.d("MicroMsg.AddrEditView", "View:" + this.iub + ", editType:" + this.iuc + " onFocusChange to " + z);
        if (this.itV != null) {
            this.itV.OY();
        }
        if (this.iug) {
            this.itX.setEnabled(true);
        } else {
            this.itX.setEnabled(false);
        }
        if (view == this.itY) {
            Rect rect = new Rect();
            b((View) this, rect);
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
        this.itY.setText(str);
        this.itY.setSelection(this.itY.getText().length());
        this.iul = str;
    }

    public final boolean Pc() {
        if (getText().equals(bg.mz(this.iul))) {
            return false;
        }
        return true;
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
