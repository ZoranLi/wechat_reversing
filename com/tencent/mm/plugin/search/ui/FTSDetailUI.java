package com.tencent.mm.plugin.search.ui;

import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fts.d.a.a;
import com.tencent.mm.plugin.fts.d.e;
import com.tencent.mm.plugin.search.a.c;
import com.tencent.mm.sdk.platformtools.w;

public class FTSDetailUI extends FTSBaseUI {
    private int mcx;
    private int mde;
    private e pfM;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        c.aZl().aya();
        String stringExtra = getIntent().getStringExtra("detail_query");
        this.fRM = stringExtra;
        this.pfq.wiF.q(stringExtra, null);
        w.i("MicroMsg.FTS.FTSDetailUI", "onCreate query=%s, searchType=%d, kvScene=%d", new Object[]{this.fRM, Integer.valueOf(this.mde), Integer.valueOf(this.mcx)});
        aZp();
    }

    protected final void aZu() {
        this.mde = getIntent().getIntExtra("detail_type", 0);
        this.mcx = getIntent().getIntExtra("Search_Scene", 0);
    }

    protected final b a(c cVar) {
        if (this.pfM == null) {
            this.pfM = new e(cVar, this.mde, this.mcx);
        }
        return this.pfM;
    }

    public final void b(a aVar) {
    }

    protected final int getLayoutId() {
        return R.i.ddH;
    }

    protected void onDestroy() {
        this.pfM.finish();
        c.aZl().axX();
        super.onDestroy();
    }

    public final String getHint() {
        String mU = e.mU(this.mde);
        if (mU == null) {
            return getString(R.l.dIz);
        }
        return mU;
    }
}
