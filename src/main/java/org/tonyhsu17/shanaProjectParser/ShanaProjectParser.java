package org.tonyhsu17.shanaProjectParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.tonyhsu17.shanaProjectParser.poms.Season;
import org.tonyhsu17.shanaProjectParser.poms.SeriesInfo;



/**
 * API for ShanaProject. HTML Parser for user's public feed on http://shanaproject.com.
 * 
 * @author Tony Hsu
 *
 */
public class ShanaProjectParser {
    /**
     * Parses shanaproject feed.
     * 
     * @param url URL of the feed. (ie. http://www.shanaproject.com/user/$USERNAME/, where $USERNAME
     *        is name of user to parse)
     * @return A list of Seasons and its Series
     * @throws IOException
     */
    public static List<Season> parse(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();
        return new ShanaProjectParser().parse(doc);
    }

    /**
     * Parse the document
     * @param doc {@link Document}
     * @return
     */
    private List<Season> parse(Document doc) {
        List<Season> seasons = new ArrayList<Season>();

        Elements tableRows = doc.select(".page_contents");
        for(Element tableRow : tableRows) {
            Elements subRow = tableRow.children();
            Element table = subRow.get(1);
            Elements eachRow = table.select("tr");

            seasons = new ArrayList<Season>();
            Season season = null;
            for(Element row : eachRow) {
                if(row.hasAttr("id")) {
                    SeriesInfo s = SeriesInfo.parse(row);
                    season.addSeries(s);
                }
                else {
                    season = Season.parse(row);
                    if(season != null) {
                        seasons.add(season);
                    }
                }
            }
        }
        return seasons;
    }
}
