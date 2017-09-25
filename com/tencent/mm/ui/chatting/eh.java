package com.tencent.mm.ui.chatting;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.ah.k;
import com.tencent.mm.ah.n;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelmulti.j;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvoice.f;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bm;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.transmit.MsgRetransmitUI.a;
import com.tencent.wcdb.FileUtils;
import java.util.LinkedList;
import java.util.List;

public final class eh {

    static class AnonymousClass4 implements d {
        final /* synthetic */ au hlc;
        final /* synthetic */ Context val$context;

        AnonymousClass4(au auVar, Context context) {
            this.hlc = auVar;
            this.val$context = context;
        }

        public final void c(MenuItem menuItem, int i) {
            String str = menuItem.getTitle();
            if (bg.mA(this.hlc.field_imgPath)) {
                w.e("MicroMsg.LongClickBrandServiceHelper", "Transfer fileName erro: fileName null");
                return;
            }
            p md = q.md(this.hlc.field_imgPath);
            w.i("MicroMsg.LongClickBrandServiceHelper", "connector click[voice]: to[%s] filePath[%s]", str, q.c(str, this.hlc.field_imgPath, md == null ? 0 : md.icm));
            ap.vd().a(new f(r0, 1), 0);
            g.oUh.i(10424, Integer.valueOf(34), Integer.valueOf(2), str);
            com.tencent.mm.ui.base.g.bl(this.val$context, this.val$context.getString(R.l.dIy));
        }
    }

    static class AnonymousClass7 implements d {
        final /* synthetic */ String vOu;
        final /* synthetic */ Context val$context;

        AnonymousClass7(String str, Context context) {
            this.vOu = str;
            this.val$context = context;
        }

        public final void c(MenuItem menuItem, int i) {
            w.i("MicroMsg.LongClickBrandServiceHelper", "connector click[location]: to[%s] content[%s]", menuItem.getTitle(), this.vOu);
            ap.vd().a(new j(r0, this.vOu, 48), 0);
            g.oUh.i(10424, Integer.valueOf(48), Integer.valueOf(16), r0);
            com.tencent.mm.ui.base.g.bl(this.val$context, this.val$context.getString(R.l.dIy));
        }
    }

    static class AnonymousClass8 implements d {
        final /* synthetic */ String vOv;
        final /* synthetic */ Context val$context;

        AnonymousClass8(String str, Context context) {
            this.vOv = str;
            this.val$context = context;
        }

        public final void c(MenuItem menuItem, int i) {
            w.i("MicroMsg.LongClickBrandServiceHelper", "connector click[location]: to[%s] content[%s]", menuItem.getTitle(), this.vOv);
            ap.vd().a(new j(r0, this.vOv, 42), 0);
            g.oUh.i(10424, Integer.valueOf(42), Integer.valueOf(32), r0);
            com.tencent.mm.ui.base.g.bl(this.val$context, this.val$context.getString(R.l.dIy));
        }
    }

    public static void k(final String str, final Context context) {
        if (context == null) {
            w.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptTextConnector: context is null");
        } else if (bg.mA(str)) {
            w.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptTextConnector: content is null");
        } else {
            a(cB(com.tencent.mm.modelbiz.w.DH().fw(1)), context, new d() {
                public final void c(MenuItem menuItem, int i) {
                    String str = menuItem.getTitle();
                    w.i("MicroMsg.LongClickBrandServiceHelper", "connector click[text]: to[%s] text[%s]", str, str);
                    ap.vd().a(new j(str, str, o.fG(str)), 0);
                    g.oUh.i(10424, Integer.valueOf(1), Integer.valueOf(1), str);
                    com.tencent.mm.ui.base.g.bl(context, context.getString(R.l.dIy));
                }
            });
        }
    }

    public static void a(final au auVar, final Context context, final String str, final boolean z) {
        if (context == null) {
            w.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptImgConnector: context is null");
        } else if (auVar == null) {
            w.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptImgConnector: msg is null");
        } else {
            ap.yY();
            if (c.isSDCardAvailable()) {
                a(cB(com.tencent.mm.modelbiz.w.DH().fw(4)), context, new d() {
                    public final void c(MenuItem menuItem, int i) {
                        com.tencent.mm.ah.d aj;
                        com.tencent.mm.ah.d ai;
                        int i2 = true;
                        String str = menuItem.getTitle();
                        if (auVar.field_msgId > 0) {
                            aj = n.GS().aj(auVar.field_msgId);
                        } else {
                            aj = null;
                        }
                        if ((aj == null || aj.hEY <= 0) && auVar.field_msgSvrId > 0) {
                            ai = n.GS().ai(auVar.field_msgSvrId);
                        } else {
                            ai = aj;
                        }
                        if (ai == null) {
                            w.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptImgConnector: try get imgInfo fail");
                        } else if (ai.offset < ai.hrs || ai.hrs == 0) {
                            String str2;
                            Bundle bundle;
                            Intent intent = new Intent(context, ImageGalleryUI.class);
                            intent.putExtra("img_gallery_msg_id", auVar.field_msgId);
                            intent.putExtra("img_gallery_msg_svr_id", auVar.field_msgSvrId);
                            intent.putExtra("img_gallery_talker", auVar.field_talker);
                            intent.putExtra("img_gallery_chatroom_name", auVar.field_talker);
                            intent.putExtra("img_gallery_is_restransmit_after_download", true);
                            intent.putExtra("img_gallery_directly_send_name", str);
                            intent.putExtra("start_chatting_ui", false);
                            str = auVar.field_talker;
                            Bundle bundle2 = new Bundle();
                            if (z) {
                                str2 = "stat_scene";
                                i2 = 2;
                                bundle = bundle2;
                            } else {
                                str2 = "stat_scene";
                                if (o.eV(str)) {
                                    i2 = 7;
                                    bundle = bundle2;
                                } else {
                                    bundle = bundle2;
                                }
                            }
                            bundle.putInt(str2, i2);
                            bundle2.putString("stat_msg_id", "msg_" + Long.toString(auVar.field_msgSvrId));
                            bundle2.putString("stat_chat_talker_username", str);
                            bundle2.putString("stat_send_msg_user", str);
                            intent.putExtra("_stat_obj", bundle2);
                            context.startActivity(intent);
                        } else {
                            int i3;
                            if (auVar.field_isSend == 1) {
                                boolean z;
                                if (ai.GB()) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                i3 = z;
                            } else if (!ai.GB()) {
                                i3 = 0;
                            } else if (e.aO(com.tencent.mm.ah.e.a(ai).hEZ)) {
                                i3 = 1;
                            } else {
                                i3 = 0;
                            }
                            String xL = m.xL();
                            String m = n.GS().m(com.tencent.mm.ah.e.c(ai), "", "");
                            if (!bg.mA(m)) {
                                w.i("MicroMsg.LongClickBrandServiceHelper", "connector click[img]: to[%s] fileName[%s]", str, m);
                                ap.vd().a(new k(4, xL, str, m, i3, null, 0, "", "", true, R.g.bdJ), 0);
                                bm.zN().c(bm.hnW, null);
                            }
                            g.oUh.i(10424, Integer.valueOf(3), Integer.valueOf(4), str);
                            com.tencent.mm.ui.base.g.bl(context, context.getString(R.l.dIy));
                        }
                    }
                });
                return;
            }
            s.eP(context);
            w.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptImgConnector: sd card is not available");
        }
    }

    public static void a(final au auVar, final Context context) {
        if (context == null) {
            w.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVideoConnector: context is null");
        } else if (auVar == null) {
            w.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVideoConnector: msg is null");
        } else {
            ap.yY();
            if (c.isSDCardAvailable()) {
                a(cB(com.tencent.mm.modelbiz.w.DH().fw(8)), context, new d() {
                    public final void c(MenuItem menuItem, int i) {
                        String str = menuItem.getTitle();
                        r lH = t.lH(auVar.field_imgPath);
                        w.i("MicroMsg.LongClickBrandServiceHelper", "connector click[video]: to[%s] imgPath[%s]", str, auVar.field_imgPath);
                        final a aVar = new a();
                        Context context = context;
                        context.getResources().getString(R.l.dIO);
                        Dialog a = com.tencent.mm.ui.base.g.a(context, context.getResources().getString(R.l.dIB), true, new OnCancelListener(this) {
                            final /* synthetic */ AnonymousClass6 vOt;

                            public final void onCancel(DialogInterface dialogInterface) {
                                aVar.wqp = true;
                            }
                        });
                        aVar.context = context;
                        aVar.fyF = auVar.field_imgPath;
                        aVar.ita = a;
                        aVar.userName = str;
                        aVar.wpP = lH.iat;
                        aVar.iap = lH.iap;
                        aVar.execute(new Object[0]);
                        bm.zN().c(bm.hnX, null);
                        com.tencent.mm.ui.base.g.bl(context, context.getString(R.l.dIy));
                    }
                });
                return;
            }
            s.eP(context);
            w.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVideoConnector: sd card is not available");
        }
    }

    public static void b(final au auVar, final Context context) {
        if (context == null) {
            w.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptEmojiConnector: context is null");
        } else if (auVar == null) {
            w.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptEmojiConnector: msg is null");
        } else {
            ap.yY();
            if (c.isSDCardAvailable()) {
                a(cB(com.tencent.mm.modelbiz.w.DH().fw(64)), context, new d() {
                    public final void c(MenuItem menuItem, int i) {
                        String str;
                        String str2 = menuItem.getTitle();
                        String str3 = aj.RD(auVar.field_content).fFW;
                        if (str3 == null || str3.endsWith("-1")) {
                            str = auVar.field_imgPath;
                        } else {
                            str = str3;
                        }
                        if (str == null) {
                            w.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptEmojiConnector: filePath is null");
                            return;
                        }
                        w.i("MicroMsg.LongClickBrandServiceHelper", "connector click[emoji]: to[%s] filePath[%s]", str2, str);
                        if (((com.tencent.mm.plugin.emoji.b.c) h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().l(context, str2, str)) {
                            g.oUh.i(10424, Integer.valueOf(47), Integer.valueOf(64), str2);
                            com.tencent.mm.ui.base.g.bl(context, "");
                        }
                        g.oUh.i(10424, Integer.valueOf(47), Integer.valueOf(64), str2);
                        com.tencent.mm.ui.base.g.bl(context, context.getString(R.l.dIy));
                    }
                });
                return;
            }
            s.eP(context);
            w.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptEmojiConnector: sd card is not available");
        }
    }

    public static void a(au auVar, String str, Context context) {
        a(auVar, str, context, 512);
    }

    public static void b(au auVar, String str, Context context) {
        a(auVar, str, context, 256);
    }

    public static void c(au auVar, String str, Context context) {
        a(auVar, str, context, (int) FileUtils.S_IWUSR);
    }

    private static void a(final au auVar, final String str, final Context context, final int i) {
        if (context == null) {
            w.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptMusicConnector: context is null");
        } else if (auVar == null) {
            w.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptMusicConnector: msg is null");
        } else {
            List list = null;
            switch (i) {
                case FileUtils.S_IWUSR /*128*/:
                    list = cB(com.tencent.mm.modelbiz.e.Dv());
                    break;
                case 256:
                    list = cB(com.tencent.mm.modelbiz.w.DH().fw(256));
                    break;
                case 512:
                    list = cB(com.tencent.mm.modelbiz.w.DH().fw(512));
                    break;
            }
            a(list, context, new d() {
                public final void c(MenuItem menuItem, int i) {
                    eh.a(menuItem.getTitle(), auVar, str);
                    switch (i) {
                        case FileUtils.S_IWUSR /*128*/:
                            g.oUh.i(10424, Integer.valueOf(49), Integer.valueOf(FileUtils.S_IWUSR), r0);
                            break;
                        case 256:
                            g.oUh.i(10424, Integer.valueOf(49), Integer.valueOf(256), r0);
                            break;
                        case 512:
                            g.oUh.i(10424, Integer.valueOf(49), Integer.valueOf(512), r0);
                            break;
                    }
                    com.tencent.mm.ui.base.g.bl(context, context.getString(R.l.dIy));
                }
            });
        }
    }

    static List<String> cB(List<String> list) {
        List<String> linkedList = new LinkedList();
        for (String str : list) {
            if (!com.tencent.mm.modelbiz.e.hZ(str)) {
                linkedList.add(str);
            }
        }
        w.d("MicroMsg.LongClickBrandServiceHelper", "get selected accept list, size %d", Integer.valueOf(linkedList.size()));
        return linkedList;
    }

    public static void a(String str, au auVar, String str2) {
        int i = 1;
        com.tencent.mm.t.f.a ek = com.tencent.mm.t.f.a.ek(bg.PX(str2));
        if (ek == null) {
            w.w("MicroMsg.LongClickBrandServiceHelper", "send: parse app msg content return null");
            return;
        }
        byte[] c;
        b bVar;
        long j;
        String str3;
        com.tencent.mm.t.f.a a;
        if (!(auVar.field_imgPath == null || auVar.field_imgPath.equals(""))) {
            String v = n.GS().v(auVar.field_imgPath, i);
            try {
                c = e.c(v, 0, e.aN(v));
            } catch (Exception e) {
                w.e("MicroMsg.LongClickBrandServiceHelper", "send appmsg to %s, error:%s", str, e.getLocalizedMessage());
            }
            bVar = new b();
            if (!bg.mA(ek.fCW)) {
                j = bg.getLong(ek.fCW, -1);
                if (j == -1) {
                    an.abL().b(j, (com.tencent.mm.sdk.e.c) bVar);
                    if (bVar.uxb != j) {
                        bVar = an.abL().LW(ek.fCW);
                        if (bVar == null || !bVar.field_mediaSvrId.equals(ek.fCW)) {
                            bVar = null;
                        }
                    }
                } else {
                    bVar = an.abL().LW(ek.fCW);
                    if (bVar == null || !bVar.field_mediaSvrId.equals(ek.fCW)) {
                        bVar = null;
                    }
                }
            }
            str3 = "";
            if (!(bVar == null || bVar.field_fileFullPath == null || bVar.field_fileFullPath.equals(""))) {
                ap.yY();
                str3 = l.W(c.xn(), ek.title, ek.hhr);
                com.tencent.mm.sdk.platformtools.j.p(bVar.field_fileFullPath, str3, false);
            }
            a = com.tencent.mm.t.f.a.a(ek);
            a.hht = 3;
            l.a(a, ek.appId, ek.appName, str, str3, c, null);
        }
        c = null;
        bVar = new b();
        if (bg.mA(ek.fCW)) {
            j = bg.getLong(ek.fCW, -1);
            if (j == -1) {
                bVar = an.abL().LW(ek.fCW);
                bVar = null;
            } else {
                an.abL().b(j, (com.tencent.mm.sdk.e.c) bVar);
                if (bVar.uxb != j) {
                    bVar = an.abL().LW(ek.fCW);
                    bVar = null;
                }
            }
        }
        str3 = "";
        ap.yY();
        str3 = l.W(c.xn(), ek.title, ek.hhr);
        com.tencent.mm.sdk.platformtools.j.p(bVar.field_fileFullPath, str3, false);
        a = com.tencent.mm.t.f.a.a(ek);
        a.hht = 3;
        l.a(a, ek.appId, ek.appName, str, str3, c, null);
    }

    static void a(final List<String> list, final Context context, d dVar) {
        if (list == null || list.isEmpty()) {
            w.w("MicroMsg.LongClickBrandServiceHelper", "tryShowConnectorDialog: careList is null or empty");
            return;
        }
        com.tencent.mm.ui.tools.l lVar = new com.tencent.mm.ui.tools.l(context);
        lVar.wnf = new com.tencent.mm.ui.base.n.a() {
            public final void a(ImageView imageView, MenuItem menuItem) {
                com.tencent.mm.pluginsdk.ui.a.b.a(imageView, menuItem.getTitle());
            }
        };
        lVar.wng = new com.tencent.mm.ui.base.n.b() {
            public final void a(TextView textView, MenuItem menuItem) {
                if (textView != null) {
                    ap.yY();
                    com.tencent.mm.j.a Rc = c.wR().Rc(menuItem.getTitle());
                    if (Rc == null || ((int) Rc.gTQ) <= 0) {
                        textView.setText(menuItem.getTitle());
                    } else {
                        textView.setText(com.tencent.mm.pluginsdk.ui.d.h.b(context, Rc.tK(), textView.getTextSize()));
                    }
                }
            }
        };
        lVar.qJf = new com.tencent.mm.ui.base.n.c() {
            public final void a(com.tencent.mm.ui.base.l lVar) {
                for (CharSequence add : list) {
                    lVar.add(add);
                }
            }
        };
        lVar.qJg = dVar;
        lVar.blb();
    }
}
