package com.tencent.mm.ui.chatting.gallery;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.view.ViewPager;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.e.a.ak;
import com.tencent.mm.e.a.aq;
import com.tencent.mm.e.a.bx;
import com.tencent.mm.e.a.dd;
import com.tencent.mm.e.a.gg;
import com.tencent.mm.e.a.jp;
import com.tencent.mm.e.a.lw;
import com.tencent.mm.e.a.ly;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMViewPager;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.chatting.En_5b8fbb1e;
import com.tencent.mm.ui.mogic.WxViewPager;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.ui.widget.e;
import com.tencent.mm.ui.x;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

@com.tencent.mm.ui.base.a(3)
public class ImageGalleryUI extends MMActivity implements OnClickListener, com.tencent.mm.sdk.platformtools.aj.a {
    protected String chatroomName;
    public long fGM;
    protected String fJL;
    private int iYK;
    private int iYL;
    private d kTc = new d(this) {
        final /* synthetic */ ImageGalleryUI vSz;

        {
            this.vSz = r1;
        }

        public final void c(MenuItem menuItem, int i) {
            ce bWK;
            r lH;
            switch (menuItem.getItemId()) {
                case 0:
                    bWK = this.vSz.vPU.bWK();
                    if (bWK == null || !bWK.bMl()) {
                        this.vSz.vPU.Bn(this.vSz.mho.ys);
                        return;
                    }
                    lH = t.lH(bWK.field_imgPath);
                    if (lH.status == 199 || lH.status == 199) {
                        this.vSz.vPU.Bn(this.vSz.mho.ys);
                        return;
                    }
                    this.vSz.vSk = t.e(bWK.field_msgId, 1);
                    this.vSz.vPU.Bs(this.vSz.mho.ys);
                    return;
                case 1:
                    bWK = this.vSz.vPU.bWK();
                    if (bWK == null || !bWK.bMl()) {
                        List arrayList = new ArrayList();
                        arrayList.add(this.vSz.vPU.bWK());
                        b.hUp.y((au) arrayList.get(0));
                        b.c(this.vSz.uSU.uTo, arrayList);
                        return;
                    }
                    lH = t.lH(bWK.field_imgPath);
                    if (lH.status == 199 || lH.status == 199) {
                        List arrayList2 = new ArrayList();
                        arrayList2.add(this.vSz.vPU.bWK());
                        b.c(this.vSz.uSU.uTo, arrayList2);
                        return;
                    }
                    this.vSz.vSk = t.e(bWK.field_msgId, 2);
                    this.vSz.vPU.Bs(this.vSz.mho.ys);
                    return;
                case 2:
                    if (com.tencent.mm.bb.d.Jt("favorite")) {
                        this.vSz.vPU.Bp(this.vSz.mho.ys);
                        return;
                    }
                    return;
                case 3:
                    w.i("MicroMsg.ImageGalleryUI", "request deal QBAR string");
                    bx bxVar = new bx();
                    bxVar.fFn.activity = this.vSz;
                    bxVar.fFn.fDK = this.vSz.qtn;
                    bxVar.fFn.fFo = this.vSz.iYK;
                    bxVar.fFn.fFp = this.vSz.iYL;
                    bxVar.fFn.scene = 37;
                    bxVar.fFn.fFu = this.vSz.getIntent().getBundleExtra("_stat_obj");
                    ImageGalleryUI.a(this.vSz, bxVar);
                    ImageGalleryUI.b(this.vSz, bxVar);
                    com.tencent.mm.sdk.b.a.urY.m(bxVar);
                    return;
                case 4:
                    this.vSz.vPU.Bo(this.vSz.mho.ys);
                    return;
                case 5:
                    ImageGalleryUI.x(this.vSz);
                    return;
                case 6:
                    if (b.aR(this.vSz.vPU.bWK())) {
                        this.vSz.bXq();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    public long kbc;
    Bundle klH;
    private boolean klI = false;
    g klJ;
    int klK = 0;
    int klL = 0;
    int klM = 0;
    int klN = 0;
    private c lHl = new c<ly>(this) {
        final /* synthetic */ ImageGalleryUI vSz;

        {
            this.vSz = r2;
            this.usg = ly.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            ly lyVar = (ly) bVar;
            if (this.vSz.qtj == null || this.vSz.qtk == null) {
                w.e("MicroMsg.ImageGalleryUI", "not in recoging");
            } else if (lyVar == null || !(lyVar instanceof ly)) {
                w.e("MicroMsg.ImageGalleryUI", "receive invalid callbak");
            } else if (lyVar == null || lyVar.fTe.filePath.equals(this.vSz.qtk)) {
                w.i("MicroMsg.ImageGalleryUI", "recog result: " + lyVar.fTe.result);
                if (!bg.mA(lyVar.fTe.result)) {
                    this.vSz.qtn = lyVar.fTe.result;
                    this.vSz.iYK = lyVar.fTe.fFo;
                    this.vSz.iYL = lyVar.fTe.fFp;
                    if (!(this.vSz.qtn == null || this.vSz.qtj == null)) {
                        this.vSz.qto = true;
                    }
                    this.vSz.ls(false);
                }
                this.vSz.qtk = null;
            } else {
                w.e("MicroMsg.ImageGalleryUI", "not same filepath");
            }
            return false;
        }
    };
    private ImageView lMk;
    private ae mHandler = new ae(Looper.getMainLooper());
    protected MMViewPager mho;
    private boolean nAn;
    private e qtj;
    private String qtk;
    private String qtn;
    private boolean qto = false;
    private c qtq = new c<jp>(this) {
        final /* synthetic */ ImageGalleryUI vSz;

        {
            this.vSz = r2;
            this.usg = jp.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            jp jpVar = (jp) bVar;
            if (jpVar != null && (jpVar instanceof jp)) {
                w.i("MicroMsg.ImageGalleryUI", "notify Event: %d", Integer.valueOf(jpVar.fQb.fPZ));
                if (jpVar.fQb.activity == this.vSz && jpVar.fQb.fDK.equals(this.vSz.qtn)) {
                    switch (jpVar.fQb.fPZ) {
                        case 0:
                        case 1:
                        case 2:
                            break;
                        case 3:
                            this.vSz.finish();
                            break;
                        default:
                            break;
                    }
                }
                w.e("MicroMsg.ImageGalleryUI", "not the same");
            } else {
                w.e("MicroMsg.ImageGalleryUI", "event is null or not a instant of NotifyDealQBarStrResultEvent");
            }
            return false;
        }
    };
    int qzi;
    int qzj;
    int qzk = 0;
    private float qzl = 1.0f;
    private int qzm = 0;
    private int qzn = 0;
    public boolean sMK = false;
    private boolean sxF = true;
    private boolean vBy = false;
    protected boolean vJn = false;
    private HashSet<Long> vLb = new HashSet();
    public b vPU;
    private final boolean vQe = false;
    private b.b vRN;
    private RelativeLayout vRO;
    private RelativeLayout vRP;
    private boolean vRQ;
    private boolean vRR = false;
    private ImageView vRS;
    private RelativeLayout vRT;
    private RelativeLayout vRU;
    private FrameLayout vRV;
    View vRW;
    Button vRX;
    Button vRY;
    View vRZ;
    private View vSa;
    protected VideoPlayerSeekBar vSb;
    private MultiTouchImageView vSc;
    int vSd = 0;
    int vSe = 0;
    boolean vSf;
    ArrayList<Integer> vSg = new ArrayList();
    protected boolean vSh = false;
    protected boolean vSi = false;
    private boolean vSj;
    private String vSk = null;
    public a vSl;
    private View vSm;
    private CheckBox vSn;
    private View vSo;
    private int vSp = 0;
    private ViewPager.e vSq = new ViewPager.e(this) {
        private boolean vSA = false;
        final /* synthetic */ ImageGalleryUI vSz;

        {
            this.vSz = r2;
        }

        public final void a(int i, float f, int i2) {
        }

        public final void V(int i) {
            if (this.vSz.vPU != null) {
                View Al = this.vSz.vPU.Al(i);
                if (Al == null) {
                    w.e("MicroMsg.ImageGalleryUI", "onPageSelected the view is null, position = %s ", Integer.valueOf(i));
                }
                ImageGalleryUI.q(this.vSz);
                this.vSz.vSp = i;
                if (this.vSz.vPU != null) {
                    b f = this.vSz.vPU;
                    f.vQb.bWS();
                    f.vQc.bWS();
                    ce Bm = this.vSz.vPU.Bm(i);
                    if (!((!b.aR(Bm) && !b.aU(Bm)) || Al == null || Al.getTag() == null)) {
                        ((j) Al.getTag()).vTx.bSJ();
                    }
                    if (Bm != null) {
                        this.vSz.eT(Bm.field_msgId);
                    }
                    if (this.vSz.vPU != null) {
                        com.tencent.mm.ah.d e = this.vSz.vPU.e(Bm, false);
                        if (b.a(Bm, e)) {
                            e = com.tencent.mm.ah.e.a(e);
                            int i2 = e.hrs;
                            w.d("MicroMsg.ImageGalleryUI", "jacks loading hd from imgInfo : %d, time: %d", Integer.valueOf(Math.max(1, (int) (i2 != 0 ? ((((long) e.offset) * 100) / ((long) i2)) - 1 : 0))), Long.valueOf(System.currentTimeMillis()));
                            this.vSz.BG(r0);
                        } else if (Bm == null || Bm.bMl() || !this.vSz.vPU.aW(Bm)) {
                            this.vSz.ew(true);
                        } else {
                            this.vSz.ew(false);
                        }
                    } else {
                        w.e("MicroMsg.ImageGalleryUI", "[arthurdan.ImageGallery] Notice!!! adapter is null");
                    }
                    if (Bm == null) {
                        w.e("MicroMsg.ImageGalleryUI", "update footer fail, msg is null, position = " + i);
                    } else {
                        this.vSz.bk(Bm);
                        this.vSz.bWY();
                    }
                }
                if (this.vSz.vPU != null) {
                    this.vSz.vPU.V(i);
                }
            }
        }

        public final void W(int i) {
            w.d("MicroMsg.ImageGalleryUI", "onPageScrollStateChanged: %d", Integer.valueOf(i));
            if (i == 2) {
                this.vSA = true;
                this.vSz.bXn();
                this.vSz.bXj();
                this.vSz.bXk();
            }
            if (i == 0) {
                if (this.vSA) {
                    this.vSz.bXm();
                }
                this.vSA = false;
            }
            if (this.vSz.vPU != null) {
                b f = this.vSz.vPU;
                if (f.vQa != null) {
                    d dVar = f.vQa;
                    dVar.xV = i;
                    if (dVar.vRo != null) {
                        dVar.vRo.W(i);
                    }
                }
            }
        }
    };
    boolean vSr = false;
    aj vSs = new aj(new com.tencent.mm.sdk.platformtools.aj.a(this) {
        final /* synthetic */ ImageGalleryUI vSz;

        {
            this.vSz = r1;
        }

        public final boolean oQ() {
            if (this.vSz.vSr) {
                this.vSz.bXe();
            }
            return false;
        }
    }, false);
    private HashMap<Long, String> vSt = new HashMap();
    private boolean vSu = false;
    private boolean vSv = false;
    private aj vSw;
    private boolean vSx = false;
    private boolean vSy = false;

    public interface a {
        void i(Boolean bool);
    }

    static /* synthetic */ void a(ImageGalleryUI imageGalleryUI, bx bxVar) {
        int i;
        String str;
        int i2 = 2;
        w.i("MicroMsg.ImageGalleryUI", "talker: %s, chatroom: %s", imageGalleryUI.fJL, imageGalleryUI.chatroomName);
        String str2 = "";
        if (!bg.mA(imageGalleryUI.chatroomName) && o.dH(imageGalleryUI.chatroomName)) {
            w.d("MicroMsg.ImageGalleryUI", "is chatroom: %s", imageGalleryUI.chatroomName);
            i = 2;
            str = imageGalleryUI.chatroomName;
        } else if (bg.mA(imageGalleryUI.fJL)) {
            w.e("MicroMsg.ImageGalleryUI", "unknow source");
            str = str2;
            i = -1;
        } else {
            if (o.eV(imageGalleryUI.fJL)) {
                w.d("MicroMsg.ImageGalleryUI", "is biz: %s", imageGalleryUI.fJL);
                i2 = 4;
            } else if (o.dH(imageGalleryUI.fJL)) {
                w.d("MicroMsg.ImageGalleryUI", "taler is chatroom: %s", imageGalleryUI.fJL);
            } else {
                w.d("MicroMsg.ImageGalleryUI", "is single chat: %s", imageGalleryUI.fJL);
                i2 = 1;
            }
            i = i2;
            str = imageGalleryUI.fJL;
        }
        bxVar.fFn.fFq = i;
        bxVar.fFn.aJE = str;
    }

    static /* synthetic */ void b(ImageGalleryUI imageGalleryUI, bx bxVar) {
        com.tencent.mm.ah.d e = imageGalleryUI.vPU.e(imageGalleryUI.vPU.bWK(), true);
        if (e != null && !bg.mA(e.hFj)) {
            Map q = bh.q(e.hFj, "msg");
            if (q != null) {
                bxVar.fFn.fFt = (String) q.get(".msg.img.$aeskey");
                bxVar.fFn.imagePath = (String) q.get(".msg.img.$cdnmidimgurl");
            }
        }
    }

    static /* synthetic */ void h(ImageGalleryUI imageGalleryUI) {
        w.i("MicroMsg.ImageGalleryUI", "%d handle single click event.", Integer.valueOf(imageGalleryUI.hashCode()));
        if (imageGalleryUI.bXb()) {
            try {
                if (imageGalleryUI.vPU.bWL().bXx().vTm.getVisibility() == 0) {
                    w.d("MicroMsg.ImageGalleryUI", "%d handle single click event, it is loading video, don't show toolbar", Integer.valueOf(imageGalleryUI.hashCode()));
                    return;
                }
            } catch (Exception e) {
            }
            if (imageGalleryUI.vSr) {
                imageGalleryUI.bXe();
                return;
            } else {
                imageGalleryUI.bXd();
                return;
            }
        }
        imageGalleryUI.onBackPressed();
    }

    static /* synthetic */ void m(ImageGalleryUI imageGalleryUI) {
        if (imageGalleryUI.bXb()) {
            try {
                if (imageGalleryUI.vPU.bWL().bXx().vTk.getVisibility() == 0) {
                    imageGalleryUI.vPU.bWL().bXx().vTk.setVisibility(8);
                    imageGalleryUI.vSu = true;
                }
            } catch (Exception e) {
            }
        }
        if (imageGalleryUI.vSr) {
            imageGalleryUI.bXe();
            imageGalleryUI.vSv = true;
        }
    }

    static /* synthetic */ void q(ImageGalleryUI imageGalleryUI) {
        final View a = imageGalleryUI.a(imageGalleryUI.vPU, imageGalleryUI.mho);
        imageGalleryUI.mho.vnA = new MMViewPager.b(imageGalleryUI) {
            final /* synthetic */ ImageGalleryUI vSz;

            public final void C(float f, float f2) {
                float f3 = 1.0f;
                float height = 1.0f - (f2 / ((float) this.vSz.mho.getHeight()));
                if (height <= 1.0f) {
                    f3 = height;
                }
                this.vSz.qzl = f3;
                if (a != null) {
                    if (f == 0.0f && f2 == 0.0f) {
                        ImageGalleryUI.r(this.vSz);
                    } else {
                        ImageGalleryUI.m(this.vSz);
                    }
                    a.setPivotX((float) (this.vSz.mho.getWidth() / 2));
                    a.setPivotY((float) (this.vSz.mho.getHeight() / 2));
                    a.setScaleX(f3);
                    a.setScaleY(f3);
                    a.setTranslationX(f);
                    a.setTranslationY(f2);
                    this.vSz.lMk.setAlpha(f3);
                    return;
                }
                w.d("MicroMsg.ImageGalleryUI", "runDragAnimation contentView is null !!");
            }

            public final void D(float f, float f2) {
                this.vSz.qzm = (int) f;
                this.vSz.qzn = (int) f2;
            }
        };
    }

    static /* synthetic */ void r(ImageGalleryUI imageGalleryUI) {
        if (imageGalleryUI.bXb() && imageGalleryUI.vSu) {
            try {
                if (imageGalleryUI.vPU.bWL().bXx().vTk.getVisibility() == 8) {
                    imageGalleryUI.vPU.bWL().bXx().vTk.setVisibility(0);
                    imageGalleryUI.vSu = false;
                }
            } catch (Exception e) {
            }
        }
        if (imageGalleryUI.vSv) {
            imageGalleryUI.bXd();
            imageGalleryUI.vSv = false;
        }
    }

    static /* synthetic */ void x(ImageGalleryUI imageGalleryUI) {
        w.i("MicroMsg.ImageGalleryUI", "enterPositionAtChatRecords-->talker:%s,magId:%d", imageGalleryUI.fJL, Long.valueOf(imageGalleryUI.vPU.Bm(imageGalleryUI.vSp).field_msgId));
        Intent intent = new Intent(imageGalleryUI.uSU.uTo, En_5b8fbb1e.class);
        intent.putExtra("Chat_User", imageGalleryUI.bWX());
        intent.putExtra("finish_direct", true);
        intent.putExtra("show_search_chat_content_result", true);
        intent.putExtra("key_is_biz_chat", imageGalleryUI.sMK);
        intent.putExtra("key_biz_chat_id", imageGalleryUI.kbc);
        ap.yY();
        intent.putExtra("need_hight_item", ((Boolean) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.USERINFO_POSITION_AT_CHATRECORD_FIRST_IN_BOOLEAN, Boolean.valueOf(true))).booleanValue());
        intent.putExtra("msg_local_id", r4);
        intent.putExtra("img_gallery_enter_from_chatting_ui", true);
        imageGalleryUI.startActivity(intent);
        if (imageGalleryUI.vSh) {
            com.tencent.mm.plugin.report.service.g.oUh.a(219, 16, 1, true);
        } else {
            com.tencent.mm.plugin.report.service.g.oUh.a(219, 17, 1, true);
        }
    }

    protected void onPause() {
        w.i("MicroMsg.ImageGalleryUI", "on pause");
        super.onPause();
        if (VERSION.SDK_INT >= 21) {
            getWindow().setFlags(2048, 2048);
        }
        if (!(isFinishing() || this.vPU == null)) {
            b bVar = this.vPU;
            bVar.vQb.vSP.sendEmptyMessageAtTime(1, 200);
            bVar.vQc.bWS();
        }
        if (this.qtn != null) {
            com.tencent.mm.sdk.b.b ajVar = new com.tencent.mm.e.a.aj();
            ajVar.fDJ.activity = this;
            ajVar.fDJ.fDK = this.qtn;
            com.tencent.mm.sdk.b.a.urY.m(ajVar);
            this.qtn = null;
            this.iYL = 0;
            this.iYK = 0;
        }
    }

    final ImageGalleryUI bWT() {
        if (this.vRW == null) {
            this.vRW = ((ViewStub) findViewById(R.h.bWL)).inflate();
            this.vRX = (Button) this.vRW.findViewById(R.h.bHp);
            this.vRY = (Button) this.vRW.findViewById(R.h.bHq);
            this.vRZ = this.vRW.findViewById(R.h.bHr);
        }
        return this;
    }

    protected final ImageGalleryUI bWU() {
        if (this.vSa == null) {
            this.vSa = ((ViewStub) findViewById(R.h.cLQ)).inflate();
            this.vSb = (VideoPlayerSeekBar) findViewById(R.h.cLX);
            this.vSb.f((OnClickListener) this);
        }
        return this;
    }

    private ImageGalleryUI bWV() {
        if (this.vRT == null) {
            this.vRT = (RelativeLayout) ((ViewStub) findViewById(R.h.bVv)).inflate();
        }
        return this;
    }

    private ImageGalleryUI bWW() {
        if (this.vRU == null) {
            this.vRU = (RelativeLayout) ((ViewStub) findViewById(R.h.bWK)).inflate();
            this.vRU.findViewById(R.h.bJX).setOnClickListener(this);
        }
        return this;
    }

    private static void L(View view, int i) {
        if (view != null) {
            view.setVisibility(i);
        }
    }

    private static int dx(View view) {
        if (view != null) {
            return view.getVisibility();
        }
        return 8;
    }

    public final boolean Xb() {
        return true;
    }

    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        long currentTimeMillis = System.currentTimeMillis();
        this.sxF = true;
        super.onCreate(bundle);
        if (com.tencent.mm.compatible.util.d.eo(19)) {
            getWindow().setFlags(201327616, 201327616);
            this.nAn = true;
        } else {
            getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            this.nAn = false;
        }
        KC();
        this.klH = bundle;
        com.tencent.mm.sdk.b.a.urY.b(this.lHl);
        com.tencent.mm.sdk.b.a.urY.b(this.qtq);
        this.vRR = false;
        w.d("MicroMsg.ImageGalleryUI", "ImageGallery onCreate spent : %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }

    protected void onResume() {
        super.onResume();
        if (VERSION.SDK_INT >= 21) {
            getWindow().clearFlags(2048);
        }
        if (!(this.sxF || this.vPU == null)) {
            BC(this.mho.ys);
        }
        this.sxF = false;
        if (this.vPU != null) {
            this.vPU.bWM();
        }
    }

    public void onStart() {
        this.vSi = getIntent().getBooleanExtra("img_gallery_back_from_grid", false);
        if (!this.vRQ) {
            Bundle bundle = this.klH;
            if (!this.klI) {
                this.klI = true;
                if (VERSION.SDK_INT >= 12) {
                    this.klK = getIntent().getIntExtra("img_gallery_top", 0);
                    this.klL = getIntent().getIntExtra("img_gallery_left", 0);
                    this.klM = getIntent().getIntExtra("img_gallery_width", 0);
                    this.klN = getIntent().getIntExtra("img_gallery_height", 0);
                    if (this.klK == 0 && this.klL == 0 && this.klM == 0 && this.klN == 0) {
                        au Bm = this.vPU.Bm(this.mho.ys);
                        if (Bm != null) {
                            com.tencent.mm.sdk.b.b aqVar = new aq();
                            aqVar.fDZ.fCZ = Bm;
                            com.tencent.mm.sdk.b.a.urY.m(aqVar);
                            this.klM = aqVar.fEa.fEd;
                            this.klN = aqVar.fEa.fEe;
                            this.klL = aqVar.fEa.fEb;
                            this.klK = aqVar.fEa.fEc;
                        }
                    }
                    this.klJ.p(this.klL, this.klK, this.klM, this.klN);
                    if (bundle == null) {
                        this.mho.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener(this) {
                            final /* synthetic */ ImageGalleryUI vSz;

                            {
                                this.vSz = r1;
                            }

                            public final boolean onPreDraw() {
                                this.vSz.mho.getViewTreeObserver().removeOnPreDrawListener(this);
                                this.vSz.qzi = this.vSz.mho.getWidth();
                                this.vSz.qzj = this.vSz.mho.getHeight();
                                if (this.vSz.vPU.bWK().bMm()) {
                                    this.vSz.qzj = (int) ((((float) this.vSz.qzi) / ((float) this.vSz.klM)) * ((float) this.vSz.klN));
                                }
                                if (this.vSz.vPU.bWK().bMh()) {
                                    this.vSz.vSc = this.vSz.vPU.nk(this.vSz.mho.ys);
                                }
                                if (this.vSz.vSc != null) {
                                    this.vSz.qzj = (int) ((((float) this.vSz.qzi) / ((float) this.vSz.vSc.imageWidth)) * ((float) this.vSz.vSc.imageHeight));
                                    if (this.vSz.qzj > this.vSz.mho.getHeight()) {
                                        this.vSz.qzj = this.vSz.mho.getHeight();
                                    }
                                }
                                this.vSz.klJ.ek(this.vSz.qzi, this.vSz.qzj);
                                if (!this.vSz.vSi) {
                                    ImageGalleryUI.m(this.vSz);
                                    this.vSz.vSu = false;
                                    this.vSz.klJ.a(this.vSz.mho, this.vSz.lMk, new g.b(this) {
                                        final /* synthetic */ AnonymousClass17 vSB;

                                        {
                                            this.vSB = r1;
                                        }

                                        public final void onAnimationStart() {
                                            if (this.vSB.vSz.vSl != null) {
                                                this.vSB.vSz.vSl.i(Boolean.valueOf(true));
                                            }
                                        }

                                        public final void onAnimationEnd() {
                                            this.vSB.vSz.mHandler.post(new Runnable(this) {
                                                final /* synthetic */ AnonymousClass1 vSC;

                                                {
                                                    this.vSC = r1;
                                                }

                                                public final void run() {
                                                    if (this.vSC.vSB.vSz.vSl != null) {
                                                        this.vSC.vSB.vSz.vSl.i(Boolean.valueOf(false));
                                                    }
                                                }
                                            });
                                        }
                                    });
                                }
                                ImageGalleryUI.q(this.vSz);
                                return true;
                            }
                        });
                    }
                }
            }
        }
        super.onStart();
    }

    protected void onDestroy() {
        w.i("MicroMsg.ImageGalleryUI", "%d image gallery ui on destroy", Integer.valueOf(hashCode()));
        if (this.vPU != null) {
            this.vPU.detach();
            this.vPU = null;
        }
        bXn();
        this.vSs.KH();
        com.tencent.mm.sdk.b.a.urY.c(this.lHl);
        com.tencent.mm.sdk.b.a.urY.c(this.qtq);
        if (this.vSb != null) {
            this.vSb.f(null);
        }
        this.vSb = null;
        super.onDestroy();
    }

    public void onBackPressed() {
        w.i("MicroMsg.ImageGalleryUI", "onBackPressed");
        if (this.vSh) {
            BD(1);
            return;
        }
        try {
            a.vRJ.detach();
            ahz();
        } catch (Exception e) {
            w.e("MicroMsg.ImageGalleryUI", e.getMessage());
        }
    }

    private String bWX() {
        return (this.chatroomName == null || this.chatroomName.length() <= 0) ? this.fJL : this.chatroomName;
    }

    protected final void KC() {
        this.klJ = new g(this.uSU.uTo);
        this.vSw = new aj(this, false);
        this.klI = false;
        this.fJL = getIntent().getStringExtra("img_gallery_talker");
        this.vSh = getIntent().getBooleanExtra("img_gallery_enter_from_grid", false);
        this.vJn = getIntent().getBooleanExtra("img_gallery_enter_from_chatting_ui", false);
        this.vSj = getIntent().getBooleanExtra("img_gallery_enter_from_appbrand_service_chatting_ui", false);
        this.vBy = getIntent().getBooleanExtra("show_search_chat_content_result", false);
        this.sMK = getIntent().getBooleanExtra("key_is_biz_chat", false);
        this.kbc = getIntent().getLongExtra("key_biz_chat_id", -1);
        this.vRQ = getIntent().getBooleanExtra("img_preview_only", false);
        if (!this.vRQ) {
            Assert.assertTrue("MicroMsg.ImageGalleryUI initView, talker is null, stack = " + bg.bJZ(), this.fJL != null);
        }
        this.chatroomName = getIntent().getStringExtra("img_gallery_chatroom_name");
        this.vSi = getIntent().getBooleanExtra("img_gallery_back_from_grid", false);
        this.vSk = getIntent().getStringExtra("img_gallery_enter_video_opcode");
        boolean booleanExtra = getIntent().getBooleanExtra("img_gallery_is_restransmit_after_download", false);
        String stringExtra = getIntent().getStringExtra("img_gallery_directly_send_name");
        this.fGM = getIntent().getLongExtra("img_gallery_msg_id", 0);
        long longExtra = getIntent().getLongExtra("img_gallery_msg_svr_id", 0);
        if (this.fGM > 0 || longExtra != 0) {
            if (this.fGM == 0) {
                ap.yY();
                this.fGM = com.tencent.mm.u.c.wT().x(bWX(), longExtra).field_msgId;
            }
            ap.yY();
            ce cA = com.tencent.mm.u.c.wT().cA(this.fGM);
            if (cA.field_msgId <= 0) {
                w.e("MicroMsg.ImageGalleryUI", " initView, msgId is invalid, msgId = " + this.fGM + ", msgSvrId = " + longExtra + ", stack = " + bg.bJZ());
                finish();
                return;
            }
            this.vPU = new b(this, this.fGM, bWX(), this.sMK, this.kbc, booleanExtra, stringExtra, Boolean.valueOf(this.vSi));
            this.vPU.vQe = false;
            this.vPU.vPY = getIntent().getBooleanExtra("start_chatting_ui", true);
            this.vPU.vQd = new b.c(this) {
                final /* synthetic */ ImageGalleryUI vSz;

                {
                    this.vSz = r1;
                }

                public final void Uc() {
                    if (this.vSz.vPU != null) {
                        this.vSz.bWY();
                        this.vSz.vPU.V(100000);
                    }
                }
            };
            this.vRO = (RelativeLayout) findViewById(R.h.bHo);
            this.vRP = (RelativeLayout) findViewById(R.h.bHn);
            this.vRS = (ImageView) findViewById(R.h.cLF);
            this.vRS.setOnClickListener(this);
            Display defaultDisplay = getWindowManager().getDefaultDisplay();
            w.d("MicroMsg.ImageGalleryUI", "%d is vertical screen orient %d [%d, %d]", Integer.valueOf(hashCode()), Integer.valueOf(defaultDisplay.getWidth() < defaultDisplay.getHeight() ? 1 : 0), Integer.valueOf(defaultDisplay.getWidth()), Integer.valueOf(defaultDisplay.getHeight()));
            if (((defaultDisplay.getWidth() < defaultDisplay.getHeight() ? 1 : 0) == 0 ? null : 1) != null) {
                bXo();
            } else {
                bXp();
            }
            this.lMk = (ImageView) findViewById(R.h.bSt);
            this.lMk.setLayerType(2, null);
            this.mho = (MMViewPager) findViewById(R.h.bSr);
            this.mho.setLayerType(2, null);
            this.mho.setVerticalFadingEdgeEnabled(false);
            this.mho.setHorizontalFadingEdgeEnabled(false);
            this.mho.vnu = new MMViewPager.e(this) {
                final /* synthetic */ ImageGalleryUI vSz;

                {
                    this.vSz = r1;
                }

                public final void ahA() {
                    ImageGalleryUI.h(this.vSz);
                }

                public final void azc() {
                    this.vSz.ahz();
                }
            };
            if (!this.vRQ) {
                this.mho.vnw = this.vSq;
                this.mho.vnv = new MMViewPager.c(this) {
                    final /* synthetic */ ImageGalleryUI vSz;

                    {
                        this.vSz = r1;
                    }

                    public final void auf() {
                        this.vSz.ls(true);
                    }
                };
            }
            this.mho.Cb(1);
            WxViewPager wxViewPager = this.mho;
            int i = wxViewPager.yz;
            wxViewPager.yz = 50;
            int width = wxViewPager.getWidth();
            wxViewPager.u(width, width, 50, i);
            wxViewPager.requestLayout();
            this.mho.a(this.vPU);
            BC(100000);
            this.mho.Y(100000);
            this.mho.postDelayed(new Runnable(this) {
                final /* synthetic */ ImageGalleryUI vSz;

                {
                    this.vSz = r1;
                }

                public final void run() {
                    if (this.vSz.vPU != null) {
                        if (a.vRJ.vRH && this.vSz.vSn != null) {
                            this.vSz.vSn.setChecked(a.vRJ.bj(this.vSz.vPU.bWK()));
                            this.vSz.vSo.setOnClickListener(this.vSz);
                        }
                        if (this.vSz.mho.ys == 100000) {
                            this.vSz.bXm();
                            b.b aX = b.aX(this.vSz.vPU.Bm(100000));
                            if (!this.vSz.vSi && aX == b.b.vQC) {
                                this.vSz.vPU.Br(100000);
                            }
                            if (aX == b.b.sight) {
                                this.vSz.vPU.Bv(100000);
                            }
                        }
                    }
                }
            }, 0);
            if (a.vRJ.vRH) {
                this.vSm = ((ViewStub) findViewById(R.h.cCm)).inflate();
                this.vSm.setVisibility(0);
                this.vSn = (CheckBox) this.vSm.findViewById(R.h.cjp);
                this.vSo = this.vSm.findViewById(R.h.cjq);
            }
            this.vSf = getIntent().getBooleanExtra("img_gallery_enter_PhotoEditUI", false);
            com.tencent.mm.ah.d e = this.vPU.e(cA, true);
            if (e == null) {
                w.e("MicroMsg.ImageGalleryUI", "[initView] imgInfo is null!!! isSoonEnterPhotoEdit:%s", Boolean.valueOf(this.vSf));
            }
            if (this.vSf && e != null && e.GA()) {
                bXq();
                this.vSf = false;
                return;
            } else if (this.vSf) {
                w.w("MicroMsg.ImageGalleryUI", "img not GetCompleted!");
                return;
            } else {
                return;
            }
        }
        w.e("MicroMsg.ImageGalleryUI", " initView, msgId is invalid, msgId = " + this.fGM + ", msgSvrId = " + longExtra + ", stack = " + bg.bJZ());
        finish();
    }

    private View a(b bVar, MMViewPager mMViewPager) {
        View view;
        String str = "MicroMsg.ImageGalleryUI";
        String str2 = "get current view adapter is null %b, gallery is null %b";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(bVar == null);
        objArr[1] = Boolean.valueOf(mMViewPager == null);
        w.d(str, str2, objArr);
        if (bVar == null || mMViewPager == null) {
            w.w("MicroMsg.ImageGalleryUI", "%d get current view but adapter or gallery is null", Integer.valueOf(hashCode()));
            view = null;
        } else if (bVar.bWK() == null) {
            return null;
        } else {
            if (bVar.bWK().bMh() || bVar.bWK().bMp()) {
                view = bVar.nk(mMViewPager.ys);
            } else {
                if (bVar.bWK().bMl() || bVar.bWK().bMm()) {
                    view = bVar.Bq(mMViewPager.ys);
                }
                view = null;
            }
        }
        return view;
    }

    private void ahz() {
        if (this.vRR) {
            w.i("MicroMsg.ImageGalleryUI", "isRunningExitAnimation");
        } else if (this.vRQ) {
            finish();
            com.tencent.mm.ui.base.b.eM(this.uSU.uTo);
        } else {
            int i;
            int i2;
            w.i("MicroMsg.ImageGalleryUI", "runExitAnimation");
            int width = this.mho.getWidth() / 2;
            int height = this.mho.getHeight() / 2;
            this.vPU.bWI();
            com.tencent.mm.sdk.b.b ggVar;
            if (this.vSh) {
                ggVar = new gg();
                ggVar.fLx.fGM = this.vPU.Bm(this.mho.ys).field_msgId;
                com.tencent.mm.sdk.b.a.urY.m(ggVar);
                i = ggVar.fLy.fEd;
                i2 = ggVar.fLy.fEe;
                width = ggVar.fLy.fEb;
                height = ggVar.fLy.fEc;
            } else {
                ce Bm = this.vPU.Bm(this.mho.ys);
                if (Bm != null) {
                    ggVar = new aq();
                    ggVar.fDZ.fCZ = Bm;
                    com.tencent.mm.sdk.b.a.urY.m(ggVar);
                    i = ggVar.fEa.fEd;
                    i2 = ggVar.fEa.fEe;
                    width = ggVar.fEa.fEb;
                    height = ggVar.fEa.fEc;
                } else {
                    i2 = 0;
                    i = 0;
                }
                if (width == 0 && r0 == 0) {
                    width = this.mho.getWidth() / 2;
                    height = this.mho.getHeight() / 2;
                } else if (Bm != null) {
                    if (Bm.field_isSend == 0) {
                        this.vSd = com.tencent.mm.bg.a.fromDPToPix(this.uSU.uTo, 5);
                    }
                    if (Bm.field_isSend == 1) {
                        this.vSe = com.tencent.mm.bg.a.fromDPToPix(this.uSU.uTo, 5);
                    }
                }
            }
            this.qzi = this.mho.getWidth();
            this.qzj = this.mho.getHeight();
            if (!(this.vPU == null || this.vPU.bWK() == null)) {
                if (this.vPU.bWK().bMm() || this.vPU.bWK().bMl()) {
                    this.qzj = (int) ((((float) this.qzi) / ((float) i)) * ((float) i2));
                }
                if (this.vPU.bWK().bMh() || this.vPU.bWK().bMp()) {
                    this.vSc = this.vPU.nk(this.mho.ys);
                }
            }
            if (this.vSc != null) {
                this.qzj = (int) ((((float) this.qzi) / ((float) this.vSc.imageWidth)) * ((float) this.vSc.imageHeight));
                if (this.qzj > this.mho.getHeight()) {
                    if (((double) this.qzj) < ((double) this.mho.getHeight()) * 1.5d) {
                        if (this.vSh) {
                            this.qzk = this.qzj - this.mho.getHeight();
                        } else {
                            i2 = (i2 * this.mho.getHeight()) / this.qzj;
                        }
                    }
                    this.qzj = this.mho.getHeight();
                }
            }
            g gVar = this.klJ;
            int i3 = this.vSd;
            int i4 = this.vSe;
            gVar.qor = i3;
            gVar.qos = i4;
            gVar.qot = 0;
            gVar.qou = 0;
            this.klJ.qoq = this.qzk;
            this.klJ.ek(this.qzi, this.qzj);
            this.klJ.p(width, height, i, i2);
            View view = this.mho;
            View a = a(this.vPU, this.mho);
            if (a == null) {
                a = view;
            } else if (((double) this.qzl) != 1.0d) {
                this.klJ.wmy = 1.0f / this.qzl;
                if (!(this.qzm == 0 && this.qzn == 0)) {
                    this.klJ.el(((int) (((float) (this.mho.getWidth() / 2)) * (1.0f - this.qzl))) + this.qzm, (int) (((float) ((this.mho.getHeight() / 2) + this.qzn)) - (((float) (this.qzj / 2)) * this.qzl)));
                }
            }
            this.klJ.a(a, this.lMk, new g.b(this) {
                final /* synthetic */ ImageGalleryUI vSz;

                {
                    this.vSz = r1;
                }

                public final void onAnimationStart() {
                    this.vSz.vRR = true;
                    ImageGalleryUI.L(this.vSz.vRP, 8);
                    ImageGalleryUI.L(this.vSz.vRO, 8);
                    new ae().postDelayed(new Runnable(this) {
                        final /* synthetic */ AnonymousClass19 vSD;

                        {
                            this.vSD = r1;
                        }

                        public final void run() {
                            if (this.vSD.vSz.vSc != null) {
                                this.vSD.vSz.vSc.bSJ();
                            }
                        }
                    }, 20);
                }

                public final void onAnimationEnd() {
                    w.i("MicroMsg.ImageGalleryUI", "runExitAnimation onAnimationEnd");
                    this.vSz.mHandler.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass19 vSD;

                        {
                            this.vSD = r1;
                        }

                        public final void run() {
                            this.vSD.vSz.finish();
                            this.vSD.vSz.overridePendingTransition(0, 0);
                        }
                    });
                    this.vSz.vRR = false;
                }
            }, null);
        }
    }

    protected final void ls(boolean z) {
        if (this.vPU != null && this.vSp >= 0) {
            au Bm = this.vPU.Bm(this.vSp);
            int bf = this.vPU.vQa.bf(Bm);
            if (bf == 5 || bf == 6) {
                w.w("MicroMsg.ImageGalleryUI", "jacks fail downloaded img, return");
            } else if (this.vPU.aW(Bm)) {
                w.w("MicroMsg.ImageGalleryUI", "jacks downloading, return");
            } else if (b.aS(Bm) && i.bl(Bm) == null) {
                w.w("MicroMsg.ImageGalleryUI", "video info is null, return now.");
            } else {
                final List arrayList = new ArrayList();
                final List arrayList2 = new ArrayList();
                arrayList.add(Integer.valueOf(0));
                arrayList2.add(getString(R.l.eLL));
                if (com.tencent.mm.bb.d.Jt("favorite")) {
                    arrayList.add(Integer.valueOf(2));
                    arrayList2.add(getString(R.l.eGa));
                }
                if (b.aR(Bm) || b.aV(Bm)) {
                    arrayList.add(Integer.valueOf(1));
                    arrayList2.add(getString(R.l.eOk));
                } else if (b.aS(Bm) || b.aT(Bm)) {
                    arrayList.add(Integer.valueOf(1));
                    arrayList2.add(getString(R.l.eOn));
                } else {
                    arrayList.add(Integer.valueOf(1));
                    arrayList2.add(getString(R.l.eOm));
                }
                if (b.aR(Bm) || b.aT(Bm)) {
                    com.tencent.mm.sdk.b.b ddVar = new dd();
                    ddVar.fGW.fGM = Bm.field_msgId;
                    com.tencent.mm.sdk.b.a.urY.m(ddVar);
                    if (ddVar.fGX.fGu || com.tencent.mm.pluginsdk.model.app.g.L(this.uSU.uTo, Bm.field_type)) {
                        arrayList.add(Integer.valueOf(4));
                        arrayList2.add(getString(R.l.dUu));
                    }
                }
                if (b.aR(Bm)) {
                    arrayList.add(Integer.valueOf(6));
                    arrayList2.add(getString(R.l.dTN));
                }
                if (!(this.qtn == null || this.vSj)) {
                    Object string;
                    arrayList.add(Integer.valueOf(3));
                    if (com.tencent.mm.plugin.scanner.a.ak(this.iYK, this.qtn)) {
                        string = getString(R.l.eIB);
                    } else {
                        string = getString(R.l.eIA);
                    }
                    arrayList2.add(string);
                }
                if (!(this.vBy || this.sMK || a.vRJ.vRH || this.vSj)) {
                    arrayList.add(Integer.valueOf(5));
                    arrayList2.add(getString(R.l.dTM));
                }
                if (this.qtj == null || !this.qto) {
                    this.qtj = new e(this.uSU.uTo, e.wuP, false);
                } else {
                    this.qto = false;
                }
                this.qtj.qJf = new n.c(this) {
                    final /* synthetic */ ImageGalleryUI vSz;

                    public final void a(l lVar) {
                        lVar.clear();
                        for (int i = 0; i < arrayList.size(); i++) {
                            lVar.e(((Integer) arrayList.get(i)).intValue(), (CharSequence) arrayList2.get(i));
                        }
                    }
                };
                this.qtj.qJg = this.kTc;
                this.qtj.bzh();
                this.qtj.wva = new com.tencent.mm.ui.widget.e.a(this) {
                    final /* synthetic */ ImageGalleryUI vSz;

                    {
                        this.vSz = r1;
                    }

                    public final void onDismiss() {
                        com.tencent.mm.sdk.b.b akVar = new ak();
                        akVar.fDL.filePath = this.vSz.qtk;
                        com.tencent.mm.sdk.b.a.urY.m(akVar);
                        this.vSz.qtj = null;
                        this.vSz.qtk = null;
                        this.vSz.qtn = null;
                        this.vSz.iYK = this.vSz.iYL = 0;
                    }
                };
                if ((b.aR(Bm) || b.aV(Bm)) && true == z && ap.vd().BR() != 0 && !this.vSj) {
                    String str = null;
                    if (b.aR(Bm)) {
                        com.tencent.mm.ah.d e = this.vPU.e(Bm, true);
                        if (e != null) {
                            str = d.a(Bm, e, false);
                        }
                    } else {
                        str = b.bb(Bm);
                    }
                    if (str != null) {
                        com.tencent.mm.sdk.b.b lwVar = new lw();
                        lwVar.fTb.filePath = str;
                        this.qtk = str;
                        com.tencent.mm.sdk.b.a.urY.m(lwVar);
                    }
                }
            }
        }
    }

    public final void ew(boolean z) {
        int i = 8;
        if (!z || this.vRO.getVisibility() != 0) {
            if (z || this.vRO.getVisibility() != 8) {
                RelativeLayout relativeLayout = this.vRO;
                if (z) {
                    i = 0;
                }
                relativeLayout.setVisibility(i);
                this.vRO.startAnimation(AnimationUtils.loadAnimation(this.uSU.uTo, z ? R.a.aQJ : R.a.aQK));
            }
        }
    }

    protected final int getLayoutId() {
        return R.i.dfG;
    }

    protected final void SC() {
        super.SC();
    }

    private void bWY() {
        if (this.vPU != null && !this.vRQ && this.vPU.bWJ() && bWV().vRT != null) {
            if (a.vRJ.vRH) {
                bXa();
            } else if (this.vBy || this.vSj) {
                bXa();
            } else {
                w.d("MicroMsg.ImageGalleryUI", "%d show enter grid is video %b", Integer.valueOf(hashCode()), Boolean.valueOf(bXb()));
                bWZ();
                bXm();
            }
        }
    }

    private void bWZ() {
        int i = 0;
        L(bWV().vRT, 0);
        View view = bWW().vRU;
        if (this.vRN != b.b.vQB) {
            i = 8;
        }
        L(view, i);
    }

    private void bXa() {
        L(bWV().vRT, 8);
        L(bWW().vRU, 8);
    }

    private static boolean d(au auVar, com.tencent.mm.ah.d dVar) {
        try {
            if (b.b(auVar, dVar) == 0 && dVar.GB() && !auVar.bMt()) {
                return true;
            }
        } catch (NullPointerException e) {
            w.e("MicroMsg.ImageGalleryUI", "error:" + e);
        }
        return false;
    }

    public final void BC(int i) {
        bk(this.vPU.Bm(i));
    }

    private boolean bXb() {
        if (this.vRN == b.b.vQC) {
            return true;
        }
        return false;
    }

    protected final void bXc() {
        if (this.vSr) {
            this.vSs.v(4000, 4000);
        }
    }

    public final void bXd() {
        w.i("MicroMsg.ImageGalleryUI", "show video tool bar");
        ew(true);
        lt(true);
        L(this.vRW, 8);
        L(bWU().vSa, 0);
        L(this.vRS, 0);
        bWV().vRT.clearAnimation();
        if (this.vRQ) {
            bXa();
        } else {
            bWZ();
        }
        bXn();
        this.vSr = true;
        bXc();
    }

    public final void bXe() {
        w.i("MicroMsg.ImageGalleryUI", "hide video tool bar");
        lt(false);
        L(bWU().vSa, 8);
        L(this.vRS, 8);
        if (bXb()) {
            bXn();
            bXa();
        }
        this.vSr = false;
    }

    private void lt(boolean z) {
        w.d("MicroMsg.ImageGalleryUI", "switch tool bar bg %b", Boolean.valueOf(z));
        if (z) {
            this.vRP.setBackgroundResource(R.g.bfT);
            this.vRO.setBackgroundResource(R.g.bfS);
            return;
        }
        dy(this.vRP);
        dy(this.vRO);
    }

    private static void dy(View view) {
        if (com.tencent.mm.compatible.util.d.eo(16)) {
            view.setBackground(null);
        } else {
            view.setBackgroundDrawable(null);
        }
    }

    public final synchronized void bk(au auVar) {
        int i = 0;
        synchronized (this) {
            this.vRN = b.aX(auVar);
            w.i("MicroMsg.ImageGalleryUI", "updateFooterInfo currGalleryType : " + this.vRN);
            if (a.vRJ.vRH && this.vSn != null) {
                this.vSn.setChecked(a.vRJ.bj(auVar));
            }
            switch (this.vRN) {
                case vQC:
                    bXe();
                    L(this.vRW, 8);
                    lu(true);
                    r bl = i.bl(auVar);
                    if (bl != null) {
                        bWU().vSb.sH(bl.iap);
                        try {
                            if (!(this.vPU.bWL() == null || this.vPU.bWL().vTl == null)) {
                                i = this.vPU.bWL().vTl.getCurrentPosition() / 1000;
                            }
                        } catch (Throwable e) {
                            w.printErrStackTrace("MicroMsg.ImageGalleryUI", e, "", new Object[0]);
                        }
                        bWU().vSb.seek(i);
                        break;
                    }
                    break;
                case vQB:
                    com.tencent.mm.ah.d e2 = this.vPU.e(auVar, false);
                    bXe();
                    bWY();
                    i = this.mho.ys;
                    if (d(auVar, e2) && !auVar.bMt() && e2.GA()) {
                        bWT().vRX.setVisibility(0);
                        bWT().vRY.setVisibility(8);
                        bWT().vRZ.setVisibility(8);
                        String str = (String) this.vSt.get(Long.valueOf(e2.hEY));
                        if (str == null) {
                            Map q = bh.q(e2.hFj, "msg");
                            if (q == null) {
                                w.e("MicroMsg.ImageGalleryUI", "parse cdnInfo failed. [%s]", e2.hFj);
                                i = -1;
                            } else {
                                i = bg.getInt((String) q.get(".msg.img.$hdlength"), 0);
                            }
                            long j = (long) i;
                            if (j < 0) {
                                str = "";
                            } else {
                                BigDecimal bigDecimal = new BigDecimal(j);
                                float floatValue = bigDecimal.divide(new BigDecimal(1048576), 2, 0).floatValue();
                                str = floatValue > 1.0f ? ((int) floatValue) + "M" : ((int) bigDecimal.divide(new BigDecimal(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT), 2, 0).floatValue()) + "K";
                            }
                            this.vSt.put(Long.valueOf(e2.hEY), str);
                        }
                        bWT().vRX.setText(getString(R.l.eba, new Object[]{str}));
                        L(this.vRW, 0);
                    } else {
                        L(this.vRW, 8);
                    }
                    if (!this.vSf || e2 == null || !e2.GA() || this.vPU.bWK() == null || auVar.field_msgId != this.vPU.bWK().field_msgId) {
                        String str2 = "MicroMsg.ImageGalleryUI";
                        String str3 = "isSoonEnterPhotoEdit:%s msgId:%s curMsgId:%s getCompleted:%s";
                        Object[] objArr = new Object[4];
                        objArr[0] = Boolean.valueOf(this.vSf);
                        objArr[1] = Long.valueOf(auVar.field_msgId);
                        objArr[2] = this.vPU.bWK() == null ? "null" : Long.valueOf(this.vPU.bWK().field_msgId);
                        objArr[3] = e2 != null ? Boolean.valueOf(e2.GA()) : "";
                        w.w(str2, str3, objArr);
                        break;
                    }
                    w.i("MicroMsg.ImageGalleryUI", "get image successfully! -> gotoPhotoEditUI msgId:%s", Long.valueOf(auVar.field_msgId));
                    bXq();
                    this.vSf = false;
                    break;
                    break;
                case appimage:
                    bXe();
                    bWY();
                    break;
                case sight:
                    bXe();
                    bWY();
                    L(this.vRW, 8);
                    this.vPU.Bv(this.mho.ys);
                    break;
            }
        }
    }

    private void BD(int i) {
        w.i("MicroMsg.ImageGalleryUI", "enterGrid source : " + i);
        if (this.vPU == null) {
            w.w("MicroMsg.ImageGalleryUI", "try to enterGrid, but adapter is NULL");
            return;
        }
        com.tencent.mm.plugin.report.service.g.oUh.a(219, 13, 1, true);
        int ano = this.vPU.ano();
        if (this.vPU.bWK() == null) {
            w.e("MicroMsg.ImageGalleryUI", "msgInfo is null");
            return;
        }
        int Bw = this.vPU.vPW.Bw(this.mho.ys);
        if (this.vSh) {
            ahz();
            return;
        }
        Intent intent = new Intent();
        intent.setClass(this.uSU.uTo, MediaHistoryGalleryUI.class);
        intent.addFlags(67108864);
        intent.putExtra("kintent_intent_source", i);
        intent.putExtra("kintent_talker", bWX());
        intent.putExtra("kintent_image_count", ano);
        intent.putExtra("kintent_image_index", Bw);
        intent.putExtra("key_biz_chat_id", this.kbc);
        intent.putExtra("key_is_biz_chat", this.sMK);
        startActivity(intent);
        com.tencent.mm.ui.base.b.eM(this.uSU.uTo);
        this.mHandler.postDelayed(new Runnable(this) {
            final /* synthetic */ ImageGalleryUI vSz;

            {
                this.vSz = r1;
            }

            public final void run() {
                this.vSz.finish();
            }
        }, 50);
    }

    public final int bXf() {
        return this.mho.ys;
    }

    public void onClick(View view) {
        boolean z = true;
        if (this.vPU != null) {
            if (view.getId() == R.h.bVv) {
                BD(0);
            } else if (view.getId() == R.h.bJX) {
                w.i("MicroMsg.ImageGalleryUI", "[oreh download_and_save] hdImg suc, curPos:%d", Integer.valueOf(this.mho.ys));
                L(bWW().vRU, 8);
                au Bm = this.vPU.Bm(this.mho.ys);
                com.tencent.mm.ah.d e = this.vPU.e(Bm, false);
                int i = this.mho.ys;
                if (d(Bm, e) && !Bm.bMt() && e.GA()) {
                    this.vPU.al(this.mho.ys, true);
                } else {
                    b.b(this.uSU.uTo, this.vPU.bWK(), true);
                }
            } else if (view.getId() == R.h.bHp) {
                this.vPU.al(this.mho.ys, false);
            } else if (view.getId() == R.h.bHq) {
                this.vPU.Bu(this.mho.ys);
                BC(this.mho.ys);
                bXj();
                bXk();
                bXm();
            } else if (view.getId() == R.h.bnf) {
                onBackPressed();
            } else if (view.getId() == R.h.cLF) {
                onBackPressed();
            } else if (view.getId() == R.h.cjq) {
                boolean isChecked = this.vSn.isChecked();
                if (isChecked || a.vRJ.vQg.size() < 9) {
                    CheckBox checkBox = this.vSn;
                    if (isChecked) {
                        z = false;
                    }
                    checkBox.setChecked(z);
                    if (this.vSn.isChecked()) {
                        a.vRJ.bh(this.vPU.bWK());
                        return;
                    } else {
                        a.vRJ.bi(this.vPU.bWK());
                        return;
                    }
                }
                Toast.makeText(this, getResources().getString(R.l.enW, new Object[]{Integer.valueOf(9)}), 1).show();
            } else if (view.getId() == R.h.crK) {
                this.vPU.Br(this.mho.ys);
            }
        }
    }

    public final void lu(boolean z) {
        try {
            bWU().vSb.bX(!z);
        } catch (Exception e) {
            w.e("MicroMsg.ImageGalleryUI", "set video state iv error : " + e.toString());
        }
    }

    public final boolean bXg() {
        return bWU().vSb.fKD;
    }

    public final void BE(final int i) {
        if (bWU().vSa != null) {
            bWU().vSa.post(new Runnable(this) {
                final /* synthetic */ ImageGalleryUI vSz;

                public final void run() {
                    if (this.vSz.vPU != null) {
                        b f = this.vSz.vPU;
                        f.vQb.pause(i);
                    }
                }
            });
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 82 || keyEvent.getAction() != 1) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (this.qtj != null) {
            this.qtj.bzi();
            this.qtj = null;
            return true;
        }
        ls(true);
        return true;
    }

    final void bXh() {
        if (bWV().vRT != null && !this.vSx) {
            String str = "MicroMsg.ImageGalleryUI";
            String str2 = "fadeOutEnterGirdBtn: %B";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(this.vRT.getVisibility() == 0);
            w.d(str, str2, objArr);
            Animation BF = BF(com.tencent.mm.plugin.appbrand.jsapi.l.e.CTRL_INDEX);
            BF.setFillAfter(false);
            BF.setAnimationListener(new AnimationListener(this) {
                final /* synthetic */ ImageGalleryUI vSz;

                {
                    this.vSz = r1;
                }

                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    this.vSz.bXa();
                    this.vSz.vSx = false;
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            });
            bWV().vRT.startAnimation(BF);
            this.vSx = true;
        }
    }

    final void bXi() {
        if (bWV().vRV != null && !this.vSy) {
            bWV().vRV.startAnimation(BF(com.tencent.mm.plugin.appbrand.jsapi.l.e.CTRL_INDEX));
            this.vSy = true;
        }
    }

    private void bXj() {
        if (bWV().vRT != null && this.vSx && !bXb()) {
            String str = "MicroMsg.ImageGalleryUI";
            String str2 = "fadeInEnterGirdBtn: %B %s";
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(bWV().vRT.getVisibility() == 0);
            objArr[1] = bg.bJZ();
            w.d(str, str2, objArr);
            bWV().vRT.startAnimation(bXl());
            bWW().vRU.startAnimation(bXl());
            this.vSx = false;
        }
    }

    private void bXk() {
        boolean z = true;
        if (bWV().vRV != null && this.vSy) {
            String str = "MicroMsg.ImageGalleryUI";
            String str2 = "fadeInPositionAtChatRecordBtn: %B";
            Object[] objArr = new Object[1];
            if (bWV().vRV.getVisibility() != 0) {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            w.d(str, str2, objArr);
            bWV().vRV.startAnimation(bXl());
            this.vSy = false;
        }
    }

    private static Animation bXl() {
        Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(150);
        alphaAnimation.setFillAfter(true);
        return alphaAnimation;
    }

    static Animation BF(int i) {
        Animation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration((long) i);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setInterpolator(new AccelerateInterpolator(10.0f));
        return alphaAnimation;
    }

    public final boolean oQ() {
        bXh();
        bXi();
        return false;
    }

    protected final void bXm() {
        Object obj = (dx(this.vRW) == 0 && dx(this.vRX) == 0) ? 1 : null;
        if (obj == null && this.vPU != null) {
            w.d("MicroMsg.ImageGalleryUI", "jacks start Hide Timer");
            this.vSw.v(4000, 4000);
        }
    }

    private void bXn() {
        w.d("MicroMsg.ImageGalleryUI", "jacks stop Hide Timer");
        this.vSw.KH();
    }

    public final void BG(int i) {
        ew(true);
        bXe();
        bWT().vRW.setVisibility(0);
        bWT().vRX.setVisibility(8);
        bWT().vRY.setVisibility(0);
        bWT().vRZ.setVisibility(8);
        bXh();
        bXi();
        bWT().vRY.setText(i + "%");
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 82) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void finish() {
        this.vLb.clear();
        super.finish();
    }

    public final int eS(long j) {
        if (bg.mA(this.vSk)) {
            return 0;
        }
        try {
            int e = t.e(j, this.vSk);
            if (e == -1) {
                this.vSk = null;
                e = 0;
            }
            w.d("MicroMsg.ImageGalleryUI", "get enter video op code %d %s", Integer.valueOf(e), this.vSk);
            return e;
        } catch (Exception e2) {
            w.e("MicroMsg.ImageGalleryUI", "get enter video op code error : " + e2.toString());
            return 0;
        }
    }

    public final void eT(long j) {
        if (!bg.mA(this.vSk) && j != 0 && t.e(j, this.vSk) == -1) {
            this.vSk = null;
            w.d("MicroMsg.ImageGalleryUI", "reset enter video op code %s", this.vSk);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 1) {
            w.d("MicroMsg.ImageGalleryUI", "%d image gallery ui is vertical screen", Integer.valueOf(hashCode()));
            bXo();
        } else if (configuration.orientation == 2) {
            w.d("MicroMsg.ImageGalleryUI", "%d image gallery ui is horizontal screen", Integer.valueOf(hashCode()));
            bXp();
        }
    }

    private void bXo() {
        w.i("MicroMsg.ImageGalleryUI", "%d handleVerticalUI image gallery ui isNavigationBarTint %b isNavBarVisibility %b navBarHeight %d", Integer.valueOf(hashCode()), Boolean.valueOf(this.nAn), Boolean.valueOf(x.eF(this)), Integer.valueOf(x.eE(this)));
        if (this.nAn && r0) {
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.vRO.getLayoutParams());
            layoutParams.addRule(12);
            layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.rightMargin, r1);
            this.vRO.setLayoutParams(layoutParams);
            layoutParams = new RelativeLayout.LayoutParams(this.vRP.getLayoutParams());
            layoutParams.addRule(10);
            layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, 0, layoutParams.bottomMargin);
            this.vRP.setLayoutParams(layoutParams);
        }
    }

    private void bXp() {
        boolean eF = x.eF(this);
        int eE = x.eE(this);
        w.i("MicroMsg.ImageGalleryUI", "%d handleHorizontalUI image gallery ui isNavigationBarTint %b isNavBarVisibility %b navBarHeight %d", Integer.valueOf(hashCode()), Boolean.valueOf(this.nAn), Boolean.valueOf(eF), Integer.valueOf(eE));
        if (this.nAn && eF) {
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.vRO.getLayoutParams());
            layoutParams.addRule(12);
            layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, eE, 0);
            this.vRO.setLayoutParams(layoutParams);
            layoutParams = new RelativeLayout.LayoutParams(this.vRP.getLayoutParams());
            layoutParams.addRule(10);
            layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, eE, layoutParams.bottomMargin);
            this.vRP.setLayoutParams(layoutParams);
        }
    }

    private void bXq() {
        String stringExtra = getIntent().getStringExtra("GalleryUI_FromUser");
        String stringExtra2 = getIntent().getStringExtra("GalleryUI_ToUser");
        Intent intent = new Intent();
        au bWK = this.vPU.bWK();
        w.i("MicroMsg.ImageGalleryUI", "edit image path:%s msgId:%s", d.a(bWK, d.bg(bWK), false), Long.valueOf(bWK.field_msgId));
        intent.putExtra("before_photo_edit", r4);
        intent.putExtra("GalleryUI_FromUser", stringExtra);
        intent.putExtra("GalleryUI_ToUser", stringExtra2);
        intent.putExtra("GalleryUI_ToUser", stringExtra2);
        intent.putExtra("from_scene", 291);
        intent.putExtra("after_photo_edit", "");
        com.tencent.mm.bb.d.b(this, "photoedit", ".ui.MMPhotoEditUI", intent, 4369);
        overridePendingTransition(0, 0);
    }
}
