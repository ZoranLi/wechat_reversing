package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.aj;
import com.tencent.mm.e.a.ak;
import com.tencent.mm.e.a.bx;
import com.tencent.mm.e.a.cb;
import com.tencent.mm.e.a.dd;
import com.tencent.mm.e.a.jp;
import com.tencent.mm.e.a.lw;
import com.tencent.mm.e.a.ly;
import com.tencent.mm.e.a.oq;
import com.tencent.mm.e.a.po;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ai;
import com.tencent.mm.plugin.sns.model.am;
import com.tencent.mm.plugin.sns.model.b.b;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.protocal.c.alh;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.an;
import com.tencent.mm.ui.base.f;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.widget.e;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public abstract class FlipView extends LinearLayout implements OnTouchListener, b {
    Context context;
    private int fFo;
    private int fFp;
    protected ae handler;
    private long hnT = 0;
    protected int infoType = -1;
    private c lHl = new c<ly>(this) {
        final /* synthetic */ FlipView qtr;

        {
            this.qtr = r2;
            this.usg = ly.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            ly lyVar = (ly) bVar;
            if (!this.qtr.qti) {
                w.i("MicroMsg.FlipView", "no need to scan image");
            } else if (this.qtr.qtj == null || this.qtr.qtk == null) {
                w.e("MicroMsg.FlipView", "not in recoging");
            } else if (lyVar == null || !(lyVar instanceof ly)) {
                w.e("MicroMsg.FlipView", "receive invalid callbak");
            } else if (lyVar.fTe.filePath.equals(this.qtr.qtk)) {
                w.i("MicroMsg.FlipView", "recog result: " + lyVar.fTe.result);
                if (!bg.mA(lyVar.fTe.result)) {
                    this.qtr.qtn = lyVar.fTe.result;
                    this.qtr.fFo = lyVar.fTe.fFo;
                    this.qtr.fFp = lyVar.fTe.fFp;
                    if (!(this.qtr.qtn == null || this.qtr.qtj == null)) {
                        this.qtr.qto = true;
                    }
                    this.qtr.e(this.qtr.qtk, this.qtr.qtl, this.qtr.qtm, false);
                }
                this.qtr.qtk = null;
            } else {
                w.e("MicroMsg.FlipView", "not same filepath");
            }
            return false;
        }
    };
    float mAP = 0.0f;
    float mAQ = 0.0f;
    boolean mAR = false;
    float mAS = 1.0f;
    private double qta = 0.0d;
    private double qtb = 0.0d;
    protected u qtc;
    protected com.tencent.mm.plugin.sns.ui.s.a qtd;
    protected int qte;
    protected int qtf;
    private boolean qtg = false;
    private long qth = 0;
    boolean qti = false;
    private e qtj;
    private String qtk;
    private String qtl;
    private String qtm;
    private String qtn;
    private boolean qto = false;
    private a qtp = new a(this);
    private c qtq = new c<jp>(this) {
        final /* synthetic */ FlipView qtr;

        {
            this.qtr = r2;
            this.usg = jp.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            jp jpVar = (jp) bVar;
            if (this.qtr.qti) {
                if (jpVar != null && (jpVar instanceof jp)) {
                    w.i("MicroMsg.FlipView", "notify Event: %d", new Object[]{Integer.valueOf(jpVar.fQb.fPZ)});
                    if (jpVar.fQb.activity == ((Activity) this.qtr.context) && jpVar.fQb.fDK.equals(this.qtr.qtn)) {
                        switch (jpVar.fQb.fPZ) {
                            case 0:
                            case 1:
                            case 2:
                                break;
                            case 3:
                                ((Activity) this.qtr.context).finish();
                                break;
                            default:
                                break;
                        }
                    }
                    w.e("MicroMsg.FlipView", "not the same");
                } else {
                    w.e("MicroMsg.FlipView", "event is null or not a instant of NotifyDealQBarStrResultEvent");
                }
            } else {
                w.i("MicroMsg.FlipView", "no need to scan image");
            }
            return false;
        }
    };

    class a implements Runnable {
        final /* synthetic */ FlipView qtr;
        float x;
        float y;

        a(FlipView flipView) {
            this.qtr = flipView;
        }

        public final void run() {
        }
    }

    public abstract long biQ();

    public abstract boolean biR();

    public abstract int getPosition();

    static /* synthetic */ void GH(String str) {
        com.tencent.mm.sdk.b.b poVar = new po();
        poVar.fWr.fJK = 3;
        poVar.fWr.fJz = str;
        com.tencent.mm.sdk.b.a.urY.m(poVar);
    }

    static /* synthetic */ void GI(String str) {
        com.tencent.mm.sdk.b.b poVar = new po();
        poVar.fWr.fJK = 1;
        poVar.fWr.fWu = 2;
        poVar.fWr.fJz = str;
        com.tencent.mm.sdk.b.a.urY.m(poVar);
    }

    static /* synthetic */ void h(boolean z, String str) {
        com.tencent.mm.sdk.b.b poVar = new po();
        poVar.fWr.fJK = 2;
        poVar.fWr.fWs = 14;
        poVar.fWr.fWt = z;
        poVar.fWr.fJz = str;
        com.tencent.mm.sdk.b.a.urY.m(poVar);
    }

    public FlipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public FlipView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        this.context = context;
        this.handler = new ae();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) this.context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.qte = displayMetrics.widthPixels;
        this.qtf = displayMetrics.heightPixels;
        com.tencent.mm.sdk.b.a.urY.b(this.lHl);
        com.tencent.mm.sdk.b.a.urY.b(this.qtq);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            w.d("MicroMsg.FlipView", "onTouchEvent down");
            this.qta = (double) motionEvent.getX();
            this.qtb = (double) motionEvent.getY();
            this.hnT = System.currentTimeMillis();
            if (f.H(motionEvent) == 1) {
                this.qtg = false;
            }
        }
        if (f.H(motionEvent) > 1) {
            this.qtg = true;
        }
        if (motionEvent.getAction() == 1 && !this.qtg) {
            w.d("MicroMsg.FlipView", "onTouchEvent up " + (System.currentTimeMillis() - this.hnT));
            long NA = bg.NA();
            w.d("MicroMsg.FlipView", "deltTime: " + (NA - this.qth));
            if (NA - this.qth < 300) {
                this.handler.removeCallbacks(this.qtp);
                this.handler.post(new Runnable(this) {
                    final /* synthetic */ FlipView qtr;

                    {
                        this.qtr = r1;
                    }

                    public final void run() {
                    }
                });
                return super.dispatchTouchEvent(motionEvent);
            }
            this.qth = NA;
            if (System.currentTimeMillis() - this.hnT < 500 && Math.abs(((double) motionEvent.getX()) - this.qta) <= 10.0d && Math.abs(((double) motionEvent.getY()) - this.qtb) <= 10.0d && motionEvent.getY() > 110.0f && motionEvent.getY() < ((float) (this.qtf - 100))) {
                a aVar = this.qtp;
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                aVar.x = x;
                aVar.y = y;
                this.handler.postDelayed(this.qtp, 10);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        return !f.bnc() ? false : false;
    }

    public final void ES(String str) {
    }

    public void ao(String str, boolean z) {
    }

    public final void bdD() {
    }

    public void ap(String str, boolean z) {
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    protected final void e(final String str, final String str2, final String str3, boolean z) {
        final List arrayList = new ArrayList();
        final List arrayList2 = new ArrayList();
        m Gg = com.tencent.mm.plugin.sns.model.ae.beL().Gg(str2);
        if (Gg == null) {
            w.e("MicroMsg.FlipView", "error!!show long click Alert snsInfo is null!!");
            return;
        }
        if (Gg.field_type != 21) {
            if (!u.Gz(str2)) {
                arrayList.add(this.context.getString(j.eWV));
                arrayList2.add(Integer.valueOf(1));
            }
            if (d.Jt("favorite")) {
                arrayList.add(this.context.getString(j.eGa));
                arrayList2.add(Integer.valueOf(2));
            }
            if (!u.Gz(str2)) {
                if (Gg.field_type == 15 || Gg.field_type == 5) {
                    arrayList.add(this.context.getString(j.eOn));
                    arrayList2.add(Integer.valueOf(0));
                } else if (Gg.field_type == 1) {
                    arrayList.add(this.context.getString(j.eOk));
                    arrayList2.add(Integer.valueOf(0));
                } else {
                    arrayList.add(this.context.getString(j.pMk));
                    arrayList2.add(Integer.valueOf(0));
                }
            }
            com.tencent.mm.sdk.b.b ddVar = new dd();
            ddVar.fGW.fGN = str2;
            com.tencent.mm.sdk.b.a.urY.m(ddVar);
            if (ddVar.fGX.fGu) {
                arrayList.add(this.context.getString(j.pJF));
                arrayList2.add(Integer.valueOf(5));
            }
            if (d.Jt("photoedit") && !u.Gz(str2) && Gg.field_type == 1) {
                arrayList.add(this.context.getString(j.dTN));
                arrayList2.add(Integer.valueOf(6));
            }
            if (this.qtn != null) {
                arrayList.add(com.tencent.mm.plugin.scanner.a.ak(this.fFo, this.qtn) ? this.context.getString(j.pMm) : this.context.getString(j.pMl));
                arrayList2.add(Integer.valueOf(4));
            }
        } else if (!Gg.field_userName.equals(com.tencent.mm.u.m.xL())) {
            arrayList.add(this.context.getString(j.pKV));
            arrayList2.add(Integer.valueOf(3));
        }
        if (this.qtj == null || !this.qto) {
            this.qtj = new e(this.context, e.wuP, false);
        } else {
            this.qto = false;
        }
        this.qtj.qJf = new n.c(this) {
            final /* synthetic */ FlipView qtr;

            public final void a(l lVar) {
                lVar.clear();
                for (int i = 0; i < arrayList.size(); i++) {
                    lVar.e(((Integer) arrayList2.get(i)).intValue(), (CharSequence) arrayList.get(i));
                }
            }
        };
        this.qtj.wva = new com.tencent.mm.ui.widget.e.a(this) {
            final /* synthetic */ FlipView qtr;

            {
                this.qtr = r1;
            }

            public final void onDismiss() {
                com.tencent.mm.sdk.b.b akVar = new ak();
                akVar.fDL.filePath = this.qtr.qtk;
                com.tencent.mm.sdk.b.a.urY.m(akVar);
                this.qtr.qtj = null;
                this.qtr.qtk = null;
                this.qtr.qtl = "";
                this.qtr.qtm = null;
                this.qtr.qtn = null;
                this.qtr.fFo = this.qtr.fFp = 0;
            }
        };
        this.qtj.qJg = new n.d(this) {
            final /* synthetic */ FlipView qtr;

            public final void c(MenuItem menuItem, int i) {
                m Gg = com.tencent.mm.plugin.sns.model.ae.beL().Gg(str2);
                if (Gg == null) {
                    w.i("MicroMsg.FlipView", "error beacause info null");
                    return;
                }
                m Gg2;
                switch (menuItem.getItemId()) {
                    case 0:
                        if (Gg.field_type != 15) {
                            k.h(str, this.qtr.context);
                            return;
                        } else {
                            FlipView.GH(str2);
                            return;
                        }
                    case 1:
                        if (Gg.field_type != 15) {
                            Intent intent = new Intent();
                            intent.putExtra("Retr_File_Name", str);
                            intent.putExtra("Retr_Compress_Type", 0);
                            intent.putExtra("Retr_Msg_Type", 0);
                            if (Gg != null) {
                                intent.putExtra("Retr_FromMainTimeline", this.qtr.biR());
                                intent.putExtra("Retr_KSnsId", i.g(Gg));
                            }
                            com.tencent.mm.plugin.sns.c.a.imv.l(intent, this.qtr.context);
                            return;
                        }
                        new StringBuilder().append(am.du(com.tencent.mm.plugin.sns.model.ae.getAccSnsPath(), str3)).append(i.e((alh) Gg.bhd().ufB.tsO.get(0)));
                        FlipView.GI(str2);
                        return;
                    case 2:
                        cb cbVar;
                        com.tencent.mm.sdk.b.b oqVar;
                        if (Gg.field_type != 15) {
                            cbVar = new cb();
                            String str = str2;
                            String str2 = str3;
                            if (str2 == null || bg.mA(str)) {
                                w.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or position errro");
                                cbVar.fFA.fFG = j.eib;
                            } else if (com.tencent.mm.plugin.sns.model.ae.beu()) {
                                w.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
                                cbVar.fFA.fFG = j.pJI;
                            } else {
                                Gg2 = com.tencent.mm.plugin.sns.model.ae.beL().Gg(str);
                                if (Gg2 == null) {
                                    w.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
                                    cbVar.fFA.fFG = j.eic;
                                } else {
                                    com.tencent.mm.plugin.sns.i.a.a(cbVar, Gg2, str2);
                                }
                            }
                            cbVar.fFA.fFH = 13;
                            cbVar.fFA.activity = (Activity) this.qtr.context;
                            com.tencent.mm.sdk.b.a.urY.m(cbVar);
                            if (this.qtr.biR()) {
                                oqVar = new oq();
                                oqVar.fVK.fVJ = i.g(Gg);
                                oqVar.fVK.fGN = Gg.bhy();
                                com.tencent.mm.sdk.b.a.urY.m(oqVar);
                                return;
                            }
                            return;
                        } else if (Gg != null) {
                            if (Gg.tE(32)) {
                                cbVar = new cb();
                                com.tencent.mm.plugin.sns.i.a.a(cbVar, Gg);
                                cbVar.fFA.fFH = 14;
                                cbVar.fFA.activity = (Activity) this.qtr.context;
                                com.tencent.mm.sdk.b.a.urY.m(cbVar);
                            } else {
                                FlipView.h(this.qtr.biR(), Gg.bhy());
                            }
                            if (this.qtr.biR()) {
                                oqVar = new oq();
                                oqVar.fVK.fVJ = i.g(Gg);
                                oqVar.fVK.fGN = Gg.bhy();
                                com.tencent.mm.sdk.b.a.urY.m(oqVar);
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    case 3:
                        Intent intent2 = new Intent();
                        intent2.putExtra("k_expose_msg_id", this.qtr.biQ());
                        Gg2 = com.tencent.mm.plugin.sns.model.ae.beL().dG(this.qtr.biQ());
                        intent2.putExtra("k_username", Gg2 == null ? "" : Gg2.field_userName);
                        intent2.putExtra("showShare", false);
                        intent2.putExtra("rawUrl", "https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect33");
                        intent2.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(33)}));
                        d.b(this.qtr.context, "webview", ".ui.tools.WebViewUI", intent2);
                        return;
                    case 4:
                        w.i("MicroMsg.FlipView", "request deal QBAR string");
                        com.tencent.mm.sdk.b.b bxVar = new bx();
                        bxVar.fFn.activity = (Activity) this.qtr.context;
                        bxVar.fFn.fDK = this.qtr.qtn;
                        bxVar.fFn.fFo = this.qtr.fFo;
                        bxVar.fFn.fFp = this.qtr.fFp;
                        alh a = ai.a(Gg, str3);
                        if (a != null) {
                            bxVar.fFn.imagePath = a.msN;
                            bxVar.fFn.fFt = a.tPz;
                        }
                        bxVar.fFn.scene = 38;
                        if (this.qtr.context instanceof Activity) {
                            bxVar.fFn.fFu = ((Activity) this.qtr.context).getIntent().getBundleExtra("_stat_obj");
                        }
                        if (this.qtr instanceof SnsInfoFlip) {
                            SnsInfoFlip snsInfoFlip = (SnsInfoFlip) this.qtr;
                            an anVar = snsInfoFlip.pQT;
                            w.d("MicroMsg.FlipView", "from Scene: %s", new Object[]{anVar.tag});
                            if (anVar.tag.equals(an.uJF.tag) || anVar.tag.equals(an.uJG.tag) || anVar.tag.equals(an.uJH.tag)) {
                                bxVar.fFn.fFq = 5;
                                if (bg.mA(snsInfoFlip.username)) {
                                    w.i("MicroMsg.FlipView", "empty username");
                                    snsInfoFlip.username = "";
                                }
                                bxVar.fFn.aJE = snsInfoFlip.username;
                            } else if (anVar.tag.equals(an.uJE.tag)) {
                                bxVar.fFn.fFq = 3;
                            } else {
                                w.i("MicroMsg.FlipView", "other scene_from: %s", new Object[]{anVar.tag});
                            }
                        }
                        com.tencent.mm.sdk.b.a.urY.m(bxVar);
                        return;
                    case 5:
                        if (Gg.bhd().ufB.tsO.size() != 0) {
                            Intent intent3 = new Intent();
                            if (Gg.field_type == 1) {
                                int position = this.qtr.getPosition();
                                int size = Gg.bhd().ufB.tsO.size();
                                if (size <= 1 || position <= 1 || position > size) {
                                    position = 0;
                                } else {
                                    position--;
                                }
                                String f = FlipView.f(str, this.qtr.context);
                                if (f != null) {
                                    intent3.putExtra("sns_send_data_ui_image_path", f);
                                    intent3.putExtra("sns_send_data_ui_image_position", position);
                                } else {
                                    return;
                                }
                            }
                            intent3.putExtra("sns_send_data_ui_activity", true);
                            intent3.putExtra("sns_local_id", str2);
                            d.a(this.qtr.context, ".ui.chatting.ChattingSendDataToDeviceUI", intent3);
                            return;
                        }
                        return;
                    case 6:
                        this.qtr.GG(str);
                        return;
                    default:
                        return;
                }
            }
        };
        this.qtj.bzh();
        if (this.qti && true == z) {
            h.vJ();
            if (h.vH().gXC.BR() != 0) {
                this.qtk = str;
                this.qtl = str2;
                this.qtm = str3;
                com.tencent.mm.sdk.b.b lwVar = new lw();
                lwVar.fTb.filePath = str;
                com.tencent.mm.sdk.b.a.urY.m(lwVar);
            }
        }
    }

    public static String f(String str, Context context) {
        FileOutputStream fileOutputStream;
        Throwable e;
        Throwable th;
        int i = 1;
        if (str == null || str.equals("")) {
            return null;
        }
        String str2 = com.tencent.mm.compatible.util.e.gSz + String.format("%s%d.%s", new Object[]{SlookAirButtonRecentMediaAdapter.IMAGE_TYPE, Integer.valueOf(str.hashCode()), "jpg"});
        String absolutePath = new File(ab.getContext().getCacheDir(), "tmp" + System.currentTimeMillis()).getAbsolutePath();
        if (FileOp.p(str, absolutePath) < 0) {
            return null;
        }
        if (MMNativeJpeg.isProgressive(absolutePath)) {
            try {
                Bitmap decodeAsBitmap = MMNativeJpeg.decodeAsBitmap(absolutePath);
                if (decodeAsBitmap != null) {
                    CompressFormat compressFormat = CompressFormat.JPEG;
                    fileOutputStream = new FileOutputStream(str2);
                    try {
                        decodeAsBitmap.compress(compressFormat, 80, fileOutputStream);
                    } catch (FileNotFoundException e2) {
                        e = e2;
                        try {
                            w.printErrStackTrace("MicroMsg.FlipView", e, "", new Object[0]);
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (Exception e3) {
                                }
                            }
                            FileOp.deleteFile(absolutePath);
                            i = 0;
                            if (i != 0) {
                            }
                            context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(new File(str2))));
                            return str2;
                        } catch (Throwable th2) {
                            th = th2;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (Exception e4) {
                                }
                            }
                            FileOp.deleteFile(absolutePath);
                            throw th;
                        }
                    } catch (OutOfMemoryError e5) {
                        e = e5;
                        w.printErrStackTrace("MicroMsg.FlipView", e, "", new Object[0]);
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception e6) {
                            }
                        }
                        FileOp.deleteFile(absolutePath);
                        i = 0;
                        if (i != 0) {
                        }
                        context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(new File(str2))));
                        return str2;
                    }
                }
                fileOutputStream = null;
                i = 0;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception e7) {
                    }
                }
                FileOp.deleteFile(absolutePath);
            } catch (FileNotFoundException e8) {
                e = e8;
                fileOutputStream = null;
                w.printErrStackTrace("MicroMsg.FlipView", e, "", new Object[0]);
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                FileOp.deleteFile(absolutePath);
                i = 0;
                if (i != 0) {
                }
                context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(new File(str2))));
                return str2;
            } catch (OutOfMemoryError e9) {
                e = e9;
                fileOutputStream = null;
                w.printErrStackTrace("MicroMsg.FlipView", e, "", new Object[0]);
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                FileOp.deleteFile(absolutePath);
                i = 0;
                if (i != 0) {
                }
                context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(new File(str2))));
                return str2;
            } catch (Throwable th3) {
                fileOutputStream = null;
                th = th3;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                FileOp.deleteFile(absolutePath);
                throw th;
            }
        }
        i = 0;
        if (i != 0 && FileOp.p(str, str2) < 0) {
            return null;
        }
        context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(new File(str2))));
        return str2;
    }

    protected void onPause() {
        this.qtk = null;
        this.qtl = "";
        this.qtm = null;
        if (this.qtn != null) {
            com.tencent.mm.sdk.b.b ajVar = new aj();
            ajVar.fDJ.activity = (Activity) this.context;
            ajVar.fDJ.fDK = this.qtn;
            com.tencent.mm.sdk.b.a.urY.m(ajVar);
            this.qtn = null;
            this.fFp = 0;
            this.fFo = 0;
        }
    }

    protected final void onDestroy() {
        com.tencent.mm.sdk.b.a.urY.c(this.lHl);
        com.tencent.mm.sdk.b.a.urY.c(this.qtq);
    }

    public alh biS() {
        return null;
    }

    public final void GG(String str) {
        if (FileOp.aO(str)) {
            Intent intent = new Intent();
            w.i("MicroMsg.FlipView", "edit image path:%s", new Object[]{str});
            intent.putExtra("before_photo_edit", str);
            intent.putExtra("from_scene", 293);
            intent.putExtra("after_photo_edit", "");
            intent.putExtra("Retr_Compress_Type", 0);
            intent.putExtra("Retr_Msg_Type", 0);
            intent.putExtra("Retr_FromMainTimeline", biR());
            d.b(this.context, "photoedit", ".ui.MMPhotoEditUI", intent);
        }
    }
}
