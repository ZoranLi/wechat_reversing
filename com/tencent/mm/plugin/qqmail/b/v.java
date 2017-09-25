package com.tencent.mm.plugin.qqmail.b;

import android.util.Base64;
import com.tencent.mm.protocal.c.bhm;
import com.tencent.mm.protocal.c.kk;
import com.tencent.mm.protocal.c.ml;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.k;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

public final class v implements com.tencent.mm.y.e {
    String fOu;
    public e oAE = null;
    String oAG;
    Map<String, String> oAH = new HashMap();
    Map<String, String> oAI = new LinkedHashMap();
    Map<String, String> oAJ = new LinkedHashMap();
    private b oAK;
    public t oAL;
    public Map<String, String> oAM = new HashMap();
    public f oAN = null;
    HashMap<Long, Integer> oAO = new HashMap();
    HashMap<Long, String> oAP = new HashMap();
    HashMap<String, Integer> oAQ = new HashMap();
    int oAR = 0;
    public ArrayList<g> oAS = new ArrayList();
    public String oAT = null;
    public String oAU = null;
    public HashMap<String, String> oAV = new HashMap();
    public c oAW;
    public d oAX;
    int oAY = 0;
    com.tencent.mm.y.f oAZ = new com.tencent.mm.y.f(this) {
        final /* synthetic */ v oBa;

        {
            this.oBa = r1;
        }

        public final void a(int i, int i2, k kVar) {
            w.i("MicroMsg.ShareModeMailAppService", "currentSendFile: %s, offset: %d, totalLen: %d, filesInfo.size: %d", new Object[]{this.oBa.oAT, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(this.oBa.oAS.size())});
            if (i >= i2) {
                this.oBa.oAV.put(this.oBa.oAU, ((o) kVar).aUs().tsQ);
                bhm aUs = ((o) kVar).aUs();
                if (this.oBa.oAX != null) {
                    this.oBa.oAX.c(this.oBa.oAY - this.oBa.oAS.size(), this.oBa.oAY, this.oBa.oAU, aUs.tsQ);
                }
                if (this.oBa.oAS.isEmpty()) {
                    w.i("MicroMsg.ShareModeMailAppService", "finished send all files");
                    if (this.oBa.oAW != null) {
                        this.oBa.oAW.aUw();
                        return;
                    }
                    return;
                }
                w.i("MicroMsg.ShareModeMailAppService", "finished send one file, continue to send another one");
                g gVar = (g) this.oBa.oAS.remove(0);
                this.oBa.oAT = gVar.fOx;
                this.oBa.oAU = gVar.fyF;
                ap.vd().a(new o(this.oBa.oAU, this.oBa.oAT, this), 0);
            }
        }
    };
    String[] ozT;
    String[] ozU;
    String[] ozV;
    public String ozq;

    class AnonymousClass1 implements Runnable {
        final /* synthetic */ int hyy = 100;
        final /* synthetic */ int iUx;
        final /* synthetic */ v oBa;

        AnonymousClass1(v vVar, int i, int i2) {
            this.oBa = vVar;
            this.iUx = i;
        }

        public final void run() {
            this.oBa.oAN.G(this.oBa.ozq, this.iUx, this.hyy);
        }
    }

    interface a {
        void aUx();
    }

    public interface b {
        void a(ArrayList<Long> arrayList, HashMap<Long, String> hashMap);
    }

    public interface c {
        void aUw();
    }

    public interface d {
        void c(int i, int i2, String str, String str2);
    }

    public interface e {
        void CU(String str);
    }

    public interface f {
        void G(String str, int i, int i2);
    }

    public static class g {
        public String fOx;
        public String fyF;

        public g(String str, String str2) {
            this.fOx = str;
            this.fyF = str2;
        }
    }

    public v() {
        ap.vd().a(483, this);
        ap.vd().a(484, this);
        ap.vd().a(485, this);
    }

    public final void rC(int i) {
        if (this.oAN != null) {
            af.v(new AnonymousClass1(this, i, 100));
        }
    }

    public final void a(f fVar, e eVar) {
        this.oAN = fVar;
        this.oAE = eVar;
        if (this.oAH.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str : this.oAH.keySet()) {
                w.i("MicroMsg.ShareModeMailAppService", "check img status, msgSvrId: %s", new Object[]{str});
                arrayList.add(Long.valueOf(bg.getLong(str, 0)));
            }
            b anonymousClass2 = new b(this) {
                final /* synthetic */ v oBa;

                {
                    this.oBa = r1;
                }

                public final void a(ArrayList<Long> arrayList, HashMap<Long, String> hashMap) {
                    v vVar;
                    w.i("MicroMsg.ShareModeMailAppService", "finishChckImgStatus, notUploadedImgIdList.size: %d, attachIdMap.size: %d", new Object[]{Integer.valueOf(arrayList.size()), Integer.valueOf(hashMap.size())});
                    if (arrayList.size() > 0) {
                        vVar = this.oBa;
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            String str = (String) vVar.oAH.get(String.valueOf((Long) it.next()));
                            w.i("MicroMsg.ShareModeMailAppService", "appendAllUndownloadImage, filePath: %s", new Object[]{str});
                            if (!bg.mA(str)) {
                                if (vVar.oAS == null) {
                                    vVar.oAS = new ArrayList();
                                }
                                vVar.oAS.add(new g(str, str));
                            }
                        }
                    }
                    if (hashMap.size() > 0) {
                        this.oBa.f(hashMap);
                    }
                    this.oBa.rC(10);
                    vVar = this.oBa;
                    w.i("MicroMsg.ShareModeMailAppService", "uploadMsgImg, filesInfo.size = %d", new Object[]{Integer.valueOf(vVar.oAS.size())});
                    if (vVar.oAS == null) {
                        vVar.oAS = new ArrayList();
                    }
                    if (vVar.oAS.size() > 0) {
                        c anonymousClass3 = new c(vVar) {
                            final /* synthetic */ v oBa;

                            {
                                this.oBa = r1;
                            }

                            public final void aUw() {
                                w.d("MicroMsg.ShareModeMailAppService", "uploadMsgImg, finshed upload all msg img");
                                this.oBa.rC(90);
                                v vVar = this.oBa;
                                if (vVar.oAS != null && vVar.oAS.size() > 0) {
                                    vVar.oAS.clear();
                                }
                                this.oBa.aUv();
                            }
                        };
                        d anonymousClass4 = new d(vVar) {
                            final /* synthetic */ v oBa;

                            {
                                this.oBa = r1;
                            }

                            public final void c(int i, int i2, String str, String str2) {
                                w.d("MicroMsg.ShareModeMailAppService", "finishedSendOneFile, currentFileCount: %d, totalFileNum: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                                this.oBa.oAM.put(str, str2);
                                this.oBa.rC((int) (10.0f + (80.0f * (((float) i) / ((float) i2)))));
                            }
                        };
                        w.i("MicroMsg.ShareModeMailAppService", "uploadFile, filesInfo.size: %d", new Object[]{Integer.valueOf(vVar.oAS.size())});
                        vVar.oAW = anonymousClass3;
                        vVar.oAX = anonymousClass4;
                        vVar.oAY = vVar.oAS.size();
                        if (vVar.oAS != null && vVar.oAS.size() > 0) {
                            g gVar = (g) vVar.oAS.remove(0);
                            vVar.oAT = gVar.fOx;
                            vVar.oAU = gVar.fyF;
                            vVar.oAV = new HashMap();
                            ap.vd().a(new o(vVar.oAU, vVar.oAT, vVar.oAZ), 0);
                            return;
                        }
                        return;
                    }
                    vVar.rC(90);
                    vVar.aUv();
                }
            };
            w.i("MicroMsg.ShareModeMailAppService", "checkImgStatus");
            this.oAR = 0;
            N(arrayList);
            if (this.oAP != null) {
                this.oAP.clear();
                this.oAP = null;
            }
            this.oAP = new HashMap();
            this.oAK = anonymousClass2;
            ap.vd().a(new l(arrayList), 0);
            return;
        }
        rC(90);
        aUv();
    }

    public final void aUv() {
        int i;
        int i2;
        com.tencent.mm.plugin.qqmail.b.k.a[] aVarArr;
        int i3;
        StringBuilder stringBuilder;
        String stringBuilder2;
        int i4 = 0;
        com.tencent.mm.plugin.qqmail.b.k.a[] aVarArr2 = null;
        if (this.oAI != null && this.oAI.size() > 0) {
            com.tencent.mm.plugin.qqmail.b.k.a[] aVarArr3 = new com.tencent.mm.plugin.qqmail.b.k.a[this.oAI.size()];
            int i5 = 0;
            i = 0;
            for (String str : this.oAI.keySet()) {
                com.tencent.mm.plugin.qqmail.b.k.a aVar = new com.tencent.mm.plugin.qqmail.b.k.a();
                aVar.ozZ = (String) this.oAI.get(str);
                aVar.fyF = str;
                aVar.name = (String) this.oAJ.get(str);
                aVar.fileSize = com.tencent.mm.a.e.aN(str);
                aVarArr3[i] = aVar;
                w.i("MicroMsg.ShareModeMailAppService", "fileInfos[%d], attachId: %s, fileName: %s, name: %s, fileSize: %d", new Object[]{Integer.valueOf(i), aVar.ozZ, aVar.fyF, aVar.name, Integer.valueOf(aVar.fileSize)});
                i5 = aVar.fileSize + i5;
                i++;
            }
            i4 = i5;
            aVarArr2 = aVarArr3;
        }
        if (this.oAM == null || this.oAM.size() <= 0) {
            i2 = i4;
            aVarArr = null;
        } else {
            com.tencent.mm.plugin.qqmail.b.k.a[] aVarArr4 = new com.tencent.mm.plugin.qqmail.b.k.a[this.oAM.size()];
            i = i4;
            i3 = 0;
            for (String str2 : this.oAM.keySet()) {
                com.tencent.mm.plugin.qqmail.b.k.a aVar2 = new com.tencent.mm.plugin.qqmail.b.k.a();
                aVar2.ozZ = (String) this.oAM.get(str2);
                aVar2.fyF = str2;
                aVar2.fileSize = bg.a((Integer) this.oAQ.get(aVar2.ozZ), 0);
                if (aVar2.fileSize == 0) {
                    aVar2.fileSize = com.tencent.mm.a.e.aN(str2);
                }
                aVarArr4[i3] = aVar2;
                w.i("MicroMsg.ShareModeMailAppService", "imagesFileInfos[%d], attachId: %s, fileName: %s, fileSize: %d", new Object[]{Integer.valueOf(i3), aVar2.ozZ, aVar2.fyF, Integer.valueOf(aVar2.fileSize)});
                i = aVar2.fileSize + i;
                i3++;
            }
            aVarArr = aVarArr4;
            i2 = i;
        }
        w.i("MicroMsg.ShareModeMailAppService", "totalFileSize = %d", new Object[]{Integer.valueOf(i2)});
        com.tencent.mm.plugin.qqmail.b.k.a[] aVarArr5 = (aVarArr == null || aVarArr.length == 0) ? null : aVarArr;
        com.tencent.mm.plugin.qqmail.b.k.a[] aVarArr6 = (aVarArr2 == null || aVarArr2.length == 0) ? null : aVarArr2;
        final a anonymousClass5 = new a(this) {
            final /* synthetic */ v oBa;

            {
                this.oBa = r1;
            }

            public final void aUx() {
                this.oBa.rC(100);
            }
        };
        k kVar = new k(this.fOu, this.ozT, this.ozU, this.ozV, this.ozq);
        kVar.ozW = this.oAG;
        if (aVarArr6 == null || aVarArr6.length <= 0) {
            kVar.ozY = null;
        } else {
            kVar.ozY = new com.tencent.mm.plugin.qqmail.b.k.a[aVarArr6.length];
            int i6;
            for (i6 = 0; i6 < kVar.ozY.length; i6++) {
                kVar.ozY[i6] = aVarArr6[i6];
            }
            w.i("MicroMsg.MailContentFormatter", "setFileInfo, fileInfos.length = %d", new Object[]{Integer.valueOf(kVar.ozY.length)});
        }
        if (aVarArr5 == null || aVarArr5.length <= 0) {
            kVar.ozX = null;
        } else {
            kVar.ozX = aVarArr5;
        }
        StringBuilder stringBuilder3 = new StringBuilder("");
        StringBuilder stringBuilder4 = new StringBuilder("");
        if (kVar.fOu != null) {
            stringBuilder = new StringBuilder("");
            stringBuilder.append("From: ");
            stringBuilder.append("\"");
            stringBuilder.append("=?utf-8?B?");
            stringBuilder.append(Base64.encodeToString(kVar.fOu.getBytes(), 2));
            stringBuilder.append("?=");
            stringBuilder.append("\"");
            stringBuilder.append(" ");
            stringBuilder.append("<");
            stringBuilder.append(kVar.fOu);
            stringBuilder.append(">");
            stringBuilder2 = stringBuilder.toString();
        } else {
            stringBuilder2 = null;
        }
        if (stringBuilder2 != null) {
            stringBuilder4.append(stringBuilder2);
            stringBuilder4.append("\n");
        }
        stringBuilder2 = kVar.aUp();
        if (stringBuilder2 != null) {
            stringBuilder4.append(stringBuilder2);
            stringBuilder4.append("\n");
        }
        stringBuilder2 = kVar.aUq();
        if (stringBuilder2 != null) {
            stringBuilder4.append(stringBuilder2);
            stringBuilder4.append("\n");
        }
        stringBuilder2 = kVar.aUr();
        if (stringBuilder2 != null) {
            stringBuilder4.append(stringBuilder2);
            stringBuilder4.append("\n");
        }
        stringBuilder4.append("Subject: ");
        if (kVar.ozq != null) {
            stringBuilder4.append(kVar.ozq);
        }
        stringBuilder4.append("\n");
        stringBuilder4.append("Mime-Version: 1.0");
        stringBuilder4.append("\n");
        stringBuilder4.append("Content-Type: multipart/mixed;boundary=\"----=_NextPart_5208D22F_0929AFA8_5112E4AB\"");
        stringBuilder4.append("\n");
        stringBuilder4.append("Content-Transfer-Encoding: 8Bit");
        stringBuilder4.append("\n");
        stringBuilder4.append("Date: " + new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z", new Locale("en")).format(new Date()));
        stringBuilder4.append("\n");
        stringBuilder4.append("X-QQ-MIME: TCMime 1.0 by Tencent");
        stringBuilder4.append("\n");
        stringBuilder4.append("X-Mailer: QQMail 2.x");
        stringBuilder4.append("\n");
        stringBuilder4.append("X-QQ-Mailer: QQMail 2.x");
        stringBuilder4.append("\n");
        stringBuilder3.append(stringBuilder4.toString());
        stringBuilder3.append("\r\n");
        stringBuilder3.append("This is a multi-part message in MIME format.");
        stringBuilder3.append("\n");
        stringBuilder3.append("\r\n");
        stringBuilder = new StringBuilder("");
        stringBuilder.append("------=_NextPart_5208D22F_0929AFA8_5112E4AB");
        stringBuilder.append("\n");
        stringBuilder.append("Content-Type:text/html;charset=\"utf-8\"");
        stringBuilder.append("\n");
        stringBuilder.append("Content-Transfer-Encoding:base64");
        stringBuilder.append("\n");
        stringBuilder.append("\r\n");
        stringBuilder.append(Base64.encodeToString(kVar.ozW.getBytes(), 0));
        stringBuilder.append("\n");
        stringBuilder3.append(stringBuilder.toString());
        stringBuilder3.append("\r\n");
        if (kVar.ozX != null && kVar.ozX.length > 0) {
            for (com.tencent.mm.plugin.qqmail.b.k.a aVar3 : kVar.ozX) {
                String str3 = aVar3.ozZ;
                String str4 = aVar3.fyF;
                int i7 = aVar3.fileSize;
                StringBuilder stringBuilder5 = new StringBuilder("");
                stringBuilder5.append("------=_NextPart_5208D22F_0929AFA8_5112E4AB");
                stringBuilder5.append("\n");
                stringBuilder5.append(String.format("Content-Type:image/jpeg;name=\"%s\"", new Object[]{str4}));
                stringBuilder5.append("\n");
                stringBuilder5.append("Content-Transfer-Encoding:base64");
                stringBuilder5.append("\n");
                stringBuilder5.append(String.format("Content-ID:<%s>", new Object[]{str4}));
                stringBuilder5.append("\n");
                stringBuilder5.append("\r\n");
                stringBuilder5.append(String.format("QQMail-LinkID:%s", new Object[]{str3}));
                stringBuilder5.append("\n");
                stringBuilder5.append(String.format("QQMail-LinkSize:%d", new Object[]{Integer.valueOf(i7)}));
                stringBuilder5.append("\n");
                stringBuilder5.append("QQMail-LineLen:72");
                stringBuilder5.append("\n");
                stringBuilder5.append("QQMail-BreakType:1");
                stringBuilder5.append("\n");
                stringBuilder5.append(String.format("QQMail-Key:%s", new Object[]{k.CR(str3)}));
                stringBuilder5.append("\n");
                stringBuilder5.append("QQMail-LinkEnd");
                stringBuilder5.append("\n");
                stringBuilder3.append(stringBuilder5.toString());
                stringBuilder3.append("\r\n");
            }
        }
        stringBuilder3.append("\r\n");
        if (kVar.ozY != null && kVar.ozY.length > 0) {
            for (com.tencent.mm.plugin.qqmail.b.k.a aVar4 : kVar.ozY) {
                String str5 = aVar4.ozZ;
                int i8 = aVar4.fileSize;
                String str6 = aVar4.name;
                StringBuilder stringBuilder6 = new StringBuilder("");
                stringBuilder6.append("------=_NextPart_5208D22F_0929AFA8_5112E4AB");
                stringBuilder6.append("\n");
                stringBuilder6.append(String.format("Content-Type:application/octet-stream;charset=\"utf-8\";name=\"=?utf-8?B?%s?=\"", new Object[]{Base64.encodeToString(str6.getBytes(), 2)}));
                stringBuilder6.append("\n");
                stringBuilder6.append(String.format("Content-Disposition: attachment; filename=\"=?utf-8?B?%s?=\"", new Object[]{Base64.encodeToString(str6.getBytes(), 2)}));
                stringBuilder6.append("\n");
                stringBuilder6.append("Content-Transfer-Encoding:base64");
                stringBuilder6.append("\n");
                stringBuilder6.append(String.format("Content-ID:<%s>", new Object[]{Long.valueOf(System.currentTimeMillis())}));
                stringBuilder6.append("\n");
                stringBuilder6.append("\r\n");
                stringBuilder6.append(String.format("QQMail-LinkID:%s", new Object[]{str5}));
                stringBuilder6.append("\n");
                stringBuilder6.append(String.format("QQMail-LinkSize:%d", new Object[]{Integer.valueOf(i8)}));
                stringBuilder6.append("\n");
                stringBuilder6.append("QQMail-LineLen:72");
                stringBuilder6.append("\n");
                stringBuilder6.append("QQMail-BreakType:1");
                stringBuilder6.append("\n");
                stringBuilder6.append(String.format("QQMail-Key:%s", new Object[]{k.CR(str5)}));
                stringBuilder6.append("\n");
                stringBuilder6.append("QQMail-LinkEnd");
                stringBuilder6.append("\n");
                stringBuilder3.append(stringBuilder6.toString());
                stringBuilder3.append("\r\n");
            }
        }
        stringBuilder3.append("------=_NextPart_5208D22F_0929AFA8_5112E4AB--");
        ap.vd().a(new m(stringBuilder3.toString(), this.fOu, this.ozT, i2, new com.tencent.mm.y.f(this) {
            final /* synthetic */ v oBa;

            public final void a(int i, int i2, k kVar) {
                w.i("MicroMsg.ShareModeMailAppService", "composeSend, offset: %d, totalLen: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                if (i >= i2) {
                    w.i("MicroMsg.ShareModeMailAppService", "finish send");
                    if (anonymousClass5 != null) {
                        anonymousClass5.aUx();
                    }
                }
            }
        }), 0);
    }

    public final void f(HashMap<Long, String> hashMap) {
        if (this.oAM == null) {
            this.oAM = new HashMap();
        }
        for (Long l : hashMap.keySet()) {
            String str = (String) hashMap.get(l);
            String str2 = (String) this.oAH.get(String.valueOf(l));
            w.i("MicroMsg.ShareModeMailAppService", "appendDownloadImgToAttachIdMap, filePath: %s, attachId: %s", new Object[]{str2, str});
            if (!bg.mA(str2)) {
                this.oAM.put(str2, str);
            }
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.ShareModeMailAppService", "onSceneEnd, errType: %d, errCode: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i != 0 || i2 != 0) {
            w.e("MicroMsg.ShareModeMailAppService", "errType = %d, errCode = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            if (kVar.getType() == 483) {
                a((l) kVar);
            } else if (this.oAE != null) {
                af.v(new Runnable(this) {
                    final /* synthetic */ v oBa;

                    {
                        this.oBa = r1;
                    }

                    public final void run() {
                        this.oBa.oAE.CU(this.oBa.ozq);
                    }
                });
            }
        } else if (kVar.getType() == 483) {
            a((l) kVar);
        } else if (kVar.getType() != 484) {
            kVar.getType();
        }
    }

    private void N(ArrayList<Long> arrayList) {
        if (this.oAO != null) {
            this.oAO.clear();
            this.oAO = null;
        }
        this.oAO = new HashMap();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.oAO.put(Long.valueOf(((Long) it.next()).longValue()), Integer.valueOf(1));
        }
    }

    private static ArrayList<Long> g(HashMap<Long, Integer> hashMap) {
        ArrayList<Long> arrayList = new ArrayList();
        for (Long add : hashMap.keySet()) {
            arrayList.add(add);
        }
        return arrayList;
    }

    private void a(l lVar) {
        this.oAR++;
        w.i("MicroMsg.ShareModeMailAppService", "processCheckImgStatusSceneEnd, checkTimes: %d", new Object[]{Integer.valueOf(this.oAR)});
        Iterator it = ((kk) lVar.gUA.hsk.hsr).tqA.iterator();
        while (it.hasNext()) {
            ml mlVar = (ml) it.next();
            long j = (long) mlVar.tfc;
            int i = mlVar.jNB;
            if (this.oAO.containsKey(Long.valueOf(j))) {
                w.i("MicroMsg.ShareModeMailAppService", "msgSvrId: %d, status: %d", new Object[]{Long.valueOf(j), Integer.valueOf(i)});
                if (i == 0) {
                    this.oAO.remove(Long.valueOf(j));
                    if (mlVar.tsQ != null) {
                        w.i("MicroMsg.ShareModeMailAppService", "msgSvrId: %d, attachId: %s", new Object[]{Long.valueOf(j), mlVar.tsQ});
                        this.oAP.put(Long.valueOf(j), mlVar.tsQ);
                        this.oAQ.put(mlVar.tsQ, Integer.valueOf(mlVar.tsR));
                    }
                } else {
                    this.oAO.put(Long.valueOf(j), Integer.valueOf(i));
                }
            }
        }
        if (this.oAO.isEmpty()) {
            w.i("MicroMsg.ShareModeMailAppService", "all image is in server");
            if (this.oAK != null) {
                this.oAK.a(new ArrayList(), this.oAP);
            }
        } else if (this.oAR < 3) {
            w.i("MicroMsg.ShareModeMailAppService", "checkTime small than limit, doScene again");
            ap.vd().a(new l(g(this.oAO)), 0);
        } else {
            this.oAK.a(g(this.oAO), this.oAP);
        }
    }
}
