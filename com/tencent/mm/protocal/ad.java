package com.tencent.mm.protocal;

import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.c.aik;
import com.tencent.mm.protocal.c.bel;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class ad {
    public static byte[] g(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr.length <= 0) {
            w.d("MicroMsg.SyncKeyUtil", "empty old key, use new key");
            return bArr2;
        } else if (bArr2 == null || bArr2.length <= 0) {
            w.e("MicroMsg.SyncKeyUtil", "newKey is null");
            return null;
        } else {
            PByteArray pByteArray = new PByteArray();
            try {
                if (MMProtocalJni.mergeSyncKey(bArr, bArr2, pByteArray)) {
                    return pByteArray.value;
                }
                w.e("MicroMsg.SyncKeyUtil", "merge key failed");
                return null;
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.Crash", e, "NoSuchMethod MMProtocalJni.mergeSyncKey", new Object[0]);
                throw ((IncompatibleClassChangeError) new IncompatibleClassChangeError("NoSuchMethod MMProtocalJni.mergeSyncKey").initCause(e));
            }
        }
    }

    private static Map<Integer, Long> aZ(byte[] bArr) {
        if (bg.bm(bArr)) {
            return null;
        }
        try {
            bel com_tencent_mm_protocal_c_bel = (bel) new bel().aD(bArr);
            if (com_tencent_mm_protocal_c_bel == null) {
                return null;
            }
            w.d("MicroMsg.SyncKeyUtil", "dkpush : keyCount:" + com_tencent_mm_protocal_c_bel.ubo);
            LinkedList linkedList = com_tencent_mm_protocal_c_bel.ubp;
            if (linkedList.size() != com_tencent_mm_protocal_c_bel.ubo) {
                return null;
            }
            Map<Integer, Long> hashMap = new HashMap();
            for (int i = 0; i < com_tencent_mm_protocal_c_bel.ubo; i++) {
                hashMap.put(Integer.valueOf(((aik) linkedList.get(i)).oTD), Long.valueOf(4294967295L & ((long) ((aik) linkedList.get(i)).tMs)));
            }
            if (hashMap.size() != com_tencent_mm_protocal_c_bel.ubo) {
                return null;
            }
            return hashMap;
        } catch (Exception e) {
            return null;
        }
    }

    public static String ba(byte[] bArr) {
        if (bg.bm(bArr)) {
            return "";
        }
        Map aZ = aZ(bArr);
        if (aZ == null || aZ.size() <= 0) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" MsgKey:" + aZ.get(Integer.valueOf(2)));
        stringBuffer.append(" profile:" + aZ.get(Integer.valueOf(1)));
        stringBuffer.append(" contact:" + aZ.get(Integer.valueOf(3)));
        stringBuffer.append(" chatroom:" + aZ.get(Integer.valueOf(11)));
        stringBuffer.append(" Bottle:" + aZ.get(Integer.valueOf(7)));
        stringBuffer.append(" QContact:" + aZ.get(Integer.valueOf(5)));
        return stringBuffer.toString();
    }

    public static boolean h(byte[] bArr, byte[] bArr2) {
        Map aZ = aZ(bArr);
        if (aZ == null) {
            w.d("MicroMsg.SyncKeyUtil", "dkpush local sync key failed");
            return true;
        }
        Map aZ2 = aZ(bArr2);
        if (aZ2 == null) {
            w.e("MicroMsg.SyncKeyUtil", "dkpush svr sync key failed");
            return false;
        }
        for (Integer num : aZ2.keySet()) {
            Long l = (Long) aZ.get(num);
            Long l2 = (Long) aZ2.get(num);
            if (l == null) {
                w.d("MicroMsg.SyncKeyUtil", "dkpush local key null :" + num);
                return true;
            }
            w.d("MicroMsg.SyncKeyUtil", "dkpush local key:" + num + " sv:" + l2 + " lv:" + l);
            if (l2.longValue() > l.longValue()) {
                return true;
            }
        }
        w.d("MicroMsg.SyncKeyUtil", "dkpush two sync key is the same");
        return false;
    }
}
