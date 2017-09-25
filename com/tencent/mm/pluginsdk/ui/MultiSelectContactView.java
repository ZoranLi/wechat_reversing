package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.n;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MultiSelectContactView extends LinearLayout {
    private LayoutInflater myo;
    private int padding;
    private View qlS;
    private List<View> sJA;
    boolean sJB;
    private HorizontalScrollView sJq;
    private LinearLayout sJr;
    private View sJs;
    public MMEditText sJt;
    private List<String> sJu;
    private Animation sJv;
    private int sJw;
    public a sJx;
    public b sJy;
    public c sJz;

    public interface a {
        void mK(String str);
    }

    public interface b {
        void zE(String str);
    }

    public interface c {
        void bEr();
    }

    static /* synthetic */ void d(MultiSelectContactView multiSelectContactView) {
        if (multiSelectContactView.sJr.getChildCount() != 0) {
            View childAt = multiSelectContactView.sJr.getChildAt(multiSelectContactView.sJr.getChildCount() - 1);
            if (multiSelectContactView.sJB) {
                multiSelectContactView.a(childAt, true, false);
                multiSelectContactView.sJB = false;
            } else {
                multiSelectContactView.sJB = true;
                multiSelectContactView.bEp();
                childAt.findViewById(R.h.mask).setVisibility(0);
            }
            multiSelectContactView.sJt.requestFocus();
        }
    }

    public MultiSelectContactView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.sJw = 0;
        this.padding = 0;
        this.sJB = false;
        this.padding = getResources().getDimensionPixelSize(R.f.aWA);
        this.myo = LayoutInflater.from(context);
        this.myo.inflate(R.i.djN, this, true);
        this.sJq = (HorizontalScrollView) findViewById(R.h.cmd);
        this.sJt = (MMEditText) findViewById(R.h.cmc);
        this.sJr = (LinearLayout) findViewById(R.h.cmb);
        this.sJs = findViewById(R.h.cme);
        this.sJu = new LinkedList();
        this.sJv = AnimationUtils.loadAnimation(context, R.a.aQX);
        com.tencent.mm.ui.tools.a.c.d(this.sJt).Ch(100).a(null);
        this.qlS = findViewById(R.h.czn);
        this.sJt.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ MultiSelectContactView sJC;

            {
                this.sJC = r1;
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.sJC.bEo();
                if (this.sJC.sJy != null) {
                    this.sJC.sJy.zE(charSequence.toString());
                }
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        this.sJt.setOnKeyListener(new OnKeyListener(this) {
            final /* synthetic */ MultiSelectContactView sJC;

            {
                this.sJC = r1;
            }

            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (i == 67 && keyEvent.getAction() == 0 && this.sJC.sJt.getSelectionStart() == 0 && this.sJC.sJt.getSelectionEnd() == 0) {
                    MultiSelectContactView.d(this.sJC);
                }
                return false;
            }
        });
        this.sJA = new ArrayList();
        this.sJt.clearFocus();
        this.sJt.setOnFocusChangeListener(new OnFocusChangeListener(this) {
            final /* synthetic */ MultiSelectContactView sJC;

            {
                this.sJC = r1;
            }

            public final void onFocusChange(View view, boolean z) {
                if (z) {
                    this.sJC.qlS.setBackgroundResource(R.g.bfV);
                    this.sJC.qlS.setPadding(this.sJC.padding, this.sJC.padding, this.sJC.padding, this.sJC.padding);
                } else {
                    this.sJC.qlS.setBackgroundResource(R.g.bfW);
                    this.sJC.qlS.setPadding(this.sJC.padding, this.sJC.padding, this.sJC.padding, this.sJC.padding);
                }
                if (this.sJC.sJz != null) {
                    this.sJC.sJz.bEr();
                }
            }
        });
        setBackgroundColor(-201326593);
        setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MultiSelectContactView sJC;

            {
                this.sJC = r1;
            }

            public final void onClick(View view) {
            }
        });
    }

    public void clearFocus() {
        this.sJt.clearFocus();
        bEo();
    }

    public final void MF(String str) {
        if (!bg.mA(str)) {
            if (this.sJu.contains(str)) {
                w.i("MicroMsg.MultiSeclectContactView", "fixed user cant change");
                return;
            }
            bEo();
            View MH = MH(str);
            if (MH != null) {
                a(MH, false, false);
            } else {
                aK(str, true);
            }
        }
    }

    public final void MG(String str) {
        View MH = MH(str);
        if (MH != null) {
            a(MH, false, false);
        }
    }

    private void bEo() {
        if (this.sJr.getChildCount() != 0 && this.sJB) {
            View childAt = this.sJr.getChildAt(this.sJr.getChildCount() - 1);
            this.sJB = false;
            childAt.findViewById(R.h.mask).setVisibility(8);
        }
    }

    public final void aK(String str, boolean z) {
        xl(this.sJr.getChildCount() + 1);
        View inflate = this.myo.inflate(R.i.dnv, null, true);
        ImageView imageView = (ImageView) inflate.findViewById(R.h.bqG);
        com.tencent.mm.pluginsdk.ui.a.b.a(imageView, str);
        imageView.setContentDescription(n.eK(str));
        inflate.setTag(str);
        inflate.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MultiSelectContactView sJC;

            {
                this.sJC = r1;
            }

            public final void onClick(View view) {
                this.sJC.a(view, true, true);
            }
        });
        if (z) {
            inflate.startAnimation(this.sJv);
        }
        this.sJr.addView(inflate);
        bEq();
        LayoutParams layoutParams = (LayoutParams) inflate.getLayoutParams();
        layoutParams.height = getResources().getDimensionPixelSize(R.f.aWL);
        layoutParams.width = getResources().getDimensionPixelSize(R.f.aWL);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(R.f.aWA);
        inflate.setLayoutParams(layoutParams);
        bEp();
    }

    private void a(final View view, boolean z, boolean z2) {
        if (z && this.sJx != null) {
            this.sJx.mK(view.getTag().toString());
        }
        if (z2) {
            Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.a.aQY);
            loadAnimation.setAnimationListener(new AnimationListener(this) {
                final /* synthetic */ MultiSelectContactView sJC;

                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationRepeat(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    view.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass6 sJD;

                        {
                            this.sJD = r1;
                        }

                        public final void run() {
                            this.sJD.sJC.sJr.removeView(view);
                            this.sJD.sJC.bEq();
                            this.sJD.sJC.xl(this.sJD.sJC.sJr.getChildCount());
                        }
                    });
                }
            });
            view.startAnimation(loadAnimation);
            return;
        }
        this.sJr.removeView(view);
        bEq();
        xl(this.sJr.getChildCount());
    }

    private void bEp() {
        this.sJr.post(new Runnable(this) {
            final /* synthetic */ MultiSelectContactView sJC;

            {
                this.sJC = r1;
            }

            public final void run() {
                this.sJC.sJq.scrollTo(this.sJC.sJr.getMeasuredWidth(), 0);
            }
        });
    }

    private void xl(int i) {
        if (this.sJw <= 0) {
            this.sJw += getResources().getDimensionPixelSize(R.f.aXu);
            int a = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(getContext(), 40.0f);
            int measureText = (int) this.sJt.getPaint().measureText(getContext().getString(R.l.dIz));
            this.sJw = Math.max(a, measureText) + this.sJw;
        }
        if (this.sJw > 0) {
            measureText = this.qlS.getWidth();
            w.v("MicroMsg.MultiSeclectContactView", "parentWidth:%d, avatarWidth:%d, minInputAreaWidth:%d", Integer.valueOf(measureText), Integer.valueOf(i * (getResources().getDimensionPixelSize(R.f.aWL) + getResources().getDimensionPixelSize(R.f.aWA))), Integer.valueOf(this.sJw));
            LayoutParams layoutParams = (LayoutParams) this.sJq.getLayoutParams();
            if (measureText - (i * (getResources().getDimensionPixelSize(R.f.aWL) + getResources().getDimensionPixelSize(R.f.aWA))) > this.sJw) {
                layoutParams.width = -2;
            } else {
                layoutParams.width = measureText - this.sJw;
            }
        }
    }

    private void bEq() {
        if (this.sJr.getChildCount() == 0) {
            this.sJs.setVisibility(0);
        } else {
            this.sJs.setVisibility(8);
        }
    }

    public final String bzZ() {
        return this.sJt.getText().toString();
    }

    private View MH(String str) {
        int childCount = this.sJr.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.sJr.getChildAt(i);
            if (str.equals(childAt.getTag())) {
                return childAt;
            }
        }
        return null;
    }
}
