package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.Display;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.compatible.d.l;
import com.tencent.mm.compatible.loader.d;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.ipcall.a.c.b;
import com.tencent.mm.plugin.ipcall.a.f;
import com.tencent.mm.plugin.ipcall.a.g.k;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.ipcall.b.c;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import com.tencent.qqmusic.mediaplayer.PlayerException;

@a(3)
public class IPCallTalkUI extends MMActivity implements j.a {
    private String mTP;
    private String mTQ;
    private String mTR;
    private String mTS;
    private int mTT;
    private int mTU;
    private j mXF;
    private String mwO;

    protected final int Ol() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        cO().cP().hide();
        getWindow().addFlags(6946944);
        this.mwO = getIntent().getStringExtra("IPCallTalkUI_nickname");
        this.mTP = getIntent().getStringExtra("IPCallTalkUI_phoneNumber");
        this.mTQ = getIntent().getStringExtra("IPCallTalkUI_contactId");
        this.mTR = getIntent().getStringExtra("IPCallTalkUI_countryCode");
        this.mTS = getIntent().getStringExtra("IPCallTalkUI_toWechatUsername");
        this.mTT = getIntent().getIntExtra("IPCallTalkUI_dialScene", 0);
        this.mTU = getIntent().getIntExtra("IPCallTalkUI_countryType", 0);
        w.i("MicroMsg.IPCallTalkUI", "onCreate, mNickname: %s, mPhoneNumber: %s, mContactId: %s, mCountryCode: %s, toUsername:%s, mDialScene:%d ,mCountryType:%d", new Object[]{this.mwO, this.mTP, this.mTQ, this.mTR, this.mTS, Integer.valueOf(this.mTT), Integer.valueOf(this.mTU)});
        w.i("MicroMsg.IPCallTalkUI", "summerper checkPermission checkMicrophone[%b],stack[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.RECORD_AUDIO", 80, null, null)), bg.bJZ()});
        if (com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.RECORD_AUDIO", 80, null, null)) {
            init();
        }
    }

    private void init() {
        this.mXF = new j(this);
        this.mXF.mYq = this;
        j jVar = this.mXF;
        String str = this.mwO;
        String str2 = this.mTP;
        String str3 = this.mTQ;
        String str4 = this.mTR;
        String str5 = this.mTS;
        int i = this.mTT;
        int i2 = this.mTU;
        jVar.mYw = jVar.mYo.getIntent().getBooleanExtra("IPCallTalkUI_isFromMiniNotification", false);
        w.i("MicroMsg.TalkUIController", "onCreate, mNickname: %s, mPhoneNumber: %s, mContactId: %s, mCountryCode: %s, toUsername: %s, isFromMinimize: %b", new Object[]{str, str2, str3, str4, str5, Boolean.valueOf(jVar.mYw)});
        jVar.mYe = (ImageView) jVar.mYo.findViewById(R.h.cHo);
        jVar.ioV = (ImageView) jVar.mYo.findViewById(R.h.cHn);
        jVar.mYc = (EditText) jVar.mYo.findViewById(R.h.cHs);
        jVar.ipa = (TextView) jVar.mYo.findViewById(R.h.cHv);
        jVar.mYd = (TextView) jVar.mYo.findViewById(R.h.cHt);
        jVar.mYf = (IPCallFuncButton) jVar.mYo.findViewById(R.h.cHr);
        jVar.mYg = (IPCallFuncButton) jVar.mYo.findViewById(R.h.cHp);
        jVar.mYh = (IPCallFuncButton) jVar.mYo.findViewById(R.h.cHu);
        jVar.mYi = (ImageButton) jVar.mYo.findViewById(R.h.cHq);
        jVar.mYl = (ImageButton) jVar.mYo.findViewById(R.h.bYT);
        jVar.mYj = (TextView) jVar.mYo.findViewById(R.h.cOj);
        jVar.mYk = jVar.mYo.findViewById(R.h.cOk);
        jVar.mRs = (DialPad) jVar.mYo.findViewById(R.h.bJl);
        String str6;
        if (jVar.mYw) {
            jVar.mwO = i.aEh().mNd.fFa;
            jVar.mYn = i.aEh().mNd.mOo;
            jVar.mTS = i.aEh().mNd.fVb;
            jVar.mTQ = i.aEh().mNd.fWT;
            jVar.mTP = i.aEh().mNd.mOn;
            jVar.mYm = i.aEh().mNd.mOq;
            w.i("MicroMsg.TalkUIController", "restoreParam nickname:%s,fianlPhoneNumber:%s,toUserName:%s,contactId:%s,phoneNumber:%s,phoneType:%d", new Object[]{jVar.mwO, jVar.mYn, jVar.mTS, jVar.mTQ, jVar.mTP, Integer.valueOf(jVar.mYm)});
            jVar.aFp();
            jVar.aFq();
            i.aEl();
            w.i("MicroMsg.TalkUIController", f.stateToString(i.aEl().mMN));
            jVar.ox(i.aEl().mMN);
            str6 = i.aEh().mNd.mOo;
            str = i.aEh().mNd.mOp;
            if (!bg.mA(str)) {
                jVar.yO(str);
                jVar.mYd.setText(com.tencent.mm.plugin.ipcall.b.a.yY(str));
            } else if (!bg.mA(str6)) {
                jVar.yO(str6);
                jVar.mYd.setText(com.tencent.mm.plugin.ipcall.b.a.yY(str6));
            }
            if (i.aEl().aEc()) {
                IPCallFuncButton iPCallFuncButton = jVar.mYh;
                i.aEk();
                iPCallFuncButton.setChecked(com.tencent.mm.plugin.ipcall.a.b.a.qN());
                jVar.mYf.setChecked(i.aEk().mOA.kmK);
            }
        } else if (i.aEl().aEb()) {
            g.a(jVar.mYo, R.l.esD, R.l.dIO, false, new OnClickListener(jVar) {
                final /* synthetic */ j mYz;

                {
                    this.mYz = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.mYz.mYo.finish();
                }
            });
        } else {
            jVar.aFp();
            jVar.mwO = str;
            jVar.mTP = str2;
            jVar.mTQ = str3;
            jVar.mTR = str4;
            jVar.mTT = i;
            jVar.mTU = i2;
            if (!bg.mA(jVar.mTP)) {
                jVar.mTP = c.zc(jVar.mTP);
            }
            if (bg.mA(jVar.mTR)) {
                if (com.tencent.mm.plugin.ipcall.b.a.yW(jVar.mTP)) {
                    str6 = com.tencent.mm.plugin.ipcall.b.a.yU(jVar.mTP);
                    if (bg.mA(str6)) {
                        jVar.mTP = com.tencent.mm.plugin.ipcall.b.a.yX(jVar.mTP);
                    } else {
                        jVar.mTP = com.tencent.mm.plugin.ipcall.b.a.yZ(jVar.mTP);
                        jVar.mTR = str6;
                    }
                }
                jVar.mTR = c.aFy();
            }
            w.i("MicroMsg.TalkUIController", "final mCountryCode: %s", new Object[]{jVar.mTR});
            com.tencent.mm.plugin.ipcall.a.c aDT = com.tencent.mm.plugin.ipcall.a.c.aDT();
            str = jVar.mTR;
            if (!aDT.isInit) {
                aDT.eP(false);
            }
            if (!bg.mA(str)) {
                i.aEp().v(bg.getInt(str.replace("+", ""), 0), bg.Nz());
                aDT.aDV();
            }
            if (bg.mA(jVar.mwO)) {
                jVar.mwO = com.tencent.mm.plugin.ipcall.b.a.aj(jVar.mYo, jVar.mTP);
            }
            jVar.mTS = str5;
            if (bg.mA(jVar.mTR) || com.tencent.mm.plugin.ipcall.b.a.yW(jVar.mTP)) {
                jVar.mYn = jVar.mTP;
            } else {
                jVar.mYn = jVar.mTR + jVar.mTP;
                if (!jVar.mYn.startsWith("+")) {
                    jVar.mYn = "+" + jVar.mYn;
                }
            }
            w.i("MicroMsg.TalkUIController", "final call mPhoneNumber: %s", new Object[]{jVar.mYn});
            if (com.tencent.mm.plugin.ipcall.a.c.aDT().og(bg.getInt(jVar.mTR, -1))) {
                com.tencent.mm.plugin.report.service.g.oUh.A(12058, jVar.mTR);
                g.a(jVar.mYo, jVar.mYo.getString(R.l.dPS), jVar.mYo.getString(R.l.dPT), false, new OnClickListener(jVar) {
                    final /* synthetic */ j mYz;

                    {
                        this.mYz = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.mYz.mYo.finish();
                        this.mYz.mYo = null;
                    }
                });
            } else if (am.isNetworkConnected(jVar.mYo)) {
                long j = jVar.mYo.getSharedPreferences("IPCall_LastInputPref", 0).getLong("IPCall_LastInvite", -1);
                if (j <= System.currentTimeMillis() || j == -1) {
                    jVar.aFq();
                    if (!(jVar.mYw && i.aEl().aEb())) {
                        b aEj;
                        jVar.mYm = com.tencent.mm.plugin.ipcall.b.a.cC(jVar.mTQ, jVar.mTP);
                        jVar.ox(1);
                        com.tencent.mm.plugin.ipcall.c cVar = jVar.mYp;
                        str = jVar.mwO;
                        str2 = jVar.mTP;
                        str3 = jVar.mTS;
                        str4 = jVar.mYn;
                        str5 = jVar.mTQ;
                        i = jVar.mYm;
                        i2 = jVar.mTT;
                        int i3 = jVar.mTU;
                        if (i.aEl().aEb()) {
                            w.i("MicroMsg.IPCallManager", "startIPCall, already start!");
                        } else {
                            w.i("MicroMsg.IPCallManager", "startIPCall");
                            i.aEh().mMU = cVar;
                            i.aEi().mPa = cVar;
                            i.aEl().mMN = -1;
                            cVar.amk();
                            cVar.mMp = (TelephonyManager) ab.getContext().getSystemService("phone");
                            cVar.mMp.listen(cVar.mMq, 32);
                            com.tencent.mm.sdk.b.a.urY.b(cVar.mMr);
                            w.d("MicroMsg.IPCallRecordStorageLogic", "recordStartCall, phoneNumber: %s, contactId: %s", new Object[]{str4, str5});
                            k kVar = new k();
                            kVar.field_phonenumber = str4;
                            if (bg.mA(str5)) {
                                kVar.field_addressId = -1;
                            } else {
                                com.tencent.mm.plugin.ipcall.a.g.c yt = i.aEn().yt(str5);
                                if (yt == null || yt.uxb == -1) {
                                    kVar.field_addressId = -1;
                                } else {
                                    kVar.field_addressId = yt.uxb;
                                }
                            }
                            if (i != -1) {
                                kVar.field_phoneType = i;
                            } else {
                                kVar.field_phoneType = -1;
                            }
                            kVar.field_calltime = bg.Nz();
                            kVar.field_status = 1;
                            if (!i.aEo().b(kVar)) {
                                kVar = null;
                            }
                            cVar.mMn = kVar;
                            com.tencent.mm.plugin.ipcall.c.hgN.postDelayed(cVar.mMt, 1754);
                            cVar.mMo = false;
                            aEj = i.aEj();
                            w.d("MicroMsg.IPCallReportHelper", "reset");
                            aEj.mPc = 0;
                            aEj.mPd = 0;
                            aEj.mPe = 0;
                            aEj.mPf = 0;
                            aEj.mPg = 0;
                            aEj.mPh = 0;
                            aEj.mPi = 0;
                            aEj.mPj = 0;
                            aEj.mPk = 0;
                            aEj.mPl = 0;
                            aEj.mNL = 0;
                            aEj.mNM = 0;
                            aEj.mPm = 0;
                            aEj.isg = "";
                            aEj.mPn = 0;
                            aEj.mPo = "";
                            aEj.mPq = 0;
                            aEj.mPp = 0;
                            aEj.mMw = 0;
                            aEj.mPr = 0;
                            aEj.mPs = 0;
                            aEj.mPx = 0;
                            aEj.mPw = 0;
                            aEj.mPt = "";
                            aEj.mPu = "";
                            aEj.countryCode = "";
                            aEj.mPy = 0;
                            aEj.mPz = 0;
                            aEj.mPA = 0;
                            aEj.mPB = 0;
                            aEj.mPC = 0;
                            i.aEl().mMN = -1;
                            w.d("MicroMsg.IPCallManager", "startIPCall, username: %s, phoneNumber: %s", new Object[]{str3, str4});
                            com.tencent.mm.plugin.ipcall.a.g aEh = i.aEh();
                            w.d("MicroMsg.IPCallSvrLogic", "startIPCall, toUsername: %s, toPhoneNumber: %s", new Object[]{str3, str4});
                            aEh.fSy = false;
                            aEh.mNe = false;
                            aEh.mMP = 0;
                            aEh.mMQ = 0;
                            aEh.mMR = 0;
                            aEh.mMS = false;
                            aEh.mMT = false;
                            aEh.mNf = false;
                            aEh.mNd = new com.tencent.mm.plugin.ipcall.a.a.c();
                            aEh.mNd.fFa = str;
                            aEh.mNd.mOn = str2;
                            aEh.mNd.fWT = str5;
                            aEh.mNd.mOo = str4;
                            aEh.mNd.fVb = str3;
                            aEh.mNd.mNO = (int) System.currentTimeMillis();
                            aEh.mNd.mNP = i2;
                            aEh.mNd.mNQ = i3;
                            aEh.mNd.mOq = i;
                            aEh.mMV.a(aEh.mNd);
                            aEh.mNa.a(aEh.mNd);
                            w.i("MicroMsg.IPCallSvrLogic", "startIPCallInternal, inviteId: %d", new Object[]{Integer.valueOf(aEh.mNd.mNO)});
                            i.aEl().oh(1);
                            com.tencent.mm.plugin.ipcall.a.c.a aEi = i.aEi();
                            if (aEi.mOZ) {
                                w.d("MicroMsg.IPCallEngineManager", "already start engine");
                            } else {
                                aEi.aED();
                                w.i("MicroMsg.IPCallEngineManager", "start engine");
                                if (aEi.mOV.nGp) {
                                    aEi.mOV.ij(false);
                                    aEi.mOV.reset();
                                }
                                aEi.mOV.rjK = 1;
                                long currentTimeMillis = System.currentTimeMillis();
                                v2protocal com_tencent_mm_plugin_voip_model_v2protocal = aEi.mOV;
                                com_tencent_mm_plugin_voip_model_v2protocal.netType = com.tencent.mm.plugin.voip.b.a.getNetType(ab.getContext());
                                if (com_tencent_mm_plugin_voip_model_v2protocal.netType == 5) {
                                    com_tencent_mm_plugin_voip_model_v2protocal.netType = 4;
                                }
                                com_tencent_mm_plugin_voip_model_v2protocal.rkD = new int[(com_tencent_mm_plugin_voip_model_v2protocal.defaultWidth * com_tencent_mm_plugin_voip_model_v2protocal.defaultHeight)];
                                ap.yY();
                                com_tencent_mm_plugin_voip_model_v2protocal.rjI = com.tencent.mm.u.c.uH();
                                i = l.rl();
                                if ((i & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
                                    d.u(ab.getContext(), "libvoipCodec_v7a.so");
                                    com.tencent.mm.plugin.voip.b.a.dK("MicroMsg.Voip", "dlopen /data/data/com.tencent.mm/lib/libvoipCodec_v7a.so... ");
                                } else if ((i & 512) != 0) {
                                    d.u(ab.getContext(), "libvoipCodec.so");
                                    com.tencent.mm.plugin.voip.b.a.dK("MicroMsg.Voip", "dlopen /data/data/com.tencent.mm/lib/libvoipCodec.so... ");
                                } else {
                                    d.u(ab.getContext(), "libvoipCodec_v5.so");
                                    com.tencent.mm.plugin.voip.b.a.dK("MicroMsg.Voip", "dlopen /data/data/com.tencent.mm/lib/libvoipCodec_v5.so... ");
                                }
                                i2 = VERSION.SDK_INT;
                                i3 = OpenGlRender.brx();
                                Display defaultDisplay = ((WindowManager) ab.getContext().getSystemService("window")).getDefaultDisplay();
                                int width = defaultDisplay.getWidth();
                                int init = com_tencent_mm_plugin_voip_model_v2protocal.init(com_tencent_mm_plugin_voip_model_v2protocal.netType, 65538, (com_tencent_mm_plugin_voip_model_v2protocal.defaultWidth << 16) | com_tencent_mm_plugin_voip_model_v2protocal.defaultHeight, (width << 16) | defaultDisplay.getHeight(), com_tencent_mm_plugin_voip_model_v2protocal.rjI, i | ((i2 << 16) | (i3 << 24)), e.hgp + "app_lib/", 4);
                                com.tencent.mm.plugin.voip.b.a.dK("MicroMsg.Voip", "protocal init ret :" + init + ",uin= " + com_tencent_mm_plugin_voip_model_v2protocal.rjI);
                                com_tencent_mm_plugin_voip_model_v2protocal.nGp = true;
                                if (init < 0) {
                                    com_tencent_mm_plugin_voip_model_v2protocal.reset();
                                }
                                j = System.currentTimeMillis();
                                w.d("MicroMsg.IPCallEngineManager", "protocal init finish, ret: %d, used %dms", new Object[]{Integer.valueOf(init), Long.valueOf(j - currentTimeMillis)});
                                if (aEi.mOV.field_capInfo != null && aEi.mOV.exchangeCabInfo(aEi.mOV.field_capInfo, aEi.mOV.field_capInfo.length) < 0) {
                                    w.e("MicroMsg.IPCallEngineManager", "exchangeCabInfo failed");
                                    i.aEj().mPl = 24;
                                }
                                if (init < 0) {
                                    w.e("MicroMsg.IPCallEngineManager", "engine init failed!");
                                }
                                aEi.mOV.rjK = 1;
                                aEi.mOZ = true;
                            }
                            com.tencent.mm.plugin.ipcall.c.hgN.removeCallbacks(cVar.mMs);
                            com.tencent.mm.plugin.ipcall.c.hgN.postDelayed(cVar.mMs, 60000);
                        }
                        w.i("MicroMsg.TalkUIController", "startLaunchTalk, callNumber: %s", new Object[]{jVar.mYn});
                        aEj = i.aEj();
                        str = jVar.mTR;
                        w.d("MicroMsg.IPCallReportHelper", "setCountryCode: %s", new Object[]{str});
                        if (!bg.mA(str)) {
                            aEj.countryCode = str;
                        }
                    }
                    jVar.mYy = false;
                    return;
                }
                w.i("MicroMsg.TalkUIController", "onDisasterHappen");
                g.a(jVar.mYo, jVar.mYo.getString(R.l.etG, new Object[]{String.valueOf(((j - r6) / 1000) + 1)}), jVar.mYo.getString(R.l.etB), jVar.mYo.getString(R.l.etC), false, new OnClickListener(jVar) {
                    final /* synthetic */ j mYz;

                    {
                        this.mYz = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.mYz.mYo.finish();
                    }
                });
            } else {
                Toast.makeText(jVar.mYo, R.l.fco, 1).show();
                jVar.mYo.finish();
            }
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        cV(true);
        if (this.mXF != null) {
            j jVar = this.mXF;
            w.i("MicroMsg.TalkUIController", "onDestroy");
            jVar.mYp.mMm = null;
            i.aEk().fCi = null;
            i.aEk().mOF = null;
            i.aEk().a(null);
            com.tencent.mm.plugin.ipcall.a.b.b aEk = i.aEk();
            aEk.mOB.mOS = null;
            com.tencent.mm.plugin.ipcall.a.b.d dVar = aEk.mOB;
            dVar.jXn.bJG();
            dVar.jXr.bJH();
            jVar.mYo = null;
            jVar.mYq = null;
        }
    }

    protected final int getLayoutId() {
        return R.i.dgg;
    }

    public final void fh(boolean z) {
        if (z) {
            af.f(new Runnable(this) {
                final /* synthetic */ IPCallTalkUI mXG;

                {
                    this.mXG = r1;
                }

                public final void run() {
                    this.mXG.setResult(-1, new Intent());
                    this.mXG.finish();
                }
            }, 3000);
        }
    }

    public void onBackPressed() {
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.mXF != null) {
            boolean z;
            if (i.aEl().aEc()) {
                int aEA;
                if (i == 25) {
                    aEA = i.aEk().aEA();
                    if (aEA != -1) {
                        ap.yZ().ec(aEA);
                        z = true;
                        if (z) {
                            return true;
                        }
                    }
                } else if (i == 24) {
                    aEA = i.aEk().aEA();
                    if (aEA != -1) {
                        ap.yZ().eb(aEA);
                        z = true;
                        if (z) {
                            return true;
                        }
                    }
                }
            }
            z = false;
            if (z) {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    protected void onPause() {
        w.d("MicroMsg.IPCallTalkUI", "onPause");
        super.onPause();
        if (this.mXF != null) {
            w.d("MicroMsg.TalkUIController", "onPause");
        }
    }

    protected void onResume() {
        w.d("MicroMsg.IPCallTalkUI", "onResume");
        super.onResume();
        if (this.mXF != null) {
            w.d("MicroMsg.TalkUIController", "onResume");
            ap.getNotification().cancel(42);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        w.i("MicroMsg.IPCallTalkUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*80*/:
                if (iArr[0] == 0) {
                    init();
                    return;
                } else {
                    g.a(this, getString(R.l.eFJ), getString(R.l.eFM), getString(R.l.evw), getString(R.l.cancel), false, new OnClickListener(this) {
                        final /* synthetic */ IPCallTalkUI mXG;

                        {
                            this.mXG = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            this.mXG.finish();
                            this.mXG.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ IPCallTalkUI mXG;

                        {
                            this.mXG = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            this.mXG.finish();
                        }
                    });
                    return;
                }
            default:
                return;
        }
    }
}
