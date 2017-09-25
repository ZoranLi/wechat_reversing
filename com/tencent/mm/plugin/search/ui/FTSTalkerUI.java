package com.tencent.mm.plugin.search.ui;

import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.u.n;
import com.tencent.mm.ui.fts.widget.FTSEditTextView;
import com.tencent.mm.ui.fts.widget.a.b;
import java.util.ArrayList;
import java.util.List;

public class FTSTalkerUI extends FTSBaseUI {
    private String fJL;
    private String fRM;
    private int mcx;
    private g pgp;

    private class a implements b {
        public String gMX;
        final /* synthetic */ FTSTalkerUI pgq;

        public a(FTSTalkerUI fTSTalkerUI) {
            this.pgq = fTSTalkerUI;
        }

        public final String getTagName() {
            return this.gMX;
        }

        public final int compareTo(Object obj) {
            return 0;
        }
    }

    protected final void aZu() {
        super.aZu();
        this.fJL = getIntent().getStringExtra("key_talker");
        this.fRM = getIntent().getStringExtra("key_query");
        this.mcx = getIntent().getIntExtra("Search_Scene", 0);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a aVar = new a(this);
        aVar.gMX = n.eK(this.fJL);
        List arrayList = new ArrayList();
        arrayList.add(aVar);
        String str = this.fRM;
        this.fRM = str;
        this.pfq.wiF.q(str, arrayList);
        aZp();
    }

    protected final int getLayoutId() {
        return R.i.ddH;
    }

    protected void onDestroy() {
        this.pgp.finish();
        super.onDestroy();
    }

    protected final b a(c cVar) {
        if (this.pgp == null) {
            this.pgp = new g(cVar, this.fJL, this.mcx);
        }
        return this.pgp;
    }

    public final boolean WV() {
        return false;
    }

    public final String getHint() {
        return getString(R.l.eQj);
    }

    public final void a(String str, String str2, List<b> list, FTSEditTextView.b bVar) {
        super.a(str2, str2, list, bVar);
    }
}
