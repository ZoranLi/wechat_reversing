package com.tencent.mm.plugin.favorite.ui.detail;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.e.a.bx;
import com.tencent.mm.e.a.lw;
import com.tencent.mm.e.a.ly;
import com.tencent.mm.plugin.favorite.b.j;
import com.tencent.mm.plugin.favorite.b.q;
import com.tencent.mm.plugin.favorite.b.r;
import com.tencent.mm.plugin.favorite.b.x;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.plugin.favorite.ui.FavImgGalleryUI;
import com.tencent.mm.plugin.favorite.ui.FavTagEditUI;
import com.tencent.mm.plugin.favorite.ui.base.FavDetailFooterView;
import com.tencent.mm.plugin.favorite.ui.base.FavDetailTitleView;
import com.tencent.mm.plugin.favorite.ui.base.FavTagEntrance;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.rm;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.sdk.platformtools.m;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.tools.l;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class FavoriteImgDetailUI extends MMActivity implements com.tencent.mm.plugin.favorite.b.b.a {
    private c lHl = new c<ly>(this) {
        final /* synthetic */ FavoriteImgDetailUI lLz;

        {
            this.lLz = r2;
            this.usg = ly.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            ly lyVar = (ly) bVar;
            String str = lyVar.fTe.filePath;
            a aVar = null;
            for (a aVar2 : this.lLz.lLv.values()) {
                a aVar22;
                if (!str.equals(x.g(aVar22.fKe))) {
                    aVar22 = aVar;
                }
                aVar = aVar22;
            }
            if (aVar != null) {
                aVar.lLH = bg.ap(lyVar.fTe.result, "");
                aVar.fFo = lyVar.fTe.fFo;
                aVar.fFp = lyVar.fTe.fFp;
                if (!bg.mA(aVar.lLH) && aVar.iLX.qJe.isShowing()) {
                    FavoriteImgDetailUI.a(this.lLz, aVar);
                }
            }
            return true;
        }
    };
    private OnClickListener lJz = new OnClickListener(this) {
        final /* synthetic */ FavoriteImgDetailUI lLz;

        {
            this.lLz = r1;
        }

        public final void onClick(View view) {
            Intent intent = new Intent(this.lLz.uSU.uTo, FavImgGalleryUI.class);
            intent.putExtra("key_detail_info_id", this.lLz.lLu.field_localId);
            intent.putExtra("key_detail_data_id", ((rm) view.getTag()).lKv);
            this.lLz.startActivity(intent);
        }
    };
    private LinearLayout lLp;
    private FavDetailTitleView lLq;
    private FavDetailFooterView lLr;
    private FavTagEntrance lLs;
    private int lLt = 0;
    private j lLu;
    private HashMap<String, a> lLv = new HashMap();
    private Bitmap lLw;
    private boolean lLx = true;
    private OnLongClickListener lLy = new OnLongClickListener(this) {
        final /* synthetic */ FavoriteImgDetailUI lLz;

        {
            this.lLz = r1;
        }

        public final boolean onLongClick(View view) {
            a aVar = (a) this.lLz.lLv.get(((rm) view.getTag()).lKv);
            FavoriteImgDetailUI.a(this.lLz, aVar);
            if (!aVar.lLG) {
                FavoriteImgDetailUI.b(aVar);
            }
            return true;
        }
    };

    private class a {
        int fFo = 0;
        int fFp = 0;
        rm fKe;
        ImageView fKf;
        l iLX = new l(this.lLz.uSU.uTo);
        boolean lLG = false;
        String lLH = null;
        final /* synthetic */ FavoriteImgDetailUI lLz;

        public a(FavoriteImgDetailUI favoriteImgDetailUI) {
            this.lLz = favoriteImgDetailUI;
        }
    }

    static /* synthetic */ void a(FavoriteImgDetailUI favoriteImgDetailUI, final a aVar) {
        l lVar = aVar.iLX;
        lVar.qJf = new n.c(favoriteImgDetailUI) {
            final /* synthetic */ FavoriteImgDetailUI lLz;

            public final void a(com.tencent.mm.ui.base.l lVar) {
                if (this.lLz.lLx) {
                    if (this.lLz.lLu.atg()) {
                        lVar.e(2, this.lLz.uSU.uTo.getString(R.l.ejs));
                    }
                    if (this.lLz.lLu.ath()) {
                        lVar.e(1, this.lLz.uSU.uTo.getString(R.l.eiU));
                    }
                    lVar.e(3, this.lLz.uSU.uTo.getString(R.l.ejn));
                    if (!bg.mA(aVar.lLH)) {
                        lVar.dX(4, com.tencent.mm.plugin.scanner.a.ak(aVar.fFo, aVar.lLH) ? R.l.eja : R.l.eiZ);
                    }
                }
            }
        };
        lVar.qJg = new d(favoriteImgDetailUI) {
            final /* synthetic */ FavoriteImgDetailUI lLz;

            public final void c(MenuItem menuItem, int i) {
                String g = x.g(aVar.fKe);
                if (e.aO(g)) {
                    switch (menuItem.getItemId()) {
                        case 1:
                            com.tencent.mm.plugin.favorite.c.c(g, this.lLz.uSU.uTo);
                            g.oUh.i(10651, new Object[]{Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0)});
                            return;
                        case 2:
                            if (o.Pj(g)) {
                                Intent intent = new Intent();
                                intent.putExtra("Select_Conv_Type", 3);
                                intent.putExtra("select_is_ret", true);
                                com.tencent.mm.bb.d.a(this.lLz, ".ui.transmit.SelectConversationUI", intent, 1);
                            } else {
                                com.tencent.mm.plugin.favorite.c.d(g, this.lLz.uSU.uTo);
                            }
                            g.oUh.i(10651, new Object[]{Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(0)});
                            return;
                        case 3:
                            com.tencent.mm.plugin.favorite.c.a(g, this.lLz.getString(R.l.ejm), this.lLz.uSU.uTo);
                            return;
                        case 4:
                            w.i("MicroMsg.FavoriteImgDetailUI", "request deal QBAR string");
                            b bxVar = new bx();
                            bxVar.fFn.activity = this.lLz;
                            bxVar.fFn.fDK = aVar.lLH;
                            bxVar.fFn.fFo = aVar.fFo;
                            bxVar.fFn.fFq = 7;
                            if (aVar.fKe != null) {
                                bxVar.fFn.imagePath = aVar.fKe.txi;
                                bxVar.fFn.fFt = aVar.fKe.txk;
                            }
                            bxVar.fFn.fFp = aVar.fFp;
                            Bundle bundle = new Bundle(1);
                            bundle.putInt("stat_scene", 5);
                            bxVar.fFn.fFu = bundle;
                            com.tencent.mm.sdk.b.a.urY.m(bxVar);
                            return;
                        default:
                            return;
                    }
                }
                w.w("MicroMsg.FavoriteImgDetailUI", "file not exists");
            }
        };
        lVar.blb();
    }

    static /* synthetic */ void a(FavoriteImgDetailUI favoriteImgDetailUI, a aVar, Bitmap bitmap) {
        int i = 0;
        if (bitmap == null) {
            bitmap = favoriteImgDetailUI.k(aVar.fKe);
        }
        if (bitmap != null) {
            w.d("MicroMsg.FavoriteImgDetailUI", "update view bmp[%d, %d], displayWidth %d", new Object[]{Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), Integer.valueOf(favoriteImgDetailUI.lLt)});
        }
        if (bitmap.getWidth() > favoriteImgDetailUI.lLt / 3) {
            LayoutParams layoutParams = aVar.fKf.getLayoutParams();
            layoutParams.height = (int) ((((float) favoriteImgDetailUI.lLt) / ((float) bitmap.getWidth())) * ((float) bitmap.getHeight()));
            if (layoutParams.height > 2048) {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                if (VERSION.SDK_INT >= 11) {
                    m mVar = new m();
                    if (width >= 2048 || height >= 2048) {
                        i = 1;
                    }
                }
                if (i != 0) {
                    layoutParams.height = 512;
                    aVar.fKf.setScaleType(ScaleType.CENTER_CROP);
                } else {
                    aVar.fKf.setScaleType(ScaleType.FIT_XY);
                }
            } else {
                aVar.fKf.setScaleType(ScaleType.FIT_XY);
            }
        } else {
            LayoutParams layoutParams2 = aVar.fKf.getLayoutParams();
            if (bitmap.getHeight() > 2048) {
                layoutParams2.height = 512;
                aVar.fKf.setScaleType(ScaleType.CENTER_CROP);
            } else {
                layoutParams2.height = bitmap.getHeight();
                aVar.fKf.setScaleType(ScaleType.CENTER_INSIDE);
            }
        }
        k.i(aVar.fKf, bitmap.getWidth(), bitmap.getHeight());
        String g = x.g(aVar.fKe);
        if (o.Pj(g)) {
            try {
                Drawable cr = com.tencent.mm.plugin.gif.b.aCV().cr(g + "_detail", g);
                aVar.fKf.setImageDrawable(cr);
                cr.stop();
                cr.start();
                return;
            } catch (Exception e) {
            }
        }
        aVar.fKf.setImageBitmap(bitmap);
    }

    static /* synthetic */ void b(a aVar) {
        b lwVar = new lw();
        lwVar.fTb.filePath = x.g(aVar.fKe);
        com.tencent.mm.sdk.b.a.urY.m(lwVar);
        aVar.lLG = true;
    }

    protected final int getLayoutId() {
        return R.i.dcM;
    }

    public void onCreate(Bundle bundle) {
        com.tencent.mm.pluginsdk.e.f(this);
        super.onCreate(bundle);
        auF();
        this.lLp = (LinearLayout) findViewById(R.h.bOD);
        this.lLq = (FavDetailTitleView) findViewById(R.h.bOo);
        this.lLr = (FavDetailFooterView) findViewById(R.h.bOn);
        this.lLs = (FavTagEntrance) findViewById(R.h.bOT);
        this.lLu = h.ata().bT(getIntent().getLongExtra("key_detail_info_id", -1));
        if (this.lLu == null) {
            finish();
            return;
        }
        this.lLq.z(this.lLu);
        this.lLr.z(this.lLu);
        Iterator it = this.lLu.field_favProto.tzn.iterator();
        int i = 0;
        while (it.hasNext()) {
            rm rmVar = (rm) it.next();
            w.d("MicroMsg.FavoriteImgDetailUI", "index[%d], dataid[%s]", new Object[]{Integer.valueOf(i), rmVar.lKv});
            a aVar = new a(this);
            aVar.fKe = rmVar;
            int i2 = i + 1;
            View imageView = new ImageView(this.uSU.uTo);
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.f.aXR);
            LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            if (i > 0) {
                layoutParams.topMargin = dimensionPixelSize;
            }
            this.lLp.addView(imageView, layoutParams);
            imageView.setTag(rmVar);
            i = dimensionPixelSize / 2;
            imageView.setScaleType(ScaleType.CENTER_INSIDE);
            imageView.setPadding(i, i, i, i);
            imageView.setMinimumWidth(com.tencent.mm.bg.a.fromDPToPix(this.uSU.uTo, 50));
            imageView.setMinimumHeight(com.tencent.mm.bg.a.fromDPToPix(this.uSU.uTo, 50));
            imageView.setImageResource(R.k.dwW);
            imageView.setOnClickListener(this.lJz);
            imageView.setOnLongClickListener(this.lLy);
            aVar.fKf = imageView;
            this.lLv.put(rmVar.lKv, aVar);
            a(aVar);
            if (rmVar.tyq != 0) {
                this.lLx = false;
            }
            i = i2;
        }
        this.lLs.ck(this.lLu.field_localId);
        this.lLs.ax(this.lLu.field_tagProto.tzx);
        qP(getString(R.l.ehE));
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ FavoriteImgDetailUI lLz;

            {
                this.lLz = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.lLz.finish();
                return true;
            }
        });
        a(0, R.l.eYj, R.k.dsS, new OnMenuItemClickListener(this) {
            final /* synthetic */ FavoriteImgDetailUI lLz;

            {
                this.lLz = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                com.tencent.mm.ui.widget.e eVar = new com.tencent.mm.ui.widget.e(this.lLz.uSU.uTo, com.tencent.mm.ui.widget.e.wuP, false);
                eVar.qJf = new n.c(this) {
                    final /* synthetic */ AnonymousClass2 lLA;

                    {
                        this.lLA = r1;
                    }

                    public final void a(com.tencent.mm.ui.base.l lVar) {
                        if (this.lLA.lLz.lLx) {
                            lVar.e(2, this.lLA.lLz.getString(R.l.ejs));
                        }
                        lVar.e(0, this.lLA.lLz.getString(R.l.ehS));
                        lVar.e(1, this.lLA.lLz.uSU.uTo.getString(R.l.dGB));
                    }
                };
                eVar.qJg = new d(this) {
                    final /* synthetic */ AnonymousClass2 lLA;

                    {
                        this.lLA = r1;
                    }

                    public final void c(MenuItem menuItem, int i) {
                        Intent intent;
                        switch (menuItem.getItemId()) {
                            case 0:
                                intent = new Intent(this.lLA.lLz.uSU.uTo, FavTagEditUI.class);
                                intent.putExtra("key_fav_scene", 2);
                                intent.putExtra("key_fav_item_id", this.lLA.lLz.lLu.field_localId);
                                this.lLA.lLz.uSU.uTo.startActivity(intent);
                                return;
                            case 1:
                                com.tencent.mm.ui.base.g.a(this.lLA.lLz.uSU.uTo, this.lLA.lLz.getString(R.l.dGC), "", new DialogInterface.OnClickListener(this) {
                                    final /* synthetic */ AnonymousClass2 lLB;

                                    {
                                        this.lLB = r1;
                                    }

                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        final p a = com.tencent.mm.ui.base.g.a(this.lLB.lLA.lLz.uSU.uTo, this.lLB.lLA.lLz.getString(R.l.dGC), false, null);
                                        x.a(this.lLB.lLA.lLz.lLu.field_localId, new Runnable(this) {
                                            final /* synthetic */ AnonymousClass1 lLC;

                                            public final void run() {
                                                a.dismiss();
                                                w.d("MicroMsg.FavoriteImgDetailUI", "do del, local id %d", new Object[]{Long.valueOf(this.lLC.lLB.lLA.lLz.lLu.field_localId)});
                                                this.lLC.lLB.lLA.lLz.finish();
                                            }
                                        });
                                    }
                                }, null);
                                return;
                            case 2:
                                intent = new Intent();
                                intent.putExtra("Select_Conv_Type", 3);
                                intent.putExtra("scene_from", 1);
                                intent.putExtra("mutil_select_is_ret", true);
                                intent.putExtra("select_fav_local_id", this.lLA.lLz.lLu.field_localId);
                                com.tencent.mm.bb.d.a(this.lLA.lLz, ".ui.transmit.SelectConversationUI", intent, 1);
                                g.oUh.i(10651, new Object[]{Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(0)});
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
        com.tencent.mm.pluginsdk.e.g(this);
        h.ata().c(this.lLs);
        h.asV().a((com.tencent.mm.plugin.favorite.b.b.a) this);
        com.tencent.mm.sdk.b.a.urY.b(this.lHl);
    }

    protected void onResume() {
        super.onResume();
        for (Entry value : this.lLv.entrySet()) {
            a((a) value.getValue());
        }
    }

    protected void onDestroy() {
        h.ata().f(this.lLs);
        h.asV().b((com.tencent.mm.plugin.favorite.b.b.a) this);
        com.tencent.mm.sdk.b.a.urY.c(this.lHl);
        super.onDestroy();
    }

    private void auF() {
        DisplayMetrics displayMetrics;
        if (ab.getResources() != null) {
            displayMetrics = ab.getResources().getDisplayMetrics();
        } else {
            displayMetrics = getResources().getDisplayMetrics();
        }
        this.lLt = displayMetrics.widthPixels - (getResources().getDimensionPixelOffset(R.f.aXi) * 2);
        this.lLt = Math.max(this.lLt, 0);
        w.d("MicroMsg.FavoriteImgDetailUI", "update display width %d", new Object[]{Integer.valueOf(this.lLt)});
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        auF();
        for (Entry value : this.lLv.entrySet()) {
            a((a) value.getValue());
        }
    }

    private void a(final a aVar) {
        ap.vL().D(new Runnable(this) {
            final /* synthetic */ FavoriteImgDetailUI lLz;

            public final void run() {
                Bitmap a = com.tencent.mm.plugin.favorite.c.g.a(aVar.fKe, this.lLz.lLu, false);
                if (a == null) {
                    w.d("MicroMsg.FavoriteImgDetailUI", "get big img fail");
                    a = this.lLz.k(aVar.fKe);
                }
                af.v(new Runnable(this) {
                    final /* synthetic */ AnonymousClass3 lLF;

                    public final void run() {
                        FavoriteImgDetailUI.a(this.lLF.lLz, aVar, a);
                    }

                    public final String toString() {
                        return super.toString() + "|renderView";
                    }
                });
            }
        });
    }

    private Bitmap k(rm rmVar) {
        boolean z = true;
        Bitmap a = com.tencent.mm.plugin.favorite.c.g.a(rmVar, this.lLu);
        String str = "MicroMsg.FavoriteImgDetailUI";
        String str2 = "get thumb ok ? %B";
        Object[] objArr = new Object[1];
        if (a == null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        w.d(str, str2, objArr);
        if (a != null) {
            return a;
        }
        if (this.lLw == null) {
            this.lLw = com.tencent.mm.compatible.f.a.decodeResource(getResources(), R.k.dwW);
        }
        return this.lLw;
    }

    public final void b(com.tencent.mm.plugin.favorite.b.a aVar) {
        if (aVar != null && aVar.isFinished()) {
            w.d("MicroMsg.FavoriteImgDetailUI", "on cdn status change, dataid[%s]", new Object[]{aVar.field_dataId});
            a aVar2 = (a) this.lLv.get(aVar.field_dataId);
            if (aVar2 != null) {
                a(aVar2);
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (1 == i) {
            if (-1 == i2) {
                q qVar = new q();
                if (q.h(this.lLu)) {
                    com.tencent.mm.ui.base.g.bl(this.uSU.uTo, getString(R.l.dAL));
                    return;
                }
                String stringExtra = intent.getStringExtra("Select_Conv_User");
                String stringExtra2 = intent.getStringExtra("custom_send_text");
                w.d("MicroMsg.FavoriteImgDetailUI", "select %s for sending", new Object[]{stringExtra});
                final Dialog a = com.tencent.mm.ui.base.g.a(this.uSU.uTo, getString(R.l.eit), false, null);
                r.a(this.uSU.uTo, stringExtra, stringExtra2, this.lLu, new Runnable(this) {
                    final /* synthetic */ FavoriteImgDetailUI lLz;

                    public final void run() {
                        a.dismiss();
                        com.tencent.mm.ui.snackbar.a.e(this.lLz, this.lLz.getString(R.l.ekV));
                    }
                });
            } else {
                return;
            }
        }
        super.onActivityResult(i, i2, intent);
    }
}
