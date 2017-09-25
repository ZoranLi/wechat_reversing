package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ao.f;
import com.tencent.mm.e.b.aj;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.plugin.bottle.a;
import com.tencent.mm.plugin.bottle.a.b;
import com.tencent.mm.plugin.bottle.a.i;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.ae;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.c;
import com.tencent.mm.u.h;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.e;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.k;
import com.tencent.mm.ui.tools.l;
import com.tencent.tmassistantsdk.downloadservice.Downloads;

public class BottleConversationUI extends MMActivity {
    private String fJL;
    private p irJ = null;
    private TextView jWk;
    private ListView jWl;
    private a jWm;
    private String jWn;
    private d jWo = new d(this) {
        final /* synthetic */ BottleConversationUI jWq;

        {
            this.jWq = r1;
        }

        public final void c(MenuItem menuItem, int i) {
            g.a(this.jWq, true, this.jWq.getString(R.l.dPo), "", this.jWq.getString(R.l.dPp), this.jWq.getString(R.l.dGs), new OnClickListener(this.jWq, this.jWq.fJL) {
                final /* synthetic */ BottleConversationUI jWq;

                public final void onClick(DialogInterface dialogInterface, int i) {
                    ap.yY();
                    ce Ah = c.wT().Ah(r9);
                    ap.yY();
                    c.wQ().b(new com.tencent.mm.ao.d(r9, Ah.field_msgSvrId));
                    ap.yY();
                    c.wQ().b(new f(r9, 0));
                    a.imw.ou();
                    this.jWq.jWp = false;
                    BottleConversationUI bottleConversationUI = this.jWq;
                    Context context = this.jWq;
                    this.jWq.getString(R.l.dIO);
                    bottleConversationUI.irJ = g.a(context, this.jWq.getString(R.l.dJd), true, new OnCancelListener(this) {
                        final /* synthetic */ AnonymousClass3 jWr;

                        {
                            this.jWr = r1;
                        }

                        public final void onCancel(DialogInterface dialogInterface) {
                            this.jWr.jWq.jWp = true;
                        }
                    });
                    ay.a(r9, new ay.a(this) {
                        final /* synthetic */ AnonymousClass3 jWr;

                        {
                            this.jWr = r1;
                        }

                        public final boolean zs() {
                            return this.jWr.jWq.jWp;
                        }

                        public final void zr() {
                            if (this.jWr.jWq.irJ != null) {
                                this.jWr.jWq.irJ.dismiss();
                                this.jWr.jWq.irJ = null;
                            }
                        }
                    });
                    ap.yY();
                    c.wW().Rl(r9);
                    b adw = i.adw();
                    String rX = com.tencent.mm.plugin.bottle.a.c.rX(r9);
                    adw.hnH.delete("bottleinfo1", "bottleid= ?", new String[]{rX});
                    a.imw.ou();
                }
            }, null);
        }
    };
    private boolean jWp = false;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KC();
    }

    protected final int getLayoutId() {
        return R.i.dpe;
    }

    public void onDestroy() {
        this.jWm.aEW();
        super.onDestroy();
    }

    public void onResume() {
        super.onResume();
        ap.yY();
        c.wR().a(this.jWm);
        ap.yY();
        c.wW().a(this.jWm);
        this.jWm.a(null, null);
    }

    public void onPause() {
        ap.yY();
        c.wR().b(this.jWm);
        ap.yY();
        c.wW().b(this.jWm);
        ap.yY();
        ce pl = c.wT().pl(8);
        if (pl != null && pl.field_msgId > 0) {
            w.d("MicroMsg.Bottle.BottleConversationUI", "resetUnread: lastReadTime = " + pl.field_createTime);
            ap.yY();
            c.vr().set(12306, Long.valueOf(pl.field_createTime));
        }
        ap.yY();
        aj Rm = c.wW().Rm("floatbottle");
        if (Rm == null || bg.mz(Rm.field_username).length() <= 0) {
            w.e("MicroMsg.Bottle.BottleConversationUI", "resetUnread: can not find bottle");
        } else {
            Rm.dt(0);
            ap.yY();
            if (c.wW().a(Rm, Rm.field_username) == -1) {
                w.e("MicroMsg.Bottle.BottleConversationUI", "reset bottle unread failed");
            }
        }
        this.jWm.onPause();
        super.onPause();
    }

    protected final void KC() {
        int xP = m.xP() | Downloads.RECV_BUFFER_SIZE;
        int xW = m.xW() & -65;
        ap.yY();
        c.vr().set(7, Integer.valueOf(xP));
        ap.yY();
        c.vr().set(34, Integer.valueOf(xW));
        this.jWl = (ListView) findViewById(R.h.cJi);
        this.jWk = (TextView) findViewById(R.h.bLU);
        this.jWk.setText(R.l.dPq);
        this.jWm = new a(this, new k.a(this) {
            final /* synthetic */ BottleConversationUI jWq;

            {
                this.jWq = r1;
            }

            public final void OH() {
                BottleConversationUI bottleConversationUI = this.jWq;
                String string = this.jWq.getString(R.l.dPt);
                int xI = h.xI();
                if (xI <= 0) {
                    bottleConversationUI.qP(string);
                } else {
                    bottleConversationUI.qP(string + "(" + xI + ")");
                }
                if (this.jWq.jWm.getCount() <= 0) {
                    this.jWq.jWk.setVisibility(0);
                    this.jWq.jWl.setVisibility(8);
                    return;
                }
                this.jWq.jWk.setVisibility(8);
                this.jWq.jWl.setVisibility(0);
            }

            public final void OI() {
            }
        });
        this.jWm.a(new MMSlideDelView.c(this) {
            final /* synthetic */ BottleConversationUI jWq;

            {
                this.jWq = r1;
            }

            public final int cb(View view) {
                return this.jWq.jWl.getPositionForView(view);
            }
        });
        this.jWm.a(new MMSlideDelView.f(this) {
            final /* synthetic */ BottleConversationUI jWq;

            {
                this.jWq = r1;
            }

            public final void s(View view, int i) {
                this.jWq.jWl.performItemClick(view, i, 0);
            }
        });
        this.jWm.a(new e(this) {
            final /* synthetic */ BottleConversationUI jWq;

            {
                this.jWq = r1;
            }

            public final void aQ(Object obj) {
                if (obj == null) {
                    w.e("MicroMsg.Bottle.BottleConversationUI", "onItemDel object null");
                } else {
                    g.a(this.jWq, true, this.jWq.getString(R.l.dPo), "", this.jWq.getString(R.l.dPp), this.jWq.getString(R.l.dGs), /* anonymous class already generated */, null);
                }
            }
        });
        this.jWl.setAdapter(this.jWm);
        final l lVar = new l(this);
        this.jWl.setOnItemLongClickListener(new OnItemLongClickListener(this) {
            final /* synthetic */ BottleConversationUI jWq;

            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i < this.jWq.jWl.getHeaderViewsCount()) {
                    w.w("MicroMsg.Bottle.BottleConversationUI", "on header view long click, ignore");
                } else {
                    lVar.a(view, i, j, this.jWq, this.jWq.jWo);
                }
                return true;
            }
        });
        this.jWl.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ BottleConversationUI jWq;

            {
                this.jWq = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                ae aeVar = (ae) this.jWq.jWm.getItem(i);
                Intent intent = new Intent();
                intent.addFlags(67108864);
                intent.putExtra("Chat_User", aeVar.field_username);
                intent.putExtra("finish_direct", true);
                intent.putExtra("key_need_send_video", false);
                a.imv.e(intent, this.jWq);
            }
        });
        a.imw.ou();
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ BottleConversationUI jWq;

            {
                this.jWq = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.jWq.finish();
                return true;
            }
        });
        String stringExtra = getIntent().getStringExtra("conversation_from");
        if (bg.mA(stringExtra) && bg.mA(this.jWn)) {
            a(0, getString(R.l.eas), new OnMenuItemClickListener(this) {
                final /* synthetic */ BottleConversationUI jWq;

                {
                    this.jWq = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    Intent intent = new Intent();
                    intent.setClass(this.jWq, BottleBeachUI.class);
                    this.jWq.startActivity(intent);
                    this.jWq.finish();
                    return true;
                }
            });
        } else if (!bg.mA(stringExtra)) {
            this.jWn = stringExtra;
        }
        AnonymousClass11 anonymousClass11 = new View.OnClickListener(this) {
            final /* synthetic */ BottleConversationUI jWq;

            {
                this.jWq = r1;
            }

            public final void onClick(View view) {
                BackwardSupportUtil.c.a(this.jWq.jWl);
            }
        };
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        this.fJL = ((ae) this.jWm.getItem(adapterContextMenuInfo.position)).field_username;
        int i = R.l.dPm;
        Object[] objArr = new Object[1];
        a aVar = this.jWm;
        ap.yY();
        objArr[0] = aVar.A(c.wR().Rc(this.fJL));
        contextMenu.setHeaderTitle(getString(i, objArr));
        contextMenu.add(adapterContextMenuInfo.position, 0, 0, R.l.dPn);
    }
}
