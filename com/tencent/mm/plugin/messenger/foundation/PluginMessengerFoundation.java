package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.ao.j;
import com.tencent.mm.kernel.api.bucket.a;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.d;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.chatroom.b;
import com.tencent.mm.plugin.messenger.foundation.a.g;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.plugin.zero.PluginZero;
import com.tencent.mm.protocal.c.ame;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.av;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bc;
import com.tencent.mm.u.bp;
import com.tencent.mm.u.e;
import com.tencent.mm.u.l;
import java.util.HashMap;

public class PluginMessengerFoundation extends d implements a, c, com.tencent.mm.kernel.api.bucket.d, n {
    private e hmf = new e();
    private bp nyA = new bp();
    private b nyB = new b();
    private d nyy;
    private e nyz;

    public void installed() {
        alias(n.class);
    }

    public void dependency() {
        dependsOn(PluginZero.class);
    }

    public void configure(com.tencent.mm.kernel.b.e eVar) {
        w.i("MicroMsg.TAG", "init thread pool[%s] current tid[%d] priority[%d] process[%s]", com.tencent.mm.sdk.f.e.bKs(), Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(Thread.currentThread().getPriority()), ((f) h.vF().vj()).gWO);
        com.tencent.mm.plugin.zero.c.sBe = new com.tencent.mm.bn.b<com.tencent.mm.plugin.zero.a.f>(this) {
            final /* synthetic */ PluginMessengerFoundation nyC;

            {
                this.nyC = r1;
            }

            public final /* synthetic */ Object get() {
                return new f();
            }
        };
        p aVar = new a();
        p.a.a(2, aVar);
        p.a.a(17, aVar);
        p.a.a(4, aVar);
        p.a.a(7, new b());
        aVar = new c();
        p.a.a(5, aVar);
        p.a.a(8, aVar);
        p.a.a(9, aVar);
        p.a.a(1, new g());
        h.vE().a(o.class, new com.tencent.mm.kernel.c.c(new com.tencent.mm.modelmulti.o()));
        com.tencent.mm.plugin.zero.a.d dVar = (com.tencent.mm.plugin.zero.a.d) h.j(com.tencent.mm.plugin.zero.a.d.class);
        if (eVar.ej("")) {
            new com.tencent.mm.plugin.zero.tasks.b().after(dVar).before(this);
            h.a(com.tencent.mm.plugin.messenger.foundation.a.c.class, new com.tencent.mm.plugin.messenger.foundation.a.c(this) {
                final /* synthetic */ PluginMessengerFoundation nyC;

                {
                    this.nyC = r1;
                }

                public final void a(ame com_tencent_mm_protocal_c_ame, String str, byte[] bArr, boolean z, boolean z2) {
                    a.a(com_tencent_mm_protocal_c_ame, str, null, true, false);
                }

                public final com.tencent.mm.vending.b.b a(com.tencent.mm.plugin.messenger.foundation.a.b bVar) {
                    return a.a(bVar);
                }
            });
            h.a(g.class, new g(this) {
                final /* synthetic */ PluginMessengerFoundation nyC;

                {
                    this.nyC = r1;
                }

                public final void a(com.tencent.mm.y.d.a aVar, r rVar) {
                    c.a(aVar, rVar);
                }
            });
            h.a(com.tencent.mm.plugin.chatroom.b.a.class, this.nyB);
        }
    }

    public void execute(com.tencent.mm.kernel.b.e eVar) {
        if (eVar.ej("")) {
            this.nyy = new d();
            h.a(com.tencent.mm.plugin.messenger.foundation.a.h.class, new com.tencent.mm.kernel.c.c(this.nyy));
            this.nyz = new e();
            h.a(i.class, new com.tencent.mm.kernel.c.c(this.nyz));
        }
    }

    public String toString() {
        return "plugin-messenger-foundation";
    }

    public HashMap<Integer, com.tencent.mm.bj.g.c> collectDatabaseFactory() {
        HashMap<Integer, com.tencent.mm.bj.g.c> hashMap = new HashMap();
        hashMap.put(Integer.valueOf("MESSAGE_TABLE".hashCode()), new com.tencent.mm.bj.g.c(this) {
            final /* synthetic */ PluginMessengerFoundation nyC;

            {
                this.nyC = r1;
            }

            public final String[] pP() {
                return av.gUx;
            }
        });
        hashMap.put(Integer.valueOf("CONTACT_TABLE".hashCode()), new com.tencent.mm.bj.g.c(this) {
            final /* synthetic */ PluginMessengerFoundation nyC;

            {
                this.nyC = r1;
            }

            public final String[] pP() {
                return ad.gUx;
            }
        });
        hashMap.put(Integer.valueOf("OPLOG_TABLE".hashCode()), new com.tencent.mm.bj.g.c(this) {
            final /* synthetic */ PluginMessengerFoundation nyC;

            {
                this.nyC = r1;
            }

            public final String[] pP() {
                return j.gUx;
            }
        });
        hashMap.put(Integer.valueOf("CONVERSATION_TABLE".hashCode()), new com.tencent.mm.bj.g.c(this) {
            final /* synthetic */ PluginMessengerFoundation nyC;

            {
                this.nyC = r1;
            }

            public final String[] pP() {
                return af.gUx;
            }
        });
        hashMap.put(Integer.valueOf("ROLEINFO_TABLE".hashCode()), new com.tencent.mm.bj.g.c(this) {
            final /* synthetic */ PluginMessengerFoundation nyC;

            {
                this.nyC = r1;
            }

            public final String[] pP() {
                return az.gUx;
            }
        });
        hashMap.put(Integer.valueOf("STRANGER_TABLE".hashCode()), new com.tencent.mm.bj.g.c(this) {
            final /* synthetic */ PluginMessengerFoundation nyC;

            {
                this.nyC = r1;
            }

            public final String[] pP() {
                return bc.gUx;
            }
        });
        hashMap.put(Integer.valueOf("DeletedConversationInfo".hashCode()), new com.tencent.mm.bj.g.c(this) {
            final /* synthetic */ PluginMessengerFoundation nyC;

            {
                this.nyC = r1;
            }

            public final String[] pP() {
                return ai.gUx;
            }
        });
        return hashMap;
    }

    public void onAccountInitialized(com.tencent.mm.kernel.e.f fVar) {
        com.tencent.mm.y.d.c.a(Integer.valueOf(10000), this.hmf);
        com.tencent.mm.y.d.c.a(Integer.valueOf(1), this.hmf);
        com.tencent.mm.y.d.c.a(Integer.valueOf(CdnLogic.MediaType_FAVORITE_FILE), this.nyA);
        com.tencent.mm.y.d.c.a(Integer.valueOf(CdnLogic.MediaType_FAVORITE_VIDEO), this.nyA);
    }

    public void onAccountRelease() {
        com.tencent.mm.y.d.c.aA(Integer.valueOf(10000));
        com.tencent.mm.y.d.c.aA(Integer.valueOf(1));
        com.tencent.mm.y.d.c.a(Integer.valueOf(CdnLogic.MediaType_FAVORITE_FILE), this.nyA);
        com.tencent.mm.y.d.c.a(Integer.valueOf(CdnLogic.MediaType_FAVORITE_VIDEO), this.nyA);
    }

    public void onDataBaseOpened(com.tencent.mm.bj.g gVar, com.tencent.mm.bj.g gVar2) {
        d dVar = this.nyy;
        dVar.nyv = new com.tencent.mm.ao.r(new j(gVar));
        dVar.nyr = new ad(gVar);
        dVar.nys = new bc(gVar);
        dVar.nyu = new af(gVar);
        dVar.nyt = new av(gVar, dVar.nyr, dVar.nyu);
        dVar.nyt.a(dVar.nyu, null);
        dVar.nyw = new az(gVar);
        dVar.nyx = new ai(gVar);
        l.xJ();
    }

    public void onDataBaseClosed(com.tencent.mm.bj.g gVar, com.tencent.mm.bj.g gVar2) {
    }

    public bp getSysCmdMsgExtension() {
        return this.nyA;
    }
}
