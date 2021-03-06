// import javafx library
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;

public class Calculator extends Application{
	double tempResult = 1.0;
	public void start(Stage primaryStage){
		// Creat a new pane
		Pane pane = new Pane();

		// The number of bottons
		final int BTNS = 28;

		// Create buttons of the calculator
		Button btn[] = new Button[BTNS];
		String btnName[] = {"MC","MR","MS","M+","M-",
							"<-","CE","C","±","√",
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
		for (int x = 0; x < BTNS; x++){
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
		calResult.setText("0");
		
		// MenuBar
		MenuBar menu = new MenuBar(); 
		final int MENU_BTN = 3;
		final int LIST0_BTN = 10;
		final int LIST1_BTN = 3;
		final int LIST2_BTN = 2;

		Menu list[] = new Menu[MENU_BTN];

		list[0] = new Menu("檢視(V)");
		// MenuItem in MenuBar list[0]
		MenuItem list0[] = new MenuItem[LIST0_BTN];
		String nameList0[] = {"標準型(T)","工程型(S)","程式設計師型(P)","統計資料(A)",
							  "歷程紀錄(Y)","數字分位(I)","基本(B)","單位轉換(U)",
							  "日期計算(D)","工作表(W)"};

		// New a item with the specific value (nameList0) and add to the list
		for (int x = 0; x < LIST0_BTN; x++) {
		  list0[x] = new MenuItem(nameList0[x]);
		  list[0].getItems().add(list0[x]);
		}


		list[1] = new Menu("編輯(V)");

		// MenuItem in MenuBar list[1]
		MenuItem list1[] = new MenuItem[LIST1_BTN];
		String nameList1[] = {"複製(C)","貼上(P)","歷程紀錄(H)"};

		// New a item with the specific value (nameList1) and add to the list
		for (int x = 0; x < LIST1_BTN; x++) {
		  list1[x] = new MenuItem(nameList1[x]);
		  list[1].getItems().add(list1[x]);
		}
		

		list[2] = new Menu("說明(H)");

		// MenuItem in MenuBar list[2]
		  MenuItem list2[] = new MenuItem[LIST2_BTN];
		  String nameList2[] = {"檢視說明(V)","關於小算盤(A)"};

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

		/* Num btns 
			Condition 1 :	if there is equal to zero (empty calResult by automatic filling zero)
							just add to the num to the calResult
			Condition 2 :	if there is not equal to zero 
							add the num to the tail of calResult string
			
			same way for 0 ~ 9
		*/
		// num 7
		btn[10].setOnAction((ActionEvent event) -> {
			if((calResult.getText()).equals("0")){
				calResult.setText("7");
			}
			else{
				calResult.setText(calResult.getText()+"7");
			}
		});	
		// num 8
		btn[11].setOnAction((ActionEvent event) -> {
			if((calResult.getText()).equals("0")){
				calResult.setText("8");
			}
			else{
				calResult.setText(calResult.getText()+"8");
			}
		});	
		// num 9
		btn[12].setOnAction((ActionEvent event) -> {
			if((calResult.getText()).equals("0")){
				calResult.setText("9");
			}
			else{
				calResult.setText(calResult.getText()+"9");
			}
		});	
		// num 4
		btn[15].setOnAction((ActionEvent event) -> {
			if((calResult.getText()).equals("0")){
				calResult.setText("4");
			}
			else{
				calResult.setText(calResult.getText()+"4");
			}
		});	
		// num 5
		btn[16].setOnAction((ActionEvent event) -> {
			if((calResult.getText()).equals("0")){
				calResult.setText("5");
			}
			else{
				calResult.setText(calResult.getText()+"5");
			}
		});	
		// num 6
		btn[17].setOnAction((ActionEvent event) -> {
			if((calResult.getText()).equals("0")){
				calResult.setText("6");
			}
			else{
				calResult.setText(calResult.getText()+"6");
			}
		});	
		// num 1
		btn[20].setOnAction((ActionEvent event) -> {
			if((calResult.getText()).equals("0")){
				calResult.setText("1");
			}
			else{
				calResult.setText(calResult.getText()+"1");
			}
		});	
		// num 2
		btn[21].setOnAction((ActionEvent event) -> {
			if((calResult.getText()).equals("0")){
				calResult.setText("2");
			}
			else{
				calResult.setText(calResult.getText()+"2");
			}
		});	
		// num 3
		btn[22].setOnAction((ActionEvent event) -> {
			if((calResult.getText()).equals("0")){
				calResult.setText("3");
			}
			else{
				calResult.setText(calResult.getText()+"3");
			}
		});	
		// num 0
		btn[25].setOnAction((ActionEvent event) -> {
			if((calResult.getText()).length()>1 || !(calResult.getText()).equals("0")){
				calResult.setText(calResult.getText()+"0");
			}
		});
		// .	
		btn[26].setOnAction((ActionEvent event) -> {
			if((calResult.getText()).indexOf('.')==-1){
				calResult.setText(calResult.getText()+".");
			}
		});	
		// C
		btn[7].setOnAction((ActionEvent event) -> {
			calResult.setText("0");
		});		
		// <-
		btn[5].setOnAction((ActionEvent event) -> {
			// delete the numbers from the end when there are not empy and doesn't equl to zero
			if((calResult.getText()).length()!=0 && (calResult.getText()).equals("0")==false){
				calResult.setText(calResult.getText().substring(0,(calResult.getText()).length()-1));
			}
			// if the calResult is empty, fill the zero to the textarea
			if((calResult.getText()).length()==0){
				calResult.setText("0");
			}
		});	
		// ±
		btn[8].setOnAction((ActionEvent event) -> {
			if((calResult.getText()).equals("0")==false){
				if(!(calResult.getText()).startsWith("-")){
					calResult.setText("-" + calResult.getText());
				}
				else{
					calResult.setText((calResult.getText()).substring(1,(calResult.getText()).length()));
				}
			}
		});	
		// +
		btn[27].setOnAction((ActionEvent event) -> {
			if( !(calResult.getText()) .endsWith("+") &&
				!(calResult.getText()) .endsWith("-") &&
				!(calResult.getText()) .endsWith("*") &&
				!(calResult.getText()) .endsWith("/")	){
				calResult.setText(calResult.getText()+"+");
			}
		});	
		// -
		btn[23].setOnAction((ActionEvent event) -> {
			if( (calResult.getText()) .charAt( (calResult.getText()).length()-1 )!='+' &&
				(calResult.getText()) .charAt( (calResult.getText()).length()-1 )!='-' &&
				(calResult.getText()) .charAt( (calResult.getText()).length()-1 )!='*' &&
				(calResult.getText()) .charAt( (calResult.getText()).length()-1 )!='/'	){
				calResult.setText(calResult.getText()+"-");
			}
		});		
		// *
		btn[18].setOnAction((ActionEvent event) -> {
			if( (calResult.getText()) .charAt( (calResult.getText()).length()-1 )!='+' &&
				(calResult.getText()) .charAt( (calResult.getText()).length()-1 )!='-' &&
				(calResult.getText()) .charAt( (calResult.getText()).length()-1 )!='*' &&
				(calResult.getText()) .charAt( (calResult.getText()).length()-1 )!='/'	){
				calResult.setText(calResult.getText()+"*");
			}
		});		
		// /
		btn[13].setOnAction((ActionEvent event) -> {
			if( (calResult.getText()) .charAt( (calResult.getText()).length()-1 )!='+' &&
				(calResult.getText()) .charAt( (calResult.getText()).length()-1 )!='-' &&
				(calResult.getText()) .charAt( (calResult.getText()).length()-1 )!='*' &&
				(calResult.getText()) .charAt( (calResult.getText()).length()-1 )!='/'	){
				calResult.setText(calResult.getText()+"/");
			}
		});	
		// =
		btn[24].setOnAction((ActionEvent event) -> {
			Calculator obj1 = new Calculator();
			String tempString = "";
			double result=0;
			if( (calResult.getText()) .charAt( (calResult.getText()).length()-1 )!='+' &&
				(calResult.getText()) .charAt( (calResult.getText()).length()-1 )!='-' &&
				(calResult.getText()) .charAt( (calResult.getText()).length()-1 )!='*' &&
				(calResult.getText()) .charAt( (calResult.getText()).length()-1 )!='/'	){
				if( (calResult.getText()).indexOf('+')!=-1 || (calResult.getText()).indexOf('-')!=-1 ||
					(calResult.getText()).indexOf('*')!=-1 || (calResult.getText()).indexOf('/')!=-1){
					tempString = calResult.getText();
					String[] tokenForAdd = tempString.split("\\+");	// add part
					for(int i = 0; i < tokenForAdd.length; i++){
						/* if there is a * , do first */
						if( tokenForAdd[i].indexOf("*")!=-1 ){	
							String[] tokenForMul = tokenForAdd[i].split("\\*");	// split by *
							double temp = 0.0;
							for(int j = 0; j < tokenForMul.length; j++){
								if(j==0){
									temp = Double.parseDouble(tokenForMul[j]);
								}
								else{
									temp = temp * Double.parseDouble(tokenForMul[j]);
								}
								tokenForAdd[i] = String.valueOf(temp);
							}
						}
						/* else if there is a / , do now */
						else if( tokenForAdd[i].indexOf("/")!=-1 ){
							String[] tokenForDiv = tokenForAdd[i].split("\\/");
							double temp = 0.0;
							for(int j = 0; j < tokenForDiv.length; j++){
								if(j==0){
									temp = Double.parseDouble(tokenForDiv[j]);
								}
								else{
									temp = temp / Double.parseDouble(tokenForDiv[j]);
								}
								tokenForAdd[i] = String.valueOf(temp);
							}
						}
						/* there is a - */
						else{
							String[] tokenForSub = tokenForAdd[i].split("\\-");
							double temp = 0.0;
							for(int j = 0; j < tokenForSub.length; j++){
								if( j==0 ){
									temp = Double.parseDouble(tokenForSub[j]);
								}
								else{
									temp = temp - Double.parseDouble(tokenForSub[j]);
								}
								tokenForAdd[i] = String.valueOf(temp);
							}						
						}
						// plus to the result
						result += Double.parseDouble(tokenForAdd[i]);
					}
					calResult.setText(String.valueOf(result));
				}
			}
		});		
		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 280 ,325); // Set the stage size
		primaryStage.setTitle("U10116054"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}
}