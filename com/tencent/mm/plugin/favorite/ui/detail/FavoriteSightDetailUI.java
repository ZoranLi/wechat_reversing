package com.tencent.mm.plugin.favorite.ui.detail;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.favorite.b.b.a;
import com.tencent.mm.plugin.favorite.b.q;
import com.tencent.mm.plugin.favorite.b.r;
import com.tencent.mm.plugin.favorite.b.v;
import com.tencent.mm.plugin.favorite.b.x;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.plugin.favorite.ui.FavTagEditUI;
import com.tencent.mm.plugin.favorite.ui.base.FavDetailFooterView;
import com.tencent.mm.plugin.favorite.ui.base.FavDetailTitleView;
import com.tencent.mm.plugin.favorite.ui.base.FavTagEntrance;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.protocal.c.rm;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

public class FavoriteSightDetailUI extends MMActivity implements a, j.a {
    private rm fKe;
    private q lIh = new q();
    private com.tencent.mm.plugin.favorite.b.j lIl;
    private boolean lKV = false;
    private ImageView lKn;
    private boolean lKs = false;
    private FavDetailTitleView lLI;
    private FavDetailFooterView lLJ;
    private FavTagEntrance lLK;
    private View lLL;
    private ImageView lLM;
    private MMPinProgressBtn lLN;
    private VideoPlayerTextureView lLO;
    private long lLP;
    private boolean lLQ = true;
    private boolean lLR = false;
    private boolean lLb = false;

    static /* synthetic */ void a(FavoriteSightDetailUI favoriteSightDetailUI, boolean z, Context context) {
        rm n = x.n(favoriteSightDetailUI.lIl);
        if (n == null) {
            w.e("MicroMsg.FavoriteSightDetailUI", "goPlayView, but dataitem is null , exit");
        } else if (n.tyi == null || (bg.mA(n.tyi.hjD) && bg.mA(n.tyi.hjH))) {
            r1 = new Intent(context, FavoriteVideoPlayUI.class);
            r1.putExtra("key_detail_fav_path", x.g(n));
            r1.putExtra("key_detail_fav_thumb_path", x.h(n));
            r1.putExtra("key_detail_fav_video_duration", n.duration);
            r1.putExtra("key_detail_statExtStr", n.fUY);
            r1.putExtra("key_detail_data_valid", z);
            context.startActivity(r1);
        } else {
            w.i("MicroMsg.FavoriteSightDetailUI", "it is ad sight.use sight play");
            r1 = new Intent(context, FavoriteFileDetailUI.class);
            r1.putExtra("key_detail_info_id", favoriteSightDetailUI.lIl.field_localId);
            r1.putExtra("key_detail_data_id", n.lKv);
            r1.putExtra("key_detail_can_delete", false);
            context.startActivity(r1);
        }
    }

    protected final int getLayoutId() {
        return R.i.dcN;
    }

    protected final int Ol() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        e.f(this);
        super.onCreate(bundle);
        this.lLP = getIntent().getLongExtra("key_detail_info_id", -1);
        this.lIl = h.ata().bT(this.lLP);
        if (this.lIl == null) {
            w.w("MicroMsg.FavoriteSightDetailUI", "id[%d] info is null, return", new Object[]{Long.valueOf(this.lLP)});
            finish();
            return;
        }
        v.j(this.lIl);
        this.fKe = x.n(this.lIl);
        this.lLI = (FavDetailTitleView) findViewById(R.h.bOo);
        this.lLJ = (FavDetailFooterView) findViewById(R.h.bOn);
        this.lLK = (FavTagEntrance) findViewById(R.h.bOT);
        this.lLM = (ImageView) findViewById(R.h.cGq);
        this.lLN = (MMPinProgressBtn) findViewById(R.h.cLY);
        this.lLL = findViewById(R.h.bCw);
        this.lLO = (VideoPlayerTextureView) findViewById(R.h.cMo);
        this.lKn = (ImageView) findViewById(R.h.cMj);
        this.lLK.ck(this.lIl.field_localId);
        this.lLK.ax(this.lIl.field_tagProto.tzx);
        this.lLI.z(this.lIl);
        this.lLJ.z(this.lIl);
        this.lLL.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FavoriteSightDetailUI lLS;

            {
                this.lLS = r1;
            }

            public final void onClick(View view) {
                if (!com.tencent.mm.n.a.aJ(view.getContext()) && !com.tencent.mm.n.a.aH(view.getContext())) {
                    w.i("MicroMsg.FavoriteSightDetailUI", "click item favid %d, localid %d, itemstatus %d", new Object[]{Integer.valueOf(this.lLS.lIl.field_id), Long.valueOf(this.lLS.lIl.field_localId), Integer.valueOf(this.lLS.lIl.field_itemStatus)});
                    if (this.lLS.lIl.isDone()) {
                        if (x.d(this.lLS.fKe)) {
                            v.a(v.a.EnterFullScreen, this.lLS.lIl);
                            FavoriteSightDetailUI.a(this.lLS, true, view.getContext());
                            return;
                        } else if (bg.mA(this.lLS.fKe.txi)) {
                            FavoriteSightDetailUI.a(this.lLS, false, view.getContext());
                            return;
                        } else {
                            w.w("MicroMsg.FavoriteSightDetailUI", "? info is done, source file not exist, cdn data url is not null");
                        }
                    } else if (this.lLS.lIl.atl()) {
                        if (bg.mA(this.lLS.fKe.txi)) {
                            FavoriteSightDetailUI.a(this.lLS, false, view.getContext());
                            return;
                        }
                    } else if (this.lLS.lIl.atk() || this.lLS.lIl.ati()) {
                        if (this.lLS.lLN.getVisibility() == 8) {
                            this.lLS.ej(false);
                            return;
                        }
                        return;
                    }
                    if (this.lLS.lIl.atj()) {
                        x.l(this.lLS.lIl);
                    } else {
                        x.m(this.lLS.lIl);
                    }
                    this.lLS.ej(false);
                }
            }
        });
        this.lLO.pvi = new f.a(this) {
            final /* synthetic */ FavoriteSightDetailUI lLS;

            {
                this.lLS = r1;
            }

            public final void Uc() {
                w.i("MicroMsg.FavoriteSightDetailUI", " onPrepared");
                this.lLS.lKs = this.lLS.lLO.start();
                af.v(new Runnable(this) {
                    final /* synthetic */ AnonymousClass2 lLT;

                    {
                        this.lLT = r1;
                    }

                    public final void run() {
                        this.lLT.lLS.lKn.setVisibility(8);
                    }
                });
            }

            public final void onError(int i, int i2) {
                w.e("MicroMsg.FavoriteSightDetailUI", "VideoPlay: on play video error what %d extra %d.", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                if (i == -1) {
                    this.lLS.lLO.stop();
                    if (com.tencent.mm.a.e.aO(x.g(this.lLS.fKe))) {
                        this.lLS.auG();
                    } else if (com.tencent.mm.a.e.aO(x.h(this.lLS.fKe))) {
                        this.lLS.lKn.setVisibility(0);
                    }
                } else if (this.lLS.lKs) {
                    oW();
                } else {
                    this.lLS.lLO.stop();
                    if (!this.lLS.lKV) {
                        this.lLS.lKV = true;
                        af.v(new Runnable(this) {
                            final /* synthetic */ AnonymousClass2 lLT;

                            {
                                this.lLT = r1;
                            }

                            public final void run() {
                                g.h(this.lLT.lLS.uSU.uTo, R.l.fak, R.l.dVf);
                            }
                        });
                    }
                }
            }

            public final void oW() {
                this.lLS.lLO.k(0.0d);
            }

            public final int bI(int i, int i2) {
                return 0;
            }

            public final void bp(int i, int i2) {
            }
        };
        qP(getString(R.l.ehE));
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ FavoriteSightDetailUI lLS;

            {
                this.lLS = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.lLS.finish();
                return true;
            }
        });
        a(0, R.l.eYj, R.g.bhb, new OnMenuItemClickListener(this) {
            final /* synthetic */ FavoriteSightDetailUI lLS;

            {
                this.lLS = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                com.tencent.mm.ui.widget.e eVar = new com.tencent.mm.ui.widget.e(this.lLS.uSU.uTo, com.tencent.mm.ui.widget.e.wuP, false);
                eVar.qJf = new c(this) {
                    final /* synthetic */ AnonymousClass4 lLU;

                    {
                        this.lLU = r1;
                    }

                    public final void a(l lVar) {
                        int i = (!this.lLU.lLS.lIl.atg() || this.lLU.lLS.lIh.g(this.lLU.lLS.lIl)) ? 0 : 1;
                        if (i != 0 && this.lLU.lLS.fKe.tyq == 0) {
                            lVar.e(0, this.lLU.lLS.getString(R.l.ejs));
                        }
                        lVar.e(3, this.lLU.lLS.getString(R.l.ehS));
                        lVar.e(2, this.lLU.lLS.uSU.uTo.getString(R.l.dGB));
                    }
                };
                eVar.qJg = new d(this) {
                    final /* synthetic */ AnonymousClass4 lLU;

                    {
                        this.lLU = r1;
                    }

                    public final void c(MenuItem menuItem, int i) {
                        Intent intent;
                        switch (menuItem.getItemId()) {
                            case 0:
                                com.tencent.mm.plugin.report.service.g.oUh.i(10651, new Object[]{Integer.valueOf(this.lLU.lLS.lIl.field_type), Integer.valueOf(1), Integer.valueOf(0)});
                                intent = new Intent();
                                intent.putExtra("Select_Conv_Type", 3);
                                intent.putExtra("scene_from", 1);
                                intent.putExtra("mutil_select_is_ret", true);
                                intent.putExtra("select_fav_local_id", this.lLU.lLS.lIl.field_localId);
                                com.tencent.mm.bb.d.a(this.lLU.lLS.uSU.uTo, ".ui.transmit.SelectConversationUI", intent, 1);
                                return;
                            case 2:
                                g.a(this.lLU.lLS.uSU.uTo, this.lLU.lLS.getString(R.l.dGC), "", new DialogInterface.OnClickListener(this) {
                                    final /* synthetic */ AnonymousClass2 lLV;

                                    {
                                        this.lLV = r1;
                                    }

                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        final p a = g.a(this.lLV.lLU.lLS.uSU.uTo, this.lLV.lLU.lLS.getString(R.l.dGC), false, null);
                                        x.a(this.lLV.lLU.lLS.lIl.field_localId, new Runnable(this) {
                                            final /* synthetic */ AnonymousClass1 lLW;

                                            public final void run() {
                                                a.dismiss();
                                                w.i("MicroMsg.FavoriteSightDetailUI", "do del fav file, local id %d, fav id %d", new Object[]{Long.valueOf(this.lLW.lLV.lLU.lLS.lIl.field_localId), Integer.valueOf(this.lLW.lLV.lLU.lLS.lIl.field_id)});
                                                this.lLW.lLV.lLU.lLS.finish();
                                            }
                                        });
                                    }
                                }, null);
                                return;
                            case 3:
                                intent = new Intent(this.lLU.lLS.uSU.uTo, FavTagEditUI.class);
                                intent.putExtra("key_fav_scene", 2);
                                intent.putExtra("key_fav_item_id", this.lLU.lLS.lIl.field_localId);
                                this.lLU.lLS.uSU.uTo.startActivity(intent);
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
        if (com.tencent.mm.a.e.aO(x.h(this.fKe))) {
            Bitmap a = com.tencent.mm.plugin.favorite.c.g.a(this.fKe, this.lIl);
            if (a != null) {
                int width = a.getWidth();
                int height = a.getHeight();
                if (!this.lLR) {
                    this.lLR = true;
                    DisplayMetrics displayMetrics = this.lLL.getResources().getDisplayMetrics();
                    float f = (displayMetrics.density * 36.0f) + 0.5f;
                    LayoutParams layoutParams = this.lLL.getLayoutParams();
                    if (layoutParams == null) {
                        w.e("MicroMsg.FavoriteSightDetailUI", "setViewResize, but params is null");
                    } else {
                        layoutParams.width = displayMetrics.widthPixels - ((int) f);
                        layoutParams.height = (height * layoutParams.width) / width;
                        this.lLL.setLayoutParams(layoutParams);
                    }
                }
                this.lKn.setImageBitmap(a);
                this.lKn.setVisibility(0);
            }
        } else if (!bg.mA(this.fKe.hhy)) {
            x.b(this.lIl, this.fKe, true);
        }
        ej(false);
        h.ata().c(this.lLK);
        h.ata().c(this);
        h.asV().a((a) this);
        e.g(this);
    }

    protected void onDestroy() {
        if (this.lLO != null) {
            this.lLO.pvi = null;
            this.lLO.stop();
        }
        if (this.lLK != null) {
            h.ata().f(this.lLK);
        }
        h.ata().f(this);
        h.asV().b((a) this);
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        if (this.lLO != null) {
            if (!this.lLQ) {
                auG();
            } else if (!this.lLO.isPlaying()) {
                this.lLO.start();
            }
            this.lLQ = false;
        }
    }

    protected void onPause() {
        if (this.lLO != null) {
            this.lLO.stop();
        }
        super.onPause();
    }

    private void ej(boolean z) {
        if (this.lIl.isDone()) {
            if (x.d(this.fKe)) {
                this.lLM.setVisibility(8);
                this.lLN.setVisibility(8);
                auG();
                return;
            } else if (bg.mA(this.fKe.txi)) {
                this.lLM.setImageResource(R.k.dzz);
            } else {
                w.w("MicroMsg.FavoriteSightDetailUI", "? info is done, source file not exist, cdn data url is not null");
                this.lLM.setImageResource(R.k.dzz);
            }
        } else if (this.lIl.atl()) {
            if (bg.mA(this.fKe.txi)) {
                this.lLM.setImageResource(R.k.dzz);
                if (z) {
                }
            } else {
                this.lLM.setImageResource(R.k.dzz);
                if (z) {
                    g.bl(this.uSU.uTo, getString(R.l.ebM));
                }
            }
        } else if (this.lIl.atj()) {
            this.lLM.setImageResource(R.k.dzz);
            if (z) {
                g.bl(this.uSU.uTo, getString(R.l.eZf));
            }
        } else if (this.lIl.atk() || this.lIl.ati()) {
            this.lLM.setVisibility(8);
            this.lLN.setVisibility(0);
            com.tencent.mm.plugin.favorite.b.a vN = h.asV().vN(this.fKe.lKv);
            if (vN != null) {
                this.lLN.setProgress((int) vN.getProgress());
            } else {
                this.lLN.setProgress(0);
            }
            this.lKn.setVisibility(0);
            return;
        } else {
            w.w("MicroMsg.FavoriteSightDetailUI", "other status, not done, downloading, uploading, downloadfail, uploadfail");
            this.lLM.setImageResource(R.k.dzz);
        }
        this.lLM.setVisibility(0);
        this.lLN.setVisibility(8);
        this.lKn.setVisibility(0);
    }

    public final void a(String str, com.tencent.mm.sdk.e.l lVar) {
        int i = 0;
        w.i("MicroMsg.FavoriteSightDetailUI", "on favitem change, notifyId:%s, curId:%d", new Object[]{str, Long.valueOf(this.lIl.field_localId)});
        com.tencent.mm.plugin.favorite.b.j bT = h.ata().bT(this.lIl.field_localId);
        if (bT == null) {
            w.w("MicroMsg.FavoriteSightDetailUI", "error, on notify change, cannot find info");
            finish();
            return;
        }
        this.lIl = bT;
        this.fKe = x.n(bT);
        com.tencent.mm.plugin.favorite.b.a vN = h.asV().vN(this.fKe.lKv);
        if (!(vN == null || this.lLb)) {
            if (vN.field_status == 4 && h.asV().vN(this.fKe.lKv).field_extFlag != 0) {
                x.a(this.lIl, this.fKe, true);
                this.lLb = true;
            }
            w.i("MicroMsg.FavoriteSightDetailUI", "FavoriteFileDetail download, check retry, return %B", new Object[]{Boolean.valueOf(this.lLb)});
            i = this.lLb;
        }
        if (i == 0) {
            af.v(new Runnable(this) {
                final /* synthetic */ FavoriteSightDetailUI lLS;

                {
                    this.lLS = r1;
                }

                public final void run() {
                    this.lLS.ej(true);
                }
            });
        }
    }

    public final void b(com.tencent.mm.plugin.favorite.b.a aVar) {
        if (aVar == null || aVar.field_dataId == null) {
            w.w("MicroMsg.FavoriteSightDetailUI", "on cdn status changed, item is null");
            return;
        }
        w.i("MicroMsg.FavoriteSightDetailUI", "on cdn status changed, dataID is %s, field id is %s,offset is %d, total is %d,cdn status is %d, cdn type is %d (send or recieve)", new Object[]{this.fKe.lKv, aVar.field_dataId, Integer.valueOf(aVar.field_offset), Integer.valueOf(aVar.field_totalLen), Integer.valueOf(aVar.field_status), Integer.valueOf(aVar.field_type)});
        if (aVar.field_offset > aVar.field_totalLen) {
            w.e("MicroMsg.FavoriteSightDetailUI", "on cdn status changed, cdn offset length > cdn total length, do cdnLengthError()");
            if (1 == aVar.field_type) {
                aVar.field_status = 2;
            } else {
                aVar.field_status = 4;
            }
            h.asV().a(aVar, new String[0]);
            if (aVar.field_type == 0) {
                com.tencent.mm.plugin.favorite.c.c.e(aVar);
            }
            if (aVar.field_type == 1) {
                com.tencent.mm.plugin.favorite.c.c.f(aVar);
            }
        }
        if (aVar.field_dataId.equals(this.fKe.lKv)) {
            final int progress = (int) aVar.getProgress();
            this.lLN.post(new Runnable(this) {
                final /* synthetic */ FavoriteSightDetailUI lLS;

                public final void run() {
                    this.lLS.lLN.setProgress(progress);
                }
            });
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1 && -1 == i2) {
            String str;
            String stringExtra = intent == null ? null : intent.getStringExtra("Select_Conv_User");
            if (intent == null) {
                str = null;
            } else {
                str = intent.getStringExtra("custom_send_text");
            }
            final Dialog a = g.a(this.uSU.uTo, getString(R.l.eit), false, null);
            r.a(this.uSU.uTo, stringExtra, str, this.lIl, new Runnable(this) {
                final /* synthetic */ FavoriteSightDetailUI lLS;

                public final void run() {
                    a.dismiss();
                }
            });
            boolean dH = o.dH(stringExtra);
            v.a(dH ? v.c.Chatroom : v.c.Chat, this.lIl, v.d.Samll, dH ? com.tencent.mm.u.j.eC(stringExtra) : 0);
            com.tencent.mm.ui.snackbar.a.e(this, getString(R.l.ekV));
            return;
        }
        super.onActivityResult(i, i2, intent);
    }

    private void auG() {
        String g = x.g(this.fKe);
        if (com.tencent.mm.a.e.aO(g)) {
            this.lLO.stop();
            this.lLO.bQ(true);
            this.lLO.setVideoPath(g);
        }
    }
}
