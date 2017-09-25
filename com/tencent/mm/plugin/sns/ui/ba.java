package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnDragListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import com.tencent.mm.bl.d;
import com.tencent.mm.e.a.kt;
import com.tencent.mm.e.a.qv;
import com.tencent.mm.modelsns.e;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.ai;
import com.tencent.mm.plugin.sns.model.av;
import com.tencent.mm.plugin.sns.model.b.b;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.protocal.c.bfc;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.c;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.s;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

public class ba implements com.tencent.mm.plugin.sns.model.av.a, b {
    protected String filePath;
    protected p irJ = null;
    public String jia;
    protected ListView mUX;
    private String mwO;
    protected MMPullDownView nxK;
    public int pOu = 0;
    private boolean pRe = false;
    protected LoadingMoreView qJG;
    public int qJH = 0;
    private boolean qJI = false;
    protected boolean qJJ = false;
    public int qJK = 0;
    public a qJL;
    private String qJM;
    com.tencent.mm.modelsns.b qJN = null;
    protected SnsHeader qaU;
    public Activity qb;
    private String qrl;
    private boolean qrm;
    public boolean qrn;
    private int qro;
    protected String title;

    public interface a {
        void Q(int i, boolean z);

        void a(int i, List<Integer> list, List<Integer> list2);

        void biA();

        ListView biB();

        MMPullDownView biC();

        boolean biD();

        void biE();

        void biF();

        void biG();

        int getType();

        void hF(boolean z);
    }

    public ba(Activity activity) {
        this.qb = activity;
    }

    public final void onCreate() {
        this.pOu = this.qb.getWindowManager().getDefaultDisplay().getHeight();
        ae.beI().start();
        this.mUX = this.qJL.biB();
        this.mUX.post(new Runnable(this) {
            final /* synthetic */ ba qJO;

            {
                this.qJO = r1;
            }

            public final void run() {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                this.qJO.qb.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                ae.beA();
                r.cY(displayMetrics.widthPixels, displayMetrics.heightPixels);
            }
        });
        w.i("MicroMsg.SnsActivity", "list is null ? " + (this.mUX != null));
        this.mUX.setScrollingCacheEnabled(false);
        this.qaU = new SnsHeader(this.qb);
        this.qaU.qBC = new com.tencent.mm.plugin.sns.ui.SnsHeader.a(this) {
            final /* synthetic */ ba qJO;

            {
                this.qJO = r1;
            }

            public final boolean dK(long j) {
                if (this.qJO.qrn || this.qJO.qJL.getType() == 1) {
                    this.qJO.ui(2);
                } else {
                    m mVar = new m();
                    mVar.field_snsId = j;
                    mVar.field_userName = this.qJO.jia;
                    bfc JH = e.JH();
                    JH.jNj = this.qJO.jia;
                    mVar.b(JH);
                    m Fk = ai.Fk(this.qJO.jia);
                    w.d("MicroMsg.SnsActivity", "friend like %s", new Object[]{this.qJO.jia});
                    if (Fk == null) {
                        com.tencent.mm.plugin.sns.model.al.a.a(mVar, 1, "");
                    } else if (Fk.bhx()) {
                        com.tencent.mm.plugin.sns.model.al.a.a(mVar, 1, "");
                    } else {
                        com.tencent.mm.plugin.sns.model.al.a.a(mVar, 5, "");
                    }
                    k Gk = ae.beO().Gk(this.qJO.jia);
                    Gk.field_local_flag |= 2;
                    ae.beO().c(Gk);
                    ba baVar = this.qJO;
                    View inflate = LayoutInflater.from(baVar.qb).inflate(g.pFy, (ViewGroup) baVar.qb.findViewById(f.pFy));
                    s sVar = new s(baVar.qb);
                    sVar.setGravity(48, 0, BackwardSupportUtil.b.a(baVar.qb, 200.0f));
                    sVar.duration = 1000;
                    sVar.setView(inflate);
                    sVar.cancel();
                    sVar.fyI.KH();
                    sVar.kor = ((int) (sVar.duration / 70)) + 1;
                    sVar.fyI.v(70, 70);
                }
                return false;
            }

            public final boolean bkm() {
                this.qJO.qJL.biF();
                return false;
            }
        };
        this.qJG = new LoadingMoreView(this.qb);
        this.mUX.addHeaderView(this.qaU);
        this.mUX.addFooterView(this.qJG);
        this.mUX.setOnScrollListener(new OnScrollListener(this) {
            final /* synthetic */ ba qJO;

            {
                this.qJO = r1;
            }

            public final void onScrollStateChanged(AbsListView absListView, int i) {
                this.qJO.qJL.biG();
                if (i == 0) {
                    com.tencent.mm.sdk.b.b qvVar = new qv();
                    qvVar.fXQ.type = 5;
                    qvVar.fXQ.fXR = this.qJO.mUX.getFirstVisiblePosition();
                    qvVar.fXQ.fXS = this.qJO.mUX.getLastVisiblePosition();
                    qvVar.fXQ.fXT = this.qJO.mUX.getHeaderViewsCount();
                    com.tencent.mm.sdk.b.a.urY.m(qvVar);
                    if ((this.qJO.qb instanceof En_424b8e16) && ((En_424b8e16) this.qJO.qb).qri != null) {
                        ((En_424b8e16) this.qJO.qb).qri.bdo();
                    }
                }
                if (i == 2) {
                    d.bOi().cJ(ba.class.getName() + this.qJO.qJL.getType() + ".Listview", 4);
                    this.qJO.hF(true);
                    return;
                }
                this.qJO.hF(false);
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                this.qJO.qJK = (i + i2) - 1;
                if (this.qJO.mUX.getLastVisiblePosition() == this.qJO.mUX.getCount() - 1 && this.qJO.mUX.getCount() != this.qJO.qJH) {
                    w.d("MicroMsg.SnsActivity", "now refresh count: %s", new Object[]{Integer.valueOf(this.qJO.mUX.getCount())});
                    this.qJO.qJH = this.qJO.mUX.getCount();
                    this.qJO.aHl();
                }
            }
        });
        this.nxK = this.qJL.biC();
        w.i("MicroMsg.SnsActivity", "pullDownView is null ? " + (this.nxK != null));
        this.nxK.vln = new MMPullDownView.g(this) {
            final /* synthetic */ ba qJO;

            {
                this.qJO = r1;
            }

            public final boolean akp() {
                this.qJO.qJL.biE();
                return true;
            }
        };
        this.nxK.kR(false);
        this.nxK.kO(false);
        this.nxK.vlz = new c(this) {
            final /* synthetic */ ba qJO;

            {
                this.qJO = r1;
            }

            public final boolean ako() {
                View childAt = this.qJO.mUX.getChildAt(this.qJO.mUX.getChildCount() - 1);
                if (childAt == null || childAt.getBottom() > this.qJO.mUX.getHeight() || this.qJO.mUX.getLastVisiblePosition() != this.qJO.mUX.getAdapter().getCount() - 1) {
                    return false;
                }
                return true;
            }
        };
        this.nxK.vlA = new MMPullDownView.d(this) {
            final /* synthetic */ ba qJO;

            {
                this.qJO = r1;
            }

            public final boolean akn() {
                View childAt = this.qJO.mUX.getChildAt(this.qJO.mUX.getFirstVisiblePosition());
                if (childAt == null || childAt.getTop() != 0) {
                    return false;
                }
                return true;
            }
        };
        this.nxK.kP(false);
        this.nxK.vlo = new MMPullDownView.e(this) {
            final /* synthetic */ ba qJO;

            {
                this.qJO = r1;
            }

            public final boolean akm() {
                w.e("MicroMsg.SnsActivity", "bottomLoad  isAll:" + this.qJO.qJJ);
                if (!this.qJO.qJJ) {
                    this.qJO.aHl();
                }
                return true;
            }
        };
        this.nxK.vlQ = true;
        MMPullDownView mMPullDownView = this.nxK;
        mMPullDownView.bgColor = Color.parseColor("#f4f4f4");
        mMPullDownView.vlS = mMPullDownView.bgColor;
        this.title = this.qb.getIntent().getStringExtra("sns_title");
        SnsHeader snsHeader = this.qaU;
        Object obj = bg.mA(this.jia) ? this.qrl : this.jia;
        String str = this.qrl;
        CharSequence charSequence = this.mwO;
        CharSequence charSequence2 = this.qJM;
        if (obj == null || str == null) {
            w.e("MicroMsg.SnsHeader", "userName or selfName is null ");
        } else {
            snsHeader.userName = obj.trim();
            snsHeader.gKJ = str.trim();
            snsHeader.fJm = str.equals(obj);
            w.d("MicroMsg.SnsHeader", "userNamelen " + obj.length() + "  " + obj);
            snsHeader.qBB.jML.setText(obj);
            if (!(snsHeader.qBB == null || snsHeader.qBB.ioV == null)) {
                com.tencent.mm.pluginsdk.ui.a.b.b(snsHeader.qBB.ioV, snsHeader.userName, true);
            }
            if (obj != null && obj.length() > 0) {
                snsHeader.qBB.jML.setText(h.a(snsHeader.context, i.w(charSequence)));
                snsHeader.qBB.qpz.setText(h.b(snsHeader.context, charSequence2, snsHeader.qBB.qpz.getTextSize()));
            }
            snsHeader.qBB.ioV.setContentDescription(snsHeader.context.getString(j.pKu, new Object[]{snsHeader.qBB.jML.getText()}));
        }
        SnsHeader snsHeader2 = this.qaU;
        int type = this.qJL.getType();
        snsHeader2.type = type;
        if (type == 1 && snsHeader2.qBB.qpz != null) {
            snsHeader2.qBB.qpz.setVisibility(8);
        }
        this.qaU.bkk();
        if (VERSION.SDK_INT < 11) {
            w.d("MicroMsg.SnsActivity", "sdk not support dragdrop event");
        } else {
            new Runnable(this) {
                final /* synthetic */ ba qJO;

                {
                    this.qJO = r1;
                }

                public final void run() {
                    OnDragListener anonymousClass1 = new OnDragListener(this) {
                        final /* synthetic */ AnonymousClass5 qJP;

                        {
                            this.qJP = r1;
                        }

                        public final boolean onDrag(View view, DragEvent dragEvent) {
                            int i = 0;
                            switch (dragEvent.getAction()) {
                                case 1:
                                case 2:
                                case 4:
                                case 5:
                                    w.i("MicroMsg.SnsActivity", "ACTION: [%s]", new Object[]{Integer.valueOf(dragEvent.getAction())});
                                    return true;
                                case 3:
                                    w.i("MicroMsg.SnsActivity", "ACTION_DROP");
                                    ClipData clipData = dragEvent.getClipData();
                                    if (clipData == null) {
                                        return true;
                                    }
                                    int itemCount = clipData.getItemCount();
                                    ArrayList arrayList = new ArrayList();
                                    while (i < itemCount) {
                                        Item itemAt = clipData.getItemAt(i);
                                        if (itemAt == null) {
                                            w.e("MicroMsg.SnsActivity", "item == null");
                                        } else if (itemAt.getIntent() != null) {
                                            this.qJP.qJO.qb.startActivity(itemAt.getIntent());
                                        } else if (itemAt.getUri() != null) {
                                            l lVar = new l(this.qJP.qJO.qb, itemAt.getUri());
                                            if (lVar.fileType != 0 && lVar.filePath != null) {
                                                switch (lVar.fileType) {
                                                    case 3:
                                                        arrayList.add(lVar.filePath);
                                                        break;
                                                    default:
                                                        break;
                                                }
                                            }
                                            w.e("MicroMsg.SnsActivity", "get file path failed");
                                        }
                                        i++;
                                    }
                                    if (arrayList.size() < 0) {
                                        w.e("MicroMsg.SnsActivity", "no image file available");
                                        return true;
                                    }
                                    Intent intent = new Intent(this.qJP.qJO.qb, En_c4f742e5.class);
                                    intent.putExtra("KSnsPostManu", true);
                                    intent.putExtra("KTouchCameraTime", bg.Ny());
                                    intent.putStringArrayListExtra("sns_kemdia_path_list", arrayList);
                                    intent.setAction("android.intent.action.SEND");
                                    intent.addCategory("android.intent.category.DEFAULT");
                                    intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                                    intent.putExtra("android.intent.extra.TEXT", "");
                                    intent.putExtra("Ksnsupload_empty_img", true);
                                    if (this.qJP.qJO.qrn) {
                                        intent.putExtra("Ksnsupload_source", 11);
                                    }
                                    intent.setType("image/*");
                                    this.qJP.qJO.qb.startActivity(intent);
                                    return true;
                                default:
                                    w.e("MicroMsg.SnsActivity", "Unknown action type received by OnDragListener.");
                                    return false;
                            }
                        }
                    };
                    if (this.qJO.qaU != null) {
                        this.qJO.qaU.setOnDragListener(anonymousClass1);
                    }
                }
            }.run();
        }
        ae.beH().gNx.add(this);
        av.pSx++;
        ae.beG().a(this);
    }

    public final void hF(boolean z) {
        this.qJL.hF(z);
    }

    public final void a(String str, String str2, String str3, String str4, boolean z, boolean z2, int i) {
        this.qrl = str;
        this.jia = str2;
        this.mwO = str3;
        this.qJM = str4;
        this.qrm = z;
        this.qrn = z2;
        this.qro = i;
    }

    public static void onResume() {
        ae.beG().N(2, false);
        com.tencent.mm.pluginsdk.wallet.f.xT(7);
        com.tencent.mm.sdk.b.b ktVar = new kt();
        ktVar.fRn.fRo = true;
        com.tencent.mm.sdk.b.a.urY.a(ktVar, Looper.getMainLooper());
        w.d("MicroMsg.SnsActivity", "SnsActivity req pause auto download logic");
    }

    public static void onPause() {
        com.tencent.mm.sdk.b.b ktVar = new kt();
        ktVar.fRn.fRo = false;
        com.tencent.mm.sdk.b.a.urY.a(ktVar, Looper.getMainLooper());
        w.d("MicroMsg.SnsActivity", "AppAttachDownloadUI cancel pause auto download logic");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final void onActivityResult(int r11, int r12, android.content.Intent r13) {
        /*
        r10 = this;
        r0 = "MicroMsg.SnsActivity";
        r1 = new java.lang.StringBuilder;
        r2 = "onAcvityResult requestCode:";
        r1.<init>(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.w.i(r0, r1);
        r0 = -1;
        if (r12 == r0) goto L_0x0034;
    L_0x0019:
        r0 = 5;
        if (r11 == r0) goto L_0x0022;
    L_0x001c:
        r0 = 2;
        if (r11 == r0) goto L_0x0022;
    L_0x001f:
        r0 = 4;
        if (r11 != r0) goto L_0x0033;
    L_0x0022:
        r0 = new com.tencent.mm.sdk.platformtools.ae;
        r1 = android.os.Looper.getMainLooper();
        r0.<init>(r1);
        r1 = new com.tencent.mm.plugin.sns.ui.ba$12;
        r1.<init>(r10);
        r0.post(r1);
    L_0x0033:
        return;
    L_0x0034:
        switch(r11) {
            case 2: goto L_0x0160;
            case 3: goto L_0x0037;
            case 4: goto L_0x0415;
            case 5: goto L_0x00fb;
            case 6: goto L_0x0425;
            case 7: goto L_0x0448;
            case 8: goto L_0x045f;
            case 9: goto L_0x0481;
            case 10: goto L_0x048f;
            case 11: goto L_0x0037;
            case 12: goto L_0x04d6;
            case 13: goto L_0x04fd;
            case 14: goto L_0x01c1;
            case 15: goto L_0x0033;
            case 16: goto L_0x0037;
            case 17: goto L_0x0041;
            default: goto L_0x0037;
        };
    L_0x0037:
        r0 = "MicroMsg.SnsActivity";
        r1 = "onActivityResult: not found this requestCode";
        com.tencent.mm.sdk.platformtools.w.e(r0, r1);
        goto L_0x0033;
    L_0x0041:
        r0 = "key_req_result";
        r0 = r13.getParcelableExtra(r0);
        r0 = (com.tencent.mm.plugin.mmsight.SightCaptureResult) r0;
        if (r0 == 0) goto L_0x0033;
    L_0x004c:
        r1 = r0.nAu;
        if (r1 == 0) goto L_0x0063;
    L_0x0050:
        r0 = r0.nAC;
        r10.filePath = r0;
        r0 = r10.filePath;
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r0 != 0) goto L_0x0033;
    L_0x005c:
        r0 = 1;
        r10.pRe = r0;
        r10.Q(r13);
        goto L_0x0033;
    L_0x0063:
        r1 = "MicroMsg.SnsActivity";
        r2 = "video path %s thumb path ";
        r3 = 2;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r5 = r0.nAw;
        r3[r4] = r5;
        r4 = 1;
        r5 = r0.nAx;
        r3[r4] = r5;
        com.tencent.mm.sdk.platformtools.w.i(r1, r2, r3);
        r1 = new android.content.Intent;
        r1.<init>();
        r2 = "KSightPath";
        r3 = r0.nAw;
        r1.putExtra(r2, r3);
        r2 = "KSightThumbPath";
        r3 = r0.nAx;
        r1.putExtra(r2, r3);
        r2 = r0.nAz;
        r2 = com.tencent.mm.sdk.platformtools.bg.mA(r2);
        if (r2 != 0) goto L_0x00d9;
    L_0x0096:
        r2 = "sight_md5";
        r3 = r0.nAz;
        r1.putExtra(r2, r3);
    L_0x009e:
        r2 = "KSnsPostManu";
        r3 = 1;
        r1.putExtra(r2, r3);
        r2 = "KTouchCameraTime";
        r4 = com.tencent.mm.sdk.platformtools.bg.Ny();
        r1.putExtra(r2, r4);
        r2 = "Ksnsupload_type";
        r3 = 14;
        r1.putExtra(r2, r3);
        r2 = "Kis_take_photo";
        r3 = 0;
        r1.putExtra(r2, r3);
        r0 = r0.nAB;	 Catch:{ Exception -> 0x00e6 }
        r0 = r0.toByteArray();	 Catch:{ Exception -> 0x00e6 }
        if (r0 == 0) goto L_0x00cc;
    L_0x00c6:
        r2 = "KMMSightExtInfo";
        r1.putExtra(r2, r0);	 Catch:{ Exception -> 0x00e6 }
    L_0x00cc:
        r0 = r10.qb;
        r2 = "sns";
        r3 = ".ui.En_c4f742e5";
        com.tencent.mm.bb.d.b(r0, r2, r3, r1);
        goto L_0x0033;
    L_0x00d9:
        r2 = "sight_md5";
        r3 = r0.nAw;
        r3 = com.tencent.mm.a.g.aV(r3);
        r1.putExtra(r2, r3);
        goto L_0x009e;
    L_0x00e6:
        r0 = move-exception;
        r2 = "MicroMsg.SnsActivity";
        r3 = "put sight extinfo to snsuploadui error: %s";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r0 = r0.getMessage();
        r4[r5] = r0;
        com.tencent.mm.sdk.platformtools.w.i(r2, r3, r4);
        goto L_0x00cc;
    L_0x00fb:
        r0 = r10.qb;
        r0 = r0.getApplicationContext();
        r1 = com.tencent.mm.plugin.sns.model.ae.getAccSnsTmpPath();
        r0 = com.tencent.mm.pluginsdk.ui.tools.k.b(r0, r13, r1);
        r10.filePath = r0;
        r0 = "MicroMsg.SnsActivity";
        r1 = new java.lang.StringBuilder;
        r2 = "onActivityResult CONTEXT_TAKE_PHOTO  filePath";
        r1.<init>(r2);
        r2 = r10.filePath;
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.w.d(r0, r1);
        r0 = r10.filePath;
        if (r0 == 0) goto L_0x0033;
    L_0x0127:
        com.tencent.mm.kernel.h.vJ();
        r0 = com.tencent.mm.kernel.h.vI();
        r0 = r0.vr();
        r1 = 68392; // 0x10b28 float:9.5838E-41 double:3.379E-319;
        r2 = 0;
        r0 = r0.get(r1, r2);
        r0 = (java.lang.Integer) r0;
        r1 = 0;
        r0 = com.tencent.mm.sdk.platformtools.bg.a(r0, r1);
        com.tencent.mm.kernel.h.vJ();
        r1 = com.tencent.mm.kernel.h.vI();
        r1 = r1.vr();
        r2 = 68392; // 0x10b28 float:9.5838E-41 double:3.379E-319;
        r0 = r0 + 1;
        r0 = java.lang.Integer.valueOf(r0);
        r1.set(r2, r0);
        r0 = 1;
        r10.pRe = r0;
        r10.Q(r13);
        goto L_0x0033;
    L_0x0160:
        if (r13 == 0) goto L_0x0033;
    L_0x0162:
        com.tencent.mm.kernel.h.vJ();
        r0 = com.tencent.mm.kernel.h.vI();
        r0 = r0.vr();
        r1 = 68393; // 0x10b29 float:9.5839E-41 double:3.37906E-319;
        r2 = 0;
        r0 = r0.get(r1, r2);
        r0 = (java.lang.Integer) r0;
        r1 = 0;
        r0 = com.tencent.mm.sdk.platformtools.bg.a(r0, r1);
        com.tencent.mm.kernel.h.vJ();
        r1 = com.tencent.mm.kernel.h.vI();
        r1 = r1.vr();
        r2 = 68393; // 0x10b29 float:9.5839E-41 double:3.37906E-319;
        r0 = r0 + 1;
        r0 = java.lang.Integer.valueOf(r0);
        r1.set(r2, r0);
        r3 = new android.content.Intent;
        r3.<init>();
        r0 = "CropImageMode";
        r1 = 4;
        r3.putExtra(r0, r1);
        r0 = "CropImage_Filter";
        r1 = 1;
        r3.putExtra(r0, r1);
        r0 = "CropImage_DirectlyIntoFilter";
        r1 = 1;
        r3.putExtra(r0, r1);
        r0 = com.tencent.mm.plugin.sns.c.a.imv;
        r1 = r10.qb;
        r4 = com.tencent.mm.plugin.sns.model.ae.getAccSnsTmpPath();
        r5 = 4;
        r6 = new com.tencent.mm.plugin.sns.ui.ba$13;
        r6.<init>(r10);
        r2 = r13;
        r0.a(r1, r2, r3, r4, r5, r6);
        goto L_0x0033;
    L_0x01c1:
        r0 = new com.tencent.mm.sdk.platformtools.ae;
        r1 = android.os.Looper.getMainLooper();
        r0.<init>(r1);
        r1 = new com.tencent.mm.plugin.sns.ui.ba$2;
        r1.<init>(r10);
        r0.post(r1);
        r0 = "key_select_video_list";
        r0 = r13.getStringArrayListExtra(r0);
        if (r0 == 0) goto L_0x01e1;
    L_0x01db:
        r1 = r0.size();
        if (r1 > 0) goto L_0x01ee;
    L_0x01e1:
        r1 = "K_SEGMENTVIDEOPATH";
        r1 = r13.getStringExtra(r1);
        r1 = com.tencent.mm.sdk.platformtools.bg.mA(r1);
        if (r1 != 0) goto L_0x0332;
    L_0x01ee:
        if (r0 == 0) goto L_0x024a;
    L_0x01f0:
        r1 = r0.size();
        if (r1 <= 0) goto L_0x024a;
    L_0x01f6:
        r1 = 0;
        r0 = r0.get(r1);
        r0 = (java.lang.String) r0;
    L_0x01fd:
        r1 = "KSEGMENTVIDEOTHUMBPATH";
        r1 = r13.getStringExtra(r1);
        r2 = com.tencent.mm.sdk.platformtools.bg.mA(r1);
        if (r2 != 0) goto L_0x0210;
    L_0x020a:
        r2 = com.tencent.mm.modelsfs.FileOp.aO(r1);
        if (r2 != 0) goto L_0x02a1;
    L_0x0210:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = com.tencent.mm.plugin.sns.model.ae.getAccSnsTmpPath();
        r1 = r1.append(r2);
        r2 = com.tencent.mm.a.g.aV(r0);
        r1 = r1.append(r2);
        r1 = r1.toString();
        r3 = new android.media.MediaMetadataRetriever;
        r3.<init>();
        r3.setDataSource(r0);	 Catch:{ Exception -> 0x0311 }
        r4 = 0;
        r2 = r3.getFrameAtTime(r4);	 Catch:{ Exception -> 0x0311 }
        if (r2 != 0) goto L_0x0252;
    L_0x0239:
        r2 = "MicroMsg.SnsActivity";
        r4 = "get bitmap error";
        com.tencent.mm.sdk.platformtools.w.e(r2, r4);	 Catch:{ Exception -> 0x0311 }
        r3.release();	 Catch:{ Exception -> 0x0247 }
        goto L_0x0033;
    L_0x0247:
        r0 = move-exception;
        goto L_0x0033;
    L_0x024a:
        r0 = "K_SEGMENTVIDEOPATH";
        r0 = r13.getStringExtra(r0);
        goto L_0x01fd;
    L_0x0252:
        r4 = "MicroMsg.SnsActivity";
        r5 = "getBitmap1 %d %d";
        r6 = 2;
        r6 = new java.lang.Object[r6];	 Catch:{ Exception -> 0x0311 }
        r7 = 0;
        r8 = r2.getWidth();	 Catch:{ Exception -> 0x0311 }
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ Exception -> 0x0311 }
        r6[r7] = r8;	 Catch:{ Exception -> 0x0311 }
        r7 = 1;
        r8 = r2.getHeight();	 Catch:{ Exception -> 0x0311 }
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ Exception -> 0x0311 }
        r6[r7] = r8;	 Catch:{ Exception -> 0x0311 }
        com.tencent.mm.sdk.platformtools.w.i(r4, r5, r6);	 Catch:{ Exception -> 0x0311 }
        r4 = 80;
        r5 = android.graphics.Bitmap.CompressFormat.JPEG;	 Catch:{ Exception -> 0x0311 }
        r6 = 1;
        com.tencent.mm.sdk.platformtools.d.a(r2, r4, r5, r1, r6);	 Catch:{ Exception -> 0x0311 }
        r2 = com.tencent.mm.sdk.platformtools.d.Pe(r1);	 Catch:{ Exception -> 0x0311 }
        r4 = "MicroMsg.SnsActivity";
        r5 = "getBitmap2 %d %d";
        r6 = 2;
        r6 = new java.lang.Object[r6];	 Catch:{ Exception -> 0x0311 }
        r7 = 0;
        r8 = r2.outWidth;	 Catch:{ Exception -> 0x0311 }
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ Exception -> 0x0311 }
        r6[r7] = r8;	 Catch:{ Exception -> 0x0311 }
        r7 = 1;
        r2 = r2.outHeight;	 Catch:{ Exception -> 0x0311 }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ Exception -> 0x0311 }
        r6[r7] = r2;	 Catch:{ Exception -> 0x0311 }
        com.tencent.mm.sdk.platformtools.w.i(r4, r5, r6);	 Catch:{ Exception -> 0x0311 }
        r3.release();	 Catch:{ Exception -> 0x0506 }
    L_0x02a1:
        r2 = "MicroMsg.SnsActivity";
        r3 = "video path %s thumb path %s and %s %s ";
        r4 = 4;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r4[r5] = r0;
        r5 = 1;
        r4[r5] = r1;
        r5 = 2;
        r6 = com.tencent.mm.modelsfs.FileOp.ki(r0);
        r6 = java.lang.Long.valueOf(r6);
        r4[r5] = r6;
        r5 = 3;
        r6 = com.tencent.mm.modelsfs.FileOp.ki(r1);
        r6 = java.lang.Long.valueOf(r6);
        r4[r5] = r6;
        com.tencent.mm.sdk.platformtools.w.i(r2, r3, r4);
        r2 = new android.content.Intent;
        r2.<init>();
        r3 = "KSightPath";
        r2.putExtra(r3, r0);
        r3 = "KSightThumbPath";
        r2.putExtra(r3, r1);
        r1 = "sight_md5";
        r0 = com.tencent.mm.a.g.aV(r0);
        r2.putExtra(r1, r0);
        r0 = "KSnsPostManu";
        r1 = 1;
        r2.putExtra(r0, r1);
        r0 = "KTouchCameraTime";
        r4 = com.tencent.mm.sdk.platformtools.bg.Ny();
        r2.putExtra(r0, r4);
        r0 = "Ksnsupload_type";
        r1 = 14;
        r2.putExtra(r0, r1);
        r0 = "Kis_take_photo";
        r1 = 0;
        r2.putExtra(r0, r1);
        r0 = r10.qb;
        r1 = "sns";
        r3 = ".ui.En_c4f742e5";
        com.tencent.mm.bb.d.b(r0, r1, r3, r2);
        goto L_0x0033;
    L_0x0311:
        r2 = move-exception;
        r4 = "MicroMsg.SnsActivity";
        r5 = "savebitmap error %s";
        r6 = 1;
        r6 = new java.lang.Object[r6];	 Catch:{ all -> 0x032d }
        r7 = 0;
        r2 = r2.getMessage();	 Catch:{ all -> 0x032d }
        r6[r7] = r2;	 Catch:{ all -> 0x032d }
        com.tencent.mm.sdk.platformtools.w.e(r4, r5, r6);	 Catch:{ all -> 0x032d }
        r3.release();	 Catch:{ Exception -> 0x032a }
        goto L_0x02a1;
    L_0x032a:
        r2 = move-exception;
        goto L_0x02a1;
    L_0x032d:
        r0 = move-exception;
        r3.release();	 Catch:{ Exception -> 0x0509 }
    L_0x0331:
        throw r0;
    L_0x0332:
        r0 = "CropImage_OutputPath_List";
        r1 = r13.getStringArrayListExtra(r0);
        if (r1 == 0) goto L_0x0341;
    L_0x033b:
        r0 = r1.size();
        if (r0 != 0) goto L_0x034c;
    L_0x0341:
        r0 = "MicroMsg.SnsActivity";
        r1 = "no image selected";
        com.tencent.mm.sdk.platformtools.w.i(r0, r1);
        goto L_0x0033;
    L_0x034c:
        r2 = new java.util.ArrayList;
        r2.<init>();
        r3 = r1.iterator();
    L_0x0355:
        r0 = r3.hasNext();
        if (r0 == 0) goto L_0x038e;
    L_0x035b:
        r0 = r3.next();
        r0 = (java.lang.String) r0;
        r4 = com.tencent.mm.compatible.util.Exif.fromFile(r0);
        r4 = r4.getLocation();
        if (r4 == 0) goto L_0x0355;
    L_0x036b:
        r5 = "%s\n%f\n%f";
        r6 = 3;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r6[r7] = r0;
        r0 = 1;
        r8 = r4.latitude;
        r7 = java.lang.Double.valueOf(r8);
        r6[r0] = r7;
        r0 = 2;
        r8 = r4.longitude;
        r4 = java.lang.Double.valueOf(r8);
        r6[r0] = r4;
        r0 = java.lang.String.format(r5, r6);
        r2.add(r0);
        goto L_0x0355;
    L_0x038e:
        r0 = "isTakePhoto";
        r3 = 0;
        r0 = r13.getBooleanExtra(r0, r3);
        r10.pRe = r0;
        r0 = new android.content.Intent;
        r3 = r10.qb;
        r4 = com.tencent.mm.plugin.sns.ui.En_c4f742e5.class;
        r0.<init>(r3, r4);
        r3 = "KSnsPostManu";
        r4 = 1;
        r0.putExtra(r3, r4);
        r3 = "KTouchCameraTime";
        r4 = com.tencent.mm.sdk.platformtools.bg.Ny();
        r0.putExtra(r3, r4);
        r3 = r10.qJN;
        if (r3 == 0) goto L_0x03c1;
    L_0x03b6:
        r3 = r10.qJN;
        r4 = "intent_key_StatisticsOplog";
        r3.b(r0, r4);
        r3 = 0;
        r10.qJN = r3;
    L_0x03c1:
        r3 = r10.qrn;
        if (r3 == 0) goto L_0x03cd;
    L_0x03c5:
        r3 = "Ksnsupload_source";
        r4 = 11;
        r0.putExtra(r3, r4);
    L_0x03cd:
        r3 = "CropImage_filterId";
        r4 = 0;
        r3 = r13.getIntExtra(r3, r4);
        r4 = "sns_kemdia_path_list";
        r0.putExtra(r4, r1);
        r1 = "KFilterId";
        r0.putExtra(r1, r3);
        r1 = r10.pRe;
        if (r1 == 0) goto L_0x03ec;
    L_0x03e5:
        r1 = "Kis_take_photo";
        r3 = 1;
        r0.putExtra(r1, r3);
    L_0x03ec:
        r1 = "sns_media_latlong_list";
        r0.putStringArrayListExtra(r1, r2);
        r1 = "MicroMsg.SnsActivity";
        r2 = "shared type %d";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r5 = "Ksnsupload_type";
        r6 = -1;
        r5 = r0.getIntExtra(r5, r6);
        r5 = java.lang.Integer.valueOf(r5);
        r3[r4] = r5;
        com.tencent.mm.sdk.platformtools.w.d(r1, r2, r3);
        r1 = r10.qb;
        r2 = 6;
        r1.startActivityForResult(r0, r2);
        goto L_0x0033;
    L_0x0415:
        if (r13 == 0) goto L_0x0033;
    L_0x0417:
        r0 = "CropImage_OutputPath";
        r0 = r13.getStringExtra(r0);
        r10.filePath = r0;
        r10.Q(r13);
        goto L_0x0033;
    L_0x0425:
        r0 = "MicroMsg.SnsActivity";
        r1 = "onActivityResult CONTEXT_UPLOAD_MEDIA";
        com.tencent.mm.sdk.platformtools.w.d(r0, r1);
        if (r13 == 0) goto L_0x0033;
    L_0x0430:
        r0 = "sns_local_id";
        r1 = -1;
        r0 = r13.getIntExtra(r0, r1);
        r1 = r10.qJL;
        r2 = 0;
        r3 = 0;
        r1.a(r0, r2, r3);
        r0 = com.tencent.mm.plugin.sns.model.ae.beH();
        r0.bdz();
        goto L_0x0033;
    L_0x0448:
        r0 = "MicroMsg.SnsActivity";
        r1 = "onActivityResult CONTEXT_CHANGE_BG";
        com.tencent.mm.sdk.platformtools.w.d(r0, r1);
        r0 = r10.qaU;
        r0.bkk();
        r0 = com.tencent.mm.plugin.sns.model.ae.beH();
        r0.bdz();
        goto L_0x0033;
    L_0x045f:
        if (r13 == 0) goto L_0x0033;
    L_0x0461:
        r0 = "MicroMsg.SnsActivity";
        r1 = "onActivityResult CONTEXT_GALLERY_OP";
        com.tencent.mm.sdk.platformtools.w.d(r0, r1);
        r0 = "sns_cmd_list";
        r0 = r13.getParcelableExtra(r0);
        r0 = (com.tencent.mm.plugin.sns.data.SnsCmdList) r0;
        if (r0 == 0) goto L_0x0033;
    L_0x0475:
        r1 = r10.qJL;
        r2 = -1;
        r3 = r0.pQP;
        r0 = r0.pQQ;
        r1.a(r2, r3, r0);
        goto L_0x0033;
    L_0x0481:
        r0 = com.tencent.mm.plugin.sns.model.ae.beH();
        r0.bdz();
        r0 = r10.mUX;
        com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c.a(r0);
        goto L_0x0033;
    L_0x048f:
        if (r13 == 0) goto L_0x0033;
    L_0x0491:
        r0 = -1;
        if (r12 != r0) goto L_0x0033;
    L_0x0494:
        r1 = r13.getData();
        r0 = r10.qb;
        r2 = 0;
        r3 = 0;
        r4 = 0;
        r5 = 0;
        r0 = r0.managedQuery(r1, r2, r3, r4, r5);
        r1 = r0.moveToFirst();
        if (r1 == 0) goto L_0x0033;
    L_0x04a8:
        r1 = "_id";
        r1 = r0.getColumnIndexOrThrow(r1);
        r0 = r0.getString(r1);
        r1 = new android.content.Intent;
        r2 = "android.intent.action.EDIT";
        r3 = new java.lang.StringBuilder;
        r4 = "content://com.android.contacts/contacts/";
        r3.<init>(r4);
        r0 = r3.append(r0);
        r0 = r0.toString();
        r0 = android.net.Uri.parse(r0);
        r1.<init>(r2, r0);
        r0 = r10.qb;
        r0.startActivity(r1);
        goto L_0x0033;
    L_0x04d6:
        r0 = "sns_gallery_op_id";
        r1 = -1;
        r0 = r13.getIntExtra(r0, r1);
        if (r0 <= 0) goto L_0x0033;
    L_0x04e0:
        r1 = "MicroMsg.SnsActivity";
        r2 = "notify cause by del item";
        com.tencent.mm.sdk.platformtools.w.d(r1, r2);
        r1 = new com.tencent.mm.plugin.sns.data.SnsCmdList;
        r1.<init>();
        r1.sO(r0);
        r0 = r10.qJL;
        r2 = -1;
        r3 = r1.pQP;
        r1 = r1.pQQ;
        r0.a(r2, r3, r1);
        goto L_0x0033;
    L_0x04fd:
        r0 = com.tencent.mm.plugin.sns.model.ae.beP();
        r0.afV();
        goto L_0x0033;
    L_0x0506:
        r2 = move-exception;
        goto L_0x02a1;
    L_0x0509:
        r1 = move-exception;
        goto L_0x0331;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.ui.ba.onActivityResult(int, int, android.content.Intent):void");
    }

    private void Q(Intent intent) {
        new com.tencent.mm.sdk.platformtools.ae(Looper.getMainLooper()).post(new Runnable(this) {
            final /* synthetic */ ba qJO;

            {
                this.qJO = r1;
            }

            public final void run() {
                com.tencent.mm.plugin.sns.c.a.imw.ow();
            }
        });
        w.d("MicroMsg.SnsActivity", "onActivityResult CONTEXT_CHOSE_IMAGE_CONFIRM");
        w.d("MicroMsg.SnsActivity", "CONTEXT_CHOSE_IMAGE_CONFIRM filePath " + this.filePath);
        if (this.filePath != null) {
            int intExtra;
            String str = "pre_temp_sns_pic" + com.tencent.mm.a.g.n((this.filePath + System.currentTimeMillis()).getBytes());
            r.T(ae.getAccSnsTmpPath(), this.filePath, str);
            this.filePath = ae.getAccSnsTmpPath() + str;
            w.d("MicroMsg.SnsActivity", "newPath " + this.filePath);
            if (intent != null) {
                intExtra = intent.getIntExtra("CropImage_filterId", 0);
            } else {
                intExtra = 0;
            }
            Intent intent2 = new Intent(this.qb, En_c4f742e5.class);
            intent2.putExtra("KSnsPostManu", true);
            intent2.putExtra("KTouchCameraTime", bg.Ny());
            if (this.qJN != null) {
                this.qJN.b(intent2, "intent_key_StatisticsOplog");
                this.qJN = null;
            }
            intent2.putExtra("sns_kemdia_path", this.filePath);
            intent2.putExtra("KFilterId", intExtra);
            if (this.pRe) {
                intent2.putExtra("Kis_take_photo", true);
            }
            if (this.qrn) {
                intent2.putExtra("Ksnsupload_source", 11);
            }
            this.qb.startActivityForResult(intent2, 6);
            this.pRe = false;
        }
    }

    protected final boolean ui(final int i) {
        int i2 = 3;
        com.tencent.mm.kernel.h.vJ();
        if (com.tencent.mm.kernel.h.vI().isSDCardAvailable()) {
            w.d("MicroMsg.SnsActivity", "selectPhoto " + i);
            if (i == 2) {
                Intent intent = new Intent();
                intent.putExtra("username", this.qrl);
                intent.setClass(this.qb, SettingSnsBackgroundUI.class);
                this.qb.startActivityForResult(intent, 7);
                return true;
            } else if (i != 1) {
                return true;
            } else {
                com.tencent.mm.kernel.h.vJ();
                int a = bg.a((Integer) com.tencent.mm.kernel.h.vI().vr().get(68385, null), 0);
                com.tencent.mm.kernel.h.vJ();
                int a2 = bg.a((Integer) com.tencent.mm.kernel.h.vI().vr().get(68386, null), 0);
                if (!this.qJI && a < 3 && a2 == 0) {
                    this.qJI = true;
                    Context context = this.qb;
                    OnClickListener anonymousClass4 = new OnClickListener(this) {
                        final /* synthetic */ ba qJO;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            com.tencent.mm.kernel.h.vJ();
                            int a = bg.a((Integer) com.tencent.mm.kernel.h.vI().vr().get(68386, null), 0) + 1;
                            com.tencent.mm.kernel.h.vJ();
                            com.tencent.mm.kernel.h.vI().vr().set(68386, Integer.valueOf(a));
                            this.qJO.ui(i);
                        }
                    };
                    com.tencent.mm.ui.base.h.a aVar = new com.tencent.mm.ui.base.h.a(context);
                    aVar.zW(j.pMY);
                    aVar.SX(context.getString(j.pMZ) + "\n\n" + context.getString(j.pNa));
                    aVar.zZ(j.pNe).a(anonymousClass4);
                    aVar.a(new OnDismissListener() {
                        public final void onDismiss(DialogInterface dialogInterface) {
                            com.tencent.mm.kernel.h.vJ();
                            int a = bg.a((Integer) com.tencent.mm.kernel.h.vI().vr().get(68385, null), 0) + 1;
                            com.tencent.mm.kernel.h.vJ();
                            com.tencent.mm.kernel.h.vI().vr().set(68385, Integer.valueOf(a));
                        }
                    });
                    aVar.WJ().show();
                    return true;
                } else if (this.qb.getSharedPreferences(ab.bIX(), 0).getString("gallery", "1").equalsIgnoreCase("0")) {
                    com.tencent.mm.pluginsdk.ui.tools.k.a(this.qb, 2, null);
                    return true;
                } else {
                    a2 = com.tencent.mm.i.g.sV().getInt("SnsCanPickVideoFromAlbum", 1);
                    w.i("MicroMsg.SnsActivity", "takeVideo %d", new Object[]{Integer.valueOf(a2)});
                    if (com.tencent.mm.platformtools.r.ijS) {
                        a2 = 0;
                    }
                    if (a2 != 1 && a2 == 0) {
                        i2 = 1;
                    }
                    com.tencent.mm.pluginsdk.ui.tools.k.a(this.qb, 14, 9, 4, i2, false, null);
                    return true;
                }
            }
        }
        s.eP(this.qb);
        return false;
    }

    public final void onDestroy() {
        if (this.qaU != null) {
            SnsHeader snsHeader = this.qaU;
            if (!(snsHeader.qBG == null || snsHeader.qBG.isRecycled())) {
                snsHeader.qBG.recycle();
            }
        }
        com.tencent.mm.kernel.h.vJ();
        if (com.tencent.mm.kernel.h.vG().uV()) {
            ae.beI().Q(this.qb);
            ae.beG().b(this);
        }
        if (this.irJ != null) {
            this.irJ.dismiss();
            this.irJ = null;
        }
        com.tencent.mm.kernel.h.vJ();
        if (com.tencent.mm.kernel.h.vG().uV()) {
            ae.beH().gNx.remove(this);
            av.pSx--;
        }
        this.qJG.setVisibility(8);
        aa.bjf();
        ae.beI().start();
        this.mUX.setAdapter(null);
    }

    public final void ES(String str) {
    }

    public final void ap(String str, boolean z) {
    }

    public final void bdD() {
        this.qaU.bkk();
    }

    public final void aHl() {
        this.qJL.biA();
    }

    protected final void hG(boolean z) {
        w.d("MicroMsg.SnsActivity", "snsactivty onIsAll ");
        this.qJG.hG(z);
    }

    protected final void tO(int i) {
        w.d("MicroMsg.SnsActivity", "snsactivty onIsRecent ");
        this.qJG.tO(i);
    }

    public final void Q(int i, boolean z) {
        this.qJL.Q(i, z);
    }

    public final void bfu() {
        if (this.qaU != null) {
            this.qaU.bkk();
        }
    }

    public final void ao(String str, boolean z) {
        if (this.qJL.getType() == 1 && this.mUX != null && this.mUX.getAdapter() != null && (this.mUX.getAdapter() instanceof aw)) {
            ((aw) this.mUX.getAdapter()).notifyDataSetChanged();
        }
    }

    public final ListView biB() {
        return this.qJL.biB();
    }
}
