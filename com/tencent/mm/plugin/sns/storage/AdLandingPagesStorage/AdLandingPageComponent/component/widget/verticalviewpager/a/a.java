package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.t;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ab;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.c;
import com.tencent.mm.plugin.sns.ui.al;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

public final class a extends android.support.v7.widget.RecyclerView.a<t> implements b {
    int bgColor;
    private Context context;
    private int jYp;
    private int jYq;
    private LinearLayoutManager qhy;
    c qlw;
    LinkedHashMap<String, i> qlx = new LinkedHashMap();
    private LayoutInflater qly;

    public class a extends t {
        public LinearLayout jqs;
        final /* synthetic */ a qlz;

        public a(a aVar, View view) {
            this.qlz = aVar;
            super(view);
            this.jqs = (LinearLayout) view.findViewById(f.czn);
        }
    }

    public a(c cVar, int i, Context context, LinearLayoutManager linearLayoutManager) {
        this.qhy = linearLayoutManager;
        this.qlw = cVar;
        this.bgColor = i;
        this.context = context;
        this.qly = (LayoutInflater) this.context.getSystemService("layout_inflater");
        int[] cP = ab.cP(this.context);
        this.jYp = cP[0];
        this.jYq = cP[1];
    }

    public final t a(ViewGroup viewGroup, int i) {
        return new a(this, LayoutInflater.from(viewGroup.getContext()).inflate(g.pGB, viewGroup, false));
    }

    public final void a(t tVar, int i) {
        w.i("ContentAdapter", "display page " + this.qlw.id + ", pos " + i);
        a aVar = (a) tVar;
        aVar.jqs.removeAllViews();
        p pVar = (p) this.qlw.qms.get(i);
        i iVar = (i) this.qlx.get(pVar.qfI);
        if (iVar != null) {
            iVar.a((p) this.qlw.qms.get(i));
        } else {
            iVar = al.a(aVar.jqs.getContext(), pVar, aVar.jqs, this.bgColor);
            if (iVar != null) {
                this.qlx.put(pVar.qfI, iVar);
            }
        }
        if (iVar != null) {
            if (iVar.getView().getParent() != null && (iVar.getView().getParent() instanceof ViewGroup)) {
                ((ViewGroup) iVar.getView().getParent()).removeView(iVar.getView());
            }
            aVar.jqs.addView(iVar.getView());
        }
    }

    public final int getItemViewType(int i) {
        return i;
    }

    public final int getItemCount() {
        return this.qlw.qms.size();
    }

    public final boolean tx(int i) {
        if (i < this.qhy.fa() || i > this.qhy.fb()) {
            w.v("ContentAdapter", "index %d not visible");
            return false;
        }
        i iVar = (i) this.qlx.get(((p) this.qlw.qms.get(i)).qfI);
        if (iVar == null) {
            return false;
        }
        w.v("ContentAdapter", "comp %s, inScreenH %d", new Object[]{iVar, Integer.valueOf(a(iVar))});
        return a(iVar) >= (iVar.getView().getHeight() >>> 1);
    }

    private int a(i iVar) {
        if (iVar != null) {
            View view = iVar.getView();
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int i = iArr[1];
            int height = view.getHeight() + i;
            w.v("ContentAdapter", "comp %s , top %d,bottom %d ", new Object[]{iVar, Integer.valueOf(i), Integer.valueOf(height)});
            if (i >= 0 && height <= this.jYq) {
                return view.getHeight();
            }
            if (i < 0 && height > 0 && height <= this.jYq) {
                return height;
            }
            if (i < 0 && height > this.jYq) {
                return this.jYq;
            }
            if (i < this.jYq && height > this.jYq) {
                return this.jYq - i;
            }
        }
        return 0;
    }

    public final void a(int i, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b bVar) {
        p pVar = (p) this.qlw.qms.get(i);
        i iVar = (i) this.qlx.get(pVar.qfI);
        if (iVar != null) {
            iVar.bfP();
            iVar.N(a(iVar), iVar.getView().getHeight(), this.jYq);
            if (pVar.type == 61 || pVar.type == 62) {
                List<Integer> arrayList = new ArrayList();
                for (Entry entry : bVar.qhx.entrySet()) {
                    if (((a) entry.getValue()).qeX) {
                        arrayList.add(entry.getKey());
                    }
                }
                for (Integer intValue : arrayList) {
                    int intValue2 = intValue.intValue();
                    if (intValue2 != i && tx(intValue2)) {
                        i iVar2 = (i) this.qlx.get(((p) this.qlw.qms.get(intValue2)).qfI);
                        if (iVar2 instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) {
                            com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a aVar = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) iVar2;
                            if (aVar.qeV && this.qlw.qmt && intValue2 == 0) {
                                ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) iVar).bfN();
                            } else if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) iVar).qeV) {
                                aVar.bfN();
                            }
                        }
                    }
                }
            }
        }
    }

    public final void tw(int i) {
        i iVar = (i) this.qlx.get(((p) this.qlw.qms.get(i)).qfI);
        if (iVar != null) {
            iVar.bfQ();
        }
    }

    public final void onDestroy() {
        for (Entry value : this.qlx.entrySet()) {
            ((i) value.getValue()).bfO();
        }
    }
}
