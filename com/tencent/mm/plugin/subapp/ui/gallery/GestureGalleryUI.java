package com.tencent.mm.plugin.subapp.ui.gallery;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.e.a.aj;
import com.tencent.mm.e.a.bx;
import com.tencent.mm.e.a.cb;
import com.tencent.mm.e.a.jp;
import com.tencent.mm.e.a.lw;
import com.tencent.mm.e.a.ly;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.gif.MMGIFImageView;
import com.tencent.mm.plugin.sns.b.m;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.s;
import com.tencent.mm.u.s.b;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMGallery;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.widget.e;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GestureGalleryUI extends MMActivity implements OnTouchListener, b {
    private String hlO = null;
    private c lHl = new c<ly>(this) {
        final /* synthetic */ GestureGalleryUI qUe;

        {
            this.qUe = r2;
            this.usg = ly.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            ly lyVar = (ly) bVar;
            if (lyVar == null) {
                w.e("MicroMsg.GestureGalleryUI", "RecogQBarOfImageFileResultEvent is null.");
            } else if (lyVar == null || lyVar.fTe.filePath.equals(this.qUe.qtk)) {
                w.i("MicroMsg.GestureGalleryUI", "recog result: %s", new Object[]{lyVar.fTe.result});
                if (this.qUe.qUd.isEmpty() || this.qUe.qUd.contains(Integer.valueOf(lyVar.fTe.fFo))) {
                    this.qUe.qTZ = lyVar.fTe.fFo;
                    this.qUe.qtn = lyVar.fTe.result;
                    this.qUe.qUa = lyVar.fTe.fFp;
                    this.qUe.qtk = null;
                    if (!bg.mA(this.qUe.qtn) && this.qUe.qTX.isShowing()) {
                        GestureGalleryUI.a(this.qUe);
                    }
                } else {
                    w.i("MicroMsg.GestureGalleryUI", "Result codeType(%s) error.", new Object[]{Integer.valueOf(lyVar.fTe.fFo)});
                }
            } else {
                w.e("MicroMsg.GestureGalleryUI", "not same filepath");
            }
            return false;
        }
    };
    private MMGallery mAN;
    private MMGestureGallery mAO;
    float mAP = 0.0f;
    float mAQ = 0.0f;
    boolean mAR = false;
    float mAS = 1.0f;
    private s mAT;
    private List<String> mAU = new ArrayList();
    private int mAV = -1;
    private OnItemSelectedListener mAW = new OnItemSelectedListener(this) {
        final /* synthetic */ GestureGalleryUI qUe;

        {
            this.qUe = r1;
        }

        public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            this.qUe.mAV = i;
            this.qUe.qP((this.qUe.mAV + 1) + " / " + this.qUe.mAU.size());
            w.d("MicroMsg.GestureGalleryUI", "pos:" + i);
            this.qUe.qTV = this.qUe.mAT.c((String) this.qUe.mAU.get(i), this.qUe.type, i, this.qUe.hlO);
            if (bg.mA(this.qUe.qTV)) {
                this.qUe.qTV = (String) this.qUe.mAU.get(i);
            }
        }

        public final void onNothingSelected(AdapterView<?> adapterView) {
        }
    };
    private a qTU;
    private String qTV;
    private boolean qTW = false;
    private e qTX;
    private volatile boolean qTY;
    private int qTZ;
    private int qUa;
    private int qUb;
    private final Set<Integer> qUc = new HashSet();
    private final Set<Integer> qUd = new HashSet();
    private volatile String qtk;
    private String qtn;
    private c qtq = new c<jp>(this) {
        final /* synthetic */ GestureGalleryUI qUe;

        {
            this.qUe = r2;
            this.usg = jp.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            jp jpVar = (jp) bVar;
            if (jpVar != null) {
                w.i("MicroMsg.GestureGalleryUI", "notify Event: %d", new Object[]{Integer.valueOf(jpVar.fQb.fPZ)});
                if (jpVar.fQb.activity == this.qUe && jpVar.fQb.fDK.equals(this.qUe.qtn)) {
                    switch (jpVar.fQb.fPZ) {
                        case 0:
                        case 1:
                        case 2:
                            break;
                        case 3:
                            this.qUe.finish();
                            break;
                        default:
                            break;
                    }
                }
                w.e("MicroMsg.GestureGalleryUI", "not the same");
            } else {
                w.e("MicroMsg.GestureGalleryUI", "NotifyDealQBarStrResultEvent is null.");
            }
            return false;
        }
    };
    private int type = 0;

    class a extends BaseAdapter {
        final /* synthetic */ GestureGalleryUI qUe;

        class a {
            ProgressBar mAY;
            MMGIFImageView qUg;
            final /* synthetic */ a qUh;

            a(a aVar) {
                this.qUh = aVar;
            }
        }

        public a(GestureGalleryUI gestureGalleryUI) {
            this.qUe = gestureGalleryUI;
        }

        public final int getCount() {
            w.d("MicroMsg.GestureGalleryUI", "lstpicurl:" + this.qUe.mAU.size());
            return this.qUe.mAU.size();
        }

        public final Object getItem(int i) {
            return Integer.valueOf(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                aVar = new a(this);
                view = View.inflate(this.qUe, R.i.dlW, null);
                aVar.mAY = (ProgressBar) view.findViewById(R.h.cts);
                aVar.qUg = (MMGIFImageView) view.findViewById(R.h.Kd);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            view.setLayoutParams(new LayoutParams(-1, -1));
            String str = (String) this.qUe.mAU.get(i);
            if (!com.tencent.mm.a.e.aO(str)) {
                str = this.qUe.mAT.c(str, this.qUe.type, i, this.qUe.hlO);
            }
            if (bg.mA(str)) {
                aVar.mAY.setVisibility(0);
                aVar.qUg.setVisibility(8);
            } else {
                Bitmap bitmap;
                aVar.mAY.setVisibility(8);
                if (str == null) {
                    bitmap = null;
                } else {
                    Options options = new Options();
                    options.inJustDecodeBounds = true;
                    bitmap = BitmapFactory.decodeFile(str, options);
                    if (bitmap != null) {
                        w.i("MicroMsg.GestureGalleryUI", "recycle bitmap:%s", new Object[]{bitmap.toString()});
                        bitmap.recycle();
                    }
                    bitmap = d.Pg(str);
                    if (bitmap == null && MMNativeJpeg.IsJpegFile(str) && MMNativeJpeg.isProgressive(str)) {
                        Bitmap decodeAsBitmap = MMNativeJpeg.decodeAsBitmap(str);
                        String str2 = "MicroMsg.GestureGalleryUI";
                        String str3 = "Progressive jpeg, result isNull:%b";
                        Object[] objArr = new Object[1];
                        objArr[0] = Boolean.valueOf(decodeAsBitmap == null);
                        w.i(str2, str3, objArr);
                        bitmap = decodeAsBitmap;
                    }
                    if (bitmap == null) {
                        w.e("MicroMsg.GestureGalleryUI", "getSuitableBmp fail, temBmp is null, filePath = " + str);
                        bitmap = null;
                    }
                }
                if (o.Pj(str)) {
                    try {
                        aVar.qUg.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
                        aVar.qUg.setVisibility(0);
                        aVar.qUg.yj(str);
                    } catch (Throwable e) {
                        w.e("MicroMsg.GestureGalleryUI", bg.g(e));
                        aVar.qUg.setVisibility(0);
                        aVar.qUg.setImageBitmap(bitmap);
                    }
                } else if (!(bitmap == null || bitmap.isRecycled())) {
                    if (b.bnc()) {
                        aVar.qUg.setVisibility(8);
                        view = new MultiTouchImageView(this.qUe, bitmap.getWidth(), bitmap.getHeight());
                        if (VERSION.SDK_INT == 20) {
                            view.setLayerType(1, null);
                        } else {
                            k.i(view, bitmap.getWidth(), bitmap.getHeight());
                        }
                        view.qBZ = false;
                        view.setLayoutParams(new LayoutParams(-1, -1));
                        view.setImageBitmap(bitmap);
                    } else {
                        aVar.qUg.setImageBitmap(bitmap);
                        aVar.qUg.setVisibility(0);
                        aVar.qUg.setScaleType(ScaleType.MATRIX);
                    }
                }
            }
            return view;
        }
    }

    static /* synthetic */ void a(GestureGalleryUI gestureGalleryUI) {
        if (gestureGalleryUI.qTX == null) {
            gestureGalleryUI.qTX = new e(gestureGalleryUI.uSU.uTo, e.wuP, false);
        }
        gestureGalleryUI.qTX.qJf = new n.c(gestureGalleryUI) {
            final /* synthetic */ GestureGalleryUI qUe;

            {
                this.qUe = r1;
            }

            public final void a(l lVar) {
                lVar.clear();
                lVar.dX(1, R.l.eHR);
                lVar.dX(2, R.l.eOk);
                lVar.dX(3, R.l.eGa);
                if (GestureGalleryUI.c(this.qUe)) {
                    lVar.dX(4, com.tencent.mm.plugin.scanner.a.ak(this.qUe.qTZ, this.qUe.qtn) ? R.l.eIB : R.l.eIA);
                }
                if (this.qUe.qTY && bg.mA(this.qUe.qtn) && ap.vd().BR() != 0) {
                    com.tencent.mm.sdk.b.b lwVar = new lw();
                    lwVar.fTb.filePath = this.qUe.qTV;
                    lwVar.fTb.fTc = new HashSet(this.qUe.qUc);
                    this.qUe.qtk = this.qUe.qTV;
                    com.tencent.mm.sdk.b.a.urY.m(lwVar);
                }
            }
        };
        gestureGalleryUI.qTX.qJg = new n.d(gestureGalleryUI) {
            final /* synthetic */ GestureGalleryUI qUe;

            {
                this.qUe = r1;
            }

            public final void c(MenuItem menuItem, int i) {
                com.tencent.mm.sdk.b.b cbVar;
                switch (menuItem.getItemId()) {
                    case 1:
                        if (bg.mA(this.qUe.qTV)) {
                            w.w("MicroMsg.GestureGalleryUI", "share image to friend fail, imgPath is null");
                            return;
                        } else if (o.Pj(this.qUe.qTV)) {
                            com.tencent.mm.storage.a.c ub;
                            String b;
                            com.tencent.mm.storage.a.c ub2 = ((com.tencent.mm.plugin.emoji.b.c) h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().ub(g.aV(this.qUe.qTV));
                            if (ub2 == null) {
                                ub = ((com.tencent.mm.plugin.emoji.b.c) h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().ub(((com.tencent.mm.plugin.emoji.b.c) h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().uc(this.qUe.qTV));
                            } else {
                                ub = ub2;
                            }
                            int aN = ub == null ? 0 : com.tencent.mm.a.e.aN(ub.eN(ub.field_groupId, ub.EP()));
                            if (ub == null) {
                                b = this.qUe.qTV;
                            } else {
                                b = ub.eN(ub.field_groupId, ub.EP());
                            }
                            Options options = new Options();
                            options.inJustDecodeBounds = true;
                            int i2;
                            if ((d.decodeFile(b, options) == null || options.outHeight <= com.tencent.mm.i.b.sB()) && options.outWidth <= com.tencent.mm.i.b.sB()) {
                                i2 = 0;
                            } else {
                                i2 = true;
                            }
                            if (aN > com.tencent.mm.i.b.sC() || r0 != 0) {
                                com.tencent.mm.ui.base.g.a(this.qUe.uSU.uTo, this.qUe.getString(R.l.ecw), "", this.qUe.getString(R.l.esq), null);
                                return;
                            }
                            r0 = new Intent();
                            r0.putExtra("Retr_File_Name", ub.EP());
                            r0.putExtra("Retr_Msg_Type", 5);
                            r0.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                            r0.putExtra("Retr_MsgImgScene", 1);
                            com.tencent.mm.plugin.subapp.b.imv.l(r0, this.qUe.uSU.uTo);
                            return;
                        } else {
                            r0 = new Intent();
                            r0.putExtra("Retr_File_Name", this.qUe.qTV);
                            r0.putExtra("Retr_Compress_Type", 0);
                            r0.putExtra("Retr_Msg_Type", 0);
                            com.tencent.mm.plugin.subapp.b.imv.l(r0, this.qUe.uSU.uTo);
                            return;
                        }
                    case 2:
                        if (this.qUe.qTV != null && !this.qUe.qTV.equals("")) {
                            ap.yY();
                            if (com.tencent.mm.u.c.isSDCardAvailable()) {
                                com.tencent.mm.pluginsdk.ui.tools.k.h(this.qUe.qTV, this.qUe);
                                return;
                            } else {
                                com.tencent.mm.ui.base.s.eP(this.qUe);
                                return;
                            }
                        }
                        return;
                    case 3:
                        cbVar = new cb();
                        com.tencent.mm.pluginsdk.model.e.a(cbVar, 1, this.qUe.qTV);
                        cbVar.fFA.activity = this.qUe;
                        cbVar.fFA.fFH = 32;
                        com.tencent.mm.sdk.b.a.urY.m(cbVar);
                        return;
                    case 4:
                        w.i("MicroMsg.GestureGalleryUI", "request deal QBAR string");
                        cbVar = new bx();
                        cbVar.fFn.activity = this.qUe;
                        cbVar.fFn.fDK = this.qUe.qtn;
                        cbVar.fFn.fFo = this.qUe.qTZ;
                        cbVar.fFn.fFp = this.qUe.qUa;
                        cbVar.fFn.fFr = this.qUe.qUb;
                        cbVar.fFn.fFu = this.qUe.getIntent().getBundleExtra("_stat_obj");
                        com.tencent.mm.sdk.b.a.urY.m(cbVar);
                        return;
                    default:
                        return;
                }
            }
        };
        gestureGalleryUI.qTX.wva = new com.tencent.mm.ui.widget.e.a(gestureGalleryUI) {
            final /* synthetic */ GestureGalleryUI qUe;

            {
                this.qUe = r1;
            }

            public final void onDismiss() {
            }
        };
        gestureGalleryUI.qTX.bzh();
    }

    static /* synthetic */ void a(GestureGalleryUI gestureGalleryUI, final String str) {
        if (str != null && str.length() != 0 && com.tencent.mm.pluginsdk.ui.applet.d.b(gestureGalleryUI.uSU, str, true, new com.tencent.mm.pluginsdk.ui.applet.k.a(gestureGalleryUI) {
            final /* synthetic */ GestureGalleryUI qUe;

            public final void a(boolean z, String str, int i) {
                if (z) {
                    if (m.pQz != null) {
                        m.pQz.dp(str, str);
                        m.pQz.bdz();
                    }
                    com.tencent.mm.ui.base.g.bl(this.qUe, this.qUe.getResources().getString(R.l.dIG));
                }
            }
        }) == null) {
            w.e("MicroMsg.GestureGalleryUI", "doTimeline fail, cannot show dialog");
        }
    }

    static /* synthetic */ boolean c(GestureGalleryUI gestureGalleryUI) {
        return gestureGalleryUI.qTY && !bg.mA(gestureGalleryUI.qtn);
    }

    public final void a(String str, String str2, int i) {
        if (this.qTU != null) {
            if (i == (b.bnc() ? this.mAO.getSelectedItemPosition() : this.mAN.getSelectedItemPosition())) {
                this.qTV = str2;
                w.d("MicroMsg.GestureGalleryUI", "onDownSucc, curFilename:%s, url:%s", new Object[]{this.qTV, str});
            }
            this.qTU.notifyDataSetChanged();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.qTW = getIntent().getBooleanExtra("isFromWebView", false);
        this.qTY = getIntent().getBooleanExtra("shouldShowScanQrCodeMenu", false);
        this.qUb = getIntent().getIntExtra("scanQrCodeGetA8KeyScene", 0);
        int[] intArrayExtra = getIntent().getIntArrayExtra("scanCodeTypes");
        if (intArrayExtra != null && intArrayExtra.length > 0) {
            for (int valueOf : intArrayExtra) {
                this.qUc.add(Integer.valueOf(valueOf));
            }
        }
        intArrayExtra = getIntent().getIntArrayExtra("scanResultCodeTypes");
        if (intArrayExtra != null && intArrayExtra.length > 0) {
            for (int valueOf2 : intArrayExtra) {
                this.qUd.add(Integer.valueOf(valueOf2));
            }
        }
        this.hlO = getIntent().getStringExtra("cookie");
        w.d("MicroMsg.GestureGalleryUI", "isFromWebView: %b, cookie = %s", new Object[]{Boolean.valueOf(this.qTW), this.hlO});
        this.mAT = new s(this.qTW);
        s sVar = this.mAT;
        w.d("MicroMsg.GetPicService", "addListener :" + hashCode());
        sVar.hlI = this;
        com.tencent.mm.sdk.b.a.urY.b(this.lHl);
        com.tencent.mm.sdk.b.a.urY.b(this.qtq);
        KC();
    }

    public void onDestroy() {
        super.onDestroy();
        s sVar = this.mAT;
        w.d("MicroMsg.GetPicService", "removeListener :" + hashCode());
        sVar.hlI = null;
        this.mAT.yE();
        com.tencent.mm.sdk.b.a.urY.c(this.lHl);
        com.tencent.mm.sdk.b.a.urY.c(this.qtq);
    }

    public void onPause() {
        super.onPause();
    }

    public void onResume() {
        super.onResume();
    }

    protected void onStop() {
        super.onStop();
        if (this.qtn != null) {
            com.tencent.mm.sdk.b.b ajVar = new aj();
            ajVar.fDJ.activity = this;
            ajVar.fDJ.fDK = this.qtn;
            com.tencent.mm.sdk.b.a.urY.m(ajVar);
            this.qtn = null;
            this.qUa = 0;
            this.qTZ = 0;
        }
    }

    protected final int getLayoutId() {
        return R.i.dlV;
    }

    protected final void KC() {
        int i;
        String mz = bg.mz(getIntent().getStringExtra("nowUrl"));
        this.type = getIntent().getIntExtra(Columns.TYPE, 0);
        String[] stringArrayExtra = getIntent().getStringArrayExtra("urlList");
        if (stringArrayExtra == null || stringArrayExtra.length == 0) {
            String mz2 = bg.mz(getIntent().getStringExtra("htmlData"));
            i = 0;
            while (i >= 0) {
                int indexOf = mz2.indexOf("weixin://viewimage/", i);
                if (indexOf < 0) {
                    break;
                }
                i = mz2.indexOf("\"", indexOf);
                if (i < 0) {
                    break;
                }
                String substring = mz2.substring(indexOf + 19, i);
                w.d("MicroMsg.GestureGalleryUI", "start:" + indexOf + " end:" + i + " url:" + substring);
                this.mAU.add(substring);
            }
        } else {
            this.mAU = Arrays.asList(stringArrayExtra);
        }
        for (i = 0; i < this.mAU.size(); i++) {
            if (mz.equals(this.mAU.get(i))) {
                this.mAV = i;
                break;
            }
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ GestureGalleryUI qUe;

            {
                this.qUe = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.qUe.finish();
                return true;
            }
        });
        this.qTU = new a(this);
        if (b.bnc()) {
            this.mAO = (MMGestureGallery) findViewById(R.h.bSr);
            this.mAO.setVisibility(0);
            this.mAO.setVerticalFadingEdgeEnabled(false);
            this.mAO.setHorizontalFadingEdgeEnabled(false);
            this.mAO.setAdapter(this.qTU);
            this.mAO.setSelection(this.mAV);
            this.mAO.setOnItemSelectedListener(this.mAW);
        } else {
            this.mAN = (MMGallery) findViewById(R.h.bSs);
            this.mAN.setVisibility(0);
            this.mAN.setAdapter(this.qTU);
            this.mAN.setSelection(this.mAV);
            this.mAN.setOnItemSelectedListener(this.mAW);
        }
        i = getIntent().getIntExtra("nevNext", 1);
        if (1 == i) {
            a(0, R.g.bhb, new OnMenuItemClickListener(this) {
                final /* synthetic */ GestureGalleryUI qUe;

                {
                    this.qUe = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    GestureGalleryUI.a(this.qUe);
                    return true;
                }
            });
        } else if (2 == i) {
            a(0, R.k.dyx, new OnMenuItemClickListener(this) {
                final /* synthetic */ GestureGalleryUI qUe;

                {
                    this.qUe = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    com.tencent.mm.ui.base.g.a(this.qUe, null, this.qUe.uSU.uTo.getResources().getStringArray(R.c.aSo), "", false, new com.tencent.mm.ui.base.g.c(this) {
                        final /* synthetic */ AnonymousClass4 qUf;

                        {
                            this.qUf = r1;
                        }

                        public final void hq(int i) {
                            switch (i) {
                                case 0:
                                    GestureGalleryUI.a(this.qUf.qUe, this.qUf.qUe.qTV);
                                    return;
                                case 1:
                                    MMActivity mMActivity = this.qUf.qUe;
                                    String b = this.qUf.qUe.qTV;
                                    if (b != null && b.length() != 0) {
                                        Intent intent = new Intent();
                                        intent.putExtra("Retr_File_Name", b);
                                        intent.putExtra("Retr_Msg_Type", 0);
                                        intent.putExtra("Retr_Compress_Type", 0);
                                        com.tencent.mm.plugin.subapp.b.imv.l(intent, mMActivity.uSU.uTo);
                                        return;
                                    }
                                    return;
                                default:
                                    return;
                            }
                        }
                    });
                    return true;
                }
            });
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        w.d("MicroMsg.GestureGalleryUI", "Main onTouch event.getAction():" + motionEvent.getAction());
        switch (motionEvent.getAction() & 255) {
            case 2:
                if (this.mAR) {
                    this.mAQ = b.E(motionEvent);
                    if (this.mAQ >= 5.0f) {
                        float f = this.mAQ - this.mAP;
                        if (f != 0.0f) {
                            if (Math.abs(f) <= 5.0f) {
                                return true;
                            }
                            float f2 = f / 854.0f;
                            Animation scaleAnimation = new ScaleAnimation(this.mAS, this.mAS + f2, this.mAS, this.mAS + f2, 1, 0.5f, 1, 0.5f);
                            scaleAnimation.setDuration(100);
                            scaleAnimation.setFillAfter(true);
                            scaleAnimation.setFillEnabled(true);
                            this.mAS += f2;
                            this.mAN.getSelectedView().setLayoutParams(new LayoutParams((int) (480.0f * this.mAS), (int) (this.mAS * 854.0f)));
                            this.mAP = this.mAQ;
                            return true;
                        }
                    }
                }
                break;
            case 5:
                this.mAP = b.E(motionEvent);
                if (this.mAP > 5.0f) {
                    this.mAR = true;
                    break;
                }
                break;
            case 6:
                this.mAR = false;
                break;
        }
        return false;
    }
}
