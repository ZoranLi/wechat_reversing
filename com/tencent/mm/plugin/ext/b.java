package com.tencent.mm.plugin.ext;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import com.jg.EType;
import com.jg.JgMethodChecked;
import com.tencent.mm.bj.g.c;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.e.a.em;
import com.tencent.mm.e.a.eu;
import com.tencent.mm.e.a.fa;
import com.tencent.mm.e.b.aj;
import com.tencent.mm.kernel.h;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.ext.openapi.provider.ExtControlProviderOpenApi;
import com.tencent.mm.plugin.ext.provider.ExtControlProviderEntry;
import com.tencent.mm.plugin.ext.provider.ExtControlProviderMsg;
import com.tencent.mm.plugin.ext.voicecontrol.ExtControlProviderVoiceControl;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.i;
import com.tencent.mm.pluginsdk.model.l;
import com.tencent.mm.protocal.c.acg;
import com.tencent.mm.protocal.c.bim;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.ax;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.am;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.o;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;

public class b implements am {
    private static HashMap<Integer, c> gJr;
    public static boolean lqa = false;
    private String gYf;
    com.tencent.mm.sdk.e.m.b lex = new com.tencent.mm.sdk.e.m.b(this) {
        final /* synthetic */ b lqb;

        {
            this.lqb = r1;
        }

        public final void a(int i, m mVar, Object obj) {
            if (obj == null || !(obj instanceof String)) {
                w.d("MicroMsg.SubCoreExt", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i), mVar, obj);
            } else if (ap.zb()) {
                ap.yY();
                if (mVar == com.tencent.mm.u.c.wR()) {
                    this.lqb.dN(false);
                }
            } else {
                w.i("MicroMsg.SubCoreExt", "onNotifyChange acc not ready");
            }
        }
    };
    private final long lpK = 1600;
    private t lpL;
    private ax lpM;
    private be lpN;
    private a lpO;
    private b lpP;
    public HashMap<String, Integer> lpQ = new HashMap();
    private com.tencent.mm.plugin.messenger.foundation.a.a.c.a lpR = new com.tencent.mm.plugin.messenger.foundation.a.a.c.a(this) {
        final /* synthetic */ b lqb;

        {
            this.lqb = r1;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(com.tencent.mm.plugin.messenger.foundation.a.a.c r9, com.tencent.mm.plugin.messenger.foundation.a.a.c.c r10) {
            /*
            r8 = this;
            r0 = 0;
            if (r9 == 0) goto L_0x0009;
        L_0x0003:
            if (r10 == 0) goto L_0x0009;
        L_0x0005:
            r1 = r10.nyP;
            if (r1 != 0) goto L_0x0013;
        L_0x0009:
            r0 = "MicroMsg.SubCoreExt";
            r1 = "onMsgChange, wrong args";
            com.tencent.mm.sdk.platformtools.w.e(r0, r1);
        L_0x0012:
            return;
        L_0x0013:
            r3 = r8.lqb;
            monitor-enter(r3);
            r1 = com.tencent.mm.plugin.ext.b.aqL();	 Catch:{ all -> 0x002b }
            r1 = r1.bMO();	 Catch:{ all -> 0x002b }
            if (r1 != 0) goto L_0x002e;
        L_0x0020:
            r0 = "MicroMsg.SubCoreExt";
            r1 = "onMsgChange onNotifyChange getValidOpenMsgListener cu == null";
            com.tencent.mm.sdk.platformtools.w.i(r0, r1);	 Catch:{ all -> 0x002b }
            monitor-exit(r3);	 Catch:{ all -> 0x002b }
            goto L_0x0012;
        L_0x002b:
            r0 = move-exception;
            monitor-exit(r3);	 Catch:{ all -> 0x002b }
            throw r0;
        L_0x002e:
            r2 = "MicroMsg.SubCoreExt";
            r4 = "onMsgChange onNotifyChange listener count = %s";
            r5 = 1;
            r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x002b }
            r6 = 0;
            r7 = r1.getCount();	 Catch:{ all -> 0x002b }
            r7 = java.lang.Integer.valueOf(r7);	 Catch:{ all -> 0x002b }
            r5[r6] = r7;	 Catch:{ all -> 0x002b }
            com.tencent.mm.sdk.platformtools.w.d(r2, r4, r5);	 Catch:{ all -> 0x002b }
            r2 = r1.getCount();	 Catch:{ all -> 0x002b }
            if (r2 > 0) goto L_0x0059;
        L_0x004b:
            r1.close();	 Catch:{ all -> 0x002b }
            r0 = "MicroMsg.SubCoreExt";
            r1 = "onMsgChange onNotifyChange cu.getCount() <= 0";
            com.tencent.mm.sdk.platformtools.w.i(r0, r1);	 Catch:{ all -> 0x002b }
            monitor-exit(r3);	 Catch:{ all -> 0x002b }
            goto L_0x0012;
        L_0x0059:
            r1.close();	 Catch:{ all -> 0x002b }
            r2 = r0;
        L_0x005d:
            r0 = r10.nyP;	 Catch:{ all -> 0x002b }
            r0 = r0.size();	 Catch:{ all -> 0x002b }
            if (r2 >= r0) goto L_0x00f7;
        L_0x0065:
            r0 = r10.nyP;	 Catch:{ all -> 0x002b }
            r0 = r0.get(r2);	 Catch:{ all -> 0x002b }
            r0 = (com.tencent.mm.storage.au) r0;	 Catch:{ all -> 0x002b }
            if (r0 == 0) goto L_0x00c1;
        L_0x006f:
            r1 = r0.field_isSend;	 Catch:{ all -> 0x002b }
            if (r1 != 0) goto L_0x00c1;
        L_0x0073:
            r1 = r0.field_status;	 Catch:{ all -> 0x002b }
            r4 = 4;
            if (r1 == r4) goto L_0x00c1;
        L_0x0078:
            r1 = r0.field_type;	 Catch:{ all -> 0x002b }
            r4 = 9999; // 0x270f float:1.4012E-41 double:4.94E-320;
            if (r1 == r4) goto L_0x00c1;
        L_0x007e:
            r1 = r0.field_type;	 Catch:{ all -> 0x002b }
            r4 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
            if (r1 == r4) goto L_0x00c1;
        L_0x0084:
            r1 = r0.field_talker;	 Catch:{ all -> 0x002b }
            r1 = com.tencent.mm.u.o.fF(r1);	 Catch:{ all -> 0x002b }
            if (r1 != 0) goto L_0x00c1;
        L_0x008c:
            r1 = r8.lqb;	 Catch:{ all -> 0x002b }
            r1 = r1.lpQ;	 Catch:{ all -> 0x002b }
            r4 = r0.field_talker;	 Catch:{ all -> 0x002b }
            r1 = r1.get(r4);	 Catch:{ all -> 0x002b }
            r1 = (java.lang.Integer) r1;	 Catch:{ all -> 0x002b }
            if (r1 != 0) goto L_0x00c5;
        L_0x009a:
            r1 = r8.lqb;	 Catch:{ all -> 0x002b }
            r1 = r1.lpQ;	 Catch:{ all -> 0x002b }
            r4 = r0.field_talker;	 Catch:{ all -> 0x002b }
            r5 = 1;
            r5 = java.lang.Integer.valueOf(r5);	 Catch:{ all -> 0x002b }
            r1.put(r4, r5);	 Catch:{ all -> 0x002b }
            r1 = "MicroMsg.SubCoreExt";
            r4 = "onMsgChange %s, %d";
            r5 = 2;
            r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x002b }
            r6 = 0;
            r0 = r0.field_talker;	 Catch:{ all -> 0x002b }
            r5[r6] = r0;	 Catch:{ all -> 0x002b }
            r0 = 1;
            r6 = 1;
            r6 = java.lang.Integer.valueOf(r6);	 Catch:{ all -> 0x002b }
            r5[r0] = r6;	 Catch:{ all -> 0x002b }
            com.tencent.mm.sdk.platformtools.w.d(r1, r4, r5);	 Catch:{ all -> 0x002b }
        L_0x00c1:
            r0 = r2 + 1;
            r2 = r0;
            goto L_0x005d;
        L_0x00c5:
            r4 = r8.lqb;	 Catch:{ all -> 0x002b }
            r4 = r4.lpQ;	 Catch:{ all -> 0x002b }
            r5 = r0.field_talker;	 Catch:{ all -> 0x002b }
            r6 = r1.intValue();	 Catch:{ all -> 0x002b }
            r6 = r6 + 1;
            r6 = java.lang.Integer.valueOf(r6);	 Catch:{ all -> 0x002b }
            r4.put(r5, r6);	 Catch:{ all -> 0x002b }
            r4 = "MicroMsg.SubCoreExt";
            r5 = "onMsgChange %s, %d";
            r6 = 2;
            r6 = new java.lang.Object[r6];	 Catch:{ all -> 0x002b }
            r7 = 0;
            r0 = r0.field_talker;	 Catch:{ all -> 0x002b }
            r6[r7] = r0;	 Catch:{ all -> 0x002b }
            r0 = 1;
            r1 = r1.intValue();	 Catch:{ all -> 0x002b }
            r1 = r1 + 1;
            r1 = java.lang.Integer.valueOf(r1);	 Catch:{ all -> 0x002b }
            r6[r0] = r1;	 Catch:{ all -> 0x002b }
            com.tencent.mm.sdk.platformtools.w.d(r4, r5, r6);	 Catch:{ all -> 0x002b }
            goto L_0x00c1;
        L_0x00f7:
            r0 = r8.lqb;	 Catch:{ all -> 0x002b }
            r0 = r0.lpQ;	 Catch:{ all -> 0x002b }
            r0 = r0.size();	 Catch:{ all -> 0x002b }
            if (r0 <= 0) goto L_0x0109;
        L_0x0101:
            r0 = r8.lqb;	 Catch:{ all -> 0x002b }
            r0.aqP();	 Catch:{ all -> 0x002b }
        L_0x0106:
            monitor-exit(r3);	 Catch:{ all -> 0x002b }
            goto L_0x0012;
        L_0x0109:
            r0 = "MicroMsg.SubCoreExt";
            r1 = "notifyMsgUsers.size < 1";
            com.tencent.mm.sdk.platformtools.w.i(r0, r1);	 Catch:{ all -> 0x002b }
            goto L_0x0106;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.ext.b.5.a(com.tencent.mm.plugin.messenger.foundation.a.a.c, com.tencent.mm.plugin.messenger.foundation.a.a.c$c):void");
        }
    };
    com.tencent.mm.pluginsdk.model.i.a lpS = new com.tencent.mm.pluginsdk.model.i.a(this) {
        final /* synthetic */ b lqb;

        {
            this.lqb = r1;
        }

        public final void a(l lVar) {
            if (lVar != null) {
                acg com_tencent_mm_protocal_c_acg;
                if (lVar.ldw == null) {
                    com_tencent_mm_protocal_c_acg = null;
                } else {
                    com_tencent_mm_protocal_c_acg = (acg) lVar.ldw.hsk.hsr;
                }
                Iterator it = com_tencent_mm_protocal_c_acg.tHP.iterator();
                int i = 0;
                while (it.hasNext()) {
                    bim com_tencent_mm_protocal_c_bim = (bim) it.next();
                    w.v("MicroMsg.SubCoreExt", "AppId[%s], UserName[%s], Xml[%s]", lVar.sCu, com_tencent_mm_protocal_c_bim.jNj, com_tencent_mm_protocal_c_bim.uis);
                    if (!(bg.mA(com_tencent_mm_protocal_c_bim.jNj) || bg.mA(com_tencent_mm_protocal_c_bim.uis))) {
                        ap.yY();
                        com.tencent.mm.j.a Ra = com.tencent.mm.u.c.wR().Ra(com_tencent_mm_protocal_c_bim.jNj);
                        if (Ra == null || ((int) Ra.gTQ) <= 0) {
                            w.e("MicroMsg.SubCoreExt", "contact is null");
                        } else if (Ra.bLe()) {
                            w.w("MicroMsg.SubCoreExt", "isBizContact");
                        } else {
                            com.tencent.mm.pluginsdk.model.i.b LR = i.LR(com_tencent_mm_protocal_c_bim.uis);
                            if (!(LR == null || bg.mA(LR.sCo))) {
                                w.v("MicroMsg.SubCoreExt", "AppId[%s], openId[%s]", lVar.sCu, LR.sCo);
                                b.aqM().a(new bd(lVar.sCu, com_tencent_mm_protocal_c_bim.jNj, LR.sCo));
                                i = 1;
                            }
                        }
                    }
                }
                if (i != 0) {
                    this.lqb.aqP();
                }
            }
        }
    };
    private ae lpT = new ae(this, Looper.getMainLooper()) {
        final /* synthetic */ b lqb;

        @JgMethodChecked(author = 20, fComment = "checked", lastDate = "20140514", reviewer = 20, vComment = {EType.INTENTCHECK})
        public final void handleMessage(Message message) {
            if (ab.getContext() == null || !ap.zb()) {
                w.w("MicroMsg.SubCoreExt", "notifyMsgChangeHandler wrong status");
                return;
            }
            Cursor bMO = b.aqL().bMO();
            if (bMO == null) {
                w.i("MicroMsg.SubCoreExt", "notifyMsgChangeHandler getValidOpenMsgListener cu == null");
                return;
            }
            w.d("MicroMsg.SubCoreExt", "notifyMsgChangeHandler listener count = %s", Integer.valueOf(bMO.getCount()));
            if (bMO.getCount() <= 0) {
                bMO.close();
                w.i("MicroMsg.SubCoreExt", "notifyMsgChangeHandler cu.getCount() <= 0");
                return;
            }
            try {
                if (bMO.moveToFirst()) {
                    HashMap hashMap = new HashMap();
                    synchronized (this.lqb) {
                        hashMap.putAll(this.lqb.lpQ);
                        this.lqb.lpQ.clear();
                    }
                    do {
                        LinkedList linkedList = new LinkedList();
                        ArrayList arrayList = new ArrayList();
                        if (hashMap.entrySet() == null) {
                            w.w("MicroMsg.SubCoreExt", "notifyMsgChangeHandler waitForNotify.entrySet() == null");
                            return;
                        }
                        aw awVar = new aw();
                        awVar.b(bMO);
                        if (bg.mA(awVar.field_appId) || bg.mA(awVar.field_packageName)) {
                            w.w("MicroMsg.SubCoreExt", "notifyMsgChangeHandler wrong msgListener, appid = %s, package = %s", awVar.field_appId, awVar.field_packageName);
                        } else {
                            for (Entry entry : hashMap.entrySet()) {
                                String mz = bg.mz((String) entry.getKey());
                                Integer num = (Integer) entry.getValue();
                                ap.yY();
                                aj Rm = com.tencent.mm.u.c.wW().Rm(mz);
                                if (Rm != null && !bg.mA(Rm.field_username) && Rm.field_unReadCount <= 0) {
                                    w.i("MicroMsg.SubCoreExt", "notifyMsgChangeHandler no unread in conversation");
                                } else if (!(o.fF(mz) || o.dH(mz) || o.eV(mz))) {
                                    bd bdVar;
                                    be aqM = b.aqM();
                                    String str = awVar.field_appId;
                                    if (str == null || str.length() <= 0 || mz == null || mz.length() <= 0) {
                                        bdVar = null;
                                    } else {
                                        Cursor a = aqM.gUz.a("UserOpenIdInApp", null, "appId=? and username=? ", new String[]{bg.my(str), bg.my(mz)}, null, null, null, 2);
                                        if (a.moveToFirst()) {
                                            bdVar = new bd();
                                            bdVar.b(a);
                                            a.close();
                                        } else {
                                            w.w("MicroMsg.scanner.UserOpenIdInAppStorage", "get null with appId-%s, username-%s:", str, mz);
                                            a.close();
                                            bdVar = null;
                                        }
                                    }
                                    if (bdVar == null || bg.mA(bdVar.field_openId) || bg.mA(bdVar.field_username)) {
                                        w.d("MicroMsg.SubCoreExt", "notifyMsgChangeHandler openId is null, go get it.");
                                        Integer num2 = (Integer) this.lqb.lpQ.get(mz);
                                        if (num2 == null) {
                                            this.lqb.lpQ.put(mz, num);
                                        } else {
                                            this.lqb.lpQ.put(mz, Integer.valueOf(num2.intValue() + num.intValue()));
                                        }
                                        linkedList.add(mz);
                                    } else {
                                        w.v("MicroMsg.SubCoreExt", "username[%s], appId[%s], openId[%s]", bdVar.field_username, bdVar.field_appId, bdVar.field_openId);
                                        arrayList.add(String.format("%s,%s,%s", new Object[]{bdVar.field_openId, num, Long.valueOf(System.currentTimeMillis() - 1600)}));
                                    }
                                }
                            }
                            if (linkedList.size() > 0) {
                                w.i("MicroMsg.SubCoreExt", "notifyMsgChangeHandler doGetGetUserInfoInApp");
                                b bVar = this.lqb;
                                String str2 = awVar.field_appId;
                                if (!bg.mA(str2) && linkedList.size() > 0) {
                                    i bCD = i.bCD();
                                    Context context = ab.getContext();
                                    com.tencent.mm.pluginsdk.model.i.a aVar = bVar.lpS;
                                    w.d("MicroMsg.GetUserInfoInAppLogic", "getGetUserInfoInApp");
                                    if (!i.sCl) {
                                        bCD.bCE();
                                    }
                                    if (ap.zb() && context != null) {
                                        if (linkedList.size() == 0) {
                                            w.d("MicroMsg.GetUserInfoInAppLogic", "userNameList empty");
                                        } else {
                                            bCD.sCn = aVar;
                                            com.tencent.mm.pluginsdk.model.app.w lVar = new l(str2, linkedList);
                                            an.aBG();
                                            d.a(14, lVar);
                                        }
                                    }
                                }
                            }
                            if (arrayList.size() <= 0) {
                                bMO.close();
                                w.i("MicroMsg.SubCoreExt", "notifyMsgChangeHandler userDataList.size() <= 0");
                                return;
                            }
                            if ((awVar.field_status == 1 ? 1 : null) == null) {
                                w.w("MicroMsg.SubCoreExt", "invalid msgListener, appid = %s, package = %s", awVar.field_appId, awVar.field_packageName);
                            } else if (!(bg.mA(awVar.field_appId) || bg.mA(awVar.field_packageName))) {
                                w.i("MicroMsg.SubCoreExt", "notify app, appId = %s, package = %s", awVar.field_appId, awVar.field_packageName);
                                final Intent intent = new Intent("com.tencent.mm.plugin.openapi.Intent.ACTION_NOTIFY_MSG");
                                intent.addCategory("com.tencent.mm.category." + awVar.field_packageName);
                                com.tencent.mm.compatible.a.a.a(12, new com.tencent.mm.compatible.a.a.a(this) {
                                    final /* synthetic */ AnonymousClass7 lqc;

                                    public final void run() {
                                        intent.setFlags(32);
                                    }
                                });
                                intent.putExtra("EXTRA_EXT_OPEN_NOTIFY_TYPE", "NEW_MESSAGE");
                                intent.putStringArrayListExtra("EXTRA_EXT_OPEN_USER_DATA", arrayList);
                                ab.getContext().sendBroadcast(intent);
                            }
                        }
                    } while (bMO.moveToNext());
                }
                bMO.close();
            } catch (Exception e) {
                w.e("MicroMsg.SubCoreExt", "Exception in handleMessage, %s", e.getMessage());
                if (bMO != null) {
                    bMO.close();
                }
            }
        }
    };
    public LinkedList<String> lpU = new LinkedList();
    private final long lpV = 60;
    public ae lpW = new ae(this, Looper.getMainLooper()) {
        final /* synthetic */ b lqb;

        public final void handleMessage(Message message) {
            try {
                if (this.lqb.lpU.size() > 0) {
                    Iterator it = this.lqb.lpU.iterator();
                    while (it.hasNext()) {
                        String str = (String) it.next();
                        if (!"*".equals(str)) {
                            f aJ = g.aJ(str, false);
                            if (aJ == null) {
                                w.w("MicroMsg.SubCoreExt", "appInfo is null");
                            } else if (bg.mA(aJ.field_appId)) {
                                w.w("MicroMsg.SubCoreExt", "appId is null");
                            } else {
                                w.d("MicroMsg.SubCoreExt", "onAppInfoStgChange, notify[%s], appFlag[%s], id[%s]", str, Integer.valueOf(aJ.field_appInfoFlag), aJ.field_appId);
                                aw RP = b.aqL().RP(aJ.field_appId);
                                if (RP == null) {
                                    w.w("MicroMsg.SubCoreExt", "openMsgListener is null, appId = %s", aJ.field_appId);
                                } else {
                                    if (g.i(aJ)) {
                                        if (RP.field_status != 1) {
                                            RP.field_status = 1;
                                        }
                                    } else if (RP.field_status != 0) {
                                        RP.field_status = 0;
                                    }
                                    ax aqL = b.aqL();
                                    if (bg.mA(aJ.field_appId) || RP == null || bg.mA(RP.field_appId)) {
                                        w.w("MicroMsg.OpenMsgListenerStorage", "wrong argument");
                                    } else {
                                        int update;
                                        ContentValues pv = RP.pv();
                                        if (pv.size() > 0) {
                                            update = aqL.gUz.update("OpenMsgListener", pv, "appId=?", new String[]{bg.my(r3)});
                                        } else {
                                            update = 0;
                                        }
                                        w.d("MicroMsg.OpenMsgListenerStorage", "update: id=%s, ret=%s ", RP.field_appId, Integer.valueOf(update));
                                    }
                                }
                            }
                        }
                    }
                    this.lqb.lpU.clear();
                }
            } catch (Exception e) {
                w.e("MicroMsg.SubCoreExt", "exception in onAppInfoStgChange, %s", e.getMessage());
            }
        }
    };
    private com.tencent.mm.sdk.e.j.a lpX = new com.tencent.mm.sdk.e.j.a(this) {
        final /* synthetic */ b lqb;

        {
            this.lqb = r1;
        }

        public final void a(String str, com.tencent.mm.sdk.e.l lVar) {
            if (!this.lqb.lpU.contains(str)) {
                this.lqb.lpU.add(str);
            }
            this.lqb.lpW.removeMessages(0);
            this.lqb.lpW.sendEmptyMessageDelayed(0, 60);
        }
    };
    public boolean lpY = true;
    public boolean lpZ = false;

    public static class a extends com.tencent.mm.sdk.b.c<eu> {
        public a() {
            this.usg = eu.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            eu euVar = (eu) bVar;
            if (!(euVar instanceof eu)) {
                w.f("MicroMsg.SubCoreExt", "mismatched event");
                return false;
            } else if (euVar.fIY == null) {
                w.e("MicroMsg.SubCoreExt", "revent.data is null");
                return false;
            } else {
                if (euVar.fIY.fIt == 9 || euVar.fIY.fIt == 13) {
                    ExtControlProviderMsg extControlProviderMsg = new ExtControlProviderMsg(euVar.fIY.fCt, euVar.fIY.fIt, euVar.fIY.context);
                    euVar.fIZ.fIu = extControlProviderMsg.query(euVar.fIY.uri, null, null, euVar.fIY.selectionArgs, null);
                } else if (euVar.fIY.fIt == 3) {
                    ExtControlProviderEntry extControlProviderEntry = new ExtControlProviderEntry(euVar.fIY.fCt, euVar.fIY.fIt, euVar.fIY.context);
                    euVar.fIZ.fIu = extControlProviderEntry.query(euVar.fIY.uri, null, null, euVar.fIY.selectionArgs, null);
                } else if (euVar.fIY.fIt == 29) {
                    ExtControlProviderVoiceControl extControlProviderVoiceControl = new ExtControlProviderVoiceControl(euVar.fIY.fCt, euVar.fIY.fIt, euVar.fIY.context);
                    euVar.fIZ.fIu = extControlProviderVoiceControl.query(euVar.fIY.uri, null, null, euVar.fIY.selectionArgs, null);
                    SharedPreferences bIY = ab.bIY();
                    if (!b.lqa) {
                        bIY.edit().putBoolean("hasCallVoiceControlApi", true).commit();
                        b.lqa = true;
                    }
                } else {
                    ExtControlProviderOpenApi extControlProviderOpenApi = new ExtControlProviderOpenApi(euVar.fIY.fCt, euVar.fIY.fIt, euVar.fIY.context);
                    euVar.fIZ.fIu = extControlProviderOpenApi.query(euVar.fIY.uri, null, null, euVar.fIY.selectionArgs, null);
                }
                return true;
            }
        }
    }

    public static class b extends com.tencent.mm.sdk.b.c<fa> {
        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            fa faVar = (fa) bVar;
            if (faVar.fJp == null) {
                w.e("MicroMsg.SubCoreExt", "StepCount revent.data is null");
            } else {
                w.i("MicroMsg.SubCoreExt", " action = " + faVar.fJp.action);
                if (faVar.fJp.action == 1) {
                    b.aqO();
                    w.d("MicroMsg.SubCoreExt", " sendBroadcast");
                    return true;
                }
            }
            return false;
        }

        public b() {
            super(0);
            this.usg = fa.class.getName().hashCode();
        }
    }

    static {
        int rl = com.tencent.mm.compatible.d.l.rl();
        try {
            if (!Build.CPU_ABI.contains("armeabi")) {
                w.e("hakon SilkCodec", "x86 machines not supported.");
            } else if ((rl & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
                k.b("wechatvoicesilk_v7a", b.class.getClassLoader());
            } else if ((rl & 512) != 0) {
                k.b("wechatvoicesilk", b.class.getClassLoader());
            } else {
                w.e("hakon SilkCodec", "load library failed! silk don't support armv5!!!!");
            }
        } catch (Exception e) {
            w.e("hakon SilkCodec", "load library failed!");
        }
        HashMap hashMap = new HashMap();
        gJr = hashMap;
        hashMap.put(Integer.valueOf("OPENMSGLISTENER_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return ax.gUx;
            }
        });
        gJr.put(Integer.valueOf("USEROPENIDINAPP_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return be.gUx;
            }
        });
    }

    public static b aqJ() {
        b bVar = (b) ap.yR().gs("plugin.ext");
        if (bVar != null) {
            return bVar;
        }
        Object bVar2 = new b();
        ap.yR().a("plugin.ext", bVar2);
        return bVar2;
    }

    public static t aqK() {
        h.vG().uQ();
        if (aqJ().lpL == null) {
            b aqJ = aqJ();
            ap.yY();
            aqJ.lpL = new t(com.tencent.mm.u.c.wO());
        }
        return aqJ().lpL;
    }

    public static ax aqL() {
        h.vG().uQ();
        if (aqJ().lpM == null) {
            b aqJ = aqJ();
            ap.yY();
            aqJ.lpM = new ax(com.tencent.mm.u.c.wO());
        }
        return aqJ().lpM;
    }

    public static be aqM() {
        h.vG().uQ();
        if (aqJ().lpN == null) {
            b aqJ = aqJ();
            ap.yY();
            aqJ.lpN = new be(com.tencent.mm.u.c.wO());
        }
        return aqJ().lpN;
    }

    public final HashMap<Integer, c> uh() {
        return gJr;
    }

    public final void aN(boolean z) {
        ap.yY();
        this.gYf = com.tencent.mm.u.c.xv();
        File file = new File(this.gYf);
        if (!file.exists()) {
            file.mkdirs();
        }
        file = new File(this.gYf + "image/ext/pcm");
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public final void aM(boolean z) {
        com.tencent.mm.sdk.b.b emVar = new em();
        emVar.fIo.op = 1;
        if (!com.tencent.mm.sdk.b.a.urY.m(emVar)) {
            w.e("MicroMsg.SubCoreExt", "ExtAgentLifeEvent event fail in onAccountPostReset");
        }
        i.bCD().bCE();
        ap.yY();
        com.tencent.mm.u.c.wT().a(this.lpR, null);
        if (this.lpO == null) {
            this.lpO = new a();
        }
        com.tencent.mm.sdk.b.a.urY.b(this.lpO);
        if (this.lpP == null) {
            this.lpP = new b();
        }
        com.tencent.mm.sdk.b.a.urY.b(this.lpP);
        com.tencent.mm.pluginsdk.model.app.i aRr = an.aRr();
        if (aRr != null) {
            aRr.c(this.lpX);
        }
        SharedPreferences bIY = ab.bIY();
        this.lpZ = bIY.getBoolean("hasTryToInitVoiceControlData", false);
        lqa = bIY.getBoolean("hasCallVoiceControlApi", false);
        w.i("MicroMsg.SubCoreExt", "onAccountPostReset,hasTryToInit:%s,hasCallApi:%s", Boolean.valueOf(this.lpZ), Boolean.valueOf(lqa));
        ap.yY();
        com.tencent.mm.u.c.wR().a(this.lex);
        dN(true);
    }

    public final void onAccountRelease() {
        if (this.lpO != null) {
            com.tencent.mm.sdk.b.a.urY.c(this.lpO);
        }
        if (this.lpP != null) {
            com.tencent.mm.sdk.b.a.urY.c(this.lpP);
        }
        com.tencent.mm.pluginsdk.model.app.i aRr = an.aRr();
        if (aRr != null) {
            aRr.f(this.lpX);
        }
        ap.yY();
        com.tencent.mm.u.c.wT().a(this.lpR);
        com.tencent.mm.sdk.b.b emVar = new em();
        emVar.fIo.op = 2;
        if (!com.tencent.mm.sdk.b.a.urY.m(emVar)) {
            w.e("MicroMsg.SubCoreExt", "ExtAgentLifeEvent event fail in onAccountRelease");
        }
        com.tencent.mm.pluginsdk.model.app.t bCD = i.bCD();
        if (ap.zb()) {
            i.sCl = false;
            an.aBG().b(14, bCD);
        }
        this.gYf = "";
        ap.yY();
        com.tencent.mm.u.c.wR().b(this.lex);
    }

    public static String aqN() {
        return aqJ().gYf + "image/ext/pcm";
    }

    public static void aqO() {
        String str = (String) aqK().get(com.tencent.mm.storage.w.a.USERINFO_EXT_SPORT_PKGNAME_STRING, null);
        w.i("MicroMsg.SubCoreExt", "sendSportBroadcast pkgNames = " + str);
        if (str != null) {
            for (String str2 : str.split(";")) {
                final Intent intent = new Intent("com.tencent.mm.plugin.openapi.Intent.ACTION_SET_SPORT_STEP");
                intent.setPackage(str2);
                com.tencent.mm.compatible.a.a.a(12, new com.tencent.mm.compatible.a.a.a() {
                    public final void run() {
                        intent.setFlags(32);
                    }
                });
                intent.putExtra("EXTRA_EXT_OPEN_NOTIFY_TYPE", "SPORT_MESSAGE");
                ab.getContext().sendBroadcast(intent);
            }
        }
    }

    public final void eD(int i) {
    }

    public static x bI(long j) {
        if (!ap.zb() || j <= 0) {
            return null;
        }
        ap.yY();
        return com.tencent.mm.u.c.wR().ez(j);
    }

    public static void bJ(long j) {
        if (j > 0) {
            try {
                ap.yY();
                if (com.tencent.mm.u.c.wT().cD(j)) {
                    ap.yY();
                    com.tencent.mm.plugin.messenger.foundation.a.a.c wT = com.tencent.mm.u.c.wT();
                    ap.yY();
                    wT.M(com.tencent.mm.u.c.wT().cA(j));
                    return;
                }
                w.e("MicroMsg.SubCoreExt", "msgId is out of range, " + j);
            } catch (Throwable e) {
                w.e("MicroMsg.SubCoreExt", e.getMessage());
                w.printErrStackTrace("MicroMsg.SubCoreExt", e, "", new Object[0]);
            }
        }
    }

    public final void aqP() {
        this.lpT.removeMessages(0);
        this.lpT.sendEmptyMessageDelayed(0, 1600);
    }

    public final void dN(boolean z) {
        if (!this.lpY) {
            return;
        }
        if (z && this.lpZ) {
            w.i("MicroMsg.SubCoreExt", "fromStartApp and already try to init");
        } else if (z || lqa) {
            w.i("MicroMsg.SubCoreExt", "initLocalVoiceControl,fromStartApp:%s,hasTryToInit:%s,hasCallApi:%s", Boolean.valueOf(z), Boolean.valueOf(this.lpZ), Boolean.valueOf(lqa));
            this.lpY = false;
            ap.vL().e(new Runnable(this) {
                final /* synthetic */ b lqb;

                {
                    this.lqb = r1;
                }

                /* JADX WARNING: inconsistent code. */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void run() {
                    /*
                    r13 = this;
                    r7 = 0;
                    r12 = 1;
                    r0 = com.tencent.mm.i.g.sV();	 Catch:{ Exception -> 0x00e5 }
                    r1 = "VoiceRecognizeSprSoMD5";
                    r1 = r0.getValue(r1);	 Catch:{ Exception -> 0x00e5 }
                    r0 = com.tencent.mm.i.g.sV();	 Catch:{ Exception -> 0x00e5 }
                    r2 = "VoiceRecognizeSprDataMD5";
                    r2 = r0.getValue(r2);	 Catch:{ Exception -> 0x00e5 }
                    if (r1 == 0) goto L_0x001c;
                L_0x001a:
                    if (r2 != 0) goto L_0x0034;
                L_0x001c:
                    r0 = "MicroMsg.SubCoreExt";
                    r3 = "error mMd5So:%s,  mMd5Data:%s";
                    r4 = 2;
                    r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x00e5 }
                    r5 = 0;
                    r4[r5] = r1;	 Catch:{ Exception -> 0x00e5 }
                    r1 = 1;
                    r4[r1] = r2;	 Catch:{ Exception -> 0x00e5 }
                    com.tencent.mm.sdk.platformtools.w.i(r0, r3, r4);	 Catch:{ Exception -> 0x00e5 }
                    r0 = r13.lqb;	 Catch:{ Exception -> 0x00e5 }
                    r1 = 1;
                    r0.lpY = r1;	 Catch:{ Exception -> 0x00e5 }
                L_0x0033:
                    return;
                L_0x0034:
                    r0 = "/system/lib/";
                    r3 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Exception -> 0x00e5 }
                    r4 = 24;
                    if (r3 < r4) goto L_0x0040;
                L_0x003d:
                    r0 = "/vendor/lib/";
                L_0x0040:
                    r3 = "MicroMsg.SubCoreExt";
                    r4 = "mMd5So:%s,  mMd5Data:%s,  mSoPath:%s";
                    r5 = 3;
                    r5 = new java.lang.Object[r5];	 Catch:{ Exception -> 0x00e5 }
                    r6 = 0;
                    r5[r6] = r1;	 Catch:{ Exception -> 0x00e5 }
                    r6 = 1;
                    r5[r6] = r2;	 Catch:{ Exception -> 0x00e5 }
                    r6 = 2;
                    r5[r6] = r0;	 Catch:{ Exception -> 0x00e5 }
                    com.tencent.mm.sdk.platformtools.w.i(r3, r4, r5);	 Catch:{ Exception -> 0x00e5 }
                    r4 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x00e5 }
                    r3 = com.qq.wx.voice.embed.recognizer.b.a.aIN;	 Catch:{ Exception -> 0x00e5 }
                    r6 = com.tencent.mm.sdk.platformtools.ab.getContext();	 Catch:{ Exception -> 0x00e5 }
                    r3 = r3.aIM;	 Catch:{ Exception -> 0x00e5 }
                    r8 = r3.d;	 Catch:{ Exception -> 0x00e5 }
                    if (r8 == 0) goto L_0x00f9;
                L_0x0065:
                    r0 = r7;
                L_0x0066:
                    r8 = com.tencent.mm.sdk.platformtools.ab.bIY();	 Catch:{ Exception -> 0x00e5 }
                    r1 = "MicroMsg.SubCoreExt";
                    r2 = "checkFiles ret:%s,use time:%s";
                    r3 = 2;
                    r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x00e5 }
                    r6 = 0;
                    r9 = java.lang.Integer.valueOf(r0);	 Catch:{ Exception -> 0x00e5 }
                    r3[r6] = r9;	 Catch:{ Exception -> 0x00e5 }
                    r6 = 1;
                    r10 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x00e5 }
                    r4 = r10 - r4;
                    r4 = java.lang.Long.valueOf(r4);	 Catch:{ Exception -> 0x00e5 }
                    r3[r6] = r4;	 Catch:{ Exception -> 0x00e5 }
                    com.tencent.mm.sdk.platformtools.w.i(r1, r2, r3);	 Catch:{ Exception -> 0x00e5 }
                    if (r0 != 0) goto L_0x01d5;
                L_0x008c:
                    r10 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x00e5 }
                    r3 = new java.util.LinkedList;	 Catch:{ Exception -> 0x00e5 }
                    r3.<init>();	 Catch:{ Exception -> 0x00e5 }
                    r0 = "tmessage";
                    r3.add(r0);	 Catch:{ Exception -> 0x00e5 }
                    r0 = "officialaccounts";
                    r3.add(r0);	 Catch:{ Exception -> 0x00e5 }
                    r0 = "helper_entry";
                    r3.add(r0);	 Catch:{ Exception -> 0x00e5 }
                    com.tencent.mm.u.ap.yY();	 Catch:{ Exception -> 0x00e5 }
                    r0 = com.tencent.mm.u.c.wZ();	 Catch:{ Exception -> 0x00e5 }
                    r1 = "@t.qq.com";
                    r0 = r0.AH(r1);	 Catch:{ Exception -> 0x00e5 }
                    if (r0 == 0) goto L_0x00bc;
                L_0x00b7:
                    r0 = r0.name;	 Catch:{ Exception -> 0x00e5 }
                    r3.add(r0);	 Catch:{ Exception -> 0x00e5 }
                L_0x00bc:
                    r9 = new java.util.ArrayList;	 Catch:{ Exception -> 0x00e5 }
                    r9.<init>();	 Catch:{ Exception -> 0x00e5 }
                    com.tencent.mm.u.ap.yY();	 Catch:{ Exception -> 0x00e5 }
                    r0 = com.tencent.mm.u.c.wR();	 Catch:{ Exception -> 0x00e5 }
                    r1 = "@all.contact.android";
                    r2 = 0;
                    r4 = 0;
                    r5 = 1;
                    r6 = 1;
                    r0 = r0.a(r1, r2, r3, r4, r5, r6);	 Catch:{ Exception -> 0x00e5 }
                    if (r0 != 0) goto L_0x0107;
                L_0x00d5:
                    r0 = "MicroMsg.SubCoreExt";
                    r1 = "initLocalVoiceControl cu is null";
                    com.tencent.mm.sdk.platformtools.w.w(r0, r1);	 Catch:{ Exception -> 0x00e5 }
                    r0 = r13.lqb;	 Catch:{ Exception -> 0x00e5 }
                    r1 = 1;
                    r0.lpY = r1;	 Catch:{ Exception -> 0x00e5 }
                    goto L_0x0033;
                L_0x00e5:
                    r0 = move-exception;
                    r1 = "MicroMsg.SubCoreExt";
                    r2 = "initLocalVoiceControl Exception:%s";
                    r3 = new java.lang.Object[r12];
                    r0 = r0.getMessage();
                    r3[r7] = r0;
                    com.tencent.mm.sdk.platformtools.w.i(r1, r2, r3);
                    goto L_0x0033;
                L_0x00f9:
                    r8 = r3.aIT;	 Catch:{ Exception -> 0x00e5 }
                    r0 = r8.checkFiles(r6, r0, r1, r2);	 Catch:{ Exception -> 0x00e5 }
                    if (r0 < 0) goto L_0x0066;
                L_0x0101:
                    r0 = 1;
                    r3.d = r0;	 Catch:{ Exception -> 0x00e5 }
                    r0 = r7;
                    goto L_0x0066;
                L_0x0107:
                    r1 = r0.moveToFirst();	 Catch:{ Exception -> 0x00e5 }
                    if (r1 == 0) goto L_0x012d;
                L_0x010d:
                    r1 = r0.isAfterLast();	 Catch:{ Exception -> 0x00e5 }
                    if (r1 != 0) goto L_0x012d;
                L_0x0113:
                    r1 = new com.tencent.mm.storage.f;	 Catch:{ Exception -> 0x00e5 }
                    r1.<init>();	 Catch:{ Exception -> 0x00e5 }
                    r1.b(r0);	 Catch:{ Exception -> 0x00e5 }
                    r2 = new com.qq.wx.voice.embed.recognizer.d;	 Catch:{ Exception -> 0x00e5 }
                    r3 = r1.field_username;	 Catch:{ Exception -> 0x00e5 }
                    r4 = r1.field_nickname;	 Catch:{ Exception -> 0x00e5 }
                    r1 = r1.field_conRemark;	 Catch:{ Exception -> 0x00e5 }
                    r2.<init>(r3, r4, r1);	 Catch:{ Exception -> 0x00e5 }
                    r9.add(r2);	 Catch:{ Exception -> 0x00e5 }
                    r0.moveToNext();	 Catch:{ Exception -> 0x00e5 }
                    goto L_0x010d;
                L_0x012d:
                    r0.close();	 Catch:{ Exception -> 0x00e5 }
                    r1 = "MicroMsg.SubCoreExt";
                    r2 = "init cusor,count:%s,use time:%s";
                    r3 = 2;
                    r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x00e5 }
                    r4 = 0;
                    r0 = r0.getCount();	 Catch:{ Exception -> 0x00e5 }
                    r0 = java.lang.Integer.valueOf(r0);	 Catch:{ Exception -> 0x00e5 }
                    r3[r4] = r0;	 Catch:{ Exception -> 0x00e5 }
                    r0 = 1;
                    r4 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x00e5 }
                    r4 = r4 - r10;
                    r4 = java.lang.Long.valueOf(r4);	 Catch:{ Exception -> 0x00e5 }
                    r3[r0] = r4;	 Catch:{ Exception -> 0x00e5 }
                    com.tencent.mm.sdk.platformtools.w.i(r1, r2, r3);	 Catch:{ Exception -> 0x00e5 }
                    r2 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x00e5 }
                    r0 = com.qq.wx.voice.embed.recognizer.b.a.aIN;	 Catch:{ Exception -> 0x00e5 }
                    r1 = r0.aIM;	 Catch:{ Exception -> 0x00e5 }
                    r0 = r1.d;	 Catch:{ Exception -> 0x00e5 }
                    if (r0 != 0) goto L_0x01ab;
                L_0x015f:
                    r0 = -304; // 0xfffffffffffffed0 float:NaN double:NaN;
                L_0x0161:
                    if (r0 != 0) goto L_0x01c5;
                L_0x0163:
                    r1 = r8.edit();	 Catch:{ Exception -> 0x00e5 }
                    r4 = "hasInitVoiceControlData";
                    r5 = 1;
                    r1 = r1.putBoolean(r4, r5);	 Catch:{ Exception -> 0x00e5 }
                    r4 = "hasTryToInitVoiceControlData";
                    r5 = 1;
                    r1 = r1.putBoolean(r4, r5);	 Catch:{ Exception -> 0x00e5 }
                    r1.commit();	 Catch:{ Exception -> 0x00e5 }
                    r1 = r13.lqb;	 Catch:{ Exception -> 0x00e5 }
                    r4 = 1;
                    r1.lpZ = r4;	 Catch:{ Exception -> 0x00e5 }
                L_0x017f:
                    r1 = "MicroMsg.SubCoreExt";
                    r4 = "init ret:%s,use time:%s";
                    r5 = 2;
                    r5 = new java.lang.Object[r5];	 Catch:{ Exception -> 0x00e5 }
                    r6 = 0;
                    r0 = java.lang.Integer.valueOf(r0);	 Catch:{ Exception -> 0x00e5 }
                    r5[r6] = r0;	 Catch:{ Exception -> 0x00e5 }
                    r0 = 1;
                    r8 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x00e5 }
                    r2 = r8 - r2;
                    r2 = java.lang.Long.valueOf(r2);	 Catch:{ Exception -> 0x00e5 }
                    r5[r0] = r2;	 Catch:{ Exception -> 0x00e5 }
                    com.tencent.mm.sdk.platformtools.w.i(r1, r4, r5);	 Catch:{ Exception -> 0x00e5 }
                    r0 = r13.lqb;	 Catch:{ Exception -> 0x00e5 }
                    r1 = 1;
                    r0.lpY = r1;	 Catch:{ Exception -> 0x00e5 }
                L_0x01a4:
                    r0 = r13.lqb;	 Catch:{ Exception -> 0x00e5 }
                    r1 = 1;
                    r0.lpY = r1;	 Catch:{ Exception -> 0x00e5 }
                    goto L_0x0033;
                L_0x01ab:
                    r0 = r1.e;	 Catch:{ Exception -> 0x00e5 }
                    if (r0 == 0) goto L_0x01b9;
                L_0x01af:
                    r0 = r1.aIT;	 Catch:{ Exception -> 0x00e5 }
                    r0 = r0.update(r9);	 Catch:{ Exception -> 0x00e5 }
                    if (r0 < 0) goto L_0x0161;
                L_0x01b7:
                    r0 = r7;
                    goto L_0x0161;
                L_0x01b9:
                    r0 = r1.aIT;	 Catch:{ Exception -> 0x00e5 }
                    r0 = r0.init(r9);	 Catch:{ Exception -> 0x00e5 }
                    if (r0 < 0) goto L_0x0161;
                L_0x01c1:
                    r0 = 1;
                    r1.e = r0;	 Catch:{ Exception -> 0x00e5 }
                    goto L_0x01b7;
                L_0x01c5:
                    r1 = r8.edit();	 Catch:{ Exception -> 0x00e5 }
                    r4 = "hasInitVoiceControlData";
                    r5 = 0;
                    r1 = r1.putBoolean(r4, r5);	 Catch:{ Exception -> 0x00e5 }
                    r1.commit();	 Catch:{ Exception -> 0x00e5 }
                    goto L_0x017f;
                L_0x01d5:
                    r0 = r8.edit();	 Catch:{ Exception -> 0x00e5 }
                    r1 = "hasInitVoiceControlData";
                    r2 = 0;
                    r0 = r0.putBoolean(r1, r2);	 Catch:{ Exception -> 0x00e5 }
                    r1 = "hasTryToInitVoiceControlData";
                    r2 = 1;
                    r0 = r0.putBoolean(r1, r2);	 Catch:{ Exception -> 0x00e5 }
                    r0.commit();	 Catch:{ Exception -> 0x00e5 }
                    r0 = r13.lqb;	 Catch:{ Exception -> 0x00e5 }
                    r1 = 1;
                    r0.lpZ = r1;	 Catch:{ Exception -> 0x00e5 }
                    goto L_0x01a4;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.ext.b.2.run():void");
                }
            }, 10000);
        }
    }
}
