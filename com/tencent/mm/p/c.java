package com.tencent.mm.p;

import com.tencent.mm.p.b.a;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public final class c {
    public volatile boolean gUt = false;
    private volatile boolean gUu = false;
    public List<Map<String, String>> gUv = new CopyOnWriteArrayList();

    public final synchronized boolean tW() {
        boolean z;
        if (this.gUv.size() <= 0) {
            w.i("MicroMsg.FunctionMsgFetcher", "processNextNewXml, all process finished");
            z = false;
        } else if (this.gUu) {
            w.i("MicroMsg.FunctionMsgFetcher", "processNextNewXml, processing new xml");
            z = false;
        } else {
            this.gUu = true;
            Map map = (Map) this.gUv.remove(0);
            String str = (String) map.get(".sysmsg.functionmsg.cgi");
            int i = bg.getInt((String) map.get(".sysmsg.functionmsg.cmdid"), 0);
            String str2 = (String) map.get(".sysmsg.functionmsg.functionmsgid");
            long j = bg.getLong((String) map.get(".sysmsg.functionmsg.version"), 0);
            int i2 = bg.getInt((String) map.get(".sysmsg.functionmsg.op"), 0);
            String str3 = (String) map.get(".sysmsg.functionmsg.custombuff");
            w.d("MicroMsg.FunctionMsgFetcher", "processNextNewXml, cgi: %s, cmdId: %s, functionMsgId: %s, version: %s, op: %s, retryInterval: %s, reportId: %s, successKey: %s, failKey: %s, finalKey: %s, customBuff: %s", str, Integer.valueOf(i), str2, Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(bg.getInt((String) map.get(".sysmsg.functionmsg.retryinterval"), 0)), Integer.valueOf(bg.getInt((String) map.get(".sysmsg.functionmsg.reportid"), 0)), Integer.valueOf(bg.getInt((String) map.get(".sysmsg.functionmsg.successkey"), 0)), Integer.valueOf(bg.getInt((String) map.get(".sysmsg.functionmsg.failkey"), 0)), Integer.valueOf(bg.getInt((String) map.get(".sysmsg.functionmsg.finalfailkey"), 0)), str3);
            com.tencent.mm.sdk.e.c dVar = new d();
            if (!bg.mA(str)) {
                dVar.field_cgi = str;
            }
            dVar.field_cmdid = i;
            if (!bg.mA(str2)) {
                dVar.field_functionmsgid = str2;
            }
            dVar.field_version = j;
            dVar.field_retryinterval = r10;
            dVar.field_reportid = r11;
            dVar.field_successkey = r12;
            dVar.field_failkey = r13;
            dVar.field_finalfailkey = r14;
            if (!bg.mA(str3)) {
                dVar.field_custombuff = str3;
            }
            dVar.field_status = -1;
            dVar.b(null);
            int intValue = Integer.valueOf((String) map.get("FUNCTION_MSG_ADD_MSG_CREATE_TIME_KEY")).intValue();
            com.tencent.mm.sdk.e.c dO = i.uf().dO(dVar.field_functionmsgid);
            if (dO != null) {
                w.i("MicroMsg.FunctionMsgFetcher", "fetchInternal, functionMsgItem.status: %s, version: %s, preVersion: %s", Integer.valueOf(dO.field_status), Long.valueOf(dO.field_version), Long.valueOf(dO.field_preVersion));
            }
            w.d("MicroMsg.FunctionMsgFetcher", "fetchInternal, functionMsgItem: %s", dO);
            if (i2 == 0) {
                dVar.field_needShow = true;
                if (dO == null) {
                    w.i("MicroMsg.FunctionMsgFetcher", "fetchInternal, functionMsgId: %s, op update, insert a new one", dVar.field_functionmsgid);
                    i.uf().b(dVar);
                } else if (dO.field_version < dVar.field_version) {
                    w.i("MicroMsg.FunctionMsgFetcher", "fetchInternal, functionMsgId: %s, op update, update the exist one", dVar.field_functionmsgid);
                    dO.field_preVersion = dO.field_version;
                    dVar.field_preVersion = dO.field_version;
                    i.uf().a(dO.field_functionmsgid, dVar);
                }
                tY();
            } else if (i2 == 1) {
                w.i("MicroMsg.FunctionMsgFetcher", "fetchInternal, op delete");
                if (dO != null) {
                    w.i("MicroMsg.FunctionMsgFetcher", "fetchInternal, functionMsgId: %s, op delete, newFunctionMsgItem.version: %s, functionMsgItem.version: %s", dO.field_functionmsgid, Long.valueOf(dVar.field_version), Long.valueOf(dO.field_version));
                    if (dVar.field_version == dO.field_version || dVar.field_version == 0) {
                        if (dO != null) {
                            try {
                                bu a = a(dO.field_addMsg);
                                str3 = "MicroMsg.FunctionMsgFetcher";
                                r6 = "callbackToDelete, msgContent==null: %s";
                                r7 = new Object[1];
                                r7[0] = Boolean.valueOf(a == null);
                                w.d(str3, r6, r7);
                                if (a != null) {
                                    Map singletonMap = Collections.singletonMap(dO.field_functionmsgid, dO.field_addMsg);
                                    List<f> list = (List) i.ue().gUK.get(Integer.valueOf(a.mtd));
                                    if (list != null) {
                                        for (f a2 : list) {
                                            a2.a(1, singletonMap, false);
                                        }
                                    }
                                }
                            } catch (Exception e) {
                                w.e("MicroMsg.FunctionMsgFetcher", "callbackToDelete error: %s", e.getMessage());
                            }
                        }
                        i.uf().a(dO, new String[0]);
                    }
                } else {
                    w.i("MicroMsg.FunctionMsgFetcher", "fetchInternal, functionMsgId: %s, op delete, the origin one not exist", dVar.field_functionmsgid);
                }
                tZ();
            } else if (i2 == 2) {
                dVar.field_needShow = false;
                if (dO == null) {
                    w.i("MicroMsg.FunctionMsgFetcher", "fetchInternal, functionMsgId: %s, op update but no show, insert a new one", dVar.field_functionmsgid);
                    i.uf().b(dVar);
                } else if (dO.field_version < dVar.field_version) {
                    w.i("MicroMsg.FunctionMsgFetcher", "fetchInternal, functionMsgId: %s, op update but no show, update the exist one, preVersion: %s", dVar.field_functionmsgid, Long.valueOf(dO.field_preVersion));
                    dO.field_preVersion = dO.field_version;
                    dVar.field_preVersion = dO.field_version;
                    i.uf().a(dO.field_functionmsgid, dVar);
                }
                tY();
            } else {
                if (i2 == 3) {
                    w.i("MicroMsg.FunctionMsgFetcher", "fetchInternal, functionMsgId: %s, op show, functionMsgItem: %s", dVar.field_functionmsgid, dO);
                    dVar.field_needShow = true;
                    if (dO != null) {
                        str3 = "MicroMsg.FunctionMsgFetcher";
                        r6 = "fetchInternal, op show, newFunctionMsgItem.version: %s, functionMsgItem.version: %s, functionMsgItem.msgContent == null: %s";
                        r7 = new Object[3];
                        r7[0] = Long.valueOf(dVar.field_version);
                        r7[1] = Long.valueOf(dO.field_version);
                        r7[2] = Boolean.valueOf(dO.field_addMsg == null);
                        w.i(str3, r6, r7);
                        if (dO.field_version >= dVar.field_version || dVar.field_version == 0) {
                            dO.field_needShow = true;
                            if (dO.field_addMsg != null) {
                                w.i("MicroMsg.FunctionMsgFetcher", "show, update create time to: %s", Integer.valueOf(intValue));
                                dO.field_addMsg.ogM = intValue;
                            }
                            i.uf().a(dO.field_functionmsgid, dO);
                            if (dO.field_addMsg != null) {
                                b(Collections.singletonList(dO), true);
                            }
                        }
                    }
                }
                tZ();
            }
            z = true;
        }
        return z;
    }

    private static bu a(bu buVar) {
        boolean z = true;
        if (buVar == null) {
            return null;
        }
        String str = "MicroMsg.FunctionMsgFetcher";
        String str2 = "processAddMsg, fromUser: %s, msgType: %s, content==null: %s";
        Object[] objArr = new Object[3];
        objArr[0] = buVar.tfd;
        objArr[1] = Integer.valueOf(buVar.mtd);
        if (buVar.tff != null) {
            z = false;
        }
        objArr[2] = Boolean.valueOf(z);
        w.i(str, str2, objArr);
        String mz = bg.mz(n.a(buVar.tfd));
        if ("readerapp".equals(mz)) {
            buVar.tfd = n.mw("newsapp");
            buVar.mtd = 12399999;
        }
        if (!"blogapp".equals(mz) && !"newsapp".equals(mz)) {
            return buVar;
        }
        buVar.mtd = 12399999;
        return buVar;
    }

    public final synchronized boolean tX() {
        return this.gUt;
    }

    public final synchronized void tY() {
        if (this.gUt) {
            w.j("MicroMsg.FunctionMsgFetcher", "fetchAllIfNeed, isFetching, ignore this", new Object[0]);
            tZ();
        } else if (am.isNetworkConnected(ab.getContext())) {
            this.gUt = true;
            List ua = i.uf().ua();
            w.d("MicroMsg.FunctionMsgFetcher", "fetchAllIfNeed, fetchItems: %s", ua);
            if (ua == null || ua.size() <= 0) {
                this.gUt = false;
                tZ();
            } else {
                w.i("MicroMsg.FunctionMsgFetcher", "fetchAllIfNeed, fetchItem.size: %s", Integer.valueOf(ua.size()));
                new b(ua, new a(this) {
                    final /* synthetic */ c gUw;

                    {
                        this.gUw = r1;
                    }

                    public final void q(List<d> list) {
                        this.gUw.gUt = false;
                        if (list != null) {
                            w.i("MicroMsg.FunctionMsgFetcher", "onFetchFinish, fetchSuccessList.size: %s", list);
                            c.b(list, false);
                        }
                        this.gUw.tZ();
                    }
                }).start();
            }
        } else {
            w.j("MicroMsg.FunctionMsgFetcher", "fetchAllIfNeed network not connected, ignore this", new Object[0]);
            tZ();
        }
    }

    public final void tZ() {
        w.j("MicroMsg.FunctionMsgFetcher", "loopToNextNewXml", new Object[0]);
        this.gUu = false;
        tW();
    }

    public static void b(List<d> list, boolean z) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    Collection arrayList = new ArrayList();
                    for (d dVar : list) {
                        if (dVar.field_needShow) {
                            dVar.b(a(dVar.field_addMsg));
                            arrayList.add(dVar);
                        }
                    }
                    w.d("MicroMsg.FunctionMsgFetcher", "callbackToUpdate, msgList.size: %s, isShow: %s", Integer.valueOf(arrayList.size()), Boolean.valueOf(z));
                    Map c = c(arrayList);
                    for (Integer intValue : c.keySet()) {
                        int intValue2 = intValue.intValue();
                        List<d> list2 = (List) c.get(Integer.valueOf(intValue2));
                        Map hashMap = new HashMap();
                        for (d dVar2 : list2) {
                            hashMap.put(dVar2.field_functionmsgid, dVar2.field_addMsg);
                        }
                        List<f> list3 = (List) i.ue().gUK.get(Integer.valueOf(intValue2));
                        if (list3 != null) {
                            for (f a : list3) {
                                a.a(0, hashMap, z);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                w.e("MicroMsg.FunctionMsgFetcher", "callbackToUpdate error: %s", e.getMessage());
            }
        }
    }

    private static Map<Integer, List<d>> c(Collection<d> collection) {
        Map<Integer, List<d>> hashMap = new HashMap();
        for (d dVar : collection) {
            if (dVar.field_addMsg != null) {
                List list = (List) hashMap.get(Integer.valueOf(dVar.field_addMsg.mtd));
                if (list == null) {
                    list = new ArrayList();
                }
                list.add(dVar);
                hashMap.put(Integer.valueOf(dVar.field_addMsg.mtd), list);
            }
        }
        return hashMap;
    }
}
