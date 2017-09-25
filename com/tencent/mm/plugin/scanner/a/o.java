package com.tencent.mm.plugin.scanner.a;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.map.geolocation.internal.TencentExtraKeys;
import com.tencent.mm.plugin.scanner.a.n.a;
import com.tencent.mm.plugin.scanner.a.n.b;
import com.tencent.mm.plugin.scanner.a.n.c;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.io.StringReader;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public final class o {
    private n oWZ = new n();

    public final void DF(String str) {
        XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
        newInstance.setNamespaceAware(true);
        XmlPullParser newPullParser = newInstance.newPullParser();
        newPullParser.setInput(new StringReader(str));
        String str2 = "";
        for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
            switch (eventType) {
                case 1:
                    n.oWZ = this.oWZ;
                    break;
                case 2:
                    str2 = newPullParser.getName();
                    if (!str2.equals("name")) {
                        if (!str2.equals("address")) {
                            if (!str2.equals("deliveryAddress")) {
                                if (!str2.equals("homeAddress")) {
                                    if (!str2.equals("workAddress")) {
                                        if (!str2.equals(SlookAirButtonFrequentContactAdapter.PHOTO)) {
                                            if (!str2.equals("logo")) {
                                                if (!str2.equals("sound")) {
                                                    break;
                                                }
                                                this.oWZ.oWL = b(newPullParser);
                                                break;
                                            }
                                            this.oWZ.oWK = b(newPullParser);
                                            break;
                                        }
                                        this.oWZ.oWJ = b(newPullParser);
                                        break;
                                    }
                                    this.oWZ.oWQ = a(newPullParser);
                                    break;
                                }
                                this.oWZ.oWP = a(newPullParser);
                                break;
                            }
                            this.oWZ.oWO = a(newPullParser);
                            break;
                        }
                        this.oWZ.oWN = a(newPullParser);
                        break;
                    }
                    this.oWZ.oWI = new b(newPullParser.getAttributeValue(null, "firstName"), newPullParser.getAttributeValue(null, "middleName"), newPullParser.getAttributeValue(null, "lastName"));
                    break;
                case 4:
                    String text = newPullParser.getText();
                    if (text != null && text.trim().length() > 0) {
                        text = text.trim();
                        if (!str2.equals("nickName")) {
                            if (!str2.equals("photoUrl")) {
                                if (!str2.equals("birthday")) {
                                    n nVar;
                                    if (!str2.equals("mobilePhoneNumber")) {
                                        if (!str2.equals("homePhoneNumber")) {
                                            if (!str2.equals("workPhoneNumber")) {
                                                if (!str2.equals("telAVPhoneNumber")) {
                                                    if (!str2.equals("phoneNumber")) {
                                                        if (!str2.equals("email")) {
                                                            if (!str2.equals("title")) {
                                                                if (!str2.equals("role")) {
                                                                    if (!str2.equals("agent")) {
                                                                        if (!str2.equals("note")) {
                                                                            if (!str2.equals(SlookSmartClipMetaTag.TAG_TYPE_URL)) {
                                                                                if (!str2.equals("organization")) {
                                                                                    break;
                                                                                }
                                                                                this.oWZ.iBj = text;
                                                                                break;
                                                                            }
                                                                            this.oWZ.url = text;
                                                                            break;
                                                                        }
                                                                        this.oWZ.oWY = text;
                                                                        break;
                                                                    }
                                                                    this.oWZ.oWX = text;
                                                                    break;
                                                                }
                                                                this.oWZ.oWW = text;
                                                                break;
                                                            }
                                                            this.oWZ.title = text;
                                                            break;
                                                        }
                                                        this.oWZ.gku = text;
                                                        break;
                                                    }
                                                    nVar = this.oWZ;
                                                    if (nVar.oWV == null) {
                                                        nVar.oWV = new ArrayList();
                                                    }
                                                    if (!(text == null || nVar.oWV.contains(text))) {
                                                        nVar.oWV.add(text);
                                                        break;
                                                    }
                                                }
                                                nVar = this.oWZ;
                                                if (nVar.oWU == null) {
                                                    nVar.oWU = new ArrayList();
                                                }
                                                if (!(text == null || nVar.oWU.contains(text))) {
                                                    nVar.oWU.add(text);
                                                    break;
                                                }
                                            }
                                            nVar = this.oWZ;
                                            if (nVar.oWT == null) {
                                                nVar.oWT = new ArrayList();
                                            }
                                            if (!(text == null || nVar.oWT.contains(text))) {
                                                nVar.oWT.add(text);
                                                break;
                                            }
                                        }
                                        nVar = this.oWZ;
                                        if (nVar.oWS == null) {
                                            nVar.oWS = new ArrayList();
                                        }
                                        if (!(text == null || nVar.oWS.contains(text))) {
                                            nVar.oWS.add(text);
                                            break;
                                        }
                                    }
                                    nVar = this.oWZ;
                                    if (nVar.oWR == null) {
                                        nVar.oWR = new ArrayList();
                                    }
                                    if (!(text == null || nVar.oWR.contains(text))) {
                                        nVar.oWR.add(text);
                                        break;
                                    }
                                }
                                this.oWZ.oWM = text;
                                break;
                            }
                            this.oWZ.iBa = text;
                            break;
                        }
                        this.oWZ.aIO = text;
                        break;
                    }
                default:
                    break;
            }
        }
        n.oWZ = this.oWZ;
    }

    private static a a(XmlPullParser xmlPullParser) {
        return new a(xmlPullParser.getAttributeValue(null, "postOfficeBox"), xmlPullParser.getAttributeValue(null, "extendedAddress"), xmlPullParser.getAttributeValue(null, "street"), xmlPullParser.getAttributeValue(null, TencentExtraKeys.LOCATION_KEY_LOCALITY), xmlPullParser.getAttributeValue(null, "region"), xmlPullParser.getAttributeValue(null, "postalCode"), xmlPullParser.getAttributeValue(null, "country"));
    }

    private static c b(XmlPullParser xmlPullParser) {
        return new c(xmlPullParser.getAttributeValue(null, Columns.TYPE), xmlPullParser.getAttributeValue(null, "buffer"));
    }
}
