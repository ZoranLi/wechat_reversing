package com.tencent.mm.plugin.brandservice.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.brandservice.ui.base.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.hv;
import com.tencent.mm.protocal.c.ia;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.ui.tools.p.b;
import java.util.LinkedList;
import java.util.List;

public class BizSearchDetailPageUI extends MMActivity implements b {
    private p jZI;
    private BizSearchResultItemContainer jZJ;
    private long jZK;
    private String jZL;
    private int jZM;
    private int jZN;
    private Runnable jZO = new Runnable(this) {
        final /* synthetic */ BizSearchDetailPageUI jZP;

        {
            this.jZP = r1;
        }

        public final void run() {
            this.jZP.jZJ.az(this.jZP.jZL, this.jZP.wa);
            this.jZP.wa = 0;
        }
    };
    private int wa;

    protected final int getLayoutId() {
        return R.i.cVN;
    }

    public final void OF() {
    }

    public final void OG() {
    }

    public void onCreate(Bundle bundle) {
        boolean z = true;
        super.onCreate(bundle);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ BizSearchDetailPageUI jZP;

            {
                this.jZP = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.jZP.finish();
                return true;
            }
        });
        Intent intent = getIntent();
        this.jZK = intent.getLongExtra("businessType", 0);
        boolean booleanExtra = intent.getBooleanExtra("showEditText", false);
        this.jZM = intent.getIntExtra("fromScene", 0);
        this.jZN = intent.getIntExtra("addContactScene", 35);
        String stringExtra = intent.getStringExtra("title");
        String stringExtra2 = intent.getStringExtra("keyword");
        boolean booleanExtra2 = intent.getBooleanExtra("showCatalog", false);
        this.wa = intent.getIntExtra("offset", 0);
        if (this.jZK == 0 || bg.mA(stringExtra2)) {
            w.e("MicroMsg.BrandService.BizSearchDetailPageUI", "businessType(%d) or queryStr is nil.", new Object[]{Long.valueOf(this.jZK)});
            finish();
            return;
        }
        byte[] byteArrayExtra = intent.getByteArrayExtra("result");
        if (byteArrayExtra != null) {
            try {
                hv hvVar = (hv) new hv().aD(byteArrayExtra);
                boolean z2 = hvVar != null;
                hv hvVar2 = hvVar;
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.BrandService.BizSearchDetailPageUI", e, "", new Object[0]);
                finish();
                return;
            }
        }
        z2 = false;
        hvVar2 = null;
        this.jZJ = (BizSearchResultItemContainer) findViewById(R.h.cAk);
        this.jZJ.a(new c(this));
        this.jZJ.d(this.jZK);
        this.jZJ.kao = 1;
        this.jZJ.cY(booleanExtra2);
        this.jZJ.kc(this.jZM);
        BizSearchResultItemContainer bizSearchResultItemContainer = this.jZJ;
        int i = this.jZN;
        bizSearchResultItemContainer.jZN = i;
        bizSearchResultItemContainer.kaf.kd(i);
        bizSearchResultItemContainer = this.jZJ;
        c.b anonymousClass3 = new c.b(this) {
            final /* synthetic */ BizSearchDetailPageUI jZP;

            {
                this.jZP = r1;
            }

            public final void a(c cVar, a aVar, int i, String str, int i2, int i3) {
                if (this.jZP.jZM == 1 && aVar.type == 5) {
                    ia iaVar = (ia) aVar.data;
                    if (iaVar.tmo == null || iaVar.tmo.tlW == null) {
                        w.e("MicroMsg.BrandService.BizSearchDetailPageUI", "bcdItem.ContactItem == null || bcdItem.ContactItem.ContactItem == null");
                        return;
                    }
                    hv kb = cVar.kb(i3);
                    String str2 = bg.mz(this.jZP.jZL) + "," + i + "," + bg.mz(str) + "," + i2 + "," + cVar.jZV + "," + (kb == null ? "" : kb.tmb + ",1");
                    g.oUh.A(10866, str2);
                    w.d("MicroMsg.BrandService.BizSearchDetailPageUI", "report : " + str2);
                    if ((iaVar.tmo.tlW.tMP & 8) > 0) {
                        g.oUh.A(10298, str + ",35");
                    }
                }
            }
        };
        if (bizSearchResultItemContainer.kaf != null) {
            bizSearchResultItemContainer.kaf.a(anonymousClass3);
        }
        if (booleanExtra) {
            this.jZI = new p();
            a(this.jZI);
            this.jZI.lK(false);
            this.jZI.clearFocus();
            this.jZI.Ug(stringExtra2);
            this.jZI.woe = this;
            this.jZJ.setOnTouchListener(new OnTouchListener(this) {
                final /* synthetic */ BizSearchDetailPageUI jZP;

                {
                    this.jZP = r1;
                }

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    if (this.jZP.jZI != null) {
                        this.jZP.jZI.clearFocus();
                    }
                    this.jZP.aHf();
                    return false;
                }
            });
        } else if (!bg.mA(stringExtra)) {
            qP(stringExtra);
        }
        if (z2) {
            bizSearchResultItemContainer = this.jZJ;
            int i2 = this.wa;
            bizSearchResultItemContainer.reset();
            if (hvVar2 == null) {
                w.e("MicroMsg.BrandService.BizSearchResultItemContainer", "setFirst page content failed, content is null.");
                return;
            }
            bizSearchResultItemContainer.kah.fDs = stringExtra2;
            bizSearchResultItemContainer.d(hvVar2.tlY);
            bizSearchResultItemContainer.kah.jZY = hvVar2.tlZ;
            bizSearchResultItemContainer.kam = i2;
            List linkedList = new LinkedList();
            linkedList.add(hvVar2);
            bizSearchResultItemContainer.kaf.c(stringExtra2, linkedList);
            bizSearchResultItemContainer.kah.offset = i2 + hvVar2.tll;
            c cVar = bizSearchResultItemContainer.kah;
            if (bizSearchResultItemContainer.kaf.isEmpty()) {
                z = false;
            }
            cVar.kav = z;
            return;
        }
        mR(stringExtra2);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        if (this.jZI != null) {
            this.jZI.a(this, menu);
        }
        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        if (this.jZI != null) {
            this.jZI.a(this, menu);
        }
        return true;
    }

    protected void onPause() {
        super.onPause();
        if (this.jZI != null) {
            this.jZI.clearFocus();
        }
    }

    public final boolean mQ(String str) {
        return false;
    }

    public final void mR(String str) {
        if (!bg.mA(str)) {
            String trim = str.trim();
            if (!trim.equals(this.jZL)) {
                af.I(this.jZO);
                this.jZL = trim;
                af.f(this.jZO, 400);
            }
        }
    }

    public final void OD() {
        finish();
    }

    public final void OE() {
    }
}
