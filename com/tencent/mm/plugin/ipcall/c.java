package com.tencent.mm.plugin.ipcall;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.net.Uri;
import android.os.Looper;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.e.a.rq;
import com.tencent.mm.plugin.ipcall.a.c.a.a;
import com.tencent.mm.plugin.ipcall.a.f;
import com.tencent.mm.plugin.ipcall.a.g;
import com.tencent.mm.plugin.ipcall.a.g.m;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.ipcall.ui.IPCallTalkUI;
import com.tencent.mm.plugin.ipcall.ui.j;
import com.tencent.mm.plugin.voip.model.k;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.video.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;

public final class c implements a, g.a, k.a {
    public static ae hgN = new ae(Looper.getMainLooper());
    private aj fyI;
    public Object lEf = new Object();
    public e mMm;
    public com.tencent.mm.plugin.ipcall.a.g.k mMn;
    public boolean mMo = false;
    public TelephonyManager mMp;
    public PhoneStateListener mMq = new PhoneStateListener(this) {
        final /* synthetic */ c mMx;

        {
            this.mMx = r1;
        }

        public final void onCallStateChanged(int i, String str) {
            super.onCallStateChanged(i, str);
            w.d("MicroMsg.IPCallManager", "onCallStateChanged " + i);
            if (i == 2) {
                w.i("MicroMsg.IPCallManager", "system phone call state offhook, stop call");
                this.mMx.ck(0, 0);
            }
        }
    };
    public com.tencent.mm.sdk.b.c mMr = new com.tencent.mm.sdk.b.c<rq>(this) {
        final /* synthetic */ c mMx;

        {
            this.mMx = r2;
            this.usg = rq.class.getName().hashCode();
        }

        public final /* bridge */ /* synthetic */ boolean a(b bVar) {
            rq rqVar = (rq) bVar;
            if (rqVar instanceof rq) {
                rqVar.fYE.fYF = false;
                rqVar.fYE.fYG = false;
                rqVar.fYE.fYH = true;
                rqVar.fYE.fJL = "";
            }
            return false;
        }
    };
    public Runnable mMs = new Runnable(this) {
        final /* synthetic */ c mMx;

        {
            this.mMx = r1;
        }

        public final void run() {
            if (!i.aEl().aEe()) {
                w.i("MicroMsg.IPCallManager", "timeout! still not accept!");
                if (this.mMx.ck(9, 12)) {
                    this.mMx.c(9, null, ab.getContext().getString(R.l.dPU), 2);
                }
            }
        }
    };
    public Runnable mMt = new Runnable(this) {
        final /* synthetic */ c mMx;

        {
            this.mMx = r1;
        }

        public final void run() {
            int i = 0;
            h aEr = i.aEr();
            int i2 = R.k.dxw;
            aEr.rqg = 0;
            if (i2 == 0) {
                aEr.ip(true);
            } else if (3500 != -1) {
                boolean booleanValue;
                try {
                    ap.yY();
                    booleanValue = ((Boolean) com.tencent.mm.u.c.vr().get(73218, Boolean.valueOf(true))).booleanValue();
                } catch (Exception e) {
                    w.e("MicroMsg.RingPlayer", "get voip sound failed: " + e.getMessage());
                    booleanValue = true;
                }
                if (booleanValue && !aEr.fEt) {
                    try {
                        aEr.rqh = System.currentTimeMillis();
                        aEr.rqf = new com.tencent.mm.compatible.b.i();
                        booleanValue = ap.yZ().qI();
                        boolean qO = ap.yZ().qO();
                        w.d("MicroMsg.RingPlayer", "isBluetoothOn: %b, isHeadsetPlugged: %b", new Object[]{Boolean.valueOf(booleanValue), Boolean.valueOf(qO)});
                        if (p.gRd.gOs >= 0) {
                            i = p.gRd.gOs;
                        }
                        aEr.io(false);
                        aEr.a(i2, 3500, true, i);
                        aEr.fEt = true;
                    } catch (Exception e2) {
                        w.e("MicroMsg.RingPlayer", "new MediaPlayer failed, " + e2.toString());
                    }
                }
            } else {
                aEr.n(i2, 2, true);
            }
        }
    };
    public boolean mMu;
    public com.tencent.mm.plugin.voip.ui.a mMv = new com.tencent.mm.plugin.voip.ui.a(this) {
        final /* synthetic */ c mMx;

        {
            this.mMx = r1;
        }

        public final boolean aDL() {
            if (i.aEl().aEb()) {
                return true;
            }
            return false;
        }

        public final void a(Intent intent, com.tencent.mm.plugin.voip.ui.h hVar) {
            if (i.aEl().aEe()) {
                int aDJ = this.mMx.aDJ();
                hVar.HF(String.format("%02d:%02d", new Object[]{Integer.valueOf(aDJ / 60), Integer.valueOf(aDJ % 60)}));
                return;
            }
            hVar.HE(ab.getContext().getString(R.l.eCw));
        }
    };
    private long mMw = 0;

    public final void amk() {
        if (this.mMp != null) {
            this.mMp.listen(this.mMq, 0);
            this.mMp = null;
        }
        com.tencent.mm.sdk.b.a.urY.c(this.mMr);
    }

    private boolean C(int i, int i2, int i3) {
        com.tencent.mm.plugin.ipcall.a.a.c cVar = i.aEh().mNd;
        if (i.aEl().oh(i)) {
            int i4;
            com.tencent.mm.plugin.ipcall.a.b.a aVar;
            if (cVar != null) {
                w.i("MicroMsg.IPCallManager", "finishIPCall inviteId:%d, roomId:%d, state:%d, errStatus:%d, pstnErrCode:%d", new Object[]{Integer.valueOf(cVar.mNO), Integer.valueOf(cVar.mNL), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            }
            w.i("MicroMsg.IPCallManager", "closeDeviceEngine");
            k.bpZ().bqb();
            k.bpZ().rit = null;
            com.tencent.mm.plugin.ipcall.a.c.b aEj = i.aEj();
            com.tencent.mm.plugin.ipcall.a.b.b aEk = i.aEk();
            if (aEk.mOA != null) {
                com.tencent.mm.plugin.ipcall.a.b.c cVar2 = aEk.mOA;
                i4 = cVar2.mOJ != null ? cVar2.mOJ.fzJ : 0;
            } else {
                i4 = 0;
            }
            if (aEj.mPz == 0) {
                aEj.mPz = i4;
            }
            aEj = i.aEj();
            aEk = i.aEk();
            if (aEk.mOz != null) {
                aVar = aEk.mOz;
                if (aVar.mOt != null) {
                    w.d("MicroMsg.IPCallAudioPlayer", "AudioPlayer  mAudioPlayErrState:" + aVar.mOt.bpa());
                    i4 = aVar.mOt.bpa();
                } else {
                    i4 = 0;
                }
            } else {
                i4 = 0;
            }
            if (aEj.mPA == 0) {
                aEj.mPA = i4;
            }
            com.tencent.mm.plugin.ipcall.a.b.b aEk2 = i.aEk();
            com.tencent.mm.plugin.ipcall.a.c.a aEi = i.aEi();
            i4 = 0;
            if (aEk2.mOz != null) {
                aVar = aEk2.mOz;
                i4 = (aVar.mOt == null || !aVar.fOV) ? -1 : aVar.mOt.bpb();
            }
            aEi.mOV.rkk = i4 == -1 ? 0 : (int) ((((float) ap.yZ().getStreamVolume(i4)) / ((float) ap.yZ().getStreamMaxVolume(i4))) * 100.0f);
            aEk2.ict.rY();
            aVar = aEk2.mOz;
            if (aVar.fOV) {
                w.i("MicroMsg.IPCallAudioPlayer", "stopPlay");
                synchronized (aVar.mOu) {
                    e.post(new a(aVar, aVar.mOt), "IPCallAudioPlayer_stop");
                    aVar.fOV = false;
                    aVar.mOt = null;
                }
            }
            aEk2.fCi = null;
            aEk2.mOC.cS(ab.getContext());
            ap.yZ().qH();
            ap.yZ().b(aEk2);
            aEk2.mOF = null;
            aEk2.mOD = null;
            aEk = i.aEk();
            com.tencent.mm.plugin.ipcall.a.b.c cVar3 = aEk.mOA;
            if (cVar3.fOV) {
                w.i("MicroMsg.IPCallRecorder", "stop record");
                synchronized (cVar3.mOK) {
                    if (cVar3.mOJ != null) {
                        e.post(new a(cVar3, cVar3.mOJ), "IPCallRecorder_stopRecord");
                        cVar3.mOJ = null;
                        cVar3.fOV = false;
                        cVar3.kmK = false;
                    }
                }
            }
            aEk.fCi = null;
            com.tencent.mm.plugin.ipcall.a.c.a aEi2 = i.aEi();
            w.i("MicroMsg.IPCallEngineManager", "close engine");
            aEi2.mOV.ij(true);
            com.tencent.mm.plugin.ipcall.a.c.b aEj2 = i.aEj();
            if (bg.mA(aEj2.mPu) && bg.mA(aEj2.mPt)) {
                com.tencent.mm.plugin.ipcall.a.a.c cVar4 = i.aEh().mNd;
                v2protocal com_tencent_mm_plugin_voip_model_v2protocal = i.aEi().mOV;
                Object obj = aEj2.mPj == 1 ? 1 : null;
                com_tencent_mm_plugin_voip_model_v2protocal.getPstnChannelInfo(com_tencent_mm_plugin_voip_model_v2protocal.rli, com_tencent_mm_plugin_voip_model_v2protocal.rli.length, obj != null ? 1 : 0, cVar4.mOi);
                w.d("MicroMsg.Voip", "field_pstnChannelInfoLength: %d", new Object[]{Integer.valueOf(com_tencent_mm_plugin_voip_model_v2protocal.field_pstnChannelInfoLength)});
                aEj2.mPu = new String(com_tencent_mm_plugin_voip_model_v2protocal.rli, 0, com_tencent_mm_plugin_voip_model_v2protocal.field_pstnChannelInfoLength);
                v2protocal com_tencent_mm_plugin_voip_model_v2protocal2 = i.aEi().mOV;
                com_tencent_mm_plugin_voip_model_v2protocal2.getPstnEngineInfo(com_tencent_mm_plugin_voip_model_v2protocal2.rlj, com_tencent_mm_plugin_voip_model_v2protocal2.rlj.length);
                w.d("MicroMsg.Voip", "field_pstnEngineInfoLength: %d", new Object[]{Integer.valueOf(com_tencent_mm_plugin_voip_model_v2protocal2.field_pstnEngineInfoLength)});
                aEj2.mPt = new String(com_tencent_mm_plugin_voip_model_v2protocal2.rlj, 0, com_tencent_mm_plugin_voip_model_v2protocal2.field_pstnEngineInfoLength);
                com_tencent_mm_plugin_voip_model_v2protocal2 = i.aEi().mOV;
                aEj2.mPv = v2protocal.bqG() + "," + com_tencent_mm_plugin_voip_model_v2protocal2.rkl + "," + (v2protocal.qXE & 255) + com_tencent_mm_plugin_voip_model_v2protocal2.bqL() + "," + com_tencent_mm_plugin_voip_model_v2protocal2.rkk;
                w.d("MicroMsg.IPCallReportHelper", "nativeChannelReportString: %s", new Object[]{aEj2.mPu});
                w.d("MicroMsg.IPCallReportHelper", "nativeEngineReportString: %s", new Object[]{aEj2.mPt});
                w.d("MicroMsg.IPCallReportHelper", "clientReportExString: %s", new Object[]{aEj2.mPv});
            }
            aEi2.mOV.reset();
            aEi2.aED();
            i.aEr().stop();
            h aEr = i.aEr();
            i4 = R.k.dyR;
            i.aEk();
            boolean isSpeakerphoneOn = ap.yZ().gNq.isSpeakerphoneOn();
            aEr.mContext.getSharedPreferences(ab.bIX(), 0).getBoolean("settings_shake", true);
            ap.yZ().setSpeakerphoneOn(isSpeakerphoneOn);
            if (isSpeakerphoneOn) {
                ap.yZ().setMode(0);
            } else {
                ap.yZ().setMode(2);
            }
            aEr.rqi = System.currentTimeMillis();
            MediaPlayer iVar = new com.tencent.mm.compatible.b.i();
            try {
                iVar.setDataSource(aEr.mContext, Uri.parse("android.resource://" + aEr.mContext.getPackageName() + "/" + i4));
                iVar.setOnCompletionListener(new OnCompletionListener(aEr) {
                    final /* synthetic */ h rqk;

                    {
                        this.rqk = r1;
                    }

                    public final void onCompletion(MediaPlayer mediaPlayer) {
                        mediaPlayer.release();
                        if (System.currentTimeMillis() - this.rqk.rqi > 5000) {
                            this.rqk.rqg = 8;
                            ap.yZ().setMode(0);
                        }
                    }
                });
                iVar.setOnErrorListener(new OnErrorListener(aEr) {
                    final /* synthetic */ h rqk;

                    {
                        this.rqk = r1;
                    }

                    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                        if (mediaPlayer != null) {
                            mediaPlayer.release();
                            this.rqk.rqg = 5;
                            w.w("MicroMsg.RingPlayer", "RingPlayer playSound :onError", new Object[]{mediaPlayer, Integer.valueOf(i), Integer.valueOf(i2)});
                        }
                        return false;
                    }
                });
                if (ap.yZ().qI() || !isSpeakerphoneOn) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                iVar.setAudioStreamType(i4);
                iVar.prepare();
                iVar.setLooping(false);
                iVar.start();
                if (System.currentTimeMillis() - aEr.rqi > 2000) {
                    aEr.rqg = 7;
                }
            } catch (Throwable th) {
                w.w("MicroMsg.RingPlayer", "playSound Failed Throwable t = ", new Object[]{th});
                aEr.rqg = 6;
            }
            hgN.removeCallbacks(this.mMt);
            hgN.removeCallbacks(this.mMs);
            if (this.fyI != null) {
                this.fyI.KH();
                this.fyI = null;
            }
            i.aEj().mPl = i3;
            com.tencent.mm.plugin.ipcall.a.c.b aEj3 = i.aEj();
            w.d("MicroMsg.IPCallReportHelper", "markEndTalk");
            if (aEj3.mPs == 0 && aEj3.mPr != 0) {
                aEj3.mPs = System.currentTimeMillis();
                aEj3.mPk = (aEj3.mPs - aEj3.mPr) / 1000;
                w.d("MicroMsg.IPCallReportHelper", "callTime: %d", new Object[]{Long.valueOf(aEj3.mPk)});
            }
            com.tencent.mm.plugin.ipcall.a.g.k kVar;
            if (i == 8) {
                i.aEh().aEf();
                i.aEj().aEF();
                kVar = this.mMn;
                if (kVar != null) {
                    w.d("MicroMsg.IPCallRecordStorageLogic", "recordCancelCall, localId: %d", new Object[]{Long.valueOf(kVar.uxb)});
                    if (kVar.uxb != -1) {
                        kVar.field_status = 2;
                        i.aEo().a(kVar);
                    }
                }
            } else if (i == 12) {
                i.aEh().aEf();
                i.aEj().aEF();
                if (i2 == 11) {
                    m.b(this.mMn);
                } else {
                    kVar = this.mMn;
                    if (kVar != null) {
                        w.d("MicroMsg.IPCallRecordStorageLogic", "recordCallFailed, localId: %d", new Object[]{Long.valueOf(kVar.uxb)});
                        if (kVar.uxb != -1) {
                            kVar.field_status = 6;
                            i.aEo().a(kVar);
                        }
                    }
                }
            } else if (i == 9) {
                i.aEh().oi(1);
                i.aEj().aEE();
                m.a(this.mMn, i.aEj().mPk);
            } else if (i == 10) {
                i.aEh().oi(1);
                aEj3 = i.aEj();
                w.i("MicroMsg.IPCallReportHelper", "otherSideUserShutdown");
                aEj3.mPe = 1;
                kVar = this.mMn;
                long j = i.aEj().mPk;
                if (kVar != null) {
                    w.d("MicroMsg.IPCallRecordStorageLogic", "recordOthersideShutdownCall, localId: %d, talkTime: %d", new Object[]{Long.valueOf(kVar.uxb), Long.valueOf(j)});
                    if (kVar.uxb != -1) {
                        kVar.field_status = 5;
                        kVar.field_duration = j;
                        i.aEo().a(kVar);
                    }
                }
            } else if (i == 11) {
                if (i2 == 5) {
                    i.aEh().oi(3);
                } else if (i2 == 11) {
                    i.aEh().oi(1);
                } else {
                    i.aEh().oi(2);
                }
                i.aEj().aEE();
                if (i2 == 11) {
                    m.b(this.mMn);
                } else {
                    m.a(this.mMn, i.aEj().mPk);
                }
            }
            if (i.aEh().fSy) {
                if (this.mMu || i.aEh().mNd.mNL == 0 || i.aEh().mNd.mNN == 0) {
                    w.e("MicroMsg.IPCallManager", "roomId = 0,ignore feedback");
                } else {
                    Context context = ab.getContext();
                    int i5 = i.aEh().mNd.mNL;
                    long j2 = i.aEh().mNd.mNN;
                    w.i("MicroMsg.IPCallPluginUtil", "tryShowFeedbackDialog");
                    if (d.aDM()) {
                        int i6 = com.tencent.mm.i.g.sV().getInt("WCOMaxTimesForShowFeedback", 0);
                        ap.yY();
                        int intValue = ((Integer) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uCc, Integer.valueOf(0))).intValue();
                        ap.yY();
                        long longValue = ((Long) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uCb, Long.valueOf(0))).longValue();
                        long Ny = bg.Ny();
                        if (Ny - longValue > 86400) {
                            i4 = 0;
                            w.i("MicroMsg.IPCallPluginUtil", "tryShowFeedbackDialog reset time");
                        } else {
                            i4 = intValue;
                        }
                        if (i4 >= i6) {
                            w.i("MicroMsg.IPCallPluginUtil", "tryShowFeedbackDialog reach max time" + i6);
                        } else if (Ny - longValue < 1800) {
                            w.i("MicroMsg.IPCallPluginUtil", "tryShowFeedbackDialog not reach INTERVAL_TIMES_TRY_SHOW_WCO_FEEDBACK_MAIN");
                        } else {
                            i4++;
                            ap.yY();
                            com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uCc, Integer.valueOf(i4));
                            ap.yY();
                            com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uCb, Long.valueOf(Ny));
                            Intent intent = new Intent();
                            intent.putExtra("IPCallFeedbackDialogUI_KRoomId", i5);
                            intent.putExtra("IPCallFeedbackDialogUI_KCallseq", j2);
                            d.b(context, "ipcall", ".ui.IPCallFeedbackDialogUI", intent);
                        }
                    }
                }
            }
            i.aEh().mMU = null;
            i.aEi().mPa = null;
            i.aEl().mMN = -1;
            aDI();
            amk();
            return true;
        }
        w.i("MicroMsg.IPCallManager", "finishIPCall, cannot finish now, currentState: %s", new Object[]{f.stateToString(i.aEl().mMN)});
        if (cVar != null) {
            w.i("MicroMsg.IPCallManager", "finishIPCall, cannot finish now inviteId:%d, roomId:%d, state:%d,errStatus:%d, pstnErrCode:%d", new Object[]{Integer.valueOf(cVar.mNO), Integer.valueOf(cVar.mNL), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        }
        return false;
    }

    public static boolean yp(String str) {
        w.d("MicroMsg.IPCallManager", "dialWhenTalking, dialButton: %s", new Object[]{str});
        if (!i.aEl().aEe()) {
            w.i("MicroMsg.IPCallManager", "ipcall not connect, cannot call dialWhenTalking now");
            return false;
        } else if (bg.mA(str) || str.length() != 1) {
            return false;
        } else {
            int i;
            com.tencent.mm.plugin.ipcall.a.c.a aEi;
            com.tencent.mm.plugin.ipcall.a.c.b aEj;
            if (!bg.mA(str) && str.length() == 1) {
                char charAt = str.charAt(0);
                if (charAt < '0' || charAt > '9') {
                    if (charAt == '*') {
                        i = 10;
                    } else if (charAt == '#') {
                        i = 11;
                    } else if (charAt >= 'A' && charAt <= 'D') {
                        i = (charAt - 65) + 12;
                    }
                    if (i != -1) {
                        return false;
                    }
                    aEi = i.aEi();
                    w.d("MicroMsg.IPCallEngineManager", "sendDTMF: %d", new Object[]{Integer.valueOf(i)});
                    aEj = i.aEj();
                    aEj.mPC++;
                    w.i("MicroMsg.IPCallReportHelper", "now addCallClickCnt %d", new Object[]{Integer.valueOf(aEj.mPC)});
                    if (aEi.mOV.SendDTMF(i) < 0) {
                        w.i("MicroMsg.IPCallEngineManager", "sendDTMF failed, ret: %d", new Object[]{Integer.valueOf(aEi.mOV.SendDTMF(i))});
                    }
                    return true;
                }
                i = charAt - 48;
                if (i != -1) {
                    return false;
                }
                aEi = i.aEi();
                w.d("MicroMsg.IPCallEngineManager", "sendDTMF: %d", new Object[]{Integer.valueOf(i)});
                aEj = i.aEj();
                aEj.mPC++;
                w.i("MicroMsg.IPCallReportHelper", "now addCallClickCnt %d", new Object[]{Integer.valueOf(aEj.mPC)});
                if (aEi.mOV.SendDTMF(i) < 0) {
                    w.i("MicroMsg.IPCallEngineManager", "sendDTMF failed, ret: %d", new Object[]{Integer.valueOf(aEi.mOV.SendDTMF(i))});
                }
                return true;
            }
            i = -1;
            if (i != -1) {
                return false;
            }
            aEi = i.aEi();
            w.d("MicroMsg.IPCallEngineManager", "sendDTMF: %d", new Object[]{Integer.valueOf(i)});
            aEj = i.aEj();
            aEj.mPC++;
            w.i("MicroMsg.IPCallReportHelper", "now addCallClickCnt %d", new Object[]{Integer.valueOf(aEj.mPC)});
            if (aEi.mOV.SendDTMF(i) < 0) {
                w.i("MicroMsg.IPCallEngineManager", "sendDTMF failed, ret: %d", new Object[]{Integer.valueOf(aEi.mOV.SendDTMF(i))});
            }
            return true;
        }
    }

    public final void aDy() {
        w.i("MicroMsg.IPCallManager", "onInviteSuccess");
        if (i.aEl().oh(3)) {
            com.tencent.mm.plugin.ipcall.a.c.b aEj = i.aEj();
            w.d("MicroMsg.IPCallReportHelper", "markStartInvite");
            if (aEj.mPp == 0) {
                aEj.mPp = System.currentTimeMillis();
            }
            com.tencent.mm.plugin.ipcall.a.a.c cVar = i.aEh().mNd;
            com.tencent.mm.plugin.ipcall.a.c.b aEj2 = i.aEj();
            int i = cVar.mNO;
            String str = cVar.fVb;
            String str2 = cVar.mOo;
            int i2 = cVar.mNL;
            long j = cVar.mNM;
            long j2 = cVar.mNN;
            aEj2.mNO = i;
            aEj2.mPo = str;
            aEj2.isg = str2;
            aEj2.mNL = i2;
            aEj2.mNM = j;
            aEj2.mPm = j2;
            if (this.mMm != null) {
                this.mMm.aDy();
            }
        }
    }

    public final void u(String str, String str2, int i) {
        w.i("MicroMsg.IPCallManager", "onInviteFailed, currentState: %s", new Object[]{f.stateToString(i.aEl().mMN)});
        if (ck(2, 0)) {
            c(2, str, str2, i);
        }
    }

    public final void aDz() {
        w.i("MicroMsg.IPCallManager", "onStartRing, currentState: %s", new Object[]{f.stateToString(i.aEl().mMN)});
        if (i.aEl().oh(4)) {
            com.tencent.mm.plugin.ipcall.a.c.b aEj = i.aEj();
            w.d("MicroMsg.IPCallReportHelper", "markStartRing");
            if (aEj.mPq == 0) {
                aEj.mPq = System.currentTimeMillis();
                aEj.mPh = aEj.mPq - aEj.mPp;
                w.d("MicroMsg.IPCallReportHelper", "ringTime: %d", new Object[]{Long.valueOf(aEj.mPh)});
            }
            i.aEi().aEC();
            aEj = i.aEj();
            w.i("MicroMsg.IPCallReportHelper", "startRing");
            aEj.mPc = 1;
            if (this.mMm != null) {
                this.mMm.aDz();
            }
        }
    }

    public final void aDA() {
        w.i("MicroMsg.IPCallManager", "onAccept, currentState: %s", new Object[]{f.stateToString(i.aEl().mMN)});
        if (i.aEl().oh(5)) {
            com.tencent.mm.plugin.ipcall.a.c.b aEj = i.aEj();
            w.d("MicroMsg.IPCallReportHelper", "markUserAccept");
            if (aEj.mMw == 0) {
                aEj.mMw = System.currentTimeMillis();
                aEj.mPi = aEj.mMw - aEj.mPp;
                w.d("MicroMsg.IPCallReportHelper", "answerTime: %d", new Object[]{Long.valueOf(aEj.mPi)});
            }
            i.aEi().aEC();
            aEj = i.aEj();
            w.i("MicroMsg.IPCallReportHelper", "userAccept");
            aEj.mPd = 1;
            hgN.removeCallbacks(this.mMs);
            i.aEr().stop();
            hgN.removeCallbacks(this.mMt);
            i.aEk().aEz();
            if (i.aEi().mOY && !this.mMo) {
                i.aEj().aEG();
                i.aEj().aEJ();
                this.mMo = true;
                this.mMw = bg.Ny();
                aDK();
                i.aEi().aEB();
                if (this.mMm != null) {
                    this.mMm.aDN();
                }
                i.aEj().aEI();
                k.bpZ().bqa();
                k.bpZ().rit = this;
            }
        }
    }

    public final void c(int i, String str, String str2, int i2) {
        if (this.mMm != null) {
            this.mMm.c(i, str, str2, i2);
        } else {
            Toast.makeText(ab.getContext(), str2, 1).show();
        }
    }

    public final void aZ(String str, int i) {
        w.i("MicroMsg.IPCallManager", "onUnAvaliable, currentState: %s", new Object[]{f.stateToString(i.aEl().mMN)});
        if (ck(3, 5)) {
            c(3, null, str, i);
        }
    }

    public final void ba(String str, int i) {
        w.i("MicroMsg.IPCallManager", "onBusy, currentState: %s", new Object[]{f.stateToString(i.aEl().mMN)});
        if (ck(1, 4)) {
            c(1, null, str, i);
        }
    }

    public final void aDB() {
        w.i("MicroMsg.IPCallManager", "onShutdownByOtherSide, currentState: %s", new Object[]{f.stateToString(i.aEl().mMN)});
        if (!C(10, 0, 32)) {
            return;
        }
        if (this.mMm != null) {
            this.mMm.aDO();
        } else {
            Toast.makeText(ab.getContext(), ab.getContext().getString(R.l.eux), 1).show();
        }
    }

    public final void bb(String str, int i) {
        w.i("MicroMsg.IPCallManager", "onSyncFailed");
        if (ck(7, 35)) {
            c(7, null, str, i);
        }
    }

    public final void aDC() {
        w.i("MicroMsg.IPCallManager", "onHeartbeatFailed");
        if (ck(7, 29)) {
            c(7, null, ab.getContext().getString(R.l.dPR), 1);
        }
    }

    public final void v(String str, String str2, int i) {
        w.i("MicroMsg.IPCallManager", "onAccountOverdue, currentState: %s", new Object[]{f.stateToString(i.aEl().mMN)});
        if (ck(8, 9)) {
            c(8, str, str2, i);
        }
    }

    public final void w(String str, String str2, int i) {
        w.i("MicroMsg.IPCallManager", "onCallRestricted, currentState: %s", new Object[]{f.stateToString(i.aEl().mMN)});
        if (ck(10, 0)) {
            c(10, str, str2, i);
        }
    }

    public final void x(String str, String str2, int i) {
        w.i("MicroMsg.IPCallManager", "onCallPhoneNumberInvalid, currentState: %s", new Object[]{f.stateToString(i.aEl().mMN)});
        if (ck(11, 0)) {
            c(11, str, str2, i);
        }
    }

    public final void y(String str, String str2, int i) {
        do {
            w.i("MicroMsg.IPCallManager", "onDisasterHappen, currentState: %s", new Object[]{f.stateToString(i.aEl().mMN)});
        } while (ck(12, 0));
    }

    public final void aDD() {
        w.i("MicroMsg.IPCallManager", "onStartEngineFailed, currentState: %s", new Object[]{f.stateToString(i.aEl().mMN)});
        if (ck(6, 0)) {
            c(6, null, ab.getContext().getString(R.l.dPU), 1);
        }
    }

    public final void aDE() {
        w.i("MicroMsg.IPCallManager", "onChannelConnected, currentState: %s", new Object[]{f.stateToString(i.aEl().mMN)});
        i.aEr().stop();
        hgN.removeCallbacks(this.mMt);
        if (i.aEl().aEc()) {
            com.tencent.mm.plugin.ipcall.a.b.b aEk = i.aEk();
            aEk.mOC.a(ab.getContext(), aEk);
            ap.yZ().a(aEk);
            ap.yZ().qG();
            aEk.mOH = ap.yZ().qO();
            aEk.mOG = ap.yZ().qI();
            w.d("MicroMsg.IPCallDeviceManager", "startPlay, isHeadsetPlugged: %b, isBluetoothConnected: %b", new Object[]{Boolean.valueOf(aEk.mOH), Boolean.valueOf(aEk.mOG)});
            aEk.ict.requestFocus();
            com.tencent.mm.plugin.ipcall.a.b.a aVar = aEk.mOz;
            if (aVar.fOV) {
                w.d("MicroMsg.IPCallAudioPlayer", "startPlay, already start");
            } else {
                w.i("MicroMsg.IPCallAudioPlayer", "startPlay");
                if (aVar.mOt == null) {
                    aVar.mOt = new com.tencent.mm.plugin.voip.model.b();
                    aVar.mOt.O(v2protocal.nON, 20, 1);
                }
                aVar.mOv = aVar.mOt.j(ab.getContext(), false);
                aVar.mOt.reE = new com.tencent.mm.plugin.voip.model.a(aVar) {
                    final /* synthetic */ a mOx;

                    {
                        this.mOx = r1;
                    }

                    public final int x(byte[] bArr, int i) {
                        if (!this.mOx.fOV) {
                            return -1;
                        }
                        if (i.aEi().mOV.playCallback(bArr, i) >= 0) {
                            return 0;
                        }
                        w.e("MicroMsg.IPCallAudioPlayer", "playCallback, error: %d", new Object[]{Integer.valueOf(i.aEi().mOV.playCallback(bArr, i))});
                        return -1;
                    }
                };
                if (aVar.mOt.boX() <= 0) {
                    i.aEj().aEH();
                }
                aVar.eW(aVar.mOw);
                aVar.fOV = true;
            }
            if (!(!aEk.mOH || aEk.mOG || aEk.mOF == null)) {
                aEk.mOF.eZ(true);
            }
            if (!(!aEk.mOG || aEk.mOH || aEk.mOF == null)) {
                aEk.mOF.fa(true);
            }
        }
        i.aEj().aEG();
        i.aEk().aEz();
        if (i.aEl().aEe() && !this.mMo) {
            i.aEj().aEJ();
            i.aEi().aEB();
            this.mMo = true;
            this.mMw = bg.Ny();
            aDK();
            if (this.mMm != null) {
                this.mMm.aDN();
            }
            com.tencent.mm.plugin.ipcall.a.g.k kVar = this.mMn;
            if (kVar != null) {
                w.d("MicroMsg.IPCallRecordStorageLogic", "recordStartTalk, localId: %d", new Object[]{Long.valueOf(kVar.uxb)});
                if (kVar.uxb != -1) {
                    kVar.field_status = 3;
                    i.aEo().a(kVar);
                }
            }
            i.aEj().aEI();
            k.bpZ().bqa();
            k.bpZ().rit = this;
        }
    }

    public final void of(int i) {
        w.i("MicroMsg.IPCallManager", "onChannelConnectFailed, currentState: %s", new Object[]{f.stateToString(i.aEl().mMN)});
        if (i.aEi().mOY) {
            w.i("MicroMsg.IPCallManager", "onChannelConnectFailed, channel already connected");
            if (ck(5, i)) {
                c(5, null, ab.getContext().getString(R.l.dPR), 1);
                return;
            }
            return;
        }
        w.i("MicroMsg.IPCallManager", "onChannelConnectFailed, channel not connet, may be request connect failed");
        if (ck(4, i)) {
            c(4, null, ab.getContext().getString(R.l.dPR), 1);
        }
    }

    public final boolean ck(int i, int i2) {
        if (i.aEl().aEe()) {
            if (i == 0) {
                return C(9, i, i2);
            }
            return C(11, i, i2);
        } else if (i == 0) {
            return C(8, i, i2);
        } else {
            return C(12, i, i2);
        }
    }

    public final void aDF() {
        if (i.aEl().mMN != 5) {
            w.i("MicroMsg.IPCallManager", "onBadNetStatus currentState != accept:%d", new Object[]{Integer.valueOf(i.aEl().mMN)});
            return;
        }
        com.tencent.mm.plugin.ipcall.a.b.b aEk = i.aEk();
        w.i("MicroMsg.IPCallDeviceManager", "onBadNetStatus");
        if (aEk.mOD != null) {
            j jVar = aEk.mOD;
            if (jVar.mYj != null) {
                jVar.mYj.setVisibility(0);
            }
            if (jVar.mYk != null) {
                jVar.mYk.setVisibility(0);
            }
        }
        if (!ap.yZ().gNq.isSpeakerphoneOn()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - aEk.mOI > 30000) {
                aEk.mOI = currentTimeMillis;
                com.tencent.mm.plugin.voip.model.d.bpd().uZ(R.k.dAv);
            }
        }
    }

    public final void aDG() {
        if (i.aEl().mMN != 5) {
            w.i("MicroMsg.IPCallManager", "onResumeGoodNetStatus currentState != accept:%d", new Object[]{Integer.valueOf(i.aEl().mMN)});
            return;
        }
        com.tencent.mm.plugin.ipcall.a.b.b aEk = i.aEk();
        w.i("MicroMsg.IPCallDeviceManager", "onResumeGoodNetStatus");
        if (aEk.mOD != null) {
            aEk.mOD.aFs();
        }
    }

    public final void aDH() {
        int i;
        CharSequence string;
        if (i.aEl().aEe()) {
            Context context = ab.getContext();
            i = R.l.etU;
            Object[] objArr = new Object[1];
            objArr[0] = String.format("%02d:%02d", new Object[]{Long.valueOf(bg.az(this.mMw) / 60), Long.valueOf(bg.az(this.mMw) % 60)});
            string = context.getString(i, objArr);
        } else {
            string = ab.getContext().getString(R.l.etT);
        }
        Intent intent = new Intent(ab.getContext(), IPCallTalkUI.class);
        intent.putExtra("IPCallTalkUI_isFromMiniNotification", true);
        PendingIntent activity = PendingIntent.getActivity(ab.getContext(), 42, intent, 134217728);
        i = R.g.bhV;
        if (com.tencent.mm.compatible.util.d.ep(19)) {
            i = R.g.bhU;
        }
        Notification notification = new Builder(ab.getContext()).setTicker(ab.getContext().getString(R.l.etT)).setWhen(System.currentTimeMillis()).setContentTitle(ab.getContext().getString(R.l.etM)).setContentText(string).setContentIntent(activity).getNotification();
        notification.icon = i;
        notification.flags |= 32;
        ap.getNotification().a(42, notification, false);
        if (i.aEl().aEe()) {
            com.tencent.mm.plugin.voip.model.d.bpe().tt(aDJ());
        } else {
            com.tencent.mm.plugin.voip.model.d.bpe().HE(ab.getContext().getString(R.l.eCw));
        }
    }

    public final void aDI() {
        synchronized (this.lEf) {
            this.mMu = false;
            com.tencent.mm.plugin.voip.model.d.bpe().dismiss();
            ((NotificationManager) ab.getContext().getSystemService("notification")).cancel(42);
        }
    }

    public final int aDJ() {
        int az = (int) bg.az(this.mMw);
        return az > 0 ? az : 0;
    }

    private void aDK() {
        w.i("MicroMsg.IPCallManager", "startTimeCount");
        if (this.fyI != null) {
            this.fyI.KH();
            return;
        }
        if (this.fyI == null) {
            this.fyI = new aj(Looper.getMainLooper(), new aj.a(this) {
                final /* synthetic */ c mMx;

                {
                    this.mMx = r1;
                }

                public final boolean oQ() {
                    this.mMx.aDH();
                    if (i.aEl().aEe() && this.mMx.mMm != null) {
                        this.mMx.mMm.aDQ();
                    }
                    return true;
                }
            }, true);
        }
        this.fyI.v(1000, 1000);
    }
}
