package com.tencent.mm.modelsimple;

import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.io.StringReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

final class a {
    a() {
    }

    public static BindWordingContent kv(String str) {
        BindWordingContent bindWordingContent = new BindWordingContent("", "");
        XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
        newInstance.setNamespaceAware(true);
        XmlPullParser newPullParser = newInstance.newPullParser();
        newPullParser.setInput(new StringReader(str));
        String str2 = "";
        for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
            switch (eventType) {
                case 2:
                    str2 = newPullParser.getName();
                    break;
                case 4:
                    String text = newPullParser.getText();
                    if (text != null && text.trim().length() > 0) {
                        text = text.trim();
                        if (!str2.equalsIgnoreCase("title")) {
                            if (!str2.equalsIgnoreCase("text")) {
                                if (!str2.equalsIgnoreCase(Columns.TYPE)) {
                                    break;
                                }
                                try {
                                    bindWordingContent.hRA = Integer.valueOf(text);
                                    break;
                                } catch (Exception e) {
                                    bindWordingContent.hRA = Integer.valueOf(0);
                                    break;
                                }
                            }
                            bindWordingContent.content = text;
                            break;
                        }
                        bindWordingContent.title = text;
                        break;
                    }
                default:
                    break;
            }
        }
        return bindWordingContent;
    }
}
