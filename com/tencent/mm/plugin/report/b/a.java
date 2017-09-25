package com.tencent.mm.plugin.report.b;

import com.tencent.mm.a.e;
import com.tencent.mm.protocal.c.aez;
import com.tencent.mm.protocal.c.amz;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Iterator;

public final class a {
    private static String filename = "heavy_user_id_mapping.dat";
    private static Object lock = new Object();
    private a oTi;
    private int oTj;
    private int oTk;
    private int oTl;
    private int oTm;

    public interface a {
    }

    public a() {
        this.oTi = null;
        this.oTj = 0;
        this.oTk = 1;
        this.oTl = 2;
        this.oTm = 3;
        this.oTi = null;
    }

    private static void a(aez com_tencent_mm_protocal_c_aez, boolean z) {
        Iterator it;
        if (z) {
            w.i("MicroMsg.HeavyUserIDMappingStg", "################################# svr heavy user strategy #############################");
            w.i("MicroMsg.HeavyUserIDMappingStg", "svr_version:" + com_tencent_mm_protocal_c_aez.tKh + ", ret:" + com_tencent_mm_protocal_c_aez.tKj);
            it = com_tencent_mm_protocal_c_aez.tKi.iterator();
            while (it.hasNext()) {
                amz com_tencent_mm_protocal_c_amz = (amz) it.next();
                w.i("MicroMsg.HeavyUserIDMappingStg", "origin:" + com_tencent_mm_protocal_c_amz.tRD + ", userid:" + com_tencent_mm_protocal_c_amz.tRE);
            }
            w.i("MicroMsg.HeavyUserIDMappingStg", "#################################  End ################################################");
            return;
        }
        w.d("MicroMsg.HeavyUserIDMappingStg", "################################# Local heavy user strategy #############################");
        w.d("MicroMsg.HeavyUserIDMappingStg", "svr_version:" + com_tencent_mm_protocal_c_aez.tKh + ", ret:" + com_tencent_mm_protocal_c_aez.tKj);
        it = com_tencent_mm_protocal_c_aez.tKi.iterator();
        while (it.hasNext()) {
            com_tencent_mm_protocal_c_amz = (amz) it.next();
            w.d("MicroMsg.HeavyUserIDMappingStg", "origin:" + com_tencent_mm_protocal_c_amz.tRD + ", userid:" + com_tencent_mm_protocal_c_amz.tRE);
        }
        w.d("MicroMsg.HeavyUserIDMappingStg", "#################################  End ################################################");
    }

    public final void a(aez com_tencent_mm_protocal_c_aez, int i) {
        w.i("MicroMsg.HeavyUserIDMappingStg", "saveIDMapping, channel:" + i);
        if (com_tencent_mm_protocal_c_aez == null) {
            w.w("MicroMsg.HeavyUserIDMappingStg", "HeavyUserRespInfo is null");
        } else if (this.oTj != com_tencent_mm_protocal_c_aez.tKj) {
            String str = "MicroMsg.HeavyUserIDMappingStg";
            StringBuilder stringBuilder = new StringBuilder("heavyUserRespInfo.RespType Unnormal, type:");
            r0 = com_tencent_mm_protocal_c_aez.tKj;
            String str2 = this.oTk == r0 ? "服务器过载" : this.oTl == r0 ? "服务器没有配置表" : this.oTm == r0 ? "服务器配置表错误" : "非法的错误类型";
            w.e(str, stringBuilder.append(str2).append(",version:").append(com_tencent_mm_protocal_c_aez.tKh).toString());
        } else {
            r0 = rW(i);
            int i2 = com_tencent_mm_protocal_c_aez.tKh;
            if (r0 == i2) {
                w.d("MicroMsg.HeavyUserIDMappingStg", "client has same version with Srv, version:" + i2);
                return;
            }
            w.i("MicroMsg.HeavyUserIDMappingStg", "version changed, client:" + rW(i) + ", svr:" + i2);
            a(com_tencent_mm_protocal_c_aez, true);
            try {
                byte[] toByteArray = com_tencent_mm_protocal_c_aez.toByteArray();
                synchronized (lock) {
                    w.i("MicroMsg.HeavyUserIDMappingStg", "new version:" + com_tencent_mm_protocal_c_aez.tKh);
                    e.a(com.tencent.mm.storage.w.hgq, filename, toByteArray);
                }
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.HeavyUserIDMappingStg", e, "", new Object[0]);
            }
        }
    }

    public static aez aXx() {
        w.d("MicroMsg.HeavyUserIDMappingStg", "getIDMappingObj");
        synchronized (lock) {
            byte[] d = e.d(com.tencent.mm.storage.w.hgq + filename, 0, -1);
        }
        if (d == null) {
            w.w("MicroMsg.HeavyUserIDMappingStg", "get file content fail, filename" + filename);
            return null;
        }
        aez com_tencent_mm_protocal_c_aez = new aez();
        try {
            com_tencent_mm_protocal_c_aez.aD(d);
            a(com_tencent_mm_protocal_c_aez, false);
            return com_tencent_mm_protocal_c_aez;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.HeavyUserIDMappingStg", e, "", new Object[0]);
            return null;
        }
    }

    public final int rW(int i) {
        w.d("MicroMsg.HeavyUserIDMappingStg", "getIDMappingVersion,chanel:" + i);
        aez aXx = aXx();
        if (aXx == null) {
            return 0;
        }
        int i2 = aXx.tKh;
        w.i("MicroMsg.HeavyUserIDMappingStg", "version:" + i2);
        return i2;
    }
}
