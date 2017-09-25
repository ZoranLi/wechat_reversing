package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.e.a.cb;
import com.tencent.mm.e.a.lz;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.modelbiz.a.c;
import com.tencent.mm.modelbiz.e;
import com.tencent.mm.modelbiz.w;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.protocal.b.a.d;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.bizchat.BizChatSelectConversationUI;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.tools.l;
import java.util.LinkedList;
import java.util.List;

public final class ad {
    public static p vAY = null;
    public static a vBj;

    private static class a {
        cb fSJ;
        String fTm;
        List<au> vBg;
        d vBh;
        boolean vBr;
        boolean vxp;
    }

    private static class b implements com.tencent.mm.sdk.platformtools.ar.a {
        private Context context;
        private String huj;
        private long kbc;
        private boolean sMK;
        private com.tencent.mm.ui.chatting.En_5b8fbb1e.a vBs;
        private a vBt;

        public b(com.tencent.mm.ui.chatting.En_5b8fbb1e.a aVar, Context context, String str, long j, a aVar2) {
            this.vBs = aVar;
            this.context = context;
            this.huj = str;
            this.kbc = j;
            this.vBt = aVar2;
            this.sMK = e.dr(str);
        }

        public final boolean Bn() {
            if (this.sMK) {
                c aa = w.DJ().aa(this.kbc);
                synchronized (com.tencent.mm.modelbiz.a.e.hwS) {
                    String zz = com.tencent.mm.modelbiz.a.e.zz();
                    com.tencent.mm.modelbiz.a.e.d(aa);
                    if (this.vBt.vBr) {
                        bUc();
                    } else {
                        bUd();
                    }
                    com.tencent.mm.modelbiz.a.e.ix(zz);
                }
            } else if (this.vBt.vBr) {
                bUc();
            } else {
                bUd();
            }
            return true;
        }

        private void bUc() {
            for (au auVar : this.vBt.vBg) {
                Context context = this.context;
                boolean z = this.vBt.vxp;
                String str = this.huj;
                if (auVar.bMk()) {
                    aa.a(context, str, auVar, z);
                } else if (auVar.bMh()) {
                    aa.b(context, str, auVar);
                } else if (auVar.bMl() && !this.sMK) {
                    aa.c(context, str, auVar);
                } else if (auVar.bMj()) {
                    aa.c(context, str, auVar, z);
                } else if ((auVar.bMn() || auVar.bMo()) && !this.sMK) {
                    if (!aa.ac(auVar)) {
                        aa.a(context, str, auVar);
                    }
                } else if (auVar.axO() && !((this.sMK && !aa.ai(auVar)) || aa.aj(auVar) || auVar.field_type == 318767153 || aa.an(auVar) || aa.ae(auVar))) {
                    aa.b(context, str, auVar, z);
                }
            }
        }

        private void bUd() {
            ad.bm(this.context, this.huj);
            com.tencent.mm.sdk.b.b lzVar = new lz();
            lzVar.fTf.type = 5;
            lzVar.fTf.fTl = this.vBt.vBg;
            lzVar.fTf.toUser = this.huj;
            lzVar.fTf.fTm = this.vBt.fTm;
            lzVar.fTf.context = this.context;
            lzVar.fTf.fSJ = this.vBt.fSJ;
            lzVar.fTf.fTo = this.vBt.vBh;
            com.tencent.mm.sdk.b.a.urY.m(lzVar);
        }

        public final boolean Bo() {
            if (ad.vAY != null) {
                ad.vAY.dismiss();
            }
            com.tencent.mm.ui.snackbar.a.a(this.context, this.vBs.mView.findViewById(R.h.ckh), this.context.getString(R.l.ekV));
            return true;
        }
    }

    public static void a(com.tencent.mm.ui.chatting.En_5b8fbb1e.a aVar, List<au> list, boolean z, db dbVar, x xVar) {
        if (aVar == null) {
            com.tencent.mm.sdk.platformtools.w.w("MicroMsg.ChattingEditModeSendToBrand", "do send to brand fail, fragment is null");
        } else if (list == null || list.isEmpty()) {
            com.tencent.mm.sdk.platformtools.w.w("MicroMsg.ChattingEditModeSendToBrand", "do send to brand fail, select item empty");
        } else {
            a aVar2 = new a();
            vBj = aVar2;
            aVar2.vBg = new LinkedList(list);
            vBj.vxp = z;
            vBj.fTm = xVar.field_username;
            vBj.vBr = true;
            final Context context = aVar.uSU.uTo;
            if (context != null) {
                l lVar = new l(context);
                lVar.wnf = new com.tencent.mm.ui.base.n.a() {
                    public final void a(ImageView imageView, MenuItem menuItem) {
                        com.tencent.mm.pluginsdk.ui.a.b.b(imageView, menuItem.getTitle(), false);
                    }
                };
                lVar.wng = new com.tencent.mm.ui.base.n.b() {
                    public final void a(TextView textView, MenuItem menuItem) {
                        if (textView != null) {
                            ap.yY();
                            com.tencent.mm.j.a Rc = com.tencent.mm.u.c.wR().Rc(menuItem.getTitle());
                            if (Rc == null || ((int) Rc.gTQ) <= 0) {
                                textView.setText(menuItem.getTitle());
                            } else {
                                textView.setText(h.a(context, Rc.tK()));
                            }
                        }
                    }
                };
                final List bUa = com.tencent.mm.pluginsdk.model.app.p.n(context, "com.tencent.wework") ? aa.bUa() : aa.bTZ();
                lVar.qJf = new n.c() {
                    public final void a(com.tencent.mm.ui.base.l lVar) {
                        lVar.W(1193046, R.l.eAL, R.g.bdM);
                        for (CharSequence add : bUa) {
                            lVar.add(add);
                        }
                    }
                };
                final List<au> list2 = list;
                final com.tencent.mm.ui.chatting.En_5b8fbb1e.a aVar3 = aVar;
                final x xVar2 = xVar;
                final db dbVar2 = dbVar;
                lVar.qJg = new n.d() {
                    public final void c(final MenuItem menuItem, int i) {
                        if (menuItem.getItemId() == 1193046) {
                            if (aa.cx(list2)) {
                                g.a(context, context.getString(R.l.eaH), "", context.getString(R.l.dAN), new OnClickListener(this) {
                                    final /* synthetic */ AnonymousClass4 vBo;

                                    {
                                        this.vBo = r1;
                                    }

                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                    }
                                });
                            } else if (aa.cy(list2)) {
                                g.a(context, context.getString(R.l.eaI), "", context.getString(R.l.dAN), new OnClickListener(this) {
                                    final /* synthetic */ AnonymousClass4 vBo;

                                    {
                                        this.vBo = r1;
                                    }

                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                    }
                                });
                            } else if (aa.cw(list2)) {
                                g.a(context, context.getString(R.l.eaJ), "", new OnClickListener(this) {
                                    final /* synthetic */ AnonymousClass4 vBo;

                                    {
                                        this.vBo = r1;
                                    }

                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                    }
                                }, null);
                            } else if (ae.a(aVar3, list2, xVar2) && dbVar2 != null) {
                                dbVar2.bUC();
                            }
                        } else if (aa.cx(list2)) {
                            g.a(context, context.getString(R.l.eaH), "", context.getString(R.l.dAN), new OnClickListener(this) {
                                final /* synthetic */ AnonymousClass4 vBo;

                                {
                                    this.vBo = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                }
                            });
                        } else if (aa.cy(list2)) {
                            g.a(context, context.getString(R.l.eaI), "", context.getString(R.l.dAN), new OnClickListener(this) {
                                final /* synthetic */ AnonymousClass4 vBo;

                                {
                                    this.vBo = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                }
                            });
                        } else {
                            boolean z;
                            List<au> list = list2;
                            if (list != null) {
                                for (au auVar : list) {
                                    if (auVar.field_isSend == 1) {
                                        break;
                                    } else if (auVar.bMh()) {
                                        com.tencent.mm.ah.d aj;
                                        com.tencent.mm.ah.d ai;
                                        if (auVar.field_msgId > 0) {
                                            aj = com.tencent.mm.ah.n.GS().aj(auVar.field_msgId);
                                        } else {
                                            aj = null;
                                        }
                                        if ((aj == null || aj.hEY <= 0) && auVar.field_msgSvrId > 0) {
                                            ai = com.tencent.mm.ah.n.GS().ai(auVar.field_msgSvrId);
                                        } else {
                                            ai = aj;
                                        }
                                        if (ai != null && (ai.offset < ai.hrs || ai.hrs == 0)) {
                                            z = true;
                                            break;
                                        }
                                    } else if (auVar.bMl()) {
                                        r0 = o.KV().ls(auVar.field_imgPath);
                                        if (!(r0 == null || r0.status == 199 || r0.status == 199)) {
                                            z = true;
                                            break;
                                        }
                                    } else if (auVar.bMm()) {
                                        r0 = t.lH(auVar.field_imgPath);
                                        if (!(r0 == null || r0.status == 199 || r0.status == 199)) {
                                            z = true;
                                            break;
                                        }
                                    } else if (auVar.bMo()) {
                                        z = !aa.ad(auVar);
                                    }
                                }
                            } else {
                                com.tencent.mm.sdk.platformtools.w.w("MicroMsg.ChattingEditModeLogic", "check contain undownload image or video error, select item empty");
                            }
                            z = false;
                            if (z || aa.cw(list2)) {
                                g.a(context, context.getString(R.l.eaJ), "", new OnClickListener(this) {
                                    final /* synthetic */ AnonymousClass4 vBo;

                                    {
                                        this.vBo = r1;
                                    }

                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                    }
                                }, null);
                                return;
                            }
                            final String str = (String) menuItem.getTitle();
                            if (e.hZ(str)) {
                                if (list2.size() <= 1) {
                                    ad.vBj.vBr = true;
                                    ad.a(str, aVar3, list2);
                                    return;
                                }
                                new l(context).b(menuItem.getActionView(), new OnCreateContextMenuListener(this) {
                                    final /* synthetic */ AnonymousClass4 vBo;

                                    {
                                        this.vBo = r1;
                                    }

                                    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                                        contextMenu.add(0, 0, 0, R.l.eBC);
                                        contextMenu.add(0, 1, 1, R.l.eBD);
                                    }
                                }, new n.d(this) {
                                    final /* synthetic */ AnonymousClass4 vBo;

                                    public final void c(MenuItem menuItem, int i) {
                                        if (menuItem.getItemId() == 0) {
                                            ad.vBj.vBr = true;
                                        } else {
                                            ad.vBj.vBr = false;
                                        }
                                        ad.a(str, aVar3, list2);
                                    }
                                });
                            } else if (aa.cu(list2)) {
                                g.a(context, context.getString(R.l.esI), "", new OnClickListener(this) {
                                    final /* synthetic */ AnonymousClass4 vBo;

                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        boolean z;
                                        List<au> list = list2;
                                        if (list != null && !list.isEmpty()) {
                                            for (au auVar : list) {
                                                if (!aa.ah(auVar)) {
                                                    if (!auVar.bLZ() && !aa.ac(auVar) && !auVar.bMi() && !aa.ae(auVar) && !aa.af(auVar) && auVar.field_type != -1879048186 && !aa.ak(auVar) && !aa.ag(auVar) && !aa.aj(auVar) && !aa.an(auVar)) {
                                                        z = false;
                                                        break;
                                                    }
                                                } else {
                                                    break;
                                                }
                                            }
                                        }
                                        com.tencent.mm.sdk.platformtools.w.w("MicroMsg.ChattingEditModeLogic", "check contain only invalid send to brand service error, select item empty");
                                        z = true;
                                        if (z) {
                                            com.tencent.mm.sdk.platformtools.w.w("MicroMsg.ChattingEditModeSendToBrand", "only contain invalid msg, exit long click mode");
                                            if (dbVar2 != null) {
                                                dbVar2.bUC();
                                                return;
                                            }
                                            return;
                                        }
                                        Context context = context;
                                        context.getString(R.l.dIO);
                                        ad.vAY = g.a(context, context.getString(R.l.eRj), false, null);
                                        db.vGa.c(new b(aVar3, context, menuItem.getTitle(), -1, ad.vBj));
                                        if (dbVar2 != null) {
                                            dbVar2.bUC();
                                        }
                                    }
                                }, null);
                            } else {
                                Context context = context;
                                context.getString(R.l.dIO);
                                ad.vAY = g.a(context, context.getString(R.l.eRj), false, null);
                                db.vGa.c(new b(aVar3, context, menuItem.getTitle(), -1, ad.vBj));
                                if (dbVar2 != null) {
                                    dbVar2.bUC();
                                }
                            }
                        }
                    }
                };
                lVar.blb();
            }
        }
    }

    public static void a(final String str, final q qVar, List<au> list) {
        Context context = qVar.uSU.uTo;
        if (context != null) {
            BizInfo hW = e.hW(str);
            if (hW != null) {
                String string;
                boolean CJ = hW.CJ();
                if (vBj.vBr) {
                    boolean cu = aa.cu(list);
                    if (CJ) {
                        Object obj;
                        if (list == null || list.isEmpty()) {
                            com.tencent.mm.sdk.platformtools.w.w("MicroMsg.ChattingEditModeLogic", "check contain invalid send to bizchat msg error, selected item empty");
                            obj = 1;
                        } else {
                            for (au auVar : list) {
                                if (!auVar.bMk() && !auVar.bLZ() && !auVar.bMh() && !auVar.bMj() && !aa.ai(auVar)) {
                                    int i = 1;
                                    break;
                                }
                            }
                            obj = null;
                        }
                        vBj.vBg = new LinkedList(list);
                        if (cu || r0 != null) {
                            string = context.getString(R.l.eeL);
                            if (string != null) {
                                g.a(context, string, "", new OnClickListener() {
                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        ad.a(str, qVar);
                                    }
                                }, null);
                            } else {
                                a(str, qVar);
                            }
                        }
                    } else if (cu) {
                        string = context.getString(R.l.eeM);
                        if (string != null) {
                            a(str, qVar);
                        } else {
                            g.a(context, string, "", /* anonymous class already generated */, null);
                        }
                    }
                }
                string = null;
                if (string != null) {
                    g.a(context, string, "", /* anonymous class already generated */, null);
                } else {
                    a(str, qVar);
                }
            }
        }
    }

    public static void a(String str, q qVar) {
        BizInfo hW = e.hW(str);
        if (hW != null) {
            Intent intent;
            if (hW.CJ()) {
                intent = new Intent(qVar.uSU.uTo, BizChatSelectConversationUI.class);
                intent.putExtra("enterprise_biz_name", str);
                intent.putExtra("biz_chat_scene", 2);
                intent.putExtra("enterprise_extra_params", vBj.vBr);
                qVar.startActivityForResult(intent, 225);
            } else if (hW.CH()) {
                intent = new Intent();
                intent.putExtra("enterprise_biz_name", str);
                intent.putExtra("enterprise_scene", 1);
                com.tencent.mm.bb.d.a((Fragment) qVar, "brandservice", ".ui.EnterpriseBizContactPlainListUI", intent, 225);
            }
        }
    }

    public static lz bm(Context context, String str) {
        com.tencent.mm.sdk.b.b lzVar = new lz();
        lzVar.fTf.type = 6;
        lzVar.fTf.fTl = vBj.vBg;
        lzVar.fTf.toUser = str;
        lzVar.fTf.fTm = vBj.fTm;
        lzVar.fTf.context = context;
        com.tencent.mm.sdk.b.a.urY.m(lzVar);
        vBj.fSJ = lzVar.fTg.fSJ;
        vBj.vBh = lzVar.fTg.fTo;
        return lzVar;
    }

    public static void a(com.tencent.mm.ui.chatting.En_5b8fbb1e.a aVar, db dbVar, String str, long j) {
        Context context = aVar.uSU.uTo;
        if (!u.mA(str) && str.length() > 0) {
            context.getString(R.l.dIO);
            vAY = g.a(context, context.getString(R.l.eRj), false, null);
            db.vGa.c(new b(aVar, context, str, j, vBj));
        }
        if (dbVar != null) {
            dbVar.bUC();
        }
    }
}
