package com.tencent.mm.plugin.readerapp.b;

import com.tencent.mm.R;
import com.tencent.mm.e.b.aj;
import com.tencent.mm.p.f;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.pluginsdk.j.o;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.ae;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bd;
import com.tencent.mm.u.c;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public final class e implements f {
    public static e oJM = new e();

    private e() {
    }

    public final void a(int i, Map<String, bu> map, boolean z) {
        w.i("MicroMsg.ReaderFuncMsgUpdateMgr", "onFunctionMsgUpdate, op: %s, msgIdMap.size: %s, needUpdateTime: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(map.size()), Boolean.valueOf(z)});
        for (String str : map.keySet()) {
            bu buVar = (bu) map.get(str);
            List<bd> a = a(buVar, str);
            if (a != null) {
                long j = ((long) buVar.ogM) * 1000;
                if (!(a == null || a.size() == 0)) {
                    w.i("MicroMsg.ReaderFuncMsgUpdateMgr", "processInfoList, op: %s, infoList.size: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(a.size())});
                    bd bdVar;
                    if (i == 1) {
                        for (bd bdVar2 : a) {
                            w.i("MicroMsg.ReaderFuncMsgUpdateMgr", "delete info, functionMsgId: %s", new Object[]{bdVar2.zJ()});
                            g.aWb().a(bdVar2.zJ(), bdVar2.type, true, true);
                        }
                    } else if (i == 0) {
                        bd bdVar3 = null;
                        List<bd> t = g.aWb().t(str, ((bd) a.get(0)).type);
                        bd bdVar4 = null;
                        w.i("MicroMsg.ReaderFuncMsgUpdateMgr", "update info, functionMsgId: %s, oldInfoList: %s", new Object[]{str, t});
                        Object obj = null;
                        int i2 = 0;
                        int i3 = 0;
                        for (bd bdVar5 : a) {
                            if (bdVar3 == null) {
                                i3 = bdVar5.type;
                                bdVar5.hnC = 1;
                                bdVar3 = bdVar5;
                            }
                            if (t == null) {
                                w.i("MicroMsg.ReaderFuncMsgUpdateMgr", "update info, insert new msg, functionMsgId: %s", new Object[]{bdVar5.zJ()});
                                i2++;
                                g.aWb().a(bdVar5);
                            } else {
                                int i4;
                                Object obj2;
                                if (z) {
                                    bdVar5.time = j;
                                    if (bdVar3 != null) {
                                        bdVar3.time = j;
                                    }
                                    i4 = i2 + 1;
                                } else {
                                    if (bdVar4 == null) {
                                        bdVar2 = (bd) t.get(0);
                                        bdVar4 = bdVar2;
                                        for (bd bdVar22 : t) {
                                            if (bdVar22.hnC != 1) {
                                                bdVar22 = bdVar4;
                                            }
                                            bdVar4 = bdVar22;
                                        }
                                    }
                                    bdVar5.time = bdVar4.time;
                                    if (bdVar3 != null) {
                                        bdVar3.time = bdVar4.time;
                                    }
                                    i4 = i2;
                                }
                                w.i("MicroMsg.ReaderFuncMsgUpdateMgr", "update info, update the exist one, functionMsgId: %s, time: %s", new Object[]{bdVar5.zJ(), Long.valueOf(bdVar5.time)});
                                if (obj == null) {
                                    g.aWb().a(bdVar5.zJ(), bdVar5.type, false, false);
                                    obj2 = 1;
                                } else {
                                    obj2 = obj;
                                }
                                g.aWb().a(bdVar5);
                                obj = obj2;
                                i2 = i4;
                            }
                        }
                        if (i2 > 0) {
                            ap.yY();
                            aj Rm = c.wW().Rm(bd.fd(i3));
                            if (Rm == null || !Rm.field_username.equals(bd.fd(i3))) {
                                ae aeVar = new ae();
                                aeVar.setUsername(bd.fd(i3));
                                aeVar.setContent(bdVar3 == null ? "" : bdVar3.getTitle());
                                aeVar.s(bdVar3 == null ? bg.Nz() : bdVar3.time);
                                aeVar.dw(0);
                                aeVar.dt(1);
                                ap.yY();
                                c.wW().d(aeVar);
                            } else {
                                Rm.s(bdVar3.time);
                                Rm.dw(0);
                                if (!(bg.mA(bdVar3.getTitle()) || bdVar3.getTitle().equals(Rm.field_content)) || Rm.field_unReadCount == 0) {
                                    Rm.setContent(bdVar3.getTitle());
                                    Rm.dt(Rm.field_unReadCount + 1);
                                }
                                ap.yY();
                                c.wW().a(Rm, bd.fd(i3));
                            }
                        }
                        g.aWb().doNotify();
                    }
                }
            }
        }
    }

    private static List<bd> a(bu buVar, String str) {
        String trim = n.a(buVar.tff).trim();
        if (trim.indexOf("<") != -1) {
            trim = trim.substring(trim.indexOf("<"));
        }
        long j = ((long) buVar.ogM) * 1000;
        w.d("MicroMsg.ReaderFuncMsgUpdateMgr", "parseMsg, createTime: %s, content: %s", new Object[]{Integer.valueOf(buVar.ogM), trim});
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSSS");
        List<bd> arrayList = new ArrayList();
        try {
            Map q = bh.q(trim, "mmreader");
            int i = 0;
            while (i <= 0) {
                String str2 = ".mmreader.category" + (i > 0 ? Integer.valueOf(i) : "");
                int i2 = bg.getInt((String) q.get(str2 + ".$type"), 0);
                if (i2 != 0) {
                    if (i2 != 20 && i2 != 11) {
                        w.e("MicroMsg.ReaderFuncMsgUpdateMgr", "get " + str2 + ".$type  error Type:" + i2);
                        break;
                    }
                    trim = (String) q.get(str2 + ".name");
                    if (bg.mA(trim)) {
                        w.e("MicroMsg.ReaderFuncMsgUpdateMgr", "get " + str2 + ".name  error");
                        break;
                    }
                    String str3 = (String) q.get(str2 + ".topnew.cover");
                    String str4 = (String) q.get(str2 + ".topnew.digest");
                    int i3 = bg.getInt((String) q.get(str2 + ".$count"), 0);
                    if (i3 == 0) {
                        w.e("MicroMsg.ReaderFuncMsgUpdateMgr", "get " + str2 + ".$count  error");
                        break;
                    }
                    if (i3 > 1) {
                        str2 = str2 + (i2 == 20 ? ".newitem" : ".item");
                    } else {
                        str2 = str2 + ".item";
                    }
                    int i4 = 0;
                    while (i4 < i3) {
                        String str5 = str2 + (i4 > 0 ? Integer.valueOf(i4) : "");
                        bd bdVar = new bd();
                        bdVar.M((long) buVar.tfc);
                        bdVar.title = (String) q.get(str5 + ".title");
                        if (i4 == 0) {
                            bdVar.hnC = 1;
                            bdVar.hks = str3;
                            bdVar.hku = bg.mA(str4) ? (String) q.get(str5 + ".digest") : str4;
                        } else {
                            bdVar.hks = (String) q.get(str5 + ".cover");
                            bdVar.hku = (String) q.get(str5 + ".digest");
                        }
                        bdVar.hnD = q.containsKey(new StringBuilder().append(str5).append(".vedio").toString()) ? 1 : 0;
                        bdVar.url = (String) q.get(str5 + ".url");
                        bdVar.hnx = (String) q.get(str5 + ".shorturl");
                        bdVar.hny = (String) q.get(str5 + ".longurl");
                        bdVar.hnz = bg.getLong((String) q.get(str5 + ".pub_time"), 0);
                        String str6 = (String) q.get(str5 + ".tweetid");
                        if (str6 == null || "".equals(str6)) {
                            str6 = "N" + simpleDateFormat.format(new Date(System.currentTimeMillis() + ((long) i4)));
                            w.d("MicroMsg.ReaderFuncMsgUpdateMgr", "create tweetID = " + str6);
                        }
                        bdVar.hnw = str6;
                        bdVar.hnA = (String) q.get(str5 + ".sources.source.name");
                        bdVar.hnB = (String) q.get(str5 + ".sources.source.icon");
                        bdVar.time = ((long) i) + j;
                        bdVar.type = i2;
                        bdVar.name = trim;
                        bdVar.hnF = str;
                        arrayList.add(bdVar);
                        String[] strArr = new Object[2];
                        strArr[0] = o.Z(ab.getContext().getString(R.l.elp), bdVar.hnz);
                        strArr[1] = o.c(ab.getContext(), bdVar.time, false);
                        w.d("MicroMsg.ReaderFuncMsgUpdateMgr", "parse info, pubtime: %s, time: %s", strArr);
                        i4++;
                    }
                    i++;
                } else {
                    w.e("MicroMsg.ReaderFuncMsgUpdateMgr", "get " + str2 + ".$type  error");
                    break;
                }
            }
            return arrayList;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.ReaderFuncMsgUpdateMgr", e, "", new Object[0]);
            w.e("MicroMsg.ReaderFuncMsgUpdateMgr", "parseMsg error: %s", new Object[]{e.getMessage()});
            return null;
        }
    }
}
