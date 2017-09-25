package com.tencent.mm.plugin.subapp.c;

import android.database.Cursor;
import android.os.SystemClock;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.wcdb.FileUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public final class j implements e {
    public static int fBq = 0;
    Queue<String> fBi = new LinkedList();
    Queue<String> fBj = new LinkedList();
    Map<String, a> fBk = new HashMap();
    public boolean fBl = false;
    public boolean fBm = false;
    public boolean fBn = false;
    public int fBo = 0;
    public long fBp = 0;
    a fBs = new a();
    public aj fBt = new aj(ap.vL().nJF.getLooper(), new aj.a(this) {
        final /* synthetic */ j qTu;

        {
            this.qTu = r1;
        }

        public final boolean oQ() {
            w.d("MicroMsg.VoiceRemindService", "onTimerExpired");
            try {
                this.qTu.pq();
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.VoiceRemindService", e, "", new Object[0]);
            }
            return false;
        }
    }, false);

    public j() {
        ap.vd().a(329, (e) this);
    }

    public final void pq() {
        this.fBp = System.currentTimeMillis();
        if ((!this.fBl && this.fBj.size() == 0) || (!this.fBm && this.fBi.size() == 0)) {
            Cursor a = d.bmZ().gUz.a(("SELECT filename, user, msgid, offset, filenowsize, totallen, status, createtime, lastmodifytime, clientid, voicelenght, msglocalid, human, voiceformat, nettimes, reserved1, reserved2" + " FROM VoiceRemindInfo") + " WHERE status<97  order by createtime", null, 2);
            List list = null;
            int i = 0;
            if (a.moveToFirst()) {
                list = new ArrayList();
                do {
                    g gVar = new g();
                    gVar.b(a);
                    list.add(gVar);
                    i++;
                } while (a.moveToNext());
            }
            a.close();
            w.d("MicroMsg.VoiceRemindStorage", "getUnfinishInfo resCount:" + i);
            if (r1 == null) {
                w.d("MicroMsg.VoiceRemindService", "getNeedRunInfo null ");
            } else {
                w.d("MicroMsg.VoiceRemindService", "getNeedRunInfo " + r1.size());
            }
            if (!(r1 == null || r1.size() == 0)) {
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                String ev = bg.ev(currentTimeMillis);
                for (g gVar2 : r1) {
                    if (this.fBk.containsKey(gVar2.field_filename)) {
                        w.d("MicroMsg.VoiceRemindService", "File is Already running:" + gVar2.field_filename);
                    } else {
                        w.d("MicroMsg.VoiceRemindService", "Get file:" + gVar2.field_filename + " status:" + gVar2.field_status + " user" + gVar2.field_user + " human:" + gVar2.field_human + " create:" + bg.ev(gVar2.field_createtime) + " last:" + bg.ev(gVar2.field_lastmodifytime) + " now:" + bg.ev(currentTimeMillis) + " " + (currentTimeMillis - gVar2.field_lastmodifytime));
                        Object obj = (gVar2.field_status == 5 || gVar2.field_status == 6) ? 1 : null;
                        if (obj != null) {
                            if (currentTimeMillis - gVar2.field_lastmodifytime > 80 && gVar2.field_status == 5) {
                                w.e("MicroMsg.VoiceRemindService", "time out file: " + gVar2.field_filename + " last:" + bg.ev(gVar2.field_lastmodifytime) + " now:" + ev);
                                h.lA(gVar2.field_filename);
                            } else if (currentTimeMillis - gVar2.field_lastmodifytime > 300 && gVar2.field_status == 6) {
                                w.e("MicroMsg.VoiceRemindService", "time out file: " + gVar2.field_filename + " last:" + bg.ev(gVar2.field_lastmodifytime) + " now:" + ev);
                                h.lA(gVar2.field_filename);
                            } else if (gVar2.field_filenowsize >= gVar2.field_offset) {
                                w.d("MicroMsg.VoiceRemindService", "file: " + gVar2.field_filename + " stat:" + gVar2.field_status + " now:" + gVar2.field_filenowsize + " net:" + gVar2.field_offset);
                            } else {
                                this.fBj.offer(gVar2.field_filename);
                                this.fBk.put(gVar2.field_filename, null);
                            }
                        }
                        if (gVar2.LC()) {
                            w.d("MicroMsg.VoiceRemindService", "now " + currentTimeMillis + "info.getLastModifyTime()  " + gVar2.field_lastmodifytime + "  info.getStatus() " + gVar2.field_status + "  info.getCreateTime() " + gVar2.field_createtime);
                            if (currentTimeMillis - gVar2.field_lastmodifytime > 10 && (gVar2.field_status == 2 || gVar2.field_status == 1)) {
                                w.e("MicroMsg.VoiceRemindService", "time out file: " + gVar2.field_filename + " last:" + bg.ev(gVar2.field_lastmodifytime) + " now:" + ev);
                                h.lA(gVar2.field_filename);
                            } else if (currentTimeMillis - gVar2.field_createtime > 600 && gVar2.field_status == 3) {
                                w.e("MicroMsg.VoiceRemindService", "time out file: " + gVar2.field_filename + " last:" + bg.ev(gVar2.field_lastmodifytime) + " now:" + ev);
                                h.lA(gVar2.field_filename);
                            } else if (gVar2.field_user.length() <= 0) {
                                w.e("MicroMsg.VoiceRemindService", "Create a new ChatRoom? , set username first :" + gVar2.field_filename);
                            } else {
                                this.fBi.offer(gVar2.field_filename);
                                this.fBk.put(gVar2.field_filename, null);
                            }
                        }
                    }
                }
                w.d("MicroMsg.VoiceRemindService", "GetNeedRun procing:" + this.fBk.size() + " [recv:" + this.fBj.size() + ",send:" + this.fBi.size() + "]");
                this.fBj.size();
                this.fBi.size();
            }
        }
        if (this.fBl || this.fBj.size() != 0 || this.fBm || this.fBi.size() != 0) {
            String str;
            if (!this.fBl && this.fBj.size() > 0) {
                str = (String) this.fBj.poll();
                w.d("MicroMsg.VoiceRemindService", "Start Recv :" + str);
                if (str != null) {
                    this.fBk.put(str, new a());
                    this.fBl = true;
                    w.d("MicroMsg.VoiceRemindService", "tiger download voice");
                }
            }
            if (!this.fBm && this.fBi.size() > 0) {
                str = (String) this.fBi.poll();
                w.d("MicroMsg.VoiceRemindService", "Start Send :" + str);
                if (str != null) {
                    this.fBk.put(str, new a());
                    this.fBm = true;
                    ap.vd().a(new b(str), 0);
                    return;
                }
                return;
            }
            return;
        }
        pr();
        w.d("MicroMsg.VoiceRemindService", "No Data Any More , Stop Service");
    }

    public final void a(final int i, final int i2, String str, final k kVar) {
        ap.vL().D(new Runnable(this) {
            final /* synthetic */ j qTu;

            public final void run() {
                int i;
                String str;
                j.fBq++;
                String str2;
                if (kVar.getType() == FileUtils.S_IWUSR) {
                    this.qTu.fBl = false;
                    str2 = ((com.tencent.mm.modelvoice.e) kVar).fyF;
                    i = ((com.tencent.mm.modelvoice.e) kVar).fEX;
                    str = str2;
                } else if (kVar.getType() == 329) {
                    this.qTu.fBm = false;
                    str2 = ((b) kVar).fyF;
                    i = ((b) kVar).fEX;
                    str = str2;
                } else {
                    w.e("MicroMsg.VoiceRemindService", "onSceneEnd Error SceneType:" + kVar.getType());
                    j.fBq--;
                    return;
                }
                long j = 0;
                if (!(str == null || this.qTu.fBk.get(str) == null)) {
                    j = ((a) this.qTu.fBk.get(str)).se();
                    this.qTu.fBk.remove(str);
                }
                w.d("MicroMsg.VoiceRemindService", "onSceneEnd SceneType:" + kVar.getType() + " errtype:" + i + " errCode:" + i2 + " retCode:" + i + " file:" + str + " time:" + j);
                if (i == 3 && i != 0) {
                    j jVar = this.qTu;
                    jVar.fBo--;
                } else if (i != 0) {
                    this.qTu.fBo = 0;
                }
                w.d("MicroMsg.VoiceRemindService", "onSceneEnd  inCnt:" + j.fBq + " stop:" + this.qTu.fBo + " running:" + this.qTu.fBn + " recving:" + this.qTu.fBl + " sending:" + this.qTu.fBm);
                if (this.qTu.fBo > 0) {
                    this.qTu.pq();
                } else if (!(this.qTu.fBm || this.qTu.fBl)) {
                    this.qTu.pr();
                }
                j.fBq--;
            }
        });
    }

    public final void pr() {
        this.fBk.clear();
        this.fBi.clear();
        this.fBj.clear();
        this.fBm = false;
        this.fBl = false;
        this.fBn = false;
        w.d("MicroMsg.VoiceRemindService", "Finish service use time(ms):" + this.fBs.se());
    }

    public final void run() {
        ap.vL().D(new Runnable(this) {
            final /* synthetic */ j qTu;

            {
                this.qTu = r1;
            }

            public final void run() {
                long currentTimeMillis = System.currentTimeMillis() - this.qTu.fBp;
                w.d("MicroMsg.VoiceRemindService", "Try Run service runningFlag:" + this.qTu.fBn + " timeWait:" + currentTimeMillis + " sending:" + this.qTu.fBm + " recving:" + this.qTu.fBl);
                if (this.qTu.fBn) {
                    if (currentTimeMillis >= 60000) {
                        w.e("MicroMsg.VoiceRemindService", "ERR: Try Run service runningFlag:" + this.qTu.fBn + " timeWait:" + currentTimeMillis + ">=MAX_TIME_WAIT sending:" + this.qTu.fBm + " recving:" + this.qTu.fBl);
                    } else {
                        return;
                    }
                }
                this.qTu.fBn = true;
                this.qTu.fBm = false;
                this.qTu.fBo = 3;
                this.qTu.fBl = false;
                this.qTu.fBs.gSO = SystemClock.elapsedRealtime();
                this.qTu.fBt.v(10, 10);
            }
        });
    }
}
