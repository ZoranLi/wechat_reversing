package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.MMActivity;

public class WebViewSearchContentInputFooter extends LinearLayout {
    private View snK;
    private EditText snL;
    private View snM;
    private View snN;
    private View snO;
    private TextView snP;
    public a snQ;

    public interface a {
        void a(WebViewSearchContentInputFooter webViewSearchContentInputFooter);

        void azX();

        void azY();

        void azZ();

        void azn();

        void b(WebViewSearchContentInputFooter webViewSearchContentInputFooter);

        boolean c(int i, KeyEvent keyEvent);
    }

    public WebViewSearchContentInputFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public WebViewSearchContentInputFooter(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        View inflate = inflate(getContext(), R.i.drP, this);
        this.snL = (EditText) inflate.findViewById(R.h.bKP);
        this.snM = inflate.findViewById(R.h.bCA);
        this.snN = inflate.findViewById(R.h.csm);
        this.snO = inflate.findViewById(R.h.cnZ);
        this.snP = (TextView) inflate.findViewById(R.h.bXy);
        this.snK = inflate.findViewById(R.h.bXL);
        this.snM.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WebViewSearchContentInputFooter snR;

            {
                this.snR = r1;
            }

            public final void onClick(View view) {
                this.snR.hide();
            }
        });
        this.snN.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WebViewSearchContentInputFooter snR;

            {
                this.snR = r1;
            }

            public final void onClick(View view) {
                if (this.snR.snQ != null) {
                    this.snR.snQ.azY();
                }
            }
        });
        this.snO.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WebViewSearchContentInputFooter snR;

            {
                this.snR = r1;
            }

            public final void onClick(View view) {
                if (this.snR.snQ != null) {
                    this.snR.snQ.azZ();
                }
            }
        });
        this.snL.setOnKeyListener(new OnKeyListener(this) {
            final /* synthetic */ WebViewSearchContentInputFooter snR;

            {
                this.snR = r1;
            }

            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (this.snR.snQ != null) {
                    this.snR.snQ.c(i, keyEvent);
                }
                if (i != 66 || this.snR.snQ == null) {
                    return false;
                }
                Context context = view.getContext();
                if (context instanceof MMActivity) {
                    ((MMActivity) context).cY(this.snR.snL);
                }
                this.snR.snQ.b(this.snR);
                return true;
            }
        });
        this.snL.setOnFocusChangeListener(new OnFocusChangeListener(this) {
            final /* synthetic */ WebViewSearchContentInputFooter snR;

            {
                this.snR = r1;
            }

            public final void onFocusChange(View view, boolean z) {
                if (!(z || this.snR.snQ == null)) {
                    Context context = view.getContext();
                    if (context instanceof MMActivity) {
                        ((MMActivity) context).cY(this.snR.snL);
                    }
                }
                this.snR.snK.setSelected(z);
            }
        });
        this.snL.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ WebViewSearchContentInputFooter snR;

            {
                this.snR = r1;
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (this.snR.snQ != null) {
                    a c = this.snR.snQ;
                    WebViewSearchContentInputFooter webViewSearchContentInputFooter = this.snR;
                    if (charSequence != null) {
                        charSequence.toString();
                    }
                    c.a(webViewSearchContentInputFooter);
                }
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        this.snL.setSelectAllOnFocus(true);
        reset();
    }

    public final void reset() {
        this.snP.setText("");
        this.snN.setEnabled(false);
        this.snO.setEnabled(false);
    }

    public final void bzY() {
        this.snL.setText("");
    }

    public boolean isShown() {
        return getVisibility() == 0;
    }

    public final void show() {
        setVisibility(0);
        if (this.snQ != null) {
            this.snQ.azn();
        }
        this.snL.requestFocus();
        postDelayed(new Runnable(this) {
            final /* synthetic */ WebViewSearchContentInputFooter snR;

            {
                this.snR = r1;
            }

            public final void run() {
                MMActivity.O((Activity) this.snR.getContext());
            }
        }, 100);
    }

    public final void hide() {
        Context context = this.snL.getContext();
        if (context instanceof MMActivity) {
            ((MMActivity) context).cY(this.snL);
        }
        this.snL.clearFocus();
        setVisibility(8);
        if (this.snQ != null) {
            this.snQ.azX();
        }
    }

    public final void q(int i, int i2, boolean z) {
        boolean z2 = true;
        if (z) {
            boolean z3;
            TextView textView = this.snP;
            String str = "%d/%d";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(i2 == 0 ? 0 : i + 1);
            objArr[1] = Integer.valueOf(i2);
            textView.setText(String.format(str, objArr));
            View view = this.snO;
            if (i2 > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            view.setEnabled(z3);
            View view2 = this.snN;
            if (i2 <= 0) {
                z2 = false;
            }
            view2.setEnabled(z2);
        }
    }

    public final String bzZ() {
        return this.snL.getText().toString();
    }
}
