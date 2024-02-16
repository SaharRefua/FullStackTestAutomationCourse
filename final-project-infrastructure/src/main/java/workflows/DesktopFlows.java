package workflows;

import extensions.UIActions;
import io.qameta.allure.Step;
import utilities.CommonOps;

public class DesktopFlows extends CommonOps {
    @Step("Calculate Addition")
    public static void calculateAddition(){
        UIActions.click(calcMain.btn_clear);
        UIActions.click(calcMain.btn_one);
        UIActions.click(calcMain.btn_plus);
        UIActions.click(calcMain.btn_eight);
        UIActions.click(calcMain.btn_result);
    }
}
