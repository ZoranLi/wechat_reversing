package com.tencent.mm.ui.transmit;

import android.os.Looper;
import com.tencent.mm.R;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.contact.a.d;
import com.tencent.mm.ui.contact.l;
import com.tencent.mm.ui.contact.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public final class a extends o {
    private int count = 0;
    ae handler = new ae(Looper.getMainLooper());
    HashSet<String> ipB;
    j osJ = new j(this) {
        final /* synthetic */ a wpy;

        {
            this.wpy = r1;
        }

        public final void a(g gVar) {
            a aVar = new a(this.wpy);
            aVar.fRM = gVar.lYe.fRM;
            aVar.maj = gVar.maj;
            if (aVar.maj == null || aVar.maj.size() == 0) {
                i iVar = new i();
                iVar.lZO = "no_result​";
                aVar.maj = new ArrayList();
                aVar.maj.add(iVar);
            }
            this.wpy.wpx.add(aVar);
            this.wpy.bZZ();
        }
    };
    List<String> wpv;
    List<com.tencent.mm.plugin.fts.a.a.a> wpw;
    List<a> wpx;

    class AnonymousClass2 implements Runnable {
        final /* synthetic */ a wpy;
        final /* synthetic */ int wpz;

        AnonymousClass2(a aVar, int i) {
            this.wpy = aVar;
            this.wpz = i;
        }

        public final void run() {
            this.wpy.Ci(this.wpz);
        }
    }

    private class a {
        String fRM;
        List<i> maj;
        int mcN = Integer.MAX_VALUE;
        int mcP = Integer.MAX_VALUE;
        boolean wpA = true;
        String wpB;
        final /* synthetic */ a wpy;

        public a(a aVar) {
            this.wpy = aVar;
        }
    }

    public a(l lVar, List<String> list, int i) {
        super(lVar, null, true, true, i);
        this.wpv = list;
        this.wpx = new ArrayList();
        this.ipB = new HashSet();
    }

    public final void finish() {
        super.finish();
        for (com.tencent.mm.plugin.fts.a.a.a cancelSearchTask : this.wpw) {
            ((com.tencent.mm.plugin.fts.a.l) h.j(com.tencent.mm.plugin.fts.a.l.class)).cancelSearchTask(cancelSearchTask);
        }
    }

    protected final com.tencent.mm.ui.contact.a.a hg(int i) {
        com.tencent.mm.ui.contact.a.a aVar = null;
        int size = this.wpx.size() - 1;
        while (size >= 0) {
            com.tencent.mm.ui.contact.a.a gVar;
            a aVar2 = (a) this.wpx.get(size);
            if (aVar2.mcN == i) {
                gVar = new com.tencent.mm.ui.contact.a.g(i);
                gVar.mdo = this.vYf.getActivity().getString(R.l.eQx, new Object[]{aVar2.fRM});
            } else if (aVar2.mcP == i) {
                gVar = new com.tencent.mm.ui.contact.a.i(i);
                gVar.rqp = R.l.enf;
                gVar.waM = aVar2.wpA;
            } else if (i > aVar2.mcN) {
                int i2 = (i - aVar2.mcN) - 1;
                i iVar = (i) aVar2.maj.get(i2);
                if (iVar.lZO.equals("no_result​")) {
                    gVar = new com.tencent.mm.ui.contact.a.h(i);
                } else {
                    aVar = new d(i);
                    aVar.iJC = iVar;
                    aVar.mai = new String[]{aVar2.fRM};
                    aVar.wal = true;
                    aVar.mdf = i2 + 1;
                    aVar.cc(aVar.iJC.type, aVar.iJC.hPr);
                    gVar = aVar;
                }
            } else {
                gVar = aVar;
            }
            if (gVar != null) {
                gVar.fRM = aVar2.fRM;
                gVar.scene = this.scene;
                gVar.vYg = true;
                return gVar;
            }
            size--;
            aVar = gVar;
        }
        return aVar;
    }

    final void bZZ() {
        int i = 0;
        for (a aVar : this.wpx) {
            int size;
            if (aVar.maj.size() > 0) {
                aVar.mcN = i;
                i++;
                if (aVar.maj.size() > 3) {
                    if (aVar.wpA) {
                        i += 3;
                    } else {
                        i += aVar.maj.size();
                    }
                    aVar.mcP = i;
                    i++;
                } else {
                    size = aVar.maj.size() + i;
                }
            } else {
                size = i;
            }
            i = size;
        }
        this.count = i;
        clearCache();
        notifyDataSetChanged();
    }

    public final int getCount() {
        return this.count;
    }

    public final boolean BM(int i) {
        return Ci(i);
    }

    private boolean Ci(int i) {
        int headerViewsCount = i - this.vYf.bcW().getHeaderViewsCount();
        int size = this.wpx.size() - 1;
        while (size >= 0) {
            a aVar = (a) this.wpx.get(size);
            if (aVar.mcP == headerViewsCount) {
                if (aVar.wpA) {
                    size = this.vYf.bcW().getSelectedItemPosition();
                    aVar.wpA = false;
                    bZZ();
                    this.vYf.bcW().setSelection(size);
                } else {
                    Object obj;
                    aVar.wpA = true;
                    headerViewsCount = 0;
                    while (headerViewsCount < aVar.maj.size()) {
                        obj = (i) aVar.maj.get(headerViewsCount);
                        if (obj.lZO.equals(aVar.wpB) && headerViewsCount > 2) {
                            break;
                        }
                        headerViewsCount++;
                    }
                    obj = null;
                    headerViewsCount = 0;
                    if (obj != null) {
                        aVar.maj.remove(headerViewsCount);
                        aVar.maj.add(0, obj);
                    }
                    bZZ();
                    this.vYf.bcW().setSelection(i);
                }
                notifyDataSetChanged();
                return true;
            } else if (headerViewsCount == aVar.mcN) {
                return true;
            } else {
                if (i > aVar.mcN) {
                    i iVar = (i) aVar.maj.get((headerViewsCount - aVar.mcN) - 1);
                    if (!iVar.lZO.equals("no_result​")) {
                        MMCreateChatroomUI mMCreateChatroomUI = (MMCreateChatroomUI) this.vYf;
                        if (u.mA(aVar.wpB)) {
                            if (!this.ipB.contains(iVar.lZO)) {
                                mMCreateChatroomUI.nyd.aK(iVar.lZO, false);
                                aVar.wpB = iVar.lZO;
                                this.ipB.add(aVar.wpB);
                            }
                        } else if (aVar.wpB.equals(iVar.lZO)) {
                            mMCreateChatroomUI.nyd.MG(aVar.wpB);
                            this.ipB.remove(aVar.wpB);
                            aVar.wpB = null;
                        } else if (!this.ipB.contains(iVar.lZO)) {
                            this.ipB.remove(aVar.wpB);
                            mMCreateChatroomUI.nyd.MG(aVar.wpB);
                            aVar.wpB = iVar.lZO;
                            mMCreateChatroomUI.nyd.aK(aVar.wpB, false);
                            this.ipB.add(aVar.wpB);
                        }
                        mMCreateChatroomUI.Ok();
                        notifyDataSetChanged();
                        return true;
                    }
                    return true;
                }
                size--;
            }
        }
        return false;
    }

    public final List<String> caa() {
        Collection hashSet = new HashSet();
        for (a aVar : this.wpx) {
            if (!u.mA(aVar.wpB)) {
                hashSet.add(aVar.wpB);
            }
        }
        List<String> arrayList = new ArrayList();
        arrayList.addAll(hashSet);
        return arrayList;
    }
}
