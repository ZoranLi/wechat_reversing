package com.tencent.mm.plugin.brandservice.ui;

import android.os.Bundle;
import android.view.Menu;
import com.tencent.mm.R;
import com.tencent.mm.ap.k;
import com.tencent.mm.plugin.brandservice.ui.base.BrandServiceSortView;
import com.tencent.mm.pluginsdk.ui.tools.p;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;

@a(3)
public class BrandServiceLocalSearchUI extends MMActivity implements BrandServiceSortView.a, p.a {
    private p kaB;
    private BrandServiceSortView kaC;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KC();
        ap.vd().a(new k(18), 0);
    }

    public final void OF() {
    }

    public final void OG() {
    }

    protected final void KC() {
        this.kaC = (BrandServiceSortView) findViewById(R.h.cFV);
        this.kaC.aet();
        this.kaC.kaz = getIntent().getBooleanExtra("is_return_result", false);
        this.kaC.aeu();
        this.kaC.cZ(false);
        this.kaC.L(false);
        this.kaC.kbY = this;
        this.kaB = new p();
        this.kaB.lK(true);
        this.kaB.a(this);
        this.kaB.sXA = false;
    }

    public final void OE() {
    }

    public final void OD() {
        finish();
    }

    public final void mR(String str) {
        w.i("MicroMsg.BrandServiceLocalSearchUI", "search biz, key word : %s", new Object[]{str});
        this.kaC.sc(str);
    }

    public final boolean mQ(String str) {
        aHf();
        return true;
    }

    public final void aej() {
        aHf();
    }

    public final void aek() {
    }

    protected void onPause() {
        super.onPause();
        this.kaB.cancel();
        this.kaB.clearFocus();
    }

    protected void onDestroy() {
        super.onDestroy();
        this.kaC.release();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        this.kaB.a(this, menu);
        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        this.kaB.a(this, menu);
        return true;
    }

    public final void a(boolean z, String[] strArr, long j, int i) {
    }

    protected final int getLayoutId() {
        return R.i.cWa;
    }

    public final boolean ael() {
        aHf();
        return false;
    }
}
