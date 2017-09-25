package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.ah.n;
import com.tencent.mm.plugin.game.model.c;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.plugin.game.model.m;
import com.tencent.mm.plugin.game.ui.l.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.LinkedList;

public final class k extends l {
    public final /* bridge */ /* synthetic */ void O(LinkedList linkedList) {
        super.O(linkedList);
    }

    public final /* bridge */ /* synthetic */ void P(LinkedList linkedList) {
        super.P(linkedList);
    }

    public final /* bridge */ /* synthetic */ void a(a aVar) {
        super.a(aVar);
    }

    public final /* bridge */ /* synthetic */ void b(SparseArray sparseArray) {
        super.b(sparseArray);
    }

    public final /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    public final /* bridge */ /* synthetic */ int getItemViewType(int i) {
        return super.getItemViewType(i);
    }

    public final /* bridge */ /* synthetic */ View getView(int i, View view, ViewGroup viewGroup) {
        return super.getView(i, view, viewGroup);
    }

    public final /* bridge */ /* synthetic */ int getViewTypeCount() {
        return super.getViewTypeCount();
    }

    public final /* bridge */ /* synthetic */ void nC(int i) {
        super.nC(i);
    }

    public final /* bridge */ /* synthetic */ void nF(int i) {
        super.nF(i);
    }

    public final /* bridge */ /* synthetic */ void refresh() {
        super.refresh();
    }

    public final /* bridge */ /* synthetic */ void x(View view, int i) {
        super.x(view, i);
    }

    public final /* bridge */ /* synthetic */ void xY(String str) {
        super.xY(str);
    }

    public final /* bridge */ /* synthetic */ void xZ(String str) {
        super.xZ(str);
    }

    public final /* bridge */ /* synthetic */ void ya(String str) {
        super.ya(str);
    }

    public k(Context context) {
        super(context);
        this.mCk = R.i.deQ;
    }

    protected final void a(c cVar, b bVar, int i) {
        bVar.mCu.setText(cVar.position);
        bVar.mCu.setVisibility(this.mCm ? 0 : 8);
        Bitmap xX = xX(cVar.field_appId);
        if (xX == null || xX.isRecycled()) {
            bVar.mwf.setImageResource(R.g.bfs);
        } else {
            bVar.mwf.setImageBitmap(xX);
        }
        bVar.mwg.setText(cVar.field_appName);
        if (bg.mA(cVar.moy)) {
            bVar.mCx.setVisibility(8);
        } else {
            bVar.mCx.setVisibility(0);
            bVar.mCx.setText(cVar.moy);
        }
        if (bg.mA(cVar.moz)) {
            bVar.mCy.setVisibility(8);
        } else {
            bVar.mCy.setVisibility(0);
            bVar.mCy.setText(cVar.moz);
        }
        if (bg.bV(cVar.moJ)) {
            if (!bg.mA(cVar.moM)) {
                bVar.mCw.setVisibility(0);
                bVar.mCw.setText(cVar.moM);
                try {
                    bVar.mCw.setBackgroundDrawable(e.bJ(Color.parseColor(cVar.moN), com.tencent.mm.bg.a.fromDPToPix(this.mContext, 10)));
                } catch (IllegalArgumentException e) {
                    w.e("MicroMsg.GameLibraryListAdapter", e.getMessage());
                } catch (Exception e2) {
                    w.e("MicroMsg.GameLibraryListAdapter", e2.getMessage());
                }
            }
            bVar.mCw.setVisibility(8);
        } else {
            bVar.mCw.setVisibility(0);
            bVar.mCw.setText((CharSequence) cVar.moJ.get(0));
        }
        bVar.mCA.nQ(this.mzt);
        bVar.mCz.setOnClickListener(this.mAj);
        bVar.mCA.setOnClickListener(this.mAj);
        bVar.mCz.setTag(cVar);
        bVar.mCA.setTag(cVar);
        this.mzy.a(bVar.mCA, bVar.mCz, cVar, (m) this.mCo.get(cVar.field_appId));
        bVar.mCB.H(cVar.moH);
        bVar.mCC.removeAllViews();
        View view = (View) this.mCp.get(i);
        if (view != null) {
            if (view.getParent() instanceof ViewGroup) {
                ((ViewGroup) view.getParent()).removeAllViews();
            }
            bVar.mCC.addView(view);
        }
    }

    protected final void a(c cVar, b bVar) {
        bVar.mCD.removeAllViews();
        if (!bg.mA(cVar.moC)) {
            View inflate = View.inflate(this.mContext, R.i.deF, null);
            ImageView imageView = (ImageView) inflate.findViewById(R.h.bUb);
            com.tencent.mm.ah.a.a GW = n.GW();
            String str = cVar.moC;
            com.tencent.mm.ah.a.a.c.a aVar = new com.tencent.mm.ah.a.a.c.a();
            aVar.hIK = true;
            GW.a(str, imageView, aVar.Hg());
            bVar.mCD.addView(inflate, new LayoutParams(-1, com.tencent.mm.bg.a.fromDPToPix(this.mContext, 100)));
        }
    }
}
