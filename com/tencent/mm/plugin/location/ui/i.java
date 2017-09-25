package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.plugin.location.model.l;
import com.tencent.mm.plugin.location.ui.h.c;
import com.tencent.mm.plugin.location.ui.impl.TrackPoint;
import com.tencent.mm.plugin.p.d;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.m;
import com.tencent.mm.u.n;
import java.util.ArrayList;
import java.util.Iterator;

public final class i implements c, com.tencent.mm.plugin.location.ui.k.a {
    private Context context;
    private String kuR = "";
    private d ndG;
    private ViewGroup nef;
    private View neg;
    private h neh;
    private j nei;
    private ArrayList<String> nej;
    private String nek = "";
    private boolean nel = false;
    public a nem;

    public interface a {
        void zz(String str);
    }

    public i(Context context, ViewGroup viewGroup, View view, String str, d dVar) {
        this.nef = viewGroup;
        this.neg = view;
        this.context = context;
        this.nej = new ArrayList();
        this.kuR = str;
        this.ndG = dVar;
        init();
    }

    private void init() {
        w.d("MicroMsg.ShareHeaderMgr", "init ShareHeaderMgr, roomname=%s", new Object[]{this.kuR});
        this.neh = new h(this.context, this.neg, this.kuR);
        this.neh.ndW = this;
        this.nei = new j(this.context, this.nef, this.kuR);
        for (String add : l.aGf().zq(this.kuR)) {
            this.nej.add(add);
        }
    }

    public final void I(ArrayList<String> arrayList) {
        w.d("MicroMsg.ShareHeaderMgr", "onRefreshMemberList, members.size=%d", new Object[]{Integer.valueOf(arrayList.size())});
        this.neh.I(arrayList);
        j jVar = this.nei;
        w.d("MicroMsg.ShareHeaderMsgMgr", "onRefreshMemberList, size=%d", new Object[]{Integer.valueOf(arrayList.size())});
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (jVar.neo.indexOf(str) == -1) {
                arrayList2.add(str);
            }
        }
        it = jVar.neo.iterator();
        while (it.hasNext()) {
            str = (String) it.next();
            if (arrayList.indexOf(str) == -1) {
                arrayList3.add(str);
            }
        }
        if (jVar.neB) {
            jVar.neB = false;
            if (arrayList2.size() > 0) {
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    jVar.neo.add((String) it2.next());
                }
            }
            jVar.fo(false);
            return;
        }
        if (arrayList2.size() > 0) {
            str = (String) arrayList2.get(0);
            jVar.neo.add(str);
            if (!bg.mA(n.eK(str))) {
                jVar.mHandler.removeMessages(3);
                Message obtain = Message.obtain();
                obtain.what = 3;
                obtain.obj = str;
                jVar.mHandler.sendMessage(obtain);
                jVar.fo(true);
            }
        }
        if (arrayList3.size() > 0) {
            str = (String) arrayList3.get(0);
            if (!bg.mA(str) && jVar.neo.indexOf(str) != -1) {
                jVar.neo.remove(jVar.neo.indexOf(str));
                if (!bg.mA(n.eK(str))) {
                    obtain = Message.obtain();
                    obtain.what = 4;
                    obtain.obj = str;
                    jVar.mHandler.sendMessage(obtain);
                    jVar.fo(true);
                }
            }
        }
    }

    public final void zz(String str) {
        if (this.nem != null) {
            this.nem.zz(str);
        }
    }

    public final void aGE() {
        w.d("MicroMsg.ShareHeaderMgr", "onMyselfTalking");
        this.nel = true;
        String xL = m.xL();
        this.neh.aGA();
        this.neh.zw(xL);
        j jVar = this.nei;
        w.d("MicroMsg.ShareHeaderMsgMgr", "onMyselfTalking");
        jVar.mHandler.removeMessages(6);
        jVar.mHandler.removeMessages(5);
        Message obtain = Message.obtain();
        obtain.what = 6;
        jVar.mHandler.sendMessageAtFrontOfQueue(obtain);
        View viewByItag = this.ndG.getViewByItag(xL);
        if (viewByItag instanceof TrackPoint) {
            viewByItag.bringToFront();
            this.ndG.invalidate();
        }
        this.nek = xL;
    }

    public final void zA(String str) {
        w.d("MicroMsg.ShareHeaderMgr", "onCurTalkerChange, username = %s", new Object[]{str});
        if (!this.nel) {
            this.nek = str;
            h hVar = this.neh;
            String str2 = this.nek;
            w.i("MicroMsg.ShareHeaderAvatarViewMgr", "onCurMemberChange, username=%s", new Object[]{str2});
            if (bg.mA(str2)) {
                hVar.aGA();
            } else {
                hVar.aGA();
                hVar.zw(str2);
            }
            j jVar = this.nei;
            str2 = this.nek;
            w.d("MicroMsg.ShareHeaderMsgMgr", "onCurMemberChange, curMember=%s", new Object[]{str2});
            if (bg.mA(str2)) {
                jVar.neG = false;
                jVar.mHandler.removeMessages(10);
                Message obtain = Message.obtain();
                obtain.what = 10;
                jVar.mHandler.sendMessage(obtain);
                jVar.fo(true);
            } else {
                if (!bg.mA(n.eK(str2))) {
                    jVar.neG = true;
                    jVar.mHandler.removeMessages(5);
                    Message obtain2 = Message.obtain();
                    obtain2.what = 5;
                    obtain2.obj = str2;
                    jVar.mHandler.sendMessageAtFrontOfQueue(obtain2);
                }
                jVar.fo(true);
            }
            View viewByItag = this.ndG.getViewByItag(this.nek);
            if (viewByItag instanceof TrackPoint) {
                viewByItag.bringToFront();
                this.ndG.invalidate();
            }
        }
    }

    public final void aGF() {
        w.i("MicroMsg.ShareHeaderMgr", "onMyselfFinishTalking");
        h hVar = this.neh;
        String xL = m.xL();
        w.d("MicroMsg.ShareHeaderAvatarViewMgr", "onMemberFinishTalking, username=%s", new Object[]{xL});
        if (hVar.ndV.zy(xL)) {
            hVar.ndV.zx(xL).aGD();
            hVar.ndV.notifyDataSetChanged();
            hVar.ndU.invalidate();
        }
        j jVar = this.nei;
        w.d("MicroMsg.ShareHeaderMsgMgr", "onMyselfFinishTalking");
        jVar.mHandler.removeMessages(9);
        jVar.mHandler.removeMessages(10);
        Message obtain = Message.obtain();
        obtain.what = 9;
        jVar.mHandler.sendMessage(obtain);
        this.nek = "";
        this.nel = false;
    }

    public final void aGG() {
        j jVar = this.nei;
        w.d("MicroMsg.ShareHeaderMsgMgr", "onPrepareTalking");
        jVar.mHandler.removeMessages(8);
        Message obtain = Message.obtain();
        obtain.what = 8;
        jVar.mHandler.sendMessageAtFrontOfQueue(obtain);
    }

    public final void zB(String str) {
        j jVar = this.nei;
        w.d("MicroMsg.ShareHeaderMsgMgr", "onTalkConflict, username=%s", new Object[]{str});
        if (!bg.mA(str) && !bg.mA(n.eK(str))) {
            jVar.neG = true;
            jVar.mHandler.removeMessages(7);
            Message obtain = Message.obtain();
            obtain.what = 7;
            jVar.mHandler.sendMessageAtFrontOfQueue(obtain);
        }
    }
}
