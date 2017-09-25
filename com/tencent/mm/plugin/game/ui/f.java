package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.model.c;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.plugin.game.model.m;
import com.tencent.mm.plugin.game.ui.l.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.LinkedList;

public final class f extends l {
    private int mxy;

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

    public f(Context context) {
        super(context);
        this.mxy = 1;
        this.mCk = R.i.del;
    }

    protected final void a(c cVar, b bVar, int i) {
        bVar.mCu.setText(cVar.position);
        Bitmap xX = xX(cVar.field_appId);
        if (xX == null || xX.isRecycled()) {
            bVar.mwf.setImageResource(R.g.bfs);
        } else {
            bVar.mwf.setImageBitmap(xX);
        }
        bVar.mwg.setText(cVar.field_appName);
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
                    w.e("MicroMsg.GameCenterListAdapter", e.getMessage());
                } catch (Exception e2) {
                    w.e("MicroMsg.GameCenterListAdapter", e2.getMessage());
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
    }

    protected final void a(c cVar, b bVar) {
    }
}
