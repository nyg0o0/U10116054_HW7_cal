// import javafx library
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.layout.*;


public classCalculator extends Application{
  public void start(Stage primaryStage){

    // Creat a new pane
    Pane pane = new Pane();

    // The number of bottons
    final int BTNS = 28;

    // Create buttons of the calculator
    Button btn[] = new Button[BTNS];
    String btnName[] = {"MC","MR","MS","M+","M-",
                        "<-","CE","C","��","��",
                        "7","8","9","/","%",
                        "4"," 5","6","*","1/x",
                        "1"," 2","3","-","=",
                        "0",".","+"};
      
    // Define some datas to set the layout of bottons 
    int currentX = 10;
    int currentY = 110;
    final int X_WIDTH = 48;
    final int Y_HEIGHT = 30;
    final int X_PADDING = 5;
    final int Y_PADDING = 5;

    // Use loop to set the layout
    for (int x = 0; x < BTNS; x++) {

      // New a button with the specific value (btnNmae) and add to the pane
      btn[x] = new Button(btnName[x]);
      pane.getChildren().add(btn[x]);

      // Set layout of buttons
      btn[x].setLayoutX(currentX);
      btn[x].setLayoutY(currentY);

      // Special layout (+,=)
      if(x==24){     // "=" layout
        btn[x].setPrefSize(X_WIDTH, Y_HEIGHT * 2 + Y_PADDING);
      }
      else if(x==25){     // "+" layout
        btn[x].setPrefSize((X_WIDTH * 2 + X_PADDING), Y_HEIGHT);
        currentX = currentX + (X_WIDTH + 5);
      }
      else{     // Normal layout
        btn[x].setPrefSize(X_WIDTH, Y_HEIGHT);
      }

     // compute coordinate of layout
     currentX = currentX + (X_WIDTH + 5);
     if((x+1) % 5 == 0){
       currentX = currentX - (X_WIDTH + 5) * 5;
       currentY = currentY + (Y_HEIGHT + 5);
     }
   }

    // Creat a textarea to perform caculator result
    TextArea calResult = new TextArea();
    pane.getChildren().add(calResult);
    calResult.setPrefSize((X_WIDTH * 5 + X_PADDING * 4),Y_HEIGHT * 2);
    calResult.setLayoutX(10);
    calResult.setLayoutY(40);
    calResult.setEditable(false);
 
    // MenuBar
    MenuBar menu = new MenuBar(); 
    final int MENU_BTN = 3;
    final int LIST0_BTN = 10;
    final int LIST1_BTN = 3;
    final int LIST2_BTN = 2;

    Menu list[] = new Menu[MENU_BTN];

    list[0] = new Menu("�˵�(V)");
    // MenuItem in MenuBar list[0]
    MenuItem list0[] = new MenuItem[LIST0_BTN];
    String nameList0[] = {"�зǫ�(T)","�u�{��(S)","�{���]�p�v��(P)","�έp���(A)",
                          "���{����(Y)","�Ʀr����(I)","��(B)","����ഫ(U)",
                          "����p��(D)","�u�@��(W)"};

    // New a item with the specific value (nameList0) and add to the list
    for (int x = 0; x < LIST0_BTN; x++) {
      list0[x] = new MenuItem(nameList0[x]);
      list[0].getItems().add(list0[x]);
    }


    list[1] = new Menu("�s��(V)");

    // MenuItem in MenuBar list[1]
    MenuItem list1[] = new MenuItem[LIST1_BTN];
    String nameList1[] = {"�ƻs(C)","�K�W(P)","���{����(H)"};

    // New a item with the specific value (nameList1) and add to the list
    for (int x = 0; x < LIST1_BTN; x++) {
      list1[x] = new MenuItem(nameList1[x]);
      list[1].getItems().add(list1[x]);
    }
    

    list[2] = new Menu("����(H)");

    // MenuItem in MenuBar list[2]
      MenuItem list2[] = new MenuItem[LIST2_BTN];
      String nameList2[] = {"�˵�����(V)","����p��L(A)"};

    // New a item with the specific value (nameList2) and add to the list
    for (int x = 0; x < LIST2_BTN; x++) {
      list2[x] = new MenuItem(nameList2[x]);
      list[2].getItems().add(list2[x]);
    }

    // Add the list to the menu
    for (int x = 0; x < MENU_BTN; x++) {
      menu.getMenus().addAll(list[x]);
    }
    pane.getChildren().add(menu);

    // Create a scene and place it in the stage
    Scene scene = new Scene(pane, 280 ,325); // Set the stage size
    primaryStage.setTitle("U10116054"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
  }
}