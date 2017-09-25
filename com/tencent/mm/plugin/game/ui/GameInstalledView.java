package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ah.n;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiSetBackgroundAudioState;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.game.model.SubCoreGameCenter;
import com.tencent.mm.plugin.game.model.ai;
import com.tencent.mm.plugin.game.model.c;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.plugin.game.model.l;
import com.tencent.mm.plugin.game.model.l.b;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class GameInstalledView extends LinearLayout implements OnClickListener {
    private static Map<String, Integer> mBB = new HashMap();
    private static int mBD = 6;
    private static int mBE = 7;
    private int count = 0;
    private int kTq = 4;
    private TextView mBA;
    private final DisplayMetrics mBC = new DisplayMetrics();
    private int mBF = 1;
    private int mBG = 999;
    a mBH;
    LinkedList<c> mBI;
    LayoutParams mBJ = new LayoutParams(-1, -2);
    private LinearLayout mBy;
    private ImageView mBz;
    private Context mContext;
    int mqT = 0;
    LinkedList<f> mrk = new LinkedList();
    private TextView mwg;
    b mzx = new b(this) {
        final /* synthetic */ GameInstalledView mBK;

        {
            this.mBK = r1;
        }

        public final void g(int i, String str, boolean z) {
            switch (i) {
                case 3:
                    SubCoreGameCenter.aBH().init(this.mBK.mContext);
                    this.mBK.dK(false);
                    return;
                default:
                    return;
            }
        }
    };

    public static class a {
        public String iMP = "";
        public String iconUrl = "";
        public String title = "";
    }

    static /* synthetic */ int b(GameInstalledView gameInstalledView) {
        int i = gameInstalledView.count + 1;
        gameInstalledView.count = i;
        return i;
    }

    public GameInstalledView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mBy = (LinearLayout) findViewById(R.h.bUg);
        l.a(this.mzx);
    }

    public final void dK(boolean z) {
        if (bg.bV(this.mBI)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        Iterator it;
        if (z) {
            this.mrk = e.aAB();
            if (!(bg.bV(this.mBI) || bg.bV(this.mrk))) {
                it = this.mBI.iterator();
                while (it.hasNext()) {
                    c cVar = (c) it.next();
                    if (this.mrk.contains(cVar)) {
                        this.mrk.remove(cVar);
                        this.mrk.addFirst(cVar);
                    }
                }
            }
        } else {
            f fVar;
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(this.mrk);
            LinkedList linkedList2 = new LinkedList();
            linkedList2.addAll(e.aAB());
            Collection linkedList3 = new LinkedList();
            Iterator it2 = linkedList.iterator();
            while (it2.hasNext()) {
                fVar = (f) it2.next();
                if (!(linkedList2.contains(fVar) || linkedList3.contains(fVar))) {
                    linkedList3.add(fVar);
                }
            }
            it2 = linkedList.iterator();
            while (it2.hasNext()) {
                fVar = (f) it2.next();
                if (linkedList2.contains(fVar)) {
                    linkedList2.remove(fVar);
                } else if (!g.a(this.mContext, fVar)) {
                    linkedList3.add(fVar);
                }
            }
            if (linkedList2.size() > 0) {
                Iterator it3 = linkedList2.iterator();
                while (it3.hasNext()) {
                    fVar = (f) it3.next();
                    if (!linkedList.contains(fVar)) {
                        linkedList.addFirst(fVar);
                    }
                }
            }
            if (linkedList3.size() > 0) {
                linkedList.removeAll(linkedList3);
            }
            linkedList2 = new LinkedList();
            it = linkedList.iterator();
            while (it.hasNext()) {
                linkedList2.add(g.aJ(((f) it.next()).field_appId, true));
            }
            this.mrk = linkedList2;
        }
        aBT();
    }

    private void aBT() {
        if (bg.bV(this.mrk)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.mBy.removeAllViews();
        this.count = 0;
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService("layout_inflater");
        if (this.mrk.size() >= this.kTq - 1) {
            mBE = 7;
            mBD = 6;
            int a = BackwardSupportUtil.b.a(this.mContext, (float) ((mBD << 1) + 84));
            ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getMetrics(this.mBC);
            int i = (int) (((float) (this.mBC.widthPixels * JsApiSetBackgroundAudioState.CTRL_INDEX)) / ((float) this.mBC.densityDpi));
            this.kTq = ((this.mBC.widthPixels - 1) / a) + 1;
            if (this.kTq == 3) {
                mBE = 3;
            }
            a = (mBD << 1) + 84;
            int i2 = (mBD + 6) + mBE;
            i = (i - 16) % a;
            if (i < i2) {
                mBD -= 2;
                BackwardSupportUtil.b.a(this.mContext, (float) ((mBD << 1) + 84));
            } else if (i > a - i2) {
                mBD = ((i - (a >> 1)) / this.kTq) + mBD;
                BackwardSupportUtil.b.a(this.mContext, (float) ((mBD << 1) + 84));
            }
        }
        this.mBJ.setMargins(BackwardSupportUtil.b.a(this.mContext, (float) mBD), 0, BackwardSupportUtil.b.a(this.mContext, (float) mBD), 0);
        Iterator it = this.mrk.iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            View inflate = layoutInflater.inflate(R.i.dfM, null);
            this.mBz = (ImageView) inflate.findViewById(R.h.bUc);
            this.mwg = (TextView) inflate.findViewById(R.h.bUJ);
            this.mBA = (TextView) inflate.findViewById(R.h.bUV);
            Bitmap b = g.b(fVar.field_appId, 1, com.tencent.mm.bg.a.getDensity(this.mContext));
            if (b != null) {
                this.mBz.setImageBitmap(b);
            } else {
                this.mBz.setImageResource(R.g.bcg);
            }
            this.mwg.setText(g.a(this.mContext, fVar, null));
            if (g.a(this.mContext, fVar)) {
                int yc = com.tencent.mm.plugin.game.d.c.yc(fVar.field_packageName);
                if (mBB.containsKey(fVar.field_appId) && ((Integer) mBB.get(fVar.field_appId)).intValue() > yc) {
                    FileDownloadTaskInfo tI = com.tencent.mm.plugin.downloader.model.e.akM().tI(fVar.field_appId);
                    this.mBA.setTextColor(this.mContext.getResources().getColor(R.e.aTV));
                    if (tI.status == 1) {
                        this.mBA.setText(R.l.eoq);
                    } else {
                        this.mBA.setText(R.l.eop);
                    }
                } else if (bg.mA(fVar.gfg)) {
                    this.mBA.setText("");
                } else {
                    this.mBA.setText(fVar.gfg);
                    this.mBA.setTextColor(this.mContext.getResources().getColor(R.e.aTY));
                }
            } else {
                this.mBA.setTextColor(this.mContext.getResources().getColor(R.e.aTV));
                this.mBA.setText(R.l.eoQ);
            }
            inflate.setTag(fVar);
            inflate.setOnClickListener(this);
            this.mBy.addView(inflate, this.mBJ);
        }
        if (this.mBH != null && this.mBH.iconUrl != null && this.mBH.title != null) {
            final View inflate2 = layoutInflater.inflate(R.i.dfM, null);
            this.mBz = (ImageView) inflate2.findViewById(R.h.bUc);
            this.mwg = (TextView) inflate2.findViewById(R.h.bUJ);
            this.mBA = (TextView) inflate2.findViewById(R.h.bUV);
            com.tencent.mm.ah.a.a GW = n.GW();
            String str = this.mBH.iconUrl;
            ImageView imageView = this.mBz;
            com.tencent.mm.ah.a.a.c.a aVar = new com.tencent.mm.ah.a.a.c.a();
            aVar.hIK = true;
            GW.a(str, imageView, aVar.Hg(), new com.tencent.mm.ah.a.c.g(this) {
                final /* synthetic */ GameInstalledView mBK;

                public final void jK(String str) {
                }

                public final void a(String str, View view, com.tencent.mm.ah.a.d.b bVar) {
                    if (bVar.status == 0) {
                        af.v(new Runnable(this) {
                            final /* synthetic */ AnonymousClass1 mBL;

                            {
                                this.mBL = r1;
                            }

                            public final void run() {
                                if (this.mBL.mBK.count == 0) {
                                    GameInstalledView.b(this.mBL.mBK);
                                    this.mBL.mBK.mBy.addView(inflate2, this.mBL.mBK.mBJ);
                                }
                            }
                        });
                    }
                }
            });
            this.mwg.setText(this.mBH.title);
            this.mBA.setVisibility(8);
            inflate2.setTag(this.mBH);
            inflate2.setOnClickListener(this);
        }
    }

    public static void v(Map<String, Integer> map) {
        if (map != null && !map.isEmpty()) {
            mBB = map;
        }
    }

    public void onClick(View view) {
        if (view.getTag() != null) {
            if (view.getTag() instanceof f) {
                f fVar = (f) view.getTag();
                if (fVar == null || bg.mA(fVar.field_appId)) {
                    w.e("MicroMsg.GameInstalledView", "appinfo is null or appid is null");
                } else if (g.a(this.mContext, fVar)) {
                    int yc = com.tencent.mm.plugin.game.d.c.yc(fVar.field_packageName);
                    if (!mBB.containsKey(fVar.field_appId) || ((Integer) mBB.get(fVar.field_appId)).intValue() <= yc) {
                        e.V(this.mContext, fVar.field_appId);
                        ai.a(this.mContext, 10, MMBitmapFactory.ERROR_LOCK_BITMAP_FAILED, this.mBF, 3, 0, fVar.field_appId, this.mqT, 0, null, null, null);
                        this.mrk.remove(fVar);
                        this.mrk.addFirst(fVar);
                    } else {
                        r0 = com.tencent.mm.plugin.downloader.model.e.akM().tI(fVar.field_appId);
                        if (r0.status == 1) {
                            com.tencent.mm.plugin.downloader.model.e.akM().aT(r0.id);
                        } else {
                            if (r0.status == 3) {
                                if (!com.tencent.mm.a.e.aO(r0.path) || com.tencent.mm.plugin.game.d.c.yd(r0.path) <= yc) {
                                    com.tencent.mm.plugin.downloader.model.e.akM().aT(r0.id);
                                } else {
                                    q.e(this.mContext, Uri.fromFile(new File(r0.path)));
                                }
                            }
                            l.a(fVar.gfc, fVar.gfh, MMBitmapFactory.ERROR_LOCK_BITMAP_FAILED, fVar.field_appId, "");
                            com.tencent.mm.plugin.downloader.model.f.a aVar = new com.tencent.mm.plugin.downloader.model.f.a();
                            aVar.tL(fVar.gfc);
                            aVar.tN(g.a(this.mContext, fVar, null));
                            aVar.setAppId(fVar.field_appId);
                            aVar.tO(fVar.gfh);
                            aVar.dn(true);
                            aVar.la(1);
                            com.tencent.mm.plugin.downloader.model.e.akM().a(aVar.kHa);
                        }
                    }
                    dK(false);
                } else {
                    r0 = com.tencent.mm.plugin.downloader.model.e.akM().tI(fVar.field_appId);
                    if (r0 == null || r0.status != 3) {
                        w.i("MicroMsg.GameInstalledView", "app not installed or download sucess : [%s]", new Object[]{fVar.field_appName});
                        dK(false);
                    } else if (bg.mA(r0.path) || !com.tencent.mm.a.e.aO(r0.path)) {
                        w.e("MicroMsg.GameInstalledView", "file status is success, while the download file not exsit:[%s]", new Object[]{r0.path});
                        com.tencent.mm.plugin.downloader.model.e.akM().aT(r0.id);
                        dK(false);
                    } else {
                        q.e(this.mContext, Uri.fromFile(new File(r0.path)));
                    }
                }
            } else if (view.getTag() instanceof a) {
                a aVar2 = (a) view.getTag();
                Intent intent = new Intent();
                int i = 6;
                if (bg.mA(aVar2.iMP)) {
                    intent.setClass(this.mContext, GameLibraryUI.class);
                    intent.putExtra("game_report_from_scene", MMBitmapFactory.ERROR_LOCK_BITMAP_FAILED);
                    this.mContext.startActivity(intent);
                } else {
                    i = 7;
                    com.tencent.mm.plugin.game.d.c.n(this.mContext, aVar2.iMP, "game_center_installed_more");
                }
                ai.a(this.mContext, 10, MMBitmapFactory.ERROR_LOCK_BITMAP_FAILED, this.mBG, i, 0, null, this.mqT, 0, null, null, null);
            }
        }
    }
}
