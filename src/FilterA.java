import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

import java.util.Scanner;

public  class FilterA extends Filter {

	public FilterA(Pipe _dataINPipe, Pipe _dataOUTPipe,String[] s) {
		super();
		this._dataINPipe = _dataINPipe;
		this._dataOUTPipe = _dataOUTPipe;
		this.mainArg=s;
	}

	Pipe _dataINPipe;
	Pipe _dataOUTPipe;
	String[] mainArg;

	public String getData(){
		return _dataINPipe.dataOUT();
	}

	public void sendData( String tempData){
		_dataOUTPipe.dataIN(tempData);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		execute();
	}

	public static PauseTransition pause;
	@Override
	synchronized void execute() {

		StartUpStartUpTest.main(mainArg);

		StartUpTest startUpTest = StartUpTest.waitForStartUpTest();
		startUpTest.printSomething();

		final double[] op1 = new double[1];
		final double[] op2 = new double[1];
		final String[] op3 = new String[1];

		startUpTest.sommeBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {

				if(!startUpTest.tf1.getText().isEmpty() && !startUpTest.tf2.getText().isEmpty()){
					op1[0] =0;
					op2[0] =0;
					op3[0] = "+";
					op1[0] = Double.parseDouble(startUpTest.tf1.getText());
					op2[0] = Double.parseDouble(startUpTest.tf2.getText());

					_dataOUTPipe.dataIN(Double.toString(op1[0]));
					_dataOUTPipe.dataIN(Double.toString(op2[0]));
					_dataOUTPipe.dataIN(op3[0]);
				}

			}
				});

		startUpTest.produitBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				if(!startUpTest.tf1.getText().isEmpty() && !startUpTest.tf2.getText().isEmpty()){
					op1[0] =0;
					op2[0] =0;
					op3[0] = "*";
					op1[0] = Double.parseDouble(startUpTest.tf1.getText());
					op2[0] = Double.parseDouble(startUpTest.tf2.getText());

					_dataOUTPipe.dataIN(Double.toString(op1[0]));
					_dataOUTPipe.dataIN(Double.toString(op2[0]));
					_dataOUTPipe.dataIN(op3[0]);
				}

			}
				});

		startUpTest.factorielBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {

				if(!startUpTest.tf1.getText().isEmpty() ){
					op1[0] =0;
					op2[0] =0;

					op3[0] = "!";
					op1[0] = Double.parseDouble(startUpTest.tf1.getText());


					_dataOUTPipe.dataIN(Double.toString(op1[0]));
					_dataOUTPipe.dataIN(Double.toString(op2[0]));
					_dataOUTPipe.dataIN(op3[0]);
				}

			}

				});





	}
}


