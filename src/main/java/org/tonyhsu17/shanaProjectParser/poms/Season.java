package org.tonyhsu17.shanaProjectParser.poms;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.tonyhsu17.utilities.Logger;



/**
 * @author Tony Hsu
 *
 */
public class Season implements Logger {
    private String season;
    private List<SeriesInfo> series;

    public static Season parse(Element element) {
        Season s = new Season();
        Elements row = element.select("td");
        if(row.size() == 1) {
            s.season = row.get(0).text();
        }
        else {
            return null;
        }
        return s;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public List<SeriesInfo> getSeries() {
        return series;
    }

    public void setSeries(List<SeriesInfo> series) {
        this.series = series;
    }

    public void addSeries(SeriesInfo seri) {
        if(series == null) {
            series = new ArrayList<SeriesInfo>();
        }
        series.add(seri);
    }

    @Override
    public String toString() {
        return "Season [season=" + season + ", series=" + series + "]";
    }
}
