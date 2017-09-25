package com.tencent.mm.ui.transmit;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.jf;
import com.tencent.mm.kernel.h;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fts.a.a.f;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.pluginsdk.e.b;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.i;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.n;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.p.a;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public class MMCreateChatroomUI extends MMBaseSelectContactUI {
    private String chatroomName;
    private ProgressDialog isv;
    private int scene;
    private b vLp = new b(this) {
        final /* synthetic */ MMCreateChatroomUI wpJ;

        {
            this.wpJ = r2;
        }

        public final void a(int i, int i2, String str, com.tencent.mm.sdk.b.b bVar) {
            int i3 = 0;
            if (bVar instanceof jf) {
                jf jfVar = (jf) bVar;
                if (this.wpJ.vZz != null) {
                    if (this.wpJ.isv != null) {
                        this.wpJ.isv.dismiss();
                        this.wpJ.isv = null;
                    }
                    this.wpJ.vZz = null;
                    this.wpJ.vZy = false;
                    this.wpJ.chatroomName = jfVar.fPo.fPs;
                    if (!a.a(this.wpJ, i, i2, str, 4)) {
                        String i4;
                        if (i == 0 && i2 == 0 && !bg.mA(this.wpJ.chatroomName)) {
                            i.a(this.wpJ.chatroomName, jfVar.fPo.fPx, this.wpJ.getString(R.l.dTa), false, "");
                            List list = jfVar.fPo.fPw;
                            if (list != null && list.size() > 0) {
                                List linkedList = new LinkedList();
                                while (i3 < list.size()) {
                                    linkedList.add(list.get(i3));
                                    i3++;
                                }
                                i.a(this.wpJ.chatroomName, linkedList, this.wpJ.getString(R.l.dTb), true, "weixin://findfriend/verifycontact/" + this.wpJ.chatroomName + "/");
                            }
                            i4 = this.wpJ.chatroomName;
                            Intent intent = new Intent();
                            if (this.wpJ.wpF) {
                                intent.putExtra("Chat_User", i4);
                                d.a(this.wpJ, ".ui.chatting.En_5b8fbb1e", intent);
                            } else {
                                intent.putExtra("Select_Contact", i4);
                                intent.putExtra("Select_Conv_User", i4);
                                intent.putExtra("Select_Contact", i4);
                                intent.putExtra("need_delete_chatroom_when_cancel", true);
                                this.wpJ.setResult(-1, intent);
                            }
                            this.wpJ.finish();
                            return;
                        }
                        String str2 = "";
                        i4 = "";
                        String string = ab.getContext().getString(R.l.dTc);
                        if (i2 == -23) {
                            str2 = this.wpJ.getString(R.l.eMO);
                            i4 = this.wpJ.getString(R.l.eMN);
                        }
                        List list2 = jfVar.fPo.fPw;
                        List list3 = jfVar.fPo.fPu;
                        if (list2 == null || list2.size() <= 0 || (list2.size() != jfVar.fPo.fPr && (list3 == null || list3.size() <= 0 || jfVar.fPo.fPr != list2.size() + list3.size()))) {
                            list2 = jfVar.fPo.fPu;
                            if (list2 != null && list2.size() > 0 && jfVar.fPo.fPr == list2.size()) {
                                str2 = this.wpJ.getString(R.l.ewe);
                                i4 = i4 + this.wpJ.getString(R.l.elw, new Object[]{bg.c(MMCreateChatroomUI.ae(list2), string)});
                            }
                            list2 = jfVar.fPo.fPt;
                            if (list2 != null && list2.size() > 0) {
                                str2 = this.wpJ.getString(R.l.ewe);
                                i4 = i4 + this.wpJ.getString(R.l.elx, new Object[]{bg.c(MMCreateChatroomUI.ae(list2), string)});
                            }
                            if (str2 == null || str2.length() <= 0) {
                                Toast.makeText(this.wpJ, this.wpJ.getString(R.l.elo, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                                return;
                            }
                            g.b(this.wpJ, i4, str2, true);
                            return;
                        }
                        LinkedList linkedList2 = new LinkedList();
                        for (int i5 = 0; i5 < list2.size(); i5++) {
                            linkedList2.add(list2.get(i5));
                        }
                        MMCreateChatroomUI.a(this.wpJ, linkedList2, list3);
                    }
                }
            }
        }
    };
    private boolean vZy;
    private jf vZz;
    private boolean wpF;
    a wpG;
    private b wpH;
    private boolean wpI;
    private List<String> wpv;

    static /* synthetic */ void a(MMCreateChatroomUI mMCreateChatroomUI, LinkedList linkedList) {
        int i = 0;
        Assert.assertTrue(linkedList.size() > 0);
        LinkedList linkedList2 = new LinkedList();
        while (i < linkedList.size()) {
            linkedList2.add(Integer.valueOf(3));
            i++;
        }
        new m(mMCreateChatroomUI, new m.a(mMCreateChatroomUI) {
            final /* synthetic */ MMCreateChatroomUI wpJ;

            {
                this.wpJ = r1;
            }

            public final void dl(boolean z) {
            }
        }).g(linkedList, linkedList2);
    }

    static /* synthetic */ void a(MMCreateChatroomUI mMCreateChatroomUI, final LinkedList linkedList, List list) {
        Assert.assertTrue(linkedList.size() > 0);
        String string = ab.getContext().getString(R.l.dTc);
        List arrayList = new ArrayList();
        arrayList.addAll(linkedList);
        arrayList.addAll(list);
        Object[] objArr = new Object[]{bg.c(ae(arrayList), string)};
        g.a(mMCreateChatroomUI, mMCreateChatroomUI.getString(R.l.elC, objArr), mMCreateChatroomUI.getString(R.l.ewe), mMCreateChatroomUI.getString(R.l.elB), mMCreateChatroomUI.getString(R.l.elA), true, new OnClickListener(mMCreateChatroomUI) {
            final /* synthetic */ MMCreateChatroomUI wpJ;

            public final void onClick(DialogInterface dialogInterface, int i) {
                MMCreateChatroomUI.a(this.wpJ, linkedList);
            }
        }, null);
    }

    static /* synthetic */ void b(MMCreateChatroomUI mMCreateChatroomUI) {
        mMCreateChatroomUI.vZz = new jf();
        mMCreateChatroomUI.vZz.fPn.fPp = "";
        mMCreateChatroomUI.vZz.fPn.fPq = mMCreateChatroomUI.wpG.caa();
        com.tencent.mm.sdk.b.a.urY.m(mMCreateChatroomUI.vZz);
        mMCreateChatroomUI.getString(R.l.dIO);
        mMCreateChatroomUI.isv = g.a(mMCreateChatroomUI, mMCreateChatroomUI.getString(R.l.ewf), true, new OnCancelListener(mMCreateChatroomUI) {
            final /* synthetic */ MMCreateChatroomUI wpJ;

            {
                this.wpJ = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                this.wpJ.vZy = false;
                if (this.wpJ.vZz != null) {
                    this.wpJ.vZz.fPn.fPm = true;
                    com.tencent.mm.sdk.b.a.urY.m(this.wpJ.vZz);
                }
            }
        });
    }

    public final /* bridge */ /* synthetic */ o bYc() {
        return this.wpG;
    }

    protected final void Oe() {
        super.Oe();
        this.wpv = getIntent().getStringArrayListExtra("query_phrase_list");
        this.wpF = getIntent().getBooleanExtra("go_to_chatroom_direct", false);
        this.scene = getIntent().getIntExtra("scene_from", 0);
    }

    protected final void KC() {
        super.KC();
        a aVar = this.wpG;
        for (String str : aVar.wpv) {
            f fVar = new f();
            fVar.handler = aVar.handler;
            fVar.mag = aVar.osJ;
            fVar.fRM = str;
            fVar.maf = com.tencent.mm.plugin.fts.a.b.b.maC;
            fVar.maa = new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT};
            fVar.mae.add("filehelper");
            fVar.mae.add(com.tencent.mm.u.m.xL());
            com.tencent.mm.plugin.fts.a.a.a search = ((l) h.j(l.class)).search(2, fVar);
            aVar.wpw = new ArrayList();
            aVar.wpw.add(search);
        }
        a(1, getString(R.l.dHT), new OnMenuItemClickListener(this) {
            final /* synthetic */ MMCreateChatroomUI wpJ;

            {
                this.wpJ = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (!this.wpJ.vZy) {
                    this.wpJ.vZy = true;
                    MMCreateChatroomUI.b(this.wpJ);
                    if (this.wpJ.scene == 3) {
                        this.wpJ.wpI = true;
                        com.tencent.mm.as.g.bm(true);
                    }
                }
                w.i("MicroMsg.MMCreateChatroomUI", "Create the chatroom");
                return true;
            }
        }, com.tencent.mm.ui.l.b.uTY);
        Ok();
        b.a(jf.class.getName(), this.vLp);
    }

    public final void Ok() {
        List caa = this.wpG.caa();
        if (caa.size() > 0) {
            aB(1, getString(R.l.dHT) + "(" + caa.size() + ")");
            if (caa.size() > 1) {
                ae(1, true);
                return;
            } else {
                ae(1, false);
                return;
            }
        }
        aB(1, getString(R.l.dHT));
        ae(1, false);
    }

    protected void onDestroy() {
        this.wpG.finish();
        b.b(jf.class.getName(), this.vLp);
        if (!this.wpI && this.scene == 3) {
            com.tencent.mm.as.g.bm(false);
        }
        super.onDestroy();
    }

    protected final boolean Of() {
        return false;
    }

    protected final boolean Og() {
        return false;
    }

    protected final String Oh() {
        return getString(R.l.eQy);
    }

    protected final o Oi() {
        if (this.wpG == null) {
            this.wpG = new a(this, this.wpv, this.scene);
        }
        return this.wpG;
    }

    protected final com.tencent.mm.ui.contact.m Oj() {
        if (this.wpH == null) {
            this.wpH = new b(this, this.scene);
        }
        return this.wpH;
    }

    public final boolean b(com.tencent.mm.ui.contact.a.a aVar) {
        if (!(aVar instanceof com.tencent.mm.ui.contact.a.d)) {
            return false;
        }
        com.tencent.mm.ui.contact.a.d dVar = (com.tencent.mm.ui.contact.a.d) aVar;
        a aVar2 = this.wpG;
        String str = dVar.iJC.lZO;
        int i = aVar.position;
        if (aVar2.ipB.contains(str)) {
            a aVar3;
            for (int size = aVar2.wpx.size() - 1; size >= 0; size--) {
                aVar3 = (a) aVar2.wpx.get(size);
                if (i >= aVar3.mcN) {
                    break;
                }
            }
            aVar3 = null;
            if (aVar3 == null) {
                return false;
            }
            if (!str.equals(aVar3.wpB)) {
                return true;
            }
        }
        return false;
    }

    public final boolean a(com.tencent.mm.ui.contact.a.a aVar) {
        if (!(aVar instanceof com.tencent.mm.ui.contact.a.d)) {
            return false;
        }
        com.tencent.mm.ui.contact.a.d dVar = (com.tencent.mm.ui.contact.a.d) aVar;
        a aVar2 = this.wpG;
        if (aVar2.ipB.contains(dVar.iJC.lZO)) {
            return true;
        }
        return false;
    }

    private static List<String> ae(List<String> list) {
        List<String> linkedList = new LinkedList();
        if (!ap.zb()) {
            return linkedList;
        }
        if (list == null) {
            return linkedList;
        }
        for (Object obj : list) {
            Object obj2;
            ap.yY();
            com.tencent.mm.j.a Rc = c.wR().Rc(obj2);
            if (!(Rc == null || ((int) Rc.gTQ) == 0)) {
                obj2 = Rc.tL();
            }
            linkedList.add(obj2);
        }
        return linkedList;
    }

    public final boolean bYj() {
        return true;
    }

    public final void hf(int i) {
        n nVar = this.wpG;
        List list = this.wpH.maj;
        String str = this.wpH.fRM;
        if (!(list.size() == 1 && ((com.tencent.mm.plugin.fts.a.a.i) list.get(0)).lZO.equals("no_result​"))) {
            a aVar = new a(nVar);
            aVar.maj = list;
            aVar.fRM = str;
            nVar.wpx.add(aVar);
            int headerViewsCount = i - nVar.vYf.bcW().getHeaderViewsCount();
            if (headerViewsCount >= 3) {
                list.add(0, (com.tencent.mm.plugin.fts.a.a.i) list.remove(headerViewsCount));
                i = nVar.vYf.bcW().getHeaderViewsCount();
            }
            nVar.bZZ();
            nVar.vYf.bcW().post(new com.tencent.mm.ui.transmit.a.AnonymousClass2(nVar, (aVar.mcN + i) + 1));
        }
        bYh();
        bYi();
        aHf();
    }

    public final void mK(String str) {
        a aVar = this.wpG;
        aVar.ipB.remove(str);
        for (a aVar2 : aVar.wpx) {
            if (str.equals(aVar2.wpB)) {
                aVar2.wpB = null;
            }
        }
        aVar.notifyDataSetChanged();
        Ok();
    }
}
