package com.tencent.mm.storage.a;

import android.database.Cursor;
import com.tencent.mm.bj.f;
import com.tencent.mm.bj.f.a;
import com.tencent.mm.protocal.c.aad;
import com.tencent.mm.protocal.c.baj;
import com.tencent.mm.protocal.c.xq;
import com.tencent.mm.protocal.c.xy;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.IOException;

public final class r extends i<q> implements a {
    public static final String[] gUx = new String[]{i.a(q.gTP, "GetEmotionListCache")};
    private e gUz;

    public r(e eVar) {
        this(eVar, q.gTP, "GetEmotionListCache");
    }

    private r(e eVar, c.a aVar, String str) {
        super(eVar, aVar, str, null);
        this.gUz = eVar;
    }

    public final int a(f fVar) {
        if (fVar != null) {
            this.gUz = fVar;
        }
        return 0;
    }

    private boolean Sp(String str) {
        if (this.gUz.delete("GetEmotionListCache", "reqType=?", new String[]{str}) > 0) {
            return true;
        }
        return false;
    }

    public final boolean a(int i, xy xyVar) {
        boolean z = false;
        if (xyVar != null) {
            try {
                this.gUz.delete("GetEmotionListCache", "reqType=?", new String[]{String.valueOf(i)});
                c qVar = new q(String.valueOf(i), xyVar.toByteArray());
                w.d("MicroMsg.emoji.Storage", "insert cache: %d", new Object[]{Integer.valueOf(i)});
                z = b(qVar);
            } catch (Throwable e) {
                w.e("MicroMsg.emoji.Storage", "exception:%s", new Object[]{bg.g(e)});
            }
        }
        return z;
    }

    public final xy yO(int i) {
        xy xyVar = null;
        Cursor a = this.gUz.a("GetEmotionListCache", null, "reqType=?", new String[]{String.valueOf(i)}, null, null, null, 2);
        if (a != null && a.moveToFirst()) {
            q qVar = new q(a);
            try {
                xy xyVar2 = new xy();
                xyVar2.aD(qVar.field_cache);
                w.d("MicroMsg.emoji.Storage", "succed get cache: %d", new Object[]{Integer.valueOf(i)});
                xyVar = xyVar2;
            } catch (Throwable e) {
                w.e("MicroMsg.emoji.Storage", "exception:%s", new Object[]{bg.g(e)});
            }
        }
        if (a != null) {
            a.close();
        }
        return xyVar;
    }

    public final boolean a(String str, aad com_tencent_mm_protocal_c_aad) {
        boolean z = false;
        if (com_tencent_mm_protocal_c_aad != null) {
            try {
                Sp(str);
                z = b(new q(str, com_tencent_mm_protocal_c_aad.toByteArray()));
            } catch (Throwable e) {
                w.e("MicroMsg.emoji.Storage", "exception:%s", new Object[]{bg.g(e)});
            }
        }
        return z;
    }

    public final aad Sq(String str) {
        aad com_tencent_mm_protocal_c_aad = null;
        Cursor a = this.gUz.a("GetEmotionListCache", null, "reqType=?", new String[]{str}, null, null, null, 2);
        if (a != null && a.moveToFirst()) {
            q qVar = new q(a);
            try {
                aad com_tencent_mm_protocal_c_aad2 = new aad();
                com_tencent_mm_protocal_c_aad2.aD(qVar.field_cache);
                w.d("MicroMsg.emoji.Storage", "succed get designerID cache: %s", new Object[]{str});
                com_tencent_mm_protocal_c_aad = com_tencent_mm_protocal_c_aad2;
            } catch (Throwable e) {
                w.e("MicroMsg.emoji.Storage", "exception:%s", new Object[]{bg.g(e)});
            }
        }
        if (a != null) {
            a.close();
        }
        return com_tencent_mm_protocal_c_aad;
    }

    public final baj bNH() {
        Cursor query;
        Throwable e;
        try {
            baj com_tencent_mm_protocal_c_baj;
            query = this.gUz.query("GetEmotionListCache", null, "reqType=?", new String[]{"Smiley_panel_req_type"}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        q qVar = new q(query);
                        com_tencent_mm_protocal_c_baj = new baj();
                        com_tencent_mm_protocal_c_baj.aD(qVar.field_cache);
                        if (query != null) {
                            return com_tencent_mm_protocal_c_baj;
                        }
                        query.close();
                        return com_tencent_mm_protocal_c_baj;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        w.e("MicroMsg.emoji.Storage", "exception:%s", new Object[]{bg.g(e)});
                        if (query != null) {
                            return null;
                        }
                        query.close();
                        return null;
                    } catch (Throwable th) {
                        e = th;
                        if (query != null) {
                            query.close();
                        }
                        throw e;
                    }
                }
            }
            com_tencent_mm_protocal_c_baj = null;
            if (query != null) {
                return com_tencent_mm_protocal_c_baj;
            }
            query.close();
            return com_tencent_mm_protocal_c_baj;
        } catch (Exception e3) {
            e = e3;
            query = null;
            w.e("MicroMsg.emoji.Storage", "exception:%s", new Object[]{bg.g(e)});
            if (query != null) {
                return null;
            }
            query.close();
            return null;
        } catch (Throwable th2) {
            e = th2;
            query = null;
            if (query != null) {
                query.close();
            }
            throw e;
        }
    }

    public final boolean a(baj com_tencent_mm_protocal_c_baj) {
        boolean z = false;
        try {
            Sp("Smiley_panel_req_type");
            z = b(new q("Smiley_panel_req_type", com_tencent_mm_protocal_c_baj.toByteArray()));
        } catch (Throwable e) {
            w.e("MicroMsg.emoji.Storage", "exception:%s", new Object[]{bg.g(e)});
        }
        return z;
    }

    public final xq Sr(String str) {
        Cursor query;
        Throwable e;
        if (bg.mA(str)) {
            w.w("MicroMsg.emoji.Storage", "getEmotionActivityByID failed. activityID is null.");
            return null;
        }
        xq xqVar;
        try {
            query = this.gUz.query("GetEmotionListCache", null, "reqType=?", new String[]{str}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        q qVar = new q(query);
                        xqVar = new xq();
                        xqVar.aD(qVar.field_cache);
                        if (query != null) {
                            query.close();
                        }
                        return xqVar;
                    }
                } catch (IOException e2) {
                    e = e2;
                    try {
                        w.e("MicroMsg.emoji.Storage", "exception:%s", new Object[]{bg.g(e)});
                        if (query == null) {
                            query.close();
                            xqVar = null;
                        } else {
                            xqVar = null;
                        }
                        return xqVar;
                    } catch (Throwable th) {
                        e = th;
                        if (query != null) {
                            query.close();
                        }
                        throw e;
                    }
                }
            }
            xqVar = null;
            if (query != null) {
                query.close();
            }
        } catch (IOException e3) {
            e = e3;
            query = null;
            w.e("MicroMsg.emoji.Storage", "exception:%s", new Object[]{bg.g(e)});
            if (query == null) {
                xqVar = null;
            } else {
                query.close();
                xqVar = null;
            }
            return xqVar;
        } catch (Throwable th2) {
            e = th2;
            query = null;
            if (query != null) {
                query.close();
            }
            throw e;
        }
        return xqVar;
    }

    public final boolean a(String str, xq xqVar) {
        boolean z = false;
        if (xqVar != null) {
            try {
                Sp(str);
                z = b(new q(str, xqVar.toByteArray()));
            } catch (Throwable e) {
                w.e("MicroMsg.emoji.Storage", "exception:%s", new Object[]{bg.g(e)});
            }
        }
        return z;
    }
}
