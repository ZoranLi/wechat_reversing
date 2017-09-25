package com.tencent.mm.plugin.favorite.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.favorite.b.j;
import com.tencent.mm.plugin.favorite.b.q;
import com.tencent.mm.plugin.favorite.b.r;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.plugin.favorite.ui.a.b;
import com.tencent.mm.plugin.favorite.ui.c.a;
import com.tencent.mm.plugin.favorite.ui.c.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.applet.d;
import com.tencent.mm.pluginsdk.ui.applet.k;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.o;
import java.util.HashSet;
import java.util.Set;

public class FavSelectUI extends FavBaseUI {
    private String lIe;
    private b lIf = null;
    private Set<Integer> lIg = new HashSet();
    private q lIh = new q();
    private String toUser;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.toUser = getIntent().getStringExtra("key_to_user");
        this.lIe = getIntent().getStringExtra("key_fav_item_id");
        if (this.lIe != null) {
            for (String str : this.lIe.split(",")) {
                int i = bg.getInt(str, Integer.MAX_VALUE);
                if (Integer.MAX_VALUE != i) {
                    this.lIg.add(Integer.valueOf(i));
                }
            }
        }
        this.lIg.remove(Integer.valueOf(3));
        this.lIf.f(this.lIg);
        this.lIh.lEn = false;
        this.lIf.a(this.lIh);
        this.lGD.post(new Runnable(this) {
            final /* synthetic */ FavSelectUI lIi;

            {
                this.lIi = r1;
            }

            public final void run() {
                this.lIi.lIf.aur();
                this.lIi.auc();
            }
        });
        a(0, R.k.dsV, new OnMenuItemClickListener(this) {
            final /* synthetic */ FavSelectUI lIi;

            {
                this.lIi = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent(this.lIi.uSU.uTo, FavSearchUI.class);
                intent.putExtra("key_to_user", this.lIi.toUser);
                intent.putExtra("key_fav_item_id", this.lIi.lIe);
                intent.putExtra("key_search_type", 1);
                intent.putExtra("key_enter_fav_search_from", 1);
                this.lIi.startActivityForResult(intent, 0);
                return true;
            }
        });
        zi(R.l.ejp);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ FavSelectUI lIi;

            {
                this.lIi = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.lIi.finish();
                return true;
            }
        });
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        final a.b bVar = (a.b) view.getTag();
        if (bVar == null) {
            w.w("MicroMsg.FavSelectUI", "on item click, holder is null");
        } else if (bVar.lFt == null) {
            w.w("MicroMsg.FavSelectUI", "on item click, info is null");
        } else {
            j jVar = bVar.lFt;
            g.oUh.i(10651, new Object[]{Integer.valueOf(jVar.field_type), Integer.valueOf(1), Integer.valueOf(1)});
            if (jVar.field_type == 3) {
                com.tencent.mm.ui.snackbar.a.e(this, getString(R.l.dAM));
            } else if (jVar.field_type == 8 && o.eV(this.toUser)) {
                com.tencent.mm.ui.snackbar.a.e(this, getString(R.l.dAK));
            } else {
                d.a aVar = new d.a(this.uSU.uTo);
                aVar.bs(this.toUser);
                e.a(aVar, this.uSU.uTo, bVar.lFt);
                e.b(aVar, this.uSU.uTo, bVar.lFt);
                aVar.c(Boolean.valueOf(true)).xp(R.l.dIA).a(new k.a(this) {
                    final /* synthetic */ FavSelectUI lIi;

                    public final void a(boolean z, String str, int i) {
                        this.lIi.aHf();
                        if (z) {
                            final Dialog a = com.tencent.mm.ui.base.g.a(this.lIi.uSU.uTo, this.lIi.getString(R.l.eit), false, null);
                            r.a(this.lIi.uSU.uTo, this.lIi.toUser, str, bVar.lFt, new Runnable(this) {
                                final /* synthetic */ AnonymousClass4 lIj;

                                public final void run() {
                                    if (a != null) {
                                        a.dismiss();
                                    }
                                    com.tencent.mm.ui.snackbar.a.e(this.lIj.lIi, this.lIj.lIi.getString(R.l.ekV));
                                    af.f(new Runnable(this) {
                                        final /* synthetic */ AnonymousClass1 lIk;

                                        {
                                            this.lIk = r1;
                                        }

                                        public final void run() {
                                            this.lIk.lIj.lIi.finish();
                                        }
                                    }, 1800);
                                }
                            });
                        }
                    }
                }).oHT.show();
            }
        }
    }

    public final com.tencent.mm.plugin.favorite.ui.a.a atY() {
        if (this.lIf == null) {
            this.lIf = new b(this.lDs, false);
        }
        return this.lIf;
    }

    protected final void atZ() {
    }

    protected final boolean aua() {
        return h.ata().getCount() > 0;
    }

    protected final void aub() {
        this.lGB.setCompoundDrawablesWithIntrinsicBounds(0, R.g.bfa, 0, 0);
        this.lGB.setCompoundDrawablePadding(com.tencent.mm.bg.a.fromDPToPix(this.uSU.uTo, 10));
        this.lGB.setText(R.l.ehU);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 0 && -1 == i2) {
            finish();
        } else {
            super.onActivityResult(i, i2, intent);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.lIf != null) {
            this.lIf.finish();
        }
    }
}
