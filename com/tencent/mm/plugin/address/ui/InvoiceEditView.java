package com.tencent.mm.plugin.address.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
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

public class InvoiceEditView extends RelativeLayout implements OnFocusChangeListener {
    private int background;
    private int gravity;
    private int imeOptions;
    private int inputType;
    private OnFocusChangeListener itW;
    private TextView itX;
    EditText itY;
    private ImageView itZ;
    private String iua;
    private String iub;
    int iuc;
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
    a iuo;
    private int iup;
    public boolean iuq;

    public interface a {
        void OY();
    }

    public InvoiceEditView(Context context, AttributeSet attributeSet, int i) {
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
            final /* synthetic */ InvoiceEditView iur;

            {
                this.iur = r1;
            }

            public final void onClick(View view) {
                if (this.iur.itZ.getVisibility() == 0 && this.iur.iue && this.iur.iuc != 2 && !bg.mA(this.iur.getText())) {
                    this.iur.itY.setText("");
                    this.iur.bD(this.iur.itY.isFocused());
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
        View inflate = LayoutInflater.from(context).inflate(R.i.dfS, this, true);
        this.itY = (EditText) inflate.findViewById(R.h.bWk);
        this.itY.setTextSize(0, (float) com.tencent.mm.bg.a.T(context, R.f.aXI));
        this.itX = (TextView) inflate.findViewById(R.h.cIJ);
        this.itZ = (ImageView) inflate.findViewById(R.h.bXC);
        this.itZ.setOnClickListener(this.iuk);
        this.itY.setImeOptions(this.imeOptions);
        this.itY.setInputType(this.inputType);
        if (this.inputType == 2) {
            this.itY.setKeyListener(new NumberKeyListener(this) {
                final /* synthetic */ InvoiceEditView iur;

                {
                    this.iur = r1;
                }

                public final int getInputType() {
                    return 2;
                }

                protected final char[] getAcceptedChars() {
                    return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '-', '+', '_', '—', ' ', ' ', '(', ')', '（', '）', '@', '~', '*', '&', '^', '%', '$', '#', '@', '!', ';', ':', '：', '；', '{', '}', '[', ']', '｛', '｝', '【', '】', '<', '>', '~', '`', '·', '=', '=', '+'};
                }
            });
        } else if (this.inputType == 3) {
            this.itY.setKeyListener(new NumberKeyListener(this) {
                final /* synthetic */ InvoiceEditView iur;

                {
                    this.iur = r1;
                }

                public final int getInputType() {
                    return 3;
                }

                protected final char[] getAcceptedChars() {
                    if (this.iur.iun) {
                        return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', ' ', ' '};
                    }
                    return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '-', '+', '_', '—', ' ', ' ', '(', ')', '（', '）', '@', '~', '*', '&', '^', '%', '$', '#', '@', '!', ';', ':', '：', '；', '{', '}', '[', ']', '｛', '｝', '【', '】', '<', '>', '转', '~', '`', '·', '=', '=', '+'};
                }
            });
        } else {
            this.itY.setInputType(this.inputType);
        }
        bD(this.itY.isFocused());
        this.itY.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ InvoiceEditView iur;

            {
                this.iur = r1;
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                int i = 0;
                if (this.iur.iuc == 5 && this.iur.iup != editable.toString().length()) {
                    CharSequence charSequence;
                    this.iur.iup = editable.toString().length();
                    InvoiceEditView invoiceEditView = this.iur;
                    String obj = editable.toString();
                    if (invoiceEditView.iuc == 5) {
                        String replace = obj.replace(" ", "");
                        if (replace.length() >= 4) {
                            StringBuilder stringBuilder = new StringBuilder();
                            if (replace.length() % 4 == 0) {
                                while (i < (replace.length() / 4) - 1) {
                                    stringBuilder.append(replace.substring(i * 4, (i + 1) * 4)).append(" ");
                                    i++;
                                }
                                charSequence = obj;
                            } else {
                                while (i < replace.length() / 4) {
                                    stringBuilder.append(replace.substring(i * 4, (i + 1) * 4)).append(" ");
                                    i++;
                                }
                                charSequence = stringBuilder.append(replace.substring((replace.length() / 4) * 4, replace.length())).toString();
                            }
                            invoiceEditView.itY.setText(charSequence);
                            invoiceEditView.itY.setSelection(invoiceEditView.itY.getText().length());
                        }
                    }
                    Object obj2 = obj;
                    invoiceEditView.itY.setText(charSequence);
                    invoiceEditView.itY.setSelection(invoiceEditView.itY.getText().length());
                }
                boolean Pb = this.iur.Pb();
                if (!(Pb == this.iur.iug || this.iur.iuo == null)) {
                    w.d("MicroMsg.InvoiceEditView", "View:" + this.iur.iub + ", editType:" + this.iur.iuc + " inputValid change to " + Pb);
                    this.iur.iug = Pb;
                    this.iur.iuo.OY();
                }
                if ((!this.iur.iun || this.iur.iug) && this.iur.iun && this.iur.iug) {
                    this.iur.itY.setTextColor(this.iur.getResources().getColor(R.e.black));
                }
                this.iur.bD(this.iur.itY.isFocused());
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
            if (this.iuq) {
                setBackgroundResource(R.g.beo);
            }
            setPadding(com.tencent.mm.bg.a.fromDPToPix(getContext(), 8), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        c(this.itY, rect);
        if (this.iuf != -1) {
            this.itZ.setImageResource(this.iuf);
        }
        if (!this.iuj) {
            this.itY.setSingleLine(false);
        }
    }

    public InvoiceEditView(Context context, AttributeSet attributeSet) {
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
            case 0:
                if (obj.length() < this.iuh || obj.length() > this.iui) {
                    return false;
                }
                return true;
            case 1:
                if (obj.length() == 0) {
                    return true;
                }
                if (obj.length() < this.iuh || obj.length() > this.iui) {
                    return false;
                }
                return true;
            case 4:
                if (obj.length() > 100) {
                    return false;
                }
                return true;
            case 5:
                if (obj.length() > 48) {
                    return false;
                }
                return true;
            default:
                if (obj.length() < this.iuh || obj.length() > this.iui) {
                    return false;
                }
                return true;
        }
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
        if (this.iuo != null) {
            this.iuo.OY();
        }
        if (this.iug) {
            this.itX.setEnabled(true);
        } else {
            this.itX.setEnabled(false);
        }
        if (view == this.itY) {
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
