package org.tonyhsu17.shanaProjectParser.poms;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.tonyhsu17.utilities.Logger;



/**
 * @author Tony Hsu
 *
 */
public class SeriesInfo implements Logger {
    private String series;
    private String url;
    private String subber;
    private String quality;
    private String profile;
    private String source;
    private boolean anySubber;
    private boolean anyQuality;

    public static SeriesInfo parse(Element element) {
        SeriesInfo s = new SeriesInfo();
        Elements row = element.select("td");
        if(row.size() == 9) {
            s.series = row.get(0).text();
            s.url = "https://www.shanaproject.com" + row.get(0).select("a").first().attr("href");
            s.subber = row.get(1).text();
            s.quality = row.get(2).text();
            s.profile = row.get(3).text();
            s.source = row.get(4).text();
            s.anySubber = row.get(5).html().contains("icon-yes");
            s.anyQuality = row.get(6).html().contains("icon-yes");
        }
        return s;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSubber() {
        return subber;
    }

    public void setSubber(String subber) {
        this.subber = subber;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public boolean getAnySubber() {
        return anySubber;
    }

    public void setAnySubber(boolean anySubber) {
        this.anySubber = anySubber;
    }

    public boolean getAnyQuality() {
        return anyQuality;
    }

    public void setAnyQuality(boolean anyQuality) {
        this.anyQuality = anyQuality;
    }

    @Override
    public String toString() {
        return "SeriesInfo [series=" +
               series +
               ", url=" +
               url +
               ", subber=" +
               subber +
               ", quality=" +
               quality +
               ", profile=" +
               profile +
               ", source=" +
               source +
               ", anySubber=" +
               anySubber +
               ", anyQuality=" +
               anyQuality +
               "]";
    }
}
