package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ah.n;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelvideo.m.AnonymousClass5;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class l extends com.tencent.mm.pluginsdk.ui.b.b implements com.tencent.mm.modelvideo.s.a {
    public ViewGroup pu;
    public Map<String, Long> wfn = new HashMap();
    public Map<Long, b> wfo = new HashMap();

    private static final class a implements Runnable {
        WeakReference<l> wfp;

        public final void run() {
            List Lm = o.KV().Lm();
            List Ln = o.KV().Ln();
            l lVar = (l) this.wfp.get();
            if (lVar == null) {
                w.w("MicroMsg.MassSightBanner", "try to load date, but banner ref is null");
                return;
            }
            w.i("MicroMsg.MassSightBanner", "ViewCount %d, unfinish size %d, fail size %d", Integer.valueOf(lVar.pu.getChildCount()), Integer.valueOf(Lm.size()), Integer.valueOf(Ln.size()));
            if (lVar.pu.getChildCount() != 0 || !Lm.isEmpty() || !Ln.isEmpty()) {
                Runnable cVar = new c();
                cVar.wfp = new WeakReference(this.wfp.get());
                cVar.wfy = Lm;
                cVar.wfz = Ln;
                af.v(cVar);
            }
        }
    }

    private static final class b {
        ProgressBar kYg = null;
        long wfq = 0;
        boolean wfr = false;
        View wfs = null;
        com.tencent.mm.plugin.sight.decode.a.a wft = null;
        ImageView wfu = null;
        TextView wfv = null;
        ImageButton wfw = null;
    }

    private static final class c implements Runnable {
        WeakReference<l> wfp;
        List<r> wfy;
        List<r> wfz;

        private static int a(String str, l lVar, List<r> list, int i, int i2, int i3) {
            for (r rVar : list) {
                lVar.wfn.put(rVar.getFileName(), Long.valueOf(rVar.hYG));
                if (lVar.wfo.containsKey(Long.valueOf(rVar.hYG))) {
                    w.d("MicroMsg.MassSightBanner", "%s: has contains massSendId %d, file %s", str, Long.valueOf(rVar.hYG), rVar.getFileName());
                } else {
                    View view;
                    b bVar;
                    View inflate;
                    if (i < i2) {
                        w.d("MicroMsg.MassSightBanner", "%s: refresh view(%d/%d, hashCode %d) with massSendId %d", str, Integer.valueOf(i + 1), Integer.valueOf(i2), Integer.valueOf(lVar.pu.getChildAt(i).hashCode()), Long.valueOf(rVar.hYG));
                        i = r2;
                        view = inflate;
                    } else {
                        inflate = LayoutInflater.from(lVar.pu.getContext()).inflate(R.i.dip, lVar.pu, false);
                        lVar.pu.addView(inflate);
                        w.d("MicroMsg.MassSightBanner", "%s: new view(%d/%d, hashCode %d) with massSendId %d", str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(inflate.hashCode()), Long.valueOf(rVar.hYG));
                        view = inflate;
                    }
                    b bVar2 = (b) view.getTag();
                    if (bVar2 == null) {
                        bVar = new b();
                    } else {
                        bVar = bVar2;
                    }
                    if (bVar.wfq != rVar.hYG) {
                        w.d("MicroMsg.MassSightBanner", "ashutest::mass send id not match! %d -> %d, totalCount %d", Long.valueOf(bVar.wfq), Long.valueOf(rVar.hYG), Integer.valueOf(i3));
                        bVar.wfq = rVar.hYG;
                        bVar.wfs = view;
                        bVar.wft = (com.tencent.mm.plugin.sight.decode.a.a) view.findViewById(R.h.bXk);
                        bVar.wfu = (ImageView) view.findViewById(R.h.cGx);
                        bVar.kYg = (ProgressBar) view.findViewById(R.h.progress);
                        bVar.wfw = (ImageButton) view.findViewById(R.h.bvK);
                        bVar.wfv = (TextView) view.findViewById(R.h.bXD);
                        bVar.wft.sF(view.getResources().getDimensionPixelSize(R.f.aXB));
                        bVar.wfs.setTag(bVar);
                        bVar.wfw.setTag(Long.valueOf(bVar.wfq));
                        bVar.wfs.setOnClickListener(new OnClickListener(bVar) {
                            final /* synthetic */ b wfx;

                            {
                                this.wfx = r1;
                            }

                            public final void onClick(View view) {
                                b bVar = (b) view.getTag();
                                w.i("MicroMsg.MassSightBanner", "on click, massSendId %d, failed %B", Long.valueOf(bVar.wfq), Boolean.valueOf(bVar.wfr));
                                if (bVar.wfr) {
                                    t.av(bVar.wfq);
                                }
                            }
                        });
                        bVar.wfw.setOnClickListener(new OnClickListener(bVar) {
                            final /* synthetic */ b wfx;

                            {
                                this.wfx = r1;
                            }

                            public final void onClick(View view) {
                                w.i("MicroMsg.MassSightBanner", "on click cancel, massSendId %d", Long.valueOf(((Long) view.getTag()).longValue()));
                                h.vL().D(new AnonymousClass5(o.Lb(), r0));
                            }
                        });
                    } else {
                        w.d("MicroMsg.MassSightBanner", "ashutest::mass send id match! %d, totalCount %d", Long.valueOf(bVar.wfq), Integer.valueOf(i3));
                    }
                    o.KV();
                    String lv = s.lv(rVar.getFileName());
                    o.KV();
                    bVar.wft.y(n.GS().a(s.lw(rVar.getFileName()), com.tencent.mm.bg.a.getDensity(view.getContext()), view.getContext()));
                    if (i3 > 3) {
                        bVar.wft.clear();
                        bVar.wfu.setVisibility(0);
                    } else {
                        bVar.wft.ak(lv, false);
                        bVar.wfu.setVisibility(8);
                    }
                    a(bVar, rVar);
                    lVar.wfo.put(Long.valueOf(rVar.hYG), bVar);
                }
            }
            return i;
        }

        public static void a(b bVar, r rVar) {
            boolean z = true;
            w.v("MicroMsg.MassSightBanner", "info status %d", Integer.valueOf(rVar.status));
            if (rVar.status == 198 || rVar.status == 197 || rVar.status == 196) {
                bVar.kYg.setVisibility(4);
                bVar.wfv.setVisibility(0);
                bVar.wfw.setEnabled(true);
                bVar.wfr = true;
                return;
            }
            float f = ((float) rVar.hYV) / ((float) rVar.hrs);
            bVar.kYg.setVisibility(0);
            bVar.wfv.setVisibility(4);
            bVar.kYg.setProgress((int) (((float) bVar.kYg.getMax()) * f));
            ImageButton imageButton = bVar.wfw;
            if (Float.compare(0.99f, f) <= 0) {
                z = false;
            }
            imageButton.setEnabled(z);
            bVar.wfr = false;
        }

        public final void run() {
            l lVar = (l) this.wfp.get();
            if (lVar == null) {
                w.w("MicroMsg.MassSightBanner", "try to refresh, but banner ref is null");
                return;
            }
            int childCount = lVar.pu.getChildCount();
            lVar.wfo.clear();
            Set hashSet = new HashSet();
            for (r rVar : this.wfy) {
                hashSet.add(Long.valueOf(rVar.hYG));
            }
            for (r rVar2 : this.wfz) {
                hashSet.add(Long.valueOf(rVar2.hYG));
            }
            int size = hashSet.size();
            int a = a("update fail", lVar, this.wfz, a("update unfinish", lVar, this.wfy, 0, childCount, size), childCount, size);
            for (int i = a; i < childCount; i++) {
                lVar.pu.removeViewAt(a);
            }
        }
    }

    public l(Context context) {
        super(context);
        o.KV().a(this, Looper.getMainLooper());
        this.pu = (ViewGroup) this.view;
    }

    public final int getLayoutId() {
        return R.i.dio;
    }

    public final void destroy() {
        o.KV().a((com.tencent.mm.modelvideo.s.a) this);
    }

    private void WS() {
        w.i("MicroMsg.MassSightBanner", "call update status");
        Runnable aVar = new a();
        aVar.wfp = new WeakReference(this);
        ap.vL().D(aVar);
    }

    public final void a(com.tencent.mm.modelvideo.s.a.a aVar) {
        String str = aVar.fyF;
        Long l = (Long) this.wfn.get(str);
        if (l == null) {
            w.d("MicroMsg.MassSightBanner", "massSendId is null, fileName %s", str);
            if (bg.ap(str, "").startsWith("DELETE_")) {
                WS();
                return;
            }
            return;
        }
        b bVar = (b) this.wfo.get(l);
        if (bVar == null) {
            w.d("MicroMsg.MassSightBanner", "find massSendId %d, but holder is null", l);
            return;
        }
        r lH = t.lH(str);
        if (lH == null) {
            w.w("MicroMsg.MassSightBanner", "on nofify changed, filename %s, massSendId %d, but videoinfo is null", str, l);
        } else if (lH.status == 199) {
            w.i("MicroMsg.MassSightBanner", "fileName %s, massSendId %d, done", str, l);
            WS();
        } else {
            c.a(bVar, lH);
        }
    }
}
