package com.tencent.mm.plugin.webview.d;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.mm.e.a.nm;
import com.tencent.mm.e.a.nn;
import com.tencent.mm.e.a.np;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.wcdb.database.SQLiteDatabase;
import org.json.JSONException;
import org.json.JSONObject;

public final class d {
    public String rYS = null;
    private a rYT;
    private c rYU = new c<np>(this) {
        final /* synthetic */ d rYX;

        {
            this.rYX = r2;
            this.usg = np.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            np npVar = (np) bVar;
            if ((npVar instanceof np) && npVar.fUK.fRW == 1) {
                this.rYX.Jk(this.rYX.rYS);
                this.rYX.reset();
            }
            return false;
        }
    };
    private c rYV = new c<nm>(this) {
        final /* synthetic */ d rYX;

        {
            this.rYX = r2;
            this.usg = nm.class.getName().hashCode();
        }

        private boolean a(nm nmVar) {
            if ((nmVar instanceof nm) && "bank".equals(this.rYX.rYS)) {
                if (nmVar.fUD.action == 0) {
                    this.rYX.Jk(this.rYX.rYS);
                } else if (nmVar.fUD.action == 1) {
                    if (bg.mA(nmVar.fUD.cardNum)) {
                        this.rYX.FY(this.rYX.rYS);
                    } else {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("bankcard_number", nmVar.fUD.cardNum);
                            this.rYX.a(this.rYX.rYS, jSONObject, null);
                        } catch (JSONException e) {
                            w.e("MicroMsg.LicenceScanner", "type = bankcard, add cardNum into json, exp = %s ", new Object[]{e});
                            this.rYX.FY(this.rYX.rYS);
                        }
                    }
                }
                this.rYX.reset();
            }
            return false;
        }
    };
    private c rYW = new c<nn>(this) {
        final /* synthetic */ d rYX;

        {
            this.rYX = r2;
            this.usg = nn.class.getName().hashCode();
        }

        private boolean a(nn nnVar) {
            if ((nnVar instanceof nn) && this.rYX.rYS.equalsIgnoreCase(nnVar.fUE.cardType)) {
                if (nnVar.fUE.fUF == 0) {
                    this.rYX.FY(this.rYX.rYS);
                } else if (nnVar.fUE.fUF == 2) {
                    this.rYX.Jk(this.rYX.rYS);
                } else {
                    try {
                        if (bg.mA(nnVar.fUE.fUG)) {
                            this.rYX.a(this.rYX.rYS, null, nnVar.fUE.fUH);
                        } else {
                            this.rYX.a(this.rYX.rYS, new JSONObject(nnVar.fUE.fUG), nnVar.fUE.fUH);
                        }
                    } catch (Exception e) {
                        w.e("MicroMsg.LicenceScanner", "Failed to parse json string: %s", new Object[]{e.getMessage()});
                        this.rYX.FY(this.rYX.rYS);
                    }
                }
                this.rYX.reset();
            }
            return false;
        }
    };

    public interface a {
        void FY(String str);

        void Jk(String str);

        void a(String str, JSONObject jSONObject, Bitmap bitmap);
    }

    public final boolean a(String str, Context context, a aVar) {
        Intent intent;
        if ("bank".equalsIgnoreCase(str)) {
            intent = new Intent();
            intent.putExtra("BaseScanUI_select_scan_mode", 7);
            intent.putExtra("scan_bankcard_with_confirm_ui", true);
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            com.tencent.mm.bb.d.b(context, "scanner", ".ui.BaseScanUI", intent);
            this.rYT = aVar;
            this.rYS = "bank";
            com.tencent.mm.sdk.b.a.urY.b(this.rYU);
            com.tencent.mm.sdk.b.a.urY.b(this.rYV);
            return true;
        } else if (!"identity_pay_auth".equalsIgnoreCase(str)) {
            return false;
        } else {
            intent = new Intent();
            intent.putExtra("BaseScanUI_select_scan_mode", 11);
            com.tencent.mm.bb.d.b(context, "scanner", ".ui.BaseScanUI", intent);
            this.rYT = aVar;
            this.rYS = "identity";
            com.tencent.mm.sdk.b.a.urY.b(this.rYU);
            com.tencent.mm.sdk.b.a.urY.b(this.rYW);
            return true;
        }
    }

    public final void reset() {
        this.rYT = null;
        com.tencent.mm.sdk.b.a.urY.c(this.rYU);
        com.tencent.mm.sdk.b.a.urY.c(this.rYV);
        com.tencent.mm.sdk.b.a.urY.c(this.rYW);
    }

    public final void Jk(String str) {
        if (this.rYT != null) {
            this.rYT.Jk(str);
        }
    }

    public final void FY(String str) {
        if (this.rYT != null) {
            this.rYT.FY(str);
        }
    }

    public final void a(String str, JSONObject jSONObject, Bitmap bitmap) {
        if (this.rYT != null) {
            this.rYT.a(str, jSONObject, bitmap);
        }
    }
}
