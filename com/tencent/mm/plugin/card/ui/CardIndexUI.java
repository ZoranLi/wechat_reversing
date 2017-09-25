package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.a.b;
import com.tencent.mm.plugin.card.b.i;
import com.tencent.mm.plugin.card.base.CardBaseUI;
import com.tencent.mm.plugin.card.model.ad;
import com.tencent.mm.plugin.card.model.al;
import com.tencent.mm.plugin.card.model.f;
import com.tencent.mm.plugin.card.model.n.a;
import com.tencent.mm.plugin.card.model.x;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.q.c;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.k;

public class CardIndexUI extends CardBaseUI {
    private final String TAG = "MicroMsg.CardIndexUI";
    int fromScene = 0;
    private View knn;
    private TextView kno;
    private f knp;
    private TextView knq;
    private TextView knr;
    private ImageView kns;
    private LinearLayout knt;
    int knu = -1;
    private long mStartTime = 0;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        w.i("MicroMsg.CardIndexUI", "oncreate");
        this.mStartTime = System.currentTimeMillis();
        KC();
        ap.vd().a(984, this);
        al.afZ();
        b.kn(1);
        int i = al.age().kdx;
        if (c.uk().aC(262152, 266256) || i > 0) {
            g.oUh.i(11324, new Object[]{"CardPackageListView", Integer.valueOf(0), "", "", Integer.valueOf(1), Integer.valueOf(this.fromScene), "", Integer.valueOf(0), ""});
            return;
        }
        g.oUh.i(11324, new Object[]{"CardPackageListView", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(this.fromScene), "", Integer.valueOf(0), ""});
    }

    protected void onDestroy() {
        ap.vd().b(984, this);
        long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
        g.oUh.i(13219, new Object[]{"CardPackageListView", Integer.valueOf(this.fromScene), "", "", Long.valueOf(currentTimeMillis)});
        super.onDestroy();
    }

    protected final void KC() {
        if (getIntent() != null) {
            this.knu = getIntent().getIntExtra("key_card_type", -1);
        }
        super.KC();
    }

    protected final void aeA() {
        if (1 == this.knu) {
            zi(R.l.dRl);
        } else if (3 == this.knu) {
            zi(R.l.dSr);
        } else {
            zi(R.l.eSP);
        }
        this.knq = (TextView) findViewById(R.h.coj);
        this.knr = (TextView) findViewById(R.h.cok);
        this.kns = (ImageView) findViewById(R.h.coh);
        this.knn = findViewById(R.h.bwT);
        this.kno = (TextView) findViewById(R.h.bwU);
        this.knt = (LinearLayout) findViewById(R.h.coi);
        this.knn.setVisibility(8);
        this.knr.setVisibility(0);
        this.knq.setVisibility(0);
        this.kns.setVisibility(8);
        LayoutParams layoutParams = (LayoutParams) this.knt.getLayoutParams();
        layoutParams.topMargin = BackwardSupportUtil.b.a(this, 100.0f);
        this.knt.setLayoutParams(layoutParams);
        if (1 == this.knu) {
            this.knr.setText(getString(R.l.dRd));
            this.knq.setText(getString(R.l.dRc));
        } else if (3 == this.knu) {
            this.knr.setText(getString(R.l.dRh));
            this.knq.setText(getString(R.l.dRg));
        } else {
            this.knr.setText(getString(R.l.dRC));
            this.knq.setText(getString(R.l.dRK));
        }
        this.kno.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ CardIndexUI knv;

            {
                this.knv = r1;
            }

            public final void onClick(View view) {
                if (!TextUtils.isEmpty(this.knv.knp.keY)) {
                    com.tencent.mm.plugin.card.b.b.a(this.knv, this.knv.knp.keY, 0);
                }
            }
        });
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onStop() {
        super.onStop();
    }

    protected final int aeB() {
        if (1 == this.knu) {
            return a.kfD;
        }
        if (3 == this.knu) {
            return a.kfC;
        }
        return a.kfz;
    }

    public final void a(int i, int i2, String str, k kVar) {
        super.a(i, i2, str, kVar);
        if (i != 0 || i2 != 0) {
            return;
        }
        if (kVar instanceof x) {
            ap.yY();
            this.knp = i.sY((String) com.tencent.mm.u.c.vr().get(282885, ""));
            if (this.knp == null) {
                this.knp = new f();
            }
            if (!(this.knp == null || TextUtils.isEmpty(this.knp.keW))) {
                this.knq.setText(this.knp.keW);
            }
            if (this.knp == null || !this.knp.keZ) {
                this.knn.setVisibility(8);
                return;
            }
            this.kno.setText(this.knp.keX);
            if (TextUtils.isEmpty(this.knp.keX) || TextUtils.isEmpty(this.knp.keY)) {
                this.knn.setVisibility(8);
            } else {
                this.knn.setVisibility(0);
            }
        } else if ((kVar instanceof ad) && ((ad) kVar).kfW && (this.kcs instanceof c)) {
            ((c) this.kcs).ko(false);
            ((c) this.kcs).ko(true);
            ((c) this.kcs).OK();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }
}
