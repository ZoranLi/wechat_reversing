package com.tencent.mm.plugin.favorite.ui.detail;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.i.b;
import com.tencent.mm.plugin.favorite.b.j;
import com.tencent.mm.plugin.favorite.b.x;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.plugin.favorite.ui.FavTagEditUI;
import com.tencent.mm.plugin.favorite.ui.FavTextEditUI;
import com.tencent.mm.plugin.favorite.ui.base.FavDetailFooterView;
import com.tencent.mm.plugin.favorite.ui.base.FavDetailTitleView;
import com.tencent.mm.plugin.favorite.ui.base.FavTagEntrance;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.widget.e;

public class FavoriteTextDetailUI extends MMActivity {
    private static final int lLY = b.sz();
    private l kmS;
    private FavDetailTitleView lLI;
    private FavDetailFooterView lLJ;
    private FavTagEntrance lLK;
    private long lLP;
    private TextView lLZ;
    private j lLu;
    private ClipboardManager lMa;
    private j lMb;
    private d lMc = new d(this) {
        final /* synthetic */ FavoriteTextDetailUI lMd;

        {
            this.lMd = r1;
        }

        public final void c(MenuItem menuItem, int i) {
            switch (menuItem.getItemId()) {
                case 1:
                    this.lMd.lMa.setText(this.lMd.lLu.field_favProto.desc);
                    g.bl(this.lMd.uSU.uTo, this.lMd.uSU.uTo.getString(R.l.dGy));
                    return;
                default:
                    return;
            }
        }
    };

    protected final int getLayoutId() {
        return R.i.dcO;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lLZ = (TextView) findViewById(R.h.bza);
        this.lLI = (FavDetailTitleView) findViewById(R.h.bOo);
        this.lLJ = (FavDetailFooterView) findViewById(R.h.bOn);
        this.lLK = (FavTagEntrance) findViewById(R.h.bOT);
        this.lMa = (ClipboardManager) getSystemService("clipboard");
        this.lLP = getIntent().getLongExtra("key_detail_info_id", -1);
        f.xT(5);
        this.kmS = new l(this.uSU.uTo);
        this.kmS.a(this.lLZ, this, this.lMc);
        qP(getString(R.l.ehE));
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ FavoriteTextDetailUI lMd;

            {
                this.lMd = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.lMd.finish();
                return true;
            }
        });
        a(0, R.l.eYj, R.g.bhb, new OnMenuItemClickListener(this) {
            final /* synthetic */ FavoriteTextDetailUI lMd;

            {
                this.lMd = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                e eVar = new e(this.lMd.uSU.uTo, e.wuP, false);
                eVar.qJf = new c(this) {
                    final /* synthetic */ AnonymousClass2 lMe;

                    {
                        this.lMe = r1;
                    }

                    public final void a(com.tencent.mm.ui.base.l lVar) {
                        if (this.lMe.lMd.getIntent().getBooleanExtra("key_detail_can_share_to_friend", true)) {
                            lVar.e(2, this.lMe.lMd.getString(R.l.ejs));
                        }
                        lVar.e(0, this.lMe.lMd.getString(R.l.ehQ));
                        lVar.e(3, this.lMe.lMd.getString(R.l.ehS));
                        lVar.e(4, this.lMe.lMd.getString(R.l.dGB));
                    }
                };
                eVar.qJg = new d(this) {
                    final /* synthetic */ AnonymousClass2 lMe;

                    {
                        this.lMe = r1;
                    }

                    public final void c(MenuItem menuItem, int i) {
                        Intent intent;
                        switch (menuItem.getItemId()) {
                            case 0:
                                intent = new Intent(this.lMe.lMd, FavTextEditUI.class);
                                intent.putExtra("key_value", this.lMe.lMd.lLu.field_favProto.desc);
                                intent.putExtra("key_max_count", FavoriteTextDetailUI.lLY);
                                intent.putExtra("key_show_confirm", true);
                                intent.putExtra("key_fav_item_id", this.lMe.lMd.lLu.field_id);
                                this.lMe.lMd.startActivityForResult(intent, 1);
                                return;
                            case 2:
                                String str = this.lMe.lMd.lLu.field_favProto.desc;
                                Context context = this.lMe.lMd;
                                if (bg.mA(str)) {
                                    w.e("MicroMsg.FavApplication", "shareTextToFriend content null");
                                } else {
                                    Intent intent2 = new Intent();
                                    intent2.putExtra("Retr_Msg_content", str);
                                    intent2.putExtra("Retr_Msg_Type", 4);
                                    intent2.putExtra("mutil_select_is_ret", true);
                                    com.tencent.mm.plugin.favorite.c.imv.l(intent2, context);
                                }
                                com.tencent.mm.plugin.report.service.g.oUh.i(10651, new Object[]{Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0)});
                                return;
                            case 3:
                                intent = new Intent(this.lMe.lMd.uSU.uTo, FavTagEditUI.class);
                                intent.putExtra("key_fav_scene", 2);
                                intent.putExtra("key_fav_item_id", this.lMe.lMd.lLu.field_localId);
                                this.lMe.lMd.uSU.uTo.startActivity(intent);
                                return;
                            case 4:
                                g.a(this.lMe.lMd.uSU.uTo, this.lMe.lMd.getString(R.l.dGC), "", new OnClickListener(this) {
                                    final /* synthetic */ AnonymousClass2 lMf;

                                    {
                                        this.lMf = r1;
                                    }

                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        final p a = g.a(this.lMf.lMe.lMd.uSU.uTo, this.lMf.lMe.lMd.getString(R.l.dGC), false, null);
                                        x.a(this.lMf.lMe.lMd.lLP, new Runnable(this) {
                                            final /* synthetic */ AnonymousClass1 lMg;

                                            public final void run() {
                                                a.dismiss();
                                                w.d("MicroMsg.FavoriteTextDetailUI", "do del, local id %d", new Object[]{Long.valueOf(this.lMg.lMf.lMe.lMd.lLP)});
                                                this.lMg.lMf.lMe.lMd.finish();
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
        h.ata().c(this.lLK);
    }

    protected void onDestroy() {
        h.ata().f(this.lLK);
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        auH();
    }

    protected void onPause() {
        super.onPause();
    }

    private void auH() {
        this.lLu = h.ata().bT(this.lLP);
        if (this.lLu == null) {
            w.w("MicroMsg.FavoriteTextDetailUI", "id[%d] info is null, return", new Object[]{Long.valueOf(this.lLP)});
            return;
        }
        this.lLK.ck(this.lLu.field_localId);
        this.lLK.ax(this.lLu.field_tagProto.tzx);
        if (this.lMb == null || this.lMb.field_edittime != this.lLu.field_edittime) {
            this.lMb = this.lLu;
            this.lLI.z(this.lLu);
            this.lLJ.z(this.lLu);
            this.lLZ.setText(this.lLu.field_favProto.desc);
            com.tencent.mm.pluginsdk.ui.d.h.d(this.lLZ, 1);
            return;
        }
        w.w("MicroMsg.FavoriteTextDetailUI", "not change, return");
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        contextMenu.add(0, 1, 0, getString(R.l.dGx));
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (1 == i && -1 == i2) {
            g.bl(this.uSU.uTo, getString(R.l.dIy));
            new ae().postDelayed(new Runnable(this) {
                final /* synthetic */ FavoriteTextDetailUI lMd;

                {
                    this.lMd = r1;
                }

                public final void run() {
                    this.lMd.auH();
                }
            }, 250);
            return;
        }
        super.onActivityResult(i, i2, intent);
    }
}
