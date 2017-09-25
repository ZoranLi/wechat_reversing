package com.tencent.mm.plugin.emoji.ui.smiley;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListAdapter;
import com.tencent.mm.R;
import com.tencent.mm.ah.n;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.plugin.emoji.e.l;
import com.tencent.mm.plugin.emoji.model.h;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleRecommendView;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.base.v;
import java.util.ArrayList;
import java.util.HashMap;

public final class g extends v {
    private final String TAG = "MicroMsg.emoji.SmileyPanel.SmileyPanelViewPagerAdapter";
    private f kTE;
    boolean kVC;
    private View kVD;
    private Context mContext;
    int mCount;

    class a {
        EmojiStoreV2SingleRecommendView kVF;
        SmileySubGrid kVG;
        final /* synthetic */ g kVH;

        public a(g gVar, View view, com.tencent.mm.plugin.emoji.ui.smiley.f.a aVar) {
            this.kVH = gVar;
            switch (aVar) {
                case RECOMMEND:
                    this.kVF = (EmojiStoreV2SingleRecommendView) view;
                    return;
                case DEFAULT:
                case EMOJI:
                    this.kVG = (SmileySubGrid) view.findViewById(R.h.cFL);
                    return;
                default:
                    return;
            }
        }
    }

    public g(f fVar, Context context) {
        this.mContext = context;
        this.kTE = fVar;
    }

    public final View c(int i, View view) {
        a aVar;
        d lC = this.kTE.lC(i);
        String str = lC.kMS;
        com.tencent.mm.plugin.emoji.ui.smiley.f.a aVar2 = "TAG_DEFAULT_TAB".equals(str) ? com.tencent.mm.plugin.emoji.ui.smiley.f.a.DEFAULT : (String.valueOf(com.tencent.mm.storage.a.a.uKR).equals(str) || String.valueOf(com.tencent.mm.storage.a.a.uKQ).equals(str)) ? com.tencent.mm.plugin.emoji.ui.smiley.f.a.EMOJI : !lC.kTL ? com.tencent.mm.plugin.emoji.ui.smiley.f.a.RECOMMEND : com.tencent.mm.plugin.emoji.ui.smiley.f.a.EMOJI;
        a aVar3;
        if (view == null || view.getTag() == null || view.getTag(R.h.cFM) != aVar2) {
            switch (aVar2) {
                case RECOMMEND:
                    view = new EmojiStoreV2SingleRecommendView(this.mContext, this.kTE.aop());
                    break;
                case DEFAULT:
                case EMOJI:
                    view = LayoutInflater.from(this.mContext).inflate(R.i.doK, null);
                    break;
            }
            aVar3 = new a(this, view, aVar2);
            view.setTag(aVar3);
            view.setTag(R.h.cFM, aVar2);
            aVar = aVar3;
        } else {
            aVar3 = (a) view.getTag();
            view.setTag(R.h.cFM, aVar2);
            aVar = aVar3;
        }
        int i2;
        switch (aVar2) {
            case RECOMMEND:
                EmojiStoreV2SingleRecommendView emojiStoreV2SingleRecommendView = aVar.kVF;
                emojiStoreV2SingleRecommendView.kMI = lC.kMS;
                if (!bg.mA(emojiStoreV2SingleRecommendView.kMI)) {
                    emojiStoreV2SingleRecommendView.kZb = h.amc().kLb.aP(emojiStoreV2SingleRecommendView.kMI, false);
                    emojiStoreV2SingleRecommendView.kRi.setOnClickListener(emojiStoreV2SingleRecommendView);
                    emojiStoreV2SingleRecommendView.kYZ.setOnClickListener(emojiStoreV2SingleRecommendView);
                    emojiStoreV2SingleRecommendView.kYV.setOnClickListener(emojiStoreV2SingleRecommendView);
                    com.tencent.mm.storage.a.a aVar4 = emojiStoreV2SingleRecommendView.kZb;
                    if (emojiStoreV2SingleRecommendView.kYZ != null) {
                        switch (aVar4.field_buttonType) {
                            case 1:
                                emojiStoreV2SingleRecommendView.kYZ.setVisibility(0);
                                emojiStoreV2SingleRecommendView.kYZ.setText(R.l.edi);
                                break;
                            case 2:
                                emojiStoreV2SingleRecommendView.kYZ.setVisibility(0);
                                emojiStoreV2SingleRecommendView.kYZ.setText(R.l.eAP);
                                break;
                            default:
                                emojiStoreV2SingleRecommendView.kYZ.setVisibility(8);
                                break;
                        }
                    }
                    if (!bg.mA(aVar4.field_packName)) {
                        emojiStoreV2SingleRecommendView.kYX.setText(aVar4.field_packName);
                    }
                    if (emojiStoreV2SingleRecommendView.kYY != null) {
                        if (bg.mA(aVar4.field_recommandWord)) {
                            emojiStoreV2SingleRecommendView.kYY.setVisibility(8);
                        } else {
                            emojiStoreV2SingleRecommendView.kYY.setVisibility(0);
                            emojiStoreV2SingleRecommendView.kYY.setText(aVar4.field_recommandWord);
                        }
                    }
                    emojiStoreV2SingleRecommendView.kZa.setVisibility(8);
                    n.GW().a(emojiStoreV2SingleRecommendView.kZb.field_BigIconUrl, emojiStoreV2SingleRecommendView.kYW, f.b(emojiStoreV2SingleRecommendView.kMI, emojiStoreV2SingleRecommendView.kZb.field_BigIconUrl, new Object[0]));
                    break;
                }
                emojiStoreV2SingleRecommendView.kYV.setVisibility(8);
                break;
            case DEFAULT:
                com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a aVar5;
                b bVar = new b(this.mContext, this.kTE);
                aVar.kVG.setAdapter((ListAdapter) bVar);
                aVar.kVG.anL();
                aVar.kVG.kTz = lC.anR();
                SmileyGrid smileyGrid = aVar.kVG;
                e eVar = lC.kTF;
                if (eVar.kUc == null) {
                    aVar5 = null;
                } else {
                    aVar5 = eVar.kUc.anQ();
                }
                smileyGrid.kTA = aVar5;
                aVar.kVG.setNumColumns(lC.kTJ);
                aVar.kVG.setColumnWidth(lC.getColumnWidth());
                aVar.kVG.setScrollbarFadingEnabled(false);
                aVar.kVG.setVerticalScrollBarEnabled(false);
                aVar.kVG.setSelector(R.g.bhc);
                aVar.kVG.setHorizontalScrollBarEnabled(false);
                aVar.kVG.setVerticalScrollBarEnabled(false);
                aVar.kVG.setLongClickable(false);
                aVar.kVG.anL();
                i2 = this.kTE.uJ(lC.kMS).kTK;
                aVar.kVG.setPadding(0, i2 == 0 ? this.kTE.kUY : i2, 0, 0);
                aVar.kVG.setVerticalSpacing(i2 / 2);
                aVar.kVG.f(lC.getType(), i - lC.kTH, lC.kTG, lC.anU(), lC.anV());
                aVar.kVG.kWa = false;
                aVar.kVG.hPi = this.kTE.hPi;
                bVar.b(lC.getType(), lC.kTG, lC.anU(), lC.anV(), i - lC.kTH, lC.kTI, lC.kTJ);
                bVar.kTo = lC.kMS;
                break;
            case EMOJI:
                c cVar = new c(this.mContext, this.kTE);
                aVar.kVG.setAdapter((ListAdapter) cVar);
                aVar.kVG.anL();
                aVar.kVG.setNumColumns(lC.kTJ);
                aVar.kVG.setColumnWidth(lC.getColumnWidth());
                aVar.kVG.setScrollbarFadingEnabled(false);
                aVar.kVG.setHorizontalScrollBarEnabled(false);
                aVar.kVG.setVerticalScrollBarEnabled(false);
                aVar.kVG.kTz = lC.anR();
                aVar.kVG.setFastScrollEnabled(false);
                aVar.kVG.kVU = lC.kTF.kTR;
                aVar.kVG.anL();
                i2 = this.kTE.uJ(lC.kMS).kTK;
                aVar.kVG.setPadding(0, i2 == 0 ? this.kTE.kUY : i2, 0, 0);
                aVar.kVG.setVerticalSpacing(i2 / 2);
                aVar.kVG.kWa = true;
                aVar.kVG.hPi = this.kTE.hPi;
                aVar.kVG.f(lC.getType(), i - lC.kTH, lC.kTG, lC.anU(), lC.anV());
                cVar.b(lC.getType(), lC.kTG, lC.kTJ * lC.kTI, lC.anV(), i - lC.kTH, lC.kTI, lC.kTJ);
                cVar.kTo = lC.kMS;
                if (cVar.kTk != 23) {
                    if (cVar.kTk == 25) {
                        cVar.kRX = h.amc().alM();
                        break;
                    }
                }
                l amc = h.amc();
                String str2 = cVar.kTo;
                if (l.kLq == null) {
                    l.kLq = new HashMap();
                }
                if (l.kLn) {
                    l.kLq.clear();
                    l.kLn = false;
                }
                if (!l.kLq.containsKey(str2)) {
                    ap.yY();
                    if (c.isSDCardAvailable()) {
                        l.kLq.put(str2, (ArrayList) amc.kLa.ud(str2));
                    }
                }
                cVar.kRX = (ArrayList) l.kLq.get(str2);
                break;
                break;
        }
        this.kVD = view;
        return view;
    }

    public final int getCount() {
        return this.mCount;
    }

    public final int j(Object obj) {
        if (!this.kVC) {
            return super.j(obj);
        }
        w.d("MicroMsg.emoji.SmileyPanel.SmileyPanelViewPagerAdapter", "get item position always changed");
        return -2;
    }

    public final void aos() {
        f fVar = this.kTE;
        this.mCount = fVar.kVd ? fVar.uJ("TAG_DEFAULT_TAB").anV() : fVar.kUZ;
        w.d("MicroMsg.emoji.SmileyPanel.SmileyPanelViewPagerAdapter", "refresh data mCount:%d", new Object[]{Integer.valueOf(this.mCount)});
    }
}
