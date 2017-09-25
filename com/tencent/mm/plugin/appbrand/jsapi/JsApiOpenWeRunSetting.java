package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.bb.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.plugin.sport.b.b;
import com.tencent.mm.protocal.c.adi;
import com.tencent.mm.protocal.c.adj;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.k;
import com.tencent.mm.y.u;
import org.json.JSONObject;

public final class JsApiOpenWeRunSetting extends a {
    public static final int CTRL_INDEX = 228;
    public static final String NAME = "openWeRunSetting";
    private OpenWeRunSetting iOJ;

    private static class OpenWeRunSetting extends MainProcessTask {
        public static final Creator<OpenWeRunSetting> CREATOR = new Creator<OpenWeRunSetting>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new OpenWeRunSetting(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new OpenWeRunSetting[i];
            }
        };
        private boolean fYd = false;
        public d iMF;
        public m iMG;
        public int iMH;
        public boolean iOK = false;

        public OpenWeRunSetting(d dVar, m mVar, int i) {
            w.i("MicroMsg.JsApiOpenWeRunSetting", "OpenWeRunSetting");
            this.iMF = dVar;
            this.iMG = mVar;
            this.iMH = i;
        }

        public OpenWeRunSetting(Parcel parcel) {
            f(parcel);
        }

        public final void PM() {
            this.iOK = ((b) h.h(b.class)).cR(ab.getContext());
            if (this.iOK) {
                Th();
                return;
            }
            a aVar = new a();
            aVar.hsm = new adi();
            aVar.hsn = new adj();
            aVar.uri = "/cgi-bin/mmoc-bin/hardware/getwerunuserstate";
            aVar.hsl = 1926;
            aVar.hso = 0;
            aVar.hsp = 0;
            u.a(aVar.BE(), new u.a(this) {
                final /* synthetic */ OpenWeRunSetting iOL;

                {
                    this.iOL = r1;
                }

                public final int a(int i, int i2, String str, com.tencent.mm.y.b bVar, k kVar) {
                    if (kVar.getType() == 1926) {
                        if (i == 0 && i2 == 0) {
                            adj com_tencent_mm_protocal_c_adj = (adj) bVar.hsk.hsr;
                            if (com_tencent_mm_protocal_c_adj == null || !com_tencent_mm_protocal_c_adj.tIV) {
                                this.iOL.iOK = false;
                            } else {
                                this.iOL.iOK = true;
                            }
                        } else {
                            this.iOL.iOK = false;
                        }
                        w.i("MicroMsg.JsApiOpenWeRunSetting", "After getUserState support %b", new Object[]{Boolean.valueOf(this.iOL.iOK)});
                        this.iOL.Th();
                    }
                    return 0;
                }
            }, true);
        }

        public final void Th() {
            if (this.iOK) {
                this.fYd = ((b) h.h(b.class)).bmm();
                if (this.fYd) {
                    ((b) h.h(b.class)).bml();
                }
            }
            SL();
        }

        public final void SK() {
            if (!this.iOK) {
                this.iMG.x(this.iMH, this.iMF.d("fail device not support", null));
                SN();
            } else if (this.fYd) {
                this.iMG.x(this.iMH, this.iMF.d("ok", null));
                SN();
            } else {
                Context a = this.iMF.a(this.iMG);
                if (a == null) {
                    this.iMG.x(this.iMH, this.iMF.d("fail", null));
                    SN();
                    return;
                }
                AppBrandSysConfig mY = com.tencent.mm.plugin.appbrand.b.mY(this.iMG.ivH);
                if (mY == null || bg.mA(mY.fGs)) {
                    this.iMG.x(this.iMH, this.iMF.d("fail", null));
                    SN();
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("OpenWeRunSettingName", mY.fGs);
                a.uSV = new MMActivity.a(this) {
                    final /* synthetic */ OpenWeRunSetting iOL;

                    {
                        this.iOL = r1;
                    }

                    public final void a(int i, int i2, Intent intent) {
                        if (i != (this.iOL.hashCode() & 65535)) {
                            this.iOL.SN();
                        } else if (i2 == -1) {
                            this.iOL.iMG.x(this.iOL.iMH, this.iOL.iMF.d("ok", null));
                            this.iOL.SN();
                        } else if (i2 == 0) {
                            this.iOL.iMG.x(this.iOL.iMH, this.iOL.iMF.d("cancel", null));
                            this.iOL.SN();
                        } else {
                            this.iOL.iMG.x(this.iOL.iMH, this.iOL.iMF.d("fail", null));
                            this.iOL.SN();
                        }
                    }
                };
                d.a(a, "appbrand", ".ui.AppBrandOpenWeRunSettingUI", intent, hashCode() & 65535, false);
            }
        }

        public final void f(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            if (parcel.readByte() != (byte) 0) {
                z = true;
            } else {
                z = false;
            }
            this.iOK = z;
            if (parcel.readByte() == (byte) 0) {
                z2 = false;
            }
            this.fYd = z2;
        }

        public void writeToParcel(Parcel parcel, int i) {
            byte b;
            byte b2 = (byte) 1;
            if (this.iOK) {
                b = (byte) 1;
            } else {
                b = (byte) 0;
            }
            parcel.writeByte(b);
            if (!this.fYd) {
                b2 = (byte) 0;
            }
            parcel.writeByte(b2);
        }
    }

    public final void a(m mVar, JSONObject jSONObject, int i) {
        this.iOJ = new OpenWeRunSetting(this, mVar, i);
        this.iOJ.SM();
        AppBrandMainProcessService.a(this.iOJ);
    }
}
