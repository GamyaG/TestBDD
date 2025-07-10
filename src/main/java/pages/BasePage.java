package pages;


import pageelements.*;
import pageobjects.BasePO;

public class BasePage extends BasePO {
    public Buttons buttons;
    public CustomButtonLink customButtonLink;
    public Checkbox checkbox;
    public DatePicker datePicker;
    public DropDown dropDown;
    public InputField inputField;
    public Label label;
    public RadioButton radioButton;
    public TextLink textLink;
    public CCElements ccElements;
    public MenuItem menuItem;
    public Icon icon;
    public BCElements bcElements;
    public  Tab tab;
    public TextArea textArea;
    public CommonFunctions commonFunctions;
    public void pageElementsSetup()
    {
        buttons = new Buttons();
        customButtonLink = new CustomButtonLink();
        checkbox = new Checkbox();
        datePicker = new DatePicker();
        dropDown = new DropDown();
        inputField = new InputField();
        label = new Label();
        radioButton = new RadioButton();
        textLink = new TextLink();
        menuItem = new MenuItem();
        icon = new Icon();
        textArea = new TextArea();
        tab= new Tab();
        commonFunctions=new CommonFunctions();
        ccElements=new CCElements();
        bcElements=new BCElements();
    }


}
