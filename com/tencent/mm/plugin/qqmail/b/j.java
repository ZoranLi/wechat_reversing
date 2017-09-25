package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.loader.stub.b;
import com.tencent.mm.plugin.qqmail.b.p.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class j {
    public List<a> gJv;
    public long ozK = 0;
    private e ozL;
    a ozM;
    private int ozN = 0;
    public int ozO = 1;
    private int ozP = 2;
    public int ozQ = 3;
    public int status = this.ozN;

    public static abstract class a {
        public abstract void onComplete();
    }

    j(String str) {
        this.ozL = new e(str, 1);
        byte[] readFromFile = e.readFromFile(this.ozL.ozt + "address");
        if (readFromFile != null) {
            this.ozL.a("address", null, readFromFile);
            b.deleteFile(this.ozL.ozt + "address");
        } else {
            readFromFile = this.ozL.i("address", null);
        }
        if (readFromFile != null) {
            try {
                this.ozM = new a().aC(readFromFile);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.Plugin.MailAddrMgr", e, "", new Object[0]);
                this.ozM = new a();
                this.ozM.CK("");
            }
        } else {
            this.ozM = new a();
            this.ozM.CK("");
        }
        this.gJv = new ArrayList();
    }

    protected final void finalize() {
        this.gJv.clear();
    }

    public final List<i> CP(String str) {
        List<i> list = this.ozM.ozg;
        if (this.status <= this.ozO) {
            aUo();
            return list;
        } else if (str == null || str.length() == 0) {
            return list;
        } else {
            List<i> arrayList = new ArrayList();
            for (i iVar : list) {
                if (iVar != null && ((iVar.name != null && iVar.name.contains(str)) || ((iVar.ozJ != null && iVar.ozJ.contains(str)) || (iVar.naK != null && iVar.naK.contains(str))))) {
                    a.b(iVar);
                    arrayList.add(iVar);
                }
            }
            return arrayList;
        }
    }

    public final void aUo() {
        if (this.status != this.ozP) {
            if (bg.Nz() - this.ozK <= 600000) {
                for (a onComplete : this.gJv) {
                    onComplete.onComplete();
                }
                return;
            }
            this.status = this.ozP;
            Map hashMap = new HashMap();
            hashMap.put("syncinfo", this.ozM.oze == null ? "" : this.ozM.oze);
            w.d("MicroMsg.Plugin.MailAddrMgr", "%s", new Object[]{"sync~~~"});
            w.aUz().b("/cgi-bin/syncaddrlist", hashMap, new c(), new com.tencent.mm.plugin.qqmail.b.p.a(this) {
                final /* synthetic */ j ozR;

                {
                    this.ozR = r1;
                }

                public final void onSuccess(String str, Map<String, String> map) {
                    j jVar = this.ozR;
                    int i = bg.getInt((String) map.get(".Response.result.Count"), 0);
                    if (i > 0) {
                        int i2 = jVar.ozM.ozg.size() == 0 ? 1 : 0;
                        int i3 = 0;
                        while (i3 < i) {
                            String str2 = ".Response.result.List.item" + (i3 > 0 ? String.valueOf(i3) : "") + ".";
                            String str3 = (String) map.get(str2 + "Del");
                            String str4 = (String) map.get(str2 + "Freq");
                            String str5 = (String) map.get(str2 + "Name");
                            str2 = (String) map.get(str2 + "Addr");
                            if (str2 != null && str2.length() != 0) {
                                if (str5 == null || str5.length() == 0) {
                                    str5 = str2;
                                }
                                int hashCode = str2.hashCode();
                                if (str3.equals("0")) {
                                    List list = jVar.ozM.ozg;
                                    int i4 = 0;
                                    while (i2 == 0 && i4 < list.size() && ((i) list.get(i4)).ozH != hashCode) {
                                        i4++;
                                    }
                                    if (i4 >= list.size() || i2 != 0) {
                                        i iVar = new i();
                                        iVar.ozH = hashCode;
                                        iVar.name = str5;
                                        iVar.naK = str2;
                                        iVar.ozI = Integer.parseInt(str4);
                                        jVar.ozM.a(iVar);
                                    }
                                } else {
                                    Iterator it = jVar.ozM.ozg.iterator();
                                    int i5 = 0;
                                    while (it.hasNext()) {
                                        if (((i) it.next()).ozH == hashCode) {
                                            jVar.ozM.rA(i5);
                                            break;
                                        }
                                        i5++;
                                    }
                                }
                            }
                            i3++;
                        }
                        jVar.ozM.CK((String) map.get(".Response.result.SyncInfo"));
                        jVar.save();
                    }
                    if (((String) map.get(".Response.result.ContinueFlag")).equals("1")) {
                        new ae().postDelayed(new Runnable(this) {
                            final /* synthetic */ AnonymousClass1 ozS;

                            {
                                this.ozS = r1;
                            }

                            public final void run() {
                                this.ozS.ozR.status = this.ozS.ozR.ozO;
                                this.ozS.ozR.aUo();
                            }
                        }, 0);
                        return;
                    }
                    this.ozR.ozK = bg.Nz();
                    for (a onComplete : this.ozR.gJv) {
                        onComplete.onComplete();
                    }
                }

                public final void onError(int i, String str) {
                    for (a onComplete : this.ozR.gJv) {
                        onComplete.onComplete();
                    }
                }

                public final void onComplete() {
                    this.ozR.status = this.ozR.ozQ;
                }
            });
        }
    }

    public final void a(a aVar) {
        for (a aVar2 : this.gJv) {
            if (aVar2 == aVar) {
                return;
            }
        }
        this.gJv.add(aVar);
    }

    public final void b(a aVar) {
        for (a aVar2 : this.gJv) {
            if (aVar2 == aVar) {
                this.gJv.remove(aVar2);
                return;
            }
        }
    }

    public final void bb(List<i> list) {
        a aVar = this.ozM;
        if (!(list == null || list.size() == 0)) {
            for (i iVar : list) {
                Iterator it = aVar.ozg.iterator();
                int i = 0;
                while (it.hasNext()) {
                    i iVar2 = (i) it.next();
                    if (iVar2.naK.equalsIgnoreCase(iVar.naK)) {
                        aVar.rA(i);
                        iVar2.ozI++;
                        aVar.a(iVar2);
                        break;
                    }
                    i++;
                }
            }
        }
        save();
    }

    final void save() {
        try {
            this.ozL.a("address", null, this.ozM.toByteArray());
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.Plugin.MailAddrMgr", e, "", new Object[0]);
        }
    }

    public static i CQ(String str) {
        if (str == null) {
            return null;
        }
        String trim = str.trim();
        int lastIndexOf = trim.trim().lastIndexOf(" ");
        if (lastIndexOf == -1) {
            return null;
        }
        i iVar = new i();
        iVar.name = trim.substring(0, lastIndexOf);
        iVar.naK = trim.substring(lastIndexOf + 1);
        return iVar;
    }
}
