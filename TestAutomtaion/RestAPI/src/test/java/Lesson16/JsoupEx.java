package Lesson16;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.List;

public class JsoupEx {
    Document doc;
    final String EXPECTED_LOGO_WIDTH="250";
    final String EXPECTED_LOGO_HEIGHT="200";
    final String EXPECTED_CATEGORY="All Categories";
    SoftAssert soft;
    @BeforeClass
    public void startSession() throws IOException {
        doc= Jsoup.connect("https://www.ebay.com").get();
        soft=new SoftAssert();
    }
    @Test
    public void test01VerifyLogo(){
        Element logo=doc.getElementById("gh-logo");
        String logoWidth=logo.attr("width");
        String logoHeight=logo.attr("height");
        System.out.println("Logo's Width: "+logoWidth);
        System.out.println("Logo's Height: "+logoHeight);
        soft.assertEquals(logoWidth,EXPECTED_LOGO_WIDTH);
        soft.assertEquals(logoHeight,EXPECTED_LOGO_HEIGHT);
        soft.assertAll();
    }

    @Test
    public void test02VerifyCategories(){
        List<Element> myCategory=doc.getElementsByAttributeValue("id","gh-cat");
        Assert.assertEquals(myCategory.get(0).text(),EXPECTED_CATEGORY);

    }
}
