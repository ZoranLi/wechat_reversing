package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.d;
import com.tencent.mm.pluginsdk.ui.chat.e;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.BasePanelKeybordLayout;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.List;

public class LuckyMoneyWishFooter extends BasePanelKeybordLayout {
    private MMActivity fCi;
    private ImageButton nuO;
    private MMEditText nuP;
    private Button nuQ;
    private ChatFooterPanel nuR;
    boolean nuS = false;
    public boolean nuT = false;
    private boolean nuU = true;
    boolean nuV = true;
    private TextWatcher nuW = new TextWatcher(this) {
        final /* synthetic */ LuckyMoneyWishFooter nuX;

        {
            this.nuX = r1;
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            if (this.nuX.nuP.getText() != null) {
                this.nuX.nuP.requestFocus();
                boolean z = editable.length() > 0 && editable.toString().trim().length() > 0;
                if (z && this.nuX.nuV) {
                    this.nuX.fy(true);
                    this.nuX.nuV = false;
                }
                if (!z) {
                    this.nuX.fy(false);
                    this.nuX.nuV = true;
                }
            }
        }
    };
    private int state = 0;

    public interface a {
        void zO(String str);
    }

    public LuckyMoneyWishFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fCi = (MMActivity) context;
        ViewGroup viewGroup = (ViewGroup) inflate(this.fCi, R.i.dhy, this);
        this.nuQ = (Button) viewGroup.findViewById(R.h.cgz);
        fy(false);
        this.nuO = (ImageButton) viewGroup.findViewById(R.h.cgy);
        this.nuO.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ LuckyMoneyWishFooter nuX;

            {
                this.nuX = r1;
            }

            public final void onClick(View view) {
                this.nuX.nuS = true;
                w.i("MicroMsg.SnsCommentFooter", "state onClick" + this.nuX.state);
                if (this.nuX.state == 0) {
                    this.nuX.fCi.aHf();
                    this.nuX.nuP.requestFocus();
                    this.nuX.Zd();
                    this.nuX.nuO.setImageResource(R.k.dzV);
                    this.nuX.state = 1;
                    this.nuX.nuU = false;
                    return;
                }
                this.nuX.nuU = false;
                this.nuX.nuP.requestFocus();
                this.nuX.nuR.setVisibility(8);
                this.nuX.fCi.aHj();
                this.nuX.nuO.setImageResource(R.k.dzU);
                this.nuX.state = 0;
            }
        });
        this.nuP = (MMEditText) viewGroup.findViewById(R.h.cgw);
        this.nuP.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ LuckyMoneyWishFooter nuX;

            {
                this.nuX = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                this.nuX.nuU = false;
                this.nuX.nuR.setVisibility(8);
                this.nuX.nuR.onPause();
                this.nuX.nuO.setImageResource(R.g.bef);
                this.nuX.state = 0;
                return false;
            }
        });
        if (e.sQl == null) {
            this.nuR = new d(this.fCi);
            return;
        }
        this.nuR = e.sQl.bR(getContext());
        this.nuR.lw(ChatFooterPanel.sIB);
        this.nuR.setVisibility(8);
        this.nuR.setBackgroundResource(R.g.bcX);
        ((LinearLayout) findViewById(R.h.czn)).addView(this.nuR, -1, 0);
        this.nuR.anO();
        this.nuR.dA(false);
        this.nuR.sIy = new com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a(this) {
            final /* synthetic */ LuckyMoneyWishFooter nuX;

            {
                this.nuX = r1;
            }

            public final void aIN() {
            }

            public final void fz(boolean z) {
            }

            public final void Zh() {
                this.nuX.nuP.wvn.sendKeyEvent(new KeyEvent(0, 67));
                this.nuX.nuP.wvn.sendKeyEvent(new KeyEvent(1, 67));
            }

            public final void append(String str) {
                try {
                    this.nuX.nuP.Uz(str);
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.SnsCommentFooter", e, "", new Object[0]);
                }
            }
        };
    }

    public void setVisibility(int i) {
        boolean z;
        this.state = 0;
        if (i == 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.nuR != null) {
            w.i("MicroMsg.SnsCommentFooter", "showState " + z);
            if (z) {
                if (this.state == 0) {
                    this.fCi.aHj();
                    this.nuP.requestFocus();
                    this.nuR.setVisibility(8);
                } else {
                    this.fCi.aHf();
                    this.nuP.requestFocus();
                    Zd();
                }
                this.nuU = false;
            } else {
                this.nuR.setVisibility(8);
                this.nuO.setImageResource(R.k.dzU);
                this.fCi.aHf();
                requestLayout();
            }
        }
        super.setVisibility(i);
    }

    private void Zd() {
        this.nuR.onResume();
        this.nuR.setVisibility(0);
        LayoutParams layoutParams = this.nuR.getLayoutParams();
        if ((layoutParams != null && layoutParams.height <= 0) || (layoutParams != null && j.aF(getContext()) && this.nuU)) {
            layoutParams.height = j.aD(getContext());
            this.nuR.setLayoutParams(layoutParams);
            this.nuU = false;
        }
    }

    public final void aIK() {
        this.nuP.setFilters(new InputFilter[]{new LengthFilter(25)});
    }

    public final boolean a(com.tencent.mm.ui.widget.MMEditText.a aVar) {
        if (this.nuP == null) {
            return false;
        }
        this.nuP.wvo = aVar;
        return true;
    }

    public final void a(final a aVar) {
        this.nuQ.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ LuckyMoneyWishFooter nuX;

            public final void onClick(View view) {
                aVar.zO(this.nuX.nuP.getText().toString());
                this.nuX.nuP.setText("");
            }
        });
    }

    protected final void nx(int i) {
        super.nx(i);
        switch (i) {
            case -3:
                this.nuT = true;
                return;
            default:
                this.nuT = false;
                return;
        }
    }

    public final void aIL() {
        if (this.nuR != null) {
            w.i("MicroMsg.SnsCommentFooter", "commentfooter release");
            this.nuR.anN();
            this.nuR.destroy();
        }
    }

    private void fy(boolean z) {
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.a.aRm);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(getContext(), R.a.aRn);
        loadAnimation.setDuration(150);
        loadAnimation2.setDuration(150);
        if (this.nuQ != null) {
            if (z) {
                if (this.nuQ.getVisibility() != 8 && this.nuQ.getVisibility() != 4) {
                    this.nuQ.startAnimation(loadAnimation2);
                    this.nuQ.setVisibility(8);
                }
            } else if (this.nuQ.getVisibility() != 0 && this.nuQ.getVisibility() != 0) {
                this.nuQ.startAnimation(loadAnimation);
                this.nuQ.setVisibility(0);
            }
        }
    }

    protected final List<View> aIM() {
        List<View> arrayList = new ArrayList();
        arrayList.add(this.nuR);
        return arrayList;
    }
}
