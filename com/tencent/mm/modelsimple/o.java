package com.tencent.mm.modelsimple;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.e.a.a;
import com.tencent.mm.e.a.ah;
import com.tencent.mm.e.a.il;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.xl;
import com.tencent.mm.protocal.c.xm;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.account.DisasterUI;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.HashMap;
import java.util.Map;

public final class o extends k implements j {
    public static Map<String, Long> hRT = new HashMap();
    private static Map<String, String> hRU;
    public boolean fMm = false;
    private e gUD;
    private final b hRS;
    public c<a> hRV;

    public o(int i, boolean z) {
        b.a aVar = new b.a();
        aVar.hsm = new xl();
        aVar.hsn = new xm();
        aVar.uri = "/cgi-bin/micromsg-bin/getdisasterinfo";
        aVar.hsl = 775;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.hRS = aVar.BE();
        this.hRS.fYs = 1;
        ((xl) this.hRS.hsj.hsr).fMl = i;
        this.fMm = z;
        IZ();
        w.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo noticeid[%d], manualauthSucc[%b], stack[%s]", Integer.valueOf(i), Boolean.valueOf(this.fMm), bg.bJZ());
    }

    public final int getType() {
        return 775;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        xl xlVar = (xl) this.hRS.hsj.hsr;
        long a = bg.a((Long) hRT.get(xlVar.fMl), 0);
        w.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo doScene noticeid[%d], tick[%d], noticeidTickMap[%s]", Integer.valueOf(xlVar.fMl), Long.valueOf(a), hRT);
        if (a == 0 || bg.aB(a) >= 1800000) {
            String ap = bg.ap((String) hRU.get(xlVar.fMl), "");
            if (bg.mA(ap)) {
                this.gUD = eVar2;
                return a(eVar, this.hRS, this);
            }
            w.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo doScene found cache[%d, %s]", Integer.valueOf(xlVar.fMl), ap);
            z(ap, false);
            return -1;
        }
        w.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo doScene disasterTick within half an hour, drop it [%s]", Integer.valueOf(xlVar.fMl));
        return -1;
    }

    private void z(final String str, final boolean z) {
        ap.vL().D(new Runnable(this) {
            final /* synthetic */ o hRY;

            public final void run() {
                int i;
                String str = "MicroMsg.NetSceneGetDisasterInfo";
                String str2 = "summerdiz NetSceneGetDisasterInfo broadcastEvent content len[%d], cache[%b]";
                Object[] objArr = new Object[2];
                if (str == null) {
                    i = -1;
                } else {
                    i = str.length();
                }
                objArr[0] = Integer.valueOf(i);
                objArr[1] = Boolean.valueOf(z);
                w.i(str, str2, objArr);
                com.tencent.mm.sdk.b.b ahVar = new ah();
                ahVar.fDx.type = 5;
                ahVar.fDx.fDz = str;
                com.tencent.mm.sdk.b.a.urY.m(ahVar);
                str = ahVar.fDy.fDE;
                int i2 = ahVar.fDy.position;
                int i3 = ahVar.fDy.fDB;
                w.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo onGYNetEnd event.result.Actionp[%d] noticeId[%s], position[%d], manualauthSucc[%b], noticeidTickMap[%s]", Integer.valueOf(i3), str, Integer.valueOf(i2), Boolean.valueOf(this.hRY.fMm), o.hRT);
                if (i2 == 1 && i3 == 6) {
                    if (z) {
                        o.ak(str, str);
                    }
                    if (this.hRY.fMm) {
                        str2 = ahVar.fDy.desc;
                        final String str3 = ahVar.fDy.url;
                        w.i("MicroMsg.NetSceneGetDisasterInfo", "summerdize NetSceneGetDisasterInfo onGYNetEnd manualauthSucc showtony after init[%b]", Boolean.valueOf(ab.bIU()));
                        if (this.hRY.hRV == null) {
                            this.hRY.hRV = new c<a>(this) {
                                final /* synthetic */ AnonymousClass1 hSb;

                                public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                                    com.tencent.mm.sdk.b.a.urY.c(this.hSb.hRY.hRV);
                                    this.hSb.hRY.hRV = null;
                                    w.i("MicroMsg.NetSceneGetDisasterInfo", "summerdize NetSceneGetDisasterInfo onGYNetEnd manualauthSucc showtony after 5s[%b]", Boolean.valueOf(ab.bIU()));
                                    af.f(new Runnable(this) {
                                        final /* synthetic */ AnonymousClass1 hSc;

                                        {
                                            this.hSc = r1;
                                        }

                                        public final void run() {
                                            w.i("MicroMsg.NetSceneGetDisasterInfo", "summerdize NetSceneGetDisasterInfo onGYNetEnd manualauthSucc showtony[%b]", Boolean.valueOf(ab.bIU()));
                                            Intent intent = new Intent();
                                            intent.putExtra("key_disaster_content", str2);
                                            intent.putExtra("key_disaster_url", str3);
                                            intent.setClass(ab.getContext(), DisasterUI.class).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                                            ab.getContext().startActivity(intent);
                                        }
                                    }, 5000);
                                    return true;
                                }
                            };
                        }
                        com.tencent.mm.sdk.b.a.urY.b(this.hRY.hRV);
                    } else {
                        com.tencent.mm.sdk.b.b ilVar = new il();
                        ilVar.fOj.content = ahVar.fDy.desc;
                        ilVar.fOj.url = ahVar.fDy.url;
                        com.tencent.mm.sdk.b.a.urY.m(ilVar);
                    }
                    o.hRT.put(str, Long.valueOf(bg.NA()));
                } else if (i3 == 2) {
                    if (z) {
                        o.ak(str, str);
                    }
                    o.hRT.put(str, Long.valueOf(bg.NA()));
                }
            }
        });
    }

    private synchronized void IZ() {
        if (hRU == null) {
            w.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz loadNoticeContentMap noticeContentMap");
            hRU = new HashMap();
            SharedPreferences sharedPreferences = ab.getContext().getSharedPreferences("disaster_pref", 4);
            String string = sharedPreferences.getString("disaster_new_noticeid_list_key", "");
            if (!bg.mA(string)) {
                String[] split = string.split(";");
                if (split != null && split.length > 0) {
                    Editor edit = sharedPreferences.edit();
                    String str = "";
                    for (String string2 : split) {
                        String[] split2 = string2.split(",");
                        try {
                            if (bg.getLong(split2[0], 0) > 0) {
                                if (bg.az(bg.getLong(split2[1], 0)) < 86400) {
                                    String string3 = sharedPreferences.getString(split2[0], "");
                                    if (!bg.mA(string3)) {
                                        str = str + split2[0] + "," + split2[1] + ";";
                                        hRU.put(split2[0], string3);
                                    }
                                } else {
                                    edit.remove(split2[0]).commit();
                                }
                            }
                        } catch (Exception e) {
                            w.e("MicroMsg.NetSceneGetDisasterInfo", "summerdiz loadNoticeContentMap noticeContentMap error:%s", e.getMessage());
                        }
                    }
                    edit.putString("disaster_new_noticeid_list_key", str).commit();
                    w.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz loadNoticeContentMap noticeContentMap newNoticeIdList[%s], noticeidTickMap[%s]", str, hRT);
                }
            }
            w.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz loadNoticeContentMap noticeContentMap done noticeContentMap[%s]", hRU);
        }
    }

    public static void ak(String str, String str2) {
        SharedPreferences sharedPreferences = ab.getContext().getSharedPreferences("disaster_pref", 4);
        String string = sharedPreferences.getString("disaster_new_noticeid_list_key", "");
        if (!bg.mA(string)) {
            string = string + ";";
        }
        string = string + str + "," + bg.Ny();
        Editor edit = sharedPreferences.edit();
        edit.putString(str, str2);
        edit.putString("disaster_new_noticeid_list_key", string);
        edit.commit();
        hRU.put(str, str2);
        w.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz saveDisasterNotice newNoticeIdList[%s], noticeId[%s], content[%s]", sharedPreferences.getString("disaster_new_noticeid_list_key", ""), str, sharedPreferences.getString(str, ""));
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo onGYNetEnd netId[%d], errType[%d], errCode[%d], errMsg[%s]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            z(((xm) this.hRS.hsk.hsr).content, true);
        }
        this.gUD.a(i2, i3, str, this);
    }
}
