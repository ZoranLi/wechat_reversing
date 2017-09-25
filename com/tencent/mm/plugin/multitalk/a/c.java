package com.tencent.mm.plugin.multitalk.a;

import android.content.Context;
import com.tencent.mm.c.b.c.a;
import com.tencent.mm.compatible.d.l;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.pb.talkroom.sdk.b;
import com.tencent.pb.talkroom.sdk.d;

public final class c implements e {
    public a fAv = new a(this) {
        final /* synthetic */ c nOZ;

        {
            this.nOZ = r1;
        }

        public final void d(byte[] bArr, int i) {
            if (i <= 0) {
                w.e("MicroMsg.MT.MultiTalkEngine", "pcm data len <= 0");
            } else if (this.nOZ.nOW != null) {
                this.nOZ.nOW.C(bArr, i);
            }
        }

        public final void ax(int i, int i2) {
            w.i("MicroMsg.MT.MultiTalkEngine", "OnPcmRecListener onRecError %d %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        }
    };
    public d nOT;
    public b nOU;
    public com.tencent.mm.c.b.c nOV;
    public com.tencent.pb.talkroom.sdk.c nOW;
    public b nOX;
    public com.tencent.mm.plugin.voip.model.a nOY = new com.tencent.mm.plugin.voip.model.a(this) {
        final /* synthetic */ c nOZ;

        {
            this.nOZ = r1;
        }

        public final int x(byte[] bArr, int i) {
            int B;
            if (this.nOZ.nOX != null) {
                B = this.nOZ.nOX.B(bArr, i);
            } else {
                B = 0;
            }
            if (B < 0) {
                return -1;
            }
            return 0;
        }
    };

    public c() {
        w.i("MicroMsg.MT.MultiTalkEngine", "init multiTalk engine");
        Context context = ab.getContext();
        d chx = com.tencent.wecall.talkroom.model.e.chx();
        com.tencent.wecall.talkroom.model.e.hK(context);
        this.nOT = chx;
        this.nOT.cdo();
        this.nOU = new b();
        int f = bg.f((Integer) ap.yW().get(1));
        this.nOT.a(o.aNn(), new com.tencent.pb.talkroom.sdk.e(this) {
            final /* synthetic */ c nOZ;

            {
                this.nOZ = r1;
            }

            public final boolean l(int i, String str, String str2) {
                switch (i) {
                    case 0:
                        w.v(str, str2);
                        break;
                    case 1:
                        w.d(str, str2);
                        break;
                    case 2:
                        w.i(str, str2);
                        break;
                    case 3:
                        w.w(str, str2);
                        break;
                    case 4:
                        w.e(str, str2);
                        break;
                    case 5:
                        w.f(str, str2);
                        break;
                    default:
                        w.v(str, str2);
                        break;
                }
                return false;
            }

            public final boolean b(int i, int i2, byte[] bArr) {
                w.i("MicroMsg.MT.MultiTalkEngine", "sendMultiTalkReq " + i + " cmdid " + i2);
                ap.vd().a(new n(i, i2, bArr), 0);
                return false;
            }

            public final boolean aMA() {
                int rl = l.rl();
                w.i("MicroMsg.MT.MultiTalkEngine", "loadVoipCodecLib cpuFlag:" + rl);
                if ((rl & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
                    com.tencent.mm.compatible.loader.d.u(ab.getContext(), "libvoipCodec_v7a.so");
                } else if ((rl & 512) != 0) {
                    com.tencent.mm.compatible.loader.d.u(ab.getContext(), "libvoipCodec.so");
                } else {
                    com.tencent.mm.compatible.loader.d.u(ab.getContext(), "libvoipCodec_v5.so");
                }
                return true;
            }

            public final int rl() {
                return l.rl();
            }

            public final int aMB() {
                ap.yY();
                String bMU = com.tencent.mm.u.c.vs().bMU();
                p.du(bMU);
                w.i("MicroMsg.MT.MultiTalkEngine", "MTSDK audioAdapter startRecord setMultiTalkAppCmd info: " + bMU);
                return this.nOZ.nOT.a(p.gRd.gOa, p.gRd.gOc, p.gRd.gOb, p.gRd.gOd, p.gRd.gOg, p.gRd.gOh, p.gRd.gOi, p.gRd.gOj, p.gRd.gNX, p.gRd.gNY, p.gRd.gOz, p.gRd.gOA, p.gRd.gOB, p.gRd.gOC);
            }

            public final boolean fP(boolean z) {
                w.i("MicroMsg.MT.MultiTalkEngine", "setMultiTalkSpeaker %b", new Object[]{Boolean.valueOf(z)});
                this.nOZ.nOU.eW(z);
                return true;
            }

            public final int a(int i, int i2, b bVar) {
                int i3;
                this.nOZ.nOX = bVar;
                Object obj = this.nOZ.nOU;
                com.tencent.mm.plugin.voip.model.a aVar = this.nOZ.nOY;
                if (obj.fOV) {
                    w.d("MicroMsg.MT.MultiTalkAudioPlayer", "startPlay, already start");
                    i3 = -1;
                } else {
                    w.i("MicroMsg.MT.MultiTalkAudioPlayer", "startPlay");
                    if (obj.mOt == null) {
                        obj.mOt = new com.tencent.mm.plugin.voip.model.b();
                        obj.mOt.O(i, i2, 0);
                    }
                    obj.mOt.j(ab.getContext(), false);
                    obj.mOt.reE = aVar;
                    ap.yZ().a(obj);
                    obj.mOH = ap.yZ().qO();
                    obj.mOG = ap.yZ().qI();
                    w.i("MicroMsg.MT.MultiTalkAudioPlayer", "startPlay, isHeadsetPlugged: %b, isBluetoothConnected: %b", new Object[]{Boolean.valueOf(obj.mOH), Boolean.valueOf(obj.mOG)});
                    i3 = obj.mOt.boX();
                    obj.ict.requestFocus();
                    obj.mOC.a(ab.getContext(), obj);
                    obj.fOV = true;
                }
                w.i("MicroMsg.MT.MultiTalkEngine", "isSpeakerOn=%b isHandsFree=%b", new Object[]{Boolean.valueOf(ap.yZ().qN()), Boolean.valueOf(o.aNn().nPg)});
                if (ap.yZ().qN() != o.aNn().nPg) {
                    this.nOZ.nOU.eW(o.aNn().nPg);
                }
                return i3;
            }

            public final int a(int i, int i2, com.tencent.pb.talkroom.sdk.c cVar) {
                this.nOZ.nOW = cVar;
                this.nOZ.nOV = new com.tencent.mm.c.b.c(i, 7);
                this.nOZ.nOV.cY(i2);
                this.nOZ.nOV.at(true);
                this.nOZ.nOV.pe();
                this.nOZ.nOV.fzT = -19;
                this.nOZ.nOV.r(1, false);
                this.nOZ.nOV.as(true);
                this.nOZ.nOV.fAe = this.nOZ.fAv;
                if (this.nOZ.nOV.pf()) {
                    return 1;
                }
                return -1;
            }

            public final boolean aMC() {
                w.i("MicroMsg.MT.MultiTalkEngine", "stopMultiTalkPlayer");
                Object obj = this.nOZ.nOU;
                if (obj.fOV) {
                    w.i("MicroMsg.MT.MultiTalkAudioPlayer", "stopPlay");
                    synchronized (obj.mOu) {
                        com.tencent.mm.sdk.f.e.post(new a(obj, obj.mOt), "MultiTalkAudioPlayer_stop");
                        obj.fOV = false;
                        obj.mOt = null;
                    }
                    obj.mOC.cS(ab.getContext());
                    ap.yZ().b(obj);
                    obj.ict.rY();
                }
                return true;
            }

            public final boolean aMD() {
                w.i("MicroMsg.MT.MultiTalkEngine", "stopMultiTalkRecord");
                try {
                    if (this.nOZ.nOV != null) {
                        this.nOZ.nOV.fAe = null;
                        this.nOZ.nOV.oX();
                    }
                    this.nOZ.nOV = null;
                    return true;
                } catch (Exception e) {
                    w.w("MicroMsg.MT.MultiTalkEngine", "stopMultiTalkPlayer :" + e);
                    return false;
                }
            }

            public final int aME() {
                int i = 0;
                w.i("MicroMsg.MT.MultiTalkEngine", "getMultiTalkPlayVolume");
                if (this.nOZ.nOU != null) {
                    b bVar = this.nOZ.nOU;
                    if (bVar.mOt != null) {
                        i = bVar.mOt.bpb();
                    }
                }
                return (int) ((((float) ap.yZ().getStreamVolume(i)) / ((float) ap.yZ().getStreamMaxVolume(i))) * 100.0f);
            }

            public final int aMF() {
                w.i("MicroMsg.MT.MultiTalkEngine", "getMultiTalkRecordReadNum");
                if (this.nOZ.nOV != null) {
                    return this.nOZ.nOV.ph();
                }
                return -2;
            }
        });
        this.nOT.aK(f, m.xL());
        ap.vd().a(1918, this);
        ap.vd().a(1919, this);
        ap.vd().a(1927, this);
        ap.vd().a(1928, this);
        ap.vd().a(1929, this);
        ap.vd().a(1931, this);
        ap.vd().a(1932, this);
        ap.vd().a(1933, this);
        ap.vd().a(1935, this);
        ap.vd().a(1937, this);
        ap.vd().a(1938, this);
        ap.vd().a(1939, this);
    }

    public final void a(int i, int i2, String str, k kVar) {
        n nVar = (n) kVar;
        w.i("MicroMsg.MT.MultiTalkEngine", "onSceneEnd errtype " + i + " errCode " + i2 + " cmdid " + nVar.lau);
        this.nOT.c(i2, nVar.las, nVar.lau, nVar.fYC);
    }
}
