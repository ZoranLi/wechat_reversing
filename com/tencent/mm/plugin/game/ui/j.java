package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.game.model.ai;
import com.tencent.mm.plugin.game.model.c;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class j implements OnClickListener, OnItemClickListener {
    protected int mqT = 0;

    public final void nC(int i) {
        this.mqT = i;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Object item = adapterView.getAdapter().getItem(i);
        if (item != null && (item instanceof c)) {
            c cVar = (c) item;
            if (!bg.mA(cVar.field_appId)) {
                a(view.getContext(), cVar);
            }
        }
    }

    public final void onClick(View view) {
        if (view.getTag() != null && (view.getTag() instanceof c)) {
            a(view.getContext(), (c) view.getTag());
        }
    }

    private void a(Context context, c cVar) {
        int i = 7;
        if (cVar.type == 1) {
            com.tencent.mm.plugin.game.d.c.aa(context, cVar.moB);
        } else if (cVar.type != 0) {
            i = 0;
        } else if (cVar.aAy() && !bg.mA(cVar.moV.msF) && !g.a(context, cVar)) {
            com.tencent.mm.plugin.game.d.c.aa(context, cVar.moV.msF);
        } else if (bg.mA(cVar.gfi) || cVar.gfl != 4) {
            Bundle bundle = new Bundle();
            bundle.putCharSequence("game_app_id", cVar.field_appId);
            if (cVar.fTL == 1601) {
                bundle.putInt("game_report_from_scene", this.mqT);
            } else {
                bundle.putInt("game_report_from_scene", cVar.fTL);
            }
            i = com.tencent.mm.plugin.game.d.c.a(context, cVar.field_appId, cVar.moB, bundle);
        } else {
            w.i("MicroMsg.GameItemClickListener", "Download via Google Play");
            q.aS(context, cVar.gfi);
            i = 25;
        }
        ai.a(context, cVar.scene, cVar.fTL, cVar.position, i, cVar.field_appId, this.mqT, cVar.fDE, cVar.moQ);
    }
}
