package com.tencent.mm.plugin.emoji.ui.smiley;

import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.me;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.emoji.ui.smiley.SmileyPanelScrollView.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.chat.j;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.base.HorizontalListViewV2;
import com.tencent.mm.ui.base.MMRadioGroupView.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public final class e implements android.support.v4.view.ViewPager.e, OnClickListener, b, com.tencent.mm.plugin.emoji.ui.smiley.SmileyPanelViewPager.a, c {
    private final String TAG = "MicroMsg.emoji.SmileyPanel.SmileyPanelManager";
    Context kLX;
    final com.tencent.mm.sdk.e.j.a kLt = new com.tencent.mm.sdk.e.j.a(this) {
        final /* synthetic */ e kUj;

        {
            this.kUj = r1;
        }

        public final void a(String str, l lVar) {
            if (str != null) {
                if (str.equalsIgnoreCase("delete_emoji_info_notify")) {
                    this.kUj.aoc();
                    return;
                }
                com.tencent.mm.storage.a.c ub = ((com.tencent.mm.plugin.emoji.b.c) h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().ub(str);
                if (ub != null && ub.field_catalog == com.tencent.mm.storage.a.c.uKY) {
                    com.tencent.mm.plugin.emoji.model.h.amc().alM();
                    this.kUj.aoc();
                }
            }
        }
    };
    final com.tencent.mm.sdk.b.c kLu = new com.tencent.mm.sdk.b.c<me>(this) {
        final /* synthetic */ e kUj;

        {
            this.kUj = r2;
            this.usg = me.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            w.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "REFRESH_PANEL_EVENT");
            this.kUj.aoc();
            return false;
        }
    };
    public f kTE;
    private final int kTN = 100;
    private final int kTO = 1102;
    private final int kTP = 1103;
    private final int kTQ = 100;
    public SmileyPanelViewPager kTR;
    private g kTS;
    SmileyPanelScrollView kTT;
    HorizontalListViewV2 kTU;
    public h kTV;
    View kTW;
    ImageView kTX;
    ImageView kTY;
    private ImageButton kTZ;
    ImageButton kUa;
    TextView kUb;
    a kUc;
    public int kUd = -1;
    private boolean kUe = false;
    public boolean kUf = true;
    public String kUg;
    final com.tencent.mm.sdk.e.j.a kUh = new com.tencent.mm.sdk.e.j.a(this) {
        final /* synthetic */ e kUj;

        {
            this.kUj = r1;
        }

        public final void a(String str, l lVar) {
            if (!TextUtils.isEmpty(str)) {
                if (str.equals("event_update_group") || str.equalsIgnoreCase("productID")) {
                    w.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "modify emoji group .");
                    this.kUj.aoc();
                }
            }
        }
    };
    OnItemClickListener kUi = new OnItemClickListener(this) {
        final /* synthetic */ e kUj;

        {
            this.kUj = r1;
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            com.tencent.mm.storage.a.a lE = this.kUj.kTV.lE(i);
            if (lE.field_productID.equalsIgnoreCase("TAG_STORE_MANEGER_TAB")) {
                d.b(this.kUj.ty, "emoji", ".ui.EmojiMineUI", null);
                return;
            }
            this.kUj.c(this.kUj.kTE.lD(this.kUj.kUd), false, true);
            d uJ = this.kUj.kTE.uJ(lE.field_productID);
            this.kUj.kUd = uJ.kTH;
            int anV = uJ.kTM > uJ.anV() + -1 ? uJ.anV() - 1 : uJ.kTM;
            if (this.kUj.kTR != null) {
                this.kUj.kTR.k(this.kUj.kUd + anV, false);
            }
            this.kUj.j(uJ.anV(), anV, true);
            this.kUj.kTE.kVc = anV;
            this.kUj.kTE.uI(lE.field_productID);
            if (lE.equals(String.valueOf(com.tencent.mm.storage.a.a.uKR))) {
                g.oUh.i(11594, new Object[]{Integer.valueOf(0)});
            }
        }
    };
    private ae mHandler = new ae(this) {
        final /* synthetic */ e kUj;

        {
            this.kUj = r1;
        }

        public final void handleMessage(Message message) {
            boolean z = true;
            switch (message.what) {
                case 1102:
                    this.kUj.anW();
                    this.kUj.kUf = true;
                    if (this.kUj.kUg != null && this.kUj.kTR != null) {
                        int i = this.kUj.kTE.kVc;
                        if (i < 0 || i > this.kUj.kTE.uJ(this.kUj.kUg).anV()) {
                            i = this.kUj.kTE.uJ(this.kUj.kUg).anV() - 1;
                        }
                        this.kUj.kUd = i + this.kUj.kTE.uJ(this.kUj.kUg).kTH;
                        this.kUj.kTR.Y(this.kUj.kUd);
                        this.kUj.kUg = null;
                        return;
                    }
                    return;
                case 1103:
                    w.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "update selection");
                    e eVar = this.kUj;
                    int i2 = message.arg1;
                    if (message.arg2 != 1) {
                        z = false;
                    }
                    eVar.c(i2, z, false);
                    return;
                default:
                    return;
            }
        }
    };
    View mView;
    Context ty = ab.getContext();

    class AnonymousClass3 implements Runnable {
        final /* synthetic */ String kKL;
        final /* synthetic */ e kUj;

        AnonymousClass3(e eVar, String str) {
            this.kUj = eVar;
            this.kKL = str;
        }

        public final void run() {
            if (this.kUj.kTR != null && this.kUj.kTE != null && this.kUj.kTE.uJ(this.kKL) != null) {
                this.kUj.kUd = this.kUj.kTE.uJ(this.kKL).kTH;
                this.kUj.kTR.Y(this.kUj.kUd);
                this.kUj.kTE.kVc = 0;
            }
        }
    }

    public interface a {
        com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a anQ();

        j anR();
    }

    public e(Context context, f fVar, a aVar) {
        this.kLX = context;
        this.kTE = fVar;
        this.kUc = aVar;
        w.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "SmileyPanelManager add listener.");
        com.tencent.mm.plugin.emoji.model.h.amc().kLb.c(this.kUh);
        com.tencent.mm.plugin.emoji.model.h.amc().kLa.c(this.kLt);
        com.tencent.mm.sdk.b.a.urY.b(this.kLu);
    }

    public final synchronized void anW() {
        if (this.mView == null || !this.kTE.kVs) {
            w.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "not view can't deal");
        } else {
            Object obj;
            com.tencent.mm.plugin.emoji.e.l amc;
            ArrayList arrayList;
            int i;
            int i2;
            Collection arrayList2;
            Iterator it;
            int i3;
            com.tencent.mm.storage.a.a aVar;
            h hVar;
            long currentTimeMillis = System.currentTimeMillis();
            this.kTE.kVh = false;
            w.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "initSmileyData");
            long currentTimeMillis2 = System.currentTimeMillis();
            f fVar = this.kTE;
            if (fVar.kVp != null) {
                Iterator it2 = fVar.kVp.iterator();
                while (it2.hasNext()) {
                    if (((d) it2.next()) != null) {
                        w.v("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "removeAllGridViewListener listener: %s", new Object[]{((d) it2.next()).kMS});
                    } else {
                        w.d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "removeAllGridViewListener already release: ..");
                    }
                }
            }
            if (fVar.kVp != null) {
                fVar.kVp.clear();
            }
            if (com.tencent.mm.plugin.emoji.model.h.amc().kLa.jZ(true) <= 2) {
                ap.yY();
                if (!((Boolean) com.tencent.mm.u.c.vr().get(208912, Boolean.valueOf(false))).booleanValue()) {
                    obj = null;
                    amc = com.tencent.mm.plugin.emoji.model.h.amc();
                    if (com.tencent.mm.plugin.emoji.e.l.kLp == null) {
                        com.tencent.mm.plugin.emoji.e.l.kLp = new ArrayList();
                    }
                    if (com.tencent.mm.plugin.emoji.e.l.kLp.size() == 0 || com.tencent.mm.plugin.emoji.e.l.kLl) {
                        ap.yY();
                        if (com.tencent.mm.u.c.isSDCardAvailable()) {
                            com.tencent.mm.plugin.emoji.e.l.kLp = (ArrayList) amc.kLb.bNa();
                        } else {
                            com.tencent.mm.plugin.emoji.e.l.kLp = amc.kLb.bNi();
                        }
                    }
                    com.tencent.mm.plugin.emoji.e.l.kLl = false;
                    arrayList = com.tencent.mm.plugin.emoji.e.l.kLp;
                    i = com.tencent.mm.i.g.sV().getInt("EmotionRecommandCount", 3);
                    amc = com.tencent.mm.plugin.emoji.model.h.amc();
                    if (com.tencent.mm.plugin.emoji.e.l.gaH == -1 || com.tencent.mm.plugin.emoji.e.l.kLo) {
                        com.tencent.mm.plugin.emoji.e.l.gaH = amc.kLb.bNe();
                    }
                    i2 = i - com.tencent.mm.plugin.emoji.e.l.gaH;
                    w.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "recommend count :%d need recommend count:%d download count:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(com.tencent.mm.plugin.emoji.e.l.gaH)});
                    arrayList2 = new ArrayList();
                    if (!this.kTE.kVe) {
                        arrayList2.add(f.aoj());
                        a(f.aoj(), true);
                    }
                    if (!this.kTE.kVd) {
                        if (obj != null) {
                            arrayList2.add(f.aok());
                            a(f.aok(), true);
                        }
                        it = arrayList.iterator();
                        i3 = 0;
                        while (it.hasNext()) {
                            aVar = (com.tencent.mm.storage.a.a) it.next();
                            if (!(aVar == null || bg.mA(aVar.field_productID))) {
                                if (aVar.field_recommand != 1) {
                                    if (i3 < i2 && i3 < i) {
                                        i3++;
                                        a(aVar, f.a(aVar));
                                        arrayList2.add(aVar);
                                    }
                                } else if (!(aVar.field_productID.equalsIgnoreCase(String.valueOf(com.tencent.mm.storage.a.a.uKR)) || aVar.field_productID.equalsIgnoreCase("TAG_DEFAULT_TAB"))) {
                                    a(aVar, f.a(aVar));
                                    arrayList2.add(aVar);
                                }
                            }
                        }
                        if (obj == null) {
                            arrayList2.add(f.aok());
                            a(f.aok(), true);
                        }
                        if (!this.kTE.kVe) {
                            aVar = new com.tencent.mm.storage.a.a();
                            aVar.field_productID = "TAG_STORE_MANEGER_TAB";
                            arrayList2.add(aVar);
                        }
                    }
                    hVar = this.kTV;
                    hVar.mData.clear();
                    hVar.mData.addAll(arrayList2);
                    hVar.notifyDataSetChanged();
                    anZ();
                    this.kTE.aoo();
                    w.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "end initTabsGroup use time :%s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis2)});
                    w.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "- deal View");
                    if (this.kTR == null) {
                        w.w("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "initPanelVP failed");
                    } else if (this.kTS != null) {
                        anY();
                        this.kTS = new g(this.kTE, this.kLX);
                        this.kTE.aon();
                        this.kTR.a(this.kTS);
                        this.kTR.Cb(1);
                    } else {
                        this.kTS.kVC = true;
                        this.kTS.aos();
                        this.kTS.notifyDataSetChanged();
                        this.kTS.kVC = false;
                    }
                    anX();
                    this.kTE.kVh = true;
                    this.kTE.kVk = true;
                    if (!this.kTE.kVi) {
                        g.oUh.a(406, 6, 1, false);
                        g.oUh.a(406, 8, System.currentTimeMillis() - currentTimeMillis, false);
                    }
                }
            }
            obj = 1;
            amc = com.tencent.mm.plugin.emoji.model.h.amc();
            if (com.tencent.mm.plugin.emoji.e.l.kLp == null) {
                com.tencent.mm.plugin.emoji.e.l.kLp = new ArrayList();
            }
            ap.yY();
            if (com.tencent.mm.u.c.isSDCardAvailable()) {
                com.tencent.mm.plugin.emoji.e.l.kLp = (ArrayList) amc.kLb.bNa();
            } else {
                com.tencent.mm.plugin.emoji.e.l.kLp = amc.kLb.bNi();
            }
            com.tencent.mm.plugin.emoji.e.l.kLl = false;
            arrayList = com.tencent.mm.plugin.emoji.e.l.kLp;
            i = com.tencent.mm.i.g.sV().getInt("EmotionRecommandCount", 3);
            amc = com.tencent.mm.plugin.emoji.model.h.amc();
            com.tencent.mm.plugin.emoji.e.l.gaH = amc.kLb.bNe();
            i2 = i - com.tencent.mm.plugin.emoji.e.l.gaH;
            w.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "recommend count :%d need recommend count:%d download count:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(com.tencent.mm.plugin.emoji.e.l.gaH)});
            arrayList2 = new ArrayList();
            if (this.kTE.kVe) {
                arrayList2.add(f.aoj());
                a(f.aoj(), true);
            }
            if (this.kTE.kVd) {
                if (obj != null) {
                    arrayList2.add(f.aok());
                    a(f.aok(), true);
                }
                it = arrayList.iterator();
                i3 = 0;
                while (it.hasNext()) {
                    aVar = (com.tencent.mm.storage.a.a) it.next();
                    if (aVar.field_recommand != 1) {
                        a(aVar, f.a(aVar));
                        arrayList2.add(aVar);
                    } else {
                        i3++;
                        a(aVar, f.a(aVar));
                        arrayList2.add(aVar);
                    }
                }
                if (obj == null) {
                    arrayList2.add(f.aok());
                    a(f.aok(), true);
                }
                if (this.kTE.kVe) {
                    aVar = new com.tencent.mm.storage.a.a();
                    aVar.field_productID = "TAG_STORE_MANEGER_TAB";
                    arrayList2.add(aVar);
                }
            }
            hVar = this.kTV;
            hVar.mData.clear();
            hVar.mData.addAll(arrayList2);
            hVar.notifyDataSetChanged();
            anZ();
            this.kTE.aoo();
            w.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "end initTabsGroup use time :%s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis2)});
            w.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "- deal View");
            if (this.kTR == null) {
                w.w("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "initPanelVP failed");
            } else if (this.kTS != null) {
                this.kTS.kVC = true;
                this.kTS.aos();
                this.kTS.notifyDataSetChanged();
                this.kTS.kVC = false;
            } else {
                anY();
                this.kTS = new g(this.kTE, this.kLX);
                this.kTE.aon();
                this.kTR.a(this.kTS);
                this.kTR.Cb(1);
            }
            anX();
            this.kTE.kVh = true;
            this.kTE.kVk = true;
            if (this.kTE.kVi) {
                g.oUh.a(406, 6, 1, false);
                g.oUh.a(406, 8, System.currentTimeMillis() - currentTimeMillis, false);
            }
        }
    }

    final void anX() {
        d aon = this.kTE.aon();
        if (aon == null) {
            this.kTE.uI("TAG_DEFAULT_TAB");
            aon = this.kTE.aon();
        }
        aob();
        if (aon != null && this.kTR != null) {
            int i = this.kTE.kVc;
            if (i < 0 || i > aon.anV() - 1) {
                i = aon.anV() - 1;
            }
            this.kUd = aon.kTH + i;
            this.kTR.Y(this.kUd);
            if (!aon.kMS.equals("TAG_STORE_TAB")) {
                w.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "init set currentItem not default qq. ");
            }
            j(aon.anV(), i + 0, false);
        }
    }

    public final void j(int i, int i2, boolean z) {
        if (i <= 1) {
            this.kTT.setVisibility(4);
            return;
        }
        this.kTT.setVisibility(0);
        SmileyPanelScrollView smileyPanelScrollView = this.kTT;
        w.d("MicroMsg.SmileyPanelScrollView", "setDot dotCount:%d selectDot:%d force:%b", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)});
        smileyPanelScrollView.kUo = i;
        if (i2 < 0) {
            i2 = 0;
        } else if (i2 > smileyPanelScrollView.kUo) {
            i2 = smileyPanelScrollView.kUo;
        }
        smileyPanelScrollView.kUp = i2;
        if (smileyPanelScrollView.kUC == -1 || z) {
            smileyPanelScrollView.kUC = smileyPanelScrollView.kUp;
        }
        if (smileyPanelScrollView.kUB == -1 || z) {
            smileyPanelScrollView.kUB = smileyPanelScrollView.kUp;
            smileyPanelScrollView.kUD = 0.0f;
        }
        smileyPanelScrollView.invalidate();
    }

    public final void anY() {
        if (this.kTS != null) {
            w.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "clearViewPagerCache");
            this.kTS.mCount = 0;
        }
    }

    private void a(com.tencent.mm.storage.a.a aVar, boolean z) {
        int i = 0;
        f fVar = this.kTE;
        if (fVar.kVp == null) {
            fVar.kVp = new ArrayList();
        }
        int size = fVar.kVp.size();
        d dVar = size <= 0 ? null : (d) fVar.kVp.get(size - 1);
        int a = bg.a((Integer) fVar.kVq.get(aVar.field_productID), 0);
        if (dVar != null) {
            i = dVar.kTH + dVar.anV();
        }
        fVar.kVp.add(new d(aVar, i, a, fVar, this, z));
    }

    public final void anZ() {
        if (this.kTX != null) {
            if (!f.aof() || this.kTE.kVb.equalsIgnoreCase("TAG_STORE_TAB")) {
                this.kTY.setVisibility(8);
            } else {
                this.kTY.setVisibility(0);
            }
            this.kTX.setContentDescription(this.ty.getString(R.l.eeq));
        }
    }

    private ImageButton aoa() {
        if (this.kTZ == null) {
            this.kTZ = new ImageButton(this.kLX, null, R.m.foy);
            this.kTZ.setMaxHeight(this.kTE.kUK);
            this.kTZ.setMinimumHeight(this.kTE.kUK);
            this.kTZ.setMaxWidth(this.kTE.kUJ);
            this.kTZ.setMinimumWidth(this.kTE.kUJ);
            this.kTZ.setScaleType(ScaleType.CENTER);
            this.kTZ.setPadding(this.kTE.kUM, this.kTE.kUM, this.kTE.kUM, this.kTE.kUM);
            this.kTZ.setClickable(false);
            this.kTZ.setVisibility(8);
        }
        return this.kTZ;
    }

    public final void onClick(View view) {
        if (view == this.kTX) {
            Intent intent = new Intent();
            intent.putExtra("preceding_scence", 13);
            intent.putExtra("download_entrance_scene", 17);
            intent.putExtra("check_clickflag", false);
            if (f.aoe()) {
                w.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "called emoji store must refresh by net");
                intent.putExtra("emoji_stroe_must_refresh_by_net", true);
            }
            if (!bg.mA(this.kTE.kVa)) {
                intent.putExtra("to_talker_name", this.kTE.kVa);
            }
            d.b(this.ty, "emoji", ".ui.v2.EmojiStoreV2UI", intent);
            g.oUh.i(11594, new Object[]{Integer.valueOf(2)});
        } else if (view == this.kUb) {
            if (this.kUc != null && this.kUc.anQ() != null) {
                this.kUc.anQ().aIN();
            }
        } else if (view == this.kUa && this.kUc.anR() != null) {
            this.kUc.anR().aJU();
        }
    }

    final View findViewById(int i) {
        return this.mView.findViewById(i);
    }

    public final void dB(boolean z) {
        aoa().setVisibility(8);
        if (this.kUb != null && this.kUb.getVisibility() == 0) {
            if (z) {
                Animation translateAnimation = new TranslateAnimation(0.0f, (float) this.kUb.getWidth(), 0.0f, 0.0f);
                translateAnimation.setDuration(250);
                this.kUb.startAnimation(translateAnimation);
            }
            this.kUb.setVisibility(8);
        }
    }

    public final void lx(int i) {
        int i2 = this.kTR.ys;
        int i3 = this.kTE.lC(i2).kTH + i;
        if (!(this.kTR == null || i3 == i2)) {
            Math.abs(i3 - i2);
            this.kTR.Y(i3);
        }
        this.kUd = i3;
    }

    public final void W(int i) {
        if (this.kTT != null) {
            SmileyPanelScrollView smileyPanelScrollView = this.kTT;
            if (i == 0) {
                smileyPanelScrollView.kUC = smileyPanelScrollView.kUp;
                smileyPanelScrollView.kUB = smileyPanelScrollView.kUp;
                smileyPanelScrollView.kUD = 0.0f;
                smileyPanelScrollView.invalidate();
                if (smileyPanelScrollView.kUE) {
                    smileyPanelScrollView.kUE = false;
                }
            } else if (i == 1) {
                smileyPanelScrollView.kUC = smileyPanelScrollView.kUp;
                smileyPanelScrollView.kUB = smileyPanelScrollView.kUp;
                smileyPanelScrollView.kUD = 0.0f;
            }
        }
        if (i == 0 || i == 1) {
            this.kUd = this.kTR.ys;
        }
    }

    public final void a(int i, float f, int i2) {
        if (this.kTT != null && f != 0.0f) {
            if (this.kUd == -1) {
                this.kUd = this.kTR.ys;
            }
            int i3 = this.kUd;
            if (i == this.kUd) {
                i3 = this.kUd + 1;
            }
            d lC = this.kTE.lC(i3);
            d lC2 = this.kTE.lC(i);
            if (lC == lC2) {
                SmileyPanelScrollView smileyPanelScrollView = this.kTT;
                int i4 = i - lC2.kTH;
                smileyPanelScrollView.kUD = f;
                if (smileyPanelScrollView.kUC != i4) {
                    smileyPanelScrollView.kUC = i4;
                }
                smileyPanelScrollView.invalidate();
                this.kUe = true;
                return;
            }
            this.kUe = false;
        }
    }

    public final void c(int i, boolean z, boolean z2) {
        int i2 = 1;
        if (this.kTU != null) {
            w.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "tab index:%d selected:%b listView child count:%d", new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(this.kTU.getChildCount())});
            this.kTU.setSelection(i);
            View selectedView = this.kTU.getSelectedView();
            if (selectedView != null) {
                selectedView.setSelected(z);
                return;
            }
            w.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "list item view is null. refreshable:%b", new Object[]{Boolean.valueOf(z2)});
            if (z2) {
                Message message = new Message();
                message.what = 1103;
                message.arg1 = i;
                if (!z) {
                    i2 = 0;
                }
                message.arg2 = i2;
                this.mHandler.sendMessageDelayed(message, 100);
            }
        }
    }

    public final void V(int i) {
        w.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "cpan onPageSelected :%d", new Object[]{Integer.valueOf(i)});
        if (this.kTE != null && this.kTE.kVs) {
            boolean z;
            d lC = this.kTE.lC(i);
            if (lC.kMS.equals("TAG_STORE_TAB")) {
                this.kTX.setSelected(true);
                w.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "show TAB: viewId: %d, tabProductId: %s", new Object[]{Integer.valueOf(this.kTX.getId()), "TAG_STORE_TAB"});
                this.kTE.uI("TAG_STORE_TAB");
                g.oUh.i(11594, new Object[]{Integer.valueOf(5)});
                com.tencent.mm.q.c.uk().aE(262147, 266244);
                com.tencent.mm.q.c.uk().aE(262149, 266244);
                anZ();
            } else {
                this.kTX.setSelected(false);
            }
            int i2 = i - lC.kTH;
            int anV = lC.anV();
            int i3 = i - lC.kTH;
            if (this.kUe) {
                z = false;
            } else {
                z = true;
            }
            j(anV, i3, z);
            this.kTE.kVc = i2;
            this.kTE.uI(lC.kMS);
            lC.kTM = i2;
            f fVar = this.kTE;
            fVar.kVq.put(lC.kMS, Integer.valueOf(lC.kTM));
            ly(this.kTE.lD(i));
            c(this.kTE.lD(i) - 1, false, true);
            c(this.kTE.lD(i) + 1, false, true);
        }
    }

    private void ly(int i) {
        int i2 = this.kTE.kUJ;
        int width = this.kTU.getWidth();
        int firstVisiblePosition = this.kTU.getFirstVisiblePosition();
        if (i > this.kTU.getLastVisiblePosition()) {
            this.kTU.zO((i2 * (i + 1)) - width);
        } else if (i < firstVisiblePosition) {
            this.kTU.zO(i2 * i);
        }
        c(i, true, true);
    }

    public final void aob() {
        if (this.kTE.kVi) {
            if (this.kTE.kVb.equals("TAG_DEFAULT_TAB")) {
                if (!(this.kUc == null || this.kUc.anQ() == null)) {
                    this.kUc.anQ().fz(true);
                }
                if (this.kTE.aol()) {
                    this.kTE.kVj = false;
                    aoa().setVisibility(0);
                    if (this.kUb != null && this.kUb.getVisibility() != 0) {
                        Animation translateAnimation = new TranslateAnimation((float) this.kUb.getWidth(), 0.0f, 0.0f, 0.0f);
                        translateAnimation.setDuration(250);
                        this.kUb.startAnimation(translateAnimation);
                        this.kUb.setVisibility(0);
                        return;
                    }
                    return;
                }
                return;
            }
            if (!(this.kUc == null || this.kUc.anQ() == null)) {
                this.kUc.anQ().fz(false);
            }
            dB(true);
        }
    }

    public final synchronized void lz(int i) {
        f fVar;
        if (this.kTE.aop()) {
            if (!this.kTE.kVn) {
                fVar = this.kTE;
                fVar.kVn = true;
                fVar.kVo = false;
            }
        } else if (!this.kTE.kVo) {
            fVar = this.kTE;
            fVar.kVo = true;
            fVar.kVn = false;
        }
        w.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "catch Size & start deal");
        if (i > 0) {
            this.mView.post(new Runnable(this) {
                final /* synthetic */ e kUj;

                {
                    this.kUj = r1;
                }

                public final void run() {
                    w.v("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "onLayoutChange handle");
                    this.kUj.anW();
                }
            });
        }
    }

    public final void lA(int i) {
        if (i > 0) {
            w.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "tab size changed ,so adjusting tab site.");
            ly(this.kTE.aom());
        }
    }

    public final void aoc() {
        this.kUf = false;
        this.mHandler.removeMessages(1102);
        this.mHandler.sendEmptyMessageDelayed(1102, 100);
    }
}
