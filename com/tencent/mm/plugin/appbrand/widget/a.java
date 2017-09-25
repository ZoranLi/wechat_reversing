package com.tencent.mm.plugin.appbrand.widget;

import android.animation.Animator;
import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.support.v4.b.b;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.ui.g;
import com.tencent.mm.ui.r;
import com.tencent.smtt.sdk.WebView;
import java.util.Iterator;

public final class a extends LinearLayout {
    public int CU;
    public View jpZ;
    public TextView jqa;
    public TextView jqb;
    private ImageView jqc;
    private View jqd;
    private View jqe;
    public ImageButton jqf;
    public AppBrandOptionButton jqg;
    private ProgressBar jqh;
    private h jqi;
    public int jqj;
    private boolean jqk = false;
    public OnClickListener jql = null;
    public OnClickListener jqm = null;
    private long jqn = 0;

    class AnonymousClass2 implements OnClickListener {
        final /* synthetic */ a jqo;
        final /* synthetic */ OnClickListener jqp;

        public AnonymousClass2(a aVar, OnClickListener onClickListener) {
            this.jqo = aVar;
            this.jqp = onClickListener;
        }

        public final void onClick(View view) {
            if (System.currentTimeMillis() - this.jqo.jqn < 250) {
                this.jqp.onClick(view);
                this.jqo.jqn = 0;
            }
            this.jqo.jqn = System.currentTimeMillis();
        }
    }

    static /* synthetic */ void a(a aVar) {
        if (aVar.jqk) {
            if (aVar.jql != null) {
                aVar.jql.onClick(aVar.jqd);
            }
        } else if (aVar.jqm != null) {
            aVar.jqm.onClick(aVar.jqd);
        }
    }

    public a(Context context) {
        super(context);
        setLayoutParams(new LayoutParams(-1, b.bG(getContext())));
        setGravity(19);
        setBackgroundResource(R.e.aSB);
        addView(r.eC(getContext()).inflate(R.i.cTQ, this, false));
        this.jqj = -1;
        this.CU = getResources().getColor(R.e.aSB);
        this.jpZ = findViewById(R.h.bnb);
        this.jqa = (TextView) findViewById(R.h.bnd);
        this.jqb = (TextView) findViewById(R.h.bne);
        this.jqc = (ImageView) findViewById(R.h.bmY);
        this.jqd = findViewById(R.h.bmX);
        this.jqe = findViewById(R.h.bmZ);
        this.jqf = (ImageButton) findViewById(R.h.bmV);
        this.jqg = (AppBrandOptionButton) findViewById(R.h.bna);
        this.jqh = (ProgressBar) findViewById(R.h.bmW);
        this.jqi = new h();
        this.jqd.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ a jqo;

            {
                this.jqo = r1;
            }

            public final void onClick(View view) {
                a.a(this.jqo);
            }
        });
    }

    public final void rg(String str) {
        this.jqa.setText(str);
    }

    public final void setBackgroundColor(int i) {
        this.CU = i;
        super.setBackgroundColor(i);
    }

    public final void cl(boolean z) {
        if (z) {
            this.jqg.setVisibility(0);
        } else {
            this.jqg.setVisibility(8);
        }
    }

    public final void cm(boolean z) {
        if (z) {
            this.jqf.setVisibility(0);
        } else {
            this.jqf.setVisibility(8);
        }
    }

    public final void rh(String str) {
        if ("white".equals(str)) {
            this.jqj = -1;
        } else if ("black".equals(str)) {
            this.jqj = WebView.NIGHT_MODE_COLOR;
        }
        Ye();
    }

    public final void Ye() {
        if (this.jqk) {
            this.jqc.setImageResource(R.k.dtA);
        } else {
            this.jqc.setImageResource(R.k.dtC);
        }
        this.jqc.setColorFilter(this.jqj, Mode.SRC_ATOP);
        this.jqe.setBackgroundColor(b.j(this.jqj, 77));
        this.jqa.setTextColor(this.jqj);
        this.jqb.setTextColor(this.jqj);
        this.jqf.setImageDrawable(g.c(getContext(), R.k.dtx, this.jqj));
        h hVar = this.jqi;
        hVar.mv = this.jqj;
        hVar.invalidateSelf();
        this.jqh.setLayerType(1, null);
        this.jqh.setIndeterminateDrawable(this.jqi);
        this.jqg.setColor(this.jqj);
    }

    public final void cn(boolean z) {
        this.jqk = z;
        Ye();
    }

    public final void co(boolean z) {
        this.jqd.setVisibility(z ? 8 : 0);
    }

    public final void cp(boolean z) {
        Object obj = null;
        this.jqh.setVisibility(z ? 0 : 8);
        Iterator it;
        if (z) {
            h hVar = this.jqi;
            hVar.mc.clear();
            hVar.mc.add(h.a(hVar.jrq));
            hVar.mc.add(h.a(hVar.jrr));
            h hVar2 = this.jqi;
            Iterator it2 = hVar2.mc.iterator();
            while (it2.hasNext()) {
                if (((Animator) it2.next()).isStarted()) {
                    obj = 1;
                    break;
                }
            }
            if (obj == null) {
                it = hVar2.mc.iterator();
                while (it.hasNext()) {
                    ((Animator) it.next()).start();
                }
                hVar2.invalidateSelf();
                return;
            }
            return;
        }
        it = this.jqi.mc.iterator();
        while (it.hasNext()) {
            ((Animator) it.next()).end();
        }
    }
}
