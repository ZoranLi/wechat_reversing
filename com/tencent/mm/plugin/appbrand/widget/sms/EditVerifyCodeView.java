package com.tencent.mm.plugin.appbrand.widget.sms;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.w;

public class EditVerifyCodeView extends RelativeLayout {
    private ImageView[] jAC;
    private TextView[] jAD;
    OnKeyListener jAE;
    private EditText kM;
    public StringBuilder mBuilder;
    private Context mContext;

    static /* synthetic */ void b(EditVerifyCodeView editVerifyCodeView) {
        String stringBuilder = editVerifyCodeView.mBuilder.toString();
        w.i("MicroMsg.EditVerifyCodeView", "mBuilder:" + editVerifyCodeView.mBuilder);
        int length = stringBuilder.length();
        if (length > 0 && length <= 6) {
            editVerifyCodeView.jAD[length - 1].setVisibility(0);
            editVerifyCodeView.jAD[length - 1].setText(String.valueOf(stringBuilder.charAt(length - 1)));
            editVerifyCodeView.jAC[length - 1].setVisibility(4);
        }
    }

    static /* synthetic */ void c(EditVerifyCodeView editVerifyCodeView) {
        String stringBuilder = editVerifyCodeView.mBuilder.toString();
        w.i("MicroMsg.EditVerifyCodeView", "del before str:" + editVerifyCodeView.mBuilder);
        int length = stringBuilder.length();
        if (length != 0) {
            if (length > 0 && length <= 6) {
                editVerifyCodeView.mBuilder.delete(length - 1, length);
            }
            editVerifyCodeView.jAD[length - 1].setVisibility(4);
            editVerifyCodeView.jAD[length - 1].setText("");
            editVerifyCodeView.jAC[length - 1].setVisibility(0);
            w.i("MicroMsg.EditVerifyCodeView", "del after str:" + editVerifyCodeView.mBuilder);
        }
    }

    public EditVerifyCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mBuilder = new StringBuilder();
        this.jAC = new ImageView[6];
        this.jAD = new TextView[6];
        this.jAE = new OnKeyListener(this) {
            final /* synthetic */ EditVerifyCodeView jAF;

            {
                this.jAF = r1;
            }

            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (i != 67 || keyEvent.getAction() != 1) {
                    return false;
                }
                EditVerifyCodeView.c(this.jAF);
                return true;
            }
        };
        init(context);
    }

    public EditVerifyCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mBuilder = new StringBuilder();
        this.jAC = new ImageView[6];
        this.jAD = new TextView[6];
        this.jAE = /* anonymous class already generated */;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View inflate = LayoutInflater.from(this.mContext).inflate(R.i.dap, null);
        TextView textView = (TextView) inflate.findViewById(R.h.bDa);
        TextView textView2 = (TextView) inflate.findViewById(R.h.bDb);
        TextView textView3 = (TextView) inflate.findViewById(R.h.bDc);
        TextView textView4 = (TextView) inflate.findViewById(R.h.bDd);
        TextView textView5 = (TextView) inflate.findViewById(R.h.bDe);
        this.jAD[0] = (TextView) inflate.findViewById(R.h.bCZ);
        this.jAD[1] = textView;
        this.jAD[2] = textView2;
        this.jAD[3] = textView3;
        this.jAD[4] = textView4;
        this.jAD[5] = textView5;
        ImageView imageView = (ImageView) inflate.findViewById(R.h.bCH);
        ImageView imageView2 = (ImageView) inflate.findViewById(R.h.bCI);
        ImageView imageView3 = (ImageView) inflate.findViewById(R.h.bCJ);
        ImageView imageView4 = (ImageView) inflate.findViewById(R.h.bCK);
        ImageView imageView5 = (ImageView) inflate.findViewById(R.h.bCL);
        this.jAC[0] = (ImageView) inflate.findViewById(R.h.bCG);
        this.jAC[1] = imageView;
        this.jAC[2] = imageView2;
        this.jAC[3] = imageView3;
        this.jAC[4] = imageView4;
        this.jAC[5] = imageView5;
        this.kM = (EditText) inflate.findViewById(R.h.cLy);
        this.kM.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ EditVerifyCodeView jAF;

            {
                this.jAF = r1;
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                if (editable != null && editable.length() != 0) {
                    w.i("MicroMsg.EditVerifyCodeView", "afterTextChanged:%s", new Object[]{editable.toString()});
                    if (this.jAF.mBuilder.length() < 6) {
                        this.jAF.mBuilder.append(editable.toString());
                        EditVerifyCodeView.b(this.jAF);
                    }
                    editable.delete(0, editable.length());
                }
            }
        });
        this.kM.setKeyListener(new NumberKeyListener(this) {
            final /* synthetic */ EditVerifyCodeView jAF;

            {
                this.jAF = r1;
            }

            protected final char[] getAcceptedChars() {
                return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
            }

            public final int getInputType() {
                return 3;
            }
        });
        this.kM.setOnKeyListener(this.jAE);
        addView(inflate, new LayoutParams(-1, -1));
    }

    public final void setText(String str) {
        this.mBuilder.delete(0, this.mBuilder.length());
        this.mBuilder.append(str);
        String stringBuilder = this.mBuilder.toString();
        int length = stringBuilder.length();
        w.i("MicroMsg.EditVerifyCodeView", "mBuilder:" + this.mBuilder);
        int i;
        if (length > 0) {
            for (i = 0; i < length; i++) {
                this.jAD[i].setVisibility(0);
                this.jAD[i].setText(String.valueOf(stringBuilder.charAt(i)));
                this.jAC[i].setVisibility(4);
            }
            return;
        }
        for (i = 0; i < 6; i++) {
            this.jAD[i].setVisibility(4);
            this.jAD[i].setText("");
            this.jAC[i].setVisibility(0);
        }
    }
}
