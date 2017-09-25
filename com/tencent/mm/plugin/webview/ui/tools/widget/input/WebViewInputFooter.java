package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.content.Context;
import android.text.Editable;
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
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText;

public final class WebViewInputFooter extends LinearLayout {
    private MMActivity fCi;
    private ImageButton juG;
    private boolean nuU = true;
    public c snS;
    public a snT;
    public b snU;
    private WebViewSmileyPanel snV;
    private View snW;
    private View snX;
    private View snY;
    MMEditText snZ;
    private LinearLayout soa;
    private boolean sob;
    private int soc = Integer.MAX_VALUE;
    private int state = 0;

    public interface a {
        boolean rl(String str);
    }

    public interface b {
        void azV();

        void azW();
    }

    public interface c {
        void xK(String str);
    }

    static /* synthetic */ void a(WebViewInputFooter webViewInputFooter, boolean z) {
        Animation loadAnimation = AnimationUtils.loadAnimation(webViewInputFooter.getContext(), R.a.aRm);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(webViewInputFooter.getContext(), R.a.aRn);
        loadAnimation.setDuration(150);
        loadAnimation2.setDuration(150);
        if (webViewInputFooter.snX != null && webViewInputFooter.snY != null) {
            if (z) {
                if (webViewInputFooter.snX.getVisibility() != 8 && webViewInputFooter.snX.getVisibility() != 4) {
                    webViewInputFooter.snY.startAnimation(loadAnimation);
                    webViewInputFooter.snY.setVisibility(0);
                    webViewInputFooter.snX.startAnimation(loadAnimation2);
                    webViewInputFooter.snX.setVisibility(8);
                } else {
                    return;
                }
            } else if (webViewInputFooter.snX.getVisibility() != 0 && webViewInputFooter.snX.getVisibility() != 0) {
                webViewInputFooter.snX.startAnimation(loadAnimation);
                webViewInputFooter.snX.setVisibility(0);
                webViewInputFooter.snY.startAnimation(loadAnimation2);
                webViewInputFooter.snY.setVisibility(8);
            } else {
                return;
            }
            webViewInputFooter.snY.getParent().requestLayout();
        }
    }

    public WebViewInputFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fCi = (MMActivity) context;
        ViewGroup viewGroup = (ViewGroup) View.inflate(this.fCi, R.i.cSq, this);
        this.soa = (LinearLayout) viewGroup.findViewById(R.h.cSo);
        this.snX = viewGroup.findViewById(R.h.cSs);
        this.snY = viewGroup.findViewById(R.h.cSr);
        this.snW = viewGroup.findViewById(R.h.cSt);
        this.snZ = (MMEditText) viewGroup.findViewById(R.h.cSp);
        this.juG = (ImageButton) viewGroup.findViewById(R.h.cSu);
        this.juG.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WebViewInputFooter sod;

            {
                this.sod = r1;
            }

            public final void onClick(View view) {
                if (this.sod.state == 0) {
                    this.sod.fCi.aHf();
                    if (!this.sod.sob) {
                        this.sod.snZ.requestFocus();
                    }
                    this.sod.byg();
                    this.sod.juG.setImageResource(R.k.dzV);
                    this.sod.state = 1;
                    this.sod.nuU = false;
                    return;
                }
                this.sod.nuU = false;
                this.sod.snZ.requestFocus();
                this.sod.fCi.aHj();
                this.sod.YD();
                this.sod.state = 0;
            }
        });
        this.snZ.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ WebViewInputFooter sod;

            {
                this.sod = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                this.sod.nuU = false;
                this.sod.snV.setVisibility(8);
                this.sod.juG.setImageResource(R.g.bef);
                this.sod.state = 0;
                return false;
            }
        });
        this.snV = new WebViewSmileyPanel(getContext());
        this.snV.setVisibility(8);
        this.snV.setBackgroundResource(R.g.bcX);
        this.snV.a(new com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewSmileyPanel.a(this) {
            final /* synthetic */ WebViewInputFooter sod;

            {
                this.sod = r1;
            }

            public final void append(String str) {
                try {
                    if (this.sod.sob) {
                        this.sod.snT.rl(str);
                    } else {
                        this.sod.snZ.Uz(str);
                    }
                } catch (Exception e) {
                    w.e("MicroMsg.WebViewInputFooter", "appendText, exp = %s", new Object[]{e});
                }
            }

            public final void Zh() {
                if (this.sod.sob && this.sod.snT != null) {
                    this.sod.snT.rl("[DELETE_EMOTION]");
                } else if (this.sod.snZ != null) {
                    MMEditText d = this.sod.snZ;
                    if (d.wvn != null) {
                        d.wvn.sendKeyEvent(new KeyEvent(0, 67));
                        d.wvn.sendKeyEvent(new KeyEvent(1, 67));
                        return;
                    }
                    d.dispatchKeyEvent(new KeyEvent(0, 67));
                    d.dispatchKeyEvent(new KeyEvent(1, 67));
                }
            }
        });
        ((LinearLayout) findViewById(R.h.czn)).addView(this.snV, -1, 0);
        this.snY.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WebViewInputFooter sod;

            {
                this.sod = r1;
            }

            public final void onClick(View view) {
                com.tencent.mm.ui.tools.a.c Ch = com.tencent.mm.ui.tools.a.c.d(this.sod.snZ).Ch(this.sod.soc);
                Ch.jtV = com.tencent.mm.ui.tools.h.a.wmF;
                Ch.wpp = true;
                Ch.a(new com.tencent.mm.ui.tools.a.c.a(this) {
                    final /* synthetic */ AnonymousClass4 soe;

                    {
                        this.soe = r1;
                    }

                    public final void ro(String str) {
                        if (this.soe.sod.snS != null) {
                            this.soe.sod.snS.xK(this.soe.sod.snZ.getText().toString());
                        }
                        WebViewInputFooter webViewInputFooter = this.soe.sod;
                        webViewInputFooter.snZ.clearComposingText();
                        webViewInputFooter.snZ.setText("");
                    }

                    public final void YN() {
                    }

                    public final void Yp() {
                        if (this.soe.sod.fCi != null) {
                            Toast.makeText(this.soe.sod.fCi, "exceed max-length", 0).show();
                        }
                    }
                });
            }
        });
        this.snZ.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ WebViewInputFooter sod;

            {
                this.sod = r1;
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                if (this.sod.snZ.getText() != null) {
                    this.sod.snZ.requestFocus();
                    boolean z = editable.length() > 0 && editable.toString().trim().length() > 0;
                    WebViewInputFooter.a(this.sod, z);
                }
            }
        });
    }

    private int byg() {
        if (this.snU != null) {
            this.snU.azV();
        }
        if (this.snZ != null) {
            this.fCi.cY(this.snZ);
        }
        this.snV.setVisibility(0);
        this.snV.bAh();
        LayoutParams layoutParams = this.snV.getLayoutParams();
        if (layoutParams != null && this.nuU) {
            layoutParams.height = j.aD(getContext());
            this.snV.setLayoutParams(layoutParams);
        }
        if (layoutParams != null) {
            return layoutParams.height;
        }
        return 0;
    }

    private void YD() {
        if (this.snU != null) {
            this.snU.azW();
        }
        this.snV.setVisibility(8);
        this.juG.setImageResource(R.k.dzU);
        this.state = 0;
    }

    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bAa();
        if (!(this.snZ == null || this.fCi == null)) {
            this.fCi.cY(this.snZ);
        }
        this.snZ = null;
        this.snV.onDestroy();
        removeAllViews();
        this.fCi = null;
        this.snS = null;
    }

    public final void setText(String str) {
        this.snZ.setText("");
        if (!bg.mA(str)) {
            try {
                this.snZ.append(str);
            } catch (Exception e) {
                w.d("MicroMsg.WebViewInputFooter", "appendText, exp = %s", new Object[]{e});
            }
            w.d("MicroMsg.WebViewInputFooter", "after setText, editText.getText() = %s", new Object[]{this.snZ.getText()});
        }
    }

    public final void wJ(int i) {
        if (i > 0) {
            this.soc = i;
        }
    }

    private void bAa() {
        if (this.snZ != null) {
            this.snZ.clearFocus();
            this.snZ.setFocusable(false);
            this.snZ.setFocusableInTouchMode(false);
        }
    }

    public final void show() {
        setVisibility(0);
        if (this.soa != null) {
            this.soa.setVisibility(0);
        }
        if (this.snZ != null) {
            this.snZ.setEnabled(true);
            this.snZ.setBackgroundResource(R.g.bfV);
        }
        if (this.snW != null) {
            this.snW.setVisibility(0);
        }
        this.sob = false;
        if (this.snZ != null) {
            this.snZ.setFocusable(true);
            this.snZ.setFocusableInTouchMode(true);
            this.snZ.requestFocus();
        }
        if (this.fCi != null) {
            this.fCi.aHj();
        }
        this.state = 0;
    }

    public final int bAb() {
        setVisibility(0);
        if (this.soa != null) {
            this.soa.setVisibility(8);
        }
        this.sob = true;
        this.state = 1;
        return byg();
    }

    public final void hide() {
        setVisibility(8);
        if (this.fCi != null) {
            if (this.snZ != null) {
                this.fCi.cY(this.snZ);
            }
            this.fCi.aHf();
        }
        this.state = 0;
        YD();
        bAa();
    }

    public final void bAc() {
        if (this.sob) {
            setVisibility(8);
        }
        this.state = 0;
        YD();
    }

    public final boolean isShown() {
        return getVisibility() == 0;
    }
}
