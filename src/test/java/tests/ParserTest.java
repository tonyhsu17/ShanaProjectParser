package tests;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.tonyhsu17.shanaProjectParser.ShanaProjectParser;
import org.tonyhsu17.shanaProjectParser.poms.Season;
import org.tonyhsu17.shanaProjectParser.poms.SeriesInfo;


/**
 * Unit Tests for {@link ShanaProjectParser}
 * 
 * @author Tony Hsu
 *
 */
public class ParserTest {

    @Test
    public void testParser() throws IOException {

        String url = "http://www.shanaproject.com/user/ikersaro/";
        List<Season> seasons = ShanaProjectParser.parse(url);
        
        SoftAssert softAssert = new SoftAssert();
        for(Season season : seasons) {
            switch (season.getSeason()) {
                case "Fall 2013":
                    for(SeriesInfo series : season.getSeries()) {
                        switch (series.getSeries()) {
                            case "Aoki Hagane no Arpeggio -Ars Nova-":
                                softAssert.assertEquals(series.getSubber(), "HorribleSubs", series.getSeries() + " getSubber mismatch");
                                softAssert.assertEquals(series.getQuality(), "1080p Only (HD)",
                                    series.getSeries() + " getQuality mismatch");
                                softAssert.assertEquals(series.getProfile(), "Don't Care", series.getSeries() + " getProfile mismatch");
                                softAssert.assertEquals(series.getSource(), "Any", series.getSeries() + " getSource mismatch");
                                softAssert.assertEquals(series.getAnySubber(), false, series.getSeries() + " getAnySubber mismatch");
                                softAssert.assertEquals(series.getAnyQuality(), false, series.getSeries() + " getAnyQuality mismatch");
                                break;
                            default:
                                break;
                        }
                    }
                    break;
                case "Unknown":
                    for(SeriesInfo series : season.getSeries()) {
                        switch (series.getSeries()) {
                            case "A Certain Scientific Railgun - Toaru Kagaku no Railgun":
                                softAssert.assertEquals(series.getSubber(), "Nep Blanc", series.getSeries() + " getSubber mismatch");
                                softAssert.assertEquals(series.getQuality(), "1080p Only (HD)",
                                    series.getSeries() + " getQuality mismatch");
                                softAssert.assertEquals(series.getProfile(), "Hi10P Only", series.getSeries() + " getProfile mismatch");
                                softAssert.assertEquals(series.getSource(), "Any", series.getSeries() + " getSource mismatch");
                                softAssert.assertEquals(series.getAnySubber(), true, series.getSeries() + " getAnySubber mismatch");
                                softAssert.assertEquals(series.getAnyQuality(), true, series.getSeries() + " getAnyQuality mismatch");
                                break;
                            case "A Certain Scientific Railgun S":
                                softAssert.assertEquals(series.getSubber(), "Kōritsu i509", series.getSeries() + " getSubber mismatch");
                                softAssert.assertEquals(series.getQuality(), "1080p Only (HD)",
                                    series.getSeries() + " getQuality mismatch");
                                softAssert.assertEquals(series.getProfile(), "Hi10P Only", series.getSeries() + " getProfile mismatch");
                                softAssert.assertEquals(series.getSource(), "Any", series.getSeries() + " getSource mismatch");
                                softAssert.assertEquals(series.getAnySubber(), false, series.getSeries() + " getAnySubber mismatch");
                                softAssert.assertEquals(series.getAnyQuality(), false, series.getSeries() + " getAnyQuality mismatch");
                                break;
                            default:
                                break;
                        }
                    }
                    break;
                default:
                    break;
            }
            softAssert.assertAll();
        }
    }
}
