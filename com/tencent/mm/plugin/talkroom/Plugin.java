package com.tencent.mm.plugin.talkroom;

import com.tencent.mm.e.a.im;
import com.tencent.mm.e.a.qj;
import com.tencent.mm.e.a.qk;
import com.tencent.mm.e.a.qm;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.am;

public class Plugin implements com.tencent.mm.pluginsdk.d.c {

    private class a extends com.tencent.mm.sdk.b.c<qj> {
        final /* synthetic */ Plugin qXb;

        private a(Plugin plugin) {
            this.qXb = plugin;
            this.usg = qj.class.getName().hashCode();
        }

        /* synthetic */ a(Plugin plugin, byte b) {
            this(plugin);
            this.usg = qj.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            qj qjVar = (qj) bVar;
            if (!(qjVar instanceof qj)) {
                w.f("MicroMsg.TalkRoomReportMgrListener", "mismatch %s", new Object[]{qjVar.getClass().getName()});
            } else if (qjVar.fXs.fXt) {
                com.tencent.mm.plugin.talkroom.model.b.bnE().qYh = 1;
                return true;
            }
            return false;
        }
    }

    private static class b extends com.tencent.mm.sdk.b.c<qk> {
        private b() {
            this.usg = qk.class.getName().hashCode();
        }

        /* synthetic */ b(byte b) {
            this();
            this.usg = qk.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            qk qkVar = (qk) bVar;
            if (qkVar != null) {
                if (!(qkVar instanceof qk)) {
                    w.f("MicroMsg.TalkRoomServerListener", "mismatch %s", new Object[]{qkVar.getClass().getName()});
                } else if (qkVar.fXu.fXx) {
                    com.tencent.mm.plugin.talkroom.model.b.bnB().aGN();
                    return true;
                } else if (!(!qkVar.fXu.fXw || qkVar.fXv == null || com.tencent.mm.plugin.talkroom.model.b.bnB() == null)) {
                    qkVar.fXv.fXy = com.tencent.mm.plugin.talkroom.model.b.bnB().qYD;
                    return true;
                }
            }
            return false;
        }
    }

    private class c extends com.tencent.mm.sdk.b.c<qm> {
        final /* synthetic */ Plugin qXb;

        private c(Plugin plugin) {
            this.qXb = plugin;
            this.usg = qm.class.getName().hashCode();
        }

        /* synthetic */ c(Plugin plugin, byte b) {
            this(plugin);
            this.usg = qm.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            if (!(((qm) bVar) instanceof qm)) {
                w.f("MicroMsg.TalkRoom.Plugin", "mismatch %s", new Object[]{((qm) bVar).getClass().getName()});
            }
            return false;
        }
    }

    public Plugin() {
        com.tencent.mm.sdk.b.a.urY.b(new com.tencent.mm.sdk.b.c<im>(this) {
            final /* synthetic */ Plugin qXb;

            {
                this.qXb = r2;
                this.usg = im.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                switch (((im) bVar).fOk.status) {
                    case 0:
                        if (com.tencent.mm.plugin.talkroom.model.b.bnB() != null) {
                            com.tencent.mm.plugin.talkroom.model.b.bnB().aGN();
                            break;
                        }
                        break;
                }
                return false;
            }
        });
        com.tencent.mm.sdk.b.a.urY.b(new b());
        com.tencent.mm.sdk.b.a.urY.b(new a());
        com.tencent.mm.sdk.b.a.urY.b(new c());
    }

    public k createApplication() {
        return new a();
    }

    public com.tencent.mm.pluginsdk.d.b getContactWidgetFactory() {
        return null;
    }

    public am createSubCore() {
        return new com.tencent.mm.plugin.talkroom.model.b();
    }
}
