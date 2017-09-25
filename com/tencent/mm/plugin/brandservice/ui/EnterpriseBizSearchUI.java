package com.tencent.mm.plugin.brandservice.ui;

import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListView.b;
import com.tencent.mm.pluginsdk.ui.tools.p;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;

@a(3)
public class EnterpriseBizSearchUI extends MMActivity implements b, p.a {
    private p kaB;
    private EnterpriseBizContactListView kaG;
    private String kbi;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KC();
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.kaG != null) {
            EnterpriseBizContactListView.release();
        }
    }

    public final void OF() {
    }

    public final void OG() {
    }

    protected final void KC() {
        if (bg.mA(this.kbi)) {
            this.kbi = getIntent().getStringExtra("enterprise_biz_name");
            if (bg.mA(this.kbi)) {
                finish();
            }
        }
        this.kaG = (EnterpriseBizContactListView) findViewById(R.h.cFV);
        this.kaG.kaE = this.kbi;
        this.kaG.kaL = true;
        this.kaG.refresh();
        this.kaG.aet();
        this.kaG.aem();
        this.kaG.aeu();
        this.kaG.cZ(false);
        this.kaG.kaO = this;
        ((TextView) this.kaG.aeo()).setText(R.l.eeS);
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
        w.i("MicroMsg.EnterpriseBizSearchUI", "search biz, key word : %s", new Object[]{str});
        this.kaG.sc(str);
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
        return R.i.dbg;
    }

    public final boolean ael() {
        aHf();
        return false;
    }
}
