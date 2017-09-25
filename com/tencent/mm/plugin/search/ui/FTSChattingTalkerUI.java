package com.tencent.mm.plugin.search.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.plugin.fts.d.a.a;
import com.tencent.mm.plugin.fts.d.g;
import com.tencent.mm.plugin.search.a.c;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.contact.u;

public class FTSChattingTalkerUI extends FTSBaseUI implements OnClickListener {
    private String fJL;
    private View pfA;
    private View pfB;
    private View pfC;
    private View pfD;
    private d pfE;
    private LinearLayout pfv;
    private LinearLayout pfw;
    private View pfx;
    private View pfy;
    private View pfz;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KC();
        g aZl = c.aZl();
        if (aZl != null) {
            aZl.aya();
        }
    }

    protected final void KC() {
        super.KC();
        this.pfD = findViewById(R.h.cAY);
        this.pfv = (LinearLayout) this.pfD.findViewById(R.h.bSj);
        this.pfw = (LinearLayout) this.pfD.findViewById(R.h.bSk);
        this.pfx = this.pfD.findViewById(R.h.cAq);
        this.pfy = this.pfD.findViewById(R.h.cAt);
        this.pfz = this.pfD.findViewById(R.h.cAs);
        this.pfA = this.pfD.findViewById(R.h.cAr);
        this.pfB = this.pfD.findViewById(R.h.cAv);
        this.pfC = this.pfD.findViewById(R.h.cAu);
        if (!o.dH(this.fJL)) {
            this.pfv.removeView(this.pfy);
            this.pfw.removeView(this.pfA);
            this.pfv.addView(this.pfA);
            this.pfw.addView(this.pfy);
            this.pfy.setVisibility(4);
            this.pfD.findViewById(R.h.bJF).setVisibility(8);
            this.pfD.findViewById(R.h.bJI).setVisibility(0);
            this.pfD.findViewById(R.h.bJH).setVisibility(8);
        }
        this.pfD.setVisibility(0);
        this.pfy.setOnClickListener(this);
        this.pfx.setOnClickListener(this);
        this.pfz.setOnClickListener(this);
        this.pfA.setOnClickListener(this);
        this.pfB.setOnClickListener(this);
        this.pfC.setOnClickListener(this);
    }

    protected final void aZu() {
        this.fJL = getIntent().getStringExtra("detail_username");
        w.i("MicroMsg.FTS.FTSChattingTalkerUI", "initSearchData talker=%s", new Object[]{this.fJL});
    }

    protected final b a(c cVar) {
        if (this.pfE == null) {
            this.pfE = new d(cVar, this.fJL);
        }
        return this.pfE;
    }

    public final void b(a aVar) {
        if (o.dH(this.fJL)) {
            u.h(this.fRM, 10, 5, aVar.position + 1);
        } else {
            u.h(this.fRM, 11, 5, aVar.position + 1);
        }
    }

    protected final void aZA() {
        super.aZA();
        this.pfD.setVisibility(0);
    }

    protected final void aZy() {
        super.aZy();
        this.pfD.setVisibility(8);
    }

    protected final void aZz() {
        super.aZz();
        this.pfD.setVisibility(8);
    }

    protected final void aZx() {
        super.aZx();
        this.pfD.setVisibility(8);
    }

    protected final int getLayoutId() {
        return R.i.ddH;
    }

    protected void onDestroy() {
        super.onDestroy();
        this.pfE.finish();
        g aZl = c.aZl();
        if (aZl != null) {
            aZl.axY();
        }
    }

    public void onClick(View view) {
        Intent intent;
        if (view.getId() == R.h.cAt) {
            w.i("MicroMsg.FTS.FTSChattingTalkerUI", "onSearchMemberDetail");
            intent = new Intent();
            intent.putExtra("frome_scene", 1);
            intent.putExtra("RoomInfo_Id", this.fJL);
            intent.putExtra("title", getResources().getString(R.l.eQl));
            d.b(this, "chatroom", ".ui.SelectMemberUI", intent);
        } else if (view.getId() == R.h.cAq) {
            w.i("MicroMsg.FTS.FTSChattingTalkerUI", "onSearchDateDetail");
            intent = new Intent();
            intent.putExtra("detail_username", this.fJL);
            d.b(this, "chatroom", ".ui.SelectDateUI", intent);
        } else if (view.getId() == R.h.cAs) {
            w.i("MicroMsg.FTS.FTSChattingTalkerUI", "onSeeImageVideoHistory");
            intent = new Intent();
            intent.putExtra("kintent_talker", this.fJL);
            intent.putExtra("key_media_type", 1);
            d.a(this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryGalleryUI", intent);
        } else if (view.getId() == R.h.cAr) {
            w.i("MicroMsg.FTS.FTSChattingTalkerUI", "onSeeFileHistory");
            intent = new Intent();
            intent.putExtra("kintent_talker", this.fJL);
            intent.putExtra("key_media_type", 2);
            d.a(this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryListUI", intent);
        } else if (view.getId() == R.h.cAv) {
            w.i("MicroMsg.FTS.FTSChattingTalkerUI", "onSeeUrlHistory");
            intent = new Intent();
            intent.putExtra("kintent_talker", this.fJL);
            intent.putExtra("key_media_type", 3);
            d.a(this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryListUI", intent);
        } else if (view.getId() == R.h.cAu) {
            w.i("MicroMsg.FTS.FTSChattingTalkerUI", "onSeeUrlHistory");
            intent = new Intent();
            intent.putExtra("kintent_talker", this.fJL);
            intent.putExtra("key_media_type", 4);
            d.a(this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryListUI", intent);
        }
    }
}
