package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.ah.d;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.n;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.x;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class SendImgProxyUI extends MMBaseActivity {
    private static boolean aJi = false;
    private p jiM = null;

    static /* synthetic */ void a(SendImgProxyUI sendImgProxyUI, Intent intent) {
        if (intent == null) {
            w.e("MicroMsg.SendImgProxyUI", "data is empty!");
            return;
        }
        boolean booleanExtra = intent.getBooleanExtra("CropImage_Compress_Img", true);
        intent.getStringExtra("GalleryUI_ToUser");
        ArrayList arrayList = new ArrayList();
        ArrayList a = a(intent.getStringArrayListExtra("CropImage_OutputPath_List"), intent.getIntExtra("CropImage_limit_Img_Size", 26214400), arrayList, booleanExtra);
        intent.putStringArrayListExtra("CropImage_OutputPath_List", a);
        if (a.size() == 0 && arrayList.size() == 0) {
            Toast.makeText(sendImgProxyUI, sendImgProxyUI.getString(R.l.enz), 0).show();
            w.e("MicroMsg.SendImgProxyUI", "filelist is empty!");
            return;
        }
        int intExtra = intent.getIntExtra("from_source", 0);
        int intExtra2 = intent.getIntExtra("CropImage_rotateCount", 0);
        String stringExtra = intent.getStringExtra("GalleryUI_ToUser");
        w.d("MicroMsg.SendImgProxyUI", "toUserName : " + stringExtra);
        w.d("MicroMsg.SendImgProxyUI", "dkimgsource" + intent.getIntExtra("from_source", 0));
        if (arrayList.size() > 0) {
            m.GJ().a(arrayList, true, intExtra, intExtra2, stringExtra, R.g.bdJ);
            e(m.GJ().jx(stringExtra), arrayList);
            w.e("MicroMsg.SendImgProxyUI", "overSizeList size:%s!", new Object[]{Integer.valueOf(arrayList.size())});
        }
        m.GJ().a(a, booleanExtra, intExtra, intExtra2, stringExtra, R.g.bdJ);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        overridePendingTransition(0, 0);
        x.a(getWindow());
        w.i("MicroMsg.SendImgProxyUI", "onCreate isRunning:%b ,%d", new Object[]{Boolean.valueOf(aJi), Integer.valueOf(hashCode())});
        if (aJi) {
            w.w("MicroMsg.SendImgProxyUI", "duplicate instance");
            finish();
            return;
        }
        aJi = true;
        setContentView(R.i.cVc);
        if (!ap.zb()) {
            w.i("MicroMsg.SendImgProxyUI", "AccHasNotReady");
            h.vG().initialize();
        }
        this.jiM = g.a(this, getString(R.l.ezo), false, null);
        ap.vL().D(new Runnable(this) {
            final /* synthetic */ SendImgProxyUI vOo;

            {
                this.vOo = r1;
            }

            public final void run() {
                w.i("MicroMsg.SendImgProxyUI", "test before sendMutiImage");
                SendImgProxyUI.a(this.vOo, this.vOo.getIntent());
                ArrayList arrayList = new ArrayList();
                arrayList.add(Integer.valueOf(-1));
                ap.vL().bJk();
                w.i("MicroMsg.SendImgProxyUI", "test before finish");
                this.vOo.jiM.dismiss();
                this.vOo.setResult(-1, this.vOo.getIntent().putIntegerArrayListExtra("GalleryUI_ImgIdList", arrayList));
                SendImgProxyUI.aJi = false;
                this.vOo.finish();
            }
        });
    }

    protected void onDestroy() {
        w.i("MicroMsg.SendImgProxyUI", "onDestroy isRunning:%b , %d", new Object[]{Boolean.valueOf(aJi), Integer.valueOf(hashCode())});
        super.onDestroy();
    }

    public void onResume() {
        w.i("MicroMsg.SendImgProxyUI", "onResume isRunning:%b ,%d", new Object[]{Boolean.valueOf(aJi), Integer.valueOf(hashCode())});
        super.onResume();
    }

    private static ArrayList<String> a(ArrayList<String> arrayList, int i, ArrayList<String> arrayList2, boolean z) {
        InputStream inputStream;
        ArrayList<String> arrayList3 = new ArrayList();
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (str.toLowerCase().endsWith(".png")) {
                    InputStream inputStream2 = null;
                    try {
                        inputStream2 = FileOp.openRead(str);
                        try {
                            if (MMBitmapFactory.checkIsImageLegal(inputStream2)) {
                                int aN = e.aN(str);
                                if (z || aN <= i) {
                                    arrayList3.add(str);
                                } else {
                                    arrayList2.add(str);
                                }
                            }
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (Exception e) {
                                }
                            }
                        } catch (Exception e2) {
                            inputStream = inputStream2;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e3) {
                                }
                            }
                        } catch (Throwable th) {
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (Exception e4) {
                                }
                            }
                        }
                    } catch (Exception e5) {
                        inputStream = inputStream2;
                        if (inputStream != null) {
                            inputStream.close();
                        }
                    } catch (Throwable th2) {
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                            } catch (Exception e42) {
                            }
                        }
                    }
                } else {
                    int aN2 = e.aN(str);
                    if (z || aN2 <= i) {
                        arrayList3.add(str);
                    } else {
                        arrayList2.add(str);
                    }
                }
            }
        }
        return arrayList3;
    }

    private static void e(ArrayList<Integer> arrayList, ArrayList<String> arrayList2) {
        if (arrayList.size() != arrayList2.size()) {
            w.e("MicroMsg.SendImgProxyUI", "[insertErrMsg] WTF");
            return;
        }
        for (int i = 0; i < arrayList2.size(); i++) {
            int intValue = ((Integer) arrayList.get(i)).intValue();
            d fT = n.GS().fT(intValue);
            int aN = e.aN((String) arrayList2.get(i));
            fT.setOffset(aN);
            fT.fO(aN);
            n.GS().a(intValue, fT);
            long j = fT.hFg;
            w.i("MicroMsg.SendImgProxyUI", "[insertErrMsg] msgLocalId:%s oriImgLocalId:%s", new Object[]{Long.valueOf(j), Integer.valueOf(intValue)});
            ce cA = ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJX().cA(j);
            cA.dv(5);
            cA.dG(80);
            ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJX().a(j, cA);
            w.i("MicroMsg.SendImgProxyUI", "after update msgInfo, localId[%d] svrId[%d] talker[%s] type[%d] isSend[%d] imgPath[%s], status[%d] createTime[%d]", new Object[]{Long.valueOf(cA.field_msgId), Long.valueOf(cA.field_msgSvrId), cA.field_talker, Integer.valueOf(cA.field_type), Integer.valueOf(cA.field_isSend), cA.field_imgPath, Integer.valueOf(cA.field_status), Long.valueOf(cA.field_createTime)});
        }
    }
}
