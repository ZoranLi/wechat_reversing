package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.a.o;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.e.a.nv;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.protocal.c.bpv;
import com.tencent.mm.protocal.c.bpw;
import com.tencent.mm.protocal.c.bqf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.t.c;
import com.tencent.mm.t.f.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.q;
import com.tencent.mm.y.k;
import com.tencent.mm.y.u;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class SendAppMessageTask extends MainProcessTask {
    public static final Creator<SendAppMessageTask> CREATOR = new Creator<SendAppMessageTask>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new SendAppMessageTask(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SendAppMessageTask[i];
        }
    };
    String appId;
    String description;
    String fCN;
    String fFa;
    int fKL;
    String iGd;
    String iHY;
    Runnable iMD;
    String iVA;
    boolean iVB;
    String iVC;
    ArrayList<ShareInfo> iVD;
    String iVv;
    String iVw;
    String iVx;
    String iVy;
    String iVz;
    String iconUrl;
    int ixp;
    String path;
    int scene = 1000;
    String title;
    String toUser;
    int type;
    String url;
    String userName;
    int version;
    boolean withShareTicket;

    public final void PM() {
        Bitmap gN;
        w.i("MicroMsg.SendAppMessageTask", "username = %s, thumbIconUrl = %s", new Object[]{this.userName, this.iVw});
        byte[] bArr = new byte[0];
        if (!bg.mA(this.iVw) && (this.iVw.startsWith("http://") || this.iVw.startsWith("https://"))) {
            gN = b.AY().gN(this.iVw);
        } else if (bg.mA(this.iVx)) {
            gN = null;
        } else {
            gN = d.Pg(this.iVx);
            boolean deleteFile = com.tencent.mm.loader.stub.b.deleteFile(this.iVx);
            w.v("MicroMsg.SendAppMessageTask", "decode thumb icon bitmap by path(%s), and deleted(%s) file.", new Object[]{this.iVx, Boolean.valueOf(deleteFile)});
        }
        if (gN == null || gN.isRecycled()) {
            w.e("MicroMsg.SendAppMessageTask", "thumb image is null");
        } else {
            w.i("MicroMsg.SendAppMessageTask", "thumb image is not null ");
            Bitmap createBitmap = Bitmap.createBitmap(gN.getWidth(), gN.getHeight(), Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            canvas.drawColor(-1);
            canvas.drawBitmap(gN, 0.0f, 0.0f, null);
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            createBitmap.compress(CompressFormat.JPEG, 100, byteArrayOutputStream);
            bArr = byteArrayOutputStream.toByteArray();
            createBitmap.recycle();
        }
        w.i("MicroMsg.SendAppMessageTask", "doSendMessage, appId : %s, title = %s, description = %s ,username = %s ,path = %s, thumbIconUrl = %s", new Object[]{this.appId, this.title, this.description, this.userName, this.path, this.iVw});
        q.yC().n(q.fQ("wxapp_" + this.appId + this.path), true).l("prePublishId", "wxapp_" + this.appId + this.path);
        final a aVar = new a();
        aVar.title = this.title;
        aVar.description = this.description;
        aVar.type = 33;
        aVar.hjM = this.userName;
        aVar.hjL = this.path;
        aVar.hjN = this.appId;
        aVar.hjT = this.fKL;
        aVar.hjU = this.version;
        aVar.hjP = this.iGd;
        aVar.hjO = this.type;
        aVar.url = this.url;
        aVar.hjV = this.iconUrl;
        aVar.fUX = "wxapp_" + this.appId + this.path;
        aVar.fUR = this.userName;
        aVar.fUS = this.fFa;
        c aVar2 = new com.tencent.mm.t.a();
        aVar2.hhi = this.iVB;
        aVar2.hhj = this.iHY;
        aVar.a(aVar2);
        final StringBuilder stringBuilder = new StringBuilder("1_");
        stringBuilder.append(this.appId);
        stringBuilder.append("_");
        ap.yY();
        stringBuilder.append(o.getString(com.tencent.mm.u.c.uH()));
        stringBuilder.append("_");
        stringBuilder.append(bg.Ny());
        stringBuilder.append("_");
        stringBuilder.append(this.ixp);
        aVar.hjR = stringBuilder.toString();
        if (this.withShareTicket) {
            final int i = this.scene;
            com.tencent.mm.y.b.a aVar3 = new com.tencent.mm.y.b.a();
            aVar3.hsl = 1118;
            aVar3.uri = "/cgi-bin/mmbiz-bin/wxaapp/getshareinfo";
            com.tencent.mm.bd.a com_tencent_mm_protocal_c_bpv = new bpv();
            com_tencent_mm_protocal_c_bpv.fTO = this.appId;
            final LinkedList linkedList = new LinkedList(bg.f(this.toUser.split(",")));
            com_tencent_mm_protocal_c_bpv.unW = linkedList;
            aVar3.hsm = com_tencent_mm_protocal_c_bpv;
            aVar3.hsn = new bpw();
            u.a(aVar3.BE(), new u.a(this) {
                final /* synthetic */ SendAppMessageTask iVI;

                public final int a(int i, int i2, String str, com.tencent.mm.y.b bVar, k kVar) {
                    w.i("MicroMsg.SendAppMessageTask", "callback, errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                    bpw com_tencent_mm_protocal_c_bpw = (bpw) bVar.hsk.hsr;
                    if (i != 0 || i2 != 0 || com_tencent_mm_protocal_c_bpw == null || com_tencent_mm_protocal_c_bpw.unX == null) {
                        if (aVar.hjO == 3) {
                            aVar.hjO = 2;
                        }
                        Iterator it = linkedList.iterator();
                        while (it.hasNext()) {
                            this.iVI.a(aVar, bArr, (String) it.next(), stringBuilder, i);
                        }
                    } else {
                        LinkedList linkedList = com_tencent_mm_protocal_c_bpw.unX;
                        this.iVI.iVD = new ArrayList();
                        int i3 = 0;
                        while (i3 < linkedList.size()) {
                            bqf com_tencent_mm_protocal_c_bqf = i3 < linkedList.size() ? (bqf) linkedList.get(i3) : new bqf();
                            aVar.hjS = com_tencent_mm_protocal_c_bqf.uov;
                            this.iVI.iVD.add(new ShareInfo(com_tencent_mm_protocal_c_bqf.uov, com_tencent_mm_protocal_c_bqf.uou));
                            this.iVI.a(aVar, bArr, (String) linkedList.get(i3), stringBuilder, i);
                            i3++;
                        }
                    }
                    this.iVI.SL();
                    return 0;
                }
            });
            return;
        }
        Iterator it = new LinkedList(bg.f(this.toUser.split(","))).iterator();
        while (it.hasNext()) {
            a(aVar, bArr, (String) it.next(), stringBuilder, this.scene);
        }
    }

    public final void SK() {
        if (this.iMD != null) {
            this.iMD.run();
        }
    }

    public final void a(a aVar, byte[] bArr, String str, StringBuilder stringBuilder, int i) {
        l.a(aVar, this.appId, this.title, str, null, bArr);
        if (!bg.mA(this.iVv)) {
            com.tencent.mm.sdk.b.b nvVar = new nv();
            nvVar.fVa.fVb = str;
            nvVar.fVa.content = this.iVv;
            nvVar.fVa.type = com.tencent.mm.u.o.fG(str);
            nvVar.fVa.flags = 0;
            com.tencent.mm.sdk.b.a.urY.m(nvVar);
        }
        int i2 = 1;
        if (str.toLowerCase().endsWith("@chatroom")) {
            ap.yY();
            List fZ = com.tencent.mm.u.c.xa().fZ(str);
            i2 = fZ != null ? fZ.size() : 0;
        }
        String str2 = this.appId;
        String str3 = this.fCN;
        String str4 = this.iVy;
        String str5 = this.title;
        String str6 = this.path;
        String str7 = this.iVz;
        String str8 = this.iVA;
        String stringBuilder2 = stringBuilder.toString();
        String str9 = this.iVC;
        if (bg.mA(str2)) {
            w.e("MicroMsg.SendAppMessageTask", "appId is Null!");
            return;
        }
        String str10 = "";
        try {
            str10 = p.encode(bg.mz(str6), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            w.e("MicroMsg.SendAppMessageTask", "encode share page path error!");
        }
        String str11 = "";
        try {
            str11 = p.encode(bg.mz(str7), "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            w.e("MicroMsg.SendAppMessageTask", "encode current page path error!");
        }
        String str12 = "";
        try {
            str12 = p.encode(bg.mz(str9), "UTF-8");
        } catch (UnsupportedEncodingException e3) {
            w.e("MicroMsg.SendAppMessageTask", "encode current html url error!");
        }
        w.d("MicroMsg.SendAppMessageTask", "stev report(%s), appId %s, scene %s, sceneNote %s, sessionId %s, currentPath %s, currentTitle %s,shareTitle %s, sharePath %s, shareActionId %s, destinationUserCount %s, destinationUserName %s", new Object[]{Integer.valueOf(14077), str2, Integer.valueOf(i), str3, str4, str7, str8, str5, str6, stringBuilder2, Integer.valueOf(i2), str});
        g.oUh.i(14077, new Object[]{str2, Integer.valueOf(i), str3, str4, str11, str8, str5, str10, stringBuilder2, "", Integer.valueOf(i2), str, str12});
    }

    public final void f(Parcel parcel) {
        boolean z = true;
        this.appId = parcel.readString();
        this.userName = parcel.readString();
        this.title = parcel.readString();
        this.description = parcel.readString();
        this.iVv = parcel.readString();
        this.toUser = parcel.readString();
        this.url = parcel.readString();
        this.path = parcel.readString();
        this.type = parcel.readInt();
        this.iVw = parcel.readString();
        this.iconUrl = parcel.readString();
        this.iVx = parcel.readString();
        this.fKL = parcel.readInt();
        this.iGd = parcel.readString();
        this.version = parcel.readInt();
        this.fFa = parcel.readString();
        this.ixp = parcel.readInt();
        this.scene = parcel.readInt();
        this.fCN = parcel.readString();
        this.iVy = parcel.readString();
        this.iVz = parcel.readString();
        this.iVA = parcel.readString();
        this.withShareTicket = parcel.readByte() == (byte) 1;
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.iVB = z;
        this.iHY = parcel.readString();
        this.iVC = parcel.readString();
        this.iVD = parcel.readArrayList(SendAppMessageTask.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        super.writeToParcel(parcel, i);
        parcel.writeString(this.appId);
        parcel.writeString(this.userName);
        parcel.writeString(this.title);
        parcel.writeString(this.description);
        parcel.writeString(this.iVv);
        parcel.writeString(this.toUser);
        parcel.writeString(this.url);
        parcel.writeString(this.path);
        parcel.writeInt(this.type);
        parcel.writeString(this.iVw);
        parcel.writeString(this.iconUrl);
        parcel.writeString(this.iVx);
        parcel.writeInt(this.fKL);
        parcel.writeString(this.iGd);
        parcel.writeInt(this.version);
        parcel.writeString(this.fFa);
        parcel.writeInt(this.ixp);
        parcel.writeInt(this.scene);
        parcel.writeString(this.fCN);
        parcel.writeString(this.iVy);
        parcel.writeString(this.iVz);
        parcel.writeString(this.iVA);
        parcel.writeByte((byte) (this.withShareTicket ? 1 : 0));
        if (!this.iVB) {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeString(this.iHY);
        parcel.writeString(this.iVC);
        parcel.writeList(this.iVD);
    }

    protected SendAppMessageTask(Parcel parcel) {
        f(parcel);
    }
}
