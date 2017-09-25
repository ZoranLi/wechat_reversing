package com.tencent.mm.plugin.wenote.ui.nativenote.a;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.t;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.plugin.wenote.ui.nativenote.b.d;
import com.tencent.mm.sdk.platformtools.w;

public final class c extends a<com.tencent.mm.plugin.wenote.ui.nativenote.b.a> {
    private final String TAG = "MicroMsg.NoteEditorUI";
    private k sxO;
    private d syF;

    public final /* synthetic */ t a(ViewGroup viewGroup, int i) {
        w.i("MicroMsg.NoteEditorUI", "viewType = " + i);
        return d.a(i, LayoutInflater.from(viewGroup.getContext()).inflate(((Integer) this.syF.syJ.get(i)).intValue(), viewGroup, false), this.sxO);
    }

    public c(k kVar) {
        this.sxO = kVar;
        this.syF = new d();
    }

    private synchronized void a(com.tencent.mm.plugin.wenote.ui.nativenote.b.a aVar, int i) {
        w.i("MicroMsg.NoteEditorUI", "huahuastart: onBindViewHolder,position is %d", new Object[]{Integer.valueOf(i)});
        com.tencent.mm.plugin.wenote.model.a.a wS = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bBv().wS(i);
        if (wS == null) {
            w.e("MicroMsg.NoteEditorUI", "onBindViewHolder, item is null, position is %d", new Object[]{Integer.valueOf(i)});
            w.i("MicroMsg.NoteEditorUI", "huahuaend: onBindViewHolder,position is %d", new Object[]{Integer.valueOf(i)});
        } else if (wS.getType() == aVar.bCe()) {
            aVar.a(wS, i, wS.getType());
            w.i("MicroMsg.NoteEditorUI", "huahuaend: onBindViewHolder,position is %d", new Object[]{Integer.valueOf(i)});
        }
    }

    public final int getItemViewType(int i) {
        com.tencent.mm.plugin.wenote.model.a.a wS = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bBv().wS(i);
        if (wS != null) {
            return wS.getType();
        }
        w.e("MicroMsg.NoteEditorUI", "getItemViewType, item is null, position is %d", new Object[]{Integer.valueOf(i)});
        return 0;
    }

    public final int getItemCount() {
        return com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bBv().size();
    }
}
