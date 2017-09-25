package com.tencent.mm.plugin.favorite.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.e.a.bx;
import com.tencent.mm.e.a.lw;
import com.tencent.mm.e.a.ly;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.favorite.b.j;
import com.tencent.mm.plugin.favorite.b.q;
import com.tencent.mm.plugin.favorite.b.r;
import com.tencent.mm.plugin.favorite.b.x;
import com.tencent.mm.plugin.favorite.c;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.plugin.favorite.ui.base.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.rm;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.MMGestureGallery.f;
import com.tencent.mm.ui.tools.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@com.tencent.mm.ui.base.a(3)
public class FavImgGalleryUI extends MMActivity implements OnItemSelectedListener, com.tencent.mm.plugin.favorite.b.b.a {
    private boolean fQy = true;
    private l iYI;
    private ArrayList<d> jjQ;
    private n.d kTc = new n.d(this) {
        final /* synthetic */ FavImgGalleryUI lHm;

        {
            this.lHm = r1;
        }

        public final void c(MenuItem menuItem, int i) {
            d mw = this.lHm.lHj.mw(this.lHm.lHi);
            if (mw != null) {
                String g = x.g(mw.fKe);
                if (e.aO(g)) {
                    switch (menuItem.getItemId()) {
                        case 0:
                            g.oUh.i(10651, new Object[]{Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(0)});
                            if (o.Pj(g)) {
                                Intent intent = new Intent();
                                intent.putExtra("Select_Conv_Type", 3);
                                intent.putExtra("select_is_ret", true);
                                com.tencent.mm.bb.d.a(this.lHm, ".ui.transmit.SelectConversationUI", intent, 1);
                                return;
                            }
                            c.d(g, this.lHm);
                            return;
                        case 1:
                            c.c(g, this.lHm);
                            g.oUh.i(10651, new Object[]{Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0)});
                            return;
                        case 2:
                            c.a(g, this.lHm.getString(R.l.ejm), this.lHm);
                            return;
                        case 3:
                            ly lyVar = (ly) this.lHm.lHk.get(g);
                            if (lyVar != null) {
                                com.tencent.mm.sdk.b.b bxVar = new bx();
                                bxVar.fFn.activity = this.lHm;
                                bxVar.fFn.fDK = lyVar.fTe.result;
                                bxVar.fFn.fFo = lyVar.fTe.fFo;
                                bxVar.fFn.fFq = 7;
                                if (!(mw == null || mw.fKe == null)) {
                                    bxVar.fFn.imagePath = mw.fKe.txi;
                                    bxVar.fFn.fFt = mw.fKe.txk;
                                }
                                bxVar.fFn.fFp = lyVar.fTe.fFp;
                                Bundle bundle = new Bundle(1);
                                bundle.putInt("stat_scene", 5);
                                bxVar.fFn.fFu = bundle;
                                com.tencent.mm.sdk.b.a.urY.m(bxVar);
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                }
                w.w("MicroMsg.FavImgGalleryUI", "file not exists");
            }
        }
    };
    private MMGestureGallery klE;
    private int lHi = 0;
    private a lHj;
    private Map<String, ly> lHk = new HashMap();
    private com.tencent.mm.sdk.b.c lHl = new com.tencent.mm.sdk.b.c<ly>(this) {
        final /* synthetic */ FavImgGalleryUI lHm;

        {
            this.lHm = r2;
            this.usg = ly.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            ly lyVar = (ly) bVar;
            this.lHm.lHk.put(lyVar.fTe.filePath, lyVar);
            if (this.lHm.iYI != null && this.lHm.iYI.qJe.isShowing()) {
                FavImgGalleryUI.a(this.lHm);
            }
            return true;
        }
    };

    private class a extends BaseAdapter {
        final /* synthetic */ FavImgGalleryUI lHm;
        SparseBooleanArray lHp;

        private a(FavImgGalleryUI favImgGalleryUI) {
            this.lHm = favImgGalleryUI;
            this.lHp = new SparseBooleanArray();
        }

        public final /* synthetic */ Object getItem(int i) {
            return mw(i);
        }

        public final int getCount() {
            return this.lHm.jjQ.size();
        }

        public final d mw(int i) {
            if (i < this.lHm.jjQ.size()) {
                return (d) this.lHm.jjQ.get(i);
            }
            w.w("MicroMsg.FavImgGalleryUI", "get item fail, position %d error", new Object[]{Integer.valueOf(i)});
            return null;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                b bVar2 = new b(this.lHm);
                view = View.inflate(this.lHm.uSU.uTo, R.i.dcl, null);
                bVar2.lHq = view.findViewById(R.h.bWO);
                bVar2.lHr = (MultiTouchImageView) view.findViewById(R.h.Kd);
                bVar2.jKM = (ProgressBar) view.findViewById(R.h.bKx);
                bVar2.lHs = (ImageView) view.findViewById(R.h.cId);
                bVar2.lHt = (TextView) view.findViewById(R.h.bKy);
                bVar2.lHu = (LinearLayout) view.findViewById(R.h.bOt);
                bVar2.lHv = (TextView) view.findViewById(R.h.bOu);
                bVar2.lHv.setText(R.l.ehH);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            view.setLayoutParams(new LayoutParams(-1, -1));
            d mw = mw(i);
            boolean z = this.lHp.get(i, true);
            this.lHp.put(i, false);
            Bitmap a = com.tencent.mm.plugin.favorite.c.g.a(mw.fKe, mw.lJS, z);
            if (mw.lJS != null) {
                w.i("MicroMsg.FavImgGalleryUI", "index %d item favid %d, localid %d, itemStatus %d", new Object[]{Integer.valueOf(i), Integer.valueOf(mw.lJS.field_id), Long.valueOf(mw.lJS.field_localId), Integer.valueOf(mw.lJS.field_itemStatus)});
            }
            if (mw.fKe != null) {
                w.i("MicroMsg.FavImgGalleryUI", "item dataId %s, item data url %s, key %s, fullsize %d, thumb url %s, key %s, thumb size %d", new Object[]{mw.fKe.lKv, mw.fKe.txi, mw.fKe.txk, Long.valueOf(mw.fKe.txD), mw.fKe.hhy, mw.fKe.txe, Long.valueOf(mw.fKe.txO)});
            }
            if (a == null) {
                this.lHm.kr(false);
                w.w("MicroMsg.FavImgGalleryUI", "get big image fail");
                com.tencent.mm.plugin.favorite.b.a vN = h.asV().vN(mw.fKe != null ? mw.fKe.lKv : "");
                if (vN == null) {
                    bVar.lHu.setVisibility(8);
                    if (mw.lJS == null || mw.lJS.field_id >= 0) {
                        bVar.jKM.setVisibility(8);
                        bVar.lHt.setVisibility(8);
                        bVar.lHs.setVisibility(8);
                        bVar.lHq.setVisibility(0);
                        if (mw.fKe.tyq != 0) {
                            bVar.lHu.setVisibility(0);
                        }
                        b(bVar, a(mw), "");
                    } else {
                        bVar.jKM.setVisibility(0);
                        bVar.lHt.setVisibility(0);
                        bVar.lHs.setVisibility(0);
                        bVar.lHq.setVisibility(8);
                        bVar.lHs.setImageBitmap(a(mw));
                        bVar.jKM.setProgress(0);
                        bVar.lHt.setText(this.lHm.getString(R.l.elF, new Object[]{Integer.valueOf(0)}));
                    }
                } else {
                    w.i("MicroMsg.FavImgGalleryUI", "fav cdnInfo status %d", new Object[]{Integer.valueOf(vN.field_status)});
                    bVar.jKM.setVisibility(0);
                    bVar.lHt.setVisibility(0);
                    bVar.lHs.setVisibility(0);
                    bVar.lHq.setVisibility(8);
                    bVar.lHs.setImageBitmap(a(mw));
                    int i2 = vN.field_totalLen > 0 ? ((vN.field_offset * 100) / vN.field_totalLen) - 1 : 0;
                    if (i2 < 0) {
                        i2 = 0;
                    }
                    bVar.jKM.setProgress(i2);
                    bVar.lHt.setText(this.lHm.getString(R.l.elF, new Object[]{Integer.valueOf(i2)}));
                }
            } else {
                this.lHm.kr(true);
                if (o.Pj(x.g(mw.fKe))) {
                    a(bVar, a, x.g(mw.fKe));
                } else {
                    a(bVar, a, "");
                }
            }
            return view;
        }

        private void a(b bVar, Bitmap bitmap, String str) {
            bVar.jKM.setVisibility(8);
            bVar.lHt.setVisibility(8);
            bVar.lHs.setVisibility(8);
            bVar.lHq.setVisibility(0);
            bVar.lHu.setVisibility(8);
            b(bVar, bitmap, str);
        }

        private Bitmap a(d dVar) {
            if (dVar != null) {
                Bitmap a = com.tencent.mm.plugin.favorite.c.g.a(dVar.fKe, dVar.lJS);
                if (a != null) {
                    return a;
                }
            }
            return com.tencent.mm.compatible.f.a.decodeResource(this.lHm.getResources(), R.k.dwC);
        }

        private void b(b bVar, Bitmap bitmap, String str) {
            k.i(bVar.lHr, bitmap.getWidth(), bitmap.getHeight());
            int width = bVar.lHr.getWidth();
            int height = bVar.lHr.getHeight();
            Matrix matrix = new Matrix();
            matrix.reset();
            float width2 = ((float) bitmap.getWidth()) / ((float) bitmap.getHeight());
            float height2 = ((float) bitmap.getHeight()) / ((float) bitmap.getWidth());
            w.v("MicroMsg.FavImgGalleryUI", "whDiv is " + width2 + " hwDiv is " + height2);
            if (height2 >= 2.0f && bitmap.getHeight() >= 480) {
                height2 = ((float) width) / ((float) bitmap.getWidth());
                if (((double) (((float) bitmap.getWidth()) / ((float) width))) > 1.0d) {
                    matrix.postScale(height2, height2);
                    bitmap.getHeight();
                    matrix.postTranslate((((float) width) - (height2 * ((float) bitmap.getWidth()))) / 2.0f, 0.0f);
                } else {
                    matrix.postScale(1.0f, 1.0f);
                    matrix.postTranslate((float) ((width - bitmap.getWidth()) / 2), 0.0f);
                }
            } else if (width2 < 2.0f || bitmap.getWidth() < 480) {
                width2 = ((float) width) / ((float) bitmap.getWidth());
                height2 = ((float) height) / ((float) bitmap.getHeight());
                if (width2 >= height2) {
                    width2 = height2;
                }
                height2 = ((float) bitmap.getWidth()) / ((float) width);
                float height3 = ((float) bitmap.getHeight()) / ((float) height);
                if (height2 <= height3) {
                    height2 = height3;
                }
                if (((double) height2) > 1.0d) {
                    matrix.postScale(width2, width2);
                } else {
                    width2 = 1.0f;
                }
                matrix.postTranslate((((float) width) - (((float) bitmap.getWidth()) * width2)) / 2.0f, (((float) height) - (width2 * ((float) bitmap.getHeight()))) / 2.0f);
            } else {
                width2 = ((float) bitmap.getHeight()) / 480.0f;
                height2 = 480.0f / ((float) bitmap.getHeight());
                if (((double) width2) > 1.0d) {
                    matrix.postScale(width2, height2);
                    matrix.postTranslate(0.0f, (float) ((height - 480) / 2));
                } else {
                    matrix.postScale(1.0f, 1.0f);
                    width2 = (float) ((height - bitmap.getHeight()) / 2);
                    w.d("MicroMsg.FavImgGalleryUI", " offsety " + width2);
                    matrix.postTranslate(0.0f, width2);
                }
            }
            bVar.lHr.setImageMatrix(matrix);
            bVar.lHr.dZ(bitmap.getWidth(), bitmap.getHeight());
            bVar.lHr.vol = true;
            if (bg.mA(str)) {
                bVar.lHr.setImageBitmap(bitmap);
                return;
            }
            try {
                Drawable aVar = new com.tencent.mm.plugin.gif.a(str);
                MultiTouchImageView multiTouchImageView = bVar.lHr;
                multiTouchImageView.vos = true;
                multiTouchImageView.vot = aVar;
                multiTouchImageView.setImageDrawable(multiTouchImageView.vot);
                multiTouchImageView = bVar.lHr;
                int dO = com.tencent.mm.bg.a.dO(this.lHm.uSU.uTo);
                multiTouchImageView.lon = com.tencent.mm.bg.a.dP(this.lHm.uSU.uTo);
                multiTouchImageView.lom = dO;
                bVar.lHr.dZ(aVar.getIntrinsicWidth(), aVar.getIntrinsicHeight());
                MultiTouchImageView multiTouchImageView2 = bVar.lHr;
                if (multiTouchImageView2.vos && multiTouchImageView2.vot != null) {
                    ((com.tencent.mm.ui.f.b.b) multiTouchImageView2.vot).start();
                }
                bVar.lHr.bSM();
            } catch (Throwable e) {
                w.e("MicroMsg.FavImgGalleryUI", bg.g(e));
                bVar.lHr.setImageBitmap(bitmap);
            }
        }
    }

    private class b {
        ProgressBar jKM;
        final /* synthetic */ FavImgGalleryUI lHm;
        View lHq;
        MultiTouchImageView lHr;
        ImageView lHs;
        TextView lHt;
        LinearLayout lHu;
        TextView lHv;

        public b(FavImgGalleryUI favImgGalleryUI) {
            this.lHm = favImgGalleryUI;
        }
    }

    static /* synthetic */ void a(FavImgGalleryUI favImgGalleryUI) {
        final List arrayList = new ArrayList();
        final List arrayList2 = new ArrayList();
        d mw = favImgGalleryUI.lHj.mw(favImgGalleryUI.lHi);
        if (mw.fKe.tyq == 0) {
            if (mw.lJS != null && mw.lJS.atg()) {
                arrayList.add(Integer.valueOf(0));
                arrayList2.add(favImgGalleryUI.getString(R.l.ejs));
            }
            if (mw.lJS != null && mw.lJS.ath()) {
                arrayList.add(Integer.valueOf(1));
                arrayList2.add(favImgGalleryUI.getString(R.l.eiU));
            }
            arrayList.add(Integer.valueOf(2));
            arrayList2.add(favImgGalleryUI.getString(R.l.ejn));
            String g = x.g(mw.fKe);
            ly lyVar = (ly) favImgGalleryUI.lHk.get(g);
            if (lyVar == null) {
                com.tencent.mm.sdk.b.b lwVar = new lw();
                lwVar.fTb.filePath = g;
                com.tencent.mm.sdk.b.a.urY.m(lwVar);
            } else if (!bg.mA(lyVar.fTe.result)) {
                arrayList.add(Integer.valueOf(3));
                arrayList2.add(favImgGalleryUI.getString(com.tencent.mm.plugin.scanner.a.ak(lyVar.fTe.fFo, lyVar.fTe.result) ? R.l.eja : R.l.eiZ));
            }
            if (favImgGalleryUI.iYI == null) {
                favImgGalleryUI.iYI = new l(favImgGalleryUI.uSU.uTo);
            }
            favImgGalleryUI.iYI.qJf = new n.c(favImgGalleryUI) {
                final /* synthetic */ FavImgGalleryUI lHm;

                public final void a(com.tencent.mm.ui.base.l lVar) {
                    lVar.setHeaderTitle("");
                    for (int i = 0; i < arrayList.size(); i++) {
                        lVar.e(((Integer) arrayList.get(i)).intValue(), (CharSequence) arrayList2.get(i));
                    }
                }
            };
            favImgGalleryUI.iYI.qJg = favImgGalleryUI.kTc;
            favImgGalleryUI.iYI.e(new OnCancelListener(favImgGalleryUI) {
                final /* synthetic */ FavImgGalleryUI lHm;

                {
                    this.lHm = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    this.lHm.iYI = null;
                }
            });
            com.tencent.mm.ui.base.g.a(favImgGalleryUI.uSU.uTo, favImgGalleryUI.iYI.blb());
        }
    }

    protected final int getLayoutId() {
        return R.i.dcm;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (VERSION.SDK_INT >= 21) {
            getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        }
        this.fQy = getIntent().getBooleanExtra("show_share", true);
        this.klE = (MMGestureGallery) findViewById(R.h.bSr);
        this.klE.setVerticalFadingEdgeEnabled(false);
        this.klE.setHorizontalFadingEdgeEnabled(false);
        this.klE.setOnItemSelectedListener(this);
        this.klE.wmR = new f(this) {
            final /* synthetic */ FavImgGalleryUI lHm;

            {
                this.lHm = r1;
            }

            public final void ahA() {
                this.lHm.finish();
            }
        };
        if (this.fQy) {
            this.klE.wmS = new MMGestureGallery.c(this) {
                final /* synthetic */ FavImgGalleryUI lHm;

                {
                    this.lHm = r1;
                }

                public final void auf() {
                    if (!this.lHm.isFinishing() && !this.lHm.uSW) {
                        FavImgGalleryUI.a(this.lHm);
                    }
                }
            };
        }
        kp(true);
        this.jjQ = new ArrayList();
        this.lHj = new a();
        this.klE.setAdapter(this.lHj);
        aue();
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ FavImgGalleryUI lHm;

            {
                this.lHm = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.lHm.finish();
                return true;
            }
        });
        com.tencent.mm.sdk.b.a.urY.b(this.lHl);
    }

    private void aue() {
        long longExtra = getIntent().getLongExtra("key_detail_info_id", -1);
        String stringExtra = getIntent().getStringExtra("key_detail_data_id");
        boolean booleanExtra = getIntent().getBooleanExtra("fav_open_from_wnnote", false);
        String stringExtra2 = getIntent().getStringExtra("fav_note_xml");
        List arrayList = new ArrayList();
        j bT = h.ata().bT(longExtra);
        String str = "MicroMsg.FavImgGalleryUI";
        String str2 = "show one fav info, local id is %d, get from db ok ? %B";
        Object[] objArr = new Object[2];
        objArr[0] = Long.valueOf(longExtra);
        objArr[1] = Boolean.valueOf(bT != null);
        w.i(str, str2, objArr);
        if (!booleanExtra || bg.mA(stringExtra2)) {
            j jVar = bT;
        } else {
            Object wc = x.wc(stringExtra2);
        }
        if (wc != null) {
            arrayList.add(wc);
        }
        this.jjQ.clear();
        int i = -1;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            jVar = (j) arrayList.get(i2);
            int size2 = jVar.field_favProto.tzn.size();
            int i3 = 0;
            while (i3 < size2) {
                int size3;
                rm rmVar = (rm) jVar.field_favProto.tzn.get(i3);
                if ((rmVar.aMw != 8 || o.Pj(x.g(rmVar))) && (rmVar.aMw == 2 || rmVar.aMw == 8)) {
                    this.jjQ.add(new d(jVar, rmVar));
                    if (stringExtra != null && stringExtra.equals(rmVar.lKv)) {
                        size3 = this.jjQ.size() - 1;
                        i3++;
                        i = size3;
                    }
                }
                size3 = i;
                i3++;
                i = size3;
            }
            if (stringExtra == null && jVar.field_localId == longExtra) {
                i = this.jjQ.size() - 1;
            }
        }
        getIntent().removeExtra("key_detail_info_id");
        getIntent().removeExtra("key_detail_data_id");
        this.lHj.notifyDataSetChanged();
        this.klE.post(new Runnable(this) {
            final /* synthetic */ FavImgGalleryUI lHm;

            public final void run() {
                if (i != -1) {
                    w.d("MicroMsg.FavImgGalleryUI", "match selection %d", new Object[]{Integer.valueOf(i)});
                    this.lHm.klE.setSelection(i);
                    this.lHm.lHi = i;
                } else if (this.lHm.lHi - 1 >= 0 && this.lHm.lHi - 1 < this.lHm.jjQ.size()) {
                    w.d("MicroMsg.FavImgGalleryUI", "adjust selection %d, list size %d", new Object[]{Integer.valueOf(this.lHm.lHi - 1), Integer.valueOf(this.lHm.jjQ.size())});
                    this.lHm.klE.setSelection(this.lHm.lHi - 1);
                    this.lHm.lHi = this.lHm.lHi - 1;
                } else if (this.lHm.jjQ.size() > 0) {
                    w.d("MicroMsg.FavImgGalleryUI", "adjust selection fail, set selection 0, list size %d", new Object[]{Integer.valueOf(this.lHm.jjQ.size())});
                    this.lHm.klE.setSelection(0);
                    this.lHm.lHi = 0;
                } else {
                    w.w("MicroMsg.FavImgGalleryUI", "data list size %d, empty, finish", new Object[]{Integer.valueOf(this.lHm.jjQ.size())});
                    this.lHm.finish();
                }
            }
        });
    }

    protected void onDestroy() {
        com.tencent.mm.sdk.b.a.urY.c(this.lHl);
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        h.asV().a((com.tencent.mm.plugin.favorite.b.b.a) this);
    }

    protected void onPause() {
        super.onPause();
        h.asV().b((com.tencent.mm.plugin.favorite.b.b.a) this);
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        this.lHi = i;
        w.d("MicroMsg.FavImgGalleryUI", "pos:" + i);
        if (view instanceof MultiTouchImageView) {
            ((MultiTouchImageView) view).bSJ();
        }
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public final void b(final com.tencent.mm.plugin.favorite.b.a aVar) {
        if (aVar != null) {
            w.v("MicroMsg.FavImgGalleryUI", "on cdn status changed, status:%d", new Object[]{Integer.valueOf(aVar.field_status)});
            d mw = this.lHj.mw(this.lHi);
            if (mw != null && bg.ap(aVar.field_dataId, "").equals(mw.fKe.lKv)) {
                af.v(new Runnable(this) {
                    final /* synthetic */ FavImgGalleryUI lHm;

                    public final void run() {
                        View selectedView = this.lHm.klE.getSelectedView();
                        if (selectedView != null) {
                            b bVar = (b) selectedView.getTag();
                            int i = aVar.field_totalLen > 0 ? ((aVar.field_offset * 100) / aVar.field_totalLen) - 1 : 0;
                            if (i < 0) {
                                i = 0;
                            }
                            bVar.jKM.setProgress(i);
                            bVar.lHt.setText(this.lHm.getString(R.l.elF, new Object[]{Integer.valueOf(i)}));
                            if (i >= 100 || aVar.isFinished()) {
                                this.lHm.lHj.notifyDataSetChanged();
                            }
                        }
                    }
                });
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (1 == i) {
            if (-1 == i2) {
                d mw = this.lHj.mw(this.lHi);
                if (mw == null) {
                    w.i("MicroMsg.FavImgGalleryUI", "dataItem is null.");
                    return;
                }
                q qVar = new q();
                if (q.h(mw.lJS)) {
                    com.tencent.mm.ui.base.g.bl(this.uSU.uTo, getString(R.l.dAL));
                    return;
                }
                w.d("MicroMsg.FavImgGalleryUI", "select %s for sending", new Object[]{intent.getStringExtra("Select_Conv_User")});
                final Dialog a = com.tencent.mm.ui.base.g.a(this.uSU.uTo, getString(R.l.eit), false, null);
                r.a(this.uSU.uTo, r1, mw.lJS, mw.fKe, new Runnable(this) {
                    final /* synthetic */ FavImgGalleryUI lHm;

                    public final void run() {
                        a.dismiss();
                        com.tencent.mm.ui.snackbar.a.e(this.lHm, this.lHm.getString(R.l.ekV));
                    }
                });
            } else {
                return;
            }
        }
        super.onActivityResult(i, i2, intent);
    }
}
