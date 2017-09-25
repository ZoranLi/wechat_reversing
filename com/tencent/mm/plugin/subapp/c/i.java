package com.tencent.mm.plugin.subapp.c;

import android.os.Message;
import com.tencent.mm.modelvoice.k;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.m;
import com.tencent.mm.y.h;
import com.tencent.mm.y.h.b;

public final class i implements com.tencent.mm.compatible.b.e.a, h {
    private static int fBC = 100;
    public String fyF = "";
    public k fyH = null;
    private int jVa = 0;
    public long lNF = 0;
    protected b qTk;
    protected com.tencent.mm.y.h.a qTl = null;
    public boolean qTm = false;
    private a qTn;
    public long qTo = 0;
    public int qTp = 0;
    private aj qTq = new aj(new com.tencent.mm.sdk.platformtools.aj.a(this) {
        final /* synthetic */ i qTr;

        {
            this.qTr = r1;
        }

        public final boolean oQ() {
            String str = this.qTr.fyF;
            if (str != null) {
                g Hl = h.Hl(str);
                if (Hl == null) {
                    w.d("MicroMsg.VoiceRemindLogic", "startSend null record : " + str);
                } else if (Hl.field_status == 1) {
                    Hl.field_status = 2;
                    Hl.fRW = 64;
                    h.a(Hl);
                }
            }
            d.bna().run();
            w.d("MicroMsg.VoiceRemindRecorder", "Start Send fileName :" + this.qTr.fyF);
            return false;
        }
    }, true);

    private final class a implements Runnable {
        ae handler;
        final /* synthetic */ i qTr;

        public a(final i iVar) {
            this.qTr = iVar;
            this.handler = new ae(this) {
                final /* synthetic */ a qTt;

                public final void handleMessage(Message message) {
                    if (this.qTt.qTr.qTp > 0) {
                        w.d("MicroMsg.VoiceRemindRecorder", "On Part :" + (this.qTt.qTr.qTk == null));
                        this.qTt.qTr.qTp = 2;
                        if (this.qTt.qTr.qTk != null) {
                            this.qTt.qTr.qTk.BF();
                        }
                    }
                }
            };
        }

        public final void run() {
            if (this.qTr.fyH == null) {
                w.e("MicroMsg.VoiceRemindRecorder", "Stop Record Failed recorder == null");
                return;
            }
            synchronized (this.qTr) {
                if (!this.qTr.fyH.bw(h.at(this.qTr.fyF, true))) {
                    i.ma(this.qTr.fyF);
                    this.qTr.fyF = null;
                    w.d("MicroMsg.VoiceRemindRecorder", "Thread Start Record  Error fileName[" + this.qTr.fyF + "]");
                    this.qTr.fyH = null;
                }
                this.qTr.lNF = bg.NA();
                w.d("MicroMsg.VoiceRemindRecorder", "Thread Started Record fileName[" + this.qTr.fyF + "] time:" + bg.aB(this.qTr.qTo));
            }
            this.handler.sendEmptyMessageDelayed(0, 1);
        }
    }

    public final void cW(int i) {
        w.d("MicroMsg.VoiceRemindRecorder", " Recorder onBluetoothHeadsetStateChange :" + i);
        if (!this.qTm) {
            this.qTm = true;
            ap.yZ().b(this);
            this.fyH = new k();
            AnonymousClass2 anonymousClass2 = new com.tencent.mm.y.h.a(this) {
                final /* synthetic */ i qTr;

                {
                    this.qTr = r1;
                }

                public final void onError() {
                    w.e("MicroMsg.VoiceRemindRecorder", "Record Failed file:" + this.qTr.fyF);
                    i.ma(this.qTr.fyF);
                    if (this.qTr.qTl != null) {
                        this.qTr.qTl.onError();
                    }
                }
            };
            this.qTn = new a(this);
            e.post(this.qTn, "VoiceRemindRecorder_record");
            this.qTp = 1;
            this.qTq.v(3000, 3000);
            w.d("MicroMsg.VoiceRemindRecorder", "start end time:" + bg.aB(this.qTo));
        }
    }

    public final int getMaxAmplitude() {
        if (this.fyH == null) {
            return 0;
        }
        int maxAmplitude = this.fyH.getMaxAmplitude();
        if (maxAmplitude > fBC) {
            fBC = maxAmplitude;
        }
        w.d("getMaxAmplitude", " map: " + maxAmplitude + " max:" + fBC + " per:" + ((maxAmplitude * 100) / fBC));
        return (maxAmplitude * 100) / fBC;
    }

    public final String getFileName() {
        return this.fyF;
    }

    public final boolean pm() {
        if (this.fyH != null && this.fyH.mStatus == 1) {
            return true;
        }
        return false;
    }

    public final boolean bx(String str) {
        String lu = k.lu(m.xL());
        g gVar = new g();
        gVar.field_filename = lu;
        gVar.field_user = str;
        gVar.field_createtime = System.currentTimeMillis() / 1000;
        gVar.field_clientid = lu;
        gVar.field_lastmodifytime = System.currentTimeMillis() / 1000;
        gVar.field_status = 1;
        gVar.field_human = m.xL();
        gVar.fRW = -1;
        k bmZ = d.bmZ();
        w.d("MicroMsg.VoiceRemindStorage", "VoiceRemindStorage Insert");
        int insert = (int) bmZ.gUz.insert("VoiceRemindInfo", "", gVar.pv());
        w.d("MicroMsg.VoiceRemindStorage", "VoiceRemindStorage Insert result" + insert);
        if (insert == -1) {
            lu = null;
        }
        this.fyF = lu;
        ap.yZ().a(this);
        int qG = ap.yZ().qG();
        this.qTm = false;
        if (qG != 0) {
            cW(100);
        } else {
            new ae(this) {
                final /* synthetic */ i qTr;

                {
                    this.qTr = r1;
                }

                public final void handleMessage(Message message) {
                    w.d("MicroMsg.VoiceRemindRecorder", " Recorder handleMessage");
                    if (!this.qTr.qTm) {
                        ap.yZ().b(this.qTr);
                        ap.yZ().qH();
                        this.qTr.cW(com.tencent.mm.plugin.appbrand.jsapi.map.m.CTRL_INDEX);
                    }
                }
            }.sendEmptyMessageDelayed(0, 50);
        }
        return false;
    }

    public final boolean cancel() {
        w.d("MicroMsg.VoiceRemindRecorder", "cancel Record :" + this.fyF);
        synchronized (this) {
            w.d("MicroMsg.VoiceRemindRecorder", "stop synchronized Record :" + this.fyF);
            if (this.fyH != null) {
                this.fyH.oX();
            }
        }
        String str = this.fyF;
        if (str != null) {
            w.d("MicroMsg.VoiceRemindLogic", "Mark Canceled fileName[" + str + "]");
            g Hl = h.Hl(str);
            if (Hl != null) {
                Hl.field_status = 8;
                Hl.field_totallen = c.lx(h.at(str, false));
                Hl.fRW = 64;
                h.a(Hl);
            }
        }
        d.bna().run();
        this.fyF = "";
        return true;
    }

    public final boolean pd() {
        boolean z = true;
        boolean z2 = false;
        ap.yZ().qH();
        w.d("MicroMsg.VoiceRemindRecorder", "stop Record :" + this.fyF);
        synchronized (this) {
            w.d("MicroMsg.VoiceRemindRecorder", "stop synchronized Record :" + this.fyF);
            if (this.fyH != null) {
                this.fyH.oX();
            }
        }
        if (this.qTp != 2) {
            h.ma(this.fyF);
            this.fyF = null;
            w.d("MicroMsg.VoiceRemindRecorder", "Stop " + this.fyF + " by not onPart: " + bg.aB(this.qTo));
        } else {
            this.jVa = (int) pn();
            if (((long) this.jVa) < 800 || ((long) this.jVa) < 1000) {
                w.d("MicroMsg.VoiceRemindRecorder", "Stop " + this.fyF + " by voiceLen: " + this.jVa);
                h.ma(this.fyF);
                this.fyF = "";
                z = false;
            } else {
                String str = this.fyF;
                int i = this.jVa;
                if (str != null) {
                    w.d("MicroMsg.VoiceRemindLogic", "StopRecord fileName[" + str + "]");
                    g Hl = h.Hl(str);
                    if (Hl != null) {
                        if (!(Hl.field_status == 97 || Hl.field_status == 98)) {
                            Hl.field_status = 3;
                        }
                        Hl.field_totallen = c.lx(h.at(str, false));
                        if (Hl.field_totallen <= 0) {
                            h.lA(str);
                        } else {
                            Hl.field_lastmodifytime = System.currentTimeMillis() / 1000;
                            Hl.field_voicelenght = i;
                            Hl.fRW = 3424;
                            au auVar = new au();
                            auVar.cH(Hl.field_user);
                            auVar.setType(34);
                            auVar.dw(1);
                            auVar.cI(str);
                            if (Hl.field_status == 97) {
                                auVar.dv(2);
                                auVar.setContent(f.b(Hl.field_human, (long) Hl.field_voicelenght, false));
                            } else if (Hl.field_status == 98) {
                                auVar.dv(5);
                                auVar.setContent(f.b(Hl.field_human, -1, true));
                            } else {
                                auVar.dv(1);
                            }
                            auVar.z(ay.gk(Hl.field_user));
                            Hl.field_msglocalid = (int) ay.i(auVar);
                            h.a(Hl);
                        }
                    }
                }
                d.bna().run();
                w.d("MicroMsg.VoiceRemindRecorder", "Stop file success: " + this.fyF);
            }
            this.fyF = "";
            z2 = z;
        }
        this.qTp = -1;
        return z2;
    }

    public final long pn() {
        if (this.lNF <= 0) {
            return 0;
        }
        return bg.aB(this.lNF);
    }

    public final void reset() {
        if (this.fyH != null) {
            this.fyH.oX();
            w.e("MicroMsg.VoiceRemindRecorder", "Reset recorder.stopReocrd");
        }
        this.fyF = "";
        this.qTo = 0;
        this.qTn = null;
        this.qTp = 0;
        this.lNF = 0;
    }

    public final int pl() {
        return this.jVa;
    }

    public final void a(com.tencent.mm.y.h.a aVar) {
        this.qTl = aVar;
    }

    public final void a(b bVar) {
        this.qTk = bVar;
    }

    public static boolean ma(String str) {
        return h.ma(str);
    }

    public final int pp() {
        return 0;
    }
}
