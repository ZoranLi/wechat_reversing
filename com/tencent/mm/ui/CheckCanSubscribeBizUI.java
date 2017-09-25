package com.tencent.mm.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.gr;
import com.tencent.mm.e.b.af;
import com.tencent.mm.modelbiz.w;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.protocal.c.kh;
import com.tencent.mm.protocal.c.ki;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.account.SimpleLoginUI;
import com.tencent.mm.ui.chatting.En_5b8fbb1e;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.mm.y.u;
import java.util.ArrayList;
import java.util.LinkedList;

public class CheckCanSubscribeBizUI extends MMActivity implements a, b, e {
    private String appId;
    private int cGa;
    private String extInfo;
    private String fIq;
    private int fromScene;
    private boolean hoD = false;
    private String osP;
    private int scene;
    private String toUserName;
    private int uOn;
    private LinkedList<avx> uOo;
    private boolean uOp = false;
    private boolean uOq = false;
    private boolean uOr = false;
    private boolean uOs = false;
    private String uOt;
    private int uOu = 0;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.uSU.bQg();
        if (!ap.za() || ap.uP()) {
            MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class), getIntent());
            finish();
            return;
        }
        ap.vd().a(605, this);
        ap.yY();
        c.wR().a(this);
        w.DH().c(this);
        if (So()) {
            String str = this.appId;
            String str2 = this.toUserName;
            String str3 = this.extInfo;
            int i = this.uOn;
            LinkedList linkedList = this.uOo;
            String str4 = this.fIq;
            int i2 = this.cGa;
            int i3 = this.scene;
            com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
            aVar.hsm = new kh();
            aVar.hsn = new ki();
            aVar.uri = "/cgi-bin/micromsg-bin/checkcansubscribebiz";
            aVar.hsl = 605;
            com.tencent.mm.y.b BE = aVar.BE();
            kh khVar = (kh) BE.hsj.hsr;
            khVar.msh = str;
            khVar.mvU = str2;
            khVar.mvZ = str3;
            khVar.tqs = i;
            khVar.tqt = linkedList;
            khVar.tqu = null;
            khVar.tqv = str4;
            khVar.tfW = i2;
            khVar.tdM = i3;
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.CheckCanSubscribeBizUI", "appId(%s) , toUsername(%s) , extInfo(%s) , packNum(%d), scene(%d)", new Object[]{str, str2, str3, Integer.valueOf(i), Integer.valueOf(i3)});
            u.a(BE, new u.a(this) {
                final /* synthetic */ CheckCanSubscribeBizUI uOv;

                {
                    this.uOv = r1;
                }

                public final int a(int i, int i2, String str, com.tencent.mm.y.b bVar, k kVar) {
                    ki kiVar = (ki) bVar.hsk.hsr;
                    this.uOv.osP = kiVar.tqw;
                    if (i == 0 && i2 == 0 && !bg.mA(kiVar.tqw) && !bg.mA(kiVar.mvU)) {
                        this.uOv.toUserName = kiVar.mvU;
                        this.uOv.uOt = kiVar.tqx;
                        this.uOv.bOG();
                    } else if (p.a.a(this.uOv, i, i2, str, 7)) {
                        this.uOv.setResult(5);
                        this.uOv.finish();
                    } else {
                        this.uOv.bOI();
                        this.uOv.setResult(3);
                        this.uOv.finish();
                    }
                    return 0;
                }
            });
            return;
        }
        setResult(2);
        bOJ();
        finish();
    }

    public void onStart() {
        super.onStart();
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.uOo != null) {
            this.uOo.clear();
        }
        if (ap.zb()) {
            ap.vd().b(605, this);
            w.DH().f(this);
            ap.yY();
            c.wR().b(this);
        }
    }

    protected void onPause() {
        super.onPause();
    }

    protected final int getLayoutId() {
        return R.i.dgy;
    }

    private boolean So() {
        Intent intent = getIntent();
        if (intent == null) {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.CheckCanSubscribeBizUI", "intent is null.");
            return false;
        }
        this.appId = intent.getStringExtra("appId");
        this.toUserName = intent.getStringExtra("toUserName");
        if (bg.mA(this.toUserName)) {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.CheckCanSubscribeBizUI", "toUserName is null.");
            return false;
        }
        this.extInfo = intent.getStringExtra("extInfo");
        this.cGa = intent.getIntExtra("source", -1);
        this.scene = intent.getIntExtra("scene", 0);
        this.uOu = intent.getIntExtra("jump_profile_type", 0);
        switch (this.cGa) {
            case 1:
                if (!bg.mA(this.appId)) {
                    this.fromScene = 68;
                    ArrayList stringArrayListExtra = intent.getStringArrayListExtra("androidPackNameList");
                    if (stringArrayListExtra != null && stringArrayListExtra.size() != 0) {
                        this.uOo = new LinkedList();
                        for (int i = 0; i < stringArrayListExtra.size(); i++) {
                            String str = (String) stringArrayListExtra.get(i);
                            if (!bg.mA(str)) {
                                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.CheckCanSubscribeBizUI", "packName(%d) : %s", new Object[]{Integer.valueOf(i), str});
                                this.uOo.add(n.mw(str));
                            }
                        }
                        if (this.uOo.size() != 0) {
                            this.uOn = this.uOo.size();
                            break;
                        }
                        com.tencent.mm.sdk.platformtools.w.e("MicroMsg.CheckCanSubscribeBizUI", "androidPackNameList is nil.");
                        return false;
                    }
                    com.tencent.mm.sdk.platformtools.w.e("MicroMsg.CheckCanSubscribeBizUI", "androidPackNameList is null or nil.");
                    return false;
                }
                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.CheckCanSubscribeBizUI", "appId is null.");
                return false;
                break;
            case 2:
                this.fromScene = 69;
                break;
            default:
                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.CheckCanSubscribeBizUI", "source(%d) is invalidated.", new Object[]{Integer.valueOf(this.cGa)});
                return false;
        }
        this.fIq = intent.getStringExtra("fromURL");
        return true;
    }

    public final void a(int i, int i2, String str, k kVar) {
        com.tencent.mm.sdk.platformtools.w.d("MicroMsg.CheckCanSubscribeBizUI", "onSceneEnd, errType = " + i + ", errCode = " + i2);
        if (kVar.getType() == 605) {
            return;
        }
        if (kVar.getType() == 233) {
            ap.vd().b(233, this);
            if (i == 0 && i2 == 0) {
                l lVar = (l) kVar;
                int IS = lVar.IS();
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.CheckCanSubscribeBizUI", "geta8key, action code = %d", new Object[]{Integer.valueOf(IS)});
                if (IS == 15) {
                    com.tencent.mm.sdk.platformtools.w.d("MicroMsg.CheckCanSubscribeBizUI", "actionCode = %s, url = %s", new Object[]{Integer.valueOf(IS), lVar.IQ()});
                    com.tencent.mm.sdk.b.b grVar = new gr();
                    grVar.fLZ.actionCode = IS;
                    grVar.fLZ.result = r1;
                    grVar.fLZ.context = this;
                    com.tencent.mm.sdk.b.a.urY.a(grVar, Looper.myLooper());
                    finish();
                    return;
                }
                bOI();
                return;
            }
            bOI();
            return;
        }
        com.tencent.mm.sdk.platformtools.w.e("MicroMsg.CheckCanSubscribeBizUI", "un support scene type : %d", new Object[]{Integer.valueOf(kVar.getType())});
    }

    private synchronized void bOG() {
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.CheckCanSubscribeBizUI", "dealSuccess..,canJump = " + this.uOp);
        Intent intent;
        if (this.scene == 1) {
            intent = new Intent();
            intent.putExtra("rawUrl", this.uOt);
            d.b(this, "webview", ".ui.tools.WebViewUI", intent);
            finish();
        } else if (this.scene == 0 && this.uOu == 1) {
            if (this.uOr) {
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.CheckCanSubscribeBizUI", "has jump ignore this scene");
            } else {
                this.uOr = true;
                ap.vd().a(233, this);
                ap.vd().a(new l(this.extInfo, null, 4, (int) System.currentTimeMillis()), 0);
            }
        } else if (bOH() && this.uOp) {
            if (!this.uOr) {
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.CheckCanSubscribeBizUI", "jump to ChattingUI");
                intent = new Intent().putExtra("Chat_User", this.toUserName);
                intent.putExtra("finish_direct", true);
                if (bg.mA(this.toUserName)) {
                    com.tencent.mm.ui.contact.e.a(intent, this.toUserName);
                }
                intent.setClass(this, En_5b8fbb1e.class);
                if (!this.uOq) {
                    setResult(-1);
                    this.uOr = true;
                    startActivity(intent);
                    finish();
                }
            }
        } else if (this.uOp && !this.uOr) {
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.CheckCanSubscribeBizUI", "jump to ContactInfoUI");
            ap.yY();
            af Rc = c.wR().Rc(this.toUserName);
            Intent intent2 = new Intent();
            intent2.putExtra("Contact_Scene", this.fromScene);
            intent2.putExtra("Verify_ticket", this.osP);
            if (Rc != null) {
                intent2.putExtra("Contact_Alias", Rc.pA());
                intent2.putExtra("Contact_Nick", Rc.field_nickname);
                intent2.putExtra("Contact_Signature", Rc.signature);
                intent2.putExtra("Contact_RegionCode", Rc.gkH);
                intent2.putExtra("Contact_Sex", Rc.gkr);
                intent2.putExtra("Contact_VUser_Info", Rc.gkG);
                intent2.putExtra("Contact_VUser_Info_Flag", Rc.field_verifyFlag);
                intent2.putExtra("Contact_KWeibo_flag", Rc.field_weiboFlag);
                intent2.putExtra("Contact_KWeibo", Rc.gkF);
                intent2.putExtra("Contact_KWeiboNick", Rc.field_weiboNickname);
            }
            com.tencent.mm.ui.contact.e.l(intent2, this.toUserName);
            if (!this.uOq) {
                setResult(-1);
                this.uOr = true;
                d.b(this, "profile", ".ui.ContactInfoUI", intent2);
                finish();
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized boolean bOH() {
        /*
        r7 = this;
        r0 = 0;
        r1 = 1;
        monitor-enter(r7);
        com.tencent.mm.u.ap.yY();	 Catch:{ all -> 0x008c }
        r2 = com.tencent.mm.u.c.wR();	 Catch:{ all -> 0x008c }
        r3 = r7.toUserName;	 Catch:{ all -> 0x008c }
        r4 = r2.Rc(r3);	 Catch:{ all -> 0x008c }
        if (r4 == 0) goto L_0x0017;
    L_0x0012:
        r2 = r4.gTQ;	 Catch:{ all -> 0x008c }
        r2 = (int) r2;	 Catch:{ all -> 0x008c }
        if (r2 != 0) goto L_0x00b4;
    L_0x0017:
        r2 = "MicroMsg.CheckCanSubscribeBizUI";
        r3 = "contact is null.";
        com.tencent.mm.sdk.platformtools.w.w(r2, r3);	 Catch:{ all -> 0x008c }
        r2 = r1;
    L_0x0021:
        r3 = 0;
        if (r2 != 0) goto L_0x002a;
    L_0x0024:
        r3 = r7.toUserName;	 Catch:{ all -> 0x008c }
        r3 = com.tencent.mm.modelbiz.e.hW(r3);	 Catch:{ all -> 0x008c }
    L_0x002a:
        if (r3 == 0) goto L_0x0032;
    L_0x002c:
        r5 = r3.CB();	 Catch:{ all -> 0x008c }
        if (r5 == 0) goto L_0x0050;
    L_0x0032:
        r2 = "MicroMsg.CheckCanSubscribeBizUI";
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x008c }
        r6 = "BizInfo(";
        r5.<init>(r6);	 Catch:{ all -> 0x008c }
        r3 = r5.append(r3);	 Catch:{ all -> 0x008c }
        r5 = ") is null or should update.";
        r3 = r3.append(r5);	 Catch:{ all -> 0x008c }
        r3 = r3.toString();	 Catch:{ all -> 0x008c }
        com.tencent.mm.sdk.platformtools.w.e(r2, r3);	 Catch:{ all -> 0x008c }
        r2 = r1;
    L_0x0050:
        r3 = r7.uOs;	 Catch:{ all -> 0x008c }
        if (r3 == 0) goto L_0x007b;
    L_0x0054:
        if (r4 != 0) goto L_0x0065;
    L_0x0056:
        r1 = 0;
        r7.uOp = r1;	 Catch:{ all -> 0x008c }
        r1 = 5;
        r7.setResult(r1);	 Catch:{ all -> 0x008c }
        r7.bOJ();	 Catch:{ all -> 0x008c }
        r7.finish();	 Catch:{ all -> 0x008c }
    L_0x0063:
        monitor-exit(r7);
        return r0;
    L_0x0065:
        r2 = 1;
        r7.uOp = r2;	 Catch:{ all -> 0x008c }
        r2 = 1;
        r7.hoD = r2;	 Catch:{ all -> 0x008c }
        r2 = r4.field_type;	 Catch:{ all -> 0x008c }
        r2 = com.tencent.mm.j.a.ez(r2);	 Catch:{ all -> 0x008c }
        if (r2 == 0) goto L_0x0063;
    L_0x0073:
        r0 = 1;
        r7.uOp = r0;	 Catch:{ all -> 0x008c }
        r0 = 1;
        r7.hoD = r0;	 Catch:{ all -> 0x008c }
        r0 = r1;
        goto L_0x0063;
    L_0x007b:
        if (r2 == 0) goto L_0x009f;
    L_0x007d:
        r1 = r7.uOp;	 Catch:{ all -> 0x008c }
        if (r1 == 0) goto L_0x008f;
    L_0x0081:
        r1 = 5;
        r7.setResult(r1);	 Catch:{ all -> 0x008c }
        r7.bOJ();	 Catch:{ all -> 0x008c }
        r7.finish();	 Catch:{ all -> 0x008c }
        goto L_0x0063;
    L_0x008c:
        r0 = move-exception;
        monitor-exit(r7);
        throw r0;
    L_0x008f:
        r1 = com.tencent.mm.u.ag.a.hlS;	 Catch:{ all -> 0x008c }
        r2 = r7.toUserName;	 Catch:{ all -> 0x008c }
        r3 = "";
        r4 = new com.tencent.mm.ui.CheckCanSubscribeBizUI$1;	 Catch:{ all -> 0x008c }
        r4.<init>(r7);	 Catch:{ all -> 0x008c }
        r1.a(r2, r3, r4);	 Catch:{ all -> 0x008c }
        goto L_0x0063;
    L_0x009f:
        r2 = r4.field_type;	 Catch:{ all -> 0x008c }
        r2 = com.tencent.mm.j.a.ez(r2);	 Catch:{ all -> 0x008c }
        if (r2 != 0) goto L_0x0073;
    L_0x00a7:
        r1 = "MicroMsg.CheckCanSubscribeBizUI";
        r2 = "is not contact.";
        com.tencent.mm.sdk.platformtools.w.w(r1, r2);	 Catch:{ all -> 0x008c }
        r1 = 1;
        r7.uOp = r1;	 Catch:{ all -> 0x008c }
        goto L_0x0063;
    L_0x00b4:
        r2 = r0;
        goto L_0x0021;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.CheckCanSubscribeBizUI.bOH():boolean");
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            this.uOq = true;
            if (this.uOr) {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void bOI() {
        Toast.makeText(this, getString(R.l.eZS), 1).show();
        aqf();
    }

    private void bOJ() {
        Toast.makeText(this, R.l.eKb, 1).show();
        aqf();
    }

    private void aqf() {
        if (this.cGa == 1) {
            LauncherUI.ez(this);
        }
    }

    public final void a(final String str, com.tencent.mm.sdk.e.l lVar) {
        new ae().post(new Runnable(this) {
            final /* synthetic */ CheckCanSubscribeBizUI uOv;

            public final void run() {
                com.tencent.mm.sdk.platformtools.w.d("MicroMsg.CheckCanSubscribeBizUI", "onNotifyChange toUserName = " + this.uOv.toUserName + ", userName = " + str);
                if (this.uOv.toUserName.equals(str)) {
                    this.uOv.uOp = true;
                    if (!this.uOv.hoD) {
                        this.uOv.bOG();
                    }
                }
            }
        });
    }

    public final void a(int i, m mVar, Object obj) {
        if (obj == null || !(obj instanceof String)) {
            com.tencent.mm.sdk.platformtools.w.d("MicroMsg.CheckCanSubscribeBizUI", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[]{Integer.valueOf(i), mVar, obj});
            return;
        }
        a((String) obj, null);
    }
}
