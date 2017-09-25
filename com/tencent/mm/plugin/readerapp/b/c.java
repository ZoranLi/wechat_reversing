package com.tencent.mm.plugin.readerapp.b;

import com.tencent.mm.e.b.aj;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bd;
import com.tencent.mm.u.m;
import com.tencent.mm.y.d;
import com.tencent.mm.y.d.a;
import com.tencent.mm.y.d.b;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public final class c implements d {
    public final b b(a aVar) {
        Throwable th;
        int i;
        bu buVar = aVar.hst;
        if (buVar == null) {
            w.e("MicroMsg.ReaderAppMsgExtension", "onPreAddMessage cmdAM is null");
            return null;
        }
        int i2;
        Object valueOf;
        int i3;
        String str;
        bd bdVar;
        g.aWb().N((long) buVar.tfc);
        String a = n.a(buVar.tff);
        long Nz = bg.Nz();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSSS");
        int i4 = 0;
        List<bd> arrayList = new ArrayList();
        int i5 = 0;
        try {
            Map q = bh.q(a, "mmreader");
            i4 = 0;
            i2 = 0;
            while (i4 <= 0) {
                StringBuilder stringBuilder = new StringBuilder(".mmreader.category");
                if (i4 > 0) {
                    valueOf = Integer.valueOf(i4);
                } else {
                    try {
                        valueOf = "";
                    } catch (Throwable e) {
                        th = e;
                        i = i2;
                        i2 = i4;
                    }
                }
                String stringBuilder2 = stringBuilder.append(valueOf).toString();
                i5 = bg.getInt((String) q.get(stringBuilder2 + ".$type"), 0);
                if (i5 != 0) {
                    if (i5 != 20 && i5 != 11) {
                        w.e("MicroMsg.ReaderAppMsgExtension", "get " + stringBuilder2 + ".$type  error Type:" + i5);
                        i3 = i4;
                        break;
                    }
                    a = (String) q.get(stringBuilder2 + ".name");
                    if (bg.mA(a)) {
                        w.e("MicroMsg.ReaderAppMsgExtension", "get " + stringBuilder2 + ".name  error");
                        i2 = i5;
                        i3 = i4;
                        break;
                    }
                    String str2 = (String) q.get(stringBuilder2 + ".topnew.cover");
                    str = (String) q.get(stringBuilder2 + ".topnew.digest");
                    int i6 = bg.getInt((String) q.get(stringBuilder2 + ".$count"), 0);
                    if (i6 == 0) {
                        w.e("MicroMsg.ReaderAppMsgExtension", "get " + stringBuilder2 + ".$count  error");
                        i2 = i5;
                        i3 = i4;
                        break;
                    }
                    if (i6 > 1) {
                        stringBuilder2 = stringBuilder2 + (i5 == 20 ? ".newitem" : ".item");
                    } else {
                        stringBuilder2 = stringBuilder2 + ".item";
                    }
                    int i7 = 0;
                    while (i7 < i6) {
                        String str3 = stringBuilder2 + (i7 > 0 ? Integer.valueOf(i7) : "");
                        bd bdVar2 = new bd();
                        bdVar2.M((long) buVar.tfc);
                        bdVar2.title = (String) q.get(str3 + ".title");
                        if (i7 == 0) {
                            long j = bg.getLong((String) q.get(str3 + ".pub_time"), 0);
                            if (j > 0) {
                                Nz = 1000 * j;
                            }
                            bdVar2.hnC = 1;
                            bdVar2.hks = str2;
                            bdVar2.hku = bg.mA(str) ? (String) q.get(str3 + ".digest") : str;
                        } else {
                            bdVar2.hks = (String) q.get(str3 + ".cover");
                            bdVar2.hku = (String) q.get(str3 + ".digest");
                        }
                        bdVar2.hnD = q.containsKey(new StringBuilder().append(str3).append(".vedio").toString()) ? 1 : 0;
                        bdVar2.url = (String) q.get(str3 + ".url");
                        bdVar2.hnx = (String) q.get(str3 + ".shorturl");
                        bdVar2.hny = (String) q.get(str3 + ".longurl");
                        bdVar2.hnz = bg.getLong((String) q.get(str3 + ".pub_time"), 0);
                        String str4 = (String) q.get(str3 + ".tweetid");
                        if (str4 == null || "".equals(str4)) {
                            str4 = "N" + simpleDateFormat.format(new Date(System.currentTimeMillis() + ((long) i7)));
                            w.d("MicroMsg.ReaderAppMsgExtension", "create tweetID = " + str4);
                        }
                        bdVar2.hnw = str4;
                        bdVar2.hnA = (String) q.get(str3 + ".sources.source.name");
                        bdVar2.hnB = (String) q.get(str3 + ".sources.source.icon");
                        bdVar2.time = ((long) i4) + Nz;
                        bdVar2.type = i5;
                        bdVar2.name = a;
                        arrayList.add(bdVar2);
                        i7++;
                    }
                    i4++;
                    i2 = i5;
                } else {
                    w.e("MicroMsg.ReaderAppMsgExtension", "get " + stringBuilder2 + ".$type  error");
                    i3 = i4;
                    break;
                }
            }
            i3 = i4;
        } catch (Throwable e2) {
            th = e2;
            i2 = i4;
            i = i5;
        }
        w.d("MicroMsg.ReaderAppMsgExtension", "type = " + i2 + ", want to receive news? " + aVZ());
        for (bd bdVar3 : arrayList) {
            if (bg.mA(bdVar3.getTitle())) {
                if (bg.mA(bdVar3.getUrl())) {
                    w.e("MicroMsg.ReaderAppMsgExtension", "readerAppInfo.getUrl() is null, appInfo.tweetid = " + bdVar3.zD() + ", type = " + bdVar3.type);
                    valueOf = null;
                    break;
                }
            }
            w.e("MicroMsg.ReaderAppMsgExtension", "readerAppInfo.getTitle() is null, appInfo.tweetid = " + bdVar3.zD() + ", type = " + bdVar3.type);
            valueOf = null;
            break;
        }
        i = 1;
        if (arrayList.size() > 0 || r4 == null) {
            return null;
        }
        int i8 = 0;
        bd bdVar4 = null;
        i5 = 0;
        while (i5 < arrayList.size()) {
            int i9;
            if (g.aWb().a((bd) arrayList.get(i5))) {
                if (bdVar4 == null) {
                    bdVar3 = (bd) arrayList.get(i5);
                    bdVar3.hnC = 1;
                } else {
                    bdVar3 = bdVar4;
                }
                i9 = i8 + 1;
            } else {
                bdVar3 = bdVar4;
                i9 = i8;
            }
            i5++;
            i8 = i9;
            bdVar4 = bdVar3;
        }
        if (i8 > 0) {
            ap.yY();
            aj Rm = com.tencent.mm.u.c.wW().Rm(bd.fd(i2));
            if (Rm == null || !Rm.field_username.equals(bd.fd(i2))) {
                ae aeVar = new ae();
                aeVar.setUsername(bd.fd(i2));
                aeVar.setContent(bdVar4 == null ? "" : bdVar4.getTitle());
                aeVar.s(bdVar4 == null ? bg.Nz() : bdVar4.time);
                aeVar.dw(0);
                aeVar.dt(i3);
                ap.yY();
                com.tencent.mm.u.c.wW().d(aeVar);
            } else {
                Rm.setContent(bdVar4.getTitle());
                Rm.s(bdVar4.time);
                Rm.dw(0);
                Rm.dt(i3 + Rm.field_unReadCount);
                ap.yY();
                com.tencent.mm.u.c.wW().a(Rm, bd.fd(i2));
            }
            g.aWb().doNotify();
            str = bdVar4.getTitle();
            au auVar = new au();
            auVar.setContent(str);
            auVar.cH(bd.fd(i2));
            auVar.setType(1);
            auVar.x(7377812);
            return new b(auVar, true);
        }
        w.e("MicroMsg.ReaderAppMsgExtension", "insert error");
        return null;
        w.printErrStackTrace("MicroMsg.ReaderAppMsgExtension", th, "", new Object[0]);
        i3 = i2;
        i2 = i;
        w.d("MicroMsg.ReaderAppMsgExtension", "type = " + i2 + ", want to receive news? " + aVZ());
        for (bd bdVar32 : arrayList) {
            if (bg.mA(bdVar32.getTitle())) {
                if (bg.mA(bdVar32.getUrl())) {
                    w.e("MicroMsg.ReaderAppMsgExtension", "readerAppInfo.getUrl() is null, appInfo.tweetid = " + bdVar32.zD() + ", type = " + bdVar32.type);
                    valueOf = null;
                    break;
                }
            }
            w.e("MicroMsg.ReaderAppMsgExtension", "readerAppInfo.getTitle() is null, appInfo.tweetid = " + bdVar32.zD() + ", type = " + bdVar32.type);
            valueOf = null;
            break;
        }
        i = 1;
        if (arrayList.size() > 0) {
        }
        return null;
    }

    public static boolean aVZ() {
        return (m.xR() & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) == 0;
    }

    public final void h(au auVar) {
    }
}
