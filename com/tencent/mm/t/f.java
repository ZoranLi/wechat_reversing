package com.tencent.mm.t;

import com.tencent.mm.e.b.o;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import junit.framework.Assert;

public final class f extends o {
    public static com.tencent.mm.sdk.e.c.a gTP;

    public static class b {
        public static final ArrayList<com.tencent.mm.bn.b<? extends c>> hkk = new ArrayList();
        private static final HashMap<Integer, com.tencent.mm.bn.b<? extends c>> hkl = new HashMap();

        public static void a(com.tencent.mm.bn.b<? extends c> bVar) {
            hkk.add(bVar);
        }

        public static c eU(int i) {
            com.tencent.mm.bn.b bVar = (com.tencent.mm.bn.b) hkl.get(Integer.valueOf(i));
            if (bVar != null) {
                c cVar = (c) bVar.get();
                cVar.type = i;
                return cVar;
            }
            w.w("MicroMsg.AppMessage", "get for type(%s) is null", Integer.valueOf(i));
            return null;
        }
    }

    public static class a extends c {
        private static final com.tencent.mm.a.f<Integer, a> hkd = new com.tencent.mm.a.f(100);
        public String action;
        public String appId;
        public String appName;
        public String canvasPageXml = "";
        public String content;
        public String desc;
        public String description;
        public String designerName;
        public String designerRediretctUrl;
        public String extInfo;
        public String fCW;
        public String fFd;
        public String fNg;
        public String fOu;
        public int fTB;
        public String fUR;
        public String fUS;
        public String fUU;
        public String fUV;
        public String fUW;
        public String fUX;
        public String fUY;
        public int fWF;
        public String filemd5;
        public String gxD;
        public int hhA;
        public int hhB;
        public int hhC;
        public int hhD;
        public String hhE;
        public String hhF;
        public int hhG;
        public String hhH;
        public String hhI;
        public int hhJ;
        public int hhK;
        public int hhL;
        public String hhM;
        public String hhN;
        public int hhO;
        public String hhP;
        public String hhQ;
        public int hhR;
        public String hhS;
        public String hhT;
        public int hhU;
        public String hhV;
        public String hhW;
        public String hhX;
        public String hhY;
        public String hhZ;
        public a hhn;
        public Map<String, String> hho;
        public String hhp;
        public int hhq;
        public String hhr;
        public String hhs;
        public int hht;
        public int hhu;
        public int hhv;
        public String hhw;
        public String hhx;
        public String hhy;
        public int hhz;
        public int hiA;
        public int hiB;
        public int hiC;
        public String hiD;
        public String hiE;
        public String hiF;
        public String hiG;
        public String hiH;
        public String hiI;
        public String hiJ;
        public int hiK;
        public String hiL;
        public String hiM;
        public String hiN;
        public String hiO;
        public String hiP;
        public String hiQ;
        public String hiR;
        public String hiS;
        public String hiT;
        public String hiU;
        public String hiV;
        public String hiW;
        public int hiX;
        public String hiY;
        public String hiZ;
        public String hia;
        public String hib;
        public String hic;
        public String hid;
        public String hie;
        public String hif;
        public String hig;
        public String hih;
        public String hii;
        public String hij;
        public int hik;
        public int hil;
        public int him;
        public String hin;
        public String hio;
        public String hip;
        public String hiq;
        public String hir;
        public int his;
        public String hit;
        public String hiu;
        public String hiv;
        public int hiw;
        public int hix;
        public String hiy;
        public String hiz;
        public int hjA;
        public String hjB;
        public String hjC;
        public String hjD;
        public int hjE = 0;
        public String hjF = "";
        public String hjG = "";
        public String hjH = "";
        public String hjI = "";
        public String hjJ = "";
        public String hjK = "";
        public String hjL;
        public String hjM;
        public String hjN;
        public int hjO;
        public String hjP;
        public int hjQ;
        public String hjR;
        public String hjS;
        public int hjT;
        public int hjU;
        public String hjV;
        public String hjW = null;
        public int hjX = 0;
        private final HashMap<Class<? extends c>, c> hjY = new HashMap();
        public Map<String, String> hjZ;
        public String hja;
        public int hjb;
        public boolean hjc = false;
        public int hjd = 0;
        public String hje;
        public int hjf;
        public String hjg;
        public String hjh;
        public String hji;
        public List<String> hjj;
        public String hjk;
        public List<String> hjl;
        public String hjm;
        public int hjn;
        public String hjo;
        public String hjp;
        public String hjq;
        public String hjr;
        public String hjs;
        public String hjt;
        public String hju;
        public String hjv;
        public String hjw;
        public String hjx;
        public String hjy;
        public String hjz;
        private String hka;
        private String hkb;
        private String hkc;
        public String iconUrl;
        public String mediaTagName;
        public String messageAction;
        public String messageExt;
        public int pageType;
        public int sdkVer;
        public String secondUrl;
        public int showType;
        public String thumburl;
        public int tid;
        public String title;
        public int type;
        public String url;
        public String username;

        public static class a {
            public String desc;
            public String gxO;
            public int hke;
            public int hkf;
            public int hkg;
            public int hkh;
            public int hki = 0;
            public int hkj = 0;
            public String title;
        }

        public final /* synthetic */ c wD() {
            return wF();
        }

        public final <T extends c> T n(Class<T> cls) {
            return (c) this.hjY.get(cls);
        }

        public final void a(c cVar) {
            if (cVar == null) {
                w.printErrStackTrace("MicroMsg.AppMessage", new NullPointerException(""), "piece is null", new Object[0]);
                return;
            }
            cVar.hhl = this;
            this.hjY.put(cVar.getClass(), cVar);
        }

        public static final a ek(String str) {
            return B(str, null);
        }

        public static final a B(String str, String str2) {
            if (bg.mA(str)) {
                return null;
            }
            String substring;
            int indexOf = str.indexOf(60);
            if (indexOf > 0) {
                substring = str.substring(indexOf);
            } else {
                substring = str;
            }
            int hashCode = substring.hashCode();
            a aVar = (a) hkd.get(Integer.valueOf(hashCode));
            if (aVar != null) {
                return aVar;
            }
            Map map;
            Map q;
            long currentTimeMillis = System.currentTimeMillis();
            if (bg.mA(str2)) {
                map = null;
            } else {
                map = aw.PF(str2);
            }
            if (map == null) {
                q = bh.q(substring, "msg");
            } else {
                q = map;
            }
            if (q == null) {
                w.e("MicroMsg.AppMessage", "parse msg failed");
                return null;
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            a aVar2 = new a();
            aVar2.hjZ = q;
            aVar2.hka = str;
            aVar2.hkb = substring;
            aVar2.hkc = str2;
            try {
                c cVar;
                aVar2.a(q, aVar2);
                Iterator it = b.hkk.iterator();
                while (it.hasNext()) {
                    cVar = (c) ((com.tencent.mm.bn.b) it.next()).get();
                    cVar.a(q, aVar2);
                    aVar2.a(cVar);
                }
                cVar = b.eU(aVar2.type);
                if (cVar != null) {
                    cVar.a(q, aVar2);
                    aVar2.a(cVar);
                }
                hkd.k(Integer.valueOf(hashCode), aVar2);
                w.d("MicroMsg.AppMessage", "parseContent, time:%d, %d, %d", Long.valueOf(currentTimeMillis2 - currentTimeMillis), Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(bg.mz(str2).hashCode()));
                return aVar2;
            } catch (Throwable e) {
                w.e("MicroMsg.AppMessage", "parse amessage xml failed");
                w.e("MicroMsg.AppMessage", "exception:%s", bg.g(e));
                return null;
            }
        }

        public static String a(a aVar, String str, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult) {
            w.i("MicroMsg.AppMessage", "summersafecdn makeLocalContent aesKey[%s], filemd5[%s]", bg.Qj(aVar.hhE), aVar.filemd5);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("<msg>");
            if (aVar.hhD == 0 || aVar.hhC == 0) {
                w.d("MicroMsg.AppMessage", "summersafecdn makeLocalContent thumb 0");
                stringBuilder.append(a(aVar, str, com_tencent_mm_modelcdntran_keep_SceneResult, 0, 0));
            } else {
                w.d("MicroMsg.AppMessage", "summersafecdn makeLocalContent thumb[%d, %d]", Integer.valueOf(aVar.hhD), Integer.valueOf(aVar.hhC));
                stringBuilder.append(a(aVar, str, com_tencent_mm_modelcdntran_keep_SceneResult, aVar.hhD, aVar.hhC));
            }
            stringBuilder.append("</msg>");
            hkd.k(Integer.valueOf(stringBuilder.toString().hashCode()), aVar);
            return stringBuilder.toString();
        }

        public static String a(a aVar, String str, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, int i, int i2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("<appmsg appid=\"" + bg.PW(aVar.appId) + "\" sdkver=\"" + aVar.sdkVer + "\">");
            aVar.a(stringBuilder, aVar, str, com_tencent_mm_modelcdntran_keep_SceneResult, i, i2);
            c eU = b.eU(aVar.type);
            if (eU != null) {
                eU.a(stringBuilder, aVar, str, com_tencent_mm_modelcdntran_keep_SceneResult, i, i2);
            }
            stringBuilder.append("</appmsg>");
            if (2 == aVar.showType) {
                stringBuilder.append("<ShakePageResult>").append(aVar.hhw).append("</ShakePageResult>");
            }
            w.d("MicroMsg.AppMessage", "summerbig makeContent[%s]", stringBuilder.toString());
            return stringBuilder.toString();
        }

        public static a a(a aVar) {
            if (aVar == null) {
                return new a();
            }
            return aVar.wF();
        }

        public final void a(Map<String, String> map, a aVar) {
            try {
                this.hho = map;
                this.appId = (String) map.get(".msg.appmsg.$appid");
                this.sdkVer = bg.getInt((String) map.get(".msg.appmsg.$sdkver"), 0);
                this.title = bg.PG((String) map.get(".msg.appmsg.title"));
                this.description = (String) map.get(".msg.appmsg.des");
                this.username = (String) map.get(".msg.appmsg.username");
                this.action = (String) map.get(".msg.appmsg.action");
                this.type = bg.getInt((String) map.get(".msg.appmsg.type"), 0);
                this.content = (String) map.get(".msg.appmsg.content");
                this.url = (String) map.get(".msg.appmsg.url");
                this.hhp = (String) map.get(".msg.appmsg.lowurl");
                this.hhH = (String) map.get(".msg.appmsg.dataurl");
                this.hhI = (String) map.get(".msg.appmsg.lowdataurl");
                this.hhq = bg.getInt((String) map.get(".msg.appmsg.appattach.totallen"), 0);
                this.fCW = (String) map.get(".msg.appmsg.appattach.attachid");
                this.hhr = bg.PG((String) map.get(".msg.appmsg.appattach.fileext"));
                this.hhs = (String) map.get(".msg.appmsg.appattach.emoticonmd5");
                this.extInfo = (String) map.get(".msg.appmsg.extinfo");
                this.hht = bg.getInt((String) map.get(".msg.appmsg.androidsource"), 0);
                this.fUR = (String) map.get(".msg.appmsg.sourceusername");
                this.fUS = (String) map.get(".msg.appmsg.sourcedisplayname");
                this.gxD = (String) map.get(".msg.commenturl");
                this.thumburl = (String) map.get(".msg.appmsg.thumburl");
                this.mediaTagName = (String) map.get(".msg.appmsg.mediatagname");
                this.messageAction = (String) map.get(".msg.appmsg.messageaction");
                this.messageExt = (String) map.get(".msg.appmsg.messageext");
                this.fWF = bg.getInt((String) map.get(".msg.appinfo.version"), 0);
                this.appName = (String) map.get(".msg.appinfo.appname");
                this.fOu = (String) map.get(".msg.fromusername");
                this.hhx = (String) map.get(".msg.appmsg.appattach.cdnattachurl");
                this.hhy = (String) map.get(".msg.appmsg.appattach.cdnthumburl");
                this.hhz = bg.getInt((String) map.get(".msg.appmsg.appattach.cdnthumblength"), 0);
                this.hhA = bg.getInt((String) map.get(".msg.appmsg.appattach.cdnthumbheight"), 0);
                this.hhB = bg.getInt((String) map.get(".msg.appmsg.appattach.cdnthumbwidth"), 0);
                this.hhC = bg.getInt((String) map.get(".msg.appmsg.appattach.thumbheight"), 0);
                this.hhD = bg.getInt((String) map.get(".msg.appmsg.appattach.thumbwidth"), 0);
                this.hhE = (String) map.get(".msg.appmsg.appattach.aeskey");
                this.hhG = bg.getInt((String) map.get(".msg.appmsg.appattach.encryver"), 1);
                this.hhF = (String) map.get(".msg.appmsg.appattach.cdnthumbaeskey");
                this.hhu = bg.getInt((String) map.get(".msg.appmsg.appattach.islargefilemsg"), 0);
                if (this.hhu == 0 && this.hhq > 26214400) {
                    this.hhu = 1;
                    w.i("MicroMsg.AppMessage", "summerbig content.attachlen[%d] set largefilemsg 1", Integer.valueOf(this.hhq));
                }
                this.hhL = bg.getInt((String) map.get(".msg.appmsg.productitem.$type"), 0);
                this.hhM = (String) map.get(".msg.appmsg.productitem.productinfo");
                this.hhO = bg.getInt((String) map.get(".msg.appmsg.emoticongift.packageflag"), 0);
                this.hhN = (String) map.get(".msg.appmsg.emoticongift.packageid");
                this.hhT = (String) map.get(".msg.appmsg.emoticonshared.packageid");
                this.hhU = bg.getInt((String) map.get(".msg.appmsg.emoticonshared.packageflag"), 0);
                this.hhP = (String) map.get(".msg.appmsg.tvinfo");
                this.hhQ = (String) map.get(".msg.appmsg.recorditem");
                this.fUU = (String) map.get(".msg.appmsg.webviewshared.shareUrlOriginal");
                this.fUV = (String) map.get(".msg.appmsg.webviewshared.shareUrlOpen");
                this.fUW = (String) map.get(".msg.appmsg.webviewshared.jsAppId");
                this.fUX = (String) map.get(".msg.appmsg.webviewshared.publisherId");
                this.hjA = com.tencent.mm.a.o.aY((String) map.get(".msg.appmsg.designershared.designeruin"));
                this.designerName = (String) map.get(".msg.appmsg.designershared.designername");
                this.designerRediretctUrl = (String) map.get(".msg.appmsg.designershared.designerrediretcturl");
                this.tid = bg.PY((String) map.get(".msg.appmsg.emotionpageshared.tid"));
                this.hjB = (String) map.get(".msg.appmsg.emotionpageshared.title");
                this.desc = (String) map.get(".msg.appmsg.emotionpageshared.desc");
                this.iconUrl = (String) map.get(".msg.appmsg.emotionpageshared.iconUrl");
                this.secondUrl = bg.ap((String) map.get(".msg.appmsg.emotionpageshared.secondUrl"), "");
                this.pageType = bg.PY((String) map.get(".msg.appmsg.emotionpageshared.pageType"));
                this.hjD = bg.ap((String) map.get(".msg.appmsg.streamvideo.streamvideourl"), "");
                this.hjE = bg.PY((String) map.get(".msg.appmsg.streamvideo.streamvideototaltime"));
                this.hjF = bg.ap((String) map.get(".msg.appmsg.streamvideo.streamvideotitle"), "");
                this.hjG = bg.ap((String) map.get(".msg.appmsg.streamvideo.streamvideowording"), "");
                this.hjH = bg.ap((String) map.get(".msg.appmsg.streamvideo.streamvideoweburl"), "");
                this.hjI = bg.ap((String) map.get(".msg.appmsg.streamvideo.streamvideothumburl"), "");
                this.hjJ = bg.ap((String) map.get(".msg.appmsg.streamvideo.streamvideoaduxinfo"), "");
                this.hjK = bg.ap((String) map.get(".msg.appmsg.streamvideo.streamvideopublishid"), "");
                this.canvasPageXml = bg.ap((String) map.get(".msg.appmsg.canvasPageItem.canvasPageXml"), "");
                this.hjM = (String) map.get(".msg.appmsg.weappinfo.username");
                this.hjL = (String) map.get(".msg.appmsg.weappinfo.pagepath");
                this.hjN = (String) map.get(".msg.appmsg.weappinfo.appid");
                this.hjU = bg.getInt((String) map.get(".msg.appmsg.weappinfo.version"), 0);
                this.hjO = bg.getInt((String) map.get(".msg.appmsg.weappinfo.type"), 0);
                this.hjT = bg.getInt((String) map.get(".msg.appmsg.weappinfo.pkginfo.type"), 0);
                this.hjP = (String) map.get(".msg.appmsg.weappinfo.pkginfo.md5");
                this.hjV = (String) map.get(".msg.appmsg.weappinfo.weappiconurl");
                this.hjR = (String) map.get(".msg.appmsg.weappinfo.shareId");
                this.hjS = (String) map.get(".msg.appmsg.weappinfo.sharekey");
                String str = "<cache";
                String str2 = "</cache>";
                int indexOf = aVar.hka.indexOf(str);
                int indexOf2 = aVar.hka.indexOf(str2);
                if (indexOf2 - indexOf > str.length()) {
                    this.hjW = aVar.hka.substring(indexOf, str2.length() + indexOf2);
                }
                this.hjX = bg.getInt((String) map.get(".msg.appmsg.soundtype"), 0);
                switch (this.type) {
                    case 1:
                        if (!(map.get(".msg.alphainfo.url") == null || map.get(".msg.alphainfo.md5") == null)) {
                            this.hjc = true;
                            break;
                        }
                    case 13:
                        this.hhR = bg.getInt((String) map.get(".msg.appmsg.mallproductitem.$type"), 0);
                        this.hhS = (String) map.get(".msg.appmsg.mallproductitem.mallproductinfo");
                        break;
                    case 16:
                        this.fNg = aVar.hka;
                        this.hiy = "";
                        this.hiA = bg.getInt((String) map.get(".msg.appmsg.carditem.from_scene"), 2);
                        this.hiz = (String) map.get(".msg.appmsg.carditem.brand_name");
                        this.hiB = bg.getInt((String) map.get(".msg.appmsg.carditem.card_type"), -1);
                        break;
                    case 34:
                        this.hiD = bg.ap((String) map.get(".msg.appmsg.giftcard_info.order_id"), "");
                        this.hiC = com.tencent.mm.a.o.aY((String) map.get(".msg.appmsg.giftcard_info.biz_uin"));
                        this.hiE = bg.ap((String) map.get(".msg.appmsg.giftcard_info.app_name"), "");
                        this.hiF = bg.ap((String) map.get(".msg.appmsg.giftcard_info.recv_digest"), "");
                        this.hiG = bg.ap((String) map.get(".msg.appmsg.giftcard_info.send_digest"), "");
                        this.hiH = bg.ap((String) map.get(".msg.appmsg.giftcard_info.background_pic_url"), "");
                        this.hiI = bg.ap((String) map.get(".msg.appmsg.giftcard_info.title_color"), "");
                        this.hiJ = bg.ap((String) map.get(".msg.appmsg.giftcard_info.des_color"), "");
                        break;
                    case MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN /*2000*/:
                        this.his = bg.getInt((String) map.get(".msg.appmsg.wcpayinfo.paysubtype"), 0);
                        this.hit = bg.mz((String) map.get(".msg.appmsg.wcpayinfo.feedesc"));
                        this.hiu = bg.mz((String) map.get(".msg.appmsg.wcpayinfo.transcationid"));
                        this.hiv = bg.mz((String) map.get(".msg.appmsg.wcpayinfo.transferid"));
                        this.hiw = bg.getInt((String) map.get(".msg.appmsg.wcpayinfo.invalidtime"), 0);
                        this.hix = bg.getInt((String) map.get(".msg.appmsg.wcpayinfo.effectivedate"), 3);
                        this.fTB = bg.getInt((String) map.get(".msg.appmsg.wcpayinfo.total_fee"), 0);
                        this.fFd = bg.ap((String) map.get(".msg.appmsg.wcpayinfo.fee_type"), "ZAR");
                        this.hjC = bg.ap((String) map.get(".msg.appmsg.wcpayinfo.pay_memo"), "");
                        break;
                    case MMBitmapFactory.ERROR_PNG_BUG_DETECTED_BEGIN /*2001*/:
                        String[] split;
                        this.hiO = bg.mz((String) map.get(".msg.appmsg.wcpayinfo.iconurl"));
                        this.hiT = bg.mz((String) map.get(".msg.appmsg.wcpayinfo.scenetext"));
                        this.hiN = bg.mz((String) map.get(".msg.appmsg.wcpayinfo.url"));
                        this.hiP = bg.mz((String) map.get(".msg.appmsg.wcpayinfo.receivertitle"));
                        this.hiQ = bg.mz((String) map.get(".msg.appmsg.wcpayinfo.sendertitle"));
                        this.hiS = bg.mz((String) map.get(".msg.appmsg.wcpayinfo.receiverdes"));
                        this.hiR = bg.mz((String) map.get(".msg.appmsg.wcpayinfo.senderdes"));
                        this.hiU = bg.mz((String) map.get(".msg.appmsg.wcpayinfo.templateid"));
                        this.hiV = bg.mz((String) map.get(".msg.appmsg.wcpayinfo.sceneid"));
                        this.hiW = bg.mz((String) map.get(".msg.appmsg.wcpayinfo.nativeurl"));
                        this.hiX = bg.getInt((String) map.get(".msg.appmsg.wcpayinfo.localtype"), 0);
                        this.hiY = bg.mz((String) map.get(".msg.appmsg.wcpayinfo.paymsgid"));
                        this.hiZ = bg.mz((String) map.get(".msg.appmsg.wcpayinfo.imageid"));
                        this.hja = bg.mz((String) map.get(".msg.appmsg.wcpayinfo.imageaeskey"));
                        this.hjb = bg.getInt((String) map.get(".msg.appmsg.wcpayinfo.imagelength"), 0);
                        this.hjd = bg.getInt((String) map.get(".msg.appmsg.wcpayinfo.droptips"), 0);
                        this.hje = bg.mz((String) map.get(".msg.appmsg.wcpayinfo.newaa.billno"));
                        this.hjf = bg.getInt((String) map.get(".msg.appmsg.wcpayinfo.newaa.newaatype"), 0);
                        this.hjg = bg.mz((String) map.get(".msg.appmsg.wcpayinfo.newaa.receivertitle"));
                        this.hjh = bg.mz((String) map.get(".msg.appmsg.wcpayinfo.newaa.launchertitle"));
                        this.hji = bg.mz((String) map.get(".msg.appmsg.wcpayinfo.newaa.notinertitle"));
                        str = bg.mz((String) map.get(".msg.appmsg.wcpayinfo.newaa.receiverlist"));
                        if (!bg.mA(str)) {
                            split = str.split("\\|");
                            if (split != null && split.length > 0) {
                                this.hjj = new ArrayList();
                                this.hjj.addAll(Arrays.asList(split));
                            }
                        }
                        this.hjk = bg.mz((String) map.get(".msg.appmsg.wcpayinfo.newaa.payertitle"));
                        str = bg.mz((String) map.get(".msg.appmsg.wcpayinfo.newaa.payerlist"));
                        if (!bg.mA(str)) {
                            split = str.split("\\|");
                            if (split != null && split.length > 0) {
                                this.hjl = new ArrayList();
                                this.hjl.addAll(Arrays.asList(split));
                            }
                        }
                        this.hjm = bg.mz((String) map.get(".msg.appmsg.wcpayinfo.newaa.outtradeno"));
                        this.hjn = bg.getInt((String) map.get(".msg.appmsg.wcpayinfo.newaa.seq"), 0);
                        this.hjo = bg.mz((String) map.get(".msg.appmsg.wcpayinfo.newaa.launcherusername"));
                        break;
                    case MMBitmapFactory.ERROR_ILLEGAL_NPTC_CHUNK /*2002*/:
                        this.hjp = bg.mz((String) map.get(".msg.appmsg.wcpaythirdinfo.url"));
                        this.hjq = bg.mz((String) map.get(".msg.appmsg.wcpaythirdinfo.templateid"));
                        this.hjr = bg.mz((String) map.get(".msg.appmsg.wcpaythirdinfo.iconurl"));
                        this.hjs = bg.mz((String) map.get(".msg.appmsg.wcpaythirdinfo.miniiconurl"));
                        this.hjt = bg.mz((String) map.get(".msg.appmsg.wcpaythirdinfo.backgroundurl"));
                        this.hju = bg.mz((String) map.get(".msg.appmsg.wcpaythirdinfo.receivertitle"));
                        this.hjv = bg.mz((String) map.get(".msg.appmsg.wcpaythirdinfo.sendertitle"));
                        this.hjw = bg.mz((String) map.get(".msg.appmsg.wcpaythirdinfo.scenetext"));
                        this.hjx = bg.mz((String) map.get(".msg.appmsg.wcpaythirdinfo.senderdes"));
                        this.hjy = bg.mz((String) map.get(".msg.appmsg.wcpaythirdinfo.receiverdes"));
                        this.hjz = bg.mz((String) map.get(".msg.appmsg.wcpaythirdinfo.sceneid"));
                        break;
                }
                if (this.type != 21) {
                    if (this.type != MMBitmapFactory.ERROR_PNG_BUG_DETECTED_BEGIN) {
                        this.showType = bg.getInt((String) map.get(".msg.appmsg.showtype"), 0);
                        switch (this.showType) {
                            case 1:
                                if (bg.getInt((String) map.get(".msg.appmsg.mmreader.category.$count"), 0) > 0) {
                                    this.content = aw.ae(map);
                                    break;
                                }
                                break;
                            case 2:
                                str = aVar.hka.toLowerCase();
                                this.hhw = aVar.hka.substring(str.indexOf("<ShakePageResult>".toLowerCase()) + 17, str.indexOf("</ShakePageResult>".toLowerCase()));
                                break;
                            default:
                                break;
                        }
                    }
                    this.showType = bg.getInt((String) map.get(".msg.appmsg.wcpayinfo.innertype"), 0);
                } else {
                    this.showType = bg.getInt((String) map.get(".msg.appmsg.hardwareinfo.hardwareshowtype"), 0);
                }
                this.fUY = (String) map.get(".msg.appmsg.statextstr");
                this.hhJ = bg.getInt((String) map.get(".msg.appmsg.mmreader.category.item.itemshowtype"), 0);
                if (this.hhJ == 5 && bg.getInt((String) map.get(".msg.appmsg.mmreader.category.$count"), 0) > 1) {
                    this.hhJ = 0;
                }
                this.hhK = bg.getInt((String) map.get(".msg.appmsg.mmreader.template_detail.template_show_type"), 0);
                this.hhV = (String) map.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.rank.ranktitle");
                this.hhW = (String) map.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.rankid");
                if (bg.mA(this.hhW)) {
                    this.hhW = (String) map.get(".msg.appmsg.hardwareinfo.likeuserlist.userinfo.rankid");
                }
                this.hhX = (String) map.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.rank.rankdisplay");
                this.hhY = (String) map.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.score.scoretitle");
                this.hhZ = (String) map.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.score.scoredisplay");
                this.hia = (String) map.get(".msg.appmsg.hardwareinfo.messagenodeinfo.tipdisplay");
                this.hib = (String) map.get(".msg.appmsg.hardwareinfo.messagenodeinfo.color");
                this.hic = (String) map.get(".msg.appmsg.hardwareinfo.messagenodeinfo.highlightcolor");
                this.hid = (String) map.get(".msg.appmsg.hardwareinfo.messagenodeinfo.linecolor");
                this.hif = (String) map.get(".msg.appmsg.hardwareinfo.messagenodeinfo.fontcolor");
                this.hie = (String) map.get(".msg.appmsg.hardwareinfo.messagenodeinfo.highlightlinecolor");
                this.hih = (String) map.get(".msg.appmsg.hardwareinfo.rankview.rankviewtitle");
                this.hig = (String) map.get(".msg.appmsg.hardwareinfo.messagenodeinfo.championusername");
                this.hik = bg.getInt((String) map.get(".msg.appmsg.hardwareinfo.hardwareshowtype"), 0);
                this.him = bg.getInt((String) map.get(".msg.appmsg.hardwareinfo.timestamp"), 0);
                this.hil = bg.getInt((String) map.get(".msg.appmsg.hardwareinfo.devicetype"), 0);
                this.hii = (String) map.get(".msg.appmsg.hardwareinfo.rankview.championinfo.motto");
                this.hij = (String) map.get(".msg.appmsg.hardwareinfo.rankview.championinfo.coverimgurl");
                str = (String) map.get(".msg.appmsg.hardwareinfo.messagenodeinfo.displayusername");
                this.hiq = str;
                this.hio = str;
                str = (String) map.get(".msg.appmsg.hardwareinfo.messagenodeinfo.title");
                this.hip = str;
                this.hin = str;
                this.hir = bg.mz((String) map.get(".msg.appmsg.template_id"));
                this.filemd5 = (String) map.get(".msg.appmsg.md5");
                this.hiK = bg.getInt((String) map.get(".msg.appmsg.jumpcontrol.enable"), 0);
                this.hiL = (String) map.get(".msg.appmsg.jumpcontrol.jumpurl");
                this.hiM = (String) map.get(".msg.appmsg.jumpcontrol.pushcontent");
                Map q = bh.q(aVar.hkb, "msgoperation");
                if (this != null && q != null) {
                    this.hhn = new a();
                    this.hhn.gxO = (String) q.get(".msgoperation.expinfo.expidstr");
                    this.hhn.hke = bg.getInt((String) q.get(".msgoperation.appmsg.usedefaultthumb"), 0);
                    this.hhn.hkf = bg.getInt((String) q.get(".msgoperation.appmsg.isupdatetitle"), 0);
                    this.hhn.title = (String) q.get(".msgoperation.appmsg.title");
                    this.hhn.hkg = bg.getInt((String) q.get(".msgoperation.appmsg.isupdatedesc"), 0);
                    this.hhn.desc = (String) q.get(".msgoperation.appmsg.desc");
                    this.hhn.hkh = bg.getInt((String) q.get(".msgoperation.appmsg.ishiddentail"), 0);
                }
            } catch (Throwable e) {
                w.e("MicroMsg.AppMessage", "parse amessage xml failed");
                w.e("MicroMsg.AppMessage", "exception:%s", bg.g(e));
                throw e;
            }
        }

        private a wF() {
            a aVar = new a();
            if (this == null) {
                return aVar;
            }
            w.i("MicroMsg.AppMessage", "summerbig cloneContent srcContent aesKey[%s], filemd5[%s], appid[%s]", bg.Qj(this.hhE), this.filemd5, aVar.appId);
            aVar.action = this.action;
            aVar.appId = this.appId;
            aVar.appName = this.appName;
            aVar.fWF = this.fWF;
            aVar.fCW = this.fCW;
            aVar.hhq = this.hhq;
            aVar.content = this.content;
            aVar.description = this.description;
            aVar.username = this.username;
            aVar.extInfo = this.extInfo;
            aVar.mediaTagName = this.mediaTagName;
            aVar.messageAction = this.messageAction;
            aVar.messageExt = this.messageExt;
            aVar.hht = this.hht;
            aVar.hhr = this.hhr;
            aVar.fOu = this.fOu;
            aVar.hhp = this.hhp;
            aVar.sdkVer = this.sdkVer;
            aVar.title = this.title;
            aVar.type = this.type;
            aVar.showType = this.showType;
            aVar.hhJ = this.hhJ;
            aVar.hhK = this.hhK;
            aVar.url = this.url;
            aVar.hhs = this.hhs;
            aVar.fUR = this.fUR;
            aVar.fUS = this.fUS;
            aVar.gxD = this.gxD;
            aVar.thumburl = this.thumburl;
            aVar.hhw = this.hhw;
            aVar.hhH = this.hhH;
            aVar.hhI = this.hhI;
            aVar.hhL = this.hhL;
            aVar.hhM = this.hhM;
            aVar.hhO = this.hhO;
            aVar.hhN = this.hhN;
            aVar.hhR = this.hhR;
            aVar.hhS = this.hhS;
            aVar.hhU = this.hhU;
            aVar.hhT = this.hhT;
            aVar.hhP = this.hhP;
            aVar.hhQ = this.hhQ;
            aVar.hir = this.hir;
            aVar.fNg = this.fNg;
            aVar.hiy = this.hiy;
            aVar.hiz = this.hiz;
            aVar.hiA = this.hiA;
            aVar.hiB = this.hiA;
            aVar.hit = this.hit;
            aVar.hiw = this.hiw;
            aVar.his = this.his;
            aVar.hiu = this.hiu;
            aVar.hiv = this.hiv;
            aVar.hiK = this.hiK;
            aVar.hiL = this.hiL;
            aVar.hiM = this.hiM;
            aVar.hhv = this.hhv;
            aVar.fUU = this.fUU;
            aVar.fUV = this.fUV;
            aVar.fUW = this.fUW;
            aVar.fUX = this.fUX;
            aVar.hjC = this.hjC;
            aVar.hjA = this.hjA;
            aVar.designerName = this.designerName;
            aVar.designerRediretctUrl = this.designerName;
            aVar.tid = this.tid;
            aVar.hjB = this.hjB;
            aVar.desc = this.desc;
            aVar.iconUrl = this.iconUrl;
            aVar.secondUrl = this.secondUrl;
            aVar.pageType = this.pageType;
            aVar.hjD = this.hjD;
            aVar.hjE = this.hjE;
            aVar.hjF = this.hjF;
            aVar.hjG = this.hjG;
            aVar.hjH = this.hjH;
            aVar.hjI = this.hjI;
            aVar.hjJ = this.hjJ;
            aVar.hjK = this.hjK;
            aVar.canvasPageXml = this.canvasPageXml;
            aVar.fUY = this.fUY;
            aVar.hhx = this.hhx;
            aVar.hhE = this.hhE;
            aVar.filemd5 = this.filemd5;
            aVar.hhu = this.hhu;
            aVar.hhn = this.hhn;
            aVar.hjL = this.hjL;
            aVar.hjM = this.hjM;
            aVar.hjO = this.hjO;
            aVar.hjP = this.hjP;
            aVar.hjT = this.hjT;
            aVar.hjN = this.hjN;
            aVar.hjU = this.hjU;
            aVar.hjV = this.hjV;
            aVar.hjR = this.hjR;
            aVar.hkb = this.hkb;
            aVar.hkc = this.hkc;
            aVar.hka = this.hka;
            aVar.hjZ = this.hjZ;
            for (Entry value : this.hjY.entrySet()) {
                c wD = ((c) value.getValue()).wD();
                if (wD != null) {
                    aVar.a(wD);
                }
            }
            return aVar;
        }

        public final void a(StringBuilder stringBuilder, a aVar, String str, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, int i, int i2) {
            String str2;
            stringBuilder.append("<title>" + bg.PW(aVar.title) + "</title>");
            stringBuilder.append("<des>" + bg.PW(aVar.description) + "</des>");
            stringBuilder.append("<username>" + bg.PW(aVar.username) + "</username>");
            StringBuilder stringBuilder2 = new StringBuilder("<action>");
            if (bg.mA(aVar.action)) {
                str2 = "view";
            } else {
                str2 = bg.PW(aVar.action);
            }
            stringBuilder.append(stringBuilder2.append(str2).append("</action>").toString());
            stringBuilder.append("<type>" + aVar.type + "</type>");
            stringBuilder.append("<showtype>").append(aVar.showType).append("</showtype>");
            stringBuilder.append("<content>" + bg.PW(aVar.content) + "</content>");
            stringBuilder.append("<url>" + bg.PW(aVar.url) + "</url>");
            stringBuilder.append("<lowurl>" + bg.PW(aVar.hhp) + "</lowurl>");
            stringBuilder.append("<dataurl>" + bg.PW(aVar.hhH) + "</dataurl>");
            stringBuilder.append("<lowdataurl>" + bg.PW(aVar.hhI) + "</lowdataurl>");
            stringBuilder.append("<contentattr>").append(aVar.hhv).append("</contentattr>");
            stringBuilder.append("<streamvideo>");
            stringBuilder.append("<streamvideourl>").append(bg.PW(aVar.hjD)).append("</streamvideourl>");
            stringBuilder.append("<streamvideototaltime>").append(aVar.hjE).append("</streamvideototaltime>");
            stringBuilder.append("<streamvideotitle>").append(bg.PW(aVar.hjF)).append("</streamvideotitle>");
            stringBuilder.append("<streamvideowording>").append(bg.PW(aVar.hjG)).append("</streamvideowording>");
            stringBuilder.append("<streamvideoweburl>").append(bg.PW(aVar.hjH)).append("</streamvideoweburl>");
            stringBuilder.append("<streamvideothumburl>").append(bg.PW(aVar.hjI)).append("</streamvideothumburl>");
            stringBuilder.append("<streamvideoaduxinfo>").append(bg.PW(aVar.hjJ)).append("</streamvideoaduxinfo>");
            stringBuilder.append("<streamvideopublishid>").append(bg.PW(aVar.hjK)).append("</streamvideopublishid>");
            stringBuilder.append("</streamvideo>");
            stringBuilder.append(String.format("<canvasPageItem><canvasPageXml><![CDATA[%s]]></canvasPageXml></canvasPageItem>", new Object[]{aVar.canvasPageXml}));
            switch (aVar.type) {
                case 10:
                    stringBuilder.append("<productitem type=\"" + aVar.hhL + "\">");
                    stringBuilder.append("<productinfo>" + bg.PW(aVar.hhM) + "</productinfo>");
                    stringBuilder.append("</productitem>");
                    break;
                case 13:
                    stringBuilder.append("<mallproductitem type=\"" + aVar.hhR + "\">");
                    stringBuilder.append("<mallproductinfo>" + bg.PW(aVar.hhS) + "</mallproductinfo>");
                    stringBuilder.append("</mallproductitem>");
                    break;
                case 16:
                    stringBuilder.append("<carditem>" + aVar.hiy + "</carditem>");
                    break;
                case 19:
                case 24:
                    stringBuilder.append("<recorditem>" + bg.PW(aVar.hhQ) + "</recorditem>");
                    break;
                case 20:
                    stringBuilder.append("<tvinfo>" + bg.PW(aVar.hhP) + "</tvinfo>");
                    break;
                case MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN /*2000*/:
                    stringBuilder.append("<wcpayinfo>");
                    stringBuilder.append("<paysubtype>" + aVar.his + "</paysubtype>");
                    stringBuilder.append("<feedesc>" + aVar.hit + "</feedesc>");
                    stringBuilder.append("<transcationid>" + aVar.hiu + "</transcationid>");
                    stringBuilder.append("<transferid>" + aVar.hiv + "</transferid>");
                    stringBuilder.append("<invalidtime>" + aVar.hiw + "</invalidtime>");
                    stringBuilder.append("<pay_memo>" + aVar.hjC + "</pay_memo>");
                    stringBuilder.append("</wcpayinfo>");
                    break;
                case MMBitmapFactory.ERROR_PNG_BUG_DETECTED_BEGIN /*2001*/:
                    stringBuilder.append("<wcpayinfo>");
                    stringBuilder.append("<iconurl>" + bg.PW(aVar.hiO) + "</iconurl>");
                    stringBuilder.append("<scenetext>" + bg.PW(aVar.hiT) + "</scenetext>");
                    stringBuilder.append("<url>" + bg.PW(aVar.hiN) + "</url>");
                    stringBuilder.append("<receivertitle>" + bg.PW(aVar.hiP) + "</receivertitle>");
                    stringBuilder.append("<sendertitle>" + bg.PW(aVar.hiQ) + "</sendertitle>");
                    stringBuilder.append("<receiverdes>" + bg.PW(aVar.hiS) + "</receiverdes>");
                    stringBuilder.append("<senderdes>" + bg.PW(aVar.hiR) + "</senderdes>");
                    stringBuilder.append("<templateid>" + bg.PW(aVar.hiU) + "</templateid>");
                    stringBuilder.append("<sceneid>" + bg.PW(aVar.hiV) + "</sceneid>");
                    stringBuilder.append("<nativeurl>" + bg.PW(aVar.hiW) + "</nativeurl>");
                    stringBuilder.append("<innertype>" + bg.PW(aVar.showType) + "</innertype>");
                    stringBuilder.append("<localtype>" + bg.PW(aVar.hiX) + "</localtype>");
                    stringBuilder.append("<paymsgid>" + bg.PW(aVar.hiY) + "</paymsgid>");
                    stringBuilder.append("<imageid>" + bg.PW(aVar.hiZ) + "</imageid>");
                    stringBuilder.append("<imageaeskey>" + bg.PW(aVar.hja) + "</imageaeskey>");
                    stringBuilder.append("<imagelength>" + bg.PW(aVar.hjb) + "</imagelength>");
                    stringBuilder.append("<droptips>" + bg.PW(aVar.hjd) + "</droptips>");
                    stringBuilder.append("</wcpayinfo>");
                    break;
            }
            stringBuilder.append("<appattach>");
            if (com_tencent_mm_modelcdntran_keep_SceneResult == null || (bg.mA(str) && i == 0 && i2 == 0)) {
                stringBuilder.append("<totallen>" + aVar.hhq + "</totallen>");
                stringBuilder.append("<attachid>" + bg.PW(aVar.fCW) + "</attachid>");
                stringBuilder.append("<cdnattachurl>" + bg.PW(aVar.hhx) + "</cdnattachurl>");
                stringBuilder.append("<emoticonmd5>" + bg.PW(aVar.hhs) + "</emoticonmd5>");
                stringBuilder.append("<aeskey>" + bg.PW(aVar.hhE) + "</aeskey>");
                if (!(i == 0 || i2 == 0)) {
                    stringBuilder.append("<thumbheight>" + i2 + "</thumbheight>");
                    stringBuilder.append("<thumbwidth>" + i + "</thumbwidth>");
                }
            } else {
                stringBuilder.append("<attachid>" + bg.PW(str) + "</attachid>");
                if (com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength > 0 && !bg.mA(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId)) {
                    stringBuilder.append("<cdnattachurl>" + bg.PW(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId) + "</cdnattachurl>");
                    if (aVar.type == 19 || aVar.type == 24 || aVar.type == 4 || aVar.type == 3 || aVar.type == 7 || aVar.type == 27 || aVar.type == 26) {
                        w.i("MicroMsg.AppMessage", "summersafecdn content.type[%d], len[%d] but not set", Integer.valueOf(aVar.type), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength));
                    } else {
                        stringBuilder.append("<totallen>" + com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength + "</totallen>");
                    }
                }
                if (com_tencent_mm_modelcdntran_keep_SceneResult.field_thumbimgLength > 0) {
                    stringBuilder.append("<cdnthumburl>" + bg.PW(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId) + "</cdnthumburl>");
                    if (!bg.mA(com_tencent_mm_modelcdntran_keep_SceneResult.field_thumbfilemd5)) {
                        stringBuilder.append("<cdnthumbmd5>" + com_tencent_mm_modelcdntran_keep_SceneResult.field_thumbfilemd5 + "</cdnthumbmd5>");
                    }
                    stringBuilder.append("<cdnthumblength>" + com_tencent_mm_modelcdntran_keep_SceneResult.field_thumbimgLength + "</cdnthumblength>");
                    stringBuilder.append("<cdnthumbheight>" + i2 + "</cdnthumbheight>");
                    stringBuilder.append("<cdnthumbwidth>" + i + "</cdnthumbwidth>");
                    stringBuilder.append("<cdnthumbaeskey>" + com_tencent_mm_modelcdntran_keep_SceneResult.field_aesKey + "</cdnthumbaeskey>");
                }
                stringBuilder.append("<aeskey>" + bg.PW(com_tencent_mm_modelcdntran_keep_SceneResult.field_aesKey) + "</aeskey>");
                stringBuilder.append("<encryver>1</encryver>");
            }
            stringBuilder.append("<fileext>" + bg.PW(aVar.hhr) + "</fileext>");
            stringBuilder.append("<islargefilemsg>" + aVar.hhu + "</islargefilemsg>");
            stringBuilder.append("</appattach>");
            stringBuilder.append("<extinfo>" + bg.PW(aVar.extInfo) + "</extinfo>");
            stringBuilder.append("<androidsource>" + aVar.hht + "</androidsource>");
            if (!bg.mA(aVar.fUR)) {
                stringBuilder.append("<sourceusername>" + bg.PW(aVar.fUR) + "</sourceusername>");
                stringBuilder.append("<sourcedisplayname>" + bg.PW(aVar.fUS) + "</sourcedisplayname>");
                stringBuilder.append("<commenturl>" + bg.PW(aVar.gxD) + "</commenturl>");
            }
            stringBuilder.append("<thumburl>" + bg.PW(aVar.thumburl) + "</thumburl>");
            stringBuilder.append("<mediatagname>" + bg.PW(aVar.mediaTagName) + "</mediatagname>");
            stringBuilder.append("<messageaction>" + el(bg.PW(aVar.messageAction)) + "</messageaction>");
            stringBuilder.append("<messageext>" + el(bg.PW(aVar.messageExt)) + "</messageext>");
            stringBuilder.append("<emoticongift>");
            stringBuilder.append("<packageflag>" + aVar.hhO + "</packageflag>");
            stringBuilder.append("<packageid>" + bg.PW(aVar.hhN) + "</packageid>");
            stringBuilder.append("</emoticongift>");
            stringBuilder.append("<emoticonshared>");
            stringBuilder.append("<packageflag>" + aVar.hhU + "</packageflag>");
            stringBuilder.append("<packageid>" + bg.PW(aVar.hhT) + "</packageid>");
            stringBuilder.append("</emoticonshared>");
            stringBuilder.append("<designershared>");
            stringBuilder.append("<designeruin>" + aVar.hjA + "</designeruin>");
            stringBuilder.append("<designername>" + aVar.designerName + "</designername>");
            stringBuilder.append("<designerrediretcturl>" + aVar.designerRediretctUrl + "</designerrediretcturl>");
            stringBuilder.append("</designershared>");
            stringBuilder.append("<emotionpageshared>");
            stringBuilder.append("<tid>" + aVar.tid + "</tid>");
            stringBuilder.append("<title>" + aVar.hjB + "</title>");
            stringBuilder.append("<desc>" + aVar.desc + "</desc>");
            stringBuilder.append("<iconUrl>" + aVar.iconUrl + "</iconUrl>");
            stringBuilder.append("<secondUrl>" + aVar.secondUrl + "</secondUrl>");
            stringBuilder.append("<pageType>" + aVar.pageType + "</pageType>");
            stringBuilder.append("</emotionpageshared>");
            stringBuilder.append("<webviewshared>");
            stringBuilder.append("<shareUrlOriginal>" + bg.PW(aVar.fUU) + "</shareUrlOriginal>");
            stringBuilder.append("<shareUrlOpen>" + bg.PW(aVar.fUV) + "</shareUrlOpen>");
            stringBuilder.append("<jsAppId>" + bg.PW(aVar.fUW) + "</jsAppId>");
            stringBuilder.append("<publisherId>" + bg.PW(aVar.fUX) + "</publisherId>");
            stringBuilder.append("</webviewshared>");
            stringBuilder.append("<template_id>" + bg.PW(aVar.hir) + "</template_id>");
            w.i("MicroMsg.AppMessage", "summerbig makecontent content md5[%s]", aVar.filemd5);
            stringBuilder.append("<md5>" + bg.PW(aVar.filemd5) + "</md5>");
            Iterator it = b.hkk.iterator();
            while (it.hasNext()) {
                c cVar = (c) ((com.tencent.mm.bn.b) it.next()).get();
                c n = aVar.n(cVar.getClass());
                if (n != null) {
                    cVar = n;
                }
                cVar.a(stringBuilder, aVar, str, com_tencent_mm_modelcdntran_keep_SceneResult, i, i2);
            }
        }

        public final void a(f fVar) {
            fVar.field_appId = this.appId;
            fVar.field_title = this.title;
            fVar.field_description = this.description;
            fVar.field_type = this.type;
            fVar.field_source = this.appName;
        }

        public static String el(String str) {
            return "<![CDATA[" + str + "]]>";
        }

        public final String getTitle() {
            if (this.hhn == null || this.hhn.hkf == 0) {
                return this.title;
            }
            return this.hhn.title;
        }

        public final String getDescription() {
            if (this.hhn == null || this.hhn.hkg == 0) {
                return this.description;
            }
            return this.hhn.desc;
        }
    }

    static {
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.hXH = new Field[7];
        aVar.columns = new String[8];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "msgId";
        aVar.uxd.put("msgId", "LONG default '0'  PRIMARY KEY ");
        stringBuilder.append(" msgId LONG default '0'  PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = "msgId";
        aVar.columns[1] = "xml";
        aVar.uxd.put("xml", "TEXT");
        stringBuilder.append(" xml TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "appId";
        aVar.uxd.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "title";
        aVar.uxd.put("title", "TEXT");
        stringBuilder.append(" title TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "description";
        aVar.uxd.put("description", "TEXT");
        stringBuilder.append(" description TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "source";
        aVar.uxd.put("source", "TEXT");
        stringBuilder.append(" source TEXT");
        stringBuilder.append(", ");
        aVar.columns[6] = Columns.TYPE;
        aVar.uxd.put(Columns.TYPE, "INTEGER");
        stringBuilder.append(" type INTEGER");
        aVar.columns[7] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
        if (com.tencent.mm.sdk.a.b.bIu()) {
            Assert.assertTrue(wE());
        }
    }

    protected final com.tencent.mm.sdk.e.c.a sY() {
        return gTP;
    }

    private static final boolean wE() {
        Field[] declaredFields = a.class.getDeclaredFields();
        int i = 0;
        for (Field modifiers : declaredFields) {
            if (!Modifier.isStatic(modifiers.getModifiers())) {
                i++;
            }
        }
        if (i > 185) {
            w.e("MicroMsg.AppMessage", "AppMessage.Content should not add new field!!! (%d) is over the limit(%d)!!!", Integer.valueOf(i), Integer.valueOf(185));
            return false;
        }
        w.i("MicroMsg.AppMessage", "AppMessage.Content nonStaticFieldCount: %d", Integer.valueOf(i));
        return true;
    }
}
