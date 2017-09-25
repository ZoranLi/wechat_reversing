package com.tencent.mm.plugin.sns.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import b.a.d.i;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.aw;
import com.tencent.mm.plugin.sns.model.h;
import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView;
import com.tencent.mm.plugin.sns.ui.previewimageview.e;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.ajq;
import com.tencent.mm.protocal.c.baw;
import com.tencent.mm.protocal.c.bca;
import com.tencent.mm.protocal.c.bcs;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.s;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class ag extends a {
    private String appId;
    private String appName;
    public MMActivity fCi;
    private String iCS;
    private int qqL;
    private com.tencent.mm.modelsns.b qqR = null;
    private boolean qsD = false;
    private boolean qul = false;
    private boolean qum = false;
    private WXMediaMessage qun = null;
    public b qwj = new b(this);
    private v qwk;
    Map<String, com.tencent.mm.compatible.util.Exif.a> qwl = new HashMap();
    private Map<String, bca> qwm = new HashMap();
    private int qwn = 0;
    private boolean qwo = false;
    ajq qwp;

    class b {
        final /* synthetic */ ag qwq;
        ArrayList<String> qwu = new ArrayList();
        Map<String, Boolean> qwv = new HashMap();
        Map<String, Integer> qww = new HashMap();

        b(ag agVar) {
            this.qwq = agVar;
        }

        public final b m(String str, int i, boolean z) {
            this.qwu.add(str);
            this.qww.put(str, Integer.valueOf(i));
            this.qwv.put(str, Boolean.valueOf(z));
            return this;
        }

        public final void R(ArrayList<String> arrayList) {
            this.qwv.clear();
            if (arrayList == null) {
                this.qwu = new ArrayList();
                return;
            }
            this.qwu = arrayList;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.qwv.put((String) it.next(), Boolean.valueOf(false));
            }
        }

        public final String toString() {
            Iterator it = this.qwu.iterator();
            String str = "";
            while (it.hasNext()) {
                String str2 = (String) it.next();
                int i = 0;
                if (this.qww != null) {
                    i = ((Integer) this.qww.get(str2)).intValue();
                }
                str = str + str2 + "," + i + ";";
            }
            return str;
        }

        public final b GQ(String str) {
            try {
                for (String split : str.split(";")) {
                    String[] split2 = split.split(",");
                    this.qwu.add(split2[0]);
                    this.qww.put(split2[0], Integer.valueOf(bg.getInt(split2[1], 0)));
                }
            } catch (Exception e) {
            }
            return this;
        }
    }

    class a extends h<String, Integer, Boolean> {
        private ProgressDialog isv = null;
        private aw qvg;
        final /* synthetic */ ag qwq;
        private List<com.tencent.mm.plugin.sns.data.h> qwr;

        public final /* synthetic */ Object bed() {
            long currentTimeMillis = System.currentTimeMillis();
            aw awVar = this.qvg;
            awVar.bs(this.qwr);
            this.qvg = awVar;
            w.d("MicroMsg.MMAsyncTask", "commit imp time " + (System.currentTimeMillis() - currentTimeMillis));
            return Boolean.valueOf(true);
        }

        public final /* synthetic */ void onPostExecute(Object obj) {
            super.onPostExecute((Boolean) obj);
            this.isv.dismiss();
            this.qwq.a(this.qvg);
        }

        public a(final ag agVar, aw awVar, List<com.tencent.mm.plugin.sns.data.h> list) {
            this.qwq = agVar;
            this.qvg = awVar;
            this.qwr = list;
            Context context = agVar.fCi;
            agVar.fCi.getString(j.dIO);
            this.isv = g.a(context, agVar.fCi.getString(j.dHA), false, new OnCancelListener(this) {
                final /* synthetic */ a qwt;

                public final void onCancel(DialogInterface dialogInterface) {
                }
            });
        }

        public final ae bec() {
            return com.tencent.mm.plugin.sns.model.ae.bey();
        }
    }

    public ag(MMActivity mMActivity) {
        this.fCi = mMActivity;
    }

    public final void C(Bundle bundle) {
        String str;
        int i = 1;
        this.qqR = com.tencent.mm.modelsns.b.o(this.fCi.getIntent());
        this.qsD = this.fCi.getIntent().getBooleanExtra("Kis_take_photo", false);
        this.appId = bg.ap(this.fCi.getIntent().getStringExtra("Ksnsupload_appid"), "");
        this.appName = bg.ap(this.fCi.getIntent().getStringExtra("Ksnsupload_appname"), "");
        this.qul = this.fCi.getIntent().getBooleanExtra("KThrid_app", false);
        this.qwo = this.fCi.getIntent().getBooleanExtra("KBlockAdd", false);
        this.qum = this.fCi.getIntent().getBooleanExtra("KSnsAction", false);
        this.qqL = this.fCi.getIntent().getIntExtra("Ksnsupload_source", 0);
        this.iCS = bg.ap(this.fCi.getIntent().getStringExtra("reportSessionId"), "");
        Bundle bundleExtra = this.fCi.getIntent().getBundleExtra("Ksnsupload_timeline");
        if (bundleExtra != null) {
            this.qun = new Req(bundleExtra).message;
        }
        String stringExtra = this.fCi.getIntent().getStringExtra("sns_kemdia_path");
        byte[] byteArrayExtra = this.fCi.getIntent().getByteArrayExtra("Ksnsupload_imgbuf");
        if (byteArrayExtra == null && this.qun != null && this.qun.mediaObject != null && (this.qun.mediaObject instanceof WXImageObject)) {
            byteArrayExtra = ((WXImageObject) this.qun.mediaObject).imageData;
        }
        if (!bg.mA(stringExtra) || bg.bm(byteArrayExtra)) {
            str = stringExtra;
        } else {
            stringExtra = com.tencent.mm.plugin.sns.model.ae.getAccSnsTmpPath() + com.tencent.mm.a.g.n((" " + System.currentTimeMillis()).getBytes());
            FileOp.deleteFile(stringExtra);
            FileOp.b(stringExtra, byteArrayExtra, byteArrayExtra.length);
            str = stringExtra;
        }
        int intExtra = this.fCi.getIntent().getIntExtra("KFilterId", 0);
        if (bundle == null) {
            stringExtra = null;
        } else {
            stringExtra = bundle.getString("sns_kemdia_path_list");
        }
        F(bundle);
        boolean F = F(this.fCi.getIntent().getExtras());
        this.qwn = 0;
        if (!bg.mA(stringExtra)) {
            this.qwj.GQ(stringExtra);
        } else if (bg.mA(str)) {
            ArrayList stringArrayListExtra = this.fCi.getIntent().getStringArrayListExtra("sns_kemdia_path_list");
            if (stringArrayListExtra != null && stringArrayListExtra.size() > 0) {
                Iterator it = stringArrayListExtra.iterator();
                while (it.hasNext()) {
                    str = (String) it.next();
                    w.d("MicroMsg.PicWidget", "newPath " + str);
                    this.qwj.m(str, intExtra, false);
                    if (!F) {
                        r1 = Exif.fromFile(str).getLocation();
                        if (r1 != null) {
                            this.qwl.put(str, r1);
                        }
                    }
                    try {
                        File file = new File(str);
                        bca com_tencent_mm_protocal_c_bca = new bca();
                        com_tencent_mm_protocal_c_bca.udl = this.qsD ? 1 : 2;
                        com_tencent_mm_protocal_c_bca.udn = file.lastModified() / 1000;
                        com_tencent_mm_protocal_c_bca.udm = Exif.fromFile(str).getUxtimeDatatimeOriginal();
                        this.qwm.put(str, com_tencent_mm_protocal_c_bca);
                    } catch (Exception e) {
                        w.e("MicroMsg.PicWidget", "get report info error " + e.getMessage());
                    }
                }
            }
        } else {
            int i2;
            String str2 = com.tencent.mm.plugin.sns.model.ae.getAccSnsTmpPath() + "pre_temp_sns_pic" + com.tencent.mm.a.g.n(str.getBytes());
            File file2 = new File(str2);
            if (!file2.getParentFile().exists()) {
                file2.getParentFile().mkdirs();
            }
            FileOp.p(str, str2);
            if (intExtra == -1) {
                i2 = 0;
            } else {
                i2 = intExtra;
            }
            this.qwj.m(str2, i2, this.qsD);
            if (!F) {
                r1 = Exif.fromFile(str).getLocation();
                if (r1 != null) {
                    this.qwl.put(str2, r1);
                }
            }
            try {
                file2 = new File(str);
                bca com_tencent_mm_protocal_c_bca2 = new bca();
                if (!this.qsD) {
                    i = 2;
                }
                com_tencent_mm_protocal_c_bca2.udl = i;
                com_tencent_mm_protocal_c_bca2.udn = file2.lastModified() / 1000;
                com_tencent_mm_protocal_c_bca2.udm = Exif.fromFile(str).getUxtimeDatatimeOriginal();
                this.qwm.put(str2, com_tencent_mm_protocal_c_bca2);
            } catch (Exception e2) {
                w.e("MicroMsg.PicWidget", "get report info error " + e2.getMessage());
            }
        }
    }

    private boolean F(Bundle bundle) {
        if (bundle == null) {
            return false;
        }
        ArrayList stringArrayList = bundle.getStringArrayList("sns_media_latlong_list");
        if (stringArrayList == null) {
            return false;
        }
        Iterator it = stringArrayList.iterator();
        while (it.hasNext()) {
            String[] split = ((String) it.next()).split("\n");
            if (3 != split.length) {
                w.e("MicroMsg.PicWidget", "invalid params");
                return true;
            }
            try {
                this.qwl.put(split[0].trim(), new com.tencent.mm.compatible.util.Exif.a(bg.getDouble(split[1], 0.0d), bg.getDouble(split[2], 0.0d), 0.0d));
            } catch (NumberFormatException e) {
                w.e("MicroMsg.PicWidget", e.toString());
            }
        }
        return true;
    }

    public final void D(Bundle bundle) {
        bundle.putString("sns_kemdia_path_list", this.qwj.toString());
        ArrayList arrayList = new ArrayList();
        for (Entry entry : this.qwl.entrySet()) {
            arrayList.add(String.format("%s\n%f\n%f", new Object[]{entry.getKey(), Double.valueOf(((com.tencent.mm.compatible.util.Exif.a) entry.getValue()).latitude), Double.valueOf(((com.tencent.mm.compatible.util.Exif.a) entry.getValue()).longitude)}));
        }
        bundle.putStringArrayList("sns_media_latlong_list", arrayList);
        bundle.getString("contentdesc");
    }

    public final boolean biq() {
        if (this.qwj != null) {
            b bVar = this.qwj;
            boolean z = bVar.qwu != null && bVar.qwu.size() > 0;
            if (z) {
                return true;
            }
        }
        return false;
    }

    public final View a(View view, View view2, DynamicGridView dynamicGridView, View view3) {
        boolean z;
        Context context = this.fCi;
        List list = this.qwj.qwu;
        com.tencent.mm.plugin.sns.ui.v.a anonymousClass1 = new com.tencent.mm.plugin.sns.ui.v.a(this) {
            final /* synthetic */ ag qwq;

            {
                this.qwq = r1;
            }

            public final void tL(int i) {
                w.d("MicroMsg.PicWidget", "I click");
                if (i < 0) {
                    this.qwq.bjA();
                    return;
                }
                Intent intent = new Intent();
                intent.setClass(this.qwq.fCi, SnsUploadBrowseUI.class);
                intent.putExtra("sns_gallery_position", i);
                intent.putExtra("sns_gallery_temp_paths", this.qwq.qwj.qwu);
                this.qwq.fCi.startActivityForResult(intent, 7);
            }
        };
        com.tencent.mm.plugin.sns.ui.previewimageview.c.a anonymousClass2 = new com.tencent.mm.plugin.sns.ui.previewimageview.c.a(this) {
            final /* synthetic */ ag qwq;

            {
                this.qwq = r1;
            }

            public final void da(int i, int i2) {
                b bVar = this.qwq.qwj;
                if (i != i2 && bVar.qwu.size() > i) {
                    String str = (String) bVar.qwu.remove(i);
                    if (i2 < bVar.qwu.size()) {
                        bVar.qwu.add(i2, str);
                    } else {
                        bVar.qwu.add(str);
                    }
                }
            }

            public final void removeItem(int i) {
                b bVar = this.qwq.qwj;
                if (bVar.qwu.size() > i) {
                    bVar.qwu.remove(i);
                }
                if (this.qwq.fCi instanceof En_c4f742e5) {
                    ((En_c4f742e5) this.qwq.fCi).biN();
                }
            }
        };
        if (this.qwo) {
            z = false;
        } else {
            z = true;
        }
        this.qwk = new e(view, view2, view3, context, list, dynamicGridView, anonymousClass1, anonymousClass2, z);
        return this.qwk.getView();
    }

    public final View bir() {
        this.qwk = new PreviewImageView(this.fCi);
        if (this.qwo) {
            this.qwk.biV();
        }
        this.qwk.a(new com.tencent.mm.plugin.sns.ui.v.a(this) {
            final /* synthetic */ ag qwq;

            {
                this.qwq = r1;
            }

            public final void tL(int i) {
                w.d("MicroMsg.PicWidget", "I click");
                if (i < 0) {
                    this.qwq.bjA();
                    return;
                }
                Intent intent = new Intent();
                intent.setClass(this.qwq.fCi, SnsUploadBrowseUI.class);
                intent.putExtra("sns_gallery_position", i);
                intent.putExtra("sns_gallery_temp_paths", this.qwq.qwj.qwu);
                this.qwq.fCi.startActivityForResult(intent, 7);
            }
        });
        this.qwk.bz(this.qwj.qwu);
        return this.qwk.getView();
    }

    private static aw a(aw awVar, List<com.tencent.mm.plugin.sns.data.h> list) {
        awVar.bs(list);
        return awVar;
    }

    public final void a(aw awVar) {
        int commit = awVar.commit();
        if (this.qqR != null) {
            this.qqR.gB(commit);
            com.tencent.mm.plugin.sns.h.e.qdB.b(this.qqR);
        }
        if (!(this.qwj == null || this.qwj.qwu == null || !r.bhX())) {
            com.tencent.mm.plugin.report.service.g.oUh.i(12834, new Object[]{Integer.valueOf(this.qwj.qwu.size())});
        }
        Intent intent = new Intent();
        intent.putExtra("sns_local_id", commit);
        this.fCi.setResult(-1, intent);
        this.fCi.finish();
    }

    public final boolean a(int i, int i2, i iVar, String str, List<String> list, ajq com_tencent_mm_protocal_c_ajq, int i3, boolean z, List<String> list2, PInt pInt, String str2, int i4, int i5) {
        List<com.tencent.mm.plugin.sns.data.h> linkedList = new LinkedList();
        Iterator it = this.qwj.qwu.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            String str3 = (String) it.next();
            com.tencent.mm.plugin.sns.data.h hVar = new com.tencent.mm.plugin.sns.data.h(str3, 2);
            hVar.type = 2;
            hVar.pQZ = i;
            if (i6 == 0) {
                hVar.pQY = i2;
                if (iVar != null) {
                    hVar.pRb = iVar.token;
                    hVar.pRc = iVar.tPO;
                }
            } else {
                hVar.pQY = 0;
            }
            int i7 = i6 + 1;
            b bVar = this.qwj;
            hVar.pQX = bVar.qww.containsKey(str3) ? ((Integer) bVar.qww.get(str3)).intValue() : 0;
            hVar.desc = str;
            bVar = this.qwj;
            boolean booleanValue = (bg.mA(str3) || !bVar.qwv.containsKey(str3)) ? false : ((Boolean) bVar.qwv.get(str3)).booleanValue();
            hVar.pRe = booleanValue;
            linkedList.add(hVar);
            i6 = i7;
        }
        LinkedList linkedList2 = new LinkedList();
        if (list != null) {
            LinkedList linkedList3 = new LinkedList();
            List yA = o.yA();
            for (String str32 : list) {
                if (!yA.contains(str32)) {
                    bcs com_tencent_mm_protocal_c_bcs = new bcs();
                    com_tencent_mm_protocal_c_bcs.jNj = str32;
                    linkedList2.add(com_tencent_mm_protocal_c_bcs);
                }
            }
        }
        aw awVar = new aw(1);
        pInt.value = awVar.jFe;
        if (iVar != null) {
            awVar.dx(iVar.token, iVar.tPO);
        }
        if (i3 > com.tencent.mm.plugin.sns.c.a.pQH) {
            awVar.tj(3);
        }
        awVar.Fy(str).a(com_tencent_mm_protocal_c_ajq).aj(linkedList2).tl(i).tm(i2);
        if (z) {
            awVar.to(1);
        } else {
            awVar.to(0);
        }
        if (!bg.mA(this.appId)) {
            awVar.FE(this.appId);
        }
        if (!bg.mA(this.appName)) {
            awVar.FF(bg.ap(this.appName, ""));
        }
        awVar.tn(this.qqL);
        if (this.qul) {
            awVar.tn(5);
        }
        if (this.qum && this.qun != null) {
            awVar.Fz(this.qun.mediaTagName);
            awVar.Q(this.appId, this.qun.messageExt, this.qun.messageAction);
        }
        awVar.e(null, null, null, i4, i5);
        awVar.br(list2);
        awVar.nV(this.iCS);
        if (!(com_tencent_mm_protocal_c_ajq == null || com_tencent_mm_protocal_c_ajq.score == 0)) {
            i6 = com_tencent_mm_protocal_c_ajq.score;
            String str4 = com_tencent_mm_protocal_c_ajq.tNr;
            awVar.pYq.tPX = new baw();
            awVar.pYq.tPX.ubW = i6;
            awVar.pYq.tPX.ubT = str4;
        }
        w.i("MicroMsg.PicWidget", "commit pic size %d, browseImageCount:%d", new Object[]{Integer.valueOf(linkedList.size()), Integer.valueOf(this.qwn)});
        com.tencent.mm.plugin.report.service.g.oUh.i(11602, new Object[]{Integer.valueOf(this.qwn), Integer.valueOf(linkedList.size())});
        for (com.tencent.mm.plugin.sns.data.h hVar2 : linkedList) {
            w.i("MicroMsg.PicWidget", "commit path  %s len: %d", new Object[]{hVar2.path, Long.valueOf(FileOp.ki(hVar2.path))});
        }
        for (com.tencent.mm.plugin.sns.data.h hVar22 : linkedList) {
            bca com_tencent_mm_protocal_c_bca;
            String str5 = hVar22.path;
            bca com_tencent_mm_protocal_c_bca2 = (bca) this.qwm.get(str5);
            if (com_tencent_mm_protocal_c_bca2 == null) {
                com_tencent_mm_protocal_c_bca = new bca();
            } else {
                com_tencent_mm_protocal_c_bca = com_tencent_mm_protocal_c_bca2;
            }
            if (this.qwp == null || (this.qwp.tna == 0.0f && this.qwp.tmZ == 0.0f)) {
                com_tencent_mm_protocal_c_bca.udj = -1000.0f;
                com_tencent_mm_protocal_c_bca.udk = -1000.0f;
            } else {
                com_tencent_mm_protocal_c_bca.udj = this.qwp.tna;
                com_tencent_mm_protocal_c_bca.udk = this.qwp.tmZ;
                com_tencent_mm_protocal_c_bca.quO = this.qwp.quO;
                com_tencent_mm_protocal_c_bca.aLh = this.qwp.aLh;
            }
            com.tencent.mm.compatible.util.Exif.a aVar = (com.tencent.mm.compatible.util.Exif.a) this.qwl.get(str5);
            if (aVar == null || (aVar.latitude == 0.0d && aVar.longitude == 0.0d)) {
                com_tencent_mm_protocal_c_bca.udh = -1000.0f;
                com_tencent_mm_protocal_c_bca.udi = -1000.0f;
            } else {
                com_tencent_mm_protocal_c_bca.udh = (float) aVar.latitude;
                com_tencent_mm_protocal_c_bca.udi = (float) aVar.longitude;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("||index: " + awVar.pYq.tPS.size());
            stringBuffer.append("||item poi lat " + com_tencent_mm_protocal_c_bca.udj + " " + com_tencent_mm_protocal_c_bca.udk);
            stringBuffer.append("||item pic lat " + com_tencent_mm_protocal_c_bca.udh + " " + com_tencent_mm_protocal_c_bca.udi);
            stringBuffer.append("||item exitime:" + com_tencent_mm_protocal_c_bca.udm + " filetime: " + com_tencent_mm_protocal_c_bca.udn);
            stringBuffer.append("||item source: " + com_tencent_mm_protocal_c_bca.udl);
            w.i("MicroMsg.UploadPackHelper", "addSnsReportInfo item : " + stringBuffer.toString());
            awVar.pYq.tPS.add(com_tencent_mm_protocal_c_bca);
        }
        if (linkedList.size() <= 1) {
            a(awVar, (List) linkedList);
            a(awVar);
        } else {
            new a(this, awVar, linkedList).l("");
        }
        return true;
    }

    protected final boolean bjA() {
        com.tencent.mm.kernel.h.vJ();
        if (!com.tencent.mm.kernel.h.vI().isSDCardAvailable()) {
            s.eP(this.fCi);
            return false;
        } else if (this.qwj.qwu.size() >= 9) {
            g.h(this.fCi, j.pMU, j.dIO);
            return false;
        } else {
            try {
                az azVar = new az(this.fCi);
                azVar.qJf = new c(this) {
                    final /* synthetic */ ag qwq;

                    {
                        this.qwq = r1;
                    }

                    public final void a(l lVar) {
                        if (!com.tencent.mm.platformtools.r.ijS) {
                            lVar.e(0, this.qwq.fCi.getString(j.dHa));
                        }
                        lVar.e(1, this.qwq.fCi.getString(j.dHe));
                    }
                };
                azVar.qJg = new d(this) {
                    final /* synthetic */ ag qwq;

                    {
                        this.qwq = r1;
                    }

                    public final void c(MenuItem menuItem, int i) {
                        switch (menuItem.getItemId()) {
                            case 0:
                                if (9 - this.qwq.qwj.qwu.size() <= 0) {
                                    w.e("MicroMsg.PicWidget", "has select the max image count");
                                    return;
                                }
                                com.tencent.mm.plugin.report.service.g.oUh.i(13822, new Object[]{Integer.valueOf(1), Integer.valueOf(2)});
                                k.a(this.qwq.fCi, 11, new Intent(), 2, 2);
                                return;
                            case 1:
                                int size = 9 - this.qwq.qwj.qwu.size();
                                if (size <= 0) {
                                    w.e("MicroMsg.PicWidget", "has select the max image count");
                                    return;
                                }
                                String string = this.qwq.fCi.getSharedPreferences(ab.bIX(), 0).getString("gallery", "1");
                                com.tencent.mm.plugin.report.service.g.oUh.i(13822, new Object[]{Integer.valueOf(2), Integer.valueOf(2)});
                                if (string.equalsIgnoreCase("0")) {
                                    k.V(this.qwq.fCi);
                                    return;
                                } else {
                                    k.a(this.qwq.fCi, 9, size, 4, 1, false, null);
                                    return;
                                }
                            default:
                                return;
                        }
                    }
                };
                azVar.blb();
            } catch (Exception e) {
            }
            return true;
        }
    }

    public final boolean d(List<String> list, int i, boolean z) {
        if (list == null || list.size() == 0) {
            w.i("MicroMsg.PicWidget", "no image selected");
        } else if (this.qwj.qwu.size() < 9) {
            for (String str : list) {
                if (FileOp.aO(str)) {
                    String str2 = "pre_temp_sns_pic" + com.tencent.mm.a.g.n((str + System.currentTimeMillis()).getBytes());
                    r.T(com.tencent.mm.plugin.sns.model.ae.getAccSnsTmpPath(), str, str2);
                    w.d("MicroMsg.PicWidget", "newPath " + com.tencent.mm.plugin.sns.model.ae.getAccSnsTmpPath() + str2);
                    this.qwj.m(com.tencent.mm.plugin.sns.model.ae.getAccSnsTmpPath() + str2, i, z);
                    this.qwk.bz(this.qwj.qwu);
                    try {
                        File file = new File(str);
                        bca com_tencent_mm_protocal_c_bca = new bca();
                        com_tencent_mm_protocal_c_bca.udl = z ? 1 : 2;
                        com_tencent_mm_protocal_c_bca.udn = file.lastModified() / 1000;
                        com_tencent_mm_protocal_c_bca.udm = Exif.fromFile(str).getUxtimeDatatimeOriginal();
                        this.qwm.put(com.tencent.mm.plugin.sns.model.ae.getAccSnsTmpPath() + str2, com_tencent_mm_protocal_c_bca);
                    } catch (Exception e) {
                        w.e("MicroMsg.PicWidget", "get report info error " + e.getMessage());
                    }
                    com.tencent.mm.compatible.util.Exif.a location = Exif.fromFile(str).getLocation();
                    if (location != null) {
                        this.qwl.put(com.tencent.mm.plugin.sns.model.ae.getAccSnsTmpPath() + str2, location);
                    }
                }
            }
        }
        return true;
    }

    public final boolean a(int i, Intent intent) {
        String b;
        String n;
        switch (i) {
            case 2:
                w.d("MicroMsg.PicWidget", "onActivityResult 1");
                if (intent == null) {
                    return false;
                }
                w.d("MicroMsg.PicWidget", "onActivityResult CONTEXT_CHOSE_IMAGE");
                Intent intent2 = new Intent();
                intent2.putExtra("CropImageMode", 4);
                intent2.putExtra("CropImage_DirectlyIntoFilter", true);
                intent2.putExtra("CropImage_Filter", true);
                com.tencent.mm.plugin.sns.c.a.imv.a(this.fCi, intent, intent2, com.tencent.mm.plugin.sns.model.ae.getAccSnsTmpPath(), 4, new com.tencent.mm.ui.tools.a.a(this) {
                    final /* synthetic */ ag qwq;

                    {
                        this.qwq = r1;
                    }

                    public final String GP(String str) {
                        return com.tencent.mm.plugin.sns.model.ae.getAccSnsTmpPath() + com.tencent.mm.a.g.n((str + System.currentTimeMillis()).getBytes());
                    }
                });
                return true;
            case 3:
                w.d("MicroMsg.PicWidget", "onActivityResult 2");
                b = k.b(this.fCi.getApplicationContext(), intent, com.tencent.mm.plugin.sns.model.ae.getAccSnsTmpPath());
                if (b == null) {
                    return true;
                }
                Intent intent3 = new Intent();
                intent3.putExtra("CropImageMode", 4);
                intent3.putExtra("CropImage_Filter", true);
                intent3.putExtra("CropImage_DirectlyIntoFilter", true);
                intent3.putExtra("CropImage_ImgPath", b);
                n = com.tencent.mm.a.g.n((b + System.currentTimeMillis()).getBytes());
                intent3.putExtra("CropImage_OutputPath", com.tencent.mm.plugin.sns.model.ae.getAccSnsTmpPath() + n);
                com.tencent.mm.compatible.util.Exif.a location = Exif.fromFile(b).getLocation();
                if (location != null) {
                    this.qwl.put(com.tencent.mm.plugin.sns.model.ae.getAccSnsTmpPath() + n, location);
                    w.d("MicroMsg.PicWidget", "take picture lat:%f, long:%f", new Object[]{Double.valueOf(location.latitude), Double.valueOf(location.longitude)});
                }
                bca com_tencent_mm_protocal_c_bca = new bca();
                com_tencent_mm_protocal_c_bca.udl = 1;
                com_tencent_mm_protocal_c_bca.udn = System.currentTimeMillis();
                com_tencent_mm_protocal_c_bca.udm = bg.PZ(Exif.fromFile(b).dateTime);
                this.qwm.put(com.tencent.mm.plugin.sns.model.ae.getAccSnsTmpPath() + n, com_tencent_mm_protocal_c_bca);
                com.tencent.mm.plugin.sns.c.a.imv.a(this.fCi, intent3, 4);
                this.qsD = true;
                return true;
            case 4:
                w.d("MicroMsg.PicWidget", "onActivityResult 3");
                if (intent == null) {
                    return true;
                }
                b = intent.getStringExtra("CropImage_OutputPath");
                w.d("MicroMsg.PicWidget", "REQUEST_CODE_IMAGE_SEND_COMFIRM filePath " + b);
                if (b == null) {
                    return true;
                }
                if (!FileOp.aO(b)) {
                    return true;
                }
                if (this.qwj.qwu.size() >= 9) {
                    return true;
                }
                int intExtra = intent.getIntExtra("CropImage_filterId", 0);
                n = "pre_temp_sns_pic" + com.tencent.mm.a.g.n((b + System.currentTimeMillis()).getBytes());
                w.i("MicroMsg.PicWidget", "onactivity result " + FileOp.ki(b) + " " + b);
                FileOp.p(b, com.tencent.mm.plugin.sns.model.ae.getAccSnsTmpPath() + n);
                if (this.qwl.containsKey(b)) {
                    this.qwl.put(com.tencent.mm.plugin.sns.model.ae.getAccSnsTmpPath() + n, this.qwl.get(b));
                }
                b = com.tencent.mm.plugin.sns.model.ae.getAccSnsTmpPath() + n;
                w.d("MicroMsg.PicWidget", "newPath " + b);
                this.qwj.m(b, intExtra, false);
                this.qwk.bz(this.qwj.qwu);
                return true;
            case 7:
                if (intent == null) {
                    return true;
                }
                this.qwj.R(intent.getStringArrayListExtra("sns_gallery_temp_paths"));
                this.qwk.bz(this.qwj.qwu);
                this.qwn = intent.getIntExtra("sns_update_preview_image_count", 0);
                return true;
            case 9:
                return d(intent.getStringArrayListExtra("CropImage_OutputPath_List"), intent.getIntExtra("CropImage_filterId", 0), intent.getBooleanExtra("isTakePhoto", false));
            case 11:
                SightCaptureResult sightCaptureResult = (SightCaptureResult) intent.getParcelableExtra("key_req_result");
                if (sightCaptureResult != null) {
                    b = sightCaptureResult.nAC;
                    if (!bg.mA(b)) {
                        return d(Collections.singletonList(b), 0, true);
                    }
                }
                break;
        }
        return false;
    }

    public final boolean bis() {
        if (this.qwk != null) {
            this.qwk.clean();
        }
        return false;
    }
}
