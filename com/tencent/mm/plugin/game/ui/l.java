package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.model.ai;
import com.tencent.mm.plugin.game.model.c;
import com.tencent.mm.plugin.game.model.m;
import com.tencent.mm.plugin.game.widget.TextProgressBar;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

abstract class l extends b<c> {
    private OnClickListener mAi = new OnClickListener(this) {
        final /* synthetic */ l mCr;

        {
            this.mCr = r1;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            this.mCr.notifyDataSetChanged();
        }
    };
    protected View.OnClickListener mAj = new View.OnClickListener(this) {
        final /* synthetic */ l mCr;

        {
            this.mCr = r1;
        }

        public final void onClick(View view) {
            if (view.getTag() instanceof c) {
                c cVar = (c) view.getTag();
                if (this.mCr.mCo.containsKey(cVar.field_appId)) {
                    m mVar = (m) this.mCr.mCo.get(cVar.field_appId);
                    mVar.cj(this.mCr.mContext);
                    this.mCr.mzy.mwG = cVar.moQ;
                    this.mCr.mzy.mqT = this.mCr.mqT;
                    this.mCr.mzy.a(cVar, mVar);
                    return;
                }
                w.e("MicroMsg.GameListAdapter", "No DownloadInfo found");
                return;
            }
            w.e("MicroMsg.GameListAdapter", "No button tag retrived, ignore click");
        }
    };
    protected int mCk;
    protected boolean mCl = true;
    protected boolean mCm = false;
    protected boolean mCn = false;
    protected ConcurrentHashMap<String, m> mCo;
    protected Context mContext;
    protected SparseArray<View> mCp;
    protected int mqT = 0;
    private a mxs;
    protected int myq;
    protected int mzt = 14;
    private com.tencent.mm.plugin.game.model.l.b mzx = new com.tencent.mm.plugin.game.model.l.b(this) {
        final /* synthetic */ l mCr;

        {
            this.mCr = r1;
        }

        public final void g(int i, String str, boolean z) {
            if (z && this.mCr.mCo != null && str != null) {
                try {
                    for (m mVar : this.mCr.mCo.values()) {
                        if (!(mVar == null || mVar.mpz == null)) {
                            if (mVar.mpz.field_appId.equals(str) || mVar.mpz.field_packageName.equals(str)) {
                                mVar.cj(this.mCr.mContext);
                                mVar.aAK();
                            }
                        }
                    }
                    int i2 = 0;
                    while (i2 < this.mCr.mrk.size()) {
                        c cVar = (c) this.mCr.mrk.get(i2);
                        if (cVar.type != 0 || (!(cVar.field_appId.equals(str) || cVar.field_packageName.equals(str)) || this.mCr.mxs == null)) {
                            i2++;
                        } else {
                            this.mCr.mxs.nE(i2);
                            return;
                        }
                    }
                } catch (Exception e) {
                    w.e("MicroMsg.GameListAdapter", e.getMessage());
                }
            }
        }
    };
    protected e mzy;

    public interface a {
        void nE(int i);
    }

    protected static class b {
        public TextProgressBar mCA;
        public GameListSocialView mCB;
        public ViewGroup mCC;
        public LinearLayout mCD;
        public TextView mCu;
        public ViewGroup mCv;
        public TextView mCw;
        public TextView mCx;
        public TextView mCy;
        public Button mCz;
        public ImageView mwf;
        public TextView mwg;

        protected b() {
        }
    }

    abstract void a(c cVar, b bVar);

    abstract void a(c cVar, b bVar, int i);

    static /* synthetic */ void a(l lVar, LinkedList linkedList) {
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (!(lVar.mCo.containsKey(cVar.field_appId) || cVar.type == 1 || cVar == null)) {
                m mVar = (m) lVar.mCo.get(cVar.field_appId);
                if (mVar == null) {
                    mVar = new m(cVar);
                    lVar.mCo.put(cVar.field_appId, mVar);
                }
                mVar.cj(lVar.mContext);
                mVar.aAK();
            }
        }
    }

    public l(Context context) {
        super(context);
        this.mContext = context;
        this.mCo = new ConcurrentHashMap();
        com.tencent.mm.plugin.game.model.l.a(this.mzx);
        this.mCp = new SparseArray();
        this.mzy = new e(context);
        this.mzy.mxb = this.mAi;
    }

    public void nC(int i) {
        this.mqT = i;
    }

    public void nF(int i) {
        this.myq = i;
    }

    public void refresh() {
        notifyDataSetChanged();
    }

    public void O(final LinkedList<c> linkedList) {
        if (linkedList != null) {
            ap.vL().D(new Runnable(this) {
                final /* synthetic */ l mCr;

                public final void run() {
                    l.a(this.mCr, linkedList);
                    af.v(new Runnable(this) {
                        final /* synthetic */ AnonymousClass1 mCs;

                        {
                            this.mCs = r1;
                        }

                        public final void run() {
                            super.O(linkedList);
                            w.i("MicroMsg.GameListAdapter", "add size: %d", new Object[]{Integer.valueOf(linkedList.size())});
                        }
                    });
                }
            });
        }
    }

    public void P(final LinkedList<c> linkedList) {
        if (linkedList != null) {
            e.post(new Runnable(this) {
                final /* synthetic */ l mCr;

                public final void run() {
                    l.a(this.mCr, linkedList);
                    af.v(new Runnable(this) {
                        final /* synthetic */ AnonymousClass2 mCt;

                        {
                            this.mCt = r1;
                        }

                        public final void run() {
                            super.P(linkedList);
                            w.i("MicroMsg.GameListAdapter", "set size: %d", new Object[]{Integer.valueOf(linkedList.size())});
                        }
                    });
                }
            }, "game_get_download_info");
        }
    }

    public int getItemViewType(int i) {
        return ((c) getItem(i)).type;
    }

    public int getViewTypeCount() {
        return 2;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        c cVar = (c) getItem(i);
        if (view == null) {
            int i2;
            Context context = this.mContext;
            switch (cVar.type) {
                case 0:
                    i2 = this.mCk;
                    break;
                case 1:
                    i2 = R.i.bSC;
                    break;
                default:
                    i2 = 0;
                    break;
            }
            view = View.inflate(context, i2, null);
            b bVar2 = new b();
            bVar2.mCv = (ViewGroup) view.findViewById(R.h.cgX);
            bVar2.mCu = (TextView) view.findViewById(R.h.bUK);
            bVar2.mwf = (ImageView) view.findViewById(R.h.bUc);
            bVar2.mwg = (TextView) view.findViewById(R.h.bUJ);
            bVar2.mCw = (TextView) view.findViewById(R.h.cnL);
            bVar2.mCx = (TextView) view.findViewById(R.h.bUe);
            bVar2.mCy = (TextView) view.findViewById(R.h.bSP);
            bVar2.mCz = (Button) view.findViewById(R.h.bTS);
            bVar2.mCA = (TextProgressBar) view.findViewById(R.h.bTT);
            bVar2.mCD = (LinearLayout) view.findViewById(R.h.bSC);
            bVar2.mCB = (GameListSocialView) view.findViewById(R.h.bUW);
            bVar2.mCC = (ViewGroup) view.findViewById(R.h.bHA);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        switch (cVar.type) {
            case 0:
                a(cVar, bVar, i);
                if (this.myq == 2 && !cVar.moR) {
                    ai.a(this.mContext, (int) MMBitmapFactory.ERROR_BEGIN_SAMPLE_FAILED, cVar.position, cVar.field_appId, this.mqT, cVar.moQ);
                    cVar.moR = true;
                    break;
                }
            case 1:
                a(cVar, bVar);
                break;
        }
        return view;
    }

    public void b(SparseArray<View> sparseArray) {
        if (sparseArray != null) {
            this.mCp = sparseArray;
        } else {
            this.mCp = new SparseArray();
        }
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.mxs = aVar;
    }

    public void x(View view, int i) {
        b bVar = (b) view.getTag();
        c cVar = (c) this.mrk.get(i);
        if (bVar != null) {
            this.mzy.a(bVar.mCA, bVar.mCz, cVar, (m) this.mCo.get(cVar.field_appId));
            return;
        }
        w.e("MicroMsg.GameListAdapter", "holder should not be null, %d", new Object[]{Integer.valueOf(i)});
    }

    public void clear() {
        super.clear();
        com.tencent.mm.plugin.game.model.l.b(this.mzx);
    }

    public void ya(String str) {
        c cVar;
        for (int i = 0; i < this.mrk.size(); i++) {
            if (((c) this.mrk.get(i)).field_appId.equals(str)) {
                cVar = (c) this.mrk.get(i);
                break;
            }
        }
        cVar = null;
        if (this.mCo.containsKey(cVar.field_appId)) {
            this.mzy.a(cVar, (m) this.mCo.get(cVar.field_appId));
            return;
        }
        w.e("MicroMsg.GameListAdapter", "No DownloadInfo found");
    }

    public void xZ(String str) {
        if (!bg.mA(str) && this.mCo.containsKey(str)) {
            m mVar = (m) this.mCo.get(str);
            if (mVar != null) {
                mVar.aAK();
            }
        }
    }

    public void xY(String str) {
        if (!bg.mA(str) && this.mCo.containsKey(str)) {
            m mVar = (m) this.mCo.get(str);
            if (mVar != null) {
                mVar.aAL();
            }
        }
    }
}
