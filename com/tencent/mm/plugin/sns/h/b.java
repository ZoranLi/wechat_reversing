package com.tencent.mm.plugin.sns.h;

import android.os.Process;
import com.tencent.mm.e.a.pj;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.ai;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.protocal.c.rk;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.o;
import java.util.HashSet;
import java.util.Iterator;

public final class b {
    int gKQ;
    c gKr;
    public int kaN;
    public int qbA;
    public int qbB;
    public int qbC;
    public int qbD;
    public String qbE;
    public String qbF;
    String qbG;
    int qbH;
    public int qbI;
    public int qbJ;
    public int qbK;
    public int qbL;
    public int qbM;
    public int qbN;
    public int qbO;
    public int qbP;
    int qbQ;
    int qbR;
    int qbS;
    int qbT;
    int qbU;
    int qbV;
    public int qbW;
    public int qbX;
    int qbY;
    int qbZ;
    public boolean qbp;
    public long qbq;
    public long qbr;
    public int qbs;
    int qbt;
    int qbu;
    int qbv;
    public int qbw;
    public int qbx;
    int qby;
    public int qbz;
    long qcA;
    long qcB;
    long qcC;
    long qcD;
    String qcE;
    int qcF;
    long qcG;
    private long qcH;
    long qcI;
    private long qcJ;
    private HashSet<String> qcK;
    HashSet<String> qcL;
    public HashSet<String> qcM;
    HashSet<String> qcN;
    public HashSet<String> qcO;
    HashSet<String> qcP;
    HashSet<String> qcQ;
    public HashSet<String> qcR;
    public HashSet<String> qcS;
    HashSet<String> qcT;
    public HashSet<String> qcU;
    private HashSet<String> qcV;
    public HashSet<String> qcW;
    public HashSet<String> qcX;
    public int qcY;
    public int qcZ;
    public long qca;
    public long qcb;
    long qcc;
    long qcd;
    long qce;
    long qcf;
    long qcg;
    long qch;
    long qci;
    long qcj;
    long qck;
    long qcl;
    long qcm;
    long qcn;
    long qco;
    long qcp;
    long qcq;
    long qcr;
    long qcs;
    long qct;
    long qcu;
    long qcv;
    long qcw;
    long qcx;
    long qcy;
    long qcz;
    public HashSet<String> qda;
    public HashSet<String> qdb;
    public HashSet<String> qdc;
    public HashSet<String> qdd;
    public HashSet<String> qde;
    public HashSet<String> qdf;
    public HashSet<String> qdg;
    public HashSet<String> qdh;
    public HashSet<String> qdi;
    public HashSet<String> qdj;
    public HashSet<String> qdk;
    public HashSet<String> qdl;
    public long qdm;

    class AnonymousClass2 implements Runnable {
        final /* synthetic */ b qdn;
        final /* synthetic */ int qdo;

        public AnonymousClass2(b bVar, int i) {
            this.qdn = bVar;
            this.qdo = i;
        }

        public final void run() {
            int myTid = Process.myTid();
            w.i("MicroMsg.SnsBrowseInfoHelper", "summersns report tid[%d] osTid[%d], prior[%d][%d]", new Object[]{Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(myTid), Integer.valueOf(Thread.currentThread().getPriority()), Integer.valueOf(Process.getThreadPriority(myTid))});
            long currentTimeMillis = System.currentTimeMillis();
            b bVar = this.qdn;
            int i = this.qdo;
            if (i != -1) {
                m tf = ai.tf(i);
                if (tf != null) {
                    String g = i.g(tf);
                    bVar.qbG = g;
                    rk bhp = ae.beO().Gk("@__weixintimtline").bhp();
                    if (bhp.twW == 0 || i.dg(bhp.twW).compareTo(g) <= 0) {
                        bVar.hB(false);
                    } else {
                        bVar.hB(true);
                    }
                }
            }
            i = o.yB();
            d dVar = new d();
            dVar.n("20BrowseTime", bVar.qbr + ",");
            dVar.n("21BrowseFeedCount", bVar.qbs + ",");
            dVar.n("22CommentOrLikeFeedCount", bVar.qbt + ",");
            dVar.n("23ClickFeedCount", bVar.qbu + ",");
            dVar.n("24ClickAlbumCount", bVar.qbv + ",");
            dVar.n("25PostFeedCount", bVar.qbw + ",");
            dVar.n("26ExposeFeedCount", bVar.qcM.size() + ",");
            dVar.n("27FavFeedCount", bVar.qcN.size() + ",");
            dVar.n("28BlackListFriendCount", bVar.qbz + ",");
            dVar.n("29OutsiderFriendCount", bVar.qbA + ",");
            dVar.n("30BrowseNewFeedCount", bVar.qbB + ",");
            dVar.n("31HasNewSnsMsgWhenEntrance", bVar.qbC + ",");
            dVar.n("32HasNewChatMsgWhenExit", bVar.qbD + ",");
            dVar.n("33StartBrowseSnsObjectId", bVar.qbE + ",");
            dVar.n("34EndBrowseSnsObjectId", bVar.qbF + ",");
            dVar.n("35NextBrowseSnsObjectId", bVar.qbG + ",");
            dVar.n("36HasNewFeedInServer", bVar.qbH + ",");
            dVar.n("37BrowseBrandUrlFeedCount", bVar.qbI + ",");
            dVar.n("38BrowseNotBrandUrlFeedCount", bVar.qbJ + ",");
            dVar.n("39BrowseTextFeedCount", bVar.qbK + ",");
            dVar.n("40BrowseImageFeedCount", bVar.qbL + ",");
            dVar.n("41BrowseSightFeedCount", bVar.qbM + ",");
            dVar.n("42BrowseAdFeedCount", bVar.qbN + ",");
            dVar.n("43BrowseMusicFeedCount", bVar.qbO + ",");
            dVar.n("44contactCount", i + ",");
            dVar.n("BrowseVideoFeedCount45", bVar.qbP + ",");
            dVar.n("ClickBrandUrlFeedCount46", bVar.qbQ + ",");
            dVar.n("ClickNotBrandUrlFeedCount47", bVar.qbR + ",");
            dVar.n("ClickImageFeedCount48", bVar.qbS + ",");
            dVar.n("ClickSightFeedCount49", bVar.qbT + ",");
            dVar.n("ClickMusicFeedCount50", bVar.qbU + ",");
            dVar.n("ClickVideoFeedCount51", bVar.qbV + ",");
            dVar.n("BrowseOtherFeedCount52", bVar.qbW + ",");
            dVar.n("BrowserStreamVideoFeedCount53", bVar.qbX + ",");
            dVar.n("ClickStreamVideoCount54", bVar.qbY + ",");
            dVar.n("ClickAdFeed55", bVar.qbZ + ",");
            dVar.n("56BackGroundTime", bVar.qca + ",");
            dVar.n("57BrowseTimeLineTime", bVar.qcc + ",");
            dVar.n("58BrowseMyAlbumTime", bVar.qce + ",");
            dVar.n("59BrowseOtherAlbumTime", bVar.qcg + ",");
            dVar.n("60BrowseMessageListTime", bVar.qci + ",");
            dVar.n("61ClickNewPostTime", bVar.qck + ",");
            dVar.n("62BrowseFullScreenImageTime", bVar.qcm + ",");
            dVar.n("63BrowseFullScreenSightTime", bVar.qco + ",");
            dVar.n("64BrowseMPArticleTime", bVar.qcq + ",");
            dVar.n("65BrowseExternalArticleTime", bVar.qcs + ",");
            dVar.n("66BrowseFullScreenAdImageTime", bVar.qcu + ",");
            dVar.n("67BrowseAdSightTime", "0,");
            dVar.n("68BrowseAdDetailTime", bVar.qcw + ",");
            dVar.n("69BrowseFullScreenAdSightTime", bVar.qcy + ",");
            dVar.n("70BrowseFullScreenAdLongVideoTime", bVar.qcA + ",");
            dVar.n("71BrowseForwardAdLongVideoTime", bVar.qcC + ",");
            dVar.n("72StartBrowseTime", bVar.qdm + ",");
            dVar.n("73ClickFeedIdList", b.e(bVar.qcL) + ",");
            dVar.n("74ExposeFeedIdList", b.e(bVar.qcM) + ",");
            dVar.n("75FavFeedIdList", b.e(bVar.qcN) + ",");
            dVar.n("76ClickAlbumUserList", b.e(bVar.qcT) + ",");
            dVar.n("77ForwardFeedIdList", b.e(bVar.qcO) + ",");
            dVar.n("78ClickAvatarFeedIdList", b.e(bVar.qcP) + ",");
            dVar.n("79ClickNickNameFeedIdList", b.e(bVar.qcQ) + ",");
            dVar.n("80ForwardToSingleChatFeedIdList", b.e(bVar.qcR) + ",");
            dVar.n("81ForwardToChatRoomFeedIdList", b.e(bVar.qcS) + ",");
            dVar.n("82FeedUpdateNotification", bVar.gKQ + ",");
            dVar.n("83abandon", ",");
            dVar.n("84abandon", ",");
            dVar.n("85LastestUnReadFeedId", bVar.qcE + ",");
            dVar.n("86UnReadMsgCount", bVar.qcF + ",");
            dVar.n("87BrowseAdCanvasPageTime", bVar.qcG + ",");
            dVar.n("88BrowseForwardAdCanvasTime", bVar.qcI + ",");
            w.v("MicroMsg.SnsBrowseInfoHelper", "report logbuffer(12076): " + dVar.JG());
            g.oUh.i(12076, new Object[]{dVar});
            a.urY.c(bVar.gKr);
            bVar.qbr = 0;
            bVar.qbs = 0;
            bVar.qbt = 0;
            bVar.qbu = 0;
            bVar.qbv = 0;
            bVar.qbw = 0;
            bVar.qbx = 0;
            bVar.qby = 0;
            bVar.qbz = 0;
            bVar.qbA = 0;
            bVar.qbB = 0;
            bVar.qbC = 0;
            bVar.qbD = 0;
            bVar.qbE = "";
            bVar.qbF = "";
            bVar.qbG = "";
            bVar.qbH = 0;
            bVar.qbI = 0;
            bVar.qbJ = 0;
            bVar.qbK = 0;
            bVar.qbL = 0;
            bVar.qbM = 0;
            bVar.qbN = 0;
            bVar.qbO = 0;
            bVar.kaN = 0;
            bVar.qbP = 0;
            bVar.qbQ = 0;
            bVar.qbR = 0;
            bVar.qbS = 0;
            bVar.qbT = 0;
            bVar.qbU = 0;
            bVar.qbV = 0;
            bVar.qbW = 0;
            bVar.qbX = 0;
            bVar.qbY = 0;
            bVar.qbZ = 0;
            bVar.qca = 0;
            bVar.qcb = 0;
            bVar.qcc = 0;
            bVar.qcd = 0;
            bVar.qce = 0;
            bVar.qcf = 0;
            bVar.qcg = 0;
            bVar.qch = 0;
            bVar.qci = 0;
            bVar.qcj = 0;
            bVar.qck = 0;
            bVar.qcl = 0;
            bVar.qcm = 0;
            bVar.qcn = 0;
            bVar.qco = 0;
            bVar.qcp = 0;
            bVar.qcq = 0;
            bVar.qcr = 0;
            bVar.qcs = 0;
            bVar.qct = 0;
            bVar.qcu = 0;
            bVar.qcv = 0;
            bVar.qcw = 0;
            bVar.qcx = 0;
            bVar.qcy = 0;
            bVar.qcz = 0;
            bVar.qcA = 0;
            bVar.qcB = 0;
            bVar.qcC = 0;
            bVar.qcD = 0;
            bVar.qcL.clear();
            bVar.qcM.clear();
            bVar.qcN.clear();
            bVar.qcO.clear();
            bVar.qcP.clear();
            bVar.qcQ.clear();
            bVar.qcR.clear();
            bVar.qcS.clear();
            bVar.gKQ = 0;
            bVar.qcE = "";
            bVar.qcF = 0;
            w.i("MicroMsg.SnsBrowseInfoHelper", "summersns report take[%d]ms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        }
    }

    public final void u(m mVar) {
        if (mVar != null) {
            this.qcK.add(mVar.bhy());
            this.qbt = this.qcK.size();
        }
    }

    public final void v(m mVar) {
        if (mVar != null) {
            String bhy = mVar.bhy();
            String g = i.g(mVar);
            if (!this.qcL.contains(g)) {
                w.i("MicroMsg.SnsBrowseInfoHelper", "onClickFeed localId:Td, snsId:%s", new Object[]{bhy, g});
                this.qbu++;
                this.qcL.add(g);
                if (mVar.tE(32)) {
                    this.qbZ++;
                }
                switch (mVar.field_type) {
                    case 1:
                        this.qbS++;
                        break;
                    case 3:
                        if (!bg.mA(mVar.bhd().ufC)) {
                            this.qbQ++;
                            break;
                        } else {
                            this.qbR++;
                            break;
                        }
                    case 4:
                        this.qbU++;
                        break;
                    case 5:
                        this.qbV++;
                        break;
                    case 15:
                        this.qbT++;
                        break;
                    case 18:
                        this.qbY++;
                        break;
                }
                if (mVar.tE(32)) {
                    if (mVar.bha() != null && mVar.bha().qdV) {
                        hs(true);
                    } else if (mVar.field_type == 1) {
                        hx(true);
                    } else if (mVar.field_type == 15) {
                        hy(true);
                    }
                } else if (mVar.bhd() == null || bg.mA(mVar.bhd().qsQ)) {
                    switch (mVar.field_type) {
                        case 1:
                            hr(true);
                            return;
                        case 3:
                            if (bg.mA(mVar.bhd().ufC)) {
                                hw(true);
                                return;
                            } else {
                                hv(true);
                                return;
                            }
                        case 4:
                            hw(true);
                            return;
                        case 5:
                            hw(true);
                            return;
                        case 15:
                            hu(true);
                            return;
                        case 18:
                            hA(true);
                            return;
                        default:
                            return;
                    }
                } else {
                    ht(true);
                }
            }
        }
    }

    public final void a(m mVar, boolean z) {
        if (mVar != null) {
            if (z) {
                this.qcP.add(i.g(mVar));
            } else {
                this.qcQ.add(i.g(mVar));
            }
            this.qcT.add(mVar.field_userName);
            this.qbv = this.qcT.size();
            if (ae.ber().equals(mVar.field_userName)) {
                hn(true);
            } else {
                ho(true);
            }
        }
    }

    public final void dz(String str, String str2) {
        this.qcN.add(str2);
        this.qcV.add(str);
        this.qby = this.qcV.size();
    }

    public final void hm(boolean z) {
        if (z) {
            this.qcd = System.currentTimeMillis();
        } else if (this.qcd > 0) {
            this.qcc += System.currentTimeMillis() - this.qcd;
            this.qcd = 0;
        }
    }

    public final void hn(boolean z) {
        if (z) {
            this.qcf = System.currentTimeMillis();
        } else if (this.qcf > 0) {
            this.qce += System.currentTimeMillis() - this.qcf;
            this.qcf = 0;
        }
    }

    public final void ho(boolean z) {
        if (z) {
            this.qch = System.currentTimeMillis();
        } else if (this.qch > 0) {
            this.qcg += System.currentTimeMillis() - this.qch;
            this.qch = 0;
        }
    }

    public final void hp(boolean z) {
        if (z) {
            this.qcj = System.currentTimeMillis();
        } else if (this.qcj > 0) {
            this.qci += System.currentTimeMillis() - this.qcj;
            this.qcj = 0;
        }
    }

    public final void hq(boolean z) {
        if (z) {
            this.qcl = System.currentTimeMillis();
        } else if (this.qcl > 0) {
            this.qck += System.currentTimeMillis() - this.qcl;
            this.qcl = 0;
        }
    }

    public final void hr(boolean z) {
        if (z) {
            this.qcn = System.currentTimeMillis();
        } else if (this.qcn > 0) {
            this.qcm += System.currentTimeMillis() - this.qcn;
            this.qcn = 0;
        }
    }

    public final void hs(boolean z) {
        if (z) {
            this.qcH = System.currentTimeMillis();
        } else if (this.qcH > 0) {
            this.qcG += System.currentTimeMillis() - this.qcH;
            this.qcH = 0;
        }
    }

    public final void ht(boolean z) {
        if (z) {
            this.qcJ = System.currentTimeMillis();
        } else if (this.qcJ > 0) {
            this.qcI += System.currentTimeMillis() - this.qcJ;
            this.qcJ = 0;
        }
    }

    public final void hu(boolean z) {
        if (z) {
            this.qcp = System.currentTimeMillis();
        } else if (this.qcp > 0) {
            this.qco += System.currentTimeMillis() - this.qcp;
            this.qcp = 0;
        }
    }

    public final void hv(boolean z) {
        if (z) {
            this.qcr = System.currentTimeMillis();
        } else if (this.qcr > 0) {
            this.qcq += System.currentTimeMillis() - this.qcr;
            this.qcr = 0;
        }
    }

    public final void hw(boolean z) {
        if (z) {
            this.qct = System.currentTimeMillis();
        } else if (this.qct > 0) {
            this.qcs += System.currentTimeMillis() - this.qct;
            this.qct = 0;
        }
    }

    public final void hx(boolean z) {
        if (z) {
            this.qcv = System.currentTimeMillis();
        } else if (this.qcv > 0) {
            this.qcu += System.currentTimeMillis() - this.qcv;
            this.qcv = 0;
        }
    }

    public final void hy(boolean z) {
        if (z) {
            this.qcz = System.currentTimeMillis();
        } else if (this.qcz > 0) {
            this.qcy += System.currentTimeMillis() - this.qcz;
            this.qcz = 0;
        }
    }

    public final void hz(boolean z) {
        if (z) {
            this.qcB = System.currentTimeMillis();
        } else if (this.qcB > 0) {
            this.qcA += System.currentTimeMillis() - this.qcB;
            this.qcB = 0;
        }
    }

    public final void hA(boolean z) {
        if (z) {
            this.qcD = System.currentTimeMillis();
        } else if (this.qcD > 0) {
            this.qcC += System.currentTimeMillis() - this.qcD;
            this.qcD = 0;
        }
    }

    public final void hB(boolean z) {
        this.qbH = z ? 1 : 0;
    }

    public b() {
        this.qbp = false;
        this.qbq = -1;
        this.qbr = 0;
        this.qbs = 0;
        this.qbt = 0;
        this.qbu = 0;
        this.qbv = 0;
        this.qbw = 0;
        this.qbx = 0;
        this.qby = 0;
        this.qbz = 0;
        this.qbA = 0;
        this.qbB = 0;
        this.qbC = 0;
        this.qbD = 0;
        this.qbE = "";
        this.qbF = "";
        this.qbG = "";
        this.qbI = 0;
        this.qbJ = 0;
        this.qbK = 0;
        this.qbL = 0;
        this.qbM = 0;
        this.qbN = 0;
        this.qbO = 0;
        this.kaN = 0;
        this.qbP = 0;
        this.qbQ = 0;
        this.qbR = 0;
        this.qbS = 0;
        this.qbT = 0;
        this.qbU = 0;
        this.qbV = 0;
        this.qbW = 0;
        this.qbX = 0;
        this.qbY = 0;
        this.qbZ = 0;
        this.qca = 0;
        this.qcb = 0;
        this.qcc = 0;
        this.qcd = 0;
        this.qce = 0;
        this.qcf = 0;
        this.qcg = 0;
        this.qch = 0;
        this.qci = 0;
        this.qcj = 0;
        this.qck = 0;
        this.qcl = 0;
        this.qcm = 0;
        this.qcn = 0;
        this.qco = 0;
        this.qcp = 0;
        this.qcq = 0;
        this.qcr = 0;
        this.qcs = 0;
        this.qct = 0;
        this.qcu = 0;
        this.qcv = 0;
        this.qcw = 0;
        this.qcx = 0;
        this.qcy = 0;
        this.qcz = 0;
        this.qcA = 0;
        this.qcB = 0;
        this.qcC = 0;
        this.qcD = 0;
        this.qcG = 0;
        this.qcH = 0;
        this.qcI = 0;
        this.qcJ = 0;
        this.qcK = new HashSet();
        this.qcL = new HashSet();
        this.qcM = new HashSet();
        this.qcN = new HashSet();
        this.qcO = new HashSet();
        this.qcP = new HashSet();
        this.qcQ = new HashSet();
        this.qcR = new HashSet();
        this.qcS = new HashSet();
        this.qcT = new HashSet();
        this.qcU = new HashSet();
        this.qcV = new HashSet();
        this.qcW = new HashSet();
        this.qcX = new HashSet();
        this.qcY = Integer.MAX_VALUE;
        this.qcZ = 0;
        this.qda = new HashSet();
        this.qdb = new HashSet();
        this.qdc = new HashSet();
        this.qdd = new HashSet();
        this.qde = new HashSet();
        this.qdf = new HashSet();
        this.qdg = new HashSet();
        this.qdh = new HashSet();
        this.qdi = new HashSet();
        this.qdj = new HashSet();
        this.qdk = new HashSet();
        this.qdl = new HashSet();
        this.gKr = new c<pj>(this) {
            final /* synthetic */ b qdn;

            {
                this.qdn = r2;
                this.usg = pj.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                pj pjVar = (pj) bVar;
                if (pjVar instanceof pj) {
                    w.i("MicroMsg.SnsBrowseInfoHelper", "IListener callback " + this.qdn.qbq);
                    if (this.qdn.qbq != -1 && this.qdn.qbq < 0) {
                        Iterator it = pjVar.fWl.fWm.iterator();
                        while (it.hasNext()) {
                            if (((Long) it.next()).longValue() > this.qdn.qbq) {
                                b bVar2 = this.qdn;
                                bVar2.qbB++;
                            }
                        }
                    }
                }
                return false;
            }
        };
        this.qdm = 0;
        a.urY.b(this.gKr);
    }

    public b(int i, String str, int i2) {
        this();
        this.gKQ = i;
        this.qcE = str;
        this.qcF = i2;
    }

    static String e(HashSet<String> hashSet) {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = hashSet.iterator();
        Object obj = 1;
        while (it.hasNext()) {
            String str = (String) it.next();
            if (obj != null) {
                stringBuffer.append(str);
                obj = null;
            } else {
                stringBuffer.append("|" + str);
            }
        }
        return stringBuffer.toString();
    }
}
