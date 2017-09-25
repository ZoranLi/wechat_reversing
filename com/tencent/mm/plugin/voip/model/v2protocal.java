package com.tencent.mm.plugin.voip.model;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Message;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mm.compatible.d.b;
import com.tencent.mm.compatible.d.l;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.compatible.loader.d;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.l.e;
import com.tencent.mm.plugin.voip.b.a;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.protocal.c.bjy;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.u.ag;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class v2protocal {
    public static final int nON;
    public static int qXE;
    public static final int rjF;
    public static boolean rjG = false;
    public int channelStrategy = 0;
    public int defaultHeight = 240;
    public int defaultWidth = 320;
    public int[] field_ChannelReportDial = null;
    public int[] field_EngineAudioReportStat = null;
    public int[] field_SpeedTestSvrParaArray = null;
    public int field_audioDuration = 0;
    public byte[] field_capInfo = null;
    int field_channelReportLength = 0;
    int field_channelStatLength = 0;
    public int field_connectingStatusKey = 0;
    int field_engine2ndReportLength = 0;
    int field_engine2ndStatLength = 0;
    int field_engineQosStatLength = 0;
    int field_engineVersionStatLength = 0;
    public int field_localImgHeight = 0;
    public int field_localImgWidth = 0;
    public int field_mGetValidSample = 0;
    int field_netFlowRecv = 0;
    int field_netFlowSent = 0;
    int field_newEngineExtStatLength = 0;
    int field_newEngineReportLength = 0;
    int field_newEngineStatLength = 0;
    public byte[] field_peerId = null;
    public int field_pstnChannelInfoLength = 0;
    public int field_pstnEngineInfoLength = 0;
    public int[] field_punchSvrArray = null;
    public int field_realLinkQualityInfoBuffLen = 0;
    public int field_recvVideoLen = 120;
    public int field_relayDataSyncKey = 0;
    public int[] field_relaySvrArray = null;
    public int[] field_relayTcpSvrArray = null;
    public int field_remoteImgHeight = 0;
    public int field_remoteImgLength = 0;
    public int field_remoteImgOrien = 0;
    public int field_remoteImgWidth = 0;
    public int field_sendVideoLen = 100;
    int field_speedTestInfoLength = 0;
    int field_statInfoLength = 0;
    public int field_statusSyncKey = 0;
    public int field_videoDuration = 0;
    public int field_voipcsChannelInfoLength = 0;
    public int field_voipcsEngineInfoLength = 0;
    public long hFg = 0;
    private ae handler = null;
    public int mNL = 0;
    public long mNM = 0;
    public int mNO = 0;
    public int mNT = 0;
    public boolean nGp = false;
    public String ndI = "";
    public int netType = 0;
    public int rjH = 0;
    public int rjI = 0;
    public int rjJ = 0;
    public int rjK = 0;
    public long rjL = 0;
    public byte[] rjM = null;
    public byte[] rjN = null;
    public byte[] rjO = null;
    public int rjP = 0;
    public byte[] rjQ = null;
    public int rjR = 500;
    public int rjS = 30;
    public int rjT = 999;
    public int rjU = 0;
    public int rjV = 20;
    public int rjW = 0;
    public int rjX = 0;
    public int rjY = 0;
    public int rjZ = 0;
    public int rkA = 0;
    public int rkB = 0;
    public int rkC = 0;
    public int[] rkD = null;
    public int rkE = 0;
    public int rkF = 0;
    public int rkG = 0;
    public int rkH = 0;
    public byte[] rkI = null;
    public int rkJ = 0;
    public int rkK = 0;
    public int rkL = 0;
    public int rkM = 0;
    public byte[] rkN = new byte[1500];
    public int rkO = 0;
    public byte[] rkP = null;
    public byte[] rkQ = null;
    public int rkR = 0;
    public int rkS = 0;
    public int rkT = 0;
    public long rkU = 0;
    public byte[] rkV = new byte[8];
    public int rkW = 0;
    public int rkX = 0;
    public int rkY = 0;
    public int rkZ = 0;
    public int rka = 0;
    public int rkb = 65536;
    public int rkc = 0;
    public int rkd = 0;
    public int rke = 7;
    public int rkf = 3;
    public int rkg = 3;
    public int rkh = 0;
    public int rki = 0;
    public int rkj = -1;
    public int rkk = -1;
    public int rkl = 0;
    public int rkm = 0;
    public int rkn = 0;
    public int rko = 0;
    public int rkp = 100;
    public int rkq = e.CTRL_INDEX;
    public int rkr = 1;
    public int rks = 1;
    public int rkt = 0;
    public int rku = 1;
    public int rkv = 0;
    public int rkw = 0;
    public int rkx = 0;
    public int rky = 0;
    public int rkz = 0;
    public int rla = 0;
    byte[] rlb = new byte[Downloads.RECV_BUFFER_SIZE];
    byte[] rlc = new byte[2048];
    byte[] rld = new byte[2048];
    byte[] rle = new byte[Downloads.RECV_BUFFER_SIZE];
    byte[] rlf = new byte[Downloads.RECV_BUFFER_SIZE];
    byte[] rlg = new byte[2048];
    byte[] rlh = new byte[Downloads.RECV_BUFFER_SIZE];
    public byte[] rli = new byte[2048];
    public byte[] rlj = new byte[2048];
    public byte[] rlk = new byte[2048];
    public byte[] rll = new byte[2048];
    public int[] rlm = new int[30];
    int rln = 0;
    public h rlo = new h();

    private native int forceredirect(int i, int i2);

    private native int setsvraddr();

    private native int uninit();

    public native int SendDTMF(int i);

    public native int SendRUDP(byte[] bArr, int i);

    public native int SetDTMFPayload(int i);

    public native int StartSpeedTest(long j, int i);

    public native int StopSpeedTest();

    public native int app2EngineDataEx(int i, int i2, byte[] bArr, int i3, int i4);

    public native int app2EngineLinkQualityEx(int i, byte[] bArr);

    public native int doubleLinkSwitch(int i);

    public native int exchangeCabInfo(byte[] bArr, int i);

    public native int freeJNIReport();

    public native int getAVDuration(byte[] bArr, int i);

    public native int getChannelInfo(byte[] bArr, int i, int i2, int i3, int i4, int i5);

    public native int getChannelReport(byte[] bArr, int i);

    public native int getCurrentConnType();

    public native int getEngine2ndInfo(byte[] bArr, int i);

    public native int getEngine2ndInfoReport(byte[] bArr, int i);

    public native int getEngineQosInfo(byte[] bArr, int i);

    public native int getEngineVersionInfo(byte[] bArr, int i);

    public native int getNewEngineExtInfo(byte[] bArr, int i);

    public native int getNewEngineInfo(byte[] bArr, int i);

    public native int getNewEngineInfoReport(byte[] bArr, int i);

    public native int getPstnChannelInfo(byte[] bArr, int i, int i2, int i3);

    public native int getPstnEngineInfo(byte[] bArr, int i);

    public native int getStatInfo(byte[] bArr, int i, int[] iArr, int i2);

    public native int getVoipcsChannelInfo(byte[] bArr, int i, int i2);

    public native int getVoipcsEngineInfo(byte[] bArr, int i);

    public native int getcurstrategy();

    public native int handleCommand(byte[] bArr, int i);

    public native int init(int i, int i2, int i3, int i4, int i5, int i6, String str, int i7);

    public native int isDCReady();

    public native int isDCSameLan();

    public native int isRelayConnReady();

    public native int parseSyncKeyBuff(byte[] bArr, int i);

    public native int playCallback(byte[] bArr, int i);

    public native int recordCallback(byte[] bArr, int i, int i2);

    public native int setActive();

    public native int setAppCmd(int i, byte[] bArr, int i2);

    public native int setConfigConnect(int i, long j, int i2, long j2, byte[] bArr, int i3, int i4, int i5, int i6, int i7, byte[] bArr2, int i8, int i9, int i10, int i11, byte[] bArr3, int i12, int i13);

    public native int setInactive();

    public native int setJNIAppCmd(int i, byte[] bArr, int i2);

    public native int setNetSignalValue(int i, int i2);

    public native int setSvrConfig(int i, int i2, int i3, int i4, int i5, int i6, int i7);

    public native int startEngine();

    public native int videoDecode(int[] iArr);

    public native int videoEncodeToLocal(byte[] bArr, int i, int i2, int i3, int i4, int i5, int[] iArr);

    public native int videoEncodeToSend(byte[] bArr, int i, int i2, int i3, int i4);

    public native int videoRorate90D(byte[] bArr, int i, int i2, int i3, int i4, byte[] bArr2, int i5, int i6, int i7, int i8);

    static {
        int rl = l.rl();
        if ((rl & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
            d.u(ab.getContext(), "libvoipCodec_v7a.so");
        } else if ((rl & 512) != 0) {
            d.u(ab.getContext(), "libvoipCodec.so");
        } else {
            d.u(ab.getContext(), "libvoipCodec_v5.so");
        }
        k.b("voipMain", v2protocal.class.getClassLoader());
        rl = l.rl();
        qXE = rl;
        rl = (rl & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0 ? 16000 : 8000;
        nON = rl;
        rjF = ((rl / 1000) * 20) * 2;
    }

    public final int pQ(int i) {
        int appCmd = setAppCmd(i, new byte[]{(byte) 0}, 1);
        if (appCmd < 0) {
            a.dK("MicroMsg.Voip", "setAppCmd: type:" + appCmd + ":ret:" + appCmd);
        }
        return appCmd;
    }

    public static String bqG() {
        String str = Build.MANUFACTURER;
        if (str.contains(",")) {
            str = str.replace(',', ' ');
        }
        String str2 = Build.MODEL;
        if (str2.contains(",")) {
            str2 = str2.replace(',', ' ');
        }
        String str3 = VERSION.SDK;
        if (str3.contains(",")) {
            str3 = str3.replace(',', ' ');
        }
        String str4 = VERSION.RELEASE;
        if (str4.contains(",")) {
            str4 = str3.replace(',', ' ');
        }
        return "," + str + "," + str2 + "," + str3 + "," + str4;
    }

    public static long aL(byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.order(ByteOrder.nativeOrder());
        return wrap.getLong();
    }

    private String bqH() {
        return "," + this.channelStrategy;
    }

    public final String bqI() {
        if (this.field_videoDuration == 0) {
            a.dK("MicroMsg.Voip", "captureFrames:" + this.rkW + ", videoduration: 0");
            return ",0";
        }
        a.dK("MicroMsg.Voip", "capturefps:" + (this.rkW / this.field_videoDuration) + " framecount:" + this.rkW + " videoDuration:" + this.field_videoDuration);
        return "," + (this.rkW / this.field_videoDuration);
    }

    private String bqJ() {
        a.dK("MicroMsg.Voip", "usePreConnect:" + this.rkn);
        return "," + this.rkn;
    }

    private String bqK() {
        a.dK("MicroMsg.Voip", "preConnectSuccess:" + this.rko);
        return "," + this.rko;
    }

    public final String bqL() {
        if (VERSION.SDK_INT < 11) {
            this.rkf = 0;
            this.rkg = 2;
        } else {
            this.rkf = 3;
            this.rkg = 3;
        }
        if (p.gRd.gOm >= 0) {
            this.rkf = p.gRd.gOm;
        }
        if (VERSION.SDK_INT >= 11 && com.tencent.mm.compatible.util.l.qq() && 2 == p.gRl.gPX) {
            this.rkg = 2;
        }
        if (p.gRd.gOn >= 0) {
            this.rkg = p.gRd.gOn;
        }
        if (VERSION.SDK_INT < 11) {
            this.rke = 1;
        } else {
            this.rke = 7;
        }
        if (p.gRd.gNN) {
            this.rke = 1;
        }
        if (p.gRd.gOl >= 0) {
            this.rke = p.gRd.gOl;
        }
        if (p.gRd.gNO > 0) {
            this.rkh = 3;
            this.rki = 0;
        } else if (p.gRd.gOo >= 0) {
            this.rkh = p.gRd.gOo;
            this.rki = p.gRd.gOo;
        }
        if (p.gRd.gOp >= 0) {
            this.rkh = p.gRd.gOp;
        }
        if (p.gRd.gOq >= 0) {
            this.rki = p.gRd.gOq;
        }
        return "," + this.rkf + "," + this.rkg + "," + this.rke + "," + this.rkh + "," + this.rki;
    }

    public v2protocal(ae aeVar) {
        this.handler = aeVar;
    }

    public int keep_onNotifyFromJni(int i, int i2, byte[] bArr) {
        if (i == 100) {
            a.a(bArr, "MicroMsg.Voip", i2);
        } else if (i == 101) {
            a.a(bArr, "MicroMsg.v2Core", i2);
        } else {
            Message message = new Message();
            message.what = 59998;
            message.arg1 = i;
            message.arg2 = i2;
            message.obj = bArr;
            this.handler.sendMessage(message);
        }
        return 0;
    }

    public int keep_onNotifyFromJniInt(int i, int i2, int[] iArr) {
        if (iArr != null) {
            a.dK("MicroMsg.VoipService", "callByJni : arg1:" + i + " arg2:" + i2);
            Message message = new Message();
            message.what = 59998;
            message.arg1 = i;
            message.arg2 = i2;
            message.obj = iArr;
            this.handler.sendMessage(message);
        }
        return 0;
    }

    public final int a(bjy com_tencent_mm_protocal_c_bjy, bjy com_tencent_mm_protocal_c_bjy2, bjy com_tencent_mm_protocal_c_bjy3, int i, int i2) {
        if (com_tencent_mm_protocal_c_bjy == null || com_tencent_mm_protocal_c_bjy.ujy <= 0) {
            a.dK("MicroMsg.Voip", "forceRedirect: [TRANSPORT]No relay svr ip");
        } else {
            a.dK("MicroMsg.Voip", "forceRedirect: got relay svr addr from server");
            this.field_relaySvrArray = a.a(com_tencent_mm_protocal_c_bjy);
        }
        if (com_tencent_mm_protocal_c_bjy2 == null || com_tencent_mm_protocal_c_bjy2.ujy <= 0) {
            a.dK("MicroMsg.Voip", "forceRedirect: No punch svr ip");
        } else {
            a.dK("MicroMsg.Voip", "forceRedirect: got punch svr addr from server");
            this.field_punchSvrArray = a.a(com_tencent_mm_protocal_c_bjy2);
        }
        if (com_tencent_mm_protocal_c_bjy3 == null || com_tencent_mm_protocal_c_bjy3.ujy <= 0) {
            a.dK("MicroMsg.Voip", "forceRedirect: No relay tcp svr ip");
        } else {
            a.dK("MicroMsg.Voip", "forceRedirect: got relay tcp svr addr from server");
            this.field_relayTcpSvrArray = a.a(com_tencent_mm_protocal_c_bjy3);
        }
        int forceredirect = forceredirect(i, i2);
        a.dK("MicroMsg.Voip", "v2protocal forceRedirect ret :" + forceredirect);
        return forceredirect;
    }

    public final int b(bjy com_tencent_mm_protocal_c_bjy, bjy com_tencent_mm_protocal_c_bjy2, bjy com_tencent_mm_protocal_c_bjy3) {
        if (com_tencent_mm_protocal_c_bjy.ujy > 0) {
            a.dK("MicroMsg.Voip", "setSvrAddr: got relay svr addr from server");
            this.field_relaySvrArray = a.a(com_tencent_mm_protocal_c_bjy);
        } else {
            a.dK("MicroMsg.Voip", "setSvrAddr: [TRANSPORT]No relay svr ip");
        }
        if (com_tencent_mm_protocal_c_bjy2.ujy > 0) {
            a.dK("MicroMsg.Voip", "setSvrAddr: got punch svr addr from server");
            this.field_punchSvrArray = a.a(com_tencent_mm_protocal_c_bjy2);
        } else {
            a.dK("MicroMsg.Voip", "setSvrAddr: No punch svr ip");
        }
        if (com_tencent_mm_protocal_c_bjy3.ujy > 0) {
            a.dK("MicroMsg.Voip", "setSvrAddr:got tcpsvr addr from server");
            this.field_relayTcpSvrArray = a.a(com_tencent_mm_protocal_c_bjy3);
        } else {
            a.dK("MicroMsg.Voip", "setSvrAddr:no tcp svr addr ip");
        }
        int i = setsvraddr();
        a.dK("MicroMsg.Voip", "v2protocal setsvraddr ret :" + i);
        return i;
    }

    public final int bnu() {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        int i;
        int i2;
        this.netType = a.getNetType(ab.getContext());
        this.rjJ = this.netType;
        if (this.netType == 5) {
            this.netType = 4;
        }
        boolean z5 = this.rjJ >= 4 && (qXE & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0 && (qXE & 255) >= 26;
        if (!z5 || (qXE & 255) < 30) {
            z = false;
        } else {
            z = true;
        }
        if (p.gRc.gPz <= 0 || p.gRc.gPc.width < 480 || p.gRc.gPc.height < 360 || p.gRc.gPe.width < 480 || p.gRc.gPe.height < 360) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (p.gRc.gPz < 2 || p.gRc.gPc.width < 640 || p.gRc.gPc.height < 480 || p.gRc.gPe.width < 640 || p.gRc.gPe.height < 480) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (p.gRc.gPz == 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        b bVar = p.gRc;
        if ((z5 || z2) && !z4) {
            if (z3) {
                this.defaultWidth = 640;
                this.defaultHeight = 480;
            } else {
                this.defaultWidth = 480;
                this.defaultHeight = 360;
            }
            rjG = true;
            a.dJ("MicroMsg.Voip", "steve:Set Enable 480! " + this.defaultWidth + "x" + this.defaultHeight);
        }
        a.dJ("MicroMsg.Voip", "steve: Android CPUFlag:" + (qXE & 255) + ", 480x360 Enc flags: bEnable480FromLocal:" + z5 + ", bEnable480FromSvr:" + z2 + ", bDisable480FromSvr:" + z4 + ", bEnable640FromLocal:" + z + ", bEnable640FromSvr:" + z3);
        this.rkD = new int[(this.defaultWidth * this.defaultHeight)];
        ap.yY();
        this.rjI = c.uH();
        if ((qXE & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
            d.u(ab.getContext(), "libvoipCodec_v7a.so");
            a.dK("MicroMsg.Voip", "dlopen /data/data/com.tencent.mm/lib/libvoipCodec_v7a.so... ");
        } else if ((qXE & 512) != 0) {
            d.u(ab.getContext(), "libvoipCodec.so");
            a.dK("MicroMsg.Voip", "dlopen /data/data/com.tencent.mm/lib/libvoipCodec.so... ");
        } else {
            d.u(ab.getContext(), "libvoipCodec_v5.so");
            a.dK("MicroMsg.Voip", "dlopen /data/data/com.tencent.mm/lib/libvoipCodec_v5.so... ");
        }
        int i3 = VERSION.SDK_INT;
        int brx = OpenGlRender.brx();
        Display defaultDisplay = ((WindowManager) ab.getContext().getSystemService("window")).getDefaultDisplay();
        int width = defaultDisplay.getWidth();
        int height = defaultDisplay.getHeight();
        if ((p.gRc.gPA & 16) != 0) {
            z = true;
        } else {
            z = false;
        }
        if ((p.gRc.gPA & 32) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if ((p.gRc.gPA & 15) != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            i = 1;
        } else {
            i = 0;
        }
        if (z) {
            i2 = i | 2;
        } else {
            i2 = i;
        }
        if (z2) {
            i2 |= 4;
        }
        i2 = init(this.netType | (i2 << 8), 2, this.defaultHeight | (this.defaultWidth << 16), (width << 16) | height, this.rjI, qXE | ((brx << 24) | (i3 << 16)), com.tencent.mm.compatible.util.e.hgp + "app_lib/", 0);
        a.dK("MicroMsg.Voip", "protocal init ret :" + i2 + ",uin= " + this.rjI + ", gl_vs:" + brx + ", cpuFlag0=" + qXE);
        this.nGp = true;
        if (i2 < 0) {
            reset();
        }
        return i2;
    }

    public final String ij(boolean z) {
        if (this.nGp) {
            a.dK("MicroMsg.Voip", "call protocalUninit now...needStatInfo=" + z);
            this.field_ChannelReportDial = new int[6];
            this.field_ChannelReportDial[0] = this.rlo.rgN;
            this.field_ChannelReportDial[1] = this.rlo.rgT;
            this.field_ChannelReportDial[2] = this.rkE;
            this.field_ChannelReportDial[3] = this.rkF;
            this.field_ChannelReportDial[4] = this.rkG;
            this.field_ChannelReportDial[5] = this.rkH;
            this.field_EngineAudioReportStat = new int[8];
            bqL();
            this.field_EngineAudioReportStat[0] = this.rjZ;
            this.field_EngineAudioReportStat[1] = this.rka;
            this.field_EngineAudioReportStat[2] = this.rkf;
            this.field_EngineAudioReportStat[3] = this.rkg;
            this.field_EngineAudioReportStat[4] = this.rke;
            this.field_EngineAudioReportStat[5] = this.rkh;
            this.field_EngineAudioReportStat[6] = this.rki;
            this.field_EngineAudioReportStat[7] = -1;
            this.nGp = false;
            uninit();
            rjG = false;
            a.dK("MicroMsg.Voip", "uninit over.");
            if (z) {
                getStatInfo(this.rlb, this.rlb.length, this.rlm, 30);
                getEngineVersionInfo(this.rlc, this.rlc.length);
                getEngineQosInfo(this.rld, this.rld.length);
                StringBuilder stringBuilder = new StringBuilder();
                long j = (long) this.rjI;
                if (this.rjI < 0) {
                    j = ((long) this.rjI) + 4294967296L;
                }
                StringBuilder append = new StringBuilder().append(j).append(",").append(this.mNM).append(",").append(this.mNL).append(",").append(this.mNT).append(",");
                h hVar = this.rlo;
                String stringBuilder2 = append.append(hVar.rgD + "," + hVar.rgE + "," + hVar.rgF + "," + hVar.rgG + "," + hVar.rgH + "," + hVar.rgI + "," + hVar.rgJ + "," + hVar.rgK + "," + hVar.rgL + "," + hVar.rgM + "," + hVar.rgN).toString();
                a.dJ("MicroMsg.Voip", "voipreport:DailStatString:" + stringBuilder2);
                append = stringBuilder.append(stringBuilder2).append(new String(this.rlb, 0, this.field_statInfoLength)).append(bqG()).append(bqH()).append("," + this.rlo.rgO).append(new String(this.rlc, 0, this.field_engineVersionStatLength)).append(bqI());
                a.dK("MicroMsg.Voip", "cpuCapacity:" + qXE);
                stringBuilder2 = append.append("," + qXE).append(bqJ()).append(bqK()).append(new String(this.rld, 0, this.field_engineQosStatLength)).toString();
                a.dJ("MicroMsg.Voip", "statInfoBuffer = " + new String(this.rlb, 0, this.field_statInfoLength));
                a.dJ("MicroMsg.Voip", "engineVersionInfoBuffer = " + new String(this.rlc, 0, this.field_engineVersionStatLength));
                a.dJ("MicroMsg.Voip", "engineQosInfoBuffer = " + new String(this.rld, 0, this.field_engineQosStatLength));
                a.dJ("MicroMsg.Voip", "voipreport:StatString = " + stringBuilder2);
                ag.a.hlT.aH(this.field_netFlowRecv, this.field_netFlowSent);
                a.dK("MicroMsg.Voip", "voip net flow = " + (this.field_netFlowSent + this.field_netFlowRecv));
                return stringBuilder2;
            }
        }
        return "";
    }

    public static String bqM() {
        return "\u0000";
    }

    public final String bqN() {
        long j = 0;
        if (this.rjX == 0 && this.rjY == 0) {
            this.rlo.rgU = 0;
        } else if (this.rjY != 0 && this.rjX != 0) {
            this.rlo.rgU = 3;
        } else if (this.rjY != 0) {
            this.rlo.rgU = 1;
        } else if (this.rjX != 0) {
            this.rlo.rgU = 2;
        }
        this.rlo.rhc = a.getNetType(ab.getContext());
        this.rlo.rhb = this.field_videoDuration;
        this.rlo.rha = this.field_audioDuration;
        this.rkc = ap.yZ().qT();
        long j2 = (this.rlo.rhk <= 0 || this.rlo.rhe <= this.rlo.rhk) ? 0 : this.rlo.rhe - this.rlo.rhk;
        a.dK("MicroMsg.Voip", "voipreport:acceptcalltime:" + j2);
        setJNIAppCmd(1, this.rkV, this.rkV.length);
        long aL = aL(this.rkV);
        h hVar = this.rlo;
        long j3 = (aL <= this.rlo.rhi || this.rlo.rhi <= 0) ? 0 : aL - this.rlo.rhi;
        hVar.rhl = j3;
        h hVar2 = this.rlo;
        if (aL > this.rlo.rhk && this.rlo.rhk > 0) {
            j = aL - this.rlo.rhk;
        }
        hVar2.rhm = j;
        a.dK("MicroMsg.Voip", "voipreport:lCallerWaitTime:" + this.rlo.rhl + " lCalledWaitTime:" + this.rlo.rhm);
        StringBuilder append = new StringBuilder().append(this.rjW).append(",").append(this.mNL).append(",").append(this.mNM).append(",").append(this.mNT).append(",").append(this.rlo.rgD).append(",").append(this.rlo.rgP).append(",").append(this.rlo.rgQ).append(",").append(this.rlo.rgR).append(",").append(this.rlo.rgS).append(",").append(this.rlo.rgT).append(",").append(this.rlo.rgU).append(",").append(this.rlo.rgN).append(",").append(this.rlo.rgV).append(",").append(this.rlo.rgW).append(",").append(this.rlo.rgX).append(",").append(this.rlo.rgY).append(",").append(this.rlo.rgZ).append(",").append(this.rlo.rha).append(",").append(this.rlo.rhb).append(",").append(this.rlo.rhc).append(bqJ()).append(bqK()).append(bqG()).append(",").append(this.rlo.rhd).append(",").append(this.rkb).append(",").append(this.rkc).append(",").append(j2).append(",").append(this.rlo.rhl).append(",").append(this.rlo.rhm).append(",").append(this.rkd).append(",").append(this.rjJ).append(bqH()).append(",").append(qXE & 255).append(",").append(this.rkj).append(",").append(this.rkk);
        String str = VERSION.INCREMENTAL;
        if (str.contains(",")) {
            str = str.replace(',', ' ');
        }
        String str2 = Build.DISPLAY;
        if (str2.contains(",")) {
            str2 = str2.replace(',', ' ');
        }
        str = append.append("," + str + "," + str2).append(",").append(this.rlo.rhf).append(",").append(this.rlo.rhh).append(",").append(this.rlo.rhg).toString();
        a.dJ("MicroMsg.Voip", "voipreport:initNetType:" + this.rjJ);
        a.dJ("MicroMsg.Voip", "voipreport:NewDialStatString:" + str);
        a.dJ("MicroMsg.Voip", "voipreport:getChannelStrategyString:" + bqH());
        return str;
    }

    public final String bqO() {
        getChannelInfo(this.rle, this.rle.length, this.rkE, this.rkF, this.rkG, this.rkH);
        a.dJ("MicroMsg.Voip", "voipreport:oldChannelString: " + (this.mNM + "," + this.mNL + "," + this.mNT + this.rlo.bpz() + ("," + this.rlo.rgT) + new String(this.rle, 0, this.field_channelStatLength)));
        getChannelReport(this.rle, this.rle.length);
        String str = new String(this.rle, 0, this.field_channelReportLength);
        a.dJ("MicroMsg.Voip", "voipreport:newChannelString: " + str);
        return str;
    }

    public final String bqP() {
        getNewEngineInfo(this.rlf, this.rlf.length);
        getNewEngineExtInfo(this.rlg, this.rlg.length);
        a.dJ("MicroMsg.Voip", "voipreport:oldNewEngineString:" + (this.mNT + "," + this.mNM + this.rlo.bpz() + "," + this.rjX + "," + this.rjY + bqI() + new String(this.rlf, 0, this.field_newEngineStatLength) + "," + this.rjZ + "," + this.rka + bqL() + new String(this.rlg, 0, this.field_newEngineExtStatLength)));
        getNewEngineInfoReport(this.rlf, this.rlf.length);
        String str = this.mNT + "," + this.mNM + this.rlo.bpz() + "," + this.rjX + "," + this.rjY + bqI() + new String(this.rlf, 0, this.field_newEngineReportLength);
        a.dJ("MicroMsg.Voip", "voipreport:yaoyaoguoNewEngineString:" + str);
        return str;
    }

    public final String bqQ() {
        getEngine2ndInfo(this.rlh, this.rlh.length);
        a.dJ("MicroMsg.Voip", "voipreport:12805,oldEngine2ndString:" + (this.mNM + "," + this.mNL + "," + this.mNT + new String(this.rlh, 0, this.field_engine2ndStatLength)));
        getEngine2ndInfoReport(this.rlh, this.rlh.length);
        String str = this.mNM + "," + this.mNL + "," + this.mNT + new String(this.rlh, 0, this.field_engine2ndReportLength);
        a.dJ("MicroMsg.Voip", "voipreport:12805,newEngine2ndString:" + str);
        return str;
    }

    public final void reset() {
        a.dJ("MicroMsg.Voip", "v2protocal reset!");
        this.field_punchSvrArray = null;
        this.field_relaySvrArray = null;
        this.field_relayTcpSvrArray = null;
        this.field_peerId = null;
        this.field_capInfo = null;
        this.mNL = 0;
        this.rjL = 0;
        this.rjK = 0;
        this.mNT = 0;
        this.mNM = 0;
        this.channelStrategy = 0;
        this.mNO = 0;
        this.hFg = 0;
        this.rjM = null;
        this.rjN = null;
        this.rjO = null;
        this.rjP = 0;
        this.rjQ = null;
        this.rkH = 0;
        this.rkI = null;
        this.rkJ = 0;
        this.rkK = 0;
        this.rkP = null;
        this.rkQ = null;
        this.rkW = 0;
        this.rkX = 0;
        this.rkY = 0;
        this.rkZ = 0;
        this.rla = 0;
        this.field_videoDuration = 0;
        this.field_audioDuration = 0;
        this.rln = 0;
        this.rko = 0;
        this.rkn = 0;
        this.field_engineVersionStatLength = 0;
        this.field_engineQosStatLength = 0;
        this.field_statusSyncKey = 0;
        this.field_relayDataSyncKey = 0;
        this.field_connectingStatusKey = 0;
        this.rjZ = 0;
        this.rka = 0;
        this.rkb = 65536;
        this.rkc = 0;
        this.rkd = 0;
        this.rkk = -1;
        this.rkl = 0;
        this.rkT = 0;
        this.rjH = 0;
        this.ndI = "";
        this.rkR = 0;
        this.rkS = 0;
        this.rlo.reset();
        this.rlo.bpy();
        rjG = false;
        a.dK("MicroMsg.Voip", "freeJNIReport : " + freeJNIReport() + ". [0: null, no need to free, 1: free success!]");
    }
}
