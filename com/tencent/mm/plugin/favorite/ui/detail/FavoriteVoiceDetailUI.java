package com.tencent.mm.plugin.favorite.ui.detail;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.favorite.b.j;
import com.tencent.mm.plugin.favorite.b.w;
import com.tencent.mm.plugin.favorite.b.x;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.plugin.favorite.ui.FavTagEditUI;
import com.tencent.mm.plugin.favorite.ui.base.FavDetailFooterView;
import com.tencent.mm.plugin.favorite.ui.base.FavDetailTitleView;
import com.tencent.mm.plugin.favorite.ui.base.FavTagEntrance;
import com.tencent.mm.plugin.favorite.ui.base.FavVoiceBaseView;
import com.tencent.mm.protocal.c.rm;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;

public class FavoriteVoiceDetailUI extends MMActivity implements a {
    private w lFN;
    private j lFt;
    private long lLP;
    private FavDetailTitleView lLq;
    private FavDetailFooterView lLr;
    private FavTagEntrance lLs;
    private FavVoiceBaseView lMu;

    protected final int getLayoutId() {
        return R.i.dcP;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        qP(getString(R.l.ehE));
        this.lLP = getIntent().getLongExtra("key_detail_info_id", -1);
        this.lFt = h.ata().bT(this.lLP);
        if (this.lFt == null) {
            com.tencent.mm.sdk.platformtools.w.w("MicroMsg.FavoriteDetailUI", "get fav item info error");
            finish();
        } else {
            this.lLq = (FavDetailTitleView) findViewById(R.h.bOo);
            this.lLq.z(this.lFt);
            this.lLr = (FavDetailFooterView) findViewById(R.h.bOn);
            this.lLr.z(this.lFt);
            this.lFN = new w();
            this.lMu = (FavVoiceBaseView) findViewById(R.h.cMZ);
            w.a aVar = this.lMu;
            aVar.lFN = this.lFN;
            aVar.lFN.a(aVar);
            rm n = x.n(this.lFt);
            String g = x.g(n);
            int wb = x.wb(n.txx);
            if (!e.aO(g)) {
                x.m(this.lFt);
            }
            this.lMu.A(g, wb, n.duration);
            this.lLs = (FavTagEntrance) findViewById(R.h.bOT);
            this.lLs.ck(this.lFt.field_localId);
            this.lLs.ax(this.lFt.field_tagProto.tzx);
            b(new OnMenuItemClickListener(this) {
                final /* synthetic */ FavoriteVoiceDetailUI lMv;

                {
                    this.lMv = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    this.lMv.finish();
                    return true;
                }
            });
            a(0, R.l.eYj, R.g.bhb, new OnMenuItemClickListener(this) {
                final /* synthetic */ FavoriteVoiceDetailUI lMv;

                {
                    this.lMv = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    com.tencent.mm.ui.widget.e eVar = new com.tencent.mm.ui.widget.e(this.lMv.uSU.uTo, com.tencent.mm.ui.widget.e.wuP, false);
                    eVar.qJf = new c(this) {
                        final /* synthetic */ AnonymousClass2 lMw;

                        {
                            this.lMw = r1;
                        }

                        public final void a(l lVar) {
                            lVar.e(0, this.lMw.lMv.getString(R.l.ehS));
                            lVar.e(1, this.lMw.lMv.uSU.uTo.getString(R.l.dGB));
                        }
                    };
                    eVar.qJg = new d(this) {
                        final /* synthetic */ AnonymousClass2 lMw;

                        {
                            this.lMw = r1;
                        }

                        public final void c(MenuItem menuItem, int i) {
                            switch (menuItem.getItemId()) {
                                case 0:
                                    Intent intent = new Intent(this.lMw.lMv.uSU.uTo, FavTagEditUI.class);
                                    intent.putExtra("key_fav_scene", 2);
                                    intent.putExtra("key_fav_item_id", this.lMw.lMv.lFt.field_localId);
                                    this.lMw.lMv.uSU.uTo.startActivity(intent);
                                    return;
                                case 1:
                                    g.a(this.lMw.lMv.uSU.uTo, this.lMw.lMv.getString(R.l.dGC), "", new OnClickListener(this) {
                                        final /* synthetic */ AnonymousClass2 lMx;

                                        {
                                            this.lMx = r1;
                                        }

                                        public final void onClick(DialogInterface dialogInterface, int i) {
                                            final p a = g.a(this.lMx.lMw.lMv.uSU.uTo, this.lMx.lMw.lMv.getString(R.l.dGC), false, null);
                                            final long j = this.lMx.lMw.lMv.lFt.field_localId;
                                            final long j2 = (long) this.lMx.lMw.lMv.lFt.field_id;
                                            x.a(this.lMx.lMw.lMv.lFt.field_localId, new Runnable(this) {
                                                final /* synthetic */ AnonymousClass1 lMA;

                                                public final void run() {
                                                    a.dismiss();
                                                    com.tencent.mm.sdk.platformtools.w.d("MicroMsg.FavoriteDetailUI", "do del fav voice, local id %d, fav id %d", new Object[]{Long.valueOf(j), Long.valueOf(j2)});
                                                    this.lMA.lMx.lMw.lMv.finish();
                                                }
                                            });
                                        }
                                    }, null);
                                    return;
                                default:
                                    return;
                            }
                        }
                    };
                    eVar.bzh();
                    return true;
                }
            });
        }
        h.ata().c(this);
        if (this.lLs != null) {
            h.ata().c(this.lLs);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        this.lMu.adL();
        this.lFN.destroy();
        h.ata().f(this);
        if (this.lLs != null) {
            h.ata().f(this.lLs);
        }
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
        this.lMu.atw();
        this.lFN.pause();
    }

    public final void a(String str, com.tencent.mm.sdk.e.l lVar) {
        this.lFt = h.ata().bT(this.lLP);
        if (this.lFt == null) {
            com.tencent.mm.sdk.platformtools.w.w("MicroMsg.FavoriteDetailUI", "on notify changed, get fav item info error");
            finish();
        } else if (this.lFt.field_itemStatus == 10 && lVar != null && lVar.uxr != null && this.lFt.field_favProto.tzn.size() > 0) {
            rm n = x.n(this.lFt);
            String g = x.g(n);
            int wb = x.wb(n.txx);
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.FavoriteDetailUI", "on notify changed, favVoiceView.updateInfo");
            this.lMu.A(g, wb, n.duration);
        }
    }
}
