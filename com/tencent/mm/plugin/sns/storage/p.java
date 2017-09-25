package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.mm.bj.g;
import com.tencent.mm.protocal.c.aig;
import com.tencent.mm.protocal.c.bbi;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.List;

public final class p extends i<o> {
    public static final String[] gUx = new String[]{i.a(o.gTP, "SnsReportKv")};
    public g hnH;

    public p(g gVar) {
        super(gVar, o.gTP, "SnsReportKv", o.gaK);
        this.hnH = gVar;
    }

    public final int a(bbi com_tencent_mm_protocal_c_bbi) {
        bbi com_tencent_mm_protocal_c_bbi2 = new bbi();
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < com_tencent_mm_protocal_c_bbi.teH.size(); i3++) {
            aig com_tencent_mm_protocal_c_aig = (aig) com_tencent_mm_protocal_c_bbi.teH.get(i3);
            if (com_tencent_mm_protocal_c_aig.tMi.sYA.length + i2 > 51200) {
                a(com_tencent_mm_protocal_c_bbi2, i2);
                i++;
                com_tencent_mm_protocal_c_bbi2.teH.clear();
                i2 = 0;
            } else {
                i2 += com_tencent_mm_protocal_c_aig.tMi.sYA.length;
                com_tencent_mm_protocal_c_bbi2.teH.add(com_tencent_mm_protocal_c_aig);
            }
        }
        if (com_tencent_mm_protocal_c_bbi2.teH.size() <= 0) {
            return i;
        }
        i++;
        a(com_tencent_mm_protocal_c_bbi2, i2);
        return i;
    }

    private int a(bbi com_tencent_mm_protocal_c_bbi, int i) {
        try {
            byte[] toByteArray = com_tencent_mm_protocal_c_bbi.toByteArray();
            o oVar = new o();
            oVar.field_value = toByteArray;
            oVar.field_logtime = System.currentTimeMillis();
            oVar.field_logsize = i;
            oVar.field_offset = 0;
            int insert = (int) this.hnH.insert("SnsReportKv", "", oVar.pv());
            w.d("MicroMsg.SnsKvReportStg", "SnsKvReport Insert result " + insert);
            return insert;
        } catch (Exception e) {
            return 0;
        }
    }

    public final bbi cX(int i, int i2) {
        Throwable th;
        String str = "select rowid, *  from SnsReportKv";
        StringBuffer stringBuffer = new StringBuffer();
        if (i2 > 0) {
            str = str + " where rowid <= " + i2;
        }
        Cursor a = this.hnH.a(str, null, 0);
        bbi com_tencent_mm_protocal_c_bbi = new bbi();
        List<Integer> arrayList = new ArrayList();
        stringBuffer.append("target size " + i + " current maxcolid " + i2);
        if (a.moveToFirst()) {
            int i3 = 0;
            do {
                c oVar = new o();
                oVar.b(a);
                int i4 = oVar.field_offset;
                stringBuffer.append("|offset: " + i4);
                bbi com_tencent_mm_protocal_c_bbi2 = new bbi();
                try {
                    com_tencent_mm_protocal_c_bbi2.aD(oVar.field_value);
                    int i5 = i4;
                    i4 = i3;
                    while (i5 < com_tencent_mm_protocal_c_bbi2.teH.size()) {
                        try {
                            aig com_tencent_mm_protocal_c_aig = (aig) com_tencent_mm_protocal_c_bbi2.teH.get(i5);
                            if (com_tencent_mm_protocal_c_aig.tMi.sYA.length + i4 > i) {
                                if (i4 == 0) {
                                    arrayList.add(Integer.valueOf(oVar.qnk));
                                    w.i("MicroMsg.SnsKvReportStg", "error by server for the mini size " + i + " vlauesize " + com_tencent_mm_protocal_c_aig.tMi.sYA.length);
                                }
                                i3 = 1;
                                stringBuffer.append("|read end on " + oVar.qnk + " and get size " + i4);
                                if (i3 != 0 || oVar.field_offset > com_tencent_mm_protocal_c_bbi2.teH.size()) {
                                    stringBuffer.append("|read full ");
                                    arrayList.add(Integer.valueOf(oVar.qnk));
                                } else {
                                    a((long) oVar.qnk, oVar);
                                    stringBuffer.append("|update new offset " + oVar.field_offset);
                                }
                                if (i3 != 0) {
                                    break;
                                }
                                i3 = i4;
                            } else {
                                oVar.field_offset = i5 + 1;
                                com_tencent_mm_protocal_c_bbi.teH.add(com_tencent_mm_protocal_c_aig);
                                i4 += com_tencent_mm_protocal_c_aig.tMi.sYA.length;
                                i5++;
                            }
                        } catch (Throwable e) {
                            Throwable th2 = e;
                            i3 = i4;
                            th = th2;
                        }
                    }
                    i3 = 0;
                    stringBuffer.append("|read end on " + oVar.qnk + " and get size " + i4);
                    if (i3 != 0) {
                    }
                    stringBuffer.append("|read full ");
                    arrayList.add(Integer.valueOf(oVar.qnk));
                    if (i3 != 0) {
                        break;
                    }
                    i3 = i4;
                } catch (Exception e2) {
                    th = e2;
                    w.printErrStackTrace("MicroMsg.SnsKvReportStg", th, "", new Object[0]);
                    arrayList.add(Integer.valueOf(oVar.qnk));
                    w.i("MicroMsg.SnsKvReportStg", "error paser then delete " + oVar.qnk);
                    if (!a.moveToNext()) {
                        w.i("MicroMsg.SnsKvReportStg", "read info " + stringBuffer.toString());
                        a.close();
                        for (Integer intValue : arrayList) {
                            delete((long) intValue.intValue());
                        }
                        return com_tencent_mm_protocal_c_bbi;
                    }
                }
            } while (a.moveToNext());
            w.i("MicroMsg.SnsKvReportStg", "read info " + stringBuffer.toString());
        }
        a.close();
        while (r1.hasNext()) {
            delete((long) intValue.intValue());
        }
        return com_tencent_mm_protocal_c_bbi;
    }
}
