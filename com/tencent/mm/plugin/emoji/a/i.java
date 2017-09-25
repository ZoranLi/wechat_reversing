package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.ah.n;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.plugin.emoji.e.m;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.ui.EmojiStoreVpHeader;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.emoji.StoreBannerEmojiView;
import com.tencent.mm.protocal.c.pn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.a.c;
import com.tencent.mm.ui.base.v;
import java.util.ArrayList;
import java.util.LinkedList;

public final class i extends v implements OnClickListener {
    public static int kIF = 60;
    public LinkedList<com.tencent.mm.plugin.emoji.model.a> kIE;
    private int kIG = 0;
    public boolean kIH = false;
    public ArrayList<String> kII = new ArrayList();
    private com.tencent.mm.ah.a.c.i kIJ = new com.tencent.mm.ah.a.c.i(this) {
        final /* synthetic */ i kIK;

        {
            this.kIK = r1;
        }

        public final void a(String str, Bitmap bitmap, Object... objArr) {
            w.i("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "onImageLoadComplete url:%s", new Object[]{str});
            this.kIK.mHandler.post(new Runnable(this) {
                final /* synthetic */ AnonymousClass1 kIL;

                {
                    this.kIL = r1;
                }

                public final void run() {
                    this.kIL.kIK.notifyDataSetChanged();
                }
            });
        }
    };
    private Context mContext;
    public ae mHandler = new ae();

    class a {
        final /* synthetic */ i kIK;
        StoreBannerEmojiView kIM;
        ImageView kIN;

        public a(i iVar, View view) {
            this.kIK = iVar;
            this.kIM = (StoreBannerEmojiView) view.findViewById(R.h.bKV);
            this.kIN = (ImageView) view.findViewById(R.h.cnS);
            this.kIM.mKc = 0;
        }
    }

    public i(Context context, LinkedList<com.tencent.mm.plugin.emoji.model.a> linkedList) {
        if (linkedList == null) {
            throw new IllegalAccessError("must has emoji banner list");
        }
        this.mContext = context;
        this.kIE = new LinkedList();
        this.kIE.addAll(linkedList);
    }

    public final void H(LinkedList<com.tencent.mm.plugin.emoji.model.a> linkedList) {
        this.kIE.clear();
        this.kIE.addAll(linkedList);
        notifyDataSetChanged();
    }

    public final int getCount() {
        if (this.kIE == null) {
            return 0;
        }
        return this.kIE.size() != 1 ? this.kIE.size() * kIF : 1;
    }

    public final void notifyDataSetChanged() {
        if (this.kIH) {
            w.i("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "has destroy need to notify");
            return;
        }
        this.kIG = getCount();
        super.notifyDataSetChanged();
    }

    public final int j(Object obj) {
        if (this.kIG <= 0) {
            return super.j(obj);
        }
        this.kIG--;
        return -2;
    }

    public final View c(int i, View view) {
        if (this.kIE == null) {
            return null;
        }
        a aVar;
        int size = i % this.kIE.size();
        a aVar2;
        if (view == null) {
            w.i("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "getView inflate");
            view = View.inflate(this.mContext, R.i.daX, null);
            aVar2 = new a(this, view);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar2 = (a) view.getTag();
            int i2 = EmojiStoreVpHeader.aG(this.mContext)[0];
            aVar2.kIM.setLayoutParams(new LayoutParams(i2, ((i2 * 3) / 8) + 1));
            aVar = aVar2;
        }
        view.setTag(R.h.bLg, Integer.valueOf(size));
        view.setOnClickListener(this);
        com.tencent.mm.plugin.emoji.model.a aVar3 = (com.tencent.mm.plugin.emoji.model.a) this.kIE.get(size);
        if (aVar3 == null) {
            w.e("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "BaseEmotionBanner is null.");
            return null;
        }
        String str;
        String str2;
        if (aVar3.kLy) {
            str = aVar3.kLw.tuK.tuL;
            if (bg.mA(aVar3.kLw.tuM)) {
                str2 = "H5";
            } else {
                str2 = "Toptic";
            }
        } else {
            str = aVar3.kLx.tuK.tuL;
            str2 = aVar3.kLx.tuJ.tgW;
        }
        if (!(aVar3 == null || bg.mA(str))) {
            com.tencent.mm.bg.a.getDensity(this.mContext);
            c a = EmojiLogic.a(str2, 8, str, true);
            if (a != null) {
                aVar.kIM.ct(a.eN(a.field_groupId, a.EP()), null);
            } else if (this.kII.contains(str)) {
                w.i("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "url has add to list. no need to try load image.");
                aVar.kIM.ct("-", null);
            } else {
                n.GW().a(str, null, f.b(str2, str, new Object[]{str2, "BANNER"}), this.kIJ);
                this.kII.add(str);
            }
        }
        w.d("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "position:%d allPostion:%d banner url:%s ", new Object[]{Integer.valueOf(size), Integer.valueOf(i), str});
        return view;
    }

    public final void onClick(View view) {
        com.tencent.mm.plugin.emoji.model.a aVar = (com.tencent.mm.plugin.emoji.model.a) this.kIE.get(((Integer) view.getTag(R.h.bLg)).intValue());
        if (aVar == null) {
            return;
        }
        if (aVar.kLy) {
            m.a(this.mContext, aVar.kLw, true);
            return;
        }
        pn pnVar = aVar.kLx.tuJ;
        if (pnVar != null) {
            String str = "MicroMsg.emoji.EmojiStoreVpHeaderAdapter";
            String str2 = "productId %s";
            Object[] objArr = new Object[1];
            objArr[0] = pnVar == null ? "" : pnVar.tgW;
            w.d(str, str2, objArr);
            g.oUh.i(11929, new Object[]{Integer.valueOf(0)});
            m.a(this.mContext, pnVar, 15, -1, -1, "", 8);
        }
    }
}
