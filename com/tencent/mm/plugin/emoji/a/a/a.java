package com.tencent.mm.plugin.emoji.a.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import com.tencent.mm.plugin.emoji.model.e;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.ak;
import java.util.HashMap;

public abstract class a extends BaseAdapter {
    private final String TAG = "MicroMsg.BaseEmojiListAdapter";
    private final String gSq = "lock";
    private HashMap<String, com.tencent.mm.plugin.emoji.a.a> kIA;
    public AbsListView kIO;
    public c kIP;
    public com.tencent.mm.plugin.emoji.model.g.a kIQ;
    protected volatile boolean kIR = false;
    private int kIS = 0;
    private int kIT = 0;
    public Context mContext;

    public abstract int alm();

    public abstract int aln();

    public abstract int alo();

    public abstract View b(int i, View view, ViewGroup viewGroup);

    public abstract com.tencent.mm.plugin.emoji.a.a c(Context context, View view);

    public abstract void lg(int i);

    public abstract void lh(int i);

    public abstract void li(int i);

    public /* synthetic */ Object getItem(int i) {
        return lj(i);
    }

    public a(Context context) {
        this.mContext = context;
        if (this.mContext != null) {
            this.kIA = new HashMap();
        }
    }

    public final void a(c cVar) {
        if (cVar != null && this.kIP != cVar) {
            this.kIP = cVar.alr();
            notifyDataSetChanged();
        }
    }

    public void all() {
        if (this.kIA != null) {
            this.kIA.clear();
        }
        super.notifyDataSetChanged();
        this.kIR = true;
    }

    public void notifyDataSetChanged() {
        Object[] objArr;
        int i;
        this.kIR = false;
        if (this.kIP != null) {
            this.kIP.notifyDataSetChanged();
            objArr = new Object[1];
            i = this.kIS;
            this.kIS = i + 1;
            objArr[0] = Integer.valueOf(i);
            w.d("MicroMsg.BaseEmojiListAdapter", "xxx data Notify: %d", objArr);
        }
        objArr = new Object[1];
        i = this.kIT;
        this.kIT = i + 1;
        objArr[0] = Integer.valueOf(i);
        w.v("MicroMsg.BaseEmojiListAdapter", "xxx ui Notify: %d", objArr);
        all();
    }

    public final void b(final e eVar) {
        af.v(new Runnable(this) {
            final /* synthetic */ a kIV;

            public final void run() {
                if (eVar != null) {
                    this.kIV.kIP = this.kIV.a(eVar);
                    this.kIV.notifyDataSetChanged();
                }
            }
        });
    }

    public c a(e eVar) {
        return new c(eVar);
    }

    public int getCount() {
        return this.kIP == null ? 0 : this.kIP.size();
    }

    public f lj(int i) {
        return this.kIP == null ? null : this.kIP.ln(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        com.tencent.mm.plugin.emoji.a.a aVar = null;
        if (view != null) {
            aVar = (com.tencent.mm.plugin.emoji.a.a) view.getTag();
        }
        f lj = lj(i);
        if (aVar == null) {
            aVar = c(this.mContext, view);
            view = aVar.ali();
            this.kIA.put(a(lj), aVar);
        } else if (!bg.mA(a(lj))) {
            if (this.kIA.containsValue(aVar)) {
                this.kIA.remove(aVar.alb());
            }
            this.kIA.put(a(lj), aVar);
        }
        aVar.kC = i;
        aVar.kHz = lj;
        View b = b(i, view, viewGroup);
        aVar.alh();
        return b;
    }

    public static String a(f fVar) {
        if (fVar == null) {
            return null;
        }
        if (fVar.kJa == com.tencent.mm.plugin.emoji.a.a.f.a.kJj) {
            return fVar.kJc.fxo + "_cell";
        }
        return fVar.kJb.tgW;
    }

    public void clear() {
        if (this.kIA != null) {
            this.kIA.clear();
            this.kIA = null;
        }
        if (this.kIP != null) {
            this.kIP.clear();
            this.kIP = null;
        }
        this.kIR = false;
    }

    public void aH(String str, int i) {
        if (this.kIA != null && this.kIP != null && str != null) {
            f tU = this.kIP.tU(str);
            if (tU != null) {
                a(tU, str, i);
            }
            if (!(tU == null || this.kIP == null || tU.mStatus != -1)) {
                w.i("MicroMsg.BaseEmojiListAdapter", "force refresh status");
                tU.a(this.kIP.kIY, this.kIP.tY(str), this.kIP.tW(str));
            }
            com.tencent.mm.plugin.emoji.a.a tT = tT(str);
            if (tT != null) {
                String alb = tT.alb() == null ? null : tT.alb();
                if (alb != null && alb.equals(str)) {
                    tT.alh();
                }
            }
        }
    }

    public final com.tencent.mm.plugin.emoji.a.a tT(String str) {
        if (this.kIA == null) {
            return null;
        }
        return (com.tencent.mm.plugin.emoji.a.a) this.kIA.get(str);
    }

    public final void aI(String str, int i) {
        if (this.kIA != null && this.kIP != null && str != null) {
            f tU = this.kIP.tU(str);
            if (tU != null) {
                if (i >= 0 && i < 100) {
                    a(tU, str, 6);
                    tU.sd = i;
                }
                if (i >= 100) {
                    a(tU, str, 7);
                }
            }
            com.tencent.mm.plugin.emoji.a.a tT = tT(str);
            if (tT != null) {
                String alb = tT.alb() == null ? null : tT.alb();
                if (alb != null && alb.equals(str)) {
                    tT.alh();
                }
            }
        }
    }

    public final void a(f fVar, String str, int i) {
        if (fVar != null && str != null) {
            fVar.dv(i);
            ak akVar = (ak) this.kIP.kIW.get(str);
            if (akVar != null) {
                akVar.yD(i);
            }
        }
    }

    public final void aiQ() {
        if (this.kIR) {
            super.notifyDataSetChanged();
        }
    }
}
