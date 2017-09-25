package com.tencent.mm.plugin.favorite.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageButton;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.e.a.ka;
import com.tencent.mm.e.a.kb;
import com.tencent.mm.plugin.favorite.b.j;
import com.tencent.mm.plugin.favorite.b.m;
import com.tencent.mm.plugin.favorite.b.q;
import com.tencent.mm.plugin.favorite.b.r;
import com.tencent.mm.plugin.favorite.b.v;
import com.tencent.mm.plugin.favorite.b.x;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.plugin.favorite.ui.base.b;
import com.tencent.mm.plugin.favorite.ui.base.c.a;
import com.tencent.mm.plugin.favorite.ui.c.a.c;
import com.tencent.mm.plugin.favorite.ui.post.FavPostVoiceUI;
import com.tencent.mm.protocal.c.rm;
import com.tencent.mm.protocal.c.rs;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FavoriteIndexUI extends FavBaseUI implements a, c {
    private d jWo = new d(this) {
        final /* synthetic */ FavoriteIndexUI lIF;

        {
            this.lIF = r1;
        }

        public final void c(MenuItem menuItem, int i) {
            switch (this.lIF.lIy) {
                case 0:
                    if (menuItem != null) {
                        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) menuItem.getMenuInfo();
                        switch (menuItem.getItemId()) {
                            case 0:
                                if (adapterContextMenuInfo.position >= this.lIF.lGA.getHeaderViewsCount()) {
                                    w.i("MicroMsg.FavoriteIndexUI", "do delete, long click info is %s", new Object[]{Integer.valueOf(adapterContextMenuInfo.position)});
                                    x.a(this.lIF.lIz.mx((adapterContextMenuInfo.position - this.lIF.lGA.getHeaderViewsCount()) - 1), null);
                                    return;
                                }
                                return;
                            case 1:
                                this.lIF.startTime = bg.Ny();
                                w.i("MicroMsg.FavoriteIndexUI", "do edit, long click info is %s", new Object[]{Integer.valueOf(adapterContextMenuInfo.position)});
                                this.lIF.lIB = this.lIF.lIz.mx((adapterContextMenuInfo.position - this.lIF.lGA.getHeaderViewsCount()) - 1);
                                FavoriteIndexUI.b(this.lIF, this.lIF.lIB);
                                return;
                            case 2:
                                w.i("MicroMsg.FavoriteIndexUI", "do tag, long click info is %s", new Object[]{Integer.valueOf(adapterContextMenuInfo.position)});
                                j mx = this.lIF.lIz.mx((adapterContextMenuInfo.position - this.lIF.lGA.getHeaderViewsCount()) - 1);
                                Intent intent = new Intent(this.lIF.uSU.uTo, FavTagEditUI.class);
                                intent.putExtra("key_fav_scene", 4);
                                intent.putExtra("key_fav_item_id", mx.field_localId);
                                this.lIF.uSU.uTo.startActivity(intent);
                                return;
                            case 3:
                                this.lIF.startTime = bg.Ny();
                                w.i("MicroMsg.FavoriteIndexUI", "do transmit, long click info is %s", new Object[]{Integer.valueOf(adapterContextMenuInfo.position)});
                                this.lIF.lIE = this.lIF.lIz.mx((adapterContextMenuInfo.position - this.lIF.lGA.getHeaderViewsCount()) - 1);
                                this.lIF.lIE = this.lIF.lIE.ato();
                                if (this.lIF.lIE != null) {
                                    List linkedList = new LinkedList();
                                    linkedList.add(this.lIF.lIE);
                                    if (x.a(linkedList, this.lIF, new OnClickListener(this) {
                                        final /* synthetic */ AnonymousClass17 lIT;

                                        {
                                            this.lIT = r1;
                                        }

                                        public final void onClick(DialogInterface dialogInterface, int i) {
                                            FavoriteIndexUI.a(this.lIT.lIF, 4106);
                                        }
                                    })) {
                                        FavoriteIndexUI.a(this.lIF, 4106);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            default:
                                return;
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private l kmS;
    private b lIA;
    private j lIB;
    private e lIC = new e(this) {
        final /* synthetic */ FavoriteIndexUI lIF;

        {
            this.lIF = r1;
        }

        public final void a(int i, int i2, String str, k kVar) {
            w.i("MicroMsg.FavoriteIndexUI", "onUsedCapacityChanged");
            this.lIF.lGG.post(new Runnable(this) {
                final /* synthetic */ AnonymousClass9 lIS;

                {
                    this.lIS = r1;
                }

                public final void run() {
                    this.lIS.lIF.lGG.auw();
                }
            });
        }
    };
    private OnItemLongClickListener lID = new OnItemLongClickListener(this) {
        final /* synthetic */ FavoriteIndexUI lIF;

        {
            this.lIF = r1;
        }

        public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (i < this.lIF.lGA.getHeaderViewsCount()) {
                w.w("MicroMsg.FavoriteIndexUI", "on header view long click, ignore");
            } else {
                this.lIF.kmS.a(view, i, j, this.lIF, this.lIF.jWo);
            }
            return true;
        }
    };
    private j lIE;
    private int lIy = 0;
    private com.tencent.mm.plugin.favorite.ui.a.b lIz;
    private long startTime = 0;

    static /* synthetic */ void a(FavoriteIndexUI favoriteIndexUI, int i) {
        boolean z = false;
        if (i == 4105) {
            Intent intent = new Intent();
            intent.putExtra("Select_Conv_Type", 3);
            intent.putExtra("scene_from", 1);
            intent.putExtra("mutil_select_is_ret", true);
            if (favoriteIndexUI.lIz.aut() == 1) {
                intent.putExtra("select_fav_local_id", ((j) favoriteIndexUI.lIz.ee(false).get(0)).field_localId);
                if (favoriteIndexUI.lIz.ee(false).get(0) != null && ((j) favoriteIndexUI.lIz.ee(false).get(0)).field_type == 3) {
                    g.bl(favoriteIndexUI.getApplicationContext(), favoriteIndexUI.getString(R.l.ejl));
                    return;
                }
            }
            int i2;
            intent.putExtra("Retr_Msg_Type", 17);
            q qVar = new q();
            for (j g : favoriteIndexUI.lIz.ee(false)) {
                if (!qVar.g(g)) {
                    i2++;
                }
            }
            intent.putExtra("select_fav_select_count", i2);
            com.tencent.mm.bb.d.a(favoriteIndexUI, ".ui.transmit.SelectConversationUI", intent, 4105);
        } else if (i == 4106) {
            Intent intent2 = new Intent();
            intent2.putExtra("Select_Conv_Type", 3);
            intent2.putExtra("scene_from", 1);
            intent2.putExtra("mutil_select_is_ret", true);
            if (favoriteIndexUI.lIE != null) {
                intent2.putExtra("select_fav_local_id", favoriteIndexUI.lIE.field_localId);
            }
            if (favoriteIndexUI.lIE != null) {
                int i3 = favoriteIndexUI.lIE.field_type;
                if (i3 == 1) {
                    z = true;
                } else if (i3 != 2) {
                    z = i3 == 16 ? true : i3 == 4 ? true : i3 == 14 ? true : i3 == 6 ? true : true;
                }
                if (!z) {
                    intent2.putExtra("Retr_Msg_Type", favoriteIndexUI.lIE.field_type);
                }
            }
            com.tencent.mm.bb.d.a(favoriteIndexUI, ".ui.transmit.SelectConversationUI", intent2, 4106);
        }
    }

    static /* synthetic */ void a(FavoriteIndexUI favoriteIndexUI, final List list) {
        if (list != null && !list.isEmpty()) {
            final Dialog a = g.a(favoriteIndexUI.uSU.uTo, favoriteIndexUI.getString(R.l.ehD), false, null);
            ap.vL().D(new Runnable(favoriteIndexUI) {
                final /* synthetic */ FavoriteIndexUI lIF;

                public final void run() {
                    x.au(list);
                    af.v(new Runnable(this) {
                        final /* synthetic */ AnonymousClass3 lIH;

                        {
                            this.lIH = r1;
                        }

                        public final void run() {
                            a.dismiss();
                        }

                        public final String toString() {
                            return super.toString() + "|batchDelFavItems";
                        }
                    });
                }
            });
        }
    }

    static /* synthetic */ void b(FavoriteIndexUI favoriteIndexUI, j jVar) {
        favoriteIndexUI.lIz.a(true, jVar);
        favoriteIndexUI.lGA.setOnItemLongClickListener(null);
        favoriteIndexUI.af(11, false);
        b bVar = favoriteIndexUI.lIA;
        if (!bVar.lJB) {
            if (bVar.lJC != null) {
                if (bVar.lJC instanceof ViewStub) {
                    bVar.lJC = ((ViewStub) bVar.lJC).inflate();
                }
                bVar.lJF = (ImageButton) bVar.lJC.findViewById(R.h.bOs);
                bVar.lJF.setEnabled(false);
                bVar.lJF.setContentDescription(bVar.lJF.getContext().getString(R.l.eYz));
                bVar.lJF.setOnClickListener(new View.OnClickListener(bVar) {
                    final /* synthetic */ b lJJ;

                    {
                        this.lJJ = r1;
                    }

                    public final void onClick(View view) {
                        if (this.lJJ.lJI != null) {
                            this.lJJ.lJI.aul();
                        }
                    }
                });
                bVar.lJG = (ImageButton) bVar.lJC.findViewById(R.h.bOp);
                bVar.lJG.setEnabled(false);
                bVar.lJG.setContentDescription(bVar.lJG.getContext().getString(R.l.ebV));
                bVar.lJG.setOnClickListener(new View.OnClickListener(bVar) {
                    final /* synthetic */ b lJJ;

                    {
                        this.lJJ = r1;
                    }

                    public final void onClick(View view) {
                        if (this.lJJ.lJI != null) {
                            this.lJJ.lJI.aum();
                        }
                    }
                });
                bVar.lJH = (ImageButton) bVar.lJC.findViewById(R.h.bOq);
                bVar.lJH.setEnabled(false);
                bVar.lJH.setContentDescription(bVar.lJH.getContext().getString(R.l.ebs));
                bVar.lJH.setOnClickListener(new View.OnClickListener(bVar) {
                    final /* synthetic */ b lJJ;

                    {
                        this.lJJ = r1;
                    }

                    public final void onClick(View view) {
                        if (this.lJJ.lJI != null) {
                            this.lJJ.lJI.aud();
                        }
                    }
                });
                bVar.lJB = true;
            } else {
                return;
            }
        }
        if (bVar.lJC.getVisibility() != 0) {
            bVar.lJC.setVisibility(0);
            bVar.lJC.startAnimation(AnimationUtils.loadAnimation(bVar.lJC.getContext(), R.a.aQX));
        }
    }

    static /* synthetic */ void h(FavoriteIndexUI favoriteIndexUI) {
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.mm.sdk.b.b kaVar = new ka();
        if (com.tencent.mm.pluginsdk.model.c.sCd) {
            kaVar.fQo.field_localId = currentTimeMillis;
        } else {
            kaVar.fQo.field_localId = -1;
        }
        kaVar.fQo.context = favoriteIndexUI.uSU.uTo;
        kaVar.fQo.type = 9;
        com.tencent.mm.sdk.b.a.urY.m(kaVar);
        com.tencent.mm.sdk.b.b kbVar = new kb();
        kbVar.fQz.context = favoriteIndexUI.uSU.uTo;
        kbVar.fQz.type = 3;
        kbVar.fQz.fQv = 1;
        com.tencent.mm.sdk.b.a.urY.m(kbVar);
    }

    public void onCreate(Bundle bundle) {
        this.lGH = this;
        w.i("MicroMsg.FavoriteIndexUI", "onCreate favoriteindex");
        super.onCreate(bundle);
        if (h.ata().gUz == null) {
            w.e("MicroMsg.FavoriteIndexUI", "onCreate favoriteindex, but favorite db is null ,return");
            finish();
            return;
        }
        h.asU().dZ(false);
        zi(R.l.eiv);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ FavoriteIndexUI lIF;

            {
                this.lIF = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (this.lIF.lIz.lJc) {
                    this.lIF.auj();
                } else {
                    this.lIF.finish();
                }
                return true;
            }
        });
        this.lGA.setOnItemLongClickListener(this.lID);
        ap.vd().a(438, this.lIC);
        ap.vd().a(401, this.lIC);
        this.kmS = new l(this);
        a(11, R.l.dBO, R.k.dsI, new OnMenuItemClickListener(this) {
            final /* synthetic */ FavoriteIndexUI lIF;

            {
                this.lIF = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                FavoriteIndexUI.h(this.lIF);
                return true;
            }
        });
        this.lIA = new b();
        b bVar = this.lIA;
        View findViewById = findViewById(R.h.bOr);
        bVar.lJB = false;
        bVar.lJC = findViewById;
        this.lIA.lJI = new b.a(this) {
            final /* synthetic */ FavoriteIndexUI lIF;

            {
                this.lIF = r1;
            }

            public final void aul() {
                if (x.a(this.lIF.lIz.ee(false), this.lIF, new OnClickListener(this) {
                    final /* synthetic */ AnonymousClass2 lIG;

                    {
                        this.lIG = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        FavoriteIndexUI.a(this.lIG.lIF, 4105);
                    }
                })) {
                    FavoriteIndexUI.a(this.lIF, 4105);
                }
            }

            public final void aud() {
                g.a(this.lIF.uSU.uTo, this.lIF.getString(R.l.ehC), "", new OnClickListener(this) {
                    final /* synthetic */ AnonymousClass2 lIG;

                    {
                        this.lIG = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        FavoriteIndexUI.a(this.lIG.lIF, this.lIG.lIF.lIz.ee(true));
                        com.tencent.mm.plugin.report.service.g.oUh.i(11125, new Object[]{Integer.valueOf(r0.size()), Integer.valueOf(3)});
                        if (this.lIG.lIF.lIz.lJc) {
                            this.lIG.lIF.auj();
                        }
                    }
                }, null);
            }

            public final void aum() {
                if (this.lIF.lIz.aut() > 0) {
                    if (this.lIF.lIz.aut() > 1) {
                        Intent intent = new Intent(this.lIF.uSU.uTo, FavTagEditUI.class);
                        intent.putExtra("key_fav_scene", 3);
                        this.lIF.startActivityForResult(intent, 4104);
                        return;
                    }
                    j jVar = (j) this.lIF.lIz.ee(false).get(0);
                    Intent intent2 = new Intent(this.lIF.uSU.uTo, FavTagEditUI.class);
                    intent2.putExtra("key_fav_scene", 3);
                    intent2.putExtra("key_fav_item_id", jVar.field_localId);
                    this.lIF.startActivity(intent2);
                    if (this.lIF.lIz.lJc) {
                        this.lIF.auj();
                    }
                }
            }
        };
        ap.vL().D(new Runnable(this) {
            final /* synthetic */ FavoriteIndexUI lIF;

            {
                this.lIF = r1;
            }

            public final void run() {
                List list;
                String[] strArr = null;
                long currentTimeMillis = System.currentTimeMillis();
                com.tencent.mm.plugin.favorite.b.k ata = h.ata();
                Cursor a = ata.gUz.a("select " + com.tencent.mm.plugin.favorite.b.k.lEl + " from FavItemInfo where flag" + " =  -1 and itemStatus = 0 ", null, 2);
                if (a == null) {
                    list = null;
                } else {
                    if (a.moveToFirst()) {
                        strArr = new ArrayList();
                        do {
                            j jVar = new j();
                            jVar.b(a);
                            strArr.add(jVar);
                        } while (a.moveToNext());
                    }
                    a.close();
                    list = strArr;
                }
                if (list != null) {
                    w.i("MicroMsg.FavoriteIndexUI", "initInvalidFavItem getInvalid favitems , size = %d,start time = %s", new Object[]{Integer.valueOf(list.size()), Long.valueOf(currentTimeMillis)});
                    if (list.size() != 0) {
                        int size = list.size();
                        for (int i = 0; i < size; i++) {
                            h.ata().d((j) list.get(i));
                        }
                        w.i("MicroMsg.FavoriteIndexUI", "initInvalidFavItem  cost time = %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                    }
                }
            }
        });
        com.tencent.mm.plugin.favorite.b.c.atc().a(null);
        com.tencent.mm.pluginsdk.model.c.bCC();
    }

    protected final void auc() {
        super.auc();
        this.hgN.post(new Runnable(this) {
            final /* synthetic */ FavoriteIndexUI lIF;

            {
                this.lIF = r1;
            }

            public final void run() {
            }
        });
    }

    protected void onDestroy() {
        super.onDestroy();
        if (h.ata().gUz != null) {
            h.asU().dZ(true);
            if (this.lIz != null) {
                this.lIz.finish();
            }
            com.tencent.mm.sdk.b.b kaVar = new ka();
            kaVar.fQo.type = 12;
            com.tencent.mm.sdk.b.a.urY.m(kaVar);
            ap.vd().b(438, this.lIC);
            ap.vd().b(401, this.lIC);
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (4 != i || !this.lIz.lJc) {
            return super.onKeyUp(i, keyEvent);
        }
        auj();
        return true;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        q qVar = new q();
        j mx = this.lIz.mx((((AdapterContextMenuInfo) contextMenuInfo).position - this.lGA.getHeaderViewsCount()) - 1);
        switch (this.lIy) {
            case 0:
                contextMenu.setHeaderTitle(R.l.dIO);
                boolean g = qVar.g(mx);
                if (!g) {
                    contextMenu.add(0, 3, 0, R.l.ejk);
                }
                if (g && x.s(mx)) {
                    contextMenu.add(0, 3, 0, R.l.ejk);
                }
                contextMenu.add(0, 2, 0, R.l.ehS);
                contextMenu.add(0, 0, 0, R.l.ehB);
                contextMenu.add(0, 1, 0, R.l.eiJ);
                return;
            default:
                super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
                return;
        }
    }

    private void auj() {
        this.lIz.a(false, null);
        this.lGA.setOnItemLongClickListener(this.lID);
        af(11, true);
        b bVar = this.lIA;
        if (bVar.lJB && bVar.lJC.getVisibility() != 8) {
            bVar.lJC.setVisibility(8);
            bVar.lJC.startAnimation(AnimationUtils.loadAnimation(bVar.lJC.getContext(), R.a.aQY));
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        switch (this.lIy) {
            case 0:
                if (this.lIz != null) {
                    this.lIz.onItemClick(adapterView, view, i, j);
                    com.tencent.mm.plugin.favorite.ui.c.a.b bVar = (com.tencent.mm.plugin.favorite.ui.c.a.b) view.getTag();
                    if (bVar == null) {
                        w.w("MicroMsg.FavoriteIndexUI", "on item click, holder is null..");
                        return;
                    } else if (bVar.lFt == null) {
                        w.w("MicroMsg.FavoriteIndexUI", "on item click, info is null..");
                        return;
                    } else {
                        w.i("MicroMsg.FavoriteIndexUI", "click type is %d", new Object[]{Integer.valueOf(bVar.lFt.field_type)});
                        com.tencent.mm.plugin.report.service.g.oUh.i(12746, new Object[]{Integer.valueOf(bVar.lFt.field_type), Integer.valueOf(0), Integer.valueOf(i - 1)});
                        return;
                    }
                }
                return;
            default:
                return;
        }
    }

    public final com.tencent.mm.plugin.favorite.ui.a.a atY() {
        if (this.lIz == null) {
            this.lIz = new com.tencent.mm.plugin.favorite.ui.a.b(this.lDs, false);
            this.lIz.a(new com.tencent.mm.plugin.favorite.ui.a.a.a(this) {
                final /* synthetic */ FavoriteIndexUI lIF;

                {
                    this.lIF = r1;
                }

                public final void aun() {
                    this.lIF.lGG.ef(true);
                }
            });
            this.lIz.lJj = this;
        }
        return this.lIz;
    }

    protected final void atZ() {
        this.lGG.post(new Runnable(this) {
            final /* synthetic */ FavoriteIndexUI lIF;

            {
                this.lIF = r1;
            }

            public final void run() {
                this.lIF.lGG.auw();
            }
        });
    }

    protected final boolean aua() {
        int i;
        switch (this.lIy) {
            case 3:
                Cursor rawQuery = h.ata().rawQuery("select count(*) from FavItemInfo where type = 2", new String[0]);
                if (rawQuery == null) {
                    i = 0;
                    break;
                }
                rawQuery.moveToFirst();
                i = rawQuery.getInt(0);
                rawQuery.close();
                break;
            default:
                i = h.ata().getCount();
                break;
        }
        if (i > 0) {
            return true;
        }
        return false;
    }

    protected final void aub() {
        switch (this.lIy) {
            case 3:
                this.lGB.setCompoundDrawablesWithIntrinsicBounds(0, R.k.dwW, 0, 0);
                this.lGB.setCompoundDrawablePadding(com.tencent.mm.bg.a.fromDPToPix(this.uSU.uTo, 10));
                this.lGB.setText(R.l.ehV);
                return;
            default:
                this.lGB.setCompoundDrawablesWithIntrinsicBounds(0, R.g.bfa, 0, 0);
                this.lGB.setCompoundDrawablePadding(com.tencent.mm.bg.a.fromDPToPix(this.uSU.uTo, 10));
                this.lGB.setText(R.l.ehU);
                return;
        }
    }

    protected void onResume() {
        long currentTimeMillis = System.currentTimeMillis();
        super.onResume();
        this.hgN.post(new Runnable(this) {
            final /* synthetic */ FavoriteIndexUI lIF;

            {
                this.lIF = r1;
            }

            public final void run() {
                this.lIF.lGG.auw();
            }
        });
        w.d("MicroMsg.FavoriteIndexUI", "on resume use %d ms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
    }

    protected final void initHeaderView() {
        super.initHeaderView();
        this.lGG.ef(false);
    }

    private void a(List<j> list, String str, String str2) {
        if (list != null && !list.isEmpty() && !bg.mA(str2)) {
            boolean dH = o.dH(str2);
            q qVar = new q();
            List<j> linkedList = new LinkedList();
            for (j jVar : list) {
                if (qVar.g(jVar)) {
                    w.i("MicroMsg.FavoriteIndexUI", "filter xml is %s", new Object[]{jVar.field_xml});
                } else {
                    com.tencent.mm.plugin.report.service.g.oUh.i(10651, new Object[]{Integer.valueOf(jVar.field_type), Integer.valueOf(1), Integer.valueOf(0)});
                    linkedList.add(jVar);
                    v.a(dH ? v.c.lES : v.c.lER, jVar, v.d.lEV, dH ? com.tencent.mm.u.j.eC(str2) : 0);
                }
            }
            if (linkedList.isEmpty()) {
                w.i("MicroMsg.FavoriteIndexUI", "after filter, nothing");
                g.bl(getApplicationContext(), getString(R.l.ejl));
                return;
            }
            final Dialog a = g.a(this.uSU.uTo, getString(R.l.eit), false, null);
            r.a(this.uSU.uTo, str2, str, linkedList, new Runnable(this) {
                final /* synthetic */ FavoriteIndexUI lIF;

                public final void run() {
                    a.dismiss();
                    com.tencent.mm.ui.snackbar.a.e(this.lIF, this.lIF.getString(R.l.ekV));
                }
            });
            for (j jVar2 : linkedList) {
                if (jVar2 != null && jVar2.field_type == 5) {
                    String str3 = "";
                    if (jVar2.field_favProto.tyy != null) {
                        str3 = jVar2.field_favProto.tyy.tzN;
                    }
                    if (jVar2.field_favProto.tzl != null && bg.mA(r1)) {
                        str3 = jVar2.field_favProto.tzl.hSX;
                    }
                    if (!bg.mA(str3)) {
                        w.d("MicroMsg.FavoriteIndexUI", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[]{Integer.valueOf(13378), str3, Long.valueOf(this.startTime), Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(1)});
                        String str4 = "";
                        try {
                            str4 = URLEncoder.encode(str3, "UTF-8");
                        } catch (Throwable e) {
                            w.printErrStackTrace("MicroMsg.FavoriteIndexUI", e, "", new Object[0]);
                        }
                        com.tencent.mm.plugin.report.service.g.oUh.i(13378, new Object[]{str4, Long.valueOf(this.startTime), Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(1)});
                    }
                }
            }
            com.tencent.mm.plugin.report.service.g.oUh.i(11125, new Object[]{Integer.valueOf(linkedList.size()), Integer.valueOf(1)});
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        w.i("MicroMsg.FavoriteIndexUI", "onActivityResult reqCode: %d, retCod: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        String stringExtra;
        String stringExtra2;
        if (i2 == -1) {
            int i3 = 2;
            stringExtra = intent.getStringExtra("custom_send_text");
            switch (i) {
                case Downloads.RECV_BUFFER_SIZE /*4096*/:
                    final ArrayList stringArrayListExtra = intent.getStringArrayListExtra("CropImage_OutputPath_List");
                    if (stringArrayListExtra != null && stringArrayListExtra.size() != 0) {
                        i3 = 0;
                        this.lGD.post(new Runnable(this) {
                            final /* synthetic */ FavoriteIndexUI lIF;

                            public final void run() {
                                this.lIF.lGx = true;
                                m.at(stringArrayListExtra);
                            }
                        });
                        break;
                    }
                    w.e("MicroMsg.FavoriteIndexUI", "onActivityResult pathList is null or nil");
                    return;
                    break;
                case 4097:
                    final double doubleExtra = intent.getDoubleExtra("kwebmap_slat", 0.0d);
                    final double doubleExtra2 = intent.getDoubleExtra("kwebmap_lng", 0.0d);
                    final int intExtra = intent.getIntExtra("kwebmap_scale", 0);
                    final String ap = bg.ap(intent.getStringExtra("Kwebmap_locaion"), "");
                    final CharSequence charSequenceExtra = intent.getCharSequenceExtra("kRemark");
                    final String stringExtra3 = intent.getStringExtra("kPoiName");
                    final ArrayList stringArrayListExtra2 = intent.getStringArrayListExtra("kTags");
                    this.lGD.post(new Runnable(this) {
                        final /* synthetic */ FavoriteIndexUI lIF;

                        public final void run() {
                            this.lIF.lGx = true;
                            double d = doubleExtra;
                            double d2 = doubleExtra2;
                            int i = intExtra;
                            String str = ap;
                            CharSequence charSequence = charSequenceExtra;
                            String str2 = stringExtra3;
                            List<String> list = stringArrayListExtra2;
                            rs rsVar = new rs();
                            rsVar.Ou(str);
                            rsVar.m(d);
                            rsVar.l(d2);
                            rsVar.yf(i);
                            rsVar.Ov(str2);
                            j jVar = new j();
                            jVar.field_type = 6;
                            jVar.field_sourceType = 6;
                            jVar.field_favProto.b(rsVar);
                            if (!(charSequence == null || bg.mA(charSequence.toString()))) {
                                jVar.field_favProto.OA(charSequence.toString());
                                jVar.field_favProto.en(bg.Nz());
                                com.tencent.mm.plugin.report.service.g.oUh.i(10873, new Object[]{Integer.valueOf(6)});
                            }
                            m.f(jVar);
                            if (!(list == null || list.isEmpty())) {
                                for (String vQ : list) {
                                    jVar.vQ(vQ);
                                }
                            }
                            com.tencent.mm.plugin.favorite.c.a.w(jVar);
                            com.tencent.mm.plugin.report.service.g.oUh.i(10648, new Object[]{Integer.valueOf(3), Integer.valueOf(0)});
                            x.cg(jVar.field_localId);
                            long j = jVar.field_localId;
                            j bT = h.ata().bT(j);
                            if (bT != null && bT.field_favProto.tyw != null) {
                                com.tencent.mm.plugin.favorite.c.a(j, bT.field_favProto.tyw, "", "", new ArrayList(), this.lIF.uSU.uTo);
                            }
                        }
                    });
                    i3 = 0;
                    break;
                case 4098:
                    Context applicationContext = getApplicationContext();
                    ap.yY();
                    stringExtra = com.tencent.mm.pluginsdk.ui.tools.k.b(applicationContext, intent, com.tencent.mm.u.c.xb());
                    if (stringExtra != null) {
                        Intent intent2 = new Intent();
                        intent2.putExtra("CropImageMode", 4);
                        intent2.putExtra("CropImage_Filter", true);
                        intent2.putExtra("CropImage_ImgPath", stringExtra);
                        com.tencent.mm.plugin.favorite.c.imv.a(this, intent2, 4099);
                        break;
                    }
                    w.w("MicroMsg.FavoriteIndexUI", "take picture result path is null");
                    return;
                case 4099:
                    stringExtra = intent.getStringExtra("CropImage_OutputPath");
                    if (stringExtra != null) {
                        i3 = 0;
                        final ArrayList arrayList = new ArrayList();
                        arrayList.add(stringExtra);
                        this.lGD.post(new Runnable(this) {
                            final /* synthetic */ FavoriteIndexUI lIF;

                            public final void run() {
                                this.lIF.lGx = true;
                                m.at(arrayList);
                            }
                        });
                        break;
                    }
                    w.w("MicroMsg.FavoriteIndexUI", "crop picture resutl path is null");
                    return;
                case 4100:
                    stringExtra2 = intent.getStringExtra("choosed_file_path");
                    if (!bg.mA(stringExtra2)) {
                        File file = new File(stringExtra2);
                        if (file.exists()) {
                            if (file.length() < 26214400) {
                                Object obj;
                                if (bg.mA(stringExtra2)) {
                                    obj = null;
                                } else {
                                    file = new File(stringExtra2);
                                    if (file.exists()) {
                                        j jVar = new j();
                                        jVar.field_type = 8;
                                        jVar.field_sourceType = 6;
                                        m.f(jVar);
                                        jVar.field_favProto.OB(file.getName());
                                        rm rmVar = new rm();
                                        rmVar.NZ(stringExtra2);
                                        rmVar.jK(true);
                                        rmVar.NL(file.getName());
                                        rmVar.yb(jVar.field_type);
                                        rmVar.NV(com.tencent.mm.a.e.aQ(stringExtra2));
                                        jVar.field_favProto.tzn.add(rmVar);
                                        com.tencent.mm.plugin.favorite.c.a.w(jVar);
                                        com.tencent.mm.plugin.report.service.g.oUh.i(10648, new Object[]{Integer.valueOf(5), Integer.valueOf(0)});
                                        obj = 1;
                                    } else {
                                        obj = null;
                                    }
                                }
                                if (obj == null) {
                                    i3 = 1;
                                    break;
                                }
                                i3 = 0;
                                this.lGx = true;
                                break;
                            }
                            i3 = 3;
                            break;
                        }
                        i3 = 1;
                        break;
                    }
                    i3 = 1;
                    break;
                case 4101:
                case 4102:
                    i3 = 0;
                    this.lGx = true;
                    break;
                case 4103:
                    long longExtra = intent.getLongExtra("key_fav_result_local_id", -1);
                    if (-1 != longExtra) {
                        i3 = this.lIz.cj(longExtra);
                        if (-1 != i3) {
                            this.lGA.removeFooterView(this.lGE);
                            this.lGA.setSelection(i3);
                            return;
                        }
                        return;
                    }
                    return;
                case 4104:
                    final List ee = this.lIz.ee(false);
                    final String[] stringArrayExtra = intent.getStringArrayExtra("key_fav_result_array");
                    if (!(ee.isEmpty() || stringArrayExtra == null || stringArrayExtra.length <= 0)) {
                        final Dialog a = g.a(this.uSU.uTo, "", false, null);
                        ap.vL().D(new Runnable(this) {
                            final /* synthetic */ FavoriteIndexUI lIF;

                            public final void run() {
                                x.a(ee, stringArrayExtra);
                                af.v(new Runnable(this) {
                                    final /* synthetic */ AnonymousClass4 lIJ;

                                    {
                                        this.lIJ = r1;
                                    }

                                    public final void run() {
                                        a.dismiss();
                                    }

                                    public final String toString() {
                                        return super.toString() + "|batchAddFavTags";
                                    }
                                });
                            }
                        });
                        com.tencent.mm.plugin.report.service.g.oUh.i(11125, new Object[]{Integer.valueOf(stringArrayExtra.length), Integer.valueOf(2)});
                        break;
                    }
                case 4105:
                    w.d("MicroMsg.FavoriteIndexUI", "select %s for sending", new Object[]{intent.getStringExtra("Select_Conv_User")});
                    a(this.lIz.ee(false), stringExtra, r4);
                    break;
                case 4106:
                    w.d("MicroMsg.FavoriteIndexUI", "select %s for sending", new Object[]{intent.getStringExtra("Select_Conv_User")});
                    List arrayList2 = new ArrayList();
                    arrayList2.add(this.lIE);
                    a(arrayList2, stringExtra, r4);
                    break;
            }
            if (i3 == 0) {
                g.bl(this.uSU.uTo, getString(R.l.eiO));
            } else if (1 == i3) {
                g.bl(this.uSU.uTo, getString(R.l.eia));
            } else if (3 == i3) {
                Toast.makeText(this.uSU.uTo, getString(R.l.ejH), 1).show();
            } else if (this.lIz.lJc) {
                auj();
            }
        } else if ((this.lIE != null && this.lIE.field_type == 5) || (this.lIB != null && this.lIB.field_type == 5)) {
            stringExtra2 = "";
            if (this.lIB == null || this.lIB.field_favProto.tzl == null) {
                if (this.lIE.field_favProto.tyy != null) {
                    stringExtra2 = this.lIE.field_favProto.tyy.tzN;
                }
                if (this.lIE.field_favProto.tzl != null && bg.mA(r2)) {
                    stringExtra2 = this.lIE.field_favProto.tzl.hSX;
                }
            } else {
                stringExtra2 = this.lIB.field_favProto.tzl.hSX;
            }
            if (!bg.mA(stringExtra2)) {
                w.d("MicroMsg.FavoriteIndexUI", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[]{Integer.valueOf(13378), stringExtra2, Long.valueOf(this.startTime), Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(3)});
                stringExtra = "";
                try {
                    stringExtra2 = URLEncoder.encode(stringExtra2, "UTF-8");
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.FavoriteIndexUI", e, "", new Object[0]);
                    stringExtra2 = stringExtra;
                }
                com.tencent.mm.plugin.report.service.g.oUh.i(13378, new Object[]{stringExtra2, Long.valueOf(this.startTime), Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(3)});
            }
        }
    }

    public final void ci(long j) {
        if (this.lIz.lJc) {
            b bVar = this.lIA;
            boolean z = this.lIz.aut() > 0;
            if (bVar.lJB) {
                bVar.lJF.setEnabled(z);
                bVar.lJG.setEnabled(z);
                bVar.lJH.setEnabled(z);
            }
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem add = menu.add(0, 10, 0, R.l.eYk);
        add.setIcon(R.k.dsV);
        android.support.v4.view.m.a(add, 2);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 10) {
            return super.onOptionsItemSelected(menuItem);
        }
        Intent intent = new Intent(this.uSU.uTo, FavSearchUI.class);
        intent.putExtra("key_enter_fav_search_from", 0);
        if (this.lIz.lJc) {
            intent.putExtra("key_search_type", 2);
            startActivityForResult(intent, 4103);
        } else {
            startActivity(intent);
        }
        return true;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        w.i("MicroMsg.FavoriteIndexUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 64:
                if (iArr[0] == 0) {
                    Intent intent = new Intent();
                    intent.putExtra("MMActivity.OverrideExitAnimation", R.a.aRo);
                    intent.putExtra("MMActivity.OverrideEnterAnimation", R.a.aQX);
                    intent.putExtra("map_view_type", 3);
                    com.tencent.mm.plugin.favorite.c.imv.a(intent, 4097, this);
                    return;
                }
                g.a(this, getString(R.l.eFI), "", getString(R.l.evw), getString(R.l.cancel), false, new OnClickListener(this) {
                    final /* synthetic */ FavoriteIndexUI lIF;

                    {
                        this.lIF = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        this.lIF.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                    }
                }, new OnClickListener(this) {
                    final /* synthetic */ FavoriteIndexUI lIF;

                    {
                        this.lIF = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                return;
            case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*80*/:
                if (iArr[0] == 0) {
                    startActivityForResult(new Intent(this, FavPostVoiceUI.class), 4102);
                    overridePendingTransition(0, 0);
                    return;
                }
                g.a(this, getString(R.l.eFJ), "", getString(R.l.evw), getString(R.l.cancel), false, new OnClickListener(this) {
                    final /* synthetic */ FavoriteIndexUI lIF;

                    {
                        this.lIF = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        this.lIF.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                    }
                }, new OnClickListener(this) {
                    final /* synthetic */ FavoriteIndexUI lIF;

                    {
                        this.lIF = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                return;
            default:
                return;
        }
    }

    public final void auk() {
        Intent intent = new Intent(this.uSU.uTo, FavCleanUI.class);
        intent.putExtra("key_enter_fav_cleanui_from", 0);
        this.uSU.uTo.startActivity(intent);
    }
}
