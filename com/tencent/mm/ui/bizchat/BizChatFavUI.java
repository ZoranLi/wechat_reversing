package com.tencent.mm.ui.bizchat;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ah.n;
import com.tencent.mm.modelbiz.a.b.a;
import com.tencent.mm.modelbiz.a.b.a.b;
import com.tencent.mm.modelbiz.a.c;
import com.tencent.mm.modelbiz.a.h;
import com.tencent.mm.modelbiz.a.s;
import com.tencent.mm.modelbiz.m;
import com.tencent.mm.protocal.c.gq;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.e;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.chatting.En_5b8fbb1e;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.y.k;

public class BizChatFavUI extends MMActivity implements m {
    private TextView jWk;
    private ListView jWl;
    private d jWo;
    private p jiM;
    private long kbc;
    private String kbi;
    private boolean uPP;
    private a vvI;
    private com.tencent.mm.modelbiz.a.d.a vvJ;
    private c vvO;

    static /* synthetic */ void a(BizChatFavUI bizChatFavUI, long j) {
        w.i("MicroMsg.BizChatFavUI", "deleteFromFav");
        c aa = com.tencent.mm.modelbiz.w.DJ().aa(j);
        aa.field_bitFlag &= -9;
        w.i("MicroMsg.BizChatFavUI", "deleteFromFav:bitFlag %s", Integer.valueOf(aa.field_bitFlag));
        gq gqVar = new gq();
        gqVar.tkF = aa.field_bizChatServId;
        gqVar.tkH = aa.field_bitFlag;
        com.tencent.mm.modelbiz.w.DN();
        final com.tencent.mm.modelbiz.a.w a = h.a(aa.field_brandUserName, gqVar, (m) bizChatFavUI);
        bizChatFavUI.jiM = g.a((Context) bizChatFavUI, "", false, new OnCancelListener(bizChatFavUI) {
            final /* synthetic */ BizChatFavUI vvP;

            public final void onCancel(DialogInterface dialogInterface) {
                com.tencent.mm.modelbiz.w.DN();
                h.f(a);
            }
        });
    }

    static /* synthetic */ void b(BizChatFavUI bizChatFavUI, long j) {
        Intent intent = new Intent(bizChatFavUI, En_5b8fbb1e.class);
        intent.addFlags(67108864);
        intent.putExtra("Chat_User", bizChatFavUI.kbi);
        intent.putExtra("key_biz_chat_id", j);
        intent.putExtra("finish_direct", true);
        intent.putExtra("key_need_send_video", false);
        intent.putExtra("key_is_biz_chat", true);
        bizChatFavUI.startActivity(intent);
        af.f(new Runnable(bizChatFavUI) {
            final /* synthetic */ BizChatFavUI vvP;

            {
                this.vvP = r1;
            }

            public final void run() {
                this.vvP.finish();
            }
        }, 500);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kbi = getIntent().getStringExtra("Contact_User");
        w.i("MicroMsg.BizChatFavUI", "[regitListener]");
        this.vvI = new a(this) {
            final /* synthetic */ BizChatFavUI vvP;

            {
                this.vvP = r1;
            }

            public final void a(b bVar) {
                if (bVar != null && bVar.hwH != null && this.vvP.kbi.equals(bVar.hwH.field_brandUserName)) {
                    w.i("MicroMsg.BizChatFavUI", "bizChatExtension bizChatConv change");
                    if (this.vvP.uPP) {
                        this.vvP.vvO.OK();
                    }
                }
            }
        };
        this.vvJ = new com.tencent.mm.modelbiz.a.d.a(this) {
            final /* synthetic */ BizChatFavUI vvP;

            {
                this.vvP = r1;
            }

            public final void a(com.tencent.mm.modelbiz.a.d.a.b bVar) {
                if (bVar != null && bVar.hwR != null) {
                    w.i("MicroMsg.BizChatFavUI", "bizChatExtension bizChat change");
                    c aa = com.tencent.mm.modelbiz.w.DJ().aa(bVar.hwG);
                    w.d("MicroMsg.BizChatFavUI", "needToUpdate:%s", Boolean.valueOf(aa.field_needToUpdate));
                    if (this.vvP.uPP) {
                        this.vvP.vvO.OK();
                    }
                }
            }
        };
        com.tencent.mm.modelbiz.w.DK().a(this.vvI, getMainLooper());
        com.tencent.mm.modelbiz.w.DJ().a(this.vvJ, getMainLooper());
        KC();
        com.tencent.mm.modelbiz.w.DN();
        com.tencent.mm.kernel.h.vH().gXC.a(new s(this.kbi), 0);
    }

    protected final int getLayoutId() {
        return R.i.dbh;
    }

    public void onDestroy() {
        w.i("MicroMsg.BizChatFavUI", "[unRegitListener]");
        com.tencent.mm.modelbiz.w.DK().a(this.vvI);
        com.tencent.mm.modelbiz.w.DJ().a(this.vvJ);
        this.vvO.aEW();
        super.onDestroy();
    }

    public void onResume() {
        super.onResume();
        ap.yY();
        com.tencent.mm.e.b.af Rc = com.tencent.mm.u.c.wR().Rc(this.kbi);
        if (Rc == null || !com.tencent.mm.j.a.ez(Rc.field_type)) {
            finish();
            return;
        }
        zo(8);
        this.uPP = true;
        this.vvO.a(null, null);
        ap.getNotification().db(this.kbi);
    }

    public void onPause() {
        this.vvO.onPause();
        this.uPP = false;
        ap.getNotification().db("");
        super.onPause();
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        this.kbc = ((c) this.vvO.getItem(adapterContextMenuInfo.position)).field_bizChatLocalId;
        contextMenu.add(adapterContextMenuInfo.position, 0, 1, R.l.dOX);
    }

    public final void a(int i, k kVar) {
        if (this.jiM != null) {
            this.jiM.dismiss();
        }
    }

    protected final void KC() {
        this.jWl = (ListView) findViewById(R.h.cJi);
        this.jWk = (TextView) findViewById(R.h.bLU);
        this.jWk.setText(R.l.dOW);
        this.jWl.setOnScrollListener(new OnScrollListener(this) {
            final /* synthetic */ BizChatFavUI vvP;

            {
                this.vvP = r1;
            }

            public final void onScrollStateChanged(AbsListView absListView, int i) {
                n.GW().bi(i);
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        this.vvO = new c(this, new com.tencent.mm.ui.k.a(this) {
            final /* synthetic */ BizChatFavUI vvP;

            {
                this.vvP = r1;
            }

            public final void OH() {
                this.vvP.qP(com.tencent.mm.u.n.eK(this.vvP.kbi));
                if (this.vvP.vvO.getCount() <= 0) {
                    this.vvP.jWk.setVisibility(0);
                    this.vvP.jWl.setVisibility(8);
                    return;
                }
                this.vvP.jWk.setVisibility(8);
                this.vvP.jWl.setVisibility(0);
            }

            public final void OI() {
            }
        }, this.kbi);
        this.vvO.a(new MMSlideDelView.c(this) {
            final /* synthetic */ BizChatFavUI vvP;

            {
                this.vvP = r1;
            }

            public final int cb(View view) {
                return this.vvP.jWl.getPositionForView(view);
            }
        });
        this.vvO.a(new f(this) {
            final /* synthetic */ BizChatFavUI vvP;

            {
                this.vvP = r1;
            }

            public final void s(View view, int i) {
                this.vvP.jWl.performItemClick(view, i, 0);
            }
        });
        this.vvO.a(new e(this) {
            final /* synthetic */ BizChatFavUI vvP;

            {
                this.vvP = r1;
            }

            public final void aQ(Object obj) {
                if (obj == null) {
                    w.e("MicroMsg.BizChatFavUI", "onItemDel object null");
                }
            }
        });
        this.jWl.setAdapter(this.vvO);
        this.jWo = new d(this) {
            final /* synthetic */ BizChatFavUI vvP;

            {
                this.vvP = r1;
            }

            public final void c(MenuItem menuItem, int i) {
                switch (menuItem.getItemId()) {
                    case 0:
                        BizChatFavUI.a(this.vvP, this.vvP.kbc);
                        return;
                    default:
                        return;
                }
            }
        };
        final l lVar = new l(this);
        this.jWl.setOnItemLongClickListener(new OnItemLongClickListener(this) {
            final /* synthetic */ BizChatFavUI vvP;

            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i < this.vvP.jWl.getHeaderViewsCount()) {
                    w.w("MicroMsg.BizChatFavUI", "on header view long click, ignore");
                } else {
                    lVar.a(view, i, j, this.vvP, this.vvP.jWo);
                }
                return true;
            }
        });
        this.jWl.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ BizChatFavUI vvP;

            {
                this.vvP = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                BizChatFavUI.b(this.vvP, ((c) this.vvP.vvO.getItem(i)).field_bizChatLocalId);
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ BizChatFavUI vvP;

            {
                this.vvP = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.vvP.finish();
                return true;
            }
        });
    }
}
