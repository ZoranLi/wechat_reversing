package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.ah.n;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.h;
import com.tencent.mm.protocal.c.ov;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.r;
import java.util.ArrayList;
import java.util.List;

public final class d extends BaseAdapter {
    List<ov> kIf;
    private int kIv;
    private int kIw;
    private int kIx;
    private boolean kZC;
    private LayoutParams kZD;
    private LayoutParams kZE;
    a kZF;
    private Context mContext;
    private int mNumColumns;

    interface a {
        void lk(int i);
    }

    class b {
        LinearLayout kID;
        final /* synthetic */ d kZH;

        b(d dVar) {
            this.kZH = dVar;
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        return lN(i);
    }

    public d(Context context) {
        this.mNumColumns = 3;
        this.kZC = true;
        this.mNumColumns = 3;
        this.mContext = context;
        this.kIw = com.tencent.mm.bg.a.dO(this.mContext);
        this.kIv = this.mContext.getResources().getDimensionPixelSize(R.f.aZD);
        this.kIx = (int) (((float) (this.kIw - (this.mNumColumns * this.kIv))) / (((float) this.mNumColumns) + 1.0f));
    }

    public final void ao(List<ov> list) {
        if (this.kIf == null) {
            this.kIf = new ArrayList();
        } else {
            this.kIf.clear();
        }
        this.kIf = list;
        notifyDataSetChanged();
    }

    private int ano() {
        return this.kIf == null ? 0 : this.kIf.size();
    }

    public final int getCount() {
        return this.kIf == null ? 0 : (int) Math.ceil((double) (((float) this.kIf.size()) / ((float) this.mNumColumns)));
    }

    public final ov lN(int i) {
        if (i < 0 || i >= ano() || this.kIf == null) {
            return null;
        }
        return (ov) this.kIf.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null || view.getTag() == null) {
            view = r.eC(this.mContext).inflate(R.i.daR, null);
            bVar = new b(this);
            bVar.kID = (LinearLayout) view.findViewById(R.h.bZe);
            bVar.kID.setPadding(0, this.kIx, 0, 0);
            view.setTag(bVar);
            for (int i2 = 0; i2 < this.mNumColumns; i2++) {
                this.kZE = new LayoutParams(-2, -2);
                this.kZE.leftMargin = this.kIx;
                this.kZD = new LayoutParams(this.kIv, this.kIv);
                View paddingImageView = new PaddingImageView(this.mContext);
                ViewGroup.LayoutParams layoutParams = this.kZD;
                paddingImageView.addView(paddingImageView.kZz, layoutParams);
                paddingImageView.addView(paddingImageView.kZA, layoutParams);
                bVar.kID.addView(paddingImageView, i2, this.kZE);
            }
        } else {
            bVar = (b) view.getTag();
        }
        for (int i3 = 0; i3 < this.mNumColumns; i3++) {
            final int i4 = (this.mNumColumns * i) + i3;
            final PaddingImageView paddingImageView2 = (PaddingImageView) bVar.kID.getChildAt(i3);
            if (i4 <= ano() - 1) {
                ov lN = lN(i4);
                if (lN != null) {
                    String stringBuilder;
                    com.tencent.mm.ah.a.a GW;
                    String str;
                    ImageView imageView;
                    String str2;
                    if (!bg.mA(lN.ohq)) {
                        StringBuilder stringBuilder2 = new StringBuilder();
                        ap.yY();
                        stringBuilder = stringBuilder2.append(EmojiLogic.D(c.xi(), "", lN.tup)).append("_cover").toString();
                        GW = n.GW();
                        str = lN.ohq;
                        imageView = paddingImageView2.kZz;
                        str2 = lN.ohq;
                        GW.a(str, imageView, f.a(stringBuilder, this.kIv, new Object[0]));
                    } else if (bg.mA(lN.msN)) {
                        w.w("MicroMsg.emoji.PreViewListGridAdapter", "this emoji has no thumb url and url. download faild");
                    } else {
                        ap.yY();
                        stringBuilder = EmojiLogic.D(c.xi(), "", lN.tup);
                        GW = h.alV();
                        str = lN.msN;
                        imageView = paddingImageView2.kZz;
                        str2 = lN.msN;
                        GW.a(str, imageView, f.a(stringBuilder, this.kIv, new Object[0]));
                    }
                    paddingImageView2.setClickable(true);
                    paddingImageView2.kZA.setBackgroundResource(R.g.beQ);
                    paddingImageView2.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ d kZH;

                        public final void onClick(View view) {
                            if (this.kZH.kZF != null) {
                                this.kZH.kZF.lk(i4);
                            }
                        }
                    });
                } else {
                    paddingImageView2.kZA.setBackgroundDrawable(null);
                    n.GW().a("", paddingImageView2.kZz);
                    w.w("MicroMsg.emoji.PreViewListGridAdapter", "item is null");
                    paddingImageView2.setClickable(false);
                    paddingImageView2.setOnClickListener(null);
                }
            } else {
                paddingImageView2.kZA.setBackgroundDrawable(null);
                n.GW().a("", paddingImageView2.kZz);
                paddingImageView2.setClickable(false);
                paddingImageView2.setOnClickListener(null);
            }
        }
        return view;
    }
}
