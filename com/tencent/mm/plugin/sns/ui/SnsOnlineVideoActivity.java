package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mm.e.a.gh;
import com.tencent.mm.e.a.ou;
import com.tencent.mm.e.a.ov;
import com.tencent.mm.e.a.po;
import com.tencent.mm.e.a.qv;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.am;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.protocal.c.alh;
import com.tencent.mm.protocal.c.as;
import com.tencent.mm.protocal.c.bfc;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.ui.widget.e;
import com.tencent.mm.ui.x;
import com.tencent.wcdb.FileUtils;

@a(3)
public class SnsOnlineVideoActivity extends MMActivity {
    private String fJz;
    private String fKz;
    private alh fVV;
    private VelocityTracker fk;
    private String hIN;
    private GestureDetector iXs;
    private Bundle klH;
    private boolean klI = false;
    private g klJ;
    private int klK = 0;
    private int klL = 0;
    private int klM = 0;
    private int klN = 0;
    private boolean kmK;
    private boolean lLQ = true;
    private RelativeLayout lMj;
    private ImageView lMk;
    private float mwV = 0.0f;
    private boolean nAn;
    d nxN = new d(this) {
        final /* synthetic */ SnsOnlineVideoActivity qEA;

        {
            this.qEA = r1;
        }

        public final void c(MenuItem menuItem, int i) {
            boolean z = false;
            Intent intent;
            b poVar;
            switch (menuItem.getItemId()) {
                case 1:
                    intent = new Intent();
                    m Gg = ae.beL().Gg(this.qEA.fJz);
                    if (Gg != null) {
                        w.i("MicroMsg.SnsOnlineVideoActivity", "expose id " + Gg.bhe());
                    }
                    intent.putExtra("k_expose_msg_id", Gg == null ? Integer.valueOf(0) : Gg.bhe());
                    intent.putExtra("k_username", Gg == null ? "" : Gg.field_userName);
                    intent.putExtra("showShare", false);
                    intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(33)}));
                    com.tencent.mm.bb.d.b(this.qEA, "webview", ".ui.tools.WebViewUI", intent);
                    return;
                case 2:
                    b poVar2 = new po();
                    poVar2.fWr.fJK = 2;
                    poVar2.fWr.fWs = 17;
                    po.a aVar = poVar2.fWr;
                    if (this.qEA.scene == 0) {
                        z = true;
                    }
                    aVar.fWt = z;
                    poVar2.fWr.fJz = this.qEA.fJz;
                    com.tencent.mm.sdk.b.a.urY.m(poVar2);
                    return;
                case 3:
                    this.qEA.qEt = true;
                    poVar = new po();
                    poVar.fWr.fJK = 1;
                    poVar.fWr.fWu = 4097;
                    poVar.fWr.fJz = this.qEA.fJz;
                    com.tencent.mm.sdk.b.a.urY.m(poVar);
                    return;
                case 4:
                    m Gg2 = ae.beL().Gg(this.qEA.fJz);
                    if (Gg2 != null) {
                        intent = new Intent();
                        if (Gg2.bhd().ufB.tsN == 15 && ((alh) Gg2.bhd().ufB.tsO.get(0)) == null) {
                            w.w("MicroMsg.SnsOnlineVideoActivity", "send sight fail, mediaObj is null");
                            return;
                        }
                        intent.putExtra("exdevice_open_scene_type", 2);
                        intent.putExtra("sns_local_id", this.qEA.fJz);
                        intent.putExtra("sns_send_data_ui_activity", true);
                        com.tencent.mm.bb.d.a(this.qEA, ".ui.chatting.ChattingSendDataToDeviceUI", intent);
                        return;
                    }
                    return;
                case 5:
                    poVar = new po();
                    poVar.fWr.fJK = 3;
                    poVar.fWr.fJz = this.qEA.fJz;
                    com.tencent.mm.sdk.b.a.urY.m(poVar);
                    return;
                default:
                    return;
            }
        }
    };
    private OnlineVideoView qEs;
    private boolean qEt = false;
    private boolean qEu;
    private float qEv = 0.0f;
    private boolean qEw = false;
    private boolean qEx = false;
    private boolean qEy = false;
    c qEz = new c(this) {
        final /* synthetic */ SnsOnlineVideoActivity qEA;

        {
            this.qEA = r1;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(com.tencent.mm.ui.base.l r10) {
            /*
            r9 = this;
            r8 = 2;
            r0 = 1;
            r1 = 0;
            r2 = com.tencent.mm.i.g.sV();
            r3 = "SIGHTCannotTransmitForFav";
            r2 = r2.getValue(r3);
            r2 = com.tencent.mm.sdk.platformtools.bg.PY(r2);
            if (r2 != 0) goto L_0x0098;
        L_0x0014:
            r2 = r9.qEA;
            r2 = r2.fKz;
            r2 = com.tencent.mm.modelsfs.FileOp.aO(r2);
            r3 = r9.qEA;
            r3 = r3.hIN;
            r3 = com.tencent.mm.modelsfs.FileOp.aO(r3);
            r4 = "MicroMsg.SnsOnlineVideoActivity";
            r5 = "config can forward sight, thumb existed %B, video existed %B";
            r6 = new java.lang.Object[r8];
            r7 = java.lang.Boolean.valueOf(r2);
            r6[r1] = r7;
            r7 = java.lang.Boolean.valueOf(r3);
            r6[r0] = r7;
            com.tencent.mm.sdk.platformtools.w.i(r4, r5, r6);
            r4 = 3;
            r5 = r9.qEA;
            r6 = com.tencent.mm.plugin.sns.i.j.pKn;
            r5 = r5.getString(r6);
            r10.add(r1, r4, r1, r5);
            if (r2 == 0) goto L_0x0098;
        L_0x004d:
            if (r3 == 0) goto L_0x0098;
        L_0x004f:
            r2 = "favorite";
            r2 = com.tencent.mm.bb.d.Jt(r2);
            if (r2 == 0) goto L_0x0063;
        L_0x0058:
            r2 = r9.qEA;
            r3 = com.tencent.mm.plugin.sns.i.j.eGa;
            r2 = r2.getString(r3);
            r10.add(r1, r8, r1, r2);
        L_0x0063:
            r2 = 5;
            r3 = r9.qEA;
            r4 = com.tencent.mm.plugin.sns.i.j.eOn;
            r3 = r3.getString(r4);
            r10.add(r1, r2, r1, r3);
            if (r0 == 0) goto L_0x0097;
        L_0x0071:
            r0 = new com.tencent.mm.e.a.dd;
            r0.<init>();
            r2 = r0.fGW;
            r3 = r9.qEA;
            r3 = r3.fJz;
            r2.fGN = r3;
            r2 = com.tencent.mm.sdk.b.a.urY;
            r2.m(r0);
            r0 = r0.fGX;
            r0 = r0.fGu;
            if (r0 == 0) goto L_0x0097;
        L_0x008b:
            r0 = 4;
            r2 = r9.qEA;
            r3 = com.tencent.mm.plugin.sns.i.j.pJF;
            r2 = r2.getString(r3);
            r10.add(r1, r0, r1, r2);
        L_0x0097:
            return;
        L_0x0098:
            r0 = r1;
            goto L_0x004f;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity.2.a(com.tencent.mm.ui.base.l):void");
        }
    };
    private e qtj;
    private boolean qvx;
    private m qyq;
    private Button qzc;
    private float qzl = 1.0f;
    private int qzm = 0;
    private int qzn = 0;
    private int scene = 0;

    public void onCreate(Bundle bundle) {
        OnlineVideoView onlineVideoView;
        if (getIntent().getExtras() != null) {
            getIntent().getExtras().setClassLoader(getClass().getClassLoader());
        }
        super.onCreate(bundle);
        this.uSU.bQg();
        try {
            if (com.tencent.mm.compatible.util.d.eo(19)) {
                getWindow().setFlags(201327616, 201327616);
                this.nAn = true;
            } else {
                getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                this.nAn = false;
            }
            getWindow().addFlags(FileUtils.S_IWUSR);
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.SnsOnlineVideoActivity", e, "", new Object[0]);
        }
        this.klH = bundle;
        this.fKz = getIntent().getStringExtra("intent_thumbpath");
        this.fJz = getIntent().getStringExtra("intent_localid");
        this.scene = getIntent().getIntExtra("intent_from_scene", -1);
        this.qvx = getIntent().getBooleanExtra("intent_ispreview", false);
        this.kmK = getIntent().getBooleanExtra("intent_ismute", false);
        w.i("MicroMsg.SnsOnlineVideoActivity", "init data get intent info finish. thumbPath %s localId %s scene %d isPreView %b isMute %b videoPath %s", new Object[]{this.fKz, this.fJz, Integer.valueOf(this.scene), Boolean.valueOf(this.qvx), Boolean.valueOf(this.kmK), getIntent().getStringExtra("intent_videopath")});
        if (this.qvx) {
            this.hIN = r0;
        } else {
            try {
                this.qyq = ae.beL().Gg(this.fJz);
                this.fVV = (alh) this.qyq.bhd().ufB.tsO.get(0);
                this.hIN = am.du(ae.getAccSnsPath(), this.fVV.mQY) + i.j(this.fVV);
                w.i("MicroMsg.SnsOnlineVideoActivity", "init data finish, sns info local id %s ", new Object[]{this.qyq.bhy()});
            } catch (Exception e2) {
                w.e("MicroMsg.SnsOnlineVideoActivity", "init data exception " + e2.toString());
            }
        }
        this.lMj = (RelativeLayout) findViewById(f.cMn);
        this.qEs = (OnlineVideoView) findViewById(f.cMo);
        if (this.qvx) {
            onlineVideoView = this.qEs;
            String str = this.hIN;
            String str2 = this.fKz;
            onlineVideoView.qvy = str;
            onlineVideoView.qvx = true;
            onlineVideoView.lKn.setImageBitmap(BackwardSupportUtil.b.c(str2, 1.0f));
            w.i("MicroMsg.OnlineVideoView", "%d set preview video %s isPreview %b ", new Object[]{Integer.valueOf(onlineVideoView.hashCode()), str, Boolean.valueOf(onlineVideoView.qvx)});
        } else {
            this.qEs.a(this.fVV, this.qyq.bhy(), this.qyq.field_createTime);
        }
        onlineVideoView = this.qEs;
        onlineVideoView.kmK = this.kmK;
        onlineVideoView.kmM.bQ(onlineVideoView.kmK);
        this.lMk = (ImageView) findViewById(f.bSt);
        this.lMk.setLayerType(2, null);
        this.lMj.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ SnsOnlineVideoActivity qEA;

            {
                this.qEA = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                this.qEA.ahz();
                return true;
            }
        });
        this.iXs = new GestureDetector(this.uSU.uTo, new SimpleOnGestureListener(this) {
            final /* synthetic */ SnsOnlineVideoActivity qEA;

            {
                this.qEA = r1;
            }

            public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                float rawX = motionEvent2.getRawX() - motionEvent.getRawX();
                float rawY = motionEvent2.getRawY() - motionEvent.getRawY();
                if (Math.abs(rawX) <= ((float) this.qEA.lMj.getWidth()) && Math.abs(rawY) <= ((float) this.qEA.lMj.getHeight()) && this.qEA.qEw) {
                    this.qEA.qEs.setTranslationX(rawX);
                    this.qEA.qEs.setTranslationY(rawY);
                }
                return true;
            }

            public final void onLongPress(MotionEvent motionEvent) {
                this.qEA.qEy = true;
                super.onLongPress(motionEvent);
            }

            public final boolean onSingleTapUp(MotionEvent motionEvent) {
                this.qEA.ahz();
                return super.onSingleTapUp(motionEvent);
            }
        });
        this.qEs.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ SnsOnlineVideoActivity qEA;

            {
                this.qEA = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                float f = 1.0f;
                this.qEA.iXs.onTouchEvent(motionEvent);
                if (this.qEA.fk == null) {
                    this.qEA.fk = VelocityTracker.obtain();
                }
                if (this.qEA.fk != null) {
                    this.qEA.fk.addMovement(motionEvent);
                }
                switch (motionEvent.getAction() & 255) {
                    case 0:
                        this.qEA.mwV = motionEvent.getX();
                        this.qEA.qEv = motionEvent.getY();
                        if (this.qEA.qEx) {
                            this.qEA.ahB();
                            this.qEA.qEx = false;
                            break;
                        }
                        break;
                    case 1:
                        if (this.qEA.qEx) {
                            this.qEA.qEs.setPivotX((float) (this.qEA.lMj.getWidth() / 2));
                            this.qEA.qEs.setPivotY((float) (this.qEA.lMj.getHeight() / 2));
                            this.qEA.qEs.setScaleX(1.0f);
                            this.qEA.qEs.setScaleY(1.0f);
                            this.qEA.qEs.setTranslationX(0.0f);
                            this.qEA.qEs.setTranslationY(0.0f);
                            this.qEA.lMk.setAlpha(1.0f);
                            this.qEA.qzl = 1.0f;
                            this.qEA.qEw = false;
                            this.qEA.qEy = false;
                            return true;
                        } else if (!this.qEA.qEw || this.qEA.qEy) {
                            this.qEA.qEy = false;
                            break;
                        } else {
                            this.qEA.ahz();
                            this.qEA.qEy = false;
                            return true;
                        }
                        break;
                    case 2:
                        VelocityTracker e = this.qEA.fk;
                        e.computeCurrentVelocity(1000);
                        int xVelocity = (int) e.getXVelocity();
                        int yVelocity = (int) e.getYVelocity();
                        float translationX = this.qEA.qEs.getTranslationX();
                        float translationY = this.qEA.qEs.getTranslationY();
                        this.qEA.qzm = (int) translationX;
                        this.qEA.qzn = (int) translationY;
                        w.d("MicroMsg.SnsOnlineVideoActivity", "dancy scaled:%s, tx:%s, ty:%s, vx:%s, vy:%s", new Object[]{Boolean.valueOf(this.qEA.qEw), Float.valueOf(translationX), Float.valueOf(translationY), Integer.valueOf(xVelocity), Integer.valueOf(yVelocity)});
                        if ((Math.abs(translationX) > 250.0f || Math.abs(yVelocity) <= Math.abs(xVelocity) || yVelocity <= 0 || this.qEA.qEy) && !this.qEA.qEw) {
                            this.qEA.qEw = false;
                        } else {
                            translationX = 1.0f - (translationY / ((float) this.qEA.lMj.getHeight()));
                            if (translationX <= 1.0f) {
                                f = translationX;
                            }
                            if (((yVelocity > 0 && f < this.qEA.qzl) || yVelocity < 0) && ((double) f) >= 0.5d) {
                                w.d("MicroMsg.SnsOnlineVideoActivity", "dancy scale:%s", new Object[]{Float.valueOf(f)});
                                this.qEA.qzl = f;
                                this.qEA.qEs.setPivotX((float) (this.qEA.lMj.getWidth() / 2));
                                this.qEA.qEs.setPivotY((float) (this.qEA.lMj.getHeight() / 2));
                                this.qEA.qEs.setScaleX(f);
                                this.qEA.qEs.setScaleY(f);
                                this.qEA.qEs.setTranslationY(translationY);
                                this.qEA.lMk.setAlpha(f);
                            }
                            this.qEA.qEw = true;
                        }
                        if (translationY > 200.0f) {
                            this.qEA.qEx = false;
                        } else if (translationY > 10.0f) {
                            this.qEA.qEx = true;
                        }
                        if (translationY > 50.0f) {
                            this.qEA.qEs.setOnLongClickListener(null);
                        }
                        if (this.qEA.fk != null) {
                            this.qEA.fk.recycle();
                            this.qEA.fk = null;
                        }
                        if (this.qEA.qEw) {
                            return true;
                        }
                        break;
                }
                return false;
            }
        });
        this.klJ = new g(this.uSU.uTo);
        m mVar = this.qyq;
        if (mVar == null) {
            w.i("MicroMsg.SnsOnlineVideoActivity", "snsInfo is null, return");
        } else {
            this.qzc = (Button) findViewById(f.pCC);
            final bfc bhd = mVar.bhd();
            final as asVar = bhd != null ? bhd.pYt : null;
            ax axVar = new ax();
            af.a(this, axVar, bhd.pYt);
            if (axVar.qJb) {
                this.qzc.setVisibility(0);
                this.qzc.setText(axVar.qJc);
                this.qzc.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ SnsOnlineVideoActivity qEA;

                    public final void onClick(View view) {
                        if (asVar.tdQ != null) {
                            this.qEA.qEu = true;
                            String bm = com.tencent.mm.plugin.sns.c.a.imw.bm(asVar.tdQ.mtb);
                            int i = 0;
                            if (bhd.ufB.tsN == 1) {
                                i = 2;
                            } else if (bhd.ufB.tsN == 3) {
                                i = 5;
                            } else if (bhd.ufB.tsN == 15) {
                                i = 38;
                            }
                            if (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.a(bhd, this.qEA)) {
                                com.tencent.mm.plugin.sns.c.a.imw.a(this.qEA, asVar.tdQ.mtb, bm, bhd.jNj, i, 19, 9, asVar.tdQ.tdJ, bhd.mQY);
                                return;
                            }
                            b ghVar;
                            switch (asVar.jOc) {
                                case 4:
                                    Intent intent = new Intent();
                                    intent.putExtra("rawUrl", asVar.msN);
                                    com.tencent.mm.plugin.sns.c.a.imv.j(intent, this.qEA);
                                    com.tencent.mm.plugin.sns.c.a.imw.a(this.qEA, asVar.tdQ.mtb, bm, bhd.jNj, i, 19, 1, asVar.tdQ.tdJ, bhd.mQY);
                                    return;
                                case 5:
                                    if (asVar.tdM == 1) {
                                        ghVar = new gh();
                                        ghVar.fLB.actionCode = 2;
                                        ghVar.fLB.scene = 3;
                                        ghVar.fLB.appId = asVar.tdQ.mtb;
                                        ghVar.fLB.context = this.qEA;
                                        com.tencent.mm.sdk.b.a.urY.m(ghVar);
                                        com.tencent.mm.plugin.sns.c.a.imw.a(this.qEA, asVar.tdQ.mtb, bm, bhd.jNj, i, 19, 6, asVar.tdQ.tdJ, bhd.mQY);
                                        return;
                                    }
                                    return;
                                case 6:
                                    int a = af.a(this.qEA, asVar);
                                    if (a == 1) {
                                        ghVar = new gh();
                                        ghVar.fLB.context = this.qEA;
                                        ghVar.fLB.actionCode = 2;
                                        ghVar.fLB.appId = asVar.tdQ.mtb;
                                        ghVar.fLB.messageAction = asVar.tdQ.tdL;
                                        ghVar.fLB.messageExt = asVar.tdQ.tdK;
                                        ghVar.fLB.scene = 3;
                                        com.tencent.mm.sdk.b.a.urY.m(ghVar);
                                        com.tencent.mm.plugin.sns.c.a.imw.a(this.qEA, asVar.tdQ.mtb, bm, bhd.jNj, i, 19, 6, asVar.tdQ.tdJ, bhd.mQY);
                                        return;
                                    } else if (a == 2) {
                                        b ghVar2 = new gh();
                                        ghVar2.fLB.context = this.qEA;
                                        ghVar2.fLB.actionCode = 1;
                                        ghVar2.fLB.appId = asVar.tdQ.mtb;
                                        ghVar2.fLB.messageAction = asVar.tdQ.tdL;
                                        ghVar2.fLB.messageExt = asVar.tdQ.tdK;
                                        ghVar2.fLB.scene = 3;
                                        com.tencent.mm.sdk.b.a.urY.m(ghVar2);
                                        com.tencent.mm.plugin.sns.c.a.imw.a(this.qEA, asVar.tdQ.mtb, bm, bhd.jNj, i, 19, 3, asVar.tdQ.tdJ, bhd.mQY);
                                        return;
                                    } else {
                                        return;
                                    }
                                default:
                                    return;
                            }
                        }
                    }
                });
                if (getRequestedOrientation() != 0) {
                    bkF();
                }
            } else {
                this.qzc.setVisibility(8);
            }
        }
        ahB();
        b qvVar = new qv();
        qvVar.fXQ.type = 1;
        com.tencent.mm.sdk.b.a.urY.m(qvVar);
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.sns.i.g.pIx;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 1) {
            w.d("MicroMsg.SnsOnlineVideoActivity", "vertical orientation");
            bkF();
        } else if (configuration.orientation == 2) {
            w.d("MicroMsg.SnsOnlineVideoActivity", "horizontal orientation");
            if (this.qzc != null && this.qzc.getVisibility() == 0) {
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.qzc.getLayoutParams();
                if (marginLayoutParams.bottomMargin != getResources().getDimensionPixelSize(com.tencent.mm.plugin.sns.i.d.pzm)) {
                    marginLayoutParams.bottomMargin = getResources().getDimensionPixelSize(com.tencent.mm.plugin.sns.i.d.pzm);
                    this.qzc.setLayoutParams(marginLayoutParams);
                }
            }
        }
    }

    private void bkF() {
        boolean eF = x.eF(this);
        int eE = x.eE(this);
        if (this.nAn && eF && this.qzc != null && this.qzc.getVisibility() == 0) {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.qzc.getLayoutParams();
            marginLayoutParams.bottomMargin = eE + marginLayoutParams.bottomMargin;
            this.qzc.setLayoutParams(marginLayoutParams);
        }
    }

    private void ahB() {
        if (this.qvx) {
            w.i("MicroMsg.SnsOnlineVideoActivity", "it is preview mode, don't register menu.");
        } else {
            this.qEs.setOnLongClickListener(new OnLongClickListener(this) {
                final /* synthetic */ SnsOnlineVideoActivity qEA;

                {
                    this.qEA = r1;
                }

                public final boolean onLongClick(View view) {
                    this.qEA.qtj = new e(this.qEA.uSU.uTo, e.wuP, false);
                    this.qEA.qtj.qJf = this.qEA.qEz;
                    this.qEA.qtj.qJg = this.qEA.nxN;
                    this.qEA.qtj.wva = new e.a(this) {
                        final /* synthetic */ AnonymousClass7 qEB;

                        {
                            this.qEB = r1;
                        }

                        public final void onDismiss() {
                            this.qEB.qEA.qtj = null;
                        }
                    };
                    this.qEA.qtj.bzh();
                    return true;
                }
            });
        }
    }

    public void onStart() {
        Bundle bundle = this.klH;
        if (!this.klI) {
            this.klI = true;
            if (VERSION.SDK_INT >= 12) {
                this.klK = getIntent().getIntExtra("img_gallery_top", 0);
                this.klL = getIntent().getIntExtra("img_gallery_left", 0);
                this.klM = getIntent().getIntExtra("img_gallery_width", 0);
                this.klN = getIntent().getIntExtra("img_gallery_height", 0);
                this.klJ.p(this.klL, this.klK, this.klM, this.klN);
                if (bundle == null) {
                    this.qEs.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener(this) {
                        final /* synthetic */ SnsOnlineVideoActivity qEA;

                        {
                            this.qEA = r1;
                        }

                        public final boolean onPreDraw() {
                            this.qEA.qEs.getViewTreeObserver().removeOnPreDrawListener(this);
                            this.qEA.klJ.a(this.qEA.qEs, this.qEA.lMk, new g.b(this) {
                                final /* synthetic */ AnonymousClass10 qEC;

                                {
                                    this.qEC = r1;
                                }

                                public final void onAnimationStart() {
                                }

                                public final void onAnimationEnd() {
                                    if (this.qEC.qEA.qEs != null) {
                                        this.qEC.qEA.qEs.onResume();
                                    }
                                }
                            });
                            return true;
                        }
                    });
                }
            }
        }
        super.onStart();
    }

    protected void onResume() {
        if (VERSION.SDK_INT >= 21) {
            getWindow().clearFlags(2048);
        }
        if (!this.lLQ) {
            this.qEs.onResume();
        }
        this.lLQ = false;
        if (this.qEt) {
            this.qEt = false;
        }
        super.onResume();
    }

    protected void onPause() {
        if (VERSION.SDK_INT >= 21) {
            getWindow().setFlags(2048, 2048);
        }
        this.qEs.onPause();
        if (!this.qEt) {
            w.d("MicroMsg.SnsOnlineVideoActivity", "close Popup");
            if (this.qEu) {
                new com.tencent.mm.sdk.platformtools.ae().postDelayed(new Runnable(this) {
                    final /* synthetic */ SnsOnlineVideoActivity qEA;

                    {
                        this.qEA = r1;
                    }

                    public final void run() {
                        this.qEA.finish();
                    }
                }, 500);
            } else {
                new com.tencent.mm.sdk.platformtools.ae().post(new Runnable(this) {
                    final /* synthetic */ SnsOnlineVideoActivity qEA;

                    {
                        this.qEA = r1;
                    }

                    public final void run() {
                        this.qEA.finish();
                    }
                });
            }
        }
        super.onPause();
    }

    protected void onDestroy() {
        this.qEs.onDestroy();
        try {
            getWindow().clearFlags(FileUtils.S_IWUSR);
        } catch (Exception e) {
        }
        super.onDestroy();
    }

    public final void ahz() {
        if (this.qzc != null && this.qzc.getVisibility() == 0) {
            this.qzc.setVisibility(8);
        }
        int width = this.lMj.getWidth();
        int height = this.lMj.getHeight();
        if (!(this.klM == 0 || this.klN == 0)) {
            height = (int) ((((float) width) / ((float) this.klM)) * ((float) this.klN));
        }
        this.klJ.ek(width, height);
        this.klJ.p(this.klL, this.klK, this.klM, this.klN);
        if (((double) this.qzl) != 1.0d) {
            this.klJ.wmy = 1.0f / this.qzl;
            if (!(this.qzm == 0 && this.qzn == 0)) {
                this.klJ.el(((int) (((float) (this.lMj.getWidth() / 2)) * (1.0f - this.qzl))) + this.qzm, (int) (((float) ((this.lMj.getHeight() / 2) + this.qzn)) - (((float) (height / 2)) * this.qzl)));
            }
        }
        this.klJ.a(this.qEs, this.lMk, new g.b(this) {
            final /* synthetic */ SnsOnlineVideoActivity qEA;

            {
                this.qEA = r1;
            }

            public final void onAnimationStart() {
            }

            public final void onAnimationEnd() {
                new com.tencent.mm.sdk.platformtools.ae().post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass11 qED;

                    {
                        this.qED = r1;
                    }

                    public final void run() {
                        this.qED.qEA.finish();
                        this.qED.qEA.overridePendingTransition(0, 0);
                    }
                });
            }
        }, null);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        w.d("MicroMsg.SnsOnlineVideoActivity", "dispatchKeyEvent");
        ahz();
        return true;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        w.i("MicroMsg.SnsOnlineVideoActivity", "on activity result reqCode %d resultCode %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (4097 == i && -1 == i2) {
            String stringExtra = intent.getStringExtra("Select_Conv_User");
            String stringExtra2 = intent.getStringExtra("custom_send_text");
            for (String str : bg.f(stringExtra.split(","))) {
                if (this.scene == 0) {
                    m Gg = ae.beL().Gg(this.fJz);
                    if (Gg != null) {
                        b ouVar;
                        if (o.dH(str)) {
                            ouVar = new ou();
                            ouVar.fVO.fVJ = i.g(Gg);
                            ouVar.fVO.fGN = Gg.bhy();
                            com.tencent.mm.sdk.b.a.urY.m(ouVar);
                        } else {
                            ouVar = new ov();
                            ouVar.fVP.fVJ = i.g(Gg);
                            ouVar.fVP.fGN = Gg.bhy();
                            com.tencent.mm.sdk.b.a.urY.m(ouVar);
                        }
                    }
                }
                bfc bhd = this.qyq.bhd();
                int ER = i.ER(this.hIN);
                if (bg.mA(this.fKz)) {
                    alh com_tencent_mm_protocal_c_alh = this.fVV;
                    if (com_tencent_mm_protocal_c_alh == null) {
                        stringExtra = "";
                    } else {
                        String du = am.du(ae.getAccSnsPath(), com_tencent_mm_protocal_c_alh.mQY);
                        stringExtra = du + i.e(com_tencent_mm_protocal_c_alh);
                        w.d("MicroMsg.SnsVideoLogic", "get sns video thumb path %s [%b]", new Object[]{stringExtra, Boolean.valueOf(FileOp.aO(stringExtra))});
                        if (!FileOp.aO(stringExtra)) {
                            stringExtra = du + i.n(com_tencent_mm_protocal_c_alh);
                            w.i("MicroMsg.SnsVideoLogic", "get sns video thumb path %s", new Object[]{stringExtra});
                        }
                    }
                } else {
                    stringExtra = this.fKz;
                }
                this.fKz = stringExtra;
                w.i("MicroMsg.SnsOnlineVideoActivity", "send sight to %s, videopath %s, thumbpath %s url: %s time: %d, duration: %s", new Object[]{str, this.hIN, this.fKz, this.fVV.tPp, Integer.valueOf(this.fVV.qLq), Integer.valueOf(ER)});
                com.tencent.mm.plugin.messenger.a.d.aJW().a(this, str, this.hIN, this.fKz, 43, ER, bhd.qui);
                if (stringExtra2 != null) {
                    com.tencent.mm.plugin.messenger.a.d.aJW().cM(stringExtra2, str);
                }
                com.tencent.mm.ui.snackbar.a.e(this, getString(j.esl));
            }
        }
        super.onActivityResult(i, i2, intent);
    }
}
