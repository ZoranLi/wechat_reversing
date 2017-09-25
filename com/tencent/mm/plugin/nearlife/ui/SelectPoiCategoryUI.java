package com.tencent.mm.plugin.nearlife.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.ap.k;
import com.tencent.mm.e.a.kz;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.storage.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SelectPoiCategoryUI extends MMActivity {
    static final String nYO = (w.hgq + "poi_categories");
    private ListView Fg;
    private OnMenuItemClickListener nYJ = new OnMenuItemClickListener(this) {
        final /* synthetic */ SelectPoiCategoryUI nYT;

        {
            this.nYT = r1;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            this.nYT.setResult(0, null);
            this.nYT.finish();
            return true;
        }
    };
    private a nYP;
    private ArrayAdapter<String> nYQ;
    private List<String> nYR;
    private OnItemClickListener nYS = new OnItemClickListener(this) {
        final /* synthetic */ SelectPoiCategoryUI nYT;

        {
            this.nYT = r1;
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            com.tencent.mm.sdk.platformtools.w.d("MicroMsg.SelectPoiCategoryUI", "item click on pos:%d, len:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(this.nYT.nYR.size())});
            Intent intent = new Intent();
            intent.putExtra("poi_category", (String) this.nYT.nYR.get(i));
            this.nYT.setResult(-1, intent);
            this.nYT.finish();
        }
    };

    private class a extends c<kz> {
        final /* synthetic */ SelectPoiCategoryUI nYT;
        SelectPoiCategoryUI nYU;

        public a(SelectPoiCategoryUI selectPoiCategoryUI) {
            this.nYT = selectPoiCategoryUI;
            super(0);
            this.usg = kz.class.getName().hashCode();
        }

        private boolean a(kz kzVar) {
            if (kzVar instanceof kz) {
                SelectPoiCategoryUI selectPoiCategoryUI = this.nYU;
                byte[] bArr = kzVar.fRG.content;
                File file = new File(SelectPoiCategoryUI.nYO);
                if (!file.exists()) {
                    file.mkdir();
                }
                try {
                    String str = SelectPoiCategoryUI.nYO + "/lastest_poi_categories.dat";
                    File file2 = new File(str);
                    if (!file2.exists()) {
                        file2.createNewFile();
                    }
                    e.b(str, bArr, bArr.length);
                } catch (Exception e) {
                    com.tencent.mm.sdk.platformtools.w.e("MicroMsg.SelectPoiCategoryUI", "write file failed: " + e.getMessage());
                }
                selectPoiCategoryUI.aA(bArr);
                selectPoiCategoryUI.aOV();
            }
            return false;
        }
    }

    protected final int getLayoutId() {
        return R.i.dnD;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nYR = new ArrayList();
        KC();
        this.nYP = new a(this);
        com.tencent.mm.sdk.b.a.urY.b(this.nYP);
        this.nYP.nYU = this;
        ap.vd().a(new k(17), 0);
    }

    protected final void KC() {
        zi(R.l.eDI);
        b(this.nYJ);
        this.nYQ = new ArrayAdapter(this, R.i.dkG);
        this.Fg = (ListView) findViewById(R.h.byP);
        this.Fg.setAdapter(this.nYQ);
        this.Fg.setOnItemClickListener(this.nYS);
        if (!BK(nYO + "/lastest_poi_categories.dat")) {
            try {
                k(getAssets().open("default_poi_categories.dat"));
            } catch (IOException e) {
                com.tencent.mm.sdk.platformtools.w.d("MicroMsg.SelectPoiCategoryUI", "open file from assets failed: " + e.getMessage());
            }
        }
        aOV();
    }

    private boolean k(InputStream inputStream) {
        BufferedReader bufferedReader;
        IOException e;
        Throwable th;
        if (inputStream == null) {
            return false;
        }
        this.nYR.clear();
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        this.nYR.add(readLine);
                    } else {
                        try {
                            break;
                        } catch (Exception e2) {
                            com.tencent.mm.sdk.platformtools.w.d("MicroMsg.SelectPoiCategoryUI", "close file failed: " + e2.getMessage());
                        }
                    }
                } catch (IOException e3) {
                    e = e3;
                }
            }
            bufferedReader.close();
            inputStream.close();
        } catch (IOException e4) {
            e = e4;
            bufferedReader = null;
            try {
                com.tencent.mm.sdk.platformtools.w.d("MicroMsg.SelectPoiCategoryUI", "read file failed: " + e.getMessage());
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception e22) {
                        com.tencent.mm.sdk.platformtools.w.d("MicroMsg.SelectPoiCategoryUI", "close file failed: " + e22.getMessage());
                    }
                }
                inputStream.close();
                return true;
            } catch (Throwable th2) {
                th = th2;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception e5) {
                        com.tencent.mm.sdk.platformtools.w.d("MicroMsg.SelectPoiCategoryUI", "close file failed: " + e5.getMessage());
                        throw th;
                    }
                }
                inputStream.close();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            inputStream.close();
            throw th;
        }
        return true;
    }

    private boolean BK(String str) {
        boolean z = false;
        if (!bg.mA(str)) {
            File file = new File(str);
            if (file.exists()) {
                try {
                    z = k(new FileInputStream(file));
                } catch (FileNotFoundException e) {
                    com.tencent.mm.sdk.platformtools.w.d("MicroMsg.SelectPoiCategoryUI", "update poi categories failed, path:%s, msg:%s", new Object[]{str, e.getMessage()});
                }
            }
        }
        return z;
    }

    protected void onDestroy() {
        super.onDestroy();
        com.tencent.mm.sdk.b.a.urY.c(this.nYP);
    }

    final void aA(byte[] bArr) {
        String[] split = new String(bArr).split("\n");
        this.nYR.clear();
        for (String trim : split) {
            this.nYR.add(trim.trim());
        }
    }

    final void aOV() {
        this.nYQ.clear();
        for (int i = 0; i < this.nYR.size(); i++) {
            this.nYQ.add(this.nYR.get(i));
        }
        this.nYQ.notifyDataSetChanged();
    }
}
