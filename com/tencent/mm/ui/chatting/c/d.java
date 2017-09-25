package com.tencent.mm.ui.chatting.c;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView.t;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.e.b.af;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.q;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.a.b.e;
import com.tencent.mm.ui.tools.l;
import java.util.Date;
import java.util.LinkedList;

public final class d extends b {
    public int vTW = -1;
    public int vUn = 0;

    class AnonymousClass1 implements Runnable {
        final /* synthetic */ boolean vTX = true;
        final /* synthetic */ d vUo;

        AnonymousClass1(d dVar, boolean z) {
            this.vUo = dVar;
        }

        public final void run() {
            q fV;
            Object linkedList = new LinkedList();
            ap.yY();
            Cursor bf = c.wT().bf(this.vUo.kwJ, this.vUo.vTW);
            if (o.dH(this.vUo.kwJ)) {
                ap.yY();
                fV = c.xa().fV(this.vUo.kwJ);
            } else {
                fV = null;
            }
            long j = 0;
            while (bf.moveToNext()) {
                try {
                    ce auVar = new au();
                    auVar.b(bf);
                    String str = auVar.field_content;
                    if (str != null) {
                        com.tencent.mm.t.f.a ek = com.tencent.mm.t.f.a.ek(str);
                        if ((6 == ek.type ? 1 : null) != null) {
                            long a = com.tencent.mm.ui.gridviewheaders.a.bZj().a(new Date(auVar.field_createTime));
                            if (j != a) {
                                linkedList.add(new com.tencent.mm.ui.chatting.a.b.c(auVar.field_createTime));
                                d dVar = this.vUo;
                                dVar.vUn++;
                            }
                            String f = b.f(auVar, o.dH(this.vUo.kwJ));
                            af Rc = ((h) com.tencent.mm.kernel.h.h(h.class)).wR().Rc(f);
                            String str2 = "";
                            if (fV != null) {
                                str2 = fV.eK(f);
                            }
                            int LO = com.tencent.mm.pluginsdk.model.c.LO(ek.hhr);
                            a aVar = new a(this.vUo, auVar.field_createTime, ek.type, ek.title, auVar.field_msgId, Rc.field_username, Rc.tK(), Rc.field_conRemark, str2);
                            aVar.iconRes = LO;
                            aVar.desc = bg.ay((long) ek.hhq);
                            linkedList.add(aVar);
                            j = a;
                        }
                    }
                } finally {
                    bf.close();
                }
            }
            this.vUo.jnH.addAll(linkedList);
            this.vUo.vUf = this.vUo.jnH;
            linkedList.clear();
            w.i("MicroMsg.FileHistoryListPresenter", "[loadData] data:%s", new Object[]{Integer.valueOf(this.vUo.jnH.size())});
            com.tencent.mm.sdk.platformtools.af.v(new Runnable(this) {
                final /* synthetic */ AnonymousClass1 vUp;

                {
                    this.vUp = r1;
                }

                public final void run() {
                    if (this.vUp.vUo.vUc != null) {
                        this.vUp.vUo.vUc.s(this.vUp.vTX, this.vUp.vUo.jnH.size());
                    }
                }
            });
        }
    }

    class a extends com.tencent.mm.ui.chatting.a.b.b {
        public String desc;
        public int iconRes;
        final /* synthetic */ d vUo;

        public a(d dVar, long j, int i, String str, long j2, String str2, String str3, String str4, String str5) {
            this.vUo = dVar;
            super(j, i, str, j2, str2, str3, str4, str5);
        }

        public final boolean TG(String str) {
            if (str != null) {
                return super.TG(str.toLowerCase());
            }
            return false;
        }

        public final int getType() {
            return 6;
        }
    }

    class b extends com.tencent.mm.ui.chatting.a.b.a {
        TextView ipx;
        ImageView jbU;
        final /* synthetic */ d vUo;

        public b(d dVar, View view) {
            this.vUo = dVar;
            super(view);
            this.jbU = (ImageView) view.findViewById(R.h.bOx);
            this.ipw.setSingleLine(false);
            this.ipw.setMaxLines(2);
            this.ipx = (TextView) view.findViewById(R.h.bOm);
        }
    }

    public d(Context context) {
        super(context);
    }

    public final void bWD() {
        w.i("MicroMsg.FileHistoryListPresenter", "[loadData] isFirst:%s", new Object[]{Boolean.valueOf(true)});
        this.vUc.bWH();
        com.tencent.mm.kernel.h.vJ();
        com.tencent.mm.kernel.h.vL().D(new AnonymousClass1(this, true));
    }

    public final String Oh() {
        return this.mContext.getString(R.l.dCX);
    }

    public final String bWG() {
        return this.mContext.getString(R.l.dCX);
    }

    public final e bWE() {
        return new e(this) {
            final /* synthetic */ d vUo;

            {
                this.vUo = r1;
            }

            public final void a(int i, com.tencent.mm.ui.chatting.a.b.b bVar) {
                w.i("MicroMsg.FileHistoryListPresenter", "[onItemClick] position:%s", new Object[]{Integer.valueOf(i)});
                this.vUo.a(bVar);
            }

            public final void a(View view, int i, final com.tencent.mm.ui.chatting.a.b.b bVar) {
                w.i("MicroMsg.FileHistoryListPresenter", "[onItemLongClick] position:%s", new Object[]{Integer.valueOf(i)});
                new l(view.getContext()).b(view, new OnCreateContextMenuListener(this) {
                    final /* synthetic */ AnonymousClass2 vUq;

                    {
                        this.vUq = r1;
                    }

                    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                        contextMenu.add(0, 0, 0, view.getContext().getString(R.l.eLL));
                        contextMenu.add(0, 1, 0, view.getContext().getString(R.l.dTs));
                        contextMenu.add(0, 2, 0, view.getContext().getString(R.l.dUp));
                    }
                }, new com.tencent.mm.ui.base.n.d(this) {
                    final /* synthetic */ AnonymousClass2 vUq;

                    public final void c(MenuItem menuItem, int i) {
                        ap.yY();
                        this.vUq.vUo.e(i, c.wT().cA(bVar.fGM));
                    }
                });
            }
        };
    }

    public final t m(ViewGroup viewGroup) {
        return new b(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.i.dcS, viewGroup, false));
    }

    public final void a(com.tencent.mm.ui.chatting.a.b.a aVar, int i) {
        b bVar = (b) aVar;
        a aVar2 = (a) Bg(i);
        if (bg.mA(aVar2.desc)) {
            bVar.ipx.setVisibility(8);
        } else {
            bVar.ipx.setVisibility(0);
            bVar.ipx.setText(bg.ap(aVar2.desc, ""));
        }
        bVar.jbU.setImageResource(aVar2.iconRes);
    }

    public final void a(com.tencent.mm.ui.chatting.a.b.b bVar) {
        if (AZ()) {
            Intent intent = new Intent();
            intent.setClassName(this.mContext, "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
            intent.putExtra("app_msg_id", bVar.fGM);
            this.mContext.startActivity(intent);
            return;
        }
        s.eP(this.mContext);
    }
}
