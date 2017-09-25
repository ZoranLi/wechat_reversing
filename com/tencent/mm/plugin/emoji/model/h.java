package com.tencent.mm.plugin.emoji.model;

import android.content.Context;
import android.content.IntentFilter;
import com.tencent.mm.bj.g.c;
import com.tencent.mm.plugin.emoji.e.a;
import com.tencent.mm.plugin.emoji.e.b;
import com.tencent.mm.plugin.emoji.e.g;
import com.tencent.mm.plugin.emoji.e.j;
import com.tencent.mm.plugin.emoji.e.l;
import com.tencent.mm.plugin.emoji.sync.BKGLoaderManager;
import com.tencent.mm.plugin.emoji.sync.d;
import com.tencent.mm.plugin.emoji.ui.smiley.SmileyPanel;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.aa;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.a.e;
import com.tencent.mm.storage.a.f;
import com.tencent.mm.storage.a.n;
import com.tencent.mm.storage.a.p;
import com.tencent.mm.storage.a.r;
import com.tencent.mm.storage.a.t;
import com.tencent.mm.storage.a.v;
import com.tencent.mm.u.am;
import com.tencent.mm.u.ap;
import java.util.HashMap;

public class h implements am {
    private static HashMap<Integer, c> gJr;
    private c kMh;
    private a kMi;
    private g kMj;
    private i kMk;
    private f kMl;
    private d kMm;
    private com.tencent.mm.plugin.emoji.sync.a<d> kMn;
    private com.tencent.mm.plugin.emoji.e.h kMo;
    private b kMp;
    private l kMq;
    private j kMr;
    private com.tencent.mm.ah.a.a kMs;
    private b kMt;

    public h() {
        ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.emoji.b.c.class)).setEmojiMgrProvider(new com.tencent.mm.plugin.emoji.b.b(this) {
            final /* synthetic */ h kMu;

            {
                this.kMu = r1;
            }

            public final com.tencent.mm.pluginsdk.c.d alt() {
                return h.alY();
            }
        });
    }

    private static h alU() {
        h hVar = (h) ap.yR().gs("plugin.emoji");
        if (hVar == null) {
            synchronized (h.class) {
                if (hVar == null) {
                    hVar = new h();
                    ap.yR().a("plugin.emoji", hVar);
                }
            }
        }
        return hVar;
    }

    public static com.tencent.mm.ah.a.a alV() {
        com.tencent.mm.kernel.h.vG().uQ();
        if (alU().kMs == null) {
            com.tencent.mm.ah.a.a.b.a aVar = new com.tencent.mm.ah.a.a.b.a(ab.getContext());
            aVar.hIB = new com.tencent.mm.plugin.emoji.d.a();
            aVar.hIz = new com.tencent.mm.plugin.emoji.d.b();
            com.tencent.mm.ah.a.a.b Hf = aVar.Hf();
            alU().kMs = new com.tencent.mm.ah.a.a(Hf);
        }
        return alU().kMs;
    }

    public static c alW() {
        com.tencent.mm.kernel.h.vG().uQ();
        if (alU().kMh == null) {
            alU().kMh = new c();
        }
        return alU().kMh;
    }

    public static a alX() {
        com.tencent.mm.kernel.h.vG().uQ();
        if (alU().kMi == null) {
            alU().kMi = new a();
        }
        return alU().kMi;
    }

    public static g alY() {
        com.tencent.mm.kernel.h.vG().uQ();
        if (alU().kMj == null) {
            alU().kMj = new g();
        }
        return alU().kMj;
    }

    public static com.tencent.mm.plugin.emoji.sync.a<d> alZ() {
        com.tencent.mm.kernel.h.vG().uQ();
        if (alU().kMn == null) {
            alU().kMn = new com.tencent.mm.plugin.emoji.sync.a();
        }
        return alU().kMn;
    }

    private static com.tencent.mm.plugin.emoji.e.h ama() {
        com.tencent.mm.kernel.h.vG().uQ();
        if (alU().kMo == null) {
            alU().kMo = new com.tencent.mm.plugin.emoji.e.h();
        }
        return alU().kMo;
    }

    private static b amb() {
        com.tencent.mm.kernel.h.vG().uQ();
        if (alU().kMp == null) {
            alU().kMp = new b();
        }
        return alU().kMp;
    }

    public static l amc() {
        com.tencent.mm.kernel.h.vG().uQ();
        if (alU().kMq == null) {
            alU().kMq = new l();
        }
        return alU().kMq;
    }

    public static j amd() {
        com.tencent.mm.kernel.h.vG().uQ();
        if (alU().kMr == null) {
            alU().kMr = new j();
        }
        return alU().kMr;
    }

    public final void onAccountRelease() {
        com.tencent.mm.plugin.emoji.e.h ama = ama();
        ap.getSysCmdMsgExtension().b("emotionstore", ama.kJX, true);
        ap.getSysCmdMsgExtension().b("NewRecommendEmotion", ama.kJY, true);
        ap.getSysCmdMsgExtension().b("EmojiBackup", ama.kJZ, true);
        ap.getSysCmdMsgExtension().b("EmotionBackup", ama.kJZ, true);
        b amb = amb();
        com.tencent.mm.sdk.b.a.urY.c(amb.kJv);
        com.tencent.mm.sdk.b.a.urY.c(amb.kJz);
        com.tencent.mm.sdk.b.a.urY.c(amb.kJA);
        com.tencent.mm.sdk.b.a.urY.c(amb.kJB);
        com.tencent.mm.sdk.b.a.urY.c(amb.kJC);
        com.tencent.mm.sdk.b.a.urY.c(amb.kJD);
        com.tencent.mm.sdk.b.a.urY.c(amb.kJE);
        com.tencent.mm.sdk.b.a.urY.c(amb.kJF);
        com.tencent.mm.sdk.b.a.urY.c(amb.kJG);
        com.tencent.mm.sdk.b.a.urY.c(amb.kJw);
        com.tencent.mm.sdk.b.a.urY.c(amb.kJx);
        com.tencent.mm.sdk.b.a.urY.c(amb.kJH);
        com.tencent.mm.sdk.b.a.urY.c(amb.kJI);
        com.tencent.mm.sdk.b.a.urY.c(amb.kJy);
        l amc = amc();
        amc.kLa.f(amc.kLt);
        amc.kLb.f(amc.kLr);
        amc.kLc.f(amc.kLs);
        com.tencent.mm.sdk.b.a.urY.c(amc.kLu);
        if (l.kLp != null) {
            l.kLp.clear();
            l.kLp = null;
        }
        if (l.kLq != null) {
            l.kLq.clear();
            l.kLq = null;
        }
        alX().clear();
        ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.emoji.b.c.class)).removeEmojiMgr();
        c alW = alW();
        ap.vd().b(aa.CTRL_BYTE, alW);
        alW.kLE.clear();
        alW.kLC.clear();
        alW.kLH.clear();
        j amd = amd();
        amd.kKH = null;
        if (amd.kKI != null) {
            amd.kKI.clear();
        }
        BKGLoaderManager bKGLoaderManager = alZ().kNA;
        w.d("MicroMsg.BKGLoader.BKGLoaderManager", "bkg detach");
        if (bKGLoaderManager.kNX != null) {
            bKGLoaderManager.kNX.clear();
        }
        if (bKGLoaderManager.kNY != null) {
            bKGLoaderManager.kNY.clear();
        }
        if (bKGLoaderManager.kNZ != null) {
            bKGLoaderManager.kNZ.clear();
        }
        bKGLoaderManager.kNN = false;
        com.tencent.mm.sdk.b.a.urY.c(bKGLoaderManager.kOg);
        com.tencent.mm.sdk.b.a.urY.c(bKGLoaderManager.kOh);
        if (bKGLoaderManager.kOb != null) {
            ab.getContext().unregisterReceiver(bKGLoaderManager.kOb);
            bKGLoaderManager.kOb = null;
        }
        if (this.kMk != null) {
            i iVar = this.kMk;
            com.tencent.mm.sdk.b.a.urY.c(iVar.kMy);
            com.tencent.mm.sdk.b.a.urY.c(iVar.kMz);
        }
        if (this.kMl != null) {
            f fVar = this.kMl;
            fVar.kLR.clear();
            alW().kLG = null;
            fVar.kLS.dead();
        }
        if (this.kMs != null) {
            this.kMs.detach();
        }
        ap.vd().b(697, amf());
    }

    static {
        HashMap hashMap = new HashMap();
        gJr = hashMap;
        hashMap.put(Integer.valueOf("EMOJIINFO_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return f.gUx;
            }
        });
        gJr.put(Integer.valueOf("EMOJIGROUPINFO_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return com.tencent.mm.storage.a.b.gUx;
            }
        });
        gJr.put(Integer.valueOf("EMOJIINFODESC_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return e.gUx;
            }
        });
        gJr.put(Integer.valueOf("EMOTIONDETAIL_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return com.tencent.mm.storage.a.l.gUx;
            }
        });
        gJr.put(Integer.valueOf("GETEMOTIONLISTCACHE_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return r.gUx;
            }
        });
        gJr.put(Integer.valueOf("EmotionRewardINFO_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return n.gUx;
            }
        });
        gJr.put(Integer.valueOf("EmotionDesignerInfoStorage_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return com.tencent.mm.storage.a.j.gUx;
            }
        });
        gJr.put(Integer.valueOf("EmotionRewardTipStorage_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return p.gUx;
            }
        });
        gJr.put(Integer.valueOf("SmileyInfoStorage_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return t.gUx;
            }
        });
        gJr.put(Integer.valueOf("SmileyPanelConfigInfoStorage_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return v.gUx;
            }
        });
        gJr.put(Integer.valueOf("EmojiDescMapStorage".hashCode()), new c() {
            public final String[] pP() {
                return com.tencent.mm.storage.a.h.gUx;
            }
        });
        gJr.put(Integer.valueOf("DELETE".hashCode()), new c() {
            public final String[] pP() {
                return new String[]{"DROP TABLE IF EXISTS EmotionDetail ", "DROP TABLE IF EXISTS EmojiSummaryInfo", "DROP TABLE IF EXISTS RewardMagicInfo"};
            }
        });
    }

    public final HashMap<Integer, c> uh() {
        return gJr;
    }

    public final void eD(int i) {
    }

    public final void aM(boolean z) {
        w.i("MicroMsg.emoji.SubCoreEmoji", "[onAccountPostReset]");
        com.tencent.mm.pluginsdk.ui.chat.e.sQl = new com.tencent.mm.pluginsdk.ui.chat.e.a(this) {
            final /* synthetic */ h kMu;

            {
                this.kMu = r1;
            }

            public final ChatFooterPanel bR(Context context) {
                return new SmileyPanel(context);
            }
        };
        ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.emoji.b.c.class)).setEmojiMgr();
        com.tencent.mm.plugin.emoji.e.h ama = ama();
        ap.getSysCmdMsgExtension().a("emotionstore", ama.kJX, true);
        ap.getSysCmdMsgExtension().a("NewRecommendEmotion", ama.kJY, true);
        ap.getSysCmdMsgExtension().a("EmojiBackup", ama.kJZ, true);
        ap.getSysCmdMsgExtension().a("EmotionBackup", ama.kJZ, true);
        b amb = amb();
        com.tencent.mm.sdk.b.a.urY.b(amb.kJv);
        com.tencent.mm.sdk.b.a.urY.b(amb.kJz);
        com.tencent.mm.sdk.b.a.urY.b(amb.kJA);
        com.tencent.mm.sdk.b.a.urY.b(amb.kJB);
        com.tencent.mm.sdk.b.a.urY.b(amb.kJC);
        com.tencent.mm.sdk.b.a.urY.b(amb.kJD);
        com.tencent.mm.sdk.b.a.urY.b(amb.kJE);
        com.tencent.mm.sdk.b.a.urY.b(amb.kJF);
        com.tencent.mm.sdk.b.a.urY.b(amb.kJG);
        com.tencent.mm.sdk.b.a.urY.b(amb.kJw);
        com.tencent.mm.sdk.b.a.urY.b(amb.kJx);
        com.tencent.mm.sdk.b.a.urY.b(amb.kJH);
        com.tencent.mm.sdk.b.a.urY.b(amb.kJI);
        com.tencent.mm.sdk.b.a.urY.b(amb.kJy);
        l amc = amc();
        amc.kLa.c(amc.kLt);
        amc.kLb.c(amc.kLr);
        amc.kLc.c(amc.kLs);
        com.tencent.mm.sdk.b.a.urY.b(amc.kLu);
        alX();
        j amd = amd();
        String value = com.tencent.mm.i.g.sV().getValue("EmotionRewardTipsLimit");
        if (!bg.mA(value)) {
            w.i("MicroMsg.emoji.EmojiRewardTipMgr", "updateConfig dynamic config %s", new Object[]{value});
            String[] split = value.split(",");
            if (split != null && split.length == 3) {
                amd.kKF = bg.getInt(split[0], 0) == 0 ? 863913600000L : ((long) bg.getInt(split[0], 0)) * 86400000;
                amd.kKG = bg.getInt(split[1], 20) - 1;
                amd.jZR = bg.getInt(split[2], 80) - 1;
            }
        }
        boolean z2 = (com.tencent.mm.i.g.sV().getInt("EmotionRewardOption", 0) & 2) != 2;
        ap.yY();
        boolean z3 = z2 && ((Boolean) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uzS, Boolean.valueOf(true))).booleanValue();
        amd.kKE = z3;
        w.i("MicroMsg.emoji.EmojiRewardTipMgr", "init RewardTipMgr RewardTipEnable:%b isEnableRewardTip:%b isTipsEnable:%b", new Object[]{Boolean.valueOf(amd.kKE), Boolean.valueOf(z2), Boolean.valueOf(r5)});
        ap.vL().D(new Runnable(amd) {
            final /* synthetic */ j kKJ;

            public final void run() {
                /* JADX: method processing error */
/*
Error: java.util.NoSuchElementException
	at java.util.HashMap$HashIterator.nextNode(HashMap.java:1431)
	at java.util.HashMap$KeyIterator.next(HashMap.java:1453)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.applyRemove(BlockFinallyExtract.java:535)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.extractFinally(BlockFinallyExtract.java:175)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.processExceptionHandler(BlockFinallyExtract.java:79)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:51)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
                /*
                r5 = this;
                r0 = r5.kKJ;
                r0 = r0.kKE;
                if (r0 == 0) goto L_0x004b;
            L_0x0006:
                r0 = r5.kKJ;
                r1 = com.tencent.mm.plugin.emoji.model.h.amc();
                r1 = r1.kLh;
                if (r1 == 0) goto L_0x001c;
            L_0x0010:
                r1 = com.tencent.mm.plugin.emoji.model.h.amc();
                r1 = r1.kLh;
                r1 = r1.bNG();
                r0.kKH = r1;
            L_0x001c:
                r0 = r5.kKJ;
                r1 = 0;
                r2 = com.tencent.mm.plugin.emoji.model.h.amc();	 Catch:{ Exception -> 0x004c }
                r2 = r2.kLh;	 Catch:{ Exception -> 0x004c }
                r1 = r2.Kk();	 Catch:{ Exception -> 0x004c }
                if (r1 == 0) goto L_0x0046;	 Catch:{ Exception -> 0x004c }
            L_0x002b:
                r2 = r1.moveToFirst();	 Catch:{ Exception -> 0x004c }
                if (r2 == 0) goto L_0x0046;	 Catch:{ Exception -> 0x004c }
            L_0x0031:
                r2 = new com.tencent.mm.storage.a.o;	 Catch:{ Exception -> 0x004c }
                r2.<init>();	 Catch:{ Exception -> 0x004c }
                r2.b(r1);	 Catch:{ Exception -> 0x004c }
                r3 = r0.kKI;	 Catch:{ Exception -> 0x004c }
                r4 = r2.field_prodcutID;	 Catch:{ Exception -> 0x004c }
                r3.put(r4, r2);	 Catch:{ Exception -> 0x004c }
                r2 = r1.moveToNext();	 Catch:{ Exception -> 0x004c }
                if (r2 != 0) goto L_0x0031;
            L_0x0046:
                if (r1 == 0) goto L_0x004b;
            L_0x0048:
                r1.close();
            L_0x004b:
                return;
            L_0x004c:
                r0 = move-exception;
                r2 = "MicroMsg.emoji.EmojiRewardTipMgr";	 Catch:{ all -> 0x005d }
                r0 = com.tencent.mm.sdk.platformtools.bg.g(r0);	 Catch:{ all -> 0x005d }
                com.tencent.mm.sdk.platformtools.w.w(r2, r0);	 Catch:{ all -> 0x005d }
                if (r1 == 0) goto L_0x004b;
            L_0x0059:
                r1.close();
                goto L_0x004b;
            L_0x005d:
                r0 = move-exception;
                if (r1 == 0) goto L_0x0063;
            L_0x0060:
                r1.close();
            L_0x0063:
                throw r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.emoji.e.j.1.run():void");
            }

            {
                this.kKJ = r1;
            }
        });
        BKGLoaderManager bKGLoaderManager = alZ().kNA;
        w.d("MicroMsg.BKGLoader.BKGLoaderManager", "bkg attach");
        com.tencent.mm.sdk.b.a.urY.b(bKGLoaderManager.kOg);
        com.tencent.mm.sdk.b.a.urY.b(bKGLoaderManager.kOh);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        bKGLoaderManager.kOb = new ConnectivityReceiver(bKGLoaderManager);
        ab.getContext().registerReceiver(bKGLoaderManager.kOb, intentFilter);
        w.i("MicroMsg.emoji.SubCoreEmoji", "[oneliang]initCore");
        amc().alL();
        this.kMk = new i();
        this.kMl = new f();
        com.tencent.mm.ac.a.bf(z);
        ap.vd().a(697, amf());
        com.tencent.mm.bi.f.bKE().bKG();
        com.tencent.mm.bi.e.bKD().YY();
    }

    public final void aN(boolean z) {
    }

    public static d ame() {
        com.tencent.mm.kernel.h.vG().uQ();
        if (alU().kMm == null) {
            alU().kMm = new d();
        }
        return alU().kMm;
    }

    public static b amf() {
        com.tencent.mm.kernel.h.vG().uQ();
        if (alU().kMt == null) {
            alU().kMt = new b();
        }
        return alU().kMt;
    }
}
