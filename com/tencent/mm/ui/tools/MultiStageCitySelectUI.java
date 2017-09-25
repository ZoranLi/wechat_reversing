package com.tencent.mm.ui.tools;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsimple.n;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.RegionCodeDecoder.Region;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.tools.p.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class MultiStageCitySelectUI extends MMPreference implements e {
    private static List<Region> wnI;
    private String countryCode = null;
    private a gKp = new a(this) {
        final /* synthetic */ MultiStageCitySelectUI wnL;

        {
            this.wnL = r1;
        }

        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            if (this.wnL.hvP == null) {
                return false;
            }
            if (z) {
                w.i("MicroMsg.MultiStageCitySelectUI", "lat:%f lng:%f accuracy:%f", new Object[]{Float.valueOf(f2), Float.valueOf(f), Double.valueOf(d2)});
                ap.vd().a(new n((double) f2, (double) f), 0);
            } else {
                this.wnL.bZO();
            }
            if (this.wnL.hvP != null) {
                this.wnL.hvP.c(this.wnL.gKp);
                this.wnL.hvP = null;
            }
            return false;
        }
    };
    private String hJF = null;
    private ae handler = new ae(Looper.getMainLooper());
    private String hnO = null;
    private String hnP = null;
    private c hvP;
    private f isJ;
    private int ivi = 0;
    private p kww = new p(true, true);
    private int wnA = -1;
    private Region[] wnB;
    private boolean wnC = false;
    private boolean wnD = true;
    private boolean wnE = true;
    private boolean wnF = false;
    private boolean wnG = false;
    private ZoneRecommandPreference wnH;
    private String wnJ;
    private Runnable wnK = new Runnable(this) {
        final /* synthetic */ MultiStageCitySelectUI wnL;

        {
            this.wnL = r1;
        }

        public final void run() {
            MultiStageCitySelectUI.k(this.wnL);
        }
    };
    private String wnx = null;
    private String wny = null;
    private boolean wnz = false;

    static /* synthetic */ void g(MultiStageCitySelectUI multiStageCitySelectUI) {
        if (multiStageCitySelectUI.wnz) {
            multiStageCitySelectUI.ivi = 3;
        } else if (multiStageCitySelectUI.countryCode == null) {
            multiStageCitySelectUI.ivi = 0;
        } else if (multiStageCitySelectUI.hnP == null) {
            multiStageCitySelectUI.ivi = 1;
        } else {
            multiStageCitySelectUI.ivi = 2;
        }
    }

    static /* synthetic */ void k(MultiStageCitySelectUI multiStageCitySelectUI) {
        if (!bg.mA(multiStageCitySelectUI.wnJ)) {
            Preference preferenceTitleCategory;
            ArrayList arrayList = new ArrayList();
            List<Region> arrayList2 = new ArrayList();
            List<Region> arrayList3 = new ArrayList();
            List<Region> arrayList4 = new ArrayList();
            for (Region region : wnI) {
                if (region.getName() != null && region.getName().contains(multiStageCitySelectUI.wnJ)) {
                    if ("CN".equalsIgnoreCase(region.getCountryCode()) || "HK".equalsIgnoreCase(region.getCountryCode()) || "MO".equalsIgnoreCase(region.getCountryCode()) || "TW".equalsIgnoreCase(region.getCountryCode()) || ((region.getParent() == null || !region.hasChildren()) && (region.getParent() == null || region.hasChildren()))) {
                        if (region.getParent() == null || !("CN".equalsIgnoreCase(region.getCountryCode()) || "HK".equalsIgnoreCase(region.getCountryCode()) || "MO".equalsIgnoreCase(region.getCountryCode()) || "TW".equalsIgnoreCase(region.getCountryCode()))) {
                            if (!(region.getParent() == null && ("HK".equalsIgnoreCase(region.getCountryCode()) || "MO".equalsIgnoreCase(region.getCountryCode()) || "TW".equalsIgnoreCase(region.getCountryCode())))) {
                                arrayList2.add(region);
                            }
                        } else if (region.hasChildren() && region.getParent() != null) {
                            arrayList3.add(region);
                        } else if (!(region.hasChildren() || region.getParent() == null)) {
                            arrayList4.add(region);
                        }
                    }
                }
            }
            if (arrayList4.size() > 0) {
                preferenceTitleCategory = new PreferenceTitleCategory(multiStageCitySelectUI);
                preferenceTitleCategory.setTitle(R.l.eRR);
                multiStageCitySelectUI.isJ.a(preferenceTitleCategory);
                for (Region region2 : arrayList4) {
                    Preference zonePreference = new ZonePreference(multiStageCitySelectUI);
                    region2.setHasChildren(false);
                    zonePreference.a(region2);
                    multiStageCitySelectUI.isJ.b(zonePreference);
                }
            }
            if (arrayList3.size() > 0) {
                preferenceTitleCategory = new PreferenceTitleCategory(multiStageCitySelectUI);
                preferenceTitleCategory.setTitle(R.l.eRT);
                multiStageCitySelectUI.isJ.a(preferenceTitleCategory);
                for (Region region22 : arrayList3) {
                    Preference zonePreference2 = new ZonePreference(multiStageCitySelectUI);
                    zonePreference2.a(region22);
                    multiStageCitySelectUI.isJ.b(zonePreference2);
                }
            }
            if (arrayList2.size() > 0) {
                preferenceTitleCategory = new PreferenceTitleCategory(multiStageCitySelectUI);
                preferenceTitleCategory.setTitle(R.l.eRS);
                multiStageCitySelectUI.isJ.a(preferenceTitleCategory);
                for (Region region222 : arrayList2) {
                    Preference zonePreference3 = new ZonePreference(multiStageCitySelectUI);
                    zonePreference3.a(region222);
                    multiStageCitySelectUI.isJ.b(zonePreference3);
                }
            }
            multiStageCitySelectUI.isJ.notifyDataSetChanged();
            multiStageCitySelectUI.wnA = multiStageCitySelectUI.ivi;
            multiStageCitySelectUI.ivi = 4;
        }
    }

    public final void bZL() {
        Region[] RT;
        int i;
        if (this.ivi == 3) {
            RT = RegionCodeDecoder.bMP().RT("CN");
        } else if (bg.mA(this.countryCode)) {
            RT = RegionCodeDecoder.bMP().bMR();
            if (this.wnF) {
                List arrayList = new ArrayList();
                for (Region region : RT) {
                    if (!("CN".equalsIgnoreCase(region.getCode()) || "HK".equalsIgnoreCase(region.getCode()) || "TW".equalsIgnoreCase(region.getCode()) || "MO".equalsIgnoreCase(region.getCode()))) {
                        arrayList.add(region);
                    }
                }
                RT = new Region[arrayList.size()];
                arrayList.toArray(RT);
            }
        } else {
            RT = bg.mA(this.hnP) ? RegionCodeDecoder.bMP().RT(this.countryCode) : RegionCodeDecoder.bMP().eM(this.countryCode, this.hnP);
        }
        this.wnB = RT;
        if (this.wnB == null || this.wnB.length <= 0) {
            w.e("MicroMsg.MultiStageCitySelectUI", "initZoneItems error ,check zone lists!");
            return;
        }
        this.isJ.removeAll();
        ap.yY();
        String str = (String) com.tencent.mm.u.c.vr().get(12324, null);
        ap.yY();
        String str2 = (String) com.tencent.mm.u.c.vr().get(12325, null);
        ap.yY();
        String str3 = (String) com.tencent.mm.u.c.vr().get(12326, null);
        this.wnE = getIntent().getBooleanExtra("ShowSelectedLocation", true);
        i = 0;
        while (i < this.wnB.length) {
            if (!(this.wnB[i] == null || bg.mA(this.wnB[i].getCode()) || bg.mA(this.wnB[i].getName()))) {
                Preference zonePreference = new ZonePreference(this);
                zonePreference.a(this.wnB[i]);
                if (!this.wnE) {
                    this.isJ.a(zonePreference);
                } else if (this.ivi == 0 && this.wnB[i].getCode().equalsIgnoreCase(str)) {
                    this.isJ.a(zonePreference, 0);
                    zonePreference.setSummary(R.l.eRU);
                } else if (this.ivi == 1 && this.wnB[i].getCode().equalsIgnoreCase(str2)) {
                    this.isJ.a(zonePreference, 0);
                    zonePreference.setSummary(R.l.eRU);
                } else if (this.ivi == 2 && this.wnB[i].getCode().equalsIgnoreCase(str3)) {
                    this.isJ.a(zonePreference, 0);
                    zonePreference.setSummary(R.l.eRU);
                } else {
                    this.isJ.a(zonePreference);
                }
            }
            i++;
        }
        if (this.ivi == 3) {
            Preference zoneSelectOtherCountryPreference = new ZoneSelectOtherCountryPreference(this);
            zoneSelectOtherCountryPreference.text = getString(R.l.eRQ);
            zoneSelectOtherCountryPreference.wpj = new ZoneSelectOtherCountryPreference.a(this) {
                final /* synthetic */ MultiStageCitySelectUI wnL;

                {
                    this.wnL = r1;
                }

                public final void onClick() {
                    Intent intent = new Intent(this.wnL, MultiStageCitySelectUI.class);
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("GetAddress", this.wnL.wnC);
                    bundle.putBoolean("ShowSelectedLocation", this.wnL.wnE);
                    bundle.putBoolean("IsSelectNonChinaCountry", true);
                    bundle.putBoolean("IsAutoPosition", false);
                    bundle.putBoolean("IsNeedShowSearchBar", true);
                    intent.putExtras(bundle);
                    this.wnL.startActivityForResult(intent, 1);
                }
            };
            this.isJ.a(zoneSelectOtherCountryPreference);
        }
        this.isJ.a(new PreferenceCategory(this.uSU.uTo));
        if (this.ivi == 0 || this.ivi == 3) {
            if (this.wnD) {
                zoneSelectOtherCountryPreference = new PreferenceTitleCategory(this);
                zoneSelectOtherCountryPreference.setTitle(R.l.eRO);
                this.isJ.a(zoneSelectOtherCountryPreference, 0);
                this.wnH = new ZoneRecommandPreference(this);
                this.wnH.setKey("current_location");
                this.isJ.a(this.wnH, 1);
            }
            zoneSelectOtherCountryPreference = new PreferenceTitleCategory(this);
            zoneSelectOtherCountryPreference.setTitle(R.l.eRN);
            if (this.wnD) {
                this.isJ.a(zoneSelectOtherCountryPreference, 2);
                if (this.hvP == null) {
                    this.hvP = c.Gk();
                }
                this.hvP.b(this.gKp);
                return;
            }
            this.isJ.a(zoneSelectOtherCountryPreference, 0);
        }
    }

    private void bZM() {
        switch (this.ivi) {
            case 0:
                this.countryCode = null;
                return;
            case 1:
                this.hnP = null;
                return;
            case 2:
                this.hnO = null;
                return;
            default:
                return;
        }
    }

    private static List<Region> bZN() {
        String str;
        InputStream openRead;
        Throwable e;
        InputStream inputStream;
        Reader reader = null;
        RegionCodeDecoder bMP = RegionCodeDecoder.bMP();
        bMP.uKH = v.bIN();
        String bMQ = bMP.bMQ();
        if (bg.mA(bMQ)) {
            w.e("MicroMsg.RegionCodeDecoder", "buildMap error, no codeFile found, curLang: " + bMP.uKH);
            str = null;
        } else {
            str = RegionCodeDecoder.uKG + bMQ;
        }
        if (bg.mA(str)) {
            return null;
        }
        List<Region> arrayList = new ArrayList();
        Reader inputStreamReader;
        Reader reader2;
        try {
            openRead = FileOp.openRead(str);
            try {
                inputStreamReader = new InputStreamReader(openRead);
            } catch (Exception e2) {
                e = e2;
                reader2 = null;
                inputStream = openRead;
                try {
                    w.printErrStackTrace("MicroMsg.MultiStageCitySelectUI", e, "buildSearchRegionMap error: %s", new Object[]{e.getMessage()});
                    if (inputStream != null) {
                        com.tencent.mm.a.e.b(inputStream);
                    }
                    if (reader2 != null) {
                        com.tencent.mm.a.e.a(reader2);
                    }
                    if (reader != null) {
                        com.tencent.mm.a.e.a(reader);
                    }
                    return arrayList;
                } catch (Throwable th) {
                    e = th;
                    openRead = inputStream;
                    inputStreamReader = reader2;
                    reader2 = reader;
                    if (openRead != null) {
                        com.tencent.mm.a.e.b(openRead);
                    }
                    if (inputStreamReader != null) {
                        com.tencent.mm.a.e.a(inputStreamReader);
                    }
                    if (reader2 != null) {
                        com.tencent.mm.a.e.a(reader2);
                    }
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                reader2 = null;
                inputStreamReader = null;
                if (openRead != null) {
                    com.tencent.mm.a.e.b(openRead);
                }
                if (inputStreamReader != null) {
                    com.tencent.mm.a.e.a(inputStreamReader);
                }
                if (reader2 != null) {
                    com.tencent.mm.a.e.a(reader2);
                }
                throw e;
            }
            try {
                reader2 = new BufferedReader(inputStreamReader);
                Region region = null;
                while (true) {
                    try {
                        String readLine = reader2.readLine();
                        if (readLine == null) {
                            break;
                        }
                        String[] split = readLine.split("\\|");
                        Region region2 = new Region();
                        if (split.length == 2) {
                            region2.setName(split[1]);
                            split = split[0].split("_");
                            String str2 = split[0];
                            region2.setCountryCode(str2);
                            if (bg.mA(str2)) {
                                continue;
                            } else {
                                if (split.length == 1) {
                                    region2.setCode(str2);
                                    region2.setProvince(false);
                                    region2.setCity(false);
                                    region2.setCountry(true);
                                    region = region2;
                                } else if (split.length == 2) {
                                    region2.setCode(split[1]);
                                    region2.setProvince(true);
                                    region2.setCountry(false);
                                    region2.setCity(false);
                                    if (region != null && region.getCountryCode().equals(region2.getCountryCode())) {
                                        region.setHasChildren(true);
                                        region2.setParent(region);
                                    }
                                    r1 = region2;
                                } else if (split.length == 3) {
                                    region2.setCode(split[2]);
                                    region2.setCity(true);
                                    region2.setCountry(false);
                                    region2.setProvince(false);
                                    region2.setHasChildren(false);
                                    if (r1 != null && r1.getCode().equals(split[1])) {
                                        region2.setParent(r1);
                                        r1.setHasChildren(true);
                                    }
                                }
                                arrayList.add(region2);
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                        reader = reader2;
                        reader2 = inputStreamReader;
                        inputStream = openRead;
                    } catch (Throwable th3) {
                        e = th3;
                    }
                }
                if (openRead != null) {
                    com.tencent.mm.a.e.b(openRead);
                }
                com.tencent.mm.a.e.a(inputStreamReader);
                com.tencent.mm.a.e.a(reader2);
            } catch (Exception e4) {
                e = e4;
                reader2 = inputStreamReader;
                inputStream = openRead;
                w.printErrStackTrace("MicroMsg.MultiStageCitySelectUI", e, "buildSearchRegionMap error: %s", new Object[]{e.getMessage()});
                if (inputStream != null) {
                    com.tencent.mm.a.e.b(inputStream);
                }
                if (reader2 != null) {
                    com.tencent.mm.a.e.a(reader2);
                }
                if (reader != null) {
                    com.tencent.mm.a.e.a(reader);
                }
                return arrayList;
            } catch (Throwable th4) {
                e = th4;
                reader2 = null;
                if (openRead != null) {
                    com.tencent.mm.a.e.b(openRead);
                }
                if (inputStreamReader != null) {
                    com.tencent.mm.a.e.a(inputStreamReader);
                }
                if (reader2 != null) {
                    com.tencent.mm.a.e.a(reader2);
                }
                throw e;
            }
        } catch (Exception e5) {
            e = e5;
            reader2 = null;
            inputStream = null;
            w.printErrStackTrace("MicroMsg.MultiStageCitySelectUI", e, "buildSearchRegionMap error: %s", new Object[]{e.getMessage()});
            if (inputStream != null) {
                com.tencent.mm.a.e.b(inputStream);
            }
            if (reader2 != null) {
                com.tencent.mm.a.e.a(reader2);
            }
            if (reader != null) {
                com.tencent.mm.a.e.a(reader);
            }
            return arrayList;
        } catch (Throwable th5) {
            e = th5;
            reader2 = null;
            inputStreamReader = null;
            openRead = null;
            if (openRead != null) {
                com.tencent.mm.a.e.b(openRead);
            }
            if (inputStreamReader != null) {
                com.tencent.mm.a.e.a(inputStreamReader);
            }
            if (reader2 != null) {
                com.tencent.mm.a.e.a(reader2);
            }
            throw e;
        }
        return arrayList;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ap.vd().a(665, this);
        this.isJ = this.vrv;
        KC();
        if (this.wnG) {
            if (wnI == null || wnI.size() <= 0) {
                long NA = bg.NA();
                Region[] bMR = RegionCodeDecoder.bMP().bMR();
                if (bMR != null && bMR.length > 0 && (wnI == null || wnI.size() <= 0)) {
                    List bZN = bZN();
                    wnI = bZN;
                    if (bZN != null) {
                        w.i("MicroMsg.MultiStageCitySelectUI", "buildAllSearchRegion used %sms, size: %s", new Object[]{Long.valueOf(bg.aB(NA)), Integer.valueOf(wnI.size())});
                    }
                }
            }
            a(this.kww);
            this.kww.woe = new b(this) {
                final /* synthetic */ MultiStageCitySelectUI wnL;

                {
                    this.wnL = r1;
                }

                public final void OE() {
                }

                public final void OD() {
                    this.wnL.aHf();
                    MultiStageCitySelectUI.g(this.wnL);
                    this.wnL.bZL();
                }

                public final void mR(String str) {
                    if (!bg.mA(str)) {
                        this.wnL.wnJ = str;
                        this.wnL.isJ.removeAll();
                        this.wnL.handler.removeCallbacks(this.wnL.wnK);
                        this.wnL.handler.postDelayed(this.wnL.wnK, 50);
                    }
                }

                public final boolean mQ(String str) {
                    if (bg.mA(str)) {
                        return false;
                    }
                    this.wnL.wnJ = str;
                    this.wnL.isJ.removeAll();
                    this.wnL.handler.removeCallbacks(this.wnL.wnK);
                    this.wnL.handler.postDelayed(this.wnL.wnK, 50);
                    return true;
                }

                public final void OF() {
                    MultiStageCitySelectUI.g(this.wnL);
                    this.wnL.bZL();
                }

                public final void OG() {
                }
            };
        }
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onDestroy() {
        ap.vd().b(665, this);
        if (this.hvP != null) {
            this.hvP.c(this.gKp);
        }
        super.onDestroy();
    }

    public final int ON() {
        return R.i.dse;
    }

    protected final void KC() {
        zi(R.l.eCI);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ MultiStageCitySelectUI wnL;

            {
                this.wnL = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.wnL.bZM();
                this.wnL.finish();
                return true;
            }
        });
        this.wnC = getIntent().getBooleanExtra("GetAddress", false);
        this.countryCode = getIntent().getStringExtra("Country");
        this.hnP = getIntent().getStringExtra("Provice");
        this.hJF = getIntent().getStringExtra("CountryName");
        this.wnx = getIntent().getStringExtra("ProviceName");
        this.wnD = getIntent().getBooleanExtra("IsAutoPosition", !bg.Hp());
        this.wnz = getIntent().getBooleanExtra("IsRealNameVerifyScene", false);
        this.wnF = getIntent().getBooleanExtra("IsSelectNonChinaCountry", false);
        this.wnG = getIntent().getBooleanExtra("IsNeedShowSearchBar", false);
        w.i("MicroMsg.MultiStageCitySelectUI", " country = " + this.countryCode + " province =" + this.hnP + " city = " + this.hnO + " " + this.hJF + " " + this.wnx + " " + this.wnz + " " + this.wnF);
        if (this.wnz) {
            this.ivi = 3;
        } else if (this.countryCode == null) {
            this.ivi = 0;
            this.hnP = null;
            this.hnO = null;
        } else if (this.hnP == null) {
            this.ivi = 1;
            this.hnO = null;
        } else {
            this.ivi = 2;
        }
        bZL();
    }

    public final boolean a(f fVar, Preference preference) {
        String str = null;
        String str2;
        if (preference instanceof ZonePreference) {
            Region region = ((ZonePreference) preference).wpb;
            if (region == null || bg.mA(region.getCode())) {
                Object valueOf;
                str = "MicroMsg.MultiStageCitySelectUI";
                StringBuilder stringBuilder = new StringBuilder("onPreferenceTreeClick error item, code:");
                if (region == null) {
                    valueOf = Integer.valueOf(-1);
                } else {
                    valueOf = region.getCode();
                }
                stringBuilder = stringBuilder.append(valueOf).append(" ,name:");
                if (region == null) {
                    str2 = "null";
                } else {
                    str2 = region.getName();
                }
                w.e(str, stringBuilder.append(str2).toString());
                return false;
            }
            if (this.ivi == 3) {
                this.countryCode = "CN";
                this.hnP = region.getCode();
                this.wnx = region.getName();
            }
            if (this.ivi == 0) {
                this.countryCode = region.getCode();
                this.hJF = region.getName();
            } else if (this.ivi == 1) {
                this.hnP = region.getCode();
                this.wnx = region.getName();
            } else if (this.ivi == 2) {
                this.hnO = region.getCode();
                this.wny = region.getName();
                if ("CN".equalsIgnoreCase(this.countryCode) || "HK".equalsIgnoreCase(this.countryCode) || "MO".equalsIgnoreCase(this.countryCode) || "TW".equalsIgnoreCase(this.countryCode)) {
                    this.hJF = null;
                } else {
                    this.wnx = null;
                }
            } else if (this.ivi == 4) {
                if (region.getParent() != null && !region.hasChildren()) {
                    this.hnO = region.getCode();
                    this.wny = region.getName();
                    this.hnP = region.getParent().getCode();
                    this.wnx = region.getParent().getName();
                    this.countryCode = region.getCountryCode();
                    this.hJF = null;
                } else if (!region.hasChildren() || region.getParent() == null) {
                    this.countryCode = region.getCode();
                    this.hJF = region.getName();
                    this.hnP = null;
                    this.wnx = null;
                    this.hnO = null;
                    this.wny = null;
                } else {
                    this.hnP = region.getCode();
                    this.wnx = region.getName();
                    this.countryCode = region.getCountryCode();
                    this.hJF = null;
                }
            }
            if (region.hasChildren()) {
                Intent intent = new Intent(this, MultiStageCitySelectUI.class);
                Bundle bundle = new Bundle();
                bundle.putString("Country", this.countryCode);
                bundle.putString("Provice", this.hnP);
                bundle.putString("CountryName", this.hJF);
                bundle.putString("ProviceName", this.wnx);
                bundle.putBoolean("GetAddress", this.wnC);
                bundle.putBoolean("ShowSelectedLocation", this.wnE);
                if (this.wnz) {
                    str2 = region.getCountryCode();
                    if (bg.mA(str2)) {
                        str2 = this.countryCode;
                    }
                    if ("CN".equalsIgnoreCase(str2) || "HK".equalsIgnoreCase(str2) || "MO".equalsIgnoreCase(str2) || "TW".equalsIgnoreCase(str2)) {
                        bundle.putBoolean("IsNeedShowSearchBar", true);
                    }
                }
                intent.putExtras(bundle);
                aHf();
                startActivityForResult(intent, 1);
            } else {
                if (!this.wnC) {
                    ap.yY();
                    com.tencent.mm.u.c.vr().set(12324, this.countryCode);
                    ap.yY();
                    com.tencent.mm.u.c.vr().set(12325, this.hnP);
                    ap.yY();
                    com.tencent.mm.u.c.vr().set(12326, this.hnO);
                }
                Intent intent2 = new Intent();
                intent2.putExtra("CountryName", this.hJF);
                intent2.putExtra("ProviceName", this.wnx);
                intent2.putExtra("CityName", this.wny);
                intent2.putExtra("Country", this.countryCode);
                intent2.putExtra("Contact_Province", this.hnP);
                intent2.putExtra("Contact_City", this.hnO);
                aHf();
                setResult(-1, intent2);
                finish();
            }
            return true;
        }
        if (preference.igL.equals("current_location")) {
            if (this.wnH.status == 1) {
                ZoneRecommandPreference zoneRecommandPreference = this.wnH;
                Region[] regionArr = new Region[]{zoneRecommandPreference.wpe, zoneRecommandPreference.wpf, zoneRecommandPreference.wpg};
                ap.yY();
                com.tencent.mm.u.c.vr().set(12324, regionArr[0] == null ? null : regionArr[0].getCode());
                ap.yY();
                com.tencent.mm.u.c.vr().set(12325, regionArr[1] == null ? null : regionArr[1].getCode());
                ap.yY();
                com.tencent.mm.u.c.vr().set(12326, regionArr[2] == null ? null : regionArr[2].getCode());
                str2 = regionArr[0] == null ? null : regionArr[0].getCode();
                String name = regionArr[0] == null ? null : regionArr[0].getName();
                String code = regionArr[1] == null ? null : regionArr[1].getCode();
                String name2 = regionArr[1] == null ? null : regionArr[1].getName();
                if ("CN".equalsIgnoreCase(str2) || "HK".equalsIgnoreCase(str2) || "MO".equalsIgnoreCase(str2) || "TW".equalsIgnoreCase(str2)) {
                    name = null;
                } else {
                    name2 = null;
                }
                Intent intent3 = new Intent();
                intent3.putExtra("CountryName", name);
                intent3.putExtra("ProviceName", name2);
                intent3.putExtra("CityName", regionArr[2] == null ? null : regionArr[2].getName());
                intent3.putExtra("Country", str2);
                intent3.putExtra("Contact_Province", code);
                str2 = "Contact_City";
                if (regionArr[2] != null) {
                    str = regionArr[2].getCode();
                }
                intent3.putExtra(str2, str);
                aHf();
                setResult(-1, intent3);
                finish();
            }
        }
        return false;
    }

    public void onBackPressed() {
        bZM();
        super.onBackPressed();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 1:
                if (i2 == -1) {
                    setResult(-1, intent);
                    finish();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        Region region = null;
        int i3 = 0;
        if (i != 0 || i2 != 0) {
            bZO();
        } else if (kVar.getType() == 665) {
            Region region2;
            Region region3;
            ZoneRecommandPreference zoneRecommandPreference;
            n nVar = (n) kVar;
            w.i("MicroMsg.MultiStageCitySelectUI", "current location country %s, province %s, city %s", new Object[]{nVar.country, nVar.gkB, nVar.gkC});
            for (Region region4 : RegionCodeDecoder.bMP().bMR()) {
                if (region4.getCode().equalsIgnoreCase(r2)) {
                    for (Region region22 : RegionCodeDecoder.bMP().RT(region4.getCode())) {
                        if (region22.getCode().equalsIgnoreCase(r5)) {
                            Region[] eM = RegionCodeDecoder.bMP().eM(region4.getCode(), region22.getCode());
                            int length = eM.length;
                            while (i3 < length) {
                                region3 = eM[i3];
                                if (region3.getCode().equalsIgnoreCase(r6)) {
                                    region = region22;
                                    region22 = region4;
                                    break;
                                }
                                i3++;
                            }
                            region3 = null;
                            region = region22;
                            region22 = region4;
                            if (region22 != null && region == null && region3 == null) {
                                if (this.wnH != null) {
                                    this.wnH.bZY();
                                    return;
                                }
                                return;
                            } else if (this.wnH == null) {
                                zoneRecommandPreference = this.wnH;
                                zoneRecommandPreference.status = 1;
                                zoneRecommandPreference.wpe = region22;
                                zoneRecommandPreference.wpf = region;
                                zoneRecommandPreference.wpg = region3;
                                zoneRecommandPreference.bZX();
                            }
                        }
                    }
                    region3 = null;
                    region22 = region4;
                    if (region22 != null) {
                    }
                    if (this.wnH == null) {
                        zoneRecommandPreference = this.wnH;
                        zoneRecommandPreference.status = 1;
                        zoneRecommandPreference.wpe = region22;
                        zoneRecommandPreference.wpf = region;
                        zoneRecommandPreference.wpg = region3;
                        zoneRecommandPreference.bZX();
                    }
                }
            }
            region3 = null;
            region22 = null;
            if (region22 != null) {
            }
            if (this.wnH == null) {
                zoneRecommandPreference = this.wnH;
                zoneRecommandPreference.status = 1;
                zoneRecommandPreference.wpe = region22;
                zoneRecommandPreference.wpf = region;
                zoneRecommandPreference.wpg = region3;
                zoneRecommandPreference.bZX();
            }
        }
    }

    private void bZO() {
        if (this.wnH != null) {
            this.wnH.bZY();
        }
    }
}
