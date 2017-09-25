package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.b.f;
import com.tencent.mm.e.a.ls;
import com.tencent.mm.e.a.nw;
import com.tencent.mm.e.a.ny;
import com.tencent.mm.kernel.h;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiStartRecordVoice;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.t.n;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import java.util.Map;
import junit.framework.Assert;

public final class au extends n {
    public static String uJQ = "voip_content_voice";
    public static String uJR = "voip_content_video";
    public boolean uJS = false;
    private String uJT;

    public static final class a {
        private String aJE = "";
        public String fFa = "";
        private String gkB;
        private String gkC;
        public String gkG = "";
        private String gkH = "";
        public int gkr;
        public String gtR = "";
        public String hCe = "";
        public String hCf = "";
        public String hCg = "";
        public String hCj = "";
        public String osT = "";
        public long ovb = 0;
        public String ovd = "";
        public String rUK = "";
        public int rWg = 0;
        public int scene = 0;
        public String signature;
        public int uJW = 0;
        public String uJX = "";
        public String uJY = "";
        public String uJZ = "";
        public String uKa = "";
        public String uKb = "";

        private a() {
        }

        public static a RF(String str) {
            a aVar = new a();
            String trim = bg.ap(str, "").trim();
            if (!trim.startsWith("<")) {
                int indexOf = trim.indexOf(":");
                if (indexOf != -1) {
                    trim = trim.substring(indexOf + 1);
                }
            }
            Map q = bh.q(trim, "msg");
            if (q != null) {
                try {
                    if (q.get(".msg.$fromusername") == null) {
                        aVar.rUK = (String) q.get(".msg.$username");
                    } else {
                        aVar.rUK = (String) q.get(".msg.$fromusername");
                    }
                    if (q.get(".msg.$fromnickname") == null) {
                        aVar.fFa = (String) q.get(".msg.$nickname");
                    } else {
                        aVar.fFa = (String) q.get(".msg.$fromnickname");
                    }
                    aVar.gtR = (String) q.get(".msg.$alias");
                    aVar.hCf = (String) q.get(".msg.$fullpy");
                    aVar.hCe = (String) q.get(".msg.$shortpy");
                    aVar.aJE = (String) q.get(".msg.$source");
                    aVar.uJW = Integer.valueOf((String) q.get(".msg.$imagestatus")).intValue();
                    aVar.scene = Integer.valueOf((String) q.get(".msg.$scene")).intValue();
                    aVar.uJX = (String) q.get(".msg.$mobileidentify");
                    aVar.uJY = (String) q.get(".msg.$mobilelongidentify");
                    if (q.get(".msg.$qqnum") != null && ((String) q.get(".msg.$qqnum")).length() > 0) {
                        aVar.ovb = Long.valueOf((String) q.get(".msg.$qqnum")).longValue();
                    }
                    aVar.signature = (String) q.get(".msg.$sign");
                    if (q.get(".msg.$sex") != null && ((String) q.get(".msg.$sex")).length() > 0) {
                        aVar.gkr = Integer.valueOf((String) q.get(".msg.$sex")).intValue();
                    }
                    aVar.gkC = (String) q.get(".msg.$city");
                    aVar.gkB = (String) q.get(".msg.$province");
                    aVar.hCg = (String) q.get(".msg.$qqnickname");
                    aVar.hCj = (String) q.get(".msg.$qqremark");
                    aVar.rWg = Integer.valueOf(TextUtils.isEmpty((CharSequence) q.get(".msg.$certflag")) ? "0" : (String) q.get(".msg.$certflag")).intValue();
                    aVar.gkG = bg.mz((String) q.get(".msg.$certinfo"));
                    aVar.osT = bg.mz((String) q.get(".msg.$brandIconUrl"));
                    aVar.gkH = bg.mz((String) q.get(".msg.$regionCode"));
                    aVar.uJZ = bg.mz((String) q.get(".msg.$bigheadimgurl"));
                    aVar.uKa = bg.mz((String) q.get(".msg.$smallheadimgurl"));
                    aVar.ovd = bg.mz((String) q.get(".msg.$googlecontact"));
                    aVar.uKb = bg.mz((String) q.get(".msg.$antispamticket"));
                    w.i("MicroMsg.MsgInfo", "dkverify FriendContent user:[%s] ticket:[%s] big:[%s] sm:[%s]", aVar.rUK, aVar.uKb, aVar.uJZ, aVar.uKa);
                } catch (Throwable e) {
                    w.e("MicroMsg.MsgInfo", "exception:%s", bg.g(e));
                }
            }
            return aVar;
        }

        public final String bME() {
            return this.rUK;
        }

        public final String getDisplayName() {
            if (!TextUtils.isEmpty(this.fFa)) {
                return this.fFa;
            }
            if (!TextUtils.isEmpty(this.gtR)) {
                return this.gtR;
            }
            w.f("MicroMsg.MsgInfo", "username is nullOrNil");
            return bg.mz(this.rUK);
        }

        public final int bzE() {
            return this.scene;
        }

        public final String bMF() {
            return this.uJX;
        }

        public final long bMG() {
            return this.ovb;
        }

        public final String bMH() {
            if (this.hCj != null && this.hCj.length() > 0) {
                return this.hCj;
            }
            if (this.hCg == null || this.hCg.length() <= 0) {
                return Long.toString(this.ovb);
            }
            return this.hCg;
        }

        public final String bMI() {
            return this.uJY;
        }

        public final String getCity() {
            if (!bg.mA(this.gkH)) {
                String[] split = this.gkH.split("_");
                if (split.length > 0) {
                    if (split.length > 2) {
                        this.gkC = RegionCodeDecoder.bMP().ac(split[0], split[1], split[2]);
                    } else if (split.length == 2) {
                        this.gkC = RegionCodeDecoder.bMP().eL(split[0], split[1]);
                    } else {
                        this.gkC = "";
                    }
                }
            }
            return this.gkC;
        }

        public final String getProvince() {
            if (!bg.mA(this.gkH)) {
                String[] split = this.gkH.split("_");
                if (split.length > 0) {
                    if (split.length <= 2 || !RegionCodeDecoder.RR(split[0])) {
                        this.gkB = RegionCodeDecoder.bMP().RS(split[0]);
                    } else {
                        this.gkB = RegionCodeDecoder.bMP().eL(split[0], split[1]);
                    }
                }
            }
            return this.gkB;
        }

        public final int bMJ() {
            return this.rWg;
        }
    }

    public static final class b {
        public int fOd = 0;
        public String label = "";
        public double naO = 0.0d;
        public double naP = 0.0d;
        public String ndv = "";
        public String rUK = "";
        public String sBQ = "";
        public String uKc = "";
        public String uKd = null;
        public String uKe = null;
        public String uKf = null;

        public final String toString() {
            return String.format("%d-%d-%d", new Object[]{Integer.valueOf((int) (this.naO * 1000000.0d)), Integer.valueOf((int) (this.naP * 1000000.0d)), Integer.valueOf(this.fOd)});
        }

        public static b RG(String str) {
            b bVar = new b();
            Map q = bh.q(str, "msg");
            if (q != null) {
                bVar.rUK = bg.ap((String) q.get(".msg.location.$fromusername"), "");
                bVar.naO = bg.Qa((String) q.get(".msg.location.$x"));
                bVar.naP = bg.Qa((String) q.get(".msg.location.$y"));
                bVar.label = bg.ap((String) q.get(".msg.location.$label"), "");
                bVar.uKc = bg.ap((String) q.get(".msg.location.$maptype"), "");
                bVar.fOd = bg.PY((String) q.get(".msg.location.$scale"));
                bVar.uKf = bg.ap((String) q.get(".msg.location.$localLocationen"), "");
                bVar.uKd = bg.ap((String) q.get(".msg.location.$localLocationcn"), "");
                bVar.uKe = bg.ap((String) q.get(".msg.location.$localLocationtw"), "");
                bVar.ndv = bg.ap((String) q.get(".msg.location.$poiname"), "");
                bVar.sBQ = bg.ap((String) q.get(".msg.location.$infourl"), "");
            }
            return bVar;
        }
    }

    public static final class c {
        public String content = "";
        public String hRP = "";
        public boolean lJB = false;
        public String ozl;
        public String title = "";
        public String uKg = "";

        private c() {
        }

        public static c RH(String str) {
            c cVar = new c();
            Map q = bh.q(str, "msg");
            if (q != null) {
                try {
                    cVar.title = (String) q.get(".msg.pushmail.content.subject");
                    cVar.content = (String) q.get(".msg.pushmail.content.digest");
                    cVar.hRP = (String) q.get(".msg.pushmail.content.sender");
                    cVar.uKg = (String) q.get(".msg.pushmail.waplink");
                    cVar.lJB = bg.mz((String) q.get(".msg.pushmail.content.attach")).equalsIgnoreCase("true");
                    cVar.ozl = (String) q.get(".msg.pushmail.mailid");
                } catch (Throwable e) {
                    w.e("MicroMsg.MsgInfo", "exception:%s", bg.g(e));
                }
            }
            return cVar;
        }

        public final String bMK() {
            return this.uKg;
        }
    }

    public static final class d {
        public String chatroomName = "";
        public String content = "";
        private String countryCode;
        public String fFa = "";
        public int fJK;
        public int gkr;
        public String gtR = "";
        public String hCe = "";
        public String hCf = "";
        public String hCg = "";
        private String hCj = "";
        private String hnO;
        private String hnP;
        public String osP;
        public long ovb = 0;
        public String ovd;
        public String rUK = "";
        public String sLS;
        public String sLT;
        public int scene = 0;
        public String signature;
        public int uJW = 0;
        public String uJX = "";
        public String uJY = "";
        public String uJZ = "";
        public String uKa = "";
        public int uKh = 0;
        public String uKi;
        public String uKj;
        public int uKk;
        public String uKl;
        public String uKm;

        private d() {
        }

        public static d RI(String str) {
            d dVar = new d();
            Map q = bh.q(str, "msg");
            if (q != null) {
                try {
                    dVar.rUK = (String) q.get(".msg.$fromusername");
                    dVar.gtR = (String) q.get(".msg.$alias");
                    dVar.fFa = (String) q.get(".msg.$fromnickname");
                    dVar.hCf = (String) q.get(".msg.$fullpy");
                    dVar.hCe = (String) q.get(".msg.$shortpy");
                    dVar.content = (String) q.get(".msg.$content");
                    dVar.uJW = Integer.valueOf((String) q.get(".msg.$imagestatus")).intValue();
                    dVar.scene = Integer.valueOf((String) q.get(".msg.$scene")).intValue();
                    dVar.uJX = (String) q.get(".msg.$mhash");
                    dVar.uJY = (String) q.get(".msg.$mfullhash");
                    if (q.get(q.get(".msg.$qqnum")) != null && ((String) q.get(q.get(".msg.$qqnum"))).length() > 0) {
                        dVar.ovb = Long.valueOf((String) q.get(".msg.$qqnum")).longValue();
                    }
                    dVar.hCg = (String) q.get(".msg.$qqnickname");
                    dVar.hCj = (String) q.get(".msg.$qqremark");
                    dVar.signature = (String) q.get(".msg.$sign");
                    if (q.get(".msg.$sex") != null && ((String) q.get(".msg.$sex")).length() > 0) {
                        dVar.gkr = Integer.valueOf((String) q.get(".msg.$sex")).intValue();
                    }
                    dVar.hnO = (String) q.get(".msg.$city");
                    dVar.hnP = (String) q.get(".msg.$province");
                    dVar.countryCode = (String) q.get(".msg.$country");
                    if (q.get(".msg.$snsflag") != null) {
                        dVar.uKh = Integer.valueOf((String) q.get(".msg.$snsflag")).intValue();
                        dVar.uKi = (String) q.get(".msg.$snsbgimgid");
                    }
                    dVar.osP = (String) q.get(".msg.$ticket");
                    w.d("MicroMsg.MsgInfo", "dkverify ticket:%s", dVar.osP);
                    dVar.uJZ = bg.mz((String) q.get(".msg.$bigheadimgurl"));
                    dVar.uKa = bg.mz((String) q.get(".msg.$smallheadimgurl"));
                    dVar.fJK = Integer.valueOf(bg.ap((String) q.get(".msg.$opcode"), "0")).intValue();
                    dVar.uKj = bg.mz((String) q.get(".msg.$encryptusername"));
                    dVar.ovd = bg.mz((String) q.get(".msg.$googlecontact"));
                    w.d("MicroMsg.MsgInfo", "dkavatar VerifyContent user:[%s] big:[%s] sm:[%s]", dVar.rUK, dVar.uJZ, dVar.uKa);
                    dVar.chatroomName = bg.mz((String) q.get(".msg.$chatroomusername"));
                    dVar.sLS = (String) q.get(".msg.$sourceusername");
                    dVar.sLT = (String) q.get(".msg.$sourcenickname");
                    dVar.uKk = bg.getInt((String) q.get(".msg.Antispam.$isSuspiciousUser"), 0);
                    if (dVar.uKk == 1) {
                        dVar.uKl = (String) q.get(".msg.Antispam.safetyWarning");
                        dVar.uKm = (String) q.get(".msg.Antispam.safetyWarningDetail");
                    }
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.MsgInfo", e, "", new Object[0]);
                }
            }
            return dVar;
        }

        public final String bME() {
            return this.rUK;
        }

        public final String getDisplayName() {
            if (this.fFa != null && this.fFa.length() > 0) {
                return this.fFa;
            }
            w.f("MicroMsg.MsgInfo", "username is nullOrNil");
            return this.rUK;
        }

        public final int bzE() {
            return this.scene;
        }

        public final String bMF() {
            return this.uJX;
        }

        public final String getCity() {
            if (bg.mA(this.countryCode) || bg.mA(this.hnP)) {
                return this.hnO;
            }
            if (bg.mA(this.hnO)) {
                return RegionCodeDecoder.bMP().eL(this.countryCode, this.hnP);
            }
            return RegionCodeDecoder.bMP().ac(this.countryCode, this.hnP, this.hnO);
        }

        public final String getProvince() {
            if (bg.mA(this.countryCode)) {
                return this.hnP;
            }
            if (bg.mA(this.hnP) || bg.mA(this.hnO) || !RegionCodeDecoder.RR(this.countryCode)) {
                return RegionCodeDecoder.bMP().RS(this.countryCode);
            }
            return RegionCodeDecoder.bMP().eL(this.countryCode, this.hnP);
        }

        public final int bML() {
            return this.uKh;
        }

        public final String bMM() {
            return this.uKi;
        }
    }

    public au(String str) {
        super.cH(str);
    }

    public final boolean axO() {
        return (this.field_type & 65535) == 49;
    }

    public final boolean bLX() {
        return this.field_type == 285212721;
    }

    public final boolean bLY() {
        return this.field_type == 486539313;
    }

    public final boolean bLZ() {
        return this.field_type == 34;
    }

    public final boolean bMa() {
        return this.field_type == 436207665;
    }

    public final boolean bMb() {
        return this.field_type == 469762097;
    }

    public final boolean bMc() {
        return this.field_type == 301989937;
    }

    public final boolean bMd() {
        return this.field_type == 50 || this.field_type == 53;
    }

    public final boolean bMe() {
        return this.field_type == 52;
    }

    public final boolean bMf() {
        return this.field_type == 318767153;
    }

    public final boolean bMg() {
        return this.field_type == CdnLogic.MediaType_FAVORITE_VIDEO;
    }

    public final boolean bMh() {
        switch (this.field_type) {
            case 3:
            case 13:
            case 23:
            case 33:
            case 39:
                return true;
            default:
                return false;
        }
    }

    public final boolean bMi() {
        return this.field_type == 42;
    }

    public final boolean bMj() {
        return this.field_type == 48;
    }

    public final boolean bMk() {
        switch (this.field_type) {
            case 1:
            case 11:
            case 21:
            case JsApiStartRecordVoice.CTRL_INDEX /*31*/:
            case 36:
                return true;
            default:
                return false;
        }
    }

    public final boolean isSystem() {
        return this.field_type == 10000;
    }

    public final boolean bMl() {
        return this.field_type == 43;
    }

    public final boolean bMm() {
        return this.field_type == 62;
    }

    public final boolean bMn() {
        return this.field_type == 47;
    }

    public final boolean bMo() {
        return this.field_type == 1048625;
    }

    public final boolean bMp() {
        return this.field_type == 268435505;
    }

    public final boolean bMq() {
        return this.field_type == -1879048191;
    }

    public final boolean bMr() {
        switch (this.field_type) {
            case PlayerException.EXCEPTION_TYPE_UNKNOWFORMAT /*55*/:
            case com.tencent.mm.plugin.appbrand.jsapi.g.b.CTRL_INDEX /*57*/:
                return true;
            default:
                return false;
        }
    }

    public final boolean bMs() {
        Object obj;
        String value = ((com.tencent.mm.plugin.zero.b.a) h.h(com.tencent.mm.plugin.zero.b.a.class)).sV().getValue("TranslateMsgOff");
        if (bg.mA(value) || bg.PY(value) == 0) {
            int i = 1;
        } else {
            w.d("MicroMsg.MsgInfo", "isTranslateFeatureOn false");
            obj = null;
        }
        return (obj == null || bg.mA(this.field_transContent)) ? false : true;
    }

    public static au Y(au auVar) {
        if (auVar == null) {
            w.d("MicroMsg.MsgInfo", "convertFrom msg is null ");
            return null;
        }
        au auVar2 = new au();
        auVar2.x(auVar.field_msgId);
        auVar2.y(auVar.field_msgSvrId);
        auVar2.setType(auVar.field_type);
        auVar2.dv(auVar.field_status);
        auVar2.dw(auVar.field_isSend);
        auVar2.field_isShowTimer = auVar.field_isShowTimer;
        auVar2.gxm = true;
        auVar2.z(auVar.field_createTime);
        auVar2.cH(auVar.field_talker);
        auVar2.setContent(auVar.field_content);
        auVar2.cI(auVar.field_imgPath);
        auVar2.cJ(auVar.field_reserved);
        auVar2.field_lvbuffer = auVar.field_lvbuffer;
        auVar2.gtA = true;
        auVar2.cK(auVar.field_transContent);
        auVar2.cM(auVar.gxD);
        auVar2.dG(auVar.gxE);
        auVar2.cN(auVar.gxF);
        return auVar2;
    }

    public final void dv(int i) {
        com.tencent.mm.sdk.b.b nwVar;
        super.dv(i);
        if (this.field_isSend == 1) {
            int i2 = (bMk() || bMj() || bMi()) ? 0 : 1;
            if (i2 != 0) {
                if (this.field_status == 5) {
                    w.e("MicroMsg.MsgInfo", "set msg status fail, msgId:%d, type:%d, userName:%s %s", Long.valueOf(this.field_msgId), Integer.valueOf(this.field_type), this.field_talker, bg.bJZ());
                    nwVar = new nw();
                    nwVar.fVc.fCZ = this;
                    com.tencent.mm.sdk.b.a.urY.m(nwVar);
                    return;
                } else if (this.field_status == 2) {
                    w.d("MicroMsg.MsgInfo", "successfully send msgId:%d, type:%d", Long.valueOf(this.field_msgId), Integer.valueOf(this.field_type));
                    nwVar = new ny();
                    nwVar.fVe.fCZ = this;
                    com.tencent.mm.sdk.b.a.urY.m(nwVar);
                    return;
                } else {
                    return;
                }
            }
        }
        if (this.field_isSend == 0) {
            nwVar = new ls();
            nwVar.fSR.fCZ = this;
            com.tencent.mm.sdk.b.a.urY.m(nwVar);
        }
    }

    public final boolean bMt() {
        return (this.gxI & 1) > 0;
    }

    public final void bMu() {
        if (bMv()) {
            dG(this.gxE & -33);
        }
    }

    public final boolean bMv() {
        return (this.gxE & 32) > 0;
    }

    public final boolean bMw() {
        return bMs() && (this.gxE & 16) > 0;
    }

    public final void bMx() {
        if (bMs()) {
            dG(this.gxE | 16);
        }
    }

    public final void bMy() {
        dG(this.gxE | 768);
    }

    public final boolean bMz() {
        return ((this.gxE & 768) == 0 && (this.gxE & 768) == 0) ? false : true;
    }

    public final void yF(int i) {
        switch (i) {
            case 0:
            case 1:
                dG(this.gxE | i);
                return;
            default:
                w.w("MicroMsg.MsgInfo", "Illgeal forwardflag !!!");
                return;
        }
    }

    public final boolean bMA() {
        return (this.gxE & 64) != 0;
    }

    public final boolean RE(String str) {
        if (!(bg.mA(this.gxF) || bg.mA(str))) {
            Map q = bh.q(this.gxF, "msgsource");
            if (q == null) {
                return false;
            }
            String str2 = (String) q.get(".msgsource.atuserlist");
            if (!bg.mA(str2)) {
                for (String trim : str2.split(",")) {
                    if (trim.trim().equals(str)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final boolean bMB() {
        boolean z;
        if (bg.mA(this.gxF) || !(this.gxF.contains("announcement@all") || this.gxF.contains("notify@all"))) {
            z = false;
        } else {
            z = true;
        }
        w.d("MicroMsg.MsgInfo", "isAtAll isAtAll:%s", Boolean.valueOf(z));
        return z;
    }

    public static boolean af(Map<String, String> map) {
        boolean z;
        if (map != null && map.containsKey(".sysmsg.$type") && ((String) map.get(".sysmsg.$type")).equalsIgnoreCase("NewXmlChatRoomAccessVerifyApplication")) {
            z = true;
        } else {
            z = false;
        }
        w.d("MicroMsg.MsgInfo", "isAddChatroomInviteMsg:%s", Boolean.valueOf(z));
        return z;
    }

    public static boolean ag(Map<String, String> map) {
        boolean z;
        if (map != null && map.containsKey(".sysmsg.$type") && ((String) map.get(".sysmsg.$type")).equalsIgnoreCase("NewXmlChatRoomAccessVerifyApproval")) {
            z = true;
        } else {
            z = false;
        }
        w.d("MicroMsg.MsgInfo", "isAddChatroomInviteAcceptMsg:%s", Boolean.valueOf(z));
        return z;
    }

    public final void b(Cursor cursor) {
        super.b(cursor);
        String str = this.field_content;
        if (str != null && str.length() > 2097152) {
            final long j = this.field_msgId;
            StringBuilder stringBuilder = new StringBuilder(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            stringBuilder.append("Very big message: \nmsgId = ").append(j).append('\n').append("msgSvrId = ").append(this.field_msgSvrId).append('\n').append("type = ").append(this.field_type).append('\n').append("createTime = ").append(this.field_createTime).append('\n').append("talker = ").append(this.field_talker).append('\n').append("flag = ").append(this.field_flag).append('\n').append("content.length() = ").append(str.length()).append('\n').append("content = ").append(str.substring(0, 256));
            w.e("MicroMsg.MsgInfo", stringBuilder.toString());
            setType(1);
            setContent("");
            final au Y = Y(this);
            h.vL().D(new Runnable(this) {
                final /* synthetic */ au uJV;

                public final void run() {
                    ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJX().a(j, Y);
                }
            });
        }
        eB(this.field_msgId);
    }

    public static void eB(long j) {
        String str = "msgId not in the reasonable scope";
        boolean z = 100000000 > j && -10 < j;
        Assert.assertTrue(str, z);
    }

    public final ContentValues pv() {
        eB(this.field_msgId);
        return super.pv();
    }

    public final String bMC() {
        if (!bMg()) {
            return "";
        }
        if (this.uJT == null) {
            bMD();
        }
        return this.uJT;
    }

    public final com.tencent.mm.an.a bMD() {
        w.i("MicroMsg.MsgInfo", "[parseNewXmlSysMsg]");
        com.tencent.mm.an.a b = com.tencent.mm.an.a.a.b(f.q(this.field_content, "sysmsg"), this);
        if (b != null) {
            w.i("MicroMsg.MsgInfo", "BaseNewXmlMsg:%s", b);
            b.HT();
            this.uJT = b.hMY;
        } else {
            w.e("MicroMsg.MsgInfo", "[parseNewXmlSysMsg] null == pBaseNewXmlMsg");
        }
        return b;
    }
}
