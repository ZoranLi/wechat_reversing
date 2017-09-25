package com.tencent.mm.plugin.sns.a.a;

import android.os.SystemClock;
import com.tencent.mm.plugin.sns.a.a.a.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.LinkedList;

public final class h {
    public String TAG = "MicroMsg.SnsAdVideoStatistic";
    public int pPq = 0;
    public int pPr = 0;
    public long pPs = 0;
    public int pPt = 0;
    public int pPu = 0;
    public int pPv = 0;
    public int pPw = 0;
    public a pPx = new a();
    public LinkedList<a> pPy = new LinkedList();

    public h(String str) {
        this.TAG = "MicroMsg.SnsAdVideoStatistic:" + str;
    }

    public final void sM(int i) {
        if (this.pPx.pQu <= 0) {
            this.pPx.pQu = this.pPx.pQy == 0 ? 0 : (int) bg.aB(this.pPx.pQy);
        }
        if (i != 0) {
            this.pPx.pQv = i;
        }
        w.i(this.TAG, "pushplayitem duration " + this.pPx.pQu + " " + this.pPx.pQx);
        this.pPy.add(this.pPx);
        this.pPx = new a();
    }

    public final String bdp() {
        int i;
        if (this.pPs == 0) {
            i = 0;
        } else {
            i = (int) bg.aB(this.pPs);
        }
        this.pPr = i;
        w.d(this.TAG, "__staytotaltime " + this.pPs + " " + this.pPr + " clock: " + SystemClock.elapsedRealtime());
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<viewinfo>");
        stringBuffer.append("<downloadstatus>");
        stringBuffer.append(this.pPq);
        stringBuffer.append("</downloadstatus>");
        stringBuffer.append("<staytotaltime>");
        stringBuffer.append(this.pPr);
        stringBuffer.append("</staytotaltime>");
        if (this.pPt > 0) {
            stringBuffer.append("<masktotaltime>");
            stringBuffer.append(this.pPt);
            stringBuffer.append("</masktotaltime>");
        }
        stringBuffer.append(String.format("<playitemlist count=\"%d\">", new Object[]{Integer.valueOf(this.pPy.size())}));
        for (int i2 = 0; i2 < this.pPy.size(); i2++) {
            a aVar = (a) this.pPy.get(i2);
            stringBuffer.append("<playitem>");
            stringBuffer.append(String.format("<playcount>%d</playcount>", new Object[]{Integer.valueOf(aVar.pQt)}));
            stringBuffer.append(String.format("<playtotaltime>%d</playtotaltime>", new Object[]{Integer.valueOf(aVar.pQu)}));
            stringBuffer.append(String.format("<videototaltime>%d</videototaltime>", new Object[]{Integer.valueOf(aVar.pQv * 1000)}));
            stringBuffer.append(String.format("<playmode>%d</playmode>", new Object[]{Integer.valueOf(aVar.pQw)}));
            stringBuffer.append(String.format("<playorientation>%d</playorientation>", new Object[]{Integer.valueOf(aVar.pQx)}));
            stringBuffer.append("</playitem>");
        }
        stringBuffer.append("</playitemlist>");
        stringBuffer.append("</viewinfo>");
        String stringBuffer2 = stringBuffer.toString();
        w.i(this.TAG, "xml " + stringBuffer2);
        return stringBuffer2;
    }
}
