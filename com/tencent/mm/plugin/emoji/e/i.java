package com.tencent.mm.plugin.emoji.e;

import com.tencent.mm.ap.d;
import com.tencent.mm.ap.f;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.e.a.bb;
import com.tencent.mm.e.a.ch;
import com.tencent.mm.kernel.h;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.a.s;
import com.tencent.mm.storage.a.u;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Map;
import javax.xml.parsers.DocumentBuilderFactory;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class i {
    private static String kKa = "";
    private static String kKb = "temp";
    public static String kKc = "newemoji";
    public static String kKd = "panel";
    public static String kKe = "suggest";
    public static String kKf = "egg";
    private static String kKg = "search";
    private static String kKh = "config.conf";
    private static String kKi = "emojipanel.zip";
    private static String kKj = "newemoji.zip";
    private static String kKk = "emoji_template.zip";
    private static String kKl = "emojisuggest.zip";
    private static String kKm = "egg.zip";
    public static String kKn = "newemoji-config.xml";
    public static String kKo = "emojipanel-config.xml";
    public static String kKp = "emojisuggest-config.xml";
    public static String kKq = "egg.xml";
    private static int kKr = 0;
    private static int kKs = 0;
    private static int kKt = 0;
    private static int kKu = 0;
    private static i kKv;
    public f kKw;

    public enum a {
        EMOJI,
        PANEL,
        SUGGEST,
        SEARCH,
        EGG
    }

    public static i alH() {
        if (kKv == null) {
            synchronized (i.class) {
                kKv = new i();
            }
        }
        return kKv;
    }

    public static String alI() {
        if (bg.mA(kKa)) {
            kKa = e.hgr.replace("/data/user/0", "/data/data");
            kKa += "/emoji";
        }
        return kKa;
    }

    public static boolean a(bb bbVar, a aVar, String str) {
        File file = new File(bbVar.fEA.filePath);
        if (!file.exists() || file.length() <= 0) {
            w.i("MicroMsg.emoji.EmojiResUpdateMgr", "copyAndUnzipFile update file don't exist.");
            return false;
        }
        String str2;
        long currentTimeMillis = System.currentTimeMillis();
        w.i("MicroMsg.emoji.EmojiResUpdateMgr", "copyAndUnzipFile start. type:%s filePath:%s", new Object[]{String.valueOf(aVar), file.getAbsolutePath()});
        File file2 = new File(alI(), str);
        if (file2.exists()) {
            com.tencent.mm.a.e.d(file2);
        }
        switch (aVar) {
            case EMOJI:
                str2 = kKj;
                break;
            case PANEL:
                str2 = kKi;
                break;
            case SEARCH:
                str2 = kKk;
                break;
            case SUGGEST:
                str2 = kKl;
                break;
            case EGG:
                str2 = kKm;
                break;
            default:
                w.w("MicroMsg.emoji.EmojiResUpdateMgr", "unknown type. type:%s", new Object[]{String.valueOf(aVar)});
                str2 = "";
                break;
        }
        File file3 = new File(file2, str2);
        file2.mkdirs();
        com.tencent.mm.a.e.p(file.getAbsolutePath(), file3.getAbsolutePath());
        int eA = bg.eA(file3.getAbsolutePath(), file2.getAbsolutePath());
        b.deleteFile(file3.getPath());
        w.d("MicroMsg.emoji.EmojiResUpdateMgr", "copyAndUnzipFile done. user time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        if (eA >= 0) {
            return true;
        }
        return false;
    }

    private static int r(File file) {
        InputStream fileInputStream;
        Throwable e;
        Reader reader;
        InputStream inputStream;
        Throwable th;
        Reader reader2 = null;
        long currentTimeMillis = System.currentTimeMillis();
        int i = -1;
        if (file.exists()) {
            Reader inputStreamReader;
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    inputStreamReader = new InputStreamReader(fileInputStream);
                } catch (Exception e2) {
                    e = e2;
                    reader = null;
                    inputStream = fileInputStream;
                    try {
                        w.e("MicroMsg.emoji.EmojiResUpdateMgr", bg.g(e));
                        com.tencent.mm.a.e.b(inputStream);
                        com.tencent.mm.a.e.a(reader2);
                        com.tencent.mm.a.e.a(reader);
                        w.i("MicroMsg.emoji.EmojiResUpdateMgr", "readLocalVersion done.use time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                        return i;
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = inputStream;
                        inputStreamReader = reader2;
                        com.tencent.mm.a.e.b(fileInputStream);
                        com.tencent.mm.a.e.a(inputStreamReader);
                        com.tencent.mm.a.e.a(reader);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    reader = null;
                    inputStreamReader = null;
                    com.tencent.mm.a.e.b(fileInputStream);
                    com.tencent.mm.a.e.a(inputStreamReader);
                    com.tencent.mm.a.e.a(reader);
                    throw th;
                }
                try {
                    reader = new BufferedReader(inputStreamReader);
                    try {
                        String str = "";
                        while (true) {
                            String readLine = reader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            str = str + readLine;
                        }
                        i = new JSONObject(str).getInt("version");
                        w.d("MicroMsg.emoji.EmojiResUpdateMgr", "readVersionCode config file content:%s version:%d", new Object[]{str, Integer.valueOf(i)});
                        com.tencent.mm.a.e.b(fileInputStream);
                        com.tencent.mm.a.e.a(inputStreamReader);
                        com.tencent.mm.a.e.a(reader);
                    } catch (Exception e3) {
                        e = e3;
                        reader2 = inputStreamReader;
                        inputStream = fileInputStream;
                        w.e("MicroMsg.emoji.EmojiResUpdateMgr", bg.g(e));
                        com.tencent.mm.a.e.b(inputStream);
                        com.tencent.mm.a.e.a(reader2);
                        com.tencent.mm.a.e.a(reader);
                        w.i("MicroMsg.emoji.EmojiResUpdateMgr", "readLocalVersion done.use time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                        return i;
                    } catch (Throwable th4) {
                        th = th4;
                        com.tencent.mm.a.e.b(fileInputStream);
                        com.tencent.mm.a.e.a(inputStreamReader);
                        com.tencent.mm.a.e.a(reader);
                        throw th;
                    }
                } catch (Exception e4) {
                    e = e4;
                    reader = null;
                    reader2 = inputStreamReader;
                    inputStream = fileInputStream;
                    w.e("MicroMsg.emoji.EmojiResUpdateMgr", bg.g(e));
                    com.tencent.mm.a.e.b(inputStream);
                    com.tencent.mm.a.e.a(reader2);
                    com.tencent.mm.a.e.a(reader);
                    w.i("MicroMsg.emoji.EmojiResUpdateMgr", "readLocalVersion done.use time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                    return i;
                } catch (Throwable th5) {
                    th = th5;
                    reader = null;
                    com.tencent.mm.a.e.b(fileInputStream);
                    com.tencent.mm.a.e.a(inputStreamReader);
                    com.tencent.mm.a.e.a(reader);
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
                reader = null;
                inputStream = null;
                w.e("MicroMsg.emoji.EmojiResUpdateMgr", bg.g(e));
                com.tencent.mm.a.e.b(inputStream);
                com.tencent.mm.a.e.a(reader2);
                com.tencent.mm.a.e.a(reader);
                w.i("MicroMsg.emoji.EmojiResUpdateMgr", "readLocalVersion done.use time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                return i;
            } catch (Throwable th6) {
                th = th6;
                reader = null;
                inputStreamReader = null;
                fileInputStream = null;
                com.tencent.mm.a.e.b(fileInputStream);
                com.tencent.mm.a.e.a(inputStreamReader);
                com.tencent.mm.a.e.a(reader);
                throw th;
            }
        }
        w.i("MicroMsg.emoji.EmojiResUpdateMgr", "readLocalVersion file don't exist. path:%s", new Object[]{file.getAbsolutePath()});
        w.i("MicroMsg.emoji.EmojiResUpdateMgr", "readLocalVersion done.use time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        return i;
    }

    public final boolean a(bb bbVar, a aVar) {
        int r;
        int intValue;
        if (a(bbVar, aVar, kKb)) {
            File file = new File(alI(), kKb);
            w.d("MicroMsg.emoji.EmojiResUpdateMgr", "readVersionCode unzip file done.");
            r = r(new File(file, kKh));
        } else {
            w.i("MicroMsg.emoji.EmojiResUpdateMgr", "unzip file failed. type:%s", new Object[]{String.valueOf(aVar)});
            r = -1;
        }
        switch (aVar) {
            case EMOJI:
                ap.yY();
                intValue = ((Integer) c.vr().get(com.tencent.mm.storage.w.a.uzV, Integer.valueOf(0))).intValue();
                kKr = intValue;
                break;
            case PANEL:
                ap.yY();
                intValue = ((Integer) c.vr().get(com.tencent.mm.storage.w.a.uzW, Integer.valueOf(0))).intValue();
                kKs = intValue;
                break;
            case SEARCH:
                intValue = com.tencent.mm.ac.a.hAa;
                break;
            case SUGGEST:
                ap.yY();
                intValue = ((Integer) c.vr().get(com.tencent.mm.storage.w.a.uzX, Integer.valueOf(0))).intValue();
                kKt = intValue;
                break;
            case EGG:
                ap.yY();
                intValue = ((Integer) c.vr().get(com.tencent.mm.storage.w.a.uzY, Integer.valueOf(0))).intValue();
                kKu = intValue;
                break;
            default:
                intValue = -1;
                break;
        }
        w.i("MicroMsg.emoji.EmojiResUpdateMgr", "file version:%d, current version:%d", new Object[]{Integer.valueOf(r), Integer.valueOf(intValue)});
        if (r == -1 || intValue >= r) {
            return false;
        }
        return true;
    }

    public static boolean alJ() {
        ap.yY();
        String str = (String) c.vr().get(com.tencent.mm.storage.w.a.uzZ, kKo);
        String alP = n.alP();
        if (bg.mA(alP) || str.equalsIgnoreCase(alP)) {
            return false;
        }
        return true;
    }

    public static void s(File file) {
        Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
        parse.normalize();
        NodeList elementsByTagName = parse.getDocumentElement().getElementsByTagName("emoji");
        if (elementsByTagName != null && elementsByTagName.getLength() > 0) {
            ArrayList arrayList = new ArrayList();
            int length = elementsByTagName.getLength();
            for (int i = 0; i < length; i++) {
                NodeList childNodes = elementsByTagName.item(i).getChildNodes();
                if (childNodes != null && childNodes.getLength() > 0) {
                    s sVar = new s();
                    for (int i2 = 0; i2 < childNodes.getLength(); i2++) {
                        Node item = childNodes.item(i2);
                        String nodeName = item.getNodeName();
                        if (nodeName.equalsIgnoreCase("key")) {
                            sVar.field_key = item.getTextContent();
                        } else if (nodeName.equalsIgnoreCase("cn-value")) {
                            if (bg.mA(item.getTextContent()) || "null".equalsIgnoreCase(item.getTextContent())) {
                                sVar.field_cnValue = sVar.field_key;
                            } else {
                                try {
                                    sVar.field_cnValue = item.getTextContent();
                                } catch (Exception e) {
                                    w.e("MicroMsg.emoji.EmojiResUpdateMgr", "parserNewEmojiConfig parseXML exception:%s", new Object[]{e.toString()});
                                    return;
                                }
                            }
                        } else if (nodeName.equalsIgnoreCase("qq-value")) {
                            if (bg.mA(item.getTextContent()) || "null".equalsIgnoreCase(item.getTextContent())) {
                                sVar.field_qqValue = sVar.field_key;
                            } else {
                                sVar.field_qqValue = item.getTextContent();
                            }
                        } else if (nodeName.equalsIgnoreCase("en-value")) {
                            if (bg.mA(item.getTextContent()) || "null".equalsIgnoreCase(item.getTextContent())) {
                                sVar.field_enValue = sVar.field_key;
                            } else {
                                sVar.field_enValue = item.getTextContent();
                            }
                        } else if (nodeName.equalsIgnoreCase("tw-value")) {
                            if (bg.mA(item.getTextContent()) || "null".equalsIgnoreCase(item.getTextContent())) {
                                sVar.field_twValue = sVar.field_key;
                            } else {
                                sVar.field_twValue = item.getTextContent();
                            }
                        } else if (nodeName.equalsIgnoreCase("th-value")) {
                            if (bg.mA(item.getTextContent()) || "null".equalsIgnoreCase(item.getTextContent())) {
                                sVar.field_thValue = sVar.field_key;
                            } else {
                                sVar.field_thValue = item.getTextContent();
                            }
                        } else if (nodeName.equalsIgnoreCase(DownloadInfo.FILENAME)) {
                            sVar.field_fileName = item.getTextContent();
                        } else if (nodeName.equalsIgnoreCase("eggIndex")) {
                            int intValue;
                            try {
                                intValue = Integer.valueOf(item.getTextContent()).intValue();
                            } catch (Throwable e2) {
                                w.e("MicroMsg.emoji.EmojiResUpdateMgr", bg.g(e2));
                                intValue = -1;
                            }
                            sVar.field_eggIndex = intValue;
                        } else {
                            continue;
                        }
                    }
                    sVar.field_position = -1;
                    w.d("MicroMsg.emoji.EmojiResUpdateMgr", sVar.toString());
                    if (bg.mA(sVar.field_key)) {
                        w.i("MicroMsg.emoji.EmojiResUpdateMgr", "key is empty");
                    } else {
                        arrayList.add(sVar);
                    }
                }
            }
            if (arrayList.isEmpty()) {
                w.i("MicroMsg.emoji.EmojiResUpdateMgr", "parserNewEmojiConfig smiley list is null.");
            } else if (((com.tencent.mm.plugin.emoji.b.c) h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().s(arrayList)) {
                com.tencent.mm.sdk.b.b chVar = new ch();
                chVar.fFM.fEC = 1;
                com.tencent.mm.sdk.b.a.urY.m(chVar);
                kKr = r(new File(alI() + File.separator + kKc, kKh));
                ap.yY();
                c.vr().a(com.tencent.mm.storage.w.a.uzV, Integer.valueOf(kKr));
            }
        }
    }

    public static void t(File file) {
        try {
            Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
            parse.normalize();
            NodeList elementsByTagName = parse.getDocumentElement().getElementsByTagName("item");
            if (elementsByTagName != null && elementsByTagName.getLength() > 0) {
                ArrayList arrayList = new ArrayList();
                int length = elementsByTagName.getLength();
                for (int i = 0; i < length; i++) {
                    Node item = elementsByTagName.item(i);
                    if (!(item == null || bg.mA(item.getTextContent()))) {
                        String replaceAll = item.getTextContent().replaceAll("\"", "");
                        if (replaceAll.startsWith("\\\\u")) {
                            char[] toChars = Character.toChars(Integer.parseInt(replaceAll.substring(3), 16));
                            replaceAll = "";
                            int i2 = 0;
                            while (i2 < toChars.length) {
                                String str = replaceAll + String.valueOf(toChars[i2]);
                                i2++;
                                replaceAll = str;
                            }
                        }
                        u uVar = new u(i, replaceAll);
                        if (bg.mA(uVar.field_key)) {
                            w.i("MicroMsg.emoji.EmojiResUpdateMgr", "key is null.");
                        } else {
                            arrayList.add(uVar);
                        }
                        w.d("MicroMsg.emoji.EmojiResUpdateMgr", uVar.toString());
                    }
                }
                if (arrayList.isEmpty()) {
                    w.i("MicroMsg.emoji.EmojiResUpdateMgr", "parserEmojiPanelConfig smiley panel list is null.");
                } else if (((com.tencent.mm.plugin.emoji.b.c) h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().t(arrayList)) {
                    com.tencent.mm.sdk.b.b chVar = new ch();
                    chVar.fFM.fEC = 2;
                    com.tencent.mm.sdk.b.a.urY.m(chVar);
                    kKs = r(new File(alI() + File.separator + kKd, kKh));
                    ap.yY();
                    c.vr().a(com.tencent.mm.storage.w.a.uzW, Integer.valueOf(kKs));
                }
            }
        } catch (Exception e) {
            w.e("MicroMsg.emoji.EmojiResUpdateMgr", "parserEmojiPanelConfig parseXML exception:%s", new Object[]{e.toString()});
        }
    }

    public static void u(File file) {
        try {
            Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
            parse.normalize();
            NodeList elementsByTagName = parse.getDocumentElement().getElementsByTagName("group");
            if (elementsByTagName != null && elementsByTagName.getLength() > 0) {
                int length = elementsByTagName.getLength();
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < length; i++) {
                    NodeList childNodes = elementsByTagName.item(i).getChildNodes();
                    if (childNodes != null && childNodes.getLength() > 0) {
                        int length2 = childNodes.getLength();
                        ArrayList arrayList2 = new ArrayList();
                        for (int i2 = 0; i2 < length2; i2++) {
                            Node item = childNodes.item(i2);
                            if (item.getNodeName().equals("word")) {
                                String textContent = item.getTextContent();
                                if (!bg.mA(textContent)) {
                                    w.d("MicroMsg.emoji.EmojiResUpdateMgr", "word:%s", new Object[]{textContent});
                                    arrayList2.add(textContent.trim());
                                }
                            }
                        }
                        arrayList.add(arrayList2);
                    }
                }
                com.tencent.mm.plugin.emoji.model.h.amc().kLk.ah(arrayList);
                kKt = r(new File(alI() + File.separator + kKe, kKh));
                ap.yY();
                c.vr().a(com.tencent.mm.storage.w.a.uzX, Integer.valueOf(kKt));
            }
        } catch (Exception e) {
            w.e("MicroMsg.emoji.EmojiResUpdateMgr", "parserEmojiDescConfig parseXML exception:%s", new Object[]{e.toString()});
        }
    }

    public static void v(File file) {
        try {
            String aT = com.tencent.mm.a.e.aT(file.getAbsolutePath());
            Map q = bh.q(aT, "EasterEgg");
            w.i("MicroMsg.emoji.EmojiResUpdateMgr", "eggXml:" + aT);
            if (q == null) {
                w.e("MicroMsg.emoji.EmojiResUpdateMgr", "Exception in parseXml EasterEgg, please check the xml");
                return;
            }
            f fVar = new f();
            fVar.hOf = (double) bg.PY((String) q.get(".EasterEgg.$version"));
            int i = 0;
            while (true) {
                String str = ".EasterEgg.Item" + (i == 0 ? "" : Integer.valueOf(i));
                if (q.get(str + ".$name") != null) {
                    d dVar = new d();
                    dVar.name = bg.mz((String) q.get(str + ".$name"));
                    dVar.hNY = bg.mz((String) q.get(str + ".$langs"));
                    dVar.hNV = bg.PY((String) q.get(str + ".$reportType"));
                    dVar.hNW = bg.PP((String) q.get(str + ".$BeginDate"));
                    dVar.hNX = bg.PP((String) q.get(str + ".$EndDate"));
                    dVar.hNZ = bg.mz((String) q.get(str + ".FileName"));
                    dVar.hOa = bg.PY((String) q.get(str + ".AnimType"));
                    dVar.hOb = bg.PY((String) q.get(str + ".AnimType.$viewcount"));
                    dVar.hOc = bg.PY((String) q.get(str + ".AnimType.$minSize"));
                    dVar.maxSize = bg.PY((String) q.get(str + ".AnimType.$maxSize"));
                    int i2 = 0;
                    while (true) {
                        aT = str + ".KeyWord" + (i2 == 0 ? "" : Integer.valueOf(i2));
                        String str2 = aT + ".$lang";
                        if (q.get(aT) == null) {
                            break;
                        }
                        com.tencent.mm.ap.e eVar = new com.tencent.mm.ap.e();
                        eVar.hOd = bg.mz((String) q.get(aT));
                        eVar.lang = bg.mz((String) q.get(str2));
                        dVar.hNT.add(eVar);
                        i2++;
                    }
                    fVar.hOe.add(dVar);
                    i++;
                } else {
                    byte[] toByteArray = fVar.toByteArray();
                    StringBuilder stringBuilder = new StringBuilder();
                    ap.yY();
                    com.tencent.mm.a.e.b(stringBuilder.append(c.xu()).append("eggingfo.ini").toString(), toByteArray, toByteArray.length);
                    kKu = r(new File(alI() + File.separator + kKf, kKh));
                    ap.yY();
                    c.vr().a(com.tencent.mm.storage.w.a.uzY, Integer.valueOf(kKu));
                    return;
                }
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.emoji.EmojiResUpdateMgr", e, "", new Object[0]);
        }
    }

    public static boolean b(bb bbVar) {
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.mm.bi.b.bKy();
        com.tencent.mm.bi.b.bKB();
        long j = com.tencent.mm.bi.b.bKy().uyc;
        com.tencent.mm.bi.b.bKy();
        int Qw = com.tencent.mm.bi.b.Qw(bbVar.fEA.filePath);
        com.tencent.mm.bi.b.bKy();
        w.i("MicroMsg.emoji.EmojiResUpdateMgr", "currentSupportVersion:%d current version:%d supportVersion:%d file version:%d use time:%d", new Object[]{Integer.valueOf(1), Long.valueOf(j), Integer.valueOf(Qw), Long.valueOf(com.tencent.mm.bi.b.Qv(bbVar.fEA.filePath)), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        if (Qw == 1 && r6 > j) {
            return true;
        }
        w.i("MicroMsg.emoji.EmojiResUpdateMgr", "need not update color emoji");
        return false;
    }

    public final f alG() {
        try {
            if (this.kKw == null) {
                StringBuilder stringBuilder = new StringBuilder();
                ap.yY();
                byte[] d = com.tencent.mm.a.e.d(stringBuilder.append(c.xu()).append("eggingfo.ini").toString(), 0, -1);
                if (d == null) {
                    w.d("MicroMsg.emoji.EmojiResUpdateMgr", "data is null, parse EggList from config file fail");
                } else {
                    this.kKw = (f) new f().aD(d);
                }
            }
        } catch (Throwable e) {
            w.w("MicroMsg.emoji.EmojiResUpdateMgr", "init crash : %s, try delete egg file", new Object[]{e.getLocalizedMessage()});
            w.printErrStackTrace("MicroMsg.emoji.EmojiResUpdateMgr", e, "", new Object[0]);
        }
        return this.kKw;
    }
}
