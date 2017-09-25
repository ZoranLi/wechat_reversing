package com.tencent.mm.plugin.voip.model;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.telephony.TelephonyManager;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.c.b.c;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.plugin.appbrand.jsapi.aq;
import com.tencent.mm.plugin.appbrand.jsapi.bh;
import com.tencent.mm.plugin.appbrand.jsapi.cf;
import com.tencent.mm.plugin.appbrand.jsapi.share.f;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.voip.model.a.h;
import com.tencent.mm.plugin.voip.model.a.j;
import com.tencent.mm.plugin.voip.model.a.k;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.bdb;
import com.tencent.mm.protocal.c.bis;
import com.tencent.mm.protocal.c.bjy;
import com.tencent.mm.protocal.c.bkb;
import com.tencent.mm.protocal.c.bkt;
import com.tencent.mm.protocal.c.bku;
import com.tencent.mm.protocal.c.bla;
import com.tencent.mm.protocal.c.blj;
import com.tencent.mm.protocal.c.blu;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.m;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Timer;
import java.util.TimerTask;

public final class e {
    public boolean fSy;
    public Context kLX;
    ae mHandler;
    public int mStatus;
    public boolean rfA;
    public boolean rfB;
    public boolean rfC;
    public int rfD;
    int rfE;
    private int rfF;
    int rfG;
    private int rfH;
    int rfI;
    public boolean rfJ;
    private boolean rfK;
    private int rfL;
    private boolean rfM;
    private int rfN;
    private int rfO;
    private int rfP;
    public v2protocal rfQ;
    public p rfR;
    public g rfS;
    public o rfT;
    public byte[] rfU;
    public bla rfV;
    public boolean rfW;
    public boolean rfX;
    public int rfY;
    public int rfZ;
    public boolean rfm;
    public boolean rfn;
    public boolean rfo;
    public boolean rfp;
    public boolean rfq;
    public boolean rfr;
    public boolean rfs;
    public boolean rft;
    public bdb rfu;
    public int rfv;
    public long rfw;
    public long rfx;
    public int rfy;
    public int rfz;
    public int rga;
    public int rgb;
    public aj rgc;
    public Timer rgd;
    public int rge;
    private aj rgf;
    private a rgg;

    public interface a {
        void q(int i, int i2, String str);
    }

    protected e() {
        this.mStatus = 1;
        this.rfm = false;
        this.rfn = false;
        this.rfo = false;
        this.rfp = false;
        this.fSy = false;
        this.rfq = false;
        this.rfr = false;
        this.rfs = false;
        this.rft = false;
        this.rfu = new bdb();
        this.rfv = 0;
        this.rfw = 0;
        this.rfx = 0;
        this.rfy = 0;
        this.rfz = 0;
        this.rfA = false;
        this.rfB = false;
        this.rfC = false;
        this.rfD = 10;
        this.rfE = -1;
        this.rfF = -1;
        this.rfG = -1;
        this.rfH = -1;
        this.rfI = -1;
        this.rfJ = false;
        this.rfK = false;
        this.rfL = 1;
        this.rfM = false;
        this.rfN = 1;
        this.rfO = -1;
        this.rfP = -1;
        this.kLX = null;
        this.rfR = p.rjq;
        this.rfU = null;
        this.rfV = null;
        this.rfW = false;
        this.rfX = false;
        this.rfY = 0;
        this.rfZ = 0;
        this.rga = 0;
        this.rgb = 0;
        this.rgc = new aj(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.aj.a(this) {
            final /* synthetic */ e rgh;

            {
                this.rgh = r1;
            }

            public final boolean oQ() {
                w.v("MicroMsg.Voip.VoipContext", "voip repeat sync");
                this.rgh.rfT.a(null, false, 7);
                return true;
            }
        }, true);
        this.mHandler = new ae(this, Looper.getMainLooper()) {
            final /* synthetic */ e rgh;

            public final void handleMessage(Message message) {
                if (message == null || message.what != 59998) {
                    super.handleMessage(message);
                } else if (message.arg1 == 1) {
                    if (this.rgh.rfQ.mNL == 0) {
                        com.tencent.mm.plugin.voip.b.a.dI("MicroMsg.Voip.VoipContext", "JNI_DOSYNC without roomid , igored!");
                        return;
                    }
                    com.tencent.mm.plugin.voip.b.a.dK("MicroMsg.Voip.VoipContext", "need dosync for cmd from channel...");
                    r0 = (byte[]) message.obj;
                    o oVar = this.rgh.rfT;
                    r2 = message.arg2;
                    blj com_tencent_mm_protocal_c_blj = new blj();
                    com_tencent_mm_protocal_c_blj.jOc = 1;
                    avw com_tencent_mm_protocal_c_avw = new avw();
                    com_tencent_mm_protocal_c_avw.bb(r0);
                    com_tencent_mm_protocal_c_blj.tij = com_tencent_mm_protocal_c_avw;
                    avw com_tencent_mm_protocal_c_avw2 = new avw();
                    try {
                        com_tencent_mm_protocal_c_avw2.bb(com_tencent_mm_protocal_c_blj.toByteArray());
                        bkt com_tencent_mm_protocal_c_bkt = new bkt();
                        com_tencent_mm_protocal_c_bkt.tsa = r2;
                        com_tencent_mm_protocal_c_bkt.tsb = com_tencent_mm_protocal_c_avw2;
                        com_tencent_mm_protocal_c_bkt.mvV = m.xL();
                        bku com_tencent_mm_protocal_c_bku = new bku();
                        com_tencent_mm_protocal_c_bku.jNd = 1;
                        com_tencent_mm_protocal_c_bku.jNe.add(com_tencent_mm_protocal_c_bkt);
                        oVar.a(com_tencent_mm_protocal_c_bku, true, 2);
                    } catch (Throwable e) {
                        w.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", e, "", new Object[0]);
                    }
                } else if (message.arg1 == 4) {
                    if (this.rgh.rfQ.mNL == 0) {
                        com.tencent.mm.plugin.voip.b.a.dI("MicroMsg.Voip.VoipContext", "JNI_STARTDEVFAILED without roomid , igored!");
                        return;
                    }
                    com.tencent.mm.plugin.voip.b.a.dK("MicroMsg.Voip.VoipContext", "need hangUP for startTalk failed. ");
                    this.rgh.rfQ.rlo.rgD = MMGIFException.D_GIF_ERR_WRONG_RECORD;
                    this.rgh.q(1, -9004, "");
                } else if (message.arg1 == 6) {
                    com.tencent.mm.plugin.voip.b.a.dK("MicroMsg.Voip.VoipContext", "OnChannelConnected from JNI");
                    if (this.rgh.rfQ.mNL == 0) {
                        com.tencent.mm.plugin.voip.b.a.dK("MicroMsg.Voip.VoipContext", "OnChannelConnected roomid null, ignored");
                        return;
                    }
                    this.rgh.rfn = true;
                    this.rgh.rfQ.rlo.rgT = 1;
                    if (this.rgh.rfo || this.rgh.rfp) {
                        this.rgh.rfQ.rko = 0;
                    } else {
                        this.rgh.rfQ.rko = 1;
                    }
                    this.rgh.rfQ.setInactive();
                    com.tencent.mm.plugin.voip.b.a.dK("MicroMsg.Voip.VoipContext", "Voip.Channel setInactive");
                    this.rgh.bpo();
                } else if (message.arg1 == 3) {
                    this.rgh.mStatus = 5;
                } else if (message.arg1 == 5) {
                    com.tencent.mm.plugin.voip.b.a.dJ("MicroMsg.Voip.VoipContext", "need hangUP for disconnect from channel..envent = " + message.arg2);
                    if (this.rgh.mStatus >= 5) {
                        this.rgh.rfQ.rlo.rgD = 108;
                    } else {
                        this.rgh.rfQ.rlo.rgD = MMGIFException.D_GIF_ERR_NO_COLOR_MAP;
                    }
                    if (message.arg2 == 4) {
                        this.rgh.rfQ.rlo.rgV = 1;
                        com.tencent.mm.plugin.voip.b.a.dK("MicroMsg.Voip.VoipContext", "channel broken...");
                    } else if (message.arg2 == 1) {
                        if (this.rgh.rfs) {
                            com.tencent.mm.plugin.voip.b.a.dJ("MicroMsg.Voip.VoipContext", "channel connect fail while pre-connect");
                            this.rgh.rfr = true;
                            return;
                        }
                        com.tencent.mm.plugin.voip.b.a.dJ("MicroMsg.Voip.VoipContext", "channel connect fail...");
                        this.rgh.rfn = false;
                        this.rgh.rfQ.rlo.rgV = 5;
                    } else if (message.arg2 == 5) {
                        if (this.rgh.rfr) {
                            this.rgh.rfQ.rlo.rgV = 6;
                            com.tencent.mm.plugin.voip.b.a.dK("MicroMsg.Voip.VoipContext", "channel network fail while pre-connect...");
                            this.rgh.rfr = true;
                            return;
                        }
                        com.tencent.mm.plugin.voip.b.a.dK("MicroMsg.Voip.VoipContext", "channel network fail");
                        this.rgh.rfQ.rlo.rgV = 6;
                    }
                    this.rgh.q(1, -9000, "");
                } else if (message.arg1 == 100) {
                    com.tencent.mm.plugin.voip.b.a.a((byte[]) message.obj, "MicroMsg.Voip.VoipContext", message.arg2);
                } else if (message.arg1 == 101) {
                    com.tencent.mm.plugin.voip.b.a.a((byte[]) message.obj, "MicroMsg.v2Core", message.arg2);
                } else if (message.arg1 == 7) {
                    int[] iArr = (int[]) message.obj;
                    int i = message.arg2;
                    String str = null;
                    try {
                        str = ((WifiManager) ab.getContext().getSystemService("wifi")).getConnectionInfo().getSSID();
                    } catch (Exception e2) {
                        com.tencent.mm.plugin.voip.b.a.dK("MicroMsg.Voip.VoipContext", "Get wifiName failed in voip speedTest!");
                    }
                    String str2 = null;
                    try {
                        str2 = ((TelephonyManager) ab.getContext().getSystemService("phone")).getSimOperatorName();
                    } catch (Exception e3) {
                        com.tencent.mm.plugin.voip.b.a.dK("MicroMsg.Voip.VoipContext", "Get netName failed in voip speedTest!");
                    }
                    new j(this.rgh.rfx, this.rgh.rfw, this.rgh.rfy, str2, str, this.rgh.rfz, i, iArr).bqD();
                } else if (message.arg1 == 8) {
                    r0 = (byte[]) message.obj;
                    e eVar = this.rgh;
                    try {
                        bis com_tencent_mm_protocal_c_bis = (bis) new bis().aD(r0);
                        com.tencent.mm.plugin.voip.b.a.dJ("MicroMsg.Voip.VoipContext", "steve: onRecvRUDPCmd:" + com_tencent_mm_protocal_c_bis.uiw);
                        switch (com_tencent_mm_protocal_c_bis.uiw) {
                            case 3:
                                if (com_tencent_mm_protocal_c_bis.uix != null) {
                                    Object obj = com_tencent_mm_protocal_c_bis.uix.sYA;
                                    com.tencent.mm.plugin.voip.b.a.dJ("MicroMsg.Voip.VoipContext", "steve: remote new network type:" + obj);
                                    r2 = eVar.rfQ.setAppCmd(302, obj, 4);
                                    if (r2 < 0) {
                                        com.tencent.mm.plugin.voip.b.a.dJ("MicroMsg.Voip.VoipContext", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteNetType] update remote network type " + obj + "fail:" + r2 + ", [roomid=" + eVar.rfQ.mNT + ", roomkey=" + eVar.rfQ.mNM + "]");
                                        return;
                                    }
                                    return;
                                }
                                com.tencent.mm.plugin.voip.b.a.dJ("MicroMsg.Voip.VoipContext", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteNetType] empty buffer");
                                return;
                            case 4:
                                if (com_tencent_mm_protocal_c_bis.uix != null) {
                                    bkb com_tencent_mm_protocal_c_bkb = (bkb) new bkb().aD(com_tencent_mm_protocal_c_bis.uix.sYA);
                                    com.tencent.mm.plugin.voip.b.a.dJ("MicroMsg.Voip.VoipContext", "zhengxue: remote audio dev occupied stat :" + com_tencent_mm_protocal_c_bkb.ujR);
                                    byte[] bArr = new byte[4];
                                    bArr[0] = (byte) com_tencent_mm_protocal_c_bkb.ujR;
                                    eVar.rfQ.setJNIAppCmd(2, bArr, 4);
                                    return;
                                }
                                com.tencent.mm.plugin.voip.b.a.dJ("MicroMsg.Voip.VoipContext", "zhengxue:[CHANNEL]EMethod_AudioDevOccupiedStatsSync empty buffer");
                                return;
                            default:
                                return;
                        }
                    } catch (Exception e4) {
                        com.tencent.mm.plugin.voip.b.a.dJ("MicroMsg.Voip.VoipContext", "onVoipLocalNetTypeChange Error");
                    }
                    com.tencent.mm.plugin.voip.b.a.dJ("MicroMsg.Voip.VoipContext", "onVoipLocalNetTypeChange Error");
                } else if (message.arg1 == 9) {
                    h hVar = this.rgh.rfQ.rlo;
                    if (0 == hVar.rhh) {
                        hVar.rhh = System.currentTimeMillis();
                        com.tencent.mm.plugin.voip.b.a.dJ("MicroMsg.VoipDailReport", "first pkt received timestamp:" + hVar.rhh);
                    }
                    com.tencent.mm.plugin.voip.b.a.dJ("MicroMsg.Voip.VoipContext", "get first pkt for voip");
                    if (1 == this.rgh.rfQ.rkT) {
                        blu com_tencent_mm_protocal_c_blu = new blu();
                        com_tencent_mm_protocal_c_blu.jNB = 1;
                        this.rgh.rfT.a(com_tencent_mm_protocal_c_blu, 2);
                    }
                } else if (message.arg1 == 11) {
                    this.rgh.rgb = 2;
                } else if (message.arg1 == 12) {
                    this.rgh.rgb = 1;
                } else if (message.arg1 == 13) {
                    r7 = (int[]) message.obj;
                    new h(this.rgh.rfQ.mNL, this.rgh.rfQ.mNM, this.rgh.rfQ.mNT, 1, message.arg2, r7).bqD();
                } else if (message.arg1 == 14) {
                    r7 = (int[]) message.obj;
                    new h(this.rgh.rfQ.mNL, this.rgh.rfQ.mNM, this.rgh.rfQ.mNT, 2, message.arg2, r7).bqD();
                }
            }
        };
        this.rgd = null;
        this.rge = 0;
        this.rgf = new aj(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.aj.a(this) {
            final /* synthetic */ e rgh;

            {
                this.rgh = r1;
            }

            public final boolean oQ() {
                if (this.rgh.mStatus == 4) {
                    com.tencent.mm.plugin.voip.b.a.dJ("MicroMsg.Voip.VoipContext", "connect time out.. now finish..");
                    this.rgh.rfQ.rlo.rgD = MMGIFException.D_GIF_ERR_NO_IMAG_DSCR;
                    this.rgh.q(1, -9000, "");
                }
                return false;
            }
        }, false);
        this.rgg = null;
        this.rfQ = new v2protocal(this.mHandler);
        this.rfS = new g(this);
        this.rfT = new o(this);
        this.rga = 0;
    }

    public final void reset() {
        w.i("MicroMsg.Voip.VoipContext", "reset");
        this.rfR.bpR();
        if (this.rfQ.nGp) {
            this.rfQ.ij(false);
        }
        this.rfQ.reset();
        this.rfE = -1;
        this.rfF = -1;
        this.rfG = -1;
        this.rfH = -1;
        this.rfI = -1;
        this.rfS.bpw();
        this.rfQ.rkd = 0;
        this.rgf.KH();
        this.rfT.bqz();
        this.rgc.KH();
        this.rfm = false;
        this.rfn = false;
        this.rfo = false;
        this.rfp = false;
        this.fSy = false;
        this.rfq = false;
        this.rfU = null;
        this.rfV = null;
        this.rfA = false;
        this.rfB = false;
        this.rfC = false;
        this.rfJ = false;
        this.rfK = false;
        this.rfM = false;
        this.rfL = 1;
        this.rfN = 1;
        this.rfW = false;
        this.rfO = -1;
        this.rfP = -1;
        this.rfr = false;
        this.rfs = false;
        this.rfq = false;
        this.rfm = false;
        this.rft = false;
        this.rfD = 10;
        this.mStatus = 1;
        this.rga = 0;
        this.rgb = 0;
    }

    public final void bpf() {
        int i = 0;
        if (this.rfm && this.rfv == 0) {
            this.rfv = 1;
            if (this.rfQ.field_speedTestInfoLength < 8) {
                com.tencent.mm.plugin.voip.b.a.dI("MicroMsg.Voip.VoipContext", "Herohe StartVoipSpeedTest failed! bufsize=" + this.rfQ.field_speedTestInfoLength);
                return;
            }
            int i2 = this.rfQ.rlm[1];
            if (i2 + 2 > this.rfQ.field_speedTestInfoLength) {
                com.tencent.mm.plugin.voip.b.a.dI("MicroMsg.Voip.VoipContext", "Herohe StartVoipSpeedTest failed! C2CRttCnt=" + i2 + ", bufsize=" + this.rfQ.field_speedTestInfoLength);
                return;
            }
            int i3 = this.rfQ.rlm[(i2 + 2) + 1];
            if ((i2 + 6) + i3 != this.rfQ.field_speedTestInfoLength) {
                com.tencent.mm.plugin.voip.b.a.dI("MicroMsg.Voip.VoipContext", "Herohe StartVoipSpeedTest failed! C2CRttCnt=" + i2 + ", C2SRttCnt=" + i3 + ", bufsize=" + this.rfQ.field_speedTestInfoLength);
                return;
            }
            this.rfw = this.rfQ.mNM;
            this.rfy = this.rfQ.netType;
            this.rfz = this.rfQ.mNL;
            this.rfu.tvL = this.rfQ.mNL;
            this.rfu.ued = this.rfQ.rjW;
            this.rfu.trD = this.rfQ.netType;
            this.rfu.uee = this.rfm ? 1 : 0;
            bdb com_tencent_mm_protocal_c_bdb = this.rfu;
            if (this.rfn) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            com_tencent_mm_protocal_c_bdb.uef = i2;
            this.rfu.ueg = this.rfQ.rlm[0];
            this.rfu.ueh = this.rfQ.rlm[1];
            int i4 = 2;
            i2 = 0;
            while (i2 < this.rfu.ueh) {
                i3 = i4 + 1;
                this.rfu.uei.add(Integer.valueOf(this.rfQ.rlm[i4]));
                i2++;
                i4 = i3;
            }
            int i5 = i4 + 1;
            this.rfu.uej = this.rfQ.rlm[i4];
            i2 = i5 + 1;
            this.rfu.uek = this.rfQ.rlm[i5];
            while (i < this.rfu.uek) {
                i4 = i2 + 1;
                this.rfu.uel.add(Integer.valueOf(this.rfQ.rlm[i2]));
                i++;
                i2 = i4;
            }
            i3 = i2 + 1;
            this.rfu.uem = this.rfQ.rlm[i2];
            this.rfu.uen = this.rfQ.rlm[i3];
            new k(this.rfu).bqD();
            return;
        }
        com.tencent.mm.plugin.voip.b.a.dI("MicroMsg.Voip.VoipContext", "StartVoipSpeedTest fail for status is wrong: isChannelStartConnect=" + this.rfm + " ,mSpeedTestStatus=" + this.rfv);
    }

    public final void bpg() {
        if (this.rfv != 0) {
            if (this.rfv == 1) {
                this.rfv = 0;
                this.rfQ.rkU = 0;
                return;
            }
            this.rfv = 0;
            v2protocal com_tencent_mm_plugin_voip_model_v2protocal = this.rfQ;
            com.tencent.mm.plugin.voip.b.a.dK("MicroMsg.Voip", "v2protocal StopVoipSpeedTest!");
            com_tencent_mm_plugin_voip_model_v2protocal.StopSpeedTest();
            com_tencent_mm_plugin_voip_model_v2protocal.rkU = 0;
        }
    }

    public final void uK(int i) {
        this.rfQ.rjY = Math.abs(i);
    }

    public final void bph() {
        this.rfQ.rjZ = this.rfS.bpv();
        this.rfQ.rka = this.rfS.bpa();
    }

    public final void uL(int i) {
        this.rfQ.rkb = i;
    }

    public final void shutdown() {
        bpt();
        this.mHandler.post(new Runnable(this) {
            final /* synthetic */ e rgh;

            {
                this.rgh = r1;
            }

            public final void run() {
                if (this.rgh.rfR != null) {
                    this.rgh.rfR.bpQ();
                }
            }
        });
    }

    public final void dv(int i) {
        if (i != this.mStatus) {
            if (i == 4) {
                this.rgf.v(60000, 60000);
            }
            this.mStatus = i;
        }
    }

    public final int bpi() {
        if (this.mStatus == 1) {
            return 0;
        }
        if (this.mStatus == 2 || this.mStatus == 3) {
            return 1;
        }
        if (this.mStatus != 4) {
            return 3;
        }
        return 2;
    }

    public final boolean bpj() {
        if (this.mStatus == 3) {
            return true;
        }
        return false;
    }

    public final boolean bpk() {
        w.d("MicroMsg.Voip.VoipContext", "isWorking, status: %d", new Object[]{Integer.valueOf(this.mStatus)});
        if (this.mStatus == 1) {
            return false;
        }
        return true;
    }

    public final void uM(int i) {
        if (8 == i || 9 == i) {
            this.rfH = i;
        } else {
            this.rfE = i;
            this.rfF = i;
        }
        o oVar = this.rfT;
        byte[] vc = com.tencent.mm.plugin.voip.b.a.vc(i);
        avw com_tencent_mm_protocal_c_avw = new avw();
        com_tencent_mm_protocal_c_avw.bb(vc);
        avw com_tencent_mm_protocal_c_avw2 = new avw();
        try {
            com_tencent_mm_protocal_c_avw2.bb(com_tencent_mm_protocal_c_avw.toByteArray());
            bkt com_tencent_mm_protocal_c_bkt = new bkt();
            com_tencent_mm_protocal_c_bkt.tsa = 3;
            com_tencent_mm_protocal_c_bkt.tsb = com_tencent_mm_protocal_c_avw2;
            com_tencent_mm_protocal_c_bkt.mvV = m.xL();
            bku com_tencent_mm_protocal_c_bku = new bku();
            com_tencent_mm_protocal_c_bku.jNd = 1;
            com_tencent_mm_protocal_c_bku.jNe.add(com_tencent_mm_protocal_c_bkt);
            oVar.a(com_tencent_mm_protocal_c_bku, false, 4);
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", e, "", new Object[0]);
        }
    }

    public final boolean bpl() {
        if (this.rfC || this.rfQ.netType == 1) {
            return false;
        }
        switch (this.rfE) {
            case -1:
                return true;
            case 0:
                if (4 != this.rfF) {
                    return false;
                }
                break;
            case 1:
            case 2:
            case 3:
                return false;
            case 4:
                if (!(4 == this.rfF || -1 == this.rfF)) {
                    return false;
                }
            case 5:
            case 6:
            case 7:
                if (5 == this.rfF || 6 == this.rfF) {
                    return false;
                }
                if (7 == this.rfF) {
                    return false;
                }
                break;
        }
        return true;
    }

    public final boolean bpm() {
        if (this.rfC) {
            return false;
        }
        switch (this.rfE) {
            case -1:
                return true;
            case 0:
                if (4 != this.rfF) {
                    return false;
                }
                break;
            case 1:
            case 2:
            case 3:
                return false;
            case 4:
                if (!(4 == this.rfG || this.rfG == 0 || -1 == this.rfG)) {
                    return false;
                }
            case 5:
            case 6:
            case 7:
                if (5 == this.rfG || 6 == this.rfG) {
                    return false;
                }
                if (7 == this.rfG) {
                    return false;
                }
                break;
        }
        return true;
    }

    private void bpn() {
        com.tencent.mm.plugin.voip.b.a.dK("MicroMsg.Voip.VoipContext", "DeviceInfo.mAudioInfo.aecMode:" + p.gRd.gOw);
        if (p.gRd.gNZ == 1) {
            this.rfQ.pQ(410);
        }
        byte[] bArr = new byte[2];
        if (p.gRd.gOw >= 0) {
            bArr[0] = (byte) p.gRd.gOw;
            this.rfQ.setAppCmd(406, bArr, 1);
        } else if (p.gRd.gOw == -2) {
            this.rfQ.pQ(407);
        }
        if (p.gRd.gOx >= 0) {
            bArr[0] = (byte) p.gRd.gOx;
            this.rfQ.setAppCmd(408, bArr, 1);
        } else if (p.gRd.gOx == -2) {
            this.rfQ.pQ(409);
        }
        if (p.gRd.gOz >= 0) {
            byte[] bArr2 = new byte[5];
            if (p.gRd.gOA >= 0 && p.gRd.gOB >= 0) {
                bArr2[0] = (byte) p.gRd.gOA;
                bArr2[1] = (byte) p.gRd.gOB;
                if (p.gRd.gOC >= 0) {
                    bArr2[2] = (byte) p.gRd.gOC;
                    bArr2[3] = (byte) p.gRd.gOz;
                    bArr2[4] = (byte) p.gRd.gOD;
                    this.rfQ.setAppCmd(TencentLocation.ERROR_UNKNOWN, bArr2, 5);
                } else {
                    this.rfQ.setAppCmd(TencentLocation.ERROR_UNKNOWN, bArr2, 2);
                }
            }
        } else if (p.gRd.gOz == -2) {
            this.rfQ.pQ(405);
        }
        if (p.gRd.gOa >= 0 || p.gRd.gOc >= 0) {
            bArr[0] = (byte) -1;
            bArr[1] = (byte) -1;
            if (p.gRd.gOa >= 0) {
                bArr[0] = (byte) p.gRd.gOa;
            }
            if (p.gRd.gOc >= 0) {
                bArr[1] = (byte) p.gRd.gOc;
            }
            this.rfQ.setAppCmd(414, bArr, 2);
        }
        if (p.gRd.gOb >= 0 || p.gRd.gOd >= 0) {
            bArr[0] = (byte) -1;
            bArr[1] = (byte) -1;
            if (p.gRd.gOb >= 0) {
                bArr[0] = (byte) p.gRd.gOb;
            }
            if (p.gRd.gOd >= 0) {
                bArr[1] = (byte) p.gRd.gOd;
            }
            this.rfQ.setAppCmd(415, bArr, 2);
        }
        if (p.gRd.gOe >= 0 || p.gRd.gOf >= 0) {
            bArr[0] = (byte) -1;
            bArr[1] = (byte) -1;
            if (p.gRd.gOe >= 0) {
                bArr[0] = (byte) p.gRd.gOe;
            }
            if (p.gRd.gOf >= 0) {
                bArr[1] = (byte) p.gRd.gOf;
            }
            this.rfQ.setAppCmd(422, bArr, 2);
        }
        if (p.gRd.gOg >= 0) {
            bArr[0] = (byte) p.gRd.gOg;
            this.rfQ.setAppCmd(416, bArr, 1);
        }
        if (p.gRd.gOh >= 0 && !(this.rfQ.rkw == 0 && p.gRd.gOh == 5)) {
            bArr[0] = (byte) p.gRd.gOh;
            this.rfQ.setAppCmd(417, bArr, 1);
        }
        if (p.gRd.gOi >= 0 && !(this.rfQ.rkw == 0 && p.gRd.gOi == 5)) {
            bArr[0] = (byte) p.gRd.gOi;
            this.rfQ.setAppCmd(418, bArr, 1);
        }
        if (p.gRd.gOj >= 0) {
            bArr[0] = (byte) p.gRd.gOj;
            this.rfQ.setAppCmd(419, bArr, 1);
        }
        if (this.rfQ.rkw == 1 && (p.gRd.gOh == 5 || p.gRd.gOi == 5)) {
            this.rfQ.rkj = 5;
        }
        if (1 == p.gRd.gOG) {
            byte[] bArr3 = new byte[30];
            for (int i = 0; i < 15; i++) {
                bArr3[i * 2] = (byte) (p.gRd.gOH[i] & 255);
                bArr3[(i * 2) + 1] = (byte) ((p.gRd.gOH[i] >> 8) & 255);
            }
            this.rfQ.setAppCmd(420, bArr3, 30);
        }
        if (p.gRd.gOG == 0) {
            this.rfQ.pQ(421);
        }
        if (p.gRd.gOI[0] > (short) 0 || p.gRd.gOI[1] > (short) 0) {
            bArr[0] = (byte) 0;
            bArr[1] = (byte) 0;
            if (p.gRd.gOI[0] > (short) 0 && p.gRd.gOI[0] < (short) 10000) {
                bArr[0] = (byte) p.gRd.gOI[0];
            }
            if (p.gRd.gOI[1] > (short) 0 && p.gRd.gOI[1] < (short) 10000) {
                bArr[1] = (byte) p.gRd.gOI[1];
            }
            this.rfQ.setAppCmd(423, bArr, 2);
        }
        if (p.gRd.gOK > 0) {
            bArr[0] = (byte) p.gRd.gOK;
            this.rfQ.setAppCmd(424, bArr, 1);
        }
        if (p.gRd.gOS >= 0) {
            this.rfQ.setAppCmd(426, new byte[]{(byte) p.gRd.gOS, (byte) p.gRd.gOT, (byte) p.gRd.gOU, (byte) p.gRd.gOV}, 4);
        }
    }

    public final void bpo() {
        com.tencent.mm.plugin.voip.b.a.dK("MicroMsg.Voip.VoipContext", "tryStartTalk: try start talk");
        if (this.rfq && this.rfn) {
            com.tencent.mm.plugin.voip.b.a.dK("MicroMsg.Voip.VoipContext", "Voip tryStartTalk, channel setActive");
            this.rfQ.setActive();
            if (this.rft) {
                com.tencent.mm.plugin.voip.b.a.dK("MicroMsg.Voip.VoipContext", "tryStartTalk: engine already started, isEngineStarted " + this.rft);
                return;
            }
            if (this.rfQ.startEngine() == 0) {
                this.rfQ.rlo.rhd = 0;
            } else {
                this.rft = false;
                this.rfQ.rlo.rhd = 1;
            }
            bpn();
            if (!bpl() && !bpm()) {
                bpr();
            } else if (this.rgd != null) {
                bpr();
            } else {
                this.rgd = new Timer();
                this.rge = 0;
                this.rgd.schedule(new TimerTask(this) {
                    final /* synthetic */ e rgh;

                    {
                        this.rgh = r1;
                    }

                    public final void run() {
                        e eVar = this.rgh;
                        eVar.rge++;
                        if (this.rgh.rfQ.rla != 0 || this.rgh.rge > 10) {
                            this.rgh.bpr();
                            this.rgh.rgd.cancel();
                            this.rgh.rgd = null;
                        }
                    }
                }, 200, 200);
            }
            this.rfR.bpS();
            g gVar = this.rfS;
            if (gVar.rgm == 2) {
                com.tencent.mm.plugin.voip.b.a.dI("MicroMsg.Voip.VoipDeviceHandler", "dev start already...");
            } else {
                com.tencent.mm.plugin.voip.b.a.dJ("MicroMsg.Voip.VoipDeviceHandler", "start device......");
                gVar.rgm = 2;
                if (gVar.rgA != null) {
                    com.tencent.mm.plugin.voip.b.a.dK("MicroMsg.Voip.VoipDeviceHandler", "stop videodecode thread..");
                    gVar.rgA.rgC = true;
                    com.tencent.mm.sdk.f.e.remove(gVar.rgA);
                    gVar.rgA = null;
                }
                gVar.rgA = new b(gVar);
                com.tencent.mm.sdk.f.e.post(gVar.rgA, "VoipDeviceHandler_decode");
                com.tencent.mm.plugin.voip.b.a.dK("MicroMsg.Voip.VoipDeviceHandler", "start video decode thread..");
                p.gRd.dump();
                gVar.rgk = new b();
                gVar.rgk.O(v2protocal.nON, 20, 0);
                gVar.rgn = gVar.rgk.j(gVar.rew.kLX, true);
                byte[] bArr = new byte[1];
                bArr[0] = (byte) (gVar.rgk.rev ? 1 : 0);
                gVar.rew.rfQ.setAppCmd(502, bArr, 1);
                if (gVar.rgn <= 10) {
                    if (gVar.rgn <= 0) {
                        gVar.rgx = 1;
                    }
                    gVar.rgn = 92;
                }
                gVar.rgk.reE = new a(gVar) {
                    final /* synthetic */ g rgB;

                    {
                        this.rgB = r1;
                    }

                    public final int x(byte[] bArr, int i) {
                        if (this.rgB.rgm != 2) {
                            return -1;
                        }
                        int playCallback = this.rgB.rew.rfQ.playCallback(bArr, i);
                        if (playCallback < 0) {
                            com.tencent.mm.plugin.voip.b.a.dI("MicroMsg.Voip.VoipDeviceHandler", com.tencent.mm.compatible.util.g.sd() + "protocal.playcallback ret:" + playCallback);
                            return -1;
                        }
                        g.rgy++;
                        return 0;
                    }
                };
                if (gVar.rgk.boX() <= 0) {
                    gVar.rgx = 1;
                }
                synchronized (gVar.rgw) {
                    com.tencent.mm.sdk.f.e.b(new Runnable(gVar) {
                        final /* synthetic */ g rgB;

                        {
                            this.rgB = r1;
                        }

                        public final void run() {
                            try {
                                g gVar = this.rgB;
                                gVar.nOV = new c(v2protocal.nON, 1);
                                gVar.nOV.cY(20);
                                gVar.nOV.at(true);
                                gVar.nOV.pe();
                                gVar.nOV.fzT = -19;
                                gVar.nOV.r(1, false);
                                gVar.nOV.as(true);
                                gVar.nOV.fAe = gVar.mOP;
                                if (!(gVar.nOV.pf() || gVar.nOV.fzJ == 13)) {
                                    gVar.rgx = 1;
                                }
                                com.tencent.mm.plugin.voip.b.a.dK("MicroMsg.Voip.VoipDeviceHandler", "  VoipDeivceHandler.m_iAudioDevErr:" + gVar.rgx);
                                gVar.rew.uK(gVar.rgx);
                                gVar.rew.rfQ.rlo.rgN = (byte) 1;
                            } catch (Exception e) {
                                w.e("MicroMsg.Voip.VoipDeviceHandler", "start record error: %s", new Object[]{e.getMessage()});
                                this.rgB.rgx = 1;
                                this.rgB.rew.uK(this.rgB.rgx);
                            }
                        }
                    }, "voip_start_record", 10);
                }
            }
            h hVar = this.rfQ.rlo;
            if (hVar.beginTime == 0) {
                hVar.rgW = 0;
            } else {
                hVar.rgW = (int) (System.currentTimeMillis() - hVar.beginTime);
            }
            com.tencent.mm.plugin.voip.b.a.dJ("MicroMsg.VoipDailReport", "devin:beginTime:" + hVar.beginTime + ", CurrentTime: " + System.currentTimeMillis());
            com.tencent.mm.plugin.voip.b.a.dJ("MicroMsg.VoipDailReport", "devin:endNewDial:" + hVar.rgW);
            this.rfR.onConnected();
            this.mStatus = 5;
            hVar = this.rfQ.rlo;
            hVar.rhe = System.currentTimeMillis();
            com.tencent.mm.plugin.voip.b.a.dJ("MicroMsg.VoipDailReport", "devin:beginTalk:" + hVar.rhe);
            this.rfQ.setSvrConfig(f.CTRL_INDEX, this.rfQ.rkp, this.rfQ.rkq, 0, 0, 0, 0);
            this.rfQ.setSvrConfig(aq.CTRL_INDEX, 0, 0, this.rfQ.rku, 0, 0, 0);
            this.rfQ.setSvrConfig(103, this.rfQ.rkr, this.rfQ.rks, this.rfQ.rkt, this.rfQ.rkv, 0, 0);
            this.rfQ.setSvrConfig(cf.CTRL_INDEX, 0, 0, this.rfQ.rkK, 0, 0, 0);
            com.tencent.mm.plugin.voip.b.a.dJ("MicroMsg.Voip.VoipContext", "bothSideGeneralSwitch" + this.rfQ.rkK);
            int i = (this.rfQ.rkx >> 2) & 3;
            int i2 = this.rfQ.rkx & 3;
            int i3 = this.rfQ.mNT == 0 ? (i << 2) + i2 : (i2 << 2) + i;
            this.rfQ.setSvrConfig(502, 0, 0, i3, 0, 0, 0);
            this.rfQ.setSvrConfig(503, 0, 0, this.rfQ.rky, this.rfQ.rkz, this.rfQ.rkA, this.rfQ.rkB);
            if (!(this.rfQ.rkP == null || this.rfQ.rkQ == null)) {
                this.rfQ.setSvrConfig(504, 0, 0, this.rfQ.rkO, 0, 0, 0);
                this.rfQ.setSvrConfig(505, 0, 0, this.rfQ.rkP[0], this.rfQ.rkP[1], this.rfQ.rkP[2], this.rfQ.rkP[3]);
                this.rfQ.setSvrConfig(506, 0, 0, this.rfQ.rkQ[0], this.rfQ.rkQ[1], 0, 0);
                com.tencent.mm.plugin.voip.b.a.dJ("MicroMsg.Voip.VoipContext", "FECSvrCtr = " + this.rfQ.rkO + ",FECKeyPara1 = " + this.rfQ.rkP[0] + "," + this.rfQ.rkP[1] + "," + this.rfQ.rkP[2] + "," + this.rfQ.rkP[3] + ",FECKeyPara2 = " + this.rfQ.rkQ[0] + "," + this.rfQ.rkQ[1]);
            }
            this.rfQ.setSvrConfig(507, 0, 0, (this.rfQ.rkC & 4) >> 2, (this.rfQ.rkC & 2) >> 1, this.rfQ.rkC & 1, 0);
            com.tencent.mm.plugin.voip.b.a.dJ("MicroMsg.Voip.VoipContext", "zhengxue[Logic] setSvrConfig brefore onStartTalk: audioTsdfBeyond3G = " + this.rfQ.rkp + ",audioTsdEdge = " + this.rfQ.rkq + ",passthroughQosAlgorithm = " + this.rfQ.rkr + ",fastPlayRepair = " + this.rfQ.rks + ", audioDTX = " + this.rfQ.rku + ", mARQFlag = " + i3 + ", mQosStrategy = " + this.rfQ.rkC + ", mSvrCfgListV = " + this.rfQ.rkt + ", maxBRForRelay = " + this.rfQ.rkv);
            byte[] bArr2 = new byte[]{(byte) p.gRc.gPy, (byte) -1};
            com.tencent.mm.plugin.voip.b.a.dK("MicroMsg.Voip.VoipContext", "steve: Model Name: " + Build.MODEL);
            com.tencent.mm.plugin.voip.b.a.dK("MicroMsg.Voip.VoipContext", "steve: Image Enhancement for Android Capture!!, mode: " + bArr2[0]);
            this.rfQ.setAppCmd(15, bArr2, 1);
            com.tencent.mm.plugin.voip.b.a.dK("MicroMsg.Voip.VoipContext", "anlin: ClientVersion: " + d.sYN);
            ByteBuffer allocate = ByteBuffer.allocate(4);
            allocate.order(ByteOrder.LITTLE_ENDIAN).putInt(d.sYN);
            this.rfQ.setAppCmd(505, allocate.array(), 4);
            this.rft = true;
            return;
        }
        com.tencent.mm.plugin.voip.b.a.dK("MicroMsg.Voip.VoipContext", "tryStartTalk: fail isCanSendData " + this.rfq + ", isChannelConnectedSuccess " + this.rfn);
    }

    public final boolean bpp() {
        boolean bpl = bpl();
        int i = 0;
        if (bpl) {
            i = 1;
        }
        if (this.rfO == -1 || this.rfO != i) {
            this.rfO = i;
            if (bpl) {
                com.tencent.mm.plugin.voip.b.a.dK("MicroMsg.Voip.VoipContext", "setAppCmd: set start video Out.......!");
                this.rfQ.pQ(aq.CTRL_INDEX);
            } else {
                com.tencent.mm.plugin.voip.b.a.dK("MicroMsg.Voip.VoipContext", "setAppCmd: set stop video Out.......!");
                this.rfQ.pQ(f.CTRL_INDEX);
            }
        }
        return bpl;
    }

    public final boolean bpq() {
        boolean bpm = bpm();
        int i = 0;
        if (bpm) {
            i = 1;
        }
        if (this.rfP == -1 || this.rfP != i) {
            this.rfP = i;
            if (bpm) {
                com.tencent.mm.plugin.voip.b.a.dK("MicroMsg.Voip.VoipContext", "setAppCmd: set start video In.......!");
                this.rfQ.pQ(bh.CTRL_INDEX);
            } else {
                com.tencent.mm.plugin.voip.b.a.dK("MicroMsg.Voip.VoipContext", "setAppCmd: set stop video In.......!");
                this.rfQ.pQ(com.tencent.mm.plugin.appbrand.jsapi.map.m.CTRL_INDEX);
            }
        }
        return bpm;
    }

    public final void bpr() {
        if (this.mStatus == 5) {
            dv(6);
            h hVar = this.rfQ.rlo;
            if (hVar.beginTime == 0) {
                hVar.rgG = 0;
            } else {
                hVar.rgG = (int) (System.currentTimeMillis() - hVar.beginTime);
            }
            com.tencent.mm.plugin.voip.b.a.dJ("MicroMsg.VoipDailReport", "devin:beginTime:" + hVar.beginTime + ", CurrentTime: " + System.currentTimeMillis());
            com.tencent.mm.plugin.voip.b.a.dJ("MicroMsg.VoipDailReport", "devin:endDial:" + hVar.rgG);
            com.tencent.mm.plugin.voip.b.a.dK("MicroMsg.Voip.VoipContext", "talking  now .......!");
            this.mHandler.post(new Runnable(this) {
                final /* synthetic */ e rgh;

                {
                    this.rgh = r1;
                }

                public final void run() {
                    this.rgh.rfR.bpP();
                }
            });
        }
    }

    public final void bps() {
        this.rfQ.rlo.rgP = 7;
        if (bg.bm(this.rfQ.rjM) || !(this.mStatus == 4 || ((this.mStatus == 2 && this.rfs) || (this.mStatus == 3 && this.rfs)))) {
            com.tencent.mm.plugin.voip.b.a.dK("MicroMsg.Voip.VoipContext", "channel:try start connect fail; mStatus:" + this.mStatus + ", isPreConnect:" + this.rfs);
            return;
        }
        com.tencent.mm.plugin.voip.b.a.dJ("MicroMsg.Voip.VoipContext", "v2protocal StartConnectChannel");
        int i = ((((this.rfQ.rkx >> 2) & 3) >> 1) & 1) & (((this.rfQ.rkx & 3) >> 1) & 1);
        int configConnect = this.rfQ.setConfigConnect(this.rfQ.rjK, (long) this.rfQ.mNL, this.rfQ.mNT, this.rfQ.mNM, this.rfQ.rjM, this.rfQ.channelStrategy, this.rfQ.rjR, this.rfQ.rjS, this.rfQ.rjP, this.rfQ.rjQ.length, this.rfQ.rjQ, this.rfQ.rjT, i, this.rfQ.rjJ, this.rfQ.rkH, this.rfQ.rkI, this.rfQ.rkJ, this.rfQ.rjU);
        com.tencent.mm.plugin.voip.b.a.dJ("MicroMsg.Voip.VoipContext", "zhengxue[Logic], mARQFlag: " + i + ",  NetType: " + this.rfQ.rjJ + ", EncryptStrategy: " + this.rfQ.rkH);
        if (configConnect < 0) {
            com.tencent.mm.plugin.voip.b.a.dI("MicroMsg.Voip.VoipContext", "v2protocal setConfigConnect failed, ret:" + configConnect);
            this.rfQ.rlo.rgD = 14;
            q(1, -9002, "");
            return;
        }
        this.rfQ.rjM = null;
        this.rfm = true;
        this.rfQ.rlo.rgK = (byte) 1;
        this.rfQ.rlo.rgS = 1;
    }

    public final void aH(byte[] bArr) {
        w.d("MicroMsg.Voip.VoipContext", "updateRemotePid");
        this.rfQ.rlo.rgI = (byte) 1;
        this.rfQ.rlo.rgH = (byte) 1;
        this.rfQ.rjM = bArr;
    }

    public final void b(int i, byte[] bArr, byte[] bArr2) {
        this.rfQ.rkO = i;
        this.rfQ.rkP = bArr;
        this.rfQ.rkQ = bArr2;
    }

    public final void a(byte[] bArr, int i, int i2, byte[] bArr2) {
        this.rfQ.rjP = i;
        this.rfQ.rjQ = bArr;
        this.rfQ.rkH = i2;
        this.rfQ.rkI = bArr2;
    }

    public final void uN(int i) {
        this.rfQ.rkJ = i;
    }

    public final void a(bjy com_tencent_mm_protocal_c_bjy, bjy com_tencent_mm_protocal_c_bjy2, bjy com_tencent_mm_protocal_c_bjy3) {
        this.rfQ.b(com_tencent_mm_protocal_c_bjy, com_tencent_mm_protocal_c_bjy2, com_tencent_mm_protocal_c_bjy3);
    }

    public final void g(int i, int i2, int i3, int i4, int i5) {
        this.rfQ.rkx = i;
        this.rfQ.rky = i2;
        this.rfQ.rkz = i3;
        this.rfQ.rkA = i4;
        this.rfQ.rkB = i5;
    }

    public final void uO(int i) {
        this.rfQ.rkC = i;
    }

    public final void aI(byte[] bArr) {
        w.i("MicroMsg.Voip.VoipContext", "updateRemoteCapInfo, isGotCapInfo: %s", new Object[]{Byte.valueOf(this.rfQ.rlo.rgM)});
        if (this.rfQ.rlo.rgM != (byte) 1) {
            this.rfQ.rlo.rgM = (byte) 1;
            this.rfQ.rjN = bArr;
            int exchangeCabInfo = this.rfQ.exchangeCabInfo(this.rfQ.rjN, this.rfQ.rjN.length);
            if (exchangeCabInfo < 0) {
                com.tencent.mm.plugin.voip.b.a.dI("MicroMsg.Voip.VoipContext", "protocal exchangecabinfo failed ret:" + exchangeCabInfo);
                this.rfQ.rlo.rgD = 15;
                q(1, -9003, "");
            }
        }
    }

    public final void uP(int i) {
        this.rfQ.rlo.rgJ = (byte) 1;
        this.rfQ.channelStrategy = i;
    }

    public final void uQ(int i) {
        this.rfQ.rjT = i;
    }

    public final void bpt() {
        w.i("MicroMsg.Voip.VoipContext", "stop repeat voip sync");
        this.rgc.KH();
    }

    public final void a(a aVar) {
        if (aVar != null) {
            this.rgg = aVar;
        }
    }

    public final void q(int i, int i2, String str) {
        bpt();
        if (this.rgg != null) {
            this.rgg.q(i, i2, str);
        }
    }
}
