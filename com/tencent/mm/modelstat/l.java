package com.tencent.mm.modelstat;

import android.content.ContentValues;
import android.database.Cursor;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.bj.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.at.b;
import com.tencent.mm.sdk.platformtools.at.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.wcdb.FileUtils;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.util.HashSet;
import junit.framework.Assert;

public final class l extends j implements c<Integer, j> {
    public static final String[] gUx = new String[]{"CREATE TABLE IF NOT EXISTS netstat ( id INTEGER PRIMARY KEY, peroid INT, textCountIn INT, textBytesIn INT, imageCountIn INT, imageBytesIn INT, voiceCountIn INT, voiceBytesIn INT, videoCountIn INT, videoBytesIn INT, mobileBytesIn INT, wifiBytesIn INT, sysMobileBytesIn INT, sysWifiBytesIn INT, textCountOut INT, textBytesOut INT, imageCountOut INT, imageBytesOut INT, voiceCountOut INT, voiceBytesOut INT, videoCountOut INT, videoBytesOut INT, mobileBytesOut INT, wifiBytesOut INT, sysMobileBytesOut INT, sysWifiBytesOut INT, reserved1 INT, reserved2 INT, reserved3 TEXT, realMobileBytesIn INT, realWifiBytesIn INT, realMobileBytesOut INT, realWifiBytesOut INT) ", "CREATE INDEX IF NOT EXISTS  statInfoIndex ON netstat ( peroid ) "};
    private static final String[] hXb = new String[]{"realMobileBytesIn", "realWifiBytesIn", "realMobileBytesOut", "realWifiBytesOut"};
    private long hWY;
    public at<Integer, j> hWZ = new at(this, h.vL().nJF.getLooper(), 30, 2, 300000, 1000);
    private long hXa;
    public g hnH;

    public l(g gVar) {
        int i = 0;
        this.hnH = gVar;
        HashSet hashSet = new HashSet();
        for (Object add : hXb) {
            hashSet.add(add);
        }
        Cursor a = this.hnH.a("PRAGMA table_info(netstat);", null, 2);
        int columnIndex = a.getColumnIndex("name");
        while (a.moveToNext()) {
            hashSet.remove(a.getString(columnIndex));
        }
        a.close();
        String[] strArr = hXb;
        columnIndex = strArr.length;
        while (i < columnIndex) {
            String str = strArr[i];
            if (hashSet.contains(str)) {
                this.hnH.eE("netstat", "ALTER TABLE netstat ADD COLUMN " + str + " INT;");
            }
            i++;
        }
        this.hXa = System.currentTimeMillis();
    }

    public final j gE(int i) {
        j jVar = (j) this.hWZ.get(Integer.valueOf(i));
        if (jVar == null) {
            Cursor a = this.hnH.a("netstat", null, "peroid = " + i, null, null, null, null, 2);
            if (a.moveToFirst()) {
                jVar = new j();
                jVar.b(a);
            }
            a.close();
            if (jVar != null) {
                this.hWZ.q(Integer.valueOf(i), jVar);
                return jVar;
            }
            at atVar = this.hWZ;
            Integer valueOf = Integer.valueOf(i);
            j jVar2 = new j();
            jVar2.fRW = 0;
            jVar2.id = 0;
            jVar2.hWl = 0;
            jVar2.hWm = 0;
            jVar2.hWn = 0;
            jVar2.hWo = 0;
            jVar2.hWp = 0;
            jVar2.hWq = 0;
            jVar2.hWr = 0;
            jVar2.hWs = 0;
            jVar2.hWt = 0;
            jVar2.hWu = 0;
            jVar2.hWv = 0;
            jVar2.hWw = 0;
            jVar2.hWx = 0;
            jVar2.hWy = 0;
            jVar2.hWz = 0;
            jVar2.hWA = 0;
            jVar2.hWB = 0;
            jVar2.hWC = 0;
            jVar2.hWD = 0;
            jVar2.hWE = 0;
            jVar2.hWF = 0;
            jVar2.hWG = 0;
            jVar2.hWH = 0;
            jVar2.hWI = 0;
            jVar2.hWJ = 0;
            jVar2.hWK = 0;
            jVar2.hWL = 0;
            jVar2.hWM = 0;
            jVar2.hWN = 0;
            atVar.q(valueOf, jVar2);
            return jVar;
        } else if (jVar.hWl != i) {
            return null;
        } else {
            return jVar;
        }
    }

    public final void a(j jVar) {
        Assert.assertNotNull(jVar);
        long currentTimeMillis = System.currentTimeMillis();
        if (jVar.hWl <= 0) {
            jVar.hWl = (int) (currentTimeMillis / 86400000);
        }
        if (jVar.hWl > 0) {
            j gE = gE(jVar.hWl);
            if (gE == null || jVar.hWl != gE.hWl) {
                jVar.fRW |= 2;
                jVar.id = -1;
                if (gE != null) {
                    w.i("MicroMsg.NetStat", gE.toString());
                } else {
                    w.i("MicroMsg.NetStat", "NetStat started.");
                }
            } else {
                jVar.fRW = gE.fRW | 1;
                jVar.hWm += gE.hWn;
                jVar.hWn += gE.hWn;
                jVar.hWo += gE.hWp;
                jVar.hWp += gE.hWp;
                jVar.hWq += gE.hWq;
                jVar.hWr += gE.hWr;
                jVar.hWs += gE.hWs;
                jVar.hWt += gE.hWt;
                jVar.hWu += gE.hWu;
                jVar.hWv += gE.hWv;
                jVar.hWw += gE.hWw;
                jVar.hWx += gE.hWx;
                jVar.hWy += gE.hWz;
                jVar.hWz += gE.hWz;
                jVar.hWA += gE.hWB;
                jVar.hWB += gE.hWB;
                jVar.hWC += gE.hWC;
                jVar.hWD += gE.hWD;
                jVar.hWE += gE.hWE;
                jVar.hWF += gE.hWF;
                jVar.hWG += gE.hWG;
                jVar.hWH += gE.hWH;
                jVar.hWI += gE.hWI;
                jVar.hWJ += gE.hWJ;
                jVar.hWK += gE.hWK;
                jVar.hWL += gE.hWL;
                jVar.hWM += gE.hWM;
                jVar.hWN += gE.hWN;
                if (jVar.hWu <= Downloads.RECV_BUFFER_SIZE && jVar.hWv <= Downloads.RECV_BUFFER_SIZE && jVar.hWG <= Downloads.RECV_BUFFER_SIZE) {
                    int i = jVar.hWH;
                }
                jVar.id = gE.id;
                if (currentTimeMillis - this.hXa > 300000) {
                    w.i("MicroMsg.NetStat", jVar.toString());
                }
                b(jVar);
            }
            this.hXa = currentTimeMillis;
            b(jVar);
        }
    }

    public final boolean b(j jVar) {
        Assert.assertNotNull(jVar);
        Assert.assertTrue(jVar.hWl > 0);
        return this.hWZ.q(Integer.valueOf(jVar.hWl), jVar);
    }

    public final long Kb() {
        this.hWZ.jV(true);
        int bJT = (int) (bg.bJT() / 86400000);
        Cursor a = this.hnH.a("SELECT peroid FROM netstat  WHERE peroid > " + ((int) ((bg.Nz() - 1296000000) / 86400000)) + " order by peroid limit 1", null, 2);
        if (a.moveToFirst()) {
            bJT = a.getInt(a.getColumnIndex("peroid"));
        }
        a.close();
        return ((long) bJT) * 86400000;
    }

    public final j gF(int i) {
        j jVar = null;
        this.hWZ.jV(true);
        Cursor a = this.hnH.a("SELECT MAX( id), MAX( peroid), SUM( textCountIn), SUM( textBytesIn), SUM( imageCountIn), SUM( imageBytesIn), SUM( voiceCountIn), SUM( voiceBytesIn), SUM( videoCountIn), SUM( videoBytesIn), SUM( mobileBytesIn), SUM( wifiBytesIn), SUM( sysMobileBytesIn), SUM( sysWifiBytesIn), SUM( textCountOut), SUM( textBytesOut), SUM( imageCountOut), SUM( imageBytesOut), SUM( voiceCountOut), SUM( voiceBytesOut), SUM( videoCountOut), SUM( videoBytesOut), SUM( mobileBytesOut), SUM( wifiBytesOut), SUM( sysMobileBytesOut), SUM( sysWifiBytesOut ), SUM( realMobileBytesIn ), SUM( realWifiBytesIn ), SUM( realMobileBytesOut ), SUM( realWifiBytesOut ) FROM netstat WHERE peroid >= " + i, null, 2);
        if (a.moveToFirst()) {
            jVar = new j();
            jVar.b(a);
        }
        a.close();
        return jVar;
    }

    public final boolean Kc() {
        if (this.hnH.inTransaction()) {
            w.i("MicroMsg.NetStat", "summer preAppend inTransaction return false");
            return false;
        }
        this.hWY = this.hnH.cs(Thread.currentThread().getId());
        if (this.hWY > 0) {
            return true;
        }
        w.i("MicroMsg.NetStat", "summer preAppend ticket: " + this.hWY + " return false");
        return false;
    }

    public final void a(at<Integer, j> atVar, b<Integer, j> bVar) {
        int i = bVar.uvg;
        j jVar = (j) bVar.values;
        if (jVar != null && i == 1) {
            i = jVar.hWl;
            int i2 = jVar.id;
            if (i > 0) {
                ContentValues contentValues = new ContentValues();
                if ((jVar.fRW & 2) != 0) {
                    contentValues.put("peroid", Integer.valueOf(jVar.hWl));
                }
                if ((jVar.fRW & 4) != 0) {
                    contentValues.put("textCountIn", Integer.valueOf(jVar.hWm));
                }
                if ((jVar.fRW & 8) != 0) {
                    contentValues.put("textBytesIn", Integer.valueOf(jVar.hWn));
                }
                if ((jVar.fRW & 16) != 0) {
                    contentValues.put("imageCountIn", Integer.valueOf(jVar.hWo));
                }
                if ((jVar.fRW & 32) != 0) {
                    contentValues.put("imageBytesIn", Integer.valueOf(jVar.hWp));
                }
                if ((jVar.fRW & 64) != 0) {
                    contentValues.put("voiceCountIn", Integer.valueOf(jVar.hWq));
                }
                if ((jVar.fRW & FileUtils.S_IWUSR) != 0) {
                    contentValues.put("voiceBytesIn", Integer.valueOf(jVar.hWr));
                }
                if ((jVar.fRW & 256) != 0) {
                    contentValues.put("videoCountIn", Integer.valueOf(jVar.hWs));
                }
                if ((jVar.fRW & 512) != 0) {
                    contentValues.put("videoBytesIn", Integer.valueOf(jVar.hWt));
                }
                if ((jVar.fRW & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
                    contentValues.put("mobileBytesIn", Integer.valueOf(jVar.hWu));
                }
                if ((jVar.fRW & 2048) != 0) {
                    contentValues.put("wifiBytesIn", Integer.valueOf(jVar.hWv));
                }
                if ((jVar.fRW & Downloads.RECV_BUFFER_SIZE) != 0) {
                    contentValues.put("sysMobileBytesIn", Integer.valueOf(jVar.hWw));
                }
                if ((jVar.fRW & 8192) != 0) {
                    contentValues.put("sysWifiBytesIn", Integer.valueOf(jVar.hWx));
                }
                if ((jVar.fRW & 16384) != 0) {
                    contentValues.put("textCountOut", Integer.valueOf(jVar.hWy));
                }
                if ((jVar.fRW & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0) {
                    contentValues.put("textBytesOut", Integer.valueOf(jVar.hWz));
                }
                if ((jVar.fRW & 65536) != 0) {
                    contentValues.put("imageCountOut", Integer.valueOf(jVar.hWA));
                }
                if ((jVar.fRW & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) != 0) {
                    contentValues.put("imageBytesOut", Integer.valueOf(jVar.hWB));
                }
                if ((jVar.fRW & 262144) != 0) {
                    contentValues.put("voiceCountOut", Integer.valueOf(jVar.hWC));
                }
                if ((jVar.fRW & SQLiteGlobal.journalSizeLimit) != 0) {
                    contentValues.put("voiceBytesOut", Integer.valueOf(jVar.hWD));
                }
                if ((jVar.fRW & 1048576) != 0) {
                    contentValues.put("videoCountOut", Integer.valueOf(jVar.hWE));
                }
                if ((jVar.fRW & 2097152) != 0) {
                    contentValues.put("videoBytesOut", Integer.valueOf(jVar.hWF));
                }
                if ((jVar.fRW & 4194304) != 0) {
                    contentValues.put("mobileBytesOut", Integer.valueOf(jVar.hWG));
                }
                if ((jVar.fRW & 8388608) != 0) {
                    contentValues.put("wifiBytesOut", Integer.valueOf(jVar.hWH));
                }
                if ((jVar.fRW & 16777216) != 0) {
                    contentValues.put("sysMobileBytesOut", Integer.valueOf(jVar.hWI));
                }
                if ((jVar.fRW & 33554432) != 0) {
                    contentValues.put("sysWifiBytesOut", Integer.valueOf(jVar.hWJ));
                }
                if ((jVar.fRW & 67108864) != 0) {
                    contentValues.put("realMobileBytesIn", Integer.valueOf(jVar.hWK));
                }
                if ((jVar.fRW & 134217728) != 0) {
                    contentValues.put("realWifiBytesIn", Integer.valueOf(jVar.hWL));
                }
                if ((jVar.fRW & SQLiteDatabase.CREATE_IF_NECESSARY) != 0) {
                    contentValues.put("realMobileBytesOut", Integer.valueOf(jVar.hWM));
                }
                if ((jVar.fRW & SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING) != 0) {
                    contentValues.put("realWifiBytesOut", Integer.valueOf(jVar.hWN));
                }
                if (i2 < 0) {
                    jVar.id = (int) this.hnH.insert("netstat", SlookAirButtonFrequentContactAdapter.ID, contentValues);
                } else {
                    this.hnH.update("netstat", contentValues, "peroid=" + i, null);
                }
            }
        }
    }

    public final void Kd() {
        if (this.hWY > 0) {
            this.hnH.aD(this.hWY);
        }
    }
}
