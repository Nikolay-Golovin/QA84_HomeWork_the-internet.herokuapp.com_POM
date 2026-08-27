package the_internet.herokuapp.com.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import the_internet.herokuapp.com.core.TestBase;
import the_internet.herokuapp.com.pages.HomePage;
import the_internet.herokuapp.com.pages.NestedFrames;

public class NestedFramesTest extends TestBase {

    HomePage homePage;
    NestedFrames nestedFrames;

    @BeforeEach
    public void setUp() {
        homePage = new HomePage(driver);
        nestedFrames = new NestedFrames(driver);
    }
    @Test
    public void nestedFramesTest(){
        homePage.openNestedFramePage();
        nestedFrames
                .verifiButtonFtame("BOTTOM")
                .verifiLeftFtame("LEFT")
                .verifiMiddleFtame("MIDDLE")
                .verifiRightFtame("RIGHT")
        ;



    }
}
