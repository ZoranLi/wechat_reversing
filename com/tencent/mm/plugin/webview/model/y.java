package com.tencent.mm.plugin.webview.model;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.protocal.c.aod;
import com.tencent.mm.protocal.c.awh;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public final class y {
    public static String[] rWM;
    public static boolean rWN = false;

    public interface a {
        boolean bwl();

        void remove(int i);

        void vP(int i);
    }

    public static final class b {

        static class AnonymousClass2 implements OnClickListener {
            final /* synthetic */ c rWQ;

            public AnonymousClass2(c cVar) {
                this.rWQ = cVar;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                this.rWQ.goBack();
            }
        }

        static class AnonymousClass4 implements OnClickListener {
            final /* synthetic */ c rWQ;

            public AnonymousClass4(c cVar) {
                this.rWQ = cVar;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                this.rWQ.goBack();
            }
        }

        static class AnonymousClass3 implements com.tencent.mm.plugin.webview.ui.tools.widget.e.a {
            final /* synthetic */ a rWP;
            final /* synthetic */ c rWQ;
            final /* synthetic */ Bundle rWR;
            final /* synthetic */ d rWs;

            public AnonymousClass3(Bundle bundle, c cVar, d dVar, a aVar) {
                this.rWR = bundle;
                this.rWQ = cVar;
                this.rWs = dVar;
                this.rWP = aVar;
            }

            public final void c(int i, Bundle bundle) {
                w.i("MicroMsg.OauthAuthorizeLogic", "WebAuthorizeDialog#onRevMsg resultCode %d", new Object[]{Integer.valueOf(i)});
                Bundle bundle2;
                d dVar;
                a aVar;
                switch (i) {
                    case 1:
                        bundle2 = this.rWR;
                        c cVar = this.rWQ;
                        dVar = this.rWs;
                        aVar = this.rWP;
                        w.i("MicroMsg.OauthAuthorizeLogic", "doAcceptLogic");
                        if (bundle2.getBoolean("is_call_server_when_confirm")) {
                            b.a(dVar, bundle2.getString("oauth_url"), 1, (ArrayList) bundle.getSerializable("key_scope"), aVar, true);
                            return;
                        }
                        cVar.IM(bundle2.getString("redirect_url"));
                        w.i("MicroMsg.OauthAuthorizeLogic", "doAcceptLogic redirectUrl: %s", new Object[]{r0});
                        return;
                    case 2:
                    case 3:
                        bundle2 = this.rWR;
                        c cVar2 = this.rWQ;
                        dVar = this.rWs;
                        aVar = this.rWP;
                        w.i("MicroMsg.OauthAuthorizeLogic", "doRejectLogic");
                        b.a(dVar, bundle2.getString("oauth_url"), 2, bundle == null ? new ArrayList() : (ArrayList) bundle.getSerializable("key_scope"), aVar, false);
                        cVar2.goBack();
                        return;
                    default:
                        this.rWQ.goBack();
                        return;
                }
            }
        }

        public static boolean a(String str, String str2, int i, d dVar, final c cVar, final a aVar) {
            if (dVar == null) {
                w.e("MicroMsg.OauthAuthorizeLogic", "doOauthAuthorize invoker null");
                return false;
            }
            w.i("MicroMsg.OauthAuthorizeLogic", "doOauthAuthorize scene: %d", new Object[]{Integer.valueOf(i)});
            cVar.c(new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    w.i("MicroMsg.OauthAuthorizeLogic", "doOauthAuthorize user cancel");
                    cVar.amV();
                    aVar.remove(1254);
                }
            });
            Bundle bundle = new Bundle();
            bundle.putString("oauth_url", str);
            bundle.putString("biz_username", str2);
            bundle.putInt("scene", i);
            try {
                aVar.vP(1254);
                dVar.q(1254, bundle);
                return true;
            } catch (RemoteException e) {
                w.w("MicroMsg.OauthAuthorizeLogic", "invoker.doScene exp : %s", new Object[]{e.getLocalizedMessage()});
                return false;
            }
        }

        static void a(d dVar, String str, int i, ArrayList<String> arrayList, a aVar, boolean z) {
            if (dVar == null) {
                w.e("MicroMsg.OauthAuthorizeLogic", "doOauthAuthorizeConfirm invoker null");
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("oauth_url", str);
            bundle.putInt("opt", i);
            bundle.putStringArrayList("scopes", arrayList);
            if (z) {
                try {
                    aVar.vP(1373);
                } catch (RemoteException e) {
                    w.w("MicroMsg.OauthAuthorizeLogic", "doOauthAuthorizeConfirm doScene exp : %s", new Object[]{e.getLocalizedMessage()});
                    return;
                }
            }
            dVar.q(1373, bundle);
        }

        public static boolean a(String str, d dVar) {
            if (y.rWM == null && !y.rWN) {
                try {
                    Bundle d = dVar.d(94, new Bundle());
                    String str2 = null;
                    if (d != null) {
                        str2 = d.getString("oauth_host_paths");
                    }
                    if (bg.mA(str2)) {
                        str2 = "open.weixin.qq.com/connect/oauth2/authorize";
                    }
                    y.rWM = str2.split(";");
                    y.rWN = true;
                } catch (RemoteException e) {
                    w.w("MicroMsg.OauthAuthorizeLogic", "isOauthHost exp:%s", new Object[]{e.getLocalizedMessage()});
                    return false;
                }
            }
            if (y.rWM == null || y.rWM.length == 0) {
                w.i("MicroMsg.OauthAuthorizeLogic", "isOauthHost sOauthHostPaths nil");
                return false;
            }
            Uri parse = Uri.parse(str);
            String str3 = parse.getAuthority() + parse.getPath();
            if (bg.mA(str3)) {
                w.i("MicroMsg.OauthAuthorizeLogic", "isOauthHost target nil");
                return false;
            }
            w.d("MicroMsg.OauthAuthorizeLogic", "isOauthHost target:%s", new Object[]{str3});
            for (String equalsIgnoreCase : y.rWM) {
                if (str3.equalsIgnoreCase(equalsIgnoreCase)) {
                    return true;
                }
            }
            return false;
        }

        public static boolean a(d dVar) {
            boolean z = false;
            try {
                Bundle d = dVar.d(93, new Bundle());
                if (d == null) {
                    w.w("MicroMsg.OauthAuthorizeLogic", "shouldNativeOauthIntercept Bundle isOauthNative null");
                } else {
                    z = d.getBoolean("is_oauth_native");
                }
            } catch (RemoteException e) {
                w.w("MicroMsg.OauthAuthorizeLogic", "shouldNativeOauthIntercept exp:%s", new Object[]{e.getLocalizedMessage()});
            }
            return z;
        }
    }

    public interface c {
        void IM(String str);

        void amV();

        void c(OnCancelListener onCancelListener);

        void goBack();
    }

    public static ArrayList<byte[]> ap(LinkedList<aod> linkedList) {
        ArrayList<byte[]> arrayList = new ArrayList();
        if (linkedList == null || linkedList.isEmpty()) {
            return arrayList;
        }
        int i = 0;
        while (i < linkedList.size()) {
            try {
                arrayList.add(((aod) linkedList.get(i)).toByteArray());
                i++;
            } catch (IOException e) {
                w.w("MicroMsg.OauthAuthorizeLogic", "oauthScopeInfoListToBytesList index:%d, exp:%s ", new Object[]{Integer.valueOf(i), e.getLocalizedMessage()});
                arrayList.clear();
                return arrayList;
            }
        }
        return arrayList;
    }

    public static LinkedList<awh> W(ArrayList<byte[]> arrayList) {
        LinkedList<awh> linkedList = new LinkedList();
        if (arrayList == null || arrayList.isEmpty()) {
            return linkedList;
        }
        int i = 0;
        while (i < arrayList.size()) {
            try {
                aod com_tencent_mm_protocal_c_aod = new aod();
                com_tencent_mm_protocal_c_aod.aD((byte[]) arrayList.get(i));
                awh com_tencent_mm_protocal_c_awh = new awh();
                com_tencent_mm_protocal_c_awh.tZA = com_tencent_mm_protocal_c_aod.tTm;
                com_tencent_mm_protocal_c_awh.msk = com_tencent_mm_protocal_c_aod.desc;
                com_tencent_mm_protocal_c_awh.tlA = com_tencent_mm_protocal_c_aod.scope;
                com_tencent_mm_protocal_c_awh.iNB = com_tencent_mm_protocal_c_aod.iNB;
                linkedList.add(com_tencent_mm_protocal_c_awh);
                i++;
            } catch (IOException e) {
                w.w("MicroMsg.OauthAuthorizeLogic", "bytesListToBytesListScopeInfoList: i:%d, exp:%s", new Object[]{Integer.valueOf(i), e.getLocalizedMessage()});
                linkedList.clear();
                return linkedList;
            }
        }
        return linkedList;
    }
}
