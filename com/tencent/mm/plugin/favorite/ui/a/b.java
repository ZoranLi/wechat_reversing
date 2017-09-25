package com.tencent.mm.plugin.favorite.ui.a;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView;
import com.tencent.mm.R;
import com.tencent.mm.e.a.jc;
import com.tencent.mm.plugin.favorite.b.j;
import com.tencent.mm.plugin.favorite.b.x;
import com.tencent.mm.plugin.favorite.c.g;
import com.tencent.mm.plugin.favorite.ui.c.a;
import com.tencent.mm.plugin.favorite.ui.c.d;
import com.tencent.mm.plugin.favorite.ui.c.f;
import com.tencent.mm.plugin.favorite.ui.c.h;
import com.tencent.mm.plugin.favorite.ui.c.i;
import com.tencent.mm.plugin.favorite.ui.c.k;
import com.tencent.mm.plugin.favorite.ui.c.l;
import com.tencent.mm.plugin.favorite.ui.c.m;
import com.tencent.mm.plugin.favorite.ui.c.n;
import com.tencent.mm.plugin.favorite.ui.c.o;
import com.tencent.mm.plugin.favorite.ui.c.p;
import com.tencent.mm.plugin.favorite.ui.c.q;
import com.tencent.mm.plugin.favorite.ui.c.r;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public final class b extends a {
    private c iOT;
    private boolean lIX;
    public List<j> lIY;
    private List<j> lIZ;
    private List<j> lJa;
    public List<Long> lJb;
    public boolean lJc;
    private Map<Long, j> lJd;
    private List<Integer> lJe;
    private List<String> lJf;
    private List<String> lJg;
    private SparseArray<a> lJh;
    private boolean lJi;
    public a.c lJj;
    public boolean lJk;
    public boolean lJl;

    public final /* synthetic */ Object getItem(int i) {
        return mx(i);
    }

    public b(g gVar, boolean z) {
        this.lIX = false;
        this.lIY = new ArrayList();
        this.lIZ = new ArrayList();
        this.lJa = new LinkedList();
        this.lJb = new ArrayList();
        this.lJc = false;
        this.lJd = new TreeMap();
        this.lJe = new ArrayList();
        this.lJf = new LinkedList();
        this.lJg = new LinkedList();
        this.lJh = new SparseArray();
        this.lJi = false;
        this.lJk = false;
        this.lJl = false;
        this.iOT = new c<jc>(this) {
            final /* synthetic */ b lJm;

            {
                this.lJm = r2;
                this.usg = jc.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                jc jcVar = (jc) bVar;
                if (jcVar instanceof jc) {
                    switch (jcVar.fPc.action) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                            this.lJm.notifyDataSetChanged();
                            break;
                    }
                }
                return false;
            }
        };
        this.type = -1;
        this.lJh.put(1, new m(gVar));
        this.lJh.put(2, new d(gVar));
        this.lJh.put(3, new q(gVar));
        this.lJh.put(4, new p(gVar));
        this.lJh.put(5, new o(gVar));
        this.lJh.put(6, new f(gVar));
        this.lJh.put(7, new h(gVar));
        this.lJh.put(8, new com.tencent.mm.plugin.favorite.ui.c.c(gVar));
        this.lJh.put(10, new i(gVar));
        this.lJh.put(12, new l(gVar));
        this.lJh.put(15, new l(gVar));
        this.lJh.put(11, new com.tencent.mm.plugin.favorite.ui.c.g(gVar));
        this.lJh.put(14, new com.tencent.mm.plugin.favorite.ui.c.j(gVar));
        this.lJh.put(16, new k(gVar));
        this.lJh.put(17, new com.tencent.mm.plugin.favorite.ui.c.b(gVar));
        this.lJh.put(18, new r(gVar));
        this.lJh.put(-2, new n(gVar));
        if (z != this.lJk) {
            this.lJk = z;
            if (z) {
                this.lJd.clear();
            }
        }
        if (!this.lJk) {
            auq();
        }
        aur();
        notifyDataSetChanged();
        com.tencent.mm.sdk.b.a.urY.c(this.iOT);
        com.tencent.mm.sdk.b.a.urY.b(this.iOT);
    }

    public final void finish() {
        com.tencent.mm.sdk.b.a.urY.c(this.iOT);
    }

    public final void auq() {
        if (aus()) {
            w.v("MicroMsg.FavoriteAdapter", "searching, do not load more data");
        } else if (x.atB()) {
            w.w("MicroMsg.FavoriteAdapter", "want to load more data, but now doing batchget");
        } else if (this.lJk) {
            this.lIZ = x.f(this.lIY, this.lJb);
            this.lIX = true;
        } else {
            try {
                this.lastUpdateTime = x.q(this.lastUpdateTime, this.type);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.FavoriteAdapter", e, "", new Object[0]);
            }
        }
    }

    private boolean aus() {
        return (this.lJf.isEmpty() && this.lJg.isEmpty() && this.lJe.isEmpty()) ? false : true;
    }

    public final void a(boolean z, j jVar) {
        if (z != this.lJc) {
            this.lJc = z;
            if (z) {
                this.lJd.clear();
                if (jVar != null) {
                    j bT = com.tencent.mm.plugin.favorite.h.ata().bT(jVar.field_localId);
                    if (bT != null) {
                        this.lJd.put(Long.valueOf(bT.field_localId), bT);
                    }
                }
            }
            notifyDataSetChanged();
        }
    }

    public final List<j> ee(boolean z) {
        List<j> linkedList = new LinkedList();
        for (j jVar : this.lJd.values()) {
            if (jVar != null) {
                linkedList.add(jVar);
            }
        }
        if (z) {
            this.lJd.clear();
        }
        return linkedList;
    }

    public final int aut() {
        return this.lJd.size();
    }

    public final long auu() {
        long j = 0;
        for (j jVar : this.lJd.values()) {
            long j2;
            if (jVar != null) {
                j2 = jVar.field_datatotalsize + j;
            } else {
                j2 = j;
            }
            j = j2;
        }
        return j;
    }

    public final void b(List<Integer> list, List<String> list2, List<String> list3) {
        this.lJe.clear();
        if (list != null) {
            this.lJe.addAll(list);
        }
        this.lJf.clear();
        if (list2 != null) {
            this.lJf.addAll(list2);
        }
        this.lJg.clear();
        if (list3 != null) {
            this.lJg.addAll(list3);
        }
        this.lJi = true;
        aur();
        this.lJi = false;
    }

    public final void aur() {
        w.v("MicroMsg.FavoriteAdapter", "reset data list beg");
        this.lIX = false;
        List list = this.lIZ;
        if (list != null) {
            w.d("MicroMsg.FavoriteAdapter", "before do recycle, need recycle list size[%d]", new Object[]{Integer.valueOf(list.size())});
            w.d("MicroMsg.FavoriteAdapter", "after do recycle, current can reused list size[%d]", new Object[]{Integer.valueOf(this.lJa.size())});
            list.clear();
        }
        if (aus()) {
            w.i("MicroMsg.FavoriteAdapter", "on reset data list, do search, searchStr:%s, tagStr:%s, searchTypes:%s", new Object[]{this.lJf, this.lJg, this.lJe});
            this.lIZ = x.a(this.lJf, this.lJg, this.lJe, this.lJa, this.lIU, this.lIV);
            int size = this.lIZ == null ? 0 : this.lIZ.size();
            com.tencent.mm.plugin.report.service.g.oUh.i(10649, new Object[]{Integer.valueOf(size)});
        } else {
            w.i("MicroMsg.FavoriteAdapter", "on reset data list, last update time is %d, type is %d", new Object[]{Long.valueOf(this.lastUpdateTime), Integer.valueOf(this.type)});
            if (this.lJk) {
                this.lJb = x.atM();
                this.lIZ = x.f(null, this.lJb);
            } else {
                this.lIZ = x.b(this.lastUpdateTime, this.type, this.lIU, this.lIV);
                if (this.lastUpdateTime == 0 && this.lIZ.size() > 0) {
                    this.lastUpdateTime = ((j) this.lIZ.get(this.lIZ.size() - 1)).field_updateTime;
                }
            }
        }
        if (this.lIZ == null) {
            w.w("MicroMsg.FavoriteAdapter", "reset data list fail, get null list, new empty one");
            this.lIZ = new ArrayList();
        }
        if (!(this.lJk || aus() || this.lIZ.size() >= 20 || com.tencent.mm.plugin.favorite.h.ata().n(this.lastUpdateTime, this.type))) {
            w.v("MicroMsg.FavoriteAdapter", "least than page count, loadMoreData");
            auq();
        }
        this.lIX = true;
        w.v("MicroMsg.FavoriteAdapter", "reset data list end");
    }

    public final boolean isEmpty() {
        return this.lIY.isEmpty();
    }

    public final void notifyDataSetChanged() {
        w.v("MicroMsg.FavoriteAdapter", "on notify data set changed requset, can exchange tempList[%B]", new Object[]{Boolean.valueOf(this.lIX)});
        if (this.lIX) {
            if (this.lJk && this.lIZ != null && this.lIY != null && this.lIZ.size() == this.lIY.size()) {
                this.lJl = true;
            }
            List list = this.lIY;
            this.lIY = this.lIZ;
            this.lIZ = list;
            this.lIX = false;
        }
        w.v("MicroMsg.FavoriteAdapter", "on notify data set changed end");
        super.notifyDataSetChanged();
    }

    public final int getItemViewType(int i) {
        if (i == 0) {
            return 0;
        }
        j mx = mx(i - 1);
        switch (mx.field_type) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
                return mx.field_type;
            default:
                w.w("MicroMsg.FavoriteAdapter", "get item view type unknown, %d", new Object[]{Integer.valueOf(mx.field_type)});
                return -2;
        }
    }

    public final int getViewTypeCount() {
        return this.lJh.size() + 3;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (i == 0) {
            View view2 = new View(viewGroup.getContext());
            view2.setLayoutParams(new LayoutParams(0, 0));
            view2.setBackgroundResource(R.e.aTO);
            view2.setPadding(0, 0, 0, 0);
            view2.setEnabled(false);
            return view2;
        }
        j mx = mx(i - 1);
        a aVar = (a) this.lJh.get(mx.field_type);
        if (aVar == null) {
            w.w("MicroMsg.FavoriteAdapter", "unknown type %d, use unknown item creator", new Object[]{Integer.valueOf(mx.field_type)});
            aVar = (a) this.lJh.get(-2);
            aup();
            return aVar.a(view, viewGroup, mx);
        }
        aVar.lMN.kau = aus();
        aVar.lMN.lastUpdateTime = this.lastUpdateTime;
        aVar.lMN.lJc = this.lJc;
        aVar.lMN.lJd = this.lJd;
        aVar.lMN.lMP = this.lJj;
        aVar.lMN.lJk = this.lJk;
        return aVar.a(view, viewGroup, mx);
    }

    public final j mx(int i) {
        if (i >= 0 && i < this.lIY.size()) {
            return (j) this.lIY.get(i);
        }
        w.e("MicroMsg.FavoriteAdapter", "get item, but position error");
        return new j();
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final int getCount() {
        return this.lIY.size() + 1;
    }

    public final int cj(long j) {
        j bT = com.tencent.mm.plugin.favorite.h.ata().bT(j);
        if (bT == null) {
            return -1;
        }
        if (this.lJd.size() >= 30) {
            w.w("MicroMsg.FavoriteAdapter", "call select item, match max select count %d", new Object[]{Integer.valueOf(30)});
            com.tencent.mm.ui.base.g.bl(ab.getContext(), ab.getContext().getResources().getString(R.l.eiI, new Object[]{Integer.valueOf(30)}));
            return -1;
        }
        this.lJd.put(Long.valueOf(j), bT);
        int i;
        if (bT.field_updateTime < this.lastUpdateTime) {
            this.lastUpdateTime = bT.field_updateTime;
            aur();
            i = 0;
            for (j jVar : this.lIZ) {
                if (jVar.field_localId == j) {
                    notifyDataSetChanged();
                    return i;
                }
                i++;
            }
            notifyDataSetChanged();
        } else {
            i = 0;
            for (j jVar2 : this.lIY) {
                if (jVar2.field_localId == j) {
                    notifyDataSetChanged();
                    return i;
                }
                i++;
            }
        }
        return -1;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.tencent.mm.plugin.favorite.ui.c.a.b bVar = (com.tencent.mm.plugin.favorite.ui.c.a.b) view.getTag();
        if (bVar == null) {
            w.w("MicroMsg.FavoriteAdapter", "on item click, holder is null");
        } else if (bVar.lFt == null) {
            w.w("MicroMsg.FavoriteAdapter", "on item click, info is null");
        } else if (!this.lJc && !this.lJk) {
            a aVar = (a) this.lJh.get(bVar.lFt.field_type);
            if (aVar != null) {
                aVar.cg(view);
                w.d("MicroMsg.FavoriteAdapter", "item click type %s", new Object[]{Integer.valueOf(bVar.lFt.field_type)});
            }
        } else if (bVar.ipy.isChecked() || this.lJd.size() < 30) {
            bVar.ipy.setChecked(!bVar.ipy.isChecked());
        } else {
            w.w("MicroMsg.FavoriteAdapter", "call select item, match max select count %d", new Object[]{Integer.valueOf(30)});
            com.tencent.mm.ui.base.g.bl(ab.getContext(), ab.getContext().getResources().getString(R.l.eiI, new Object[]{Integer.valueOf(30)}));
        }
    }
}
