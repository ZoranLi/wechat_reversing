package com.tencent.mm.modelfriend;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import com.tencent.mm.av.e;
import com.tencent.mm.av.f;
import com.tencent.mm.av.l;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class m {
    private static Map<String, String> hBp = null;

    public enum a {
        NO_INIT,
        SET_MOBILE,
        SUCC,
        SUCC_UNLOAD
    }

    public static void Fi() {
        ap.yY();
        c.vr().set(12322, Boolean.valueOf(true));
    }

    public static boolean Fj() {
        if (ap.yY() != null) {
            ap.yY();
            if (c.vr() != null) {
                ap.yY();
                return bg.b((Boolean) c.vr().get(12322, Boolean.valueOf(true)), true);
            }
        }
        w.e("MicroMsg.FriendLogic", "[arthurdan.UploadPhone] Notice!!!! MMCore.getAccStg() is null!!!");
        return false;
    }

    public static boolean Fk() {
        w.i("MicroMsg.FriendLogic", "isTipInMobileFriend, state %s", Fl().toString());
        if (Fl() != a.SUCC) {
            return false;
        }
        ap.yY();
        w.i("MicroMsg.FriendLogic", "USERINFO_UPLOAD_ADDR_LOOK_UP %B", Boolean.valueOf(bg.b((Boolean) c.vr().get(12322, Boolean.valueOf(false)), false)));
        if (bg.b((Boolean) c.vr().get(12322, Boolean.valueOf(false)), false)) {
            return false;
        }
        return true;
    }

    public static a Fl() {
        try {
            ap.yY();
            String str = (String) c.vr().get(4097, (Object) "");
            ap.yY();
            String str2 = (String) c.vr().get(6, (Object) "");
            boolean yo = com.tencent.mm.u.m.yo();
            w.i("MicroMsg.FriendLogic", "isUpload " + yo + " stat " + com.tencent.mm.u.m.xP());
            if (str == null || str.length() <= 0) {
                str = null;
            }
            if (str2 == null || str2.length() <= 0) {
                str2 = null;
            }
            if (str == null && r1 == null) {
                return a.NO_INIT;
            }
            if (str != null && r1 == null) {
                return a.SET_MOBILE;
            }
            if (yo) {
                return a.SUCC;
            }
            return a.SUCC_UNLOAD;
        } catch (Exception e) {
            return a.NO_INIT;
        }
    }

    public static void Fm() {
        ap.yY();
        c.vr().set(4097, "");
        ap.yY();
        c.vr().set(6, "");
    }

    public static String Fn() {
        ap.yY();
        return (String) c.vr().get(6, (Object) "");
    }

    public static boolean Fo() {
        if (ap.zb()) {
            int i;
            if (Fl() == a.SUCC) {
                i = 1;
            } else {
                boolean z = false;
            }
            if (i == 0) {
                w.i("MicroMsg.FriendLogic", "canSyncAddrBook userBindOpMobile: %b", Boolean.valueOf(false));
                return false;
            }
            if (Fj()) {
                return true;
            }
            w.i("MicroMsg.FriendLogic", "canSyncAddrBook isUploadContact: %b", Boolean.valueOf(Fj()));
            return false;
        }
        w.i("MicroMsg.FriendLogic", "canSyncAddrBook isAccHasReady: %b", Boolean.valueOf(ap.zb()));
        return false;
    }

    public static Bitmap a(String str, Context context) {
        return com.tencent.mm.pluginsdk.a.a(str, context, false);
    }

    public static boolean a(String str, Context context, byte[] bArr) {
        return com.tencent.mm.pluginsdk.a.b(str, context, bArr);
    }

    public static void Fp() {
        com.tencent.mm.sdk.e.m FY = af.FY();
        int delete = FY.hnH.delete("addr_upload2", null, null);
        w.d("MicroMsg.AddrUploadStorage", "delete addr_upload2");
        if (delete > 0) {
            FY.b(5, FY, null);
        }
    }

    public static void Fq() {
        HashSet hashSet = new HashSet();
        Iterator it = l.Kx().Kq().iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            ap.yY();
            com.tencent.mm.storage.au.a Av = c.wT().Av(fVar.field_msgContent);
            if (Av != null && (Av.scene == 10 || Av.scene == 11)) {
                hashSet.add(fVar.field_talker);
            }
        }
        w.d("MicroMsg.FriendLogic", "deleteMobileFMessage, delete fmsg and fconv, talker size = " + hashSet.size());
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            e.d(0, (String) it2.next());
        }
    }

    public static void C(List<String> list) {
        if (list.size() != 0) {
            HashSet hashSet = new HashSet();
            Iterator it = l.Kx().Kq().iterator();
            while (it.hasNext()) {
                f fVar = (f) it.next();
                ap.yY();
                com.tencent.mm.storage.au.a Av = c.wT().Av(fVar.field_msgContent);
                if (Av != null) {
                    String str = Av.uJY;
                    String str2 = Av.uJX;
                    if ((Av.scene == 10 || Av.scene == 11) && (list.contains(str) || list.contains(str2))) {
                        hashSet.add(fVar.field_talker);
                    }
                }
            }
            w.d("MicroMsg.FriendLogic", "deleteMobileFMessage(md5List), delete fmsg and fconv, talker size = " + hashSet.size());
            Iterator it2 = hashSet.iterator();
            while (it2.hasNext()) {
                e.d(0, (String) it2.next());
            }
        }
    }

    public static String jh(String str) {
        if (str == null || str.equals("")) {
            return "";
        }
        c FY = af.FY();
        Cursor a = FY.hnH.a("select addr_upload2.realname from addr_upload2 where addr_upload2.id = \"" + b.iX(str) + "\"", null, 2);
        if (a == null) {
            return "";
        }
        String str2 = "";
        if (a.moveToFirst()) {
            str2 = a.getString(0);
        }
        a.close();
        return str2;
    }

    public static void D(List<b> list) {
        if (list == null) {
            w.e("MicroMsg.FriendLogic", "sync address book failed, null info list");
        } else {
            af.FY().z(list);
        }
    }

    public static void E(List<String> list) {
        if (list == null) {
            w.e("MicroMsg.FriendLogic", "set uploaded mobile contact failed, null info list");
        } else {
            af.FY().B(list);
        }
    }

    public static List<String> Fr() {
        Cursor a = af.FY().hnH.a("select addr_upload2.md5 from addr_upload2 where addr_upload2.uploadtime = 0 AND addr_upload2.type = 1", null, 2);
        List<String> arrayList = new ArrayList();
        while (a.moveToNext()) {
            arrayList.add(a.getString(0));
        }
        a.close();
        return arrayList;
    }

    public static List<String> Fs() {
        Cursor a = af.FY().hnH.a("select addr_upload2.moblie from addr_upload2 where addr_upload2.uploadtime = 0 AND addr_upload2.type = 0", null, 2);
        List<String> arrayList = new ArrayList();
        while (a.moveToNext()) {
            String Di = com.tencent.mm.pluginsdk.a.Di(a.getString(0));
            if (com.tencent.mm.pluginsdk.a.LA(Di)) {
                arrayList.add(Di);
            }
        }
        a.close();
        return arrayList;
    }

    public static boolean fF(int i) {
        ab fI = af.Gb().fI(i);
        boolean fJ = af.Gd().fJ(i);
        if (fI == null) {
            return false;
        }
        if (fI.hBY == 1 || fJ) {
            return true;
        }
        return false;
    }
}
