package com.tencent.mm.platformtools;

import com.tencent.mm.bd.b;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.avx;

public final class n {
    public static avw G(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        avw com_tencent_mm_protocal_c_avw = new avw();
        com_tencent_mm_protocal_c_avw.bb(bArr);
        return com_tencent_mm_protocal_c_avw;
    }

    public static byte[] a(avw com_tencent_mm_protocal_c_avw) {
        if (com_tencent_mm_protocal_c_avw == null || com_tencent_mm_protocal_c_avw.tZp == null) {
            return null;
        }
        return com_tencent_mm_protocal_c_avw.tZp.toByteArray();
    }

    public static byte[] a(avw com_tencent_mm_protocal_c_avw, byte[] bArr) {
        return (com_tencent_mm_protocal_c_avw == null || com_tencent_mm_protocal_c_avw.tZp == null) ? bArr : com_tencent_mm_protocal_c_avw.tZp.toByteArray();
    }

    public static String a(avx com_tencent_mm_protocal_c_avx) {
        if (com_tencent_mm_protocal_c_avx == null) {
            return null;
        }
        return com_tencent_mm_protocal_c_avx.tZr;
    }

    public static avx mw(String str) {
        if (str == null) {
            return null;
        }
        avx com_tencent_mm_protocal_c_avx = new avx();
        com_tencent_mm_protocal_c_avx.OV(str);
        return com_tencent_mm_protocal_c_avx;
    }

    public static String a(b bVar) {
        if (bVar == null) {
            return null;
        }
        return bVar.bGX();
    }

    public static String b(avw com_tencent_mm_protocal_c_avw) {
        if (com_tencent_mm_protocal_c_avw == null || com_tencent_mm_protocal_c_avw.tZp == null) {
            return null;
        }
        return com_tencent_mm_protocal_c_avw.tZp.bGX();
    }
}
