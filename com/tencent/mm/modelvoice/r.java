package com.tencent.mm.modelvoice;

import com.tencent.mm.e.b.ce;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import com.tencent.mm.y.d;
import com.tencent.mm.y.d.a;
import com.tencent.mm.y.d.b;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class r implements d {
    private static Set<c> icp = new HashSet();

    public static void c(c cVar) {
        if (!icp.contains(cVar)) {
            icp.add(cVar);
        }
    }

    public static void b(c cVar) {
        icp.remove(cVar);
    }

    public final b b(a aVar) {
        bu buVar = aVar.hst;
        if (buVar == null) {
            w.e("MicroMsg.VoiceMsgExtension", "onPreAddMessage cmdAM is null , give up.");
            return null;
        }
        String a;
        p ax;
        w.i("MicroMsg.VoiceMsgExtension", "summerbadcr parseVoiceMsg srvId:" + buVar.tfk);
        String a2 = n.a(buVar.tfd);
        if (a2.equals(m.xL())) {
            a = n.a(buVar.tfe);
        } else {
            a = a2;
        }
        ce x = ((h) com.tencent.mm.kernel.h.h(h.class)).aJX().x(a, buVar.tfk);
        if (x.field_msgId != 0 && x.field_createTime + 604800000 < ay.i(a, (long) buVar.ogM)) {
            w.w("MicroMsg.VoiceMsgExtension", "dkmsgid prepareMsgInfo msg Too Old Remove it. svrid:%d", Long.valueOf(buVar.tfk));
            ay.j(a, buVar.tfk);
            ax = m.Ly().ax(buVar.tfk);
            if (!(ax == null || bg.mA(ax.fyF))) {
                q.mb(ax.fyF);
            }
        }
        ax = new p();
        ax.fSf = a;
        ax.iam = (long) buVar.ogM;
        ax.fTQ = buVar.tfk;
        ax.gxF = buVar.tfi;
        w.d("MicroMsg.VoiceMsgExtension", "voiceMsgExtension, onPreAddMessage.(MsgSource : %s)", buVar.tfi);
        a = n.a(buVar.tff);
        if (o.dH(a2)) {
            a = ay.gj(a);
            w.i("MicroMsg.VoiceMsgExtension", "chatroom voicemsg, new content=" + a);
        }
        Map q = bh.q(a, "msg");
        if (q == null) {
            g.oUh.a(111, 227, 1, false);
            return null;
        }
        try {
            ax.hYV = Integer.valueOf((String) q.get(".msg.voicemsg.$length")).intValue();
            ax.clientId = (String) q.get(".msg.voicemsg.$clientmsgid");
            int intValue = Integer.valueOf((String) q.get(".msg.voicemsg.$endflag")).intValue();
            int intValue2 = Integer.valueOf((String) q.get(".msg.voicemsg.$cancelflag")).intValue();
            ax.icm = Integer.valueOf((String) q.get(".msg.voicemsg.$voicelength")).intValue();
            ax.iah = (String) q.get(".msg.voicemsg.$fromusername");
            String str = (String) q.get(".msg.commenturl");
            ax.ibl = Integer.valueOf(bg.ap((String) q.get(".msg.voicemsg.$forwardflag"), "0")).intValue();
            ax.ibe = (String) q.get(".msg.voicemsg.$voiceformat");
            ax.icn = bg.getLong((String) q.get(".msg.voicemsg.$bufid"), 0);
            if (intValue2 == 1) {
                w.v("MicroMsg.VoiceMsgExtension", "cancelFlag = 1 srvId:" + buVar.tfk);
                ax = m.Ly().ax(ax.fTQ);
                if (ax != null) {
                    q.lZ(ax.fyF);
                }
                return null;
            }
            if (intValue == 1) {
                w.v("MicroMsg.VoiceMsgExtension", "endFlag = 1 srvId:" + buVar.tfk);
                ax.hrs = ax.hYV;
            }
            ax.fRW = 284334;
            byte[] a3 = n.a(buVar.tfh);
            if (a3 != null) {
                w.d("MicroMsg.VoiceMsgExtension", "Voice Buf Len:" + a3.length + " srvId:" + buVar.tfk);
            }
            if (q.a(ax, a3, buVar.jNB, str, buVar.tfi, aVar) > 0) {
                w.i("MicroMsg.VoiceMsgExtension", "summerbadcr parseVoiceMsg setRecvSync[%d], svrId[%d], msgseq[%d]", Integer.valueOf(q.a(ax, a3, buVar.jNB, str, buVar.tfi, aVar)), Long.valueOf(buVar.tfk), Integer.valueOf(buVar.tfl));
                g.oUh.a(111, 228, 1, false);
                ce x2 = ((h) com.tencent.mm.kernel.h.h(h.class)).aJX().x(ax.fSf, ax.fTQ);
                x2.yF(0);
                for (final c cVar : icp) {
                    af.v(new Runnable(this) {
                        final /* synthetic */ r icr;

                        public final void run() {
                            cVar.A(((h) com.tencent.mm.kernel.h.h(h.class)).aJX().x(ax.fSf, ax.fTQ));
                        }
                    });
                }
                x = x2;
            } else {
                w.i("MicroMsg.VoiceMsgExtension", "summerbadcr parseVoiceMsg setRecvSync[%d], svrId[%d], msgseq[%d], stack[%s]", Integer.valueOf(q.a(ax, a3, buVar.jNB, str, buVar.tfi, aVar)), Long.valueOf(buVar.tfk), Integer.valueOf(buVar.tfl), bg.bJZ());
                x = null;
            }
            boolean z = x != null && x.field_msgId > 0;
            return new b(x, z);
        } catch (Throwable e) {
            g.oUh.a(111, 227, 1, false);
            w.e("MicroMsg.VoiceMsgExtension", "parsing voice msg xml failed");
            w.e("MicroMsg.VoiceMsgExtension", "exception:%s", bg.g(e));
            return null;
        }
    }

    public final void h(au auVar) {
        w.d("MicroMsg.VoiceMsgExtension", "onPreDelMessage " + auVar.field_imgPath + " " + auVar.field_talker);
        if (!o.fq(auVar.field_talker)) {
            q.mb(auVar.field_imgPath);
        }
    }
}
