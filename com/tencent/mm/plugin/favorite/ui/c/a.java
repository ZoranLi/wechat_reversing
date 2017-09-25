package com.tencent.mm.plugin.favorite.ui.c;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.e.b.af;
import com.tencent.mm.plugin.favorite.b.j;
import com.tencent.mm.plugin.favorite.b.u;
import com.tencent.mm.plugin.favorite.b.x;
import com.tencent.mm.plugin.favorite.c.g;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.protocal.c.rw;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;
import com.tencent.mm.u.n;
import com.tencent.mm.u.o;
import java.util.Map;

public abstract class a {
    protected g lDs = null;
    public final a lMN = new a();

    public static class a {
        public boolean kau;
        public String kwE;
        public boolean lJc;
        public Map<Long, j> lJd;
        public boolean lJk;
        public c lMP;
        public long lastUpdateTime;

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("lastUpdateTime:").append(this.lastUpdateTime).append('\n');
            stringBuilder.append("isSearching:").append(this.kau).append('\n');
            stringBuilder.append("search str:").append(this.kwE).append('\n');
            return stringBuilder.toString();
        }
    }

    public static class b {
        public ImageView ipv;
        public CheckBox ipy;
        public TextView kxi;
        public TextView kzl;
        public j lFt;
        public TextView lMQ;
        public LinearLayout lMR;
        public TextView lMS;
    }

    public interface c {
        void ci(long j);
    }

    public abstract View a(View view, ViewGroup viewGroup, j jVar);

    public abstract void cg(View view);

    public a(g gVar) {
        this.lDs = gVar;
    }

    protected final View a(View view, b bVar, j jVar) {
        if (view == null) {
            throw new NullPointerException("base item view is null");
        }
        bVar.ipv = (ImageView) view.findViewById(R.h.bNY);
        if (bVar.ipv == null) {
            throw new IllegalArgumentException("base item view do not contain id named fav_avatar");
        }
        bVar.kzl = (TextView) view.findViewById(R.h.bOJ);
        if (bVar.kzl == null) {
            throw new IllegalArgumentException("base item view do not contain id named fav_name");
        }
        bVar.kxi = (TextView) view.findViewById(R.h.bOX);
        if (bVar.kxi == null) {
            throw new IllegalArgumentException("base item view do not contain id named fav_time");
        }
        bVar.ipy = (CheckBox) view.findViewById(R.h.bOd);
        if (bVar.ipy == null) {
            throw new IllegalArgumentException("base item view do not contain id named checkbox");
        }
        bVar.lMQ = (TextView) view.findViewById(R.h.bOE);
        bVar.ipy.setOnCheckedChangeListener(new OnCheckedChangeListener(this) {
            final /* synthetic */ a lMO;

            {
                this.lMO = r1;
            }

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (compoundButton.getTag() != null) {
                    j jVar = (j) compoundButton.getTag();
                    if (z) {
                        this.lMO.lMN.lJd.put(Long.valueOf(jVar.field_localId), h.ata().bT(jVar.field_localId));
                    } else {
                        this.lMO.lMN.lJd.remove(Long.valueOf(jVar.field_localId));
                    }
                    if (this.lMO.lMN.lMP != null) {
                        this.lMO.lMN.lMP.ci(jVar.field_localId);
                    }
                }
            }
        });
        bVar.lFt = jVar;
        view.setTag(bVar);
        bVar.lMR = (LinearLayout) view.findViewById(R.h.bOS);
        bVar.lMS = (TextView) view.findViewById(R.h.bOR);
        bVar.lMS.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ a lMO;

            {
                this.lMO = r1;
            }

            public final void onClick(View view) {
                w.d("MicroMsg.FavBaseListItem", "manual restart upload");
                if (view.getTag() instanceof j) {
                    x.l((j) view.getTag());
                }
            }
        });
        return view;
    }

    protected final void a(b bVar, j jVar) {
        bVar.lFt = jVar;
        rw rwVar = bVar.lFt.field_favProto.tzl;
        if (rwVar == null || bg.mA(rwVar.tyQ)) {
            com.tencent.mm.pluginsdk.ui.a.b.m(bVar.ipv, bVar.lFt.field_fromUser);
        } else {
            com.tencent.mm.pluginsdk.ui.a.b.m(bVar.ipv, rwVar.tyQ);
        }
        if (this.lMN.lJk) {
            bVar.kxi.setText(com.tencent.mm.plugin.favorite.c.bP(bVar.lFt.field_datatotalsize));
        } else {
            bVar.kxi.setText(u.e(bVar.kxi.getContext(), bVar.lFt.field_updateTime));
        }
        Context context = bVar.kzl.getContext();
        ap.yY();
        af Rb = com.tencent.mm.u.c.wR().Rb(bVar.lFt.field_fromUser);
        if (Rb == null || !Rb.field_username.equals(bVar.lFt.field_fromUser)) {
            w.w("MicroMsg.FavBaseListItem", "render name, user is %s, but name is null", new Object[]{bVar.lFt.field_fromUser});
            bVar.kzl.setText("");
            com.tencent.mm.u.ag.a.hlS.a(bVar.lFt.field_fromUser, "", null);
        } else {
            CharSequence eK;
            if (o.dH(bVar.lFt.field_fromUser)) {
                rwVar = bVar.lFt.field_favProto.tzl;
                eK = m.xL().equals(rwVar.fOu) ? n.eK(rwVar.toUser) : n.eK(rwVar.fOu);
            } else {
                eK = n.a(Rb, Rb.field_username);
            }
            bVar.kzl.setText(com.tencent.mm.pluginsdk.ui.d.h.b(context, eK, bVar.kzl.getTextSize()));
        }
        w.d("MicroMsg.FavBaseListItem", "status %s", new Object[]{Integer.valueOf(bVar.lFt.field_itemStatus)});
        if (bVar.lFt.atj()) {
            bVar.lMR.setVisibility(0);
        } else {
            bVar.lMR.setVisibility(8);
        }
        bVar.ipy.setTag(jVar);
        if (this.lMN.lJc || this.lMN.lJk) {
            boolean z;
            bVar.ipy.setVisibility(0);
            CheckBox checkBox = bVar.ipy;
            if (this.lMN.lJd.get(Long.valueOf(jVar.field_localId)) != null) {
                z = true;
            } else {
                z = false;
            }
            checkBox.setChecked(z);
        } else {
            bVar.ipy.setVisibility(8);
        }
        if (jVar.field_tagProto.tzx == null || jVar.field_tagProto.tzx.isEmpty()) {
            bVar.lMQ.setVisibility(8);
        } else {
            bVar.lMQ.setVisibility(0);
            bVar.lMQ.setText(com.tencent.mm.pluginsdk.ui.d.h.b(bVar.lMQ.getContext(), x.a(bVar.lMQ.getContext(), jVar.field_tagProto.tzx), bVar.lMQ.getTextSize()));
        }
        bVar.lMS.setTag(jVar);
    }
}
