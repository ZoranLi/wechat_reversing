package com.tencent.mm.ui.chatting.gallery;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.k;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ah.n;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.chatting.b.a.b;
import com.tencent.mm.ui.chatting.b.a.c;
import com.tencent.mm.ui.chatting.c.e;

public class MediaHistoryGalleryUI extends MMActivity implements OnClickListener, b {
    private RecyclerView aak;
    private String kwJ;
    private TextView kwL;
    private ProgressDialog vPS;
    private long vPu;
    private boolean vQX = false;
    private View vRa;
    private View vRc;
    private View vRd;
    private View vRe;
    private View vRf;
    private com.tencent.mm.ui.chatting.b.a.a vTH;
    private TextView vTI;
    private boolean vTJ;
    private boolean vTK;
    private int vTL = -1;
    private boolean vTM;

    static /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] vTP = new int[c.bWB().length];

        static {
            try {
                vTP[c.vPP - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
        }
    }

    private static class a {
        public static com.tencent.mm.ui.chatting.b.a.a ae(Context context, int i) {
            switch (AnonymousClass6.vTP[i - 1]) {
                case 1:
                    return new e(context);
                default:
                    return null;
            }
        }
    }

    public void onCreate(Bundle bundle) {
        boolean z;
        com.tencent.mm.ui.chatting.b.a.a ae;
        super.onCreate(bundle);
        this.vQX = true;
        Intent intent = getIntent();
        if (intent.getIntExtra("kintent_intent_source", 0) == 1) {
            z = true;
        } else {
            z = false;
        }
        this.vTJ = z;
        this.kwJ = intent.getStringExtra("kintent_talker");
        this.vTL = intent.getIntExtra("kintent_image_index", -1);
        this.vTK = intent.getBooleanExtra("key_is_biz_chat", false);
        this.vPu = getIntent().getLongExtra("key_biz_chat_id", -1);
        switch (getIntent().getIntExtra("key_media_type", -1)) {
            case 1:
                ae = a.ae(this, c.vPP);
                break;
            default:
                ae = a.ae(this, c.vPP);
                break;
        }
        ae.a(this);
        KC();
        this.vTH.r(true, this.vTL);
    }

    protected void onResume() {
        super.onResume();
        this.vTH.onResume();
        if (this.vQX) {
            if (this.vTH.bWw()) {
                bWu();
            } else {
                bWv();
            }
        }
        this.vQX = false;
    }

    protected void onDestroy() {
        super.onDestroy();
        this.vTH.onDetach();
    }

    protected final void KC() {
        super.KC();
        this.vRa = findViewById(R.h.clg);
        this.vRd = findViewById(R.h.cJD);
        this.vRf = findViewById(R.h.bev);
        this.vRe = findViewById(R.h.czB);
        this.vRc = findViewById(R.h.bNZ);
        this.vRc.setTag(Integer.valueOf(1));
        this.vRd.setTag(Integer.valueOf(0));
        this.vRe.setTag(Integer.valueOf(3));
        this.vRf.setTag(Integer.valueOf(2));
        this.vRc.setOnClickListener(this);
        this.vRd.setOnClickListener(this);
        this.vRe.setOnClickListener(this);
        this.vRf.setOnClickListener(this);
        this.vTI = (TextView) findViewById(R.h.bom);
        this.kwL = (TextView) findViewById(R.h.cAT);
        this.aak = (RecyclerView) findViewById(R.h.bWn);
        this.aak.setBackgroundColor(getResources().getColor(R.e.aSI));
        findViewById(R.h.bGy).setBackgroundColor(getResources().getColor(R.e.aSI));
        this.aak.a(this.vTH.eW(this));
        this.aak.a(this.vTH.eX(this));
        this.aak.a(this.vTH.ak(this.kwJ, this.vPu));
        this.aak.Zl = true;
        this.aak.ZM = new k(this) {
            final /* synthetic */ MediaHistoryGalleryUI vTN;

            {
                this.vTN = r1;
            }

            public final void c(RecyclerView recyclerView, int i, int i2) {
                super.c(recyclerView, i, i2);
            }
        };
        this.aak.a(new k(this) {
            private Runnable mgt = new Runnable(this) {
                final /* synthetic */ AnonymousClass2 vTO;

                {
                    this.vTO = r1;
                }

                public final void run() {
                    this.vTO.vTN.vTI.startAnimation(AnimationUtils.loadAnimation(this.vTO.vTN.uSU.uTo, R.a.aQY));
                    this.vTO.vTN.vTI.setVisibility(8);
                }
            };
            final /* synthetic */ MediaHistoryGalleryUI vTN;

            {
                this.vTN = r2;
            }

            private void et(boolean z) {
                if (z) {
                    this.vTN.vTI.removeCallbacks(this.mgt);
                    if (this.vTN.vTI.getVisibility() != 0) {
                        this.vTN.vTI.clearAnimation();
                        Animation loadAnimation = AnimationUtils.loadAnimation(this.vTN.uSU.uTo, R.a.aQX);
                        this.vTN.vTI.setVisibility(0);
                        this.vTN.vTI.startAnimation(loadAnimation);
                        return;
                    }
                    return;
                }
                this.vTN.vTI.removeCallbacks(this.mgt);
                this.vTN.vTI.postDelayed(this.mgt, 256);
            }

            public final void c(RecyclerView recyclerView, int i, int i2) {
                super.c(recyclerView, i, i2);
                com.tencent.mm.ui.chatting.a.a aVar = (com.tencent.mm.ui.chatting.a.a) this.vTN.vTH.bWs();
                com.tencent.mm.ui.chatting.a.a.c Bf = aVar.Bf(((LinearLayoutManager) this.vTN.vTH.eW(this.vTN)).fa());
                if (Bf != null) {
                    this.vTN.vTI.setText(bg.ap(aVar.eO(Bf.hTv), ""));
                }
            }

            public final void e(RecyclerView recyclerView, int i) {
                if (1 == i) {
                    et(true);
                } else if (i == 0) {
                    et(false);
                }
                if (recyclerView.Zf instanceof LinearLayoutManager) {
                    if (((LinearLayoutManager) recyclerView.Zf).fa() == 0) {
                        this.vTN.vTH.r(false, -1);
                    }
                    n.GW().bi(i);
                }
            }
        });
        qP(this.vTH.Oh());
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ MediaHistoryGalleryUI vTN;

            {
                this.vTN = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.vTN.finish();
                return true;
            }
        });
    }

    protected final int getLayoutId() {
        return R.i.diq;
    }

    public final void lq(boolean z) {
        if (z) {
            j(true, null);
        } else {
            this.aak.fn().bc(0);
        }
    }

    public final void s(boolean z, int i) {
        w.i("MicroMsg.MediaHistoryGalleryUI", "[onDataLoaded] isFirst:%s addCount:%s mIntentPos:%s", Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(this.vTL));
        if (z) {
            j(false, null);
            this.aak.fn().aab.notifyChanged();
            if (this.vTL != -1) {
                this.aak.Zf.aX(this.vTL);
            } else {
                this.aak.Zf.aX(this.aak.fn().getItemCount() - 1);
            }
            if (i <= 0) {
                this.kwL.setVisibility(0);
                this.aak.setVisibility(8);
                this.kwL.setText(getString(R.l.dVi));
                return;
            }
            this.kwL.setVisibility(8);
            this.aak.setVisibility(0);
        } else if (i > 0) {
            this.aak.fn().bc(0);
            this.aak.fn().R(0, i);
        } else {
            this.aak.fn().bc(0);
        }
    }

    public final View getChildAt(int i) {
        return this.aak.getChildAt(i);
    }

    public final void Bi(int i) {
        qP(getString(R.l.eoc, new Object[]{Integer.valueOf(i)}));
        BJ(i);
    }

    public void onClick(View view) {
        this.vTH.Bh(((Integer) view.getTag()).intValue());
    }

    public void onBackPressed() {
        super.onBackPressed();
        w.i("MicroMsg.MediaHistoryGalleryUI", "[onBackPressed] ");
        if (this.vTM) {
            this.vTH.bWx();
        } else {
            finish();
        }
    }

    public final void bWu() {
        this.vTH.bWu();
        qP(getString(R.l.eoc, new Object[]{Integer.valueOf(this.vTH.bWt())}));
        this.vRa.setVisibility(0);
        this.vRa.startAnimation(AnimationUtils.loadAnimation(this, R.a.aRq));
        BJ(this.vTH.bWt());
        zn(0);
        a(0, getString(R.l.enx), new OnMenuItemClickListener(this) {
            final /* synthetic */ MediaHistoryGalleryUI vTN;

            {
                this.vTN = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.vTN.bWv();
                return true;
            }
        });
    }

    public final void bWv() {
        this.vTH.bWv();
        qP(this.vTH.Oh());
        this.vRa.setVisibility(8);
        this.vRa.startAnimation(AnimationUtils.loadAnimation(this, R.a.aRo));
        zn(0);
        a(0, getString(R.l.eny), new OnMenuItemClickListener(this) {
            final /* synthetic */ MediaHistoryGalleryUI vTN;

            {
                this.vTN = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.vTN.bWu();
                return true;
            }
        });
    }

    public final void bWy() {
        this.vTM = true;
        j(true, getString(R.l.esr));
    }

    public final void bWx() {
        bWv();
        this.vTM = false;
        j(false, "");
    }

    public final void bWz() {
        bWv();
        this.vTM = false;
        j(false, "");
        String substring = com.tencent.mm.compatible.util.e.gSz.substring(com.tencent.mm.compatible.util.e.gSz.indexOf("tencent/MicroMsg"));
        Toast.makeText(this, getString(R.l.dVj, new Object[]{substring}), 1).show();
    }

    public final void Bj(int i) {
        bWv();
        j(false, "");
        if (i == 0) {
            i = R.l.eoa;
        }
        if (this.vTM) {
            g.a((Context) this, i, R.l.dIO, true, null);
        }
        this.vTM = false;
    }

    public final boolean bWA() {
        return this.vTM;
    }

    private void BJ(int i) {
        if (!this.vTH.bWw() || i <= 0) {
            this.vRc.setEnabled(false);
            this.vRd.setEnabled(false);
            this.vRe.setEnabled(false);
            this.vRf.setEnabled(false);
            return;
        }
        this.vRc.setEnabled(true);
        this.vRd.setEnabled(true);
        this.vRe.setEnabled(true);
        this.vRf.setEnabled(true);
    }

    private void j(boolean z, String str) {
        w.i("MicroMsg.MediaHistoryGalleryUI", "[setProgress] isVisible:%s", Boolean.valueOf(z));
        if (z) {
            if (str == null) {
                str = getString(R.l.cbS);
            }
            this.vPS = p.b(this, str, true, 0, null);
        } else if (this.vPS != null && this.vPS.isShowing()) {
            this.vPS.dismiss();
            this.vPS = null;
        }
    }
}
