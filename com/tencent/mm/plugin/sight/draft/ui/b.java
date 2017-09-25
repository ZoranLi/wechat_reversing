package com.tencent.mm.plugin.sight.draft.ui;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.modelvideo.j;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.s.a.g;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.k;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class b extends k<j> {
    private int kpi;
    private int ksj;
    a pvY = new a(this);
    private b pvZ = new b(this);
    private c pwa = new c(this);
    private Set<e> pwb = new HashSet();
    private d pwc = d.NORMAL;
    a pwd;
    private int pwe = R.l.eWD;
    int pwf = 0;
    private int pwg;
    private int pwh;
    private c pwi = new c(this) {
        final /* synthetic */ b pwk;

        {
            this.pwk = r1;
        }

        public final void q(String str, Bitmap bitmap) {
            for (e eVar : this.pwk.pwb) {
                if (eVar.pwr != null && bg.ap(str, "").equals(eVar.pwr.field_fileName)) {
                    eVar.pwp.y(bitmap);
                    return;
                }
            }
        }
    };
    e pwj;

    private class a implements OnClickListener {
        final /* synthetic */ b pwk;

        public a(b bVar) {
            this.pwk = bVar;
        }

        public final void onClick(View view) {
            if (view.getTag() instanceof e) {
                e eVar = (e) view.getTag();
                if (eVar.pwr == null) {
                    w.i("MicroMsg.SightDraftContainerAdapter", "click draft, but info null, curType %s", new Object[]{this.pwk.pwc});
                    bcD();
                    this.pwk.pwj = null;
                    return;
                }
                if (this.pwk.pwj != eVar) {
                    bcD();
                    String lm = com.tencent.mm.modelvideo.k.lm(eVar.pwr.field_fileName);
                    eVar.pwp.gZ(true);
                    eVar.pwp.ak(lm, false);
                    eVar.lNh.setBackgroundResource(R.g.bjT);
                    View view2 = eVar.pwo;
                    if (!(view2 == null || com.tencent.mm.compatible.util.d.ep(11))) {
                        Animator animator = (Animator) view2.getTag(g.hcS);
                        if (animator != null) {
                            animator.cancel();
                        }
                        AnimatorSet animatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(view2.getContext(), com.tencent.mm.s.a.b.hbt);
                        animatorSet.setTarget(view2);
                        animatorSet.start();
                        view2.setTag(g.hcS, animatorSet);
                    }
                    this.pwk.a(eVar);
                    this.pwk.pwj = eVar;
                }
                if (this.pwk.pwd != null) {
                    this.pwk.pwd.bcB();
                }
            }
        }

        public final boolean bcD() {
            if (this.pwk.pwj == null) {
                return false;
            }
            this.pwk.pwj.jbV.setVisibility(8);
            this.pwk.pwj.pwp.gZ(false);
            this.pwk.pwj.pwp.ak(null, false);
            this.pwk.pwj.pwp.y(this.pwk.pwi.n(this.pwk.pwj.pwr.field_fileName, com.tencent.mm.modelvideo.k.ln(this.pwk.pwj.pwr.field_fileName), true));
            this.pwk.pwj.lNh.setBackgroundResource(R.g.bjS);
            com.tencent.mm.ui.tools.j.m(this.pwk.pwj.pwo, 1.0f);
            this.pwk.pwj = null;
            return true;
        }
    }

    private class b implements OnLongClickListener {
        final /* synthetic */ b pwk;

        public b(b bVar) {
            this.pwk = bVar;
        }

        public final boolean onLongClick(View view) {
            if (view.getTag() instanceof e) {
                e eVar = (e) view.getTag();
                if (!(eVar.pwr == null || -1 == eVar.pwr.field_fileStatus)) {
                    this.pwk.a(d.EDIT, true);
                }
            }
            return true;
        }
    }

    private class c implements OnClickListener {
        final /* synthetic */ b pwk;

        public c(b bVar) {
            this.pwk = bVar;
        }

        public final void onClick(View view) {
            if (view.getTag() instanceof e) {
                this.pwk.pvY.bcD();
                e eVar = (e) view.getTag();
                if (eVar.pwr == null) {
                    w.e("MicroMsg.SightDraftContainerAdapter", "draftInfo is NULL");
                    return;
                }
                eVar.pwr.field_fileStatus = 6;
                o.KZ().c(eVar.pwr, new String[]{"localId"});
                this.pwk.a(null, null);
            }
        }
    }

    public enum d {
        NORMAL,
        EDIT
    }

    private static final class e {
        TextView jbV;
        ImageView lNh;
        View lmQ;
        ImageView pmp;
        View pwo;
        com.tencent.mm.plugin.sight.decode.a.a pwp;
        View pwq;
        j pwr;
    }

    private static final class f {
        List<e> pws = new LinkedList();
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        obj = (j) obj;
        if (obj == null) {
            obj = new j();
        }
        obj.b(cursor);
        return obj;
    }

    public b(Context context, a aVar) {
        super(context, null);
        this.pwd = aVar;
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.f.bbc) * 2;
        this.pwg = context.getResources().getDisplayMetrics().widthPixels / 3;
        this.ksj = this.pwg - dimensionPixelSize;
        this.kpi = (this.ksj * 3) / 4;
        this.pwh = dimensionPixelSize + this.kpi;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        f fVar;
        if (view == null) {
            f fVar2 = new f();
            view = new LinearLayout(viewGroup.getContext());
            view.setOrientation(0);
            for (int i2 = 0; i2 < 3; i2++) {
                View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.i.doE, view, false);
                e eVar = new e();
                eVar.lmQ = inflate;
                eVar.lmQ.setTag(eVar);
                eVar.pwo = inflate.findViewById(R.h.cFq);
                eVar.pwp = (com.tencent.mm.plugin.sight.decode.a.a) inflate.findViewById(R.h.cFu);
                eVar.lNh = (ImageView) inflate.findViewById(R.h.cFv);
                eVar.pwq = inflate.findViewById(R.h.cDz);
                eVar.jbV = (TextView) inflate.findViewById(R.h.cFt);
                eVar.jbV.setText(this.pwe);
                eVar.pmp = (ImageView) inflate.findViewById(R.h.cFn);
                fVar2.pws.add(eVar);
                LayoutParams layoutParams = (LayoutParams) inflate.getLayoutParams();
                layoutParams.weight = 1.0f;
                layoutParams.height = this.pwh;
                view.addView(inflate);
                inflate.setOnClickListener(this.pvY);
                eVar.pmp.setTag(eVar);
                eVar.pmp.setOnClickListener(this.pwa);
            }
            view.setTag(fVar2);
            fVar = fVar2;
        } else {
            fVar = (f) view.getTag();
        }
        for (int i3 = 0; i3 < fVar.pws.size(); i3++) {
            int i4 = (i * 3) + i3;
            e eVar2 = (e) fVar.pws.get(i3);
            this.pwb.add(eVar2);
            eVar2.pwq.setVisibility(8);
            eVar2.jbV.setVisibility(8);
            eVar2.lNh.setBackgroundResource(R.g.bjS);
            eVar2.pwp.ak(null, false);
            eVar2.pwp.gZ(false);
            eVar2.pwp.bbW();
            ((ImageView) eVar2.pwp).setBackgroundResource(0);
            if (i4 >= ano()) {
                eVar2.pwr = null;
                eVar2.lmQ.setVisibility(4);
                com.tencent.mm.ui.tools.j.m(eVar2.pwo, 1.0f);
            } else {
                this.pwf--;
                j jVar = (j) getItem(i4);
                ap.yY();
                if (com.tencent.mm.u.c.isSDCardAvailable()) {
                    boolean z;
                    eVar2.pwr = jVar;
                    c cVar = this.pwi;
                    String str = jVar.field_fileName;
                    String ln = com.tencent.mm.modelvideo.k.ln(jVar.field_fileName);
                    if (this.pwf <= 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    Bitmap n = cVar.n(str, ln, z);
                    ((ImageView) eVar2.pwp).setScaleType(ScaleType.CENTER_CROP);
                    eVar2.pwp.y(n);
                } else {
                    eVar2.pwr = null;
                    eVar2.pwp.bbS();
                }
                if (d.EDIT == this.pwc) {
                    eVar2.pmp.setVisibility(0);
                    com.tencent.mm.ui.tools.j.m(eVar2.pwo, 0.95f);
                } else {
                    eVar2.pmp.setVisibility(8);
                    com.tencent.mm.ui.tools.j.m(eVar2.pwo, 1.0f);
                }
                eVar2.lmQ.setVisibility(0);
            }
        }
        return view;
    }

    final void a(e eVar) {
        if (eVar == null) {
            for (e eVar2 : this.pwb) {
                eVar2.pwq.setVisibility(8);
            }
            return;
        }
        for (e eVar22 : this.pwb) {
            eVar22.pwq.setVisibility(eVar == eVar22 ? 8 : 0);
        }
    }

    public final boolean a(d dVar, boolean z) {
        if (dVar == this.pwc) {
            if (z && this.pwd != null) {
                this.pwd.bcC();
            }
            return false;
        }
        this.pwc = dVar;
        this.pvY.bcD();
        notifyDataSetChanged();
        if (z && this.pwd != null) {
            this.pwd.bcC();
        }
        return true;
    }

    public final void a(String str, l lVar) {
        this.pwb.clear();
        super.a(str, lVar);
    }

    public final void OK() {
        OL();
        super.notifyDataSetChanged();
    }

    protected final void OL() {
        setCursor(o.KZ().gUz.rawQuery("SELECT * FROM SightDraftInfo WHERE fileStatus = ?  ORDER BY localId DESC ", new String[]{"1"}));
    }

    public final int getCount() {
        return (super.getCount() / 3) + 1;
    }
}
