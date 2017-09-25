package com.tencent.mm.wallet_core.ui;

import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.text.method.NumberKeyListener;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.widget.f;
import com.tencent.mm.wallet_core.c.s;
import com.tencent.wcdb.FileUtils;
import com.tenpay.android.wechat.TenpaySecureEditText;
import java.text.DecimalFormat;
import java.util.Calendar;

@Deprecated
public class EditHintView extends RelativeLayout implements OnFocusChangeListener {
    private int background;
    private int gravity;
    private int imeOptions;
    private int inputType;
    private OnFocusChangeListener itW;
    private TextView itX;
    private ImageView itZ;
    private String iua;
    private String iub;
    private int iuc;
    private int iud;
    public boolean iue;
    private boolean iug;
    private int iuh;
    private int iui;
    private OnClickListener iuk;
    private int mode;
    private int nOL;
    private int nOM;
    private boolean oLE;
    public boolean vrl;
    private b wEY;
    private TextView wEZ;
    TenpaySecureEditText wFa;
    private int wFb;
    private int wFc;
    private int wFd;
    private boolean wFe;
    private String wFf;
    private DatePickerDialog wFg;
    private h wFh;
    private a wFi;

    public interface a {
    }

    public interface b {
    }

    static /* synthetic */ void o(EditHintView editHintView) {
        int cco;
        int ccp;
        switch (editHintView.iuc) {
            case 3:
                editHintView.getContext();
                cco = s.cco();
                editHintView.getContext();
                ccp = s.ccp();
                break;
            case 4:
                editHintView.getContext();
                cco = s.ccq();
                ccp = R.l.ebh;
                break;
            case 9:
                cco = R.i.dri;
                ccp = R.l.feJ;
                break;
            case 10:
                cco = R.i.dqN;
                ccp = R.l.feE;
                break;
            default:
                ccp = -1;
                cco = -1;
                break;
        }
        if (cco != -1) {
            if (editHintView.wFh == null) {
                editHintView.wFh = b.a(editHintView.getContext(), cco, editHintView.getResources().getString(ccp), editHintView.getResources().getString(R.l.eOW), new DialogInterface.OnClickListener(editHintView) {
                    final /* synthetic */ EditHintView wFj;

                    {
                        this.wFj = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.wFj.wFh.dismiss();
                    }
                });
            }
            editHintView.wFh.show();
        }
    }

    public EditHintView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.iua = "";
        this.iub = "";
        this.inputType = 1;
        this.oLE = true;
        this.iui = -1;
        this.iuh = 1;
        this.gravity = 19;
        this.wFb = -1;
        this.iuc = -1;
        this.iug = false;
        this.wFc = 1;
        this.wFd = -1;
        this.background = -1;
        this.iud = -1;
        this.iue = true;
        this.vrl = true;
        this.wFe = true;
        this.wFf = null;
        this.mode = 0;
        this.wFg = null;
        this.nOL = 0;
        this.nOM = 0;
        this.iuk = new OnClickListener(this) {
            final /* synthetic */ EditHintView wFj;

            {
                this.wFj = r1;
            }

            public final void onClick(View view) {
                if (this.wFj.itZ.getVisibility() != 0) {
                    return;
                }
                if (this.wFj.iue && !bg.mA(this.wFj.getText())) {
                    this.wFj.wFa.ClearInput();
                } else if (this.wFj.iuc != 1) {
                    EditHintView.o(this.wFj);
                } else if (this.wFj.wFi != null && this.wFj.wFe) {
                }
            }
        };
        this.wFh = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.n.fpP, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(R.n.fpY, 0);
        if (resourceId != 0) {
            this.iua = context.getString(resourceId);
        }
        resourceId = obtainStyledAttributes.getResourceId(R.n.fqd, 0);
        if (resourceId != 0) {
            this.iub = context.getString(resourceId);
        }
        this.inputType = obtainStyledAttributes.getInteger(R.n.fpU, 1);
        this.iue = obtainStyledAttributes.getBoolean(R.n.fpX, true);
        this.gravity = obtainStyledAttributes.getInt(R.n.fpS, 19);
        this.oLE = obtainStyledAttributes.getBoolean(R.n.fpR, true);
        this.iui = obtainStyledAttributes.getInteger(R.n.fqb, -1);
        this.iuc = obtainStyledAttributes.getInteger(R.n.fpW, 0);
        this.imeOptions = obtainStyledAttributes.getInteger(R.n.fpT, 5);
        this.wFd = obtainStyledAttributes.getColor(R.n.fqa, R.e.black);
        this.background = obtainStyledAttributes.getResourceId(R.n.fpQ, -1);
        this.iud = obtainStyledAttributes.getResourceId(R.n.fpZ, R.g.beF);
        this.iuh = obtainStyledAttributes.getInteger(R.n.fqc, 1);
        this.vrl = obtainStyledAttributes.getBoolean(R.n.fpV, true);
        obtainStyledAttributes.recycle();
        View inflate = r.eC(context).inflate(R.i.dal, this, true);
        this.wFa = (TenpaySecureEditText) inflate.findViewById(R.h.bWk);
        this.itX = (TextView) inflate.findViewById(R.h.cIJ);
        this.wEZ = (TextView) inflate.findViewById(R.h.csl);
        this.itZ = (ImageView) inflate.findViewById(R.h.bXC);
        this.wFa.setImeOptions(this.imeOptions);
        switch (this.iuc) {
            case 0:
                break;
            case 1:
                this.iui = 25;
                this.wFa.setIsBankcardFormat(true);
                this.inputType = 2;
                break;
            case 2:
            case 9:
                this.iui = 30;
                this.inputType = 3;
                break;
            case 3:
                this.iue = false;
                this.wFa.setIsValidThru(true);
                setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ EditHintView wFj;

                    {
                        this.wFj = r1;
                    }

                    public final void onClick(View view) {
                        if (this.wFj.wFg == null) {
                            Calendar instance = Calendar.getInstance();
                            instance.setTimeInMillis(System.currentTimeMillis());
                            instance.add(2, 1);
                            this.wFj.nOL = instance.get(1);
                            this.wFj.nOM = instance.get(2);
                            this.wFj.wFg = new f(this.wFj.getContext(), new OnDateSetListener(this) {
                                final /* synthetic */ AnonymousClass6 wFk;

                                {
                                    this.wFk = r1;
                                }

                                public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                                    if (i >= this.wFk.wFj.nOL || i2 >= this.wFk.wFj.nOM) {
                                        DecimalFormat decimalFormat = new DecimalFormat("00");
                                        if (m.xY()) {
                                            this.wFk.wFj.wFf = decimalFormat.format((long) (i2 + 1)) + i;
                                        } else {
                                            this.wFk.wFj.wFf = decimalFormat.format((long) i).substring(2) + decimalFormat.format((long) (i2 + 1));
                                        }
                                        this.wFk.wFj.wFa.setText(decimalFormat.format((long) (i2 + 1)) + decimalFormat.format((long) i).substring(2));
                                    } else {
                                        g.b(this.wFk.wFj.getContext(), this.wFk.wFj.getContext().getString(R.l.ffA), null, true);
                                    }
                                    this.wFk.wFj.iug = this.wFk.wFj.Pb();
                                    if (this.wFk.wFj.wEY != null) {
                                        w.d("MicroMsg.EditHintView", "View:" + this.wFk.wFj.iub + ", editType:" + this.wFk.wFj.iuc + " inputValid change to " + this.wFk.wFj.iug);
                                    }
                                }
                            }, this.wFj.nOL, this.wFj.nOM, instance.get(5), instance.getTimeInMillis());
                        }
                        this.wFj.wFg.show();
                    }
                });
                break;
            case 4:
                this.iui = 4;
                this.inputType = 2;
                break;
            case 5:
                this.iui = 18;
                this.inputType = 4;
                break;
            case 6:
                this.iui = 6;
                this.itX.setVisibility(8);
                this.inputType = 2;
                break;
            case 7:
            case 17:
                this.iui = 6;
                this.itX.setVisibility(8);
                this.wFa.setIsPasswordFormat(true);
                this.wFa.setImeOptions(6);
                this.inputType = FileUtils.S_IWUSR;
                break;
            case 8:
                this.inputType = 32;
                break;
            case 10:
                if (!this.iue && this.oLE) {
                    break;
                }
            case 12:
                this.iui = 12;
                this.wFa.setIsMoneyAmountFormat(true);
                break;
            case 13:
            case 16:
                this.wFa.setIsSecurityAnswerFormat(true);
                break;
            case 14:
                this.iui = 3;
                this.itX.setVisibility(8);
                this.wFa.setIsCvvPaymentFormat(true);
                this.wFa.setImeOptions(6);
                this.inputType = FileUtils.S_IWUSR;
                break;
            case 15:
                this.iui = 4;
                this.itX.setVisibility(8);
                this.wFa.setIsCvv4PaymentFormat(true);
                this.wFa.setImeOptions(6);
                this.inputType = FileUtils.S_IWUSR;
                break;
            default:
                this.inputType = 1;
                break;
        }
        ccw();
        this.wFa.setSingleLine(this.vrl);
        if (!this.vrl) {
            this.wFa.setMaxLines(1073741823);
        }
        this.itZ.setOnClickListener(this.iuk);
        this.wFa.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ EditHintView wFj;

            {
                this.wFj = r1;
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (this.wFj.mode == 4 && this.wFj.Pb()) {
                    this.wFj.mode = 0;
                    this.wFj.wFa.ClearInput();
                }
            }

            public final void afterTextChanged(Editable editable) {
                boolean Pb = this.wFj.Pb();
                if (!(Pb == this.wFj.iug || this.wFj.wEY == null)) {
                    w.d("MicroMsg.EditHintView", "View:" + this.wFj.iub + ", editType:" + this.wFj.iuc + " inputValid change to " + Pb);
                    this.wFj.iug = Pb;
                }
                this.wFj.ccw();
            }
        });
        this.wFa.setOnFocusChangeListener(this);
        if (!bg.mA(this.iua)) {
            this.wFa.setHint(this.iua);
        }
        if (!bg.mA(this.iub)) {
            this.itX.setText(this.iub);
        }
        this.wFa.setGravity(this.gravity);
        if (this.inputType == 2) {
            this.wFa.setKeyListener(new NumberKeyListener(this) {
                final /* synthetic */ EditHintView wFj;

                {
                    this.wFj = r1;
                }

                public final int getInputType() {
                    return 3;
                }

                protected final char[] getAcceptedChars() {
                    return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
                }
            });
        } else if (this.inputType == 4) {
            this.wFa.setKeyListener(new NumberKeyListener(this) {
                final /* synthetic */ EditHintView wFj;

                {
                    this.wFj = r1;
                }

                public final int getInputType() {
                    return 1;
                }

                protected final char[] getAcceptedChars() {
                    return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'x', 'X'};
                }
            });
        } else if (this.inputType == FileUtils.S_IWUSR) {
            this.wFa.setTransformationMethod(PasswordTransformationMethod.getInstance());
            this.wFa.setKeyListener(new NumberKeyListener(this) {
                final /* synthetic */ EditHintView wFj;

                {
                    this.wFj = r1;
                }

                public final int getInputType() {
                    return 18;
                }

                protected final char[] getAcceptedChars() {
                    return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
                }
            });
            this.wFa.setRawInputType(18);
        } else if (this.inputType == 3) {
            this.wFa.setKeyListener(new NumberKeyListener(this) {
                final /* synthetic */ EditHintView wFj;

                {
                    this.wFj = r1;
                }

                public final int getInputType() {
                    return 3;
                }

                protected final char[] getAcceptedChars() {
                    return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '-'};
                }
            });
        } else {
            this.wFa.setInputType(this.inputType);
        }
        if (this.iui != -1) {
            this.wFa.setFilters(new InputFilter[]{new LengthFilter(this.iui)});
        }
        super.setEnabled(true);
        super.setClickable(true);
        if (!this.oLE) {
            this.wFa.setEnabled(false);
            this.wFa.setTextColor(getResources().getColor(this.wFd));
            this.wFa.setFocusable(false);
            this.wFa.setClickable(false);
            this.wFa.setBackgroundResource(R.g.bkS);
            setBackgroundResource(R.g.bgh);
        }
        if (this.iue) {
            this.iug = false;
            this.wFa.setBackgroundResource(this.iud);
            setBackgroundResource(R.g.bkS);
        } else {
            this.iug = true;
            this.wFa.setEnabled(false);
            this.wFa.setTextColor(getResources().getColor(R.e.aUB));
            this.wFa.setFocusable(false);
            this.wFa.setClickable(false);
            this.wFa.setBackgroundResource(R.g.bkS);
            setBackgroundResource(R.g.beo);
        }
        if (this.background > 0) {
            setBackgroundResource(this.background);
        }
        if (!(this.itX == null || this.wFb == -1)) {
            LayoutParams layoutParams = this.itX.getLayoutParams();
            layoutParams.width = this.wFb;
            this.itX.setLayoutParams(layoutParams);
        }
        if (m.xY()) {
            int i2;
            TenpaySecureEditText tenpaySecureEditText = this.wFa;
            switch (this.iuc) {
                case 1:
                    i2 = 50;
                    break;
                case 4:
                case 14:
                case 15:
                    i2 = 30;
                    break;
                case 6:
                    i2 = 60;
                    break;
                case 7:
                    i2 = 20;
                    break;
                case 13:
                    i2 = 40;
                    break;
                case 16:
                    i2 = -20;
                    break;
                case 17:
                    i2 = -10;
                    break;
                default:
                    i2 = 0;
                    break;
            }
            tenpaySecureEditText.setSecureEncrypt(new com.tencent.mm.wallet_core.a.a(i2));
        }
    }

    public EditHintView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    protected void onMeasure(int i, int i2) {
        if (this.iuc == 7 || this.iuc == 17 || this.iuc == 14 || this.iuc == 15) {
            int i3;
            setMeasuredDimension(getDefaultSize(com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(getContext(), 960.0f), i), getDefaultSize(com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(getContext(), 720.0f), i2));
            int measuredWidth = getMeasuredWidth();
            if (this.iuc == 7 || this.iuc == 17) {
                i3 = measuredWidth / 6;
            } else if (this.iuc == 14) {
                i3 = measuredWidth / 3;
            } else {
                i3 = measuredWidth / 4;
            }
            i = MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
            i2 = MeasureSpec.makeMeasureSpec(i3, 1073741824);
            setMeasuredDimension(getDefaultSize(measuredWidth, i), getDefaultSize(i3, i2));
        }
        super.onMeasure(i, i2);
    }

    public final String getText() {
        switch (this.iuc) {
            case 0:
            case 8:
            case 10:
                return bg.ap(this.wFa.getText().toString(), "");
            case 1:
            case 13:
            case 16:
                return this.wFa.getEncryptDataWithHash(false);
            case 2:
            case 9:
                return bg.ap(this.wFa.getText().toString(), "");
            case 3:
                return bg.ap(this.wFf, "").replace("/", "");
            case 4:
            case 14:
            case 15:
                return this.wFa.get3DesEncrptData();
            case 5:
                return this.wFa.get3DesEncrptData();
            case 6:
                return this.wFa.get3DesVerifyCode();
            case 7:
                return this.wFa.getEncryptDataWithHash(true);
            default:
                return bg.ap(this.wFa.getText().toString(), "");
        }
    }

    public final boolean Pb() {
        if (!this.iue && !this.oLE) {
            return true;
        }
        switch (this.iuc) {
            case 1:
                return this.wFa.isBankcardNum();
            case 4:
                if (this.wFa.getInputLength() <= 0) {
                    return false;
                }
                return true;
            case 5:
                return this.wFa.isAreaIDCardNum(this.wFc);
            case 7:
            case 17:
                if (this.wFa.getInputLength() != 6) {
                    return false;
                }
                return true;
            case 8:
                return bg.PK(this.wFa.getText().toString());
            case 9:
                return this.wFa.isPhoneNum();
            case 12:
                return this.wFa.isMoneyAmount();
            case 14:
                if (this.wFa.getInputLength() != 3) {
                    return false;
                }
                return true;
            case 15:
                if (this.wFa.getInputLength() != 4) {
                    return false;
                }
                return true;
            default:
                if (this.wFa.getInputLength() < this.iuh) {
                    return false;
                }
                return true;
        }
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.iue = z;
        this.itZ.setEnabled(true);
    }

    public void setClickable(boolean z) {
        super.setClickable(z);
        this.oLE = z;
        if (z) {
            this.wFa.setEnabled(true);
            if (this.iue) {
                this.wFa.setTextColor(getResources().getColor(this.wFd));
            } else {
                this.wFa.setTextColor(getResources().getColor(R.e.aUB));
            }
            this.wFa.setFocusable(true);
            this.wFa.setClickable(true);
            return;
        }
        this.wFa.setEnabled(false);
        if (this.iue) {
            this.wFa.setTextColor(getResources().getColor(this.wFd));
        } else {
            this.wFa.setTextColor(getResources().getColor(R.e.aUz));
        }
        this.wFa.setFocusable(false);
        this.wFa.setClickable(false);
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

    public void setOnFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        super.setOnFocusChangeListener(onFocusChangeListener);
        this.itW = onFocusChangeListener;
    }

    private void ccw() {
        if (this.iuc != 7 && this.iuc != 14 && this.iuc != 15) {
            if (!this.iue || bg.mA(getText())) {
                switch (this.iuc) {
                    case 1:
                        if (this.wFe) {
                            this.itZ.setVisibility(0);
                            this.itZ.setImageResource(R.k.dAE);
                            return;
                        }
                        this.itZ.setVisibility(8);
                        return;
                    case 3:
                    case 4:
                    case 9:
                    case 10:
                        this.itZ.setVisibility(0);
                        this.itZ.setImageResource(R.g.bil);
                        return;
                    default:
                        this.itZ.setVisibility(8);
                        return;
                }
            }
            this.itZ.setVisibility(0);
            this.itZ.setImageResource(R.g.bgg);
        }
    }

    public void onFocusChange(View view, boolean z) {
        if (this.itW != null) {
            this.itW.onFocusChange(this, z);
        }
        w.d("MicroMsg.EditHintView", "View:" + this.iub + ", editType:" + this.iuc + " onFocusChange to " + z);
        if (this.iug) {
            this.itX.setEnabled(true);
        } else {
            this.itX.setEnabled(false);
        }
    }
}
