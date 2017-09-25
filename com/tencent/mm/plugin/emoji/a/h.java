package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.ah.n;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;

public final class h extends com.tencent.mm.plugin.emoji.a.a.a {
    private HashMap<String, b> kIA;
    public int kIo = 0;
    private int kIt;
    private int kIu;
    private int kIv;
    private int kIw;
    private int kIx;
    private boolean kIy;
    public a kIz;
    private Context mContext;
    private int mNumColumns = 3;

    public interface a {
        void lk(int i);
    }

    class b {
        final /* synthetic */ h kIC;
        LinearLayout kID;

        b(h hVar) {
            this.kIC = hVar;
        }
    }

    public h(Context context) {
        super(context);
        this.mContext = context;
        this.kIy = false;
        this.kIt = this.mContext.getResources().getDimensionPixelSize(R.f.aXH);
        this.kIu = this.mContext.getResources().getDimensionPixelSize(R.f.aWD);
        this.kIv = this.mContext.getResources().getDimensionPixelSize(R.f.aZD);
        this.kIw = com.tencent.mm.bg.a.dO(this.mContext);
        this.kIx = (int) (((float) (this.kIw - (this.mNumColumns * this.kIv))) / (((float) this.mNumColumns) + 1.0f));
    }

    public final int alq() {
        if (!this.kIy) {
            return super.getCount();
        }
        if (this.kIo == 0) {
            return 0;
        }
        if (this.kIo <= 0 || super.getCount() <= this.kIo) {
            return super.getCount();
        }
        return this.kIo;
    }

    public final int getCount() {
        if (!this.kIy) {
            int alq = alq();
            if (alq > this.kIo) {
                return (int) Math.ceil((double) (((float) (alq - this.kIo)) / ((float) this.mNumColumns)));
            }
            return 0;
        } else if (this.kIo == 0) {
            return 0;
        } else {
            if (this.kIo <= 0 || alq() <= this.kIo) {
                return (int) Math.ceil((double) (((float) alq()) / ((float) this.mNumColumns)));
            }
            return (int) Math.ceil((double) (((float) this.kIo) / ((float) this.mNumColumns)));
        }
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null || view.getTag() == null) {
            view = new LinearLayout(this.mContext);
            LayoutParams layoutParams = new AbsListView.LayoutParams(-1, -2);
            view.setBackgroundResource(R.g.bkS);
            view.setOrientation(0);
            view.setLayoutParams(layoutParams);
            view.setPadding(0, 0, 0, this.kIu);
            b bVar2 = new b(this);
            bVar2.kID = view;
            view.setTag(bVar2);
            for (int i2 = 0; i2 < this.mNumColumns; i2++) {
                LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams2.leftMargin = this.kIx;
                bVar2.kID.addView(new b(this.mContext, R.i.daK).kHP, i2, layoutParams2);
            }
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        for (int i3 = 0; i3 < this.mNumColumns; i3++) {
            int i4;
            if (this.kIy) {
                i4 = this.mNumColumns * i;
            } else {
                i4 = (this.mNumColumns * i) + this.kIo;
            }
            i4 += i3;
            final b bVar3 = new b(this.mContext, bVar.kID.getChildAt(i3));
            bVar3.kHP.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ h kIC;

                public final void onClick(View view) {
                    if (this.kIC.kIz != null) {
                        this.kIC.kIz.lk(i4);
                    }
                }
            });
            f lj = lj(i4);
            if (i4 > alq() - 1 || lj == null) {
                bVar3.kHP.setClickable(false);
                bVar3.kHP.setVisibility(8);
                bVar3.kHZ.setBackgroundDrawable(null);
            } else {
                if (this.kIA == null) {
                    this.kIA = new HashMap();
                }
                if (this.kIA.containsValue(bVar3)) {
                    this.kIA.remove(bVar3.kHX);
                }
                bVar3.kHX = a(lj);
                this.kIA.put(a(lj), bVar3);
                bVar3.kHP.setVisibility(0);
                bVar3.kmZ.setText(lj.kJb.tuV);
                n.GW().a(lj.kJb.muU, bVar3.kHY, com.tencent.mm.plugin.emoji.e.f.bL(lj.kJb.tgW, lj.kJb.muU));
                bVar3.kHZ.setBackgroundResource(R.g.beN);
                bVar3.kHP.setClickable(true);
                a(bVar3, lj.mStatus);
            }
        }
        return view;
    }

    private void a(b bVar, int i) {
        switch (i) {
            case 7:
                bVar.kmZ.setTextColor(this.mContext.getResources().getColor(R.e.aUk));
                Drawable drawable = this.mContext.getResources().getDrawable(R.k.dwF);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                bVar.kmZ.setCompoundDrawables(null, null, drawable, null);
                return;
            default:
                bVar.kmZ.setTextColor(this.mContext.getResources().getColor(R.e.aVo));
                bVar.kmZ.setCompoundDrawables(null, null, null, null);
                w.w("MicroMsg.emoji.EmojiStoreV2PersonAdapter", "unknow product status:%d", new Object[]{Integer.valueOf(i)});
                return;
        }
    }

    protected final a c(Context context, View view) {
        return null;
    }

    public final int alm() {
        return this.kIo;
    }

    public final void lg(int i) {
        this.kIo = i;
    }

    public final int aln() {
        return 0;
    }

    public final void lh(int i) {
    }

    public final int alo() {
        return 0;
    }

    public final void li(int i) {
    }

    public final View b(int i, View view, ViewGroup viewGroup) {
        return null;
    }

    public final void aH(String str, int i) {
        if (this.kIA == null) {
            w.w("MicroMsg.emoji.EmojiStoreV2PersonAdapter", "updateStatus mCacheHolder is nulll.");
            return;
        }
        b bVar = (b) this.kIA.get(str);
        f tU = this.kIP.tU(str);
        if (tU != null) {
            a(tU, str, i);
        }
        if (!(tU == null || this.kIP == null || tU.mStatus != -1)) {
            w.i("MicroMsg.emoji.EmojiStoreV2PersonAdapter", "force refresh status");
            tU.a(this.kIP.kIY, this.kIP.tY(str), this.kIP.tW(str));
        }
        if (bVar == null) {
            w.w("MicroMsg.emoji.EmojiStoreV2PersonAdapter", "updateStatus viewHolder is nulll.");
        } else {
            a(bVar, i);
        }
    }
}
