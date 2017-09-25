package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.os.Build.VERSION;
import android.widget.ListView;
import com.tencent.mm.e.a.ba;
import com.tencent.mm.e.a.is;
import com.tencent.mm.e.a.md;
import com.tencent.mm.e.b.aj;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.ae;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.y;
import java.util.HashMap;
import java.util.Map.Entry;

public final class c {
    public Activity activity;
    HashMap<String, Integer> wbI = new HashMap();
    int wbJ = -1;
    public int wbK = -1;
    public g wbL;
    com.tencent.mm.sdk.b.c wbM = new com.tencent.mm.sdk.b.c<md>(this) {
        final /* synthetic */ c wbP;

        {
            this.wbP = r2;
            this.usg = md.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            if (this.wbP.wbL != null) {
                af.v(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 wbQ;

                    {
                        this.wbQ = r1;
                    }

                    public final void run() {
                        w.d("MicroMsg.ConvUnreadHelper", "refresh main ui unread count.");
                        this.wbQ.wbP.wbL.notifyDataSetChanged();
                        this.wbQ.wbP.bYv();
                    }
                });
            }
            return true;
        }
    };
    com.tencent.mm.sdk.b.c wbN = new com.tencent.mm.sdk.b.c<ba>(this) {
        final /* synthetic */ c wbP;

        {
            this.wbP = r2;
            this.usg = ba.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            if (((ba) bVar).fEy.fEz != this.wbP.wbK) {
                w.i("MicroMsg.ConvUnreadHelper", "unreadcheck wrong should be %d, but is %d", Integer.valueOf(((ba) bVar).fEy.fEz), Integer.valueOf(this.wbP.wbK));
                this.wbP.wbK = -1;
            }
            return true;
        }
    };
    com.tencent.mm.sdk.b.c wbO = new com.tencent.mm.sdk.b.c<is>(this) {
        private final long INTERVAL;
        final /* synthetic */ c wbP;
        public long wbR;
        public int wbS;

        {
            this.wbP = r3;
            this.INTERVAL = 3000;
            this.wbR = 0;
            this.wbS = -1;
            this.usg = is.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            if (this.wbP.activity != null) {
                w.d("MicroMsg.ConvUnreadHelper", "trigger double tab");
                this.wbP.wbi.postDelayed(new Runnable(this) {
                    final /* synthetic */ AnonymousClass3 wbT;

                    {
                        this.wbT = r1;
                    }

                    public final void run() {
                        int firstVisiblePosition;
                        int i;
                        int i2;
                        int abs;
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - this.wbT.wbR >= 3000 || this.wbT.wbS < 0) {
                            firstVisiblePosition = (this.wbT.wbP.wbi.getFirstVisiblePosition() - this.wbT.wbP.wbi.getHeaderViewsCount()) + 1;
                            if (firstVisiblePosition < 0) {
                                i = 0;
                            } else {
                                i = firstVisiblePosition;
                            }
                        } else {
                            i = this.wbT.wbS;
                        }
                        g gVar = this.wbT.wbP.wbL;
                        if (this.wbT.wbP.wbK > 0) {
                            i2 = 1;
                        } else {
                            i2 = 0;
                        }
                        int count = gVar.getCount();
                        if (count > 0) {
                            for (abs = Math.abs((i + 1) % count); abs != i; abs = (abs + 1) % count) {
                                ae aeVar = (ae) gVar.yQ(abs);
                                if (aeVar != null && aeVar.field_unReadCount > 0) {
                                    if (i2 == 0) {
                                        i2 = abs;
                                        break;
                                    } else if (g.a(aeVar, gVar.j(aeVar)) == 2) {
                                        i2 = abs;
                                        break;
                                    }
                                }
                            }
                        }
                        i2 = -1;
                        if (i2 < 0) {
                            com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c.a(this.wbT.wbP.wbi);
                        } else {
                            ListView listView = this.wbT.wbP.wbi;
                            abs = this.wbT.wbP.wbi.getHeaderViewsCount() + i2;
                            if (listView != null) {
                                if (VERSION.SDK_INT >= 11) {
                                    com.tencent.mm.sdk.platformtools.ba baVar = new com.tencent.mm.sdk.platformtools.ba();
                                    int firstVisiblePosition2 = listView.getFirstVisiblePosition();
                                    if (firstVisiblePosition2 < abs && firstVisiblePosition2 + 10 < abs) {
                                        listView.setSelectionFromTop(abs - 10, 0);
                                    } else if (firstVisiblePosition2 > abs && firstVisiblePosition2 - 10 > abs) {
                                        listView.setSelectionFromTop(abs + 10, 0);
                                    }
                                    if (VERSION.SDK_INT >= 11) {
                                        listView.smoothScrollToPositionFromTop(abs, 0);
                                    }
                                } else {
                                    az azVar = new az();
                                    listView.setSelectionFromTop(abs, 0);
                                }
                            }
                        }
                        this.wbT.wbR = currentTimeMillis;
                        AnonymousClass3 anonymousClass3 = this.wbT;
                        if (i2 < 0) {
                            firstVisiblePosition = 0;
                        } else {
                            firstVisiblePosition = i2;
                        }
                        anonymousClass3.wbS = firstVisiblePosition;
                        w.d("MicroMsg.ConvUnreadHelper", "headerCount %d, scroll from %d to %d", Integer.valueOf(this.wbT.wbP.wbi.getHeaderViewsCount()), Integer.valueOf(i), Integer.valueOf(i2));
                    }
                }, 100);
            }
            return false;
        }
    };
    public ListView wbi;

    public final void ae(Activity activity) {
        this.wbK = ((LauncherUI) activity).uRM.bPB();
    }

    public final void bYv() {
        if (this.activity != null) {
            long currentTimeMillis = System.currentTimeMillis();
            LauncherUI launcherUI = (LauncherUI) this.activity;
            w.i("MicroMsg.ConvUnreadHelper", "unreadcheck postSetLauncherUIUnReadCount  resetStatus %d", Integer.valueOf(this.wbJ));
            switch (this.wbJ) {
                case 1:
                    return;
                case 2:
                    int i = 0;
                    for (Entry entry : this.wbI.entrySet()) {
                        int i2;
                        String str = (String) entry.getKey();
                        int intValue = ((Integer) entry.getValue()).intValue();
                        w.i("MicroMsg.ConvUnreadHelper", "unreadcheck postSetLauncherUIUnReadCount  username %s, preunread %d", str, Integer.valueOf(intValue));
                        aj TU = TU(str);
                        if (TU == null || y.bQG().contains(str)) {
                            w.i("MicroMsg.ConvUnreadHelper", "unreadcheck postSetLauncherUIUnReadCount  cov == null username %s, change %d", str, Integer.valueOf(0 - intValue));
                            i2 = intValue;
                        } else {
                            w.i("MicroMsg.ConvUnreadHelper", "unreadcheck postSetLauncherUIUnReadCount  cov != null username %s, change %d", str, Integer.valueOf((TU.field_unReadCount - intValue) + 0));
                            i2 = intValue;
                        }
                        if (i2 != 0 && this.wbL.TV(str)) {
                            w.i("MicroMsg.ConvUnreadHelper", "unreadcheck postSetLauncherUIUnReadCount  username %s isWithoutItemCache", str);
                            ap.yY();
                            com.tencent.mm.e.b.af Rc = com.tencent.mm.u.c.wR().Rc(str);
                            if (Rc != null) {
                                if (o.dH(str)) {
                                    if (Rc.gkz == 0) {
                                    }
                                } else if (Rc.tD()) {
                                }
                            }
                        }
                        w.i("MicroMsg.ConvUnreadHelper", "unreadcheck postSetLauncherUIUnReadCount  real change usename %s, change %d, totalchange %d", str, Integer.valueOf(i2), Integer.valueOf(i + i2));
                        i = intValue;
                    }
                    this.wbK += i;
                    launcherUI.uRM.zd(this.wbK);
                    w.i("MicroMsg.ConvUnreadHelper", "unreadcheck postSetLauncherUIUnReadCount UNREAD_RESET_PART totalUnReadCount %d, change %d, usetime %d,", Integer.valueOf(this.wbK), Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    return;
                default:
                    this.wbK = launcherUI.uRM.bPB();
                    w.i("MicroMsg.ConvUnreadHelper", "unreadcheck postSetLauncherUIUnReadCount UNREAD_RESET_ALL totalUnReadCount %d, usetime %d,", Integer.valueOf(this.wbK), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    return;
            }
        }
    }

    final ae TU(String str) {
        if (this.wbL != null) {
            return (ae) this.wbL.bC(str);
        }
        return null;
    }
}
