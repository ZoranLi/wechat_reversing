package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.plugin.sns.data.g;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.pluginsdk.model.k;
import com.tencent.mm.sdk.platformtools.ae;
import java.io.OutputStream;

public final class ar extends k<g, String, Boolean> {
    private String fyF;
    private OutputStream hrI = null;
    private String hrJ;
    private String mediaId;
    private String pTT;
    private String pTX = "";

    public final /* synthetic */ Object bed() {
        return Boolean.valueOf(true);
    }

    public final /* synthetic */ void m(Object[] objArr) {
        g[] gVarArr = (g[]) objArr;
        super.m(gVarArr);
        g gVar = gVarArr[0];
        if (gVar != null) {
            this.mediaId = gVar.mediaId;
            this.pTT = am.du(ae.getAccSnsPath(), this.mediaId);
            this.pTX = i.ao(gVar.requestType, this.mediaId);
            this.hrJ = "sns_tmpt_" + this.mediaId;
            this.fyF = "snst_" + this.mediaId;
        }
    }

    public final /* synthetic */ void onPostExecute(Object obj) {
        Boolean bool = (Boolean) obj;
        super.onPostExecute(bool);
        bool.booleanValue();
        ae.beG().EW(this.pTX);
    }

    public final ae bec() {
        return ae.bex();
    }
}
